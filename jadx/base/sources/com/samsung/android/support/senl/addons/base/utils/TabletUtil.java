package com.samsung.android.support.senl.addons.base.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0010\u001a\u00020\tH\u0007J\b\u0010\u0011\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/utils/TabletUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SMALLEST_WIDTH_TABLET", "", "mIsTabletMode", "", "mIsTabletUi", "getDeviceStableDensity", "checkTabletMode", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "isTabletMode", "isTabletUi", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TabletUtil {
    private static final int SMALLEST_WIDTH_TABLET = 585;
    private static boolean mIsTabletMode;
    private static boolean mIsTabletUi;

    @NotNull
    public static final TabletUtil INSTANCE = new TabletUtil();

    @NotNull
    private static final String TAG = Logger.createTag("TabletUtil");

    private TabletUtil() {
    }

    private final int getDeviceStableDensity() {
        return DisplayMetrics.DENSITY_DEVICE_STABLE;
    }

    @JvmStatic
    public static final boolean isTabletMode() {
        return mIsTabletMode;
    }

    @JvmStatic
    public static final boolean isTabletUi() {
        return mIsTabletUi;
    }

    public final void checkTabletMode(@Nullable Activity activity) {
        mIsTabletMode = false;
        mIsTabletUi = false;
        if (activity == null) {
            return;
        }
        Object systemService = activity.getSystemService("window");
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager != null) {
            try {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                float deviceStableDensity = getDeviceStableDensity() / 160;
                int physicalWidth = defaultDisplay.getMode().getPhysicalWidth();
                int physicalHeight = defaultDisplay.getMode().getPhysicalHeight();
                if (physicalWidth < physicalHeight) {
                    float f = physicalWidth / deviceStableDensity;
                    if (f >= 585.0f) {
                        mIsTabletMode = true;
                        Logger.m7104i(TAG, "checkTabletMode - 1 : " + f + " = " + physicalWidth + " / " + deviceStableDensity);
                    }
                } else {
                    float f4 = physicalHeight / deviceStableDensity;
                    if (f4 >= 585.0f) {
                        mIsTabletMode = true;
                        Logger.m7104i(TAG, "checkTabletMode - 2 : " + f4 + " = " + physicalHeight + " / " + deviceStableDensity);
                    }
                }
                if (PlatformUtil.isTabletModel()) {
                    mIsTabletMode = true;
                    Logger.m7104i(TAG, "checkTabletMode - Device type is tablet");
                }
                if (DesktopModeCompat.INSTANCE.getInstance().isDexMode(activity)) {
                    mIsTabletMode = true;
                    Logger.m7104i(TAG, "checkTabletMode - Dex");
                }
                if (mIsTabletMode) {
                    mIsTabletUi = true;
                    Rect rect = new Rect();
                    defaultDisplay.getRectSize(rect);
                    if ((rect.width() < rect.height() ? rect.width() : rect.height()) < activity.getResources().getDimensionPixelSize(C7944R.dimen.base_menu_min_tablet_width)) {
                        Logger.m7101e(TAG, "checkTabletMode - window size is short!");
                        mIsTabletUi = false;
                    }
                }
            } catch (Throwable th) {
                Logger.m7104i(TAG, "checkTabletMode - ".concat(mIsTabletMode ? "tablet" : "phone"));
                throw th;
            }
        }
        Logger.m7104i(TAG, "checkTabletMode - ".concat(mIsTabletMode ? "tablet" : "phone"));
    }
}
