package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("Ivan");
            user1.setLastName("Ivanov");
            user1.setBirthDate(new Date(90, 12, 25));
            user1.setCountry(User.Country.UKRAINE);
            user1.setMale(true);
            javaRush.users.add(user1);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (loadedObject.equals(javaRush))
                System.out.println("Same shit!");
            System.out.println(loadedObject.users.get(0).getFirstName());
            System.out.println(javaRush.users.get(0).getFirstName());
            System.out.println(loadedObject.users.get(0).getLastName());
            System.out.println(javaRush.users.get(0).getLastName());
            System.out.println(loadedObject.users.get(0).getBirthDate());
            System.out.println(javaRush.users.get(0).getBirthDate());
            System.out.println(loadedObject.users.get(0).getCountry());
            System.out.println(javaRush.users.get(0).getCountry());
            System.out.println(loadedObject.users.get(0).isMale());
            System.out.println(javaRush.users.get(0).isMale());

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            for (User user : users){
                writer.println("yes");
                writer.println(user.getFirstName());
                writer.println(user.getLastName());
                writer.println(new SimpleDateFormat("dd.MM.yyyy").format(user.getBirthDate()));
                writer.println(user.getCountry());
                writer.println(user.isMale() ? "male" : "female");
                writer.flush();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine())!=null){
                if (line.equals("yes")){
                    User user = new User();
                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());
                    user.setBirthDate(new SimpleDateFormat("dd.MM.yyyy").parse(reader.readLine()));
                    user.setCountry(User.Country.valueOf(reader.readLine()));
                    user.setMale(reader.readLine().equals("male") ? true : false);
                    users.add(user);
                }
            }

        }
    }
}
