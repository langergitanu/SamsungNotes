package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.constants.DirectWriteConstant;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class DirectWriteLanguageData extends AbsStoredData<String> {
    private static final String KEY_DIRECT_WRITE_RECOGNITION_LANGUAGE = "KEY_DIRECT_WRITE_RECOGNITION_LANGUAGE";
    private boolean mIsLanguageMatched;
    private String mKeyboardLanguage;

    public DirectWriteLanguageData() {
        super(KEY_DIRECT_WRITE_RECOGNITION_LANGUAGE, DirectWriteConstant.NEED_RECOGNITION_LANGUAGE);
        this.mKeyboardLanguage = null;
    }

    public String getKeyboardLanguage() {
        return this.mKeyboardLanguage;
    }

    public boolean isLanguageMatched() {
        return this.mIsLanguageMatched;
    }

    public void setKeyboardLanguage(String str) {
        this.mKeyboardLanguage = str;
    }

    public void setLanguageMatching(boolean z) {
        this.mIsLanguageMatched = z;
    }
}
