package com.samsung.android.support.senl.p148nt.coedit.service.task;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenUnsupportedTypeException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedVersionException;
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
public class ExternalSnapUploadTask extends ExternalBaseTask {
    private static final String TAG = "ExternalSnapUploadTask";
    private final String mFilePath;
    private final String mSpaceId;

    public ExternalSnapUploadTask(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, @NonNull ExternalBaseTask.UpDownloadCallback upDownloadCallback) {
        super(context, str2, str3, str4, upDownloadCallback);
        this.mFilePath = str;
        this.mSpaceId = str5;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.service.task.ExternalBaseTask
    public void execute() {
        CoeditLogger.m8919d(TAG, "[CS7] externalSnapUpload() - runnable");
        if (CoeditHandlerManager.getInstance().isCoeditRunning(this.mUuid) || AbstractC0291i.m569f(this.mUuid)) {
            CoeditLogger.m8920e(TAG, "externalSnapUpload, already exists, uuid: " + this.mUuid);
            this.mCallback.onError(201);
            return;
        }
        try {
            CoeditHandlerManager.getInstance().externalSnapUpload(DocumentFileManager.getInstance().open(this.mContext, this.mFilePath, 2160, 8000, true, false, true), this.mUuid, this.mFilePath, this.mGroupId, this.mWorkspaceId, new ExternalBaseTask.ExternalBaseCallback(this.mCallback, this.mContract) { // from class: com.samsung.android.support.senl.nt.coedit.service.task.ExternalSnapUploadTask.1
                @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.ExternalControlCallback
                public void onCompleted(final SpenWNote spenWNote, final String str) {
                    AbstractC8014b.m7219u("[CS5-1] onCompleted. Success to upload note. ", str, ExternalSnapUploadTask.TAG);
                    ExternalBaseTask.Contract contract = this.contract;
                    if (contract != null) {
                        contract.releaseHandler(ExternalSnapUploadTask.this.mUuid, "externalSnapUpload-onComplete", new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.service.task.ExternalSnapUploadTask.1.2
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.lang.Runnable
                            public void run() {
                                String str2 = "externalSnapUpload, onCompleted, ";
                                try {
                                    try {
                                        DocumentFileManager.getInstance().saveAsDirectory(spenWNote, ExternalSnapUploadTask.this.mFilePath);
                                        ExternalSnapUploadTask externalSnapUploadTask = ExternalSnapUploadTask.this;
                                        SnapUploadTask.onSnapUploadCompleted(externalSnapUploadTask.mContext, externalSnapUploadTask.mUuid, str, externalSnapUploadTask.mSpaceId, new Handler(Looper.getMainLooper()));
                                        ExternalSnapUploadTask externalSnapUploadTask2 = ExternalSnapUploadTask.this;
                                        externalSnapUploadTask2.closeDoc(externalSnapUploadTask2.mFilePath, spenWNote, "externalSnapUpload, onCompleted, " + str);
                                        ExternalBaseTask.UpDownloadCallback upDownloadCallback = C90811.this.callback;
                                        str2 = upDownloadCallback;
                                        if (upDownloadCallback != null) {
                                            upDownloadCallback.onCompleted();
                                        }
                                    } catch (IOException e) {
                                        CoeditLogger.m8920e(ExternalSnapUploadTask.TAG, "externalSnapUpload, saveAsDirectory Failed, " + e.getMessage());
                                        ExternalSnapUploadTask externalSnapUploadTask3 = ExternalSnapUploadTask.this;
                                        SnapUploadTask.onSnapUploadCompleted(externalSnapUploadTask3.mContext, externalSnapUploadTask3.mUuid, str, externalSnapUploadTask3.mSpaceId, new Handler(Looper.getMainLooper()));
                                        ExternalSnapUploadTask externalSnapUploadTask4 = ExternalSnapUploadTask.this;
                                        externalSnapUploadTask4.closeDoc(externalSnapUploadTask4.mFilePath, spenWNote, "externalSnapUpload, onCompleted, " + str);
                                        ExternalBaseTask.UpDownloadCallback upDownloadCallback2 = C90811.this.callback;
                                        str2 = upDownloadCallback2;
                                        if (upDownloadCallback2 != null) {
                                            upDownloadCallback2.onCompleted();
                                            str2 = upDownloadCallback2;
                                        }
                                    }
                                } catch (Throwable th) {
                                    ExternalSnapUploadTask externalSnapUploadTask5 = ExternalSnapUploadTask.this;
                                    SnapUploadTask.onSnapUploadCompleted(externalSnapUploadTask5.mContext, externalSnapUploadTask5.mUuid, str, externalSnapUploadTask5.mSpaceId, new Handler(Looper.getMainLooper()));
                                    ExternalSnapUploadTask externalSnapUploadTask6 = ExternalSnapUploadTask.this;
                                    externalSnapUploadTask6.closeDoc(externalSnapUploadTask6.mFilePath, spenWNote, str2 + str);
                                    ExternalBaseTask.UpDownloadCallback upDownloadCallback3 = C90811.this.callback;
                                    if (upDownloadCallback3 != null) {
                                        upDownloadCallback3.onCompleted();
                                    }
                                    throw th;
                                }
                            }
                        });
                        this.contract = null;
                    }
                }

                @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.ExternalControlCallback
                public void onError(final SpenWNote spenWNote, final String str) {
                    CoeditLogger.m8920e(ExternalSnapUploadTask.TAG, "[CS5-2] externalSnapUpload. Failed to upload note. " + str);
                    ExternalBaseTask.Contract contract = this.contract;
                    if (contract != null) {
                        contract.releaseHandler(ExternalSnapUploadTask.this.mUuid, "externalSnapUpload-onError", new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.service.task.ExternalSnapUploadTask.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ExternalSnapUploadTask externalSnapUploadTask = ExternalSnapUploadTask.this;
                                externalSnapUploadTask.closeDoc(externalSnapUploadTask.mFilePath, spenWNote, "externalSnapUpload, onError, " + str);
                                C90811 c90811 = C90811.this;
                                c90811.callback.onError(ExternalSnapUploadTask.this.getSnapResult(str));
                            }
                        });
                        this.contract = null;
                    }
                }
            });
        } catch (SpenUnsupportedTypeException | SpenUnsupportedVersionException | IOException e) {
            AbstractC8014b.m7218t(e, new StringBuilder("externalSnapUpload, createSpenNoteForUpload Failed, "), TAG);
            this.mCallback.onError(201);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.service.task.ExternalBaseTask
    public String getTag() {
        return TAG;
    }
}
