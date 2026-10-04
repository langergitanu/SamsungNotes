package com.samsung.scsp.framework.core.identity;

import com.google.gson.JsonObject;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.SContextHolder;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.network.Network;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class UserUpdateApiImpl extends AbstractUpdateApi {
    public UserUpdateApiImpl(SContextHolder sContextHolder, FaultBarrier.ThrowableSupplier<String> throwableSupplier) {
        super(sContextHolder, IdentityApiContract.Token.USER, throwableSupplier);
    }

    private void addAppProperties(JsonObject jsonObject, PushInfoList pushInfoList) {
        if (pushInfoList != null) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.add(IdentityApiContract.Parameter.PUSHES, pushInfoList.toJsonArray());
            jsonObject.add("app", jsonObject2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$update$0(PushInfoList pushInfoList, DeviceInfo deviceInfo, HttpRequest httpRequest, Map map, InputStream inputStream) {
        if (Integer.parseInt((String) ((List) map.get(Network.HTTP_STATUS)).get(0)) == 200) {
            saveAppProperties(pushInfoList);
            saveDeviceProperties(deviceInfo);
            this.logger.m12934i("Success to update property");
        }
    }

    private void saveAppProperties(PushInfoList pushInfoList) {
        if (pushInfoList != null) {
            ScspCorePreferences.get().pushInfos.accept(pushInfoList.toJsonArray().toString());
        }
    }

    public void update(PushInfoList pushInfoList, DeviceInfo deviceInfo) {
        JsonObject jsonObject = new JsonObject();
        addDeviceProperties(jsonObject, deviceInfo);
        addAppProperties(jsonObject, pushInfoList);
        this.scontextHolder.network.post(getHttpRequest(jsonObject), new C11659d(this, 1, pushInfoList, deviceInfo));
    }
}
