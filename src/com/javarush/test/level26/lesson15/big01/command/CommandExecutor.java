package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by V.Kornev on 16.05.16.
 */
public final class CommandExecutor
{
    static Map<Operation, Command> operationMap = new HashMap<>();

    static {
        operationMap.put(Operation.LOGIN, new LoginCommand());
        operationMap.put(Operation.INFO, new InfoCommand());
        operationMap.put(Operation.DEPOSIT, new DepositCommand());
        operationMap.put(Operation.WITHDRAW, new WithdrawCommand());
        operationMap.put(Operation.EXIT, new ExitCommand());
    }

    public static final void execute(Operation operation) throws InterruptOperationException
    {
        operationMap.get(operation).execute();
    }

    private CommandExecutor()
    {
    }
}
