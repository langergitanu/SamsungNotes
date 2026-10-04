package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.Obsolete;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.conn.util.PublicSuffixMatcher;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import cz.msebera.android.httpclient.protocol.HttpContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Obsolete
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class RFC2965SpecProvider implements CookieSpecProvider {
    private volatile CookieSpec cookieSpec;
    private final boolean oneHeader;
    private final PublicSuffixMatcher publicSuffixMatcher;

    public RFC2965SpecProvider(PublicSuffixMatcher publicSuffixMatcher, boolean z) {
        this.oneHeader = z;
        this.publicSuffixMatcher = publicSuffixMatcher;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpecProvider
    public CookieSpec create(HttpContext httpContext) {
        if (this.cookieSpec == null) {
            synchronized (this) {
                try {
                    if (this.cookieSpec == null) {
                        this.cookieSpec = new RFC2965Spec(this.oneHeader, new RFC2965VersionAttributeHandler(), new BasicPathHandler(), PublicSuffixDomainFilter.decorate(new RFC2965DomainAttributeHandler(), this.publicSuffixMatcher), new RFC2965PortAttributeHandler(), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicCommentHandler(), new RFC2965CommentUrlAttributeHandler(), new RFC2965DiscardAttributeHandler());
                    }
                } finally {
                }
            }
        }
        return this.cookieSpec;
    }

    public RFC2965SpecProvider(PublicSuffixMatcher publicSuffixMatcher) {
        this(publicSuffixMatcher, false);
    }

    public RFC2965SpecProvider() {
        this(null, false);
    }
}
