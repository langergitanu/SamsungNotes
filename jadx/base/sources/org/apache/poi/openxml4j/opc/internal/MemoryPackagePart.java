package org.apache.poi.openxml4j.opc.internal;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.internal.marshallers.ZipPartMarshaller;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class MemoryPackagePart extends PackagePart {
    protected byte[] data;

    public MemoryPackagePart(OPCPackage oPCPackage, PackagePartName packagePartName, String str) {
        super(oPCPackage, packagePartName, str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public void clear() {
        this.data = null;
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public InputStream getInputStreamImpl() {
        if (this.data == null) {
            this.data = new byte[0];
        }
        return new ByteArrayInputStream(this.data);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public OutputStream getOutputStreamImpl() {
        return new MemoryPackagePartOutputStream(this);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public long getSize() {
        if (this.data == null) {
            return 0L;
        }
        return r0.length;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.util.RecordFormatException */
    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public boolean load(InputStream inputStream) throws InvalidFormatException, RecordFormatException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            IOUtils.copy(inputStream, byteArrayOutputStream);
            this.data = byteArrayOutputStream.toByteArray();
            return true;
        } catch (IOException e) {
            throw new InvalidFormatException(e.getMessage());
        }
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public boolean save(OutputStream outputStream) {
        return new ZipPartMarshaller().marshall(this, outputStream);
    }

    public MemoryPackagePart(OPCPackage oPCPackage, PackagePartName packagePartName, String str, boolean z) {
        super(oPCPackage, packagePartName, new ContentType(str), z);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public void close() {
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public void flush() {
    }
}
