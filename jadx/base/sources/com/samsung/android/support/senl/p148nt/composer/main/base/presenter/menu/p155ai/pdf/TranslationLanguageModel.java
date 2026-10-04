package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TranslationLanguageModel {
    public static final String LANGUAGE_FROM = "FromLanguage";
    public static final String LANGUAGE_TO = "ToLanguage";
    private static final String TAG = Logger.createTag("AI#TranslationLanguageModel");
    private LanguageTagListener mListener;
    private String mFromLanguageTag = "";
    private String mToLanguageTag = "";
    private final TranslationLanguageRepository mRepository = new TranslationLanguageRepository();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface LanguageTagListener {
        void onToLanguageChanged();
    }

    public TranslationLanguageModel() {
        updateToLanguageTagFromRepository();
    }

    public int getFromLanguageState() {
        Locale locale = AiLanguageHelper.getLocale(this.mFromLanguageTag);
        if (AiLanguageHelper.isDownloadedLanguage(locale)) {
            return 0;
        }
        return AiLanguageHelper.isDownloadableLanguage(locale) ? 1 : 2;
    }

    @NonNull
    public String getFromLanguageTag() {
        return this.mFromLanguageTag;
    }

    public int getToLanguageState() {
        if (isSame()) {
            return 2;
        }
        if (AiLanguageHelper.isDownloadedLanguage(AiLanguageHelper.getLocale(this.mFromLanguageTag), AiLanguageHelper.getLocale(this.mToLanguageTag), false)) {
            return 0;
        }
        return AiLanguageHelper.isDownloadableLanguage(AiLanguageHelper.getLocale(this.mToLanguageTag)) ? 1 : 2;
    }

    @NonNull
    public String getToLanguageTag() {
        return this.mToLanguageTag;
    }

    public String getToLanguageTagFromRepository() {
        return this.mRepository.loadLastLanguageTag();
    }

    public boolean isInvalidStatus() {
        return TextUtils.isEmpty(this.mFromLanguageTag) || TextUtils.isEmpty(this.mToLanguageTag) || isSame() || !AiLanguageHelper.isDownloadedLanguage(AiLanguageHelper.getLocale(this.mFromLanguageTag), AiLanguageHelper.getLocale(this.mToLanguageTag), true);
    }

    public boolean isSame() {
        Locale locale;
        if (TextUtils.isEmpty(this.mFromLanguageTag) || (locale = AiLanguageHelper.getLocale(this.mFromLanguageTag)) == null) {
            return false;
        }
        if (AiLanguageHelper.isSeperateLanguagePack(locale.getLanguage())) {
            return this.mFromLanguageTag.equals(this.mToLanguageTag);
        }
        Locale locale2 = AiLanguageHelper.getLocale(this.mToLanguageTag);
        if (locale2 == null) {
            return false;
        }
        return AiLanguageHelper.convertSpecificLanguage(locale.getLanguage()).equals(AiLanguageHelper.convertSpecificLanguage(locale2.getLanguage()));
    }

    public void restore(Bundle bundle) {
        setFromLanguageTag(bundle.getString(LANGUAGE_FROM));
        setToLanguageTag(bundle.getString(LANGUAGE_TO));
    }

    public void save(Bundle bundle) {
        bundle.putString(LANGUAGE_FROM, this.mFromLanguageTag);
        bundle.putString(LANGUAGE_TO, this.mToLanguageTag);
    }

    public void setFromLanguageTag(@Nullable String str) {
        if (TextUtils.isEmpty(str) || this.mFromLanguageTag.equals(str)) {
            return;
        }
        this.mFromLanguageTag = str;
    }

    public void setLanguageTagListener(LanguageTagListener languageTagListener) {
        this.mListener = languageTagListener;
    }

    public void setToLanguageTag(@Nullable String str) {
        if (TextUtils.isEmpty(str) || this.mToLanguageTag.equals(str)) {
            return;
        }
        this.mToLanguageTag = str;
        LanguageTagListener languageTagListener = this.mListener;
        if (languageTagListener != null) {
            languageTagListener.onToLanguageChanged();
        }
    }

    public void updateFromLanguageTag(Locale locale) {
        Locale locale2 = AiLanguageHelper.getLocale(locale.toLanguageTag());
        if (locale2 == null) {
            Logger.m11000e(TAG, "identifyLanguage#onCompleted unexpected error");
            setFromLanguageTag(locale.toLanguageTag());
        } else {
            setFromLanguageTag(locale2.toLanguageTag());
        }
        this.mRepository.saveLastFromLanguage(this.mFromLanguageTag);
    }

    public void updateFromLanguageTagFromRepository() {
        setFromLanguageTag(this.mRepository.loadLastFromLanguageTag());
    }

    public void updateLanguageStatus() {
        if (!AiLanguageHelper.isDownloadedLanguage(AiLanguageHelper.getLocale(this.mFromLanguageTag))) {
            Logger.m10999d(TAG, "updateLanguageStatus# reset fromLanguageTag");
            this.mFromLanguageTag = "";
            this.mRepository.removeLastFromLanguage();
        }
        if (AiLanguageHelper.isDownloadedLanguage(AiLanguageHelper.getLocale(this.mToLanguageTag))) {
            return;
        }
        Logger.m10999d(TAG, "updateLanguageStatus# reset toLanguageTag");
        this.mToLanguageTag = "";
        this.mRepository.removeLastLanguage();
    }

    public void updateToLanguageTagFromRepository() {
        setToLanguageTag(this.mRepository.loadLastLanguageTag());
    }

    public void save() {
        this.mRepository.saveLastFromLanguage(this.mFromLanguageTag);
        this.mRepository.saveLastLanguage(this.mToLanguageTag);
    }
}
