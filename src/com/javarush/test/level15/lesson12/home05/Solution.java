package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    String string;
    int anInt;
    Double d;

    private Solution(String string, int anInt){
        this.string = string;
        this.anInt = anInt;
    }

    private Solution(String string){
        this.string = string;
    }

    private Solution(int anInt){
        this.anInt = anInt;
    }

    public Solution(int anInt, String string){
        this.string = string;
        this.anInt = anInt;
    }

    public Solution(){

    }

    public Solution(Double d){
        this.d = d;
    }

    protected Solution(String string, Double d){
        this.string = string;
        this.d = d;
    }

    protected Solution(int anInt, Double d){
        this.anInt = anInt;
        this.d = d;
    }

    protected Solution(Double d, String string){
        this.d = d;
        this.string = string;
    }

    Solution(Double d, String string, int anInt) {
        this.d = d;
        this.string = string;
        this.anInt = anInt;
    }

    Solution(String string, int anInt, Double d) {
        this.d = d;
        this.string = string;
        this.anInt = anInt;
    }

    Solution(Double d, int anInt) {
        this.d = d;
        this.anInt = anInt;
    }

}

