package com.google.api.client.http;

import com.google.api.client.util.Beta;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
@Deprecated
public interface BackOffPolicy {
    public static final long STOP = -1;

    long getNextBackOffMillis();

    boolean isBackOffRequired(int i);

    void reset();
}
