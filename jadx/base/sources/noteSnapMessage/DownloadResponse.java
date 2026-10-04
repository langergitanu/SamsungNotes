package noteSnapMessage;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import noteSnapMessage.Binary;
import noteSnapMessage.BinaryInfo;
import noteSnapMessage.ResponseResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class DownloadResponse extends GeneratedMessageLite<DownloadResponse, Builder> implements DownloadResponseOrBuilder {
    public static final int BINARY_FIELD_NUMBER = 2;
    public static final int BINARY_INFO_FIELD_NUMBER = 1;
    private static final DownloadResponse DEFAULT_INSTANCE;
    private static volatile Parser<DownloadResponse> PARSER = null;
    public static final int RESPONSE_RESULT_FIELD_NUMBER = 3;
    private int requestCase_ = 0;
    private Object request_;

    /* JADX INFO: renamed from: noteSnapMessage.DownloadResponse$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C135611 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f9608xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f9608xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9608xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9608xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9608xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9608xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9608xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9608xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<DownloadResponse, Builder> implements DownloadResponseOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearBinary() {
            copyOnWrite();
            ((DownloadResponse) this.instance).clearBinary();
            return this;
        }

        public Builder clearBinaryInfo() {
            copyOnWrite();
            ((DownloadResponse) this.instance).clearBinaryInfo();
            return this;
        }

        public Builder clearRequest() {
            copyOnWrite();
            ((DownloadResponse) this.instance).clearRequest();
            return this;
        }

        public Builder clearResponseResult() {
            copyOnWrite();
            ((DownloadResponse) this.instance).clearResponseResult();
            return this;
        }

        @Override // noteSnapMessage.DownloadResponseOrBuilder
        public Binary getBinary() {
            return ((DownloadResponse) this.instance).getBinary();
        }

        @Override // noteSnapMessage.DownloadResponseOrBuilder
        public BinaryInfo getBinaryInfo() {
            return ((DownloadResponse) this.instance).getBinaryInfo();
        }

        @Override // noteSnapMessage.DownloadResponseOrBuilder
        public RequestCase getRequestCase() {
            return ((DownloadResponse) this.instance).getRequestCase();
        }

        @Override // noteSnapMessage.DownloadResponseOrBuilder
        public ResponseResult getResponseResult() {
            return ((DownloadResponse) this.instance).getResponseResult();
        }

        @Override // noteSnapMessage.DownloadResponseOrBuilder
        public boolean hasBinary() {
            return ((DownloadResponse) this.instance).hasBinary();
        }

        @Override // noteSnapMessage.DownloadResponseOrBuilder
        public boolean hasBinaryInfo() {
            return ((DownloadResponse) this.instance).hasBinaryInfo();
        }

        @Override // noteSnapMessage.DownloadResponseOrBuilder
        public boolean hasResponseResult() {
            return ((DownloadResponse) this.instance).hasResponseResult();
        }

        public Builder mergeBinary(Binary binary) {
            copyOnWrite();
            ((DownloadResponse) this.instance).mergeBinary(binary);
            return this;
        }

        public Builder mergeBinaryInfo(BinaryInfo binaryInfo) {
            copyOnWrite();
            ((DownloadResponse) this.instance).mergeBinaryInfo(binaryInfo);
            return this;
        }

        public Builder mergeResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((DownloadResponse) this.instance).mergeResponseResult(responseResult);
            return this;
        }

        public Builder setBinary(Binary binary) {
            copyOnWrite();
            ((DownloadResponse) this.instance).setBinary(binary);
            return this;
        }

        public Builder setBinaryInfo(BinaryInfo binaryInfo) {
            copyOnWrite();
            ((DownloadResponse) this.instance).setBinaryInfo(binaryInfo);
            return this;
        }

        public Builder setResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((DownloadResponse) this.instance).setResponseResult(responseResult);
            return this;
        }

        private Builder() {
            super(DownloadResponse.DEFAULT_INSTANCE);
        }

        public Builder setBinary(Binary.Builder builder) {
            copyOnWrite();
            ((DownloadResponse) this.instance).setBinary(builder.build());
            return this;
        }

        public Builder setBinaryInfo(BinaryInfo.Builder builder) {
            copyOnWrite();
            ((DownloadResponse) this.instance).setBinaryInfo(builder.build());
            return this;
        }

        public Builder setResponseResult(ResponseResult.Builder builder) {
            copyOnWrite();
            ((DownloadResponse) this.instance).setResponseResult(builder.build());
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum RequestCase {
        BINARY_INFO(1),
        BINARY(2),
        RESPONSE_RESULT(3),
        REQUEST_NOT_SET(0);

        private final int value;

        RequestCase(int i) {
            this.value = i;
        }

        public static RequestCase forNumber(int i) {
            if (i == 0) {
                return REQUEST_NOT_SET;
            }
            if (i == 1) {
                return BINARY_INFO;
            }
            if (i == 2) {
                return BINARY;
            }
            if (i != 3) {
                return null;
            }
            return RESPONSE_RESULT;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static RequestCase valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        DownloadResponse downloadResponse = new DownloadResponse();
        DEFAULT_INSTANCE = downloadResponse;
        GeneratedMessageLite.registerDefaultInstance(DownloadResponse.class, downloadResponse);
    }

    private DownloadResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBinary() {
        if (this.requestCase_ == 2) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBinaryInfo() {
        if (this.requestCase_ == 1) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequest() {
        this.requestCase_ = 0;
        this.request_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseResult() {
        if (this.requestCase_ == 3) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    public static DownloadResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeBinary(Binary binary) {
        binary.getClass();
        if (this.requestCase_ != 2 || this.request_ == Binary.getDefaultInstance()) {
            this.request_ = binary;
        } else {
            this.request_ = Binary.newBuilder((Binary) this.request_).mergeFrom(binary).buildPartial();
        }
        this.requestCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeBinaryInfo(BinaryInfo binaryInfo) {
        binaryInfo.getClass();
        if (this.requestCase_ != 1 || this.request_ == BinaryInfo.getDefaultInstance()) {
            this.request_ = binaryInfo;
        } else {
            this.request_ = BinaryInfo.newBuilder((BinaryInfo) this.request_).mergeFrom(binaryInfo).buildPartial();
        }
        this.requestCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeResponseResult(ResponseResult responseResult) {
        responseResult.getClass();
        if (this.requestCase_ != 3 || this.request_ == ResponseResult.getDefaultInstance()) {
            this.request_ = responseResult;
        } else {
            this.request_ = ResponseResult.newBuilder((ResponseResult) this.request_).mergeFrom(responseResult).buildPartial();
        }
        this.requestCase_ = 3;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static DownloadResponse parseDelimitedFrom(InputStream inputStream) {
        return (DownloadResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DownloadResponse parseFrom(ByteBuffer byteBuffer) {
        return (DownloadResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<DownloadResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBinary(Binary binary) {
        binary.getClass();
        this.request_ = binary;
        this.requestCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBinaryInfo(BinaryInfo binaryInfo) {
        binaryInfo.getClass();
        this.request_ = binaryInfo;
        this.requestCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseResult(ResponseResult responseResult) {
        responseResult.getClass();
        this.request_ = responseResult;
        this.requestCase_ = 3;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C135611.f9608xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new DownloadResponse();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"request_", "requestCase_", BinaryInfo.class, Binary.class, ResponseResult.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DownloadResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (DownloadResponse.class) {
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

    @Override // noteSnapMessage.DownloadResponseOrBuilder
    public Binary getBinary() {
        return this.requestCase_ == 2 ? (Binary) this.request_ : Binary.getDefaultInstance();
    }

    @Override // noteSnapMessage.DownloadResponseOrBuilder
    public BinaryInfo getBinaryInfo() {
        return this.requestCase_ == 1 ? (BinaryInfo) this.request_ : BinaryInfo.getDefaultInstance();
    }

    @Override // noteSnapMessage.DownloadResponseOrBuilder
    public RequestCase getRequestCase() {
        return RequestCase.forNumber(this.requestCase_);
    }

    @Override // noteSnapMessage.DownloadResponseOrBuilder
    public ResponseResult getResponseResult() {
        return this.requestCase_ == 3 ? (ResponseResult) this.request_ : ResponseResult.getDefaultInstance();
    }

    @Override // noteSnapMessage.DownloadResponseOrBuilder
    public boolean hasBinary() {
        return this.requestCase_ == 2;
    }

    @Override // noteSnapMessage.DownloadResponseOrBuilder
    public boolean hasBinaryInfo() {
        return this.requestCase_ == 1;
    }

    @Override // noteSnapMessage.DownloadResponseOrBuilder
    public boolean hasResponseResult() {
        return this.requestCase_ == 3;
    }

    public static Builder newBuilder(DownloadResponse downloadResponse) {
        return DEFAULT_INSTANCE.createBuilder(downloadResponse);
    }

    public static DownloadResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DownloadResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DownloadResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DownloadResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DownloadResponse parseFrom(ByteString byteString) {
        return (DownloadResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static DownloadResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DownloadResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DownloadResponse parseFrom(byte[] bArr) {
        return (DownloadResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DownloadResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (DownloadResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DownloadResponse parseFrom(InputStream inputStream) {
        return (DownloadResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DownloadResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DownloadResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DownloadResponse parseFrom(CodedInputStream codedInputStream) {
        return (DownloadResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DownloadResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DownloadResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
