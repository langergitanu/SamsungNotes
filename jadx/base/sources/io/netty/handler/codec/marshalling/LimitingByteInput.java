package io.netty.handler.codec.marshalling;

import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import org.jboss.marshalling.ByteInput;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class LimitingByteInput implements ByteInput {
    private static final TooBigObjectException EXCEPTION = new TooBigObjectException();
    private final ByteInput input;
    private final long limit;
    private long read;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TooBigObjectException extends IOException {
        private static final long serialVersionUID = 1;
    }

    public LimitingByteInput(ByteInput byteInput, long j) {
        this.input = byteInput;
        this.limit = ObjectUtil.checkPositive(j, "limit");
    }

    private int readable(int i) {
        return (int) Math.min(i, this.limit - this.read);
    }

    public int available() {
        return readable(this.input.available());
    }

    public int read() throws TooBigObjectException {
        if (readable(1) <= 0) {
            throw EXCEPTION;
        }
        int i = this.input.read();
        this.read++;
        return i;
    }

    public long skip(long j) throws TooBigObjectException {
        int i = readable((int) j);
        if (i <= 0) {
            throw EXCEPTION;
        }
        long jSkip = this.input.skip(i);
        this.read += jSkip;
        return jSkip;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws TooBigObjectException {
        int i4 = readable(i2);
        if (i4 > 0) {
            int i5 = this.input.read(bArr, i, i4);
            this.read += (long) i5;
            return i5;
        }
        throw EXCEPTION;
    }

    public void close() {
    }
}
