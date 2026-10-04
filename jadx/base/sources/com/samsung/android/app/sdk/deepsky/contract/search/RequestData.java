package com.samsung.android.app.sdk.deepsky.contract.search;

import android.os.Bundle;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000eR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000e¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/search/RequestData;", "", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "getBundle", "()Landroid/os/Bundle;", Contract.COMMAND, "Lcom/samsung/android/app/sdk/deepsky/contract/search/Command;", "getCommand", "()Lcom/samsung/android/app/sdk/deepsky/contract/search/Command;", Contract.HEADERS, "", "getHeaders", "()Ljava/lang/String;", Contract.PROMISE, "Lcom/samsung/android/app/sdk/deepsky/contract/search/Promise;", "getPromise", "()Lcom/samsung/android/app/sdk/deepsky/contract/search/Promise;", Contract.PROMISE_ID, "", "getPromiseId", "()Ljava/lang/Integer;", "query", "getQuery", Contract.VARIABLE, "getVariable", "Builder", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nsearch.kt\nKotlin\n*S Kotlin\n*F\n+ 1 search.kt\ncom/samsung/android/app/sdk/deepsky/contract/search/RequestData\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,355:1\n1#2:356\n*E\n"})
public final class RequestData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final Bundle bundle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0000J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/search/RequestData$Builder;", "", "()V", Contract.COMMAND, "", Contract.HEADERS, Contract.PROMISE, "query", Contract.VARIABLE, "build", "Lcom/samsung/android/app/sdk/deepsky/contract/search/RequestData;", "setCancelCommand", "setHeaders", "setPromise", "setQuery", "setStateCommand", "setVariable", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nsearch.kt\nKotlin\n*S Kotlin\n*F\n+ 1 search.kt\ncom/samsung/android/app/sdk/deepsky/contract/search/RequestData$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,355:1\n1#2:356\n*E\n"})
    public static final class Builder {

        @Nullable
        private String command;

        @Nullable
        private String headers;

        @Nullable
        private String promise;

        @Nullable
        private String query;

        @Nullable
        private String variable;

        @NotNull
        public final RequestData build() {
            Bundle bundle = new Bundle();
            String str = this.query;
            if (str != null) {
                bundle.putString("query", str);
            }
            String str2 = this.variable;
            if (str2 != null) {
                bundle.putString(Contract.VARIABLE, str2);
            }
            String str3 = this.headers;
            if (str3 != null) {
                bundle.putString(Contract.HEADERS, str3);
            }
            String str4 = this.promise;
            if (str4 != null) {
                bundle.putString(Contract.PROMISE, str4);
            }
            String str5 = this.command;
            if (str5 != null) {
                bundle.putString(Contract.COMMAND, str5);
            }
            return new RequestData(bundle);
        }

        @NotNull
        public final Builder setCancelCommand() {
            this.command = "cancel";
            return this;
        }

        @NotNull
        public final Builder setHeaders(@NotNull String headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.headers = headers;
            return this;
        }

        @NotNull
        public final Builder setPromise(@NotNull String promise) {
            Intrinsics.checkNotNullParameter(promise, "promise");
            this.promise = promise;
            return this;
        }

        @NotNull
        public final Builder setQuery(@NotNull String query) {
            Intrinsics.checkNotNullParameter(query, "query");
            this.query = query;
            return this;
        }

        @NotNull
        public final Builder setStateCommand() {
            this.command = "state";
            return this;
        }

        @NotNull
        public final Builder setVariable(@NotNull String variable) {
            Intrinsics.checkNotNullParameter(variable, "variable");
            this.variable = variable;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/search/RequestData$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/samsung/android/app/sdk/deepsky/contract/search/RequestData;", "bundle", "Landroid/os/Bundle;", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RequestData from(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return new RequestData(bundle);
        }

        private Companion() {
        }
    }

    public RequestData(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.bundle = bundle;
    }

    @NotNull
    public final Bundle getBundle() {
        return this.bundle;
    }

    @Nullable
    public final Command getCommand() {
        String string = this.bundle.getString(Contract.COMMAND);
        if (string != null) {
            return Command.INSTANCE.fromId(string);
        }
        return null;
    }

    @Nullable
    public final String getHeaders() {
        return this.bundle.getString(Contract.HEADERS);
    }

    @Nullable
    public final Promise getPromise() {
        String string = this.bundle.getString(Contract.PROMISE);
        if (string != null) {
            return Promise.INSTANCE.parse(string);
        }
        return null;
    }

    @Nullable
    public final Integer getPromiseId() {
        Promise promise;
        String id;
        String string = this.bundle.getString(Contract.PROMISE);
        if (string == null || (promise = Promise.INSTANCE.parse(string)) == null || (id = promise.getId()) == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(id));
    }

    @Nullable
    public final String getQuery() {
        return this.bundle.getString("query");
    }

    @Nullable
    public final String getVariable() {
        return this.bundle.getString(Contract.VARIABLE);
    }
}
