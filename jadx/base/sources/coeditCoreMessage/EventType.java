package coeditCoreMessage;

import com.google.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public enum EventType implements Internal.EnumLite {
    DELETE_NOTE_RESOURCE(0),
    CHANGE_MEMBER_PERMISSION(1),
    DELETE_MEMBER(2),
    UPDATE_DOCUMENT_XML_VERSION(3),
    UPDATE_APP_VERSION(4),
    IS_SERVER_UNDER_MAINTENANCE(5),
    UNRECOGNIZED(-1);

    public static final int CHANGE_MEMBER_PERMISSION_VALUE = 1;
    public static final int DELETE_MEMBER_VALUE = 2;
    public static final int DELETE_NOTE_RESOURCE_VALUE = 0;
    public static final int IS_SERVER_UNDER_MAINTENANCE_VALUE = 5;
    public static final int UPDATE_APP_VERSION_VALUE = 4;
    public static final int UPDATE_DOCUMENT_XML_VERSION_VALUE = 3;
    private static final Internal.EnumLiteMap<EventType> internalValueMap = new Internal.EnumLiteMap<EventType>() { // from class: coeditCoreMessage.EventType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public EventType findValueByNumber(int i) {
            return EventType.forNumber(i);
        }
    };
    private final int value;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class EventTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new EventTypeVerifier();

        private EventTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return EventType.forNumber(i) != null;
        }
    }

    EventType(int i) {
        this.value = i;
    }

    public static EventType forNumber(int i) {
        if (i == 0) {
            return DELETE_NOTE_RESOURCE;
        }
        if (i == 1) {
            return CHANGE_MEMBER_PERMISSION;
        }
        if (i == 2) {
            return DELETE_MEMBER;
        }
        if (i == 3) {
            return UPDATE_DOCUMENT_XML_VERSION;
        }
        if (i == 4) {
            return UPDATE_APP_VERSION;
        }
        if (i != 5) {
            return null;
        }
        return IS_SERVER_UNDER_MAINTENANCE;
    }

    public static Internal.EnumLiteMap<EventType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return EventTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static EventType valueOf(int i) {
        return forNumber(i);
    }
}
