package com.samsung.android.app.sdk.deepsky.textextraction.languagepack;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.glance.AbstractC2821a;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/OnDeviceLanguage;", "", "code", "", "langPackCode", "displayLangCode", "name", "isDownloadable", "", "packageName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getDisplayLangCode", "()Z", "getLangPackCode", "getName", "getPackageName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class OnDeviceLanguage {

    @NotNull
    private final String code;

    @NotNull
    private final String displayLangCode;
    private final boolean isDownloadable;

    @NotNull
    private final String langPackCode;

    @NotNull
    private final String name;

    @NotNull
    private final String packageName;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: EN */
    @NotNull
    private static final OnDeviceLanguage f4749EN = new OnDeviceLanguage("en", "", "en", null, false, null, 40, null);

    @NotNull
    private static final OnDeviceLanguage AUTO = new OnDeviceLanguage(LangPackConfigConstants.LANGUAGE_CODE_AUTO, "", DebugKt.DEBUG_PROPERTY_VALUE_AUTO, null, false, null, 40, null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/OnDeviceLanguage$Companion;", "", "()V", "AUTO", "Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/OnDeviceLanguage;", "getAUTO", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/OnDeviceLanguage;", "EN", "getEN", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OnDeviceLanguage getAUTO() {
            return OnDeviceLanguage.AUTO;
        }

        @NotNull
        public final OnDeviceLanguage getEN() {
            return OnDeviceLanguage.f4749EN;
        }

        private Companion() {
        }
    }

    public OnDeviceLanguage(@NotNull String code, @NotNull String langPackCode, @NotNull String displayLangCode, @NotNull String name, boolean z, @NotNull String packageName) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(langPackCode, "langPackCode");
        Intrinsics.checkNotNullParameter(displayLangCode, "displayLangCode");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.code = code;
        this.langPackCode = langPackCode;
        this.displayLangCode = displayLangCode;
        this.name = name;
        this.isDownloadable = z;
        this.packageName = packageName;
    }

    public static /* synthetic */ OnDeviceLanguage copy$default(OnDeviceLanguage onDeviceLanguage, String str, String str2, String str3, String str4, boolean z, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = onDeviceLanguage.code;
        }
        if ((i & 2) != 0) {
            str2 = onDeviceLanguage.langPackCode;
        }
        if ((i & 4) != 0) {
            str3 = onDeviceLanguage.displayLangCode;
        }
        if ((i & 8) != 0) {
            str4 = onDeviceLanguage.name;
        }
        if ((i & 16) != 0) {
            z = onDeviceLanguage.isDownloadable;
        }
        if ((i & 32) != 0) {
            str5 = onDeviceLanguage.packageName;
        }
        boolean z2 = z;
        String str6 = str5;
        return onDeviceLanguage.copy(str, str2, str3, str4, z2, str6);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
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

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsDownloadable() {
        return this.isDownloadable;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final OnDeviceLanguage copy(@NotNull String code, @NotNull String langPackCode, @NotNull String displayLangCode, @NotNull String name, boolean isDownloadable, @NotNull String packageName) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(langPackCode, "langPackCode");
        Intrinsics.checkNotNullParameter(displayLangCode, "displayLangCode");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return new OnDeviceLanguage(code, langPackCode, displayLangCode, name, isDownloadable, packageName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnDeviceLanguage)) {
            return false;
        }
        OnDeviceLanguage onDeviceLanguage = (OnDeviceLanguage) other;
        return Intrinsics.areEqual(this.code, onDeviceLanguage.code) && Intrinsics.areEqual(this.langPackCode, onDeviceLanguage.langPackCode) && Intrinsics.areEqual(this.displayLangCode, onDeviceLanguage.displayLangCode) && Intrinsics.areEqual(this.name, onDeviceLanguage.name) && this.isDownloadable == onDeviceLanguage.isDownloadable && Intrinsics.areEqual(this.packageName, onDeviceLanguage.packageName);
    }

    @NotNull
    public final String getCode() {
        return this.code;
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
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public int hashCode() {
        int iM1202c = AbstractC1038a.m1202c(AbstractC1038a.m1202c(AbstractC1038a.m1202c(this.code.hashCode() * 31, 31, this.langPackCode), 31, this.displayLangCode), 31, this.name);
        boolean z = this.isDownloadable;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        return this.packageName.hashCode() + ((iM1202c + r2) * 31);
    }

    public final boolean isDownloadable() {
        return this.isDownloadable;
    }

    @NotNull
    public String toString() {
        String str = this.code;
        String str2 = this.langPackCode;
        String str3 = this.displayLangCode;
        String str4 = this.name;
        boolean z = this.isDownloadable;
        String str5 = this.packageName;
        StringBuilder sbM16m = AbstractC0000a.m16m("OnDeviceLanguage(code=", str, ", langPackCode=", str2, ", displayLangCode=");
        AbstractC2821a.m2207B(sbM16m, str3, ", name=", str4, ", isDownloadable=");
        sbM16m.append(z);
        sbM16m.append(", packageName=");
        sbM16m.append(str5);
        sbM16m.append(")");
        return sbM16m.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ OnDeviceLanguage(String str, String str2, String str3, String str4, boolean z, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        str3 = (i & 4) != 0 ? str2 : str3;
        if ((i & 8) != 0) {
            str4 = str.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str4, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        }
        this(str, str2, str3, str4, (i & 16) != 0 ? str2.length() > 0 : z, (i & 32) != 0 ? "" : str5);
    }
}
