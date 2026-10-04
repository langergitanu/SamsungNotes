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
public final class PermissionResponse extends GeneratedMessageLite<PermissionResponse, Builder> implements PermissionResponseOrBuilder {
    private static final PermissionResponse DEFAULT_INSTANCE;
    private static volatile Parser<PermissionResponse> PARSER = null;
    public static final int RESPONSE_RESULT_FIELD_NUMBER = 1;
    private ResponseResult responseResult_;

    /* JADX INFO: renamed from: coeditCoreMessage.PermissionResponse$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42451 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1871xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1871xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1871xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1871xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1871xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1871xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1871xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1871xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<PermissionResponse, Builder> implements PermissionResponseOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearResponseResult() {
            copyOnWrite();
            ((PermissionResponse) this.instance).clearResponseResult();
            return this;
        }

        @Override // coeditCoreMessage.PermissionResponseOrBuilder
        public ResponseResult getResponseResult() {
            return ((PermissionResponse) this.instance).getResponseResult();
        }

        @Override // coeditCoreMessage.PermissionResponseOrBuilder
        public boolean hasResponseResult() {
            return ((PermissionResponse) this.instance).hasResponseResult();
        }

        public Builder mergeResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((PermissionResponse) this.instance).mergeResponseResult(responseResult);
            return this;
        }

        public Builder setResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((PermissionResponse) this.instance).setResponseResult(responseResult);
            return this;
        }

        private Builder() {
            super(PermissionResponse.DEFAULT_INSTANCE);
        }

        public Builder setResponseResult(ResponseResult.Builder builder) {
            copyOnWrite();
            ((PermissionResponse) this.instance).setResponseResult(builder.build());
            return this;
        }
    }

    static {
        PermissionResponse permissionResponse = new PermissionResponse();
        DEFAULT_INSTANCE = permissionResponse;
        GeneratedMessageLite.registerDefaultInstance(PermissionResponse.class, permissionResponse);
    }

    private PermissionResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseResult() {
        this.responseResult_ = null;
    }

    public static PermissionResponse getDefaultInstance() {
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

    public static PermissionResponse parseDelimitedFrom(InputStream inputStream) {
        return (PermissionResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PermissionResponse parseFrom(ByteBuffer byteBuffer) {
        return (PermissionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PermissionResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseResult(ResponseResult responseResult) {
        responseResult.getClass();
        this.responseResult_ = responseResult;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42451.f1871xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new PermissionResponse();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"responseResult_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PermissionResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PermissionResponse.class) {
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

    @Override // coeditCoreMessage.PermissionResponseOrBuilder
    public ResponseResult getResponseResult() {
        ResponseResult responseResult = this.responseResult_;
        return responseResult == null ? ResponseResult.getDefaultInstance() : responseResult;
    }

    @Override // coeditCoreMessage.PermissionResponseOrBuilder
    public boolean hasResponseResult() {
        return this.responseResult_ != null;
    }

    public static Builder newBuilder(PermissionResponse permissionResponse) {
        return DEFAULT_INSTANCE.createBuilder(permissionResponse);
    }

    public static PermissionResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PermissionResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PermissionResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PermissionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PermissionResponse parseFrom(ByteString byteString) {
        return (PermissionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PermissionResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PermissionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PermissionResponse parseFrom(byte[] bArr) {
        return (PermissionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PermissionResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PermissionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PermissionResponse parseFrom(InputStream inputStream) {
        return (PermissionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PermissionResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PermissionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PermissionResponse parseFrom(CodedInputStream codedInputStream) {
        return (PermissionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PermissionResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PermissionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
