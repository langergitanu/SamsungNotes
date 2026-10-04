package com.samsung.android.support.senl.p148nt.coedit.service.task;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.service.task.ExternalBaseTask;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.io.IOException;
import p079T.AbstractC0291i;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ExternalSnapDownloadTask extends ExternalBaseTask {
    private static final String TAG = "ExternalSnapDownloadTask";
    private final String mTempFilePath;

    public ExternalSnapDownloadTask(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull ExternalBaseTask.UpDownloadCallback upDownloadCallback) {
        super(context, str2, str3, str4, upDownloadCallback);
        this.mTempFilePath = str;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.service.task.ExternalBaseTask
    public void execute() {
        CoeditLogger.m8919d(TAG, "[CS7] externalSnapDownload, run() : uuid = " + this.mUuid);
        if (CoeditHandlerManager.getInstance().isCoeditRunning(this.mUuid) || AbstractC0291i.m569f(this.mUuid)) {
            CoeditLogger.m8920e(TAG, "[CS7-2] externalSnapDownload, run() : already exists, uuid = " + this.mUuid);
            this.mCallback.onError(201);
            return;
        }
        try {
            SpenWNote spenWNote = new SpenWNote(this.mContext, null, SpenWNote.PageMode.LIST, SpenWNote.Orientation.PORTRAIT, 2160, true);
            try {
                DocumentFileManager.getInstance().saveAsDirectory(spenWNote, this.mTempFilePath);
                CoeditHandlerManager.getInstance().externalSnapDownload(spenWNote, this.mUuid, this.mTempFilePath, this.mGroupId, this.mWorkspaceId, new ExternalBaseTask.ExternalBaseCallback(this.mCallback, this.mContract) { // from class: com.samsung.android.support.senl.nt.coedit.service.task.ExternalSnapDownloadTask.1
                    @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.ExternalControlCallback
                    public void onCompleted(final SpenWNote spenWNote2, final String str) {
                        AbstractC8014b.m7219u("[CS7-1] externalSnapDownload, run, onCompleted() : uuid = ", str, ExternalSnapDownloadTask.TAG);
                        ExternalBaseTask.Contract contract = this.contract;
                        if (contract != null) {
                            contract.releaseHandler(ExternalSnapDownloadTask.this.mUuid, "externalSnapDownload-onComplete", new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.service.task.ExternalSnapDownloadTask.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ExternalSnapDownloadTask externalSnapDownloadTask;
                                    String str2;
                                    SpenWNote spenWNote3;
                                    StringBuilder sb;
                                    String string = "externalSnapDownload, onCompleted, ";
                                    try {
                                        try {
                                            DocumentFileManager.getInstance().saveAsDirectory(spenWNote2, ExternalSnapDownloadTask.this.mTempFilePath);
                                            externalSnapDownloadTask = ExternalSnapDownloadTask.this;
                                            str2 = externalSnapDownloadTask.mTempFilePath;
                                            spenWNote3 = spenWNote2;
                                            sb = new StringBuilder("externalSnapDownload, onCompleted, ");
                                        } catch (IOException e) {
                                            CoeditLogger.m8920e(ExternalSnapDownloadTask.TAG, "[CS7-2] externalSnapDownload, run, onCompleted() : fail to save doc, e : " + e.getMessage());
                                            externalSnapDownloadTask = ExternalSnapDownloadTask.this;
                                            str2 = externalSnapDownloadTask.mTempFilePath;
                                            spenWNote3 = spenWNote2;
                                            sb = new StringBuilder("externalSnapDownload, onCompleted, ");
                                        }
                                        sb.append(str);
                                        string = sb.toString();
                                        externalSnapDownloadTask.closeDoc(str2, spenWNote3, string);
                                        C90791.this.callback.onCompleted();
                                    } catch (Throwable th) {
                                        ExternalSnapDownloadTask externalSnapDownloadTask2 = ExternalSnapDownloadTask.this;
                                        externalSnapDownloadTask2.closeDoc(externalSnapDownloadTask2.mTempFilePath, spenWNote2, string + str);
                                        throw th;
                                    }
                                }
                            });
                            this.contract = null;
                        }
                    }

                    @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.ExternalControlCallback
                    public void onError(final SpenWNote spenWNote2, final String str) {
                        CoeditLogger.m8920e(ExternalSnapDownloadTask.TAG, "[CS7-2] externalSnapDownload, run, onError() : Failed to download note, " + str);
                        ExternalBaseTask.Contract contract = this.contract;
                        if (contract != null) {
                            contract.releaseHandler(ExternalSnapDownloadTask.this.mUuid, "externalSnapDownload-onError", new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.service.task.ExternalSnapDownloadTask.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ExternalSnapDownloadTask externalSnapDownloadTask = ExternalSnapDownloadTask.this;
                                    externalSnapDownloadTask.closeDoc(externalSnapDownloadTask.mTempFilePath, spenWNote2, "externalSnapDownload, onError, " + str);
                                    C90791 c90791 = C90791.this;
                                    c90791.callback.onError(ExternalSnapDownloadTask.this.getSnapResult(str));
                                }
                            });
                            this.contract = null;
                        }
                    }
                });
            } catch (IOException e) {
                CoeditLogger.m8920e(TAG, "[CS7-2] externalSnapDownload, run() : saveAsDirectory Failed, " + e.getMessage());
                closeDoc(this.mTempFilePath, spenWNote, "externalSnapDownload, saveAsDirectory Failed");
                this.mCallback.onError(201);
            }
        } catch (IOException e2) {
            CoeditLogger.m8920e(TAG, "[CS7-2] externalSnapDownload, run() : createSpenNoteForDownload Failed, " + e2.getMessage());
            this.mCallback.onError(201);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.service.task.ExternalBaseTask
    public String getTag() {
        return TAG;
    }
}
