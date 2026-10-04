package com.samsung.android.scloud.lib.setting;

import android.content.Context;
import com.samsung.android.scloud.lib.setting.RPCSyncSettingContract;
import com.samsung.android.scloud.lib.setting.RPCSyncSettingPublicContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SamsungCloudRPCSettingBuilder {
    Context context;
    String dataAuthority;
    String interfaceType;
    String settingAuthority;

    public ISamsungCloudRPCSettingV2 buildV2() {
        return new SamsungCloudRPCSettingV2(this.context, "public".equals(this.interfaceType) ? RPCSyncSettingPublicContract.Method.CONTENT_URI : RPCSyncSettingContract.Method.CONTENT_URI, this.dataAuthority, this.settingAuthority);
    }

    public ISamsungCloudRPCSettingV2Std buildV2Std() {
        return new SamsungCloudRPCSettingV2Std(this.context, "public".equals(this.interfaceType) ? RPCSyncSettingPublicContract.Method.CONTENT_URI : RPCSyncSettingContract.Method.CONTENT_URI, this.dataAuthority, this.settingAuthority);
    }

    public SamsungCloudRPCSettingBuilder setContext(Context context) {
        this.context = context;
        return this;
    }

    public SamsungCloudRPCSettingBuilder setDataAuthority(String str) {
        this.dataAuthority = str;
        return this;
    }

    public SamsungCloudRPCSettingBuilder setInterfaceType(String str) {
        this.interfaceType = str;
        return this;
    }

    public SamsungCloudRPCSettingBuilder setSettingAuthority(String str) {
        this.settingAuthority = str;
        return this;
    }
}
