package com.javarush.test.level36.lesson04.home01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by V.Kornev on 05.10.16.
 */
public class Model
{
    private Service service= new Service();

    public List<String> getStringDataList()    {
        return service.getData();
    }
}
