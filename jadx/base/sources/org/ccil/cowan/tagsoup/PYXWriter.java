package org.ccil.cowan.tagsoup;

import java.io.PrintWriter;
import java.io.Writer;
import org.apache.commons.beanutils.PropertyUtils;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PYXWriter implements ScanHandler, ContentHandler, LexicalHandler {
    private static char[] dummy = new char[1];
    private String attrName;
    private PrintWriter theWriter;

    public PYXWriter(Writer writer) {
        if (writer instanceof PrintWriter) {
            this.theWriter = (PrintWriter) writer;
        } else {
            this.theWriter = new PrintWriter(writer);
        }
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void adup(char[] cArr, int i, int i2) {
        this.theWriter.println(this.attrName);
        this.attrName = null;
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void aname(char[] cArr, int i, int i2) {
        this.theWriter.print('A');
        this.theWriter.write(cArr, i, i2);
        this.theWriter.print(' ');
        this.attrName = new String(cArr, i, i2);
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void aval(char[] cArr, int i, int i2) {
        this.theWriter.write(cArr, i, i2);
        this.theWriter.println();
        this.attrName = null;
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void cdsect(char[] cArr, int i, int i2) {
        pcdata(cArr, i, i2);
    }

    @Override // org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) {
        pcdata(cArr, i, i2);
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i, int i2) {
        cmnt(cArr, i, i2);
    }

    @Override // org.xml.sax.ContentHandler
    public void endDocument() {
        this.theWriter.close();
    }

    @Override // org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        if (str3.length() != 0) {
            str2 = str3;
        }
        this.theWriter.print(PropertyUtils.MAPPED_DELIM2);
        this.theWriter.println(str2);
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void eof(char[] cArr, int i, int i2) {
        this.theWriter.close();
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void etag(char[] cArr, int i, int i2) {
        this.theWriter.print(PropertyUtils.MAPPED_DELIM2);
        this.theWriter.write(cArr, i, i2);
        this.theWriter.println();
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public int getEntity() {
        return 0;
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    /* JADX INFO: renamed from: gi */
    public void mo14972gi(char[] cArr, int i, int i2) {
        this.theWriter.print(PropertyUtils.MAPPED_DELIM);
        this.theWriter.write(cArr, i, i2);
        this.theWriter.println();
    }

    @Override // org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i2) {
        characters(cArr, i, i2);
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void pcdata(char[] cArr, int i, int i2) {
        if (i2 == 0) {
            return;
        }
        int i4 = i2 + i;
        boolean z = false;
        while (i < i4) {
            if (cArr[i] == '\n') {
                if (z) {
                    this.theWriter.println();
                }
                this.theWriter.println("-\\n");
                z = false;
            } else {
                if (!z) {
                    this.theWriter.print('-');
                }
                char c = cArr[i];
                if (c == '\t') {
                    this.theWriter.print("\\t");
                } else if (c != '\\') {
                    this.theWriter.print(c);
                } else {
                    this.theWriter.print("\\\\");
                }
                z = true;
            }
            i++;
        }
        if (z) {
            this.theWriter.println();
        }
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    /* JADX INFO: renamed from: pi */
    public void mo14973pi(char[] cArr, int i, int i2) {
        this.theWriter.write(cArr, i, i2);
        this.theWriter.println();
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void pitarget(char[] cArr, int i, int i2) {
        this.theWriter.print('?');
        this.theWriter.write(cArr, i, i2);
        this.theWriter.write(32);
    }

    @Override // org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) {
        this.theWriter.print('?');
        this.theWriter.print(str);
        this.theWriter.print(' ');
        this.theWriter.println(str2);
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void stage(char[] cArr, int i, int i2) {
        this.theWriter.println("!");
    }

    @Override // org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if (str3.length() != 0) {
            str2 = str3;
        }
        this.theWriter.print(PropertyUtils.MAPPED_DELIM);
        this.theWriter.println(str2);
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            String qName = attributes.getQName(i);
            if (qName.length() == 0) {
                qName = attributes.getLocalName(i);
            }
            this.theWriter.print('A');
            this.theWriter.print(qName);
            this.theWriter.print(' ');
            this.theWriter.println(attributes.getValue(i));
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endCDATA() {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endDTD() {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startCDATA() {
    }

    @Override // org.xml.sax.ContentHandler
    public void startDocument() {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endEntity(String str) {
    }

    @Override // org.xml.sax.ContentHandler
    public void endPrefixMapping(String str) {
    }

    @Override // org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
    }

    @Override // org.xml.sax.ContentHandler
    public void skippedEntity(String str) {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startEntity(String str) {
    }

    @Override // org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) {
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void cmnt(char[] cArr, int i, int i2) {
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void decl(char[] cArr, int i, int i2) {
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void entity(char[] cArr, int i, int i2) {
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void stagc(char[] cArr, int i, int i2) {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startDTD(String str, String str2, String str3) {
    }
}
