package com.samsung.scsp.framework.core.api;

import com.samsung.scsp.framework.core.listeners.Listeners;
import com.samsung.scsp.framework.core.network.HttpRequest;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class EmptyJobImpl implements Job {
    @Override // com.samsung.scsp.framework.core.api.Job
    public HttpRequest createRequest(ApiContext apiContext, Listeners listeners) {
        return null;
    }

    @Override // com.samsung.scsp.framework.core.api.Job
    public void execute(ApiContext apiContext, Listeners listeners) {
    }

    @Override // com.samsung.scsp.framework.core.api.Job
    public String getName() {
        return null;
    }
}
