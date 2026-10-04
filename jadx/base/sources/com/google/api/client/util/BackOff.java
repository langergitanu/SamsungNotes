package com.google.api.client.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface BackOff {
    public static final long STOP = -1;
    public static final BackOff ZERO_BACKOFF = new BackOff() { // from class: com.google.api.client.util.BackOff.1
        @Override // com.google.api.client.util.BackOff
        public long nextBackOffMillis() {
            return 0L;
        }

        @Override // com.google.api.client.util.BackOff
        public void reset() {
        }
    };
    public static final BackOff STOP_BACKOFF = new BackOff() { // from class: com.google.api.client.util.BackOff.2
        @Override // com.google.api.client.util.BackOff
        public long nextBackOffMillis() {
            return -1L;
        }

        @Override // com.google.api.client.util.BackOff
        public void reset() {
        }
    };

    long nextBackOffMillis();

    void reset();
}
