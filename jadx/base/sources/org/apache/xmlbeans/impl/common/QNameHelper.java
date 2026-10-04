package org.apache.xmlbeans.impl.common;

import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.xml.stream.XMLName;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class QNameHelper {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final int MAX_NAME_LENGTH = 64;
    public static final String URI_SHA1_PREFIX = "URI_SHA_1_";
    private static final Map WELL_KNOWN_PREFIXES;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$common$QNameHelper;
    private static final char[] hexdigits;

    static {
        if (class$org$apache$xmlbeans$impl$common$QNameHelper == null) {
            class$org$apache$xmlbeans$impl$common$QNameHelper = class$("org.apache.xmlbeans.impl.common.QNameHelper");
        }
        $assertionsDisabled = true;
        WELL_KNOWN_PREFIXES = buildWKP();
        hexdigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    private static Map buildWKP() {
        HashMap mapM13996q = AbstractC12991c.m13996q("http://www.w3.org/XML/1998/namespace", "xml", "http://www.w3.org/2001/XMLSchema", "xs");
        mapM13996q.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        mapM13996q.put("http://schemas.xmlsoap.org/wsdl/", "wsdl");
        mapM13996q.put("http://schemas.xmlsoap.org/soap/encoding/", "soapenc");
        mapM13996q.put("http://schemas.xmlsoap.org/soap/envelope/", "soapenv");
        return Collections.unmodifiableMap(mapM13996q);
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    public static QName forLN(String str) {
        return new QName("", str);
    }

    public static QName forLNS(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return new QName(str2, str);
    }

    public static QName forPretty(String str, int i) {
        int iIndexOf = str.indexOf(64, i);
        return iIndexOf < 0 ? new QName("", str.substring(i)) : new QName(str.substring(iIndexOf + 1), str.substring(i, iIndexOf));
    }

    public static String getLocalPart(String str) {
        int iIndexOf = str.indexOf(58);
        return iIndexOf < 0 ? str : str.substring(iIndexOf + 1);
    }

    public static String getPrefixPart(String str) {
        int iIndexOf = str.indexOf(58);
        return iIndexOf >= 0 ? str.substring(0, iIndexOf) : "";
    }

    public static XMLName getXMLName(QName qName) {
        if (qName == null) {
            return null;
        }
        return XMLNameHelper.forLNS(qName.getLocalPart(), qName.getNamespaceURI());
    }

    public static String hexsafe(String str) {
        byte[] bytes;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (isSafe(cCharAt)) {
                stringBuffer.append(cCharAt);
            } else {
                try {
                    byte[] bytes2 = str.substring(i, i + 1).getBytes("UTF-8");
                    for (int i2 = 0; i2 < bytes2.length; i2++) {
                        stringBuffer.append('_');
                        char[] cArr = hexdigits;
                        stringBuffer.append(cArr[(bytes2[i2] >> 4) & 15]);
                        stringBuffer.append(cArr[bytes2[i2] & 15]);
                    }
                } catch (UnsupportedEncodingException unused) {
                    stringBuffer.append("_BAD_UTF8_CHAR");
                }
            }
        }
        if (stringBuffer.length() <= 64) {
            return stringBuffer.toString();
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            try {
                bytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused2) {
                bytes = new byte[0];
            }
            byte[] bArrDigest = messageDigest.digest(bytes);
            if (!$assertionsDisabled && bArrDigest.length != 20) {
                throw new AssertionError();
            }
            StringBuffer stringBuffer2 = new StringBuffer(URI_SHA1_PREFIX);
            for (int i4 = 0; i4 < bArrDigest.length; i4++) {
                char[] cArr2 = hexdigits;
                stringBuffer2.append(cArr2[(bArrDigest[i4] >> 4) & 15]);
                stringBuffer2.append(cArr2[bArrDigest[i4] & 15]);
            }
            return stringBuffer2.toString();
        } catch (NoSuchAlgorithmException unused3) {
            throw new IllegalStateException("Using in a JDK without an SHA implementation");
        }
    }

    public static String hexsafedir(QName qName) {
        if (qName.getNamespaceURI() == null || qName.getNamespaceURI().length() == 0) {
            StringBuffer stringBuffer = new StringBuffer("_nons/");
            stringBuffer.append(hexsafe(qName.getLocalPart()));
            return stringBuffer.toString();
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(hexsafe(qName.getNamespaceURI()));
        stringBuffer2.append("/");
        stringBuffer2.append(hexsafe(qName.getLocalPart()));
        return stringBuffer2.toString();
    }

    private static boolean isSafe(int i) {
        if (i >= 97 && i <= 122) {
            return true;
        }
        if (i < 65 || i > 90) {
            return i >= 48 && i <= 57;
        }
        return true;
    }

    private static boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static String namespace(SchemaType schemaType) {
        while (schemaType != null) {
            if (schemaType.getName() != null) {
                return schemaType.getName().getNamespaceURI();
            }
            if (schemaType.getContainerField() != null && schemaType.getContainerField().getName().getNamespaceURI().length() > 0) {
                return schemaType.getContainerField().getName().getNamespaceURI();
            }
            schemaType = schemaType.getOuterType();
        }
        return "";
    }

    public static String pretty(QName qName) {
        if (qName == null) {
            return "null";
        }
        if (qName.getNamespaceURI() == null || qName.getNamespaceURI().length() == 0) {
            return qName.getLocalPart();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(qName.getLocalPart());
        stringBuffer.append(Log.TAG_SEPARATOR);
        stringBuffer.append(qName.getNamespaceURI());
        return stringBuffer.toString();
    }

    public static String readable(SchemaType schemaType) {
        return readable(schemaType, WELL_KNOWN_PREFIXES);
    }

    private static boolean startsWithXml(String str, int i) {
        if (str.length() < i + 3) {
            return false;
        }
        if (str.charAt(i) != 'X' && str.charAt(i) != 'x') {
            return false;
        }
        int i2 = i + 1;
        if (str.charAt(i2) != 'M' && str.charAt(i2) != 'm') {
            return false;
        }
        int i4 = i + 2;
        return str.charAt(i4) == 'L' || str.charAt(i4) == 'l';
    }

    public static String suggestPrefix(String str) {
        String str2 = (String) WELL_KNOWN_PREFIXES.get(str);
        if (str2 != null) {
            return str2;
        }
        int length = str.length();
        int iLastIndexOf = str.lastIndexOf(47);
        if (iLastIndexOf > 0 && iLastIndexOf == str.length() - 1) {
            iLastIndexOf = str.lastIndexOf(47, iLastIndexOf - 1);
            length = iLastIndexOf;
        }
        int i = iLastIndexOf + 1;
        if (str.startsWith("www.", i)) {
            i = iLastIndexOf + 5;
        }
        while (i < length && !XMLChar.isNCNameStart(str.charAt(i))) {
            i++;
        }
        for (int i2 = i + 1; i2 < length; i2++) {
            if (!XMLChar.isNCName(str.charAt(i2)) || !Character.isLetterOrDigit(str.charAt(i2))) {
                length = i2;
                break;
            }
        }
        int i4 = i + 3;
        if (str.length() < i4 || !startsWithXml(str, i)) {
            if (length - i > 4) {
                length = (!isVowel(str.charAt(i + 2)) || isVowel(str.charAt(i4))) ? i4 : i + 4;
            }
            return length - i == 0 ? VPathDataCmd.NoStroke : str.substring(i, length).toLowerCase();
        }
        if (str.length() < i + 4) {
            return VPathDataCmd.NoStroke;
        }
        StringBuffer stringBuffer = new StringBuffer("x");
        stringBuffer.append(Character.toLowerCase(str.charAt(i4)));
        return stringBuffer.toString();
    }

    public static String readable(SchemaType schemaType, Map map) {
        if (schemaType.getName() != null) {
            return readable(schemaType.getName(), map);
        }
        if (schemaType.isAttributeType()) {
            StringBuffer stringBuffer = new StringBuffer("attribute type ");
            stringBuffer.append(readable(schemaType.getAttributeTypeAttributeName(), map));
            return stringBuffer.toString();
        }
        if (schemaType.isDocumentType()) {
            StringBuffer stringBuffer2 = new StringBuffer("document type ");
            stringBuffer2.append(readable(schemaType.getDocumentElementName(), map));
            return stringBuffer2.toString();
        }
        if (schemaType.isNoType() || schemaType.getOuterType() == null) {
            return "invalid type";
        }
        SchemaType outerType = schemaType.getOuterType();
        SchemaField containerField = schemaType.getContainerField();
        if (outerType.isAttributeType()) {
            StringBuffer stringBuffer3 = new StringBuffer("type of attribute ");
            stringBuffer3.append(readable(containerField.getName(), map));
            return stringBuffer3.toString();
        }
        if (outerType.isDocumentType()) {
            StringBuffer stringBuffer4 = new StringBuffer("type of element ");
            stringBuffer4.append(readable(containerField.getName(), map));
            return stringBuffer4.toString();
        }
        if (containerField != null) {
            if (containerField.isAttribute()) {
                StringBuffer stringBuffer5 = new StringBuffer("type of ");
                stringBuffer5.append(containerField.getName().getLocalPart());
                stringBuffer5.append(" attribute in ");
                stringBuffer5.append(readable(outerType, map));
                return stringBuffer5.toString();
            }
            StringBuffer stringBuffer6 = new StringBuffer("type of ");
            stringBuffer6.append(containerField.getName().getLocalPart());
            stringBuffer6.append(" element in ");
            stringBuffer6.append(readable(outerType, map));
            return stringBuffer6.toString();
        }
        if (outerType.getBaseType() == schemaType) {
            StringBuffer stringBuffer7 = new StringBuffer("base type of ");
            stringBuffer7.append(readable(outerType, map));
            return stringBuffer7.toString();
        }
        if (outerType.getSimpleVariety() == 3) {
            StringBuffer stringBuffer8 = new StringBuffer("item type of ");
            stringBuffer8.append(readable(outerType, map));
            return stringBuffer8.toString();
        }
        if (outerType.getSimpleVariety() != 2) {
            StringBuffer stringBuffer9 = new StringBuffer("inner type in ");
            stringBuffer9.append(readable(outerType, map));
            return stringBuffer9.toString();
        }
        StringBuffer stringBuffer10 = new StringBuffer("member type ");
        stringBuffer10.append(schemaType.getAnonymousUnionMemberOrdinal());
        stringBuffer10.append(" of ");
        stringBuffer10.append(readable(outerType, map));
        return stringBuffer10.toString();
    }

    public static String readable(QName qName) {
        return readable(qName, WELL_KNOWN_PREFIXES);
    }

    public static String readable(QName qName, Map map) {
        if (qName.getNamespaceURI().length() == 0) {
            return qName.getLocalPart();
        }
        String str = (String) map.get(qName.getNamespaceURI());
        if (str != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(":");
            stringBuffer.append(qName.getLocalPart());
            return stringBuffer.toString();
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(qName.getLocalPart());
        stringBuffer2.append(" in namespace ");
        stringBuffer2.append(qName.getNamespaceURI());
        return stringBuffer2.toString();
    }
}
