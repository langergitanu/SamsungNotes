package coeditCoreMessage;

import coeditCoreMessage.ResponseResult;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class SubmitResponse extends GeneratedMessageLite<SubmitResponse, Builder> implements SubmitResponseOrBuilder {
    public static final int CHECKPOINT_FIELD_NUMBER = 2;
    private static final SubmitResponse DEFAULT_INSTANCE;
    private static volatile Parser<SubmitResponse> PARSER = null;
    public static final int RESPONSE_RESULT_FIELD_NUMBER = 1;
    private long checkpoint_;
    private ResponseResult responseResult_;

    /* JADX INFO: renamed from: coeditCoreMessage.SubmitResponse$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42541 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1878xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1878xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1878xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1878xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1878xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1878xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1878xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1878xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<SubmitResponse, Builder> implements SubmitResponseOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearCheckpoint() {
            copyOnWrite();
            ((SubmitResponse) this.instance).clearCheckpoint();
            return this;
        }

        public Builder clearResponseResult() {
            copyOnWrite();
            ((SubmitResponse) this.instance).clearResponseResult();
            return this;
        }

        @Override // coeditCoreMessage.SubmitResponseOrBuilder
        public long getCheckpoint() {
            return ((SubmitResponse) this.instance).getCheckpoint();
        }

        @Override // coeditCoreMessage.SubmitResponseOrBuilder
        public ResponseResult getResponseResult() {
            return ((SubmitResponse) this.instance).getResponseResult();
        }

        @Override // coeditCoreMessage.SubmitResponseOrBuilder
        public boolean hasResponseResult() {
            return ((SubmitResponse) this.instance).hasResponseResult();
        }

        public Builder mergeResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((SubmitResponse) this.instance).mergeResponseResult(responseResult);
            return this;
        }

        public Builder setCheckpoint(long j) {
            copyOnWrite();
            ((SubmitResponse) this.instance).setCheckpoint(j);
            return this;
        }

        public Builder setResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((SubmitResponse) this.instance).setResponseResult(responseResult);
            return this;
        }

        private Builder() {
            super(SubmitResponse.DEFAULT_INSTANCE);
        }

        public Builder setResponseResult(ResponseResult.Builder builder) {
            copyOnWrite();
            ((SubmitResponse) this.instance).setResponseResult(builder.build());
            return this;
        }
    }

    static {
        SubmitResponse submitResponse = new SubmitResponse();
        DEFAULT_INSTANCE = submitResponse;
        GeneratedMessageLite.registerDefaultInstance(SubmitResponse.class, submitResponse);
    }

    private SubmitResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCheckpoint() {
        this.checkpoint_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseResult() {
        this.responseResult_ = null;
    }

    public static SubmitResponse getDefaultInstance() {
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

    public static SubmitResponse parseDelimitedFrom(InputStream inputStream) {
        return (SubmitResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SubmitResponse parseFrom(ByteBuffer byteBuffer) {
        return (SubmitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SubmitResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckpoint(long j) {
        this.checkpoint_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseResult(ResponseResult responseResult) {
        responseResult.getClass();
        this.responseResult_ = responseResult;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42541.f1878xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new SubmitResponse();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u0002", new Object[]{"responseResult_", "checkpoint_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SubmitResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SubmitResponse.class) {
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

    @Override // coeditCoreMessage.SubmitResponseOrBuilder
    public long getCheckpoint() {
        return this.checkpoint_;
    }

    @Override // coeditCoreMessage.SubmitResponseOrBuilder
    public ResponseResult getResponseResult() {
        ResponseResult responseResult = this.responseResult_;
        return responseResult == null ? ResponseResult.getDefaultInstance() : responseResult;
    }

    @Override // coeditCoreMessage.SubmitResponseOrBuilder
    public boolean hasResponseResult() {
        return this.responseResult_ != null;
    }

    public static Builder newBuilder(SubmitResponse submitResponse) {
        return DEFAULT_INSTANCE.createBuilder(submitResponse);
    }

    public static SubmitResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SubmitResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SubmitResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (SubmitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SubmitResponse parseFrom(ByteString byteString) {
        return (SubmitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SubmitResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (SubmitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SubmitResponse parseFrom(byte[] bArr) {
        return (SubmitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SubmitResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (SubmitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SubmitResponse parseFrom(InputStream inputStream) {
        return (SubmitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SubmitResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SubmitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SubmitResponse parseFrom(CodedInputStream codedInputStream) {
        return (SubmitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SubmitResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SubmitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
