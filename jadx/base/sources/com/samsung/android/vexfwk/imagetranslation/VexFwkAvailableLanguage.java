package com.samsung.android.vexfwk.imagetranslation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/vexfwk/imagetranslation/VexFwkAvailableLanguage;", "", "lang", "", "downloadRequired", "", "(Ljava/lang/String;Z)V", "getDownloadRequired", "()Z", "getLang", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class VexFwkAvailableLanguage {
    private final boolean downloadRequired;

    @NotNull
    private final String lang;

    public VexFwkAvailableLanguage(@NotNull String lang, boolean z) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        this.lang = lang;
        this.downloadRequired = z;
    }

    public static /* synthetic */ VexFwkAvailableLanguage copy$default(VexFwkAvailableLanguage vexFwkAvailableLanguage, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vexFwkAvailableLanguage.lang;
        }
        if ((i & 2) != 0) {
            z = vexFwkAvailableLanguage.downloadRequired;
        }
        return vexFwkAvailableLanguage.copy(str, z);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getDownloadRequired() {
        return this.downloadRequired;
    }

    @NotNull
    public final VexFwkAvailableLanguage copy(@NotNull String lang, boolean downloadRequired) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        return new VexFwkAvailableLanguage(lang, downloadRequired);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VexFwkAvailableLanguage)) {
            return false;
        }
        VexFwkAvailableLanguage vexFwkAvailableLanguage = (VexFwkAvailableLanguage) other;
        return Intrinsics.areEqual(this.lang, vexFwkAvailableLanguage.lang) && this.downloadRequired == vexFwkAvailableLanguage.downloadRequired;
    }

    public final boolean getDownloadRequired() {
        return this.downloadRequired;
    }

    @NotNull
    public final String getLang() {
        return this.lang;
    }

    public int hashCode() {
        return Boolean.hashCode(this.downloadRequired) + (this.lang.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "VexFwkAvailableLanguage(lang=" + this.lang + ", downloadRequired=" + this.downloadRequired + ")";
    }
}
