package com.samsung.android.support.senl.document.memoconverter.xml;

import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class XMLParser {
    public static final int ERROR_CODE_EXCEPTION = -1;
    public static final int ERROR_CODE_NOT_SUPPORTED = -2;
    public static final int ERROR_CODE_NO_FREE_SPACE = -4;
    public static final int ERROR_CODE_PROCESS_STOPPED = -5;
    public static final int ERROR_CODE_WRONG_PWD = -3;
    private static final String TAG = "XMLParser";
    public static final String XML_CONTENT_FILE = "/snote/snote.xml";
    public static final String XML_SETTINGS_FILE = "/snote/settings.xml";
    private static XMLParser instance;
    private String content;
    private long createdTime;
    private long modifiedTime;
    private String templateType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class XMLHandler extends DefaultHandler {
        private static final String TAG_CONTENT = "t";
        private static final String TAG_CREATED_TIME = "createdTime";
        private static final String TAG_MODIFIED_TIME = "modifiedTime";
        private static final String TAG_TEMPLATE_TYPE = "TemplateInfo";
        private static final String TAG_VALUE = "val";
        private StringBuilder buf;
        private boolean currentElement;
        private XMLItem item;

        private XMLHandler() {
            this.currentElement = false;
            this.buf = new StringBuilder();
            this.item = new XMLItem();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) {
            if (this.currentElement) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    this.buf.append(cArr[i4]);
                }
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            this.currentElement = false;
            if (str2.equalsIgnoreCase("t")) {
                this.item.setContent(this.buf.toString());
            }
        }

        public String getContent() {
            XMLItem xMLItem = this.item;
            if (xMLItem == null) {
                return null;
            }
            return xMLItem.getContent();
        }

        public long getCreatedTime() {
            XMLItem xMLItem = this.item;
            if (xMLItem == null) {
                return 0L;
            }
            return xMLItem.getCreatedTime();
        }

        public long getModifiedTime() {
            XMLItem xMLItem = this.item;
            if (xMLItem == null) {
                return 0L;
            }
            return xMLItem.getModifiedTime();
        }

        public String getTemplateType() {
            XMLItem xMLItem = this.item;
            if (xMLItem == null) {
                return null;
            }
            return xMLItem.getTemplateType();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (str2.equals("t")) {
                this.currentElement = true;
                return;
            }
            if (str2.equals(TAG_TEMPLATE_TYPE)) {
                this.item.setTemplateType(attributes.getValue("val"));
                return;
            }
            if (str2.equals("createdTime")) {
                this.item.setCreatedTime(Long.parseLong(attributes.getValue("val")));
            } else if (str2.equals("modifiedTime")) {
                this.item.setModifiedTime(Long.parseLong(attributes.getValue("val")));
            }
        }
    }

    private XMLParser() {
    }

    public static XMLParser getInstance() {
        if (instance == null) {
            instance = new XMLParser();
        }
        return instance;
    }

    public String getContent() {
        return this.content;
    }

    public long getCreatedTime() {
        return this.createdTime;
    }

    public long getModifiedTime() {
        return this.modifiedTime;
    }

    public String getTemplateType() {
        return this.templateType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0071 A[EXC_TOP_SPLITTER, PHI: r5
      0x0071: PHI (r5v6 java.io.FileInputStream) = 
      (r5v27 java.io.FileInputStream)
      (r5v28 java.io.FileInputStream)
      (r5v29 java.io.FileInputStream)
      (r5v30 java.io.FileInputStream)
     binds: [B:43:0x0098, B:41:0x0094, B:31:0x006f, B:38:0x008e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.samsung.android.support.senl.document.memoconverter.xml.XMLParser$1] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int parseXMLContent(String str) throws Throwable {
        FileInputStream fileInputStream;
        XMLReader xMLReader;
        XMLHandler xMLHandler;
        FileInputStream fileInputStream2;
        int i = -2;
        ?? r5 = 0;
        FileInputStream fileInputStream3 = null;
        FileInputStream fileInputStream4 = null;
        FileInputStream fileInputStream5 = null;
        FileInputStream fileInputStream6 = null;
        try {
            try {
                xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                xMLHandler = new XMLHandler();
                xMLReader.setContentHandler(xMLHandler);
                fileInputStream2 = new FileInputStream(new File(str + XML_CONTENT_FILE));
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
        } catch (IOException e2) {
            e = e2;
        } catch (ParserConfigurationException e3) {
            e = e3;
        } catch (SAXException e5) {
            e = e5;
        }
        try {
            xMLReader.parse(new InputSource(fileInputStream2));
            String content = xMLHandler.getContent();
            this.content = content;
            try {
                fileInputStream2.close();
            } catch (IOException e6) {
                DocumentLogger.m7180e(TAG, "Exception during closing InputStream.", e6);
            }
            i = 0;
            r5 = content;
        } catch (FileNotFoundException e7) {
            e = e7;
            fileInputStream3 = fileInputStream2;
            DocumentLogger.m7180e(TAG, str + "/snote/snote.xml was not found.", e);
            r5 = fileInputStream3;
            if (fileInputStream3 != null) {
                fileInputStream = fileInputStream3;
                try {
                    fileInputStream.close();
                    r5 = fileInputStream;
                } catch (IOException e8) {
                    DocumentLogger.m7180e(TAG, "Exception during closing InputStream.", e8);
                    r5 = fileInputStream;
                }
            }
        } catch (IOException e9) {
            e = e9;
            fileInputStream4 = fileInputStream2;
            DocumentLogger.m7180e(TAG, "Exception during XML parsing.", e);
            r5 = fileInputStream4;
            fileInputStream = fileInputStream4;
            if (fileInputStream4 != null) {
                fileInputStream.close();
                r5 = fileInputStream;
            }
        } catch (ParserConfigurationException e10) {
            e = e10;
            fileInputStream5 = fileInputStream2;
            DocumentLogger.m7180e(TAG, "Exception during SAX initialization.", e);
            r5 = fileInputStream5;
            if (fileInputStream5 != null) {
                fileInputStream = fileInputStream5;
                fileInputStream.close();
                r5 = fileInputStream;
            }
        } catch (SAXException e11) {
            e = e11;
            fileInputStream6 = fileInputStream2;
            DocumentLogger.m7180e(TAG, "Exception during SAX initialization.", e);
            r5 = fileInputStream6;
            fileInputStream = fileInputStream6;
            if (fileInputStream6 != null) {
            }
        } catch (Throwable th2) {
            th = th2;
            r5 = fileInputStream2;
            if (r5 != 0) {
                try {
                    r5.close();
                } catch (IOException e12) {
                    DocumentLogger.m7180e(TAG, "Exception during closing InputStream.", e12);
                }
            }
            throw th;
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x007d A[EXC_TOP_SPLITTER, PHI: r5
      0x007d: PHI (r5v6 java.io.FileInputStream) = 
      (r5v29 java.io.FileInputStream)
      (r5v30 java.io.FileInputStream)
      (r5v31 java.io.FileInputStream)
      (r5v32 java.io.FileInputStream)
     binds: [B:43:0x00a4, B:41:0x00a0, B:31:0x007b, B:38:0x009a] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.samsung.android.support.senl.document.memoconverter.xml.XMLParser$1] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int parseXMLSettings(String str) throws Throwable {
        FileInputStream fileInputStream;
        XMLReader xMLReader;
        XMLHandler xMLHandler;
        FileInputStream fileInputStream2;
        int i = -2;
        ?? r5 = 0;
        FileInputStream fileInputStream3 = null;
        FileInputStream fileInputStream4 = null;
        FileInputStream fileInputStream5 = null;
        FileInputStream fileInputStream6 = null;
        try {
            try {
                xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                xMLHandler = new XMLHandler();
                xMLReader.setContentHandler(xMLHandler);
                fileInputStream2 = new FileInputStream(new File(str + XML_SETTINGS_FILE));
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
        } catch (IOException e2) {
            e = e2;
        } catch (ParserConfigurationException e3) {
            e = e3;
        } catch (SAXException e5) {
            e = e5;
        }
        try {
            xMLReader.parse(new InputSource(fileInputStream2));
            this.templateType = xMLHandler.getTemplateType();
            this.createdTime = xMLHandler.getCreatedTime();
            long modifiedTime = xMLHandler.getModifiedTime();
            this.modifiedTime = modifiedTime;
            try {
                fileInputStream2.close();
            } catch (Exception e6) {
                DocumentLogger.m7180e(TAG, "Exception during InputStream close.", e6);
            }
            i = 0;
            r5 = modifiedTime;
        } catch (FileNotFoundException e7) {
            e = e7;
            fileInputStream3 = fileInputStream2;
            DocumentLogger.m7180e(TAG, str + "/snote/settings.xml was not found.", e);
            r5 = fileInputStream3;
            if (fileInputStream3 != null) {
                fileInputStream = fileInputStream3;
                try {
                    fileInputStream.close();
                    r5 = fileInputStream;
                } catch (Exception e8) {
                    DocumentLogger.m7180e(TAG, "Exception during InputStream close.", e8);
                    r5 = fileInputStream;
                }
            }
        } catch (IOException e9) {
            e = e9;
            fileInputStream4 = fileInputStream2;
            DocumentLogger.m7180e(TAG, "Exception during XML parsing.", e);
            r5 = fileInputStream4;
            fileInputStream = fileInputStream4;
            if (fileInputStream4 != null) {
                fileInputStream.close();
                r5 = fileInputStream;
            }
        } catch (ParserConfigurationException e10) {
            e = e10;
            fileInputStream5 = fileInputStream2;
            DocumentLogger.m7180e(TAG, "Exception during SAX initialization.", e);
            r5 = fileInputStream5;
            if (fileInputStream5 != null) {
                fileInputStream = fileInputStream5;
                fileInputStream.close();
                r5 = fileInputStream;
            }
        } catch (SAXException e11) {
            e = e11;
            fileInputStream6 = fileInputStream2;
            DocumentLogger.m7180e(TAG, "Exception during SAX initialization.", e);
            r5 = fileInputStream6;
            fileInputStream = fileInputStream6;
            if (fileInputStream6 != null) {
            }
        } catch (Throwable th2) {
            th = th2;
            r5 = fileInputStream2;
            if (r5 != 0) {
                try {
                    r5.close();
                } catch (Exception e12) {
                    DocumentLogger.m7180e(TAG, "Exception during InputStream close.", e12);
                }
            }
            throw th;
        }
        return i;
    }
}
