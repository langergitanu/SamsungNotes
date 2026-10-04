package coeditCoreMessage;

import com.google.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public enum DeviceInfoChangeType implements Internal.EnumLite {
    DEVICE_CONNECT(0),
    DEVICE_DISCONNECT(1),
    DEVICE_PERMISSION_CHANGE(2),
    UNRECOGNIZED(-1);

    public static final int DEVICE_CONNECT_VALUE = 0;
    public static final int DEVICE_DISCONNECT_VALUE = 1;
    public static final int DEVICE_PERMISSION_CHANGE_VALUE = 2;
    private static final Internal.EnumLiteMap<DeviceInfoChangeType> internalValueMap = new Internal.EnumLiteMap<DeviceInfoChangeType>() { // from class: coeditCoreMessage.DeviceInfoChangeType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public DeviceInfoChangeType findValueByNumber(int i) {
            return DeviceInfoChangeType.forNumber(i);
        }
    };
    private final int value;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DeviceInfoChangeTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new DeviceInfoChangeTypeVerifier();

        private DeviceInfoChangeTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return DeviceInfoChangeType.forNumber(i) != null;
        }
    }

    DeviceInfoChangeType(int i) {
        this.value = i;
    }

    public static DeviceInfoChangeType forNumber(int i) {
        if (i == 0) {
            return DEVICE_CONNECT;
        }
        if (i == 1) {
            return DEVICE_DISCONNECT;
        }
        if (i != 2) {
            return null;
        }
        return DEVICE_PERMISSION_CHANGE;
    }

    public static Internal.EnumLiteMap<DeviceInfoChangeType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return DeviceInfoChangeTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static DeviceInfoChangeType valueOf(int i) {
        return forNumber(i);
    }
}
