import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Timestamp;
import java.util.AbstractList;
import java.util.ArrayList;

public class TheVergeUpdater implements IRssUpdater {
    private Timestamp timestamp;
    private String urlStr = "https://www.theverge.com/rss/index.xml";
    private AbstractList<String> words;

    public TheVergeUpdater(Timestamp timestamp, AbstractList<String> words) {
        this.timestamp = timestamp;
        this.words = words;
    }

    private Timestamp getTime(String time){
        String cut_time = time.substring(0, 19);
        Timestamp ts = Timestamp.valueOf(cut_time.replace('T', ' '));
        return ts;
    }

    public AbstractList<Item> update() throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbf.newDocumentBuilder();

        URL url = new URL(this.urlStr);
        InputStream stream = url.openStream();
        Document doc = docBuilder.parse(stream);
        doc.getDocumentElement().normalize();
        String last_update = doc.getElementsByTagName("updated").item(0).getTextContent();
        NodeList nodeList = doc.getElementsByTagName("entry");

        AbstractList<Item> items = new ArrayList<>();

        for (int itr = 0; itr < nodeList.getLength(); itr++) {
            Node node = nodeList.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                for(String word : this.words) {
                    if (eElement.getElementsByTagName("content").item(0).getTextContent().contains(word) ||
                            eElement.getElementsByTagName("title").item(0).getTextContent().contains(word)) {
                        String time = eElement.getElementsByTagName("updated").item(0).getTextContent();
                        Timestamp ts = getTime(time);
                        int check_time = ts.compareTo(this.timestamp);

                        if (check_time > 0) {
                            String content = eElement.getElementsByTagName("content").item(0).getTextContent();
                            String title = eElement.getElementsByTagName("title").item(0).getTextContent();
                            Item item = new Item(title, content);
                            items.add(item);
                        }
                        break;
                    }
                }
            }
        }
        this.timestamp = getTime(last_update);
        return items;
    }
}
