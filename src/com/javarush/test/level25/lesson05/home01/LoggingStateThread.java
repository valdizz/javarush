package com.javarush.test.level25.lesson05.home01;

/**
 * Created by V.Kornev on 22.04.16.
 */
public class LoggingStateThread extends Thread
{
    Thread thread;
    public State state;

    public LoggingStateThread(Thread target)
    {
        setDaemon(true);
        thread = target;
        state = thread.getState();
        System.out.println(thread.getState());
    }

    @Override
    public void run()
    {
        while (state != State.TERMINATED){
            if (thread.getState() != state)
            {
                state = thread.getState();
                System.out.println(state);
            }
        }
    }

}
