package com.samsung.android.sdk.pen.setting.colorpicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.pen.util.color.SpenColorMatching;
import com.samsung.android.sdk.pen.util.color.SpenReverseColorTheme;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0007\b\u0000\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0002 !B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bJ\u0016\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bJ\u0016\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u0018\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0003R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082.¢\u0006\u0004\n\u0002\u0010\f¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenPickerReverseColorTheme;", "Lcom/samsung/android/sdk/pen/util/color/SpenReverseColorTheme;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenIPickerColorTheme;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mColorMatching", "Lcom/samsung/android/sdk/pen/util/color/SpenColorMatching;", "mPaletteColor", "", "", "[[F", "close", "", "getContentColor", "", "visibleColor", "contentColor", "getOldColor", "oldColor", "newOldColor", "getColorWithinPicker", "source", "closeColor", "matchColor", "findInPickerColor", "", "copyColor", "src", "dest", "initPaletteColor", "Companion", "Point3", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPickerReverseColorTheme extends SpenReverseColorTheme implements SpenIPickerColorTheme {
    private static final int MAX_CURRENT_VALUE = 1200;

    @NotNull
    private static final String TAG = "SpenPickerReverseColorTheme";

    @NotNull
    private SpenColorMatching mColorMatching;
    private float[][] mPaletteColor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenPickerReverseColorTheme$Point3;", "", "hsv", "", "<init>", "([F)V", "x", "", "y", "z", "setColor", "", "hue", "", "saturation", "value", "getDistance", LangPackConfigConstants.LANGUAGE_CODE_PT, "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Point3 {

        /* JADX INFO: renamed from: PI */
        private static final double f5011PI = 3.14159d;
        private double x;
        private double y;
        private double z;

        public Point3(@NotNull float[] hsv) {
            Intrinsics.checkNotNullParameter(hsv, "hsv");
            setColor(hsv[0], hsv[1], hsv[2]);
        }

        public final double getDistance(@NotNull Point3 pt) {
            Intrinsics.checkNotNullParameter(pt, "pt");
            return Math.sqrt(Math.pow(Math.abs(this.z - pt.z), 2.0d) + Math.pow(Math.abs(this.y - pt.y), 2.0d) + Math.pow(Math.abs(this.x - pt.x), 2.0d));
        }

        public final void setColor(float hue, float saturation, float value) {
            double d = saturation;
            double d2 = (float) ((((double) hue) * f5011PI) / ((double) 180));
            this.x = (float) (Math.cos(d2) * d);
            this.y = (float) (Math.sin(d2) * d);
            this.z = value;
        }
    }

    public SpenPickerReverseColorTheme(@Nullable Context context) {
        super(context);
        this.mColorMatching = new SpenColorMatching();
        initPaletteColor();
    }

    private final void copyColor(float[] src, float[] dest) {
        dest[0] = src[0];
        dest[1] = src[1];
        dest[2] = src[2];
    }

    private final double findInPickerColor(float[] source, float[] closeColor) {
        if (!this.mColorMatching.matchColor(source)) {
            return 1200.0d;
        }
        this.mColorMatching.getResultColor(closeColor);
        double mLastMatchedDistanceValue = this.mColorMatching.getMLastMatchedDistanceValue();
        this.mColorMatching.clearMatchedData();
        return mLastMatchedDistanceValue;
    }

    @SuppressLint({"LongLogTag"})
    private final void initPaletteColor() {
        float[][] fArr;
        Set<Integer> setKeySet = getPaletteHash().keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        int size = setKeySet.size();
        float[][] fArr2 = new float[size][];
        for (int i = 0; i < size; i++) {
            fArr2[i] = new float[3];
        }
        this.mPaletteColor = fArr2;
        Iterator<Integer> it = setKeySet.iterator();
        float[] fArr3 = {0.0f, 0.0f, 0.0f};
        int i2 = 0;
        while (true) {
            fArr = null;
            if (!it.hasNext()) {
                break;
            }
            Color.colorToHSV(it.next().intValue(), fArr3);
            float[][] fArr4 = this.mPaletteColor;
            if (fArr4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPaletteColor");
                fArr4 = null;
            }
            fArr4[i2][0] = fArr3[0];
            float[][] fArr5 = this.mPaletteColor;
            if (fArr5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPaletteColor");
                fArr5 = null;
            }
            fArr5[i2][1] = fArr3[1];
            float[][] fArr6 = this.mPaletteColor;
            if (fArr6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPaletteColor");
            } else {
                fArr = fArr6;
            }
            fArr[i2][2] = fArr3[2];
            i2++;
        }
        int size2 = setKeySet.size();
        float[][] fArr7 = this.mPaletteColor;
        if (fArr7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaletteColor");
        } else {
            fArr = fArr7;
        }
        AbstractC6670b.m4744e(size2, fArr.length, "initPaletteColor() size=", " length=", TAG);
    }

    @Override // com.samsung.android.sdk.pen.util.color.SpenReverseColorTheme, com.samsung.android.sdk.pen.util.color.SpenIColorTheme
    public void close() {
        super.close();
        this.mPaletteColor = new float[0][];
    }

    public final boolean getColorWithinPicker(@NotNull float[] source, @NotNull float[] closeColor) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(closeColor, "closeColor");
        setSearchScope(1);
        getColor(source, closeColor);
        setSearchScope(8);
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenIPickerColorTheme
    public boolean getContentColor(@NotNull float[] visibleColor, @NotNull float[] contentColor) {
        Intrinsics.checkNotNullParameter(visibleColor, "visibleColor");
        Intrinsics.checkNotNullParameter(contentColor, "contentColor");
        setSearchScope(8);
        getColor(visibleColor, contentColor);
        setSearchScope(8);
        return true;
    }

    public final boolean getOldColor(@NotNull float[] oldColor, @NotNull float[] newOldColor) {
        Intrinsics.checkNotNullParameter(oldColor, "oldColor");
        Intrinsics.checkNotNullParameter(newOldColor, "newOldColor");
        float[] fArr = new float[3];
        matchColor(oldColor, fArr);
        getColor(fArr, newOldColor);
        return true;
    }

    public final boolean matchColor(@NotNull float[] source, @NotNull float[] closeColor) {
        float[][] fArr;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(closeColor, "closeColor");
        Point3 point3 = new Point3(source);
        double dFindInPickerColor = findInPickerColor(source, closeColor);
        float[][] fArr2 = this.mPaletteColor;
        if (fArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaletteColor");
            fArr2 = null;
        }
        int length = fArr2.length;
        int i = -1;
        int i2 = 0;
        Point3 point32 = null;
        while (true) {
            if (i2 >= length) {
                i2 = i;
                break;
            }
            if (point32 == null) {
                float[][] fArr3 = this.mPaletteColor;
                if (fArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPaletteColor");
                    fArr3 = null;
                }
                point32 = new Point3(fArr3[i2]);
            } else {
                float[][] fArr4 = this.mPaletteColor;
                if (fArr4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPaletteColor");
                    fArr4 = null;
                }
                float f = fArr4[i2][0];
                float[][] fArr5 = this.mPaletteColor;
                if (fArr5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPaletteColor");
                    fArr5 = null;
                }
                float f4 = fArr5[i2][1];
                float[][] fArr6 = this.mPaletteColor;
                if (fArr6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPaletteColor");
                    fArr6 = null;
                }
                point32.setColor(f, f4, fArr6[i2][2]);
            }
            double distance = point3.getDistance(point32);
            if (distance == 0.0d) {
                break;
            }
            if (dFindInPickerColor > distance) {
                i = i2;
                dFindInPickerColor = distance;
            }
            i2++;
        }
        if (i2 > -1) {
            float[][] fArr7 = this.mPaletteColor;
            if (fArr7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPaletteColor");
                fArr = null;
            } else {
                fArr = fArr7;
            }
            copyColor(fArr[i2], closeColor);
        }
        return !(dFindInPickerColor == 1200.0d);
    }
}
