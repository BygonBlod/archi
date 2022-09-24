package Util;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Util {
    public static ArrayList<Element> getElements(NodeList list) {
        ArrayList<Element> res = new ArrayList<>();
        if (list != null) {
            for (int i = 0; i < list.getLength(); i++) {
                Node n = list.item(i);
                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) n;
                    res.add(element);
                }
            }
        }
        return res;
    }

    public static Element getElementNamed(NodeList list){
        Element res=null;
        if (list!=null){
            Node n = list.item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) n;
                res=element;
            }
        }
        return res;
    }

}