package com.microsoft.identity.common.java.nativeauth.providers.requests;

import androidx.exifinterface.media.ExifInterface;
import com.microsoft.identity.common.java.nativeauth.util.ILoggable;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest;", "Lcom/microsoft/identity/common/java/nativeauth/util/ILoggable;", "()V", Contract.HEADERS, "", "", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", "getParameters", "()Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", "requestUrl", "Ljava/net/URL;", "getRequestUrl", "()Ljava/net/URL;", "setRequestUrl", "(Ljava/net/URL;)V", "Companion", "NativeAuthRequestParameters", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public abstract class NativeAuthRequest implements ILoggable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0006*\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007¨\u0006\t"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$Companion;", "", "()V", "toJsonString", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "map", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final <K, V> String toJsonString(@NotNull Map<K, ? extends V> map, @NotNull Map<String, String> map2) {
            Intrinsics.checkNotNullParameter(map, "<this>");
            Intrinsics.checkNotNullParameter(map2, "map");
            String string = new JSONObject(map2).toString();
            Intrinsics.checkNotNullExpressionValue(string, "JSONObject(map).toString()");
            return string;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", "Lcom/microsoft/identity/common/java/nativeauth/util/ILoggable;", "()V", SyncDBSchema.SyncInfo.CLIENT_ID, "", "getClientId", "()Ljava/lang/String;", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static abstract class NativeAuthRequestParameters implements ILoggable {
        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return ILoggable.DefaultImpls.containsPii(this);
        }

        @NotNull
        public abstract String getClientId();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return ILoggable.DefaultImpls.containsPii(this);
    }

    @NotNull
    public abstract Map<String, String> getHeaders();

    @NotNull
    public abstract NativeAuthRequestParameters getParameters();

    @NotNull
    public abstract URL getRequestUrl();

    public abstract void setHeaders(@NotNull Map<String, String> map);

    public abstract void setRequestUrl(@NotNull URL url);
}
