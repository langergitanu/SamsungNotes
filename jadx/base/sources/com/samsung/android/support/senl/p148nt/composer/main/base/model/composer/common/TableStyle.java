package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common;

import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.ColorCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 -2\u00020\u0001:\u0001-B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0005J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0014J\u000e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0014J\u0006\u0010'\u001a\u00020\rJ\u000e\u0010'\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u0014J\u0006\u0010(\u001a\u00020#J\u0006\u0010)\u001a\u00020#J\b\u0010*\u001a\u00020\u0014H\u0002J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0014H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006."}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/common/TableStyle;", "", "<init>", "()V", "style", "(Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/common/TableStyle;)V", "cellStyle", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/common/CellStyle;", "getCellStyle", "()Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/common/CellStyle;", "setCellStyle", "(Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/common/CellStyle;)V", "isHighlightHeaderRow", "", "()Z", "setHighlightHeaderRow", "(Z)V", "isHighlightHeaderColumn", "setHighlightHeaderColumn", "tableLineType", "", "getTableLineType", "()I", "setTableLineType", "(I)V", "tableBgColor", "getTableBgColor", "setTableBgColor", "tableBgColorHsvColor", "", "getTableBgColorHsvColor", "()[F", "setTableBgColorHsvColor", "([F)V", "setTableBgColorWithHSV", "", "bgColor", "setUpdatedData", "updatedDataType", "isUpdatedData", "loadData", "save", "convertHeaderTypeToInt", "convertHeaderTypeToBoolean", "headerType", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TableStyle {
    public static final int HEADER_COLUMN_BIT = 512;
    public static final int HEADER_ROW_BIT = 256;

    @NotNull
    public static final String KEY_ALIGN = "KEY_ALIGN";

    @NotNull
    private static final String KEY_FONT_COLOR = "KEY_FONT_COLOR";

    @NotNull
    public static final String KEY_FONT_SIZE = "KEY_FONT_SIZE";

    @NotNull
    private static final String KEY_IS_BOLD = "KEY_IS_BOLD";

    @NotNull
    private static final String KEY_IS_HIGHLIGHT_HEADER = "KEY_IS_HIGHLIGHT_HEADER";

    @NotNull
    private static final String KEY_IS_ITALIC = "KEY_IS_ITALIC";

    @NotNull
    private static final String KEY_IS_STRIKETHROUGH = "KEY_IS_STRIKETHROUGH";

    @NotNull
    private static final String KEY_IS_UNDERLINE = "KEY_IS_UNDERLINE";

    @NotNull
    private static final String KEY_LINE_TYPE = "KEY_LINE_TYPE";

    @NotNull
    private static final String KEY_TABLE_BG = "KEY_TABLE_BG";
    public static final int LINE_TYPE_ALL_RECT = 1;
    public static final int LINE_TYPE_ALL_ROUND = 0;
    public static final int LINE_TYPE_DEFAULT = 0;
    public static final int LINE_TYPE_NONE = 4;
    public static final int LINE_TYPE_ROWS = 2;
    public static final int LINE_TYPE_TOP_AND_BOTTOM = 3;
    public static final int TABLE_BG_COLOR_BIT = 2048;
    public static final int TABLE_LINE_TYPE_BIT = 1024;

    @NotNull
    private static final String TAG;

    @NotNull
    private CellStyle cellStyle;
    private boolean isHighlightHeaderColumn;
    private boolean isHighlightHeaderRow;
    private int tableBgColor;

    @NotNull
    private float[] tableBgColorHsvColor;
    private int tableLineType;

    static {
        String strCreateTag = Logger.createTag("TableStyle");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public TableStyle() {
        this.tableBgColorHsvColor = new float[3];
        this.cellStyle = new CellStyle();
    }

    private final void convertHeaderTypeToBoolean(int headerType) {
        if (headerType == 1) {
            this.isHighlightHeaderRow = true;
            setUpdatedData(256);
        } else if (headerType == 2) {
            this.isHighlightHeaderColumn = true;
            setUpdatedData(512);
        } else {
            if (headerType != 3) {
                return;
            }
            this.isHighlightHeaderRow = true;
            setUpdatedData(256);
            this.isHighlightHeaderColumn = true;
            setUpdatedData(512);
        }
    }

    private final int convertHeaderTypeToInt() {
        boolean z = this.isHighlightHeaderRow;
        return this.isHighlightHeaderColumn ? (z ? 1 : 0) + 2 : z ? 1 : 0;
    }

    @NotNull
    public final CellStyle getCellStyle() {
        return this.cellStyle;
    }

    public final int getTableBgColor() {
        return this.tableBgColor;
    }

    @NotNull
    public final float[] getTableBgColorHsvColor() {
        return this.tableBgColorHsvColor;
    }

    public final int getTableLineType() {
        return this.tableLineType;
    }

    /* JADX INFO: renamed from: isHighlightHeaderColumn, reason: from getter */
    public final boolean getIsHighlightHeaderColumn() {
        return this.isHighlightHeaderColumn;
    }

    /* JADX INFO: renamed from: isHighlightHeaderRow, reason: from getter */
    public final boolean getIsHighlightHeaderRow() {
        return this.isHighlightHeaderRow;
    }

    public final boolean isUpdatedData() {
        return this.cellStyle.isUpdatedData();
    }

    public final void loadData() {
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        int i = companion.getInstance("Composer").getInt(KEY_IS_HIGHLIGHT_HEADER, 0);
        convertHeaderTypeToBoolean(i);
        this.tableLineType = companion.getInstance("Composer").getInt(KEY_LINE_TYPE, 0);
        setUpdatedData(1024);
        int i2 = companion.getInstance("Composer").getInt(KEY_TABLE_BG, 0);
        if (i2 != 0) {
            this.tableBgColor = i2;
            setUpdatedData(2048);
        }
        int i4 = companion.getInstance("Composer").getInt(KEY_FONT_SIZE, -1);
        if (i4 > 0) {
            this.cellStyle.setFontSize(i4);
            setUpdatedData(32);
        }
        int i5 = companion.getInstance("Composer").getInt(KEY_FONT_COLOR, 0);
        if (i5 != 0) {
            this.cellStyle.setFontColor(i5);
            setUpdatedData(64);
        }
        int i6 = companion.getInstance("Composer").getInt(KEY_ALIGN, -1);
        if (i6 != -1) {
            this.cellStyle.setAlign(i6);
            setUpdatedData(16);
        }
        boolean z = companion.getInstance("Composer").getBoolean(KEY_IS_BOLD, false);
        if (z) {
            this.cellStyle.setBold(true);
            setUpdatedData(1);
        }
        boolean z2 = companion.getInstance("Composer").getBoolean(KEY_IS_ITALIC, false);
        if (z2) {
            this.cellStyle.setItalic(true);
            setUpdatedData(2);
        }
        boolean z3 = companion.getInstance("Composer").getBoolean(KEY_IS_UNDERLINE, false);
        if (z3) {
            this.cellStyle.setUnderline(true);
            setUpdatedData(4);
        }
        boolean z4 = companion.getInstance("Composer").getBoolean(KEY_IS_STRIKETHROUGH, false);
        if (z4) {
            this.cellStyle.setStrikethrough(true);
            setUpdatedData(8);
        }
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, this.tableLineType, "loadData# headerType : ", ", lineType : ", ", tableBg : ");
        AbstractC2821a.m2235z(sbM1173s, i2, i4, ", fontSize : ", ", fontColor : ");
        AbstractC2821a.m2235z(sbM1173s, i5, i6, ", align : ", ", fontStyle : ");
        AbstractC2821a.m2208C(sbM1173s, z, SQLKeyword.COMMA, z2, SQLKeyword.COMMA);
        sbM1173s.append(z3);
        sbM1173s.append(SQLKeyword.COMMA);
        sbM1173s.append(z4);
        Logger.m10999d(str, sbM1173s.toString());
    }

    public final void save() {
        int iConvertHeaderTypeToInt = convertHeaderTypeToInt();
        StringBuilder sb = new StringBuilder(AbstractC0000a.m11h(iConvertHeaderTypeToInt, "save# headerType : "));
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        companion.getInstance("Composer").putInt(KEY_IS_HIGHLIGHT_HEADER, iConvertHeaderTypeToInt);
        if (isUpdatedData(1024)) {
            sb.append(", lineType : " + this.tableLineType);
            companion.getInstance("Composer").putInt(KEY_LINE_TYPE, this.tableLineType);
        }
        if (isUpdatedData(2048)) {
            sb.append(", tableBg : " + this.tableBgColor);
            companion.getInstance("Composer").putInt(KEY_TABLE_BG, this.tableBgColor);
        }
        if (isUpdatedData(32)) {
            sb.append(", fontSize : " + this.cellStyle.getFontSize());
            companion.getInstance("Composer").putInt(KEY_FONT_SIZE, this.cellStyle.getFontSize());
        }
        if (isUpdatedData(64)) {
            sb.append(", fontColor : " + this.cellStyle.getFontColor());
            companion.getInstance("Composer").putInt(KEY_FONT_COLOR, this.cellStyle.getFontColor());
        }
        if (isUpdatedData(16)) {
            sb.append(", align : " + this.cellStyle.getAlign());
            companion.getInstance("Composer").putInt(KEY_ALIGN, this.cellStyle.getAlign());
        }
        if (isUpdatedData(1)) {
            sb.append(", bold : " + this.cellStyle.getIsBold());
            companion.getInstance("Composer").putBoolean(KEY_IS_BOLD, this.cellStyle.getIsBold());
        }
        if (isUpdatedData(2)) {
            sb.append(", italic : " + this.cellStyle.getIsItalic());
            companion.getInstance("Composer").putBoolean(KEY_IS_ITALIC, this.cellStyle.getIsItalic());
        }
        if (isUpdatedData(4)) {
            sb.append(", underline : " + this.cellStyle.getIsUnderline());
            companion.getInstance("Composer").putBoolean(KEY_IS_UNDERLINE, this.cellStyle.getIsUnderline());
        }
        if (isUpdatedData(8)) {
            sb.append(", strikethrough : " + this.cellStyle.getIsStrikethrough());
            companion.getInstance("Composer").putBoolean(KEY_IS_STRIKETHROUGH, this.cellStyle.getIsStrikethrough());
        }
        Logger.m10999d(TAG, sb.toString());
    }

    public final void setCellStyle(@NotNull CellStyle cellStyle) {
        Intrinsics.checkNotNullParameter(cellStyle, "<set-?>");
        this.cellStyle = cellStyle;
    }

    public final void setHighlightHeaderColumn(boolean z) {
        this.isHighlightHeaderColumn = z;
    }

    public final void setHighlightHeaderRow(boolean z) {
        this.isHighlightHeaderRow = z;
    }

    public final void setTableBgColor(int i) {
        this.tableBgColor = i;
    }

    public final void setTableBgColorHsvColor(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.tableBgColorHsvColor = fArr;
    }

    public final void setTableBgColorWithHSV(int bgColor) {
        this.tableBgColor = bgColor;
        float[] fArr = new float[3];
        ColorCompat.colorToHSV(bgColor, fArr);
        this.tableBgColorHsvColor = fArr;
    }

    public final void setTableLineType(int i) {
        this.tableLineType = i;
    }

    public final void setUpdatedData(int updatedDataType) {
        this.cellStyle.setUpdatedData(updatedDataType);
    }

    public final boolean isUpdatedData(int updatedDataType) {
        return this.cellStyle.isUpdatedData(updatedDataType);
    }

    public TableStyle(@NotNull TableStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.tableBgColorHsvColor = new float[3];
        this.cellStyle = new CellStyle(style.cellStyle);
        this.isHighlightHeaderRow = style.isHighlightHeaderRow;
        this.isHighlightHeaderColumn = style.isHighlightHeaderColumn;
        this.tableLineType = style.tableLineType;
        this.tableBgColor = style.tableBgColor;
        this.tableBgColorHsvColor = style.tableBgColorHsvColor;
    }
}
