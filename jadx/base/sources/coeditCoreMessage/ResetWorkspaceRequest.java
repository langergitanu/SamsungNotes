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
public final class ResetWorkspaceRequest extends GeneratedMessageLite<ResetWorkspaceRequest, Builder> implements ResetWorkspaceRequestOrBuilder {
    private static final ResetWorkspaceRequest DEFAULT_INSTANCE;
    private static volatile Parser<ResetWorkspaceRequest> PARSER = null;
    public static final int WORKSPACE_VERSION_FIELD_NUMBER = 1;
    private long workspaceVersion_;

    /* JADX INFO: renamed from: coeditCoreMessage.ResetWorkspaceRequest$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42481 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1873xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1873xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1873xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1873xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1873xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1873xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1873xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1873xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<ResetWorkspaceRequest, Builder> implements ResetWorkspaceRequestOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearWorkspaceVersion() {
            copyOnWrite();
            ((ResetWorkspaceRequest) this.instance).clearWorkspaceVersion();
            return this;
        }

        @Override // coeditCoreMessage.ResetWorkspaceRequestOrBuilder
        public long getWorkspaceVersion() {
            return ((ResetWorkspaceRequest) this.instance).getWorkspaceVersion();
        }

        public Builder setWorkspaceVersion(long j) {
            copyOnWrite();
            ((ResetWorkspaceRequest) this.instance).setWorkspaceVersion(j);
            return this;
        }

        private Builder() {
            super(ResetWorkspaceRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        ResetWorkspaceRequest resetWorkspaceRequest = new ResetWorkspaceRequest();
        DEFAULT_INSTANCE = resetWorkspaceRequest;
        GeneratedMessageLite.registerDefaultInstance(ResetWorkspaceRequest.class, resetWorkspaceRequest);
    }

    private ResetWorkspaceRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWorkspaceVersion() {
        this.workspaceVersion_ = 0L;
    }

    public static ResetWorkspaceRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ResetWorkspaceRequest parseDelimitedFrom(InputStream inputStream) {
        return (ResetWorkspaceRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ResetWorkspaceRequest parseFrom(ByteBuffer byteBuffer) {
        return (ResetWorkspaceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ResetWorkspaceRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWorkspaceVersion(long j) {
        this.workspaceVersion_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42481.f1873xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new ResetWorkspaceRequest();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"workspaceVersion_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ResetWorkspaceRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ResetWorkspaceRequest.class) {
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

    @Override // coeditCoreMessage.ResetWorkspaceRequestOrBuilder
    public long getWorkspaceVersion() {
        return this.workspaceVersion_;
    }

    public static Builder newBuilder(ResetWorkspaceRequest resetWorkspaceRequest) {
        return DEFAULT_INSTANCE.createBuilder(resetWorkspaceRequest);
    }

    public static ResetWorkspaceRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ResetWorkspaceRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ResetWorkspaceRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ResetWorkspaceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ResetWorkspaceRequest parseFrom(ByteString byteString) {
        return (ResetWorkspaceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ResetWorkspaceRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ResetWorkspaceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ResetWorkspaceRequest parseFrom(byte[] bArr) {
        return (ResetWorkspaceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ResetWorkspaceRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ResetWorkspaceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ResetWorkspaceRequest parseFrom(InputStream inputStream) {
        return (ResetWorkspaceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ResetWorkspaceRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ResetWorkspaceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ResetWorkspaceRequest parseFrom(CodedInputStream codedInputStream) {
        return (ResetWorkspaceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ResetWorkspaceRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ResetWorkspaceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
