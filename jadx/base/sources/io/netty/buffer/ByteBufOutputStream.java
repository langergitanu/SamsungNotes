package io.netty.buffer;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ByteBufOutputStream extends OutputStream implements DataOutput {
    private final ByteBuf buffer;
    private boolean closed;
    private final int startIndex;
    private DataOutputStream utf8out;

    public ByteBufOutputStream(ByteBuf byteBuf) {
        this.buffer = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "buffer");
        this.startIndex = byteBuf.writerIndex();
    }

    public ByteBuf buffer() {
        return this.buffer;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        try {
            super.close();
            DataOutputStream dataOutputStream = this.utf8out;
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
        } catch (Throwable th) {
            if (this.utf8out != null) {
                this.utf8out.close();
            }
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.DataOutput
    public void write(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return;
        }
        this.buffer.writeBytes(bArr, i, i2);
    }

    @Override // java.io.DataOutput
    public void writeBoolean(boolean z) {
        this.buffer.writeBoolean(z);
    }

    @Override // java.io.DataOutput
    public void writeByte(int i) {
        this.buffer.writeByte(i);
    }

    @Override // java.io.DataOutput
    public void writeBytes(String str) {
        this.buffer.writeCharSequence(str, CharsetUtil.US_ASCII);
    }

    @Override // java.io.DataOutput
    public void writeChar(int i) {
        this.buffer.writeChar(i);
    }

    @Override // java.io.DataOutput
    public void writeChars(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            this.buffer.writeChar(str.charAt(i));
        }
    }

    @Override // java.io.DataOutput
    public void writeDouble(double d) {
        this.buffer.writeDouble(d);
    }

    @Override // java.io.DataOutput
    public void writeFloat(float f) {
        this.buffer.writeFloat(f);
    }

    @Override // java.io.DataOutput
    public void writeInt(int i) {
        this.buffer.writeInt(i);
    }

    @Override // java.io.DataOutput
    public void writeLong(long j) {
        this.buffer.writeLong(j);
    }

    @Override // java.io.DataOutput
    public void writeShort(int i) {
        this.buffer.writeShort((short) i);
    }

    @Override // java.io.DataOutput
    public void writeUTF(String str) throws IOException {
        DataOutputStream dataOutputStream = this.utf8out;
        if (dataOutputStream == null) {
            if (this.closed) {
                throw new IOException("The stream is closed");
            }
            dataOutputStream = new DataOutputStream(this);
            this.utf8out = dataOutputStream;
        }
        dataOutputStream.writeUTF(str);
    }

    public int writtenBytes() {
        return this.buffer.writerIndex() - this.startIndex;
    }

    @Override // java.io.OutputStream, java.io.DataOutput
    public void write(byte[] bArr) {
        this.buffer.writeBytes(bArr);
    }

    @Override // java.io.OutputStream, java.io.DataOutput
    public void write(int i) {
        this.buffer.writeByte(i);
    }
}
