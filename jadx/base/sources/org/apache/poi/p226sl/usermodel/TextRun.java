package org.apache.poi.p226sl.usermodel;

import org.apache.poi.common.usermodel.fonts.FontGroup;
import org.apache.poi.common.usermodel.fonts.FontInfo;
import org.apache.poi.java.awt.Color;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface TextRun {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum FieldType {
        SLIDE_NUMBER,
        DATE_TIME
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TextCap {
        NONE,
        SMALL,
        ALL
    }

    Hyperlink<?, ?> createHyperlink();

    @Internal
    FieldType getFieldType();

    PaintStyle getFontColor();

    String getFontFamily();

    String getFontFamily(FontGroup fontGroup);

    FontInfo getFontInfo(FontGroup fontGroup);

    Double getFontSize();

    Hyperlink<?, ?> getHyperlink();

    byte getPitchAndFamily();

    String getRawText();

    TextCap getTextCap();

    boolean isBold();

    boolean isItalic();

    boolean isStrikethrough();

    boolean isSubscript();

    boolean isSuperscript();

    boolean isUnderlined();

    void setBold(boolean z);

    void setFontColor(Color color);

    void setFontColor(PaintStyle paintStyle);

    void setFontFamily(String str);

    void setFontFamily(String str, FontGroup fontGroup);

    void setFontInfo(FontInfo fontInfo, FontGroup fontGroup);

    void setFontSize(Double d);

    void setItalic(boolean z);

    void setStrikethrough(boolean z);

    void setText(String str);

    void setUnderlined(boolean z);
}
