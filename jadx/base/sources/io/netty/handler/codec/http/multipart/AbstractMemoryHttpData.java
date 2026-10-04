package io.netty.handler.codec.http.multipart;

import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractMemoryHttpData extends AbstractHttpData {
    private ByteBuf byteBuf;
    private int chunkPosition;

    public AbstractMemoryHttpData(String str, Charset charset, long j) {
        super(str, charset, j);
        this.byteBuf = Unpooled.EMPTY_BUFFER;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void addContent(ByteBuf byteBuf, boolean z) throws IOException {
        if (byteBuf != null) {
            long j = byteBuf.readableBytes();
            try {
                checkSize(this.size + j);
                long j2 = this.definedSize;
                if (j2 > 0 && j2 < this.size + j) {
                    byteBuf.release();
                    throw new IOException("Out of size: " + (this.size + j) + " > " + this.definedSize);
                }
                this.size += j;
                ByteBuf byteBuf2 = this.byteBuf;
                if (byteBuf2 == null) {
                    this.byteBuf = byteBuf;
                } else if (j == 0) {
                    byteBuf.release();
                } else if (byteBuf2.readableBytes() == 0) {
                    this.byteBuf.release();
                    this.byteBuf = byteBuf;
                } else {
                    ByteBuf byteBuf3 = this.byteBuf;
                    if (byteBuf3 instanceof CompositeByteBuf) {
                        ((CompositeByteBuf) byteBuf3).addComponent(true, byteBuf);
                    } else {
                        CompositeByteBuf compositeByteBufCompositeBuffer = Unpooled.compositeBuffer(Integer.MAX_VALUE);
                        compositeByteBufCompositeBuffer.addComponents(true, this.byteBuf, byteBuf);
                        this.byteBuf = compositeByteBufCompositeBuffer;
                    }
                }
            } catch (IOException e) {
                byteBuf.release();
                throw e;
            }
        }
        if (z) {
            setCompleted();
        } else {
            ObjectUtil.checkNotNull(byteBuf, "buffer");
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void delete() {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf != null) {
            byteBuf.release();
            this.byteBuf = null;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public byte[] get() {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf == null) {
            return Unpooled.EMPTY_BUFFER.array();
        }
        byte[] bArr = new byte[byteBuf.readableBytes()];
        ByteBuf byteBuf2 = this.byteBuf;
        byteBuf2.getBytes(byteBuf2.readerIndex(), bArr);
        return bArr;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getByteBuf() {
        return this.byteBuf;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getChunk(int i) {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf == null || i == 0 || byteBuf.readableBytes() == 0) {
            this.chunkPosition = 0;
            return Unpooled.EMPTY_BUFFER;
        }
        int i2 = this.byteBuf.readableBytes();
        int i4 = this.chunkPosition;
        int i5 = i2 - i4;
        if (i5 == 0) {
            this.chunkPosition = 0;
            return Unpooled.EMPTY_BUFFER;
        }
        if (i5 < i) {
            i = i5;
        }
        ByteBuf byteBufRetainedSlice = this.byteBuf.retainedSlice(i4, i);
        this.chunkPosition += i;
        return byteBufRetainedSlice;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public File getFile() throws IOException {
        throw new IOException("Not represented by a file");
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString() {
        return getString(HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean isInMemory() {
        return true;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean renameTo(File file) throws IOException {
        ObjectUtil.checkNotNull(file, "dest");
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf == null) {
            if (file.createNewFile()) {
                return true;
            }
            throw new IOException(AbstractC2322a.m1617g(file, "file exists already: "));
        }
        int i = byteBuf.readableBytes();
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
        try {
            FileChannel channel = randomAccessFile.getChannel();
            try {
                long jWrite = 0;
                if (this.byteBuf.nioBufferCount() == 1) {
                    ByteBuffer byteBufferNioBuffer = this.byteBuf.nioBuffer();
                    while (jWrite < i) {
                        jWrite += (long) channel.write(byteBufferNioBuffer);
                    }
                } else {
                    ByteBuffer[] byteBufferArrNioBuffers = this.byteBuf.nioBuffers();
                    while (jWrite < i) {
                        jWrite += channel.write(byteBufferArrNioBuffers);
                    }
                }
                channel.force(false);
                channel.close();
                randomAccessFile.close();
                return jWrite == ((long) i);
            } catch (Throwable th) {
                channel.close();
                throw th;
            }
        } catch (Throwable th2) {
            randomAccessFile.close();
            throw th2;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(ByteBuf byteBuf) throws IOException {
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        long j = byteBuf.readableBytes();
        try {
            checkSize(j);
            long j2 = this.definedSize;
            if (j2 > 0 && j2 < j) {
                byteBuf.release();
                StringBuilder sbM1323p = AbstractC1974b.m1323p(j, "Out of size: ", " > ");
                sbM1323p.append(this.definedSize);
                throw new IOException(sbM1323p.toString());
            }
            ByteBuf byteBuf2 = this.byteBuf;
            if (byteBuf2 != null) {
                byteBuf2.release();
            }
            this.byteBuf = byteBuf;
            this.size = j;
            setCompleted();
        } catch (IOException e) {
            byteBuf.release();
            throw e;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString(Charset charset) {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf == null) {
            return "";
        }
        if (charset == null) {
            charset = HttpConstants.DEFAULT_CHARSET;
        }
        return byteBuf.toString(charset);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public HttpData touch() {
        return touch((Object) null);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.ReferenceCounted
    public HttpData touch(Object obj) {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf != null) {
            byteBuf.touch(obj);
        }
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(InputStream inputStream) throws IOException {
        ObjectUtil.checkNotNull(inputStream, "inputStream");
        byte[] bArr = new byte[16384];
        ByteBuf byteBufBuffer = Unpooled.buffer();
        try {
            int i = inputStream.read(bArr);
            int i2 = 0;
            while (i > 0) {
                byteBufBuffer.writeBytes(bArr, 0, i);
                i2 += i;
                checkSize(i2);
                i = inputStream.read(bArr);
            }
            long j = i2;
            this.size = j;
            long j2 = this.definedSize;
            if (j2 > 0 && j2 < j) {
                byteBufBuffer.release();
                throw new IOException("Out of size: " + this.size + " > " + this.definedSize);
            }
            ByteBuf byteBuf = this.byteBuf;
            if (byteBuf != null) {
                byteBuf.release();
            }
            this.byteBuf = byteBufBuffer;
            setCompleted();
        } catch (IOException e) {
            byteBufBuffer.release();
            throw e;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(File file) throws IOException {
        ObjectUtil.checkNotNull(file, "file");
        long length = file.length();
        if (length <= 2147483647L) {
            checkSize(length);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                try {
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[(int) length]);
                    for (int i = 0; i < length; i += channel.read(byteBufferWrap)) {
                    }
                    randomAccessFile.close();
                    byteBufferWrap.flip();
                    ByteBuf byteBuf = this.byteBuf;
                    if (byteBuf != null) {
                        byteBuf.release();
                    }
                    this.byteBuf = Unpooled.wrappedBuffer(Integer.MAX_VALUE, byteBufferWrap);
                    this.size = length;
                    setCompleted();
                    return;
                } finally {
                    channel.close();
                }
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        }
        throw new IllegalArgumentException("File too big to be loaded in memory");
    }
}
