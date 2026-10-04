package com.samsung.android.support.senl.p148nt.livesharing;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class TestConstant {
    public static final String CLIENT_ACTION = "livesharing.client.action";
    public static final String KEY_END_REASON = "end_reason";
    public static final String KEY_MEETING_STATE = "meeting_state";
    public static final String KEY_METHOD = "method";
    public static final String KEY_SHARING_DATA = "data";
    public static final String SERVER_ACTION = "livesharing.server.action";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ClientMethod {
        CONNECT,
        DISCONNECT,
        QUERY_MEETING,
        START_CO_DOING,
        END_CO_DOING,
        SEND_DATA,
        SEND_QUERY_CO_DOING_STATE
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    /* JADX INFO: loaded from: classes5.dex */
    public enum ServerMethod {
        SUCCESS,
        FAILURE,
        END_CONNECTION,
        STATE_CHANGED,
        QUERY_CO_DOING_STATE
    }
}
