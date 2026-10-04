package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.pcap.TCPPacket;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class PcapWriteHandler extends ChannelDuplexHandler implements Closeable {
    private final boolean captureZeroByte;
    private ChannelType channelType;
    private InetSocketAddress handlerAddr;
    private InetSocketAddress initiatorAddr;
    private boolean isServerPipeline;
    private final InternalLogger logger;
    private final OutputStream outputStream;
    private PcapWriter pCapWriter;
    private int receiveSegmentNumber;
    private int sendSegmentNumber;
    private final boolean sharedOutputStream;
    private final AtomicReference<State> state;
    private final boolean writePcapGlobalHeader;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private boolean captureZeroByte;
        private ChannelType channelType;
        private InetSocketAddress handlerAddr;
        private InetSocketAddress initiatorAddr;
        private boolean isServerPipeline;
        private boolean sharedOutputStream;
        private boolean writePcapGlobalHeader;

        public PcapWriteHandler build(OutputStream outputStream) {
            ObjectUtil.checkNotNull(outputStream, "outputStream");
            return new PcapWriteHandler(this, outputStream);
        }

        public Builder captureZeroByte(boolean z) {
            this.captureZeroByte = z;
            return this;
        }

        public Builder forceTcpChannel(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, boolean z) {
            this.channelType = ChannelType.TCP;
            this.handlerAddr = (InetSocketAddress) ObjectUtil.checkNotNull(inetSocketAddress, "serverAddress");
            this.initiatorAddr = (InetSocketAddress) ObjectUtil.checkNotNull(inetSocketAddress2, "clientAddress");
            this.isServerPipeline = z;
            return this;
        }

        public Builder forceUdpChannel(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
            this.channelType = ChannelType.UDP;
            this.handlerAddr = (InetSocketAddress) ObjectUtil.checkNotNull(inetSocketAddress2, "remoteAddress");
            this.initiatorAddr = (InetSocketAddress) ObjectUtil.checkNotNull(inetSocketAddress, "localAddress");
            return this;
        }

        public Builder sharedOutputStream(boolean z) {
            this.sharedOutputStream = z;
            return this;
        }

        public Builder writePcapGlobalHeader(boolean z) {
            this.writePcapGlobalHeader = z;
            return this;
        }

        private Builder() {
            this.writePcapGlobalHeader = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ChannelType {
        TCP,
        UDP
    }

    public static Builder builder() {
        return new Builder();
    }

    private void completeTCPWrite(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, ByteBuf byteBuf, ByteBufAllocator byteBufAllocator, ChannelHandlerContext channelHandlerContext) {
        ByteBuf byteBufBuffer = byteBufAllocator.buffer();
        ByteBuf byteBufBuffer2 = byteBufAllocator.buffer();
        ByteBuf byteBufBuffer3 = byteBufAllocator.buffer();
        try {
            try {
            } catch (IOException e) {
                this.logger.error("Caught Exception While Writing Packet into Pcap", (Throwable) e);
                channelHandlerContext.fireExceptionCaught((Throwable) e);
            }
            if ((inetSocketAddress.getAddress() instanceof Inet4Address) && (inetSocketAddress2.getAddress() instanceof Inet4Address)) {
                IPPacket.writeTCPv4(byteBufBuffer, byteBuf, NetUtil.ipv4AddressToInt((Inet4Address) inetSocketAddress.getAddress()), NetUtil.ipv4AddressToInt((Inet4Address) inetSocketAddress2.getAddress()));
                EthernetPacket.writeIPv4(byteBufBuffer2, byteBufBuffer);
            } else {
                if (!(inetSocketAddress.getAddress() instanceof Inet6Address) || !(inetSocketAddress2.getAddress() instanceof Inet6Address)) {
                    this.logger.error("Source and Destination IP Address versions are not same. Source Address: {}, Destination Address: {}", inetSocketAddress.getAddress(), inetSocketAddress2.getAddress());
                    byteBufBuffer.release();
                    byteBufBuffer2.release();
                    byteBufBuffer3.release();
                }
                IPPacket.writeTCPv6(byteBufBuffer, byteBuf, inetSocketAddress.getAddress().getAddress(), inetSocketAddress2.getAddress().getAddress());
                EthernetPacket.writeIPv6(byteBufBuffer2, byteBufBuffer);
            }
            this.pCapWriter.writePacket(byteBufBuffer3, byteBufBuffer2);
            byteBufBuffer.release();
            byteBufBuffer2.release();
            byteBufBuffer3.release();
        } catch (Throwable th) {
            byteBufBuffer.release();
            byteBufBuffer2.release();
            byteBufBuffer3.release();
            throw th;
        }
    }

    private void completeUDPWrite(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, ByteBuf byteBuf, ByteBufAllocator byteBufAllocator, ChannelHandlerContext channelHandlerContext) {
        ByteBuf byteBufBuffer = byteBufAllocator.buffer();
        ByteBuf byteBufBuffer2 = byteBufAllocator.buffer();
        ByteBuf byteBufBuffer3 = byteBufAllocator.buffer();
        try {
            try {
            } catch (IOException e) {
                this.logger.error("Caught Exception While Writing Packet into Pcap", (Throwable) e);
                channelHandlerContext.fireExceptionCaught((Throwable) e);
            }
            if ((inetSocketAddress.getAddress() instanceof Inet4Address) && (inetSocketAddress2.getAddress() instanceof Inet4Address)) {
                IPPacket.writeUDPv4(byteBufBuffer, byteBuf, NetUtil.ipv4AddressToInt((Inet4Address) inetSocketAddress.getAddress()), NetUtil.ipv4AddressToInt((Inet4Address) inetSocketAddress2.getAddress()));
                EthernetPacket.writeIPv4(byteBufBuffer2, byteBufBuffer);
            } else {
                if (!(inetSocketAddress.getAddress() instanceof Inet6Address) || !(inetSocketAddress2.getAddress() instanceof Inet6Address)) {
                    this.logger.error("Source and Destination IP Address versions are not same. Source Address: {}, Destination Address: {}", inetSocketAddress.getAddress(), inetSocketAddress2.getAddress());
                    byteBufBuffer.release();
                    byteBufBuffer2.release();
                    byteBufBuffer3.release();
                }
                IPPacket.writeUDPv6(byteBufBuffer, byteBuf, inetSocketAddress.getAddress().getAddress(), inetSocketAddress2.getAddress().getAddress());
                EthernetPacket.writeIPv6(byteBufBuffer2, byteBufBuffer);
            }
            this.pCapWriter.writePacket(byteBufBuffer3, byteBufBuffer2);
            byteBufBuffer.release();
            byteBufBuffer2.release();
            byteBufBuffer3.release();
        } catch (Throwable th) {
            byteBufBuffer.release();
            byteBufBuffer2.release();
            byteBufBuffer3.release();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [io.netty.util.ReferenceCounted] */
    private void handleTCP(ChannelHandlerContext channelHandlerContext, Object obj, boolean z) throws Throwable {
        ?? r9;
        InetSocketAddress inetSocketAddress;
        InetSocketAddress inetSocketAddress2;
        ByteBuf byteBuf;
        ?? r8;
        InetSocketAddress inetSocketAddress3;
        InetSocketAddress inetSocketAddress4;
        InetSocketAddress inetSocketAddress5;
        if (!(obj instanceof ByteBuf)) {
            this.logger.debug("Discarding Pcap Write for TCP Object: {}", obj);
            return;
        }
        ByteBuf byteBuf2 = (ByteBuf) obj;
        if (byteBuf2.readableBytes() == 0 && !this.captureZeroByte) {
            this.logger.debug("Discarding Zero Byte TCP Packet. isWriteOperation {}", Boolean.valueOf(z));
            return;
        }
        ByteBufAllocator byteBufAllocatorAlloc = channelHandlerContext.alloc();
        ByteBuf byteBufDuplicate = byteBuf2.duplicate();
        ByteBuf byteBufBuffer = byteBufAllocatorAlloc.buffer();
        int i = byteBufDuplicate.readableBytes();
        try {
            try {
                try {
                    try {
                        if (z) {
                            if (this.isServerPipeline) {
                                inetSocketAddress4 = this.handlerAddr;
                                inetSocketAddress5 = this.initiatorAddr;
                            } else {
                                inetSocketAddress4 = this.initiatorAddr;
                                inetSocketAddress5 = this.handlerAddr;
                            }
                            int i2 = this.sendSegmentNumber;
                            int i4 = this.receiveSegmentNumber;
                            int port = inetSocketAddress4.getPort();
                            int port2 = inetSocketAddress5.getPort();
                            TCPPacket.TCPFlag tCPFlag = TCPPacket.TCPFlag.ACK;
                            TCPPacket.writePacket(byteBufBuffer, byteBufDuplicate, i2, i4, port, port2, tCPFlag);
                            completeTCPWrite(inetSocketAddress4, inetSocketAddress5, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext);
                            InetSocketAddress inetSocketAddress6 = inetSocketAddress4;
                            InetSocketAddress inetSocketAddress7 = inetSocketAddress5;
                            logTCP(true, i, this.sendSegmentNumber, this.receiveSegmentNumber, inetSocketAddress6, inetSocketAddress7, false);
                            int i5 = this.sendSegmentNumber + i;
                            this.sendSegmentNumber = i5;
                            TCPPacket.writePacket(byteBufBuffer, null, this.receiveSegmentNumber, i5, inetSocketAddress7.getPort(), inetSocketAddress6.getPort(), tCPFlag);
                            completeTCPWrite(inetSocketAddress7, inetSocketAddress6, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext);
                            byteBuf = byteBufBuffer;
                            r8 = 1;
                            inetSocketAddress3 = inetSocketAddress7;
                            logTCP(true, i, this.sendSegmentNumber, this.receiveSegmentNumber, inetSocketAddress3, inetSocketAddress6, true);
                        } else {
                            if (this.isServerPipeline) {
                                inetSocketAddress = this.initiatorAddr;
                                inetSocketAddress2 = this.handlerAddr;
                            } else {
                                inetSocketAddress = this.handlerAddr;
                                inetSocketAddress2 = this.initiatorAddr;
                            }
                            int i6 = this.receiveSegmentNumber;
                            int i7 = this.sendSegmentNumber;
                            int port3 = inetSocketAddress.getPort();
                            int port4 = inetSocketAddress2.getPort();
                            TCPPacket.TCPFlag tCPFlag2 = TCPPacket.TCPFlag.ACK;
                            TCPPacket.writePacket(byteBufBuffer, byteBufDuplicate, i6, i7, port3, port4, tCPFlag2);
                            completeTCPWrite(inetSocketAddress, inetSocketAddress2, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext);
                            InetSocketAddress inetSocketAddress8 = inetSocketAddress;
                            InetSocketAddress inetSocketAddress9 = inetSocketAddress2;
                            logTCP(false, i, this.receiveSegmentNumber, this.sendSegmentNumber, inetSocketAddress8, inetSocketAddress9, false);
                            int i8 = this.receiveSegmentNumber + i;
                            this.receiveSegmentNumber = i8;
                            TCPPacket.writePacket(byteBufBuffer, null, this.sendSegmentNumber, i8, inetSocketAddress9.getPort(), inetSocketAddress8.getPort(), tCPFlag2);
                            completeTCPWrite(inetSocketAddress9, inetSocketAddress8, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext);
                            byteBuf = byteBufBuffer;
                            r8 = 1;
                            inetSocketAddress3 = inetSocketAddress9;
                            logTCP(false, i, this.sendSegmentNumber, this.receiveSegmentNumber, inetSocketAddress3, inetSocketAddress8, true);
                        }
                        byteBuf.release();
                    } catch (Throwable th) {
                        th = th;
                        r9.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r9 = r8;
                    r9.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                r9 = byteBufBuffer;
                r9.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r9 = inetSocketAddress3;
            r9.release();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleUDP(ChannelHandlerContext channelHandlerContext, Object obj) throws Throwable {
        Throwable th;
        PcapWriteHandler pcapWriteHandler;
        Throwable th2;
        ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer();
        try {
        } catch (Throwable th3) {
            th = th3;
        }
        if (!(obj instanceof DatagramPacket)) {
            pcapWriteHandler = this;
            try {
                try {
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                th = th5;
            }
            if (obj instanceof ByteBuf) {
                if (channelHandlerContext.channel() instanceof DatagramChannel) {
                    try {
                        if (((DatagramChannel) channelHandlerContext.channel()).isConnected()) {
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        th2 = th;
                        th = th2;
                        byteBufBuffer.release();
                        throw th;
                    }
                }
                if (((ByteBuf) obj).readableBytes() == 0 && !pcapWriteHandler.captureZeroByte) {
                    pcapWriteHandler.logger.debug("Discarding Zero Byte UDP Packet");
                    byteBufBuffer.release();
                    return;
                } else {
                    ByteBuf byteBufDuplicate = ((ByteBuf) obj).duplicate();
                    pcapWriteHandler.logger.debug("Writing UDP Data of {} Bytes, Src Addr {}, Dst Addr {}", Integer.valueOf(byteBufDuplicate.readableBytes()), pcapWriteHandler.initiatorAddr, pcapWriteHandler.handlerAddr);
                    UDPPacket.writePacket(byteBufBuffer, byteBufDuplicate, pcapWriteHandler.initiatorAddr.getPort(), pcapWriteHandler.handlerAddr.getPort());
                    pcapWriteHandler.completeUDPWrite(pcapWriteHandler.initiatorAddr, pcapWriteHandler.handlerAddr, byteBufBuffer, channelHandlerContext.alloc(), channelHandlerContext);
                }
                th = th;
                byteBufBuffer.release();
                throw th;
            }
            pcapWriteHandler.logger.debug("Discarding Pcap Write for UDP Object: {}", obj);
            byteBufBuffer.release();
            return;
        }
        try {
            if (((DatagramPacket) obj).content().readableBytes() == 0) {
                try {
                    if (!this.captureZeroByte) {
                        this.logger.debug("Discarding Zero Byte UDP Packet");
                        byteBufBuffer.release();
                        return;
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            }
            DatagramPacket datagramPacketDuplicate = ((DatagramPacket) obj).duplicate();
            InetSocketAddress inetSocketAddressSender = datagramPacketDuplicate.sender();
            InetSocketAddress inetSocketAddressRecipient = datagramPacketDuplicate.recipient();
            if (inetSocketAddressSender == null) {
                inetSocketAddressSender = (InetSocketAddress) channelHandlerContext.channel().localAddress();
            }
            InetSocketAddress inetSocketAddress = inetSocketAddressSender;
            this.logger.debug("Writing UDP Data of {} Bytes, Src Addr {}, Dst Addr {}", Integer.valueOf(datagramPacketDuplicate.content().readableBytes()), inetSocketAddress, inetSocketAddressRecipient);
            UDPPacket.writePacket(byteBufBuffer, datagramPacketDuplicate.content(), inetSocketAddress.getPort(), inetSocketAddressRecipient.getPort());
            try {
                completeUDPWrite(inetSocketAddress, inetSocketAddressRecipient, byteBufBuffer, channelHandlerContext.alloc(), channelHandlerContext);
                byteBufBuffer.release();
                return;
            } catch (Throwable th8) {
                th2 = th8;
            }
        } catch (Throwable th9) {
            th = th9;
            pcapWriteHandler = this;
            th2 = th;
        }
        th = th2;
        byteBufBuffer.release();
        throw th;
    }

    private void initializeIfNecessary(ChannelHandlerContext channelHandlerContext) throws Throwable {
        PcapWriteHandler pcapWriteHandler;
        ByteBuf byteBuf;
        TCPPacket.TCPFlag tCPFlag;
        PcapWriteHandler pcapWriteHandler2;
        ByteBuf byteBuf2;
        if (this.state.get() != State.INIT) {
            return;
        }
        this.pCapWriter = new PcapWriter(this);
        if (this.channelType == null) {
            if (channelHandlerContext.channel() instanceof SocketChannel) {
                this.channelType = ChannelType.TCP;
                if (channelHandlerContext.channel().parent() instanceof ServerSocketChannel) {
                    this.isServerPipeline = true;
                    this.initiatorAddr = (InetSocketAddress) channelHandlerContext.channel().remoteAddress();
                    this.handlerAddr = (InetSocketAddress) channelHandlerContext.channel().localAddress();
                } else {
                    this.isServerPipeline = false;
                    this.initiatorAddr = (InetSocketAddress) channelHandlerContext.channel().localAddress();
                    this.handlerAddr = (InetSocketAddress) channelHandlerContext.channel().remoteAddress();
                }
            } else if (channelHandlerContext.channel() instanceof DatagramChannel) {
                this.channelType = ChannelType.UDP;
                if (((DatagramChannel) channelHandlerContext.channel()).isConnected()) {
                    this.initiatorAddr = (InetSocketAddress) channelHandlerContext.channel().localAddress();
                    this.handlerAddr = (InetSocketAddress) channelHandlerContext.channel().remoteAddress();
                }
            }
        }
        if (this.channelType == ChannelType.TCP) {
            this.logger.debug("Initiating Fake TCP 3-Way Handshake");
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer();
            try {
                int port = this.initiatorAddr.getPort();
                int port2 = this.handlerAddr.getPort();
                tCPFlag = TCPPacket.TCPFlag.SYN;
                TCPPacket.writePacket(byteBufBuffer, null, 0, 0, port, port2, tCPFlag);
                byteBuf = byteBufBuffer;
                try {
                    completeTCPWrite(this.initiatorAddr, this.handlerAddr, byteBuf, channelHandlerContext.alloc(), channelHandlerContext);
                    pcapWriteHandler2 = this;
                    byteBuf2 = byteBuf;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                byteBuf = byteBufBuffer;
            }
            try {
                int port3 = pcapWriteHandler2.handlerAddr.getPort();
                int port4 = pcapWriteHandler2.initiatorAddr.getPort();
                TCPPacket.TCPFlag tCPFlag2 = TCPPacket.TCPFlag.ACK;
                TCPPacket.writePacket(byteBuf2, null, 0, 1, port3, port4, tCPFlag, tCPFlag2);
                pcapWriteHandler2.completeTCPWrite(pcapWriteHandler2.handlerAddr, pcapWriteHandler2.initiatorAddr, byteBuf2, channelHandlerContext.alloc(), channelHandlerContext);
                pcapWriteHandler2 = pcapWriteHandler2;
                byteBuf2 = byteBuf2;
                TCPPacket.writePacket(byteBuf2, null, 1, 1, pcapWriteHandler2.initiatorAddr.getPort(), pcapWriteHandler2.handlerAddr.getPort(), tCPFlag2);
                byteBuf = byteBuf2;
                pcapWriteHandler = pcapWriteHandler2;
                pcapWriteHandler.completeTCPWrite(pcapWriteHandler2.initiatorAddr, pcapWriteHandler2.handlerAddr, byteBuf, channelHandlerContext.alloc(), channelHandlerContext);
                byteBuf.release();
                pcapWriteHandler.logger.debug("Finished Fake TCP 3-Way Handshake");
            } catch (Throwable th3) {
                th = th3;
                byteBuf = byteBuf2;
                Throwable th4 = th;
                byteBuf.release();
                throw th4;
            }
        } else {
            pcapWriteHandler = this;
        }
        pcapWriteHandler.state.set(State.WRITING);
    }

    private void logDiscard() {
        this.logger.warn("Discarding pcap write because channel type is unknown. The channel this handler is registered on is not a SocketChannel or DatagramChannel, so the inference does not work. Please call forceTcpChannel or forceUdpChannel before registering the handler.");
    }

    private void logTCP(boolean z, int i, int i2, int i4, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, boolean z2) {
        if (this.logger.isDebugEnabled()) {
            if (z2) {
                this.logger.debug("Writing TCP ACK, isWriteOperation {}, Segment Number {}, Ack Number {}, Src Addr {}, Dst Addr {}", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i4), inetSocketAddress2, inetSocketAddress);
            } else {
                this.logger.debug("Writing TCP Data of {} Bytes, isWriteOperation {}, Segment Number {}, Ack Number {}, Src Addr {}, Dst Addr {}", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i4), inetSocketAddress, inetSocketAddress2);
            }
        }
    }

    public static void writeGlobalHeader(OutputStream outputStream) throws IOException {
        PcapHeaders.writeGlobalHeader(outputStream);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Throwable {
        initializeIfNecessary(channelHandlerContext);
        super.channelActive(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Throwable {
        if (this.state.get() == State.INIT) {
            initializeIfNecessary(channelHandlerContext);
        }
        if (this.state.get() == State.WRITING) {
            ChannelType channelType = this.channelType;
            if (channelType == ChannelType.TCP) {
                handleTCP(channelHandlerContext, obj, false);
            } else if (channelType == ChannelType.UDP) {
                handleUDP(channelHandlerContext, obj);
            } else {
                logDiscard();
            }
        }
        super.channelRead(channelHandlerContext, obj);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.state.get() == State.CLOSED) {
            this.logger.debug("PcapWriterHandler is already closed");
            return;
        }
        markClosed();
        this.pCapWriter.close();
        this.logger.debug("PcapWriterHandler is now closed");
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Throwable {
        ChannelHandlerContext channelHandlerContext2;
        ByteBuf byteBuf;
        if (this.channelType == ChannelType.TCP) {
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer();
            try {
                TCPPacket.writePacket(byteBufBuffer, null, this.sendSegmentNumber, this.receiveSegmentNumber, this.initiatorAddr.getPort(), this.handlerAddr.getPort(), TCPPacket.TCPFlag.RST, TCPPacket.TCPFlag.ACK);
                channelHandlerContext2 = channelHandlerContext;
                byteBuf = byteBufBuffer;
                try {
                    completeTCPWrite(this.initiatorAddr, this.handlerAddr, byteBuf, channelHandlerContext.alloc(), channelHandlerContext2);
                    byteBuf.release();
                    this.logger.debug("Sent Fake TCP RST to close connection");
                } catch (Throwable th2) {
                    th = th2;
                    Throwable th3 = th;
                    byteBuf.release();
                    throw th3;
                }
            } catch (Throwable th4) {
                th = th4;
                byteBuf = byteBufBuffer;
            }
        } else {
            channelHandlerContext2 = channelHandlerContext;
        }
        close();
        channelHandlerContext2.fireExceptionCaught(th);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Throwable {
        ChannelHandlerContext channelHandlerContext2;
        TCPPacket.TCPFlag tCPFlag;
        TCPPacket.TCPFlag tCPFlag2;
        ByteBuf byteBuf;
        if (this.channelType == ChannelType.TCP) {
            this.logger.debug("Starting Fake TCP FIN+ACK Flow to close connection");
            ByteBufAllocator byteBufAllocatorAlloc = channelHandlerContext.alloc();
            ByteBuf byteBufBuffer = byteBufAllocatorAlloc.buffer();
            try {
                int i = this.sendSegmentNumber;
                int i2 = this.receiveSegmentNumber;
                int port = this.initiatorAddr.getPort();
                int port2 = this.handlerAddr.getPort();
                tCPFlag = TCPPacket.TCPFlag.FIN;
                tCPFlag2 = TCPPacket.TCPFlag.ACK;
                byteBuf = byteBufBuffer;
                try {
                    TCPPacket.writePacket(byteBuf, null, i, i2, port, port2, tCPFlag, tCPFlag2);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                completeTCPWrite(this.initiatorAddr, this.handlerAddr, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext);
                byteBuf = byteBufBuffer;
                try {
                    TCPPacket.writePacket(byteBuf, null, this.receiveSegmentNumber, this.sendSegmentNumber, this.handlerAddr.getPort(), this.initiatorAddr.getPort(), tCPFlag, tCPFlag2);
                    completeTCPWrite(this.handlerAddr, this.initiatorAddr, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext);
                    byteBuf = byteBufBuffer;
                    TCPPacket.writePacket(byteBuf, null, this.sendSegmentNumber + 1, this.receiveSegmentNumber + 1, this.initiatorAddr.getPort(), this.handlerAddr.getPort(), tCPFlag2);
                    channelHandlerContext2 = channelHandlerContext;
                    completeTCPWrite(this.initiatorAddr, this.handlerAddr, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext2);
                    byteBufBuffer.release();
                    this.logger.debug("Finished Fake TCP FIN+ACK Flow to close connection");
                } catch (Throwable th3) {
                    th = th3;
                    byteBufBuffer = byteBuf;
                    Throwable th4 = th;
                    byteBufBuffer.release();
                    throw th4;
                }
            } catch (Throwable th5) {
                th = th5;
                Throwable th42 = th;
                byteBufBuffer.release();
                throw th42;
            }
        } else {
            channelHandlerContext2 = channelHandlerContext;
        }
        close();
        super.handlerRemoved(channelHandlerContext2);
    }

    public boolean isWriting() {
        return this.state.get() == State.WRITING;
    }

    public void markClosed() {
        State state = this.state.get();
        State state2 = State.CLOSED;
        if (state != state2) {
            this.state.set(state2);
        }
    }

    public OutputStream outputStream() {
        return this.outputStream;
    }

    public PcapWriter pCapWriter() {
        return this.pCapWriter;
    }

    public void pause() {
        AtomicReference<State> atomicReference = this.state;
        State state = State.WRITING;
        State state2 = State.PAUSED;
        while (!atomicReference.compareAndSet(state, state2)) {
            if (atomicReference.get() != state) {
                throw new IllegalStateException("State must be 'STARTED' to pause but current state is: " + this.state);
            }
        }
    }

    public void resume() {
        AtomicReference<State> atomicReference = this.state;
        State state = State.PAUSED;
        State state2 = State.WRITING;
        while (!atomicReference.compareAndSet(state, state2)) {
            if (atomicReference.get() != state) {
                throw new IllegalStateException("State must be 'PAUSED' to resume but current state is: " + this.state);
            }
        }
    }

    public boolean sharedOutputStream() {
        return this.sharedOutputStream;
    }

    public State state() {
        return this.state.get();
    }

    public String toString() {
        return "PcapWriteHandler{captureZeroByte=" + this.captureZeroByte + ", writePcapGlobalHeader=" + this.writePcapGlobalHeader + ", sharedOutputStream=" + this.sharedOutputStream + ", sendSegmentNumber=" + this.sendSegmentNumber + ", receiveSegmentNumber=" + this.receiveSegmentNumber + ", channelType=" + this.channelType + ", initiatorAddr=" + this.initiatorAddr + ", handlerAddr=" + this.handlerAddr + ", isServerPipeline=" + this.isServerPipeline + ", state=" + this.state + '}';
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Throwable {
        if (this.state.get() == State.INIT) {
            initializeIfNecessary(channelHandlerContext);
        }
        if (this.state.get() == State.WRITING) {
            ChannelType channelType = this.channelType;
            if (channelType == ChannelType.TCP) {
                handleTCP(channelHandlerContext, obj, true);
            } else if (channelType == ChannelType.UDP) {
                handleUDP(channelHandlerContext, obj);
            } else {
                logDiscard();
            }
        }
        super.write(channelHandlerContext, obj, channelPromise);
    }

    @Deprecated
    public PcapWriteHandler(OutputStream outputStream) {
        this(outputStream, false, true);
    }

    @Deprecated
    public PcapWriteHandler(OutputStream outputStream, boolean z, boolean z2) {
        this.logger = InternalLoggerFactory.getInstance((Class<?>) PcapWriteHandler.class);
        this.sendSegmentNumber = 1;
        this.receiveSegmentNumber = 1;
        this.state = new AtomicReference<>(State.INIT);
        this.outputStream = (OutputStream) ObjectUtil.checkNotNull(outputStream, "OutputStream");
        this.captureZeroByte = z;
        this.writePcapGlobalHeader = z2;
        this.sharedOutputStream = false;
    }

    private PcapWriteHandler(Builder builder, OutputStream outputStream) {
        this.logger = InternalLoggerFactory.getInstance((Class<?>) PcapWriteHandler.class);
        this.sendSegmentNumber = 1;
        this.receiveSegmentNumber = 1;
        this.state = new AtomicReference<>(State.INIT);
        this.outputStream = outputStream;
        this.captureZeroByte = builder.captureZeroByte;
        this.sharedOutputStream = builder.sharedOutputStream;
        this.writePcapGlobalHeader = builder.writePcapGlobalHeader;
        this.channelType = builder.channelType;
        this.handlerAddr = builder.handlerAddr;
        this.initiatorAddr = builder.initiatorAddr;
        this.isServerPipeline = builder.isServerPipeline;
    }
}
