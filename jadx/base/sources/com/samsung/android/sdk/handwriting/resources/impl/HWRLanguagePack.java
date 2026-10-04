package com.samsung.android.sdk.handwriting.resources.impl;

import android.content.Context;
import android.util.Log;
import com.samsung.android.sdk.handwriting.HwrLanguageID;
import com.samsung.android.sdk.handwriting.resources.impl.listener.HWRDeleteListener;
import com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import p001A.AbstractC0000a;
import p017D1.C0061b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class HWRLanguagePack implements HWRLanguage, LanguagePackInterface {
    private static final String TAG = "HWRLanguagePack";
    private HWRDeleteListener mDeleteListener;
    private LanguagePackInterface.OnDownloadListener mDownloadLanguageListener;
    private LanguagePackInterface.OnDownloadListener mDownloadListener;
    private LanguagePackInterface.OnDownloadSizeListener mDownloadSizeListener;
    private boolean mIsPreload;
    private final String mLanguage;
    private int mPrevState;
    private int mProgress;
    private final HWRRMLauncher mRmLauncher;
    private int mState;

    public HWRLanguagePack(Context context, HWRLanguagePack hWRLanguagePack, String str) {
        this(context, str);
        if (hWRLanguagePack == null) {
            return;
        }
        this.mDeleteListener = hWRLanguagePack.mDeleteListener;
        this.mDownloadListener = hWRLanguagePack.mDownloadListener;
        this.mDownloadLanguageListener = hWRLanguagePack.mDownloadLanguageListener;
        this.mDownloadSizeListener = hWRLanguagePack.mDownloadSizeListener;
    }

    private void deleteLanguage(HWRDeleteListener hWRDeleteListener) {
        this.mDeleteListener = hWRDeleteListener;
        deleteLanguageInternal();
    }

    private void deleteLanguageInternal() {
        if (isPreloaded()) {
            return;
        }
        setPrevState(this.mState);
        HWRRMLauncher hWRRMLauncher = this.mRmLauncher;
        if (hWRRMLauncher != null) {
            hWRRMLauncher.launchDeleteByIntent(this.mLanguage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$delete$0(LanguagePackInterface.OnDeleteListener onDeleteListener, boolean z, String str) {
        if (onDeleteListener != null) {
            onDeleteListener.onComplete(!z ? 1 : 0);
        }
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface
    public void cancel() {
        StringBuilder sb = new StringBuilder("cancel: ");
        sb.append(HwrLanguageID.getID(getLanguage()));
        sb.append(", state: ");
        sb.append(this.mState);
        sb.append(", prevstate: ");
        AbstractC0000a.m26w(sb, TAG, this.mPrevState);
        HWRRMLauncher hWRRMLauncher = this.mRmLauncher;
        if (hWRRMLauncher != null) {
            hWRRMLauncher.launchCancelByIntent(this.mLanguage);
        }
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface
    public void delete(LanguagePackInterface.OnDeleteListener onDeleteListener) {
        Log.i(TAG, "delete: " + HwrLanguageID.getID(getLanguage()) + ", state: " + this.mState + ", prevstate: " + this.mPrevState);
        deleteLanguage(new C0061b(onDeleteListener, 22));
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface
    public void download(LanguagePackInterface.OnDownloadListener onDownloadListener) {
        StringBuilder sb = new StringBuilder("download: ");
        sb.append(HwrLanguageID.getID(getLanguage()));
        sb.append(", state: ");
        sb.append(this.mState);
        sb.append(", prevstate: ");
        AbstractC0000a.m26w(sb, TAG, this.mPrevState);
        this.mDownloadListener = onDownloadListener;
        download();
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface
    public void downloadLanguage(LanguagePackInterface.OnDownloadListener onDownloadListener) {
        StringBuilder sb = new StringBuilder("downloadLanguage: ");
        sb.append(HwrLanguageID.getID(getLanguage()));
        sb.append(", state: ");
        sb.append(this.mState);
        sb.append(", prevstate: ");
        AbstractC0000a.m26w(sb, TAG, this.mPrevState);
        this.mDownloadLanguageListener = onDownloadListener;
        download();
    }

    public int getCurrentMax() {
        return 100;
    }

    public int getCurrentProgress() {
        return this.mProgress;
    }

    public int getCurrentState() {
        return this.mState;
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface
    public void getDownloadSize(LanguagePackInterface.OnDownloadSizeListener onDownloadSizeListener) {
        Log.i(TAG, "download size: " + HwrLanguageID.getID(getLanguage()));
        this.mDownloadSizeListener = onDownloadSizeListener;
        HWRRMLauncher hWRRMLauncher = this.mRmLauncher;
        if (hWRRMLauncher != null) {
            hWRRMLauncher.launchDownloadSizeByIntent(this.mLanguage);
        }
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface
    public String getLanguage() {
        return this.mLanguage;
    }

    public int getPrevState() {
        return this.mPrevState;
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface
    public boolean isDownloadInProgress() {
        return this.mState == 2;
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface
    public boolean isDownloaded() {
        return this.mState == 0;
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface
    public boolean isInstallable() {
        return this.mState == 1;
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface
    public boolean isPreloaded() {
        return this.mIsPreload;
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface
    public boolean isUpdateAvailable() {
        return this.mState == 4;
    }

    public void notifyDeleteResult(boolean z) {
        Log.i(TAG, "notifyDeleteResult: " + this.mLanguage + SQLKeyword.COMMA + z);
        StringBuilder sb = new StringBuilder("notifyDeleteResult: ");
        sb.append(this.mLanguage);
        sb.append(", mState before = ");
        AbstractC0000a.m26w(sb, TAG, this.mState);
        if (z) {
            this.mState = 1;
        } else {
            this.mState = getPrevState();
        }
        StringBuilder sb2 = new StringBuilder("notifyDeleteResult: ");
        sb2.append(this.mLanguage);
        sb2.append(", mState after = ");
        AbstractC0000a.m26w(sb2, TAG, this.mState);
        HWRDeleteListener hWRDeleteListener = this.mDeleteListener;
        if (hWRDeleteListener != null) {
            hWRDeleteListener.onComplete(z, this.mLanguage);
            this.mDeleteListener = null;
        }
    }

    public void notifyDownloadSizeResult(long j) {
        Log.i(TAG, "notifyDownloadSizeResult: " + this.mLanguage + ", size = " + j);
        LanguagePackInterface.OnDownloadSizeListener onDownloadSizeListener = this.mDownloadSizeListener;
        if (onDownloadSizeListener != null) {
            onDownloadSizeListener.onDownloadSize(j);
            this.mDownloadSizeListener = null;
        }
    }

    public void notifyUpdateResult(int i) {
        Log.i(TAG, "notifyUpdateResult: " + this.mLanguage + SQLKeyword.COMMA + i);
        StringBuilder sb = new StringBuilder("notifyUpdateResult: ");
        sb.append(this.mLanguage);
        sb.append(", mState before = ");
        AbstractC0000a.m26w(sb, TAG, this.mState);
        if (i == 0) {
            this.mState = 0;
        } else {
            this.mState = getPrevState();
        }
        StringBuilder sb2 = new StringBuilder("notifyUpdateResult: ");
        sb2.append(this.mLanguage);
        sb2.append(", mState after = ");
        AbstractC0000a.m26w(sb2, TAG, this.mState);
        LanguagePackInterface.OnDownloadListener onDownloadListener = this.mDownloadListener;
        if (onDownloadListener != null) {
            onDownloadListener.onComplete(i);
            this.mDownloadListener = null;
        }
        LanguagePackInterface.OnDownloadListener onDownloadListener2 = this.mDownloadLanguageListener;
        if (onDownloadListener2 != null) {
            onDownloadListener2.onComplete(i);
            this.mDownloadLanguageListener = null;
        }
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface
    public void setDownloadLanguageListener(LanguagePackInterface.OnDownloadListener onDownloadListener) {
        this.mDownloadLanguageListener = onDownloadListener;
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface
    public void setDownloadListener(LanguagePackInterface.OnDownloadListener onDownloadListener) {
        this.mDownloadListener = onDownloadListener;
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface
    public void setDownloadSizeListener(LanguagePackInterface.OnDownloadSizeListener onDownloadSizeListener) {
        this.mDownloadSizeListener = onDownloadSizeListener;
    }

    public void setPreloaded(boolean z) {
        this.mIsPreload = z;
    }

    public void setPrevState(int i) {
        this.mPrevState = i;
    }

    public void setProgress(int i) {
        this.mProgress = i;
        LanguagePackInterface.OnDownloadListener onDownloadListener = this.mDownloadListener;
        if (onDownloadListener != null) {
            onDownloadListener.onProgress(i, 100);
        }
        LanguagePackInterface.OnDownloadListener onDownloadListener2 = this.mDownloadLanguageListener;
        if (onDownloadListener2 != null) {
            onDownloadListener2.onProgress(i, 100);
        }
    }

    public void setState(int i) {
        this.mState = i;
        this.mProgress = 0;
    }

    public HWRLanguagePack(Context context, String str) {
        Log.i(TAG, "HWRLanguagePack: construct : language = " + str);
        this.mRmLauncher = new HWRRMLauncher(context);
        this.mLanguage = str;
        this.mIsPreload = false;
    }

    private void download() {
        setPrevState(this.mState);
        this.mState = 2;
        HWRRMLauncher hWRRMLauncher = this.mRmLauncher;
        if (hWRRMLauncher != null) {
            hWRRMLauncher.launchUpdateByIntent(this.mLanguage);
        }
    }
}
