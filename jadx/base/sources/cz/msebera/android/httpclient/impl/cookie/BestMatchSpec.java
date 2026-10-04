package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.SAFE)
@Deprecated
public class BestMatchSpec extends DefaultCookieSpec {
    public BestMatchSpec(String[] strArr, boolean z) {
        super(strArr, z);
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.DefaultCookieSpec
    public String toString() {
        return "best-match";
    }

    public BestMatchSpec() {
        this(null, false);
    }
}
