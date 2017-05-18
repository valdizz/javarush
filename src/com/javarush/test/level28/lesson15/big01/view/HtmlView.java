package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson10.home01.*;
import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

/**
 * Created by V.Kornev on 27.05.16.
 */
public class HtmlView implements View
{
    private Controller controller;
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace(".", "/") + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies)
    {
        try
        {
            updateFile(getUpdatedFileContent(vacancies));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) throws IOException{
        try
        {
            Document document = getDocument();
            Element original = document.getElementsByClass("template").first();
            Element copy = original.clone();
            copy.removeAttr("style");
            copy.removeClass("template");
            document.select("tr[class=vacancy]").remove();
            for (Vacancy vacancy : vacancies){
                Element element = copy.clone();
                element.getElementsByClass("city").first().text(vacancy.getCity());
                element.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                element.getElementsByClass("salary").first().text(vacancy.getSalary());
                element.getElementsByTag("a").first().text(vacancy.getTitle());
                element.getElementsByTag("a").first().attr("href",vacancy.getUrl());
                document.select("tr[class=vacancy template]").before(element.outerHtml());
            }
            return document.html();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "Some exception occurred";
        }
    }

    private void updateFile(String contentFile) throws IOException{
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(contentFile);
        fileWriter.close();
    }

    protected Document getDocument() throws IOException{
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
