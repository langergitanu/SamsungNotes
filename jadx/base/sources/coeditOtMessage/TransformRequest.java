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
public final class TransformRequest extends GeneratedMessageLite<TransformRequest, Builder> implements TransformRequestOrBuilder {
    private static final TransformRequest DEFAULT_INSTANCE;
    public static final int FIRST_FIELD_NUMBER = 1;
    private static volatile Parser<TransformRequest> PARSER = null;
    public static final int SECOND_FIELD_NUMBER = 2;
    private IdxCedOpsPair first_;
    private IdxCedOpsPair second_;

    /* JADX INFO: renamed from: coeditOtMessage.TransformRequest$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42951 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1900xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1900xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1900xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1900xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1900xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1900xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1900xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1900xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<TransformRequest, Builder> implements TransformRequestOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearFirst() {
            copyOnWrite();
            ((TransformRequest) this.instance).clearFirst();
            return this;
        }

        public Builder clearSecond() {
            copyOnWrite();
            ((TransformRequest) this.instance).clearSecond();
            return this;
        }

        @Override // coeditOtMessage.TransformRequestOrBuilder
        public IdxCedOpsPair getFirst() {
            return ((TransformRequest) this.instance).getFirst();
        }

        @Override // coeditOtMessage.TransformRequestOrBuilder
        public IdxCedOpsPair getSecond() {
            return ((TransformRequest) this.instance).getSecond();
        }

        @Override // coeditOtMessage.TransformRequestOrBuilder
        public boolean hasFirst() {
            return ((TransformRequest) this.instance).hasFirst();
        }

        @Override // coeditOtMessage.TransformRequestOrBuilder
        public boolean hasSecond() {
            return ((TransformRequest) this.instance).hasSecond();
        }

        public Builder mergeFirst(IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((TransformRequest) this.instance).mergeFirst(idxCedOpsPair);
            return this;
        }

        public Builder mergeSecond(IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((TransformRequest) this.instance).mergeSecond(idxCedOpsPair);
            return this;
        }

        public Builder setFirst(IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((TransformRequest) this.instance).setFirst(idxCedOpsPair);
            return this;
        }

        public Builder setSecond(IdxCedOpsPair idxCedOpsPair) {
            copyOnWrite();
            ((TransformRequest) this.instance).setSecond(idxCedOpsPair);
            return this;
        }

        private Builder() {
            super(TransformRequest.DEFAULT_INSTANCE);
        }

        public Builder setFirst(IdxCedOpsPair.Builder builder) {
            copyOnWrite();
            ((TransformRequest) this.instance).setFirst(builder.build());
            return this;
        }

        public Builder setSecond(IdxCedOpsPair.Builder builder) {
            copyOnWrite();
            ((TransformRequest) this.instance).setSecond(builder.build());
            return this;
        }
    }

    static {
        TransformRequest transformRequest = new TransformRequest();
        DEFAULT_INSTANCE = transformRequest;
        GeneratedMessageLite.registerDefaultInstance(TransformRequest.class, transformRequest);
    }

    private TransformRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFirst() {
        this.first_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSecond() {
        this.second_ = null;
    }

    public static TransformRequest getDefaultInstance() {
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

    public static TransformRequest parseDelimitedFrom(InputStream inputStream) {
        return (TransformRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TransformRequest parseFrom(ByteBuffer byteBuffer) {
        return (TransformRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TransformRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFirst(IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        this.first_ = idxCedOpsPair;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSecond(IdxCedOpsPair idxCedOpsPair) {
        idxCedOpsPair.getClass();
        this.second_ = idxCedOpsPair;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42951.f1900xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new TransformRequest();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"first_", "second_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TransformRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (TransformRequest.class) {
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

    @Override // coeditOtMessage.TransformRequestOrBuilder
    public IdxCedOpsPair getFirst() {
        IdxCedOpsPair idxCedOpsPair = this.first_;
        return idxCedOpsPair == null ? IdxCedOpsPair.getDefaultInstance() : idxCedOpsPair;
    }

    @Override // coeditOtMessage.TransformRequestOrBuilder
    public IdxCedOpsPair getSecond() {
        IdxCedOpsPair idxCedOpsPair = this.second_;
        return idxCedOpsPair == null ? IdxCedOpsPair.getDefaultInstance() : idxCedOpsPair;
    }

    @Override // coeditOtMessage.TransformRequestOrBuilder
    public boolean hasFirst() {
        return this.first_ != null;
    }

    @Override // coeditOtMessage.TransformRequestOrBuilder
    public boolean hasSecond() {
        return this.second_ != null;
    }

    public static Builder newBuilder(TransformRequest transformRequest) {
        return DEFAULT_INSTANCE.createBuilder(transformRequest);
    }

    public static TransformRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TransformRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TransformRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (TransformRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TransformRequest parseFrom(ByteString byteString) {
        return (TransformRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static TransformRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (TransformRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TransformRequest parseFrom(byte[] bArr) {
        return (TransformRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TransformRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (TransformRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TransformRequest parseFrom(InputStream inputStream) {
        return (TransformRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TransformRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TransformRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TransformRequest parseFrom(CodedInputStream codedInputStream) {
        return (TransformRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TransformRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TransformRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
