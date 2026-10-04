package coeditCoreMessage;

import coeditCoreMessage.ResponseResult;
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
public final class ResetWorkspaceResponse extends GeneratedMessageLite<ResetWorkspaceResponse, Builder> implements ResetWorkspaceResponseOrBuilder {
    private static final ResetWorkspaceResponse DEFAULT_INSTANCE;
    public static final int IS_BLOCKED_FIELD_NUMBER = 5;
    public static final int LATEST_SNAPSHOT_CHECKPOINT_FIELD_NUMBER = 4;
    private static volatile Parser<ResetWorkspaceResponse> PARSER = null;
    public static final int RESPONSE_RESULT_FIELD_NUMBER = 1;
    public static final int WORKSPACE_ID_FIELD_NUMBER = 2;
    public static final int WORKSPACE_VERSION_FIELD_NUMBER = 3;
    private boolean isBlocked_;
    private long latestSnapshotCheckpoint_;
    private ResponseResult responseResult_;
    private String workspaceId_ = "";
    private long workspaceVersion_;

    /* JADX INFO: renamed from: coeditCoreMessage.ResetWorkspaceResponse$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42491 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1874xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1874xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1874xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1874xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1874xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1874xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1874xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1874xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<ResetWorkspaceResponse, Builder> implements ResetWorkspaceResponseOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearIsBlocked() {
            copyOnWrite();
            ((ResetWorkspaceResponse) this.instance).clearIsBlocked();
            return this;
        }

        public Builder clearLatestSnapshotCheckpoint() {
            copyOnWrite();
            ((ResetWorkspaceResponse) this.instance).clearLatestSnapshotCheckpoint();
            return this;
        }

        public Builder clearResponseResult() {
            copyOnWrite();
            ((ResetWorkspaceResponse) this.instance).clearResponseResult();
            return this;
        }

        public Builder clearWorkspaceId() {
            copyOnWrite();
            ((ResetWorkspaceResponse) this.instance).clearWorkspaceId();
            return this;
        }

        public Builder clearWorkspaceVersion() {
            copyOnWrite();
            ((ResetWorkspaceResponse) this.instance).clearWorkspaceVersion();
            return this;
        }

        @Override // coeditCoreMessage.ResetWorkspaceResponseOrBuilder
        public boolean getIsBlocked() {
            return ((ResetWorkspaceResponse) this.instance).getIsBlocked();
        }

        @Override // coeditCoreMessage.ResetWorkspaceResponseOrBuilder
        public long getLatestSnapshotCheckpoint() {
            return ((ResetWorkspaceResponse) this.instance).getLatestSnapshotCheckpoint();
        }

        @Override // coeditCoreMessage.ResetWorkspaceResponseOrBuilder
        public ResponseResult getResponseResult() {
            return ((ResetWorkspaceResponse) this.instance).getResponseResult();
        }

        @Override // coeditCoreMessage.ResetWorkspaceResponseOrBuilder
        public String getWorkspaceId() {
            return ((ResetWorkspaceResponse) this.instance).getWorkspaceId();
        }

        @Override // coeditCoreMessage.ResetWorkspaceResponseOrBuilder
        public ByteString getWorkspaceIdBytes() {
            return ((ResetWorkspaceResponse) this.instance).getWorkspaceIdBytes();
        }

        @Override // coeditCoreMessage.ResetWorkspaceResponseOrBuilder
        public long getWorkspaceVersion() {
            return ((ResetWorkspaceResponse) this.instance).getWorkspaceVersion();
        }

        @Override // coeditCoreMessage.ResetWorkspaceResponseOrBuilder
        public boolean hasResponseResult() {
            return ((ResetWorkspaceResponse) this.instance).hasResponseResult();
        }

        public Builder mergeResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((ResetWorkspaceResponse) this.instance).mergeResponseResult(responseResult);
            return this;
        }

        public Builder setIsBlocked(boolean z) {
            copyOnWrite();
            ((ResetWorkspaceResponse) this.instance).setIsBlocked(z);
            return this;
        }

        public Builder setLatestSnapshotCheckpoint(long j) {
            copyOnWrite();
            ((ResetWorkspaceResponse) this.instance).setLatestSnapshotCheckpoint(j);
            return this;
        }

        public Builder setResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((ResetWorkspaceResponse) this.instance).setResponseResult(responseResult);
            return this;
        }

        public Builder setWorkspaceId(String str) {
            copyOnWrite();
            ((ResetWorkspaceResponse) this.instance).setWorkspaceId(str);
            return this;
        }

        public Builder setWorkspaceIdBytes(ByteString byteString) {
            copyOnWrite();
            ((ResetWorkspaceResponse) this.instance).setWorkspaceIdBytes(byteString);
            return this;
        }

        public Builder setWorkspaceVersion(long j) {
            copyOnWrite();
            ((ResetWorkspaceResponse) this.instance).setWorkspaceVersion(j);
            return this;
        }

        private Builder() {
            super(ResetWorkspaceResponse.DEFAULT_INSTANCE);
        }

        public Builder setResponseResult(ResponseResult.Builder builder) {
            copyOnWrite();
            ((ResetWorkspaceResponse) this.instance).setResponseResult(builder.build());
            return this;
        }
    }

    static {
        ResetWorkspaceResponse resetWorkspaceResponse = new ResetWorkspaceResponse();
        DEFAULT_INSTANCE = resetWorkspaceResponse;
        GeneratedMessageLite.registerDefaultInstance(ResetWorkspaceResponse.class, resetWorkspaceResponse);
    }

    private ResetWorkspaceResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsBlocked() {
        this.isBlocked_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLatestSnapshotCheckpoint() {
        this.latestSnapshotCheckpoint_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseResult() {
        this.responseResult_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWorkspaceId() {
        this.workspaceId_ = getDefaultInstance().getWorkspaceId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWorkspaceVersion() {
        this.workspaceVersion_ = 0L;
    }

    public static ResetWorkspaceResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    public static ResetWorkspaceResponse parseDelimitedFrom(InputStream inputStream) {
        return (ResetWorkspaceResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ResetWorkspaceResponse parseFrom(ByteBuffer byteBuffer) {
        return (ResetWorkspaceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ResetWorkspaceResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsBlocked(boolean z) {
        this.isBlocked_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLatestSnapshotCheckpoint(long j) {
        this.latestSnapshotCheckpoint_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseResult(ResponseResult responseResult) {
        responseResult.getClass();
        this.responseResult_ = responseResult;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setWorkspaceVersion(long j) {
        this.workspaceVersion_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42491.f1874xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new ResetWorkspaceResponse();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\t\u0002Ȉ\u0003\u0002\u0004\u0002\u0005\u0007", new Object[]{"responseResult_", "workspaceId_", "workspaceVersion_", "latestSnapshotCheckpoint_", "isBlocked_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ResetWorkspaceResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ResetWorkspaceResponse.class) {
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

    @Override // coeditCoreMessage.ResetWorkspaceResponseOrBuilder
    public boolean getIsBlocked() {
        return this.isBlocked_;
    }

    @Override // coeditCoreMessage.ResetWorkspaceResponseOrBuilder
    public long getLatestSnapshotCheckpoint() {
        return this.latestSnapshotCheckpoint_;
    }

    @Override // coeditCoreMessage.ResetWorkspaceResponseOrBuilder
    public ResponseResult getResponseResult() {
        ResponseResult responseResult = this.responseResult_;
        return responseResult == null ? ResponseResult.getDefaultInstance() : responseResult;
    }

    @Override // coeditCoreMessage.ResetWorkspaceResponseOrBuilder
    public String getWorkspaceId() {
        return this.workspaceId_;
    }

    @Override // coeditCoreMessage.ResetWorkspaceResponseOrBuilder
    public ByteString getWorkspaceIdBytes() {
        return ByteString.copyFromUtf8(this.workspaceId_);
    }

    @Override // coeditCoreMessage.ResetWorkspaceResponseOrBuilder
    public long getWorkspaceVersion() {
        return this.workspaceVersion_;
    }

    @Override // coeditCoreMessage.ResetWorkspaceResponseOrBuilder
    public boolean hasResponseResult() {
        return this.responseResult_ != null;
    }

    public static Builder newBuilder(ResetWorkspaceResponse resetWorkspaceResponse) {
        return DEFAULT_INSTANCE.createBuilder(resetWorkspaceResponse);
    }

    public static ResetWorkspaceResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ResetWorkspaceResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ResetWorkspaceResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ResetWorkspaceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ResetWorkspaceResponse parseFrom(ByteString byteString) {
        return (ResetWorkspaceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ResetWorkspaceResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ResetWorkspaceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ResetWorkspaceResponse parseFrom(byte[] bArr) {
        return (ResetWorkspaceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ResetWorkspaceResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ResetWorkspaceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ResetWorkspaceResponse parseFrom(InputStream inputStream) {
        return (ResetWorkspaceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ResetWorkspaceResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ResetWorkspaceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ResetWorkspaceResponse parseFrom(CodedInputStream codedInputStream) {
        return (ResetWorkspaceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ResetWorkspaceResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ResetWorkspaceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
