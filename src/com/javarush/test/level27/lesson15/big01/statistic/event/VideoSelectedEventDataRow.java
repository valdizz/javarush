package com.javarush.test.level27.lesson15.big01.statistic.event;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;

import java.util.Date;
import java.util.List;

/**
 * Created by V.Kornev on 23.05.16.
 */
public class VideoSelectedEventDataRow implements EventDataRow
{
    private final List<Advertisement> optimalVideoSet;
    private final long amount;
    private final int totalDuration;
    private Date currentDate;

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration){
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        currentDate = new Date();
    }

    @Override
    public EventType getType()
    {
        return EventType.SELECTED_VIDEOS;
    }

    @Override
    public Date getDate()
    {
        return currentDate;
    }

    @Override
    public int getTime()
    {
        return totalDuration;
    }

    public long getAmount()
    {
        return amount;
    }

    public List<Advertisement> getOptimalVideoSet()
    {
        return optimalVideoSet;
    }
}
