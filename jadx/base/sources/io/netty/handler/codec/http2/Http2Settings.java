package io.netty.handler.codec.http2;

import androidx.compose.runtime.AbstractC1974b;
import io.netty.util.collection.CharObjectHashMap;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class Http2Settings extends CharObjectHashMap<Long> {
    private static final int DEFAULT_CAPACITY = 13;
    private static final Long FALSE = 0L;
    private static final Long TRUE = 1L;

    public Http2Settings() {
        this(13);
    }

    public static Http2Settings defaultSettings() {
        return new Http2Settings().maxHeaderListSize(8192L);
    }

    private static void verifyStandardSetting(int i, Long l) {
        ObjectUtil.checkNotNull(l, "value");
        switch (i) {
            case 1:
                if (l.longValue() < 0 || l.longValue() > 4294967295L) {
                    throw new IllegalArgumentException("Setting HEADER_TABLE_SIZE is invalid: " + l + ", expected [0, 4294967295]");
                }
                return;
            case 2:
                if (l.longValue() == 0 || l.longValue() == 1) {
                    return;
                }
                throw new IllegalArgumentException("Setting ENABLE_PUSH is invalid: " + l + ", expected [0, 1]");
            case 3:
                if (l.longValue() < 0 || l.longValue() > 4294967295L) {
                    throw new IllegalArgumentException("Setting MAX_CONCURRENT_STREAMS is invalid: " + l + ", expected [0, 4294967295]");
                }
                return;
            case 4:
                if (l.longValue() < 0 || l.longValue() > 2147483647L) {
                    throw new IllegalArgumentException("Setting INITIAL_WINDOW_SIZE is invalid: " + l + ", expected [0, 2147483647]");
                }
                return;
            case 5:
                if (Http2CodecUtil.isMaxFrameSizeValid(l.intValue())) {
                    return;
                }
                throw new IllegalArgumentException("Setting MAX_FRAME_SIZE is invalid: " + l + ", expected [16384, 16777215]");
            case 6:
                if (l.longValue() < 0 || l.longValue() > 4294967295L) {
                    throw new IllegalArgumentException("Setting MAX_HEADER_LIST_SIZE is invalid: " + l + ", expected [0, 4294967295]");
                }
                return;
            default:
                if (l.longValue() < 0 || l.longValue() > 4294967295L) {
                    throw new IllegalArgumentException("Non-standard setting 0x" + Integer.toHexString(i) + " is invalid: " + l + ", expected unsigned 32-bit value");
                }
                return;
        }
    }

    public Http2Settings copyFrom(Http2Settings http2Settings) {
        clear();
        putAll(http2Settings);
        return this;
    }

    public Integer getIntValue(char c) {
        Long l = get(c);
        if (l == null) {
            return null;
        }
        return Integer.valueOf(l.intValue());
    }

    public Long headerTableSize() {
        return get((char) 1);
    }

    public Integer initialWindowSize() {
        return getIntValue((char) 4);
    }

    @Override // io.netty.util.collection.CharObjectHashMap
    public String keyToString(char c) {
        switch (c) {
            case 1:
                return "HEADER_TABLE_SIZE";
            case 2:
                return "ENABLE_PUSH";
            case 3:
                return "MAX_CONCURRENT_STREAMS";
            case 4:
                return "INITIAL_WINDOW_SIZE";
            case 5:
                return "MAX_FRAME_SIZE";
            case 6:
                return "MAX_HEADER_LIST_SIZE";
            default:
                return AbstractC1974b.m1316i(c, new StringBuilder("0x"));
        }
    }

    public Long maxConcurrentStreams() {
        return get((char) 3);
    }

    public Integer maxFrameSize() {
        return getIntValue((char) 5);
    }

    public Long maxHeaderListSize() {
        return get((char) 6);
    }

    public Boolean pushEnabled() {
        Long l = get((char) 2);
        if (l == null) {
            return null;
        }
        return Boolean.valueOf(TRUE.equals(l));
    }

    public Http2Settings(int i, float f) {
        super(i, f);
    }

    public Http2Settings headerTableSize(long j) {
        put((char) 1, Long.valueOf(j));
        return this;
    }

    public Http2Settings initialWindowSize(int i) {
        put((char) 4, Long.valueOf(i));
        return this;
    }

    public Http2Settings maxConcurrentStreams(long j) {
        put((char) 3, Long.valueOf(j));
        return this;
    }

    public Http2Settings maxFrameSize(int i) {
        put((char) 5, Long.valueOf(i));
        return this;
    }

    public Http2Settings maxHeaderListSize(long j) {
        put((char) 6, Long.valueOf(j));
        return this;
    }

    @Override // io.netty.util.collection.CharObjectHashMap, io.netty.util.collection.CharObjectMap
    public Long put(char c, Long l) {
        verifyStandardSetting(c, l);
        return (Long) super.put(c, l);
    }

    public Http2Settings(int i) {
        super(i);
    }

    public Http2Settings pushEnabled(boolean z) {
        put((char) 2, z ? TRUE : FALSE);
        return this;
    }
}
