package org.apache.commons.logging;

import java.security.PrivilegedAction;

/* JADX INFO: renamed from: org.apache.commons.logging.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13933a implements PrivilegedAction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9975a = 1;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ClassLoader f9976b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f9977c;

    public /* synthetic */ C13933a(ClassLoader classLoader, String str) {
        this.f9976b = classLoader;
        this.f9977c = str;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        switch (this.f9975a) {
            case 0:
                return LogFactory.createFactory(this.f9977c, this.f9976b);
            default:
                return LogFactory.lambda$getResources$17(this.f9976b, this.f9977c);
        }
    }

    public /* synthetic */ C13933a(String str, ClassLoader classLoader) {
        this.f9977c = str;
        this.f9976b = classLoader;
    }
}
