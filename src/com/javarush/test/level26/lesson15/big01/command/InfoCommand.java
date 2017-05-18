package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.ResourceBundle;


/**
 * Created by V.Kornev on 16.05.16.
 */
class InfoCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"info_en");

    @Override
    public void execute()
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        boolean hasMoney = false;
        for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators())
        {
            if (manipulator.hasMoney())
            {
                String info = manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount();
                ConsoleHelper.writeMessage(info);
                hasMoney = true;
            }
        }
        if (!hasMoney){
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
