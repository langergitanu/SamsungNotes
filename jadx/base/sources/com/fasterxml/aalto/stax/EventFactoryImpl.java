package com.fasterxml.aalto.stax;

import org.apache.poi.javax.xml.namespace.QName;
import org.codehaus.stax2.p230ri.Stax2EventFactoryImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class EventFactoryImpl extends Stax2EventFactoryImpl {
    @Override // org.codehaus.stax2.p230ri.Stax2EventFactoryImpl
    public QName createQName(String str, String str2) {
        return new QName(str, str2);
    }

    @Override // org.codehaus.stax2.p230ri.Stax2EventFactoryImpl
    public QName createQName(String str, String str2, String str3) {
        return new QName(str, str2, str3);
    }
}
