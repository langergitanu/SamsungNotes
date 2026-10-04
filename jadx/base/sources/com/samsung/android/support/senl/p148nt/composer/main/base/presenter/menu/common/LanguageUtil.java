package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.sdk.pen.recogengine.SpenRecognizerAILanguages;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.constants.DirectWriteConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguage;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class LanguageUtil {
    private static final String TAG = Logger.createTag("LanguageUtil");

    public static String getAutoFormatLanguage(Context context) {
        Logger.m10999d(TAG, "getAutoFormatLanguage#");
        return getLanguage(context, "Settings", SettingsConstants.SETTINGS_HANDWRITING_CONVERT_TO_TEXT_LANGUAGE);
    }

    public static String getCleanUpHandwritingLanguage(Context context) {
        Logger.m10999d(TAG, "getCleanUpHandwritingLanguage#");
        return getLanguage(context, "Composer", SharedPreferencesConstants.COMPOSER_CLEAN_UP_HW_LANGUAGE_PREF, false);
    }

    public static String getConvertToTextLanguage(Context context) {
        Logger.m10999d(TAG, "getConvertToTextLanguage#");
        return getLanguage(context, "Settings", SettingsConstants.SETTINGS_HANDWRITING_CONVERT_TO_TEXT_LANGUAGE);
    }

    private static String getLanguage(Context context, String str, String str2) {
        return getLanguage(context, str, str2, false);
    }

    public static void setCleanUpHandwritingLanguage(String str) {
        AbstractC8014b.m7196B("setCleanUpHandwritingLanguage# ", str, TAG);
        setLanguage("Composer", SharedPreferencesConstants.COMPOSER_CLEAN_UP_HW_LANGUAGE_PREF, str);
    }

    private static void setLanguage(String str, String str2, String str3) {
        Logger.m10999d(TAG, "setLanguage# " + str3);
        SharedPreferencesCompat.getInstance(str).putString(str2, str3);
    }

    private static String getLanguage(Context context, String str, String str2, boolean z) throws TextRecognitionLanguage.SupportedLanguageException {
        List<String> availableLanguages;
        String string = SharedPreferencesCompat.getInstance(str).getString(str2, null);
        if (TextUtils.isEmpty(string)) {
            String str3 = TAG;
            Logger.m10999d(str3, "getLanguage# currentLanguage is null");
            TextRecognitionLanguage textRecognitionLanguage = new TextRecognitionLanguage(context);
            textRecognitionLanguage.initTextRecognitionLanguage(false);
            String firstLanguageForTextRecognition = textRecognitionLanguage.getFirstLanguageForTextRecognition();
            AbstractC8014b.m7196B("getLanguage# update current language : ", firstLanguageForTextRecognition, str3);
            if (z && (availableLanguages = SpenRecognizerAILanguages.getAvailableLanguages()) != null && !availableLanguages.contains(firstLanguageForTextRecognition)) {
                firstLanguageForTextRecognition = DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE;
            }
            string = firstLanguageForTextRecognition;
            SharedPreferencesCompat.getInstance(str).putString(str2, string);
        }
        AbstractC8014b.m7196B("getLanguage# current language : ", string, TAG);
        return string;
    }
}
