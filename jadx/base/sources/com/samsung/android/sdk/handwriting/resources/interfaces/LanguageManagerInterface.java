package com.samsung.android.sdk.handwriting.resources.interfaces;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface LanguageManagerInterface {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnUpdateListener {
        void onComplete(int i);
    }

    boolean awake();

    void close();

    LanguagePackInterface get(String str);

    String[] getAvailableLanguage();

    List<String> getPreloadedLanguage();

    void initialize();

    void update(OnUpdateListener onUpdateListener);

    void update(OnUpdateListener onUpdateListener, boolean z);
}
