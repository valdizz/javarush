package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут

        switch (args[0]) {
            case "-c":
                createPerson(args);
                break;
            case "-u":
                updatePerson(args);
                break;
            case "-d":
                deletePerson(args);
                break;
            case "-i":
                infoPerson(args);
                break;
        }


    }

    public static String getSexyStr(Sex sex) {
        return (sex == Sex.MALE ? "м" : "ж");
    }

    public static Sex getSexyEnum(String sex) {
        return (sex.equals("м") ? Sex.MALE : Sex.FEMALE);
    }

    public synchronized static void createPerson(String[] args) {
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Person person = null;
        for (int i=1; i<(args.length-1); i+=3) {
            try {
                if (args[i+1].equals("м"))
                    person = Person.createMale(args[i],dateFormat2.parse(args[i+2]));
                else
                    person = Person.createFemale(args[i],dateFormat2.parse(args[i+2]));
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }
    }

    public synchronized static void updatePerson(String[] args) {
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        for (int i=1; i<(args.length-1); i+=4) {
            allPeople.get(Integer.parseInt(args[i])).setName(args[i+1]);
            allPeople.get(Integer.parseInt(args[i])).setSex(getSexyEnum(args[i+2]));
            try {
                allPeople.get(Integer.parseInt(args[i])).setBirthDay(dateFormat2.parse(args[i+3]));
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized static void deletePerson(String[] args) {
        for (int i=1; i<args.length; i++) {
            allPeople.get(Integer.parseInt(args[i])).setName(null);
            allPeople.get(Integer.parseInt(args[i])).setSex(null);
            allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
            //allPeople.remove(Integer.parseInt(args[i]));
        }
    }

    public synchronized static void infoPerson(String[] args) {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (int i=1; i<args.length; i++) {
            System.out.println(allPeople.get(Integer.parseInt(args[i])).getName()+" "+getSexyStr(allPeople.get(Integer.parseInt(args[i])).getSex())+" "+dateFormat1.format(allPeople.get(Integer.parseInt(args[i])).getBirthDay()));
        }
    }
}
