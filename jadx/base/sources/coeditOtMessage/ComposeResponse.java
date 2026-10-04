package coeditOtMessage;

import coeditOtMessage.IdxCedOpsPair;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class ComposeResponse extends GeneratedMessageLite<ComposeResponse, Builder> implements ComposeResponseOrBuilder {
    private static final ComposeResponse DEFAULT_INSTANCE;
    public static final int PAIRS_FIELD_NUMBER = 1;
    private static volatile Parser<ComposeResponse> PARSER;
    private IdxCedOpsPair pairs_;

    /* JADX INFO: renamed from: coeditOtMessage.ComposeResponse$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42911 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1896xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1896xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1896xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1896xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1896xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1896xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1896xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1896xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<ComposeResponse, Builder> implements ComposeResponseOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearPairs() {
            copyOnWrite();
            ((ComposeResponse) this.instance).clearPairs();
            return this;
        }

        @Override // coeditOtMessage.ComposeResponseOrBuilder
        public IdxCedOpsPair getPairs() {
            return ((ComposeResponse) this.instance).getPairs();
        }

        @Override // coeditOtMessage.ComposeResponseOrBuilder
        public boolean hasPairs() {
            return ((ComposeResponse) this.instance).hasPairs();
        }

        public Builder mergePairs(IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((ComposeResponse) this.instance).mergePairs(idxCedOpsPair);
            return this;
        }

        public Builder setPairs(IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((ComposeResponse) this.instance).setPairs(idxCedOpsPair);
            return this;
        }

        private Builder() {
            super(ComposeResponse.DEFAULT_INSTANCE);
        }

        public Builder setPairs(IdxCedOpsPair.Builder builder) {
            copyOnWrite();
            ((ComposeResponse) this.instance).setPairs(builder.build());
            return this;
        }
    }

    static {
        ComposeResponse composeResponse = new ComposeResponse();
        DEFAULT_INSTANCE = composeResponse;
        GeneratedMessageLite.registerDefaultInstance(ComposeResponse.class, composeResponse);
    }

    private ComposeResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPairs() {
        this.pairs_ = null;
    }

    public static ComposeResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePairs(IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        IdxCedOpsPair idxCedOpsPair2 = this.pairs_;
        if (idxCedOpsPair2 == null || idxCedOpsPair2 == IdxCedOpsPair.getDefaultInstance()) {
            this.pairs_ = idxCedOpsPair;
        } else {
            this.pairs_ = IdxCedOpsPair.newBuilder(this.pairs_).mergeFrom(idxCedOpsPair).buildPartial();
        }
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ComposeResponse parseDelimitedFrom(InputStream inputStream) {
        return (ComposeResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ComposeResponse parseFrom(ByteBuffer byteBuffer) {
        return (ComposeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ComposeResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPairs(IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        this.pairs_ = idxCedOpsPair;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42911.f1896xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new ComposeResponse();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"pairs_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ComposeResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ComposeResponse.class) {
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

    @Override // coeditOtMessage.ComposeResponseOrBuilder
    public IdxCedOpsPair getPairs() {
        IdxCedOpsPair idxCedOpsPair = this.pairs_;
        return idxCedOpsPair == null ? IdxCedOpsPair.getDefaultInstance() : idxCedOpsPair;
    }

    @Override // coeditOtMessage.ComposeResponseOrBuilder
    public boolean hasPairs() {
        return this.pairs_ != null;
    }

    public static Builder newBuilder(ComposeResponse composeResponse) {
        return DEFAULT_INSTANCE.createBuilder(composeResponse);
    }

    public static ComposeResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ComposeResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ComposeResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ComposeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ComposeResponse parseFrom(ByteString byteString) {
        return (ComposeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ComposeResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ComposeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ComposeResponse parseFrom(byte[] bArr) {
        return (ComposeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ComposeResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ComposeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ComposeResponse parseFrom(InputStream inputStream) {
        return (ComposeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ComposeResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ComposeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ComposeResponse parseFrom(CodedInputStream codedInputStream) {
        return (ComposeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ComposeResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ComposeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
