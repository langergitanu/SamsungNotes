package org.apache.poi.xssf.usermodel;

import java.io.IOException;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.p227ss.usermodel.PictureData;
import org.apache.poi.util.IOUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSSFPictureData extends POIXMLDocumentPart implements PictureData {
    protected static final POIXMLRelation[] RELATIONS;

    static {
        POIXMLRelation[] pOIXMLRelationArr = new POIXMLRelation[13];
        RELATIONS = pOIXMLRelationArr;
        pOIXMLRelationArr[2] = XSSFRelation.IMAGE_EMF;
        pOIXMLRelationArr[3] = XSSFRelation.IMAGE_WMF;
        pOIXMLRelationArr[4] = XSSFRelation.IMAGE_PICT;
        pOIXMLRelationArr[5] = XSSFRelation.IMAGE_JPEG;
        pOIXMLRelationArr[6] = XSSFRelation.IMAGE_PNG;
        pOIXMLRelationArr[7] = XSSFRelation.IMAGE_DIB;
        pOIXMLRelationArr[8] = XSSFRelation.IMAGE_GIF;
        pOIXMLRelationArr[9] = XSSFRelation.IMAGE_TIFF;
        pOIXMLRelationArr[10] = XSSFRelation.IMAGE_EPS;
        pOIXMLRelationArr[11] = XSSFRelation.IMAGE_BMP;
        pOIXMLRelationArr[12] = XSSFRelation.IMAGE_WPG;
    }

    public XSSFPictureData() {
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    @Override // org.apache.poi.p227ss.usermodel.PictureData
    public byte[] getData() throws POIXMLException {
        try {
            return IOUtils.toByteArray(getPackagePart().getInputStream());
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    @Override // org.apache.poi.p227ss.usermodel.PictureData
    public String getMimeType() {
        return getPackagePart().getContentType();
    }

    @Override // org.apache.poi.p227ss.usermodel.PictureData
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

    @Override // org.apache.poi.p227ss.usermodel.PictureData
    public String suggestFileExtension() {
        return getPackagePart().getPartName().getExtension();
    }

    public XSSFPictureData(PackagePart packagePart) {
        super(packagePart);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void prepareForCommit() {
    }
}
