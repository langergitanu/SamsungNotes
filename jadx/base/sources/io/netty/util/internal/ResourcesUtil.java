package io.netty.util.internal;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ResourcesUtil {
    private ResourcesUtil() {
    }

    public static File getFile(Class cls, String str) {
        try {
            return new File(URLDecoder.decode(cls.getResource(str).getFile(), "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return new File(cls.getResource(str).getFile());
        }
    }
}
