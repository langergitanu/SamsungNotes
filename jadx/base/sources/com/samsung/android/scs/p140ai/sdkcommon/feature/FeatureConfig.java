package com.samsung.android.scs.p140ai.sdkcommon.feature;

import androidx.annotation.Keep;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/scs/ai/sdkcommon/feature/FeatureConfig;", "", "appVersion", "", "features", "", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getAppVersion", "()Ljava/lang/String;", "getFeatures", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class FeatureConfig {

    @NotNull
    public static final String JSON_KEY_APP_VERSION = "app_version";

    @NotNull
    public static final String JSON_KEY_FEATURES = "features";

    @NotNull
    private final String appVersion;

    @NotNull
    private final Map<String, Integer> features;

    public FeatureConfig(@NotNull String appVersion, @NotNull Map<String, Integer> features) {
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(features, "features");
        this.appVersion = appVersion;
        this.features = features;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeatureConfig copy$default(FeatureConfig featureConfig, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = featureConfig.appVersion;
        }
        if ((i & 2) != 0) {
            map = featureConfig.features;
        }
        return featureConfig.copy(str, map);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    @NotNull
    public final Map<String, Integer> component2() {
        return this.features;
    }

    @NotNull
    public final FeatureConfig copy(@NotNull String appVersion, @NotNull Map<String, Integer> features) {
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(features, "features");
        return new FeatureConfig(appVersion, features);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeatureConfig)) {
            return false;
        }
        FeatureConfig featureConfig = (FeatureConfig) other;
        return Intrinsics.areEqual(this.appVersion, featureConfig.appVersion) && Intrinsics.areEqual(this.features, featureConfig.features);
    }

    @NotNull
    public final String getAppVersion() {
        return this.appVersion;
    }

    @NotNull
    public final Map<String, Integer> getFeatures() {
        return this.features;
    }

    public int hashCode() {
        return this.features.hashCode() + (this.appVersion.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "FeatureConfig(appVersion=" + this.appVersion + ", features=" + this.features + ")";
    }
}
