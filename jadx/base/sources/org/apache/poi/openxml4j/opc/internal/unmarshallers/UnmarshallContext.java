package org.apache.poi.openxml4j.opc.internal.unmarshallers;

import java.util.zip.ZipEntry;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePartName;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class UnmarshallContext {
    private OPCPackage _package;
    private PackagePartName partName;
    private ZipEntry zipEntry;

    public UnmarshallContext(OPCPackage oPCPackage, PackagePartName packagePartName) {
        this._package = oPCPackage;
        this.partName = packagePartName;
    }

    public OPCPackage getPackage() {
        return this._package;
    }

    public PackagePartName getPartName() {
        return this.partName;
    }

    public ZipEntry getZipEntry() {
        return this.zipEntry;
    }

    public void setPackage(OPCPackage oPCPackage) {
        this._package = oPCPackage;
    }

    public void setPartName(PackagePartName packagePartName) {
        this.partName = packagePartName;
    }

    public void setZipEntry(ZipEntry zipEntry) {
        this.zipEntry = zipEntry;
    }
}
