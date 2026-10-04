package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data;

import coeditCoreMessage.ObjectInfo;
import coeditCoreMessage.ServerMsg;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpFileData;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface CoeditGrpcDataContract {
    void downloadContentFile(ObjectInfo objectInfo);

    String getWorkspaceId();

    boolean isConcurrencyPausedByNetwork();

    void notify(ServerMsg serverMsg);

    void reconnect(String str);

    void releaseLock(String str);

    void setPausedByNetwork(String str);

    void uploadContentFile(NoteOpFileData noteOpFileData, String str, String str2);

    void wakeConcurrencyPool();
}
