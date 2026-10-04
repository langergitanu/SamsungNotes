package io.netty.handler.codec.serialization;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public class ObjectEncoderOutputStream extends OutputStream implements ObjectOutput {
    private final int estimatedLength;
    private final DataOutputStream out;

    public ObjectEncoderOutputStream(OutputStream outputStream) {
        this(outputStream, 512);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.ObjectOutput
    public void close() throws IOException {
        this.out.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable, java.io.ObjectOutput
    public void flush() throws IOException {
        this.out.flush();
    }

    public final int size() {
        return this.out.size();
    }

    @Override // java.io.OutputStream, java.io.ObjectOutput, java.io.DataOutput
    public void write(int i) throws IOException {
        this.out.write(i);
    }

    @Override // java.io.DataOutput
    public final void writeBoolean(boolean z) throws IOException {
        this.out.writeBoolean(z);
    }

    @Override // java.io.DataOutput
    public final void writeByte(int i) throws IOException {
        this.out.writeByte(i);
    }

    @Override // java.io.DataOutput
    public final void writeBytes(String str) throws IOException {
        this.out.writeBytes(str);
    }

    @Override // java.io.DataOutput
    public final void writeChar(int i) throws IOException {
        this.out.writeChar(i);
    }

    @Override // java.io.DataOutput
    public final void writeChars(String str) throws IOException {
        this.out.writeChars(str);
    }

    @Override // java.io.DataOutput
    public final void writeDouble(double d) throws IOException {
        this.out.writeDouble(d);
    }

    @Override // java.io.DataOutput
    public final void writeFloat(float f) throws IOException {
        this.out.writeFloat(f);
    }

    @Override // java.io.DataOutput
    public final void writeInt(int i) throws IOException {
        this.out.writeInt(i);
    }

    @Override // java.io.DataOutput
    public final void writeLong(long j) throws IOException {
        this.out.writeLong(j);
    }

    @Override // java.io.ObjectOutput
    public void writeObject(Object obj) {
        ByteBuf byteBufBuffer = Unpooled.buffer(this.estimatedLength);
        try {
            CompactObjectOutputStream compactObjectOutputStream = new CompactObjectOutputStream(new ByteBufOutputStream(byteBufBuffer));
            try {
                compactObjectOutputStream.writeObject(obj);
                compactObjectOutputStream.flush();
                compactObjectOutputStream.close();
                int i = byteBufBuffer.readableBytes();
                writeInt(i);
                byteBufBuffer.getBytes(0, this, i);
            } catch (Throwable th) {
                compactObjectOutputStream.close();
                throw th;
            }
        } finally {
            byteBufBuffer.release();
        }
    }

    @Override // java.io.DataOutput
    public final void writeShort(int i) throws IOException {
        this.out.writeShort(i);
    }

    @Override // java.io.DataOutput
    public final void writeUTF(String str) throws IOException {
        this.out.writeUTF(str);
    }

    public ObjectEncoderOutputStream(OutputStream outputStream, int i) {
        ObjectUtil.checkNotNull(outputStream, "out");
        ObjectUtil.checkPositiveOrZero(i, "estimatedLength");
        if (outputStream instanceof DataOutputStream) {
            this.out = (DataOutputStream) outputStream;
        } else {
            this.out = new DataOutputStream(outputStream);
        }
        this.estimatedLength = i;
    }

    @Override // java.io.OutputStream, java.io.ObjectOutput, java.io.DataOutput
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
    }

    @Override // java.io.OutputStream, java.io.ObjectOutput, java.io.DataOutput
    public void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
    }
}
