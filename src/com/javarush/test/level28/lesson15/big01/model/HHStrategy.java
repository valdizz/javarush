package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by V.Kornev on 25.05.16.
 */
public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> list = new ArrayList<>();
        Document doc = null;
        int page = 0;
        while (true){
            try
            {
                doc = getDocument(searchString, page);
                if (doc == null)
                    break;
                Elements vakancies = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (vakancies.size()==0)
                    break;
                for (Element element : vakancies){
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(element.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy-title").text());
                    vacancy.setCity(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                    vacancy.setSalary(element.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy-compensation").text());
                    vacancy.setSiteName("http://hh.ua/");
                    vacancy.setUrl(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));
                    list.add(vacancy);
                }
                page++;
            }
            catch (IOException e){}
        }
        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException{
        return Jsoup.connect(String.format(URL_FORMAT,searchString,page)).userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36").referrer("http://javarush.ru/").get();
    }
}
