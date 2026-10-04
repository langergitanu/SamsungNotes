package com.google.android.play.core.splitinstall;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.play.core.internal.InterfaceC5219cn;
import java.io.File;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.aa */
/* JADX INFO: loaded from: classes5.dex */
public final class C5274aa implements InterfaceC5219cn<File> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<Context> f3073a;

    public C5274aa(InterfaceC5219cn<Context> interfaceC5219cn) {
        this.f3073a = interfaceC5219cn;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    @Nullable
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ File mo3591a() {
        return C5335y.m4180a(((C5336z) this.f3073a).mo3591a());
    }
}
