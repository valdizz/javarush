package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by V.Kornev on 17.06.16.
 */
public class MoikrugStrategy implements Strategy
{
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";

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
                Elements vakancies = doc.getElementsByClass("job");
                if (vakancies.size()==0)
                    break;
                for (Element element : vakancies){
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(element.getElementsByAttributeValue("class","title").text());
                    vacancy.setCity(element.getElementsByAttributeValue("class","meta").text());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("class", "company_name").select("a").text());
                    vacancy.setSalary(element.getElementsByAttributeValue("class", "count").text());
                    vacancy.setSiteName("http://moikrug.ru/");
                    vacancy.setUrl("http://moikrug.ru"+element.getElementsByAttributeValue("class", "title").select("a").attr("href"));
                    list.add(vacancy);
                }
                page++;
            }
            catch (IOException e){}
        }
        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException{
        return Jsoup.connect(String.format(URL_FORMAT, page, searchString)).userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36").referrer("http://javarush.ru/").get();
    }

}
