package org.apache.xmlbeans.impl.store;

import org.apache.poi.javax.xml.namespace.QName;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface QNameFactory {
    QName getQName(String str, String str2);

    QName getQName(String str, String str2, String str3);

    QName getQName(char[] cArr, int i, int i2, char[] cArr2, int i4, int i5);

    QName getQName(char[] cArr, int i, int i2, char[] cArr2, int i4, int i5, char[] cArr3, int i6, int i7);
}
