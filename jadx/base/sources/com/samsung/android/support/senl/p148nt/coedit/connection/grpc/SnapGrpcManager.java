package com.samsung.android.support.senl.p148nt.coedit.connection.grpc;

import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpFileData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.SnapGrpcClient;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.data.SnapGrpcDataContract;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import io.grpc.Status;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SnapGrpcManager {
    private static final String TAG = "SnapGrpcManager";
    private SnapGrpcClient mSnapClient;

    public void createChannel(String str, String str2, String str3, String str4, String str5, String str6, String str7, GrpcRunnable.Contract contract, SnapGrpcDataContract snapGrpcDataContract) {
        this.mSnapClient = new SnapGrpcClient(str, "443", str2, str3, str4, str5, str6, str7, snapGrpcDataContract, contract);
    }

    public int getDownloadXmlDataSize() {
        SnapGrpcClient snapGrpcClient = this.mSnapClient;
        if (snapGrpcClient == null) {
            return -1;
        }
        return snapGrpcClient.getSnapData().getDownloadXmlDataSize();
    }

    public byte[] getSnapDataDownloadStroke(String str) {
        SnapGrpcClient snapGrpcClient = this.mSnapClient;
        return snapGrpcClient == null ? new byte[0] : snapGrpcClient.getSnapData().getDownloadStroke(str);
    }

    public Set<String> getSnapDataDownloadStrokeMapKeySet() {
        SnapGrpcClient snapGrpcClient = this.mSnapClient;
        return snapGrpcClient == null ? new HashSet() : snapGrpcClient.getSnapData().getDownloadStrokeMapKeySet();
    }

    public String getSnapDataDownloadXmlData() {
        SnapGrpcClient snapGrpcClient = this.mSnapClient;
        return snapGrpcClient == null ? "" : snapGrpcClient.getSnapData().getDownloadXmlData();
    }

    public String getSnapDataResourceId() {
        SnapGrpcClient snapGrpcClient = this.mSnapClient;
        return snapGrpcClient == null ? "" : snapGrpcClient.getSnapData().getResourceId();
    }

    public boolean isChannelConnected() {
        return this.mSnapClient != null;
    }

    public boolean isSnapDataResultOk() {
        SnapGrpcClient snapGrpcClient = this.mSnapClient;
        return snapGrpcClient != null && snapGrpcClient.getSnapData().getResultCode() == Status.Code.OK.value();
    }

    public void putSnapDataUploadStrokeRequest(String str, String str2, byte[] bArr, long j) throws InterruptedException {
        SnapGrpcClient snapGrpcClient = this.mSnapClient;
        if (snapGrpcClient == null) {
            return;
        }
        snapGrpcClient.getSnapData().putUploadStrokeRequest(str, str2, bArr, j);
    }

    public void putUploadNoteRequest(String str, String str2, int i) throws InterruptedException, IOException {
        SnapGrpcClient snapGrpcClient = this.mSnapClient;
        if (snapGrpcClient == null) {
            return;
        }
        snapGrpcClient.getSnapData().putUploadNoteRequest(str, str2, i);
    }

    public void release() {
        SnapGrpcClient snapGrpcClient = this.mSnapClient;
        if (snapGrpcClient != null) {
            snapGrpcClient.release();
            this.mSnapClient = null;
        }
    }

    public void removeUndownloadedObjectInfo(String str, boolean z) {
        this.mSnapClient.getSnapData().removeUndownloadedObjectInfo(str, z);
    }

    public boolean removeUnuploadedContentFileData(String str) {
        return this.mSnapClient.getSnapData().removeUnuploadedContentFileData(str);
    }

    public void requestSnap(String str, int i) {
        SnapGrpcClient snapGrpcClient = this.mSnapClient;
        if (snapGrpcClient != null) {
            snapGrpcClient.request(str, i);
            return;
        }
        CoeditLogger.m8924w(TAG, "requestSnap, skip, SnapClient is invalid, message : " + str + ", method : " + i);
    }

    public boolean snapDataRequestUploadFileData(List<NoteOpFileData> list) {
        if (list.isEmpty()) {
            return false;
        }
        for (NoteOpFileData noteOpFileData : list) {
            snapDataRequestUploadObjects(noteOpFileData);
            requestSnap("GetObjectUploadUrl for Snap: " + noteOpFileData.getId(), 101);
        }
        return isChannelConnected();
    }

    public void snapDataRequestUploadObjects(NoteOpFileData noteOpFileData) {
        SnapGrpcClient snapGrpcClient = this.mSnapClient;
        if (snapGrpcClient == null) {
            return;
        }
        snapGrpcClient.getSnapData().addUploadContentFileData(noteOpFileData);
    }
}
