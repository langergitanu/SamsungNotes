package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
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
public abstract class AbstractDiskHttpData extends AbstractHttpData {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractDiskHttpData.class);
    private File file;
    private FileChannel fileChannel;
    private boolean isRenamed;

    public AbstractDiskHttpData(String str, Charset charset, long j) {
        super(str, charset, j);
    }

    private static byte[] readFrom(File file) throws IOException {
        long length = file.length();
        if (length > 2147483647L) {
            throw new IllegalArgumentException("File too big to be loaded in memory");
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        byte[] bArr = new byte[(int) length];
        try {
            FileChannel channel = randomAccessFile.getChannel();
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            for (int i = 0; i < length; i += channel.read(byteBufferWrap)) {
            }
            return bArr;
        } finally {
            randomAccessFile.close();
        }
    }

    private File tempFile() {
        String postfix;
        String diskFilename = getDiskFilename();
        if (diskFilename != null) {
            postfix = "_" + Integer.toString(diskFilename.hashCode());
        } else {
            postfix = getPostfix();
        }
        File fileCreateTempFile = getBaseDirectory() == null ? PlatformDependent.createTempFile(getPrefix(), postfix, null) : PlatformDependent.createTempFile(getPrefix(), postfix, new File(getBaseDirectory()));
        if (deleteOnExit()) {
            DeleteFileOnExitHook.add(fileCreateTempFile.getPath());
        }
        return fileCreateTempFile;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void addContent(ByteBuf byteBuf, boolean z) throws Throwable {
        ByteBuf byteBuf2;
        Throwable th;
        if (byteBuf != null) {
            try {
                int i = byteBuf.readableBytes();
                long j = i;
                checkSize(this.size + j);
                long j2 = this.definedSize;
                if (j2 > 0) {
                    try {
                        if (j2 < this.size + j) {
                            throw new IOException("Out of size: " + (this.size + j) + " > " + this.definedSize);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteBuf2 = byteBuf;
                        byteBuf2.release();
                        throw th;
                    }
                }
                if (this.file == null) {
                    this.file = tempFile();
                }
                if (this.fileChannel == null) {
                    this.fileChannel = new RandomAccessFile(this.file, InternalZipConstants.WRITE_MODE).getChannel();
                }
                long jPosition = this.fileChannel.position();
                int i2 = byteBuf.readerIndex();
                int i4 = i;
                long j3 = jPosition;
                while (true) {
                    if (i4 <= 0) {
                        byteBuf2 = byteBuf;
                        break;
                    }
                    byteBuf2 = byteBuf;
                    try {
                        int bytes = byteBuf2.getBytes(i2, this.fileChannel, j3, i4);
                        if (bytes < 0) {
                            break;
                        }
                        i4 -= bytes;
                        j3 += (long) bytes;
                        i2 += bytes;
                        byteBuf = byteBuf2;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        byteBuf2.release();
                        throw th;
                    }
                }
                this.fileChannel.position(j3);
                byteBuf2.readerIndex(i2);
                this.size += (long) (i - i4);
                byteBuf2.release();
            } catch (Throwable th4) {
                th = th4;
                byteBuf2 = byteBuf;
            }
        } else {
            byteBuf2 = byteBuf;
        }
        if (!z) {
            ObjectUtil.checkNotNull(byteBuf2, "buffer");
            return;
        }
        if (this.file == null) {
            this.file = tempFile();
        }
        if (this.fileChannel == null) {
            this.fileChannel = new RandomAccessFile(this.file, InternalZipConstants.WRITE_MODE).getChannel();
        }
        try {
            this.fileChannel.force(false);
            this.fileChannel.close();
            this.fileChannel = null;
            setCompleted();
        } catch (Throwable th5) {
            this.fileChannel.close();
            throw th5;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void delete() {
        String path;
        FileChannel fileChannel;
        FileChannel fileChannel2 = this.fileChannel;
        if (fileChannel2 != null) {
            try {
                try {
                    try {
                        fileChannel2.force(false);
                        fileChannel = this.fileChannel;
                    } catch (IOException e) {
                        logger.warn("Failed to force.", (Throwable) e);
                        fileChannel = this.fileChannel;
                    }
                    fileChannel.close();
                } catch (IOException e2) {
                    logger.warn("Failed to close a file.", (Throwable) e2);
                }
                this.fileChannel = null;
            } catch (Throwable th) {
                try {
                    this.fileChannel.close();
                } catch (IOException e3) {
                    logger.warn("Failed to close a file.", (Throwable) e3);
                }
                throw th;
            }
        }
        if (this.isRenamed) {
            return;
        }
        File file = this.file;
        if (file == null || !file.exists()) {
            path = null;
        } else {
            path = this.file.getPath();
            if (!this.file.delete()) {
                logger.warn("Failed to delete: {}", this.file);
                path = null;
            }
        }
        if (deleteOnExit() && path != null) {
            DeleteFileOnExitHook.remove(path);
        }
        this.file = null;
    }

    public abstract boolean deleteOnExit();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public byte[] get() {
        File file = this.file;
        return file == null ? EmptyArrays.EMPTY_BYTES : readFrom(file);
    }

    public abstract String getBaseDirectory();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getByteBuf() {
        File file = this.file;
        return file == null ? Unpooled.EMPTY_BUFFER : Unpooled.wrappedBuffer(readFrom(file));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        r6.fileChannel.close();
        r6.fileChannel = null;
     */
    @Override // io.netty.handler.codec.http.multipart.HttpData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ByteBuf getChunk(int i) throws IOException {
        if (this.file == null || i == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        if (this.fileChannel == null) {
            this.fileChannel = new RandomAccessFile(this.file, "r").getChannel();
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            try {
                int i4 = this.fileChannel.read(byteBufferAllocate);
                if (i4 == -1) {
                    break;
                }
                i2 += i4;
            } catch (IOException e) {
                this.fileChannel.close();
                this.fileChannel = null;
                throw e;
            }
        }
        if (i2 == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        byteBufferAllocate.flip();
        ByteBuf byteBufWrappedBuffer = Unpooled.wrappedBuffer(byteBufferAllocate);
        byteBufWrappedBuffer.readerIndex(0);
        byteBufWrappedBuffer.writerIndex(i2);
        return byteBufWrappedBuffer;
    }

    public abstract String getDiskFilename();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public File getFile() {
        return this.file;
    }

    public abstract String getPostfix();

    public abstract String getPrefix();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString() {
        return getString(HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean isInMemory() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // io.netty.handler.codec.http.multipart.HttpData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean renameTo(File file) throws Throwable {
        Throwable th;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        long jTransferTo;
        ObjectUtil.checkNotNull(file, "dest");
        File file2 = this.file;
        if (file2 == null) {
            throw new IOException("No file defined so cannot be renamed");
        }
        if (file2.renameTo(file)) {
            this.file = file;
            this.isRenamed = true;
            return true;
        }
        IOException iOException = null;
        long j = 0;
        try {
            randomAccessFile = new RandomAccessFile(this.file, "r");
            try {
                randomAccessFile2 = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
                try {
                    try {
                        FileChannel channel = randomAccessFile.getChannel();
                        FileChannel channel2 = randomAccessFile2.getChannel();
                        jTransferTo = 0;
                        long j2 = 8196;
                        while (true) {
                            try {
                                long j3 = this.size;
                                if (jTransferTo < j3) {
                                    if (j2 < j3 - jTransferTo) {
                                        j2 = j3 - jTransferTo;
                                    }
                                    long j5 = j2;
                                    jTransferTo += channel.transferTo(jTransferTo, j5, channel2);
                                    j2 = j5;
                                } else {
                                    try {
                                        break;
                                    } catch (IOException e) {
                                        iOException = e;
                                    }
                                }
                            } catch (IOException e2) {
                                iOException = e2;
                                j = jTransferTo;
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (IOException e3) {
                                        logger.warn("Multiple exceptions detected, the following will be suppressed {}", (Throwable) e3);
                                    }
                                }
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (IOException e5) {
                                        logger.warn("Multiple exceptions detected, the following will be suppressed {}", (Throwable) e5);
                                    }
                                }
                                jTransferTo = j;
                            }
                        }
                        randomAccessFile.close();
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e6) {
                            if (iOException == null) {
                                iOException = e6;
                            } else {
                                logger.warn("Multiple exceptions detected, the following will be suppressed {}", (Throwable) e6);
                            }
                        }
                    } catch (IOException e7) {
                        e = e7;
                        iOException = e;
                        if (randomAccessFile != null) {
                        }
                        if (randomAccessFile2 != null) {
                        }
                        jTransferTo = j;
                        if (iOException == null) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e8) {
                            iOException = e8;
                        }
                    }
                    if (randomAccessFile2 == null) {
                        throw th;
                    }
                    try {
                        randomAccessFile2.close();
                        throw th;
                    } catch (IOException e9) {
                        if (iOException == null) {
                            throw th;
                        }
                        logger.warn("Multiple exceptions detected, the following will be suppressed {}", (Throwable) e9);
                        throw th;
                    }
                }
            } catch (IOException e10) {
                e = e10;
                randomAccessFile2 = null;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile2 = null;
            }
        } catch (IOException e11) {
            e = e11;
            randomAccessFile = null;
            randomAccessFile2 = null;
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
            randomAccessFile2 = null;
        }
        if (iOException == null) {
            throw iOException;
        }
        if (jTransferTo != this.size) {
            if (file.delete()) {
                return false;
            }
            logger.warn("Failed to delete: {}", file);
            return false;
        }
        if (!this.file.delete()) {
            logger.warn("Failed to delete: {}", this.file);
        }
        this.file = file;
        this.isRenamed = true;
        return true;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(ByteBuf byteBuf) {
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        try {
            long j = byteBuf.readableBytes();
            this.size = j;
            checkSize(j);
            long j2 = this.definedSize;
            if (j2 > 0 && j2 < this.size) {
                throw new IOException("Out of size: " + this.size + " > " + this.definedSize);
            }
            if (this.file == null) {
                this.file = tempFile();
            }
            if (byteBuf.readableBytes() == 0) {
                if (!this.file.createNewFile()) {
                    if (this.file.length() == 0) {
                        byteBuf.release();
                        return;
                    } else if (!this.file.delete() || !this.file.createNewFile()) {
                        throw new IOException("file exists already: " + this.file);
                    }
                }
                return;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.file, InternalZipConstants.WRITE_MODE);
            try {
                randomAccessFile.setLength(0L);
                FileChannel channel = randomAccessFile.getChannel();
                ByteBuffer byteBufferNioBuffer = byteBuf.nioBuffer();
                int iWrite = 0;
                while (iWrite < this.size) {
                    iWrite += channel.write(byteBufferNioBuffer);
                }
                byteBuf.readerIndex(byteBuf.readerIndex() + iWrite);
                channel.force(false);
                randomAccessFile.close();
                setCompleted();
                byteBuf.release();
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        } finally {
            byteBuf.release();
        }
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public HttpData touch() {
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString(Charset charset) {
        File file = this.file;
        return file == null ? "" : charset == null ? new String(readFrom(file), HttpConstants.DEFAULT_CHARSET.name()) : new String(readFrom(file), charset.name());
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.ReferenceCounted
    public HttpData touch(Object obj) {
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(File file) throws IOException {
        long length = file.length();
        checkSize(length);
        this.size = length;
        if (this.file != null) {
            delete();
        }
        this.file = file;
        this.isRenamed = true;
        setCompleted();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(InputStream inputStream) throws IOException {
        ObjectUtil.checkNotNull(inputStream, "inputStream");
        if (this.file != null) {
            delete();
        }
        this.file = tempFile();
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.file, InternalZipConstants.WRITE_MODE);
        try {
            randomAccessFile.setLength(0L);
            FileChannel channel = randomAccessFile.getChannel();
            byte[] bArr = new byte[16384];
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int i = inputStream.read(bArr);
            int iWrite = 0;
            while (i > 0) {
                byteBufferWrap.position(i).flip();
                iWrite += channel.write(byteBufferWrap);
                checkSize(iWrite);
                byteBufferWrap.clear();
                i = inputStream.read(bArr);
            }
            channel.force(false);
            randomAccessFile.close();
            long j = iWrite;
            this.size = j;
            long j2 = this.definedSize;
            if (j2 > 0 && j2 < j) {
                if (!this.file.delete()) {
                    logger.warn("Failed to delete: {}", this.file);
                }
                this.file = null;
                throw new IOException("Out of size: " + this.size + " > " + this.definedSize);
            }
            this.isRenamed = true;
            setCompleted();
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }
}
