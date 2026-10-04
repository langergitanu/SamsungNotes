package org.apache.xmlbeans;

import java.util.Hashtable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SystemProperties {
    protected static Hashtable propertyH;

    public static String getProperty(String str) {
        if (propertyH == null) {
            try {
                propertyH = System.getProperties();
            } catch (SecurityException unused) {
                propertyH = new Hashtable();
                return null;
            }
        }
        return (String) propertyH.get(str);
    }

    public static void setPropertyH(Hashtable hashtable) {
        propertyH = hashtable;
    }

    public static String getProperty(String str, String str2) {
        String property = getProperty(str);
        return property == null ? str2 : property;
    }
}
