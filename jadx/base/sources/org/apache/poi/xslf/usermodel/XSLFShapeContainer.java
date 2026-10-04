package org.apache.poi.xslf.usermodel;

import org.apache.poi.p226sl.usermodel.PictureData;
import org.apache.poi.p226sl.usermodel.ShapeContainer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface XSLFShapeContainer extends ShapeContainer<XSLFShape, XSLFTextParagraph> {
    void clear();

    @Override // org.apache.poi.p226sl.usermodel.ShapeContainer
    XSLFAutoShape createAutoShape();

    @Override // org.apache.poi.p226sl.usermodel.ShapeContainer
    XSLFConnectorShape createConnector();

    @Override // org.apache.poi.p226sl.usermodel.ShapeContainer
    XSLFFreeformShape createFreeform();

    @Override // org.apache.poi.p226sl.usermodel.ShapeContainer
    XSLFGroupShape createGroup();

    @Override // org.apache.poi.p226sl.usermodel.ShapeContainer
    XSLFPictureShape createPicture(PictureData pictureData);

    @Override // org.apache.poi.p226sl.usermodel.ShapeContainer
    XSLFTextBox createTextBox();
}
