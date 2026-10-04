package coeditCoreMessage;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class PermissionRequest extends GeneratedMessageLite<PermissionRequest, Builder> implements PermissionRequestOrBuilder {
    private static final PermissionRequest DEFAULT_INSTANCE;
    private static volatile Parser<PermissionRequest> PARSER = null;
    public static final int PERMISSION_TYPE_FIELD_NUMBER = 1;
    private int permissionType_;

    /* JADX INFO: renamed from: coeditCoreMessage.PermissionRequest$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42441 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1870xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1870xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1870xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1870xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1870xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1870xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1870xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1870xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<PermissionRequest, Builder> implements PermissionRequestOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearPermissionType() {
            copyOnWrite();
            ((PermissionRequest) this.instance).clearPermissionType();
            return this;
        }

        @Override // coeditCoreMessage.PermissionRequestOrBuilder
        public PermissionType getPermissionType() {
            return ((PermissionRequest) this.instance).getPermissionType();
        }

        @Override // coeditCoreMessage.PermissionRequestOrBuilder
        public int getPermissionTypeValue() {
            return ((PermissionRequest) this.instance).getPermissionTypeValue();
        }

        public Builder setPermissionType(PermissionType permissionType) {
            copyOnWrite();
            ((PermissionRequest) this.instance).setPermissionType(permissionType);
            return this;
        }

        public Builder setPermissionTypeValue(int i) {
            copyOnWrite();
            ((PermissionRequest) this.instance).setPermissionTypeValue(i);
            return this;
        }

        private Builder() {
            super(PermissionRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        PermissionRequest permissionRequest = new PermissionRequest();
        DEFAULT_INSTANCE = permissionRequest;
        GeneratedMessageLite.registerDefaultInstance(PermissionRequest.class, permissionRequest);
    }

    private PermissionRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPermissionType() {
        this.permissionType_ = 0;
    }

    public static PermissionRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PermissionRequest parseDelimitedFrom(InputStream inputStream) {
        return (PermissionRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PermissionRequest parseFrom(ByteBuffer byteBuffer) {
        return (PermissionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PermissionRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPermissionType(PermissionType permissionType) {
        this.permissionType_ = permissionType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPermissionTypeValue(int i) {
        this.permissionType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42441.f1870xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new PermissionRequest();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"permissionType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PermissionRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PermissionRequest.class) {
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

    @Override // coeditCoreMessage.PermissionRequestOrBuilder
    public PermissionType getPermissionType() {
        PermissionType permissionTypeForNumber = PermissionType.forNumber(this.permissionType_);
        return permissionTypeForNumber == null ? PermissionType.UNRECOGNIZED : permissionTypeForNumber;
    }

    @Override // coeditCoreMessage.PermissionRequestOrBuilder
    public int getPermissionTypeValue() {
        return this.permissionType_;
    }

    public static Builder newBuilder(PermissionRequest permissionRequest) {
        return DEFAULT_INSTANCE.createBuilder(permissionRequest);
    }

    public static PermissionRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PermissionRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PermissionRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PermissionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PermissionRequest parseFrom(ByteString byteString) {
        return (PermissionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PermissionRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PermissionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PermissionRequest parseFrom(byte[] bArr) {
        return (PermissionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PermissionRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PermissionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PermissionRequest parseFrom(InputStream inputStream) {
        return (PermissionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PermissionRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PermissionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PermissionRequest parseFrom(CodedInputStream codedInputStream) {
        return (PermissionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PermissionRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PermissionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
