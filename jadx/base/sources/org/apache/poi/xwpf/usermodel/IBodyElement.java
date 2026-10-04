package org.apache.poi.xwpf.usermodel;

import org.apache.poi.POIXMLDocumentPart;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface IBodyElement {
    IBody getBody();

    BodyElementType getElementType();

    POIXMLDocumentPart getPart();

    BodyType getPartType();
}
