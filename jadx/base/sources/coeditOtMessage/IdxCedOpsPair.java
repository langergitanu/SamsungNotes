package coeditOtMessage;

import coeditOperation.CedOps;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class IdxCedOpsPair extends GeneratedMessageLite<IdxCedOpsPair, Builder> implements IdxCedOpsPairOrBuilder {
    public static final int CEDOPS_FIELD_NUMBER = 2;
    private static final IdxCedOpsPair DEFAULT_INSTANCE;
    public static final int IDX_FIELD_NUMBER = 1;
    private static volatile Parser<IdxCedOpsPair> PARSER;
    private CedOps cedOps_;
    private long idx_;

    /* JADX INFO: renamed from: coeditOtMessage.IdxCedOpsPair$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42921 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1897xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1897xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1897xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1897xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1897xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1897xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1897xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1897xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<IdxCedOpsPair, Builder> implements IdxCedOpsPairOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearCedOps() {
            copyOnWrite();
            ((IdxCedOpsPair) this.instance).clearCedOps();
            return this;
        }

        public Builder clearIdx() {
            copyOnWrite();
            ((IdxCedOpsPair) this.instance).clearIdx();
            return this;
        }

        @Override // coeditOtMessage.IdxCedOpsPairOrBuilder
        public CedOps getCedOps() {
            return ((IdxCedOpsPair) this.instance).getCedOps();
        }

        @Override // coeditOtMessage.IdxCedOpsPairOrBuilder
        public long getIdx() {
            return ((IdxCedOpsPair) this.instance).getIdx();
        }

        @Override // coeditOtMessage.IdxCedOpsPairOrBuilder
        public boolean hasCedOps() {
            return ((IdxCedOpsPair) this.instance).hasCedOps();
        }

        public Builder mergeCedOps(CedOps cedOps) {
            copyOnWrite();
            ((IdxCedOpsPair) this.instance).mergeCedOps(cedOps);
            return this;
        }

        public Builder setCedOps(CedOps cedOps) {
            copyOnWrite();
            ((IdxCedOpsPair) this.instance).setCedOps(cedOps);
            return this;
        }

        public Builder setIdx(long j) {
            copyOnWrite();
            ((IdxCedOpsPair) this.instance).setIdx(j);
            return this;
        }

        private Builder() {
            super(IdxCedOpsPair.DEFAULT_INSTANCE);
        }

        public Builder setCedOps(CedOps.Builder builder) {
            copyOnWrite();
            ((IdxCedOpsPair) this.instance).setCedOps(builder.build());
            return this;
        }
    }

    static {
        IdxCedOpsPair idxCedOpsPair = new IdxCedOpsPair();
        DEFAULT_INSTANCE = idxCedOpsPair;
        GeneratedMessageLite.registerDefaultInstance(IdxCedOpsPair.class, idxCedOpsPair);
    }

    private IdxCedOpsPair() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCedOps() {
        this.cedOps_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIdx() {
        this.idx_ = 0L;
    }

    public static IdxCedOpsPair getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCedOps(CedOps cedOps) {
        cedOps.getClass();
        CedOps cedOps2 = this.cedOps_;
        if (cedOps2 == null || cedOps2 == CedOps.getDefaultInstance()) {
            this.cedOps_ = cedOps;
        } else {
            this.cedOps_ = CedOps.newBuilder(this.cedOps_).mergeFrom(cedOps).buildPartial();
        }
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static IdxCedOpsPair parseDelimitedFrom(InputStream inputStream) {
        return (IdxCedOpsPair) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static IdxCedOpsPair parseFrom(ByteBuffer byteBuffer) {
        return (IdxCedOpsPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<IdxCedOpsPair> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCedOps(CedOps cedOps) {
        cedOps.getClass();
        this.cedOps_ = cedOps;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdx(long j) {
        this.idx_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42921.f1897xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new IdxCedOpsPair();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\t", new Object[]{"idx_", "cedOps_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<IdxCedOpsPair> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (IdxCedOpsPair.class) {
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

    @Override // coeditOtMessage.IdxCedOpsPairOrBuilder
    public CedOps getCedOps() {
        CedOps cedOps = this.cedOps_;
        return cedOps == null ? CedOps.getDefaultInstance() : cedOps;
    }

    @Override // coeditOtMessage.IdxCedOpsPairOrBuilder
    public long getIdx() {
        return this.idx_;
    }

    @Override // coeditOtMessage.IdxCedOpsPairOrBuilder
    public boolean hasCedOps() {
        return this.cedOps_ != null;
    }

    public static Builder newBuilder(IdxCedOpsPair idxCedOpsPair) {
        return DEFAULT_INSTANCE.createBuilder(idxCedOpsPair);
    }

    public static IdxCedOpsPair parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (IdxCedOpsPair) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static IdxCedOpsPair parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (IdxCedOpsPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static IdxCedOpsPair parseFrom(ByteString byteString) {
        return (IdxCedOpsPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static IdxCedOpsPair parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (IdxCedOpsPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static IdxCedOpsPair parseFrom(byte[] bArr) {
        return (IdxCedOpsPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static IdxCedOpsPair parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (IdxCedOpsPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static IdxCedOpsPair parseFrom(InputStream inputStream) {
        return (IdxCedOpsPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static IdxCedOpsPair parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (IdxCedOpsPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static IdxCedOpsPair parseFrom(CodedInputStream codedInputStream) {
        return (IdxCedOpsPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static IdxCedOpsPair parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (IdxCedOpsPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
