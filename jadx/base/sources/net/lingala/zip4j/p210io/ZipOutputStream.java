package net.lingala.zip4j.p210io;

import java.io.IOException;
import java.io.OutputStream;
import net.lingala.zip4j.model.ZipModel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ZipOutputStream extends DeflaterOutputStream {
    public ZipOutputStream(OutputStream outputStream) {
        this(outputStream, null);
    }

    @Override // net.lingala.zip4j.p210io.DeflaterOutputStream, net.lingala.zip4j.p210io.CipherOutputStream, net.lingala.zip4j.p210io.BaseOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    public ZipOutputStream(OutputStream outputStream, ZipModel zipModel) {
        super(outputStream, zipModel);
    }

    @Override // net.lingala.zip4j.p210io.DeflaterOutputStream, net.lingala.zip4j.p210io.CipherOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // net.lingala.zip4j.p210io.DeflaterOutputStream, net.lingala.zip4j.p210io.CipherOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.crc.update(bArr, i, i2);
        updateTotalBytesRead(i2);
        super.write(bArr, i, i2);
    }
}
