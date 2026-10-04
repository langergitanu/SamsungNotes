package org.apache.xmlbeans;

import org.apache.poi.javax.xml.namespace.QName;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BindingConfig {
    private static final InterfaceExtension[] EMPTY_INTERFACE_EXT_ARRAY = new InterfaceExtension[0];
    private static final PrePostExtension[] EMPTY_PREPOST_EXT_ARRAY = new PrePostExtension[0];
    private static final UserType[] EMPTY_USER_TYPE_ARRY = new UserType[0];
    public static final int QNAME_ACCESSOR_ATTRIBUTE = 4;
    public static final int QNAME_ACCESSOR_ELEMENT = 3;
    public static final int QNAME_DOCUMENT_TYPE = 2;
    public static final int QNAME_TYPE = 1;

    public InterfaceExtension[] getInterfaceExtensions() {
        return EMPTY_INTERFACE_EXT_ARRAY;
    }

    public PrePostExtension getPrePostExtension(String str) {
        return null;
    }

    public PrePostExtension[] getPrePostExtensions() {
        return EMPTY_PREPOST_EXT_ARRAY;
    }

    public UserType[] getUserTypes() {
        return EMPTY_USER_TYPE_ARRY;
    }

    public String lookupJavanameForQName(QName qName) {
        return null;
    }

    public String lookupPackageForNamespace(String str) {
        return null;
    }

    public String lookupPrefixForNamespace(String str) {
        return null;
    }

    public String lookupSuffixForNamespace(String str) {
        return null;
    }

    public UserType lookupUserTypeForQName(QName qName) {
        return null;
    }

    public InterfaceExtension[] getInterfaceExtensions(String str) {
        return EMPTY_INTERFACE_EXT_ARRAY;
    }

    public String lookupJavanameForQName(QName qName, int i) {
        return null;
    }
}
