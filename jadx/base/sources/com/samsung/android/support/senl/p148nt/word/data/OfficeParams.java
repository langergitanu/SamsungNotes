package com.samsung.android.support.senl.p148nt.word.data;

import androidx.annotation.ColorInt;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0015\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0011H$¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0005H$J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0005H&J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0018\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0011X\u0082.¢\u0006\u0004\n\u0002\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/data/OfficeParams;", "", "<init>", "()V", "width", "", "height", "marginLeft", "marginRight", "marginTop", "marginBottom", "bgLeftIndentation", "", "contentTextSize", "contentTextColor", "borderColor", "textRecognizeCounts", "", "[Ljava/lang/Integer;", "sizesRecognize", "fontSizeDelta", "getFontSizeDelta", "()I", "setFontSizeDelta", "(I)V", "init", "", "getSizesRecognize", "()[Ljava/lang/Integer;", "getTextRecognizeDefaultFontSize", "getFontSize", "fontSize", "getFontSizeTextRecognize", "lineCount", "toHexaStringColor", "", "color", "Companion", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class OfficeParams {
    public static final double A4_PORTRAIT_HEIGHT = 11.69d;
    public static final double A4_PORTRAIT_WIDTH = 8.27d;
    public static final int DEFAULT_MARGIN_BOTTOM = 270;
    public static final int DEFAULT_MARGIN_LEFT = 375;
    public static final int DEFAULT_MARGIN_RIGHT = 375;
    public static final int DEFAULT_MARGIN_TOP = 0;

    @NotNull
    public static final String FONT_FAMILY = "Calibri";
    public static final int LONG_MARGIN_BOTTOM = 270;
    public static final int LONG_MARGIN_LEFT = 2130;
    public static final int LONG_MARGIN_RIGHT = 2130;
    public static final int LONG_MARGIN_TOP = 0;

    @JvmField
    public double bgLeftIndentation;
    private int fontSizeDelta;

    @JvmField
    public int height;

    @JvmField
    public int marginBottom;

    @JvmField
    public int marginLeft;

    @JvmField
    public int marginRight;
    private Integer[] sizesRecognize;

    @JvmField
    public int width;

    @JvmField
    public int contentTextSize = 24;

    @ColorInt
    @JvmField
    public int contentTextColor = -14342875;

    @ColorInt
    @JvmField
    public int borderColor = VUtilString.GRAY;

    @NotNull
    private Integer[] textRecognizeCounts = {8, 11, 15, 16, 18, 20, 22, 24, 27};

    @JvmField
    public int marginTop = 0;

    public OfficeParams() {
        this.marginLeft = 375;
        this.marginRight = 375;
        this.marginBottom = 270;
        this.marginLeft = 375;
        this.marginRight = 375;
        this.marginBottom = 270;
        init();
    }

    private final void init() {
        this.sizesRecognize = getSizesRecognize();
    }

    public abstract double getFontSize(int fontSize);

    public final int getFontSizeDelta() {
        return this.fontSizeDelta;
    }

    public int getFontSizeTextRecognize(int lineCount) {
        Integer[] numArr = this.sizesRecognize;
        Integer[] numArr2 = null;
        if (numArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sizesRecognize");
            numArr = null;
        }
        int length = numArr.length;
        for (int i = 0; i < length; i++) {
            if (lineCount < this.textRecognizeCounts[i].intValue()) {
                Integer[] numArr3 = this.sizesRecognize;
                if (numArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sizesRecognize");
                } else {
                    numArr2 = numArr3;
                }
                Integer num = numArr2[i];
                Intrinsics.checkNotNull(num);
                return num.intValue();
            }
        }
        return getTextRecognizeDefaultFontSize();
    }

    @NotNull
    public abstract Integer[] getSizesRecognize();

    public abstract int getTextRecognizeDefaultFontSize();

    public final void setFontSizeDelta(int i) {
        this.fontSizeDelta = i;
    }

    @NotNull
    public final String toHexaStringColor(int color) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        return AbstractC2322a.m1624n("#%06X", new Object[]{Integer.valueOf(color & 16777215)}, 1, "format(...)");
    }
}
