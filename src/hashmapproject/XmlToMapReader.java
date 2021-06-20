package hashmapproject;

import java.io.*;
import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public final class XmlToMapReader extends MapReader {

    /**
     * Taking a path to XML config file, read the data and store it
     * into Today and Yesterday hashmaps.
     * @param filepath Absolute path to the config file.
     * @throws Exception
     */
    @Override
    public void parseFormat(String filepath) throws Exception {
        try {
            File file = new File(filepath);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            setYesterday(getHashMap("yesterday", document));
            setToday(getHashMap("today", document));
        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new Exception(Strings.ERR_PARSE);
        }
    }

    /**
     * Parse XML nodes into a hashmap, where keys are URLs and values
     * are source HTML codes that are being stored in files specified in "source"
     * XML attributes.
     * @param name Name of parent XML node.
     * @param param XML document.
     * @return Today or Yesterday hashmap.
     */
    @Override
    protected HashMap<String, String> getHashMap(String name, Object param) {
        HashMap<String, String> result = new HashMap<>();
        Document document = (Document)param;
        NodeList lst = document.getElementsByTagName(name)
                    .item(0).getChildNodes();
        for (int i = 0; i < lst.getLength(); i++) {
            if ("item".equals(lst.item(i).getNodeName())) {
                String url = lst.item(i).getAttributes().getNamedItem("url").getNodeValue();
                String src = lst.item(i).getAttributes().getNamedItem("source").getNodeValue();
                String html = "";
                try (FileReader fr = new FileReader(src)) {
                    int c;
                    while ((c = fr.read()) != -1)
                        html += (char)c;
                } catch (IOException ioe) {
                    html = src;
                }
                result.put(url, html);
            }
        }
        return result;
    }
}
