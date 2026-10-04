package org.apache.poi.xslf.usermodel;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLFactory;
import org.apache.poi.POIXMLRelation;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class XSLFFactory extends POIXMLFactory {
    private static final XSLFFactory inst = new XSLFFactory();

    private XSLFFactory() {
    }

    public static XSLFFactory getInstance() {
        return inst;
    }

    @Override // org.apache.poi.POIXMLFactory
    public POIXMLDocumentPart createDocumentPart(Class<? extends POIXMLDocumentPart> cls, Class<?>[] clsArr, Object[] objArr) {
        return cls.getDeclaredConstructor(clsArr).newInstance(objArr);
    }

    @Override // org.apache.poi.POIXMLFactory
    public POIXMLRelation getDescriptor(String str) {
        return XSLFRelation.getInstance(str);
    }
}
