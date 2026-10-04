package com.samsung.android.sdk.pen.setting.colorpicker;

import android.content.Context;
import android.util.Log;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.util.color.SpenIColorTheme;
import com.samsung.android.sdk.pen.util.color.SpenNormalColorTheme;
import com.samsung.android.sdk.pen.util.color.SpenReverseColorTheme;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005J\u0016\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0005J\b\u0010\u001e\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerTheme;", "", "mContext", "Landroid/content/Context;", "oldColor", "", "<init>", "(Landroid/content/Context;[F)V", "mOldColor", "mColorTheme", "Lcom/samsung/android/sdk/pen/util/color/SpenIColorTheme;", "mPickerColorTheme", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenIPickerColorTheme;", "close", "", BaseWidgetConstant.WIDGET_THEME, "", "getTheme", "()I", "setTheme", "(I)V", "getColor", "", "input", "output", "getContentColor", "visibleColor", "outContentColor", "getOldVisibleColor", "color", "closeTheme", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColorPickerTheme {

    @NotNull
    private static final String TAG = "SpenColorPickerTheme";

    @NotNull
    private SpenIColorTheme mColorTheme;

    @NotNull
    private Context mContext;

    @NotNull
    private float[] mOldColor;

    @NotNull
    private SpenIPickerColorTheme mPickerColorTheme;

    public SpenColorPickerTheme(@NotNull Context mContext, @Nullable float[] fArr) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        float[] fArr2 = new float[3];
        this.mOldColor = fArr2;
        System.arraycopy(fArr, 0, fArr2, 0, 3);
        SpenPickerNormalColorTheme spenPickerNormalColorTheme = new SpenPickerNormalColorTheme();
        this.mColorTheme = spenPickerNormalColorTheme;
        Intrinsics.checkNotNull(spenPickerNormalColorTheme, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.colorpicker.SpenIPickerColorTheme");
        this.mPickerColorTheme = spenPickerNormalColorTheme;
    }

    private final void closeTheme() {
        this.mColorTheme.close();
    }

    public final void close() {
        closeTheme();
    }

    public final boolean getColor(@NotNull float[] input, @NotNull float[] output) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        return this.mColorTheme.getColor(input, output);
    }

    public final boolean getContentColor(@NotNull float[] visibleColor, @NotNull float[] outContentColor) {
        Intrinsics.checkNotNullParameter(visibleColor, "visibleColor");
        Intrinsics.checkNotNullParameter(outContentColor, "outContentColor");
        return this.mPickerColorTheme.getContentColor(visibleColor, outContentColor);
    }

    public final boolean getOldVisibleColor(@NotNull float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        return this.mColorTheme.getColor(this.mOldColor, color);
    }

    public final int getTheme() {
        SpenIColorTheme spenIColorTheme = this.mColorTheme;
        if (spenIColorTheme instanceof SpenNormalColorTheme) {
            return 0;
        }
        return spenIColorTheme instanceof SpenReverseColorTheme ? 1 : -1;
    }

    public final void setTheme(int i) {
        int theme = getTheme();
        AbstractC6670b.m4744e(theme, i, "setTheme() current=", " theme=", TAG);
        if (theme == -1 || theme == i) {
            return;
        }
        closeTheme();
        if (i == 0) {
            SpenPickerNormalColorTheme spenPickerNormalColorTheme = new SpenPickerNormalColorTheme();
            this.mColorTheme = spenPickerNormalColorTheme;
            Intrinsics.checkNotNull(spenPickerNormalColorTheme, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.colorpicker.SpenIPickerColorTheme");
            this.mPickerColorTheme = spenPickerNormalColorTheme;
            return;
        }
        if (i != 1) {
            Log.i(TAG, "Unknown theme.");
            return;
        }
        SpenPickerReverseColorTheme spenPickerReverseColorTheme = new SpenPickerReverseColorTheme(this.mContext);
        this.mColorTheme = spenPickerReverseColorTheme;
        Intrinsics.checkNotNull(spenPickerReverseColorTheme, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.colorpicker.SpenIPickerColorTheme");
        this.mPickerColorTheme = spenPickerReverseColorTheme;
    }
}
