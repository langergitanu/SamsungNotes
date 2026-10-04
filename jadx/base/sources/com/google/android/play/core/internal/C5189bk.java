package com.google.android.play.core.internal;

import java.io.File;
import java.util.Set;

/* JADX INFO: renamed from: com.google.android.play.core.internal.bk */
/* JADX INFO: loaded from: classes5.dex */
final class C5189bk implements InterfaceC5172au {
    /* JADX INFO: renamed from: b */
    public static void m3926b(ClassLoader classLoader, Set<File> set) {
        C5184bf.m3923a(classLoader, set, new C5187bi());
    }

    @Override // com.google.android.play.core.internal.InterfaceC5172au
    /* JADX INFO: renamed from: a */
    public final void mo3908a(ClassLoader classLoader, Set<File> set) {
        m3926b(classLoader, set);
    }

    /* JADX INFO: renamed from: b */
    public static boolean m3927b(ClassLoader classLoader, File file, File file2, boolean z) {
        return C5179ba.m3918a(classLoader, file, file2, z, C5184bf.m3922a(), "path", new C5188bj());
    }

    @Override // com.google.android.play.core.internal.InterfaceC5172au
    /* JADX INFO: renamed from: a */
    public final boolean mo3909a(ClassLoader classLoader, File file, File file2, boolean z) {
        return m3927b(classLoader, file, file2, z);
    }
}
