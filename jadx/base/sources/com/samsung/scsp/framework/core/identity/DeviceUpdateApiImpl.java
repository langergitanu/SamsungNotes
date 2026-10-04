package com.samsung.scsp.framework.core.identity;

import com.google.gson.JsonObject;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.SContextHolder;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.network.Network;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class DeviceUpdateApiImpl extends AbstractUpdateApi {
    public DeviceUpdateApiImpl(SContextHolder sContextHolder, FaultBarrier.ThrowableSupplier<String> throwableSupplier) {
        super(sContextHolder, "device", throwableSupplier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$update$0(DeviceInfo deviceInfo, HttpRequest httpRequest, Map map, InputStream inputStream) {
        if (Integer.parseInt((String) ((List) map.get(Network.HTTP_STATUS)).get(0)) == 200) {
            saveDeviceProperties(deviceInfo);
            this.logger.m12934i("Success to update property");
        }
    }

    public void update(DeviceInfo deviceInfo) {
        JsonObject jsonObject = new JsonObject();
        addDeviceProperties(jsonObject, deviceInfo);
        this.scontextHolder.network.post(getHttpRequest(jsonObject), new C11658c(this, deviceInfo, 4));
    }
}
