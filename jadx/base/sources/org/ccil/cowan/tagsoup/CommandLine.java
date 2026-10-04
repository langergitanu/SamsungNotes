package org.ccil.cowan.tagsoup;

import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import org.apache.commons.lang3.BooleanUtils;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CommandLine {
    static Hashtable options;
    private static String theOutputEncoding;
    private static Parser theParser;
    private static HTMLSchema theSchema;

    static {
        Hashtable hashtable = new Hashtable();
        options = hashtable;
        Boolean bool = Boolean.FALSE;
        hashtable.put("--nocdata", bool);
        options.put("--files", bool);
        options.put("--reuse", bool);
        options.put("--nons", bool);
        options.put("--nobogons", bool);
        options.put("--any", bool);
        options.put("--emptybogons", bool);
        options.put("--norootbogons", bool);
        options.put("--pyxin", bool);
        options.put("--lexical", bool);
        options.put("--pyx", bool);
        options.put("--html", bool);
        options.put("--method=", bool);
        options.put("--doctype-public=", bool);
        options.put("--doctype-system=", bool);
        options.put("--output-encoding=", bool);
        options.put("--omit-xml-declaration", bool);
        options.put("--encoding=", bool);
        options.put("--help", bool);
        options.put("--version", bool);
        options.put("--nodefaults", bool);
        options.put("--nocolons", bool);
        options.put("--norestart", bool);
        options.put("--ignorable", bool);
        theParser = null;
        theSchema = null;
        theOutputEncoding = null;
    }

    private static ContentHandler chooseContentHandler(Writer writer) {
        String str;
        String str2;
        String str3;
        if (hasOption(options, "--pyx")) {
            return new PYXWriter(writer);
        }
        XMLWriter xMLWriter = new XMLWriter(writer);
        if (hasOption(options, "--html")) {
            xMLWriter.setOutputProperty("method", "html");
            xMLWriter.setOutputProperty(XMLWriter.OMIT_XML_DECLARATION, BooleanUtils.YES);
        }
        if (hasOption(options, "--method=") && (str3 = (String) options.get("--method=")) != null) {
            xMLWriter.setOutputProperty("method", str3);
        }
        if (hasOption(options, "--doctype-public=") && (str2 = (String) options.get("--doctype-public=")) != null) {
            xMLWriter.setOutputProperty(XMLWriter.DOCTYPE_PUBLIC, str2);
        }
        if (hasOption(options, "--doctype-system=") && (str = (String) options.get("--doctype-system=")) != null) {
            xMLWriter.setOutputProperty(XMLWriter.DOCTYPE_SYSTEM, str);
        }
        if (hasOption(options, "--output-encoding=")) {
            String str4 = (String) options.get("--output-encoding=");
            theOutputEncoding = str4;
            if (str4 != null) {
                xMLWriter.setOutputProperty(XMLWriter.ENCODING, str4);
            }
        }
        if (hasOption(options, "--omit-xml-declaration")) {
            xMLWriter.setOutputProperty(XMLWriter.OMIT_XML_DECLARATION, BooleanUtils.YES);
        }
        xMLWriter.setPrefix(theSchema.getURI(), "");
        return xMLWriter;
    }

    private static void doHelp() {
        System.err.print("usage: java -jar tagsoup-*.jar ");
        System.err.print(" [ ");
        Enumeration enumerationKeys = options.keys();
        boolean z = true;
        while (enumerationKeys.hasMoreElements()) {
            if (!z) {
                System.err.print("| ");
            }
            String str = (String) enumerationKeys.nextElement();
            System.err.print(str);
            if (str.endsWith(MarketingConstants.REFERRER_DELIMITER_U003D)) {
                System.err.print(MsalUtils.QUERY_STRING_SYMBOL);
            }
            System.err.print(" ");
            z = false;
        }
        System.err.println("]*");
    }

    private static int getopts(Hashtable hashtable, String[] strArr) {
        String strSubstring;
        int i = 0;
        while (i < strArr.length) {
            String strSubstring2 = strArr[i];
            if (strSubstring2.charAt(0) != '-') {
                break;
            }
            int iIndexOf = strSubstring2.indexOf(61);
            if (iIndexOf != -1) {
                int i2 = iIndexOf + 1;
                strSubstring = strSubstring2.substring(i2, strSubstring2.length());
                strSubstring2 = strSubstring2.substring(0, i2);
            } else {
                strSubstring = null;
            }
            if (!hashtable.containsKey(strSubstring2)) {
                System.err.print("Unknown option ");
                System.err.println(strSubstring2);
                System.exit(1);
            } else if (strSubstring == null) {
                hashtable.put(strSubstring2, Boolean.TRUE);
            } else {
                hashtable.put(strSubstring2, strSubstring);
            }
            i++;
        }
        return i;
    }

    private static boolean hasOption(Hashtable hashtable, String str) {
        return Boolean.getBoolean(str) || hashtable.get(str) != Boolean.FALSE;
    }

    public static void main(String[] strArr) throws SAXException, IOException {
        String string;
        int i = getopts(options, strArr);
        if (hasOption(options, "--help")) {
            doHelp();
            return;
        }
        if (hasOption(options, "--version")) {
            System.err.println("TagSoup version 1.2.1");
            return;
        }
        if (strArr.length == i) {
            process("", System.out);
            return;
        }
        if (!hasOption(options, "--files")) {
            while (i < strArr.length) {
                PrintStream printStream = System.err;
                StringBuffer stringBuffer = new StringBuffer("src: ");
                stringBuffer.append(strArr[i]);
                printStream.println(stringBuffer.toString());
                process(strArr[i], System.out);
                i++;
            }
            return;
        }
        while (i < strArr.length) {
            String str = strArr[i];
            int iLastIndexOf = str.lastIndexOf(46);
            if (iLastIndexOf == -1) {
                string = str.concat(".xhtml");
            } else if (str.endsWith(".xhtml")) {
                string = str.concat("_");
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(str.substring(0, iLastIndexOf));
                stringBuffer2.append(".xhtml");
                string = stringBuffer2.toString();
            }
            PrintStream printStream2 = System.err;
            StringBuffer stringBuffer3 = new StringBuffer("src: ");
            stringBuffer3.append(str);
            stringBuffer3.append(" dst: ");
            stringBuffer3.append(string);
            printStream2.println(stringBuffer3.toString());
            process(str, new FileOutputStream(string));
            i++;
        }
    }

    private static void process(String str, OutputStream outputStream) throws SAXException, IOException {
        Parser parser;
        String str2;
        if (hasOption(options, "--reuse")) {
            if (theParser == null) {
                theParser = new Parser();
            }
            parser = theParser;
        } else {
            parser = new Parser();
        }
        HTMLSchema hTMLSchema = new HTMLSchema();
        theSchema = hTMLSchema;
        parser.setProperty(Parser.schemaProperty, hTMLSchema);
        if (hasOption(options, "--nocdata")) {
            parser.setFeature(Parser.CDATAElementsFeature, false);
        }
        if (hasOption(options, "--nons") || hasOption(options, "--html")) {
            parser.setFeature(Parser.namespacesFeature, false);
        }
        if (hasOption(options, "--nobogons")) {
            parser.setFeature(Parser.ignoreBogonsFeature, true);
        }
        if (hasOption(options, "--any")) {
            parser.setFeature(Parser.bogonsEmptyFeature, false);
        } else if (hasOption(options, "--emptybogons")) {
            parser.setFeature(Parser.bogonsEmptyFeature, true);
        }
        if (hasOption(options, "--norootbogons")) {
            parser.setFeature(Parser.rootBogonsFeature, false);
        }
        if (hasOption(options, "--nodefaults")) {
            parser.setFeature(Parser.defaultAttributesFeature, false);
        }
        if (hasOption(options, "--nocolons")) {
            parser.setFeature(Parser.translateColonsFeature, true);
        }
        if (hasOption(options, "--norestart")) {
            parser.setFeature(Parser.restartElementsFeature, false);
        }
        if (hasOption(options, "--ignorable")) {
            parser.setFeature(Parser.ignorableWhitespaceFeature, true);
        }
        if (hasOption(options, "--pyxin")) {
            parser.setProperty(Parser.scannerProperty, new PYXScanner());
        }
        ContentHandler contentHandlerChooseContentHandler = chooseContentHandler(theOutputEncoding == null ? new OutputStreamWriter(outputStream) : new OutputStreamWriter(outputStream, theOutputEncoding));
        parser.setContentHandler(contentHandlerChooseContentHandler);
        if (hasOption(options, "--lexical") && (contentHandlerChooseContentHandler instanceof LexicalHandler)) {
            parser.setProperty(Parser.lexicalHandlerProperty, contentHandlerChooseContentHandler);
        }
        InputSource inputSource = new InputSource();
        if (str != "") {
            inputSource.setSystemId(str);
        } else {
            inputSource.setByteStream(System.in);
        }
        if (hasOption(options, "--encoding=") && (str2 = (String) options.get("--encoding=")) != null) {
            inputSource.setEncoding(str2);
        }
        parser.parse(inputSource);
    }
}
