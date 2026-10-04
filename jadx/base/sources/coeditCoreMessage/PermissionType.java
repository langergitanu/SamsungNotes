package coeditCoreMessage;

import com.google.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public enum PermissionType implements Internal.EnumLite {
    VIEW(0),
    EDIT(1),
    UNRECOGNIZED(-1);

    public static final int EDIT_VALUE = 1;
    public static final int VIEW_VALUE = 0;
    private static final Internal.EnumLiteMap<PermissionType> internalValueMap = new Internal.EnumLiteMap<PermissionType>() { // from class: coeditCoreMessage.PermissionType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public PermissionType findValueByNumber(int i) {
            return PermissionType.forNumber(i);
        }
    };
    private final int value;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PermissionTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PermissionTypeVerifier();

        private PermissionTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return PermissionType.forNumber(i) != null;
        }
    }

    PermissionType(int i) {
        this.value = i;
    }

    public static PermissionType forNumber(int i) {
        if (i == 0) {
            return VIEW;
        }
        if (i != 1) {
            return null;
        }
        return EDIT;
    }

    public static Internal.EnumLiteMap<PermissionType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PermissionTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static PermissionType valueOf(int i) {
        return forNumber(i);
    }
}
