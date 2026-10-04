package coeditCoreMessage;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class PolicyInfo extends GeneratedMessageLite<PolicyInfo, Builder> implements PolicyInfoOrBuilder {
    private static final PolicyInfo DEFAULT_INSTANCE;
    public static final int MAX_CONNECTABLE_DEVICE_CNT_FIELD_NUMBER = 1;
    public static final int MAX_EDITABLE_DEVICE_CNT_FIELD_NUMBER = 2;
    private static volatile Parser<PolicyInfo> PARSER;
    private int maxConnectableDeviceCnt_;
    private int maxEditableDeviceCnt_;

    /* JADX INFO: renamed from: coeditCoreMessage.PolicyInfo$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42471 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1872xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1872xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1872xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1872xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1872xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1872xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1872xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1872xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<PolicyInfo, Builder> implements PolicyInfoOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearMaxConnectableDeviceCnt() {
            copyOnWrite();
            ((PolicyInfo) this.instance).clearMaxConnectableDeviceCnt();
            return this;
        }

        public Builder clearMaxEditableDeviceCnt() {
            copyOnWrite();
            ((PolicyInfo) this.instance).clearMaxEditableDeviceCnt();
            return this;
        }

        @Override // coeditCoreMessage.PolicyInfoOrBuilder
        public int getMaxConnectableDeviceCnt() {
            return ((PolicyInfo) this.instance).getMaxConnectableDeviceCnt();
        }

        @Override // coeditCoreMessage.PolicyInfoOrBuilder
        public int getMaxEditableDeviceCnt() {
            return ((PolicyInfo) this.instance).getMaxEditableDeviceCnt();
        }

        public Builder setMaxConnectableDeviceCnt(int i) {
            copyOnWrite();
            ((PolicyInfo) this.instance).setMaxConnectableDeviceCnt(i);
            return this;
        }

        public Builder setMaxEditableDeviceCnt(int i) {
            copyOnWrite();
            ((PolicyInfo) this.instance).setMaxEditableDeviceCnt(i);
            return this;
        }

        private Builder() {
            super(PolicyInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        PolicyInfo policyInfo = new PolicyInfo();
        DEFAULT_INSTANCE = policyInfo;
        GeneratedMessageLite.registerDefaultInstance(PolicyInfo.class, policyInfo);
    }

    private PolicyInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMaxConnectableDeviceCnt() {
        this.maxConnectableDeviceCnt_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMaxEditableDeviceCnt() {
        this.maxEditableDeviceCnt_ = 0;
    }

    public static PolicyInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PolicyInfo parseDelimitedFrom(InputStream inputStream) {
        return (PolicyInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PolicyInfo parseFrom(ByteBuffer byteBuffer) {
        return (PolicyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PolicyInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaxConnectableDeviceCnt(int i) {
        this.maxConnectableDeviceCnt_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaxEditableDeviceCnt(int i) {
        this.maxEditableDeviceCnt_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42471.f1872xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new PolicyInfo();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", new Object[]{"maxConnectableDeviceCnt_", "maxEditableDeviceCnt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PolicyInfo> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PolicyInfo.class) {
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

    @Override // coeditCoreMessage.PolicyInfoOrBuilder
    public int getMaxConnectableDeviceCnt() {
        return this.maxConnectableDeviceCnt_;
    }

    @Override // coeditCoreMessage.PolicyInfoOrBuilder
    public int getMaxEditableDeviceCnt() {
        return this.maxEditableDeviceCnt_;
    }

    public static Builder newBuilder(PolicyInfo policyInfo) {
        return DEFAULT_INSTANCE.createBuilder(policyInfo);
    }

    public static PolicyInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PolicyInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PolicyInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PolicyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PolicyInfo parseFrom(ByteString byteString) {
        return (PolicyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PolicyInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PolicyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PolicyInfo parseFrom(byte[] bArr) {
        return (PolicyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PolicyInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PolicyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PolicyInfo parseFrom(InputStream inputStream) {
        return (PolicyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PolicyInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PolicyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PolicyInfo parseFrom(CodedInputStream codedInputStream) {
        return (PolicyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PolicyInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PolicyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
