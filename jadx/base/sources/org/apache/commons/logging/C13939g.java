package org.apache.commons.logging;

import java.io.Serializable;
import java.net.URL;
import java.security.PrivilegedAction;
import org.apache.commons.logging.impl.SimpleLog;

/* JADX INFO: renamed from: org.apache.commons.logging.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13939g implements PrivilegedAction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9988a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Serializable f9989b;

    public /* synthetic */ C13939g(Serializable serializable, int i) {
        this.f9988a = i;
        this.f9989b = serializable;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        switch (this.f9988a) {
            case 0:
                return LogFactory.lambda$getProperties$15((URL) this.f9989b);
            default:
                return SimpleLog.lambda$getResourceAsStream$0((String) this.f9989b);
        }
    }
}
