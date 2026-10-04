package com.google.android.play.core.internal;

import android.util.Log;
import java.io.File;

/* JADX INFO: renamed from: com.google.android.play.core.internal.bj */
/* JADX INFO: loaded from: classes5.dex */
final class C5188bj implements InterfaceC5176ay {
    @Override // com.google.android.play.core.internal.InterfaceC5176ay
    /* JADX INFO: renamed from: a */
    public final boolean mo3915a(Object obj, File file, File file2) {
        try {
            return !((Boolean) C5195bq.m3935a(Class.forName("dalvik.system.DexFile"), Boolean.class, (Class<String>) String.class, file.getPath())).booleanValue();
        } catch (ClassNotFoundException unused) {
            Log.e("SplitCompat", "Unexpected missing dalvik.system.DexFile.");
            return false;
        }
    }
}
