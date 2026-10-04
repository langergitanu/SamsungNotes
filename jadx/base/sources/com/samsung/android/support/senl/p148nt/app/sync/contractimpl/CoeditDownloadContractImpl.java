package com.samsung.android.support.senl.p148nt.app.sync.contractimpl;

import com.samsung.android.support.senl.p148nt.coedit.caller.CoeditNoteUpDownloader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditDownloadContractImpl {
    public boolean isBackgroundDownloadStopped() {
        return CoeditNoteUpDownloader.getInstance().isBackgroundDownloadStoppedBySync();
    }

    public boolean isBackgroundDownloading() {
        return CoeditNoteUpDownloader.getInstance().isBackgroundDownloading();
    }

    public void requestBackgroundDownload() {
        CoeditNoteUpDownloader.getInstance().requestBackgroundDownload();
    }

    public void resumeBackgroundDownload() {
        CoeditNoteUpDownloader.getInstance().resumeBackgroundDownload();
    }

    public void stopBackgroundDownload() {
        CoeditNoteUpDownloader.getInstance().stopBackgroundDownload();
    }
}
