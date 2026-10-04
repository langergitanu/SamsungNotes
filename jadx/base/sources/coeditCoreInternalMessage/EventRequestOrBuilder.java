package coeditCoreInternalMessage;

import coeditCoreMessage.EventType;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public interface EventRequestOrBuilder extends MessageLiteOrBuilder {
    EventType getEventType();

    int getEventTypeValue();

    String getTargetUid();

    ByteString getTargetUidBytes();

    boolean getWritable();
}
