package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;
import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by V.Kornev on 23.05.16.
 */
public class DirectorTablet
{
    private  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);

    public void printAdvertisementProfit(){
        Map<Date,Long> mapAdvertisementProfit = StatisticEventManager.getInstance().getVideoAmountPerDay();
        long totalAmount = 0;
        for (Map.Entry<Date,Long> entry : mapAdvertisementProfit.entrySet()){
            ConsoleHelper.writeMessage(dateFormat.format(entry.getKey())+" - "+String.format("%.2f", entry.getValue() / 100f));
            totalAmount += entry.getValue();
        }
        ConsoleHelper.writeMessage("Total - "+String.format("%.2f", totalAmount/100f));
    }

    public void printCookWorkloading(){
        Map<Date, Map<String, Integer>> mapCookWorkloading = StatisticEventManager.getInstance().getCookWorkloading();
        for (Map.Entry<Date,Map<String, Integer>> entry : mapCookWorkloading.entrySet()){
            ConsoleHelper.writeMessage(dateFormat.format(entry.getKey()));
            SortedMap<String,Integer> sortedCooks = new TreeMap<String,Integer>(entry.getValue());
            for (Map.Entry<String,Integer> cookEntry : sortedCooks.entrySet()){
                if (cookEntry.getValue()>0)
                    ConsoleHelper.writeMessage(cookEntry.getKey()+" - "+cookEntry.getValue()/60 +" min");
            }
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet(){
        for (Advertisement advertisement : StatisticAdvertisementManager.getInstance().getActiveAdvertisements()){
            ConsoleHelper.writeMessage(advertisement.getName()+" - "+advertisement.getHits());
        }
    }

    public void printArchivedVideoSet(){
        for (Advertisement advertisement : StatisticAdvertisementManager.getInstance().getArchiveAdvertisements()){
            ConsoleHelper.writeMessage(advertisement.getName());
        }
    }
}
