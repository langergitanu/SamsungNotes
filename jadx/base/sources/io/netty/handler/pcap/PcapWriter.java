package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class PcapWriter implements Closeable {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PcapWriter.class);
    private final OutputStream outputStream;
    private final PcapWriteHandler pcapWriteHandler;

    public PcapWriter(PcapWriteHandler pcapWriteHandler) throws IOException {
        this.pcapWriteHandler = pcapWriteHandler;
        this.outputStream = pcapWriteHandler.outputStream();
        if (pcapWriteHandler.sharedOutputStream()) {
            return;
        }
        PcapHeaders.writeGlobalHeader(pcapWriteHandler.outputStream());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.pcapWriteHandler.state() == State.CLOSED) {
            logger.debug("PcapWriter is already closed");
            return;
        }
        if (this.pcapWriteHandler.sharedOutputStream()) {
            synchronized (this.outputStream) {
                this.outputStream.flush();
            }
        } else {
            this.outputStream.flush();
            this.outputStream.close();
        }
        this.pcapWriteHandler.markClosed();
        logger.debug("PcapWriter is now closed");
    }

    public String toString() {
        return "PcapWriter{outputStream=" + this.outputStream + '}';
    }

    public void writePacket(ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (this.pcapWriteHandler.state() == State.CLOSED) {
            logger.debug("Pcap Write attempted on closed PcapWriter");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        PcapHeaders.writePacketHeader(byteBuf, (int) (jCurrentTimeMillis / 1000), (int) ((jCurrentTimeMillis % 1000) * 1000), byteBuf2.readableBytes(), byteBuf2.readableBytes());
        if (!this.pcapWriteHandler.sharedOutputStream()) {
            byteBuf.readBytes(this.outputStream, byteBuf.readableBytes());
            byteBuf2.readBytes(this.outputStream, byteBuf2.readableBytes());
        } else {
            synchronized (this.outputStream) {
                byteBuf.readBytes(this.outputStream, byteBuf.readableBytes());
                byteBuf2.readBytes(this.outputStream, byteBuf2.readableBytes());
            }
        }
    }
}
