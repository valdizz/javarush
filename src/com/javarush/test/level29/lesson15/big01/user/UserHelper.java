package com.javarush.test.level29.lesson15.big01.user;

public class UserHelper
{
    private User userAnya = new User("Аня", "Смирнова", 10);
    private User userRoma = new User("Рома", "Виноградов", 30);

    public void printUsers()
    {
        userAnya.printInfo();
        userRoma.printInfo();
    }

    public int calculateAvarageAge()
    {
        User userUra = new User("Юра", "Карп", 28);
        return (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;
    }

    public double calculateRate(double base, int age, boolean hasWork, boolean hasHouse)
    {
        double result = base;
        result += age / 100;
        result *= hasWork ? 1.1 : 0.9;
        result  *= hasHouse ? 1.1 : 0.9;
        return result;
    }

    public String getBoosName(User user)
    {
        return user.getBoss();
    }
}
