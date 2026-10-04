package coeditObjectMessage;

import coeditObjectMessage.Binary;
import coeditObjectMessage.ResponseResult;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class DownloadStrokeResponse extends GeneratedMessageLite<DownloadStrokeResponse, Builder> implements DownloadStrokeResponseOrBuilder {
    public static final int BINARY_FIELD_NUMBER = 2;
    private static final DownloadStrokeResponse DEFAULT_INSTANCE;
    private static volatile Parser<DownloadStrokeResponse> PARSER = null;
    public static final int RESPONSE_RESULT_FIELD_NUMBER = 1;
    private Binary binary_;
    private ResponseResult responseResult_;

    /* JADX INFO: renamed from: coeditObjectMessage.DownloadStrokeResponse$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42671 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1882xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1882xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1882xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1882xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1882xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1882xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1882xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1882xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<DownloadStrokeResponse, Builder> implements DownloadStrokeResponseOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearBinary() {
            copyOnWrite();
            ((DownloadStrokeResponse) this.instance).clearBinary();
            return this;
        }

        public Builder clearResponseResult() {
            copyOnWrite();
            ((DownloadStrokeResponse) this.instance).clearResponseResult();
            return this;
        }

        @Override // coeditObjectMessage.DownloadStrokeResponseOrBuilder
        public Binary getBinary() {
            return ((DownloadStrokeResponse) this.instance).getBinary();
        }

        @Override // coeditObjectMessage.DownloadStrokeResponseOrBuilder
        public ResponseResult getResponseResult() {
            return ((DownloadStrokeResponse) this.instance).getResponseResult();
        }

        @Override // coeditObjectMessage.DownloadStrokeResponseOrBuilder
        public boolean hasBinary() {
            return ((DownloadStrokeResponse) this.instance).hasBinary();
        }

        @Override // coeditObjectMessage.DownloadStrokeResponseOrBuilder
        public boolean hasResponseResult() {
            return ((DownloadStrokeResponse) this.instance).hasResponseResult();
        }

        public Builder mergeBinary(Binary binary) {
            copyOnWrite();
            ((DownloadStrokeResponse) this.instance).mergeBinary(binary);
            return this;
        }

        public Builder mergeResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((DownloadStrokeResponse) this.instance).mergeResponseResult(responseResult);
            return this;
        }

        public Builder setBinary(Binary binary) {
            copyOnWrite();
            ((DownloadStrokeResponse) this.instance).setBinary(binary);
            return this;
        }

        public Builder setResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((DownloadStrokeResponse) this.instance).setResponseResult(responseResult);
            return this;
        }

        private Builder() {
            super(DownloadStrokeResponse.DEFAULT_INSTANCE);
        }

        public Builder setBinary(Binary.Builder builder) {
            copyOnWrite();
            ((DownloadStrokeResponse) this.instance).setBinary(builder.build());
            return this;
        }

        public Builder setResponseResult(ResponseResult.Builder builder) {
            copyOnWrite();
            ((DownloadStrokeResponse) this.instance).setResponseResult(builder.build());
            return this;
        }
    }

    static {
        DownloadStrokeResponse downloadStrokeResponse = new DownloadStrokeResponse();
        DEFAULT_INSTANCE = downloadStrokeResponse;
        GeneratedMessageLite.registerDefaultInstance(DownloadStrokeResponse.class, downloadStrokeResponse);
    }

    private DownloadStrokeResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBinary() {
        this.binary_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseResult() {
        this.responseResult_ = null;
    }

    public static DownloadStrokeResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeBinary(Binary binary) {
        binary.getClass();
        Binary binary2 = this.binary_;
        if (binary2 == null || binary2 == Binary.getDefaultInstance()) {
            this.binary_ = binary;
        } else {
            this.binary_ = Binary.newBuilder(this.binary_).mergeFrom(binary).buildPartial();
        }
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

    public static DownloadStrokeResponse parseDelimitedFrom(InputStream inputStream) {
        return (DownloadStrokeResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DownloadStrokeResponse parseFrom(ByteBuffer byteBuffer) {
        return (DownloadStrokeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<DownloadStrokeResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBinary(Binary binary) {
        binary.getClass();
        this.binary_ = binary;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseResult(ResponseResult responseResult) {
        responseResult.getClass();
        this.responseResult_ = responseResult;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42671.f1882xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new DownloadStrokeResponse();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"responseResult_", "binary_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DownloadStrokeResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (DownloadStrokeResponse.class) {
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

    @Override // coeditObjectMessage.DownloadStrokeResponseOrBuilder
    public Binary getBinary() {
        Binary binary = this.binary_;
        return binary == null ? Binary.getDefaultInstance() : binary;
    }

    @Override // coeditObjectMessage.DownloadStrokeResponseOrBuilder
    public ResponseResult getResponseResult() {
        ResponseResult responseResult = this.responseResult_;
        return responseResult == null ? ResponseResult.getDefaultInstance() : responseResult;
    }

    @Override // coeditObjectMessage.DownloadStrokeResponseOrBuilder
    public boolean hasBinary() {
        return this.binary_ != null;
    }

    @Override // coeditObjectMessage.DownloadStrokeResponseOrBuilder
    public boolean hasResponseResult() {
        return this.responseResult_ != null;
    }

    public static Builder newBuilder(DownloadStrokeResponse downloadStrokeResponse) {
        return DEFAULT_INSTANCE.createBuilder(downloadStrokeResponse);
    }

    public static DownloadStrokeResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DownloadStrokeResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DownloadStrokeResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DownloadStrokeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DownloadStrokeResponse parseFrom(ByteString byteString) {
        return (DownloadStrokeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static DownloadStrokeResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DownloadStrokeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DownloadStrokeResponse parseFrom(byte[] bArr) {
        return (DownloadStrokeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DownloadStrokeResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (DownloadStrokeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DownloadStrokeResponse parseFrom(InputStream inputStream) {
        return (DownloadStrokeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DownloadStrokeResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DownloadStrokeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DownloadStrokeResponse parseFrom(CodedInputStream codedInputStream) {
        return (DownloadStrokeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DownloadStrokeResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DownloadStrokeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
