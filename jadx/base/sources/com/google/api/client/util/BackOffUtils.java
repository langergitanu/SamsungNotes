package com.google.api.client.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public final class BackOffUtils {
    private BackOffUtils() {
    }

    public static boolean next(Sleeper sleeper, BackOff backOff) {
        long jNextBackOffMillis = backOff.nextBackOffMillis();
        if (jNextBackOffMillis == -1) {
            return false;
        }
        sleeper.sleep(jNextBackOffMillis);
        return true;
    }
}
