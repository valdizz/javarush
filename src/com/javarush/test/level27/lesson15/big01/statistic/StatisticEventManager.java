package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 * Created by V.Kornev on 23.05.16.
 */
public class StatisticEventManager
{
    private static final StatisticEventManager instance = new StatisticEventManager();
    private StatisticStorage statisticStorage;

    private StatisticEventManager()
    {
        statisticStorage = new StatisticStorage();
    }

    public static StatisticEventManager getInstance()
    {
        return instance;
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }

    private class StatisticStorage{
        public Map<EventType, List<EventDataRow>> eventTypeListMap;

        public StatisticStorage()
        {
            eventTypeListMap = new HashMap<>();
            for (EventType eventType : EventType.values()){
                eventTypeListMap.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data){
            eventTypeListMap.get(data.getType()).add(data);
        }

        private List<EventDataRow> get(EventType eventType){
            return eventTypeListMap.get(eventType);
        }
    }

    public Map<Date,Long> getVideoAmountPerDay(){
        Map<Date,Long> resultMap = new TreeMap<Date,Long>(new Comparator<Date>()
        {
            @Override
            public int compare(Date o1, Date o2)
            {
                return o2.compareTo(o1);
            }
        });
        for (EventDataRow eventDataRow : statisticStorage.get(EventType.SELECTED_VIDEOS)){
            VideoSelectedEventDataRow video = (VideoSelectedEventDataRow)eventDataRow;
            Date videoDate = new Date(video.getDate().getYear(),video.getDate().getMonth(),video.getDate().getDate());
            resultMap.put(videoDate, resultMap.get(videoDate) == null ? video.getAmount() : resultMap.get(videoDate)+video.getAmount());
        }
        return resultMap;
    }

    public Map<Date, Map<String, Integer>> getCookWorkloading(){
        Map<Date, Map<String, Integer>> resultMap = new TreeMap<Date, Map<String, Integer>>(new Comparator<Date>()
        {
            @Override
            public int compare(Date o1, Date o2)
            {
                return o2.compareTo(o1);
            }
        });
        for (EventDataRow eventDataRow : statisticStorage.get(EventType.COOKED_ORDER)){
            CookedOrderEventDataRow order = (CookedOrderEventDataRow)eventDataRow;
            Date orderDate = new Date(order.getDate().getYear(),order.getDate().getMonth(),order.getDate().getDate());
            Map<String, Integer> mapCooks = resultMap.get(orderDate);
            if (mapCooks == null)
            {
                mapCooks = new HashMap<>();
                mapCooks.put(order.getCookName(), order.getTime());
            }
            else
                mapCooks.put(order.getCookName(),(mapCooks.get(order.getCookName())==null ? order.getTime() : mapCooks.get(order.getCookName())+order.getTime()));
            resultMap.put(orderDate, mapCooks);
        }
        return resultMap;
    }

}
