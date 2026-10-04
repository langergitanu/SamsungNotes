package com.samsung.android.app.sdk.deepsky.contract.search;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/search/Promise;", "", "raw", "", "id", Contract.NOTIFY_URL, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getNotifyUri", "getRaw", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Builder", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class Promise {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String id;

    @NotNull
    private final String notifyUri;

    @NotNull
    private final String raw;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/search/Promise$Builder;", "", "()V", Contract.NOTIFY_URL, "", Contract.PROMISE_ID, "setNotifyUri", "setPromiseId", "", "toJson", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Builder {

        @Nullable
        private String notifyUri;

        @Nullable
        private String promiseId;

        @NotNull
        public final Builder setNotifyUri(@NotNull String notifyUri) {
            Intrinsics.checkNotNullParameter(notifyUri, "notifyUri");
            this.notifyUri = notifyUri;
            return this;
        }

        @NotNull
        public final Builder setPromiseId(int promiseId) {
            this.promiseId = String.valueOf(promiseId);
            return this;
        }

        @NotNull
        public final String toJson() {
            String string = new JSONObject(MapsKt.mapOf(TuplesKt.m13893to(Contract.PROMISE_ID, this.promiseId), TuplesKt.m13893to(Contract.NOTIFY_URL, this.notifyUri))).toString();
            Intrinsics.checkNotNullExpressionValue(string, "JSONObject(\n            …\n            ).toString()");
            return string;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/search/Promise$Companion;", "", "()V", "parse", "Lcom/samsung/android/app/sdk/deepsky/contract/search/Promise;", Contract.PROMISE, "", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nsearch.kt\nKotlin\n*S Kotlin\n*F\n+ 1 search.kt\ncom/samsung/android/app/sdk/deepsky/contract/search/Promise$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,355:1\n1#2:356\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Promise parse(@NotNull String promise) throws JSONException {
            Intrinsics.checkNotNullParameter(promise, "promise");
            JSONObject jSONObject = new JSONObject(promise);
            String string = jSONObject.getString(Contract.PROMISE_ID);
            String string2 = jSONObject.getString(Contract.NOTIFY_URL);
            if (string == null) {
                throw new IllegalArgumentException("promiseId is null");
            }
            if (string2 != null) {
                return new Promise(promise, string, string2);
            }
            throw new IllegalArgumentException("promiseUri is null");
        }

        private Companion() {
        }
    }

    public Promise(@NotNull String raw, @NotNull String id, @NotNull String notifyUri) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(notifyUri, "notifyUri");
        this.raw = raw;
        this.id = id;
        this.notifyUri = notifyUri;
    }

    public static /* synthetic */ Promise copy$default(Promise promise, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = promise.raw;
        }
        if ((i & 2) != 0) {
            str2 = promise.id;
        }
        if ((i & 4) != 0) {
            str3 = promise.notifyUri;
        }
        return promise.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRaw() {
        return this.raw;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNotifyUri() {
        return this.notifyUri;
    }

    @NotNull
    public final Promise copy(@NotNull String raw, @NotNull String id, @NotNull String notifyUri) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(notifyUri, "notifyUri");
        return new Promise(raw, id, notifyUri);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Promise)) {
            return false;
        }
        Promise promise = (Promise) other;
        return Intrinsics.areEqual(this.raw, promise.raw) && Intrinsics.areEqual(this.id, promise.id) && Intrinsics.areEqual(this.notifyUri, promise.notifyUri);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getNotifyUri() {
        return this.notifyUri;
    }

    @NotNull
    public final String getRaw() {
        return this.raw;
    }

    public int hashCode() {
        return this.notifyUri.hashCode() + AbstractC1038a.m1202c(this.raw.hashCode() * 31, 31, this.id);
    }

    @NotNull
    public String toString() {
        return AbstractC0622a.m1170p(this.notifyUri, ")", AbstractC0000a.m16m("Promise(raw=", this.raw, ", id=", this.id, ", notifyUri="));
    }
}
