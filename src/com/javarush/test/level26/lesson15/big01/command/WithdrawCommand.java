package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by V.Kornev on 16.05.16.
 */
class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"withdraw_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String curCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator curManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(curCode);
        try
        {
            Integer amount;
            while (true){
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                amount = Integer.parseInt(ConsoleHelper.readString());
                if (amount <= 0)
                {
                    ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                    continue;
                }
                if (!curManipulator.isAmountAvailable(amount)){
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                    continue;
                }
                break;
            }
            Map<Integer, Integer> mapAmount = curManipulator.withdrawAmount(amount);
            StringBuilder resultToConsole = new StringBuilder();
            for (Map.Entry<Integer, Integer> entry : mapAmount.entrySet()){
                resultToConsole.append("\t").append(entry.getKey() + " - " + entry.getValue());
            }
            ConsoleHelper.writeMessage(resultToConsole.toString());
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"),amount,curCode));
        }
        catch (NumberFormatException e)
        {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
        }
        catch (NotEnoughMoneyException e)
        {
            ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
        }
        catch (ConcurrentModificationException ignore) {}
    }
}
