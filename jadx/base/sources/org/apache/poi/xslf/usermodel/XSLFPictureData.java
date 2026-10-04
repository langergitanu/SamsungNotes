package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.java.awt.Dimension;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.p226sl.image.ImageHeaderBitmap;
import org.apache.poi.p226sl.image.ImageHeaderEMF;
import org.apache.poi.p226sl.image.ImageHeaderPICT;
import org.apache.poi.p226sl.image.ImageHeaderWMF;
import org.apache.poi.p226sl.usermodel.PictureData;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.Units;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class XSLFPictureData extends POIXMLDocumentPart implements PictureData {
    private Long checksum;
    private int index;
    private Dimension origSize;

    /* JADX INFO: renamed from: org.apache.poi.xslf.usermodel.XSLFPictureData$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C141031 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType;

        static {
            int[] iArr = new int[PictureData.PictureType.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType = iArr;
            try {
                iArr[PictureData.PictureType.EMF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.WMF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.PICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.JPEG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.PNG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.DIB.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.GIF.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.EPS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.BMP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.WPG.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.WDP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.TIFF.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public XSLFPictureData() {
        this.checksum = null;
        this.origSize = null;
        this.index = -1;
    }

    public static XSLFRelation getRelationForType(PictureData.PictureType pictureType) {
        switch (C141031.$SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[pictureType.ordinal()]) {
            case 1:
                return XSLFRelation.IMAGE_EMF;
            case 2:
                return XSLFRelation.IMAGE_WMF;
            case 3:
                return XSLFRelation.IMAGE_PICT;
            case 4:
                return XSLFRelation.IMAGE_JPEG;
            case 5:
                return XSLFRelation.IMAGE_PNG;
            case 6:
                return XSLFRelation.IMAGE_DIB;
            case 7:
                return XSLFRelation.IMAGE_GIF;
            case 8:
                return XSLFRelation.IMAGE_EPS;
            case 9:
                return XSLFRelation.IMAGE_BMP;
            case 10:
                return XSLFRelation.IMAGE_WPG;
            case 11:
                return XSLFRelation.IMAGE_WDP;
            case 12:
                return XSLFRelation.IMAGE_TIFF;
            default:
                return null;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    public void cacheProperties() throws POIXMLException {
        if (this.origSize == null || this.checksum == null) {
            byte[] data = getData();
            this.checksum = Long.valueOf(IOUtils.calculateChecksum(data));
            PictureData.PictureType type = getType();
            if (type == null) {
                this.origSize = new Dimension(1, 1);
                return;
            }
            int i = C141031.$SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[type.ordinal()];
            if (i == 1) {
                this.origSize = new ImageHeaderEMF(data, 0).getSize();
                return;
            }
            if (i == 2) {
                this.origSize = new ImageHeaderWMF(data, 0).getSize();
            } else if (i != 3) {
                this.origSize = new ImageHeaderBitmap(data, 0).getSize();
            } else {
                this.origSize = new ImageHeaderPICT(data, 0).getSize();
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    @Override // org.apache.poi.p226sl.usermodel.PictureData
    public byte[] getChecksum() throws POIXMLException {
        cacheProperties();
        byte[] bArr = new byte[8];
        LittleEndian.putLong(bArr, 0, this.checksum.longValue());
        return bArr;
    }

    @Override // org.apache.poi.p226sl.usermodel.PictureData
    public String getContentType() {
        return getPackagePart().getContentType();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    @Override // org.apache.poi.p226sl.usermodel.PictureData
    public byte[] getData() throws POIXMLException {
        try {
            return IOUtils.toByteArray(getInputStream());
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    public String getFileName() {
        String name = getPackagePart().getPartName().getName();
        return name.substring(name.lastIndexOf(47) + 1);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    @Override // org.apache.poi.p226sl.usermodel.PictureData
    public Dimension getImageDimension() throws POIXMLException {
        cacheProperties();
        return this.origSize;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    @Override // org.apache.poi.p226sl.usermodel.PictureData
    public Dimension getImageDimensionInPixels() throws POIXMLException {
        Dimension imageDimension = getImageDimension();
        return new Dimension(Units.pointsToPixel(imageDimension.getWidth()), Units.pointsToPixel(imageDimension.getHeight()));
    }

    public int getIndex() {
        return this.index;
    }

    public InputStream getInputStream() {
        return getPackagePart().getInputStream();
    }

    @Override // org.apache.poi.p226sl.usermodel.PictureData
    public PictureData.PictureType getType() {
        String contentType = getContentType();
        if (XSLFRelation.IMAGE_EMF.getContentType().equals(contentType)) {
            return PictureData.PictureType.EMF;
        }
        if (XSLFRelation.IMAGE_WMF.getContentType().equals(contentType)) {
            return PictureData.PictureType.WMF;
        }
        if (XSLFRelation.IMAGE_PICT.getContentType().equals(contentType)) {
            return PictureData.PictureType.PICT;
        }
        if (XSLFRelation.IMAGE_JPEG.getContentType().equals(contentType)) {
            return PictureData.PictureType.JPEG;
        }
        if (XSLFRelation.IMAGE_PNG.getContentType().equals(contentType)) {
            return PictureData.PictureType.PNG;
        }
        if (XSLFRelation.IMAGE_DIB.getContentType().equals(contentType)) {
            return PictureData.PictureType.DIB;
        }
        if (XSLFRelation.IMAGE_GIF.getContentType().equals(contentType)) {
            return PictureData.PictureType.GIF;
        }
        if (XSLFRelation.IMAGE_EPS.getContentType().equals(contentType)) {
            return PictureData.PictureType.EPS;
        }
        if (XSLFRelation.IMAGE_BMP.getContentType().equals(contentType)) {
            return PictureData.PictureType.BMP;
        }
        if (XSLFRelation.IMAGE_WPG.getContentType().equals(contentType)) {
            return PictureData.PictureType.WPG;
        }
        if (XSLFRelation.IMAGE_WDP.getContentType().equals(contentType)) {
            return PictureData.PictureType.WDP;
        }
        if (XSLFRelation.IMAGE_TIFF.getContentType().equals(contentType)) {
            return PictureData.PictureType.TIFF;
        }
        return null;
    }

    @Override // org.apache.poi.p226sl.usermodel.PictureData
    public void setData(byte[] bArr) throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        outputStream.write(bArr);
        outputStream.close();
        this.checksum = Long.valueOf(IOUtils.calculateChecksum(bArr));
        this.origSize = null;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public String suggestFileExtension() {
        return getPackagePart().getPartName().getExtension();
    }

    public XSLFPictureData(PackagePart packagePart) {
        super(packagePart);
        this.checksum = null;
        this.origSize = null;
        this.index = -1;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void prepareForCommit() {
    }
}
