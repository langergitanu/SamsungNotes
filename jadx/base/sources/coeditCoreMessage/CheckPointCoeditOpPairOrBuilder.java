package coeditCoreMessage;

import coeditOperation.CoeditOperation;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface CheckPointCoeditOpPairOrBuilder extends MessageLiteOrBuilder {
    long getCheckpoint();

    CoeditOperation getCoeditOperation(int i);

    int getCoeditOperationCount();

    List<CoeditOperation> getCoeditOperationList();

    DeviceInfo getDeviceInfo();

    String getExtraData();

    ByteString getExtraDataBytes();

    ObjectInfo getObjectInfo(int i);

    int getObjectInfoCount();

    List<ObjectInfo> getObjectInfoList();

    boolean hasDeviceInfo();
}
