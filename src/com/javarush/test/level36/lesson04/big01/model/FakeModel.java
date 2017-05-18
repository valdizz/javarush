package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by V.Kornev on 06.10.16.
 */
public class FakeModel implements Model
{
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData()
    {
        return modelData;
    }

    @Override
    public void loadUsers()
    {
        modelData.setUsers(Arrays.asList(new User("A", 1, 1), new User("B", 2, 1)));
    }

    @Override
    public void loadDeletedUsers()
    {
        throw new UnsupportedOperationException();
    }

    public void loadUserById(long userId) {throw new UnsupportedOperationException();
    }

    public void deleteUserById(long id) {throw new UnsupportedOperationException();
    }

    public void changeUserData(String name, long id, int level){
        throw new UnsupportedOperationException();
    }
}
