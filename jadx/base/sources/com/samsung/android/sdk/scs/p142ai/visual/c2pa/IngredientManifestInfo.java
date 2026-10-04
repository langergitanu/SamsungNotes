package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/visual/c2pa/IngredientManifestInfo;", "", "manifestKey", "", "isParent", "", "<init>", "(Ljava/lang/String;Z)V", "getManifestKey", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class IngredientManifestInfo {
    private final boolean isParent;

    @NotNull
    private final String manifestKey;

    public IngredientManifestInfo(@NotNull String manifestKey, boolean z) {
        Intrinsics.checkNotNullParameter(manifestKey, "manifestKey");
        this.manifestKey = manifestKey;
        this.isParent = z;
    }

    public static /* synthetic */ IngredientManifestInfo copy$default(IngredientManifestInfo ingredientManifestInfo, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ingredientManifestInfo.manifestKey;
        }
        if ((i & 2) != 0) {
            z = ingredientManifestInfo.isParent;
        }
        return ingredientManifestInfo.copy(str, z);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getManifestKey() {
        return this.manifestKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsParent() {
        return this.isParent;
    }

    @NotNull
    public final IngredientManifestInfo copy(@NotNull String manifestKey, boolean isParent) {
        Intrinsics.checkNotNullParameter(manifestKey, "manifestKey");
        return new IngredientManifestInfo(manifestKey, isParent);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IngredientManifestInfo)) {
            return false;
        }
        IngredientManifestInfo ingredientManifestInfo = (IngredientManifestInfo) other;
        return Intrinsics.areEqual(this.manifestKey, ingredientManifestInfo.manifestKey) && this.isParent == ingredientManifestInfo.isParent;
    }

    @NotNull
    public final String getManifestKey() {
        return this.manifestKey;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isParent) + (this.manifestKey.hashCode() * 31);
    }

    public final boolean isParent() {
        return this.isParent;
    }

    @NotNull
    public String toString() {
        return "IngredientManifestInfo(manifestKey=" + this.manifestKey + ", isParent=" + this.isParent + ")";
    }
}
