package org.apache.poi.p226sl.usermodel;

import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import org.apache.poi.java.awt.Dimension;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface PictureData {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum PictureType {
        EMF(2, 2, "image/x-emf", ".emf"),
        WMF(3, 3, "image/x-wmf", ".wmf"),
        PICT(4, 4, "image/pict", ".pict"),
        JPEG(5, 5, "image/jpeg", ".jpg"),
        PNG(6, 6, CoeditServiceConstants.MimeType.IMAGE_PNG, ".png"),
        DIB(7, 7, "image/dib", ".dib"),
        GIF(-1, 8, Constants.MIME_GIF, ".gif"),
        TIFF(-1, 9, "image/tiff", ".tif"),
        EPS(-1, 10, "image/x-eps", ".eps"),
        BMP(-1, 11, "image/x-ms-bmp", ".bmp"),
        WPG(-1, 12, "image/x-wpg", ".wpg"),
        WDP(-1, 13, "image/vnd.ms-photo", ".wdp");

        public final String contentType;
        public final String extension;
        public final int nativeId;
        public final int ooxmlId;

        PictureType(int i, int i2, String str, String str2) {
            this.nativeId = i;
            this.ooxmlId = i2;
            this.contentType = str;
            this.extension = str2;
        }

        public static PictureType forNativeID(int i) {
            for (PictureType pictureType : values()) {
                if (pictureType.nativeId == i) {
                    return pictureType;
                }
            }
            return null;
        }

        public static PictureType forOoxmlID(int i) {
            for (PictureType pictureType : values()) {
                if (pictureType.ooxmlId == i) {
                    return pictureType;
                }
            }
            return null;
        }
    }

    byte[] getChecksum();

    String getContentType();

    byte[] getData();

    Dimension getImageDimension();

    Dimension getImageDimensionInPixels();

    PictureType getType();

    void setData(byte[] bArr);
}
