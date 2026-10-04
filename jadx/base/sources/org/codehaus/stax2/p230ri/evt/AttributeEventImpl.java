package org.codehaus.stax2.p230ri.evt;

import java.io.IOException;
import java.io.Writer;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.events.Attribute;
import org.codehaus.stax2.XMLStreamWriter2;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AttributeEventImpl extends BaseEventImpl implements Attribute {
    final QName mName;
    final String mValue;
    final boolean mWasSpecified;

    public AttributeEventImpl(Location location, String str, String str2, String str3, String str4, boolean z) {
        super(location);
        this.mValue = str4;
        if (str3 != null) {
            this.mName = new QName(str2 == null ? "" : str2, str, str3);
        } else if (str2 == null) {
            this.mName = new QName(str);
        } else {
            this.mName = new QName(str2, str);
        }
        this.mWasSpecified = z;
    }

    public static void writeEscapedAttrValue(Writer writer, String str) throws IOException {
        int length = str.length();
        int i = 0;
        do {
            char cCharAt = 0;
            int i2 = i;
            while (i2 < length && (cCharAt = str.charAt(i2)) != '<' && cCharAt != '&' && cCharAt != '\"') {
                i2++;
            }
            int i4 = i2 - i;
            if (i4 > 0) {
                writer.write(str, i, i4);
            }
            if (i2 < length) {
                if (cCharAt == '<') {
                    writer.write("&lt;");
                } else if (cCharAt == '&') {
                    writer.write("&amp;");
                } else if (cCharAt == '\"') {
                    writer.write("&quot;");
                }
            }
            i = i2 + 1;
        } while (i < length);
    }

    @Override // org.codehaus.stax2.p230ri.evt.BaseEventImpl
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Attribute)) {
            return false;
        }
        Attribute attribute = (Attribute) obj;
        if (this.mName.equals(attribute.getName()) && this.mValue.equals(attribute.getValue()) && isSpecified() == attribute.isSpecified()) {
            return BaseEventImpl.stringsWithNullsEqual(getDTDType(), attribute.getDTDType());
        }
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.events.Attribute
    public String getDTDType() {
        return "CDATA";
    }

    @Override // org.codehaus.stax2.p230ri.evt.BaseEventImpl, org.apache.poi.javax.xml.stream.events.XMLEvent
    public int getEventType() {
        return 10;
    }

    @Override // org.apache.poi.javax.xml.stream.events.Attribute
    public QName getName() {
        return this.mName;
    }

    @Override // org.apache.poi.javax.xml.stream.events.Attribute
    public String getValue() {
        return this.mValue;
    }

    @Override // org.codehaus.stax2.p230ri.evt.BaseEventImpl
    public int hashCode() {
        return this.mName.hashCode() ^ this.mValue.hashCode();
    }

    @Override // org.codehaus.stax2.p230ri.evt.BaseEventImpl, org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isAttribute() {
        return true;
    }

    @Override // org.apache.poi.javax.xml.stream.events.Attribute
    public boolean isSpecified() {
        return this.mWasSpecified;
    }

    @Override // org.codehaus.stax2.p230ri.evt.BaseEventImpl, org.apache.poi.javax.xml.stream.events.XMLEvent
    public void writeAsEncodedUnicode(Writer writer) throws XMLStreamException {
        String prefix = this.mName.getPrefix();
        if (prefix != null) {
            try {
                if (prefix.length() > 0) {
                    writer.write(prefix);
                    writer.write(58);
                }
            } catch (IOException e) {
                throwFromIOE(e);
                return;
            }
        }
        writer.write(this.mName.getLocalPart());
        writer.write(61);
        writer.write(34);
        writeEscapedAttrValue(writer, this.mValue);
        writer.write(34);
    }

    @Override // org.codehaus.stax2.p230ri.evt.BaseEventImpl, org.codehaus.stax2.evt.XMLEvent2
    public void writeUsing(XMLStreamWriter2 xMLStreamWriter2) {
        QName qName = this.mName;
        xMLStreamWriter2.writeAttribute(qName.getPrefix(), qName.getLocalPart(), qName.getNamespaceURI(), this.mValue);
    }

    public AttributeEventImpl(Location location, QName qName, String str, boolean z) {
        super(location);
        this.mName = qName;
        this.mValue = str;
        this.mWasSpecified = z;
    }
}
