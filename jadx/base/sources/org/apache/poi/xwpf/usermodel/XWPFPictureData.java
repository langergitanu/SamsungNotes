package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLRelation;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.IOUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XWPFPictureData extends POIXMLDocumentPart {
    protected static final POIXMLRelation[] RELATIONS;
    private Long checksum;

    static {
        POIXMLRelation[] pOIXMLRelationArr = new POIXMLRelation[13];
        RELATIONS = pOIXMLRelationArr;
        pOIXMLRelationArr[2] = XWPFRelation.IMAGE_EMF;
        pOIXMLRelationArr[3] = XWPFRelation.IMAGE_WMF;
        pOIXMLRelationArr[4] = XWPFRelation.IMAGE_PICT;
        pOIXMLRelationArr[5] = XWPFRelation.IMAGE_JPEG;
        pOIXMLRelationArr[6] = XWPFRelation.IMAGE_PNG;
        pOIXMLRelationArr[7] = XWPFRelation.IMAGE_DIB;
        pOIXMLRelationArr[8] = XWPFRelation.IMAGE_GIF;
        pOIXMLRelationArr[9] = XWPFRelation.IMAGE_TIFF;
        pOIXMLRelationArr[10] = XWPFRelation.IMAGE_EPS;
        pOIXMLRelationArr[11] = XWPFRelation.IMAGE_BMP;
        pOIXMLRelationArr[12] = XWPFRelation.IMAGE_WPG;
    }

    public XWPFPictureData() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof XWPFPictureData)) {
            return false;
        }
        XWPFPictureData xWPFPictureData = (XWPFPictureData) obj;
        PackagePart packagePart = xWPFPictureData.getPackagePart();
        PackagePart packagePart2 = getPackagePart();
        if ((packagePart != null && packagePart2 == null) || (packagePart == null && packagePart2 != null)) {
            return false;
        }
        if (packagePart2 != null) {
            OPCPackage oPCPackage = packagePart.getPackage();
            OPCPackage oPCPackage2 = packagePart2.getPackage();
            if ((oPCPackage != null && oPCPackage2 == null) || (oPCPackage == null && oPCPackage2 != null)) {
                return false;
            }
            if (oPCPackage2 != null && !oPCPackage2.equals(oPCPackage)) {
                return false;
            }
        }
        if (getChecksum().equals(xWPFPictureData.getChecksum())) {
            return Arrays.equals(getData(), xWPFPictureData.getData());
        }
        return false;
    }

    public Long getChecksum() {
        if (this.checksum == null) {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = getPackagePart().getInputStream();
                    byte[] byteArray = IOUtils.toByteArray(inputStream);
                    IOUtils.closeQuietly(inputStream);
                    this.checksum = Long.valueOf(IOUtils.calculateChecksum(byteArray));
                } catch (IOException e) {
                    throw new POIXMLException(e);
                }
            } catch (Throwable th) {
                IOUtils.closeQuietly(inputStream);
                throw th;
            }
        }
        return this.checksum;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    public byte[] getData() throws POIXMLException {
        try {
            return IOUtils.toByteArray(getPackagePart().getInputStream());
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    public String getFileName() {
        String name = getPackagePart().getPartName().getName();
        return name.substring(name.lastIndexOf(47) + 1);
    }

    public int getPictureType() {
        String contentType = getPackagePart().getContentType();
        int i = 0;
        while (true) {
            POIXMLRelation[] pOIXMLRelationArr = RELATIONS;
            if (i >= pOIXMLRelationArr.length) {
                return 0;
            }
            POIXMLRelation pOIXMLRelation = pOIXMLRelationArr[i];
            if (pOIXMLRelation != null && pOIXMLRelation.getContentType().equals(contentType)) {
                return i;
            }
            i++;
        }
    }

    public int hashCode() {
        return getChecksum().hashCode();
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void onDocumentRead() {
        super.onDocumentRead();
    }

    public String suggestFileExtension() {
        return getPackagePart().getPartName().getExtension();
    }

    public XWPFPictureData(PackagePart packagePart) {
        super(packagePart);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void prepareForCommit() {
    }
}
