package org.apache.poi.p226sl.usermodel;

import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.p226sl.usermodel.Shape;
import org.apache.poi.p226sl.usermodel.TextParagraph;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface PlaceableShape<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> {
    Rectangle2D getAnchor();

    boolean getFlipHorizontal();

    boolean getFlipVertical();

    ShapeContainer<S, P> getParent();

    double getRotation();

    Sheet<S, P> getSheet();

    void setAnchor(Rectangle2D rectangle2D);

    void setFlipHorizontal(boolean z);

    void setFlipVertical(boolean z);

    void setRotation(double d);
}
