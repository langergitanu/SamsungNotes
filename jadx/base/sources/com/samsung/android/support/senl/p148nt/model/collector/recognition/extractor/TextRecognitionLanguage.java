package com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor;

import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.recogengine.SpenResourceProvider;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.RecogEngineConstructor;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.constants.DirectWriteConstant;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TextRecognitionLanguage {
    private static final String TAG = CollectLogger.createTag("TextRecognitionLanguage");
    private final Context mContext;
    private List<String> mSpenRecognizerSupportedLanguageList;
    private final List<String> mSupportedLanguageList = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SupportedLanguageException extends Exception {
        public SupportedLanguageException(String str) {
            super(str);
        }
    }

    public TextRecognitionLanguage(Context context) {
        this.mContext = context;
    }

    private static String getDefaultLocale(List<String> list) {
        return list.contains("en_GB") ? "en_GB" : list.contains(DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE) ? DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE : list.get(0);
    }

    private String getHWCurrentLanguage(List<String> list) {
        String string = SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION_LANGUAGE, null);
        String str = TAG;
        AbstractC11014a.m12334s("getHWCurrentLanguage 1: ", string, str);
        if (string != null) {
            if (list == null) {
                list = this.mSupportedLanguageList;
            }
            if (!list.isEmpty() && list.contains(string)) {
                DataLogger.m12302d(str, "getHWCurrentLanguage : 2".concat(string));
                return string;
            }
        }
        String hWCurrentLanguageByNewConcept = getHWCurrentLanguageByNewConcept();
        DataLogger.m12302d(str, "getHWCurrentLanguage : " + string + "/" + hWCurrentLanguageByNewConcept);
        SharedPreferencesCompat.getInstance("Settings").edit().putString(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION_LANGUAGE, hWCurrentLanguageByNewConcept).apply();
        return hWCurrentLanguageByNewConcept;
    }

    private String getHWCurrentLanguageByNewConcept() {
        List<String> list = this.mSpenRecognizerSupportedLanguageList;
        Locale locale = Locale.getDefault();
        return getLanguageInRecognizerLanguageList(list, locale.getLanguage(), locale.getCountry());
    }

    private ArrayList<String> getKeyboardSettingsSelectedLanguageList(Context context) {
        String keyboardSettingsSelectedLanguage = InputMethodCompat.getInstance().getKeyboardSettingsSelectedLanguage(context);
        ArrayList<String> arrayList = new ArrayList<>();
        if (keyboardSettingsSelectedLanguage != null && keyboardSettingsSelectedLanguage.length() > 0) {
            DataLogger.m12302d(TAG, "getKeyboardSettingsSelectedLanguageList : ".concat(keyboardSettingsSelectedLanguage));
            StringTokenizer stringTokenizer = new StringTokenizer(keyboardSettingsSelectedLanguage, ";");
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken != null) {
                    if (strNextToken.endsWith("_")) {
                        strNextToken = strNextToken.substring(0, strNextToken.indexOf(95));
                    }
                    arrayList.add(strNextToken);
                }
            }
        }
        return arrayList;
    }

    private String getLanguageInRecognizerLanguageList(List<String> list, String str, String str2) {
        if (list.isEmpty()) {
            return null;
        }
        return getLanguageInRecognizerLanguageListInternal(list, str, str2);
    }

    private String getLanguageInRecognizerLanguageListInternal(List<String> list, String str, String str2) {
        String languageInRecognizerLanguageListOrReturnNull = getLanguageInRecognizerLanguageListOrReturnNull(list, str, str2);
        return languageInRecognizerLanguageListOrReturnNull != null ? languageInRecognizerLanguageListOrReturnNull : getDefaultLocale(list);
    }

    private String getLanguageInRecognizerLanguageListOrReturnNull(List<String> list, String str, String str2) {
        String strM757C = isNonUnderLineLanguage(str) ? str : AbstractC0541b.m757C(str, "_", str2);
        if (str != null && list.contains(strM757C)) {
            return strM757C;
        }
        if (str == null) {
            return null;
        }
        for (String str3 : list) {
            if (str3.startsWith(str)) {
                return str3;
            }
        }
        return null;
    }

    private String[] getSpenRecognitionSupportedLanguage() {
        return RecogEngineConstructor.makeResourceProvider(this.mContext, SpenResourceProvider.EngineType.TEXT, SpenResourceProvider.ResourceType.FRAMEWORK).getSupportedLanguages();
    }

    private boolean isNonUnderLineLanguage(String str) {
        return "ar".equals(str) || "sw".equals(str) || "ceb".equals(str);
    }

    public String findDefaultLocaleLanguageInRecognizerList() {
        List<String> list = this.mSpenRecognizerSupportedLanguageList;
        if (list == null) {
            return null;
        }
        Locale locale = Locale.getDefault();
        return getLanguageInRecognizerLanguageListOrReturnNull(list, locale.getLanguage(), locale.getCountry());
    }

    public String getFirstLanguageForTextRecognition() throws SupportedLanguageException {
        if (this.mSupportedLanguageList.isEmpty()) {
            throw new SupportedLanguageException("supported language is empty");
        }
        return this.mSupportedLanguageList.get(0);
    }

    public List<String> getLanguageListForTextRecognition() {
        return this.mSupportedLanguageList;
    }

    public void initTextRecognitionLanguage(boolean z) {
        String[] spenRecognitionSupportedLanguage = getSpenRecognitionSupportedLanguage();
        if (spenRecognitionSupportedLanguage == null) {
            return;
        }
        this.mSpenRecognizerSupportedLanguageList = Arrays.asList(spenRecognitionSupportedLanguage);
        this.mSupportedLanguageList.clear();
        if (z) {
            for (String str : getKeyboardSettingsSelectedLanguageList(this.mContext)) {
                if (this.mSpenRecognizerSupportedLanguageList.contains(str)) {
                    this.mSupportedLanguageList.add(str);
                }
            }
        } else {
            for (String str2 : this.mSpenRecognizerSupportedLanguageList) {
                if (str2.contains("_") || isNonUnderLineLanguage(str2)) {
                    this.mSupportedLanguageList.add(str2);
                }
            }
        }
        List<String> list = this.mSupportedLanguageList;
        this.mSpenRecognizerSupportedLanguageList = list;
        String hWCurrentLanguage = getHWCurrentLanguage(list);
        if (hWCurrentLanguage != null) {
            this.mSupportedLanguageList.remove(hWCurrentLanguage);
            this.mSupportedLanguageList.add(0, hWCurrentLanguage);
        }
    }
}
