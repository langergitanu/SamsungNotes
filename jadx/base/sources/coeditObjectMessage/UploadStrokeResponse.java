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
public final class UploadStrokeResponse extends GeneratedMessageLite<UploadStrokeResponse, Builder> implements UploadStrokeResponseOrBuilder {
    private static final UploadStrokeResponse DEFAULT_INSTANCE;
    public static final int OBJ_ID_FIELD_NUMBER = 2;
    private static volatile Parser<UploadStrokeResponse> PARSER = null;
    public static final int RESPONSE_RESULT_FIELD_NUMBER = 1;
    private String objId_ = "";
    private ResponseResult responseResult_;

    /* JADX INFO: renamed from: coeditObjectMessage.UploadStrokeResponse$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42741 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1889xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1889xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1889xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1889xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1889xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1889xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1889xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1889xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<UploadStrokeResponse, Builder> implements UploadStrokeResponseOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearObjId() {
            copyOnWrite();
            ((UploadStrokeResponse) this.instance).clearObjId();
            return this;
        }

        public Builder clearResponseResult() {
            copyOnWrite();
            ((UploadStrokeResponse) this.instance).clearResponseResult();
            return this;
        }

        @Override // coeditObjectMessage.UploadStrokeResponseOrBuilder
        public String getObjId() {
            return ((UploadStrokeResponse) this.instance).getObjId();
        }

        @Override // coeditObjectMessage.UploadStrokeResponseOrBuilder
        public ByteString getObjIdBytes() {
            return ((UploadStrokeResponse) this.instance).getObjIdBytes();
        }

        @Override // coeditObjectMessage.UploadStrokeResponseOrBuilder
        public ResponseResult getResponseResult() {
            return ((UploadStrokeResponse) this.instance).getResponseResult();
        }

        @Override // coeditObjectMessage.UploadStrokeResponseOrBuilder
        public boolean hasResponseResult() {
            return ((UploadStrokeResponse) this.instance).hasResponseResult();
        }

        public Builder mergeResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((UploadStrokeResponse) this.instance).mergeResponseResult(responseResult);
            return this;
        }

        public Builder setObjId(String str) {
            copyOnWrite();
            ((UploadStrokeResponse) this.instance).setObjId(str);
            return this;
        }

        public Builder setObjIdBytes(ByteString byteString) {
            copyOnWrite();
            ((UploadStrokeResponse) this.instance).setObjIdBytes(byteString);
            return this;
        }

        public Builder setResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((UploadStrokeResponse) this.instance).setResponseResult(responseResult);
            return this;
        }

        private Builder() {
            super(UploadStrokeResponse.DEFAULT_INSTANCE);
        }

        public Builder setResponseResult(ResponseResult.Builder builder) {
            copyOnWrite();
            ((UploadStrokeResponse) this.instance).setResponseResult(builder.build());
            return this;
        }
    }

    static {
        UploadStrokeResponse uploadStrokeResponse = new UploadStrokeResponse();
        DEFAULT_INSTANCE = uploadStrokeResponse;
        GeneratedMessageLite.registerDefaultInstance(UploadStrokeResponse.class, uploadStrokeResponse);
    }

    private UploadStrokeResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearObjId() {
        this.objId_ = getDefaultInstance().getObjId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseResult() {
        this.responseResult_ = null;
    }

    public static UploadStrokeResponse getDefaultInstance() {
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

    public static UploadStrokeResponse parseDelimitedFrom(InputStream inputStream) {
        return (UploadStrokeResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UploadStrokeResponse parseFrom(ByteBuffer byteBuffer) {
        return (UploadStrokeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<UploadStrokeResponse> parser() {
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

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42741.f1889xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new UploadStrokeResponse();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002Ȉ", new Object[]{"responseResult_", "objId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<UploadStrokeResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (UploadStrokeResponse.class) {
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

    @Override // coeditObjectMessage.UploadStrokeResponseOrBuilder
    public String getObjId() {
        return this.objId_;
    }

    @Override // coeditObjectMessage.UploadStrokeResponseOrBuilder
    public ByteString getObjIdBytes() {
        return ByteString.copyFromUtf8(this.objId_);
    }

    @Override // coeditObjectMessage.UploadStrokeResponseOrBuilder
    public ResponseResult getResponseResult() {
        ResponseResult responseResult = this.responseResult_;
        return responseResult == null ? ResponseResult.getDefaultInstance() : responseResult;
    }

    @Override // coeditObjectMessage.UploadStrokeResponseOrBuilder
    public boolean hasResponseResult() {
        return this.responseResult_ != null;
    }

    public static Builder newBuilder(UploadStrokeResponse uploadStrokeResponse) {
        return DEFAULT_INSTANCE.createBuilder(uploadStrokeResponse);
    }

    public static UploadStrokeResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UploadStrokeResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UploadStrokeResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (UploadStrokeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static UploadStrokeResponse parseFrom(ByteString byteString) {
        return (UploadStrokeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static UploadStrokeResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (UploadStrokeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static UploadStrokeResponse parseFrom(byte[] bArr) {
        return (UploadStrokeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UploadStrokeResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (UploadStrokeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static UploadStrokeResponse parseFrom(InputStream inputStream) {
        return (UploadStrokeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UploadStrokeResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UploadStrokeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UploadStrokeResponse parseFrom(CodedInputStream codedInputStream) {
        return (UploadStrokeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static UploadStrokeResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UploadStrokeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
