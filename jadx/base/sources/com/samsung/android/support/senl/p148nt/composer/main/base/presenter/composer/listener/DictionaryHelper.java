package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.app.sync.cloudsettings.callee.NotesSyncRpcProvider;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.IntentUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DictionaryHelper {
    public static final String DICTIONARY = "com.sec.android.app.dictionary.SEARCH";
    private static final int DICTIONARY_MAXIMUM_STRING_LENGTH = 100;
    public static final String DICTIONARY_PACKAGE_NAME = "com.diotek.sec.lookup.dictionary";
    public static final String DICTIONARY_PACKAGE_NAME_SEC = "com.sec.android.app.dictionary";
    private static final int MIN_SUPPORTED_VERSION_CODE = 200001002;
    private static final String TAG = Logger.createTag("DictionaryHelper");

    public static void executeDictionary(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Logger.m11003i(TAG, "executeDictionary# " + str.length());
        if (str.length() > 100) {
            str = str.substring(0, 100);
        }
        if (sendToDictionaryNewVersion(activity, str)) {
            return;
        }
        sendToDictionaryOldVersion(activity, str);
    }

    private static PackageInfo getPackageInfoDictionaryNewVersion(PackageManager packageManager) {
        PackageInfo packageInfo;
        try {
            try {
                packageInfo = packageManager.getPackageInfo(DICTIONARY_PACKAGE_NAME, 1);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = packageManager.getPackageInfo(DICTIONARY_PACKAGE_NAME_SEC, 1);
            }
            if (packageInfo == null || !packageInfo.applicationInfo.enabled) {
                Logger.m11000e(TAG, "getPackageInfoDictionaryNewVersion# info is null or applicationInfo is not enabled");
                return null;
            }
            if (MIN_SUPPORTED_VERSION_CODE <= packageInfo.versionCode) {
                return packageInfo;
            }
            Logger.m11000e(TAG, "getPackageInfoDictionaryNewVersion# minSupportedVersionCode - " + packageInfo.versionCode);
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.m11000e(TAG, "getPackageInfoDictionaryNewVersion# " + e.getMessage());
            return null;
        }
    }

    private static boolean isDictionarEnabledyNewVersion(PackageManager packageManager) {
        return getPackageInfoDictionaryNewVersion(packageManager) != null;
    }

    public static boolean isDictionaryEnabled(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (isDictionarEnabledyNewVersion(packageManager)) {
            return true;
        }
        return isDictionaryEnabledOldVersion(packageManager, new Intent(DICTIONARY));
    }

    private static boolean isDictionaryEnabledOldVersion(PackageManager packageManager, Intent intent) {
        return !packageManager.queryBroadcastReceivers(intent, 0).isEmpty();
    }

    private static boolean sendToDictionaryNewVersion(Context context, String str) {
        PackageInfo packageInfoDictionaryNewVersion = getPackageInfoDictionaryNewVersion(context.getPackageManager());
        if (packageInfoDictionaryNewVersion == null) {
            return false;
        }
        IntentUtil.startActivity(context, new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain").putExtra("android.intent.extra.PROCESS_TEXT_READONLY", true).setPackage(packageInfoDictionaryNewVersion.packageName).putExtra("android.intent.extra.PROCESS_TEXT", str));
        return true;
    }

    private static void sendToDictionaryOldVersion(Context context, String str) {
        Intent intent = new Intent(DICTIONARY);
        intent.addFlags(32);
        intent.putExtra(Bixby2Constants.BIXBY_PARAM_KEYWORD, str);
        intent.putExtra(NotesSyncRpcProvider.FORCE_SYNC, "true");
        intent.setPackage(DICTIONARY_PACKAGE_NAME_SEC);
        if (isDictionaryEnabledOldVersion(context.getPackageManager(), intent)) {
            context.sendBroadcast(intent);
        } else {
            Logger.m11000e(TAG, "sendToDictionaryOldVersion# info is null");
        }
    }
}
