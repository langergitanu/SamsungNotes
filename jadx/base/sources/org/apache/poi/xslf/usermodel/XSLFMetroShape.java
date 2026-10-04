package org.apache.poi.xslf.usermodel;

import java.io.ByteArrayInputStream;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.p226sl.usermodel.Shape;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class XSLFMetroShape {
    public static Shape<?, ?> parseShape(byte[] bArr) throws Throwable {
        PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName("/drs/shapexml.xml");
        OPCPackage oPCPackage = null;
        try {
            OPCPackage oPCPackageOpen = OPCPackage.open(new ByteArrayInputStream(bArr));
            try {
                XSLFShape xSLFShape = new XSLFGroupShape(CTGroupShape.Factory.parse(oPCPackageOpen.getPart(packagePartNameCreatePartName).getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS), null).getShapes().get(0);
                oPCPackageOpen.close();
                return xSLFShape;
            } catch (Throwable th) {
                th = th;
                oPCPackage = oPCPackageOpen;
                if (oPCPackage != null) {
                    oPCPackage.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
