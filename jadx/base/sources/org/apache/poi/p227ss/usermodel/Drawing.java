package org.apache.poi.p227ss.usermodel;

import org.apache.poi.p227ss.usermodel.Shape;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface Drawing<T extends Shape> extends ShapeContainer<T> {
    ClientAnchor createAnchor(int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9);

    Comment createCellComment(ClientAnchor clientAnchor);

    Chart createChart(ClientAnchor clientAnchor);

    ObjectData createObjectData(ClientAnchor clientAnchor, int i, int i2);

    Picture createPicture(ClientAnchor clientAnchor, int i);
}
