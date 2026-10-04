package net.lingala.zip4j.crypto;

import net.lingala.zip4j.crypto.engine.ZipCryptoEngine;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class StandardDecrypter implements IDecrypter {
    private byte[] crc = new byte[4];
    private FileHeader fileHeader;
    private ZipCryptoEngine zipCryptoEngine;

    public StandardDecrypter(FileHeader fileHeader, byte[] bArr) throws ZipException {
        if (fileHeader == null) {
            throw new ZipException("one of more of the input parameters were null in StandardDecryptor");
        }
        this.fileHeader = fileHeader;
        this.zipCryptoEngine = new ZipCryptoEngine();
        init(bArr);
    }

    @Override // net.lingala.zip4j.crypto.IDecrypter
    public int decryptData(byte[] bArr) {
        return decryptData(bArr, 0, bArr.length);
    }

    public void init(byte[] bArr) throws ZipException {
        byte[] crcBuff = this.fileHeader.getCrcBuff();
        byte[] bArr2 = this.crc;
        bArr2[3] = (byte) (crcBuff[3] & 255);
        byte b = crcBuff[3];
        byte b5 = (byte) ((b >> 8) & 255);
        bArr2[2] = b5;
        byte b6 = (byte) ((b >> 16) & 255);
        bArr2[1] = b6;
        byte b7 = (byte) ((b >> 24) & 255);
        int i = 0;
        bArr2[0] = b7;
        if (b5 > 0 || b6 > 0 || b7 > 0) {
            throw new IllegalStateException("Invalid CRC in File Header");
        }
        if (this.fileHeader.getPassword() == null || this.fileHeader.getPassword().length <= 0) {
            throw new ZipException("Wrong password!", 5);
        }
        this.zipCryptoEngine.initKeys(this.fileHeader.getPassword());
        try {
            byte b8 = bArr[0];
            while (i < 12) {
                ZipCryptoEngine zipCryptoEngine = this.zipCryptoEngine;
                zipCryptoEngine.updateKeys((byte) (zipCryptoEngine.decryptByte() ^ b8));
                i++;
                if (i != 12) {
                    b8 = bArr[i];
                }
            }
        } catch (Exception e) {
            throw new ZipException(e);
        }
    }

    @Override // net.lingala.zip4j.crypto.IDecrypter
    public int decryptData(byte[] bArr, int i, int i2) throws ZipException {
        if (i < 0 || i2 < 0) {
            throw new ZipException("one of the input parameters were null in standard decrpyt data");
        }
        for (int i4 = 0; i4 < i2; i4++) {
            try {
                byte bDecryptByte = (byte) (((bArr[i4] & 255) ^ this.zipCryptoEngine.decryptByte()) & 255);
                this.zipCryptoEngine.updateKeys(bDecryptByte);
                bArr[i4] = bDecryptByte;
            } catch (Exception e) {
                throw new ZipException(e);
            }
        }
        return i2;
    }
}
