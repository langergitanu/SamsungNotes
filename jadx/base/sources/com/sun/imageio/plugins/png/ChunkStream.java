package com.sun.imageio.plugins.png;

import org.apache.poi.javax.imageio.stream.ImageOutputStream;
import org.apache.poi.javax.imageio.stream.ImageOutputStreamImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class ChunkStream extends ImageOutputStreamImpl {
    private CRC crc = new CRC();
    private long startPos;
    private ImageOutputStream stream;

    public ChunkStream(int i, ImageOutputStream imageOutputStream) {
        this.stream = imageOutputStream;
        this.startPos = imageOutputStream.getStreamPosition();
        imageOutputStream.writeInt(-1);
        writeInt(i);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl
    public void finalize() {
    }

    public void finish() {
        this.stream.writeInt(this.crc.getValue());
        long streamPosition = this.stream.getStreamPosition();
        this.stream.seek(this.startPos);
        this.stream.writeInt(((int) (streamPosition - this.startPos)) - 12);
        this.stream.seek(streamPosition);
        this.stream.flushBefore(streamPosition);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public int read() {
        throw new RuntimeException("Method not available");
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStreamImpl, org.apache.poi.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void write(byte[] bArr, int i, int i2) {
        this.crc.update(bArr, i, i2);
        this.stream.write(bArr, i, i2);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public int read(byte[] bArr, int i, int i2) {
        throw new RuntimeException("Method not available");
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStreamImpl, org.apache.poi.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void write(int i) {
        this.crc.update(i);
        this.stream.write(i);
    }
}
