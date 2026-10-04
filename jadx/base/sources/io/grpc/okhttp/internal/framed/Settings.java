package io.grpc.okhttp.internal.framed;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class Settings {
    static final int CLIENT_CERTIFICATE_VECTOR_SIZE = 8;
    static final int COUNT = 10;
    static final int CURRENT_CWND = 5;
    static final int DEFAULT_INITIAL_WINDOW_SIZE = 65536;
    static final int DOWNLOAD_BANDWIDTH = 2;
    static final int DOWNLOAD_RETRANS_RATE = 6;
    public static final int ENABLE_PUSH = 2;
    static final int FLAG_CLEAR_PREVIOUSLY_PERSISTED_SETTINGS = 1;
    static final int FLOW_CONTROL_OPTIONS = 10;
    static final int FLOW_CONTROL_OPTIONS_DISABLED = 1;
    static final int HEADER_TABLE_SIZE = 1;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    static final int MAX_FRAME_SIZE = 5;
    public static final int MAX_HEADER_LIST_SIZE = 6;
    static final int PERSISTED = 2;
    static final int PERSIST_VALUE = 1;
    static final int ROUND_TRIP_TIME = 3;
    static final int UPLOAD_BANDWIDTH = 1;
    private int persistValue;
    private int persisted;
    private int set;
    private final int[] values = new int[10];

    public void clear() {
        this.persisted = 0;
        this.persistValue = 0;
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    public int flags(int i) {
        int i2 = isPersisted(i) ? 2 : 0;
        return persistValue(i) ? i2 | 1 : i2;
    }

    public int get(int i) {
        return this.values[i];
    }

    public int getClientCertificateVectorSize(int i) {
        return (this.set & 256) != 0 ? this.values[8] : i;
    }

    public int getCurrentCwnd(int i) {
        return (this.set & 32) != 0 ? this.values[5] : i;
    }

    public int getDownloadBandwidth(int i) {
        return (this.set & 4) != 0 ? this.values[2] : i;
    }

    public int getDownloadRetransRate(int i) {
        return (this.set & 64) != 0 ? this.values[6] : i;
    }

    public boolean getEnablePush(boolean z) {
        return ((this.set & 4) != 0 ? this.values[2] : z ? 1 : 0) == 1;
    }

    public int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    public int getInitialWindowSize(int i) {
        return (this.set & 128) != 0 ? this.values[7] : i;
    }

    public int getMaxConcurrentStreams(int i) {
        return (this.set & 16) != 0 ? this.values[4] : i;
    }

    public int getMaxFrameSize(int i) {
        return (this.set & 32) != 0 ? this.values[5] : i;
    }

    public int getMaxHeaderListSize(int i) {
        return (this.set & 64) != 0 ? this.values[6] : i;
    }

    public int getRoundTripTime(int i) {
        return (this.set & 8) != 0 ? this.values[3] : i;
    }

    public int getUploadBandwidth(int i) {
        return (this.set & 2) != 0 ? this.values[1] : i;
    }

    public boolean isFlowControlDisabled() {
        return (((this.set & 1024) != 0 ? this.values[10] : 0) & 1) != 0;
    }

    public boolean isPersisted(int i) {
        return ((1 << i) & this.persisted) != 0;
    }

    public boolean isSet(int i) {
        return ((1 << i) & this.set) != 0;
    }

    public void merge(Settings settings) {
        for (int i = 0; i < 10; i++) {
            if (settings.isSet(i)) {
                set(i, settings.flags(i), settings.get(i));
            }
        }
    }

    public boolean persistValue(int i) {
        return ((1 << i) & this.persistValue) != 0;
    }

    public Settings set(int i, int i2, int i4) {
        int[] iArr = this.values;
        if (i >= iArr.length) {
            return this;
        }
        int i5 = 1 << i;
        this.set |= i5;
        if ((i2 & 1) != 0) {
            this.persistValue |= i5;
        } else {
            this.persistValue &= ~i5;
        }
        if ((i2 & 2) != 0) {
            this.persisted |= i5;
        } else {
            this.persisted &= ~i5;
        }
        iArr[i] = i4;
        return this;
    }

    public int size() {
        return Integer.bitCount(this.set);
    }
}
