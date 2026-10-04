package org.apache.xmlbeans.impl.util;

import androidx.compose.p109ui.layout.LayoutKt;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import kotlin.collections.AbstractC12991c;
import opennlp.tools.parser.Parse;
import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateBuilder;
import org.apache.xmlbeans.GDateSpecification;
import org.apache.xmlbeans.XmlCalendar;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.impl.common.InvalidLexicalValueException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class XsTypeConverter {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final char[] CH_ZEROS;
    private static final BigDecimal DECIMAL__ZERO;
    private static final String EMPTY_PREFIX = "";
    private static final char NAMESPACE_SEP = ':';
    private static final String NAN_LEX = "NaN";
    private static final String NEG_INF_LEX = "-INF";
    private static final String POS_INF_LEX = "INF";
    private static final String[] URI_CHARS_REPLACED_WITH;
    private static final String[] URI_CHARS_TO_BE_REPLACED;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$util$XsTypeConverter;

    static {
        if (class$org$apache$xmlbeans$impl$util$XsTypeConverter == null) {
            class$org$apache$xmlbeans$impl$util$XsTypeConverter = class$("org.apache.xmlbeans.impl.util.XsTypeConverter");
        }
        $assertionsDisabled = true;
        DECIMAL__ZERO = new BigDecimal(0.0d);
        URI_CHARS_TO_BE_REPLACED = new String[]{" ", Parse.BRACKET_LCB, "}", "|", "\\", "^", "[", "]", "`"};
        URI_CHARS_REPLACED_WITH = new String[]{"%20", "%7b", "%7d", "%7c", "%5c", "%5e", "%5b", "%5d", "%60"};
        CH_ZEROS = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'};
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    public static GDateSpecification getGDateValue(Date date, int i) {
        GDateBuilder gDateBuilder = new GDateBuilder(date);
        gDateBuilder.setBuiltinTypeCode(i);
        return gDateBuilder.toGDate();
    }

    public static String getQNameString(String str, String str2, String str3) {
        if (str3 == null || str == null || str.length() <= 0 || str3.length() <= 0) {
            return str2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str3);
        stringBuffer.append(NAMESPACE_SEP);
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public static CharSequence lexAnyURI(CharSequence charSequence) {
        StringBuffer stringBuffer = new StringBuffer(charSequence.toString());
        for (int i = 0; i < URI_CHARS_TO_BE_REPLACED.length; i++) {
            int i2 = 0;
            while (true) {
                int iIndexOf = stringBuffer.indexOf(URI_CHARS_TO_BE_REPLACED[i], i2);
                if (iIndexOf >= 0) {
                    stringBuffer.replace(iIndexOf, iIndexOf + 1, URI_CHARS_REPLACED_WITH[i]);
                    i2 = iIndexOf + 3;
                }
            }
        }
        try {
            URI.create(stringBuffer.toString());
            return charSequence;
        } catch (IllegalArgumentException e) {
            StringBuffer stringBuffer2 = new StringBuffer("invalid anyURI value: ");
            stringBuffer2.append((Object) charSequence);
            throw new InvalidLexicalValueException(stringBuffer2.toString(), e);
        }
    }

    public static byte[] lexBase64Binary(CharSequence charSequence) {
        byte[] bArrDecode = Base64.decode(charSequence.toString().getBytes());
        if (bArrDecode != null) {
            return bArrDecode;
        }
        throw new InvalidLexicalValueException("invalid base64Binary value");
    }

    public static boolean lexBoolean(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            if ('0' == cCharAt) {
                return false;
            }
            if ('1' == cCharAt) {
                return true;
            }
        } else if (length != 4) {
            if (length == 5 && 'f' == charSequence.charAt(0) && 'a' == charSequence.charAt(1) && 'l' == charSequence.charAt(2) && 's' == charSequence.charAt(3) && 'e' == charSequence.charAt(4)) {
                return false;
            }
        } else if ('t' == charSequence.charAt(0) && 'r' == charSequence.charAt(1) && 'u' == charSequence.charAt(2) && 'e' == charSequence.charAt(3)) {
            return true;
        }
        StringBuffer stringBuffer = new StringBuffer("invalid boolean: ");
        stringBuffer.append((Object) charSequence);
        throw new InvalidLexicalValueException(stringBuffer.toString());
    }

    public static byte lexByte(CharSequence charSequence) {
        return parseByte(charSequence);
    }

    public static XmlCalendar lexDateTime(CharSequence charSequence) {
        return getGDateValue(charSequence, 14).getCalendar();
    }

    public static BigDecimal lexDecimal(CharSequence charSequence) {
        return new BigDecimal(trimTrailingZeros(charSequence.toString()));
    }

    public static double lexDouble(CharSequence charSequence) {
        char cCharAt;
        String string = charSequence.toString();
        try {
            if (charSequence.length() > 0 && ((cCharAt = charSequence.charAt(charSequence.length() - 1)) == 'd' || cCharAt == 'D')) {
                StringBuffer stringBuffer = new StringBuffer("Invalid char '");
                stringBuffer.append(cCharAt);
                stringBuffer.append("' in double.");
                throw new NumberFormatException(stringBuffer.toString());
            }
            return Double.parseDouble(string);
        } catch (NumberFormatException e) {
            if (string.equals(POS_INF_LEX)) {
                return Double.POSITIVE_INFINITY;
            }
            if (string.equals(NEG_INF_LEX)) {
                return Double.NEGATIVE_INFINITY;
            }
            if (string.equals(NAN_LEX)) {
                return Double.NaN;
            }
            throw e;
        }
    }

    public static float lexFloat(CharSequence charSequence) {
        char cCharAt;
        String string = charSequence.toString();
        try {
            if (charSequence.length() > 0 && (((cCharAt = charSequence.charAt(charSequence.length() - 1)) == 'f' || cCharAt == 'F') && charSequence.charAt(charSequence.length() - 2) != 'N')) {
                StringBuffer stringBuffer = new StringBuffer("Invalid char '");
                stringBuffer.append(cCharAt);
                stringBuffer.append("' in float.");
                throw new NumberFormatException(stringBuffer.toString());
            }
            return Float.parseFloat(string);
        } catch (NumberFormatException e) {
            if (string.equals(POS_INF_LEX)) {
                return Float.POSITIVE_INFINITY;
            }
            if (string.equals(NEG_INF_LEX)) {
                return Float.NEGATIVE_INFINITY;
            }
            if (string.equals(NAN_LEX)) {
                return Float.NaN;
            }
            throw e;
        }
    }

    public static GDate lexGDate(CharSequence charSequence) {
        return new GDate(charSequence);
    }

    public static byte[] lexHexBinary(CharSequence charSequence) {
        byte[] bArrDecode = HexBin.decode(charSequence.toString().getBytes());
        if (bArrDecode != null) {
            return bArrDecode;
        }
        throw new InvalidLexicalValueException("invalid hexBinary value");
    }

    public static int lexInt(CharSequence charSequence) {
        return parseInt(charSequence);
    }

    public static BigInteger lexInteger(CharSequence charSequence) {
        if (charSequence.length() > 1 && charSequence.charAt(0) == '+' && charSequence.charAt(1) == '-') {
            throw new NumberFormatException("Illegal char sequence '+-'");
        }
        return new BigInteger(trimInitialPlus(charSequence.toString()));
    }

    public static long lexLong(CharSequence charSequence) {
        return Long.parseLong(trimInitialPlus(charSequence.toString()));
    }

    public static QName lexQName(CharSequence charSequence, NamespaceContext namespaceContext) {
        String str;
        String string;
        String string2;
        int i = 0;
        while (true) {
            str = "";
            if (i >= charSequence.length()) {
                string = charSequence.toString();
                string2 = "";
                break;
            }
            if (charSequence.charAt(i) == ':') {
                string2 = charSequence.subSequence(0, i).toString();
                string = charSequence.subSequence(i + 1, charSequence.length()).toString();
                if (i == 0) {
                    StringBuffer stringBuffer = new StringBuffer("invalid xsd:QName '");
                    stringBuffer.append(charSequence.toString());
                    stringBuffer.append("'");
                    throw new InvalidLexicalValueException(stringBuffer.toString());
                }
            } else {
                i++;
            }
        }
        String namespaceURI = namespaceContext.getNamespaceURI(string2);
        if (namespaceURI != null) {
            str = namespaceURI;
        } else if (string2 != null && string2.length() > 0) {
            throw new InvalidLexicalValueException("Can't resolve prefix: ".concat(string2));
        }
        return new QName(str, string);
    }

    public static short lexShort(CharSequence charSequence) {
        return parseShort(charSequence);
    }

    public static String lexString(CharSequence charSequence, Collection collection) {
        return charSequence.toString();
    }

    private static byte parseByte(CharSequence charSequence) {
        return (byte) parseIntXsdNumber(charSequence, -128, 127);
    }

    private static int parseInt(CharSequence charSequence) {
        return parseIntXsdNumber(charSequence, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static int parseIntXsdNumber(CharSequence charSequence, int i, int i2) {
        int i4;
        int i5;
        int i6;
        int length = charSequence.length();
        int i7 = 1;
        if (length < 1) {
            StringBuffer stringBuffer = new StringBuffer("For input string: \"");
            stringBuffer.append(charSequence.toString());
            stringBuffer.append("\"");
            throw new NumberFormatException(stringBuffer.toString());
        }
        char cCharAt = charSequence.charAt(0);
        if (cCharAt == '-') {
            i4 = i / 10;
            i5 = -(i % 10);
            i6 = 1;
        } else {
            if (cCharAt == '+') {
                int i8 = -(i2 / 10);
                int i9 = i2 % 10;
                i4 = i8;
                i5 = i9;
                i6 = 1;
            } else {
                int i10 = -(i2 / 10);
                int i11 = i2 % 10;
                i4 = i10;
                i5 = i11;
                i6 = 0;
            }
            i7 = -1;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < length - i6; i13++) {
            int iDigit = Character.digit(charSequence.charAt(i13 + i6), 10);
            if (iDigit < 0) {
                StringBuffer stringBuffer2 = new StringBuffer("For input string: \"");
                stringBuffer2.append(charSequence.toString());
                stringBuffer2.append("\"");
                throw new NumberFormatException(stringBuffer2.toString());
            }
            if (i12 < i4 || (i12 == i4 && iDigit > i5)) {
                StringBuffer stringBuffer3 = new StringBuffer("For input string: \"");
                stringBuffer3.append(charSequence.toString());
                stringBuffer3.append("\"");
                throw new NumberFormatException(stringBuffer3.toString());
            }
            i12 = (i12 * 10) - iDigit;
        }
        return i7 * i12;
    }

    private static short parseShort(CharSequence charSequence) {
        return (short) parseIntXsdNumber(charSequence, -32768, LayoutKt.LargeDimension);
    }

    public static CharSequence printBase64Binary(byte[] bArr) {
        return new String(Base64.encode(bArr));
    }

    public static String printBoolean(boolean z) {
        return z ? "true" : "false";
    }

    public static String printByte(byte b) {
        return Byte.toString(b);
    }

    public static String printDate(Calendar calendar) {
        return printDateTime(calendar, 16);
    }

    public static String printDateTime(Calendar calendar) {
        return printDateTime(calendar, 14);
    }

    public static String printDecimal(BigDecimal bigDecimal) {
        char[] cArr;
        char[] cArr2;
        String string = bigDecimal.unscaledValue().toString();
        int iScale = bigDecimal.scale();
        if (iScale == 0 || (bigDecimal.longValue() == 0 && iScale < 0)) {
            return string;
        }
        int i = bigDecimal.signum() < 0 ? 1 : 0;
        StringBuffer stringBuffer = new StringBuffer(Math.abs(iScale) + string.length() + 1);
        if (i == 1) {
            stringBuffer.append('-');
        }
        if (iScale > 0) {
            int length = iScale - (string.length() - i);
            if (length >= 0) {
                stringBuffer.append("0.");
                while (true) {
                    cArr2 = CH_ZEROS;
                    if (length <= cArr2.length) {
                        break;
                    }
                    stringBuffer.append(cArr2);
                    length -= cArr2.length;
                }
                stringBuffer.append(cArr2, 0, length);
                stringBuffer.append(string.substring(i));
            } else {
                int i2 = i - length;
                stringBuffer.append(string.substring(i, i2));
                stringBuffer.append('.');
                stringBuffer.append(string.substring(i2));
            }
        } else {
            stringBuffer.append(string.substring(i));
            while (true) {
                cArr = CH_ZEROS;
                if (iScale >= (-cArr.length)) {
                    break;
                }
                stringBuffer.append(cArr);
                iScale += cArr.length;
            }
            stringBuffer.append(cArr, 0, -iScale);
        }
        return stringBuffer.toString();
    }

    public static String printDouble(double d) {
        return d == Double.POSITIVE_INFINITY ? POS_INF_LEX : d == Double.NEGATIVE_INFINITY ? NEG_INF_LEX : Double.isNaN(d) ? NAN_LEX : Double.toString(d);
    }

    public static String printFloat(float f) {
        return f == Float.POSITIVE_INFINITY ? POS_INF_LEX : f == Float.NEGATIVE_INFINITY ? NEG_INF_LEX : Float.isNaN(f) ? NAN_LEX : Float.toString(f);
    }

    public static String printGDate(GDate gDate, Collection collection) {
        return gDate.toString();
    }

    public static CharSequence printHexBinary(byte[] bArr) {
        return HexBin.bytesToString(bArr);
    }

    public static String printInt(int i) {
        return Integer.toString(i);
    }

    public static String printInteger(BigInteger bigInteger) {
        return bigInteger.toString();
    }

    public static String printLong(long j) {
        return Long.toString(j);
    }

    public static String printQName(QName qName, NamespaceContext namespaceContext, Collection collection) {
        String prefix;
        String namespaceURI = qName.getNamespaceURI();
        if (!$assertionsDisabled && namespaceURI == null) {
            throw new AssertionError();
        }
        if (namespaceURI.length() > 0) {
            prefix = namespaceContext.getPrefix(namespaceURI);
            if (prefix == null) {
                collection.add(XmlError.forMessage("NamespaceContext does not provide prefix for namespaceURI ".concat(namespaceURI)));
            }
        } else {
            prefix = null;
        }
        return getQNameString(namespaceURI, qName.getLocalPart(), prefix);
    }

    public static String printShort(short s) {
        return Short.toString(s);
    }

    public static String printTime(Calendar calendar) {
        return printDateTime(calendar, 15);
    }

    private static String trimInitialPlus(String str) {
        return (str.length() <= 0 || str.charAt(0) != '+') ? str : str.substring(1);
    }

    private static String trimTrailingZeros(String str) {
        int iLastIndexOf;
        int length = str.length() - 1;
        if (str.charAt(length) != '0' || (iLastIndexOf = str.lastIndexOf(46)) < 0) {
            return str;
        }
        while (length > iLastIndexOf) {
            if (str.charAt(length) != '0') {
                return str.substring(0, length + 1);
            }
            length--;
        }
        return str.substring(0, iLastIndexOf);
    }

    public static byte lexByte(CharSequence charSequence, Collection collection) {
        try {
            return lexByte(charSequence);
        } catch (NumberFormatException unused) {
            StringBuffer stringBuffer = new StringBuffer("invalid byte: ");
            stringBuffer.append((Object) charSequence);
            collection.add(XmlError.forMessage(stringBuffer.toString()));
            return (byte) 0;
        }
    }

    public static GDate lexGDate(String str, Collection collection) {
        try {
            return lexGDate(str);
        } catch (IllegalArgumentException e) {
            collection.add(XmlError.forMessage(e.getMessage()));
            return new GDateBuilder().toGDate();
        }
    }

    public static int lexInt(CharSequence charSequence, Collection collection) {
        try {
            return lexInt(charSequence);
        } catch (NumberFormatException unused) {
            StringBuffer stringBuffer = new StringBuffer("invalid int:");
            stringBuffer.append((Object) charSequence);
            collection.add(XmlError.forMessage(stringBuffer.toString()));
            return 0;
        }
    }

    public static short lexShort(CharSequence charSequence, Collection collection) {
        try {
            return lexShort(charSequence);
        } catch (NumberFormatException unused) {
            StringBuffer stringBuffer = new StringBuffer("invalid short: ");
            stringBuffer.append((Object) charSequence);
            collection.add(XmlError.forMessage(stringBuffer.toString()));
            return (short) 0;
        }
    }

    public static String lexString(CharSequence charSequence) {
        return charSequence.toString();
    }

    public static String printDate(Date date) {
        return getGDateValue(date, 16).toString();
    }

    public static String printDateTime(Calendar calendar, int i) {
        return getGDateValue(calendar, i).toString();
    }

    public static BigDecimal lexDecimal(CharSequence charSequence, Collection collection) {
        try {
            return lexDecimal(charSequence);
        } catch (NumberFormatException unused) {
            StringBuffer stringBuffer = new StringBuffer("invalid long: ");
            stringBuffer.append((Object) charSequence);
            collection.add(XmlError.forMessage(stringBuffer.toString()));
            return DECIMAL__ZERO;
        }
    }

    public static long lexLong(CharSequence charSequence, Collection collection) {
        try {
            return lexLong(charSequence);
        } catch (NumberFormatException unused) {
            StringBuffer stringBuffer = new StringBuffer("invalid long: ");
            stringBuffer.append((Object) charSequence);
            collection.add(XmlError.forMessage(stringBuffer.toString()));
            return 0L;
        }
    }

    public static GDateSpecification getGDateValue(Calendar calendar, int i) {
        GDateBuilder gDateBuilder = new GDateBuilder(calendar);
        gDateBuilder.setBuiltinTypeCode(i);
        return gDateBuilder.toGDate();
    }

    public static String printDateTime(Date date) {
        return getGDateValue(date, 14).toString();
    }

    public static BigInteger lexInteger(CharSequence charSequence, Collection collection) {
        try {
            return lexInteger(charSequence);
        } catch (NumberFormatException unused) {
            StringBuffer stringBuffer = new StringBuffer("invalid long: ");
            stringBuffer.append((Object) charSequence);
            collection.add(XmlError.forMessage(stringBuffer.toString()));
            return BigInteger.ZERO;
        }
    }

    public static GDateSpecification getGDateValue(CharSequence charSequence, int i) {
        GDateBuilder gDateBuilder = new GDateBuilder(charSequence);
        gDateBuilder.setBuiltinTypeCode(i);
        return gDateBuilder.toGDate();
    }

    public static boolean lexBoolean(CharSequence charSequence, Collection collection) {
        try {
            return lexBoolean(charSequence);
        } catch (InvalidLexicalValueException e) {
            collection.add(XmlError.forMessage(e.getMessage()));
            return false;
        }
    }

    public static double lexDouble(CharSequence charSequence, Collection collection) {
        try {
            return lexDouble(charSequence);
        } catch (NumberFormatException unused) {
            StringBuffer stringBuffer = new StringBuffer("invalid double: ");
            stringBuffer.append((Object) charSequence);
            collection.add(XmlError.forMessage(stringBuffer.toString()));
            return Double.NaN;
        }
    }

    public static float lexFloat(CharSequence charSequence, Collection collection) {
        try {
            return lexFloat(charSequence);
        } catch (NumberFormatException unused) {
            StringBuffer stringBuffer = new StringBuffer("invalid float: ");
            stringBuffer.append((Object) charSequence);
            collection.add(XmlError.forMessage(stringBuffer.toString()));
            return Float.NaN;
        }
    }

    public static QName lexQName(String str, Collection collection, NamespaceContext namespaceContext) {
        try {
            return lexQName(str, namespaceContext);
        } catch (InvalidLexicalValueException e) {
            collection.add(XmlError.forMessage(e.getMessage()));
            return new QName(null, str.substring(str.indexOf(58)));
        }
    }

    public static CharSequence printAnyURI(CharSequence charSequence) {
        return charSequence;
    }

    public static String printString(String str) {
        return str;
    }
}
