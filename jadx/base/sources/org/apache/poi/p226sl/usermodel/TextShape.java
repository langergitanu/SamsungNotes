package org.apache.poi.p226sl.usermodel;

import java.util.List;
import org.apache.poi.java.awt.Graphics2D;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.p226sl.usermodel.Shape;
import org.apache.poi.p226sl.usermodel.TextParagraph;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface TextShape<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends SimpleShape<S, P>, Iterable<P> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TextAutofit {
        NONE,
        NORMAL,
        SHAPE
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TextDirection {
        HORIZONTAL,
        VERTICAL,
        VERTICAL_270,
        STACKED
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TextPlaceholder {
        TITLE,
        BODY,
        CENTER_TITLE,
        CENTER_BODY,
        HALF_BODY,
        QUARTER_BODY,
        NOTES,
        OTHER
    }

    TextRun appendText(String str, boolean z);

    Insets2D getInsets();

    String getText();

    TextDirection getTextDirection();

    double getTextHeight();

    double getTextHeight(Graphics2D graphics2D);

    List<? extends TextParagraph<S, P, ?>> getTextParagraphs();

    TextPlaceholder getTextPlaceholder();

    Double getTextRotation();

    VerticalAlignment getVerticalAlignment();

    boolean getWordWrap();

    boolean isHorizontalCentered();

    Rectangle2D resizeToFitText();

    Rectangle2D resizeToFitText(Graphics2D graphics2D);

    void setHorizontalCentered(Boolean bool);

    void setInsets(Insets2D insets2D);

    TextRun setText(String str);

    void setTextDirection(TextDirection textDirection);

    void setTextPlaceholder(TextPlaceholder textPlaceholder);

    void setTextRotation(Double d);

    void setVerticalAlignment(VerticalAlignment verticalAlignment);

    void setWordWrap(boolean z);
}
