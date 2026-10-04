package coeditObjectMessage;

import coeditObjectMessage.Binary;
import coeditObjectMessage.BinaryInfo;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class UploadStrokeRequest extends GeneratedMessageLite<UploadStrokeRequest, Builder> implements UploadStrokeRequestOrBuilder {
    public static final int BINARY_FIELD_NUMBER = 2;
    public static final int BINARY_INFO_FIELD_NUMBER = 1;
    private static final UploadStrokeRequest DEFAULT_INSTANCE;
    private static volatile Parser<UploadStrokeRequest> PARSER;
    private int requestCase_ = 0;
    private Object request_;

    /* JADX INFO: renamed from: coeditObjectMessage.UploadStrokeRequest$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42731 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1888xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1888xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1888xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1888xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1888xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1888xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1888xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1888xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<UploadStrokeRequest, Builder> implements UploadStrokeRequestOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearBinary() {
            copyOnWrite();
            ((UploadStrokeRequest) this.instance).clearBinary();
            return this;
        }

        public Builder clearBinaryInfo() {
            copyOnWrite();
            ((UploadStrokeRequest) this.instance).clearBinaryInfo();
            return this;
        }

        public Builder clearRequest() {
            copyOnWrite();
            ((UploadStrokeRequest) this.instance).clearRequest();
            return this;
        }

        @Override // coeditObjectMessage.UploadStrokeRequestOrBuilder
        public Binary getBinary() {
            return ((UploadStrokeRequest) this.instance).getBinary();
        }

        @Override // coeditObjectMessage.UploadStrokeRequestOrBuilder
        public BinaryInfo getBinaryInfo() {
            return ((UploadStrokeRequest) this.instance).getBinaryInfo();
        }

        @Override // coeditObjectMessage.UploadStrokeRequestOrBuilder
        public RequestCase getRequestCase() {
            return ((UploadStrokeRequest) this.instance).getRequestCase();
        }

        @Override // coeditObjectMessage.UploadStrokeRequestOrBuilder
        public boolean hasBinary() {
            return ((UploadStrokeRequest) this.instance).hasBinary();
        }

        @Override // coeditObjectMessage.UploadStrokeRequestOrBuilder
        public boolean hasBinaryInfo() {
            return ((UploadStrokeRequest) this.instance).hasBinaryInfo();
        }

        public Builder mergeBinary(Binary binary) {
            copyOnWrite();
            ((UploadStrokeRequest) this.instance).mergeBinary(binary);
            return this;
        }

        public Builder mergeBinaryInfo(BinaryInfo binaryInfo) {
            copyOnWrite();
            ((UploadStrokeRequest) this.instance).mergeBinaryInfo(binaryInfo);
            return this;
        }

        public Builder setBinary(Binary binary) {
            copyOnWrite();
            ((UploadStrokeRequest) this.instance).setBinary(binary);
            return this;
        }

        public Builder setBinaryInfo(BinaryInfo binaryInfo) {
            copyOnWrite();
            ((UploadStrokeRequest) this.instance).setBinaryInfo(binaryInfo);
            return this;
        }

        private Builder() {
            super(UploadStrokeRequest.DEFAULT_INSTANCE);
        }

        public Builder setBinary(Binary.Builder builder) {
            copyOnWrite();
            ((UploadStrokeRequest) this.instance).setBinary(builder.build());
            return this;
        }

        public Builder setBinaryInfo(BinaryInfo.Builder builder) {
            copyOnWrite();
            ((UploadStrokeRequest) this.instance).setBinaryInfo(builder.build());
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum RequestCase {
        BINARY_INFO(1),
        BINARY(2),
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
            if (i != 2) {
                return null;
            }
            return BINARY;
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
        UploadStrokeRequest uploadStrokeRequest = new UploadStrokeRequest();
        DEFAULT_INSTANCE = uploadStrokeRequest;
        GeneratedMessageLite.registerDefaultInstance(UploadStrokeRequest.class, uploadStrokeRequest);
    }

    private UploadStrokeRequest() {
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

    public static UploadStrokeRequest getDefaultInstance() {
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

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static UploadStrokeRequest parseDelimitedFrom(InputStream inputStream) {
        return (UploadStrokeRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UploadStrokeRequest parseFrom(ByteBuffer byteBuffer) {
        return (UploadStrokeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<UploadStrokeRequest> parser() {
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

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42731.f1888xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new UploadStrokeRequest();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"request_", "requestCase_", BinaryInfo.class, Binary.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<UploadStrokeRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (UploadStrokeRequest.class) {
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

    @Override // coeditObjectMessage.UploadStrokeRequestOrBuilder
    public Binary getBinary() {
        return this.requestCase_ == 2 ? (Binary) this.request_ : Binary.getDefaultInstance();
    }

    @Override // coeditObjectMessage.UploadStrokeRequestOrBuilder
    public BinaryInfo getBinaryInfo() {
        return this.requestCase_ == 1 ? (BinaryInfo) this.request_ : BinaryInfo.getDefaultInstance();
    }

    @Override // coeditObjectMessage.UploadStrokeRequestOrBuilder
    public RequestCase getRequestCase() {
        return RequestCase.forNumber(this.requestCase_);
    }

    @Override // coeditObjectMessage.UploadStrokeRequestOrBuilder
    public boolean hasBinary() {
        return this.requestCase_ == 2;
    }

    @Override // coeditObjectMessage.UploadStrokeRequestOrBuilder
    public boolean hasBinaryInfo() {
        return this.requestCase_ == 1;
    }

    public static Builder newBuilder(UploadStrokeRequest uploadStrokeRequest) {
        return DEFAULT_INSTANCE.createBuilder(uploadStrokeRequest);
    }

    public static UploadStrokeRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UploadStrokeRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UploadStrokeRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (UploadStrokeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static UploadStrokeRequest parseFrom(ByteString byteString) {
        return (UploadStrokeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static UploadStrokeRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (UploadStrokeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static UploadStrokeRequest parseFrom(byte[] bArr) {
        return (UploadStrokeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UploadStrokeRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (UploadStrokeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static UploadStrokeRequest parseFrom(InputStream inputStream) {
        return (UploadStrokeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UploadStrokeRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UploadStrokeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UploadStrokeRequest parseFrom(CodedInputStream codedInputStream) {
        return (UploadStrokeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static UploadStrokeRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UploadStrokeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
