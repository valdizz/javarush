package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 * Created by V.Kornev on 20.05.16.
 */
public class AdvertisementManager
{
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    private List<Advertisement> advertisements = new ArrayList<>();

    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }

    public void printCombination(List<Advertisement> arr, Stack<Advertisement> s, int am) {
        if (am == 0) {
            List<Advertisement> result = new ArrayList<>();
            result.addAll(s);
            List<Advertisement> variantAdv = new ArrayList<>();
            int variantSeconds = 0;
            long variantCost = 0;
            for (Advertisement adv : result){
                if (variantSeconds+adv.getDuration() > timeSeconds)
                    break;
                variantSeconds += adv.getDuration();
                variantCost += adv.getAmountPerOneDisplaying();
                variantAdv.add(adv);
            }
            int resultSeconds = 0;
            long resultCost = 0;
            for (Advertisement adv : advertisements){
                resultSeconds += adv.getDuration();
                resultCost += adv.getAmountPerOneDisplaying();
            }
            if ((variantCost > resultCost) || (variantCost == resultCost && variantSeconds > resultSeconds) || (variantCost == resultCost && variantSeconds == resultSeconds && variantAdv.size() < advertisements.size())){
                advertisements.clear();
                advertisements.addAll(variantAdv);
            }
            return;
        }
        for (int i = 0; i < arr.size(); i++) if (arr.get(i) != null) {
            s.push(arr.get(i));
            arr.set(i,null);
            printCombination(arr, s, am - 1);
            arr.set(i,s.pop());
        }
    }

    public void processVideos() throws NoVideoAvailableException
    {
        List<Advertisement> videos = new ArrayList<>();
        for (Advertisement adv : storage.list()){
            if (adv.getHits()>0)
                videos.add(adv);
        }
        printCombination(videos, new Stack<Advertisement>(), videos.size());

        if (advertisements.isEmpty())
            throw new NoVideoAvailableException();

        Collections.sort(advertisements, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                if (result != 0) return -result;
                long  amountPerOneSecond1 = o1.getAmountPerOneDisplaying()*1000 / o1.getDuration();
                long  amountPerOneSecond2 = o2.getAmountPerOneDisplaying()*1000 / o2.getDuration();
                    return Long.compare(amountPerOneSecond1, amountPerOneSecond2);
            }
        });


        long amount = 0;
        int duration = 0;
        for (Advertisement advertisement : advertisements) {
            amount += advertisement.getAmountPerOneDisplaying();
            duration += advertisement.getDuration();
        }

        StatisticEventManager.getInstance().register(new VideoSelectedEventDataRow(advertisements, amount, duration));

        for (Advertisement advertisement : advertisements){
            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... "
                    + advertisement.getAmountPerOneDisplaying() + ", "
                    + advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration());
            advertisement.revalidate();
        }
    }
}
