package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NavigationBarUtil {
    private static final String TAG = Logger.createTag("NavigationBarUtil");
    private static final List<OnChangedListener> mOnChangedListener = new ArrayList();
    private static final Set<Class<?>> mExcludedListNavigationBar = new HashSet();
    private static final Object mLock = new Object();
    private static boolean mIsNavigationBarEnabled = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnChangedListener {
        void onHidedNavigation(boolean z);
    }

    public static void addNavigationHideModeChangeListener(@NonNull OnChangedListener onChangedListener) {
        synchronized (mLock) {
            mOnChangedListener.add(onChangedListener);
        }
    }

    public static void clearHideNavigationBarFlag(Activity activity) {
        clearHideNavigationBarFlag(activity.getWindow().getDecorView());
    }

    public static void enrollExcludedListToHideNavigationBar(Class<?> cls) {
        mExcludedListNavigationBar.add(cls);
    }

    public static boolean hideNavigationBar(Activity activity) {
        return hideNavigationBar(activity, activity.getWindow().getDecorView());
    }

    public static boolean isEnabledToHideNavigationBar() {
        return mIsNavigationBarEnabled;
    }

    public static boolean isHideNavigationBarEnable() {
        boolean z;
        if (!CommonUtils.isSupportHideNavigationOption()) {
            return false;
        }
        if (SharedPreferencesCompat.getInstance("Settings").contains(SettingsConstants.SETTINGS_HIDE_NAVIGATION_BAR_WHILE_WRITING)) {
            z = SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_HIDE_NAVIGATION_BAR_WHILE_WRITING, CommonUtils.isDefaultHideNavigationOptionEnabled());
        } else {
            boolean zIsDefaultHideNavigationOptionEnabled = CommonUtils.isDefaultHideNavigationOptionEnabled();
            SharedPreferencesCompat.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_HIDE_NAVIGATION_BAR_WHILE_WRITING, zIsDefaultHideNavigationOptionEnabled);
            z = zIsDefaultHideNavigationOptionEnabled;
        }
        AbstractC8014b.m7220v("isHideNavigationBarHideModeEnable# ", TAG, z);
        return z;
    }

    public static void removeNavigationHideModeChangeListener(@NonNull OnChangedListener onChangedListener) {
        synchronized (mLock) {
            mOnChangedListener.remove(onChangedListener);
        }
    }

    public static void setEnabledToHideNavigationBar(boolean z) {
        mIsNavigationBarEnabled = z;
    }

    public static void clearHideNavigationBarFlag(View view) {
        view.setSystemUiVisibility(view.getSystemUiVisibility() & (-4099));
        synchronized (mLock) {
            try {
                Iterator<OnChangedListener> it = mOnChangedListener.iterator();
                while (it.hasNext()) {
                    it.next().onHidedNavigation(false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean hideNavigationBar(Activity activity, View view) {
        if (mExcludedListNavigationBar.contains(activity.getClass())) {
            return false;
        }
        setEnabledToHideNavigationBar(isHideNavigationBarEnable());
        if (!isEnabledToHideNavigationBar() || WindowManagerCompat.getInstance().isMultiWindowMode(activity)) {
            return false;
        }
        view.setSystemUiVisibility(view.getSystemUiVisibility() | InputDeviceCompat.SOURCE_TOUCHSCREEN);
        synchronized (mLock) {
            try {
                Iterator<OnChangedListener> it = mOnChangedListener.iterator();
                while (it.hasNext()) {
                    it.next().onHidedNavigation(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }
}
