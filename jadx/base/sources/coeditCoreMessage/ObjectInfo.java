package coeditCoreMessage;

import coeditCoreMessage.BinaryInfo;
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
public final class ObjectInfo extends GeneratedMessageLite<ObjectInfo, Builder> implements ObjectInfoOrBuilder {
    public static final int BINARY_INFO_FIELD_NUMBER = 2;
    private static final ObjectInfo DEFAULT_INSTANCE;
    public static final int DOWNLOAD_SIGNED_URL_FIELD_NUMBER = 3;
    public static final int OBJ_ID_FIELD_NUMBER = 1;
    private static volatile Parser<ObjectInfo> PARSER;
    private BinaryInfo binaryInfo_;
    private String objId_ = "";
    private String downloadSignedUrl_ = "";

    /* JADX INFO: renamed from: coeditCoreMessage.ObjectInfo$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42431 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1869xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1869xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1869xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1869xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1869xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1869xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1869xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1869xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<ObjectInfo, Builder> implements ObjectInfoOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearBinaryInfo() {
            copyOnWrite();
            ((ObjectInfo) this.instance).clearBinaryInfo();
            return this;
        }

        public Builder clearDownloadSignedUrl() {
            copyOnWrite();
            ((ObjectInfo) this.instance).clearDownloadSignedUrl();
            return this;
        }

        public Builder clearObjId() {
            copyOnWrite();
            ((ObjectInfo) this.instance).clearObjId();
            return this;
        }

        @Override // coeditCoreMessage.ObjectInfoOrBuilder
        public BinaryInfo getBinaryInfo() {
            return ((ObjectInfo) this.instance).getBinaryInfo();
        }

        @Override // coeditCoreMessage.ObjectInfoOrBuilder
        public String getDownloadSignedUrl() {
            return ((ObjectInfo) this.instance).getDownloadSignedUrl();
        }

        @Override // coeditCoreMessage.ObjectInfoOrBuilder
        public ByteString getDownloadSignedUrlBytes() {
            return ((ObjectInfo) this.instance).getDownloadSignedUrlBytes();
        }

        @Override // coeditCoreMessage.ObjectInfoOrBuilder
        public String getObjId() {
            return ((ObjectInfo) this.instance).getObjId();
        }

        @Override // coeditCoreMessage.ObjectInfoOrBuilder
        public ByteString getObjIdBytes() {
            return ((ObjectInfo) this.instance).getObjIdBytes();
        }

        @Override // coeditCoreMessage.ObjectInfoOrBuilder
        public boolean hasBinaryInfo() {
            return ((ObjectInfo) this.instance).hasBinaryInfo();
        }

        public Builder mergeBinaryInfo(BinaryInfo binaryInfo) {
            copyOnWrite();
            ((ObjectInfo) this.instance).mergeBinaryInfo(binaryInfo);
            return this;
        }

        public Builder setBinaryInfo(BinaryInfo binaryInfo) {
            copyOnWrite();
            ((ObjectInfo) this.instance).setBinaryInfo(binaryInfo);
            return this;
        }

        public Builder setDownloadSignedUrl(String str) {
            copyOnWrite();
            ((ObjectInfo) this.instance).setDownloadSignedUrl(str);
            return this;
        }

        public Builder setDownloadSignedUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((ObjectInfo) this.instance).setDownloadSignedUrlBytes(byteString);
            return this;
        }

        public Builder setObjId(String str) {
            copyOnWrite();
            ((ObjectInfo) this.instance).setObjId(str);
            return this;
        }

        public Builder setObjIdBytes(ByteString byteString) {
            copyOnWrite();
            ((ObjectInfo) this.instance).setObjIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(ObjectInfo.DEFAULT_INSTANCE);
        }

        public Builder setBinaryInfo(BinaryInfo.Builder builder) {
            copyOnWrite();
            ((ObjectInfo) this.instance).setBinaryInfo(builder.build());
            return this;
        }
    }

    static {
        ObjectInfo objectInfo = new ObjectInfo();
        DEFAULT_INSTANCE = objectInfo;
        GeneratedMessageLite.registerDefaultInstance(ObjectInfo.class, objectInfo);
    }

    private ObjectInfo() {
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
    public void clearObjId() {
        this.objId_ = getDefaultInstance().getObjId();
    }

    public static ObjectInfo getDefaultInstance() {
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

    public static ObjectInfo parseDelimitedFrom(InputStream inputStream) {
        return (ObjectInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ObjectInfo parseFrom(ByteBuffer byteBuffer) {
        return (ObjectInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ObjectInfo> parser() {
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
        switch (C42431.f1869xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new ObjectInfo();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\t\u0003Ȉ", new Object[]{"objId_", "binaryInfo_", "downloadSignedUrl_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ObjectInfo> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ObjectInfo.class) {
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

    @Override // coeditCoreMessage.ObjectInfoOrBuilder
    public BinaryInfo getBinaryInfo() {
        BinaryInfo binaryInfo = this.binaryInfo_;
        return binaryInfo == null ? BinaryInfo.getDefaultInstance() : binaryInfo;
    }

    @Override // coeditCoreMessage.ObjectInfoOrBuilder
    public String getDownloadSignedUrl() {
        return this.downloadSignedUrl_;
    }

    @Override // coeditCoreMessage.ObjectInfoOrBuilder
    public ByteString getDownloadSignedUrlBytes() {
        return ByteString.copyFromUtf8(this.downloadSignedUrl_);
    }

    @Override // coeditCoreMessage.ObjectInfoOrBuilder
    public String getObjId() {
        return this.objId_;
    }

    @Override // coeditCoreMessage.ObjectInfoOrBuilder
    public ByteString getObjIdBytes() {
        return ByteString.copyFromUtf8(this.objId_);
    }

    @Override // coeditCoreMessage.ObjectInfoOrBuilder
    public boolean hasBinaryInfo() {
        return this.binaryInfo_ != null;
    }

    public static Builder newBuilder(ObjectInfo objectInfo) {
        return DEFAULT_INSTANCE.createBuilder(objectInfo);
    }

    public static ObjectInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ObjectInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ObjectInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ObjectInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ObjectInfo parseFrom(ByteString byteString) {
        return (ObjectInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ObjectInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ObjectInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ObjectInfo parseFrom(byte[] bArr) {
        return (ObjectInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ObjectInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ObjectInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ObjectInfo parseFrom(InputStream inputStream) {
        return (ObjectInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ObjectInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ObjectInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ObjectInfo parseFrom(CodedInputStream codedInputStream) {
        return (ObjectInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ObjectInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ObjectInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
