package com.javarush.test.level27.lesson15.big01.ad;

import java.util.*;

/**
 * Created by V.Kornev on 24.05.16.
 */
public class StatisticAdvertisementManager
{
    private final static StatisticAdvertisementManager instance = new StatisticAdvertisementManager();
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager()
    {
    }

    public static StatisticAdvertisementManager getInstance()
    {
        return instance;
    }

    public Set<Advertisement> getActiveAdvertisements(){
        SortedSet<Advertisement> activeAdvertisements = new TreeSet<Advertisement>(new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement advertisement : storage.list()){
            if (advertisement.getHits()>0)
                activeAdvertisements.add(advertisement);
        }
        return activeAdvertisements;
    }

    public Set<Advertisement> getArchiveAdvertisements(){
        SortedSet<Advertisement> archiveAdvertisements = new TreeSet<Advertisement>(new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement advertisement : storage.list()){
            if (advertisement.getHits()==0)
                archiveAdvertisements.add(advertisement);
        }
        return archiveAdvertisements;
    }
}
