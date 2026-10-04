package org.apache.poi.p227ss.usermodel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface Shape {
    ChildAnchor getAnchor();

    Shape getParent();

    String getShapeName();

    boolean isNoFill();

    void setFillColor(int i, int i2, int i4);

    void setLineStyleColor(int i, int i2, int i4);

    void setNoFill(boolean z);
}
