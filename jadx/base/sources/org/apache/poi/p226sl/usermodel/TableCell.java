package org.apache.poi.p226sl.usermodel;

import org.apache.poi.java.awt.Color;
import org.apache.poi.p226sl.usermodel.Shape;
import org.apache.poi.p226sl.usermodel.StrokeStyle;
import org.apache.poi.p226sl.usermodel.TextParagraph;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface TableCell<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends TextShape<S, P> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum BorderEdge {
        bottom,
        left,
        top,
        right
    }

    StrokeStyle getBorderStyle(BorderEdge borderEdge);

    int getGridSpan();

    int getRowSpan();

    boolean isMerged();

    void removeBorder(BorderEdge borderEdge);

    void setBorderColor(BorderEdge borderEdge, Color color);

    void setBorderCompound(BorderEdge borderEdge, StrokeStyle.LineCompound lineCompound);

    void setBorderDash(BorderEdge borderEdge, StrokeStyle.LineDash lineDash);

    void setBorderStyle(BorderEdge borderEdge, StrokeStyle strokeStyle);

    void setBorderWidth(BorderEdge borderEdge, double d);
}
