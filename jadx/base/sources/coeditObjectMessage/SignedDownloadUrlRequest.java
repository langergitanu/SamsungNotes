package coeditObjectMessage;

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
public final class SignedDownloadUrlRequest extends GeneratedMessageLite<SignedDownloadUrlRequest, Builder> implements SignedDownloadUrlRequestOrBuilder {
    private static final SignedDownloadUrlRequest DEFAULT_INSTANCE;
    public static final int OBJ_ID_FIELD_NUMBER = 1;
    private static volatile Parser<SignedDownloadUrlRequest> PARSER;
    private String objId_ = "";

    /* JADX INFO: renamed from: coeditObjectMessage.SignedDownloadUrlRequest$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42711 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1886xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1886xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1886xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1886xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1886xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1886xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1886xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1886xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<SignedDownloadUrlRequest, Builder> implements SignedDownloadUrlRequestOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearObjId() {
            copyOnWrite();
            ((SignedDownloadUrlRequest) this.instance).clearObjId();
            return this;
        }

        @Override // coeditObjectMessage.SignedDownloadUrlRequestOrBuilder
        public String getObjId() {
            return ((SignedDownloadUrlRequest) this.instance).getObjId();
        }

        @Override // coeditObjectMessage.SignedDownloadUrlRequestOrBuilder
        public ByteString getObjIdBytes() {
            return ((SignedDownloadUrlRequest) this.instance).getObjIdBytes();
        }

        public Builder setObjId(String str) {
            copyOnWrite();
            ((SignedDownloadUrlRequest) this.instance).setObjId(str);
            return this;
        }

        public Builder setObjIdBytes(ByteString byteString) {
            copyOnWrite();
            ((SignedDownloadUrlRequest) this.instance).setObjIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(SignedDownloadUrlRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        SignedDownloadUrlRequest signedDownloadUrlRequest = new SignedDownloadUrlRequest();
        DEFAULT_INSTANCE = signedDownloadUrlRequest;
        GeneratedMessageLite.registerDefaultInstance(SignedDownloadUrlRequest.class, signedDownloadUrlRequest);
    }

    private SignedDownloadUrlRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearObjId() {
        this.objId_ = getDefaultInstance().getObjId();
    }

    public static SignedDownloadUrlRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SignedDownloadUrlRequest parseDelimitedFrom(InputStream inputStream) {
        return (SignedDownloadUrlRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SignedDownloadUrlRequest parseFrom(ByteBuffer byteBuffer) {
        return (SignedDownloadUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SignedDownloadUrlRequest> parser() {
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

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42711.f1886xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new SignedDownloadUrlRequest();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"objId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SignedDownloadUrlRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SignedDownloadUrlRequest.class) {
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

    @Override // coeditObjectMessage.SignedDownloadUrlRequestOrBuilder
    public String getObjId() {
        return this.objId_;
    }

    @Override // coeditObjectMessage.SignedDownloadUrlRequestOrBuilder
    public ByteString getObjIdBytes() {
        return ByteString.copyFromUtf8(this.objId_);
    }

    public static Builder newBuilder(SignedDownloadUrlRequest signedDownloadUrlRequest) {
        return DEFAULT_INSTANCE.createBuilder(signedDownloadUrlRequest);
    }

    public static SignedDownloadUrlRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SignedDownloadUrlRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SignedDownloadUrlRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (SignedDownloadUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SignedDownloadUrlRequest parseFrom(ByteString byteString) {
        return (SignedDownloadUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SignedDownloadUrlRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (SignedDownloadUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SignedDownloadUrlRequest parseFrom(byte[] bArr) {
        return (SignedDownloadUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SignedDownloadUrlRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (SignedDownloadUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SignedDownloadUrlRequest parseFrom(InputStream inputStream) {
        return (SignedDownloadUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SignedDownloadUrlRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SignedDownloadUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SignedDownloadUrlRequest parseFrom(CodedInputStream codedInputStream) {
        return (SignedDownloadUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SignedDownloadUrlRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SignedDownloadUrlRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
