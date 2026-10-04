package os_migration_data_types.p233v1;

import com.google.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public enum AttachmentType implements Internal.EnumLite {
    ATTACHMENT_TYPE_UNSPECIFIED(0),
    ATTACHMENT_TYPE_AUDIO(1),
    ATTACHMENT_TYPE_AUDIO_TRANSCRIPT(2),
    ATTACHMENT_TYPE_AUDIO_SUMMARY(3),
    ATTACHMENT_TYPE_AUDIO_CALL_RECORDING(4),
    ATTACHMENT_TYPE_OTHER(5),
    UNRECOGNIZED(-1);

    public static final int ATTACHMENT_TYPE_AUDIO_CALL_RECORDING_VALUE = 4;
    public static final int ATTACHMENT_TYPE_AUDIO_SUMMARY_VALUE = 3;
    public static final int ATTACHMENT_TYPE_AUDIO_TRANSCRIPT_VALUE = 2;
    public static final int ATTACHMENT_TYPE_AUDIO_VALUE = 1;
    public static final int ATTACHMENT_TYPE_OTHER_VALUE = 5;
    public static final int ATTACHMENT_TYPE_UNSPECIFIED_VALUE = 0;
    private static final Internal.EnumLiteMap<AttachmentType> internalValueMap = new Internal.EnumLiteMap<AttachmentType>() { // from class: os_migration_data_types.v1.AttachmentType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public AttachmentType findValueByNumber(int i) {
            return AttachmentType.forNumber(i);
        }
    };
    private final int value;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class AttachmentTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new AttachmentTypeVerifier();

        private AttachmentTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return AttachmentType.forNumber(i) != null;
        }
    }

    AttachmentType(int i) {
        this.value = i;
    }

    public static AttachmentType forNumber(int i) {
        if (i == 0) {
            return ATTACHMENT_TYPE_UNSPECIFIED;
        }
        if (i == 1) {
            return ATTACHMENT_TYPE_AUDIO;
        }
        if (i == 2) {
            return ATTACHMENT_TYPE_AUDIO_TRANSCRIPT;
        }
        if (i == 3) {
            return ATTACHMENT_TYPE_AUDIO_SUMMARY;
        }
        if (i == 4) {
            return ATTACHMENT_TYPE_AUDIO_CALL_RECORDING;
        }
        if (i != 5) {
            return null;
        }
        return ATTACHMENT_TYPE_OTHER;
    }

    public static Internal.EnumLiteMap<AttachmentType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return AttachmentTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static AttachmentType valueOf(int i) {
        return forNumber(i);
    }
}
