package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.annotation.Obsolete;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface ClientCookie extends Cookie {

    @Obsolete
    public static final String COMMENTURL_ATTR = "commenturl";

    @Obsolete
    public static final String COMMENT_ATTR = "comment";

    @Obsolete
    public static final String DISCARD_ATTR = "discard";
    public static final String DOMAIN_ATTR = "domain";
    public static final String EXPIRES_ATTR = "expires";
    public static final String MAX_AGE_ATTR = "max-age";
    public static final String PATH_ATTR = "path";

    @Obsolete
    public static final String PORT_ATTR = "port";
    public static final String SECURE_ATTR = "secure";

    @Obsolete
    public static final String VERSION_ATTR = "version";

    boolean containsAttribute(String str);

    String getAttribute(String str);
}
