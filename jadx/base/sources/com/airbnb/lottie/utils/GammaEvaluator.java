package com.airbnb.lottie.utils;

import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class GammaEvaluator {
    private static float EOCF_sRGB(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    private static float OECF_sRGB(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int evaluate(float f, int i, int i2) {
        if (i == i2 || f <= 0.0f) {
            return i;
        }
        if (f >= 1.0f) {
            return i2;
        }
        float f4 = ((i >> 24) & 255) / 255.0f;
        float f5 = ((i2 >> 24) & 255) / 255.0f;
        float fEOCF_sRGB = EOCF_sRGB(((i >> 16) & 255) / 255.0f);
        float fEOCF_sRGB2 = EOCF_sRGB(((i >> 8) & 255) / 255.0f);
        float fEOCF_sRGB3 = EOCF_sRGB((i & 255) / 255.0f);
        float fEOCF_sRGB4 = EOCF_sRGB(((i2 >> 16) & 255) / 255.0f);
        float fEOCF_sRGB5 = EOCF_sRGB(((i2 >> 8) & 255) / 255.0f);
        float fEOCF_sRGB6 = EOCF_sRGB((i2 & 255) / 255.0f);
        float fM29z = AbstractC0000a.m29z(f5, f4, f, f4);
        float fM29z2 = AbstractC0000a.m29z(fEOCF_sRGB4, fEOCF_sRGB, f, fEOCF_sRGB);
        float fM29z3 = AbstractC0000a.m29z(fEOCF_sRGB5, fEOCF_sRGB2, f, fEOCF_sRGB2);
        float fM29z4 = AbstractC0000a.m29z(fEOCF_sRGB6, fEOCF_sRGB3, f, fEOCF_sRGB3);
        float fOECF_sRGB = OECF_sRGB(fM29z2) * 255.0f;
        float fOECF_sRGB2 = OECF_sRGB(fM29z3) * 255.0f;
        return Math.round(OECF_sRGB(fM29z4) * 255.0f) | (Math.round(fOECF_sRGB) << 16) | (Math.round(fM29z * 255.0f) << 24) | (Math.round(fOECF_sRGB2) << 8);
    }
}
