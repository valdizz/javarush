package com.javarush.test.level35.lesson10.bonus01;

import com.javarush.test.level35.lesson10.bonus01.data.Cat;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

/* ClassLoader - что это такое?
Реализуйте логику метода getAllAnimals.
Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.
Путь не обязательно содержит / в конце.
НЕ все классы наследуются от интерфейса Animal.
НЕ все классы имеют публичный конструктор без параметров.
Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров, - создать по одному объекту.
Добавить созданные объекты в результирующий сет и вернуть.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals("D://pathToClasses/");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> result = new HashSet<>();

        final File dir = new File(pathToAnimals.endsWith("/") ? pathToAnimals : pathToAnimals+"/");
        File[] files = dir.listFiles(new FilenameFilter()
        {
            @Override
            public boolean accept(File dir, String name)
            {
                return name.toLowerCase().endsWith(".class");
            }
        });

        class AnimalClassLoader extends ClassLoader{
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException
            {
                Class<?> clazz = null;
                try
                {
                    File file = new File(dir+File.separator+name+".class");
                    FileInputStream f = new FileInputStream(file);
                    byte[] classBytes= new byte[(int)file.length()];
                    try {
                        f.read(classBytes,0,classBytes.length);
                    } finally {
                        try {
                            f.close();
                        } catch (Exception e) {};
                    }
                    clazz = defineClass(classBytes, 0 , classBytes.length);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                return clazz;
            }
        }

        AnimalClassLoader animalClassLoader = new AnimalClassLoader();

        for (File file : files){
            try
            {
                Class<? extends Animal> clazz = (Class<? extends Animal>) animalClassLoader.loadClass(file.getName().substring(0,file.getName().length()-6));
                Class[] classes = clazz.getInterfaces();
                Constructor[] constructors = clazz.getConstructors();
                for(Class interfaces : classes)
                {
                    if (Animal.class.getName().equals(interfaces.getName()))
                    {
                        for (Constructor constructor : constructors)
                        {
                             if (constructor.getParameterTypes().length==0)
                             {
                                 if (!clazz.isInterface())
                                 {
                                     result.add(clazz.newInstance());
                                 }
                             }
                        }
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return result;
    }
}
