package io.netty.handler.codec.http.cookie;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface Cookie extends Comparable<Cookie> {
    public static final long UNDEFINED_MAX_AGE = Long.MIN_VALUE;

    String domain();

    boolean isHttpOnly();

    boolean isSecure();

    long maxAge();

    String name();

    String path();

    void setDomain(String str);

    void setHttpOnly(boolean z);

    void setMaxAge(long j);

    void setPath(String str);

    void setSecure(boolean z);

    void setValue(String str);

    void setWrap(boolean z);

    String value();

    boolean wrap();
}
