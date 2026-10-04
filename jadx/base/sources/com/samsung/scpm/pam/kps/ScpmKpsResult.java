package com.samsung.scpm.pam.kps;

import android.os.Bundle;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.scloud.rpc.SamsungCloudRPCStatus;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ScpmKpsResult {
    public final int rcode;
    public final int result;
    public final String rmsg;
    protected final String tag = "[SCPMSDK][1.0.1101][ScpmKps]";

    public ScpmKpsResult(Bundle bundle) {
        int i = bundle.getInt("rcode", SamsungCloudRPCStatus.Value.FAILED_INTERNAL_AGENT_ERROR);
        this.rcode = i;
        String string = bundle.getString("rmsg", "no rmsg from bundle.");
        this.rmsg = string;
        int i2 = bundle.getInt("result", 2);
        this.result = i2;
        AbstractC4539a.m3209s(AbstractC0622a.m1173s(i2, i, "result = ", ", rcode = ", ", rmsg = "), string, Extension.DOT, "[SCPMSDK][1.0.1101][ScpmKps]");
    }
}
