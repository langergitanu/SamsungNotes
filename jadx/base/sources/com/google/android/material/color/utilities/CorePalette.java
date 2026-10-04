package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CorePalette {

    /* JADX INFO: renamed from: a1 */
    public TonalPalette f2276a1;

    /* JADX INFO: renamed from: a2 */
    public TonalPalette f2277a2;

    /* JADX INFO: renamed from: a3 */
    public TonalPalette f2278a3;
    public TonalPalette error;

    /* JADX INFO: renamed from: n1 */
    public TonalPalette f2279n1;

    /* JADX INFO: renamed from: n2 */
    public TonalPalette f2280n2;

    private CorePalette(int i, boolean z) {
        Hct hctFromInt = Hct.fromInt(i);
        double hue = hctFromInt.getHue();
        double chroma = hctFromInt.getChroma();
        if (z) {
            this.f2276a1 = TonalPalette.fromHueAndChroma(hue, chroma);
            this.f2277a2 = TonalPalette.fromHueAndChroma(hue, chroma / 3.0d);
            this.f2278a3 = TonalPalette.fromHueAndChroma(60.0d + hue, chroma / 2.0d);
            this.f2279n1 = TonalPalette.fromHueAndChroma(hue, Math.min(chroma / 12.0d, 4.0d));
            this.f2280n2 = TonalPalette.fromHueAndChroma(hue, Math.min(chroma / 6.0d, 8.0d));
        } else {
            this.f2276a1 = TonalPalette.fromHueAndChroma(hue, Math.max(48.0d, chroma));
            this.f2277a2 = TonalPalette.fromHueAndChroma(hue, 16.0d);
            this.f2278a3 = TonalPalette.fromHueAndChroma(60.0d + hue, 24.0d);
            this.f2279n1 = TonalPalette.fromHueAndChroma(hue, 4.0d);
            this.f2280n2 = TonalPalette.fromHueAndChroma(hue, 8.0d);
        }
        this.error = TonalPalette.fromHueAndChroma(25.0d, 84.0d);
    }

    public static CorePalette contentOf(int i) {
        return new CorePalette(i, true);
    }

    /* JADX INFO: renamed from: of */
    public static CorePalette m3278of(int i) {
        return new CorePalette(i, false);
    }
}
