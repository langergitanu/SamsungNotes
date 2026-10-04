package coeditCoreMessage;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface ServerMsgOrBuilder extends MessageLiteOrBuilder {
    String getChannelId();

    ByteString getChannelIdBytes();

    CheckPointCoeditOpPair getCheckpointCoeditopPair();

    long getConnectedDeviceCnt();

    DeviceInfo getDeviceInfo(int i);

    int getDeviceInfoCount();

    List<DeviceInfo> getDeviceInfoList();

    String getDvcId();

    ByteString getDvcIdBytes();

    EventInfo getEventInfo();

    PolicyInfo getPolicyInfo();

    ResponseResult getResponseResult();

    ServerCmd getServerCmd();

    int getServerCmdValue();

    long getSessionValidTime();

    boolean getWorkspaceBlocked();

    long getWorkspaceVersion();

    boolean hasCheckpointCoeditopPair();

    boolean hasEventInfo();

    boolean hasPolicyInfo();

    boolean hasResponseResult();
}
