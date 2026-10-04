package coeditCoreMessage;

import coeditCoreMessage.CheckPointCoeditOpPair;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class SubmitRequest extends GeneratedMessageLite<SubmitRequest, Builder> implements SubmitRequestOrBuilder {
    public static final int CHANNEL_ID_FIELD_NUMBER = 2;
    public static final int CHECKPOINT_COEDITOP_PAIR_FIELD_NUMBER = 3;
    public static final int CLIENT_CMD_FIELD_NUMBER = 1;
    private static final SubmitRequest DEFAULT_INSTANCE;
    public static final int IS_VALIDATE_FIELD_NUMBER = 4;
    private static volatile Parser<SubmitRequest> PARSER = null;
    public static final int WORKSPACE_VERSION_FIELD_NUMBER = 5;
    private String channelId_ = "";
    private CheckPointCoeditOpPair checkpointCoeditopPair_;
    private int clientCmd_;
    private boolean isValidate_;
    private long workspaceVersion_;

    /* JADX INFO: renamed from: coeditCoreMessage.SubmitRequest$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42531 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1877xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1877xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1877xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1877xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1877xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1877xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1877xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1877xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<SubmitRequest, Builder> implements SubmitRequestOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearChannelId() {
            copyOnWrite();
            ((SubmitRequest) this.instance).clearChannelId();
            return this;
        }

        public Builder clearCheckpointCoeditopPair() {
            copyOnWrite();
            ((SubmitRequest) this.instance).clearCheckpointCoeditopPair();
            return this;
        }

        public Builder clearClientCmd() {
            copyOnWrite();
            ((SubmitRequest) this.instance).clearClientCmd();
            return this;
        }

        public Builder clearIsValidate() {
            copyOnWrite();
            ((SubmitRequest) this.instance).clearIsValidate();
            return this;
        }

        public Builder clearWorkspaceVersion() {
            copyOnWrite();
            ((SubmitRequest) this.instance).clearWorkspaceVersion();
            return this;
        }

        @Override // coeditCoreMessage.SubmitRequestOrBuilder
        public String getChannelId() {
            return ((SubmitRequest) this.instance).getChannelId();
        }

        @Override // coeditCoreMessage.SubmitRequestOrBuilder
        public ByteString getChannelIdBytes() {
            return ((SubmitRequest) this.instance).getChannelIdBytes();
        }

        @Override // coeditCoreMessage.SubmitRequestOrBuilder
        public CheckPointCoeditOpPair getCheckpointCoeditopPair() {
            return ((SubmitRequest) this.instance).getCheckpointCoeditopPair();
        }

        @Override // coeditCoreMessage.SubmitRequestOrBuilder
        public ClientCmd getClientCmd() {
            return ((SubmitRequest) this.instance).getClientCmd();
        }

        @Override // coeditCoreMessage.SubmitRequestOrBuilder
        public int getClientCmdValue() {
            return ((SubmitRequest) this.instance).getClientCmdValue();
        }

        @Override // coeditCoreMessage.SubmitRequestOrBuilder
        public boolean getIsValidate() {
            return ((SubmitRequest) this.instance).getIsValidate();
        }

        @Override // coeditCoreMessage.SubmitRequestOrBuilder
        public long getWorkspaceVersion() {
            return ((SubmitRequest) this.instance).getWorkspaceVersion();
        }

        @Override // coeditCoreMessage.SubmitRequestOrBuilder
        public boolean hasCheckpointCoeditopPair() {
            return ((SubmitRequest) this.instance).hasCheckpointCoeditopPair();
        }

        public Builder mergeCheckpointCoeditopPair(CheckPointCoeditOpPair checkPointCoeditOpPair) {
            copyOnWrite();
            ((SubmitRequest) this.instance).mergeCheckpointCoeditopPair(checkPointCoeditOpPair);
            return this;
        }

        public Builder setChannelId(String str) {
            copyOnWrite();
            ((SubmitRequest) this.instance).setChannelId(str);
            return this;
        }

        public Builder setChannelIdBytes(ByteString byteString) {
            copyOnWrite();
            ((SubmitRequest) this.instance).setChannelIdBytes(byteString);
            return this;
        }

        public Builder setCheckpointCoeditopPair(CheckPointCoeditOpPair checkPointCoeditOpPair) {
            copyOnWrite();
            ((SubmitRequest) this.instance).setCheckpointCoeditopPair(checkPointCoeditOpPair);
            return this;
        }

        public Builder setClientCmd(ClientCmd clientCmd) {
            copyOnWrite();
            ((SubmitRequest) this.instance).setClientCmd(clientCmd);
            return this;
        }

        public Builder setClientCmdValue(int i) {
            copyOnWrite();
            ((SubmitRequest) this.instance).setClientCmdValue(i);
            return this;
        }

        public Builder setIsValidate(boolean z) {
            copyOnWrite();
            ((SubmitRequest) this.instance).setIsValidate(z);
            return this;
        }

        public Builder setWorkspaceVersion(long j) {
            copyOnWrite();
            ((SubmitRequest) this.instance).setWorkspaceVersion(j);
            return this;
        }

        private Builder() {
            super(SubmitRequest.DEFAULT_INSTANCE);
        }

        public Builder setCheckpointCoeditopPair(CheckPointCoeditOpPair.Builder builder) {
            copyOnWrite();
            ((SubmitRequest) this.instance).setCheckpointCoeditopPair(builder.build());
            return this;
        }
    }

    static {
        SubmitRequest submitRequest = new SubmitRequest();
        DEFAULT_INSTANCE = submitRequest;
        GeneratedMessageLite.registerDefaultInstance(SubmitRequest.class, submitRequest);
    }

    private SubmitRequest() {
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
    public void clearClientCmd() {
        this.clientCmd_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsValidate() {
        this.isValidate_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWorkspaceVersion() {
        this.workspaceVersion_ = 0L;
    }

    public static SubmitRequest getDefaultInstance() {
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

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SubmitRequest parseDelimitedFrom(InputStream inputStream) {
        return (SubmitRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SubmitRequest parseFrom(ByteBuffer byteBuffer) {
        return (SubmitRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SubmitRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
    public void setClientCmd(ClientCmd clientCmd) {
        this.clientCmd_ = clientCmd.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientCmdValue(int i) {
        this.clientCmd_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsValidate(boolean z) {
        this.isValidate_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWorkspaceVersion(long j) {
        this.workspaceVersion_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42531.f1877xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new SubmitRequest();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003\t\u0004\u0007\u0005\u0002", new Object[]{"clientCmd_", "channelId_", "checkpointCoeditopPair_", "isValidate_", "workspaceVersion_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SubmitRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SubmitRequest.class) {
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

    @Override // coeditCoreMessage.SubmitRequestOrBuilder
    public String getChannelId() {
        return this.channelId_;
    }

    @Override // coeditCoreMessage.SubmitRequestOrBuilder
    public ByteString getChannelIdBytes() {
        return ByteString.copyFromUtf8(this.channelId_);
    }

    @Override // coeditCoreMessage.SubmitRequestOrBuilder
    public CheckPointCoeditOpPair getCheckpointCoeditopPair() {
        CheckPointCoeditOpPair checkPointCoeditOpPair = this.checkpointCoeditopPair_;
        return checkPointCoeditOpPair == null ? CheckPointCoeditOpPair.getDefaultInstance() : checkPointCoeditOpPair;
    }

    @Override // coeditCoreMessage.SubmitRequestOrBuilder
    public ClientCmd getClientCmd() {
        ClientCmd clientCmdForNumber = ClientCmd.forNumber(this.clientCmd_);
        return clientCmdForNumber == null ? ClientCmd.UNRECOGNIZED : clientCmdForNumber;
    }

    @Override // coeditCoreMessage.SubmitRequestOrBuilder
    public int getClientCmdValue() {
        return this.clientCmd_;
    }

    @Override // coeditCoreMessage.SubmitRequestOrBuilder
    public boolean getIsValidate() {
        return this.isValidate_;
    }

    @Override // coeditCoreMessage.SubmitRequestOrBuilder
    public long getWorkspaceVersion() {
        return this.workspaceVersion_;
    }

    @Override // coeditCoreMessage.SubmitRequestOrBuilder
    public boolean hasCheckpointCoeditopPair() {
        return this.checkpointCoeditopPair_ != null;
    }

    public static Builder newBuilder(SubmitRequest submitRequest) {
        return DEFAULT_INSTANCE.createBuilder(submitRequest);
    }

    public static SubmitRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SubmitRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SubmitRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (SubmitRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SubmitRequest parseFrom(ByteString byteString) {
        return (SubmitRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SubmitRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (SubmitRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SubmitRequest parseFrom(byte[] bArr) {
        return (SubmitRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SubmitRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (SubmitRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SubmitRequest parseFrom(InputStream inputStream) {
        return (SubmitRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SubmitRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SubmitRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SubmitRequest parseFrom(CodedInputStream codedInputStream) {
        return (SubmitRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SubmitRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SubmitRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
