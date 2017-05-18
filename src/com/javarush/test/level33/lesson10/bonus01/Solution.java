package com.javarush.test.level33.lesson10.bonus01;

import org.w3c.dom.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;


/* Комментарий внутри xml
Реализовать метод toXmlWithComment, который должен возвращать строку - xml представление объекта obj.
В строке перед каждым тэгом tagName должен быть вставлен комментарий comment.
Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно.

Пример вызова:  toXmlWithComment(firstSecondObject, "second", "it's a comment")
Пример результата:
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<first>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second><![CDATA[need CDATA because of < and >]]></second>
    <!--it's a comment-->
    <second/>
</first>
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment){
        StringWriter stringWriter = new StringWriter();
        try
        {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            marshaller.marshal(obj, document);

            //document.setXmlStandalone(false);


            changeNodes(document, document);
            NodeList list = document.getElementsByTagName(tagName);

            for (int i = 0; i < list.getLength(); i++)
                list.item(i).getParentNode().insertBefore(document.createComment(comment), list.item(i));

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
            StreamResult result = new StreamResult(stringWriter);

            transformer.transform(source, result);
            stringWriter.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }

    private static void changeNodes(Node firstNode, Document ownerDocument)
    {

        if (firstNode.hasChildNodes())
        {
            NodeList children = firstNode.getChildNodes();

            for (int i = 0; i < children.getLength(); i++)
            {
                Node node = children.item(i);
                if (node.getNodeType() == Node.TEXT_NODE)
                {
                    String text = node.getTextContent();
                    if (text != null && !text.equals("") && text.matches(".*[<>&\"'?!'].*"))
                        node.getParentNode().replaceChild(ownerDocument.createCDATASection(node.getNodeValue()), node);
                } else
                {
                    changeNodes(node, ownerDocument);
                }
            }
        }
        return;
    }

    public static void main(String[] args)
    {
        @XmlType(name = "anExample")
        @XmlRootElement(name = "first")
        class anExample
        {
            public String[] second = new String[]{"need CDATA because of < and > signs. Don't need before that <second> placed inside CDATA", "", "sadasd"};
            public String third = "fdfg<second>";
        }

        System.out.println(toXmlWithComment(new anExample(), "second", "it's a comment"));
    }

}
