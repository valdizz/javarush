package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.*;
import java.util.ResourceBundle;

/**
 * Created by V.Kornev on 13.05.16.
 */
public class ConsoleHelper
{
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"common_en");
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException{
        try
        {
            String line = bufferedReader.readLine();
            if (line.equalsIgnoreCase("EXIT"))
                throw new InterruptOperationException();
            else
                return line;
        }
        catch (IOException e)
        {
            return "";
        }
    }

    public static String askCurrencyCode() throws InterruptOperationException{
        while (true){
            writeMessage(res.getString("choose.currency.code"));
            String currencyStrCode = readString().trim();
            if (currencyStrCode.length()!=3)
                writeMessage(res.getString("invalid.data"));
            else
                return currencyStrCode.toUpperCase();
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{
        while (true)
        {
            writeMessage(String.format(res.getString("choose.denomination.and.count.format"),currencyCode));
            String[] strings = readString().trim().split(" ");
            try
            {
                if (strings.length==2 && Integer.parseInt(strings[0])>0 && Integer.parseInt(strings[1])>0){
                    return strings;
                }
            }
            catch (Exception e){}
            writeMessage(res.getString("invalid.data"));
        }
    }

    public static Operation askOperation() throws InterruptOperationException{
        while (true){
            writeMessage(res.getString("choose.operation"));
            writeMessage(res.getString("operation.INFO"));
            writeMessage(res.getString("operation.DEPOSIT"));
            writeMessage(res.getString("operation.WITHDRAW"));
            writeMessage(res.getString("operation.EXIT"));
            String numOperation = readString();
            try
            {
                Operation operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(numOperation));
                if (operation!=null)
                    return operation;
            }
            catch (IllegalArgumentException ex){
                writeMessage(res.getString("the.end"));
            }
            catch (Exception e){

            }
        }
    }

    public static void printExitMessage(){
        writeMessage(res.getString("the.end"));
    }
}
