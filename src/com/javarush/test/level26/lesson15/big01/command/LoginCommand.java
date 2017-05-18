package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by V.Kornev on 17.05.16.
 */
class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"login");

    @Override
    public void execute() throws InterruptOperationException
    {
        while (true){
            ConsoleHelper.writeMessage(res.getString("before"));
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String cardNumber = ConsoleHelper.readString().trim();
            if (cardNumber.length()!=12){
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                continue;
            }
            String cardPin = ConsoleHelper.readString().trim();
            if (cardPin.length()!=4){
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                continue;
            }
            if (validCreditCards.containsKey(cardNumber) && cardPin.equals(validCreditCards.getString(cardNumber))){
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"),cardNumber));
                break;
            }
            else {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"),cardNumber));
            }
        }
    }
}
