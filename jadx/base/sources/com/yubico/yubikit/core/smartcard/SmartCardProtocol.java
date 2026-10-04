package com.yubico.yubikit.core.smartcard;

import com.yubico.yubikit.core.Transport;
import com.yubico.yubikit.core.Version;
import com.yubico.yubikit.core.application.ApplicationNotAvailableException;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SmartCardProtocol implements Closeable {
    private static final byte INS_SELECT = -92;
    private static final byte INS_SEND_REMAINING = -64;
    private static final byte P1_SELECT = 4;
    private static final byte P2_SELECT = 0;
    private static final int SHORT_APDU_MAX_CHUNK = 255;
    private static final byte SW1_HAS_MORE_DATA = 97;
    private ApduFormat apduFormat;
    private final SmartCardConnection connection;
    private final byte insSendRemaining;
    private long lastLongResponse;
    private boolean useTouchWorkaround;

    /* JADX INFO: renamed from: com.yubico.yubikit.core.smartcard.SmartCardProtocol$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C119081 {
        static final /* synthetic */ int[] $SwitchMap$com$yubico$yubikit$core$smartcard$ApduFormat;

        static {
            int[] iArr = new int[ApduFormat.values().length];
            $SwitchMap$com$yubico$yubikit$core$smartcard$ApduFormat = iArr;
            try {
                iArr[ApduFormat.SHORT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$yubico$yubikit$core$smartcard$ApduFormat[ApduFormat.EXTENDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public SmartCardProtocol(SmartCardConnection smartCardConnection) {
        this(smartCardConnection, INS_SEND_REMAINING);
    }

    private static byte[] encodeExtendedApdu(byte b, byte b5, byte b6, byte b7, byte[] bArr) {
        return ByteBuffer.allocate(bArr.length + 7).put(b).put(b5).put(b6).put(b7).put((byte) 0).putShort((short) bArr.length).put(bArr).array();
    }

    private static byte[] encodeShortApdu(byte b, byte b5, byte b6, byte b7, byte[] bArr, int i, int i2) {
        if (i2 <= 255) {
            return ByteBuffer.allocate(i2 + 5).put(b).put(b5).put(b6).put(b7).put((byte) i2).put(bArr, i, i2).array();
        }
        throw new IllegalArgumentException("Length must be no greater than 255");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.connection.close();
    }

    public void enableWorkarounds(Version version) {
        if (this.connection.getTransport() == Transport.USB && version.isAtLeast(4, 2, 0) && version.isLessThan(4, 2, 7)) {
            setEnableTouchWorkaround(true);
        }
    }

    public SmartCardConnection getConnection() {
        return this.connection;
    }

    public byte[] select(byte[] bArr) {
        try {
            return sendAndReceive(new Apdu(0, -92, 4, 0, bArr));
        } catch (ApduException e) {
            if (e.getSw() == 27266 || e.getSw() == 27904) {
                throw new ApplicationNotAvailableException("The application couldn't be selected", e);
            }
            throw new IOException("Unexpected SW", e);
        }
    }

    public byte[] sendAndReceive(Apdu apdu) {
        ApduResponse apduResponse;
        byte[] bArr;
        if (this.useTouchWorkaround && this.lastLongResponse > 0 && System.currentTimeMillis() - this.lastLongResponse < 2000) {
            this.connection.sendAndReceive(new byte[5]);
            this.lastLongResponse = 0L;
        }
        byte[] data = apdu.getData();
        int i = C119081.$SwitchMap$com$yubico$yubikit$core$smartcard$ApduFormat[this.apduFormat.ordinal()];
        char c = 4;
        boolean z = true;
        if (i == 1) {
            int i2 = 0;
            while (data.length - i2 > 255) {
                boolean z2 = z;
                char c2 = c;
                ApduResponse apduResponse2 = new ApduResponse(this.connection.sendAndReceive(encodeShortApdu((byte) (apdu.getCla() | 16), apdu.getIns(), apdu.getP1(), apdu.getP2(), data, i2, 255)));
                if (apduResponse2.getSw() != -28672) {
                    throw new ApduException(apduResponse2.getSw());
                }
                i2 += 255;
                z = z2;
                c = c2;
            }
            apduResponse = new ApduResponse(this.connection.sendAndReceive(encodeShortApdu(apdu.getCla(), apdu.getIns(), apdu.getP1(), apdu.getP2(), data, i2, data.length - i2)));
            bArr = new byte[5];
            bArr[0] = 0;
            bArr[z ? 1 : 0] = this.insSendRemaining;
            bArr[2] = 0;
            bArr[3] = 0;
            bArr[c] = 0;
        } else {
            if (i != 2) {
                throw new IllegalStateException("Invalid APDU format");
            }
            apduResponse = new ApduResponse(this.connection.sendAndReceive(encodeExtendedApdu(apdu.getCla(), apdu.getIns(), apdu.getP1(), apdu.getP2(), data)));
            bArr = new byte[]{0, this.insSendRemaining, 0, 0, 0, 0, 0};
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((apduResponse.getSw() >> 8) == 97) {
            byteArrayOutputStream.write(apduResponse.getData());
            apduResponse = new ApduResponse(this.connection.sendAndReceive(bArr));
        }
        if (apduResponse.getSw() != -28672) {
            throw new ApduException(apduResponse.getSw());
        }
        byteArrayOutputStream.write(apduResponse.getData());
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (!this.useTouchWorkaround || byteArray.length <= 54) {
            this.lastLongResponse = 0L;
            return byteArray;
        }
        this.lastLongResponse = System.currentTimeMillis();
        return byteArray;
    }

    public void setApduFormat(ApduFormat apduFormat) {
        this.apduFormat = apduFormat;
    }

    public void setEnableTouchWorkaround(boolean z) {
        this.useTouchWorkaround = z;
    }

    public SmartCardProtocol(SmartCardConnection smartCardConnection, byte b) {
        this.apduFormat = ApduFormat.SHORT;
        this.useTouchWorkaround = false;
        this.lastLongResponse = 0L;
        this.connection = smartCardConnection;
        this.insSendRemaining = b;
    }
}
