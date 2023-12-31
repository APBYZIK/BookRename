import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.File;

public class BookInfo {
    private String bookName;
    private String authorFirstName;
    private String authorLastName;

    private void readInfo(Document xmlDocument) throws XPathExpressionException {
        XPath xPath = XPathFactory.newInstance().newXPath();

        authorFirstName = (String) xPath.compile("//description/title-info/author/first-name").evaluate(xmlDocument, XPathConstants.STRING);
        authorLastName = (String) xPath.compile("//description/title-info/author/last-name").evaluate(xmlDocument, XPathConstants.STRING);
        bookName  = (String)xPath.compile("//description/title-info/book-title").evaluate(xmlDocument, XPathConstants.STRING);
    }

    public void readFb2Info(File file) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder  = builderFactory.newDocumentBuilder();
        Document xmlDocument = builder.parse(file);

        readInfo(xmlDocument);
    }

    public void readFb2Info(byte[] content) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder  = builderFactory.newDocumentBuilder();
        Document xmlDocument = builder.parse(new ByteArrayInputStream(content));

        readInfo(xmlDocument);
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }
}
