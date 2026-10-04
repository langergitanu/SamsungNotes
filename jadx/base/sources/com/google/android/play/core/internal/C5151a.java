package com.google.android.play.core.internal;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: renamed from: com.google.android.play.core.internal.a */
/* JADX INFO: loaded from: classes5.dex */
final class C5151a implements InterfaceC5178b {

    /* JADX INFO: renamed from: a */
    private final ByteBuffer f2931a;

    public C5151a(ByteBuffer byteBuffer) {
        this.f2931a = byteBuffer.slice();
    }

    @Override // com.google.android.play.core.internal.InterfaceC5178b
    /* JADX INFO: renamed from: a */
    public final long mo3864a() {
        return this.f2931a.capacity();
    }

    @Override // com.google.android.play.core.internal.InterfaceC5178b
    /* JADX INFO: renamed from: a */
    public final void mo3865a(MessageDigest[] messageDigestArr, long j, int i) {
        ByteBuffer byteBufferSlice;
        synchronized (this.f2931a) {
            int i2 = (int) j;
            this.f2931a.position(i2);
            this.f2931a.limit(i2 + i);
            byteBufferSlice = this.f2931a.slice();
        }
        for (MessageDigest messageDigest : messageDigestArr) {
            byteBufferSlice.position(0);
            messageDigest.update(byteBufferSlice);
        }
    }
}
