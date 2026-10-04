package io.netty.channel.oio;

import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.util.internal.ObjectUtil;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public abstract class OioByteStreamChannel extends AbstractOioByteChannel {
    private static final InputStream CLOSED_IN = new InputStream() { // from class: io.netty.channel.oio.OioByteStreamChannel.1
        @Override // java.io.InputStream
        public int read() {
            return -1;
        }
    };
    private static final OutputStream CLOSED_OUT = new OutputStream() { // from class: io.netty.channel.oio.OioByteStreamChannel.2
        @Override // java.io.OutputStream
        public void write(int i) throws ClosedChannelException {
            throw new ClosedChannelException();
        }
    };

    /* JADX INFO: renamed from: is */
    private InputStream f8864is;

    /* JADX INFO: renamed from: os */
    private OutputStream f8865os;
    private WritableByteChannel outChannel;

    public OioByteStreamChannel(Channel channel) {
        super(channel);
    }

    private static void checkEOF(FileRegion fileRegion) throws EOFException {
        if (fileRegion.transferred() >= fileRegion.count()) {
            return;
        }
        throw new EOFException("Expected to be able to write " + fileRegion.count() + " bytes, but only wrote " + fileRegion.transferred());
    }

    public final void activate(InputStream inputStream, OutputStream outputStream) {
        if (this.f8864is != null) {
            throw new IllegalStateException("input was set already");
        }
        if (this.f8865os != null) {
            throw new IllegalStateException("output was set already");
        }
        this.f8864is = (InputStream) ObjectUtil.checkNotNull(inputStream, "is");
        this.f8865os = (OutputStream) ObjectUtil.checkNotNull(outputStream, NetworkConfig.CLIENTS_OS);
        if (this.readWhenInactive) {
            eventLoop().execute(this.readTask);
            this.readWhenInactive = false;
        }
    }

    @Override // io.netty.channel.oio.AbstractOioByteChannel
    public int available() {
        try {
            return this.f8864is.available();
        } catch (IOException unused) {
            return 0;
        }
    }

    @Override // io.netty.channel.AbstractChannel
    public void doClose() throws IOException {
        InputStream inputStream = this.f8864is;
        OutputStream outputStream = this.f8865os;
        this.f8864is = CLOSED_IN;
        this.f8865os = CLOSED_OUT;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        }
    }

    @Override // io.netty.channel.oio.AbstractOioByteChannel
    public int doReadBytes(ByteBuf byteBuf) {
        RecvByteBufAllocator.Handle handleRecvBufAllocHandle = unsafe().recvBufAllocHandle();
        handleRecvBufAllocHandle.attemptedBytesRead(Math.max(1, Math.min(available(), byteBuf.maxWritableBytes())));
        return byteBuf.writeBytes(this.f8864is, handleRecvBufAllocHandle.attemptedBytesRead());
    }

    @Override // io.netty.channel.oio.AbstractOioByteChannel
    public void doWriteBytes(ByteBuf byteBuf) {
        OutputStream outputStream = this.f8865os;
        if (outputStream == null) {
            throw new NotYetConnectedException();
        }
        byteBuf.readBytes(outputStream, byteBuf.readableBytes());
    }

    @Override // io.netty.channel.oio.AbstractOioByteChannel
    public void doWriteFileRegion(FileRegion fileRegion) throws EOFException {
        OutputStream outputStream = this.f8865os;
        if (outputStream == null) {
            throw new NotYetConnectedException();
        }
        if (this.outChannel == null) {
            this.outChannel = Channels.newChannel(outputStream);
        }
        long j = 0;
        do {
            long jTransferTo = fileRegion.transferTo(this.outChannel, j);
            if (jTransferTo == -1) {
                checkEOF(fileRegion);
                return;
            }
            j += jTransferTo;
        } while (j < fileRegion.count());
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        OutputStream outputStream;
        InputStream inputStream = this.f8864is;
        return (inputStream == null || inputStream == CLOSED_IN || (outputStream = this.f8865os) == null || outputStream == CLOSED_OUT) ? false : true;
    }
}
