package coeditCoreMessage;

import com.google.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public enum ClientCmd implements Internal.EnumLite {
    CONNECT(0),
    DISCONNECT(1),
    SUBMIT(2),
    REFRESH(3),
    GET_DEVICE_LIST(4),
    UNRECOGNIZED(-1);

    public static final int CONNECT_VALUE = 0;
    public static final int DISCONNECT_VALUE = 1;
    public static final int GET_DEVICE_LIST_VALUE = 4;
    public static final int REFRESH_VALUE = 3;
    public static final int SUBMIT_VALUE = 2;
    private static final Internal.EnumLiteMap<ClientCmd> internalValueMap = new Internal.EnumLiteMap<ClientCmd>() { // from class: coeditCoreMessage.ClientCmd.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public ClientCmd findValueByNumber(int i) {
            return ClientCmd.forNumber(i);
        }
    };
    private final int value;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ClientCmdVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new ClientCmdVerifier();

        private ClientCmdVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return ClientCmd.forNumber(i) != null;
        }
    }

    ClientCmd(int i) {
        this.value = i;
    }

    public static ClientCmd forNumber(int i) {
        if (i == 0) {
            return CONNECT;
        }
        if (i == 1) {
            return DISCONNECT;
        }
        if (i == 2) {
            return SUBMIT;
        }
        if (i == 3) {
            return REFRESH;
        }
        if (i != 4) {
            return null;
        }
        return GET_DEVICE_LIST;
    }

    public static Internal.EnumLiteMap<ClientCmd> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return ClientCmdVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static ClientCmd valueOf(int i) {
        return forNumber(i);
    }
}
