package com.samsung.scsp.pam.kps.lite;

import com.samsung.scsp.framework.core.api.Get;
import com.samsung.scsp.framework.core.api.Post;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface KpsLiteApiSpec {
    public static final String API_BASE_DISTRIBUTION = "/kps/v2/distribution/keys";
    public static final String API_BASE_INFO = "/kps/v2/info";
    public static final String API_BASE_MANAGE = "/kps/v2/manage";
    public static final String API_BASE_STATISTICS = "/kps/v2/statistics";

    @Post(response = KpsGroupStateVo.class, value = "/kps/v2/manage/sks/check-essential?serviceId={serviceId}")
    public static final String CHECK_ESSENTIAL_DATA = "CHECK_ESSENTIAL_DATA";

    @Post(response = KpsCertificateChain.class, value = "/kps/v2/manage/certificate-chain")
    public static final String GET_CERTIFICATE_CHAIN = "GET_CERTIFICATE_CHAIN";

    @Get(response = KpsState.class, value = "/kps/v2/manage/groups")
    public static final String GET_GROUP_STATE = "GET_GROUP_STATE";

    @Get(jobImpl = KpsGetPolicyJobImpl.class, response = KpsPolicies.class, value = "/kps/v2/info/policy")
    public static final String GET_POLICY = "GET_POLICY";

    @Get(response = KpsServiceKeyVo.class, value = "/kps/v2/distribution/keys/service/wrapped-service-key")
    public static final String GET_SERVICE_KEY = "JOIN";

    @Post(response = KpsRequestKeyVo.class, value = "/kps/v2/distribution/keys/service/request?e2eeGroupId={e2eeGroupId}&serviceId={serviceId}")
    public static final String REQUEST_SERVICE_KEY = "REQUEST_SERVICE_KEY";

    @Post("/kps/v2/statistics/service-key-secured")
    public static final String SET_SERVICE_KEY_SECURED_STATISTICS = "SET_SERVICE_KEY_SECURED_STATISTICS";

    @Post("/kps/v2/manage/sks/groups/{e2eeGroupId}/state/off")
    public static final String STATE_OFF = "STATE_OFF";
}
