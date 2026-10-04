package com.samsung.android.support.senl.p148nt.coedit.caller.handler;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.DownloadNoteCallback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface UpDownloaderContract {
    boolean addToRunningNoteUuids(String str, String str2);

    void cancelCoeditTrimLocalSDoc();

    void downloadSpenWNote(Context context, String str, String str2, String str3, String str4, DownloadNoteCallback downloadNoteCallback);

    void externalSnapStart(Context context, String str, String str2, String str3, String str4, String str5, DownloadNoteCallback downloadNoteCallback);

    boolean isExceedRunningNoteUuids();

    boolean isRunningNoteUuids(String str);

    void removeFromRunningNoteUuids(String str, String str2);

    void requestConnectSession();

    void requestDisconnectSession();
}
