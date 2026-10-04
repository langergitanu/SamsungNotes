package com.samsung.android.sdk.handwriting.resources.interfaces;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface LanguagePackInterface {

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

    void cancel();

    void delete(OnDeleteListener onDeleteListener);

    void download(OnDownloadListener onDownloadListener);

    void downloadLanguage(OnDownloadListener onDownloadListener);

    void getDownloadSize(OnDownloadSizeListener onDownloadSizeListener);

    String getLanguage();

    boolean isDownloadInProgress();

    boolean isDownloaded();

    boolean isInstallable();

    boolean isPreloaded();

    boolean isUpdateAvailable();

    void setDownloadLanguageListener(OnDownloadListener onDownloadListener);

    void setDownloadListener(OnDownloadListener onDownloadListener);

    void setDownloadSizeListener(OnDownloadSizeListener onDownloadSizeListener);
}
