package coeditObjectMessage;

import coeditObjectMessage.BinaryInfo;
import coeditObjectMessage.ResponseResult;
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
public final class SignedDownloadUrlResponse extends GeneratedMessageLite<SignedDownloadUrlResponse, Builder> implements SignedDownloadUrlResponseOrBuilder {
    public static final int BINARY_INFO_FIELD_NUMBER = 2;
    private static final SignedDownloadUrlResponse DEFAULT_INSTANCE;
    public static final int DOWNLOAD_SIGNED_URL_FIELD_NUMBER = 3;
    private static volatile Parser<SignedDownloadUrlResponse> PARSER = null;
    public static final int RESPONSE_RESULT_FIELD_NUMBER = 1;
    private BinaryInfo binaryInfo_;
    private String downloadSignedUrl_ = "";
    private ResponseResult responseResult_;

    /* JADX INFO: renamed from: coeditObjectMessage.SignedDownloadUrlResponse$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42721 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1887xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1887xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1887xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1887xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1887xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1887xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1887xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1887xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<SignedDownloadUrlResponse, Builder> implements SignedDownloadUrlResponseOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearBinaryInfo() {
            copyOnWrite();
            ((SignedDownloadUrlResponse) this.instance).clearBinaryInfo();
            return this;
        }

        public Builder clearDownloadSignedUrl() {
            copyOnWrite();
            ((SignedDownloadUrlResponse) this.instance).clearDownloadSignedUrl();
            return this;
        }

        public Builder clearResponseResult() {
            copyOnWrite();
            ((SignedDownloadUrlResponse) this.instance).clearResponseResult();
            return this;
        }

        @Override // coeditObjectMessage.SignedDownloadUrlResponseOrBuilder
        public BinaryInfo getBinaryInfo() {
            return ((SignedDownloadUrlResponse) this.instance).getBinaryInfo();
        }

        @Override // coeditObjectMessage.SignedDownloadUrlResponseOrBuilder
        public String getDownloadSignedUrl() {
            return ((SignedDownloadUrlResponse) this.instance).getDownloadSignedUrl();
        }

        @Override // coeditObjectMessage.SignedDownloadUrlResponseOrBuilder
        public ByteString getDownloadSignedUrlBytes() {
            return ((SignedDownloadUrlResponse) this.instance).getDownloadSignedUrlBytes();
        }

        @Override // coeditObjectMessage.SignedDownloadUrlResponseOrBuilder
        public ResponseResult getResponseResult() {
            return ((SignedDownloadUrlResponse) this.instance).getResponseResult();
        }

        @Override // coeditObjectMessage.SignedDownloadUrlResponseOrBuilder
        public boolean hasBinaryInfo() {
            return ((SignedDownloadUrlResponse) this.instance).hasBinaryInfo();
        }

        @Override // coeditObjectMessage.SignedDownloadUrlResponseOrBuilder
        public boolean hasResponseResult() {
            return ((SignedDownloadUrlResponse) this.instance).hasResponseResult();
        }

        public Builder mergeBinaryInfo(BinaryInfo binaryInfo) {
            copyOnWrite();
            ((SignedDownloadUrlResponse) this.instance).mergeBinaryInfo(binaryInfo);
            return this;
        }

        public Builder mergeResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((SignedDownloadUrlResponse) this.instance).mergeResponseResult(responseResult);
            return this;
        }

        public Builder setBinaryInfo(BinaryInfo binaryInfo) {
            copyOnWrite();
            ((SignedDownloadUrlResponse) this.instance).setBinaryInfo(binaryInfo);
            return this;
        }

        public Builder setDownloadSignedUrl(String str) {
            copyOnWrite();
            ((SignedDownloadUrlResponse) this.instance).setDownloadSignedUrl(str);
            return this;
        }

        public Builder setDownloadSignedUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((SignedDownloadUrlResponse) this.instance).setDownloadSignedUrlBytes(byteString);
            return this;
        }

        public Builder setResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((SignedDownloadUrlResponse) this.instance).setResponseResult(responseResult);
            return this;
        }

        private Builder() {
            super(SignedDownloadUrlResponse.DEFAULT_INSTANCE);
        }

        public Builder setBinaryInfo(BinaryInfo.Builder builder) {
            copyOnWrite();
            ((SignedDownloadUrlResponse) this.instance).setBinaryInfo(builder.build());
            return this;
        }

        public Builder setResponseResult(ResponseResult.Builder builder) {
            copyOnWrite();
            ((SignedDownloadUrlResponse) this.instance).setResponseResult(builder.build());
            return this;
        }
    }

    static {
        SignedDownloadUrlResponse signedDownloadUrlResponse = new SignedDownloadUrlResponse();
        DEFAULT_INSTANCE = signedDownloadUrlResponse;
        GeneratedMessageLite.registerDefaultInstance(SignedDownloadUrlResponse.class, signedDownloadUrlResponse);
    }

    private SignedDownloadUrlResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBinaryInfo() {
        this.binaryInfo_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDownloadSignedUrl() {
        this.downloadSignedUrl_ = getDefaultInstance().getDownloadSignedUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseResult() {
        this.responseResult_ = null;
    }

    public static SignedDownloadUrlResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeBinaryInfo(BinaryInfo binaryInfo) {
        binaryInfo.getClass();
        BinaryInfo binaryInfo2 = this.binaryInfo_;
        if (binaryInfo2 == null || binaryInfo2 == BinaryInfo.getDefaultInstance()) {
            this.binaryInfo_ = binaryInfo;
        } else {
            this.binaryInfo_ = BinaryInfo.newBuilder(this.binaryInfo_).mergeFrom(binaryInfo).buildPartial();
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

    public static SignedDownloadUrlResponse parseDelimitedFrom(InputStream inputStream) {
        return (SignedDownloadUrlResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SignedDownloadUrlResponse parseFrom(ByteBuffer byteBuffer) {
        return (SignedDownloadUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SignedDownloadUrlResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBinaryInfo(BinaryInfo binaryInfo) {
        binaryInfo.getClass();
        this.binaryInfo_ = binaryInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDownloadSignedUrl(String str) {
        str.getClass();
        this.downloadSignedUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDownloadSignedUrlBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.downloadSignedUrl_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseResult(ResponseResult responseResult) {
        responseResult.getClass();
        this.responseResult_ = responseResult;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42721.f1887xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new SignedDownloadUrlResponse();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003Ȉ", new Object[]{"responseResult_", "binaryInfo_", "downloadSignedUrl_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SignedDownloadUrlResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SignedDownloadUrlResponse.class) {
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

    @Override // coeditObjectMessage.SignedDownloadUrlResponseOrBuilder
    public BinaryInfo getBinaryInfo() {
        BinaryInfo binaryInfo = this.binaryInfo_;
        return binaryInfo == null ? BinaryInfo.getDefaultInstance() : binaryInfo;
    }

    @Override // coeditObjectMessage.SignedDownloadUrlResponseOrBuilder
    public String getDownloadSignedUrl() {
        return this.downloadSignedUrl_;
    }

    @Override // coeditObjectMessage.SignedDownloadUrlResponseOrBuilder
    public ByteString getDownloadSignedUrlBytes() {
        return ByteString.copyFromUtf8(this.downloadSignedUrl_);
    }

    @Override // coeditObjectMessage.SignedDownloadUrlResponseOrBuilder
    public ResponseResult getResponseResult() {
        ResponseResult responseResult = this.responseResult_;
        return responseResult == null ? ResponseResult.getDefaultInstance() : responseResult;
    }

    @Override // coeditObjectMessage.SignedDownloadUrlResponseOrBuilder
    public boolean hasBinaryInfo() {
        return this.binaryInfo_ != null;
    }

    @Override // coeditObjectMessage.SignedDownloadUrlResponseOrBuilder
    public boolean hasResponseResult() {
        return this.responseResult_ != null;
    }

    public static Builder newBuilder(SignedDownloadUrlResponse signedDownloadUrlResponse) {
        return DEFAULT_INSTANCE.createBuilder(signedDownloadUrlResponse);
    }

    public static SignedDownloadUrlResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SignedDownloadUrlResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SignedDownloadUrlResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (SignedDownloadUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SignedDownloadUrlResponse parseFrom(ByteString byteString) {
        return (SignedDownloadUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SignedDownloadUrlResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (SignedDownloadUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SignedDownloadUrlResponse parseFrom(byte[] bArr) {
        return (SignedDownloadUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SignedDownloadUrlResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (SignedDownloadUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SignedDownloadUrlResponse parseFrom(InputStream inputStream) {
        return (SignedDownloadUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SignedDownloadUrlResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SignedDownloadUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SignedDownloadUrlResponse parseFrom(CodedInputStream codedInputStream) {
        return (SignedDownloadUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SignedDownloadUrlResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SignedDownloadUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
