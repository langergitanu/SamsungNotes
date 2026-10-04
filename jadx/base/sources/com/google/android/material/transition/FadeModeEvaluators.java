package com.google.android.material.transition;

import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class FadeModeEvaluators {

    /* JADX INFO: renamed from: IN */
    private static final FadeModeEvaluator f2413IN = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.1
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f4, float f5, float f6) {
            return FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, f4, f5, f));
        }
    };
    private static final FadeModeEvaluator OUT = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.2
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f4, float f5, float f6) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f4, f5, f), 255);
        }
    };
    private static final FadeModeEvaluator CROSS = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.3
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f4, float f5, float f6) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f4, f5, f), TransitionUtils.lerp(0, 255, f4, f5, f));
        }
    };
    private static final FadeModeEvaluator THROUGH = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.4
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f4, float f5, float f6) {
            float fM29z = AbstractC0000a.m29z(f5, f4, f6, f4);
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f4, fM29z, f), TransitionUtils.lerp(0, 255, fM29z, f5, f));
        }
    };

    private FadeModeEvaluators() {
    }

    public static FadeModeEvaluator get(int i, boolean z) {
        if (i == 0) {
            return z ? f2413IN : OUT;
        }
        if (i == 1) {
            return z ? OUT : f2413IN;
        }
        if (i == 2) {
            return CROSS;
        }
        if (i == 3) {
            return THROUGH;
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Invalid fade mode: "));
    }
}
