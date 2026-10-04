package com.adobe.internal.xmp;

import com.adobe.internal.xmp.properties.XMPAliasInfo;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface XMPSchemaRegistry {
    void deleteNamespace(String str);

    XMPAliasInfo findAlias(String str);

    XMPAliasInfo[] findAliases(String str);

    Map getAliases();

    String getNamespacePrefix(String str);

    String getNamespaceURI(String str);

    Map getNamespaces();

    Map getPrefixes();

    String registerNamespace(String str, String str2);

    XMPAliasInfo resolveAlias(String str, String str2);
}
