package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common;

import com.samsung.android.support.senl.p145cm.base.framework.support.ColorCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0005J\u000e\u0010,\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u0012J\u000e\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0012J\u000e\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\u0012J\u0006\u00102\u001a\u00020\u0007J\u000e\u00102\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001a\u0010&\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010)\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\b\"\u0004\b*\u0010\nR\u000e\u0010+\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/common/CellStyle;", "", "<init>", "()V", "style", "(Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/common/CellStyle;)V", "isBold", "", "()Z", "setBold", "(Z)V", "isItalic", "setItalic", "isUnderline", "setUnderline", "isStrikethrough", "setStrikethrough", "align", "", "getAlign", "()I", "setAlign", "(I)V", "fontSize", "getFontSize", "setFontSize", "fontColor", "getFontColor", "setFontColor", "fontColorHsvColor", "", "getFontColorHsvColor", "()[F", "setFontColorHsvColor", "([F)V", "cellBgColor", "getCellBgColor", "setCellBgColor", "cellBgColorHsvColor", "getCellBgColorHsvColor", "setCellBgColorHsvColor", "isCellBgColorEnabled", "setCellBgColorEnabled", "updatedData", "setFontColorWithHSV", "", "setCellBgColorWithHSV", "bgColor", "setUpdatedData", "updatedDataType", "isUpdatedData", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CellStyle {
    public static final int ALIGN_BIT = 16;
    public static final int BOLD_BIT = 1;
    public static final int CELL_BG_COLOR_BIT = 128;
    public static final int FONT_COLOR_BIT = 64;
    public static final int FONT_SIZE_BIT = 32;
    public static final int ITALIC_BIT = 2;
    public static final int STRIKETHROUGH_BIT = 8;
    public static final int UNDERLINE_BIT = 4;
    private int align;
    private int cellBgColor;

    @NotNull
    private float[] cellBgColorHsvColor;
    private int fontColor;

    @NotNull
    private float[] fontColorHsvColor;
    private int fontSize;
    private boolean isBold;
    private boolean isCellBgColorEnabled;
    private boolean isItalic;
    private boolean isStrikethrough;
    private boolean isUnderline;
    private int updatedData;

    public CellStyle() {
        this.align = -1;
        this.fontColorHsvColor = new float[3];
        this.cellBgColorHsvColor = new float[3];
    }

    public final int getAlign() {
        return this.align;
    }

    public final int getCellBgColor() {
        return this.cellBgColor;
    }

    @NotNull
    public final float[] getCellBgColorHsvColor() {
        return this.cellBgColorHsvColor;
    }

    public final int getFontColor() {
        return this.fontColor;
    }

    @NotNull
    public final float[] getFontColorHsvColor() {
        return this.fontColorHsvColor;
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    /* JADX INFO: renamed from: isBold, reason: from getter */
    public final boolean getIsBold() {
        return this.isBold;
    }

    /* JADX INFO: renamed from: isCellBgColorEnabled, reason: from getter */
    public final boolean getIsCellBgColorEnabled() {
        return this.isCellBgColorEnabled;
    }

    /* JADX INFO: renamed from: isItalic, reason: from getter */
    public final boolean getIsItalic() {
        return this.isItalic;
    }

    /* JADX INFO: renamed from: isStrikethrough, reason: from getter */
    public final boolean getIsStrikethrough() {
        return this.isStrikethrough;
    }

    /* JADX INFO: renamed from: isUnderline, reason: from getter */
    public final boolean getIsUnderline() {
        return this.isUnderline;
    }

    public final boolean isUpdatedData() {
        return this.updatedData != 0;
    }

    public final void setAlign(int i) {
        this.align = i;
    }

    public final void setBold(boolean z) {
        this.isBold = z;
    }

    public final void setCellBgColor(int i) {
        this.cellBgColor = i;
    }

    public final void setCellBgColorEnabled(boolean z) {
        this.isCellBgColorEnabled = z;
    }

    public final void setCellBgColorHsvColor(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.cellBgColorHsvColor = fArr;
    }

    public final void setCellBgColorWithHSV(int bgColor) {
        this.cellBgColor = bgColor;
        float[] fArr = new float[3];
        ColorCompat.colorToHSV(bgColor, fArr);
        this.cellBgColorHsvColor = fArr;
    }

    public final void setFontColor(int i) {
        this.fontColor = i;
    }

    public final void setFontColorHsvColor(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.fontColorHsvColor = fArr;
    }

    public final void setFontColorWithHSV(int fontColor) {
        this.fontColor = fontColor;
        float[] fArr = new float[3];
        ColorCompat.colorToHSV(fontColor, fArr);
        this.fontColorHsvColor = fArr;
    }

    public final void setFontSize(int i) {
        this.fontSize = i;
    }

    public final void setItalic(boolean z) {
        this.isItalic = z;
    }

    public final void setStrikethrough(boolean z) {
        this.isStrikethrough = z;
    }

    public final void setUnderline(boolean z) {
        this.isUnderline = z;
    }

    public final void setUpdatedData(int updatedDataType) {
        this.updatedData = updatedDataType | this.updatedData;
    }

    public final boolean isUpdatedData(int updatedDataType) {
        return (updatedDataType & this.updatedData) != 0;
    }

    public CellStyle(@NotNull CellStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.align = -1;
        this.fontColorHsvColor = new float[3];
        this.cellBgColorHsvColor = new float[3];
        this.isBold = style.isBold;
        this.isItalic = style.isItalic;
        this.isUnderline = style.isUnderline;
        this.isStrikethrough = style.isStrikethrough;
        this.align = style.align;
        this.fontSize = style.fontSize;
        this.fontColor = style.fontColor;
        this.fontColorHsvColor = (float[]) style.fontColorHsvColor.clone();
        this.cellBgColor = style.cellBgColor;
        this.cellBgColorHsvColor = style.cellBgColorHsvColor;
        this.isCellBgColorEnabled = style.isCellBgColorEnabled;
        this.updatedData = style.updatedData;
    }
}
