package coeditCoreMessage;

import com.google.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public enum ServerCmd implements Internal.EnumLite {
    RESPONSE(0),
    NOTIFY(1),
    HEALTH_CHECK(2),
    DISCONNECT_BY_EVENT(3),
    RESPOND_DEVICE_LIST(4),
    WORKSPACE_BLOCK_STATE_CHANGE(5),
    UNRECOGNIZED(-1);

    public static final int DISCONNECT_BY_EVENT_VALUE = 3;
    public static final int HEALTH_CHECK_VALUE = 2;
    public static final int NOTIFY_VALUE = 1;
    public static final int RESPOND_DEVICE_LIST_VALUE = 4;
    public static final int RESPONSE_VALUE = 0;
    public static final int WORKSPACE_BLOCK_STATE_CHANGE_VALUE = 5;
    private static final Internal.EnumLiteMap<ServerCmd> internalValueMap = new Internal.EnumLiteMap<ServerCmd>() { // from class: coeditCoreMessage.ServerCmd.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public ServerCmd findValueByNumber(int i) {
            return ServerCmd.forNumber(i);
        }
    };
    private final int value;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ServerCmdVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new ServerCmdVerifier();

        private ServerCmdVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return ServerCmd.forNumber(i) != null;
        }
    }

    ServerCmd(int i) {
        this.value = i;
    }

    public static ServerCmd forNumber(int i) {
        if (i == 0) {
            return RESPONSE;
        }
        if (i == 1) {
            return NOTIFY;
        }
        if (i == 2) {
            return HEALTH_CHECK;
        }
        if (i == 3) {
            return DISCONNECT_BY_EVENT;
        }
        if (i == 4) {
            return RESPOND_DEVICE_LIST;
        }
        if (i != 5) {
            return null;
        }
        return WORKSPACE_BLOCK_STATE_CHANGE;
    }

    public static Internal.EnumLiteMap<ServerCmd> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return ServerCmdVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static ServerCmd valueOf(int i) {
        return forNumber(i);
    }
}
