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
public final class DownloadStrokeRequest extends GeneratedMessageLite<DownloadStrokeRequest, Builder> implements DownloadStrokeRequestOrBuilder {
    private static final DownloadStrokeRequest DEFAULT_INSTANCE;
    public static final int OBJ_ID_FIELD_NUMBER = 1;
    private static volatile Parser<DownloadStrokeRequest> PARSER;
    private String objId_ = "";

    /* JADX INFO: renamed from: coeditObjectMessage.DownloadStrokeRequest$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42661 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1881xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1881xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1881xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1881xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1881xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1881xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1881xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1881xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<DownloadStrokeRequest, Builder> implements DownloadStrokeRequestOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearObjId() {
            copyOnWrite();
            ((DownloadStrokeRequest) this.instance).clearObjId();
            return this;
        }

        @Override // coeditObjectMessage.DownloadStrokeRequestOrBuilder
        public String getObjId() {
            return ((DownloadStrokeRequest) this.instance).getObjId();
        }

        @Override // coeditObjectMessage.DownloadStrokeRequestOrBuilder
        public ByteString getObjIdBytes() {
            return ((DownloadStrokeRequest) this.instance).getObjIdBytes();
        }

        public Builder setObjId(String str) {
            copyOnWrite();
            ((DownloadStrokeRequest) this.instance).setObjId(str);
            return this;
        }

        public Builder setObjIdBytes(ByteString byteString) {
            copyOnWrite();
            ((DownloadStrokeRequest) this.instance).setObjIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(DownloadStrokeRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        DownloadStrokeRequest downloadStrokeRequest = new DownloadStrokeRequest();
        DEFAULT_INSTANCE = downloadStrokeRequest;
        GeneratedMessageLite.registerDefaultInstance(DownloadStrokeRequest.class, downloadStrokeRequest);
    }

    private DownloadStrokeRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearObjId() {
        this.objId_ = getDefaultInstance().getObjId();
    }

    public static DownloadStrokeRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static DownloadStrokeRequest parseDelimitedFrom(InputStream inputStream) {
        return (DownloadStrokeRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DownloadStrokeRequest parseFrom(ByteBuffer byteBuffer) {
        return (DownloadStrokeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<DownloadStrokeRequest> parser() {
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
        switch (C42661.f1881xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new DownloadStrokeRequest();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"objId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DownloadStrokeRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (DownloadStrokeRequest.class) {
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

    @Override // coeditObjectMessage.DownloadStrokeRequestOrBuilder
    public String getObjId() {
        return this.objId_;
    }

    @Override // coeditObjectMessage.DownloadStrokeRequestOrBuilder
    public ByteString getObjIdBytes() {
        return ByteString.copyFromUtf8(this.objId_);
    }

    public static Builder newBuilder(DownloadStrokeRequest downloadStrokeRequest) {
        return DEFAULT_INSTANCE.createBuilder(downloadStrokeRequest);
    }

    public static DownloadStrokeRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DownloadStrokeRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DownloadStrokeRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DownloadStrokeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DownloadStrokeRequest parseFrom(ByteString byteString) {
        return (DownloadStrokeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static DownloadStrokeRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DownloadStrokeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DownloadStrokeRequest parseFrom(byte[] bArr) {
        return (DownloadStrokeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DownloadStrokeRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (DownloadStrokeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DownloadStrokeRequest parseFrom(InputStream inputStream) {
        return (DownloadStrokeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DownloadStrokeRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DownloadStrokeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DownloadStrokeRequest parseFrom(CodedInputStream codedInputStream) {
        return (DownloadStrokeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DownloadStrokeRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DownloadStrokeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
