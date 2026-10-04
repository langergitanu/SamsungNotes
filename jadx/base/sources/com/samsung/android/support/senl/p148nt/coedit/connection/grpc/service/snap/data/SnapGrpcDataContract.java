package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.data;

import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpFileData;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface SnapGrpcDataContract {
    void downloadContentFile(String str);

    void handleDownloadUrlMap(Map<String, String> map);

    void onContentFileUploadError(int i);

    void updateSnapNoteLatestInfo(long j, long j2, String str);

    void uploadContentFileData(NoteOpFileData noteOpFileData, String str, String str2);
}
