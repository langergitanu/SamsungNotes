package org.apache.poi.p226sl.usermodel;

import org.apache.poi.java.awt.Color;
import org.apache.poi.p226sl.draw.geom.IAdjustableShape;
import org.apache.poi.p226sl.usermodel.Shape;
import org.apache.poi.p226sl.usermodel.TextParagraph;
import org.apache.poi.sl.draw.geom.CustomGeometry;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface SimpleShape<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends Shape<S, P>, IAdjustableShape, PlaceableShape<S, P> {
    Hyperlink<S, P> createHyperlink();

    Color getFillColor();

    FillStyle getFillStyle();

    CustomGeometry getGeometry();

    Hyperlink<S, P> getHyperlink();

    LineDecoration getLineDecoration();

    Placeholder getPlaceholder();

    Shadow<S, P> getShadow();

    ShapeType getShapeType();

    StrokeStyle getStrokeStyle();

    void setFillColor(Color color);

    void setPlaceholder(Placeholder placeholder);

    void setShapeType(ShapeType shapeType);

    void setStrokeStyle(Object... objArr);
}
