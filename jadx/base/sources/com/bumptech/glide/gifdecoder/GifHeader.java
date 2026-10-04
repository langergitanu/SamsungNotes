package com.bumptech.glide.gifdecoder;

import androidx.annotation.ColorInt;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class GifHeader {
    public static final int NETSCAPE_LOOP_COUNT_DOES_NOT_EXIST = -1;
    public static final int NETSCAPE_LOOP_COUNT_FOREVER = 0;

    @ColorInt
    int bgColor;
    int bgIndex;
    GifFrame currentFrame;
    boolean gctFlag;
    int gctSize;
    int height;
    int pixelAspect;
    int width;

    @ColorInt
    int[] gct = null;
    int status = 0;
    int frameCount = 0;
    final List<GifFrame> frames = new ArrayList();
    int loopCount = -1;

    public int getHeight() {
        return this.height;
    }

    public int getNumFrames() {
        return this.frameCount;
    }

    public int getStatus() {
        return this.status;
    }

    public int getWidth() {
        return this.width;
    }
}
