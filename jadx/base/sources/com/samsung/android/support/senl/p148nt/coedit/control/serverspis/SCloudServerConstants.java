package com.samsung.android.support.senl.p148nt.coedit.control.serverspis;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SCloudServerConstants {
    public static final String APP_VERSION_HEADER = "x-sn-app-ver";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String CID_PARM = "cid";
    private static final String CID_SDOCX = "LeAmLaorme";
    public static final String CONTENT_LENGTH_HEADER = "Content-Length";
    public static final String CONTENT_TYPE_HEADER = "Content-Type";
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String GROUP_ID_HEADER = "x-sc-group-id";
    public static final String MODEL_NAME_HEADER = "x-sn-model-name";
    public static final String NETWORK_INFO_HEADER = "x-sc-network";
    public static final String PATH_COEDIT_GET_JWT_TOKEN = "/token";
    public static final String PATH_COEDIT_V1 = "/coedit/v1";
    public static final String RANGE_HEADER = "Range";
    public static final String REQUEST_ID_HEADER = "x-sc-request-id";
    public static final String SDK_VERSION_HEADER = "x-sn-sdk-ver";
    public static final String USER_AGENT_HEADER = "user-agent";
    public static final String UUID_PARAM = "uuid";
    public static final String WORKSPACEID_PARM = "workspaceId";
    public static final String XML_VERSION_HEADER = "x-sn-xml-ver";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Method {
        public static final String GET = "GET";
        public static final String POST = "POST";
        public static final String PUT = "PUT";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Response {
        public static final String RCODE = "rcode";
    }

    public static String getSDocxCID() {
        return "LeAmLaorme";
    }
}
