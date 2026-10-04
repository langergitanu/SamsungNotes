package com.adobe.internal.xmp.impl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class QName {
    private String localName;
    private String prefix;

    public QName(String str) {
        int iIndexOf = str.indexOf(58);
        if (iIndexOf >= 0) {
            this.prefix = str.substring(0, iIndexOf);
            this.localName = str.substring(iIndexOf + 1);
        } else {
            this.prefix = "";
            this.localName = str;
        }
    }

    public String getLocalName() {
        return this.localName;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public boolean hasPrefix() {
        String str = this.prefix;
        return str != null && str.length() > 0;
    }

    public QName(String str, String str2) {
        this.prefix = str;
        this.localName = str2;
    }
}
