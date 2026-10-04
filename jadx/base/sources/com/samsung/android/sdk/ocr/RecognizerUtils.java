package com.samsung.android.sdk.ocr;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.ocr.SpenIOcrRecognizer;
import com.samsung.android.sdk.pen.ocr.SpenOcrEngine;
import com.samsung.android.sdk.pen.ocr.SpenOcrLanguage;
import com.samsung.android.sdk.pen.ocr.SpenOcrModelLoaderFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class RecognizerUtils {
    private static final String SOCR_PROVIDER_PACKAGE_NAME = "com.samsung.android.sdk.ocr";
    private static final String TAG = "RecognizerUtils";

    private static int getVersionNumberFrom(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        String[] strArrSplit = str.split(RemoteConstant.VERSION_DIVIDE);
        if (strArrSplit.length > 1) {
            return Integer.parseInt(strArrSplit[1]) + (Integer.parseInt(strArrSplit[0]) * 100);
        }
        Log.e(TAG, "Unable to split version name : ".concat(str));
        return i;
    }

    public static int getVersionOfNativeLibInDevice() {
        SpenOcrEngine spenOcrEngine = new SpenOcrEngine();
        String engineVersion = spenOcrEngine.getEngineVersion();
        AbstractC6670b.m4756q("native so version : ", engineVersion, TAG);
        int versionNumberFrom = getVersionNumberFrom(engineVersion, 101);
        spenOcrEngine.close();
        Log.i(TAG, "version number = " + versionNumberFrom);
        return versionNumberFrom;
    }

    public static int getVersionOfNativeLibInOneUI41Device(Context context) {
        SpenOcrEngine spenOcrEngine = new SpenOcrEngine(context, SpenOcrModelLoaderFactory.MODEL_LOADER.ONEUI41);
        SpenOcrLanguage spenOcrLanguage = SpenOcrLanguage.ENGLISH;
        int versionNumberFrom = 100;
        if (spenOcrEngine.isSupportedLanguage(spenOcrLanguage)) {
            SpenIOcrRecognizer spenIOcrRecognizerCreateRecognizer = spenOcrEngine.createRecognizer();
            if (spenIOcrRecognizerCreateRecognizer == null) {
                Log.e(TAG, "Fails to create recognizer");
            } else {
                versionNumberFrom = getVersionNumberFrom(spenIOcrRecognizerCreateRecognizer.getVersion(), 100);
                spenIOcrRecognizerCreateRecognizer.close();
            }
        } else {
            Log.w(TAG, "Does not support language(" + spenOcrLanguage.name() + ")");
        }
        spenOcrEngine.close();
        Log.i(TAG, "version number = " + versionNumberFrom);
        return versionNumberFrom;
    }

    public static int getVersionOfNativeLibInServiceProvider(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.samsung.android.sdk.ocr", 128);
            Log.i(TAG, "OCRDataProvider Version = " + packageInfo.versionName + ", Version Code = " + packageInfo.versionCode);
            return getVersionNumberFrom(packageInfo.versionName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(TAG, "OCRDataProvider is not found");
            return 0;
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            return 0;
        }
    }
}
