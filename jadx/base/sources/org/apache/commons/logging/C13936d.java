package org.apache.commons.logging;

import java.security.PrivilegedAction;

/* JADX INFO: renamed from: org.apache.commons.logging.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13936d implements PrivilegedAction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9982a;

    public /* synthetic */ C13936d(int i) {
        this.f9982a = i;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        switch (this.f9982a) {
        }
        return LogFactory.directGetContextClassLoader();
    }
}
