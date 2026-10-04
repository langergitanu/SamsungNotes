package com.samsung.android.support.senl.p148nt.coedit.service.task;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
public class ExternalSnapStartTask extends ExternalBaseTask {
    private static final String TAG = "ExternalSnapStartTask";
    private final String mOriginFilePath;
    private final String mTempFilePath;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.coedit.service.task.ExternalSnapStartTask$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C90801 extends ExternalBaseTask.ExternalBaseCallback {
        public C90801(ExternalBaseTask.UpDownloadCallback upDownloadCallback, ExternalBaseTask.Contract contract) {
            super(upDownloadCallback, contract);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.ExternalControlCallback
        public void onCompleted(SpenWNote spenWNote, String str) {
            CoeditLogger.m8919d(ExternalSnapStartTask.TAG, "externalSnapStart, onCompleted. call sync method, " + str);
            CoeditHandlerManager coeditHandlerManager = CoeditHandlerManager.getInstance();
            ExternalSnapStartTask externalSnapStartTask = ExternalSnapStartTask.this;
            coeditHandlerManager.externalChannelOpen(spenWNote, externalSnapStartTask.mUuid, externalSnapStartTask.mGroupId, externalSnapStartTask.mWorkspaceId, new ExternalBaseTask.ExternalBaseCallback(this.callback, this.contract) { // from class: com.samsung.android.support.senl.nt.coedit.service.task.ExternalSnapStartTask.1.2
                @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.ExternalControlCallback
                public void onCompleted(final SpenWNote spenWNote2, final String str2) {
                    ExternalBaseTask.Contract contract = this.contract;
                    if (contract != null) {
                        contract.releaseHandler(ExternalSnapStartTask.this.mUuid, "externalSnapStart-onComplete", new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.service.task.ExternalSnapStartTask.1.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    try {
                                        DocumentFileManager.getInstance().saveAsDirectory(spenWNote2, ExternalSnapStartTask.this.mTempFilePath);
                                    } catch (IOException e) {
                                        CoeditLogger.m8920e(ExternalSnapStartTask.TAG, "externalSnapStart, sync, saveAsDirectory Failed, " + e.getMessage());
                                        ExternalSnapStartTask externalSnapStartTask2 = ExternalSnapStartTask.this;
                                        externalSnapStartTask2.closeDoc(externalSnapStartTask2.mOriginFilePath, spenWNote2, "externalSnapStart, sync, onCompleted, " + str2);
                                        ExternalBaseTask.UpDownloadCallback upDownloadCallback = AnonymousClass2.this.callback;
                                        if (upDownloadCallback != null) {
                                            upDownloadCallback.onError(206);
                                        }
                                    }
                                } finally {
                                    ExternalSnapStartTask externalSnapStartTask3 = ExternalSnapStartTask.this;
                                    externalSnapStartTask3.closeDoc(externalSnapStartTask3.mOriginFilePath, spenWNote2, "externalSnapStart, sync, onCompleted, " + str2);
                                    ExternalBaseTask.UpDownloadCallback upDownloadCallback2 = AnonymousClass2.this.callback;
                                    if (upDownloadCallback2 != null) {
                                        upDownloadCallback2.onCompleted();
                                    }
                                }
                            }
                        });
                        this.contract = null;
                    }
                }

                @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.ExternalControlCallback
                public void onError(final SpenWNote spenWNote2, final String str2) {
                    CoeditLogger.m8920e(ExternalSnapStartTask.TAG, "externalSnapStart, onError. Failed to sync note. " + str2);
                    ExternalBaseTask.Contract contract = this.contract;
                    if (contract != null) {
                        contract.releaseHandler(ExternalSnapStartTask.this.mUuid, "externalSnapStart-onError", new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.service.task.ExternalSnapStartTask.1.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ExternalSnapStartTask externalSnapStartTask2 = ExternalSnapStartTask.this;
                                externalSnapStartTask2.closeDoc(externalSnapStartTask2.mOriginFilePath, spenWNote2, "externalSnapStart, sync, onError, " + str2);
                                AnonymousClass2.this.callback.onError(202);
                            }
                        });
                        this.contract = null;
                    }
                }
            });
            this.contract = null;
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.ExternalControlCallback
        public void onError(final SpenWNote spenWNote, final String str) {
            CoeditLogger.m8920e(ExternalSnapStartTask.TAG, "externalSnapStart, snapSync, onError. Failed to snapSync note. " + str);
            ExternalBaseTask.Contract contract = this.contract;
            if (contract != null) {
                contract.releaseHandler(ExternalSnapStartTask.this.mUuid, "externalSnapStart, snapSync-onError", new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.service.task.ExternalSnapStartTask.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ExternalSnapStartTask externalSnapStartTask = ExternalSnapStartTask.this;
                        externalSnapStartTask.closeDoc(externalSnapStartTask.mOriginFilePath, spenWNote, "externalSnapStart, snapSync, onError, " + str);
                        C90801 c90801 = C90801.this;
                        c90801.callback.onError(ExternalSnapStartTask.this.getSnapResult(str));
                    }
                });
                this.contract = null;
            }
        }
    }

    public ExternalSnapStartTask(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, @NonNull ExternalBaseTask.UpDownloadCallback upDownloadCallback) {
        super(context, str3, str4, str5, upDownloadCallback);
        this.mOriginFilePath = str;
        this.mTempFilePath = str2;
    }

    @Nullable
    private SpenWNote externalSnapStartInitialize() {
        if (!TextUtils.isEmpty(this.mGroupId) && !CoeditHandlerManager.getInstance().isCoeditRunning(this.mUuid) && !AbstractC0291i.m569f(this.mUuid)) {
            try {
                return DocumentFileManager.getInstance().open(this.mContext, this.mOriginFilePath, 2160, 8000, true, false, true);
            } catch (SpenUnsupportedTypeException | SpenUnsupportedVersionException | IOException | RuntimeException e) {
                AbstractC8014b.m7218t(e, new StringBuilder("externalSnapStart, createSpenNoteForSync Failed, "), TAG);
            }
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.service.task.ExternalBaseTask
    public void execute() {
        SpenWNote spenWNoteExternalSnapStartInitialize = externalSnapStartInitialize();
        if (spenWNoteExternalSnapStartInitialize == null) {
            this.mCallback.onError(201);
        } else {
            CoeditHandlerManager.getInstance().externalSnapStart(spenWNoteExternalSnapStartInitialize, this.mUuid, this.mOriginFilePath, this.mGroupId, this.mWorkspaceId, new C90801(this.mCallback, this.mContract));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.service.task.ExternalBaseTask
    public String getTag() {
        return TAG;
    }
}
