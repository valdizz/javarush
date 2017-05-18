package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    private static final long serialVersionUID = 1L;
    transient private FileOutputStream stream;
    private String file;

    public Solution(String fileName) throws FileNotFoundException {
        this.file = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(file);
        out.flush();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        file = (String)in.readObject();
        stream = new FileOutputStream(file, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception{
        Solution solution = new Solution("d:\\123.dat");

        solution.writeObject("111111");
        solution.writeObject("222222");
        //solution.close();

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("d:\\1223.dat"));
        //solution.writeObject(outputStream);
        outputStream.writeObject(solution);
        outputStream.flush();
        outputStream.close();
        //solution.close();
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("d:\\1223.dat"));
        Solution solution1 = (Solution) inputStream.readObject();
        inputStream.close();
        solution1.writeObject("333333");
    }
}
