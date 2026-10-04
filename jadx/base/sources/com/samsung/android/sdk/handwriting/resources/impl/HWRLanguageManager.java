package com.samsung.android.sdk.handwriting.resources.impl;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.handwriting.HwrLanguageID;
import com.samsung.android.sdk.handwriting.resources.impl.listener.HWRRefreshListener;
import com.samsung.android.sdk.handwriting.resources.interfaces.LanguageManagerInterface;
import com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class HWRLanguageManager implements LanguageManagerInterface {
    private static final String TAG = "HWRLanguageManager";
    private final HWRLanguagePackManager mLanguageManager;
    private HashMap<String, HWRLanguagePack> mLanguagePack = null;
    private HashMap<String, HWRLanguagePack> mInstalledLanguage = null;
    private HashMap<String, HWRLanguagePack> mDownloadableLanguage = null;

    public HWRLanguageManager(Context context) {
        this.mLanguageManager = new HWRLanguagePackManager(context);
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$update$0(LanguageManagerInterface.OnUpdateListener onUpdateListener, int i) {
        AbstractC2322a.m1631u(i, "inner update result = ", TAG);
        HashMap<String, HWRLanguagePack> languagePacks = this.mLanguageManager.getLanguagePacks();
        this.mLanguagePack = languagePacks;
        if (languagePacks != null && languagePacks.size() > 0) {
            this.mInstalledLanguage = new HashMap<>();
            this.mDownloadableLanguage = new HashMap<>();
            for (String str : this.mLanguagePack.keySet()) {
                HWRLanguagePack hWRLanguagePack = this.mLanguagePack.get(str);
                if (hWRLanguagePack != null && (hWRLanguagePack.isDownloaded() || hWRLanguagePack.isUpdateAvailable())) {
                    this.mInstalledLanguage.put(str, hWRLanguagePack);
                    Log.i(TAG, "Installed Language list = " + HwrLanguageID.getID(str));
                }
            }
            for (String str2 : this.mLanguagePack.keySet()) {
                HWRLanguagePack hWRLanguagePack2 = this.mLanguagePack.get(str2);
                if (hWRLanguagePack2 != null && hWRLanguagePack2.isInstallable()) {
                    this.mDownloadableLanguage.put(str2, hWRLanguagePack2);
                    Log.i(TAG, "Downloadable Language list = " + HwrLanguageID.getID(str2));
                }
            }
        }
        if (onUpdateListener != null) {
            onUpdateListener.onComplete(i);
        }
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguageManagerInterface
    public boolean awake() {
        HWRLanguagePackManager hWRLanguagePackManager = this.mLanguageManager;
        if (hWRLanguagePackManager != null) {
            return hWRLanguagePackManager.awakeContentProvider();
        }
        Log.e(TAG, "awake : mLanguageManager is null!");
        return false;
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguageManagerInterface
    public void close() {
        this.mLanguageManager.unregisterReceiver();
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguageManagerInterface
    public LanguagePackInterface get(String str) {
        return this.mLanguageManager.get(str);
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguageManagerInterface
    public String[] getAvailableLanguage() {
        HashMap<String, HWRLanguagePack> map = this.mLanguagePack;
        return (map == null || map.keySet().size() == 0) ? new String[0] : (String[]) this.mLanguagePack.keySet().toArray(new String[0]);
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguageManagerInterface
    public List<String> getPreloadedLanguage() {
        return HWRPreloadLanguageManager.getPreloadedLanguages();
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguageManagerInterface
    public void initialize() {
        this.mLanguageManager.registerReceiver();
    }

    public void update() {
        if (!this.mLanguageManager.updateLanguageManager()) {
            Log.e(TAG, "[HWRLanguageManager : updateList] Fail to update list!");
            return;
        }
        HashMap<String, HWRLanguagePack> languagePacks = this.mLanguageManager.getLanguagePacks();
        this.mLanguagePack = languagePacks;
        if (languagePacks == null || languagePacks.size() <= 0) {
            return;
        }
        Log.i(TAG, "Language list = " + this.mLanguagePack.size());
        this.mInstalledLanguage = new HashMap<>();
        this.mDownloadableLanguage = new HashMap<>();
        for (String str : this.mLanguagePack.keySet()) {
            HWRLanguagePack hWRLanguagePack = this.mLanguagePack.get(str);
            if (hWRLanguagePack != null && (hWRLanguagePack.isDownloaded() || hWRLanguagePack.isUpdateAvailable())) {
                this.mInstalledLanguage.put(str, hWRLanguagePack);
                Log.i(TAG, "Installed Language list = " + HwrLanguageID.getID(str));
            }
        }
        for (String str2 : this.mLanguagePack.keySet()) {
            HWRLanguagePack hWRLanguagePack2 = this.mLanguagePack.get(str2);
            if (hWRLanguagePack2 != null && hWRLanguagePack2.isInstallable()) {
                this.mDownloadableLanguage.put(str2, hWRLanguagePack2);
                Log.i(TAG, "Downloadable Language list = " + HwrLanguageID.getID(str2));
            }
        }
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguageManagerInterface
    public void update(final LanguageManagerInterface.OnUpdateListener onUpdateListener, boolean z) {
        if (z) {
            Log.i(TAG, "update() : download the latest resource list from server!");
            this.mLanguageManager.updateResourceListFromServer();
        }
        this.mLanguageManager.updateLanguageManager(new HWRRefreshListener() { // from class: com.samsung.android.sdk.handwriting.resources.impl.a
            @Override // com.samsung.android.sdk.handwriting.resources.impl.listener.HWRRefreshListener
            public final void onComplete(int i) {
                this.f4873a.lambda$update$0(onUpdateListener, i);
            }
        });
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguageManagerInterface
    public void update(LanguageManagerInterface.OnUpdateListener onUpdateListener) {
        update(onUpdateListener, false);
    }
}
