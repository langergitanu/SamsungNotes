package io.netty.handler.codec.http;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public interface Cookie extends io.netty.handler.codec.http.cookie.Cookie {
    @Deprecated
    String comment();

    @Deprecated
    String commentUrl();

    @Deprecated
    String getComment();

    @Deprecated
    String getCommentUrl();

    @Deprecated
    String getDomain();

    @Deprecated
    long getMaxAge();

    @Deprecated
    String getName();

    @Deprecated
    String getPath();

    @Deprecated
    Set<Integer> getPorts();

    @Deprecated
    String getValue();

    @Deprecated
    int getVersion();

    @Deprecated
    boolean isDiscard();

    @Override // io.netty.handler.codec.http.cookie.Cookie
    @Deprecated
    long maxAge();

    @Deprecated
    Set<Integer> ports();

    @Deprecated
    void setComment(String str);

    @Deprecated
    void setCommentUrl(String str);

    @Deprecated
    void setDiscard(boolean z);

    @Override // io.netty.handler.codec.http.cookie.Cookie
    @Deprecated
    void setMaxAge(long j);

    @Deprecated
    void setPorts(Iterable<Integer> iterable);

    @Deprecated
    void setPorts(int... iArr);

    @Deprecated
    void setVersion(int i);

    @Deprecated
    int version();
}
