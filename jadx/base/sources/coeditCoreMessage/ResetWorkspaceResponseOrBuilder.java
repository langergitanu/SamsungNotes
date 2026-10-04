package coeditCoreMessage;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface ResetWorkspaceResponseOrBuilder extends MessageLiteOrBuilder {
    boolean getIsBlocked();

    long getLatestSnapshotCheckpoint();

    ResponseResult getResponseResult();

    String getWorkspaceId();

    ByteString getWorkspaceIdBytes();

    long getWorkspaceVersion();

    boolean hasResponseResult();
}
