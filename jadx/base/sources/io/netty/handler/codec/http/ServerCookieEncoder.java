package io.netty.handler.codec.http;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public final class ServerCookieEncoder {
    private ServerCookieEncoder() {
    }

    @Deprecated
    public static String encode(String str, String str2) {
        return io.netty.handler.codec.http.cookie.ServerCookieEncoder.LAX.encode(str, str2);
    }

    @Deprecated
    public static String encode(Cookie cookie) {
        return io.netty.handler.codec.http.cookie.ServerCookieEncoder.LAX.encode(cookie);
    }

    @Deprecated
    public static List<String> encode(Cookie... cookieArr) {
        return io.netty.handler.codec.http.cookie.ServerCookieEncoder.LAX.encode(cookieArr);
    }

    @Deprecated
    public static List<String> encode(Collection<Cookie> collection) {
        return io.netty.handler.codec.http.cookie.ServerCookieEncoder.LAX.encode((Collection<? extends io.netty.handler.codec.http.cookie.Cookie>) collection);
    }

    @Deprecated
    public static List<String> encode(Iterable<Cookie> iterable) {
        return io.netty.handler.codec.http.cookie.ServerCookieEncoder.LAX.encode(iterable);
    }
}
