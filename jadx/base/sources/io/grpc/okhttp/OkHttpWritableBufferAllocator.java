package io.grpc.okhttp;

import io.grpc.internal.WritableBuffer;
import io.grpc.internal.WritableBufferAllocator;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class OkHttpWritableBufferAllocator implements WritableBufferAllocator {
    private static final int MAX_BUFFER = 1048576;
    private static final int MIN_BUFFER = 4096;

    @Override // io.grpc.internal.WritableBufferAllocator
    public WritableBuffer allocate(int i) {
        return new OkHttpWritableBuffer(new Buffer(), Math.min(1048576, Math.max(4096, i)));
    }
}
