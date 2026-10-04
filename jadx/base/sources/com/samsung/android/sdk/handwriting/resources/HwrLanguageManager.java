package com.samsung.android.sdk.handwriting.resources;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.samsung.android.sdk.handwriting.resources.utils.HwrTools;
import java.util.ArrayList;
import java.util.List;
import p001A.AbstractC0000a;
import p079T.C0287e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class HwrLanguageManager {
    public static final int RESULT_FAILURE = -1;
    public static final int RESULT_FAILURE_NO_SPACE_LEFT = -2;
    public static final int RESULT_SUCCESS = 0;
    public static final String TAG = "HwrLanguageManager";
    private HwrLanguagePackManager mLanguagePackManager = null;
    private boolean mIsUpdating = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnUpdateListener {
        void onComplete(int i);
    }

    public HwrLanguageManager(Context context) {
        Log.i(TAG, "Initialize HwrLanguageManager : 2023_0811");
        if (initialize(context.getApplicationContext())) {
            return;
        }
        Log.e(TAG, "Handwriting module is not in the framework");
    }

    private boolean initialize(Context context) {
        String versionNameOf = HwrTools.getVersionNameOf(context, "com.samsung.android.sdk.handwriting");
        boolean zIsEmpty = TextUtils.isEmpty(versionNameOf);
        boolean z = !zIsEmpty;
        if (!zIsEmpty) {
            HwrLanguagePackManager hwrLanguagePackManager = HwrLanguagePackManager.getInstance(context.getApplicationContext());
            this.mLanguagePackManager = hwrLanguagePackManager;
            if (hwrLanguagePackManager != null) {
                hwrLanguagePackManager.setApkVersionName(versionNameOf);
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$update$0(OnUpdateListener onUpdateListener, int i) {
        if (onUpdateListener != null) {
            onUpdateListener.onComplete(i);
        }
        this.mIsUpdating = false;
        AbstractC0000a.m27x(new StringBuilder("update() : finish on listener, mIsUpdating is set FALSE, , mIsUpdating = "), this.mIsUpdating, TAG);
    }

    public void close() {
        HwrLanguagePackManager hwrLanguagePackManager = this.mLanguagePackManager;
        if (hwrLanguagePackManager != null) {
            hwrLanguagePackManager.close();
            this.mLanguagePackManager = null;
        }
    }

    public HwrLanguagePack get(String str) {
        HwrLanguagePackManager hwrLanguagePackManager = this.mLanguagePackManager;
        if (hwrLanguagePackManager != null) {
            return hwrLanguagePackManager.get(str);
        }
        return null;
    }

    public String[] getAvailableLanguage() {
        HwrLanguagePackManager hwrLanguagePackManager = this.mLanguagePackManager;
        return hwrLanguagePackManager != null ? hwrLanguagePackManager.getAvailableLanguage() : new String[0];
    }

    public List<String> getPreloadedLanguage() {
        HwrLanguagePackManager hwrLanguagePackManager = this.mLanguagePackManager;
        return hwrLanguagePackManager != null ? hwrLanguagePackManager.getPreloadedLanguage() : new ArrayList();
    }

    public boolean isPreloadedLanguage(String str) {
        List<String> preloadedLanguage = getPreloadedLanguage();
        if (preloadedLanguage == null || preloadedLanguage.size() <= 0) {
            return false;
        }
        return preloadedLanguage.contains(str);
    }

    public void update(OnUpdateListener onUpdateListener, boolean z) {
        AbstractC0000a.m27x(new StringBuilder("update() : start, mIsUpdating = "), this.mIsUpdating, TAG);
        if (this.mIsUpdating) {
            Log.i(TAG, "update() : Updating is in progress. This update() call is just ignored.");
            return;
        }
        this.mIsUpdating = true;
        AbstractC0000a.m27x(new StringBuilder("update() : mIsUpdating is set TRUE, mIsUpdating = "), this.mIsUpdating, TAG);
        HwrLanguagePackManager hwrLanguagePackManager = this.mLanguagePackManager;
        if (hwrLanguagePackManager != null) {
            hwrLanguagePackManager.update(new C0287e(this, onUpdateListener, 7), z);
            return;
        }
        if (onUpdateListener != null) {
            onUpdateListener.onComplete(-1);
        }
        this.mIsUpdating = false;
        AbstractC0000a.m27x(new StringBuilder("update() : finish on sync, mIsUpdating is set FALSE, , mIsUpdating = "), this.mIsUpdating, TAG);
    }

    public void update(OnUpdateListener onUpdateListener) {
        update(onUpdateListener, false);
    }
}
