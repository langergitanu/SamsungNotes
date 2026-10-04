package com.samsung.android.sdk.handwriting.resources;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.handwriting.HwrLanguageID;
import com.samsung.android.sdk.handwriting.common.HwrResConfigBase;
import com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface;
import com.samsung.android.sdk.handwriting.resources.utils.HwrTools;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class HwrLanguagePack {
    public static final int DOWNLOAD_SIZE_RESULT_FAILURE = -1;
    public static final int RESULT_FAILURE = 1;
    public static final int RESULT_SUCCESS = 0;
    private static final String TAG = "HwrLanguagePack";
    private final LanguagePackInterface mLanguagePack;
    private final HwrLanguagePackManager mLanguagePackManager;
    private LanguagePackDownloadListener mDownloadListener = null;
    private LanguagePackDownloadListener mDownloadLanguageListener = null;
    private boolean mDownloadInProgressDownloadQ = false;
    private boolean mCancelInProgress = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LanguagePackDeleteListener implements LanguagePackInterface.OnDeleteListener {
        private OnDeleteListener mListener;

        public /* synthetic */ LanguagePackDeleteListener(int i) {
            this();
        }

        @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface.OnDeleteListener
        public void onComplete(int i) {
            AbstractC2322a.m1631u(i, "Delete Complete = ", HwrLanguagePack.TAG);
            OnDeleteListener onDeleteListener = this.mListener;
            if (onDeleteListener != null) {
                onDeleteListener.onComplete(i);
            }
        }

        public void setListener(OnDeleteListener onDeleteListener) {
            this.mListener = onDeleteListener;
        }

        private LanguagePackDeleteListener() {
            this.mListener = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class LanguagePackDownloadListener implements LanguagePackInterface.OnDownloadListener {
        private OnDownloadListener mListener;

        public /* synthetic */ LanguagePackDownloadListener(HwrLanguagePack hwrLanguagePack, int i) {
            this();
        }

        @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface.OnDownloadListener
        public void onComplete(int i) {
            String language = HwrLanguagePack.this.mLanguagePack.getLanguage();
            Log.i(HwrLanguagePack.TAG, "[onComplete] " + HwrLanguageID.getID(language) + " download complete = " + i);
            StringBuilder sb = new StringBuilder("[onComplete] mDownloadInProgressDownloadQ: ");
            sb.append(HwrLanguagePack.this.mDownloadInProgressDownloadQ);
            Log.i(HwrLanguagePack.TAG, sb.toString());
            AbstractC0000a.m27x(new StringBuilder("[onComplete] success? = "), i == 0, HwrLanguagePack.TAG);
            HwrLanguagePack.this.mCancelInProgress = false;
            if (HwrLanguagePack.this.mDownloadListener != null) {
                if (HwrLanguagePack.this.mDownloadInProgressDownloadQ) {
                    HwrLanguagePack.this.mLanguagePackManager.cancelDownload(language);
                } else {
                    HwrLanguagePack.this.mLanguagePackManager.finishDownload(language);
                }
            }
            HwrLanguagePack.this.mDownloadInProgressDownloadQ = false;
            HwrLanguagePack.this.mDownloadListener = null;
            HwrLanguagePack.this.mDownloadLanguageListener = null;
            OnDownloadListener onDownloadListener = this.mListener;
            if (onDownloadListener != null) {
                onDownloadListener.onComplete(i);
            }
        }

        @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface.OnDownloadListener
        public void onProgress(int i, int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(HwrLanguageID.getID(HwrLanguagePack.this.mLanguagePack.getLanguage()));
            sb.append(": ");
            sb.append(i);
            sb.append("%, max = ");
            AbstractC0000a.m26w(sb, HwrLanguagePack.TAG, i2);
            OnDownloadListener onDownloadListener = this.mListener;
            if (onDownloadListener != null) {
                onDownloadListener.onProgress(i, 100);
            }
        }

        public void setListener(OnDownloadListener onDownloadListener) {
            this.mListener = onDownloadListener;
        }

        private LanguagePackDownloadListener() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LanguagePackDownloadSizeListener implements LanguagePackInterface.OnDownloadSizeListener {
        private OnDownloadSizeListener mListener;

        public /* synthetic */ LanguagePackDownloadSizeListener(int i) {
            this();
        }

        @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface.OnDownloadSizeListener
        public void onDownloadSize(long j) {
            Log.i(HwrLanguagePack.TAG, "Download size = " + j);
            OnDownloadSizeListener onDownloadSizeListener = this.mListener;
            if (onDownloadSizeListener != null) {
                onDownloadSizeListener.onDownloadSize(j);
            }
        }

        public void setListener(OnDownloadSizeListener onDownloadSizeListener) {
            this.mListener = onDownloadSizeListener;
        }

        private LanguagePackDownloadSizeListener() {
            this.mListener = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnDeleteListener {
        void onComplete(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnDownloadListener {
        void onComplete(int i);

        void onProgress(int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnDownloadSizeListener {
        void onDownloadSize(long j);
    }

    public HwrLanguagePack(LanguagePackInterface languagePackInterface, HwrLanguagePackManager hwrLanguagePackManager) {
        this.mLanguagePack = languagePackInterface;
        this.mLanguagePackManager = hwrLanguagePackManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$returnLanguagePackDownloadListener$1(int i, LanguagePackDownloadListener languagePackDownloadListener) {
        AbstractC2322a.m1631u(i, "returnLanguagePackDownloadListener : status = ", TAG);
        if (languagePackDownloadListener == null) {
            Log.i(TAG, "returnLanguagePackDownloadListener : listener is null!");
        } else {
            languagePackDownloadListener.onComplete(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$returnOnDownloadListener$0(int i, OnDownloadListener onDownloadListener) {
        AbstractC2322a.m1631u(i, "returnOnDownloadListener : status = ", TAG);
        if (onDownloadListener == null) {
            Log.i(TAG, "returnOnDownloadListener : listener is null!");
        } else {
            onDownloadListener.onComplete(i);
        }
    }

    private void returnLanguagePackDownloadListener(LanguagePackDownloadListener languagePackDownloadListener, int i) {
        startRunnable(new RunnableC7270a(i, languagePackDownloadListener, 0));
    }

    private void returnOnDownloadListener(OnDownloadListener onDownloadListener, int i) {
        startRunnable(new RunnableC7270a(i, onDownloadListener, 1));
    }

    private void startRunnable(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            new Handler().post(runnable);
        } else {
            new Thread(runnable).start();
        }
    }

    public void cancel() {
        if (!isDownloadInProgress()) {
            Log.w(TAG, "[cancel] not download in progress! just return.");
            return;
        }
        this.mCancelInProgress = true;
        Log.i(TAG, "[cancel] start to cancel");
        AbstractC0000a.m27x(new StringBuilder("[cancel] mDownloadInProgressDownloadQ: "), this.mDownloadInProgressDownloadQ, TAG);
        if (this.mDownloadInProgressDownloadQ) {
            returnLanguagePackDownloadListener(this.mDownloadListener, 1);
            return;
        }
        String language = this.mLanguagePack.getLanguage();
        Log.i(TAG, "[cancel] languageID = " + HwrLanguageID.getID(language));
        this.mLanguagePackManager.cancelDownload(language);
        this.mLanguagePack.cancel();
    }

    public void delete(OnDeleteListener onDeleteListener) {
        Log.i(TAG, "[delete] awake process to download");
        if (!this.mLanguagePackManager.awake()) {
            Log.e(TAG, "[delete] : cannot awake content provider!");
            onDeleteListener.onComplete(1);
        } else if (this.mLanguagePack == null) {
            Log.e(TAG, "mLanguagePack is null!");
            onDeleteListener.onComplete(1);
        } else {
            LanguagePackDeleteListener languagePackDeleteListener = new LanguagePackDeleteListener(0);
            languagePackDeleteListener.setListener(onDeleteListener);
            this.mLanguagePack.delete(languagePackDeleteListener);
        }
    }

    public void download(OnDownloadListener onDownloadListener) {
        if (this.mCancelInProgress) {
            Log.w(TAG, "[download] canceling is in progress!");
            return;
        }
        Log.i(TAG, "[download] awake process to download");
        if (!this.mLanguagePackManager.awake()) {
            Log.e(TAG, "[download] : cannot awake content provider!");
            returnOnDownloadListener(onDownloadListener, 1);
            return;
        }
        LanguagePackInterface languagePackInterface = this.mLanguagePack;
        if (languagePackInterface == null) {
            Log.e(TAG, "Invalid language pack : mLanguagePack is null!");
            returnOnDownloadListener(onDownloadListener, 1);
            return;
        }
        String language = languagePackInterface.getLanguage();
        if (this.mLanguagePackManager.isContainedInDownloadQ(language)) {
            Log.w(TAG, "Already downloading in DownloadQ, LanguageID = " + HwrLanguageID.getID(language));
            setDownloadListener(onDownloadListener);
            return;
        }
        LanguagePackDownloadListener languagePackDownloadListener = new LanguagePackDownloadListener(this, 0);
        this.mDownloadListener = languagePackDownloadListener;
        languagePackDownloadListener.setListener(onDownloadListener);
        Log.i(TAG, "[download] Download is requested : languageID = " + HwrLanguageID.getID(language));
        this.mDownloadInProgressDownloadQ = true;
        this.mLanguagePackManager.requestDownload(language);
    }

    public void downloadLanguage(OnDownloadListener onDownloadListener) {
        if (this.mCancelInProgress) {
            Log.w(TAG, "[downloadLanguage] canceling is in progress!");
            return;
        }
        Log.i(TAG, "[downloadLanguage] awake process to download");
        if (!this.mLanguagePackManager.awake()) {
            Log.e(TAG, "[downloadLanguage] : cannot awake content provider!");
            returnOnDownloadListener(onDownloadListener, 1);
            return;
        }
        if (this.mLanguagePack == null) {
            Log.e(TAG, "Invalid language pack: mLanguagePack is null");
            returnOnDownloadListener(onDownloadListener, 1);
            return;
        }
        LanguagePackDownloadListener languagePackDownloadListener = new LanguagePackDownloadListener(this, 0);
        this.mDownloadLanguageListener = languagePackDownloadListener;
        languagePackDownloadListener.setListener(onDownloadListener);
        Log.i(TAG, "[downloadLanguage] languageID = " + HwrLanguageID.getID(this.mLanguagePack.getLanguage()));
        this.mLanguagePack.downloadLanguage(this.mDownloadLanguageListener);
    }

    public void getDownloadSize(OnDownloadSizeListener onDownloadSizeListener) {
        Log.i(TAG, "[getDownloadSize] awake process to download");
        if (!this.mLanguagePackManager.awake()) {
            Log.e(TAG, "[getDownloadSize] : cannot awake content provider!");
            onDownloadSizeListener.onDownloadSize(-1L);
            return;
        }
        if (this.mLanguagePack == null) {
            Log.e(TAG, "mLanguagePack is null!");
            onDownloadSizeListener.onDownloadSize(-1L);
        } else if (HwrTools.compareTwoVersions(this.mLanguagePackManager.getApkVersionName(), HwrResConfigBase.DOWNLOADSIZE_API_AVAILABLE_VERSION) < 0) {
            Log.e(TAG, "Cannot support getDownloadSize in this APK!");
            onDownloadSizeListener.onDownloadSize(-1L);
        } else {
            LanguagePackDownloadSizeListener languagePackDownloadSizeListener = new LanguagePackDownloadSizeListener(0);
            languagePackDownloadSizeListener.setListener(onDownloadSizeListener);
            this.mLanguagePack.getDownloadSize(languagePackDownloadSizeListener);
        }
    }

    public boolean isCancelInProgress() {
        return this.mCancelInProgress;
    }

    public boolean isDownloadInProgress() {
        if (this.mDownloadInProgressDownloadQ) {
            return true;
        }
        LanguagePackInterface languagePackInterface = this.mLanguagePack;
        if (languagePackInterface != null) {
            return languagePackInterface.isDownloadInProgress();
        }
        Log.e(TAG, "mLanguagePack is null!");
        return false;
    }

    public boolean isDownloaded() {
        LanguagePackInterface languagePackInterface = this.mLanguagePack;
        if (languagePackInterface != null) {
            return languagePackInterface.isDownloaded();
        }
        Log.e(TAG, "mLanguagePack is null!");
        return false;
    }

    public boolean isInstallable() {
        LanguagePackInterface languagePackInterface = this.mLanguagePack;
        if (languagePackInterface != null) {
            return languagePackInterface.isInstallable();
        }
        Log.e(TAG, "mLanguagePack is null!");
        return false;
    }

    public boolean isPreloaded() {
        LanguagePackInterface languagePackInterface = this.mLanguagePack;
        if (languagePackInterface != null) {
            return languagePackInterface.isPreloaded();
        }
        Log.e(TAG, "mLanguagePack is null!");
        return false;
    }

    public boolean isUpdateAvailable() {
        LanguagePackInterface languagePackInterface = this.mLanguagePack;
        if (languagePackInterface != null) {
            return languagePackInterface.isUpdateAvailable();
        }
        Log.e(TAG, "mLanguagePack is null!");
        return false;
    }

    public void setDownloadLanguageListener(OnDownloadListener onDownloadListener) {
        LanguagePackDownloadListener languagePackDownloadListener = new LanguagePackDownloadListener(this, 0);
        this.mDownloadLanguageListener = languagePackDownloadListener;
        languagePackDownloadListener.setListener(onDownloadListener);
        LanguagePackInterface languagePackInterface = this.mLanguagePack;
        if (languagePackInterface != null) {
            languagePackInterface.setDownloadLanguageListener(this.mDownloadLanguageListener);
        }
    }

    public void setDownloadListener(OnDownloadListener onDownloadListener) {
        LanguagePackDownloadListener languagePackDownloadListener = new LanguagePackDownloadListener(this, 0);
        this.mDownloadListener = languagePackDownloadListener;
        languagePackDownloadListener.setListener(onDownloadListener);
        LanguagePackInterface languagePackInterface = this.mLanguagePack;
        if (languagePackInterface != null) {
            languagePackInterface.setDownloadListener(this.mDownloadListener);
        }
    }

    public void download() {
        this.mDownloadInProgressDownloadQ = false;
        Log.i(TAG, "download() : awake process to download");
        if (!this.mLanguagePackManager.awake()) {
            returnLanguagePackDownloadListener(this.mDownloadListener, 1);
        } else {
            this.mLanguagePack.download(this.mDownloadListener);
        }
    }
}
