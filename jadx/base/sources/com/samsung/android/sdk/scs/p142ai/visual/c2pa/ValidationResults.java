package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/visual/c2pa/ValidationResults;", "", "activeManifest", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/ValidationResultMap;", "<init>", "(Lcom/samsung/android/sdk/scs/ai/visual/c2pa/ValidationResultMap;)V", "getActiveManifest", "()Lcom/samsung/android/sdk/scs/ai/visual/c2pa/ValidationResultMap;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class ValidationResults {

    @SerializedName("activeManifest")
    @Nullable
    private final ValidationResultMap activeManifest;

    public ValidationResults(@Nullable ValidationResultMap validationResultMap) {
        this.activeManifest = validationResultMap;
    }

    public static /* synthetic */ ValidationResults copy$default(ValidationResults validationResults, ValidationResultMap validationResultMap, int i, Object obj) {
        if ((i & 1) != 0) {
            validationResultMap = validationResults.activeManifest;
        }
        return validationResults.copy(validationResultMap);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ValidationResultMap getActiveManifest() {
        return this.activeManifest;
    }

    @NotNull
    public final ValidationResults copy(@Nullable ValidationResultMap activeManifest) {
        return new ValidationResults(activeManifest);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ValidationResults) && Intrinsics.areEqual(this.activeManifest, ((ValidationResults) other).activeManifest);
    }

    @Nullable
    public final ValidationResultMap getActiveManifest() {
        return this.activeManifest;
    }

    public int hashCode() {
        ValidationResultMap validationResultMap = this.activeManifest;
        if (validationResultMap == null) {
            return 0;
        }
        return validationResultMap.hashCode();
    }

    @NotNull
    public String toString() {
        return "ValidationResults(activeManifest=" + this.activeManifest + ")";
    }
}
