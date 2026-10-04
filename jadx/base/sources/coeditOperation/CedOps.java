package coeditOperation;

import coeditOperation.CoeditOperation;
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
public final class CedOps extends GeneratedMessageLite<CedOps, Builder> implements CedOpsOrBuilder {
    public static final int COEDIT_OPERATION_FIELD_NUMBER = 1;
    private static final CedOps DEFAULT_INSTANCE;
    private static volatile Parser<CedOps> PARSER;
    private Internal.ProtobufList<CoeditOperation> coeditOperation_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: coeditOperation.CedOps$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42811 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1893xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1893xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1893xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1893xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1893xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1893xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1893xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1893xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<CedOps, Builder> implements CedOpsOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder addAllCoeditOperation(Iterable<? extends CoeditOperation> iterable) {
            copyOnWrite();
            ((CedOps) this.instance).addAllCoeditOperation(iterable);
            return this;
        }

        public Builder addCoeditOperation(CoeditOperation coeditOperation2) {
            copyOnWrite();
            ((CedOps) this.instance).addCoeditOperation(coeditOperation2);
            return this;
        }

        public Builder clearCoeditOperation() {
            copyOnWrite();
            ((CedOps) this.instance).clearCoeditOperation();
            return this;
        }

        @Override // coeditOperation.CedOpsOrBuilder
        public CoeditOperation getCoeditOperation(int i) {
            return ((CedOps) this.instance).getCoeditOperation(i);
        }

        @Override // coeditOperation.CedOpsOrBuilder
        public int getCoeditOperationCount() {
            return ((CedOps) this.instance).getCoeditOperationCount();
        }

        @Override // coeditOperation.CedOpsOrBuilder
        public List<CoeditOperation> getCoeditOperationList() {
            return Collections.unmodifiableList(((CedOps) this.instance).getCoeditOperationList());
        }

        public Builder removeCoeditOperation(int i) {
            copyOnWrite();
            ((CedOps) this.instance).removeCoeditOperation(i);
            return this;
        }

        public Builder setCoeditOperation(int i, CoeditOperation coeditOperation2) {
            copyOnWrite();
            ((CedOps) this.instance).setCoeditOperation(i, coeditOperation2);
            return this;
        }

        private Builder() {
            super(CedOps.DEFAULT_INSTANCE);
        }

        public Builder addCoeditOperation(int i, CoeditOperation coeditOperation2) {
            copyOnWrite();
            ((CedOps) this.instance).addCoeditOperation(i, coeditOperation2);
            return this;
        }

        public Builder setCoeditOperation(int i, CoeditOperation.Builder builder) {
            copyOnWrite();
            ((CedOps) this.instance).setCoeditOperation(i, builder.build());
            return this;
        }

        public Builder addCoeditOperation(CoeditOperation.Builder builder) {
            copyOnWrite();
            ((CedOps) this.instance).addCoeditOperation(builder.build());
            return this;
        }

        public Builder addCoeditOperation(int i, CoeditOperation.Builder builder) {
            copyOnWrite();
            ((CedOps) this.instance).addCoeditOperation(i, builder.build());
            return this;
        }
    }

    static {
        CedOps cedOps = new CedOps();
        DEFAULT_INSTANCE = cedOps;
        GeneratedMessageLite.registerDefaultInstance(CedOps.class, cedOps);
    }

    private CedOps() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllCoeditOperation(Iterable<? extends CoeditOperation> iterable) {
        ensureCoeditOperationIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.coeditOperation_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCoeditOperation(CoeditOperation coeditOperation2) {
        coeditOperation2.getClass();
        ensureCoeditOperationIsMutable();
        this.coeditOperation_.add(coeditOperation2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCoeditOperation() {
        this.coeditOperation_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureCoeditOperationIsMutable() {
        Internal.ProtobufList<CoeditOperation> protobufList = this.coeditOperation_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.coeditOperation_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static CedOps getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static CedOps parseDelimitedFrom(InputStream inputStream) {
        return (CedOps) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CedOps parseFrom(ByteBuffer byteBuffer) {
        return (CedOps) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CedOps> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCoeditOperation(int i) {
        ensureCoeditOperationIsMutable();
        this.coeditOperation_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCoeditOperation(int i, CoeditOperation coeditOperation2) {
        coeditOperation2.getClass();
        ensureCoeditOperationIsMutable();
        this.coeditOperation_.set(i, coeditOperation2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42811.f1893xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new CedOps();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"coeditOperation_", CoeditOperation.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CedOps> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (CedOps.class) {
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

    @Override // coeditOperation.CedOpsOrBuilder
    public CoeditOperation getCoeditOperation(int i) {
        return this.coeditOperation_.get(i);
    }

    @Override // coeditOperation.CedOpsOrBuilder
    public int getCoeditOperationCount() {
        return this.coeditOperation_.size();
    }

    @Override // coeditOperation.CedOpsOrBuilder
    public List<CoeditOperation> getCoeditOperationList() {
        return this.coeditOperation_;
    }

    public CoeditOperationOrBuilder getCoeditOperationOrBuilder(int i) {
        return this.coeditOperation_.get(i);
    }

    public List<? extends CoeditOperationOrBuilder> getCoeditOperationOrBuilderList() {
        return this.coeditOperation_;
    }

    public static Builder newBuilder(CedOps cedOps) {
        return DEFAULT_INSTANCE.createBuilder(cedOps);
    }

    public static CedOps parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CedOps) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CedOps parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (CedOps) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CedOps parseFrom(ByteString byteString) {
        return (CedOps) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCoeditOperation(int i, CoeditOperation coeditOperation2) {
        coeditOperation2.getClass();
        ensureCoeditOperationIsMutable();
        this.coeditOperation_.add(i, coeditOperation2);
    }

    public static CedOps parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CedOps) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CedOps parseFrom(byte[] bArr) {
        return (CedOps) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CedOps parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (CedOps) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CedOps parseFrom(InputStream inputStream) {
        return (CedOps) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CedOps parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CedOps) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CedOps parseFrom(CodedInputStream codedInputStream) {
        return (CedOps) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CedOps parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CedOps) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
