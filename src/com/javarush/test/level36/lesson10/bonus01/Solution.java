package com.javarush.test.level36.lesson10.bonus01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/* Осваиваем ClassLoader и Reflection
Аргументом для класса Solution является абсолютный путь к пакету,
например, "C:\JavaRushHomeWork\src\com\javarush\test\level36\lesson10\bonus01\data\second".
Имя пакета может содержать File.separator.
В этом пакете находятся только скомпилированные классы.
Известно, что каждый класс имеет конструктор без параметров и реализует интерфейс HiddenClass.
Считайте все классы с файловой системы, создайте фабрику - реализуйте метод getHiddenClassObjectByKey.
Известно, что есть только один класс, простое имя которого начинается с String key без учета регистра.
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;
    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //Solution solution = new Solution("C:\\JavaRushHomeWork\\src\\com\\javarush\\test\\level36\\lesson10\\bonus01\\data\\second");
        Solution solution = new Solution("D:\\java\\JavaRushHomeWork\\out\\production\\JavaRushHomeWork\\com\\javarush\\test\\level36\\lesson10\\bonus01\\data\\second");

        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplsecond"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File dir = new File(packageName);
        final String dirName = dir.getAbsolutePath() + File.separator;
        File[] files = dir.listFiles();

        ClassLoader classLoader = new ClassLoader()
        {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException
            {

                Class<?> clazz = null;
                try
                {
                    File file = new File(dirName+name+".class");
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] bytes = new byte[(int)file.length()];
                    fileInputStream.read(bytes);
                    clazz = defineClass(null, bytes, 0, bytes.length);
                    fileInputStream.close();
                }
                catch (IOException e)
                {
                    throw new ClassNotFoundException();
                }
                return clazz;
            }
        };

        for (File file : files){
            Class clazz = classLoader.loadClass(file.getName().substring(0, file.getName().lastIndexOf(".")));
            if (HiddenClass.class.isAssignableFrom(clazz))
                hiddenClasses.add(clazz);
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (Class tmpClazz : hiddenClasses){
            if (tmpClazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase()))
            {
                try
                {
                    Constructor[] constructors = tmpClazz.getDeclaredConstructors();
                    for (Constructor constructor : constructors)
                    {
                        if (constructor.getParameterTypes().length == 0)
                        {
                            constructor.setAccessible(true);
                            return (HiddenClass) constructor.newInstance();
                        }
                    }
                }
                catch (Exception e)
                {
                }
            }
        }
        return null;
    }
}
