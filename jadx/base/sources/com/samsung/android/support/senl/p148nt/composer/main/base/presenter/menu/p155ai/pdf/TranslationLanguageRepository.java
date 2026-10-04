package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf;

import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TranslationLanguageRepository {
    private String getDefaultLanguageTag() {
        return Locale.getDefault().toLanguageTag();
    }

    public String loadLastFromLanguageTag() {
        return SharedPreferencesCompat.getInstance("Composer").getString(SharedPreferencesConstants.COMPOSER_KEY_AI_TRANSLATE_LAST_FROM_LANGUAGE, getDefaultLanguageTag());
    }

    public String loadLastLanguageTag() {
        return SharedPreferencesCompat.getInstance("Composer").getString(SharedPreferencesConstants.COMPOSER_KEY_AI_TRANSLATE_LAST_LANGUAGE, getDefaultLanguageTag());
    }

    public void removeLastFromLanguage() {
        SharedPreferencesCompat.getInstance("Composer").remove(SharedPreferencesConstants.COMPOSER_KEY_AI_TRANSLATE_LAST_FROM_LANGUAGE);
    }

    public void removeLastLanguage() {
        SharedPreferencesCompat.getInstance("Composer").remove(SharedPreferencesConstants.COMPOSER_KEY_AI_TRANSLATE_LAST_LANGUAGE);
    }

    public void saveLastFromLanguage(String str) {
        Locale locale;
        if (TextUtils.isEmpty(str) || (locale = AiLanguageHelper.getLocale(str)) == null) {
            return;
        }
        SharedPreferencesCompat.getInstance("Composer").putString(SharedPreferencesConstants.COMPOSER_KEY_AI_TRANSLATE_LAST_FROM_LANGUAGE, locale.toLanguageTag());
    }

    public void saveLastLanguage(String str) {
        Locale locale;
        if (TextUtils.isEmpty(str) || (locale = AiLanguageHelper.getLocale(str)) == null) {
            return;
        }
        SharedPreferencesCompat.getInstance("Composer").putString(SharedPreferencesConstants.COMPOSER_KEY_AI_TRANSLATE_LAST_LANGUAGE, locale.toLanguageTag());
    }
}
