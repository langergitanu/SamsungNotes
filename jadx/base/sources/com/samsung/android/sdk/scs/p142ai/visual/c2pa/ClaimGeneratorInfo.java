package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import androidx.appcompat.widget.AbstractC0541b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/visual/c2pa/ClaimGeneratorInfo;", "", "name", "", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getVersion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class ClaimGeneratorInfo {

    @Nullable
    private final String name;

    @Nullable
    private final String version;

    public ClaimGeneratorInfo(@Nullable String str, @Nullable String str2) {
        this.name = str;
        this.version = str2;
    }

    public static /* synthetic */ ClaimGeneratorInfo copy$default(ClaimGeneratorInfo claimGeneratorInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = claimGeneratorInfo.name;
        }
        if ((i & 2) != 0) {
            str2 = claimGeneratorInfo.version;
        }
        return claimGeneratorInfo.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    @NotNull
    public final ClaimGeneratorInfo copy(@Nullable String name, @Nullable String version) {
        return new ClaimGeneratorInfo(name, version);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClaimGeneratorInfo)) {
            return false;
        }
        ClaimGeneratorInfo claimGeneratorInfo = (ClaimGeneratorInfo) other;
        return Intrinsics.areEqual(this.name, claimGeneratorInfo.name) && Intrinsics.areEqual(this.version, claimGeneratorInfo.version);
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.version;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return AbstractC0541b.m775q("ClaimGeneratorInfo(name=", this.name, ", version=", this.version, ")");
    }
}
