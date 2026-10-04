package com.samsung.android.sdk.handwriting.resources;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.handwriting.HwrLanguageID;
import com.samsung.android.sdk.handwriting.common.HwrLanguageMap;
import com.samsung.android.sdk.handwriting.resources.impl.HWRLanguageManager;
import com.samsung.android.sdk.handwriting.resources.interfaces.LanguageManagerInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class HwrLanguagePackManager {
    private static final String TAG = "HwrLanguagePackManager";
    private static final int UPDATE_RESULT_FAILURE = 1;
    private static final int UPDATE_RESULT_SUCCESS = 0;
    private static HwrLanguagePackManager mInstance;
    private static LanguageManagerInterface mLanguageManager;
    private ConcurrentHashMap<String, HwrLanguagePack> mLanguagePackMap = new ConcurrentHashMap<>();
    private HwrDownloadManager mDownloadManager = null;
    private String mApkVersionName = "";
    private final Object mSyncForMap = new Object();
    private final UpdateLanguageManagerListener mUpdateListener = new UpdateLanguageManagerListener(this, 0);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class UpdateLanguageManagerListener implements LanguageManagerInterface.OnUpdateListener {
        private LanguageManagerInterface.OnUpdateListener mListener;

        public /* synthetic */ UpdateLanguageManagerListener(HwrLanguagePackManager hwrLanguagePackManager, int i) {
            this();
        }

        private void onCompleteToUpdate(int i) {
            LanguageManagerInterface.OnUpdateListener onUpdateListener = this.mListener;
            if (onUpdateListener != null) {
                onUpdateListener.onComplete(i);
                this.mListener = null;
            }
        }

        @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguageManagerInterface.OnUpdateListener, com.samsung.android.sdk.handwriting.resources.HwrLanguageManager.OnUpdateListener
        public void onComplete(int i) {
            AbstractC2322a.m1631u(i, "update result = ", HwrLanguagePackManager.TAG);
            if (i != 0) {
                Log.e(HwrLanguagePackManager.TAG, "update failure");
                onCompleteToUpdate(i);
                return;
            }
            Log.i(HwrLanguagePackManager.TAG, "update success");
            if (HwrLanguagePackManager.mLanguageManager == null) {
                Log.e(HwrLanguagePackManager.TAG, "update error : mLanguageManager is null!");
                onCompleteToUpdate(1);
            } else {
                HwrLanguagePackManager.this.updateLanguagePackMap();
                onCompleteToUpdate(i);
            }
        }

        public void setListener(LanguageManagerInterface.OnUpdateListener onUpdateListener) {
            this.mListener = onUpdateListener;
        }

        private UpdateLanguageManagerListener() {
            this.mListener = null;
        }
    }

    private HwrLanguagePackManager(Context context) {
        closeLanguageManager();
        mLanguageManager = new HWRLanguageManager(context);
    }

    private void closeLanguageManager() {
        LanguageManagerInterface languageManagerInterface = mLanguageManager;
        if (languageManagerInterface != null) {
            languageManagerInterface.close();
            mLanguageManager = null;
        }
    }

    public static HwrLanguagePackManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new HwrLanguagePackManager(context);
        } else {
            LanguageManagerInterface languageManagerInterface = mLanguageManager;
            if (languageManagerInterface != null) {
                languageManagerInterface.initialize();
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLanguagePackMap() {
        Log.i(TAG, "updateLanguagePackMap : start");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (String str : mLanguageManager.getAvailableLanguage()) {
            concurrentHashMap.put(str, new HwrLanguagePack(mLanguageManager.get(str), mInstance));
        }
        synchronized (this.mSyncForMap) {
            try {
                ConcurrentHashMap<String, HwrLanguagePack> concurrentHashMap2 = this.mLanguagePackMap;
                if (concurrentHashMap2 != null) {
                    concurrentHashMap2.clear();
                    this.mLanguagePackMap = null;
                }
                ConcurrentHashMap<String, HwrLanguagePack> concurrentHashMap3 = new ConcurrentHashMap<>(concurrentHashMap);
                this.mLanguagePackMap = concurrentHashMap3;
                this.mDownloadManager = new HwrDownloadManager(concurrentHashMap3);
            } catch (Throwable th) {
                throw th;
            }
        }
        Log.i(TAG, "updateLanguagePackMap : mLanguagePackMap.size() = " + this.mLanguagePackMap.size());
    }

    public boolean awake() {
        LanguageManagerInterface languageManagerInterface = mLanguageManager;
        if (languageManagerInterface != null) {
            return languageManagerInterface.awake();
        }
        Log.e(TAG, "awake : mLanguageManager is null!");
        return false;
    }

    public void cancelDownload(String str) {
        synchronized (this.mSyncForMap) {
            try {
                HwrDownloadManager hwrDownloadManager = this.mDownloadManager;
                if (hwrDownloadManager != null) {
                    hwrDownloadManager.cancelDownload(HwrLanguageMap.getInternalLocale(str));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void close() {
        closeLanguageManager();
        synchronized (this.mSyncForMap) {
            try {
                for (HwrLanguagePack hwrLanguagePack : new ArrayList(this.mLanguagePackMap.values())) {
                    if (hwrLanguagePack.isDownloadInProgress()) {
                        hwrLanguagePack.cancel();
                    }
                }
                this.mLanguagePackMap.clear();
                this.mDownloadManager = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        mInstance = null;
    }

    public void finishDownload(String str) {
        synchronized (this.mSyncForMap) {
            try {
                HwrDownloadManager hwrDownloadManager = this.mDownloadManager;
                if (hwrDownloadManager != null) {
                    hwrDownloadManager.finishDownload(HwrLanguageMap.getInternalLocale(str));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public HwrLanguagePack get(String str) {
        synchronized (this.mSyncForMap) {
            try {
                ConcurrentHashMap<String, HwrLanguagePack> concurrentHashMap = this.mLanguagePackMap;
                if (concurrentHashMap != null) {
                    return concurrentHashMap.get(HwrLanguageMap.getInternalLocale(str));
                }
                Log.w(TAG, "HwrLanguagePack get(String language) : mLanguagePackMap is null!");
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String getApkVersionName() {
        return this.mApkVersionName;
    }

    public String[] getAvailableLanguage() {
        List<String> modifiedLanguageList;
        synchronized (this.mSyncForMap) {
            modifiedLanguageList = HwrLanguageMap.getModifiedLanguageList(new ArrayList(this.mLanguagePackMap.keySet()));
        }
        String[] strArr = (String[]) modifiedLanguageList.toArray(new String[0]);
        Log.i(TAG, "available language = " + HwrLanguageID.getIDs(strArr));
        return strArr;
    }

    public List<String> getPreloadedLanguage() {
        LanguageManagerInterface languageManagerInterface = mLanguageManager;
        if (languageManagerInterface != null) {
            return HwrLanguageMap.getModifiedLanguageList(languageManagerInterface.getPreloadedLanguage());
        }
        Log.e(TAG, "getPreloadedLanguage : mLanguageManager is null!");
        return new ArrayList();
    }

    public boolean isContainedInDownloadQ(String str) {
        synchronized (this.mSyncForMap) {
            try {
                HwrDownloadManager hwrDownloadManager = this.mDownloadManager;
                if (hwrDownloadManager == null) {
                    return false;
                }
                return hwrDownloadManager.isContainedInDownloadQ(HwrLanguageMap.getInternalLocale(str));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void requestDownload(String str) {
        synchronized (this.mSyncForMap) {
            try {
                HwrDownloadManager hwrDownloadManager = this.mDownloadManager;
                if (hwrDownloadManager != null) {
                    hwrDownloadManager.requestDownload(HwrLanguageMap.getInternalLocale(str));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setApkVersionName(String str) {
        this.mApkVersionName = str;
    }

    public void update(LanguageManagerInterface.OnUpdateListener onUpdateListener, boolean z) {
        if (mLanguageManager == null) {
            Log.e(TAG, "No language manager : mLanguageManager is null!");
            onUpdateListener.onComplete(1);
            return;
        }
        synchronized (this.mSyncForMap) {
            try {
                Iterator it = new ArrayList(this.mLanguagePackMap.values()).iterator();
                while (it.hasNext()) {
                    if (((HwrLanguagePack) it.next()).isDownloadInProgress()) {
                        Log.w(TAG, "Language downloading...");
                        onUpdateListener.onComplete(0);
                        return;
                    }
                }
                this.mUpdateListener.setListener(onUpdateListener);
                Log.i(TAG, "update start");
                mLanguageManager.update(this.mUpdateListener, z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
