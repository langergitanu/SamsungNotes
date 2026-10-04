package com.google.android.play.core.splitinstall;

import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.l */
/* JADX INFO: loaded from: classes5.dex */
public final class EnumC5310l implements InterfaceC5303e {

    /* JADX INFO: renamed from: a */
    public static final EnumC5310l f3133a = new EnumC5310l();

    /* JADX INFO: renamed from: b */
    private static final AtomicReference<InterfaceC5304f> f3134b = new AtomicReference<>(null);

    private EnumC5310l() {
    }

    @Override // com.google.android.play.core.splitinstall.InterfaceC5303e
    @Nullable
    /* JADX INFO: renamed from: a */
    public final InterfaceC5304f mo4134a() {
        return f3134b.get();
    }

    /* JADX INFO: renamed from: a */
    public final void m4140a(InterfaceC5304f interfaceC5304f) {
        f3134b.set(interfaceC5304f);
    }
}
