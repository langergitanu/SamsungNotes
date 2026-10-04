package coeditCoreMessage;

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
public final class BinaryInfo extends GeneratedMessageLite<BinaryInfo, Builder> implements BinaryInfoOrBuilder {
    private static final BinaryInfo DEFAULT_INSTANCE;
    public static final int HASH_FIELD_NUMBER = 1;
    public static final int MIMETYPE_FIELD_NUMBER = 3;
    private static volatile Parser<BinaryInfo> PARSER = null;
    public static final int SIZE_FIELD_NUMBER = 2;
    private String hash_ = "";
    private String mimetype_ = "";
    private long size_;

    /* JADX INFO: renamed from: coeditCoreMessage.BinaryInfo$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42321 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1862xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1862xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1862xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1862xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1862xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1862xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1862xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1862xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<BinaryInfo, Builder> implements BinaryInfoOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearHash() {
            copyOnWrite();
            ((BinaryInfo) this.instance).clearHash();
            return this;
        }

        public Builder clearMimetype() {
            copyOnWrite();
            ((BinaryInfo) this.instance).clearMimetype();
            return this;
        }

        public Builder clearSize() {
            copyOnWrite();
            ((BinaryInfo) this.instance).clearSize();
            return this;
        }

        @Override // coeditCoreMessage.BinaryInfoOrBuilder
        public String getHash() {
            return ((BinaryInfo) this.instance).getHash();
        }

        @Override // coeditCoreMessage.BinaryInfoOrBuilder
        public ByteString getHashBytes() {
            return ((BinaryInfo) this.instance).getHashBytes();
        }

        @Override // coeditCoreMessage.BinaryInfoOrBuilder
        public String getMimetype() {
            return ((BinaryInfo) this.instance).getMimetype();
        }

        @Override // coeditCoreMessage.BinaryInfoOrBuilder
        public ByteString getMimetypeBytes() {
            return ((BinaryInfo) this.instance).getMimetypeBytes();
        }

        @Override // coeditCoreMessage.BinaryInfoOrBuilder
        public long getSize() {
            return ((BinaryInfo) this.instance).getSize();
        }

        public Builder setHash(String str) {
            copyOnWrite();
            ((BinaryInfo) this.instance).setHash(str);
            return this;
        }

        public Builder setHashBytes(ByteString byteString) {
            copyOnWrite();
            ((BinaryInfo) this.instance).setHashBytes(byteString);
            return this;
        }

        public Builder setMimetype(String str) {
            copyOnWrite();
            ((BinaryInfo) this.instance).setMimetype(str);
            return this;
        }

        public Builder setMimetypeBytes(ByteString byteString) {
            copyOnWrite();
            ((BinaryInfo) this.instance).setMimetypeBytes(byteString);
            return this;
        }

        public Builder setSize(long j) {
            copyOnWrite();
            ((BinaryInfo) this.instance).setSize(j);
            return this;
        }

        private Builder() {
            super(BinaryInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        BinaryInfo binaryInfo = new BinaryInfo();
        DEFAULT_INSTANCE = binaryInfo;
        GeneratedMessageLite.registerDefaultInstance(BinaryInfo.class, binaryInfo);
    }

    private BinaryInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHash() {
        this.hash_ = getDefaultInstance().getHash();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMimetype() {
        this.mimetype_ = getDefaultInstance().getMimetype();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSize() {
        this.size_ = 0L;
    }

    public static BinaryInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static BinaryInfo parseDelimitedFrom(InputStream inputStream) {
        return (BinaryInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BinaryInfo parseFrom(ByteBuffer byteBuffer) {
        return (BinaryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<BinaryInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHash(String str) {
        str.getClass();
        this.hash_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHashBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.hash_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMimetype(String str) {
        str.getClass();
        this.mimetype_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMimetypeBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.mimetype_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(long j) {
        this.size_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42321.f1862xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new BinaryInfo();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003Ȉ", new Object[]{"hash_", "size_", "mimetype_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<BinaryInfo> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (BinaryInfo.class) {
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

    @Override // coeditCoreMessage.BinaryInfoOrBuilder
    public String getHash() {
        return this.hash_;
    }

    @Override // coeditCoreMessage.BinaryInfoOrBuilder
    public ByteString getHashBytes() {
        return ByteString.copyFromUtf8(this.hash_);
    }

    @Override // coeditCoreMessage.BinaryInfoOrBuilder
    public String getMimetype() {
        return this.mimetype_;
    }

    @Override // coeditCoreMessage.BinaryInfoOrBuilder
    public ByteString getMimetypeBytes() {
        return ByteString.copyFromUtf8(this.mimetype_);
    }

    @Override // coeditCoreMessage.BinaryInfoOrBuilder
    public long getSize() {
        return this.size_;
    }

    public static Builder newBuilder(BinaryInfo binaryInfo) {
        return DEFAULT_INSTANCE.createBuilder(binaryInfo);
    }

    public static BinaryInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinaryInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BinaryInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (BinaryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static BinaryInfo parseFrom(ByteString byteString) {
        return (BinaryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static BinaryInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BinaryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BinaryInfo parseFrom(byte[] bArr) {
        return (BinaryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BinaryInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (BinaryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static BinaryInfo parseFrom(InputStream inputStream) {
        return (BinaryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BinaryInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinaryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BinaryInfo parseFrom(CodedInputStream codedInputStream) {
        return (BinaryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BinaryInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinaryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
