package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by V.Kornev on 20.05.16.
 */
class AdvertisementStorage
{
    private static final AdvertisementStorage instance = new AdvertisementStorage();
    private final List<Advertisement> videos = new ArrayList<>();

    // конструктор private, чтобы не было возможности создать экземпл€р класса извне.
    private AdvertisementStorage(){
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));   //10 min
    }

    static AdvertisementStorage getInstance(){
        return instance;
    }

    List<Advertisement> list(){
        return videos;
    }

    void add(Advertisement advertisement){
        videos.add(advertisement);
    }

}
