package coeditCoreMessage;

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
public final class ClientMsg extends GeneratedMessageLite<ClientMsg, Builder> implements ClientMsgOrBuilder {
    public static final int CHANNEL_ID_FIELD_NUMBER = 1;
    public static final int CLIENT_CMD_FIELD_NUMBER = 2;
    private static final ClientMsg DEFAULT_INSTANCE;
    private static volatile Parser<ClientMsg> PARSER;
    private String channelId_ = "";
    private int clientCmd_;

    /* JADX INFO: renamed from: coeditCoreMessage.ClientMsg$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42381 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1866xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1866xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1866xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1866xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1866xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1866xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1866xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1866xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<ClientMsg, Builder> implements ClientMsgOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearChannelId() {
            copyOnWrite();
            ((ClientMsg) this.instance).clearChannelId();
            return this;
        }

        public Builder clearClientCmd() {
            copyOnWrite();
            ((ClientMsg) this.instance).clearClientCmd();
            return this;
        }

        @Override // coeditCoreMessage.ClientMsgOrBuilder
        public String getChannelId() {
            return ((ClientMsg) this.instance).getChannelId();
        }

        @Override // coeditCoreMessage.ClientMsgOrBuilder
        public ByteString getChannelIdBytes() {
            return ((ClientMsg) this.instance).getChannelIdBytes();
        }

        @Override // coeditCoreMessage.ClientMsgOrBuilder
        public ClientCmd getClientCmd() {
            return ((ClientMsg) this.instance).getClientCmd();
        }

        @Override // coeditCoreMessage.ClientMsgOrBuilder
        public int getClientCmdValue() {
            return ((ClientMsg) this.instance).getClientCmdValue();
        }

        public Builder setChannelId(String str) {
            copyOnWrite();
            ((ClientMsg) this.instance).setChannelId(str);
            return this;
        }

        public Builder setChannelIdBytes(ByteString byteString) {
            copyOnWrite();
            ((ClientMsg) this.instance).setChannelIdBytes(byteString);
            return this;
        }

        public Builder setClientCmd(ClientCmd clientCmd) {
            copyOnWrite();
            ((ClientMsg) this.instance).setClientCmd(clientCmd);
            return this;
        }

        public Builder setClientCmdValue(int i) {
            copyOnWrite();
            ((ClientMsg) this.instance).setClientCmdValue(i);
            return this;
        }

        private Builder() {
            super(ClientMsg.DEFAULT_INSTANCE);
        }
    }

    static {
        ClientMsg clientMsg = new ClientMsg();
        DEFAULT_INSTANCE = clientMsg;
        GeneratedMessageLite.registerDefaultInstance(ClientMsg.class, clientMsg);
    }

    private ClientMsg() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChannelId() {
        this.channelId_ = getDefaultInstance().getChannelId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClientCmd() {
        this.clientCmd_ = 0;
    }

    public static ClientMsg getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ClientMsg parseDelimitedFrom(InputStream inputStream) {
        return (ClientMsg) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClientMsg parseFrom(ByteBuffer byteBuffer) {
        return (ClientMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ClientMsg> parser() {
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
    public void setClientCmd(ClientCmd clientCmd) {
        this.clientCmd_ = clientCmd.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientCmdValue(int i) {
        this.clientCmd_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42381.f1866xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new ClientMsg();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\f", new Object[]{"channelId_", "clientCmd_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ClientMsg> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ClientMsg.class) {
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

    @Override // coeditCoreMessage.ClientMsgOrBuilder
    public String getChannelId() {
        return this.channelId_;
    }

    @Override // coeditCoreMessage.ClientMsgOrBuilder
    public ByteString getChannelIdBytes() {
        return ByteString.copyFromUtf8(this.channelId_);
    }

    @Override // coeditCoreMessage.ClientMsgOrBuilder
    public ClientCmd getClientCmd() {
        ClientCmd clientCmdForNumber = ClientCmd.forNumber(this.clientCmd_);
        return clientCmdForNumber == null ? ClientCmd.UNRECOGNIZED : clientCmdForNumber;
    }

    @Override // coeditCoreMessage.ClientMsgOrBuilder
    public int getClientCmdValue() {
        return this.clientCmd_;
    }

    public static Builder newBuilder(ClientMsg clientMsg) {
        return DEFAULT_INSTANCE.createBuilder(clientMsg);
    }

    public static ClientMsg parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ClientMsg) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ClientMsg parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ClientMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ClientMsg parseFrom(ByteString byteString) {
        return (ClientMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ClientMsg parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ClientMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ClientMsg parseFrom(byte[] bArr) {
        return (ClientMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ClientMsg parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ClientMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ClientMsg parseFrom(InputStream inputStream) {
        return (ClientMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClientMsg parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ClientMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ClientMsg parseFrom(CodedInputStream codedInputStream) {
        return (ClientMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ClientMsg parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ClientMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
