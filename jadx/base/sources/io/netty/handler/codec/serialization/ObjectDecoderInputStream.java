package io.netty.handler.codec.serialization;

import androidx.appcompat.widget.AbstractC0541b;
import io.netty.util.internal.ObjectUtil;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.StreamCorruptedException;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public class ObjectDecoderInputStream extends InputStream implements ObjectInput {
    private final ClassResolver classResolver;

    /* JADX INFO: renamed from: in */
    private final DataInputStream f8909in;
    private final int maxObjectSize;

    public ObjectDecoderInputStream(InputStream inputStream) {
        this(inputStream, (ClassLoader) null);
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public int available() {
        return this.f8909in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.ObjectInput
    public void close() throws IOException {
        this.f8909in.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f8909in.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f8909in.markSupported();
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public int read() {
        return this.f8909in.read();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        return this.f8909in.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() {
        return this.f8909in.readByte();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        return this.f8909in.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return this.f8909in.readDouble();
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return this.f8909in.readFloat();
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.f8909in.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public final int readInt() {
        return this.f8909in.readInt();
    }

    @Override // java.io.DataInput
    @Deprecated
    public final String readLine() {
        return this.f8909in.readLine();
    }

    @Override // java.io.DataInput
    public final long readLong() {
        return this.f8909in.readLong();
    }

    @Override // java.io.ObjectInput
    public Object readObject() throws StreamCorruptedException {
        int i = readInt();
        if (i <= 0) {
            throw new StreamCorruptedException(AbstractC0000a.m11h(i, "invalid data length: "));
        }
        if (i <= this.maxObjectSize) {
            return new CompactObjectInputStream(this.f8909in, this.classResolver).readObject();
        }
        throw new StreamCorruptedException(AbstractC0000a.m13j(AbstractC0541b.m778t(i, "data length too big: ", " (max: "), this.maxObjectSize, PropertyUtils.MAPPED_DELIM2));
    }

    @Override // java.io.DataInput
    public final short readShort() {
        return this.f8909in.readShort();
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        return this.f8909in.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        return this.f8909in.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() {
        return this.f8909in.readUnsignedShort();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.f8909in.reset();
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public long skip(long j) {
        return this.f8909in.skip(j);
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) {
        return this.f8909in.skipBytes(i);
    }

    public ObjectDecoderInputStream(InputStream inputStream, ClassLoader classLoader) {
        this(inputStream, classLoader, 1048576);
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public final int read(byte[] bArr, int i, int i2) {
        return this.f8909in.read(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) throws IOException {
        this.f8909in.readFully(bArr);
    }

    public ObjectDecoderInputStream(InputStream inputStream, int i) {
        this(inputStream, null, i);
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public final int read(byte[] bArr) {
        return this.f8909in.read(bArr);
    }

    public ObjectDecoderInputStream(InputStream inputStream, ClassLoader classLoader, int i) {
        ObjectUtil.checkNotNull(inputStream, "in");
        ObjectUtil.checkPositive(i, "maxObjectSize");
        if (inputStream instanceof DataInputStream) {
            this.f8909in = (DataInputStream) inputStream;
        } else {
            this.f8909in = new DataInputStream(inputStream);
        }
        this.classResolver = ClassResolvers.weakCachingResolver(classLoader);
        this.maxObjectSize = i;
    }
}
