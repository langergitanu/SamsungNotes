package org.apache.poi.p226sl.usermodel;

import java.util.List;
import org.apache.poi.java.awt.Color;
import org.apache.poi.p226sl.usermodel.Shape;
import org.apache.poi.p226sl.usermodel.TextParagraph;
import org.apache.poi.p226sl.usermodel.TextRun;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface TextParagraph<S extends Shape<S, P>, P extends TextParagraph<S, P, T>, T extends TextRun> extends Iterable<T> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface BulletStyle {
        AutoNumberingScheme getAutoNumberingScheme();

        Integer getAutoNumberingStartAt();

        String getBulletCharacter();

        String getBulletFont();

        PaintStyle getBulletFontColor();

        Double getBulletFontSize();

        void setBulletFontColor(Color color);

        void setBulletFontColor(PaintStyle paintStyle);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum FontAlign {
        AUTO,
        TOP,
        CENTER,
        BASELINE,
        BOTTOM
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TextAlign {
        LEFT,
        CENTER,
        RIGHT,
        JUSTIFY,
        JUSTIFY_LOW,
        DIST,
        THAI_DIST
    }

    BulletStyle getBulletStyle();

    String getDefaultFontFamily();

    Double getDefaultFontSize();

    Double getDefaultTabSize();

    FontAlign getFontAlign();

    Double getIndent();

    int getIndentLevel();

    Double getLeftMargin();

    Double getLineSpacing();

    TextShape<S, P> getParentShape();

    Double getRightMargin();

    Double getSpaceAfter();

    Double getSpaceBefore();

    TextAlign getTextAlign();

    List<T> getTextRuns();

    boolean isHeaderOrFooter();

    void setBulletStyle(Object... objArr);

    void setIndent(Double d);

    void setIndentLevel(int i);

    void setLeftMargin(Double d);

    void setLineSpacing(Double d);

    void setRightMargin(Double d);

    void setSpaceAfter(Double d);

    void setSpaceBefore(Double d);

    void setTextAlign(TextAlign textAlign);
}
