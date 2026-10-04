package com.samsung.android.support.senl.p148nt.base.composer.table;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.RectF;
import androidx.core.content.ContextCompat;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenBoldSpan;
import com.samsung.android.support.senl.p145cm.base.framework.content.TypedArrayCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0007J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0007J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J&\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tJ\u0018\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\b\u0010\u001e\u001a\u00020\u001fH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/table/TableHelper;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "TABLE_DEF_BG_COLOR", "", "getDefaultBorderStyle", "Lcom/samsung/android/sdk/pen/document/SpenObjectTable$BorderStyle;", "lineColor", "setAllRoundBorderStyle", "", "table", "Lcom/samsung/android/sdk/pen/document/SpenObjectTable;", "borderStyle", "getHeaderColor", "color", "initTableCellTextBox", ExternalDataConstants.Column.TEXT_BOX, "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "setTableHeaderStyle", "cellBox", "rowIndex", "colIndex", "initTablePasteStyle", "maxRectInPage", "Landroid/graphics/RectF;", "getContext", "Landroid/content/Context;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TableHelper {
    public static final int TABLE_DEF_BG_COLOR = 0;

    @NotNull
    public static final TableHelper INSTANCE = new TableHelper();

    @NotNull
    private static final String TAG = Logger.createTag("TableHelper");

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.base.composer.table.TableHelper$getHeaderColor$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class C89123 extends FunctionReferenceImpl implements Function1<Integer, Integer> {
        public static final C89123 INSTANCE = new C89123();

        public C89123() {
            super(1, Color.class, "red", "red(I)I", 0);
        }

        public final Integer invoke(int i) {
            return Integer.valueOf(Color.red(i));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.base.composer.table.TableHelper$getHeaderColor$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class C89134 extends FunctionReferenceImpl implements Function1<Integer, Integer> {
        public static final C89134 INSTANCE = new C89134();

        public C89134() {
            super(1, Color.class, "green", "green(I)I", 0);
        }

        public final Integer invoke(int i) {
            return Integer.valueOf(Color.green(i));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.base.composer.table.TableHelper$getHeaderColor$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class C89145 extends FunctionReferenceImpl implements Function1<Integer, Integer> {
        public static final C89145 INSTANCE = new C89145();

        public C89145() {
            super(1, Color.class, "blue", "blue(I)I", 0);
        }

        public final Integer invoke(int i) {
            return Integer.valueOf(Color.blue(i));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    private TableHelper() {
    }

    private final Context getContext() {
        return BaseUtils.getContext();
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectTable.BorderStyle getDefaultBorderStyle() {
        return getDefaultBorderStyle(ContextCompat.getColor(INSTANCE.getContext(), C8875R.color.table_border_line_color));
    }

    @JvmStatic
    public static final int getHeaderColor(int color) {
        TypedArray typedArrayObtainTypedArray;
        TypedArray typedArray;
        try {
            TypedArrayCompat.Companion companion = TypedArrayCompat.INSTANCE;
            typedArrayObtainTypedArray = companion.getInstance().obtainTypedArray(C8875R.array.table_color_set);
            try {
                typedArray = typedArrayObtainTypedArray;
                typedArrayObtainTypedArray = companion.getInstance().obtainTypedArray(C8875R.array.table_header_color_set);
            } finally {
            }
        } catch (Exception unused) {
            Logger.m8697d(TAG, "getHeaderColor# can't find color.");
        }
        try {
            TypedArray typedArray2 = typedArrayObtainTypedArray;
            Intrinsics.checkNotNull(typedArray);
            int length = typedArray.length() - 1;
            for (int i = 0; i < length; i++) {
                if (color == typedArray.getColor(i, 0)) {
                    Intrinsics.checkNotNull(typedArray2);
                    int color2 = typedArray2.getColor(i, 0);
                    AutoCloseableKt.closeFinally(typedArrayObtainTypedArray, null);
                    AutoCloseableKt.closeFinally(typedArrayObtainTypedArray, null);
                    return color2;
                }
            }
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(typedArrayObtainTypedArray, null);
            AutoCloseableKt.closeFinally(typedArrayObtainTypedArray, null);
            return Color.argb(Color.alpha(color), getHeaderColor$extractColor(0.9f, 4603950, Color.red(color), C89123.INSTANCE), getHeaderColor$extractColor(0.9f, 4603950, Color.green(color), C89134.INSTANCE), getHeaderColor$extractColor(0.9f, 4603950, Color.blue(color), C89145.INSTANCE));
        } finally {
        }
    }

    private static final int getHeaderColor$extractColor(float f, int i, int i2, Function1<? super Integer, Integer> function1) {
        return (int) Math.min(255.0f, Math.max(0.0f, ((1.0f - f) * function1.invoke(Integer.valueOf(i)).floatValue()) + (i2 * f)));
    }

    @JvmStatic
    public static final void initTableCellTextBox(@NotNull SpenObjectTextBox textBox) {
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        textBox.setTextLimit(5000);
        textBox.setAutoFitOption(2);
        textBox.setMargin(8.0f, 4.0f, 8.0f, 4.0f);
        textBox.setEllipsisType(0);
    }

    @JvmStatic
    public static final void initTablePasteStyle(@NotNull SpenObjectTable table, @NotNull RectF maxRectInPage) {
        Intrinsics.checkNotNullParameter(table, "table");
        Intrinsics.checkNotNullParameter(maxRectInPage, "maxRectInPage");
        setAllRoundBorderStyle(table, getDefaultBorderStyle());
        int columnsCount = table.getColumnsCount();
        float fWidth = maxRectInPage.width();
        float fWidth2 = maxRectInPage.width() / 5.0f;
        float fWidth3 = (1 > columnsCount || columnsCount >= 6) ? fWidth2 : maxRectInPage.width() / columnsCount;
        int columnsCount2 = table.getColumnsCount();
        for (int i = 0; i < columnsCount2; i++) {
            table.setColumnWidth(i, fWidth3);
            table.setMinColumnWidth(i, fWidth2);
            table.setMaxColumnWidth(i, fWidth);
        }
    }

    @JvmStatic
    public static final void setAllRoundBorderStyle(@NotNull SpenObjectTable table, @NotNull SpenObjectTable.BorderStyle borderStyle) {
        Intrinsics.checkNotNullParameter(table, "table");
        Intrinsics.checkNotNullParameter(borderStyle, "borderStyle");
        SpenObjectTable.Companion companion = SpenObjectTable.INSTANCE;
        table.setDefaultCellBorderStyle(borderStyle, companion.getBORDER_ALL());
        float dimensionPixelSize = INSTANCE.getContext().getResources().getDimensionPixelSize(C8875R.dimen.table_round_border_line_radius);
        borderStyle.setStartRadius(dimensionPixelSize);
        borderStyle.setEndRadius(dimensionPixelSize);
        table.setBorderStyle(borderStyle, companion.getBORDER_ALL());
    }

    @NotNull
    public final String getTAG() {
        return TAG;
    }

    public final void setTableHeaderStyle(@NotNull SpenObjectTable table, @NotNull SpenObjectTextBox cellBox, int rowIndex, int colIndex) {
        Intrinsics.checkNotNullParameter(table, "table");
        Intrinsics.checkNotNullParameter(cellBox, "cellBox");
        table.setCellBackgroundColor(0, rowIndex, colIndex);
        String text = cellBox.getText();
        cellBox.appendTextSpan(new SpenBoldSpan(0, text != null ? text.length() : 0, 1, true));
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectTable.BorderStyle getDefaultBorderStyle(int lineColor) {
        SpenObjectTable.BorderStyle borderStyle = new SpenObjectTable.BorderStyle();
        borderStyle.setColor(lineColor);
        borderStyle.setWidth(INSTANCE.getContext().getResources().getDimensionPixelSize(C8875R.dimen.table_border_line_thickness));
        return borderStyle;
    }
}
