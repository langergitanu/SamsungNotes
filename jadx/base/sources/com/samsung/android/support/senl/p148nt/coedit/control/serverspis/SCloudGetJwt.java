package com.samsung.android.support.senl.p148nt.coedit.control.serverspis;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.scloud.pam.SCloudPamHelper;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSCloudManager;
import com.samsung.android.support.senl.p148nt.coedit.common.CoeditConstants;
import com.samsung.android.support.senl.p148nt.coedit.control.networkutils.HttpRequestUtil;
import com.samsung.android.support.senl.p148nt.coedit.control.networkutils.SCloudHttpClient;
import com.samsung.android.support.senl.p148nt.coedit.control.networkutils.SCloudHttpResponse;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.scsp.framework.core.ScspException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SCloudGetJwt extends SCloudServerAPI {
    private static final String TAG = "NT/SCloudGetJwt";
    private final String mCid;
    private final String mDocUuid;
    private String mWorkspaceId;

    public SCloudGetJwt(String str, String str2, String str3) {
        this.mAuthorization = str;
        this.mDocUuid = str2;
        this.mGroupId = str3;
        this.mCid = SCloudServerConstants.getSDocxCID();
    }

    private Map<String, String> getRequestHeaders() {
        HashMap map = new HashMap();
        addSCloudCommonHeaders(map);
        map.put(SCloudServerConstants.GROUP_ID_HEADER, this.mGroupId);
        map.put(SCloudServerConstants.REQUEST_ID_HEADER, getRequestId());
        map.put("Content-Type", "application/json");
        return map;
    }

    private String getRequestId() {
        String requestNumber = CoeditUtils.getRequestNumber(this.mWorkspaceId);
        AbstractC8014b.m7223y("[CS3] perform : getRequestId() : ", requestNumber, TAG);
        return requestNumber;
    }

    private Map<String, String> getRequestParams() {
        HashMap map = new HashMap();
        map.put("uuid", this.mDocUuid);
        map.put("cid", this.mCid);
        if (!TextUtils.isEmpty(this.mWorkspaceId)) {
            map.put(SCloudServerConstants.WORKSPACEID_PARM, this.mWorkspaceId);
        }
        return map;
    }

    private String getRequestUrl() {
        StringBuilder sb = new StringBuilder();
        if (CoeditConstants.IS_STG_SERVER) {
            sb.append("https://stg-api.samsungcloud.com/coedit/v1/token");
        } else {
            sb.append(RequestToSCloudManager.INSTANCE.getInstance().getServerUrl("/coedit/v1/token"));
        }
        return sb.toString();
    }

    private GetJwtItem parseJwtJson(String str) {
        if (TextUtils.isEmpty(str)) {
            CoeditLogger.m8920e(TAG, "[CS3-2] parseJwtJson Fail : jsonString is empty!");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new GetJwtItem(jSONObject.getString("jwt"), jSONObject.getString("ownerRegionDomain"));
        } catch (JSONException e) {
            CoeditLogger.m8920e(TAG, "[CS3-2] parseJwtJson Fail " + e.getMessage());
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public GetJwtItem perform() {
        int i;
        CoeditLogger.m8923i(TAG, "[CS3] perform : docUuid = " + this.mDocUuid);
        try {
            SCloudHttpResponse sCloudHttpResponsePost = new SCloudHttpClient().post(getRequestUrl(), getRequestParams(), getRequestHeaders(), "{\"Writable\":true}");
            if (sCloudHttpResponsePost == null) {
                CoeditLogger.m8920e(TAG, "[CS3-2] perform : httpResponse is null!");
                return new GetJwtItem(20);
            }
            if (!HttpRequestUtil.isFailedResponse(sCloudHttpResponsePost.statusCode)) {
                return parseJwtJson(sCloudHttpResponsePost.responseStr);
            }
            int rCode = HttpRequestUtil.parseRCode(sCloudHttpResponsePost.responseStr);
            Context applicationContext = BaseUtils.getApplicationContext();
            CoeditLogger.m8920e(TAG, "[CS3-2] perform : statusCode = " + sCloudHttpResponsePost.statusCode + ", rCode = " + rCode);
            switch (rCode) {
                case ErrorCodeConvertor.CLOUD_BAD_ACCESS_TOKEN /* 19008 */:
                case ErrorCodeConvertor.CLOUD_BAD_ACCESS_TOKEN2 /* 19018 */:
                    Debugger.m8609e(TAG, "[CS3-2] perform : access token is expired!");
                    if (applicationContext != null) {
                        C13541h.m14287e().m14296j();
                    } else {
                        CoeditLogger.m8920e(TAG, "[CS3-2] perform : fail to setAccessTokenExpired because the app context is null");
                    }
                    i = 20;
                    break;
                case ScspException.Code.UNAUTHENTICATED_FOR_SC_V1 /* 101000 */:
                    Debugger.m8609e(TAG, "[CS3-2] perform : SC Access token is expired!");
                    if (applicationContext != null) {
                        C13541h.m14287e().m14296j();
                    } else {
                        CoeditLogger.m8920e(TAG, "[CS3-2] perform : fail to setAccessTokenExpired because the app context is null!");
                    }
                    SCloudPamHelper.handleExpiredCloudToken();
                    i = 20;
                    break;
                case 40000100:
                    i = 1;
                    break;
                case 42600000:
                    i = 2;
                    break;
                case 50300001:
                    i = 3;
                    break;
                default:
                    i = 20;
                    break;
            }
            return new GetJwtItem(i);
        } catch (Exception e) {
            CoeditLogger.m8920e(TAG, "[CS3-2] perform : " + e.getMessage());
            return new GetJwtItem(20);
        }
    }

    public SCloudGetJwt(String str, String str2, String str3, String str4) {
        this(str, str2, str4);
        this.mWorkspaceId = str3;
    }
}
