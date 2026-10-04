package coeditCoreMessage;

import coeditCoreMessage.CheckPointCoeditOpPair;
import coeditCoreMessage.DeviceInfo;
import coeditCoreMessage.EventInfo;
import coeditCoreMessage.PolicyInfo;
import coeditCoreMessage.ResponseResult;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class ServerMsg extends GeneratedMessageLite<ServerMsg, Builder> implements ServerMsgOrBuilder {
    public static final int CHANNEL_ID_FIELD_NUMBER = 2;
    public static final int CHECKPOINT_COEDITOP_PAIR_FIELD_NUMBER = 4;
    public static final int CONNECTED_DEVICE_CNT_FIELD_NUMBER = 8;
    private static final ServerMsg DEFAULT_INSTANCE;
    public static final int DEVICE_INFO_FIELD_NUMBER = 7;
    public static final int DVC_ID_FIELD_NUMBER = 12;
    public static final int EVENT_INFO_FIELD_NUMBER = 6;
    private static volatile Parser<ServerMsg> PARSER = null;
    public static final int POLICY_INFO_FIELD_NUMBER = 11;
    public static final int RESPONSE_RESULT_FIELD_NUMBER = 1;
    public static final int SERVER_CMD_FIELD_NUMBER = 3;
    public static final int SESSION_VALID_TIME_FIELD_NUMBER = 5;
    public static final int WORKSPACE_BLOCKED_FIELD_NUMBER = 9;
    public static final int WORKSPACE_VERSION_FIELD_NUMBER = 10;
    private CheckPointCoeditOpPair checkpointCoeditopPair_;
    private long connectedDeviceCnt_;
    private EventInfo eventInfo_;
    private PolicyInfo policyInfo_;
    private ResponseResult responseResult_;
    private int serverCmd_;
    private long sessionValidTime_;
    private boolean workspaceBlocked_;
    private long workspaceVersion_;
    private String channelId_ = "";
    private Internal.ProtobufList<DeviceInfo> deviceInfo_ = GeneratedMessageLite.emptyProtobufList();
    private String dvcId_ = "";

    /* JADX INFO: renamed from: coeditCoreMessage.ServerMsg$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42521 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1876xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1876xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1876xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1876xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1876xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1876xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1876xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1876xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<ServerMsg, Builder> implements ServerMsgOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder addAllDeviceInfo(Iterable<? extends DeviceInfo> iterable) {
            copyOnWrite();
            ((ServerMsg) this.instance).addAllDeviceInfo(iterable);
            return this;
        }

        public Builder addDeviceInfo(DeviceInfo deviceInfo) {
            copyOnWrite();
            ((ServerMsg) this.instance).addDeviceInfo(deviceInfo);
            return this;
        }

        public Builder clearChannelId() {
            copyOnWrite();
            ((ServerMsg) this.instance).clearChannelId();
            return this;
        }

        public Builder clearCheckpointCoeditopPair() {
            copyOnWrite();
            ((ServerMsg) this.instance).clearCheckpointCoeditopPair();
            return this;
        }

        public Builder clearConnectedDeviceCnt() {
            copyOnWrite();
            ((ServerMsg) this.instance).clearConnectedDeviceCnt();
            return this;
        }

        public Builder clearDeviceInfo() {
            copyOnWrite();
            ((ServerMsg) this.instance).clearDeviceInfo();
            return this;
        }

        public Builder clearDvcId() {
            copyOnWrite();
            ((ServerMsg) this.instance).clearDvcId();
            return this;
        }

        public Builder clearEventInfo() {
            copyOnWrite();
            ((ServerMsg) this.instance).clearEventInfo();
            return this;
        }

        public Builder clearPolicyInfo() {
            copyOnWrite();
            ((ServerMsg) this.instance).clearPolicyInfo();
            return this;
        }

        public Builder clearResponseResult() {
            copyOnWrite();
            ((ServerMsg) this.instance).clearResponseResult();
            return this;
        }

        public Builder clearServerCmd() {
            copyOnWrite();
            ((ServerMsg) this.instance).clearServerCmd();
            return this;
        }

        public Builder clearSessionValidTime() {
            copyOnWrite();
            ((ServerMsg) this.instance).clearSessionValidTime();
            return this;
        }

        public Builder clearWorkspaceBlocked() {
            copyOnWrite();
            ((ServerMsg) this.instance).clearWorkspaceBlocked();
            return this;
        }

        public Builder clearWorkspaceVersion() {
            copyOnWrite();
            ((ServerMsg) this.instance).clearWorkspaceVersion();
            return this;
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public String getChannelId() {
            return ((ServerMsg) this.instance).getChannelId();
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public ByteString getChannelIdBytes() {
            return ((ServerMsg) this.instance).getChannelIdBytes();
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public CheckPointCoeditOpPair getCheckpointCoeditopPair() {
            return ((ServerMsg) this.instance).getCheckpointCoeditopPair();
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public long getConnectedDeviceCnt() {
            return ((ServerMsg) this.instance).getConnectedDeviceCnt();
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public DeviceInfo getDeviceInfo(int i) {
            return ((ServerMsg) this.instance).getDeviceInfo(i);
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public int getDeviceInfoCount() {
            return ((ServerMsg) this.instance).getDeviceInfoCount();
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public List<DeviceInfo> getDeviceInfoList() {
            return Collections.unmodifiableList(((ServerMsg) this.instance).getDeviceInfoList());
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public String getDvcId() {
            return ((ServerMsg) this.instance).getDvcId();
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public ByteString getDvcIdBytes() {
            return ((ServerMsg) this.instance).getDvcIdBytes();
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public EventInfo getEventInfo() {
            return ((ServerMsg) this.instance).getEventInfo();
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public PolicyInfo getPolicyInfo() {
            return ((ServerMsg) this.instance).getPolicyInfo();
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public ResponseResult getResponseResult() {
            return ((ServerMsg) this.instance).getResponseResult();
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public ServerCmd getServerCmd() {
            return ((ServerMsg) this.instance).getServerCmd();
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public int getServerCmdValue() {
            return ((ServerMsg) this.instance).getServerCmdValue();
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public long getSessionValidTime() {
            return ((ServerMsg) this.instance).getSessionValidTime();
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public boolean getWorkspaceBlocked() {
            return ((ServerMsg) this.instance).getWorkspaceBlocked();
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public long getWorkspaceVersion() {
            return ((ServerMsg) this.instance).getWorkspaceVersion();
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public boolean hasCheckpointCoeditopPair() {
            return ((ServerMsg) this.instance).hasCheckpointCoeditopPair();
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public boolean hasEventInfo() {
            return ((ServerMsg) this.instance).hasEventInfo();
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public boolean hasPolicyInfo() {
            return ((ServerMsg) this.instance).hasPolicyInfo();
        }

        @Override // coeditCoreMessage.ServerMsgOrBuilder
        public boolean hasResponseResult() {
            return ((ServerMsg) this.instance).hasResponseResult();
        }

        public Builder mergeCheckpointCoeditopPair(CheckPointCoeditOpPair checkPointCoeditOpPair) {
            copyOnWrite();
            ((ServerMsg) this.instance).mergeCheckpointCoeditopPair(checkPointCoeditOpPair);
            return this;
        }

        public Builder mergeEventInfo(EventInfo eventInfo) {
            copyOnWrite();
            ((ServerMsg) this.instance).mergeEventInfo(eventInfo);
            return this;
        }

        public Builder mergePolicyInfo(PolicyInfo policyInfo) {
            copyOnWrite();
            ((ServerMsg) this.instance).mergePolicyInfo(policyInfo);
            return this;
        }

        public Builder mergeResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((ServerMsg) this.instance).mergeResponseResult(responseResult);
            return this;
        }

        public Builder removeDeviceInfo(int i) {
            copyOnWrite();
            ((ServerMsg) this.instance).removeDeviceInfo(i);
            return this;
        }

        public Builder setChannelId(String str) {
            copyOnWrite();
            ((ServerMsg) this.instance).setChannelId(str);
            return this;
        }

        public Builder setChannelIdBytes(ByteString byteString) {
            copyOnWrite();
            ((ServerMsg) this.instance).setChannelIdBytes(byteString);
            return this;
        }

        public Builder setCheckpointCoeditopPair(CheckPointCoeditOpPair checkPointCoeditOpPair) {
            copyOnWrite();
            ((ServerMsg) this.instance).setCheckpointCoeditopPair(checkPointCoeditOpPair);
            return this;
        }

        public Builder setConnectedDeviceCnt(long j) {
            copyOnWrite();
            ((ServerMsg) this.instance).setConnectedDeviceCnt(j);
            return this;
        }

        public Builder setDeviceInfo(int i, DeviceInfo deviceInfo) {
            copyOnWrite();
            ((ServerMsg) this.instance).setDeviceInfo(i, deviceInfo);
            return this;
        }

        public Builder setDvcId(String str) {
            copyOnWrite();
            ((ServerMsg) this.instance).setDvcId(str);
            return this;
        }

        public Builder setDvcIdBytes(ByteString byteString) {
            copyOnWrite();
            ((ServerMsg) this.instance).setDvcIdBytes(byteString);
            return this;
        }

        public Builder setEventInfo(EventInfo eventInfo) {
            copyOnWrite();
            ((ServerMsg) this.instance).setEventInfo(eventInfo);
            return this;
        }

        public Builder setPolicyInfo(PolicyInfo policyInfo) {
            copyOnWrite();
            ((ServerMsg) this.instance).setPolicyInfo(policyInfo);
            return this;
        }

        public Builder setResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((ServerMsg) this.instance).setResponseResult(responseResult);
            return this;
        }

        public Builder setServerCmd(ServerCmd serverCmd) {
            copyOnWrite();
            ((ServerMsg) this.instance).setServerCmd(serverCmd);
            return this;
        }

        public Builder setServerCmdValue(int i) {
            copyOnWrite();
            ((ServerMsg) this.instance).setServerCmdValue(i);
            return this;
        }

        public Builder setSessionValidTime(long j) {
            copyOnWrite();
            ((ServerMsg) this.instance).setSessionValidTime(j);
            return this;
        }

        public Builder setWorkspaceBlocked(boolean z) {
            copyOnWrite();
            ((ServerMsg) this.instance).setWorkspaceBlocked(z);
            return this;
        }

        public Builder setWorkspaceVersion(long j) {
            copyOnWrite();
            ((ServerMsg) this.instance).setWorkspaceVersion(j);
            return this;
        }

        private Builder() {
            super(ServerMsg.DEFAULT_INSTANCE);
        }

        public Builder addDeviceInfo(int i, DeviceInfo deviceInfo) {
            copyOnWrite();
            ((ServerMsg) this.instance).addDeviceInfo(i, deviceInfo);
            return this;
        }

        public Builder setCheckpointCoeditopPair(CheckPointCoeditOpPair.Builder builder) {
            copyOnWrite();
            ((ServerMsg) this.instance).setCheckpointCoeditopPair(builder.build());
            return this;
        }

        public Builder setDeviceInfo(int i, DeviceInfo.Builder builder) {
            copyOnWrite();
            ((ServerMsg) this.instance).setDeviceInfo(i, builder.build());
            return this;
        }

        public Builder setEventInfo(EventInfo.Builder builder) {
            copyOnWrite();
            ((ServerMsg) this.instance).setEventInfo(builder.build());
            return this;
        }

        public Builder setPolicyInfo(PolicyInfo.Builder builder) {
            copyOnWrite();
            ((ServerMsg) this.instance).setPolicyInfo(builder.build());
            return this;
        }

        public Builder setResponseResult(ResponseResult.Builder builder) {
            copyOnWrite();
            ((ServerMsg) this.instance).setResponseResult(builder.build());
            return this;
        }

        public Builder addDeviceInfo(DeviceInfo.Builder builder) {
            copyOnWrite();
            ((ServerMsg) this.instance).addDeviceInfo(builder.build());
            return this;
        }

        public Builder addDeviceInfo(int i, DeviceInfo.Builder builder) {
            copyOnWrite();
            ((ServerMsg) this.instance).addDeviceInfo(i, builder.build());
            return this;
        }
    }

    static {
        ServerMsg serverMsg = new ServerMsg();
        DEFAULT_INSTANCE = serverMsg;
        GeneratedMessageLite.registerDefaultInstance(ServerMsg.class, serverMsg);
    }

    private ServerMsg() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDeviceInfo(Iterable<? extends DeviceInfo> iterable) {
        ensureDeviceInfoIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.deviceInfo_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDeviceInfo(DeviceInfo deviceInfo) {
        deviceInfo.getClass();
        ensureDeviceInfoIsMutable();
        this.deviceInfo_.add(deviceInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChannelId() {
        this.channelId_ = getDefaultInstance().getChannelId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCheckpointCoeditopPair() {
        this.checkpointCoeditopPair_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConnectedDeviceCnt() {
        this.connectedDeviceCnt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeviceInfo() {
        this.deviceInfo_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDvcId() {
        this.dvcId_ = getDefaultInstance().getDvcId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEventInfo() {
        this.eventInfo_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPolicyInfo() {
        this.policyInfo_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseResult() {
        this.responseResult_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServerCmd() {
        this.serverCmd_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionValidTime() {
        this.sessionValidTime_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWorkspaceBlocked() {
        this.workspaceBlocked_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWorkspaceVersion() {
        this.workspaceVersion_ = 0L;
    }

    private void ensureDeviceInfoIsMutable() {
        Internal.ProtobufList<DeviceInfo> protobufList = this.deviceInfo_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.deviceInfo_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static ServerMsg getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCheckpointCoeditopPair(CheckPointCoeditOpPair checkPointCoeditOpPair) {
        checkPointCoeditOpPair.getClass();
        CheckPointCoeditOpPair checkPointCoeditOpPair2 = this.checkpointCoeditopPair_;
        if (checkPointCoeditOpPair2 == null || checkPointCoeditOpPair2 == CheckPointCoeditOpPair.getDefaultInstance()) {
            this.checkpointCoeditopPair_ = checkPointCoeditOpPair;
        } else {
            this.checkpointCoeditopPair_ = CheckPointCoeditOpPair.newBuilder(this.checkpointCoeditopPair_).mergeFrom(checkPointCoeditOpPair).buildPartial();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeEventInfo(EventInfo eventInfo) {
        eventInfo.getClass();
        EventInfo eventInfo2 = this.eventInfo_;
        if (eventInfo2 == null || eventInfo2 == EventInfo.getDefaultInstance()) {
            this.eventInfo_ = eventInfo;
        } else {
            this.eventInfo_ = EventInfo.newBuilder(this.eventInfo_).mergeFrom(eventInfo).buildPartial();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePolicyInfo(PolicyInfo policyInfo) {
        policyInfo.getClass();
        PolicyInfo policyInfo2 = this.policyInfo_;
        if (policyInfo2 == null || policyInfo2 == PolicyInfo.getDefaultInstance()) {
            this.policyInfo_ = policyInfo;
        } else {
            this.policyInfo_ = PolicyInfo.newBuilder(this.policyInfo_).mergeFrom(policyInfo).buildPartial();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeResponseResult(ResponseResult responseResult) {
        responseResult.getClass();
        ResponseResult responseResult2 = this.responseResult_;
        if (responseResult2 == null || responseResult2 == ResponseResult.getDefaultInstance()) {
            this.responseResult_ = responseResult;
        } else {
            this.responseResult_ = ResponseResult.newBuilder(this.responseResult_).mergeFrom(responseResult).buildPartial();
        }
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ServerMsg parseDelimitedFrom(InputStream inputStream) {
        return (ServerMsg) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ServerMsg parseFrom(ByteBuffer byteBuffer) {
        return (ServerMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ServerMsg> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDeviceInfo(int i) {
        ensureDeviceInfoIsMutable();
        this.deviceInfo_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChannelId(String str) {
        str.getClass();
        this.channelId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChannelIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.channelId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckpointCoeditopPair(CheckPointCoeditOpPair checkPointCoeditOpPair) {
        checkPointCoeditOpPair.getClass();
        this.checkpointCoeditopPair_ = checkPointCoeditOpPair;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectedDeviceCnt(long j) {
        this.connectedDeviceCnt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceInfo(int i, DeviceInfo deviceInfo) {
        deviceInfo.getClass();
        ensureDeviceInfoIsMutable();
        this.deviceInfo_.set(i, deviceInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDvcId(String str) {
        str.getClass();
        this.dvcId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDvcIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.dvcId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventInfo(EventInfo eventInfo) {
        eventInfo.getClass();
        this.eventInfo_ = eventInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPolicyInfo(PolicyInfo policyInfo) {
        policyInfo.getClass();
        this.policyInfo_ = policyInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseResult(ResponseResult responseResult) {
        responseResult.getClass();
        this.responseResult_ = responseResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServerCmd(ServerCmd serverCmd) {
        this.serverCmd_ = serverCmd.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServerCmdValue(int i) {
        this.serverCmd_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionValidTime(long j) {
        this.sessionValidTime_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWorkspaceBlocked(boolean z) {
        this.workspaceBlocked_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWorkspaceVersion(long j) {
        this.workspaceVersion_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42521.f1876xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new ServerMsg();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\f\u0000\u0000\u0001\f\f\u0000\u0001\u0000\u0001\t\u0002Ȉ\u0003\f\u0004\t\u0005\u0002\u0006\t\u0007\u001b\b\u0002\t\u0007\n\u0002\u000b\t\fȈ", new Object[]{"responseResult_", "channelId_", "serverCmd_", "checkpointCoeditopPair_", "sessionValidTime_", "eventInfo_", "deviceInfo_", DeviceInfo.class, "connectedDeviceCnt_", "workspaceBlocked_", "workspaceVersion_", "policyInfo_", "dvcId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ServerMsg> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ServerMsg.class) {
                    try {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public String getChannelId() {
        return this.channelId_;
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public ByteString getChannelIdBytes() {
        return ByteString.copyFromUtf8(this.channelId_);
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public CheckPointCoeditOpPair getCheckpointCoeditopPair() {
        CheckPointCoeditOpPair checkPointCoeditOpPair = this.checkpointCoeditopPair_;
        return checkPointCoeditOpPair == null ? CheckPointCoeditOpPair.getDefaultInstance() : checkPointCoeditOpPair;
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public long getConnectedDeviceCnt() {
        return this.connectedDeviceCnt_;
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public DeviceInfo getDeviceInfo(int i) {
        return this.deviceInfo_.get(i);
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public int getDeviceInfoCount() {
        return this.deviceInfo_.size();
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public List<DeviceInfo> getDeviceInfoList() {
        return this.deviceInfo_;
    }

    public DeviceInfoOrBuilder getDeviceInfoOrBuilder(int i) {
        return this.deviceInfo_.get(i);
    }

    public List<? extends DeviceInfoOrBuilder> getDeviceInfoOrBuilderList() {
        return this.deviceInfo_;
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public String getDvcId() {
        return this.dvcId_;
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public ByteString getDvcIdBytes() {
        return ByteString.copyFromUtf8(this.dvcId_);
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public EventInfo getEventInfo() {
        EventInfo eventInfo = this.eventInfo_;
        return eventInfo == null ? EventInfo.getDefaultInstance() : eventInfo;
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public PolicyInfo getPolicyInfo() {
        PolicyInfo policyInfo = this.policyInfo_;
        return policyInfo == null ? PolicyInfo.getDefaultInstance() : policyInfo;
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public ResponseResult getResponseResult() {
        ResponseResult responseResult = this.responseResult_;
        return responseResult == null ? ResponseResult.getDefaultInstance() : responseResult;
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public ServerCmd getServerCmd() {
        ServerCmd serverCmdForNumber = ServerCmd.forNumber(this.serverCmd_);
        return serverCmdForNumber == null ? ServerCmd.UNRECOGNIZED : serverCmdForNumber;
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public int getServerCmdValue() {
        return this.serverCmd_;
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public long getSessionValidTime() {
        return this.sessionValidTime_;
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public boolean getWorkspaceBlocked() {
        return this.workspaceBlocked_;
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public long getWorkspaceVersion() {
        return this.workspaceVersion_;
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public boolean hasCheckpointCoeditopPair() {
        return this.checkpointCoeditopPair_ != null;
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public boolean hasEventInfo() {
        return this.eventInfo_ != null;
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public boolean hasPolicyInfo() {
        return this.policyInfo_ != null;
    }

    @Override // coeditCoreMessage.ServerMsgOrBuilder
    public boolean hasResponseResult() {
        return this.responseResult_ != null;
    }

    public static Builder newBuilder(ServerMsg serverMsg) {
        return DEFAULT_INSTANCE.createBuilder(serverMsg);
    }

    public static ServerMsg parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ServerMsg) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ServerMsg parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ServerMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ServerMsg parseFrom(ByteString byteString) {
        return (ServerMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDeviceInfo(int i, DeviceInfo deviceInfo) {
        deviceInfo.getClass();
        ensureDeviceInfoIsMutable();
        this.deviceInfo_.add(i, deviceInfo);
    }

    public static ServerMsg parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ServerMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ServerMsg parseFrom(byte[] bArr) {
        return (ServerMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ServerMsg parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ServerMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ServerMsg parseFrom(InputStream inputStream) {
        return (ServerMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ServerMsg parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ServerMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ServerMsg parseFrom(CodedInputStream codedInputStream) {
        return (ServerMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ServerMsg parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ServerMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
