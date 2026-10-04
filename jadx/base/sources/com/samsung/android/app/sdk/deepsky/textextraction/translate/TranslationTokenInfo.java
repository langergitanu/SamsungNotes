package com.samsung.android.app.sdk.deepsky.textextraction.translate;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.glance.AbstractC2821a;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated(message = "TranslationTokenInfo is no longer needed in image translation")
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TranslationTokenInfo;", "", "apiKey", "", "signingKey", "appId", "accessToken", "serverUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "getApiKey", "getAppId", "getServerUrl", "getSigningKey", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class TranslationTokenInfo {

    @NotNull
    private final String accessToken;

    @NotNull
    private final String apiKey;

    @NotNull
    private final String appId;

    @NotNull
    private final String serverUrl;

    @NotNull
    private final String signingKey;

    public TranslationTokenInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ TranslationTokenInfo copy$default(TranslationTokenInfo translationTokenInfo, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = translationTokenInfo.apiKey;
        }
        if ((i & 2) != 0) {
            str2 = translationTokenInfo.signingKey;
        }
        if ((i & 4) != 0) {
            str3 = translationTokenInfo.appId;
        }
        if ((i & 8) != 0) {
            str4 = translationTokenInfo.accessToken;
        }
        if ((i & 16) != 0) {
            str5 = translationTokenInfo.serverUrl;
        }
        String str6 = str5;
        String str7 = str3;
        return translationTokenInfo.copy(str, str2, str7, str4, str6);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getApiKey() {
        return this.apiKey;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSigningKey() {
        return this.signingKey;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getServerUrl() {
        return this.serverUrl;
    }

    @NotNull
    public final TranslationTokenInfo copy(@NotNull String apiKey, @NotNull String signingKey, @NotNull String appId, @NotNull String accessToken, @NotNull String serverUrl) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(signingKey, "signingKey");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(serverUrl, "serverUrl");
        return new TranslationTokenInfo(apiKey, signingKey, appId, accessToken, serverUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TranslationTokenInfo)) {
            return false;
        }
        TranslationTokenInfo translationTokenInfo = (TranslationTokenInfo) other;
        return Intrinsics.areEqual(this.apiKey, translationTokenInfo.apiKey) && Intrinsics.areEqual(this.signingKey, translationTokenInfo.signingKey) && Intrinsics.areEqual(this.appId, translationTokenInfo.appId) && Intrinsics.areEqual(this.accessToken, translationTokenInfo.accessToken) && Intrinsics.areEqual(this.serverUrl, translationTokenInfo.serverUrl);
    }

    @NotNull
    public final String getAccessToken() {
        return this.accessToken;
    }

    @NotNull
    public final String getApiKey() {
        return this.apiKey;
    }

    @NotNull
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    public final String getServerUrl() {
        return this.serverUrl;
    }

    @NotNull
    public final String getSigningKey() {
        return this.signingKey;
    }

    public int hashCode() {
        return this.serverUrl.hashCode() + AbstractC1038a.m1202c(AbstractC1038a.m1202c(AbstractC1038a.m1202c(this.apiKey.hashCode() * 31, 31, this.signingKey), 31, this.appId), 31, this.accessToken);
    }

    @NotNull
    public String toString() {
        String str = this.apiKey;
        String str2 = this.signingKey;
        String str3 = this.appId;
        String str4 = this.accessToken;
        String str5 = this.serverUrl;
        StringBuilder sbM16m = AbstractC0000a.m16m("TranslationTokenInfo(apiKey=", str, ", signingKey=", str2, ", appId=");
        AbstractC2821a.m2207B(sbM16m, str3, ", accessToken=", str4, ", serverUrl=");
        return AbstractC0622a.m1170p(str5, ")", sbM16m);
    }

    public TranslationTokenInfo(@NotNull String apiKey, @NotNull String signingKey, @NotNull String appId, @NotNull String accessToken, @NotNull String serverUrl) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(signingKey, "signingKey");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(serverUrl, "serverUrl");
        this.apiKey = apiKey;
        this.signingKey = signingKey;
        this.appId = appId;
        this.accessToken = accessToken;
        this.serverUrl = serverUrl;
    }

    public /* synthetic */ TranslationTokenInfo(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5);
    }
}
