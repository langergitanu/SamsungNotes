package com.google.android.play.core.internal;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/* JADX INFO: renamed from: com.google.android.play.core.internal.c */
/* JADX INFO: loaded from: classes5.dex */
final class C5205c implements InterfaceC5178b {

    /* JADX INFO: renamed from: a */
    private final FileChannel f2971a;

    /* JADX INFO: renamed from: b */
    private final long f2972b;

    /* JADX INFO: renamed from: c */
    private final long f2973c;

    public C5205c(FileChannel fileChannel, long j, long j2) {
        this.f2971a = fileChannel;
        this.f2972b = j;
        this.f2973c = j2;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5178b
    /* JADX INFO: renamed from: a */
    public final long mo3864a() {
        return this.f2973c;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5178b
    /* JADX INFO: renamed from: a */
    public final void mo3865a(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        MappedByteBuffer map = this.f2971a.map(FileChannel.MapMode.READ_ONLY, this.f2972b + j, i);
        map.load();
        for (MessageDigest messageDigest : messageDigestArr) {
            map.position(0);
            messageDigest.update(map);
        }
    }
}
