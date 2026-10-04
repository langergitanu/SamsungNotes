package org.apache.poi.p227ss.usermodel;

import org.apache.poi.java.awt.Dimension;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface Picture extends Shape {
    ClientAnchor getClientAnchor();

    Dimension getImageDimension();

    PictureData getPictureData();

    ClientAnchor getPreferredSize();

    ClientAnchor getPreferredSize(double d, double d2);

    Sheet getSheet();

    void resize();

    void resize(double d);

    void resize(double d, double d2);
}
