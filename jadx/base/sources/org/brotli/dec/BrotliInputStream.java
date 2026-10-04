package org.brotli.dec;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import java.io.InputStream;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BrotliInputStream extends InputStream {
    public static final int DEFAULT_INTERNAL_BUFFER_SIZE = 16384;
    private byte[] buffer;
    private int bufferOffset;
    private int remainingBufferBytes;
    private final State state;

    public BrotliInputStream(InputStream inputStream) {
        this(inputStream, 16384, null);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        State.close(this.state);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.bufferOffset >= this.remainingBufferBytes) {
            byte[] bArr = this.buffer;
            int i = read(bArr, 0, bArr.length);
            this.remainingBufferBytes = i;
            this.bufferOffset = 0;
            if (i == -1) {
                return -1;
            }
        }
        byte[] bArr2 = this.buffer;
        int i2 = this.bufferOffset;
        this.bufferOffset = i2 + 1;
        return bArr2[i2] & 255;
    }

    public BrotliInputStream(InputStream inputStream, int i) {
        this(inputStream, i, null);
    }

    public BrotliInputStream(InputStream inputStream, int i, byte[] bArr) throws IOException {
        State state = new State();
        this.state = state;
        if (i <= 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Bad buffer size:"));
        }
        if (inputStream != null) {
            this.buffer = new byte[i];
            this.remainingBufferBytes = 0;
            this.bufferOffset = 0;
            try {
                State.setInput(state, inputStream);
                if (bArr != null) {
                    Decode.setCustomDictionary(state, bArr);
                    return;
                }
                return;
            } catch (BrotliRuntimeException e) {
                throw new IOException("Brotli decoder initialization failed", e);
            }
        }
        throw new IllegalArgumentException("source is null");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Bad offset: "));
        }
        if (i2 >= 0) {
            int i4 = i + i2;
            if (i4 > bArr.length) {
                StringBuilder sbM778t = AbstractC0541b.m778t(i4, "Buffer overflow: ", " > ");
                sbM778t.append(bArr.length);
                throw new IllegalArgumentException(sbM778t.toString());
            }
            if (i2 == 0) {
                return 0;
            }
            int iMax = Math.max(this.remainingBufferBytes - this.bufferOffset, 0);
            if (iMax != 0) {
                iMax = Math.min(iMax, i2);
                System.arraycopy(this.buffer, this.bufferOffset, bArr, i, iMax);
                this.bufferOffset += iMax;
                i += iMax;
                i2 -= iMax;
                if (i2 == 0) {
                    return iMax;
                }
            }
            try {
                State state = this.state;
                state.output = bArr;
                state.outputOffset = i;
                state.outputLength = i2;
                state.outputUsed = 0;
                Decode.decompress(state);
                int i5 = this.state.outputUsed;
                if (i5 == 0) {
                    return -1;
                }
                return i5 + iMax;
            } catch (BrotliRuntimeException e) {
                throw new IOException("Brotli stream decoding failed", e);
            }
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i2, "Bad length: "));
    }
}
