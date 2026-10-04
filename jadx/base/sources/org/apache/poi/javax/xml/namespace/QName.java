package org.apache.poi.javax.xml.namespace;

import java.io.Serializable;
import opennlp.tools.parser.Parse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class QName implements Serializable {
    private String localPart;
    private String namespaceURI;
    private String prefix;

    public QName(String str) {
        this("", str);
    }

    public static QName valueOf(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("invalid QName literal");
        }
        if (str.charAt(0) != '{') {
            return new QName(str);
        }
        int iIndexOf = str.indexOf(125);
        if (iIndexOf == -1) {
            throw new IllegalArgumentException("invalid QName literal");
        }
        if (iIndexOf != str.length() - 1) {
            return new QName(str.substring(1, iIndexOf), str.substring(iIndexOf + 1));
        }
        throw new IllegalArgumentException("invalid QName literal");
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof QName)) {
            return false;
        }
        QName qName = (QName) obj;
        return this.localPart.equals(qName.localPart) && this.namespaceURI.equals(qName.namespaceURI);
    }

    public String getLocalPart() {
        return this.localPart;
    }

    public String getNamespaceURI() {
        return this.namespaceURI;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public final int hashCode() {
        return this.namespaceURI.hashCode() ^ this.localPart.hashCode();
    }

    public String toString() {
        if (this.namespaceURI.equals("")) {
            return this.localPart;
        }
        StringBuffer stringBuffer = new StringBuffer(Parse.BRACKET_LCB);
        stringBuffer.append(this.namespaceURI);
        stringBuffer.append("}");
        stringBuffer.append(this.localPart);
        return stringBuffer.toString();
    }

    public QName(String str, String str2) {
        this(str, str2, "");
    }

    public QName(String str, String str2, String str3) {
        if (str2 != null) {
            str = str == null ? "" : str;
            str3 = str3 == null ? "" : str3;
            this.namespaceURI = str;
            this.localPart = str2;
            this.prefix = str3;
            return;
        }
        throw new IllegalArgumentException("Local part not allowed to be null");
    }
}
