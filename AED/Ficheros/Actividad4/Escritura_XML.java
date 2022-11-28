package AED.Ficheros.Actividad4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class Escritura_XML {
    final static String namdoc= "EducationCenters";
    final static String namelement= "educationcenter";
    final static String campos[]={"Type","Name","Code","Street","PostCode","Locality","Island"};
    public static void main(String[] args) {
        File doc = new File("src\\AED\\Ficheros\\Actividad4\\EducationCenters.obj");
        Introduce_Center(doc);
        Print("The writer has successfully finished");
        Reader_Center_Obj(doc);
        Print("The reader objects has successfully finished");
    }

    private static void Reader_Center_Obj(File doc) {
        try {
            ObjectInputStream ois= new ObjectInputStream(new FileInputStream(doc));
            EducationCenter ec;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder myxml = factory.newDocumentBuilder();
            DOMImplementation implementation = myxml.getDOMImplementation();
            Document docxml = implementation.createDocument(null, namdoc, null);
            docxml.setXmlVersion("1.0");
            
            for (int i = 0; i < campos.length-1; i++) {
                ec=(EducationCenter)ois.readObject();
                Element root = docxml.createElement(namelement);
                docxml.getDocumentElement().appendChild(root);
                CreateElement(campos[0],ec.getType(),root,docxml);
                CreateElement(campos[1],ec.getName(),root,docxml);
                CreateElement(campos[2],ec.getCode(),root,docxml);
                CreateElement(campos[3],ec.getStreet(),root,docxml);
                CreateElement(campos[4],Integer.toString(ec.getPostCode()),root,docxml);
                CreateElement(campos[5],ec.getLocality(),root,docxml);
                CreateElement(campos[6],ec.getIsland(),root,docxml);
            }
            Source source = new DOMSource(docxml);
            Result result = new StreamResult(new File("./"+namdoc+".xml"));
            Transformer trans= TransformerFactory.newInstance().newTransformer();
            trans.transform(source,result);
            //Reader
            docxml= myxml.parse(new File("./"+namdoc+".xml"));
            docxml.getDocumentElement().normalize();
            Print("Root Element: "+docxml.getDocumentElement().getNodeName());
            NodeList elements= docxml.getElementsByTagName(namelement);
            for (int i = 0; i < elements.getLength(); i++) {
                Node item = elements.item(i);
                if (item.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) item;
                    Print(campos[0]+":"+leeNodo(campos[0],element));
                    Print(campos[1]+":"+leeNodo(campos[1],element));
                    Print(campos[2]+":"+leeNodo(campos[2],element));
                    Print(campos[3]+":"+leeNodo(campos[3],element));
                    Print(campos[4]+":"+leeNodo(campos[4],element));
                    Print(campos[5]+":"+leeNodo(campos[5],element));
                    Print(campos[6]+":"+leeNodo(campos[6],element));
                } 
            }
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } 
    }
    private static String leeNodo(String nametag, Element element) {
        NodeList nodo = element.getElementsByTagName(nametag).item(0).getChildNodes();
        Node value = (Node) nodo.item(0);
        return value.getNodeValue();
    }

    private static void CreateElement(String campos, String value, Element root, Document docxml) {
        Element element = docxml.createElement(campos);
        Text text = docxml.createTextNode(value);
        element.appendChild(text);
        root.appendChild(element);
    }

    protected static void Introduce_Center(File doc) {
        String[] Type={"CIFP","CEIP","IES","IES","CEI","CEE"};
        String[] Name={"Villa de Aguimes","Maspalomas","Tamara","Amurga","Dunas","Oasis"};
        //This string is alphanumeric
        String[] Code={"432E849F","478H321Q","489G312J","357M189A","594B128V","753K516L"};
        String[] Street={"Calle Lenzarote n5","Calle Fuerteventura n3","Avedina Gran Canaria n13","Avedina Tenerife n26","Calle Unamuno n19","Calle Primo de Rivera n9"};
        Integer[] PostCode={12,58,32,48,32,7};
        String[] Locality={"Cruce de Arinaga","Maspalomas","Santa Cruz de Tenerife","Jandia","Puerto Rico","Artenara"};
        String[] Island={"Gran Canaria","La Graciosa","Lanzarote","La Gomera","Tenerife","El Hierro"};
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(doc));
            for (int i = 0; i < Island.length; i++) {
                EducationCenter ec = new EducationCenter(Type[i],Name[i],Code[i],Street[i],PostCode[i],Locality[i],Island[i]);
                oos.writeObject(ec);
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected static void Print(String Text) {
        System.out.println(Text);
    }
}
