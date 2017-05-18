package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException{
        System.out.println(getPartOfString("JavaRush - лучший ."));
    }

    public static String getPartOfString(String string) throws TooShortStringException
    {
        int bpos=0, epos=0;
        try
        {
            bpos = string.indexOf(" ")+1;
            String[] strings = string.split("\\s");
            epos = string.indexOf(strings[4])+strings[4].length();

        }
        catch (Exception e){
            throw new TooShortStringException();
        }
        return string.substring(bpos,epos);
    }

    public static class TooShortStringException extends Exception{
    }
}
