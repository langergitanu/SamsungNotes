package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method;

import androidx.annotation.NonNull;
import coeditObjectMessage.BinaryInfo;
import coeditObjectMessage.ObjUploadUrlRequest;
import coeditObjectMessage.ObjUploadUrlResponse;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpFileData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionLogger;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class GetObjectUploadUrlRunnable extends GrpcRunnable {
    private static final String TAG = "GetObjectUploadUrlRunnable";
    private final CoeditGrpcData mData;
    private NoteOpFileData mFileData;
    private ObjUploadUrlResponse mResponse;

    public GetObjectUploadUrlRunnable(@NonNull CoeditGrpcData coeditGrpcData, GrpcRunnable.Contract contract) {
        super(contract);
        this.mFileData = null;
        this.mResponse = null;
        this.mData = coeditGrpcData;
    }

    private void getObjectUploadUrl() {
        if (this.mData.isUploadContentFileDataExist()) {
            try {
                this.mFileData = this.mData.takeUploadContentFileData();
                ObjUploadUrlRequest objUploadUrlRequestBuild = ObjUploadUrlRequest.newBuilder().setBinaryInfo(BinaryInfo.newBuilder().setHash(this.mFileData.getHash()).setSize(this.mFileData.getBinarySize()).setMimetype(this.mFileData.getMimeType()).build()).build();
                printRequest(objUploadUrlRequestBuild);
                ObjUploadUrlResponse objUploadUrl = this.mData.getObjUploadUrl(objUploadUrlRequestBuild);
                this.mResponse = objUploadUrl;
                if (objUploadUrl != null) {
                    printResponse(objUploadUrl);
                    this.mData.uploadContentFileData(this.mFileData, this.mResponse.getObjId(), this.mResponse.getUploadSignedUrl());
                }
            } catch (InterruptedException e) {
                CoeditLogger.m8920e(TAG, "Failed to getObjectUploadUrl. " + e.getMessage());
                showToast("getObjectUploadUrl error. " + e.getMessage());
                retryRunnable();
            }
        }
    }

    private void printRequest(ObjUploadUrlRequest objUploadUrlRequest) {
        CoeditLogger.m8923i(getTag(), "Request#  hash: [" + objUploadUrlRequest.getBinaryInfo().getHash() + "], mimeType: [" + objUploadUrlRequest.getBinaryInfo().getMimetype() + "], size: [" + objUploadUrlRequest.getBinaryInfo().getSize() + "]");
    }

    private void printResponse(ObjUploadUrlResponse objUploadUrlResponse) {
        StringBuilder sb = new StringBuilder("Response# objectId: [");
        sb.append(objUploadUrlResponse.getObjId());
        sb.append("], uploadSignedUrl: [");
        sb.append(objUploadUrlResponse.getUploadSignedUrl());
        sb.append("]");
        if (objUploadUrlResponse.hasResponseResult()) {
            sb.append(SQLKeyword.COMMA);
            sb.append(OtDetectionLogger.getResponseResultLog(objUploadUrlResponse.getResponseResult()));
        }
        CoeditLogger.m8923i(getTag(), sb.toString());
    }

    private void retryRunnable() {
        if (5 <= getRetryCount() || this.mFileData == null || this.mResponse != null) {
            this.mData.onContentFileUploadError(-1);
            return;
        }
        increaseRetryCount();
        CoeditLogger.m8919d(TAG, "Retry submit. " + getRetryCount() + "fileData :  " + this.mFileData);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            CoeditLogger.m8920e(TAG, "retryRunnable, e: " + e.getMessage());
        }
        getObjectUploadUrl();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionListener
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, java.lang.Runnable
    public void run() {
        super.run();
        getObjectUploadUrl();
    }
}
