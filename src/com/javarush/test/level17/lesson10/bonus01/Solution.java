package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        Person person;
        Date d = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        switch (args[0]) {
            case "-c":
                try {
                    d = dateFormat1.parse(args[3]);
                }
                catch (ParseException e) {}
                if ("м".equals(args[2]))
                    person = Person.createMale(args[1], d);
                else
                    person = Person.createFemale(args[1], d);
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
                break;
            case "-u":
                person = allPeople.get(Integer.parseInt(args[1]));
                try {
                    d = dateFormat1.parse(args[4]);
                }
                catch (ParseException e) {}
                person.setName(args[2]);
                person.setBirthDay(d);
                if ("м".equals(args[3]))
                    person.setSex(Sex.MALE);
                else
                    person.setSex(Sex.FEMALE);
                allPeople.set(Integer.parseInt(args[1]),person);
                break;
            case "-d":
                person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(null);
                person.setSex(null);
                person.setBirthDay(null);
                //allPeople.remove(Integer.parseInt(args[1]));
                break;
            case "-i":
                person = allPeople.get(Integer.parseInt(args[1]));
                System.out.println(person.getName()+" "+(person.getSex()==Sex.MALE ? "м" : "ж")+" "+dateFormat.format(person.getBirthDay()));
                break;
        }

    }
}
