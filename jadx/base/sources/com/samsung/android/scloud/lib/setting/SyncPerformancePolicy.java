package com.samsung.android.scloud.lib.setting;

import android.os.Bundle;
import com.samsung.android.scloud.lib.setting.RPCSyncSettingContract;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class SyncPerformancePolicy {
    public static final long DEFAULT_LOCAL_REQUEST_INITIAL_INTERVAL_IN_MS = 0;
    public static final long DEFAULT_LOCAL_REQUEST_INTERVAL_IN_MS = 1000;
    private Status status = Status.None;
    private final Map<String, Level> levelMap = new HashMap();
    private long localRequestInitialInterval = 0;
    private long localRequestInterval = 1000;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Level {
        App,
        Cloud
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Status {
        None,
        Loading,
        Loaded,
        NotLoaded
    }

    public static SyncPerformancePolicy fromBundle(Bundle bundle) {
        SyncPerformancePolicy syncPerformancePolicy = new SyncPerformancePolicy();
        syncPerformancePolicy.status = Status.Loaded;
        ArrayList<String> stringArrayList = bundle.getStringArrayList(RPCSyncSettingContract.Parameter.CONTENT_IDS);
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(RPCSyncSettingContract.Parameter.POLICY_STATUS_LIST);
        int iIntValue = ((Integer) Optional.ofNullable(stringArrayList).map(new C7221c(2)).orElse(0)).intValue();
        int iIntValue2 = ((Integer) Optional.ofNullable(integerArrayList).map(new C7221c(2)).orElse(0)).intValue();
        if (iIntValue > 0 && iIntValue == iIntValue2) {
            for (int i = 0; i < stringArrayList.size(); i++) {
                syncPerformancePolicy.levelMap.put(stringArrayList.get(i), integerArrayList.get(i).intValue() == 1 ? Level.Cloud : Level.App);
            }
        }
        syncPerformancePolicy.localRequestInitialInterval = bundle.getLong(RPCSyncSettingContract.Parameter.LOCAL_REQUEST_INITIAL_INTERVAL, 0L);
        syncPerformancePolicy.localRequestInterval = bundle.getLong(RPCSyncSettingContract.Parameter.LOCAL_REQUEST_INTERVAL, 1000L);
        return syncPerformancePolicy;
    }

    public Map<String, Level> getLevelMap() {
        return this.levelMap;
    }

    public long getLocalRequestInitialInterval() {
        return this.localRequestInitialInterval;
    }

    public long getLocalRequestInterval() {
        return this.localRequestInterval;
    }

    public Status getStatus() {
        return this.status;
    }

    public String toString() {
        return "SyncPerformancePolicy{levelMap=" + this.levelMap + ", localRequestInitialInterval=" + this.localRequestInitialInterval + ", localRequestInterval=" + this.localRequestInterval + ", status=" + this.status + '}';
    }

    public void updateStatus(Status status) {
        this.status = status;
    }
}
