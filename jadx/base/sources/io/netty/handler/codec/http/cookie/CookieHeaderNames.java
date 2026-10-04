package io.netty.handler.codec.http.cookie;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class CookieHeaderNames {
    public static final String DOMAIN = "Domain";
    public static final String EXPIRES = "Expires";
    public static final String HTTPONLY = "HTTPOnly";
    public static final String MAX_AGE = "Max-Age";
    public static final String PATH = "Path";
    public static final String SAMESITE = "SameSite";
    public static final String SECURE = "Secure";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SameSite {
        Lax,
        Strict,
        None;

        /* JADX INFO: renamed from: of */
        public static SameSite m13772of(String str) {
            if (str == null) {
                return null;
            }
            for (SameSite sameSite : (SameSite[]) SameSite.class.getEnumConstants()) {
                if (sameSite.name().equalsIgnoreCase(str)) {
                    return sameSite;
                }
            }
            return null;
        }
    }

    private CookieHeaderNames() {
    }
}
