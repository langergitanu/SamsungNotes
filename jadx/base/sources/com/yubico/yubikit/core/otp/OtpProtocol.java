package com.yubico.yubikit.core.otp;

import com.yubico.yubikit.core.Version;
import com.yubico.yubikit.core.application.CommandException;
import com.yubico.yubikit.core.application.CommandState;
import com.yubico.yubikit.core.application.TimeoutException;
import com.yubico.yubikit.core.util.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import javax.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class OtpProtocol implements Closeable {
    private static final int DUMMY_REPORT_WRITE = 143;
    private static final int FEATURE_RPT_DATA_SIZE = 7;
    private static final int FEATURE_RPT_SIZE = 8;
    private static final int FRAME_SIZE = 70;
    private static final int RESP_PENDING_FLAG = 64;
    private static final int RESP_TIMEOUT_WAIT_FLAG = 32;
    private static final int SEQUENCE_MASK = 31;
    private static final int SEQUENCE_OFFSET = 4;
    private static final int SLOT_DATA_SIZE = 64;
    private static final int SLOT_WRITE_FLAG = 128;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) OtpProtocol.class);
    private final OtpConnection connection;
    private final CommandState defaultState = new CommandState();
    private final Version version;

    public OtpProtocol(OtpConnection otpConnection) throws IOException {
        this.connection = otpConnection;
        byte[] featureReport = readFeatureReport();
        if (featureReport[4] == 3) {
            byte[] bArr = new byte[51];
            Arrays.fill(bArr, (byte) 99);
            try {
                sendAndReceive((byte) 18, bArr, null);
            } catch (CommandException unused) {
            }
        }
        this.version = Version.fromBytes(Arrays.copyOfRange(featureReport, 1, 4));
    }

    private void awaitReadyToWrite() throws IOException {
        for (int i = 0; i < 20; i++) {
            if ((readFeatureReport()[7] & 128) == 0) {
                return;
            }
            try {
                Thread.sleep(50L);
            } catch (InterruptedException unused) {
            }
        }
        throw new IOException("Timeout waiting for YubiKey to become ready to receive");
    }

    private byte[] readFeatureReport() {
        byte[] bArr = new byte[8];
        this.connection.receive(bArr);
        com.yubico.yubikit.core.internal.Logger.trace(logger, "READ FEATURE REPORT: {}", StringUtils.bytesToHex(bArr));
        return bArr;
    }

    private byte[] readFrame(int i, CommandState commandState) throws TimeoutException, CommandRejectedException, IOException {
        long j;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte b = 0;
        boolean z = false;
        while (true) {
            byte[] featureReport = readFeatureReport();
            byte b5 = featureReport[7];
            if ((b5 & 64) != 0) {
                int i2 = b5 & 31;
                if (b == i2) {
                    byteArrayOutputStream.write(featureReport, 0, 7);
                    b = (byte) (b + 1);
                } else if (i2 == 0) {
                    resetState();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    com.yubico.yubikit.core.internal.Logger.trace(logger, "{} bytes read over HID: {}", Integer.valueOf(byteArray.length), StringUtils.bytesToHex(byteArray));
                    return byteArray;
                }
            } else {
                boolean z2 = true;
                if (b5 == 0) {
                    byte b6 = featureReport[4];
                    if (byteArrayOutputStream.size() > 0) {
                        throw new IOException("Incomplete transfer");
                    }
                    if (b6 == i + 1 || (i > 0 && b6 == 0 && featureReport[5] == 0)) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(featureReport, 1, 7);
                        com.yubico.yubikit.core.internal.Logger.trace(logger, "HID programming sequence updated. New status: {}", StringUtils.bytesToHex(bArrCopyOfRange));
                        return bArrCopyOfRange;
                    }
                    if (z) {
                        throw new TimeoutException("Timed out waiting for touch");
                    }
                    throw new CommandRejectedException("No data");
                }
                if ((b5 & 32) != 0) {
                    commandState.onKeepAliveStatus((byte) 2);
                    j = 100;
                } else {
                    commandState.onKeepAliveStatus((byte) 1);
                    z2 = z;
                    j = 20;
                }
                if (commandState.waitForCancel(j)) {
                    resetState();
                    throw new TimeoutException("Command cancelled by CommandState");
                }
                z = z2;
            }
        }
    }

    private void resetState() {
        byte[] bArr = new byte[8];
        bArr[7] = -113;
        writeFeatureReport(bArr);
    }

    private int sendFrame(byte b, byte[] bArr) throws IOException {
        com.yubico.yubikit.core.internal.Logger.trace(logger, "Sending payload over HID to slot {}: {}", String.format("0x%02x", Integer.valueOf(b & 255)), StringUtils.bytesToHex(bArr));
        ByteBuffer byteBufferPut = ByteBuffer.allocate(70).order(ByteOrder.LITTLE_ENDIAN).put(bArr).put(b).putShort(ChecksumUtils.calculateCrc(bArr, bArr.length)).put(new byte[3]);
        byteBufferPut.flip();
        byte b5 = readFeatureReport()[4];
        byte[] bArr2 = new byte[8];
        byte b6 = 0;
        while (byteBufferPut.hasRemaining()) {
            byteBufferPut.get(bArr2, 0, 7);
            if (shouldSend(bArr2, b6)) {
                bArr2[7] = (byte) (b6 | 128);
                awaitReadyToWrite();
                writeFeatureReport(bArr2);
            }
            b6 = (byte) (b6 + 1);
        }
        return b5;
    }

    private static boolean shouldSend(byte[] bArr, byte b) {
        if (b == 0 || b == 9) {
            return true;
        }
        for (int i = 0; i < 7; i++) {
            if (bArr[i] != 0) {
                return true;
            }
        }
        return false;
    }

    private void writeFeatureReport(byte[] bArr) {
        com.yubico.yubikit.core.internal.Logger.trace(logger, "WRITE FEATURE REPORT: {}", StringUtils.bytesToHex(bArr));
        this.connection.send(bArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.connection.close();
    }

    public Version getVersion() {
        return this.version;
    }

    public byte[] readStatus() {
        byte[] featureReport = readFeatureReport();
        return Arrays.copyOfRange(featureReport, 1, featureReport.length - 1);
    }

    public byte[] sendAndReceive(byte b, @Nullable byte[] bArr, @Nullable CommandState commandState) throws IOException {
        byte[] bArrCopyOf;
        if (bArr == null) {
            bArrCopyOf = new byte[64];
        } else {
            if (bArr.length > 64) {
                throw new IllegalArgumentException("Payload too large for HID frame!");
            }
            bArrCopyOf = Arrays.copyOf(bArr, 64);
        }
        int iSendFrame = sendFrame(b, bArrCopyOf);
        if (commandState == null) {
            commandState = this.defaultState;
        }
        return readFrame(iSendFrame, commandState);
    }
}
