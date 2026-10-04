package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import androidx.collection.AbstractC0622a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/visual/c2pa/ValidationStatus;", "", "code", "", "url", "explanation", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getUrl", "getExplanation", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class ValidationStatus {

    @Nullable
    private final String code;

    @Nullable
    private final String explanation;

    @Nullable
    private final String url;

    public ValidationStatus(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.code = str;
        this.url = str2;
        this.explanation = str3;
    }

    public static /* synthetic */ ValidationStatus copy$default(ValidationStatus validationStatus, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = validationStatus.code;
        }
        if ((i & 2) != 0) {
            str2 = validationStatus.url;
        }
        if ((i & 4) != 0) {
            str3 = validationStatus.explanation;
        }
        return validationStatus.copy(str, str2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getExplanation() {
        return this.explanation;
    }

    @NotNull
    public final ValidationStatus copy(@Nullable String code, @Nullable String url, @Nullable String explanation) {
        return new ValidationStatus(code, url, explanation);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ValidationStatus)) {
            return false;
        }
        ValidationStatus validationStatus = (ValidationStatus) other;
        return Intrinsics.areEqual(this.code, validationStatus.code) && Intrinsics.areEqual(this.url, validationStatus.url) && Intrinsics.areEqual(this.explanation, validationStatus.explanation);
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final String getExplanation() {
        return this.explanation;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.code;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.url;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.explanation;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return AbstractC0622a.m1170p(this.explanation, ")", AbstractC0000a.m16m("ValidationStatus(code=", this.code, ", url=", this.url, ", explanation="));
    }
}
