package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import coeditCoreMessage.BinaryInfo;
import coeditCoreMessage.ObjectInfo;
import coeditObjectMessage.SignedDownloadUrlRequest;
import coeditObjectMessage.SignedDownloadUrlResponse;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionLogger;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class GetSignedDownloadUrlRunnable extends GrpcRunnable {
    private static final String TAG = "GetSignedDownloadUrlRunnable";
    private final CoeditGrpcData mData;

    public GetSignedDownloadUrlRunnable(@NonNull CoeditGrpcData coeditGrpcData, GrpcRunnable.Contract contract) {
        super(contract);
        this.mData = coeditGrpcData;
    }

    private void printRequest(SignedDownloadUrlRequest signedDownloadUrlRequest) {
        CoeditLogger.m8923i(getTag(), "Request# objectId: [" + signedDownloadUrlRequest.getObjId() + "]");
    }

    private void printResponse(SignedDownloadUrlResponse signedDownloadUrlResponse) {
        StringBuilder sb = new StringBuilder("Response# signedDownloadUrl: [");
        sb.append(signedDownloadUrlResponse.getDownloadSignedUrl());
        sb.append("]");
        if (signedDownloadUrlResponse.hasResponseResult()) {
            sb.append(SQLKeyword.COMMA);
            sb.append(OtDetectionLogger.getResponseResultLog(signedDownloadUrlResponse.getResponseResult()));
        }
        CoeditLogger.m8923i(getTag(), sb.toString());
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionListener
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, java.lang.Runnable
    public void run() {
        super.run();
        if (this.mData.isDownloadContentFileObjectInfoExist()) {
            try {
                ObjectInfo objectInfoTakeDownloadContentFileObjectInfo = this.mData.takeDownloadContentFileObjectInfo();
                String objId = objectInfoTakeDownloadContentFileObjectInfo.getObjId();
                String downloadSignedUrl = objectInfoTakeDownloadContentFileObjectInfo.getDownloadSignedUrl();
                CoeditLogger.m8923i(getTag(), "run# objectId: [" + objId + "], downloadSignedUrl: [" + CoeditLogger.getEncode(downloadSignedUrl) + "]");
                if (TextUtils.isEmpty(downloadSignedUrl)) {
                    SignedDownloadUrlRequest signedDownloadUrlRequestBuild = SignedDownloadUrlRequest.newBuilder().setObjId(objId).build();
                    printRequest(signedDownloadUrlRequestBuild);
                    SignedDownloadUrlResponse signedDownloadUrl = this.mData.getSignedDownloadUrl(signedDownloadUrlRequestBuild);
                    printResponse(signedDownloadUrl);
                    objectInfoTakeDownloadContentFileObjectInfo = ObjectInfo.newBuilder(objectInfoTakeDownloadContentFileObjectInfo).setDownloadSignedUrl(signedDownloadUrl.getDownloadSignedUrl()).setBinaryInfo(BinaryInfo.newBuilder().setHash(signedDownloadUrl.getBinaryInfo().getHash()).setMimetype(signedDownloadUrl.getBinaryInfo().getMimetype()).build()).build();
                }
                this.mData.downloadContentFileObjectInfos(objectInfoTakeDownloadContentFileObjectInfo);
            } catch (Exception e) {
                CoeditLogger.m8920e(TAG, "Failed to getSignedDownloadUrl. " + e.getMessage());
                showToast("getSignedDownloadUrl error. " + e.getMessage());
            }
        }
    }
}
