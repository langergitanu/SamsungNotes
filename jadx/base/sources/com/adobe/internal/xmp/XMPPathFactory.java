package com.adobe.internal.xmp;

import androidx.appcompat.widget.AbstractC0541b;
import com.adobe.internal.xmp.impl.Utils;
import com.adobe.internal.xmp.impl.xpath.XMPPath;
import com.adobe.internal.xmp.impl.xpath.XMPPathParser;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class XMPPathFactory {
    private XMPPathFactory() {
    }

    private static void assertFieldNS(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty field namespace URI", 101);
        }
    }

    private static void assertFieldName(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty f name", 102);
        }
    }

    private static void assertQualNS(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty qualifier namespace URI", 101);
        }
    }

    private static void assertQualName(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty qualifier name", 102);
        }
    }

    public static String composeArrayItemPath(String str, int i) throws XMPException {
        if (i <= 0) {
            if (i == -1) {
                return AbstractC0541b.m756B(str, "[last()]");
            }
            throw new XMPException("Array index must be larger than zero", 104);
        }
        return str + PropertyUtils.INDEXED_DELIM + i + PropertyUtils.INDEXED_DELIM2;
    }

    public static String composeFieldSelector(String str, String str2, String str3, String str4) throws XMPException {
        XMPPath xMPPathExpandXPath = XMPPathParser.expandXPath(str2, str3);
        if (xMPPathExpandXPath.size() != 2) {
            throw new XMPException("The fieldName name must be simple", 102);
        }
        return str + PropertyUtils.INDEXED_DELIM + xMPPathExpandXPath.getSegment(1).getName() + "=\"" + str4 + "\"]";
    }

    public static String composeLangSelector(String str, String str2) {
        StringBuilder sbM781w = AbstractC0541b.m781w(str, "[?xml:lang=\"");
        sbM781w.append(Utils.normalizeLangValue(str2));
        sbM781w.append("\"]");
        return sbM781w.toString();
    }

    public static String composeQualifierPath(String str, String str2) throws XMPException {
        assertQualNS(str);
        assertQualName(str2);
        XMPPath xMPPathExpandXPath = XMPPathParser.expandXPath(str, str2);
        if (xMPPathExpandXPath.size() != 2) {
            throw new XMPException("The qualifier name must be simple", 102);
        }
        return "/?" + xMPPathExpandXPath.getSegment(1).getName();
    }

    public static String composeStructFieldPath(String str, String str2) throws XMPException {
        assertFieldNS(str);
        assertFieldName(str2);
        XMPPath xMPPathExpandXPath = XMPPathParser.expandXPath(str, str2);
        if (xMPPathExpandXPath.size() != 2) {
            throw new XMPException("The field name must be simple", 102);
        }
        return "/" + xMPPathExpandXPath.getSegment(1).getName();
    }
}
