package org.apache.poi.javax.imageio.event;

import java.util.EventListener;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.javax.imageio.ImageReader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface IIOReadUpdateListener extends EventListener {
    void imageUpdate(ImageReader imageReader, BufferedImage bufferedImage, int i, int i2, int i4, int i5, int i6, int i7, int[] iArr);

    void passComplete(ImageReader imageReader, BufferedImage bufferedImage);

    void passStarted(ImageReader imageReader, BufferedImage bufferedImage, int i, int i2, int i4, int i5, int i6, int i7, int i8, int[] iArr);

    void thumbnailPassComplete(ImageReader imageReader, BufferedImage bufferedImage);

    void thumbnailPassStarted(ImageReader imageReader, BufferedImage bufferedImage, int i, int i2, int i4, int i5, int i6, int i7, int i8, int[] iArr);

    void thumbnailUpdate(ImageReader imageReader, BufferedImage bufferedImage, int i, int i2, int i4, int i5, int i6, int i7, int[] iArr);
}
