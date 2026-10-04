package com.samsung.android.scloud.lib.setting;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.compose.runtime.AbstractC1974b;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.scloud.lib.setting.RPCSyncSettingContract;
import com.samsung.android.scloud.lib.setting.SyncPerformancePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class LibSyncScheduleManager {
    private static final String TAG = "LibSyncScheduleManager";
    private final String authority;
    private final Context context;
    private final SyncPerformancePolicyManager performancePolicyManager;
    private final Uri rpcUri;
    private final Uri syncUri;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CountUnit {
        private int value = 0;

        public void addCount() {
            this.value++;
        }

        public String toString() {
            return AbstractC0000a.m13j(new StringBuilder("CountUnit{value="), this.value, '}');
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RequestTask extends TimerTask {
        private static final long[] taskCount = {0};
        private final String authority;
        private final Context context;
        private final SyncPerformancePolicyManager policyManager;
        private final long requestStartTime;
        private final Uri rpcUri;

        public RequestTask(Context context, Uri uri, String str, SyncPerformancePolicyManager syncPerformancePolicyManager, long j, long j2) {
            this.context = context;
            this.rpcUri = uri;
            this.authority = str;
            this.policyManager = syncPerformancePolicyManager;
            this.requestStartTime = j;
            StringBuilder sbM1323p = AbstractC1974b.m1323p(j2, "request task pending start: ", ",");
            sbM1323p.append(increaseTaskCount());
            Log.d(LibSyncScheduleManager.TAG, sbM1323p.toString());
        }

        private static synchronized long decreaseTaskCount() {
            long j;
            long[] jArr = taskCount;
            j = jArr[0] - 1;
            jArr[0] = j;
            return j;
        }

        private static synchronized long increaseTaskCount() {
            long j;
            long[] jArr = taskCount;
            j = jArr[0] + 1;
            jArr[0] = j;
            return j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$0(SyncPerformancePolicy syncPerformancePolicy) {
            Log.i(LibSyncScheduleManager.TAG, "RequestTask - policy was reloaded after sync request failure, " + syncPerformancePolicy);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            RequestPendingStatus requestPendingStatusReleasePendingRequest = LibSyncScheduleManager.releasePendingRequest(this.requestStartTime);
            boolean zProcessRequest = LibSyncScheduleManager.processRequest(this.context, this.rpcUri, this.authority, requestPendingStatusReleasePendingRequest);
            Log.d(LibSyncScheduleManager.TAG, "request task pending finish: " + (System.currentTimeMillis() - this.requestStartTime) + "," + requestPendingStatusReleasePendingRequest + "," + zProcessRequest);
            decreaseTaskCount();
            if (zProcessRequest) {
                return;
            }
            this.policyManager.loadPolicy(new C7219a(1));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Static {
        private static final RequestPendingStatus pendingRequest = new RequestPendingStatus();
        private static long totalRequestCount = 0;
        private static Timer requestTimer = new Timer();
        private static final ExecutorService singleRequestHandler = Executors.newSingleThreadExecutor();

        private Static() {
        }
    }

    public LibSyncScheduleManager(Context context, Uri uri, String str) {
        this.context = context;
        this.rpcUri = uri;
        this.authority = str;
        this.syncUri = Uri.parse(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME + str);
        this.performancePolicyManager = new SyncPerformancePolicyManager(context, uri, str);
    }

    public static long getTotalRequestCount() {
        long j;
        synchronized (Static.class) {
            j = Static.totalRequestCount;
        }
        return j;
    }

    private void handleRequest(LocalRequestUnit localRequestUnit) {
        if (localRequestUnit.policyLevel == SyncPerformancePolicy.Level.Cloud) {
            requestCloud(localRequestUnit);
        } else {
            requestApp(localRequestUnit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleSingleRequest, reason: merged with bridge method [inline-methods] */
    public void lambda$requestCloud$2(RequestPendingStatus requestPendingStatus) {
        boolean zProcessRequest = processRequest(this.context, this.rpcUri, this.authority, requestPendingStatus);
        Log.d(TAG, "request with no pending - " + requestPendingStatus + "," + zProcessRequest);
        if (zProcessRequest) {
            return;
        }
        this.performancePolicyManager.loadPolicy(new C7219a(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleSingleRequest$3(SyncPerformancePolicy syncPerformancePolicy) {
        Log.i(TAG, "no pending request failed - policy was reloaded after sync request failure, " + syncPerformancePolicy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$processRequest$4(CountUnit countUnit) {
        return Integer.valueOf(countUnit.value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$request$0(List list, SyncPerformancePolicy syncPerformancePolicy) {
        LocalRequestUnit requestUnit = this.performancePolicyManager.getRequestUnit(list);
        Log.i(TAG, "handle request after policy verification: " + syncPerformancePolicy + " , " + requestUnit);
        handleRequest(requestUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$request$1(final List list, final SyncPerformancePolicy syncPerformancePolicy) {
        new Thread(new Runnable() { // from class: com.samsung.android.scloud.lib.setting.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f4848a.lambda$request$0(list, syncPerformancePolicy);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1095)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1049)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:130)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    public static boolean processRequest(Context context, Uri uri, String str, RequestPendingStatus requestPendingStatus) {
        boolean z;
        Bundle requestExtra = SyncSettingUtil.getRequestExtra(str);
        ArrayList<String> arrayList = new ArrayList<>(requestPendingStatus.mainCidSet);
        ArrayList<String> arrayList2 = new ArrayList<>(requestPendingStatus.extraCidSet);
        ArrayList<Integer> arrayList3 = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            arrayList3.add((Integer) Optional.ofNullable(requestPendingStatus.pendingRequestCountMap.get(it.next())).map(new C7221c(0)).orElse(0));
        }
        requestExtra.putStringArrayList(RPCSyncSettingContract.Parameter.CONTENT_IDS, arrayList);
        requestExtra.putStringArrayList(RPCSyncSettingContract.Parameter.EXTRA_CONTENT_IDS, arrayList2);
        requestExtra.putLong(RPCSyncSettingContract.Parameter.LOCAL_SYNC_FIRST_REQUEST_TIME, requestPendingStatus.firstRequestTime);
        requestExtra.putLong(RPCSyncSettingContract.Parameter.LOCAL_SYNC_LAST_REQUEST_TIME, requestPendingStatus.lastRequestTime);
        requestExtra.putIntegerArrayList(RPCSyncSettingContract.Parameter.PENDING_REQUEST_COUNTS, arrayList3);
        if (context.getContentResolver().call(uri, RPCSyncSettingContract.Method.REQUEST_LOCAL_SYNC, (String) null, requestExtra) == null) {
            Log.i(TAG, "processRequest: failed. need to reload sync performance policy");
        } else {
            z = true;
        }
        synchronized (Static.class) {
            Static.totalRequestCount += (long) requestPendingStatus.requestCount;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RequestPendingStatus releasePendingRequest(long j) {
        RequestPendingStatus requestPendingStatusRelease;
        synchronized (LibSyncScheduleManager.class) {
            requestPendingStatusRelease = Static.pendingRequest.release(j);
        }
        return requestPendingStatusRelease;
    }

    private void requestApp(LocalRequestUnit localRequestUnit) {
        Log.d(TAG, "requestApp: " + localRequestUnit.defaultPolicyCidList);
        this.context.getContentResolver().notifyChange(this.syncUri, (ContentObserver) null, 1);
    }

    private void requestCloud(LocalRequestUnit localRequestUnit) {
        long jCurrentTimeMillis;
        boolean z;
        long j;
        long j2 = localRequestUnit.requestInitialInterval;
        long j3 = localRequestUnit.requestInterval;
        StringBuilder sbM1323p = AbstractC1974b.m1323p(j2, "requestCloud: ", ",");
        sbM1323p.append(j3);
        sbM1323p.append(",");
        sbM1323p.append(localRequestUnit.cloudPolicyCidList);
        sbM1323p.append(",");
        sbM1323p.append(localRequestUnit.defaultPolicyCidList);
        Log.d(TAG, sbM1323p.toString());
        synchronized (LibSyncScheduleManager.class) {
            try {
                jCurrentTimeMillis = System.currentTimeMillis();
                if (Static.pendingRequest.pendingRequestCountMap.isEmpty()) {
                    j = jCurrentTimeMillis - Static.pendingRequest.lastRequestTime;
                    z = true;
                    if (j >= j3) {
                        j = -1;
                    }
                } else {
                    z = false;
                    j = 0;
                }
                Static.pendingRequest.addPendingUpload(localRequestUnit);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            if (j >= 0) {
                long j5 = j3 - j;
                Static.requestTimer.schedule(new RequestTask(this.context, this.rpcUri, this.authority, this.performancePolicyManager, jCurrentTimeMillis, j5), j5);
            } else if (j2 > 0) {
                Static.requestTimer.schedule(new RequestTask(this.context, this.rpcUri, this.authority, this.performancePolicyManager, jCurrentTimeMillis, j2), j2);
            } else {
                Static.singleRequestHandler.submit(new RunnableC7222d(this, releasePendingRequest(jCurrentTimeMillis), 0));
            }
        }
    }

    public void request(final List<String> list) {
        LocalRequestUnit requestUnit = this.performancePolicyManager.getRequestUnit(list);
        Log.d(TAG, "request entry : " + requestUnit);
        if (requestUnit.isNeedVerification) {
            this.performancePolicyManager.loadPolicy(new Consumer() { // from class: com.samsung.android.scloud.lib.setting.e
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f4855a.lambda$request$1(list, (SyncPerformancePolicy) obj);
                }
            });
        } else {
            handleRequest(requestUnit);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RequestPendingStatus {
        Set<String> extraCidSet;
        long firstRequestTime;
        long lastRequestTime;
        Set<String> mainCidSet;
        Map<String, CountUnit> pendingRequestCountMap;
        int requestCount;

        public RequestPendingStatus() {
            this.mainCidSet = new LinkedHashSet();
            this.extraCidSet = new LinkedHashSet();
            this.firstRequestTime = 0L;
            this.lastRequestTime = 0L;
            this.pendingRequestCountMap = new HashMap();
            this.requestCount = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ CountUnit lambda$addPendingUpload$0(String str) {
            return new CountUnit();
        }

        public void addPendingUpload(LocalRequestUnit localRequestUnit) {
            this.requestCount++;
            for (String str : localRequestUnit.cloudPolicyCidList) {
                this.mainCidSet.add(str);
                this.pendingRequestCountMap.computeIfAbsent(str, new C7221c(1)).addCount();
            }
            this.extraCidSet.addAll(localRequestUnit.defaultPolicyCidList);
        }

        public RequestPendingStatus release(long j) {
            Set<String> set = this.mainCidSet;
            Set<String> set2 = this.extraCidSet;
            Map<String, CountUnit> map = this.pendingRequestCountMap;
            int i = this.requestCount;
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.lastRequestTime = jCurrentTimeMillis;
            if (j <= 0) {
                j = jCurrentTimeMillis;
            }
            this.firstRequestTime = j;
            this.mainCidSet = new LinkedHashSet();
            this.extraCidSet = new LinkedHashSet();
            this.pendingRequestCountMap = new HashMap();
            this.requestCount = 0;
            return new RequestPendingStatus(set, set2, this.firstRequestTime, this.lastRequestTime, map, i);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("RequestPendingStatus{mainCidSet=");
            sb.append(this.mainCidSet);
            sb.append(", extraCidSet=");
            sb.append(this.extraCidSet);
            sb.append(", firstRequestTime=");
            sb.append(this.firstRequestTime);
            sb.append(", lastRequestTime=");
            sb.append(this.lastRequestTime);
            sb.append(", pendingRequestCountMap=");
            sb.append(this.pendingRequestCountMap);
            sb.append(", requestCount=");
            return AbstractC0000a.m13j(sb, this.requestCount, '}');
        }

        private RequestPendingStatus(Set<String> set, Set<String> set2, long j, long j2, Map<String, CountUnit> map, int i) {
            this.mainCidSet = set;
            this.extraCidSet = set2;
            this.firstRequestTime = j;
            this.lastRequestTime = j2;
            this.pendingRequestCountMap = map;
            this.requestCount = i;
        }
    }
}
