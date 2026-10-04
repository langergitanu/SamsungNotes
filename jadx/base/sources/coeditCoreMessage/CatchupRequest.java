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
public final class CatchupRequest extends GeneratedMessageLite<CatchupRequest, Builder> implements CatchupRequestOrBuilder {
    public static final int CATCHUP_TYPE_FIELD_NUMBER = 3;
    private static final CatchupRequest DEFAULT_INSTANCE;
    public static final int END_CHECKPOINT_FIELD_NUMBER = 2;
    private static volatile Parser<CatchupRequest> PARSER = null;
    public static final int START_CHECKPOINT_FIELD_NUMBER = 1;
    public static final int WORKSPACE_VERSION_FIELD_NUMBER = 4;
    private int catchupType_;
    private long endCheckpoint_;
    private long startCheckpoint_;
    private long workspaceVersion_;

    /* JADX INFO: renamed from: coeditCoreMessage.CatchupRequest$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42331 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1863xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1863xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1863xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1863xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1863xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1863xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1863xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1863xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<CatchupRequest, Builder> implements CatchupRequestOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearCatchupType() {
            copyOnWrite();
            ((CatchupRequest) this.instance).clearCatchupType();
            return this;
        }

        public Builder clearEndCheckpoint() {
            copyOnWrite();
            ((CatchupRequest) this.instance).clearEndCheckpoint();
            return this;
        }

        public Builder clearStartCheckpoint() {
            copyOnWrite();
            ((CatchupRequest) this.instance).clearStartCheckpoint();
            return this;
        }

        public Builder clearWorkspaceVersion() {
            copyOnWrite();
            ((CatchupRequest) this.instance).clearWorkspaceVersion();
            return this;
        }

        @Override // coeditCoreMessage.CatchupRequestOrBuilder
        public CatchupType getCatchupType() {
            return ((CatchupRequest) this.instance).getCatchupType();
        }

        @Override // coeditCoreMessage.CatchupRequestOrBuilder
        public int getCatchupTypeValue() {
            return ((CatchupRequest) this.instance).getCatchupTypeValue();
        }

        @Override // coeditCoreMessage.CatchupRequestOrBuilder
        public long getEndCheckpoint() {
            return ((CatchupRequest) this.instance).getEndCheckpoint();
        }

        @Override // coeditCoreMessage.CatchupRequestOrBuilder
        public long getStartCheckpoint() {
            return ((CatchupRequest) this.instance).getStartCheckpoint();
        }

        @Override // coeditCoreMessage.CatchupRequestOrBuilder
        public long getWorkspaceVersion() {
            return ((CatchupRequest) this.instance).getWorkspaceVersion();
        }

        public Builder setCatchupType(CatchupType catchupType) {
            copyOnWrite();
            ((CatchupRequest) this.instance).setCatchupType(catchupType);
            return this;
        }

        public Builder setCatchupTypeValue(int i) {
            copyOnWrite();
            ((CatchupRequest) this.instance).setCatchupTypeValue(i);
            return this;
        }

        public Builder setEndCheckpoint(long j) {
            copyOnWrite();
            ((CatchupRequest) this.instance).setEndCheckpoint(j);
            return this;
        }

        public Builder setStartCheckpoint(long j) {
            copyOnWrite();
            ((CatchupRequest) this.instance).setStartCheckpoint(j);
            return this;
        }

        public Builder setWorkspaceVersion(long j) {
            copyOnWrite();
            ((CatchupRequest) this.instance).setWorkspaceVersion(j);
            return this;
        }

        private Builder() {
            super(CatchupRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        CatchupRequest catchupRequest = new CatchupRequest();
        DEFAULT_INSTANCE = catchupRequest;
        GeneratedMessageLite.registerDefaultInstance(CatchupRequest.class, catchupRequest);
    }

    private CatchupRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCatchupType() {
        this.catchupType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndCheckpoint() {
        this.endCheckpoint_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartCheckpoint() {
        this.startCheckpoint_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWorkspaceVersion() {
        this.workspaceVersion_ = 0L;
    }

    public static CatchupRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static CatchupRequest parseDelimitedFrom(InputStream inputStream) {
        return (CatchupRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CatchupRequest parseFrom(ByteBuffer byteBuffer) {
        return (CatchupRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CatchupRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCatchupType(CatchupType catchupType) {
        this.catchupType_ = catchupType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCatchupTypeValue(int i) {
        this.catchupType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndCheckpoint(long j) {
        this.endCheckpoint_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartCheckpoint(long j) {
        this.startCheckpoint_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWorkspaceVersion(long j) {
        this.workspaceVersion_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42331.f1863xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new CatchupRequest();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\f\u0004\u0002", new Object[]{"startCheckpoint_", "endCheckpoint_", "catchupType_", "workspaceVersion_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CatchupRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (CatchupRequest.class) {
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

    @Override // coeditCoreMessage.CatchupRequestOrBuilder
    public CatchupType getCatchupType() {
        CatchupType catchupTypeForNumber = CatchupType.forNumber(this.catchupType_);
        return catchupTypeForNumber == null ? CatchupType.UNRECOGNIZED : catchupTypeForNumber;
    }

    @Override // coeditCoreMessage.CatchupRequestOrBuilder
    public int getCatchupTypeValue() {
        return this.catchupType_;
    }

    @Override // coeditCoreMessage.CatchupRequestOrBuilder
    public long getEndCheckpoint() {
        return this.endCheckpoint_;
    }

    @Override // coeditCoreMessage.CatchupRequestOrBuilder
    public long getStartCheckpoint() {
        return this.startCheckpoint_;
    }

    @Override // coeditCoreMessage.CatchupRequestOrBuilder
    public long getWorkspaceVersion() {
        return this.workspaceVersion_;
    }

    public static Builder newBuilder(CatchupRequest catchupRequest) {
        return DEFAULT_INSTANCE.createBuilder(catchupRequest);
    }

    public static CatchupRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CatchupRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CatchupRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (CatchupRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CatchupRequest parseFrom(ByteString byteString) {
        return (CatchupRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static CatchupRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CatchupRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CatchupRequest parseFrom(byte[] bArr) {
        return (CatchupRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CatchupRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (CatchupRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CatchupRequest parseFrom(InputStream inputStream) {
        return (CatchupRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CatchupRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CatchupRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CatchupRequest parseFrom(CodedInputStream codedInputStream) {
        return (CatchupRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CatchupRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CatchupRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
