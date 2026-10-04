package com.samsung.android.sdk.handwriting;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.samsung.android.sdk.handwriting.common.HwrConfig;
import com.samsung.android.sdk.handwriting.text.impl.SepUseWrapper;
import com.samsung.android.spen.libwrapper.SystemPropertiesWrapper;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Recognizer {
    private static final String HWR_SDL_PACKAGE_NAME = "com.samsung.android.handwriting.SemRecognizer";
    private static final String TAG = "Recognizer";
    private static boolean mIsInitialized;
    private static boolean mIsSdkAvailable;
    private static boolean mIsSdlAvailable;
    private static int mLibraryAbi;

    public static int getOneUIVersion(Context context) {
        try {
            String str = SystemPropertiesWrapper.create(context).get("ro.build.version.oneui");
            if (TextUtils.isEmpty(str)) {
                Log.w(TAG, "Cannot get One UI version!");
                return 0;
            }
            Log.i(TAG, "OneUI = " + str);
            if (str.matches("[0-9]+")) {
                return Integer.parseInt(str);
            }
            return 0;
        } catch (PlatformException | NumberFormatException e) {
            Log.e(TAG, "Cannot get OneUI : " + e.getMessage());
            return 0;
        }
    }

    public static void initialize(Context context) {
        if (System.getProperty(SystemProperties.JAVA_LIBRARY_PATH).contains("/system/lib")) {
            mLibraryAbi = 1;
        } else {
            mLibraryAbi = 2;
        }
        mIsSdlAvailable = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.samsung.android.sdk.handwriting", 128);
            Log.i(TAG, "APK Version = " + packageInfo.versionName + " : " + packageInfo.packageName);
            mIsSdkAvailable = true;
            HwrConfig.setLibraryAbi(mLibraryAbi);
        } catch (PackageManager.NameNotFoundException unused) {
            mIsSdkAvailable = false;
            Log.i(TAG, "No SDK apis");
        } catch (Exception unused2) {
            Logger.getLogger(TAG).log(Level.INFO, "No authority to handwriting provider");
            mIsSdkAvailable = false;
        }
    }

    public static boolean isSDKAvailable() {
        return mIsSdkAvailable;
    }

    public static boolean isSDLAvailable() {
        return mIsSdlAvailable;
    }

    public static boolean isTextRecognizerAvailable(Context context) {
        if (context == null) {
            return false;
        }
        initialize(context);
        if (!mIsSdkAvailable && !mIsSdlAvailable) {
            return false;
        }
        if (new SepUseWrapper().isSamsungKeyboardPackage(context) || getOneUIVersion(context) >= 80000) {
            return true;
        }
        File file = new File("/sys/class/sec/sec_epen");
        String property = System.getProperty("ro.build.scafe.size");
        if (file.isDirectory() || (property != null && "short".equals(property))) {
            return true;
        }
        Logger.getLogger(TAG).log(Level.INFO, "Target does not have a pen or is not a tablet");
        return false;
    }
}
