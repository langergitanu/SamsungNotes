package coeditCoreMessage;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class DeviceInfo extends GeneratedMessageLite<DeviceInfo, Builder> implements DeviceInfoOrBuilder {
    private static final DeviceInfo DEFAULT_INSTANCE;
    public static final int DEVICE_INFO_CHANGE_TYPE_FIELD_NUMBER = 3;
    public static final int DVC_ID_FIELD_NUMBER = 1;
    private static volatile Parser<DeviceInfo> PARSER = null;
    public static final int PERMISSION_TYPE_FIELD_NUMBER = 4;
    public static final int UID_FIELD_NUMBER = 2;
    private int deviceInfoChangeType_;
    private int permissionType_;
    private String dvcId_ = "";
    private String uid_ = "";

    /* JADX INFO: renamed from: coeditCoreMessage.DeviceInfo$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42391 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1867xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1867xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1867xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1867xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1867xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1867xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1867xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1867xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<DeviceInfo, Builder> implements DeviceInfoOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearDeviceInfoChangeType() {
            copyOnWrite();
            ((DeviceInfo) this.instance).clearDeviceInfoChangeType();
            return this;
        }

        public Builder clearDvcId() {
            copyOnWrite();
            ((DeviceInfo) this.instance).clearDvcId();
            return this;
        }

        public Builder clearPermissionType() {
            copyOnWrite();
            ((DeviceInfo) this.instance).clearPermissionType();
            return this;
        }

        public Builder clearUid() {
            copyOnWrite();
            ((DeviceInfo) this.instance).clearUid();
            return this;
        }

        @Override // coeditCoreMessage.DeviceInfoOrBuilder
        public DeviceInfoChangeType getDeviceInfoChangeType() {
            return ((DeviceInfo) this.instance).getDeviceInfoChangeType();
        }

        @Override // coeditCoreMessage.DeviceInfoOrBuilder
        public int getDeviceInfoChangeTypeValue() {
            return ((DeviceInfo) this.instance).getDeviceInfoChangeTypeValue();
        }

        @Override // coeditCoreMessage.DeviceInfoOrBuilder
        public String getDvcId() {
            return ((DeviceInfo) this.instance).getDvcId();
        }

        @Override // coeditCoreMessage.DeviceInfoOrBuilder
        public ByteString getDvcIdBytes() {
            return ((DeviceInfo) this.instance).getDvcIdBytes();
        }

        @Override // coeditCoreMessage.DeviceInfoOrBuilder
        public PermissionType getPermissionType() {
            return ((DeviceInfo) this.instance).getPermissionType();
        }

        @Override // coeditCoreMessage.DeviceInfoOrBuilder
        public int getPermissionTypeValue() {
            return ((DeviceInfo) this.instance).getPermissionTypeValue();
        }

        @Override // coeditCoreMessage.DeviceInfoOrBuilder
        public String getUid() {
            return ((DeviceInfo) this.instance).getUid();
        }

        @Override // coeditCoreMessage.DeviceInfoOrBuilder
        public ByteString getUidBytes() {
            return ((DeviceInfo) this.instance).getUidBytes();
        }

        public Builder setDeviceInfoChangeType(DeviceInfoChangeType deviceInfoChangeType) {
            copyOnWrite();
            ((DeviceInfo) this.instance).setDeviceInfoChangeType(deviceInfoChangeType);
            return this;
        }

        public Builder setDeviceInfoChangeTypeValue(int i) {
            copyOnWrite();
            ((DeviceInfo) this.instance).setDeviceInfoChangeTypeValue(i);
            return this;
        }

        public Builder setDvcId(String str) {
            copyOnWrite();
            ((DeviceInfo) this.instance).setDvcId(str);
            return this;
        }

        public Builder setDvcIdBytes(ByteString byteString) {
            copyOnWrite();
            ((DeviceInfo) this.instance).setDvcIdBytes(byteString);
            return this;
        }

        public Builder setPermissionType(PermissionType permissionType) {
            copyOnWrite();
            ((DeviceInfo) this.instance).setPermissionType(permissionType);
            return this;
        }

        public Builder setPermissionTypeValue(int i) {
            copyOnWrite();
            ((DeviceInfo) this.instance).setPermissionTypeValue(i);
            return this;
        }

        public Builder setUid(String str) {
            copyOnWrite();
            ((DeviceInfo) this.instance).setUid(str);
            return this;
        }

        public Builder setUidBytes(ByteString byteString) {
            copyOnWrite();
            ((DeviceInfo) this.instance).setUidBytes(byteString);
            return this;
        }

        private Builder() {
            super(DeviceInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        DeviceInfo deviceInfo = new DeviceInfo();
        DEFAULT_INSTANCE = deviceInfo;
        GeneratedMessageLite.registerDefaultInstance(DeviceInfo.class, deviceInfo);
    }

    private DeviceInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeviceInfoChangeType() {
        this.deviceInfoChangeType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDvcId() {
        this.dvcId_ = getDefaultInstance().getDvcId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPermissionType() {
        this.permissionType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUid() {
        this.uid_ = getDefaultInstance().getUid();
    }

    public static DeviceInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static DeviceInfo parseDelimitedFrom(InputStream inputStream) {
        return (DeviceInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DeviceInfo parseFrom(ByteBuffer byteBuffer) {
        return (DeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<DeviceInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceInfoChangeType(DeviceInfoChangeType deviceInfoChangeType) {
        this.deviceInfoChangeType_ = deviceInfoChangeType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceInfoChangeTypeValue(int i) {
        this.deviceInfoChangeType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDvcId(String str) {
        str.getClass();
        this.dvcId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDvcIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.dvcId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPermissionType(PermissionType permissionType) {
        this.permissionType_ = permissionType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPermissionTypeValue(int i) {
        this.permissionType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUid(String str) {
        str.getClass();
        this.uid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUidBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.uid_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42391.f1867xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new DeviceInfo();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\f\u0004\f", new Object[]{"dvcId_", "uid_", "deviceInfoChangeType_", "permissionType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DeviceInfo> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (DeviceInfo.class) {
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

    @Override // coeditCoreMessage.DeviceInfoOrBuilder
    public DeviceInfoChangeType getDeviceInfoChangeType() {
        DeviceInfoChangeType deviceInfoChangeTypeForNumber = DeviceInfoChangeType.forNumber(this.deviceInfoChangeType_);
        return deviceInfoChangeTypeForNumber == null ? DeviceInfoChangeType.UNRECOGNIZED : deviceInfoChangeTypeForNumber;
    }

    @Override // coeditCoreMessage.DeviceInfoOrBuilder
    public int getDeviceInfoChangeTypeValue() {
        return this.deviceInfoChangeType_;
    }

    @Override // coeditCoreMessage.DeviceInfoOrBuilder
    public String getDvcId() {
        return this.dvcId_;
    }

    @Override // coeditCoreMessage.DeviceInfoOrBuilder
    public ByteString getDvcIdBytes() {
        return ByteString.copyFromUtf8(this.dvcId_);
    }

    @Override // coeditCoreMessage.DeviceInfoOrBuilder
    public PermissionType getPermissionType() {
        PermissionType permissionTypeForNumber = PermissionType.forNumber(this.permissionType_);
        return permissionTypeForNumber == null ? PermissionType.UNRECOGNIZED : permissionTypeForNumber;
    }

    @Override // coeditCoreMessage.DeviceInfoOrBuilder
    public int getPermissionTypeValue() {
        return this.permissionType_;
    }

    @Override // coeditCoreMessage.DeviceInfoOrBuilder
    public String getUid() {
        return this.uid_;
    }

    @Override // coeditCoreMessage.DeviceInfoOrBuilder
    public ByteString getUidBytes() {
        return ByteString.copyFromUtf8(this.uid_);
    }

    public static Builder newBuilder(DeviceInfo deviceInfo) {
        return DEFAULT_INSTANCE.createBuilder(deviceInfo);
    }

    public static DeviceInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DeviceInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DeviceInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DeviceInfo parseFrom(ByteString byteString) {
        return (DeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static DeviceInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DeviceInfo parseFrom(byte[] bArr) {
        return (DeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DeviceInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (DeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DeviceInfo parseFrom(InputStream inputStream) {
        return (DeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DeviceInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DeviceInfo parseFrom(CodedInputStream codedInputStream) {
        return (DeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DeviceInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
