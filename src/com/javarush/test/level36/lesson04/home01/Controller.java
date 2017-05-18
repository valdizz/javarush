package com.javarush.test.level36.lesson04.home01;

import java.util.List;

/**
 * Created by V.Kornev on 05.10.16.
 */
public class Controller
{
    private Model model = new Model();

    public List<String> onDataListShow() {
        return model.getStringDataList();
    }
}
