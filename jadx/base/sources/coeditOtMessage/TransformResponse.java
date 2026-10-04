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
public final class TransformResponse extends GeneratedMessageLite<TransformResponse, Builder> implements TransformResponseOrBuilder {
    private static final TransformResponse DEFAULT_INSTANCE;
    public static final int FIRST_TRANSFORMED_FIELD_NUMBER = 1;
    private static volatile Parser<TransformResponse> PARSER = null;
    public static final int SECOND_TRANSFORMED_FIELD_NUMBER = 2;
    private IdxCedOpsPair firstTransformed_;
    private IdxCedOpsPair secondTransformed_;

    /* JADX INFO: renamed from: coeditOtMessage.TransformResponse$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42961 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1901xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1901xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1901xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1901xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1901xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1901xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1901xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1901xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<TransformResponse, Builder> implements TransformResponseOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearFirstTransformed() {
            copyOnWrite();
            ((TransformResponse) this.instance).clearFirstTransformed();
            return this;
        }

        public Builder clearSecondTransformed() {
            copyOnWrite();
            ((TransformResponse) this.instance).clearSecondTransformed();
            return this;
        }

        @Override // coeditOtMessage.TransformResponseOrBuilder
        public IdxCedOpsPair getFirstTransformed() {
            return ((TransformResponse) this.instance).getFirstTransformed();
        }

        @Override // coeditOtMessage.TransformResponseOrBuilder
        public IdxCedOpsPair getSecondTransformed() {
            return ((TransformResponse) this.instance).getSecondTransformed();
        }

        @Override // coeditOtMessage.TransformResponseOrBuilder
        public boolean hasFirstTransformed() {
            return ((TransformResponse) this.instance).hasFirstTransformed();
        }

        @Override // coeditOtMessage.TransformResponseOrBuilder
        public boolean hasSecondTransformed() {
            return ((TransformResponse) this.instance).hasSecondTransformed();
        }

        public Builder mergeFirstTransformed(IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((TransformResponse) this.instance).mergeFirstTransformed(idxCedOpsPair);
            return this;
        }

        public Builder mergeSecondTransformed(IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((TransformResponse) this.instance).mergeSecondTransformed(idxCedOpsPair);
            return this;
        }

        public Builder setFirstTransformed(IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((TransformResponse) this.instance).setFirstTransformed(idxCedOpsPair);
            return this;
        }

        public Builder setSecondTransformed(IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((TransformResponse) this.instance).setSecondTransformed(idxCedOpsPair);
            return this;
        }

        private Builder() {
            super(TransformResponse.DEFAULT_INSTANCE);
        }

        public Builder setFirstTransformed(IdxCedOpsPair.Builder builder) {
            copyOnWrite();
            ((TransformResponse) this.instance).setFirstTransformed(builder.build());
            return this;
        }

        public Builder setSecondTransformed(IdxCedOpsPair.Builder builder) {
            copyOnWrite();
            ((TransformResponse) this.instance).setSecondTransformed(builder.build());
            return this;
        }
    }

    static {
        TransformResponse transformResponse = new TransformResponse();
        DEFAULT_INSTANCE = transformResponse;
        GeneratedMessageLite.registerDefaultInstance(TransformResponse.class, transformResponse);
    }

    private TransformResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFirstTransformed() {
        this.firstTransformed_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSecondTransformed() {
        this.secondTransformed_ = null;
    }

    public static TransformResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeFirstTransformed(IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        IdxCedOpsPair idxCedOpsPair2 = this.firstTransformed_;
        if (idxCedOpsPair2 == null || idxCedOpsPair2 == IdxCedOpsPair.getDefaultInstance()) {
            this.firstTransformed_ = idxCedOpsPair;
        } else {
            this.firstTransformed_ = IdxCedOpsPair.newBuilder(this.firstTransformed_).mergeFrom(idxCedOpsPair).buildPartial();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSecondTransformed(IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        IdxCedOpsPair idxCedOpsPair2 = this.secondTransformed_;
        if (idxCedOpsPair2 == null || idxCedOpsPair2 == IdxCedOpsPair.getDefaultInstance()) {
            this.secondTransformed_ = idxCedOpsPair;
        } else {
            this.secondTransformed_ = IdxCedOpsPair.newBuilder(this.secondTransformed_).mergeFrom(idxCedOpsPair).buildPartial();
        }
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static TransformResponse parseDelimitedFrom(InputStream inputStream) {
        return (TransformResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TransformResponse parseFrom(ByteBuffer byteBuffer) {
        return (TransformResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TransformResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFirstTransformed(IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        this.firstTransformed_ = idxCedOpsPair;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSecondTransformed(IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        this.secondTransformed_ = idxCedOpsPair;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42961.f1901xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new TransformResponse();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"firstTransformed_", "secondTransformed_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TransformResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (TransformResponse.class) {
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

    @Override // coeditOtMessage.TransformResponseOrBuilder
    public IdxCedOpsPair getFirstTransformed() {
        IdxCedOpsPair idxCedOpsPair = this.firstTransformed_;
        return idxCedOpsPair == null ? IdxCedOpsPair.getDefaultInstance() : idxCedOpsPair;
    }

    @Override // coeditOtMessage.TransformResponseOrBuilder
    public IdxCedOpsPair getSecondTransformed() {
        IdxCedOpsPair idxCedOpsPair = this.secondTransformed_;
        return idxCedOpsPair == null ? IdxCedOpsPair.getDefaultInstance() : idxCedOpsPair;
    }

    @Override // coeditOtMessage.TransformResponseOrBuilder
    public boolean hasFirstTransformed() {
        return this.firstTransformed_ != null;
    }

    @Override // coeditOtMessage.TransformResponseOrBuilder
    public boolean hasSecondTransformed() {
        return this.secondTransformed_ != null;
    }

    public static Builder newBuilder(TransformResponse transformResponse) {
        return DEFAULT_INSTANCE.createBuilder(transformResponse);
    }

    public static TransformResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TransformResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TransformResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (TransformResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TransformResponse parseFrom(ByteString byteString) {
        return (TransformResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static TransformResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (TransformResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TransformResponse parseFrom(byte[] bArr) {
        return (TransformResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TransformResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (TransformResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TransformResponse parseFrom(InputStream inputStream) {
        return (TransformResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TransformResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TransformResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TransformResponse parseFrom(CodedInputStream codedInputStream) {
        return (TransformResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TransformResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TransformResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
