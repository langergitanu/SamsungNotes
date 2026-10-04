package com.adobe.internal.xmp;

import com.adobe.internal.xmp.impl.Base64;
import com.adobe.internal.xmp.impl.ISO8601Converter;
import com.adobe.internal.xmp.impl.XMPUtilsImpl;
import com.adobe.internal.xmp.options.PropertyOptions;
import com.adobe.internal.xmp.options.TemplateOptions;
import org.apache.commons.lang3.BooleanUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class XMPUtils {
    private XMPUtils() {
    }

    public static void appendProperties(XMPMeta xMPMeta, XMPMeta xMPMeta2, boolean z, boolean z2) {
        appendProperties(xMPMeta, xMPMeta2, z, z2, false);
    }

    public static void applyTemplate(XMPMeta xMPMeta, XMPMeta xMPMeta2, TemplateOptions templateOptions) {
        XMPUtilsImpl.applyTemplate(xMPMeta, xMPMeta2, templateOptions);
    }

    public static String catenateArrayItems(XMPMeta xMPMeta, String str, String str2, String str3, String str4, boolean z) {
        return XMPUtilsImpl.catenateArrayItems(xMPMeta, str, str2, str3, str4, z);
    }

    public static String convertFromBoolean(boolean z) {
        return z ? XMPConst.TRUESTR : XMPConst.FALSESTR;
    }

    public static String convertFromDate(XMPDateTime xMPDateTime) {
        return ISO8601Converter.render(xMPDateTime);
    }

    public static String convertFromDouble(double d) {
        return String.valueOf(d);
    }

    public static String convertFromInteger(int i) {
        return String.valueOf(i);
    }

    public static String convertFromLong(long j) {
        return String.valueOf(j);
    }

    public static boolean convertToBoolean(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty convert-string", 5);
        }
        String lowerCase = str.toLowerCase();
        try {
            return Integer.parseInt(lowerCase) != 0;
        } catch (NumberFormatException unused) {
            return "true".equals(lowerCase) || "t".equals(lowerCase) || "on".equals(lowerCase) || BooleanUtils.YES.equals(lowerCase);
        }
    }

    public static XMPDateTime convertToDate(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty convert-string", 5);
        }
        return ISO8601Converter.parse(str);
    }

    public static double convertToDouble(String str) throws XMPException {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    return Double.parseDouble(str);
                }
            } catch (NumberFormatException unused) {
                throw new XMPException("Invalid double string", 5);
            }
        }
        throw new XMPException("Empty convert-string", 5);
    }

    public static int convertToInteger(String str) throws XMPException {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    return str.startsWith("0x") ? Integer.parseInt(str.substring(2), 16) : Integer.parseInt(str);
                }
            } catch (NumberFormatException unused) {
                throw new XMPException("Invalid integer string", 5);
            }
        }
        throw new XMPException("Empty convert-string", 5);
    }

    public static long convertToLong(String str) throws XMPException {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    return str.startsWith("0x") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
                }
            } catch (NumberFormatException unused) {
                throw new XMPException("Invalid long string", 5);
            }
        }
        throw new XMPException("Empty convert-string", 5);
    }

    public static byte[] decodeBase64(String str) throws XMPException {
        try {
            return Base64.decode(str.getBytes());
        } catch (Throwable th) {
            throw new XMPException("Invalid base64 string", 5, th);
        }
    }

    public static void duplicateSubtree(XMPMeta xMPMeta, XMPMeta xMPMeta2, String str, String str2, String str3, String str4, PropertyOptions propertyOptions) {
        XMPUtilsImpl.duplicateSubtree(xMPMeta, xMPMeta2, str, str2, str3, str4, propertyOptions);
    }

    public static String encodeBase64(byte[] bArr) {
        return new String(Base64.encode(bArr));
    }

    public static void mergeFromJPEG(XMPMeta xMPMeta, XMPMeta xMPMeta2) {
        XMPUtilsImpl.mergeFromJPEG(xMPMeta, xMPMeta2);
    }

    public static void packageForJPEG(XMPMeta xMPMeta, StringBuilder sb, StringBuilder sb2, StringBuilder sb3) {
        XMPUtilsImpl.packageForJPEG(xMPMeta, sb, sb2, sb3);
    }

    public static void removeProperties(XMPMeta xMPMeta, String str, String str2, boolean z, boolean z2) {
        XMPUtilsImpl.removeProperties(xMPMeta, str, str2, z, z2);
    }

    public static void separateArrayItems(XMPMeta xMPMeta, String str, String str2, String str3, PropertyOptions propertyOptions, boolean z) {
        XMPUtilsImpl.separateArrayItems(xMPMeta, str, str2, str3, propertyOptions, z);
    }

    public static void appendProperties(XMPMeta xMPMeta, XMPMeta xMPMeta2, boolean z, boolean z2, boolean z3) {
        XMPUtilsImpl.appendProperties(xMPMeta, xMPMeta2, z, z2, z3);
    }
}
