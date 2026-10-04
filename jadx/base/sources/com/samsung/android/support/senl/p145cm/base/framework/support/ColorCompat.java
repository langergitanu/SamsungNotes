package com.samsung.android.support.senl.p145cm.base.framework.support;

import android.graphics.Color;
import android.os.Build;
import androidx.annotation.ColorInt;
import androidx.annotation.Size;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u00020\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u001c\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/support/ColorCompat;", "", "<init>", "()V", "mImple", "Lcom/samsung/android/support/senl/cm/base/framework/support/ColorCompat$ColorCompatImpl;", "HSVToColor", "", "hsv", "", "colorToHSV", "", "color", "ColorCompatImplUnderO", "ColorCompatImplBase", "ColorCompatImpl", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ColorCompat {

    @NotNull
    public static final ColorCompat INSTANCE = new ColorCompat();

    @NotNull
    private static ColorCompatImpl mImple;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'J\u001c\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/support/ColorCompat$ColorCompatImpl;", "", "HSVToColor", "", "hsv", "", "colorToHSV", "", "color", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ColorCompatImpl {
        @ColorInt
        int HSVToColor(@Size(3) @Nullable float[] hsv);

        void colorToHSV(int color, @Size(3) @Nullable float[] hsv);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/support/ColorCompat$ColorCompatImplBase;", "Lcom/samsung/android/support/senl/cm/base/framework/support/ColorCompat$ColorCompatImpl;", "<init>", "()V", "HSVToColor", "", "hsv", "", "colorToHSV", "", "color", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class ColorCompatImplBase implements ColorCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.support.ColorCompat.ColorCompatImpl
        public int HSVToColor(@Nullable float[] hsv) {
            return Color.HSVToColor(hsv);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.support.ColorCompat.ColorCompatImpl
        public void colorToHSV(int color, @Nullable float[] hsv) {
            Color.colorToHSV(color, hsv);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/support/ColorCompat$ColorCompatImplUnderO;", "Lcom/samsung/android/support/senl/cm/base/framework/support/ColorCompat$ColorCompatImplBase;", "<init>", "()V", "HSVToColor", "", "hsv", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ColorCompatImplUnderO extends ColorCompatImplBase {
        @Override // com.samsung.android.support.senl.cm.base.framework.support.ColorCompat.ColorCompatImplBase, com.samsung.android.support.senl.cm.base.framework.support.ColorCompat.ColorCompatImpl
        public int HSVToColor(@Nullable float[] hsv) {
            if (hsv == null || hsv.length < 3) {
                throw new RuntimeException("Invalid hsv color");
            }
            float fMax = (float) Math.max(Math.min(hsv[1], 1.0d), 0.0d);
            float fMax2 = (float) Math.max(Math.min(hsv[2], 1.0d), 0.0d);
            float f = 255;
            int iRound = Math.round(fMax2 * f);
            if (fMax <= 2.4414062E-4f) {
                int i = iRound & 255;
                return i | (i << 16) | (-16777216) | (i << 8);
            }
            float f4 = hsv[0];
            float f5 = 0.0f;
            if (f4 >= 0.0f && f4 < 360.0f) {
                f5 = f4 / 60.0f;
            }
            int iFloor = (int) Math.floor(f5);
            if (iFloor >= 6 || iFloor < 0) {
                throw new RuntimeException("Invalid hsv color");
            }
            float f6 = f5 - iFloor;
            float f7 = 1;
            int iRound2 = Math.round((f7 - fMax) * fMax2 * f);
            int iRound3 = Math.round((f7 - (fMax * f6)) * fMax2 * f);
            int iRound4 = Math.round((f7 - ((f7 - f6) * fMax)) * fMax2 * f);
            if (iFloor == 0) {
                iRound3 = iRound2;
                iRound2 = iRound4;
            } else if (iFloor == 1) {
                iRound2 = iRound;
                iRound = iRound3;
                iRound3 = iRound2;
            } else if (iFloor == 2) {
                iRound2 = iRound;
                iRound = iRound2;
                iRound3 = iRound4;
            } else if (iFloor == 3) {
                iRound3 = iRound;
                iRound = iRound2;
                iRound2 = iRound3;
            } else if (iFloor == 4) {
                iRound3 = iRound;
                iRound = iRound4;
            } else if (iFloor != 5) {
                iRound = 0;
                iRound2 = 0;
                iRound3 = 0;
            }
            return ((iRound & 255) << 16) | (-16777216) | ((iRound2 & 255) << 8) | (iRound3 & 255);
        }
    }

    static {
        if (Build.VERSION.SDK_INT > 26) {
            mImple = new ColorCompatImplBase();
        } else {
            mImple = new ColorCompatImplUnderO();
        }
    }

    private ColorCompat() {
    }

    @JvmStatic
    @ColorInt
    public static final int HSVToColor(@Size(3) @Nullable float[] hsv) {
        return mImple.HSVToColor(hsv);
    }

    @JvmStatic
    public static final void colorToHSV(int color, @Size(3) @Nullable float[] hsv) {
        mImple.colorToHSV(color, hsv);
    }
}
