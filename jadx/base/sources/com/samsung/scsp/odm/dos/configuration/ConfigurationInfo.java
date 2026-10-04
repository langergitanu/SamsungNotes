package com.samsung.scsp.odm.dos.configuration;

import com.google.gson.annotations.SerializedName;
import com.samsung.android.sdk.mobileservice.social.buddy.request.TargetAppListRequest;
import com.samsung.scsp.framework.core.api.DrsSupportableResponse;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ConfigurationInfo implements DrsSupportableResponse {

    @SerializedName(TargetAppListRequest.BundleKey.APPS)
    public List<appInfo> apps;
    public boolean isDrs;
    public String ticketId;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Configuration {

        @SerializedName("file")
        public ConfigurationFile file;

        /* JADX INFO: renamed from: id */
        @SerializedName("id")
        public String f8250id;

        @SerializedName("name")
        public String name;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class appInfo {

        @SerializedName("appId")
        public String appId;

        @SerializedName("changePoint")
        public String changePoint;

        @SerializedName("configurations")
        public List<Configuration> configurations;

        @SerializedName("requestAfter")
        public int requestAfter;
    }

    @Override // com.samsung.scsp.framework.core.api.DrsSupportableResponse
    public void update(boolean z, String str) {
        this.isDrs = z;
        this.ticketId = str;
    }
}
