package org.conscrypt;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class OpenSSLBIOSource {
    private OpenSSLBIOInputStream source;

    private OpenSSLBIOSource(OpenSSLBIOInputStream openSSLBIOInputStream) {
        this.source = openSSLBIOInputStream;
    }

    private synchronized void release() {
        OpenSSLBIOInputStream openSSLBIOInputStream = this.source;
        if (openSSLBIOInputStream != null) {
            NativeCrypto.BIO_free_all(openSSLBIOInputStream.getBioContext());
            this.source = null;
        }
    }

    public static OpenSSLBIOSource wrap(ByteBuffer byteBuffer) {
        return new OpenSSLBIOSource(new OpenSSLBIOInputStream(new ByteBufferInputStream(byteBuffer), false));
    }

    public void finalize() throws Throwable {
        try {
            release();
        } finally {
            super.finalize();
        }
    }

    public long getContext() {
        return this.source.getBioContext();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ByteBufferInputStream extends InputStream {
        private final ByteBuffer source;

        public ByteBufferInputStream(ByteBuffer byteBuffer) {
            this.source = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.source.limit() - this.source.position();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.source.remaining() > 0) {
                return this.source.get();
            }
            return -1;
        }

        @Override // java.io.InputStream
        public void reset() {
            this.source.reset();
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            long jPosition = this.source.position();
            this.source.position((int) (j + jPosition));
            return ((long) this.source.position()) - jPosition;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) {
            int iPosition = this.source.position();
            this.source.get(bArr);
            return this.source.position() - iPosition;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int iMin = Math.min(this.source.remaining(), i2);
            int iPosition = this.source.position();
            this.source.get(bArr, i, iMin);
            return this.source.position() - iPosition;
        }
    }
}
