package com.project.ugyfel_gate_rest.DataBase;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LoadMySQL
{   public static String DriverName;
    public static String Address;
    public static String UserPass;
    public static String DBName;
    public static String UserName;
    public static String Password;

    public static String getDriverName() {
        return DriverName;
    }

    public static String getAddress() {
        return Address;
    }

    public static String getUserPass() {
        return UserPass;
    }

    public static String getDBName() {
        return DBName;
    }

    public static String getUserName() {
        return UserName;
    }

    public static String getPassword() {
        return Password;
    }

    public LoadMySQL()
    {
        try
        {
            //creating a constructor of file class and parsing an XML file
            File file = new File("src/main/resources/DataBase/MySQL_Connection.xml");
            //an instance of factory that gives a document builder
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //an instance of builder to parse the specified xml file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            //System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("DataBase");
            // nodeList is not iterable, so we are using for loop
            for (int itr = 0; itr < nodeList.getLength(); itr++)
            {
                Node node = nodeList.item(itr);
                //System.out.println("\nNode Name :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;
                    //System.out.println("Driver: "+ eElement.getElementsByTagName("Driver").item(0).getTextContent());
                    DriverName = eElement.getElementsByTagName("Driver").item(0).getTextContent();
                    Address = eElement.getElementsByTagName("Address").item(0).getTextContent();
                    UserPass = eElement.getElementsByTagName("UserPass").item(0).getTextContent();
                    DBName = eElement.getElementsByTagName("DBName").item(0).getTextContent();
                    UserName = eElement.getElementsByTagName("UserName").item(0).getTextContent();
                    Password = eElement.getElementsByTagName("Password").item(0).getTextContent();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
