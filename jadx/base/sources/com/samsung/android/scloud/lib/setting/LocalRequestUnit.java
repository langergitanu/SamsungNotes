package com.samsung.android.scloud.lib.setting;

import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.scloud.lib.setting.SyncPerformancePolicy;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class LocalRequestUnit {
    public final List<String> cloudPolicyCidList;
    public final List<String> defaultPolicyCidList;
    final boolean isNeedVerification;
    final SyncPerformancePolicy.Level policyLevel;
    final long requestInitialInterval;
    final long requestInterval;

    public LocalRequestUnit(SyncPerformancePolicy.Level level, boolean z, long j, long j2, List<String> list, List<String> list2) {
        this.policyLevel = level;
        this.isNeedVerification = z;
        this.requestInitialInterval = j;
        this.requestInterval = j2;
        this.cloudPolicyCidList = list;
        this.defaultPolicyCidList = list2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LocalRequestUnit{policyLevel=");
        sb.append(this.policyLevel);
        sb.append(", isNeedVerification=");
        sb.append(this.isNeedVerification);
        sb.append(", requestInitialInterval=");
        sb.append(this.requestInitialInterval);
        sb.append(", requestInterval=");
        sb.append(this.requestInterval);
        sb.append(", cloudPolicyCidList=");
        sb.append(this.cloudPolicyCidList);
        sb.append(", defaultPolicyCidList=");
        return AbstractC1974b.m1321n(sb, this.defaultPolicyCidList, '}');
    }
}
