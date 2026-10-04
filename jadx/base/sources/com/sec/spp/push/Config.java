package com.sec.spp.push;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Config {
    public static final String DEFAULT_DEREGISTRATION_ID = "com.sec.spp.DeRegistrationFail";
    public static final String DEFAULT_REGISTRATION_ID = "com.sec.spp.RegistrationFail";
    public static final String EXTRA_APPID = "appId";
    public static final String EXTRA_ERROR = "Error";
    public static final String EXTRA_ERROR_CODE = "ErrorCode";
    public static final String EXTRA_ERROR_MESSAGE = "ErrorMessage";
    public static final String EXTRA_PUSH_STATUS = "com.sec.spp.Status";
    public static final String EXTRA_REGID = "RegistrationID";
    public static final String EXTRA_REQTYPE = "reqType";
    public static final String EXTRA_USERDATA = "userdata";
    public static final String KEYVALUE_PACKAGENAME = "packageName=";
    public static final String KEYVALUE_SPLIT = ";";
    public static final String NOTIFICATION_ACK_RESULT_ACTION = "com.sec.spp.NotificationAckResultAction";
    public static final String NOTIFICATION_INTENT_ACK = "ack";
    public static final String NOTIFICATION_INTENT_ACK_RESULT = "ackResult";
    public static final String NOTIFICATION_INTENT_APPID = "appId";
    public static final String NOTIFICATION_INTENT_APP_DATA = "appData";
    public static final String NOTIFICATION_INTENT_CONNECTION_TERM = "connectionTerm";
    public static final String NOTIFICATION_INTENT_MSG = "msg";
    public static final String NOTIFICATION_INTENT_NOTIID = "notificationId";
    public static final String NOTIFICATION_INTENT_SENDER = "sender";
    public static final String NOTIFICATION_INTENT_SESSION_INFO = "sessionInfo";
    public static final String NOTIFICATION_INTENT_TIMESTAMP = "timeStamp";
    public static final int PUSH_DEREGISTRATION_FAIL = 3;
    public static final int PUSH_DEREGISTRATION_SUCCESS = 2;
    public static final String PUSH_REGISTRATION_CHANGED_ACTION = "com.sec.spp.RegistrationChangedAction";
    public static final int PUSH_REGISTRATION_FAIL = 1;
    public static final int PUSH_REGISTRATION_SUCCESS = 0;
    public static final int PUSH_REQ_TYPE_DEFAULT = 0;
    public static final int PUSH_REQ_TYPE_DEREGISTRATION = 2;
    public static final int PUSH_REQ_TYPE_MAX = 3;
    public static final int PUSH_REQ_TYPE_REGISTRATION = 1;
    public static final String PUSH_SERVICE_REQUEST = "com.sec.spp.action.SPP_REQUEST";
    public static final String SERVICE_ABNORMALLY_STOPPED_ACTION = "com.sec.spp.ServiceAbnormallyStoppedAction";
    public static final String SERVICE_DATA_DELETED_ACTION = "com.sec.spp.ServiceDataDeletedAction";
}
