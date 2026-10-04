package coeditOtMessage;

import coeditOtMessage.IdxCedOpsPair;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class ComposeRequest extends GeneratedMessageLite<ComposeRequest, Builder> implements ComposeRequestOrBuilder {
    private static final ComposeRequest DEFAULT_INSTANCE;
    public static final int PAIRS_FIELD_NUMBER = 1;
    private static volatile Parser<ComposeRequest> PARSER;
    private Internal.ProtobufList<IdxCedOpsPair> pairs_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: coeditOtMessage.ComposeRequest$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42901 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1895xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1895xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1895xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1895xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1895xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1895xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1895xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1895xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<ComposeRequest, Builder> implements ComposeRequestOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder addAllPairs(Iterable<? extends IdxCedOpsPair> iterable) {
            copyOnWrite();
            ((ComposeRequest) this.instance).addAllPairs(iterable);
            return this;
        }

        public Builder addPairs(IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((ComposeRequest) this.instance).addPairs(idxCedOpsPair);
            return this;
        }

        public Builder clearPairs() {
            copyOnWrite();
            ((ComposeRequest) this.instance).clearPairs();
            return this;
        }

        @Override // coeditOtMessage.ComposeRequestOrBuilder
        public IdxCedOpsPair getPairs(int i) {
            return ((ComposeRequest) this.instance).getPairs(i);
        }

        @Override // coeditOtMessage.ComposeRequestOrBuilder
        public int getPairsCount() {
            return ((ComposeRequest) this.instance).getPairsCount();
        }

        @Override // coeditOtMessage.ComposeRequestOrBuilder
        public List<IdxCedOpsPair> getPairsList() {
            return Collections.unmodifiableList(((ComposeRequest) this.instance).getPairsList());
        }

        public Builder removePairs(int i) {
            copyOnWrite();
            ((ComposeRequest) this.instance).removePairs(i);
            return this;
        }

        public Builder setPairs(int i, IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((ComposeRequest) this.instance).setPairs(i, idxCedOpsPair);
            return this;
        }

        private Builder() {
            super(ComposeRequest.DEFAULT_INSTANCE);
        }

        public Builder addPairs(int i, IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((ComposeRequest) this.instance).addPairs(i, idxCedOpsPair);
            return this;
        }

        public Builder setPairs(int i, IdxCedOpsPair.Builder builder) {
            copyOnWrite();
            ((ComposeRequest) this.instance).setPairs(i, builder.build());
            return this;
        }

        public Builder addPairs(IdxCedOpsPair.Builder builder) {
            copyOnWrite();
            ((ComposeRequest) this.instance).addPairs(builder.build());
            return this;
        }

        public Builder addPairs(int i, IdxCedOpsPair.Builder builder) {
            copyOnWrite();
            ((ComposeRequest) this.instance).addPairs(i, builder.build());
            return this;
        }
    }

    static {
        ComposeRequest composeRequest = new ComposeRequest();
        DEFAULT_INSTANCE = composeRequest;
        GeneratedMessageLite.registerDefaultInstance(ComposeRequest.class, composeRequest);
    }

    private ComposeRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPairs(Iterable<? extends IdxCedOpsPair> iterable) {
        ensurePairsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.pairs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPairs(IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        ensurePairsIsMutable();
        this.pairs_.add(idxCedOpsPair);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPairs() {
        this.pairs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePairsIsMutable() {
        Internal.ProtobufList<IdxCedOpsPair> protobufList = this.pairs_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.pairs_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static ComposeRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ComposeRequest parseDelimitedFrom(InputStream inputStream) {
        return (ComposeRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ComposeRequest parseFrom(ByteBuffer byteBuffer) {
        return (ComposeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ComposeRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePairs(int i) {
        ensurePairsIsMutable();
        this.pairs_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPairs(int i, IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        ensurePairsIsMutable();
        this.pairs_.set(i, idxCedOpsPair);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42901.f1895xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new ComposeRequest();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"pairs_", IdxCedOpsPair.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ComposeRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ComposeRequest.class) {
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

    @Override // coeditOtMessage.ComposeRequestOrBuilder
    public IdxCedOpsPair getPairs(int i) {
        return this.pairs_.get(i);
    }

    @Override // coeditOtMessage.ComposeRequestOrBuilder
    public int getPairsCount() {
        return this.pairs_.size();
    }

    @Override // coeditOtMessage.ComposeRequestOrBuilder
    public List<IdxCedOpsPair> getPairsList() {
        return this.pairs_;
    }

    public IdxCedOpsPairOrBuilder getPairsOrBuilder(int i) {
        return this.pairs_.get(i);
    }

    public List<? extends IdxCedOpsPairOrBuilder> getPairsOrBuilderList() {
        return this.pairs_;
    }

    public static Builder newBuilder(ComposeRequest composeRequest) {
        return DEFAULT_INSTANCE.createBuilder(composeRequest);
    }

    public static ComposeRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ComposeRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ComposeRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ComposeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ComposeRequest parseFrom(ByteString byteString) {
        return (ComposeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPairs(int i, IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        ensurePairsIsMutable();
        this.pairs_.add(i, idxCedOpsPair);
    }

    public static ComposeRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ComposeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ComposeRequest parseFrom(byte[] bArr) {
        return (ComposeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ComposeRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ComposeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ComposeRequest parseFrom(InputStream inputStream) {
        return (ComposeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ComposeRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ComposeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ComposeRequest parseFrom(CodedInputStream codedInputStream) {
        return (ComposeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ComposeRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ComposeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
