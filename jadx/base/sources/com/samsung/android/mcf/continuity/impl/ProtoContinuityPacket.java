package com.samsung.android.mcf.continuity.impl;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class ProtoContinuityPacket {

    /* JADX INFO: renamed from: com.samsung.android.mcf.continuity.impl.ProtoContinuityPacket$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C72081 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        public static final /* synthetic */ int[] f4844xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f4844xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4844xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4844xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4844xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4844xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4844xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4844xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ContinuityPacket extends GeneratedMessageLite<ContinuityPacket, Builder> implements ContinuityPacketOrBuilder {
        private static final ContinuityPacket DEFAULT_INSTANCE;
        public static final int ID_FIELD_NUMBER = 2;
        private static volatile Parser<ContinuityPacket> PARSER = null;
        public static final int PAYLOAD_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int id_;
        private ByteString payload_ = ByteString.EMPTY;
        private int type_;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Builder extends GeneratedMessageLite.Builder<ContinuityPacket, Builder> implements ContinuityPacketOrBuilder {
            public /* synthetic */ Builder(C72081 c72081) {
                this();
            }

            public Builder clearId() {
                copyOnWrite();
                ((ContinuityPacket) this.instance).clearId();
                return this;
            }

            public Builder clearPayload() {
                copyOnWrite();
                ((ContinuityPacket) this.instance).clearPayload();
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((ContinuityPacket) this.instance).clearType();
                return this;
            }

            @Override // com.samsung.android.mcf.continuity.impl.ProtoContinuityPacket.ContinuityPacketOrBuilder
            public int getId() {
                return ((ContinuityPacket) this.instance).getId();
            }

            @Override // com.samsung.android.mcf.continuity.impl.ProtoContinuityPacket.ContinuityPacketOrBuilder
            public ByteString getPayload() {
                return ((ContinuityPacket) this.instance).getPayload();
            }

            @Override // com.samsung.android.mcf.continuity.impl.ProtoContinuityPacket.ContinuityPacketOrBuilder
            public int getType() {
                return ((ContinuityPacket) this.instance).getType();
            }

            public Builder setId(int i) {
                copyOnWrite();
                ((ContinuityPacket) this.instance).setId(i);
                return this;
            }

            public Builder setPayload(ByteString byteString) {
                copyOnWrite();
                ((ContinuityPacket) this.instance).setPayload(byteString);
                return this;
            }

            public Builder setType(int i) {
                copyOnWrite();
                ((ContinuityPacket) this.instance).setType(i);
                return this;
            }

            private Builder() {
                super(ContinuityPacket.DEFAULT_INSTANCE);
            }
        }

        static {
            ContinuityPacket continuityPacket = new ContinuityPacket();
            DEFAULT_INSTANCE = continuityPacket;
            GeneratedMessageLite.registerDefaultInstance(ContinuityPacket.class, continuityPacket);
        }

        private ContinuityPacket() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearId() {
            this.id_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPayload() {
            this.payload_ = getDefaultInstance().getPayload();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.type_ = 0;
        }

        public static ContinuityPacket getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ContinuityPacket parseDelimitedFrom(InputStream inputStream) {
            return (ContinuityPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ContinuityPacket parseFrom(ByteBuffer byteBuffer) {
            return (ContinuityPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ContinuityPacket> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setId(int i) {
            this.id_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPayload(ByteString byteString) {
            byteString.getClass();
            this.payload_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(int i) {
            this.type_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            C72081 c72081 = null;
            switch (C72081.f4844xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new ContinuityPacket();
                case 2:
                    return new Builder(c72081);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\n", new Object[]{"type_", "id_", "payload_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ContinuityPacket> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ContinuityPacket.class) {
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

        @Override // com.samsung.android.mcf.continuity.impl.ProtoContinuityPacket.ContinuityPacketOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // com.samsung.android.mcf.continuity.impl.ProtoContinuityPacket.ContinuityPacketOrBuilder
        public ByteString getPayload() {
            return this.payload_;
        }

        @Override // com.samsung.android.mcf.continuity.impl.ProtoContinuityPacket.ContinuityPacketOrBuilder
        public int getType() {
            return this.type_;
        }

        public static Builder newBuilder(ContinuityPacket continuityPacket) {
            return DEFAULT_INSTANCE.createBuilder(continuityPacket);
        }

        public static ContinuityPacket parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ContinuityPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ContinuityPacket parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ContinuityPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ContinuityPacket parseFrom(ByteString byteString) {
            return (ContinuityPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ContinuityPacket parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ContinuityPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ContinuityPacket parseFrom(byte[] bArr) {
            return (ContinuityPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ContinuityPacket parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ContinuityPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ContinuityPacket parseFrom(InputStream inputStream) {
            return (ContinuityPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ContinuityPacket parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ContinuityPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ContinuityPacket parseFrom(CodedInputStream codedInputStream) {
            return (ContinuityPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ContinuityPacket parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ContinuityPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ContinuityPacketOrBuilder extends MessageLiteOrBuilder {
        int getId();

        ByteString getPayload();

        int getType();
    }

    private ProtoContinuityPacket() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
