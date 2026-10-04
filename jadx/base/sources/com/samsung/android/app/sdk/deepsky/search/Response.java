package com.samsung.android.app.sdk.deepsky.search;

import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0018\u00010\u0005HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/search/Response;", "", "data", "", Contract.ERRORS, "", "Ljava/lang/Error;", "Lkotlin/Error;", "(Ljava/lang/String;Ljava/util/List;)V", "getData", "()Ljava/lang/String;", "getErrors", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class Response {

    @Nullable
    private final String data;

    @Nullable
    private final List<Error> errors;

    /* JADX WARN: Multi-variable type inference failed */
    public Response() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Response copy$default(Response response, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = response.data;
        }
        if ((i & 2) != 0) {
            list = response.errors;
        }
        return response.copy(str, list);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getData() {
        return this.data;
    }

    @Nullable
    public final List<Error> component2() {
        return this.errors;
    }

    @NotNull
    public final Response copy(@Nullable String data, @Nullable List<? extends Error> errors) {
        return new Response(data, errors);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Response)) {
            return false;
        }
        Response response = (Response) other;
        return Intrinsics.areEqual(this.data, response.data) && Intrinsics.areEqual(this.errors, response.errors);
    }

    @Nullable
    public final String getData() {
        return this.data;
    }

    @Nullable
    public final List<Error> getErrors() {
        return this.errors;
    }

    public int hashCode() {
        String str = this.data;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<Error> list = this.errors;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Response(data=" + this.data + ", errors=" + this.errors + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Response(@Nullable String str, @Nullable List<? extends Error> list) {
        this.data = str;
        this.errors = list;
    }

    public /* synthetic */ Response(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list);
    }
}
