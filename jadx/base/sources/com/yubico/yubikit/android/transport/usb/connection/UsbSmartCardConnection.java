package com.yubico.yubikit.android.transport.usb.connection;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import com.yubico.yubikit.core.Transport;
import com.yubico.yubikit.core.smartcard.SmartCardConnection;
import com.yubico.yubikit.core.util.StringUtils;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class UsbSmartCardConnection extends UsbYubiKeyConnection implements SmartCardConnection {
    private static final byte POWER_ON_MESSAGE_TYPE = 98;
    private static final byte REQUEST_MESSAGE_TYPE = 111;
    private static final byte RESPONSE_DATA_BLOCK = -128;
    private static final byte STATUS_TIME_EXTENSION = -128;
    private static final int TIMEOUT = 1000;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) UsbSmartCardConnection.class);
    private final byte[] atr;
    private final UsbDeviceConnection connection;
    private final UsbEndpoint endpointIn;
    private final UsbEndpoint endpointOut;
    private byte sequence;

    public UsbSmartCardConnection(UsbDeviceConnection usbDeviceConnection, UsbInterface usbInterface, UsbEndpoint usbEndpoint, UsbEndpoint usbEndpoint2) {
        super(usbDeviceConnection, usbInterface);
        this.sequence = (byte) 0;
        this.connection = usbDeviceConnection;
        this.endpointIn = usbEndpoint;
        this.endpointOut = usbEndpoint2;
        this.atr = transceive(POWER_ON_MESSAGE_TYPE, new byte[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x005e, code lost:
    
        r13 = new java.io.ByteArrayOutputStream();
        r0 = r11.endpointIn.getMaxPacketSize();
        r1 = new byte[r0];
        r2 = false;
        r5 = false;
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x006e, code lost:
    
        r6 = r11.connection.bulkTransfer(r11.endpointIn, r1, r0, 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0078, code lost:
    
        if (r6 <= 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x007a, code lost:
    
        r7 = com.yubico.yubikit.android.transport.usb.connection.UsbSmartCardConnection.logger;
        com.yubico.yubikit.core.internal.Logger.trace(r7, "{} bytes received: {}", java.lang.Integer.valueOf(r6), com.yubico.yubikit.core.util.StringUtils.bytesToHex(r1, 0, r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0089, code lost:
    
        if (r2 == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x008b, code lost:
    
        r13.write(r1, 0, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x008f, code lost:
    
        r4 = new com.yubico.yubikit.android.transport.usb.connection.UsbSmartCardConnection.MessageHeader(r1, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x009c, code lost:
    
        if ((r4.status & (-128)) != (-128)) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x009e, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a0, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a9, code lost:
    
        if (r4.verify((byte) (r11.sequence - 1)) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ab, code lost:
    
        r13.write(r1, 0, r6);
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b4, code lost:
    
        if (r4.error == 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b6, code lost:
    
        if (r5 == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b9, code lost:
    
        r12 = java.util.Locale.ROOT;
        com.yubico.yubikit.core.internal.Logger.debug(r7, "Invalid response from card reader bStatus={} and bError={}", java.lang.String.format(r12, "0x%02X", java.lang.Byte.valueOf(r4.status)), java.lang.String.format(r12, "0x%02X", java.lang.Byte.valueOf(r4.error)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e9, code lost:
    
        throw new java.io.IOException("Invalid response from card reader");
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ea, code lost:
    
        if (r6 < 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ec, code lost:
    
        if (r6 <= 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ee, code lost:
    
        if (r6 == r0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f0, code lost:
    
        if (r5 != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f2, code lost:
    
        r12 = r13.toByteArray();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f6, code lost:
    
        if (r4 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00fd, code lost:
    
        if (r12.length < r4.size()) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x011a, code lost:
    
        return java.util.Arrays.copyOfRange(r12, r4.size(), r4.size() + java.lang.Math.min(r12.length - r4.size(), r4.dataLength));
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0122, code lost:
    
        throw new java.io.IOException("Response is invalid");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x012a, code lost:
    
        throw new java.io.IOException("Failed to read response");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] transceive(byte b, byte[] bArr) throws IOException {
        int length = bArr.length;
        byte b5 = this.sequence;
        this.sequence = (byte) (b5 + 1);
        MessageHeader messageHeader = new MessageHeader(b, length, b5);
        byte[] bArrArray = ByteBuffer.allocate(messageHeader.size() + bArr.length).order(ByteOrder.LITTLE_ENDIAN).put(messageHeader.array()).put(bArr).array();
        int iBulkTransfer = 0;
        int i = 0;
        while (true) {
            if (i >= bArrArray.length && iBulkTransfer != this.endpointOut.getMaxPacketSize()) {
                break;
            }
            iBulkTransfer = this.connection.bulkTransfer(this.endpointOut, bArrArray, i, bArrArray.length - i, 1000);
            if (iBulkTransfer > 0) {
                com.yubico.yubikit.core.internal.Logger.trace(logger, "{} bytes sent over ccid: {}", Integer.valueOf(iBulkTransfer), StringUtils.bytesToHex(bArrArray, i, iBulkTransfer));
                i += iBulkTransfer;
            } else if (iBulkTransfer < 0) {
                throw new IOException("Failed to send " + (bArrArray.length - i) + " bytes");
            }
        }
    }

    @Override // com.yubico.yubikit.android.transport.usb.connection.UsbYubiKeyConnection, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    @Override // com.yubico.yubikit.core.smartcard.SmartCardConnection
    public byte[] getAtr() {
        return (byte[]) this.atr.clone();
    }

    @Override // com.yubico.yubikit.core.smartcard.SmartCardConnection
    public Transport getTransport() {
        return Transport.USB;
    }

    @Override // com.yubico.yubikit.core.smartcard.SmartCardConnection
    public boolean isExtendedLengthApduSupported() {
        return true;
    }

    @Override // com.yubico.yubikit.core.smartcard.SmartCardConnection
    public byte[] sendAndReceive(byte[] bArr) {
        return transceive(REQUEST_MESSAGE_TYPE, bArr);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MessageHeader {
        private static final byte[] MESSAGE_SPECIFIC_BYTES = {0, 0, 0};
        private static final int SIZE_OF_CCID_PREFIX = 10;
        private static final byte SLOT_NUMBER = 0;
        private int dataLength;
        private byte error;

        @SuppressFBWarnings({"URF_UNREAD_FIELD"})
        private byte messageSpecificByte;
        private byte sequence;
        private byte slot;
        private byte status;
        private byte type;

        /* JADX INFO: Access modifiers changed from: private */
        public byte[] array() {
            return ByteBuffer.allocate(10).order(ByteOrder.LITTLE_ENDIAN).put(this.type).putInt(this.dataLength).put(this.slot).put(this.sequence).put(MESSAGE_SPECIFIC_BYTES).array();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int size() {
            return 10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean verify(byte b) {
            return this.type == -128 && this.slot == 0 && this.sequence == b && this.status == 0;
        }

        private MessageHeader(byte[] bArr) {
            if (bArr.length > 10) {
                ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr, 0, 10).order(ByteOrder.LITTLE_ENDIAN);
                this.type = byteBufferOrder.get();
                this.dataLength = byteBufferOrder.getInt();
                this.slot = byteBufferOrder.get();
                this.sequence = byteBufferOrder.get();
                this.status = byteBufferOrder.get();
                this.error = byteBufferOrder.get();
                this.messageSpecificByte = byteBufferOrder.get();
            }
        }

        private MessageHeader(byte b, int i, byte b5) {
            this.type = b;
            this.dataLength = i;
            this.slot = (byte) 0;
            this.sequence = b5;
        }
    }
}
