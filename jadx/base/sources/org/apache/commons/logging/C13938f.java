package org.apache.commons.logging;

import java.security.PrivilegedAction;

/* JADX INFO: renamed from: org.apache.commons.logging.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13938f implements PrivilegedAction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9985a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f9986b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f9987c;

    public /* synthetic */ C13938f(String str, String str2, int i) {
        this.f9985a = i;
        this.f9986b = str;
        this.f9987c = str2;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        switch (this.f9985a) {
        }
        return System.getProperty(this.f9986b, this.f9987c);
    }
}
