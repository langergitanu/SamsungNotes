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
public final class TransformWithMultipleRequest extends GeneratedMessageLite<TransformWithMultipleRequest, Builder> implements TransformWithMultipleRequestOrBuilder {
    private static final TransformWithMultipleRequest DEFAULT_INSTANCE;
    public static final int FIRST_FIELD_NUMBER = 1;
    private static volatile Parser<TransformWithMultipleRequest> PARSER = null;
    public static final int SECOND_FIELD_NUMBER = 2;
    private IdxCedOpsPair first_;
    private Internal.ProtobufList<IdxCedOpsPair> second_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: coeditOtMessage.TransformWithMultipleRequest$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42971 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1902xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1902xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1902xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1902xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1902xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1902xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1902xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1902xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<TransformWithMultipleRequest, Builder> implements TransformWithMultipleRequestOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder addAllSecond(Iterable<? extends IdxCedOpsPair> iterable) {
            copyOnWrite();
            ((TransformWithMultipleRequest) this.instance).addAllSecond(iterable);
            return this;
        }

        public Builder addSecond(IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((TransformWithMultipleRequest) this.instance).addSecond(idxCedOpsPair);
            return this;
        }

        public Builder clearFirst() {
            copyOnWrite();
            ((TransformWithMultipleRequest) this.instance).clearFirst();
            return this;
        }

        public Builder clearSecond() {
            copyOnWrite();
            ((TransformWithMultipleRequest) this.instance).clearSecond();
            return this;
        }

        @Override // coeditOtMessage.TransformWithMultipleRequestOrBuilder
        public IdxCedOpsPair getFirst() {
            return ((TransformWithMultipleRequest) this.instance).getFirst();
        }

        @Override // coeditOtMessage.TransformWithMultipleRequestOrBuilder
        public IdxCedOpsPair getSecond(int i) {
            return ((TransformWithMultipleRequest) this.instance).getSecond(i);
        }

        @Override // coeditOtMessage.TransformWithMultipleRequestOrBuilder
        public int getSecondCount() {
            return ((TransformWithMultipleRequest) this.instance).getSecondCount();
        }

        @Override // coeditOtMessage.TransformWithMultipleRequestOrBuilder
        public List<IdxCedOpsPair> getSecondList() {
            return Collections.unmodifiableList(((TransformWithMultipleRequest) this.instance).getSecondList());
        }

        @Override // coeditOtMessage.TransformWithMultipleRequestOrBuilder
        public boolean hasFirst() {
            return ((TransformWithMultipleRequest) this.instance).hasFirst();
        }

        public Builder mergeFirst(IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((TransformWithMultipleRequest) this.instance).mergeFirst(idxCedOpsPair);
            return this;
        }

        public Builder removeSecond(int i) {
            copyOnWrite();
            ((TransformWithMultipleRequest) this.instance).removeSecond(i);
            return this;
        }

        public Builder setFirst(IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((TransformWithMultipleRequest) this.instance).setFirst(idxCedOpsPair);
            return this;
        }

        public Builder setSecond(int i, IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((TransformWithMultipleRequest) this.instance).setSecond(i, idxCedOpsPair);
            return this;
        }

        private Builder() {
            super(TransformWithMultipleRequest.DEFAULT_INSTANCE);
        }

        public Builder addSecond(int i, IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((TransformWithMultipleRequest) this.instance).addSecond(i, idxCedOpsPair);
            return this;
        }

        public Builder setFirst(IdxCedOpsPair.Builder builder) {
            copyOnWrite();
            ((TransformWithMultipleRequest) this.instance).setFirst(builder.build());
            return this;
        }

        public Builder setSecond(int i, IdxCedOpsPair.Builder builder) {
            copyOnWrite();
            ((TransformWithMultipleRequest) this.instance).setSecond(i, builder.build());
            return this;
        }

        public Builder addSecond(IdxCedOpsPair.Builder builder) {
            copyOnWrite();
            ((TransformWithMultipleRequest) this.instance).addSecond(builder.build());
            return this;
        }

