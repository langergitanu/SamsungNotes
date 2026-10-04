package com.samsung.android.support.senl.document.memoconverter.core.Html;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ParagraphStyle;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.scsp.common.Header;
import java.io.IOException;
import java.io.StringReader;
import org.ccil.cowan.tagsoup.Parser;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class HtmlToSpannedConverter implements ContentHandler {
    private XMLReader mReader;
    private String mSource;
    private boolean mysteryTagFound;
    private SpannableStringBuilder mSpannableStringBuilder = new SpannableStringBuilder();
    private String mysteryTagContent = "";
    private String mysteryTagName = null;

    public HtmlToSpannedConverter(Context context, Parser parser, String str) {
        this.mSource = str;
        this.mReader = parser;
    }

    private static void handleBr(SpannableStringBuilder spannableStringBuilder) {
        spannableStringBuilder.append('\n');
    }

    private void handleEndTag(String str) {
        if (this.mysteryTagFound) {
            if (str.equalsIgnoreCase("html") || str.equalsIgnoreCase("body") || !this.mysteryTagName.equals(str)) {
                return;
            }
            this.mysteryTagFound = false;
            this.mSpannableStringBuilder.append((CharSequence) this.mysteryTagContent);
            return;
        }
        if (str.equalsIgnoreCase(Header.f8126BR)) {
            handleBr(this.mSpannableStringBuilder);
        } else if (str.equalsIgnoreCase("p")) {
            handleP(this.mSpannableStringBuilder);
        } else if (str.equalsIgnoreCase("div")) {
            handleP(this.mSpannableStringBuilder);
        }
    }

    private static void handleP(SpannableStringBuilder spannableStringBuilder) {
        spannableStringBuilder.append('\n');
    }

    private void handleStartTag(String str, Attributes attributes) {
        if (this.mysteryTagFound || str.equalsIgnoreCase(Header.f8126BR) || str.equalsIgnoreCase("p")) {
            return;
        }
        if (str.equalsIgnoreCase("div")) {
            handleP(this.mSpannableStringBuilder);
        } else {
            if (str.equalsIgnoreCase("img") || str.equalsIgnoreCase("html") || str.equalsIgnoreCase("body")) {
                return;
            }
            this.mysteryTagFound = true;
            this.mysteryTagName = str;
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) {
        char cCharAt;
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < i2; i4++) {
            char c = cArr[i4 + i];
            if (c == ' ' || c == '\n') {
                int length = sb.length();
                if (length == 0) {
                    int length2 = this.mSpannableStringBuilder.length();
                    cCharAt = length2 == 0 ? '\n' : this.mSpannableStringBuilder.charAt(length2 - 1);
                } else {
                    cCharAt = sb.charAt(length - 1);
                }
                if (cCharAt != ' ' && cCharAt != '\n') {
                    sb.append(' ');
                }
            } else {
                sb.append(c);
            }
        }
        try {
            if (!this.mysteryTagFound) {
                this.mSpannableStringBuilder.append((CharSequence) sb);
                return;
            }
            if (sb.length() < i2) {
                this.mysteryTagContent += sb.toString().substring(i, i2 - 1);
                return;
            }
            this.mysteryTagContent += sb.toString().substring(i, i2);
        } catch (Exception e) {
            DocumentLogger.m7180e("HtmlUtil", "setOverFlowMenu exception", e);
        }
    }

    public Spanned convert() {
        this.mReader.setContentHandler(this);
        try {
            if (this.mSource == null) {
                return null;
            }
            this.mReader.parse(new InputSource(new StringReader(this.mSource)));
            SpannableStringBuilder spannableStringBuilder = this.mSpannableStringBuilder;
            Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ParagraphStyle.class);
            for (int i = 0; i < spans.length; i++) {
                int spanStart = this.mSpannableStringBuilder.getSpanStart(spans[i]);
                int spanEnd = this.mSpannableStringBuilder.getSpanEnd(spans[i]);
                int i2 = spanEnd - 2;
                if (i2 >= 0 && this.mSpannableStringBuilder.charAt(spanEnd - 1) == '\n' && this.mSpannableStringBuilder.charAt(i2) == '\n') {
                    spanEnd--;
                }
                if (spanEnd == spanStart) {
                    this.mSpannableStringBuilder.removeSpan(spans[i]);
                } else {
                    try {
                        this.mSpannableStringBuilder.setSpan(spans[i], spanStart, spanEnd, 51);
                    } catch (Exception e) {
                        DocumentLogger.m7180e("HtmlToSpannedConverter", "convert()", e);
                    }
                }
            }
            int length = this.mSpannableStringBuilder.length();
            int i4 = length - 1;
            if (i4 > 0 && this.mSpannableStringBuilder.charAt(i4) == '\n') {
                this.mSpannableStringBuilder.replace(i4, length, (CharSequence) "");
            }
            return this.mSpannableStringBuilder;
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        } catch (SAXException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        if (this.mysteryTagFound) {
            this.mysteryTagContent = AbstractC0541b.m776r(new StringBuilder(), this.mysteryTagContent, "</", str2, ">\n");
        }
        handleEndTag(str2);
    }

    @Override // org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if (!this.mysteryTagFound) {
            this.mysteryTagContent = "";
        }
        if (!"".equals(str2)) {
            str3 = str2;
        }
        this.mysteryTagContent = AbstractC2322a.m1626p(new StringBuilder(), this.mysteryTagContent, "<", str3);
        if (attributes != null) {
            int length = attributes.getLength();
            for (int i = 0; i < length; i++) {
                String localName = attributes.getLocalName(i);
                if ("".equals(localName)) {
                    localName = attributes.getQName(i);
                }
                this.mysteryTagContent = AbstractC0622a.m1170p(this.mysteryTagContent, " ", new StringBuilder());
                StringBuilder sb = new StringBuilder();
                AbstractC1974b.m1332y(sb, this.mysteryTagContent, localName, "=\"");
                sb.append(attributes.getValue(i));
                sb.append("\"");
                this.mysteryTagContent = sb.toString();
            }
        }
        this.mysteryTagContent = AbstractC0622a.m1170p(this.mysteryTagContent, ">", new StringBuilder());
        handleStartTag(str2, attributes);
    }

    public static void releaseObject() {
    }

    @Override // org.xml.sax.ContentHandler
    public void endDocument() {
    }

    @Override // org.xml.sax.ContentHandler
    public void startDocument() {
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

    @Override // org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) {
    }

    @Override // org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) {
    }

    @Override // org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i2) {
    }
}
