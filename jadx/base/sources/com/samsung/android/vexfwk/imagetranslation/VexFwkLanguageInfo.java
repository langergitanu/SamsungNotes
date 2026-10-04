package com.samsung.android.vexfwk.imagetranslation;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/vexfwk/imagetranslation/VexFwkLanguageInfo;", "", "onDeviceLangCode", "", "langPackCode", "displayLangCode", "supportOnDevice", "", "packageName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getDisplayLangCode", "()Ljava/lang/String;", "getLangPackCode", "getOnDeviceLangCode", "getPackageName", "getSupportOnDevice", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class VexFwkLanguageInfo {

    @NotNull
    private final String displayLangCode;

    @NotNull
    private final String langPackCode;

    @NotNull
    private final String onDeviceLangCode;

    @NotNull
    private final String packageName;
    private final boolean supportOnDevice;

    public VexFwkLanguageInfo(@NotNull String onDeviceLangCode, @NotNull String langPackCode, @NotNull String displayLangCode, boolean z, @NotNull String packageName) {
        Intrinsics.checkNotNullParameter(onDeviceLangCode, "onDeviceLangCode");
        Intrinsics.checkNotNullParameter(langPackCode, "langPackCode");
        Intrinsics.checkNotNullParameter(displayLangCode, "displayLangCode");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.onDeviceLangCode = onDeviceLangCode;
        this.langPackCode = langPackCode;
        this.displayLangCode = displayLangCode;
        this.supportOnDevice = z;
        this.packageName = packageName;
    }

    public static /* synthetic */ VexFwkLanguageInfo copy$default(VexFwkLanguageInfo vexFwkLanguageInfo, String str, String str2, String str3, boolean z, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vexFwkLanguageInfo.onDeviceLangCode;
        }
        if ((i & 2) != 0) {
            str2 = vexFwkLanguageInfo.langPackCode;
        }
        if ((i & 4) != 0) {
            str3 = vexFwkLanguageInfo.displayLangCode;
        }
        if ((i & 8) != 0) {
            z = vexFwkLanguageInfo.supportOnDevice;
        }
        if ((i & 16) != 0) {
            str4 = vexFwkLanguageInfo.packageName;
        }
        String str5 = str4;
        String str6 = str3;
        return vexFwkLanguageInfo.copy(str, str2, str6, z, str5);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOnDeviceLangCode() {
        return this.onDeviceLangCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLangPackCode() {
        return this.langPackCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDisplayLangCode() {
        return this.displayLangCode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getSupportOnDevice() {
        return this.supportOnDevice;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final VexFwkLanguageInfo copy(@NotNull String onDeviceLangCode, @NotNull String langPackCode, @NotNull String displayLangCode, boolean supportOnDevice, @NotNull String packageName) {
        Intrinsics.checkNotNullParameter(onDeviceLangCode, "onDeviceLangCode");
        Intrinsics.checkNotNullParameter(langPackCode, "langPackCode");
        Intrinsics.checkNotNullParameter(displayLangCode, "displayLangCode");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return new VexFwkLanguageInfo(onDeviceLangCode, langPackCode, displayLangCode, supportOnDevice, packageName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VexFwkLanguageInfo)) {
            return false;
        }
        VexFwkLanguageInfo vexFwkLanguageInfo = (VexFwkLanguageInfo) other;
        return Intrinsics.areEqual(this.onDeviceLangCode, vexFwkLanguageInfo.onDeviceLangCode) && Intrinsics.areEqual(this.langPackCode, vexFwkLanguageInfo.langPackCode) && Intrinsics.areEqual(this.displayLangCode, vexFwkLanguageInfo.displayLangCode) && this.supportOnDevice == vexFwkLanguageInfo.supportOnDevice && Intrinsics.areEqual(this.packageName, vexFwkLanguageInfo.packageName);
    }

    @NotNull
    public final String getDisplayLangCode() {
        return this.displayLangCode;
    }

    @NotNull
    public final String getLangPackCode() {
        return this.langPackCode;
    }

    @NotNull
    public final String getOnDeviceLangCode() {
        return this.onDeviceLangCode;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public final boolean getSupportOnDevice() {
        return this.supportOnDevice;
    }

    public int hashCode() {
        return this.packageName.hashCode() + AbstractC0622a.m1160f(this.supportOnDevice, AbstractC1038a.m1202c(AbstractC1038a.m1202c(this.onDeviceLangCode.hashCode() * 31, 31, this.langPackCode), 31, this.displayLangCode), 31);
    }

    @NotNull
    public String toString() {
        String str = this.onDeviceLangCode;
        String str2 = this.langPackCode;
        String str3 = this.displayLangCode;
        boolean z = this.supportOnDevice;
        String str4 = this.packageName;
        StringBuilder sbM16m = AbstractC0000a.m16m("VexFwkLanguageInfo(onDeviceLangCode=", str, ", langPackCode=", str2, ", displayLangCode=");
        sbM16m.append(str3);
        sbM16m.append(", supportOnDevice=");
        sbM16m.append(z);
        sbM16m.append(", packageName=");
        return AbstractC0622a.m1170p(str4, ")", sbM16m);
    }
}
