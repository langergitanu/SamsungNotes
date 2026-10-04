package com.bumptech.glide.gifdecoder;

import androidx.annotation.ColorInt;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class GifFrame {
    static final int DISPOSAL_BACKGROUND = 2;
    static final int DISPOSAL_NONE = 1;
    static final int DISPOSAL_PREVIOUS = 3;
    static final int DISPOSAL_UNSPECIFIED = 0;
    int bufferFrameStart;
    int delay;
    int dispose;

    /* JADX INFO: renamed from: ih */
    int f1974ih;
    boolean interlace;

    /* JADX INFO: renamed from: iw */
    int f1975iw;

    /* JADX INFO: renamed from: ix */
    int f1976ix;

    /* JADX INFO: renamed from: iy */
    int f1977iy;

    @ColorInt
    int[] lct;
    int transIndex;
    boolean transparency;
}
