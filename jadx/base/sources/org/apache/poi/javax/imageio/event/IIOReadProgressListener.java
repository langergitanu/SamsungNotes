package org.apache.poi.javax.imageio.event;

import java.util.EventListener;
import org.apache.poi.javax.imageio.ImageReader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface IIOReadProgressListener extends EventListener {
    void imageComplete(ImageReader imageReader);

    void imageProgress(ImageReader imageReader, float f);

    void imageStarted(ImageReader imageReader, int i);

    void readAborted(ImageReader imageReader);

    void sequenceComplete(ImageReader imageReader);

    void sequenceStarted(ImageReader imageReader, int i);

    void thumbnailComplete(ImageReader imageReader);

    void thumbnailProgress(ImageReader imageReader, float f);

    void thumbnailStarted(ImageReader imageReader, int i, int i2);
}
