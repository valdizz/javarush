package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by V.Kornev on 13.05.16.
 */
public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public void addAmount(int denomination, int count){
        if (denominations.containsKey(denomination)){
            denominations.put(denomination, denominations.get(denomination) + count);
        }
        else {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount(){
        Integer sum=0;
        for (Map.Entry<Integer,Integer> map : denominations.entrySet()){
            sum += map.getValue()*map.getKey();
        }
        return sum;
    }

    public boolean hasMoney(){
        return getTotalAmount() > 0;
    }

    public boolean isAmountAvailable(int expectedAmount){
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        Map<Integer, Integer> resultMap = new TreeMap<Integer,Integer>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2 - o1;
            }
        });

        int itrKol = 0;
        int itrNum;
        int expectedAmountTemp = expectedAmount;
        do{
            expectedAmount = expectedAmountTemp;
            resultMap.clear();
            resultMap.putAll(denominations);
            itrKol++;
            itrNum = 1;
            for (Map.Entry<Integer, Integer> entry : resultMap.entrySet())
            {
                if (itrNum >= itrKol)
                {
                    Integer kolCur = expectedAmount / entry.getKey();
                    if (kolCur > entry.getValue())
                        kolCur = entry.getValue();
                    expectedAmount -= kolCur * entry.getKey();
                    entry.setValue(kolCur);
                }
                else {
                    entry.setValue(0);
                }
                itrNum++;
            }
        }
        while (expectedAmount != 0 && itrKol != resultMap.size());

        if (expectedAmount == 0){
            Iterator<Map.Entry<Integer,Integer>> iterator = resultMap.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<Integer,Integer> entry = iterator.next();
                if (entry.getValue() == 0){
                    iterator.remove();
                }
                else {
                    int newValue = denominations.get(entry.getKey())-entry.getValue();
                    denominations.remove(entry.getKey());
                    denominations.put(entry.getKey(), newValue);
                }
            }
        }
        else {
            resultMap.clear();
            throw new NotEnoughMoneyException();
        }
        return resultMap;
    }
}
