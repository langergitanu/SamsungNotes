package com.airbnb.lottie.utils;

import androidx.collection.AbstractC0622a;
import androidx.core.os.TraceCompat;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class LottieTrace {
    private static final int MAX_DEPTH = 5;
    private final String[] sections = new String[5];
    private final long[] startTimeNs = new long[5];
    private int traceDepth = 0;
    private int depthPastMaxDepth = 0;

    public void beginSection(String str) {
        int i = this.traceDepth;
        if (i == 5) {
            this.depthPastMaxDepth++;
            return;
        }
        this.sections[i] = str;
        this.startTimeNs[i] = System.nanoTime();
        TraceCompat.beginSection(str);
        this.traceDepth++;
    }

    public float endSection(String str) {
        int i = this.depthPastMaxDepth;
        if (i > 0) {
            this.depthPastMaxDepth = i - 1;
            return 0.0f;
        }
        int i2 = this.traceDepth - 1;
        this.traceDepth = i2;
        if (i2 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(this.sections[i2])) {
            TraceCompat.endSection();
            return (System.nanoTime() - this.startTimeNs[this.traceDepth]) / 1000000.0f;
        }
        throw new IllegalStateException(AbstractC0622a.m1170p(this.sections[this.traceDepth], Extension.DOT, AbstractC0000a.m15l("Unbalanced trace call ", str, ". Expected ")));
    }
}
