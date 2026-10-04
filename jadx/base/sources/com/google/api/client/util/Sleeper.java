package com.google.api.client.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface Sleeper {
    public static final Sleeper DEFAULT = new Sleeper() { // from class: com.google.api.client.util.Sleeper.1
        @Override // com.google.api.client.util.Sleeper
        public void sleep(long j) throws InterruptedException {
            Thread.sleep(j);
        }
    };

    void sleep(long j);
}
