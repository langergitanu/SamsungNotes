package com.google.firebase.heartbeatinfo;

import com.google.auto.value.AutoValue;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@AutoValue
public abstract class HeartBeatResult {
    public static HeartBeatResult create(String str, List<String> list) {
        return new AutoValue_HeartBeatResult(str, list);
    }

    public abstract List<String> getUsedDates();

    public abstract String getUserAgent();
}
