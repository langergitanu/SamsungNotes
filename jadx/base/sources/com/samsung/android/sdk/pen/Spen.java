package com.samsung.android.sdk.pen;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.core.p139ai.sdkcommon.ExtensionConst;
import com.samsung.android.sdk.SsdkInterface;
import com.samsung.android.sdk.handwriting.Recognizer;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.spen.libwrapper.FloatingFeatureWrapper;
import com.samsung.android.spen.libwrapper.PackageManagerWrapper;
import com.samsung.android.spen.libwrapper.PointerIconWrapper;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016J\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\rH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0007J\"\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0007J*\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\tH\u0007J4\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010\u001b\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u001c\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/Spen;", "Lcom/samsung/android/sdk/SsdkInterface;", "<init>", "()V", "mContext", "Landroid/content/Context;", "mCreateMode", "", "isPointerIconEnabled", "", "()Z", "getVersionCode", "getVersionName", "", "isFeatureEnabled", "type", "initialize", "", "context", "SPEN_SDK_4_0_0", "input", "loadLibrary", "libraryName", "maxCacheSize", "createMode", "isForce32BitMode", "packageName", "printVersion", "insertLog", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Spen.kt\ncom/samsung/android/sdk/pen/Spen\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,812:1\n1#2:813\n*E\n"})
public final class Spen implements SsdkInterface {
    public static final boolean BUILD_HME = true;
    private static final int DEFAULT_MAX_CACHE_SIZE = 5;
    public static final int DEVICE_PEN = 0;

    @JvmField
    public static boolean IS_SPEN_PRELOAD_MODE = false;

    @NotNull
    private static final String LOG_TAG = "SpenSdk";
    public static final int POINTER_ICON = 1;
    private static final int SPEN_APP_LIB_MODE = 2;

    @NotNull
    private static final String SPEN_NATIVE_PACKAGE_NAME_64BIT = "com.samsung.android.sdk.spen30_64";

    @NotNull
    private static final String SPEN_NATIVE_PACKAGE_NAME_PRELOAD = "com.samsung.android.sdk.spenv10";
    public static final int SPEN_STATIC_LIB_MODE = 1;
    public static final int TEXT_RECOGNIZER = 2;

    @NotNull
    private static final String VERSION = "7.0.0";
    private static final int VERSION_LEVEL = 1;
    private static boolean mIsInitialized;

    /* JADX INFO: renamed from: os */
    private static int f4940os;

    @Nullable
    private Context mContext;
    private int mCreateMode;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String SPEN_NATIVE_PACKAGE_NAME = "com.samsung.android.sdk.spen30";

