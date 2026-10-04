package com.samsung.android.support.senl.addons.base.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.FoldStateCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0016\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/utils/FeatureInfo;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "SETTINGS_PREFS_NAME", "SETTINGS_HIDE_NAVIGATION_BAR_WHEN_WRITING", "mIsNavigationBarEnabled", "", "isEnabledToHideNavigationBar", "setEnabledToHideNavigationBar", "", "value", "isHideNavigationBarEnable", "hideNavigationBar", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "decor", "Landroid/view/View;", "isSupportHideNavigationOption", "isDefaultHideNavigationOptionEnabled", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FeatureInfo {

    @NotNull
    private static final String SETTINGS_HIDE_NAVIGATION_BAR_WHEN_WRITING = "settings_hide_navigation_bar_when_writing";

    @NotNull
    public static final String SETTINGS_PREFS_NAME = "Settings";
    private static boolean mIsNavigationBarEnabled;

    @NotNull
    public static final FeatureInfo INSTANCE = new FeatureInfo();

    @NotNull
    private static final String TAG = Logger.createBrushTag("FeatureInfo");

    private FeatureInfo() {
    }

    @JvmStatic
    public static final boolean hideNavigationBar(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        return INSTANCE.hideNavigationBar(activity, decorView);
    }

    private final boolean isDefaultHideNavigationOptionEnabled() {
        if (!isSupportHideNavigationOption()) {
            return false;
        }
        if (!PlatformUtil.isTabletModel()) {
            FoldStateCompat.Companion companion = FoldStateCompat.INSTANCE;
            if (!companion.getInstance().isFoldableDevice() || companion.getInstance().getFoldType() != 1) {
                return false;
            }
        }
        return true;
    }

    private final boolean isEnabledToHideNavigationBar() {
        return mIsNavigationBarEnabled;
    }

    private final boolean isHideNavigationBarEnable() {
        boolean z;
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        if (companion.getInstance("Settings").contains("settings_hide_navigation_bar_when_writing")) {
            z = companion.getInstance("Settings").getBoolean("settings_hide_navigation_bar_when_writing", isDefaultHideNavigationOptionEnabled());
        } else {
            boolean z2 = isSupportHideNavigationOption() && isDefaultHideNavigationOptionEnabled();
            companion.getInstance("Settings").putBoolean("settings_hide_navigation_bar_when_writing", z2);
            z = z2;
        }
        AbstractC6670b.m4764y("isHideNavigationBarHideModeEnable# ", TAG, z);
        return z;
    }

    private final boolean isSupportHideNavigationOption() {
        return PlatformUtil.isSpenModel() && InputMethodCompat.INSTANCE.hasSoftKey() && Build.VERSION.SDK_INT >= 29;
    }

    private final void setEnabledToHideNavigationBar(boolean value) {
        mIsNavigationBarEnabled = value;
    }

    @NotNull
    public final String getTAG() {
        return TAG;
    }

    public final boolean hideNavigationBar(@NotNull Activity activity, @NotNull View decor) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(decor, "decor");
        setEnabledToHideNavigationBar(isHideNavigationBarEnable());
        if (!isEnabledToHideNavigationBar()) {
            return false;
        }
        decor.setSystemUiVisibility(decor.getSystemUiVisibility() | InputDeviceCompat.SOURCE_TOUCHSCREEN);
        return true;
    }
}
