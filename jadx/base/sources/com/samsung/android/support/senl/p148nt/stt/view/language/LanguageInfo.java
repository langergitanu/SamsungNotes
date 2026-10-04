package com.samsung.android.support.senl.p148nt.stt.view.language;

import android.content.Intent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\bBO\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0005\u0010\u0011J\b\u0010)\u001a\u00020\u0003H\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/language/LanguageInfo;", "", "locale", "", "languageName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "languageDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ondeviceDict", "", "speakerLabel", "status", "storeUrl", "langPackage", "storeIntent", "Landroid/content/Intent;", "(Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V", "getLocale", "()Ljava/lang/String;", "setLocale", "(Ljava/lang/String;)V", "getLanguageName", "setLanguageName", "isOndeviceDict", "()Z", "setOndeviceDict", "(Z)V", "isSpeakerLabel", "setSpeakerLabel", "getLanguageDescription", "setLanguageDescription", "isLangpackAvailable", "getStoreUrl", "setStoreUrl", "getLangPackage", "setLangPackage", "getStoreIntent", "()Landroid/content/Intent;", "setStoreIntent", "(Landroid/content/Intent;)V", "toString", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LanguageInfo {
    private boolean isLangpackAvailable;

    @SerializedName("ondeviceDict")
    private boolean isOndeviceDict;

    @SerializedName("speakerLabel")
    private boolean isSpeakerLabel;

    @SerializedName("ondevicePkgName")
    @Nullable
    private String langPackage;

    @Nullable
    private String languageDescription;

    @SerializedName("languageDisplayName")
    @NotNull
    private String languageName;

    @SerializedName("languageCode")
    @NotNull
    private String locale;

    @Nullable
    private Intent storeIntent;

    @Nullable
    private String storeUrl;

    public LanguageInfo(@NotNull String locale, @NotNull String languageName) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(languageName, "languageName");
        this.languageName = languageName;
        this.locale = locale;
    }

    @Nullable
    public final String getLangPackage() {
        return this.langPackage;
    }

    @Nullable
    public final String getLanguageDescription() {
        return this.languageDescription;
    }

    @NotNull
    public final String getLanguageName() {
        return this.languageName;
    }

    @NotNull
    public final String getLocale() {
        return this.locale;
    }

    @Nullable
    public final Intent getStoreIntent() {
        return this.storeIntent;
    }

    @Nullable
    public final String getStoreUrl() {
        return this.storeUrl;
    }

    /* JADX INFO: renamed from: isOndeviceDict, reason: from getter */
    public final boolean getIsOndeviceDict() {
        return this.isOndeviceDict;
    }

    /* JADX INFO: renamed from: isSpeakerLabel, reason: from getter */
    public final boolean getIsSpeakerLabel() {
        return this.isSpeakerLabel;
    }

    public final void setLangPackage(@Nullable String str) {
        this.langPackage = str;
    }

    public final void setLanguageDescription(@Nullable String str) {
        this.languageDescription = str;
    }

    public final void setLanguageName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.languageName = str;
    }

    public final void setLocale(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.locale = str;
    }

    public final void setOndeviceDict(boolean z) {
        this.isOndeviceDict = z;
    }

    public final void setSpeakerLabel(boolean z) {
        this.isSpeakerLabel = z;
    }

    public final void setStoreIntent(@Nullable Intent intent) {
        this.storeIntent = intent;
    }

    public final void setStoreUrl(@Nullable String str) {
        this.storeUrl = str;
    }

    @NotNull
    public String toString() {
        return this.locale + ";" + this.languageName + ";" + this.isOndeviceDict + ";" + this.isSpeakerLabel + ";" + this.isLangpackAvailable + ";" + this.langPackage + ";" + this.storeIntent;
    }

    public LanguageInfo(@NotNull String locale, @NotNull String languageName, @Nullable String str) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(languageName, "languageName");
        this.languageName = languageName;
        this.locale = locale;
        this.languageDescription = str;
        this.isOndeviceDict = false;
        this.isSpeakerLabel = false;
        this.isLangpackAvailable = false;
        this.storeUrl = null;
        this.langPackage = null;
        this.storeIntent = null;
    }

    public LanguageInfo(@NotNull String languageName, @NotNull String locale, boolean z, boolean z2, boolean z3, @Nullable String str, @Nullable String str2, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(languageName, "languageName");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.languageName = languageName;
        this.locale = locale;
        this.isOndeviceDict = z;
        this.isSpeakerLabel = z2;
        this.isLangpackAvailable = z3;
        this.storeUrl = str;
        this.langPackage = str2;
        this.storeIntent = intent;
    }
}
