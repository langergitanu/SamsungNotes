package com.samsung.android.support.senl.ntnl.coedit;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface ICoeditController {
    boolean canShowProgress();

    int getAbnormalReleased(String str);

    String getCacheFilePath(String str);

    int getCurrentDocumentSize(String str);

    long getLastDownloadedCheckPoint(String str);

    String getMimeType(String str);

    void handleExceedMaxConnectDevice(long j);

    void hideProgress(String str);

    boolean isEditMode();

    boolean isLocalDataChanged(String str);

    boolean isMainThread();

    boolean isNetworkReconnectDisabled();

    boolean isReconnectAvailable();

    boolean isSnapDuration(String str, String str2);

    boolean isSnapUploadCompleted(String str);

    void onDeviceListUpdated(List<CoeditDeviceInfo> list);

    void onError(long j, String str);

    void releaseForReconnect(String str);

    void releaseJwt();

    String requestDownloadFile(String str, String str2, String str3);

    void requestReconnect(String str);

    int requestUploadFile(String str, String str2, String str3, long j, String str4, String str5);

    void restoreUndrawnData(String str);

    void runOnUiThread(long j);

    void setAbnormalReleased(String str, int i);

    void setCurrentDocumentSize(String str, int i);

    void setDisableOfflineEditMode(boolean z);

    void setLastDownloadedCheckPoint(String str, long j);

    void setLocalDataChanged(String str, boolean z);

    void setRequestUpdate(String str, int i);

    void setXmlDocumentSize(String str);

    void showProgress(String str);
}
