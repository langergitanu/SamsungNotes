package coeditCoreInternalMessage;

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
/* JADX INFO: loaded from: classes.dex */
public final class WorkspaceResponse extends GeneratedMessageLite<WorkspaceResponse, Builder> implements WorkspaceResponseOrBuilder {
    private static final WorkspaceResponse DEFAULT_INSTANCE;
    private static volatile Parser<WorkspaceResponse> PARSER = null;
    public static final int RESPONSE_RESULT_FIELD_NUMBER = 1;
    public static final int WORKSPACE_ID_FIELD_NUMBER = 2;
    private ResponseResult responseResult_;
    private String workspaceId_ = "";

    /* JADX INFO: renamed from: coeditCoreInternalMessage.WorkspaceResponse$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42311 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1861xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1861xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1861xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1861xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1861xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1861xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1861xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1861xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<WorkspaceResponse, Builder> implements WorkspaceResponseOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearResponseResult() {
            copyOnWrite();
            ((WorkspaceResponse) this.instance).clearResponseResult();
            return this;
        }

        public Builder clearWorkspaceId() {
            copyOnWrite();
            ((WorkspaceResponse) this.instance).clearWorkspaceId();
            return this;
        }

        @Override // coeditCoreInternalMessage.WorkspaceResponseOrBuilder
        public ResponseResult getResponseResult() {
            return ((WorkspaceResponse) this.instance).getResponseResult();
        }

        @Override // coeditCoreInternalMessage.WorkspaceResponseOrBuilder
        public String getWorkspaceId() {
            return ((WorkspaceResponse) this.instance).getWorkspaceId();
        }

        @Override // coeditCoreInternalMessage.WorkspaceResponseOrBuilder
        public ByteString getWorkspaceIdBytes() {
            return ((WorkspaceResponse) this.instance).getWorkspaceIdBytes();
        }

        @Override // coeditCoreInternalMessage.WorkspaceResponseOrBuilder
        public boolean hasResponseResult() {
            return ((WorkspaceResponse) this.instance).hasResponseResult();
        }

        public Builder mergeResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((WorkspaceResponse) this.instance).mergeResponseResult(responseResult);
            return this;
        }

        public Builder setResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((WorkspaceResponse) this.instance).setResponseResult(responseResult);
            return this;
        }

        public Builder setWorkspaceId(String str) {
            copyOnWrite();
            ((WorkspaceResponse) this.instance).setWorkspaceId(str);
            return this;
        }

        public Builder setWorkspaceIdBytes(ByteString byteString) {
            copyOnWrite();
            ((WorkspaceResponse) this.instance).setWorkspaceIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(WorkspaceResponse.DEFAULT_INSTANCE);
        }

        public Builder setResponseResult(ResponseResult.Builder builder) {
            copyOnWrite();
            ((WorkspaceResponse) this.instance).setResponseResult(builder.build());
            return this;
        }
    }

    static {
        WorkspaceResponse workspaceResponse = new WorkspaceResponse();
        DEFAULT_INSTANCE = workspaceResponse;
        GeneratedMessageLite.registerDefaultInstance(WorkspaceResponse.class, workspaceResponse);
    }

    private WorkspaceResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseResult() {
        this.responseResult_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWorkspaceId() {
        this.workspaceId_ = getDefaultInstance().getWorkspaceId();
    }

    public static WorkspaceResponse getDefaultInstance() {
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

    public static WorkspaceResponse parseDelimitedFrom(InputStream inputStream) {
        return (WorkspaceResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WorkspaceResponse parseFrom(ByteBuffer byteBuffer) {
        return (WorkspaceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<WorkspaceResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
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

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42311.f1861xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new WorkspaceResponse();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002Ȉ", new Object[]{"responseResult_", "workspaceId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<WorkspaceResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (WorkspaceResponse.class) {
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

    @Override // coeditCoreInternalMessage.WorkspaceResponseOrBuilder
    public ResponseResult getResponseResult() {
        ResponseResult responseResult = this.responseResult_;
        return responseResult == null ? ResponseResult.getDefaultInstance() : responseResult;
    }

    @Override // coeditCoreInternalMessage.WorkspaceResponseOrBuilder
    public String getWorkspaceId() {
        return this.workspaceId_;
    }

    @Override // coeditCoreInternalMessage.WorkspaceResponseOrBuilder
    public ByteString getWorkspaceIdBytes() {
        return ByteString.copyFromUtf8(this.workspaceId_);
    }

    @Override // coeditCoreInternalMessage.WorkspaceResponseOrBuilder
    public boolean hasResponseResult() {
        return this.responseResult_ != null;
    }

    public static Builder newBuilder(WorkspaceResponse workspaceResponse) {
        return DEFAULT_INSTANCE.createBuilder(workspaceResponse);
    }

    public static WorkspaceResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WorkspaceResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WorkspaceResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (WorkspaceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static WorkspaceResponse parseFrom(ByteString byteString) {
        return (WorkspaceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static WorkspaceResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (WorkspaceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static WorkspaceResponse parseFrom(byte[] bArr) {
        return (WorkspaceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WorkspaceResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (WorkspaceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static WorkspaceResponse parseFrom(InputStream inputStream) {
        return (WorkspaceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WorkspaceResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WorkspaceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WorkspaceResponse parseFrom(CodedInputStream codedInputStream) {
        return (WorkspaceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static WorkspaceResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WorkspaceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
