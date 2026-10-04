package com.samsung.android.support.senl.p148nt.model.collector.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.recogengine.SpenRecognizer;
import com.samsung.android.sdk.pen.recogengine.SpenRecognizerManager;
import com.samsung.android.sdk.pen.recogengine.SpenResourceProvider;
import com.samsung.android.support.senl.p145cm.base.common.status.ThermalStatus;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PowerManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.RecogEngineConstructor;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguage;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RecognitionUtil {
    private static final String DEFAULT_RECOGNIZER_DB_VERSION = "0";
    public static final int RECOGNIZE_SLEEP_TIME_MAX = 500000;
    public static final int RECOGNIZE_SLEEP_TIME_NONE = 0;
    public static final String SPEN_RECOGNIZER_PLUGIN_PACKAGE = "com.samsung.android.sdk.pen.recogengine.preload.SpenRecognizerPlugin";
    private static boolean sIsRecognitionSleepDisabled;
    private static final boolean sIsSupportThermalFunction;
    private static String sRecognizerDBVersion;
    private static final String TAG = CollectLogger.createTag("RecognitionUtil");
    private static int sIsRecognitionSupported = -1;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.collector.util.RecognitionUtil$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C114301 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$cm$base$common$status$ThermalStatus$Types */
        static final /* synthetic */ int[] f7696xe23b7dcf;

        static {
            int[] iArr = new int[ThermalStatus.Types.values().length];
            f7696xe23b7dcf = iArr;
            try {
                iArr[ThermalStatus.Types.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7696xe23b7dcf[ThermalStatus.Types.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7696xe23b7dcf[ThermalStatus.Types.MODERATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7696xe23b7dcf[ThermalStatus.Types.SEVERE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7696xe23b7dcf[ThermalStatus.Types.CRITICAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        sIsSupportThermalFunction = Build.VERSION.SDK_INT >= 29;
        sIsRecognitionSleepDisabled = false;
        sRecognizerDBVersion = "";
    }

    public static String getHWRLanguage(Context context) {
        TextRecognitionLanguage textRecognitionLanguage = new TextRecognitionLanguage(context);
        textRecognitionLanguage.initTextRecognitionLanguage(false);
        try {
            return textRecognitionLanguage.getFirstLanguageForTextRecognition();
        } catch (TextRecognitionLanguage.SupportedLanguageException e) {
            Logger.m8698e(TAG, "getHWRLanguage, " + e.getMessage());
            return getSystemLocale(context);
        }
    }

    public static int getRecognizeSleepTime(Context context, int i) {
        if (sIsRecognitionSleepDisabled) {
            return 0;
        }
        DataLogger.m12302d(TAG, "getRecognizeSleepTime priority : " + i);
        if (i == ICollectParam.Priority.BACKGROUND.getValue()) {
            return RECOGNIZE_SLEEP_TIME_MAX;
        }
        if (sIsSupportThermalFunction) {
            return getRecognizeSleepTimeByThermalFactor(context);
        }
        return 0;
    }

    private static int getRecognizeSleepTimeByThermalFactor(Context context) {
        try {
            ThermalStatus.Types currentThermalStatus = PowerManagerCompat.getInstance(context).getCurrentThermalStatus();
            int sleepTime = (int) (getSleepTime(currentThermalStatus) * 500000.0f);
            DataLogger.m12302d(TAG, "getRecognizeSleepTimeByThermalFactor thermalStatus/result : " + currentThermalStatus + "/" + sleepTime);
            return sleepTime;
        } catch (ClassCastException | NullPointerException e) {
            DataLogger.m12303e(TAG, "getRecognizeSleepTimeByThermalFactor, e : " + e.getMessage());
            return 0;
        }
    }

    public static String getRecognizerDBVersion() throws Throwable {
        if (TextUtils.isEmpty(sRecognizerDBVersion)) {
            setRecognizerDBVersion();
        }
        return sRecognizerDBVersion;
    }

    private static float getSleepTime(ThermalStatus.Types types) {
        int i = C114301.f7696xe23b7dcf[types.ordinal()];
        if (i == 1) {
            return 0.0f;
        }
        if (i == 2) {
            return 0.3f;
        }
        if (i == 3) {
            return 0.5f;
        }
        if (i == 4 || i == 5) {
            return 1.0f;
        }
        throw new IncompatibleClassChangeError();
    }

    public static String getSystemLocale(Context context) {
        return LocaleUtils.getLocale(context.getResources().getConfiguration()).toString();
    }

    public static void initLanguageListDb(Context context) {
        try {
            if (DeviceUtils.isSupportedHandWritingRecognition(context)) {
                RecogEngineConstructor.makeResourceProvider(context, SpenResourceProvider.EngineType.TEXT, SpenResourceProvider.ResourceType.FRAMEWORK);
            }
        } catch (Throwable th) {
            DataLogger.m12303e(TAG, "initLanguageListDb, e : " + th.getMessage());
        }
    }

    private static boolean isDefaultLanguageAvailable(Context context) {
        if (context == null) {
            return false;
        }
        if (isHWREnabledChanged() || SharedPreferencesCompat.getInstance("Settings").contains(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION)) {
            return true;
        }
        return TextRecognitionLanguageDownloadHelper.getDefaultLanguageSupported(context);
    }

    public static boolean isHWREnabled() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION, true);
    }

    public static boolean isHWREnabledChanged() {
        return TextRecognitionLanguageDownloadHelper.isHWREnabledChanged();
    }

    public static boolean isSDKRecognitionSupported(Context context) {
        if (sIsRecognitionSupported == -1) {
            sIsRecognitionSupported = 0;
            SpenSdkInitializer.initialize(context);
            sIsRecognitionSupported = Spen.isTextRecognizerEnabled(context) ? 1 : 0;
        }
        return sIsRecognitionSupported == 1;
    }

    public static boolean isSupported(Context context) {
        return DeviceUtils.isSupportedHandWritingRecognition(context) && isHWREnabled() && isSDKRecognitionSupported(context) && isDefaultLanguageAvailable(context);
    }

    public static void setHWREnabled(boolean z) {
        SharedPreferencesCompat.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION, z);
    }

    public static void setHWREnabledChanged(boolean z) {
        TextRecognitionLanguageDownloadHelper.setHWREnabledChanged(z);
    }

    public static void setHWRLanguage(String str) {
        SharedPreferencesCompat.getInstance("Settings").putString(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION_LANGUAGE, str);
    }

    public static void setRecognizerDBVersion() throws Throwable {
        SpenRecognizer spenRecognizer;
        Exception exc;
        if (!TextUtils.isEmpty(sRecognizerDBVersion)) {
            return;
        }
        sRecognizerDBVersion = "0";
        SpenRecognizerManager spenRecognizerManager = null;
        spenRecognizerCreateRecognizer = null;
        SpenRecognizer spenRecognizerCreateRecognizer = null;
        spenRecognizerManager = null;
        try {
            Context applicationContext = BaseUtils.getApplicationContext();
            SpenSdkInitializer.initialize(applicationContext);
            SpenRecognizerManager spenRecognizerManagerMakeRecognizerManager = RecogEngineConstructor.makeRecognizerManager(applicationContext);
            try {
                spenRecognizerCreateRecognizer = spenRecognizerManagerMakeRecognizerManager.createRecognizer(SPEN_RECOGNIZER_PLUGIN_PACKAGE);
                TextRecognitionLanguage textRecognitionLanguage = new TextRecognitionLanguage(applicationContext);
                textRecognitionLanguage.initTextRecognitionLanguage(false);
                spenRecognizerCreateRecognizer.setLanguage(textRecognitionLanguage.getFirstLanguageForTextRecognition());
                sRecognizerDBVersion = spenRecognizerCreateRecognizer.getRecognizerDBVersionByHash();
                if (spenRecognizerCreateRecognizer.getPluginObject() != null) {
                    spenRecognizerManagerMakeRecognizerManager.destroyRecognizer(spenRecognizerCreateRecognizer);
                }
                DataLogger.m12302d(TAG, "setRecognizerDBVersion, recognizerDBVersion: " + sRecognizerDBVersion);
            } catch (Exception e) {
                spenRecognizer = spenRecognizerCreateRecognizer;
                spenRecognizerManager = spenRecognizerManagerMakeRecognizerManager;
                exc = e;
                try {
                    String str = TAG;
                    DataLogger.m12303e(str, "setRecognizerDBVersion, e : " + exc.getMessage());
                    if (spenRecognizerManager != null && spenRecognizer != null && spenRecognizer.getPluginObject() != null) {
                        spenRecognizerManager.destroyRecognizer(spenRecognizer);
                    }
                    DataLogger.m12302d(str, "setRecognizerDBVersion, recognizerDBVersion: " + sRecognizerDBVersion);
                } catch (Throwable th) {
                    th = th;
                    if (spenRecognizerManager != null && spenRecognizer != null && spenRecognizer.getPluginObject() != null) {
                        spenRecognizerManager.destroyRecognizer(spenRecognizer);
                    }
                    DataLogger.m12302d(TAG, "setRecognizerDBVersion, recognizerDBVersion: " + sRecognizerDBVersion);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                spenRecognizer = spenRecognizerCreateRecognizer;
                spenRecognizerManager = spenRecognizerManagerMakeRecognizerManager;
                if (spenRecognizerManager != null) {
                    spenRecognizerManager.destroyRecognizer(spenRecognizer);
                }
                DataLogger.m12302d(TAG, "setRecognizerDBVersion, recognizerDBVersion: " + sRecognizerDBVersion);
                throw th;
            }
        } catch (Exception e2) {
            exc = e2;
            spenRecognizer = null;
        } catch (Throwable th3) {
            th = th3;
            spenRecognizer = null;
        }
    }

    public static boolean togglesRecognitionSleep() {
        boolean z = !sIsRecognitionSleepDisabled;
        sIsRecognitionSleepDisabled = z;
        return z;
    }
}
