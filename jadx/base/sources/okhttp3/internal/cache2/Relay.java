package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.lingala.zip4j.util.InternalZipConstants;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    static final ByteString PREFIX_CLEAN = ByteString.encodeUtf8("OkHttp cache v1\n");
    static final ByteString PREFIX_DIRTY = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    final long bufferMaxSize;
    boolean complete;
    RandomAccessFile file;
    private final ByteString metadata;
    int sourceCount;
    Source upstream;
    long upstreamPos;
    Thread upstreamReader;
    final Buffer upstreamBuffer = new Buffer();
    final Buffer buffer = new Buffer();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        public RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.file.getChannel());
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (Relay.this) {
                try {
                    Relay relay = Relay.this;
                    int i = relay.sourceCount - 1;
                    relay.sourceCount = i;
                    if (i == 0) {
                        RandomAccessFile randomAccessFile2 = relay.file;
                        relay.file = null;
                        randomAccessFile = randomAccessFile2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            Relay relay;
            if (this.fileOperator == null) {
                throw new IllegalStateException("closed");
            }
            synchronized (Relay.this) {
                while (true) {
                    try {
                        long j2 = this.sourcePos;
                        Relay relay2 = Relay.this;
                        long j3 = relay2.upstreamPos;
                        if (j2 != j3) {
                            long size = j3 - relay2.buffer.size();
                            long j5 = this.sourcePos;
                            if (j5 < size) {
                                long jMin = Math.min(j, j3 - j5);
                                this.fileOperator.read(this.sourcePos + 32, buffer, jMin);
                                this.sourcePos += jMin;
                                return jMin;
                            }
                            long jMin2 = Math.min(j, j3 - j5);
                            Relay.this.buffer.copyTo(buffer, this.sourcePos - size, jMin2);
                            this.sourcePos += jMin2;
                            return jMin2;
                        }
                        if (relay2.complete) {
                            return -1L;
                        }
                        if (relay2.upstreamReader == null) {
                            relay2.upstreamReader = Thread.currentThread();
                            try {
                                Relay relay3 = Relay.this;
                                long j6 = relay3.upstream.read(relay3.upstreamBuffer, relay3.bufferMaxSize);
                                if (j6 == -1) {
                                    Relay.this.commit(j3);
                                    synchronized (Relay.this) {
                                        Relay relay4 = Relay.this;
                                        relay4.upstreamReader = null;
                                        relay4.notifyAll();
                                    }
                                    return -1L;
                                }
                                long jMin3 = Math.min(j6, j);
                                Relay.this.upstreamBuffer.copyTo(buffer, 0L, jMin3);
                                this.sourcePos += jMin3;
                                this.fileOperator.write(j3 + 32, Relay.this.upstreamBuffer.clone(), j6);
                                synchronized (Relay.this) {
                                    try {
                                        Relay relay5 = Relay.this;
                                        relay5.buffer.write(relay5.upstreamBuffer, j6);
                                        long size2 = Relay.this.buffer.size();
                                        Relay relay6 = Relay.this;
                                        if (size2 > relay6.bufferMaxSize) {
                                            Buffer buffer2 = relay6.buffer;
                                            buffer2.skip(buffer2.size() - Relay.this.bufferMaxSize);
                                        }
                                        relay = Relay.this;
                                        relay.upstreamPos += j6;
                                    } finally {
                                    }
                                }
                                synchronized (relay) {
                                    Relay relay7 = Relay.this;
                                    relay7.upstreamReader = null;
                                    relay7.notifyAll();
                                }
                                return jMin3;
                            } catch (Throwable th) {
                                synchronized (Relay.this) {
                                    Relay relay8 = Relay.this;
                                    relay8.upstreamReader = null;
                                    relay8.notifyAll();
                                    throw th;
                                }
                            }
                        }
                        this.timeout.waitUntilNotified(relay2);
                    } finally {
                    }
                }
            }
        }

        @Override // okio.Source
        /* JADX INFO: renamed from: timeout */
        public Timeout getTimeout() {
            return this.timeout;
        }
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j, ByteString byteString, long j2) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.complete = source == null;
        this.upstreamPos = j;
        this.metadata = byteString;
        this.bufferMaxSize = j2;
    }

    public static Relay edit(File file, Source source, ByteString byteString, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
        Relay relay = new Relay(randomAccessFile, source, 0L, byteString, j);
        randomAccessFile.setLength(0L);
        relay.writeHeader(PREFIX_DIRTY, -1L, -1L);
        return relay;
    }

    public static Relay read(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        Buffer buffer = new Buffer();
        fileOperator.read(0L, buffer, 32L);
        if (!buffer.readByteString(r10.size()).equals(PREFIX_CLEAN)) {
            throw new IOException("unreadable cache file");
        }
        long j = buffer.readLong();
        long j2 = buffer.readLong();
        Buffer buffer2 = new Buffer();
        fileOperator.read(32 + j, buffer2, j2);
        return new Relay(randomAccessFile, null, j, buffer2.readByteString(), 0L);
    }

    private void writeHeader(ByteString byteString, long j, long j2) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(byteString);
        buffer.writeLong(j);
        buffer.writeLong(j2);
        if (buffer.size() != 32) {
            throw new IllegalArgumentException();
        }
        new FileOperator(this.file.getChannel()).write(0L, buffer, 32L);
    }

    private void writeMetadata(long j) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(this.metadata);
        new FileOperator(this.file.getChannel()).write(32 + j, buffer, this.metadata.size());
    }

    public void commit(long j) throws IOException {
        writeMetadata(j);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, this.metadata.size());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Util.closeQuietly(this.upstream);
        this.upstream = null;
    }

    public boolean isClosed() {
        return this.file == null;
    }

    public ByteString metadata() {
        return this.metadata;
    }

    public Source newSource() {
        synchronized (this) {
            try {
                if (this.file == null) {
                    return null;
                }
                this.sourceCount++;
                return new RelaySource();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
