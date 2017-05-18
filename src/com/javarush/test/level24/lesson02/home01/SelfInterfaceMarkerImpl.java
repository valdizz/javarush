package com.javarush.test.level24.lesson02.home01;

/**
 * Created by V.Kornev on 14.04.16.
 */
public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker
{
    String name;

    public SelfInterfaceMarkerImpl()
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
