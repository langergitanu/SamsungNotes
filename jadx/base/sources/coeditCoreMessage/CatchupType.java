package coeditCoreMessage;

import com.google.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public enum CatchupType implements Internal.EnumLite {
    NORMAL_NEW_MEMBER(0),
    ABNORMAL_SUBMIT_ACK_LOST(1),
    ABNORMAL_NOTIFY_LOST(2),
    UNRECOGNIZED(-1);

    public static final int ABNORMAL_NOTIFY_LOST_VALUE = 2;
    public static final int ABNORMAL_SUBMIT_ACK_LOST_VALUE = 1;
    public static final int NORMAL_NEW_MEMBER_VALUE = 0;
    private static final Internal.EnumLiteMap<CatchupType> internalValueMap = new Internal.EnumLiteMap<CatchupType>() { // from class: coeditCoreMessage.CatchupType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public CatchupType findValueByNumber(int i) {
            return CatchupType.forNumber(i);
        }
    };
    private final int value;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CatchupTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new CatchupTypeVerifier();

        private CatchupTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return CatchupType.forNumber(i) != null;
        }
    }

    CatchupType(int i) {
        this.value = i;
    }

    public static CatchupType forNumber(int i) {
        if (i == 0) {
            return NORMAL_NEW_MEMBER;
        }
        if (i == 1) {
            return ABNORMAL_SUBMIT_ACK_LOST;
        }
        if (i != 2) {
            return null;
        }
        return ABNORMAL_NOTIFY_LOST;
    }

    public static Internal.EnumLiteMap<CatchupType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return CatchupTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static CatchupType valueOf(int i) {
        return forNumber(i);
    }
}
