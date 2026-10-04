package org.apache.commons.logging.impl;

import java.security.PrivilegedAction;
import org.slf4j.LoggerFactory;

/* JADX INFO: renamed from: org.apache.commons.logging.impl.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13942a implements PrivilegedAction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9990a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ClassLoader f9991b;

    public /* synthetic */ C13942a(ClassLoader classLoader, int i) {
        this.f9990a = i;
        this.f9991b = classLoader;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        switch (this.f9990a) {
            case 0:
                return this.f9991b.getParent();
            default:
                return LoggerFactory.lambda$getServiceLoader$0(this.f9991b);
        }
    }
}
