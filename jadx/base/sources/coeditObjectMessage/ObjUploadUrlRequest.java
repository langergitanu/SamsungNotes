package coeditObjectMessage;

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
public final class ObjUploadUrlRequest extends GeneratedMessageLite<ObjUploadUrlRequest, Builder> implements ObjUploadUrlRequestOrBuilder {
    public static final int BINARY_INFO_FIELD_NUMBER = 1;
    private static final ObjUploadUrlRequest DEFAULT_INSTANCE;
    private static volatile Parser<ObjUploadUrlRequest> PARSER;
    private BinaryInfo binaryInfo_;

    /* JADX INFO: renamed from: coeditObjectMessage.ObjUploadUrlRequest$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42681 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1883xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1883xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1883xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1883xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1883xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1883xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1883xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1883xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<ObjUploadUrlRequest, Builder> implements ObjUploadUrlRequestOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearBinaryInfo() {
            copyOnWrite();
            ((ObjUploadUrlRequest) this.instance).clearBinaryInfo();
            return this;
        }

        @Override // coeditObjectMessage.ObjUploadUrlRequestOrBuilder
        public BinaryInfo getBinaryInfo() {
            return ((ObjUploadUrlRequest) this.instance).getBinaryInfo();
        }

        @Override // coeditObjectMessage.ObjUploadUrlRequestOrBuilder
        public boolean hasBinaryInfo() {
            return ((ObjUploadUrlRequest) this.instance).hasBinaryInfo();
        }

        public Builder mergeBinaryInfo(BinaryInfo binaryInfo) {
            copyOnWrite();
            ((ObjUploadUrlRequest) this.instance).mergeBinaryInfo(binaryInfo);
            return this;
        }

        public Builder setBinaryInfo(BinaryInfo binaryInfo) {
            copyOnWrite();
            ((ObjUploadUrlRequest) this.instance).setBinaryInfo(binaryInfo);
            return this;
        }

        private Builder() {
            super(ObjUploadUrlRequest.DEFAULT_INSTANCE);
        }

        public Builder setBinaryInfo(BinaryInfo.Builder builder) {
            copyOnWrite();
            ((ObjUploadUrlRequest) this.instance).setBinaryInfo(builder.build());
            return this;
        }
    }

    static {
        ObjUploadUrlRequest objUploadUrlRequest = new ObjUploadUrlRequest();
        DEFAULT_INSTANCE = objUploadUrlRequest;
        GeneratedMessageLite.registerDefaultInstance(ObjUploadUrlRequest.class, objUploadUrlRequest);
    }

    private ObjUploadUrlRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBinaryInfo() {
        this.binaryInfo_ = null;
    }

    public static ObjUploadUrlRequest getDefaultInstance() {
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

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ObjUploadUrlRequest parseDelimitedFrom(InputStream inputStream) {
        return (ObjUploadUrlRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ObjUploadUrlRequest parseFrom(ByteBuffer byteBuffer) {
        return (ObjUploadUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ObjUploadUrlRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBinaryInfo(BinaryInfo binaryInfo) {
        binaryInfo.getClass();
        this.binaryInfo_ = binaryInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42681.f1883xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new ObjUploadUrlRequest();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"binaryInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ObjUploadUrlRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ObjUploadUrlRequest.class) {
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

    @Override // coeditObjectMessage.ObjUploadUrlRequestOrBuilder
    public BinaryInfo getBinaryInfo() {
        BinaryInfo binaryInfo = this.binaryInfo_;
        return binaryInfo == null ? BinaryInfo.getDefaultInstance() : binaryInfo;
    }

    @Override // coeditObjectMessage.ObjUploadUrlRequestOrBuilder
    public boolean hasBinaryInfo() {
        return this.binaryInfo_ != null;
    }

    public static Builder newBuilder(ObjUploadUrlRequest objUploadUrlRequest) {
        return DEFAULT_INSTANCE.createBuilder(objUploadUrlRequest);
    }

    public static ObjUploadUrlRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ObjUploadUrlRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ObjUploadUrlRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ObjUploadUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ObjUploadUrlRequest parseFrom(ByteString byteString) {
        return (ObjUploadUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ObjUploadUrlRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ObjUploadUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ObjUploadUrlRequest parseFrom(byte[] bArr) {
        return (ObjUploadUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ObjUploadUrlRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ObjUploadUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ObjUploadUrlRequest parseFrom(InputStream inputStream) {
        return (ObjUploadUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ObjUploadUrlRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ObjUploadUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ObjUploadUrlRequest parseFrom(CodedInputStream codedInputStream) {
        return (ObjUploadUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ObjUploadUrlRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ObjUploadUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
