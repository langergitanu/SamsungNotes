package io.netty.handler.codec.rtsp;

import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class RtspVersions {
    public static final HttpVersion RTSP_1_0 = new HttpVersion("RTSP", 1, 0, true);

    private RtspVersions() {
    }

    public static HttpVersion valueOf(String str) {
        ObjectUtil.checkNotNull(str, "text");
        String upperCase = str.trim().toUpperCase();
        return "RTSP/1.0".equals(upperCase) ? RTSP_1_0 : new HttpVersion(upperCase, true);
    }
}
