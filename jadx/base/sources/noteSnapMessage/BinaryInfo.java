package noteSnapMessage;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class BinaryInfo extends GeneratedMessageLite<BinaryInfo, Builder> implements BinaryInfoOrBuilder {
    private static final BinaryInfo DEFAULT_INSTANCE;
    public static final int HASH_FIELD_NUMBER = 4;
    public static final int LENGTH_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<BinaryInfo> PARSER = null;
    public static final int SIZE_FIELD_NUMBER = 5;
    public static final int TYPE_FIELD_NUMBER = 2;
    private long length_;
    private long size_;
    private String name_ = "";
    private String type_ = "";
    private String hash_ = "";

    /* JADX INFO: renamed from: noteSnapMessage.BinaryInfo$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C135591 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f9606xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f9606xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9606xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9606xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9606xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9606xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9606xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9606xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
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

        public Builder clearLength() {
            copyOnWrite();
            ((BinaryInfo) this.instance).clearLength();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((BinaryInfo) this.instance).clearName();
            return this;
        }

        public Builder clearSize() {
            copyOnWrite();
            ((BinaryInfo) this.instance).clearSize();
            return this;
        }

        public Builder clearType() {
            copyOnWrite();
            ((BinaryInfo) this.instance).clearType();
            return this;
        }

        @Override // noteSnapMessage.BinaryInfoOrBuilder
        public String getHash() {
            return ((BinaryInfo) this.instance).getHash();
        }

        @Override // noteSnapMessage.BinaryInfoOrBuilder
        public ByteString getHashBytes() {
            return ((BinaryInfo) this.instance).getHashBytes();
        }

        @Override // noteSnapMessage.BinaryInfoOrBuilder
        public long getLength() {
            return ((BinaryInfo) this.instance).getLength();
        }

        @Override // noteSnapMessage.BinaryInfoOrBuilder
        public String getName() {
            return ((BinaryInfo) this.instance).getName();
        }

        @Override // noteSnapMessage.BinaryInfoOrBuilder
        public ByteString getNameBytes() {
            return ((BinaryInfo) this.instance).getNameBytes();
        }

        @Override // noteSnapMessage.BinaryInfoOrBuilder
        public long getSize() {
            return ((BinaryInfo) this.instance).getSize();
        }

        @Override // noteSnapMessage.BinaryInfoOrBuilder
        public String getType() {
            return ((BinaryInfo) this.instance).getType();
        }

        @Override // noteSnapMessage.BinaryInfoOrBuilder
        public ByteString getTypeBytes() {
            return ((BinaryInfo) this.instance).getTypeBytes();
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

        public Builder setLength(long j) {
            copyOnWrite();
            ((BinaryInfo) this.instance).setLength(j);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((BinaryInfo) this.instance).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((BinaryInfo) this.instance).setNameBytes(byteString);
            return this;
        }

        public Builder setSize(long j) {
            copyOnWrite();
            ((BinaryInfo) this.instance).setSize(j);
            return this;
        }

        public Builder setType(String str) {
            copyOnWrite();
            ((BinaryInfo) this.instance).setType(str);
            return this;
        }

        public Builder setTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((BinaryInfo) this.instance).setTypeBytes(byteString);
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
    public void clearLength() {
        this.length_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSize() {
        this.size_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.type_ = getDefaultInstance().getType();
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
    public void setLength(long j) {
        this.length_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(long j) {
        this.size_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(String str) {
        str.getClass();
        this.type_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.type_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C135591.f9606xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new BinaryInfo();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004Ȉ\u0005\u0002", new Object[]{"name_", "type_", "length_", "hash_", "size_"});
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

    @Override // noteSnapMessage.BinaryInfoOrBuilder
    public String getHash() {
        return this.hash_;
    }

    @Override // noteSnapMessage.BinaryInfoOrBuilder
    public ByteString getHashBytes() {
        return ByteString.copyFromUtf8(this.hash_);
    }

    @Override // noteSnapMessage.BinaryInfoOrBuilder
    public long getLength() {
        return this.length_;
    }

    @Override // noteSnapMessage.BinaryInfoOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // noteSnapMessage.BinaryInfoOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // noteSnapMessage.BinaryInfoOrBuilder
    public long getSize() {
        return this.size_;
    }

    @Override // noteSnapMessage.BinaryInfoOrBuilder
    public String getType() {
        return this.type_;
    }

    @Override // noteSnapMessage.BinaryInfoOrBuilder
    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
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
