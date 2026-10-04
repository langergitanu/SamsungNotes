package com.samsung.android.support.senl.p148nt.base.widget.theme;

import android.content.Context;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 -2\u00020\u0001:\u0001-B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\tJ\u0012\u0010#\u001a\u00020$2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010+\u001a\u00020,H\u0016R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0005R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u0005R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u0005R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u0005R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u0005R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u0012\u0010&\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\fR\u0012\u0010(\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\fR\u0011\u0010*\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b*\u0010\u001d¨\u0006."}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/widget/theme/BaseThemeInfo;", "", BaseWidgetConstant.WIDGET_THEME, "", "<init>", "(I)V", "context", "Landroid/content/Context;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "(Landroid/content/Context;I)V", "mAppWidgetId", "getMAppWidgetId", "()I", "setMAppWidgetId", "mTransparency", "getMTransparency", "setMTransparency", "mBackgroundColor", "getMBackgroundColor", "setMBackgroundColor", "mDarkMode", "getMDarkMode", "setMDarkMode", "mTheme", "getMTheme", "setMTheme", "mIsMatchWithDarkMode", "", "getMIsMatchWithDarkMode", "()Z", "setMIsMatchWithDarkMode", "(Z)V", "mIsForcedTheme", "getMIsForcedTheme", "setMIsForcedTheme", "initTheme", "", "setForceContentsThemeColor", "textColor", "getTextColor", "strokeColor", "getStrokeColor", "isDarkMode", "toString", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class BaseThemeInfo {

    @NotNull
    private static final String TAG = "BaseThemeInfo";
    private int mAppWidgetId;
    private int mBackgroundColor;
    private int mDarkMode;
    private boolean mIsForcedTheme;
    private boolean mIsMatchWithDarkMode;
    private int mTheme;
    private int mTransparency;

    public BaseThemeInfo(int i) {
        setForceContentsThemeColor(i);
    }

    private final void initTheme(Context context) {
        this.mTheme = BaseWidgetUtils.INSTANCE.checkTheme(context, this.mTransparency, this.mIsMatchWithDarkMode ? 0 : this.mBackgroundColor);
    }

    public final int getMAppWidgetId() {
        return this.mAppWidgetId;
    }

    public final int getMBackgroundColor() {
        return this.mBackgroundColor;
    }

    public final int getMDarkMode() {
        return this.mDarkMode;
    }

    public final boolean getMIsForcedTheme() {
        return this.mIsForcedTheme;
    }

    public final boolean getMIsMatchWithDarkMode() {
        return this.mIsMatchWithDarkMode;
    }

    public final int getMTheme() {
        return this.mTheme;
    }

    public final int getMTransparency() {
        return this.mTransparency;
    }

    public abstract int getStrokeColor();

    public abstract int getTextColor();

    public final boolean isDarkMode() {
        return this.mTheme == 0;
    }

    @Nullable
    public BaseThemeInfo setForceContentsThemeColor(int theme) {
        this.mIsForcedTheme = true;
        this.mTheme = theme;
        return this;
    }

    public final void setMAppWidgetId(int i) {
        this.mAppWidgetId = i;
    }

    public final void setMBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public final void setMDarkMode(int i) {
        this.mDarkMode = i;
    }

    public final void setMIsForcedTheme(boolean z) {
        this.mIsForcedTheme = z;
    }

    public final void setMIsMatchWithDarkMode(boolean z) {
        this.mIsMatchWithDarkMode = z;
    }

    public final void setMTheme(int i) {
        this.mTheme = i;
    }

    public final void setMTransparency(int i) {
        this.mTransparency = i;
    }

    @NotNull
    public String toString() {
        int i = this.mBackgroundColor;
        int i2 = this.mTransparency;
        int i4 = this.mDarkMode;
        int i5 = this.mTheme;
        boolean z = this.mIsMatchWithDarkMode;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "ThemeInfo# background color ", " , transparency : ", " , darkMode : ");
        AbstractC2821a.m2235z(sbM1173s, i4, i5, " , theme : ", " , isMatchWithDarkMode : ");
        sbM1173s.append(z);
        return sbM1173s.toString();
    }

    public BaseThemeInfo(@Nullable Context context, int i) {
        this.mAppWidgetId = i;
        BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
        this.mTransparency = companion.getReverseTransparency(i);
        this.mBackgroundColor = companion.getBackgroundColor(i);
        int darkMode = companion.getDarkMode(i);
        this.mDarkMode = darkMode;
        this.mIsMatchWithDarkMode = BaseWidgetUtils.INSTANCE.isMatchWithDarkModeAndNightMode(context, darkMode);
        initTheme(context);
        Logger.m8697d(TAG, toString());
    }
}
