package com.javarush.test.level15.lesson12.home05;

/**
 * Created by V.Kornev on 02.03.16.
 */
public class SubSolution extends Solution
{
    public SubSolution(int anInt, String string)
    {
        super(anInt, string);
    }

    public SubSolution()
    {
    }

    public SubSolution(Double d)
    {
        super(d);
    }

    protected SubSolution(String string, Double d)
    {
        super(string, d);
    }

    protected SubSolution(int anInt, Double d)
    {
        super(anInt, d);
    }

    protected SubSolution(Double d, String string)
    {
        super(d, string);
    }

    SubSolution(Double d, String string, int anInt)
    {
        super(d, string, anInt);
    }

    SubSolution(String string, int anInt, Double d)
    {
        super(string, anInt, d);
    }

    SubSolution(Double d, int anInt)
    {
        super(d, anInt);
    }

    private SubSolution(String string, int anInt){
        this.string = string;
        this.anInt = anInt;
    }

    private SubSolution(String string){
        this.string = string;
    }

    private SubSolution(int anInt){
        this.anInt = anInt;
    }
}
