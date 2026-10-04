package com.sun.imageio.plugins.png;

import java.util.zip.Deflater;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;
import org.apache.poi.javax.imageio.stream.ImageOutputStreamImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class IDATOutputStream extends ImageOutputStreamImpl {
    private static byte[] chunkType = {73, 68, 65, 84};
    private int bytesRemaining;
    private int chunkLength;
    private long startPos;
    private ImageOutputStream stream;
    private CRC crc = new CRC();
    Deflater def = new Deflater(9);
    byte[] buf = new byte[512];

    public IDATOutputStream(ImageOutputStream imageOutputStream, int i) {
        this.stream = imageOutputStream;
        this.chunkLength = i;
        startChunk();
    }

    private void finishChunk() {
        this.stream.writeInt(this.crc.getValue());
        long streamPosition = this.stream.getStreamPosition();
        this.stream.seek(this.startPos);
        this.stream.writeInt(((int) (streamPosition - this.startPos)) - 12);
        this.stream.seek(streamPosition);
        this.stream.flushBefore(streamPosition);
    }

    private void startChunk() {
        this.crc.reset();
        this.startPos = this.stream.getStreamPosition();
        this.stream.writeInt(-1);
        this.crc.update(chunkType, 0, 4);
        this.stream.write(chunkType, 0, 4);
        this.bytesRemaining = this.chunkLength;
    }

    public void deflate() {
        Deflater deflater = this.def;
        byte[] bArr = this.buf;
        int i = 0;
        int iDeflate = deflater.deflate(bArr, 0, bArr.length);
        while (iDeflate > 0) {
            if (this.bytesRemaining == 0) {
                finishChunk();
                startChunk();
            }
            int iMin = Math.min(iDeflate, this.bytesRemaining);
            this.crc.update(this.buf, i, iMin);
            this.stream.write(this.buf, i, iMin);
            i += iMin;
            iDeflate -= iMin;
            this.bytesRemaining -= iMin;
        }
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl
    public void finalize() {
    }

    public void finish() {
        try {
            if (!this.def.finished()) {
                this.def.finish();
                while (!this.def.finished()) {
                    deflate();
                }
            }
            finishChunk();
            this.def.end();
        } catch (Throwable th) {
            this.def.end();
            throw th;
        }
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public int read() {
        throw new RuntimeException("Method not available");
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStreamImpl, org.apache.poi.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void write(byte[] bArr, int i, int i2) {
        if (i2 == 0 || this.def.finished()) {
            return;
        }
        this.def.setInput(bArr, i, i2);
        while (!this.def.needsInput()) {
            deflate();
        }
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public int read(byte[] bArr, int i, int i2) {
        throw new RuntimeException("Method not available");
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStreamImpl, org.apache.poi.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void write(int i) {
        write(new byte[]{(byte) i}, 0, 1);
    }
}
