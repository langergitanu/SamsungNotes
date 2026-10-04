package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.Display;
import com.samsung.android.support.senl.p145cm.base.framework.app.ConfigurationModelCompat;
import com.samsung.android.support.senl.p145cm.base.framework.observer.SettingsContentObserver;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.base.common.util.PinnedEdge;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.ConfigurationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p196io.CloseableKt;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020+J\u0010\u0010/\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u0005H\u0003J\b\u00102\u001a\u00020+H\u0002J\u0010\u00103\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u00104\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\b\u00106\u001a\u00020+H\u0002J\b\u00107\u001a\u00020+H\u0002J\b\u00108\u001a\u00020+H\u0002J\b\u0010:\u001a\u00020+H\u0002J\b\u0010;\u001a\u00020+H\u0002J\u0010\u0010<\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010=\u001a\u00020+H\u0002J\b\u0010>\u001a\u00020+H\u0002J\b\u0010?\u001a\u00020+H\u0002J\u0006\u0010@\u001a\u00020\u0017J\b\u0010B\u001a\u00020\u0017H\u0007J\u0006\u0010C\u001a\u00020\u0017J\u0006\u0010E\u001a\u00020+J\b\u0010F\u001a\u00020+H\u0002J\b\u0010G\u001a\u00020+H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u001e\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u001e\u0010\"\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u001e\u0010#\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u001e\u0010$\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u001e\u0010%\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u001e\u0010&\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u001e\u0010'\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u001e\u0010)\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u000e\u00105\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u001cR\u0011\u0010A\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\bA\u0010\u001cR\u0011\u0010D\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\bD\u0010\u001cR\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/statical/ConfigurationModel;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SETTINGS_AOD_MODE", "SETTINGS_LOCK_SCREEN_ALLOW_ROTATION", "SETTINGS_PEN_DETECT_MODE_DISABLED", "SETTINGS_GESTURE_NAVIGATION_BAR", "SETTINGS_TASK_BAR", "FILE_PATH_SUPPORT_AOP_MODE", "FILE_PATH_EPEN_INSERT", "ROTATION_PERMITTED_PLATFORM_VERSION", "", "SCREEN_TIME_OUT_DEFAULT_VALUE", "SCREEN_TIME_OUT_MIN_VALUE", "aodPinnedPreviewFirstVersion", "mContentResolver", "Landroid/content/ContentResolver;", "mPinnedEdge", "Lcom/samsung/android/support/senl/nt/base/common/util/PinnedEdge;", "mHasSWNavigation", "", "mHasGestureNavigation", "mHasAODServiceMetaData", "value", "isMirrorDisplayExisted", "()Z", "isAODEnabled", "aODPinnedPreviewVersion", "getAODPinnedPreviewVersion", "()I", "isUseScopedStorage", "isSupportNavigationRotation", "isSupportRotation", "isSupportAOP", "isUseMultiplePens", "isTaskBarEnabled", "screenTimeOut", "getScreenTimeOut", "isPreInitialized", "init", "", "context", "Landroid/content/Context;", "registerObservers", "initMirrorDisplayExisted", "getDisplayType", "fieldName", "initAODEnabled", "initHasAODServiceMetaData", "initAODPinnedPreviewVersion", "VERSION_CODES_R", "initUseScopedStorage", "initSupportNavigationRotation", "initSupportRotation", "isAOPAlwaysSupported", "initSupportAOP", "initUseMultiplePens", "initHasSWNavigation", "initHasGestureNavigation", "initTaskBarEnabled", "initScreenTimeOut", "hasAODServiceMetaData", "isPenAttached", "hasSWNavigation", "hasGestureNavigation", "isPinnedPanelRunning", "release", "registerSettingsContentObserver", "unregisterSettingsContentObserver", "mAODSettingsCallback", "Lcom/samsung/android/support/senl/cm/base/framework/observer/SettingsContentObserver$SettingsContentChangedCallback;", "mAccelerometerRotationSettingsCallback", "mLockScreenRotationSettingsCallback", "mGestureNavigationSettingsCallback", "mScreenTimeOutSettingsCallback", "mTaskBarSettingsCallback", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ConfigurationModel {

    @NotNull
    private static final String FILE_PATH_EPEN_INSERT = "/sys/class/sec/sec_epen/epen_insert";

    @NotNull
    private static final String FILE_PATH_SUPPORT_AOP_MODE = "/sys/class/sec/sec_epen/input/device/of_node/wacom,support_aop_mode";
    private static final int ROTATION_PERMITTED_PLATFORM_VERSION = 100100;
    private static final int SCREEN_TIME_OUT_DEFAULT_VALUE = 30000;
    private static final int SCREEN_TIME_OUT_MIN_VALUE = 15000;

    @NotNull
    private static final String SETTINGS_AOD_MODE = "aod_mode";

    @NotNull
    private static final String SETTINGS_GESTURE_NAVIGATION_BAR = "navigation_bar_gesture_while_hidden";

    @NotNull
    private static final String SETTINGS_LOCK_SCREEN_ALLOW_ROTATION = "lock_screen_allow_rotation";

    @NotNull
    private static final String SETTINGS_PEN_DETECT_MODE_DISABLED = "pen_detect_mode_disabled";

    @NotNull
    private static final String SETTINGS_TASK_BAR = "task_bar";
    private static final int VERSION_CODES_R = 30;
    public static final int aodPinnedPreviewFirstVersion = 1;
    private static boolean isMirrorDisplayExisted;
    private static boolean isPreInitialized;
    private static boolean isSupportNavigationRotation;
    private static boolean isSupportRotation;
    private static boolean isTaskBarEnabled;
    private static boolean isUseMultiplePens;
    private static boolean isUseScopedStorage;

    @NotNull
    private static final SettingsContentObserver.SettingsContentChangedCallback mAODSettingsCallback;

    @NotNull
    private static final SettingsContentObserver.SettingsContentChangedCallback mAccelerometerRotationSettingsCallback;

    @Nullable
    private static ContentResolver mContentResolver;

    @NotNull
    private static final SettingsContentObserver.SettingsContentChangedCallback mGestureNavigationSettingsCallback;
    private static boolean mHasGestureNavigation;

    @NotNull
    private static final SettingsContentObserver.SettingsContentChangedCallback mLockScreenRotationSettingsCallback;

    @Nullable
    private static PinnedEdge mPinnedEdge;

    @NotNull
    private static final SettingsContentObserver.SettingsContentChangedCallback mScreenTimeOutSettingsCallback;

    @NotNull
    private static final SettingsContentObserver.SettingsContentChangedCallback mTaskBarSettingsCallback;

    @NotNull
    public static final ConfigurationModel INSTANCE = new ConfigurationModel();

    @NotNull
    private static final String TAG = SOLogger.createTag("ConfigurationModel");
    private static boolean mHasSWNavigation = true;
    private static boolean mHasAODServiceMetaData = true;
    private static boolean isAODEnabled = true;
    private static int aODPinnedPreviewVersion = -1;
    private static boolean isSupportAOP = true;
    private static int screenTimeOut = 30000;

    static {
        final int i = 0;
        mAODSettingsCallback = new SettingsContentObserver.SettingsContentChangedCallback() { // from class: O3.a
            @Override // com.samsung.android.support.senl.cm.base.framework.observer.SettingsContentObserver.SettingsContentChangedCallback
            public final void onChanged(boolean z, Uri uri) {
                switch (i) {
                    case 0:
                        ConfigurationModel.mAODSettingsCallback$lambda$2(z, uri);
                        break;
                    case 1:
                        ConfigurationModel.mAccelerometerRotationSettingsCallback$lambda$3(z, uri);
                        break;
                    case 2:
                        ConfigurationModel.mLockScreenRotationSettingsCallback$lambda$4(z, uri);
                        break;
                    case 3:
                        ConfigurationModel.mGestureNavigationSettingsCallback$lambda$5(z, uri);
                        break;
                    case 4:
                        ConfigurationModel.mScreenTimeOutSettingsCallback$lambda$6(z, uri);
                        break;
                    default:
                        ConfigurationModel.mTaskBarSettingsCallback$lambda$7(z, uri);
                        break;
                }
            }
        };
        final int i2 = 1;
        mAccelerometerRotationSettingsCallback = new SettingsContentObserver.SettingsContentChangedCallback() { // from class: O3.a
            @Override // com.samsung.android.support.senl.cm.base.framework.observer.SettingsContentObserver.SettingsContentChangedCallback
            public final void onChanged(boolean z, Uri uri) {
                switch (i2) {
                    case 0:
                        ConfigurationModel.mAODSettingsCallback$lambda$2(z, uri);
                        break;
                    case 1:
                        ConfigurationModel.mAccelerometerRotationSettingsCallback$lambda$3(z, uri);
                        break;
                    case 2:
                        ConfigurationModel.mLockScreenRotationSettingsCallback$lambda$4(z, uri);
                        break;
                    case 3:
                        ConfigurationModel.mGestureNavigationSettingsCallback$lambda$5(z, uri);
                        break;
                    case 4:
                        ConfigurationModel.mScreenTimeOutSettingsCallback$lambda$6(z, uri);
                        break;
                    default:
                        ConfigurationModel.mTaskBarSettingsCallback$lambda$7(z, uri);
                        break;
                }
            }
        };
        final int i4 = 2;
        mLockScreenRotationSettingsCallback = new SettingsContentObserver.SettingsContentChangedCallback() { // from class: O3.a
            @Override // com.samsung.android.support.senl.cm.base.framework.observer.SettingsContentObserver.SettingsContentChangedCallback
            public final void onChanged(boolean z, Uri uri) {
                switch (i4) {
                    case 0:
                        ConfigurationModel.mAODSettingsCallback$lambda$2(z, uri);
                        break;
                    case 1:
                        ConfigurationModel.mAccelerometerRotationSettingsCallback$lambda$3(z, uri);
                        break;
                    case 2:
                        ConfigurationModel.mLockScreenRotationSettingsCallback$lambda$4(z, uri);
                        break;
                    case 3:
                        ConfigurationModel.mGestureNavigationSettingsCallback$lambda$5(z, uri);
                        break;
                    case 4:
                        ConfigurationModel.mScreenTimeOutSettingsCallback$lambda$6(z, uri);
                        break;
                    default:
                        ConfigurationModel.mTaskBarSettingsCallback$lambda$7(z, uri);
                        break;
                }
            }
        };
        final int i5 = 3;
        mGestureNavigationSettingsCallback = new SettingsContentObserver.SettingsContentChangedCallback() { // from class: O3.a
            @Override // com.samsung.android.support.senl.cm.base.framework.observer.SettingsContentObserver.SettingsContentChangedCallback
            public final void onChanged(boolean z, Uri uri) {
                switch (i5) {
                    case 0:
                        ConfigurationModel.mAODSettingsCallback$lambda$2(z, uri);
                        break;
                    case 1:
                        ConfigurationModel.mAccelerometerRotationSettingsCallback$lambda$3(z, uri);
                        break;
                    case 2:
                        ConfigurationModel.mLockScreenRotationSettingsCallback$lambda$4(z, uri);
                        break;
                    case 3:
                        ConfigurationModel.mGestureNavigationSettingsCallback$lambda$5(z, uri);
                        break;
                    case 4:
                        ConfigurationModel.mScreenTimeOutSettingsCallback$lambda$6(z, uri);
                        break;
                    default:
                        ConfigurationModel.mTaskBarSettingsCallback$lambda$7(z, uri);
                        break;
                }
            }
        };
        final int i6 = 4;
        mScreenTimeOutSettingsCallback = new SettingsContentObserver.SettingsContentChangedCallback() { // from class: O3.a
            @Override // com.samsung.android.support.senl.cm.base.framework.observer.SettingsContentObserver.SettingsContentChangedCallback
            public final void onChanged(boolean z, Uri uri) {
                switch (i6) {
                    case 0:
                        ConfigurationModel.mAODSettingsCallback$lambda$2(z, uri);
                        break;
                    case 1:
                        ConfigurationModel.mAccelerometerRotationSettingsCallback$lambda$3(z, uri);
                        break;
                    case 2:
                        ConfigurationModel.mLockScreenRotationSettingsCallback$lambda$4(z, uri);
                        break;
                    case 3:
                        ConfigurationModel.mGestureNavigationSettingsCallback$lambda$5(z, uri);
                        break;
                    case 4:
                        ConfigurationModel.mScreenTimeOutSettingsCallback$lambda$6(z, uri);
                        break;
                    default:
                        ConfigurationModel.mTaskBarSettingsCallback$lambda$7(z, uri);
                        break;
                }
            }
        };
        final int i7 = 5;
        mTaskBarSettingsCallback = new SettingsContentObserver.SettingsContentChangedCallback() { // from class: O3.a
            @Override // com.samsung.android.support.senl.cm.base.framework.observer.SettingsContentObserver.SettingsContentChangedCallback
            public final void onChanged(boolean z, Uri uri) {
                switch (i7) {
                    case 0:
                        ConfigurationModel.mAODSettingsCallback$lambda$2(z, uri);
                        break;
                    case 1:
                        ConfigurationModel.mAccelerometerRotationSettingsCallback$lambda$3(z, uri);
                        break;
                    case 2:
                        ConfigurationModel.mLockScreenRotationSettingsCallback$lambda$4(z, uri);
                        break;
                    case 3:
                        ConfigurationModel.mGestureNavigationSettingsCallback$lambda$5(z, uri);
                        break;
                    case 4:
                        ConfigurationModel.mScreenTimeOutSettingsCallback$lambda$6(z, uri);
                        break;
                    default:
                        ConfigurationModel.mTaskBarSettingsCallback$lambda$7(z, uri);
                        break;
                }
            }
        };
    }

    private ConfigurationModel() {
    }

    @SuppressLint({"PrivateApi"})
    private final int getDisplayType(String fieldName) {
        try {
            Field declaredField = Display.class.getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            return ((Integer) obj).intValue();
        } catch (Exception unused) {
            SOLogger.INSTANCE.SOLoggerE(TAG, "getDisplayType# exception");
            return -1;
        }
    }

    @JvmStatic
    public static final boolean hasSWNavigation() {
        return mHasSWNavigation;
    }

    private final void initAODEnabled() {
        isAODEnabled = Settings.System.getInt(mContentResolver, SETTINGS_AOD_MODE, 0) == 1;
        AbstractC8014b.m7211m("initAODEnabled# ", isAODEnabled, SOLogger.INSTANCE, TAG);
    }

    private final void initAODPinnedPreviewVersion(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(Constants.ExternalPackageName.AOD_SERVICE, 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            aODPinnedPreviewVersion = applicationInfo.metaData.getInt(Constants.ExternalPackageMetaDataName.AOD_PINNED_PREVIEW_VERSION_META_DATA, -1);
        } catch (Exception unused) {
            aODPinnedPreviewVersion = -1;
        }
        AbstractC8014b.m7206h("initAODPinnedPreviewVersion# ", aODPinnedPreviewVersion, SOLogger.INSTANCE, TAG);
    }

    private final void initHasAODServiceMetaData(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(Constants.ExternalPackageName.AOD_SERVICE, 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            mHasAODServiceMetaData = applicationInfo.metaData.getBoolean("com.samsung.android.app.aodservice.settings.AODPinnedPreviewService", false);
        } catch (Exception unused) {
            mHasAODServiceMetaData = false;
        }
        AbstractC8014b.m7211m("initHasAODServiceMetaData# ", mHasAODServiceMetaData, SOLogger.INSTANCE, TAG);
    }

    private final void initHasGestureNavigation() {
        mHasGestureNavigation = Settings.Global.getInt(mContentResolver, SETTINGS_GESTURE_NAVIGATION_BAR, 0) > 0;
        AbstractC8014b.m7211m("initHasGestureNavigation# ", mHasGestureNavigation, SOLogger.INSTANCE, TAG);
    }

    private final void initHasSWNavigation(Context context) {
        if (!InputMethodCompat.INSTANCE.getInstance().configShowNavigationBar(context)) {
            mHasSWNavigation = false;
        }
        AbstractC8014b.m7211m("initHasSWNavigation# ", mHasSWNavigation, SOLogger.INSTANCE, TAG);
    }

    private final void initMirrorDisplayExisted(Context context) {
        try {
            int displayType = getDisplayType("TYPE_BUILT_IN");
            int displayType2 = getDisplayType("TYPE_HDMI");
            int displayType3 = getDisplayType("TYPE_WIFI");
            int displayType4 = getDisplayType("TYPE_OVERLAY");
            int displayType5 = getDisplayType("TYPE_VIRTUAL");
            int displayType6 = getDisplayType("TYPE_UNKNOWN");
            Object systemService = context.getSystemService("display");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
            Display[] displays = ((DisplayManager) systemService).getDisplays();
            StringBuilder sb = new StringBuilder();
            Iterator it = ArrayIteratorKt.iterator(displays);
            while (it.hasNext()) {
                Display display = (Display) it.next();
                Iterator it2 = it;
                Object objInvoke = display.getClass().getMethod("getType", null).invoke(display, null);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                int iIntValue = ((Integer) objInvoke).intValue();
                if (iIntValue != displayType) {
                    if (iIntValue == displayType2) {
                        isMirrorDisplayExisted = true;
                        sb.append("TYPE_HDMI");
                    } else if (iIntValue == displayType3) {
                        isMirrorDisplayExisted = true;
                        sb.append("TYPE_WIFI");
                    } else if (iIntValue == displayType4) {
                        sb.append("TYPE_OVERLAY");
                    } else if (iIntValue == displayType5) {
                        sb.append("TYPE_VIRTUAL");
                    } else if (iIntValue == displayType6) {
                        sb.append("TYPE_UNKNOWN");
                    }
                }
                it = it2;
            }
            SOLogger.INSTANCE.SOLoggerD(TAG, "initMirrorDisplayExisted# lDisplayType " + ((Object) sb));
        } catch (Exception e) {
            AbstractC0000a.m24u("initMirrorDisplayExisted# exception ", e.getMessage(), SOLogger.INSTANCE, TAG);
        }
        AbstractC8014b.m7211m("initMirrorDisplayExisted# ", isMirrorDisplayExisted, SOLogger.INSTANCE, TAG);
    }

    private final void initScreenTimeOut() {
        int i = Settings.System.getInt(mContentResolver, "screen_off_timeout", 30000);
        screenTimeOut = i;
        if (i < 15000) {
            screenTimeOut = 15000;
        }
        AbstractC8014b.m7206h("initScreenTimeOut# ", screenTimeOut, SOLogger.INSTANCE, TAG);
    }

    private final void initSupportAOP() {
        if (isAOPAlwaysSupported()) {
            SOLogger.INSTANCE.SOLoggerD(TAG, "initSupportAOP# always supported");
            isSupportAOP = true;
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_PATH_SUPPORT_AOP_MODE);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr, 0, fileInputStream.available());
                fileInputStream.close();
                if ('1' != new String(bArr, Charsets.UTF_8).charAt(0)) {
                    isSupportAOP = false;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileInputStream, null);
            } finally {
            }
        } catch (Exception e) {
            AbstractC0000a.m24u("initSupportAOP# ", e.getMessage(), SOLogger.INSTANCE, TAG);
            isSupportAOP = false;
        }
        AbstractC8014b.m7211m("initSupportAOP# ", isSupportAOP, SOLogger.INSTANCE, TAG);
    }

    private final void initSupportNavigationRotation() {
        if (DeviceUtils.isTabletModel() || ModelFeature.getFeature().isFoldableModel()) {
            isSupportNavigationRotation = true;
        }
        AbstractC8014b.m7211m("initSupportNavigationRotation# ", isSupportNavigationRotation, SOLogger.INSTANCE, TAG);
    }

    private final void initSupportRotation() {
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        boolean z = false;
        sOLogger.SOLoggerD(str, "initSupportRotation# SemPlatformVersion : " + DeviceInfo.getSemPlatformVersionInt(0));
        if (DeviceInfo.getSemPlatformVersionInt(0) >= 100100) {
            boolean z2 = Settings.System.getInt(mContentResolver, "accelerometer_rotation", 0) > 0;
            boolean z3 = Settings.System.getInt(mContentResolver, SETTINGS_LOCK_SCREEN_ALLOW_ROTATION, 0) > 0;
            sOLogger.SOLoggerD(str, "initSupportRotation# systemRotationSetting/lockScreenRotationSetting : " + z2 + "/" + z3);
            if (isSupportNavigationRotation) {
                isSupportRotation = z2;
            } else {
                if (z2 && z3) {
                    z = true;
                }
                isSupportRotation = z;
            }
        }
        AbstractC8014b.m7211m("initSupportRotation# ", isSupportRotation, sOLogger, str);
    }

    private final void initTaskBarEnabled() {
        isTaskBarEnabled = Settings.System.getInt(mContentResolver, SETTINGS_TASK_BAR, 0) > 0 || Settings.Global.getInt(mContentResolver, SETTINGS_TASK_BAR, 0) > 0;
        AbstractC8014b.m7211m("initTaskBarEnabled# ", isTaskBarEnabled, SOLogger.INSTANCE, TAG);
    }

    private final void initUseMultiplePens() {
        try {
            boolean z = true;
            if (Settings.System.getInt(mContentResolver, SETTINGS_PEN_DETECT_MODE_DISABLED, 1) > 0) {
                z = false;
            }
            isUseMultiplePens = z;
        } catch (SecurityException e) {
            AbstractC0000a.m24u("initUseMultiplePens# ", e.getMessage(), SOLogger.INSTANCE, TAG);
        }
        AbstractC8014b.m7211m("initUseMultiplePens# ", isUseMultiplePens, SOLogger.INSTANCE, TAG);
    }

    private final void initUseScopedStorage() {
        if (Build.VERSION.SDK_INT >= 30) {
            isUseScopedStorage = true;
        }
        AbstractC8014b.m7211m("initUseScopedStorage# ", isUseScopedStorage, SOLogger.INSTANCE, TAG);
    }

    private final boolean isAOPAlwaysSupported() {
        return ConfigurationModelCompat.INSTANCE.getInstance().isAOPAlwaysSupported();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mAODSettingsCallback$lambda$2(boolean z, Uri uri) {
        INSTANCE.initAODEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mAccelerometerRotationSettingsCallback$lambda$3(boolean z, Uri uri) {
        INSTANCE.initSupportRotation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mGestureNavigationSettingsCallback$lambda$5(boolean z, Uri uri) {
        INSTANCE.initHasGestureNavigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mLockScreenRotationSettingsCallback$lambda$4(boolean z, Uri uri) {
        INSTANCE.initSupportRotation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mScreenTimeOutSettingsCallback$lambda$6(boolean z, Uri uri) {
        INSTANCE.initScreenTimeOut();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mTaskBarSettingsCallback$lambda$7(boolean z, Uri uri) {
        INSTANCE.initTaskBarEnabled();
    }

    private final void registerSettingsContentObserver() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "registerSettingsContentObserver#");
        SettingsContentObserver.Companion companion = SettingsContentObserver.INSTANCE;
        companion.getInstance().addSettingsContentChangedCallback(mAODSettingsCallback, SETTINGS_AOD_MODE, 0);
        if (DeviceInfo.getSemPlatformVersionInt(0) >= 100100) {
            companion.getInstance().addSettingsContentChangedCallback(mAccelerometerRotationSettingsCallback, "accelerometer_rotation", 0);
            companion.getInstance().addSettingsContentChangedCallback(mLockScreenRotationSettingsCallback, SETTINGS_LOCK_SCREEN_ALLOW_ROTATION, 0);
        }
        companion.getInstance().addSettingsContentChangedCallback(mGestureNavigationSettingsCallback, SETTINGS_GESTURE_NAVIGATION_BAR, 1);
        companion.getInstance().addSettingsContentChangedCallback(mScreenTimeOutSettingsCallback, "screen_off_timeout", 0);
        companion.getInstance().addSettingsContentChangedCallback(mTaskBarSettingsCallback, SETTINGS_TASK_BAR, 0);
        PinnedEdge pinnedEdge = mPinnedEdge;
        if (pinnedEdge != null) {
            pinnedEdge.registerSettingsContentObserver();
        }
    }

    private final void unregisterSettingsContentObserver() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "unregisterSettingsContentObserver#");
        SettingsContentObserver.Companion companion = SettingsContentObserver.INSTANCE;
        companion.getInstance().removeSettingsContentChangedCallback(mAODSettingsCallback);
        companion.getInstance().removeSettingsContentChangedCallback(mAccelerometerRotationSettingsCallback);
        companion.getInstance().removeSettingsContentChangedCallback(mLockScreenRotationSettingsCallback);
        companion.getInstance().removeSettingsContentChangedCallback(mGestureNavigationSettingsCallback);
        companion.getInstance().removeSettingsContentChangedCallback(mScreenTimeOutSettingsCallback);
        companion.getInstance().removeSettingsContentChangedCallback(mTaskBarSettingsCallback);
        PinnedEdge pinnedEdge = mPinnedEdge;
        if (pinnedEdge != null) {
            pinnedEdge.unregisterSettingsContentObserver();
        }
    }

    public final int getAODPinnedPreviewVersion() {
        return aODPinnedPreviewVersion;
    }

    public final int getScreenTimeOut() {
        return screenTimeOut;
    }

    public final boolean hasAODServiceMetaData() {
        return mHasAODServiceMetaData;
    }

    public final boolean hasGestureNavigation() {
        return mHasGestureNavigation;
    }

    public final void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        isPreInitialized = true;
        mContentResolver = context.getContentResolver();
        mPinnedEdge = new PinnedEdge(context);
        initMirrorDisplayExisted(context);
        initAODEnabled();
        initHasAODServiceMetaData(context);
        initAODPinnedPreviewVersion(context);
        initUseScopedStorage();
        initSupportNavigationRotation();
        initSupportRotation();
        initSupportAOP();
        initUseMultiplePens();
        initHasSWNavigation(context);
        initHasGestureNavigation();
        initTaskBarEnabled();
        initScreenTimeOut();
    }

    public final boolean isAODEnabled() {
        return isAODEnabled;
    }

    public final boolean isMirrorDisplayExisted() {
        return isMirrorDisplayExisted;
    }

    public final boolean isPenAttached() {
        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_PATH_EPEN_INSERT);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr, 0, fileInputStream.available());
                fileInputStream.close();
                z = '1' == new String(bArr, Charsets.UTF_8).charAt(0);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileInputStream, null);
            } finally {
            }
        } catch (Exception e) {
            AbstractC0000a.m24u("isPenAttached# ", e.getMessage(), SOLogger.INSTANCE, TAG);
        }
        AbstractC8014b.m7211m("isPenAttached# ", z, SOLogger.INSTANCE, TAG);
        return z;
    }

    public final boolean isPinnedPanelRunning() {
        PinnedEdge pinnedEdge = mPinnedEdge;
        if (pinnedEdge != null) {
            return pinnedEdge.getIsPinnedPanelRunning();
        }
        return false;
    }

    public final boolean isPreInitialized() {
        return isPreInitialized;
    }

    public final boolean isSupportAOP() {
        return isSupportAOP;
    }

    public final boolean isSupportNavigationRotation() {
        return isSupportNavigationRotation;
    }

    public final boolean isSupportRotation() {
        return isSupportRotation;
    }

    public final boolean isTaskBarEnabled() {
        return isTaskBarEnabled;
    }

    public final boolean isUseMultiplePens() {
        return isUseMultiplePens;
    }

    public final boolean isUseScopedStorage() {
        return isUseScopedStorage;
    }

    public final void registerObservers() {
        registerSettingsContentObserver();
    }

    public final void release() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "release#");
        isPreInitialized = false;
        unregisterSettingsContentObserver();
    }
}