    @NotNull
    private static String spenPackageName = SPEN_NATIVE_PACKAGE_NAME;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007J\u0012\u0010\u001f\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007J\b\u0010 \u001a\u00020\u0007H\u0007J\u0012\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010#\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007J\"\u0010$\u001a\u00020%2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0007J\u001a\u0010(\u001a\u00020%2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010)\u001a\u00020\u0007H\u0007J\t\u0010*\u001a\u00020\u0007H\u0083 J\u0019\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u0007H\u0083 J!\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0083 J)\u00100\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0083 J\u0011\u00101\u001a\u00020%2\u0006\u00102\u001a\u000203H\u0083 R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R&\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r8\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u00064"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/Spen$Companion;", "", "<init>", "()V", "IS_SPEN_PRELOAD_MODE", "", "SPEN_STATIC_LIB_MODE", "", "SPEN_APP_LIB_MODE", "DEVICE_PEN", "POINTER_ICON", "TEXT_RECOGNIZER", "SPEN_NATIVE_PACKAGE_NAME", "", "SPEN_NATIVE_PACKAGE_NAME_64BIT", "SPEN_NATIVE_PACKAGE_NAME_PRELOAD", "VERSION", "VERSION_LEVEL", "mIsInitialized", "DEFAULT_MAX_CACHE_SIZE", "value", "spenPackageName", "getSpenPackageName$annotations", "getSpenPackageName", "()Ljava/lang/String;", NetworkConfig.CLIENTS_OS, "BUILD_HME", "LOG_TAG", "hasPenFeature", "context", "Landroid/content/Context;", "isPenInboxed", IdentityApiContract.Parameter.OS_TYPE, "isLoadedSpen", "libraryName", "isTextRecognizerEnabled", "updateSDK", "", "isWifiOn", "isMobileNetworkOn", "trimCache", "maxCacheSize", "SPenSdk_OSType", "SPenSdk_trimCache", "appFilePath", "SPenSdk_init", "width", "height", "SPenSdk_init2", "SPenSdk_setScreenDensity", "density", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSpen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Spen.kt\ncom/samsung/android/sdk/pen/Spen$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,812:1\n1#2:813\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private final int SPenSdk_OSType() {
            return Spen.SPenSdk_OSType();
        }

        @JvmStatic
        private final boolean SPenSdk_init(String appFilePath, int width, int height) {
            return Spen.SPenSdk_init(appFilePath, width, height);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean SPenSdk_init2(String appFilePath, int width, int height, int maxCacheSize) {
            return Spen.SPenSdk_init2(appFilePath, width, height, maxCacheSize);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void SPenSdk_setScreenDensity(float density) {
            Spen.SPenSdk_setScreenDensity(density);
        }

        @JvmStatic
        private final boolean SPenSdk_trimCache(String appFilePath, int maxCacheSize) {
            return Spen.SPenSdk_trimCache(appFilePath, maxCacheSize);
        }

        @JvmStatic
        public static /* synthetic */ void getSpenPackageName$annotations() {
        }

        @NotNull
        public final String getSpenPackageName() {
            return Spen.spenPackageName;
        }

        @JvmStatic
        public final boolean hasPenFeature(@Nullable Context context) {
            if (context == null) {
                Log.e(Spen.LOG_TAG, "hasPenFeature - invalid argument");
                return false;
            }
            try {
                if (FloatingFeatureWrapper.create(context).getInt("SEC_FLOATING_FEATURE_FRAMEWORK_CONFIG_SPEN_VERSION") > 0) {
                    return true;
                }
            } catch (PlatformException e) {
                e.printStackTrace();
            }
            PackageManager packageManager = context.getPackageManager();
            return packageManager != null && (packageManager.hasSystemFeature("org.chromium.arc") || packageManager.hasSystemFeature("org.chromium.arc.device_management") || packageManager.hasSystemFeature("com.sec.feature.spen_usp"));
        }

        @JvmStatic
        public final boolean isLoadedSpen(@Nullable String libraryName) {
            return true;
        }

        @JvmStatic
        public final boolean isPenInboxed(@Nullable Context context) {
            int systemFeatureLevel;
            if (context == null) {
                Log.e(Spen.LOG_TAG, "isPenInboxed - invalid argument");
                return false;
            }
            try {
                systemFeatureLevel = PackageManagerWrapper.create(context).getSystemFeatureLevel("com.sec.feature.spen_usp");
                Log.i(Spen.LOG_TAG, "SystemFeatureLevel = " + systemFeatureLevel);
            } catch (PlatformException e) {
                e.printStackTrace();
            }
            return systemFeatureLevel % 10 == 5;
        }

        @JvmStatic
        public final boolean isTextRecognizerEnabled(@Nullable Context context) {
            if (!Spen.mIsInitialized || context == null) {
                return false;
            }
            if (Recognizer.isTextRecognizerAvailable(context)) {
                return true;
            }
            boolean zHasPenFeature = hasPenFeature(context);
            AbstractC4539a.m3208r("Recognizer.isTextRecognizerAvailable() = false, so check hasPenFeature() = ", Spen.LOG_TAG, zHasPenFeature);
            return zHasPenFeature;
        }

        @JvmStatic
        public final int osType() {
            if (Spen.f4940os != 0) {
                return Spen.f4940os;
            }
            try {
                Spen.f4940os = SPenSdk_OSType();
                return Spen.f4940os;
            } catch (UnsatisfiedLinkError unused) {
                Log.i(Spen.LOG_TAG, "osType - old so");
                Spen.f4940os = 32;
                return Spen.f4940os;
            }
        }

        @JvmStatic
        public final void trimCache(@Nullable Context context, int maxCacheSize) {
            if (context == null) {
                Log.e(Spen.LOG_TAG, "trimCache() - context can not be null.");
                return;
            }
            if (!Spen.mIsInitialized) {
                Log.e(Spen.LOG_TAG, "trimCache() - SPen is not initialized.");
                return;
            }
            String absolutePath = context.getFilesDir().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            if (!SPenSdk_trimCache(absolutePath, maxCacheSize)) {
                throw new IllegalStateException("Fail to trim SDK Cache directory.");
            }
        }

        @JvmStatic
        public final void updateSDK(@Nullable Context context, boolean isWifiOn, boolean isMobileNetworkOn) {
            if (!Spen.mIsInitialized || context == null) {
                return;
            }
            AbstractC6670b.m4758s("Update SDK : isWifiOn = ", ", isMobileNetworkOn = ", Spen.LOG_TAG, isWifiOn, isMobileNetworkOn);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int SPenSdk_OSType();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean SPenSdk_init(String str, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean SPenSdk_init2(String str, int i, int i2, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void SPenSdk_setScreenDensity(float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean SPenSdk_trimCache(String str, int i);

    @NotNull
    public static final String getSpenPackageName() {
        return INSTANCE.getSpenPackageName();
    }

    @JvmStatic
    public static final boolean hasPenFeature(@Nullable Context context) {
        return INSTANCE.hasPenFeature(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void insertLog(Context context) {
        int i = -1;
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager != null ? packageManager.getPackageInfo("com.samsung.android.providers.context", 128) : null;
                if (packageInfo != null) {
                    i = packageInfo.versionCode;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.i(LOG_TAG, "Could not find ContextProvider");
            }
        }
        AbstractC2322a.m1631u(i, "versionCode: ", LOG_TAG);
        if (i <= 1) {
            Log.i(LOG_TAG, "Add com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission");
            return;
        }
        if (context == null || context.checkCallingOrSelfPermission("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY") != 0) {
            Log.i(LOG_TAG, " com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY is not allowed ");
            return;
        }
        ContentValues contentValues = new ContentValues();
        Package r32 = Spen.class.getPackage();
        String name = r32 != null ? r32.getName() : null;
        String strM2218i = AbstractC2821a.m2218i(getVersionCode(), context.getPackageName(), ContentUtils.HASH_SYMBOL);
        contentValues.put("app_id", name);
        contentValues.put(ExtensionConst.KEY_PARAM_FEATURE, strM2218i);
        contentValues.put("extra", "initialize");
        Intent intent = new Intent();
        intent.setAction("com.samsung.android.providers.context.log.action.USE_APP_FEATURE_SURVEY");
        intent.putExtra("data", contentValues);
        intent.setPackage("com.samsung.android.providers.context");
        context.sendBroadcast(intent);
    }

    @JvmStatic
    public static final boolean isLoadedSpen(@Nullable String str) {
        return INSTANCE.isLoadedSpen(str);
    }

    @JvmStatic
    public static final boolean isPenInboxed(@Nullable Context context) {
        return INSTANCE.isPenInboxed(context);
    }

    private final boolean isPointerIconEnabled() {
        if (!mIsInitialized) {
            return false;
        }
        try {
            return PointerIconWrapper.create(this.mContext).isPointerIconSupported();
        } catch (PlatformException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @JvmStatic
    public static final boolean isTextRecognizerEnabled(@Nullable Context context) {
        return INSTANCE.isTextRecognizerEnabled(context);
    }

    @JvmStatic
    public static final int osType() {
        return INSTANCE.osType();
    }

    private final void printVersion(Context context) {
        if (context == null) {
            return;
        }
        try {
            InputStream inputStreamOpen = context.getAssets().open("PEN_SDK_CHANGELIST");
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
            StringBuilder sb = new StringBuilder();
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i == -1) {
                    Log.i(LOG_TAG, "SpenSdk native version = " + ((Object) sb));
                    inputStreamOpen.close();
                    return;
                }
                sb.append(new String(bArr, 0, i, Charsets.UTF_8));
            }
        } catch (Exception e) {
            AbstractC2322a.m1636z("SpenSdk it is not created by jenkins : ", e.getMessage(), LOG_TAG);
        }
    }

    @JvmStatic
    public static final void trimCache(@Nullable Context context, int i) {
        INSTANCE.trimCache(context, i);
    }

    @JvmStatic
    public static final void updateSDK(@Nullable Context context, boolean z, boolean z2) {
        INSTANCE.updateSDK(context, z, z2);
    }

    public final int SPEN_SDK_4_0_0(int input) {
        return (input * input) + input;
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public int getVersionCode() {
        return 1;
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    @NotNull
    public String getVersionName() {
        return VERSION;
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public void initialize(@Nullable Context context) {
        initialize(context, 5, 1, true, null);
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public boolean isFeatureEnabled(int type) {
        if (type == 0) {
            Context context = this.mContext;
            return context != null ? INSTANCE.hasPenFeature(context) : new File("/sys/class/sec/sec_epen").isDirectory();
        }
        if (type == 1) {
            return isPointerIconEnabled();
        }
        if (type == 2) {
            return INSTANCE.isTextRecognizerEnabled(this.mContext);
        }
        throw new IllegalArgumentException();
    }

    @SuppressLint({"SdCardPath"})
    public final boolean loadLibrary(@NotNull String libraryName) {
        Intrinsics.checkNotNullParameter(libraryName, "libraryName");
        if (this.mCreateMode != 1) {
            File file = new File(AbstractC0541b.m775q("/data/data/", spenPackageName, "/lib/lib", libraryName, ".so"));
            if (file.exists()) {
                try {
                    System.load(file.toString());
                    return true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return false;
        }
        try {
            System.loadLibrary(libraryName);
            return true;
        } catch (Error e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final void initialize(@Nullable Context context, int maxCacheSize) {
        initialize(context, maxCacheSize, 1, true, null);
    }

    @Deprecated(message = "This API is deprecated. All input parameters (except {@code context} and {@code maxCacheSize} are set by default values){@code createMode} is set default by {@code SPEN_STATIC_LIB_MODE}.", replaceWith = @ReplaceWith(expression = "initialize(context, maxCacheSize, SPEN_STATIC_LIB_MODE, true, null)", imports = {"com.samsung.android.sdk.pen.Spen.Companion.SPEN_STATIC_LIB_MODE"}))
    @SuppressLint({WarningType.NewApi})
    public final void initialize(@Nullable Context context, int maxCacheSize, int createMode) {
        initialize(context, maxCacheSize, 1, true, null);
    }

    @Deprecated(message = "This API is deprecated. All input parameters (except {@code context} and {@code maxCacheSize} are set by default values).{@code createMode} is set default by {@code SPEN_STATIC_LIB_MODE}.{@code isForce32BitMode} is set default by true.", replaceWith = @ReplaceWith(expression = "initialize(context, maxCacheSize, SPEN_STATIC_LIB_MODE, true, null)", imports = {"com.samsung.android.sdk.pen.Spen.Companion.SPEN_STATIC_LIB_MODE"}))
    @SuppressLint({WarningType.NewApi})
    public final void initialize(@Nullable Context context, int maxCacheSize, int createMode, boolean isForce32BitMode) {
        initialize(context, maxCacheSize, 1, true, null);
    }

    @Deprecated(message = "This API is deprecated. All input parameters (except {@code context} and {@code maxCacheSize} are set by default values).>{@code createMode} is set default by {@code SPEN_STATIC_LIB_MODE}.{@code isForce32BitMode} is set default by true.{@code packageName} is set default by null.)")
    @SuppressLint({WarningType.NewApi})
    public final synchronized void initialize(@Nullable Context context, int maxCacheSize, int createMode, boolean isForce32BitMode, @Nullable String packageName) {
        int width;
        int height;
        Context context2;
        try {
            Log.i(LOG_TAG, "SpenSdk version level = " + getVersionCode());
            Log.i(LOG_TAG, "SpenSdk jar version = " + getVersionName());
            if (context != null) {
                Log.i(LOG_TAG, "Client package name = " + context.getPackageName());
                printVersion(context);
                this.mContext = context;
                this.mCreateMode = createMode;
                if (createMode == 1) {
                    Log.i(LOG_TAG, "SpenSdk use static library");
                    if (!mIsInitialized && (context2 = this.mContext) != null) {
                        spenPackageName = context2.getPackageName();
                    }
                    Log.i(LOG_TAG, "mSpenPackageName : " + spenPackageName);
                    insertLog(context);
                    File filesDir = context.getFilesDir();
                    if (filesDir != null) {
                        if (!filesDir.exists() && !filesDir.mkdirs()) {
                            throw new IllegalStateException("Cannot create application files directory");
                        }
                        Object systemService = context.getSystemService("window");
                        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                        WindowManager windowManager = (WindowManager) systemService;
                        try {
                            try {
                                try {
                                    Point point = new Point();
                                    windowManager.getDefaultDisplay().getRealSize(point);
                                    width = point.x;
                                    height = point.y;
                                } catch (NoSuchMethodError unused) {
                                    Display defaultDisplay = windowManager.getDefaultDisplay();
                                    Method method = Display.class.getMethod("getRawWidth", null);
                                    Method method2 = Display.class.getMethod("getRawHeight", null);
                                    Object objInvoke = method.invoke(defaultDisplay, null);
                                    Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                                    width = ((Integer) objInvoke).intValue();
                                    Object objInvoke2 = method2.invoke(defaultDisplay, null);
                                    Intrinsics.checkNotNull(objInvoke2, "null cannot be cast to non-null type kotlin.Int");
                                    height = ((Integer) objInvoke2).intValue();
                                }
                            } catch (Exception unused2) {
                                Point point2 = new Point();
                                windowManager.getDefaultDisplay().getSize(point2);
                                width = point2.x;
                                height = point2.y;
                            }
                        } catch (NoSuchMethodError unused3) {
                            Display defaultDisplay2 = windowManager.getDefaultDisplay();
                            width = defaultDisplay2.getWidth();
                            height = defaultDisplay2.getHeight();
                        }
                        if (mIsInitialized) {
                            Companion companion = INSTANCE;
                            String absolutePath = filesDir.getAbsolutePath();
                            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                            if (companion.SPenSdk_init2(absolutePath, width, height, maxCacheSize)) {
                                Log.i(LOG_TAG, "Spen OS type = " + companion.osType());
                                Log.i(LOG_TAG, "initialize complete");
                                return;
                            }
                            throw new IllegalStateException("SDK Cache directory is not initialized.");
                        }
                        if (loadLibrary("c++_shared")) {
                            if (loadLibrary("SPenZlib") && loadLibrary("SPenLibpng") && loadLibrary("SPenLibjpeg") && loadLibrary("SPenLibgif") && loadLibrary("SPenUuid")) {
                                if (loadLibrary("SPenSkia")) {
                                    if (loadLibrary("SPenLibxml2")) {
                                        if (loadLibrary("SPenBase") && loadLibrary("SPenPluginFW") && loadLibrary("SPenModel") && loadLibrary("SPenRenderer") && loadLibrary("SPenGraphics") && loadLibrary("SPenEngine") && loadLibrary("SPenInit") && loadLibrary("SPenPaintingCompat")) {
                                            loadLibrary("SPenContent");
                                            loadLibrary("SPenView");
                                            loadLibrary("SPenText");
                                            loadLibrary("SPenObjectControl");
                                            loadLibrary("SPenDrawing");
                                            loadLibrary("SPenWidget");
                                            loadLibrary("SPenRecogUIFeature");
                                            loadLibrary("SPenPdfiumV");
                                            loadLibrary("SPenPdf");
                                            loadLibrary("SPenPdfViewer");
                                            loadLibrary("SPenComposer");
                                            loadLibrary("SPenBodytext");
                                            loadLibrary("SPenSDoc");
                                            loadLibrary("SPenWDoc");
                                            loadLibrary("SPenXmlSerializer");
                                            loadLibrary("SPenWordDocCoedit");
                                            loadLibrary("SPenPenCommon");
                                            loadLibrary("SPenGestureModel");
                                            loadLibrary("SPenRecognizerShape");
                                            loadLibrary("SPenSnet");
                                            loadLibrary("SPenInference");
                                            loadLibrary("SPenRecognizerMathLineSplitter");
                                            loadLibrary("SPenRecognizerMathRecognition");
                                            loadLibrary("SPenRecognizerMathRender");
                                            Log.i(LOG_TAG, "SpenSdk Libraries are loaded.");
                                            Companion companion2 = INSTANCE;
                                            String absolutePath2 = filesDir.getAbsolutePath();
                                            Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
                                            if (companion2.SPenSdk_init2(absolutePath2, width, height, maxCacheSize)) {
                                                Display defaultDisplay3 = windowManager.getDefaultDisplay();
                                                DisplayMetrics displayMetrics = new DisplayMetrics();
                                                defaultDisplay3.getRealMetrics(displayMetrics);
                                                companion2.SPenSdk_setScreenDensity(displayMetrics.density);
                                                Recognizer.initialize(context);
                                                SpenPenManager.INSTANCE.setPenAntiAliasEnabled();
                                                mIsInitialized = true;
                                                Log.i(LOG_TAG, "Spen OS type = " + companion2.osType());
                                                Log.i(LOG_TAG, "initialize complete");
                                                return;
                                            }
                                            throw new IllegalStateException("SDK Cache directory is not initialized.");
                                        }
                                        throw new IllegalStateException("Check failed.");
                                    }
                                    throw new IllegalStateException("Libxml2 is not loaded!!");
                                }
                                throw new IllegalStateException("skia is not loaded!!");
                            }
                            throw new IllegalStateException("base libraries is not loaded!!");
                        }
                        throw new IllegalStateException("c++_shared is not loaded!!");
                    }
                    throw new IllegalStateException("Cannot get the path of the directory holding application files.");
                }
                Log.e(LOG_TAG, "SpenSdk use mode : " + createMode + ". Skip!!!");
                return;
            }
            throw new IllegalArgumentException("context is invalid.");
        } catch (Throwable th) {
            throw th;
        }
    }
}
