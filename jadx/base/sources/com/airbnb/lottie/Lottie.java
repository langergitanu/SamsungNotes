package com.airbnb.lottie;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class Lottie {
    private Lottie() {
    }

    public static void initialize(@NonNull LottieConfig lottieConfig) {
        C4306L.setFetcher(lottieConfig.networkFetcher);
        C4306L.setCacheProvider(lottieConfig.cacheProvider);
        C4306L.setTraceEnabled(lottieConfig.enableSystraceMarkers);
        C4306L.setNetworkCacheEnabled(lottieConfig.enableNetworkCache);
        C4306L.setDisablePathInterpolatorCache(lottieConfig.disablePathInterpolatorCache);
        C4306L.setDefaultAsyncUpdates(lottieConfig.defaultAsyncUpdates);
        C4306L.setReducedMotionOption(lottieConfig.reducedMotionOption);
    }
}
