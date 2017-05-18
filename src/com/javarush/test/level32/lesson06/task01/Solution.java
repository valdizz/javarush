package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        final String alphabet = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        Random random = new Random();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        while ((!flag1) || (!flag2) || (!flag3))
        {
            flag1 = false;
            flag2 = false;
            flag3 = false;
            byteArrayOutputStream.reset();
            for (int i=0; i<8; i++)
                byteArrayOutputStream.write(alphabet.charAt(random.nextInt(alphabet.length())));


            for (int i=0; i<8; i++){
                if ("1234567890".contains(String.valueOf(byteArrayOutputStream.toString().charAt(i)))){
                    flag1 = true;
                }
                if ("qwertyuiopasdfghjklzxcvbnm".contains(String.valueOf(byteArrayOutputStream.toString().charAt(i)))){
                    flag2 = true;
                }
                if ("QWERTYUIOPASDFGHJKLZXCVBNM".contains(String.valueOf(byteArrayOutputStream.toString().charAt(i)))){
                    flag3 = true;
                }
            }
        }
        return byteArrayOutputStream;
    }
}
