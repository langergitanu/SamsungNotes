package com.samsung.android.scloud.lib.setting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import com.samsung.android.scloud.lib.setting.RPCSyncSettingContract;
import com.samsung.android.scloud.lib.setting.SyncPerformancePolicy;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class SyncPerformancePolicyManager {
    private static final String TAG = "SyncPerformancePolicyManager";
    private final String authority;
    private final Context context;
    private final Uri rpcUri;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Holder {
        private static final Object LOCK = new Object();
        private static SyncPerformancePolicy performancePolicy = new SyncPerformancePolicy();
        private static AtomicBoolean policyVerificationRequested = new AtomicBoolean(false);

        private Holder() {
        }
    }

    public SyncPerformancePolicyManager(Context context, Uri uri, String str) {
        this.context = context;
        this.rpcUri = uri;
        this.authority = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPolicy$0(Consumer consumer) {
        AbstractC11014a.m12338w(new StringBuilder("loadPolicy start : "), this.authority, TAG);
        synchronized (Holder.LOCK) {
            Holder.performancePolicy.updateStatus(SyncPerformancePolicy.Status.Loading);
        }
        try {
            Log.i(TAG, "loadPolicy: " + onPolicyUpdatedByCloud(this.context.getContentResolver().call(this.rpcUri, RPCSyncSettingContract.Method.GET_PERFORMANCE_POLICY, (String) null, SyncSettingUtil.getRequestExtra(this.authority, false))));
        } finally {
        }
        consumer.accept(getPolicy());
        AbstractC11014a.m12338w(new StringBuilder("loadPolicy completed : "), this.authority, TAG);
    }

    public static SyncPerformancePolicy onPolicyUpdatedByCloud(Bundle bundle) {
        SyncPerformancePolicy syncPerformancePolicyFromBundle = SyncPerformancePolicy.fromBundle(bundle);
        synchronized (Holder.LOCK) {
            Holder.performancePolicy = syncPerformancePolicyFromBundle;
        }
        Log.i(TAG, "onPolicyUpdatedByCloud: " + syncPerformancePolicyFromBundle);
        return syncPerformancePolicyFromBundle;
    }

    public SyncPerformancePolicy getPolicy() {
        SyncPerformancePolicy syncPerformancePolicy;
        synchronized (Holder.LOCK) {
            syncPerformancePolicy = Holder.performancePolicy;
        }
        return syncPerformancePolicy;
    }

    public Pair<List<String>, List<String>> getPolicyLevel(List<String> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Map<String, SyncPerformancePolicy.Level> levelMap = getPolicy().getLevelMap();
        for (String str : list) {
            if (SyncPerformancePolicy.Level.Cloud == levelMap.get(str)) {
                arrayList.add(str);
            } else {
                arrayList2.add(str);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public LocalRequestUnit getRequestUnit(List<String> list) {
        SyncPerformancePolicy policy = getPolicy();
        Map<String, SyncPerformancePolicy.Level> levelMap = policy.getLevelMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        SyncPerformancePolicy.Level level = SyncPerformancePolicy.Level.App;
        SyncPerformancePolicy.Level level2 = level;
        for (String str : list) {
            SyncPerformancePolicy.Level level3 = SyncPerformancePolicy.Level.Cloud;
            if (level3 == levelMap.get(str)) {
                arrayList.add(str);
                level2 = level3;
            } else {
                arrayList2.add(str);
            }
        }
        return new LocalRequestUnit(level2, policy.getStatus() == SyncPerformancePolicy.Status.None ? Holder.policyVerificationRequested.compareAndSet(false, true) : false, policy.getLocalRequestInitialInterval(), policy.getLocalRequestInterval(), arrayList, arrayList2);
    }

    public void loadPolicy(Consumer<SyncPerformancePolicy> consumer) {
        new Thread(new RunnableC7222d(this, consumer, 1)).start();
    }
}
