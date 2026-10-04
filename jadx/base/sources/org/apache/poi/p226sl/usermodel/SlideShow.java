package org.apache.poi.p226sl.usermodel;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.java.awt.Dimension;
import org.apache.poi.p226sl.usermodel.PictureData;
import org.apache.poi.p226sl.usermodel.Shape;
import org.apache.poi.p226sl.usermodel.TextParagraph;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface SlideShow<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends Closeable {
    PictureData addPicture(File file, PictureData.PictureType pictureType);

    PictureData addPicture(InputStream inputStream, PictureData.PictureType pictureType);

    PictureData addPicture(byte[] bArr, PictureData.PictureType pictureType);

    MasterSheet<S, P> createMasterSheet();

    Slide<S, P> createSlide();

    PictureData findPictureData(byte[] bArr);

    Dimension getPageSize();

    List<? extends PictureData> getPictureData();

    Resources getResources();

    List<? extends MasterSheet<S, P>> getSlideMasters();

    List<? extends Slide<S, P>> getSlides();

    void setPageSize(Dimension dimension);

    void write(OutputStream outputStream);
}
