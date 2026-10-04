package org.apache.poi.javax.xml.stream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XMLStreamException extends Exception {
    protected Location location;
    protected Throwable nested;

    public XMLStreamException() {
    }

    public Location getLocation() {
        return this.location;
    }

    public Throwable getNestedException() {
        return this.nested;
    }

    public XMLStreamException(String str) {
        super(str);
    }

    public XMLStreamException(Throwable th) {
        this.nested = th;
    }

    public XMLStreamException(String str, Throwable th) {
        super(str);
        this.nested = th;
    }

    public XMLStreamException(String str, Location location, Throwable th) {
        StringBuffer stringBuffer = new StringBuffer("ParseError at [row,col]:[");
        stringBuffer.append(location.getLineNumber());
        stringBuffer.append(",");
        stringBuffer.append(location.getColumnNumber());
        stringBuffer.append("]\nMessage: ");
        stringBuffer.append(str);
        super(stringBuffer.toString());
        this.nested = th;
        this.location = location;
    }

    public XMLStreamException(String str, Location location) {
        StringBuffer stringBuffer = new StringBuffer("ParseError at [row,col]:[");
        stringBuffer.append(location.getLineNumber());
        stringBuffer.append(",");
        stringBuffer.append(location.getColumnNumber());
        stringBuffer.append("]\nMessage: ");
        stringBuffer.append(str);
        super(stringBuffer.toString());
        this.location = location;
    }
}
