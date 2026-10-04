package org.ccil.cowan.tagsoup.jaxp;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParserFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class JAXPTest {
    public static void main(String[] strArr) throws SAXException, IOException {
        new JAXPTest().test(strArr);
    }

    private void test(String[] strArr) throws SAXException, IOException {
        if (strArr.length != 1) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer("Usage: java ");
            stringBuffer.append(getClass());
            stringBuffer.append(" [input-file]");
            printStream.println(stringBuffer.toString());
            System.exit(1);
        }
        File file = new File(strArr[0]);
        System.setProperty("javax.xml.parsers.SAXParserFactory", "org.ccil.cowan.tagsoup.jaxp.SAXFactoryImpl");
        SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
        PrintStream printStream2 = System.out;
        StringBuffer stringBuffer2 = new StringBuffer("Ok, SAX factory JAXP creates is: ");
        stringBuffer2.append(sAXParserFactoryNewInstance);
        printStream2.println(stringBuffer2.toString());
        System.out.println("Let's parse...");
        sAXParserFactoryNewInstance.newSAXParser().parse(file, new DefaultHandler());
        System.out.println("Done. And then DOM build:");
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        PrintStream printStream3 = System.out;
        StringBuffer stringBuffer3 = new StringBuffer("Succesfully built DOM tree from '");
        stringBuffer3.append(file);
        stringBuffer3.append("', -> ");
        stringBuffer3.append(document);
        printStream3.println(stringBuffer3.toString());
    }
}
