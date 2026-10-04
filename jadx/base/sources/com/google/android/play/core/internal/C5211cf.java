package com.google.android.play.core.internal;

/* JADX INFO: renamed from: com.google.android.play.core.internal.cf */
/* JADX INFO: loaded from: classes5.dex */
final class C5211cf extends AbstractC5208cc {

    /* JADX INFO: renamed from: a */
    private final C5210ce f2980a = new C5210ce();

    @Override // com.google.android.play.core.internal.AbstractC5208cc
    /* JADX INFO: renamed from: a */
    public final void mo3976a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 == null) {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
        this.f2980a.m3977a(th).add(th2);
    }
}