        public Builder addSecond(int i, IdxCedOpsPair.Builder builder) {
            copyOnWrite();
            ((TransformWithMultipleRequest) this.instance).addSecond(i, builder.build());
            return this;
        }
    }

    static {
        TransformWithMultipleRequest transformWithMultipleRequest = new TransformWithMultipleRequest();
        DEFAULT_INSTANCE = transformWithMultipleRequest;
        GeneratedMessageLite.registerDefaultInstance(TransformWithMultipleRequest.class, transformWithMultipleRequest);
    }

    private TransformWithMultipleRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSecond(Iterable<? extends IdxCedOpsPair> iterable) {
        ensureSecondIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.second_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSecond(IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        ensureSecondIsMutable();
        this.second_.add(idxCedOpsPair);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFirst() {
        this.first_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSecond() {
        this.second_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureSecondIsMutable() {
        Internal.ProtobufList<IdxCedOpsPair> protobufList = this.second_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.second_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static TransformWithMultipleRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeFirst(IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        IdxCedOpsPair idxCedOpsPair2 = this.first_;
        if (idxCedOpsPair2 == null || idxCedOpsPair2 == IdxCedOpsPair.getDefaultInstance()) {
            this.first_ = idxCedOpsPair;
        } else {
            this.first_ = IdxCedOpsPair.newBuilder(this.first_).mergeFrom(idxCedOpsPair).buildPartial();
        }
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static TransformWithMultipleRequest parseDelimitedFrom(InputStream inputStream) {
        return (TransformWithMultipleRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TransformWithMultipleRequest parseFrom(ByteBuffer byteBuffer) {
        return (TransformWithMultipleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TransformWithMultipleRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSecond(int i) {
        ensureSecondIsMutable();
        this.second_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFirst(IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        this.first_ = idxCedOpsPair;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSecond(int i, IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        ensureSecondIsMutable();
        this.second_.set(i, idxCedOpsPair);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42971.f1902xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new TransformWithMultipleRequest();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\t\u0002\u001b", new Object[]{"first_", "second_", IdxCedOpsPair.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TransformWithMultipleRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (TransformWithMultipleRequest.class) {
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

    @Override // coeditOtMessage.TransformWithMultipleRequestOrBuilder
    public IdxCedOpsPair getFirst() {
        IdxCedOpsPair idxCedOpsPair = this.first_;
        return idxCedOpsPair == null ? IdxCedOpsPair.getDefaultInstance() : idxCedOpsPair;
    }

    @Override // coeditOtMessage.TransformWithMultipleRequestOrBuilder
    public IdxCedOpsPair getSecond(int i) {
        return this.second_.get(i);
    }

    @Override // coeditOtMessage.TransformWithMultipleRequestOrBuilder
    public int getSecondCount() {
        return this.second_.size();
    }

    @Override // coeditOtMessage.TransformWithMultipleRequestOrBuilder
    public List<IdxCedOpsPair> getSecondList() {
        return this.second_;
    }

    public IdxCedOpsPairOrBuilder getSecondOrBuilder(int i) {
        return this.second_.get(i);
    }

    public List<? extends IdxCedOpsPairOrBuilder> getSecondOrBuilderList() {
        return this.second_;
    }

    @Override // coeditOtMessage.TransformWithMultipleRequestOrBuilder
    public boolean hasFirst() {
        return this.first_ != null;
    }

    public static Builder newBuilder(TransformWithMultipleRequest transformWithMultipleRequest) {
        return DEFAULT_INSTANCE.createBuilder(transformWithMultipleRequest);
    }

    public static TransformWithMultipleRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TransformWithMultipleRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TransformWithMultipleRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (TransformWithMultipleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TransformWithMultipleRequest parseFrom(ByteString byteString) {
        return (TransformWithMultipleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSecond(int i, IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        ensureSecondIsMutable();
        this.second_.add(i, idxCedOpsPair);
    }

    public static TransformWithMultipleRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (TransformWithMultipleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TransformWithMultipleRequest parseFrom(byte[] bArr) {
        return (TransformWithMultipleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TransformWithMultipleRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (TransformWithMultipleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TransformWithMultipleRequest parseFrom(InputStream inputStream) {
        return (TransformWithMultipleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TransformWithMultipleRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TransformWithMultipleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TransformWithMultipleRequest parseFrom(CodedInputStream codedInputStream) {
        return (TransformWithMultipleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TransformWithMultipleRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TransformWithMultipleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
