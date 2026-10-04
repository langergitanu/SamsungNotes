package com.samsung.android.vexfwk.imagetranslation;

import androidx.appcompat.widget.AbstractC0541b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/imagetranslation/VexFwkLanguagePackInfo;", "", "languagePackCode", "", "(Ljava/lang/String;)V", "getLanguagePackCode", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class VexFwkLanguagePackInfo {

    @NotNull
    private final String languagePackCode;

    public VexFwkLanguagePackInfo(@NotNull String languagePackCode) {
        Intrinsics.checkNotNullParameter(languagePackCode, "languagePackCode");
        this.languagePackCode = languagePackCode;
    }

    public static /* synthetic */ VexFwkLanguagePackInfo copy$default(VexFwkLanguagePackInfo vexFwkLanguagePackInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vexFwkLanguagePackInfo.languagePackCode;
        }
        return vexFwkLanguagePackInfo.copy(str);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLanguagePackCode() {
        return this.languagePackCode;
    }

    @NotNull
    public final VexFwkLanguagePackInfo copy(@NotNull String languagePackCode) {
        Intrinsics.checkNotNullParameter(languagePackCode, "languagePackCode");
        return new VexFwkLanguagePackInfo(languagePackCode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof VexFwkLanguagePackInfo) && Intrinsics.areEqual(this.languagePackCode, ((VexFwkLanguagePackInfo) other).languagePackCode);
    }

    @NotNull
    public final String getLanguagePackCode() {
        return this.languagePackCode;
    }

    public int hashCode() {
        return this.languagePackCode.hashCode();
    }

    @NotNull
    public String toString() {
        return AbstractC0541b.m773o("VexFwkLanguagePackInfo(languagePackCode=", this.languagePackCode, ")");
    }
}
