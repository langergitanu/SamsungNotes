package coeditObjectMessage;

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
public final class ObjUploadUrlResponse extends GeneratedMessageLite<ObjUploadUrlResponse, Builder> implements ObjUploadUrlResponseOrBuilder {
    private static final ObjUploadUrlResponse DEFAULT_INSTANCE;
    public static final int OBJ_ID_FIELD_NUMBER = 2;
    private static volatile Parser<ObjUploadUrlResponse> PARSER = null;
    public static final int RESPONSE_RESULT_FIELD_NUMBER = 1;
    public static final int UPLOAD_SIGNED_URL_FIELD_NUMBER = 3;
    private ResponseResult responseResult_;
    private String objId_ = "";
    private String uploadSignedUrl_ = "";

    /* JADX INFO: renamed from: coeditObjectMessage.ObjUploadUrlResponse$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42691 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1884xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1884xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1884xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1884xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1884xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1884xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1884xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1884xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<ObjUploadUrlResponse, Builder> implements ObjUploadUrlResponseOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearObjId() {
            copyOnWrite();
            ((ObjUploadUrlResponse) this.instance).clearObjId();
            return this;
        }

        public Builder clearResponseResult() {
            copyOnWrite();
            ((ObjUploadUrlResponse) this.instance).clearResponseResult();
            return this;
        }

        public Builder clearUploadSignedUrl() {
            copyOnWrite();
            ((ObjUploadUrlResponse) this.instance).clearUploadSignedUrl();
            return this;
        }

        @Override // coeditObjectMessage.ObjUploadUrlResponseOrBuilder
        public String getObjId() {
            return ((ObjUploadUrlResponse) this.instance).getObjId();
        }

        @Override // coeditObjectMessage.ObjUploadUrlResponseOrBuilder
        public ByteString getObjIdBytes() {
            return ((ObjUploadUrlResponse) this.instance).getObjIdBytes();
        }

        @Override // coeditObjectMessage.ObjUploadUrlResponseOrBuilder
        public ResponseResult getResponseResult() {
            return ((ObjUploadUrlResponse) this.instance).getResponseResult();
        }

        @Override // coeditObjectMessage.ObjUploadUrlResponseOrBuilder
        public String getUploadSignedUrl() {
            return ((ObjUploadUrlResponse) this.instance).getUploadSignedUrl();
        }

        @Override // coeditObjectMessage.ObjUploadUrlResponseOrBuilder
        public ByteString getUploadSignedUrlBytes() {
            return ((ObjUploadUrlResponse) this.instance).getUploadSignedUrlBytes();
        }

        @Override // coeditObjectMessage.ObjUploadUrlResponseOrBuilder
        public boolean hasResponseResult() {
            return ((ObjUploadUrlResponse) this.instance).hasResponseResult();
        }

        public Builder mergeResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((ObjUploadUrlResponse) this.instance).mergeResponseResult(responseResult);
            return this;
        }

        public Builder setObjId(String str) {
            copyOnWrite();
            ((ObjUploadUrlResponse) this.instance).setObjId(str);
            return this;
        }

        public Builder setObjIdBytes(ByteString byteString) {
            copyOnWrite();
            ((ObjUploadUrlResponse) this.instance).setObjIdBytes(byteString);
            return this;
        }

        public Builder setResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((ObjUploadUrlResponse) this.instance).setResponseResult(responseResult);
            return this;
        }

        public Builder setUploadSignedUrl(String str) {
            copyOnWrite();
            ((ObjUploadUrlResponse) this.instance).setUploadSignedUrl(str);
            return this;
        }

        public Builder setUploadSignedUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((ObjUploadUrlResponse) this.instance).setUploadSignedUrlBytes(byteString);
            return this;
        }

        private Builder() {
            super(ObjUploadUrlResponse.DEFAULT_INSTANCE);
        }

        public Builder setResponseResult(ResponseResult.Builder builder) {
            copyOnWrite();
            ((ObjUploadUrlResponse) this.instance).setResponseResult(builder.build());
            return this;
        }
    }

    static {
        ObjUploadUrlResponse objUploadUrlResponse = new ObjUploadUrlResponse();
        DEFAULT_INSTANCE = objUploadUrlResponse;
        GeneratedMessageLite.registerDefaultInstance(ObjUploadUrlResponse.class, objUploadUrlResponse);
    }

    private ObjUploadUrlResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearObjId() {
        this.objId_ = getDefaultInstance().getObjId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseResult() {
        this.responseResult_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUploadSignedUrl() {
        this.uploadSignedUrl_ = getDefaultInstance().getUploadSignedUrl();
    }

    public static ObjUploadUrlResponse getDefaultInstance() {
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

    public static ObjUploadUrlResponse parseDelimitedFrom(InputStream inputStream) {
        return (ObjUploadUrlResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ObjUploadUrlResponse parseFrom(ByteBuffer byteBuffer) {
        return (ObjUploadUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ObjUploadUrlResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setObjId(String str) {
        str.getClass();
        this.objId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setObjIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.objId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseResult(ResponseResult responseResult) {
        responseResult.getClass();
        this.responseResult_ = responseResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUploadSignedUrl(String str) {
        str.getClass();
        this.uploadSignedUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUploadSignedUrlBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.uploadSignedUrl_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42691.f1884xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new ObjUploadUrlResponse();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002Ȉ\u0003Ȉ", new Object[]{"responseResult_", "objId_", "uploadSignedUrl_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ObjUploadUrlResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ObjUploadUrlResponse.class) {
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

    @Override // coeditObjectMessage.ObjUploadUrlResponseOrBuilder
    public String getObjId() {
        return this.objId_;
    }

    @Override // coeditObjectMessage.ObjUploadUrlResponseOrBuilder
    public ByteString getObjIdBytes() {
        return ByteString.copyFromUtf8(this.objId_);
    }

    @Override // coeditObjectMessage.ObjUploadUrlResponseOrBuilder
    public ResponseResult getResponseResult() {
        ResponseResult responseResult = this.responseResult_;
        return responseResult == null ? ResponseResult.getDefaultInstance() : responseResult;
    }

    @Override // coeditObjectMessage.ObjUploadUrlResponseOrBuilder
    public String getUploadSignedUrl() {
        return this.uploadSignedUrl_;
    }

    @Override // coeditObjectMessage.ObjUploadUrlResponseOrBuilder
    public ByteString getUploadSignedUrlBytes() {
        return ByteString.copyFromUtf8(this.uploadSignedUrl_);
    }

    @Override // coeditObjectMessage.ObjUploadUrlResponseOrBuilder
    public boolean hasResponseResult() {
        return this.responseResult_ != null;
    }

    public static Builder newBuilder(ObjUploadUrlResponse objUploadUrlResponse) {
        return DEFAULT_INSTANCE.createBuilder(objUploadUrlResponse);
    }

    public static ObjUploadUrlResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ObjUploadUrlResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ObjUploadUrlResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ObjUploadUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ObjUploadUrlResponse parseFrom(ByteString byteString) {
        return (ObjUploadUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ObjUploadUrlResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ObjUploadUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ObjUploadUrlResponse parseFrom(byte[] bArr) {
        return (ObjUploadUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ObjUploadUrlResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ObjUploadUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ObjUploadUrlResponse parseFrom(InputStream inputStream) {
        return (ObjUploadUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ObjUploadUrlResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ObjUploadUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ObjUploadUrlResponse parseFrom(CodedInputStream codedInputStream) {
        return (ObjUploadUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ObjUploadUrlResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ObjUploadUrlResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
