package com.samsung.android.app.sdk.deepsky.textextraction.languagepack;

import androidx.annotation.Keep;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.glance.AbstractC2821a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/ScsLanguageInfo;", "", "languageInfo", "Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/ScsLanguageInfo$LanguageInfo;", "(Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/ScsLanguageInfo$LanguageInfo;)V", "getLanguageInfo", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/ScsLanguageInfo$LanguageInfo;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "LanguageInfo", "SupportLanguage", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class ScsLanguageInfo {

    @SerializedName("translateSupportLanguageInfo")
    @NotNull
    private final LanguageInfo languageInfo;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Keep
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/ScsLanguageInfo$LanguageInfo;", "", "supportLanguages", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/ScsLanguageInfo$SupportLanguage;", "(Ljava/util/List;)V", "getSupportLanguages", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class LanguageInfo {

        @SerializedName("default")
        @NotNull
        private final List<SupportLanguage> supportLanguages;

        public LanguageInfo(@NotNull List<SupportLanguage> supportLanguages) {
            Intrinsics.checkNotNullParameter(supportLanguages, "supportLanguages");
            this.supportLanguages = supportLanguages;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LanguageInfo copy$default(LanguageInfo languageInfo, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = languageInfo.supportLanguages;
            }
            return languageInfo.copy(list);
        }

        @NotNull
        public final List<SupportLanguage> component1() {
            return this.supportLanguages;
        }

        @NotNull
        public final LanguageInfo copy(@NotNull List<SupportLanguage> supportLanguages) {
            Intrinsics.checkNotNullParameter(supportLanguages, "supportLanguages");
            return new LanguageInfo(supportLanguages);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LanguageInfo) && Intrinsics.areEqual(this.supportLanguages, ((LanguageInfo) other).supportLanguages);
        }

        @NotNull
        public final List<SupportLanguage> getSupportLanguages() {
            return this.supportLanguages;
        }

        public int hashCode() {
            return this.supportLanguages.hashCode();
        }

        @NotNull
        public String toString() {
            return "LanguageInfo(supportLanguages=" + this.supportLanguages + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Keep
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/ScsLanguageInfo$SupportLanguage;", "", "displayLangCode", "", "langPackCode", "onDeviceLangCode", "serverLangCode", "supportOnDevice", "", "packageName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getDisplayLangCode", "()Ljava/lang/String;", "getLangPackCode", "getOnDeviceLangCode", "getPackageName", "getServerLangCode", "getSupportOnDevice", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class SupportLanguage {

        @SerializedName("displayLangCode")
        @NotNull
        private final String displayLangCode;

        @SerializedName("langpackCode")
        @NotNull
        private final String langPackCode;

        @SerializedName("ondeviceLangCode")
        @NotNull
        private final String onDeviceLangCode;

        @SerializedName("packageName")
        @NotNull
        private final String packageName;

        @SerializedName("serverLangCode")
        @NotNull
        private final String serverLangCode;

        @SerializedName("supportOndevice")
        private final boolean supportOnDevice;

        public SupportLanguage(@NotNull String displayLangCode, @NotNull String langPackCode, @NotNull String onDeviceLangCode, @NotNull String serverLangCode, boolean z, @NotNull String packageName) {
            Intrinsics.checkNotNullParameter(displayLangCode, "displayLangCode");
            Intrinsics.checkNotNullParameter(langPackCode, "langPackCode");
            Intrinsics.checkNotNullParameter(onDeviceLangCode, "onDeviceLangCode");
            Intrinsics.checkNotNullParameter(serverLangCode, "serverLangCode");
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            this.displayLangCode = displayLangCode;
            this.langPackCode = langPackCode;
            this.onDeviceLangCode = onDeviceLangCode;
            this.serverLangCode = serverLangCode;
            this.supportOnDevice = z;
            this.packageName = packageName;
        }

        public static /* synthetic */ SupportLanguage copy$default(SupportLanguage supportLanguage, String str, String str2, String str3, String str4, boolean z, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = supportLanguage.displayLangCode;
            }
            if ((i & 2) != 0) {
                str2 = supportLanguage.langPackCode;
            }
            if ((i & 4) != 0) {
                str3 = supportLanguage.onDeviceLangCode;
            }
            if ((i & 8) != 0) {
                str4 = supportLanguage.serverLangCode;
            }
            if ((i & 16) != 0) {
                z = supportLanguage.supportOnDevice;
            }
            if ((i & 32) != 0) {
                str5 = supportLanguage.packageName;
            }
            boolean z2 = z;
            String str6 = str5;
            return supportLanguage.copy(str, str2, str3, str4, z2, str6);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDisplayLangCode() {
            return this.displayLangCode;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLangPackCode() {
            return this.langPackCode;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getOnDeviceLangCode() {
            return this.onDeviceLangCode;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getServerLangCode() {
            return this.serverLangCode;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getSupportOnDevice() {
            return this.supportOnDevice;
        }

        @NotNull
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getPackageName() {
            return this.packageName;
        }

        @NotNull
        public final SupportLanguage copy(@NotNull String displayLangCode, @NotNull String langPackCode, @NotNull String onDeviceLangCode, @NotNull String serverLangCode, boolean supportOnDevice, @NotNull String packageName) {
            Intrinsics.checkNotNullParameter(displayLangCode, "displayLangCode");
            Intrinsics.checkNotNullParameter(langPackCode, "langPackCode");
            Intrinsics.checkNotNullParameter(onDeviceLangCode, "onDeviceLangCode");
            Intrinsics.checkNotNullParameter(serverLangCode, "serverLangCode");
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            return new SupportLanguage(displayLangCode, langPackCode, onDeviceLangCode, serverLangCode, supportOnDevice, packageName);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SupportLanguage)) {
                return false;
            }
            SupportLanguage supportLanguage = (SupportLanguage) other;
            return Intrinsics.areEqual(this.displayLangCode, supportLanguage.displayLangCode) && Intrinsics.areEqual(this.langPackCode, supportLanguage.langPackCode) && Intrinsics.areEqual(this.onDeviceLangCode, supportLanguage.onDeviceLangCode) && Intrinsics.areEqual(this.serverLangCode, supportLanguage.serverLangCode) && this.supportOnDevice == supportLanguage.supportOnDevice && Intrinsics.areEqual(this.packageName, supportLanguage.packageName);
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

        @NotNull
        public final String getServerLangCode() {
            return this.serverLangCode;
        }

        public final boolean getSupportOnDevice() {
            return this.supportOnDevice;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6 */
        public int hashCode() {
            int iM1202c = AbstractC1038a.m1202c(AbstractC1038a.m1202c(AbstractC1038a.m1202c(this.displayLangCode.hashCode() * 31, 31, this.langPackCode), 31, this.onDeviceLangCode), 31, this.serverLangCode);
            boolean z = this.supportOnDevice;
            ?? r2 = z;
            if (z) {
                r2 = 1;
            }
            return this.packageName.hashCode() + ((iM1202c + r2) * 31);
        }

        @NotNull
        public String toString() {
            String str = this.displayLangCode;
            String str2 = this.langPackCode;
            String str3 = this.onDeviceLangCode;
            String str4 = this.serverLangCode;
            boolean z = this.supportOnDevice;
            String str5 = this.packageName;
            StringBuilder sbM16m = AbstractC0000a.m16m("SupportLanguage(displayLangCode=", str, ", langPackCode=", str2, ", onDeviceLangCode=");
            AbstractC2821a.m2207B(sbM16m, str3, ", serverLangCode=", str4, ", supportOnDevice=");
            sbM16m.append(z);
            sbM16m.append(", packageName=");
            sbM16m.append(str5);
            sbM16m.append(")");
            return sbM16m.toString();
        }
    }

    public ScsLanguageInfo(@NotNull LanguageInfo languageInfo) {
        Intrinsics.checkNotNullParameter(languageInfo, "languageInfo");
        this.languageInfo = languageInfo;
    }

    public static /* synthetic */ ScsLanguageInfo copy$default(ScsLanguageInfo scsLanguageInfo, LanguageInfo languageInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            languageInfo = scsLanguageInfo.languageInfo;
        }
        return scsLanguageInfo.copy(languageInfo);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LanguageInfo getLanguageInfo() {
        return this.languageInfo;
    }

    @NotNull
    public final ScsLanguageInfo copy(@NotNull LanguageInfo languageInfo) {
        Intrinsics.checkNotNullParameter(languageInfo, "languageInfo");
        return new ScsLanguageInfo(languageInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ScsLanguageInfo) && Intrinsics.areEqual(this.languageInfo, ((ScsLanguageInfo) other).languageInfo);
    }

    @NotNull
    public final LanguageInfo getLanguageInfo() {
        return this.languageInfo;
    }

    public int hashCode() {
        return this.languageInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "ScsLanguageInfo(languageInfo=" + this.languageInfo + ")";
    }
}
