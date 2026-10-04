package coeditObjectStg;

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
public final class DeleteRequest extends GeneratedMessageLite<DeleteRequest, Builder> implements DeleteRequestOrBuilder {
    private static final DeleteRequest DEFAULT_INSTANCE;
    private static volatile Parser<DeleteRequest> PARSER = null;
    public static final int WORKSPACE_ID_FIELD_NUMBER = 1;
    private String workspaceId_ = "";

    /* JADX INFO: renamed from: coeditObjectStg.DeleteRequest$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42751 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1890xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1890xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1890xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1890xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1890xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1890xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1890xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1890xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<DeleteRequest, Builder> implements DeleteRequestOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearWorkspaceId() {
            copyOnWrite();
            ((DeleteRequest) this.instance).clearWorkspaceId();
            return this;
        }

        @Override // coeditObjectStg.DeleteRequestOrBuilder
        public String getWorkspaceId() {
            return ((DeleteRequest) this.instance).getWorkspaceId();
        }

        @Override // coeditObjectStg.DeleteRequestOrBuilder
        public ByteString getWorkspaceIdBytes() {
            return ((DeleteRequest) this.instance).getWorkspaceIdBytes();
        }

        public Builder setWorkspaceId(String str) {
            copyOnWrite();
            ((DeleteRequest) this.instance).setWorkspaceId(str);
            return this;
        }

        public Builder setWorkspaceIdBytes(ByteString byteString) {
            copyOnWrite();
            ((DeleteRequest) this.instance).setWorkspaceIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(DeleteRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        DeleteRequest deleteRequest = new DeleteRequest();
        DEFAULT_INSTANCE = deleteRequest;
        GeneratedMessageLite.registerDefaultInstance(DeleteRequest.class, deleteRequest);
    }

    private DeleteRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWorkspaceId() {
        this.workspaceId_ = getDefaultInstance().getWorkspaceId();
    }

    public static DeleteRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static DeleteRequest parseDelimitedFrom(InputStream inputStream) {
        return (DeleteRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DeleteRequest parseFrom(ByteBuffer byteBuffer) {
        return (DeleteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<DeleteRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWorkspaceId(String str) {
        str.getClass();
        this.workspaceId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWorkspaceIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.workspaceId_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42751.f1890xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new DeleteRequest();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"workspaceId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DeleteRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (DeleteRequest.class) {
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

    @Override // coeditObjectStg.DeleteRequestOrBuilder
    public String getWorkspaceId() {
        return this.workspaceId_;
    }

    @Override // coeditObjectStg.DeleteRequestOrBuilder
    public ByteString getWorkspaceIdBytes() {
        return ByteString.copyFromUtf8(this.workspaceId_);
    }

    public static Builder newBuilder(DeleteRequest deleteRequest) {
        return DEFAULT_INSTANCE.createBuilder(deleteRequest);
    }

    public static DeleteRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DeleteRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DeleteRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DeleteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DeleteRequest parseFrom(ByteString byteString) {
        return (DeleteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static DeleteRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DeleteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DeleteRequest parseFrom(byte[] bArr) {
        return (DeleteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DeleteRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (DeleteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DeleteRequest parseFrom(InputStream inputStream) {
        return (DeleteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DeleteRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DeleteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DeleteRequest parseFrom(CodedInputStream codedInputStream) {
        return (DeleteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DeleteRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DeleteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
