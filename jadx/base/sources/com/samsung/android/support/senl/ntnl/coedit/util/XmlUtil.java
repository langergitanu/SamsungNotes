package com.samsung.android.support.senl.ntnl.coedit.util;

import com.samsung.android.support.senl.ntnl.coedit.common.raw.Element;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class XmlUtil {
    private static native int XmlUtil_checkXmlDocument(String str, boolean z);

    private static native List<Element> XmlUtil_getElement(String str);

    private static native String XmlUtil_getXmlString(List<Element> list);

    public static int checkXmlDocument(String str) {
        return XmlUtil_checkXmlDocument(str, true);
    }

    public static List<Element> getElement(String str) {
        return XmlUtil_getElement(str);
    }

    public static String getXmlString(List<Element> list) {
        return XmlUtil_getXmlString(list);
    }

    public static int checkXmlDocument(String str, boolean z) {
        return XmlUtil_checkXmlDocument(str, z);
    }
}
