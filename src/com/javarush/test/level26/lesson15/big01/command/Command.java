package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

/**
 * Created by V.Kornev on 16.05.16.
 */
interface Command
{
    void execute() throws InterruptOperationException;
}
