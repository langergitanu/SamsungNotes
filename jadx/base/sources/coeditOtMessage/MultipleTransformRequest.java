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
public final class MultipleTransformRequest extends GeneratedMessageLite<MultipleTransformRequest, Builder> implements MultipleTransformRequestOrBuilder {
    private static final MultipleTransformRequest DEFAULT_INSTANCE;
    public static final int FIRST_FIELD_NUMBER = 1;
    private static volatile Parser<MultipleTransformRequest> PARSER = null;
    public static final int SECOND_FIELD_NUMBER = 2;
    private Internal.ProtobufList<IdxCedOpsPair> first_ = GeneratedMessageLite.emptyProtobufList();
    private IdxCedOpsPair second_;

    /* JADX INFO: renamed from: coeditOtMessage.MultipleTransformRequest$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42931 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1898xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1898xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1898xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1898xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1898xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1898xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1898xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1898xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<MultipleTransformRequest, Builder> implements MultipleTransformRequestOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder addAllFirst(Iterable<? extends IdxCedOpsPair> iterable) {
            copyOnWrite();
            ((MultipleTransformRequest) this.instance).addAllFirst(iterable);
            return this;
        }

        public Builder addFirst(IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((MultipleTransformRequest) this.instance).addFirst(idxCedOpsPair);
            return this;
        }

        public Builder clearFirst() {
            copyOnWrite();
            ((MultipleTransformRequest) this.instance).clearFirst();
            return this;
        }

        public Builder clearSecond() {
            copyOnWrite();
            ((MultipleTransformRequest) this.instance).clearSecond();
            return this;
        }

        @Override // coeditOtMessage.MultipleTransformRequestOrBuilder
        public IdxCedOpsPair getFirst(int i) {
            return ((MultipleTransformRequest) this.instance).getFirst(i);
        }

        @Override // coeditOtMessage.MultipleTransformRequestOrBuilder
        public int getFirstCount() {
            return ((MultipleTransformRequest) this.instance).getFirstCount();
        }

        @Override // coeditOtMessage.MultipleTransformRequestOrBuilder
        public List<IdxCedOpsPair> getFirstList() {
            return Collections.unmodifiableList(((MultipleTransformRequest) this.instance).getFirstList());
        }

        @Override // coeditOtMessage.MultipleTransformRequestOrBuilder
        public IdxCedOpsPair getSecond() {
            return ((MultipleTransformRequest) this.instance).getSecond();
        }

        @Override // coeditOtMessage.MultipleTransformRequestOrBuilder
        public boolean hasSecond() {
            return ((MultipleTransformRequest) this.instance).hasSecond();
        }

        public Builder mergeSecond(IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((MultipleTransformRequest) this.instance).mergeSecond(idxCedOpsPair);
            return this;
        }

        public Builder removeFirst(int i) {
            copyOnWrite();
            ((MultipleTransformRequest) this.instance).removeFirst(i);
            return this;
        }

        public Builder setFirst(int i, IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((MultipleTransformRequest) this.instance).setFirst(i, idxCedOpsPair);
            return this;
        }

        public Builder setSecond(IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((MultipleTransformRequest) this.instance).setSecond(idxCedOpsPair);
            return this;
        }

        private Builder() {
            super(MultipleTransformRequest.DEFAULT_INSTANCE);
        }

        public Builder addFirst(int i, IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((MultipleTransformRequest) this.instance).addFirst(i, idxCedOpsPair);
            return this;
        }

        public Builder setFirst(int i, IdxCedOpsPair.Builder builder) {
            copyOnWrite();
            ((MultipleTransformRequest) this.instance).setFirst(i, builder.build());
            return this;
        }

        public Builder setSecond(IdxCedOpsPair.Builder builder) {
            copyOnWrite();
            ((MultipleTransformRequest) this.instance).setSecond(builder.build());
            return this;
        }

        public Builder addFirst(IdxCedOpsPair.Builder builder) {
            copyOnWrite();
            ((MultipleTransformRequest) this.instance).addFirst(builder.build());
            return this;
        }

        public Builder addFirst(int i, IdxCedOpsPair.Builder builder) {
            copyOnWrite();
            ((MultipleTransformRequest) this.instance).addFirst(i, builder.build());
            return this;
        }
    }

    static {
        MultipleTransformRequest multipleTransformRequest = new MultipleTransformRequest();
        DEFAULT_INSTANCE = multipleTransformRequest;
        GeneratedMessageLite.registerDefaultInstance(MultipleTransformRequest.class, multipleTransformRequest);
    }

    private MultipleTransformRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFirst(Iterable<? extends IdxCedOpsPair> iterable) {
        ensureFirstIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.first_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFirst(IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        ensureFirstIsMutable();
        this.first_.add(idxCedOpsPair);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFirst() {
        this.first_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSecond() {
        this.second_ = null;
    }

    private void ensureFirstIsMutable() {
        Internal.ProtobufList<IdxCedOpsPair> protobufList = this.first_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.first_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static MultipleTransformRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSecond(IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        IdxCedOpsPair idxCedOpsPair2 = this.second_;
        if (idxCedOpsPair2 == null || idxCedOpsPair2 == IdxCedOpsPair.getDefaultInstance()) {
            this.second_ = idxCedOpsPair;
        } else {
            this.second_ = IdxCedOpsPair.newBuilder(this.second_).mergeFrom(idxCedOpsPair).buildPartial();
        }
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MultipleTransformRequest parseDelimitedFrom(InputStream inputStream) {
        return (MultipleTransformRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MultipleTransformRequest parseFrom(ByteBuffer byteBuffer) {
        return (MultipleTransformRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MultipleTransformRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFirst(int i) {
        ensureFirstIsMutable();
        this.first_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFirst(int i, IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        ensureFirstIsMutable();
        this.first_.set(i, idxCedOpsPair);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSecond(IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        this.second_ = idxCedOpsPair;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42931.f1898xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new MultipleTransformRequest();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\t", new Object[]{"first_", IdxCedOpsPair.class, "second_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MultipleTransformRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MultipleTransformRequest.class) {
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

    @Override // coeditOtMessage.MultipleTransformRequestOrBuilder
    public IdxCedOpsPair getFirst(int i) {
        return this.first_.get(i);
    }

    @Override // coeditOtMessage.MultipleTransformRequestOrBuilder
    public int getFirstCount() {
        return this.first_.size();
    }

    @Override // coeditOtMessage.MultipleTransformRequestOrBuilder
    public List<IdxCedOpsPair> getFirstList() {
        return this.first_;
    }

    public IdxCedOpsPairOrBuilder getFirstOrBuilder(int i) {
        return this.first_.get(i);
    }

    public List<? extends IdxCedOpsPairOrBuilder> getFirstOrBuilderList() {
        return this.first_;
    }

    @Override // coeditOtMessage.MultipleTransformRequestOrBuilder
    public IdxCedOpsPair getSecond() {
        IdxCedOpsPair idxCedOpsPair = this.second_;
        return idxCedOpsPair == null ? IdxCedOpsPair.getDefaultInstance() : idxCedOpsPair;
    }

    @Override // coeditOtMessage.MultipleTransformRequestOrBuilder
    public boolean hasSecond() {
        return this.second_ != null;
    }

    public static Builder newBuilder(MultipleTransformRequest multipleTransformRequest) {
        return DEFAULT_INSTANCE.createBuilder(multipleTransformRequest);
    }

    public static MultipleTransformRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MultipleTransformRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MultipleTransformRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MultipleTransformRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MultipleTransformRequest parseFrom(ByteString byteString) {
        return (MultipleTransformRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFirst(int i, IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        ensureFirstIsMutable();
        this.first_.add(i, idxCedOpsPair);
    }

    public static MultipleTransformRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MultipleTransformRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MultipleTransformRequest parseFrom(byte[] bArr) {
        return (MultipleTransformRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MultipleTransformRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MultipleTransformRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MultipleTransformRequest parseFrom(InputStream inputStream) {
        return (MultipleTransformRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MultipleTransformRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MultipleTransformRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MultipleTransformRequest parseFrom(CodedInputStream codedInputStream) {
        return (MultipleTransformRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MultipleTransformRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MultipleTransformRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
