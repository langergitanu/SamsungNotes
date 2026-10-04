package org.apache.poi.openxml4j.opc;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.opc.internal.marshallers.ZipPartMarshaller;
import org.apache.poi.util.NotImplemented;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ZipPackagePart extends PackagePart {
    private ZipEntry zipEntry;

    public ZipPackagePart(OPCPackage oPCPackage, PackagePartName packagePartName, String str) {
        super(oPCPackage, packagePartName, str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    @NotImplemented
    public void close() {
        throw new InvalidOperationException("Method not implemented !");
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    @NotImplemented
    public void flush() {
        throw new InvalidOperationException("Method not implemented !");
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public InputStream getInputStreamImpl() {
        return ((ZipPackage) this._container).getZipArchive().getInputStream(this.zipEntry);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public OutputStream getOutputStreamImpl() {
        return null;
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public long getSize() {
        return this.zipEntry.getSize();
    }

    public ZipEntry getZipArchive() {
        return this.zipEntry;
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    @NotImplemented
    public boolean load(InputStream inputStream) {
        throw new InvalidOperationException("Method not implemented !");
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public boolean save(OutputStream outputStream) {
        return new ZipPartMarshaller().marshall(this, outputStream);
    }

    public ZipPackagePart(OPCPackage oPCPackage, ZipEntry zipEntry, PackagePartName packagePartName, String str) {
        super(oPCPackage, packagePartName, str);
        this.zipEntry = zipEntry;
    }
}
