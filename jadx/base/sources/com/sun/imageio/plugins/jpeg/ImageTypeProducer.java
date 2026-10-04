package com.sun.imageio.plugins.jpeg;

import androidx.core.view.MotionEventCompat;
import com.sun.imageio.plugins.jpeg.JPEG;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class ImageTypeProducer {
    private static final ImageTypeProducer[] defaultTypes = new ImageTypeProducer[12];
    private int csCode;
    boolean failed;
    private ImageTypeSpecifier type;

    public ImageTypeProducer(int i) {
        this.type = null;
        this.failed = false;
        this.csCode = i;
    }

    public static synchronized ImageTypeProducer getTypeProducer(int i) {
        if (i < 0 || i >= 12) {
            return null;
        }
        try {
            ImageTypeProducer[] imageTypeProducerArr = defaultTypes;
            if (imageTypeProducerArr[i] == null) {
                imageTypeProducerArr[i] = new ImageTypeProducer(i);
            }
            return imageTypeProducerArr[i];
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized ImageTypeSpecifier getType() {
        try {
            if (!this.failed && this.type == null) {
                try {
                    this.type = produce();
                } catch (Throwable unused) {
                    this.failed = true;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.type;
    }

    public ImageTypeSpecifier produce() {
        int i = this.csCode;
        if (i == 1) {
            return ImageTypeSpecifier.createFromBufferedImageType(10);
        }
        if (i == 2) {
            return ImageTypeSpecifier.createInterleaved(JPEG.JCS.sRGB, JPEG.bOffsRGB, 0, false, false);
        }
        if (i == 5) {
            if (JPEG.JCS.getYCC() != null) {
                return ImageTypeSpecifier.createInterleaved(JPEG.JCS.getYCC(), JPEG.bandOffsets[2], 0, false, false);
            }
            return null;
        }
        if (i == 6) {
            return ImageTypeSpecifier.createPacked(JPEG.JCS.sRGB, -16777216, 16711680, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 255, 3, false);
        }
        if (i == 10 && JPEG.JCS.getYCC() != null) {
            return ImageTypeSpecifier.createInterleaved(JPEG.JCS.getYCC(), JPEG.bandOffsets[3], 0, true, false);
        }
        return null;
    }

    public ImageTypeProducer() {
        this.type = null;
        this.failed = false;
        this.csCode = -1;
    }
}
