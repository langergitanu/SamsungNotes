package coeditOperation;

import com.google.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public enum ChangeType implements Internal.EnumLite {
    INSERT_CHARACTERS(0),
    DELETE_CHARACTERS(1),
    INSERT_ELEMENTS(2),
    DELETE_ELEMENTS(3),
    UPDATE_ATTRIBUTES(4),
    REPLACE_ATTRIBUTES(5),
    SET_ANNOTATIONS(6),
    RETAIN(7),
    INSERT_OBJECT_SPAN(8),
    DELETE_OBJECT_SPAN(9),
    UNRECOGNIZED(-1);

    public static final int DELETE_CHARACTERS_VALUE = 1;
    public static final int DELETE_ELEMENTS_VALUE = 3;
    public static final int DELETE_OBJECT_SPAN_VALUE = 9;
    public static final int INSERT_CHARACTERS_VALUE = 0;
    public static final int INSERT_ELEMENTS_VALUE = 2;
    public static final int INSERT_OBJECT_SPAN_VALUE = 8;
    public static final int REPLACE_ATTRIBUTES_VALUE = 5;
    public static final int RETAIN_VALUE = 7;
    public static final int SET_ANNOTATIONS_VALUE = 6;
    public static final int UPDATE_ATTRIBUTES_VALUE = 4;
    private static final Internal.EnumLiteMap<ChangeType> internalValueMap = new Internal.EnumLiteMap<ChangeType>() { // from class: coeditOperation.ChangeType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public ChangeType findValueByNumber(int i) {
            return ChangeType.forNumber(i);
        }
    };
    private final int value;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ChangeTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new ChangeTypeVerifier();

        private ChangeTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return ChangeType.forNumber(i) != null;
        }
    }

    ChangeType(int i) {
        this.value = i;
    }

    public static ChangeType forNumber(int i) {
        switch (i) {
            case 0:
                return INSERT_CHARACTERS;
            case 1:
                return DELETE_CHARACTERS;
            case 2:
                return INSERT_ELEMENTS;
            case 3:
                return DELETE_ELEMENTS;
            case 4:
                return UPDATE_ATTRIBUTES;
            case 5:
                return REPLACE_ATTRIBUTES;
            case 6:
                return SET_ANNOTATIONS;
            case 7:
                return RETAIN;
            case 8:
                return INSERT_OBJECT_SPAN;
            case 9:
                return DELETE_OBJECT_SPAN;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<ChangeType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return ChangeTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static ChangeType valueOf(int i) {
        return forNumber(i);
    }
}
