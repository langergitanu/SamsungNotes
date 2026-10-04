package org.apache.xmlbeans.impl.schema;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlFactoryHook;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlSaxHandler;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.store.Locale;
import org.apache.xmlbeans.impl.validator.ValidatingXMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class SchemaTypeLoaderBase implements SchemaTypeLoader {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final String USER_AGENT;
    private static final Method _pathCompiler;
    private static final Method _queryCompiler;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$org$apache$xmlbeans$XmlOptions;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$SchemaTypeLoaderBase;

    static {
        if (class$org$apache$xmlbeans$impl$schema$SchemaTypeLoaderBase == null) {
            class$org$apache$xmlbeans$impl$schema$SchemaTypeLoaderBase = class$("org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase");
        }
        $assertionsDisabled = true;
        StringBuffer stringBuffer = new StringBuffer("XMLBeans/");
        stringBuffer.append(XmlBeans.getVersion());
        stringBuffer.append(" (");
        stringBuffer.append(XmlBeans.getTitle());
        stringBuffer.append(")");
        USER_AGENT = stringBuffer.toString();
        Class clsClass$ = class$java$lang$String;
        if (clsClass$ == null) {
            clsClass$ = class$("java.lang.String");
            class$java$lang$String = clsClass$;
        }
        Class clsClass$2 = class$org$apache$xmlbeans$XmlOptions;
        if (clsClass$2 == null) {
            clsClass$2 = class$("org.apache.xmlbeans.XmlOptions");
            class$org$apache$xmlbeans$XmlOptions = clsClass$2;
        }
        _pathCompiler = getMethod("org.apache.xmlbeans.impl.store.Path", "compilePath", new Class[]{clsClass$, clsClass$2});
        Class clsClass$3 = class$java$lang$String;
        if (clsClass$3 == null) {
            clsClass$3 = class$("java.lang.String");
            class$java$lang$String = clsClass$3;
        }
        Class clsClass$4 = class$org$apache$xmlbeans$XmlOptions;
        if (clsClass$4 == null) {
            clsClass$4 = class$("org.apache.xmlbeans.XmlOptions");
            class$org$apache$xmlbeans$XmlOptions = clsClass$4;
        }
        _queryCompiler = getMethod("org.apache.xmlbeans.impl.store.Query", "compileQuery", new Class[]{clsClass$3, clsClass$4});
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    private static String doCompilePath(String str, XmlOptions xmlOptions) {
        return (String) invokeMethod(_pathCompiler, new Object[]{str, xmlOptions});
    }

    private static String doCompileQuery(String str, XmlOptions xmlOptions) {
        return (String) invokeMethod(_queryCompiler, new Object[]{str, xmlOptions});
    }

    private static Method getMethod(String str, String str2, Class[] clsArr) {
        try {
            return Class.forName(str).getDeclaredMethod(str2, clsArr);
        } catch (Exception unused) {
            StringBuffer stringBuffer = new StringBuffer("Cannot find ");
            stringBuffer.append(str);
            stringBuffer.append(Extension.DOT);
            stringBuffer.append(str2);
            stringBuffer.append(".  verify that xmlstore (from xbean.jar) is on classpath");
            throw new IllegalStateException(stringBuffer.toString());
        }
    }

    private static Object invokeMethod(Method method, Object[] objArr) {
        try {
            return method.invoke(method, objArr);
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        } catch (Exception e2) {
            IllegalStateException illegalStateException2 = new IllegalStateException(e2.getMessage());
            illegalStateException2.initCause(e2);
            throw illegalStateException2;
        }
    }

    public String compilePath(String str) {
        return compilePath(str, null);
    }

    public String compileQuery(String str) {
        return compileQuery(str, null);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute findAttribute(QName qName) {
        SchemaGlobalAttribute.Ref refFindAttributeRef = findAttributeRef(qName);
        if (refFindAttributeRef == null) {
            return null;
        }
        SchemaGlobalAttribute schemaGlobalAttribute = refFindAttributeRef.get();
        if ($assertionsDisabled || schemaGlobalAttribute != null) {
            return schemaGlobalAttribute;
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaAttributeGroup findAttributeGroup(QName qName) {
        SchemaAttributeGroup.Ref refFindAttributeGroupRef = findAttributeGroupRef(qName);
        if (refFindAttributeGroupRef == null) {
            return null;
        }
        SchemaAttributeGroup schemaAttributeGroup = refFindAttributeGroupRef.get();
        if ($assertionsDisabled || schemaAttributeGroup != null) {
            return schemaAttributeGroup;
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findAttributeType(QName qName) {
        SchemaType.Ref refFindAttributeTypeRef = findAttributeTypeRef(qName);
        if (refFindAttributeTypeRef == null) {
            return null;
        }
        SchemaType schemaType = refFindAttributeTypeRef.get();
        if ($assertionsDisabled || schemaType != null) {
            return schemaType;
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findDocumentType(QName qName) {
        SchemaType.Ref refFindDocumentTypeRef = findDocumentTypeRef(qName);
        if (refFindDocumentTypeRef == null) {
            return null;
        }
        SchemaType schemaType = refFindDocumentTypeRef.get();
        if ($assertionsDisabled || schemaType != null) {
            return schemaType;
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement findElement(QName qName) {
        SchemaGlobalElement.Ref refFindElementRef = findElementRef(qName);
        if (refFindElementRef == null) {
            return null;
        }
        SchemaGlobalElement schemaGlobalElement = refFindElementRef.get();
        if ($assertionsDisabled || schemaGlobalElement != null) {
            return schemaGlobalElement;
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaModelGroup findModelGroup(QName qName) {
        SchemaModelGroup.Ref refFindModelGroupRef = findModelGroupRef(qName);
        if (refFindModelGroupRef == null) {
            return null;
        }
        SchemaModelGroup schemaModelGroup = refFindModelGroupRef.get();
        if ($assertionsDisabled || schemaModelGroup != null) {
            return schemaModelGroup;
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findType(QName qName) {
        SchemaType.Ref refFindTypeRef = findTypeRef(qName);
        if (refFindTypeRef == null) {
            return null;
        }
        SchemaType schemaType = refFindTypeRef.get();
        if ($assertionsDisabled || schemaType != null) {
            return schemaType;
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public DOMImplementation newDomImplementation(XmlOptions xmlOptions) {
        return Locale.newDomImplementation(this, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject newInstance(SchemaType schemaType, XmlOptions xmlOptions) {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        return hook != null ? hook.newInstance(this, schemaType, xmlOptions) : Locale.newInstance(this, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions) {
        return new ValidatingXMLInputStream(xMLInputStream, this, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlSaxHandler newXmlSaxHandler(SchemaType schemaType, XmlOptions xmlOptions) {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        return hook != null ? hook.newXmlSaxHandler(this, schemaType, xmlOptions) : Locale.newSaxHandler(this, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(String str, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        return hook != null ? hook.parse(this, str, schemaType, xmlOptions) : Locale.parseToXmlObject(this, str, schemaType, xmlOptions);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x013f  */
    @Override // org.apache.xmlbeans.SchemaTypeLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SchemaType typeForSignature(String str) {
        String strSubstring;
        int iIndexOf = str.indexOf(64);
        if (iIndexOf < 0) {
            iIndexOf = str.length();
            strSubstring = "";
        } else {
            strSubstring = str.substring(iIndexOf + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < iIndexOf) {
            int iIndexOf2 = str.indexOf(58, i);
            int iIndexOf3 = str.indexOf(124, i);
            if (iIndexOf2 < 0 || (iIndexOf3 >= 0 && iIndexOf2 >= iIndexOf3)) {
                iIndexOf2 = iIndexOf3;
            }
            if (iIndexOf2 < 0 || iIndexOf2 > iIndexOf) {
                iIndexOf2 = iIndexOf;
            }
            arrayList.add(str.substring(i, iIndexOf2));
            i = iIndexOf2 + 1;
        }
        SchemaType type = null;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            String str2 = (String) arrayList.get(size);
            if (str2.length() < 1) {
                throw new IllegalArgumentException();
            }
            int i2 = (str2.length() < 2 || str2.charAt(1) != '=') ? 1 : 2;
            char cCharAt = str2.charAt(0);
            if (cCharAt == 'I') {
                if (type == null) {
                    throw new IllegalArgumentException();
                }
                if (type.getSimpleVariety() != 3) {
                    return null;
                }
                SchemaType[] anonymousTypes = type.getAnonymousTypes();
                if (anonymousTypes.length != 1) {
                    return null;
                }
                type = anonymousTypes[0];
            } else if (cCharAt == 'M') {
                if (type == null) {
                    throw new IllegalArgumentException();
                }
                try {
                    int i4 = Integer.parseInt(str2.substring(i2));
                    if (type.getSimpleVariety() != 2) {
                        return null;
                    }
                    SchemaType[] anonymousTypes2 = type.getAnonymousTypes();
                    if (anonymousTypes2.length <= i4) {
                        return null;
                    }
                    type = anonymousTypes2[i4];
                } catch (Exception unused) {
                    throw new IllegalArgumentException();
                }
            } else if (cCharAt == 'Q') {
                if (type != null) {
                    if (type.isSimpleType()) {
                        return null;
                    }
                    SchemaType[] anonymousTypes3 = type.getAnonymousTypes();
                    String strSubstring2 = str2.substring(i2);
                    for (int i5 = 0; i5 < anonymousTypes3.length; i5++) {
                        SchemaField containerField = anonymousTypes3[i5].getContainerField();
                        if (containerField != null && containerField.isAttribute() && containerField.getName().getLocalPart().equals(strSubstring2)) {
                            type = anonymousTypes3[i5];
                        }
                    }
                    return null;
                }
                SchemaGlobalAttribute schemaGlobalAttributeFindAttribute = findAttribute(QNameHelper.forLNS(str2.substring(i2), strSubstring));
                if (schemaGlobalAttributeFindAttribute == null) {
                    return null;
                }
                type = schemaGlobalAttributeFindAttribute.getType();
            } else if (cCharAt == 'R') {
                if (type != null) {
                    throw new IllegalArgumentException();
                }
                type = findAttributeType(QNameHelper.forLNS(str2.substring(i2), strSubstring));
                if (type == null) {
                    return null;
                }
            } else if (cCharAt == 'T') {
                if (type != null) {
                    throw new IllegalArgumentException();
                }
                type = findType(QNameHelper.forLNS(str2.substring(i2), strSubstring));
                if (type == null) {
                    return null;
                }
            } else if (cCharAt != 'U') {
                switch (cCharAt) {
                    case 'A':
                        break;
                    case 'B':
                        if (type == null) {
                            throw new IllegalArgumentException();
                        }
                        if (type.getSimpleVariety() != 1) {
                            return null;
                        }
                        SchemaType[] anonymousTypes4 = type.getAnonymousTypes();
                        if (anonymousTypes4.length != 1) {
                            return null;
                        }
                        type = anonymousTypes4[0];
                        break;
                        break;
                    case 'C':
                        break;
                    case 'D':
                        if (type != null) {
                            throw new IllegalArgumentException();
                        }
                        type = findDocumentType(QNameHelper.forLNS(str2.substring(i2), strSubstring));
                        if (type == null) {
                            return null;
                        }
                        break;
                        break;
                    case 'E':
                        if (type != null) {
                            if (type.getContentType() < 3) {
                                return null;
                            }
                            SchemaType[] anonymousTypes5 = type.getAnonymousTypes();
                            String strSubstring3 = str2.substring(i2);
                            for (int i6 = 0; i6 < anonymousTypes5.length; i6++) {
                                SchemaField containerField2 = anonymousTypes5[i6].getContainerField();
                                if (containerField2 != null && !containerField2.isAttribute() && containerField2.getName().getLocalPart().equals(strSubstring3)) {
                                    type = anonymousTypes5[i6];
                                }
                                break;
                            }
                            return null;
                        }
                        SchemaGlobalElement schemaGlobalElementFindElement = findElement(QNameHelper.forLNS(str2.substring(i2), strSubstring));
                        if (schemaGlobalElementFindElement == null) {
                            return null;
                        }
                        type = schemaGlobalElementFindElement.getType();
                        break;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }
        return type;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public String compilePath(String str, XmlOptions xmlOptions) {
        return doCompilePath(str, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public String compileQuery(String str, XmlOptions xmlOptions) {
        return doCompileQuery(str, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.parse(this, xMLInputStream, schemaType, xmlOptions);
        }
        return Locale.parseToXmlObject(this, xMLInputStream, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(XMLStreamReader xMLStreamReader, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.parse(this, xMLStreamReader, schemaType, xmlOptions);
        }
        return Locale.parseToXmlObject(this, xMLStreamReader, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(File file, SchemaType schemaType, XmlOptions xmlOptions) throws IOException {
        if (xmlOptions == null) {
            xmlOptions = new XmlOptions();
            xmlOptions.put(XmlOptions.DOCUMENT_SOURCE_NAME, file.toURI().normalize().toString());
        } else if (!xmlOptions.hasOption(XmlOptions.DOCUMENT_SOURCE_NAME)) {
            XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
            xmlOptions2.put(XmlOptions.DOCUMENT_SOURCE_NAME, file.toURI().normalize().toString());
            xmlOptions = xmlOptions2;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return parse(fileInputStream, schemaType, xmlOptions);
        } finally {
            fileInputStream.close();
        }
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(URL url, SchemaType schemaType, XmlOptions xmlOptions) throws IOException {
        InputStream inputStream;
        URLConnection uRLConnectionOpenConnection;
        if (xmlOptions == null) {
            xmlOptions = new XmlOptions();
            xmlOptions.put(XmlOptions.DOCUMENT_SOURCE_NAME, url.toString());
        } else if (!xmlOptions.hasOption(XmlOptions.DOCUMENT_SOURCE_NAME)) {
            XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
            xmlOptions2.put(XmlOptions.DOCUMENT_SOURCE_NAME, url.toString());
            xmlOptions = xmlOptions2;
        }
        int i = 0;
        boolean z = false;
        do {
            inputStream = null;
            try {
                uRLConnectionOpenConnection = url.openConnection();
                uRLConnectionOpenConnection.addRequestProperty("User-Agent", USER_AGENT);
                uRLConnectionOpenConnection.addRequestProperty("Accept", "application/xml, text/xml, */*");
                if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                    int responseCode = httpURLConnection.getResponseCode();
                    boolean z2 = responseCode == 301 || responseCode == 302;
                    if (z2 && i > 5) {
                        z2 = false;
                    }
                    if (z2) {
                        String headerField = httpURLConnection.getHeaderField("Location");
                        if (headerField == null) {
                            z = false;
                        } else {
                            url = new URL(headerField);
                            i++;
                            z = z2;
                        }
                    } else {
                        z = z2;
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } while (z);
        inputStream = uRLConnectionOpenConnection.getInputStream();
        XmlObject xmlObject = parse(inputStream, schemaType, xmlOptions);
        if (inputStream != null) {
            inputStream.close();
        }
        return xmlObject;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(InputStream inputStream, SchemaType schemaType, XmlOptions xmlOptions) {
        DigestInputStream digestInputStream;
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (xmlOptions == null || !xmlOptions.hasOption(XmlOptions.LOAD_MESSAGE_DIGEST)) {
            digestInputStream = null;
        } else {
            try {
                digestInputStream = new DigestInputStream(inputStream, MessageDigest.getInstance("SHA"));
                inputStream = digestInputStream;
            } catch (NoSuchAlgorithmException unused) {
                digestInputStream = null;
            }
        }
        if (hook != null) {
            return hook.parse(this, inputStream, schemaType, xmlOptions);
        }
        XmlObject toXmlObject = Locale.parseToXmlObject(this, inputStream, schemaType, xmlOptions);
        if (digestInputStream != null) {
            toXmlObject.documentProperties().setMessageDigest(digestInputStream.getMessageDigest().digest());
        }
        return toXmlObject;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(Reader reader, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.parse(this, reader, schemaType, xmlOptions);
        }
        return Locale.parseToXmlObject(this, reader, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(Node node, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.parse(this, node, schemaType, xmlOptions);
        }
        return Locale.parseToXmlObject(this, node, schemaType, xmlOptions);
    }
}
