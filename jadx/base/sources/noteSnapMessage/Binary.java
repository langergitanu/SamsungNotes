package noteSnapMessage;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class Binary extends GeneratedMessageLite<Binary, Builder> implements BinaryOrBuilder {
    public static final int CHUNK_FIELD_NUMBER = 1;
    private static final Binary DEFAULT_INSTANCE;
    private static volatile Parser<Binary> PARSER = null;
    public static final int READ_SIZE_FIELD_NUMBER = 2;
    private ByteString chunk_ = ByteString.EMPTY;
    private int readSize_;

    /* JADX INFO: renamed from: noteSnapMessage.Binary$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C135581 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f9605xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f9605xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9605xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9605xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9605xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9605xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9605xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9605xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<Binary, Builder> implements BinaryOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearChunk() {
            copyOnWrite();
            ((Binary) this.instance).clearChunk();
            return this;
        }

        public Builder clearReadSize() {
            copyOnWrite();
            ((Binary) this.instance).clearReadSize();
            return this;
        }

        @Override // noteSnapMessage.BinaryOrBuilder
        public ByteString getChunk() {
            return ((Binary) this.instance).getChunk();
        }

        @Override // noteSnapMessage.BinaryOrBuilder
        public int getReadSize() {
            return ((Binary) this.instance).getReadSize();
        }

        public Builder setChunk(ByteString byteString) {
            copyOnWrite();
            ((Binary) this.instance).setChunk(byteString);
            return this;
        }

        public Builder setReadSize(int i) {
            copyOnWrite();
            ((Binary) this.instance).setReadSize(i);
            return this;
        }

        private Builder() {
            super(Binary.DEFAULT_INSTANCE);
        }
    }

    static {
        Binary binary = new Binary();
        DEFAULT_INSTANCE = binary;
        GeneratedMessageLite.registerDefaultInstance(Binary.class, binary);
    }

    private Binary() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChunk() {
        this.chunk_ = getDefaultInstance().getChunk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReadSize() {
        this.readSize_ = 0;
    }

    public static Binary getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Binary parseDelimitedFrom(InputStream inputStream) {
        return (Binary) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Binary parseFrom(ByteBuffer byteBuffer) {
        return (Binary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Binary> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChunk(ByteString byteString) {
        byteString.getClass();
        this.chunk_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadSize(int i) {
        this.readSize_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C135581.f9605xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new Binary();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\n\u0002\u0004", new Object[]{"chunk_", "readSize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Binary> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Binary.class) {
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

    @Override // noteSnapMessage.BinaryOrBuilder
    public ByteString getChunk() {
        return this.chunk_;
    }

    @Override // noteSnapMessage.BinaryOrBuilder
    public int getReadSize() {
        return this.readSize_;
    }

    public static Builder newBuilder(Binary binary) {
        return DEFAULT_INSTANCE.createBuilder(binary);
    }

    public static Binary parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Binary) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Binary parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Binary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Binary parseFrom(ByteString byteString) {
        return (Binary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Binary parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Binary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Binary parseFrom(byte[] bArr) {
        return (Binary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Binary parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Binary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Binary parseFrom(InputStream inputStream) {
        return (Binary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Binary parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Binary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Binary parseFrom(CodedInputStream codedInputStream) {
        return (Binary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Binary parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Binary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
