package com.samsung.android.sdk.pen.util.color;

import android.content.Context;
import android.util.Log;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fJ\b\u0010\u0014\u001a\u00020\nH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/util/color/SpenColorThemeUtil;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContext", "mCurrentTheme", "Lcom/samsung/android/sdk/pen/util/color/SpenIColorTheme;", "close", "", BaseWidgetConstant.WIDGET_THEME, "", "colorTheme", "getColorTheme", "()I", "setColorTheme", "(I)V", "getColor", "color", "closeCurrentTheme", "getThemeObject", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenColorThemeUtil {
    public static final int COLOR_THEME_NORMAL = 0;
    public static final int COLOR_THEME_REVERSE = 1;

    @NotNull
    private static final String TAG = "SpenColorThemeUtil";

    @Nullable
    private Context mContext;

    @Nullable
    private SpenIColorTheme mCurrentTheme = new SpenNormalColorTheme();

    public SpenColorThemeUtil(@Nullable Context context) {
        this.mContext = context;
    }

    private final void closeCurrentTheme() {
        SpenIColorTheme spenIColorTheme = this.mCurrentTheme;
        if (spenIColorTheme != null) {
            spenIColorTheme.close();
        }
        this.mCurrentTheme = null;
    }

    private final SpenIColorTheme getThemeObject(int theme) {
        if (theme == 0) {
            return new SpenNormalColorTheme();
        }
        if (theme != 1) {
            return null;
        }
        return new SpenReverseColorTheme(this.mContext);
    }

    public final void close() {
        this.mContext = null;
        closeCurrentTheme();
    }

    public final int getColor(int color) {
        SpenIColorTheme spenIColorTheme = this.mCurrentTheme;
        if (spenIColorTheme != null) {
            return spenIColorTheme.getColor(color);
        }
        return -1;
    }

    public final int getColorTheme() {
        SpenIColorTheme spenIColorTheme = this.mCurrentTheme;
        if (spenIColorTheme == null) {
            return -1;
        }
        if (spenIColorTheme instanceof SpenNormalColorTheme) {
            return 0;
        }
        return spenIColorTheme instanceof SpenReverseColorTheme ? 1 : -1;
    }

    public final void setColorTheme(int i) {
        Log.i(TAG, "setColorTheme() theme=" + i);
        if (getColorTheme() != i) {
            closeCurrentTheme();
            this.mCurrentTheme = getThemeObject(i);
        }
    }
}
