package com.samsung.android.scloud.lib.setting;

import android.content.Context;
import android.os.Bundle;
import com.samsung.android.scloud.rpc.ISamsungCloudRPCCallback;
import com.samsung.android.scloud.rpc.SamsungCloudRPCProfile;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
interface ISetting {
    void cancel(String str, ISamsungCloudRPCCallback iSamsungCloudRPCCallback);

    void close(Context context);

    Bundle getProfile(String str, SamsungCloudRPCProfile samsungCloudRPCProfile);

    void showSetting(String str);

    void start(String str, ISamsungCloudRPCCallback iSamsungCloudRPCCallback);

    Bundle switchOnOff(String str, int i);
}
