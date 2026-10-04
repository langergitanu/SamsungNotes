package org.apache.xmlbeans;

import java.io.File;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.stream.Location;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XmlError implements Serializable {
    public static final int SEVERITY_ERROR = 0;
    public static final int SEVERITY_INFO = 2;
    public static final int SEVERITY_WARNING = 1;
    private static final ResourceBundle _bundle = ResourceBundle.getBundle("org.apache.xmlbeans.message");
    static /* synthetic */ Class class$org$apache$xmlbeans$XmlCursor = null;
    static /* synthetic */ Class class$org$apache$xmlbeans$XmlLineNumber = null;
    static /* synthetic */ Class class$org$apache$xmlbeans$XmlObject = null;
    private static final long serialVersionUID = 1;
    private String _code;
    private int _column;
    private transient XmlCursor _cursor;
    private int _line;
    private String _message;
    private int _offset;
    private int _severity;
    private String _source;

    public XmlError(XmlError xmlError) {
        this._severity = 0;
        this._line = -1;
        this._column = -1;
        this._offset = -1;
        this._message = xmlError.getMessage();
        this._code = xmlError.getErrorCode();
        this._severity = xmlError.getSeverity();
        this._source = xmlError.getSourceName();
        this._line = xmlError.getLine();
        this._column = xmlError.getColumn();
        this._offset = xmlError.getOffset();
        this._cursor = xmlError.getCursorLocation();
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    public static XmlError forCursor(String str, XmlCursor xmlCursor) {
        return forCursor(str, 0, xmlCursor);
    }

    public static XmlError forLocation(String str, String str2, Location location) {
        return new XmlError(str, (String) null, 0, str2, location.getLineNumber(), location.getColumnNumber(), -1, (XmlCursor) null);
    }

    public static XmlError forLocationAndCursor(String str, int i, String str2, int i2, int i4, int i5, XmlCursor xmlCursor) {
        return new XmlError(str, (String) null, i, str2, i2, i4, i5, xmlCursor);
    }

    public static XmlError forMessage(String str) {
        return forMessage(str, 0);
    }

    public static XmlError forObject(String str, XmlObject xmlObject) {
        return forObject(str, 0, xmlObject);
    }

    public static XmlError forSource(String str, String str2) {
        return forLocation(str, 0, str2, -1, -1, -1);
    }

    public static String formattedFileName(String str, URI uri) {
        URI uriRelativize = null;
        if (str == null) {
            return null;
        }
        try {
            URI uri2 = new URI(str);
            if (uri2.isAbsolute()) {
                uriRelativize = uri2;
            }
        } catch (URISyntaxException unused) {
        }
        if (uriRelativize == null) {
            uriRelativize = new File(str).toURI();
        }
        if (uri != null) {
            uriRelativize = uri.relativize(uriRelativize);
        }
        if (!uriRelativize.isAbsolute() ? !(uri == null || !uri.isAbsolute() || uri.getScheme().compareToIgnoreCase("file") != 0) : uriRelativize.getScheme().compareToIgnoreCase("file") == 0) {
            try {
                return new File(uriRelativize).toString();
            } catch (Exception unused2) {
            }
        }
        return uriRelativize.toString();
    }

    public static String formattedMessage(String str, Object[] objArr) {
        if (str == null) {
            return null;
        }
        try {
            return MessageFormat.format(_bundle.getString(str), objArr);
        } catch (IllegalArgumentException e) {
            return MessageFormat.format(_bundle.getString("message.pattern.invalid"), e.getMessage());
        } catch (MissingResourceException e2) {
            return MessageFormat.format(_bundle.getString("message.missing.resource"), e2.getMessage());
        }
    }

    public static String severityAsString(int i) {
        if (i == 0) {
            return "error";
        }
        if (i == 1) {
            return "warning";
        }
        if (i == 2) {
            return "info";
        }
        throw new IllegalArgumentException("unknown severity");
    }

    public int getColumn() {
        return this._column;
    }

    public XmlCursor getCursorLocation() throws Throwable {
        Class clsClass$ = class$org$apache$xmlbeans$XmlCursor;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.xmlbeans.XmlCursor");
            class$org$apache$xmlbeans$XmlCursor = clsClass$;
        }
        return (XmlCursor) getLocation(clsClass$);
    }

    public String getErrorCode() {
        return this._code;
    }

    public int getLine() {
        return this._line;
    }

    public Object getLocation(Object obj) throws Throwable {
        XmlCursor xmlCursor;
        Class clsClass$ = class$org$apache$xmlbeans$XmlCursor;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.xmlbeans.XmlCursor");
            class$org$apache$xmlbeans$XmlCursor = clsClass$;
        }
        if (obj == clsClass$) {
            return this._cursor;
        }
        Class clsClass$2 = class$org$apache$xmlbeans$XmlObject;
        if (clsClass$2 == null) {
            clsClass$2 = class$("org.apache.xmlbeans.XmlObject");
            class$org$apache$xmlbeans$XmlObject = clsClass$2;
        }
        if (obj != clsClass$2 || (xmlCursor = this._cursor) == null) {
            return null;
        }
        return xmlCursor.getObject();
    }

    public String getMessage() {
        return this._message;
    }

    public XmlObject getObjectLocation() throws Throwable {
        Class clsClass$ = class$org$apache$xmlbeans$XmlObject;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.xmlbeans.XmlObject");
            class$org$apache$xmlbeans$XmlObject = clsClass$;
        }
        return (XmlObject) getLocation(clsClass$);
    }

    public int getOffset() {
        return this._offset;
    }

    public int getSeverity() {
        return this._severity;
    }

    public String getSourceName() {
        return this._source;
    }

    public String toString() {
        return toString(null);
    }

    public static XmlError forCursor(String str, Object[] objArr, XmlCursor xmlCursor) {
        return forCursor(str, objArr, 0, xmlCursor);
    }

    public static XmlError forLocation(String str, String str2, int i, int i2, int i4) {
        return new XmlError(str, (String) null, 0, str2, i, i2, i4, (XmlCursor) null);
    }

    public static XmlError forMessage(String str, int i) {
        return forSource(str, i, null);
    }

    public static XmlError forObject(String str, Object[] objArr, XmlObject xmlObject) {
        return forObject(str, objArr, 0, xmlObject);
    }

    public static XmlError forSource(String str, int i, String str2) {
        return forLocation(str, i, str2, -1, -1, -1);
    }

    public String toString(URI uri) {
        StringBuffer stringBuffer = new StringBuffer();
        String str = formattedFileName(getSourceName(), uri);
        if (str != null) {
            stringBuffer.append(str);
            int line = getLine();
            if (line < 0) {
                line = 0;
            }
            stringBuffer.append(':');
            stringBuffer.append(line);
            stringBuffer.append(':');
            if (getColumn() > 0) {
                stringBuffer.append(getColumn());
                stringBuffer.append(':');
            }
            stringBuffer.append(" ");
        }
        int severity = getSeverity();
        if (severity == 0) {
            stringBuffer.append("error: ");
        } else if (severity == 1) {
            stringBuffer.append("warning: ");
        }
        if (getErrorCode() != null) {
            stringBuffer.append(getErrorCode());
            stringBuffer.append(": ");
        }
        String message = getMessage();
        if (message == null) {
            message = "<Unspecified message>";
        }
        stringBuffer.append(message);
        return stringBuffer.toString();
    }

    public static XmlError forCursor(String str, int i, XmlCursor xmlCursor) {
        return new XmlError(str, (String) null, i, xmlCursor);
    }

    public static XmlError forLocation(String str, Object[] objArr, int i, String str2, int i2, int i4, int i5) {
        return new XmlError(str, objArr, i, str2, i2, i4, i5, (XmlCursor) null);
    }

    public static XmlError forMessage(String str, Object[] objArr) {
        return forSource(str, objArr, 0, null);
    }

    public static XmlError forObject(String str, int i, XmlObject xmlObject) {
        if (xmlObject == null) {
            return forMessage(str, i);
        }
        return forCursor(str, i, xmlObject.newCursor());
    }

    public static XmlError forSource(String str, Object[] objArr, int i, String str2) {
        return forLocation(str, objArr, i, str2, -1, -1, -1);
    }

    public static XmlError forCursor(String str, Object[] objArr, int i, XmlCursor xmlCursor) {
        return new XmlError(str, objArr, i, xmlCursor);
    }

    public static XmlError forLocation(String str, int i, String str2, int i2, int i4, int i5) {
        return new XmlError(str, (String) null, i, str2, i2, i4, i5, (XmlCursor) null);
    }

    public static XmlError forMessage(String str, Object[] objArr, int i) {
        return forSource(str, objArr, i, null);
    }

    public static XmlError forObject(String str, Object[] objArr, int i, XmlObject xmlObject) {
        if (xmlObject == null) {
            return forMessage(str, objArr, i);
        }
        return forCursor(str, objArr, i, xmlObject.newCursor());
    }

    private XmlError(String str, String str2, int i, String str3, int i2, int i4, int i5, XmlCursor xmlCursor) {
        this._message = str;
        this._code = str2;
        this._severity = i;
        this._source = str3;
        this._line = i2;
        this._column = i4;
        this._offset = i5;
        this._cursor = xmlCursor;
    }

    private XmlError(String str, Object[] objArr, int i, String str2, int i2, int i4, int i5, XmlCursor xmlCursor) {
        this(formattedMessage(str, objArr), str, i, str2, i2, i4, i5, xmlCursor);
    }

    public XmlError(String str, String str2, int i, XmlCursor xmlCursor) throws Throwable {
        String sourceName;
        int offset;
        int column;
        this._severity = 0;
        int line = -1;
        this._line = -1;
        this._column = -1;
        this._offset = -1;
        if (xmlCursor != null) {
            sourceName = xmlCursor.documentProperties().getSourceName();
            XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
            Class clsClass$ = class$org$apache$xmlbeans$XmlLineNumber;
            if (clsClass$ == null) {
                clsClass$ = class$("org.apache.xmlbeans.XmlLineNumber");
                class$org$apache$xmlbeans$XmlLineNumber = clsClass$;
            }
            XmlLineNumber xmlLineNumber = (XmlLineNumber) xmlCursorNewCursor.getBookmark(clsClass$);
            if (xmlLineNumber == null) {
                Class clsClass$2 = class$org$apache$xmlbeans$XmlLineNumber;
                if (clsClass$2 == null) {
                    clsClass$2 = class$("org.apache.xmlbeans.XmlLineNumber");
                    class$org$apache$xmlbeans$XmlLineNumber = clsClass$2;
                }
                xmlLineNumber = (XmlLineNumber) xmlCursorNewCursor.toPrevBookmark(clsClass$2);
            }
            if (xmlLineNumber != null) {
                line = xmlLineNumber.getLine();
                column = xmlLineNumber.getColumn();
                offset = xmlLineNumber.getOffset();
            } else {
                offset = -1;
                column = -1;
            }
            xmlCursorNewCursor.dispose();
        } else {
            sourceName = null;
            offset = -1;
            column = -1;
        }
        this._message = str;
        this._code = str2;
        this._severity = i;
        this._source = sourceName;
        this._line = line;
        this._column = column;
        this._offset = offset;
        this._cursor = xmlCursor;
    }

    public XmlError(String str, Object[] objArr, int i, XmlCursor xmlCursor) {
        this(formattedMessage(str, objArr), str, i, xmlCursor);
    }

    public XmlError(String str, String str2, int i, Location location) {
        String publicId;
        int columnNumber;
        this._severity = 0;
        int lineNumber = -1;
        this._line = -1;
        this._column = -1;
        this._offset = -1;
        if (location != null) {
            lineNumber = location.getLineNumber();
            columnNumber = location.getColumnNumber();
            publicId = location.getPublicId();
            if (publicId == null) {
                publicId = location.getSystemId();
            }
        } else {
            publicId = null;
            columnNumber = -1;
        }
        this._message = str;
        this._code = str2;
        this._severity = i;
        this._source = publicId;
        this._line = lineNumber;
        this._column = columnNumber;
    }

    public XmlError(String str, Object[] objArr, int i, Location location) {
        this(formattedMessage(str, objArr), str, i, location);
    }
}
