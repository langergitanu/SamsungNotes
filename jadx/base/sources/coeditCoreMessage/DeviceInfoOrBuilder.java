package coeditCoreMessage;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface DeviceInfoOrBuilder extends MessageLiteOrBuilder {
    DeviceInfoChangeType getDeviceInfoChangeType();

    int getDeviceInfoChangeTypeValue();

    String getDvcId();

    ByteString getDvcIdBytes();

    PermissionType getPermissionType();

    int getPermissionTypeValue();

    String getUid();

    ByteString getUidBytes();
}
