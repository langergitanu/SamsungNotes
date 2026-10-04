package coeditCoreInternalMessage;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final class WorkspaceRequest extends GeneratedMessageLite<WorkspaceRequest, Builder> implements WorkspaceRequestOrBuilder {
    public static final int CID_FIELD_NUMBER = 3;
    private static final WorkspaceRequest DEFAULT_INSTANCE;
    public static final int OWNER_ID_FIELD_NUMBER = 1;
    private static volatile Parser<WorkspaceRequest> PARSER = null;
    public static final int UUID_FIELD_NUMBER = 2;
    private String ownerId_ = "";
    private String uuid_ = "";
    private String cid_ = "";

    /* JADX INFO: renamed from: coeditCoreInternalMessage.WorkspaceRequest$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42301 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1860xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1860xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1860xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1860xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1860xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1860xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1860xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1860xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<WorkspaceRequest, Builder> implements WorkspaceRequestOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearCid() {
            copyOnWrite();
            ((WorkspaceRequest) this.instance).clearCid();
            return this;
        }

        public Builder clearOwnerId() {
            copyOnWrite();
            ((WorkspaceRequest) this.instance).clearOwnerId();
            return this;
        }

        public Builder clearUuid() {
            copyOnWrite();
            ((WorkspaceRequest) this.instance).clearUuid();
            return this;
        }

        @Override // coeditCoreInternalMessage.WorkspaceRequestOrBuilder
        public String getCid() {
            return ((WorkspaceRequest) this.instance).getCid();
        }

        @Override // coeditCoreInternalMessage.WorkspaceRequestOrBuilder
        public ByteString getCidBytes() {
            return ((WorkspaceRequest) this.instance).getCidBytes();
        }

        @Override // coeditCoreInternalMessage.WorkspaceRequestOrBuilder
        public String getOwnerId() {
            return ((WorkspaceRequest) this.instance).getOwnerId();
        }

        @Override // coeditCoreInternalMessage.WorkspaceRequestOrBuilder
        public ByteString getOwnerIdBytes() {
            return ((WorkspaceRequest) this.instance).getOwnerIdBytes();
        }

        @Override // coeditCoreInternalMessage.WorkspaceRequestOrBuilder
        public String getUuid() {
            return ((WorkspaceRequest) this.instance).getUuid();
        }

        @Override // coeditCoreInternalMessage.WorkspaceRequestOrBuilder
        public ByteString getUuidBytes() {
            return ((WorkspaceRequest) this.instance).getUuidBytes();
        }

        public Builder setCid(String str) {
            copyOnWrite();
            ((WorkspaceRequest) this.instance).setCid(str);
            return this;
        }

        public Builder setCidBytes(ByteString byteString) {
            copyOnWrite();
            ((WorkspaceRequest) this.instance).setCidBytes(byteString);
            return this;
        }

        public Builder setOwnerId(String str) {
            copyOnWrite();
            ((WorkspaceRequest) this.instance).setOwnerId(str);
            return this;
        }

        public Builder setOwnerIdBytes(ByteString byteString) {
            copyOnWrite();
            ((WorkspaceRequest) this.instance).setOwnerIdBytes(byteString);
            return this;
        }

        public Builder setUuid(String str) {
            copyOnWrite();
            ((WorkspaceRequest) this.instance).setUuid(str);
            return this;
        }

        public Builder setUuidBytes(ByteString byteString) {
            copyOnWrite();
            ((WorkspaceRequest) this.instance).setUuidBytes(byteString);
            return this;
        }

        private Builder() {
            super(WorkspaceRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        WorkspaceRequest workspaceRequest = new WorkspaceRequest();
        DEFAULT_INSTANCE = workspaceRequest;
        GeneratedMessageLite.registerDefaultInstance(WorkspaceRequest.class, workspaceRequest);
    }

    private WorkspaceRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCid() {
        this.cid_ = getDefaultInstance().getCid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOwnerId() {
        this.ownerId_ = getDefaultInstance().getOwnerId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUuid() {
        this.uuid_ = getDefaultInstance().getUuid();
    }

    public static WorkspaceRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static WorkspaceRequest parseDelimitedFrom(InputStream inputStream) {
        return (WorkspaceRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WorkspaceRequest parseFrom(ByteBuffer byteBuffer) {
        return (WorkspaceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<WorkspaceRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCid(String str) {
        str.getClass();
        this.cid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCidBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.cid_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOwnerId(String str) {
        str.getClass();
        this.ownerId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOwnerIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.ownerId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUuid(String str) {
        str.getClass();
        this.uuid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUuidBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.uuid_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42301.f1860xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new WorkspaceRequest();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"ownerId_", "uuid_", "cid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<WorkspaceRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (WorkspaceRequest.class) {
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

    @Override // coeditCoreInternalMessage.WorkspaceRequestOrBuilder
    public String getCid() {
        return this.cid_;
    }

    @Override // coeditCoreInternalMessage.WorkspaceRequestOrBuilder
    public ByteString getCidBytes() {
        return ByteString.copyFromUtf8(this.cid_);
    }

    @Override // coeditCoreInternalMessage.WorkspaceRequestOrBuilder
    public String getOwnerId() {
        return this.ownerId_;
    }

    @Override // coeditCoreInternalMessage.WorkspaceRequestOrBuilder
    public ByteString getOwnerIdBytes() {
        return ByteString.copyFromUtf8(this.ownerId_);
    }

    @Override // coeditCoreInternalMessage.WorkspaceRequestOrBuilder
    public String getUuid() {
        return this.uuid_;
    }

    @Override // coeditCoreInternalMessage.WorkspaceRequestOrBuilder
    public ByteString getUuidBytes() {
        return ByteString.copyFromUtf8(this.uuid_);
    }

    public static Builder newBuilder(WorkspaceRequest workspaceRequest) {
        return DEFAULT_INSTANCE.createBuilder(workspaceRequest);
    }

    public static WorkspaceRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WorkspaceRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WorkspaceRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (WorkspaceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static WorkspaceRequest parseFrom(ByteString byteString) {
        return (WorkspaceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static WorkspaceRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (WorkspaceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static WorkspaceRequest parseFrom(byte[] bArr) {
        return (WorkspaceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WorkspaceRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (WorkspaceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static WorkspaceRequest parseFrom(InputStream inputStream) {
        return (WorkspaceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WorkspaceRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WorkspaceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WorkspaceRequest parseFrom(CodedInputStream codedInputStream) {
        return (WorkspaceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static WorkspaceRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WorkspaceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
