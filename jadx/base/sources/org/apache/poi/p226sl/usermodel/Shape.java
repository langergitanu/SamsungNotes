package org.apache.poi.p226sl.usermodel;

import org.apache.poi.java.awt.Graphics2D;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.p226sl.usermodel.Shape;
import org.apache.poi.p226sl.usermodel.TextParagraph;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface Shape<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> {
    void draw(Graphics2D graphics2D, Rectangle2D rectangle2D);

    Rectangle2D getAnchor();

    ShapeContainer<S, P> getParent();

    Sheet<S, P> getSheet();
}
