package org.apache.poi.xslf.model;

import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class TextBodyPropertyFetcher<T> extends PropertyFetcher<T> {
    @Override // org.apache.poi.xslf.model.PropertyFetcher
    public boolean fetch(XSLFShape xSLFShape) {
        XmlObject[] xmlObjectArrSelectPath = xSLFShape.getXmlObject().selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//p:txBody/a:bodyPr");
        if (xmlObjectArrSelectPath.length == 1) {
            return fetch((CTTextBodyProperties) xmlObjectArrSelectPath[0]);
        }
        return false;
    }

    public abstract boolean fetch(CTTextBodyProperties cTTextBodyProperties);
}
