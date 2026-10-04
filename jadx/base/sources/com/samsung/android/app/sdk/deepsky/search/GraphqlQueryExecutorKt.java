package com.samsung.android.app.sdk.deepsky.search;

import com.samsung.android.app.sdk.deepsky.search.GraphqlQueryExecutor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004¨\u0006\t"}, m13886d2 = {"executeBy", "Lcom/samsung/android/app/sdk/deepsky/search/Cancelable;", "Lcom/samsung/android/app/sdk/deepsky/search/GraphqlQueryExecutor;", "onResponse", "Lkotlin/Function1;", "Lcom/samsung/android/app/sdk/deepsky/search/Response;", "", "onFailure", "", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class GraphqlQueryExecutorKt {
    @NotNull
    public static final Cancelable executeBy(@NotNull GraphqlQueryExecutor graphqlQueryExecutor, @NotNull final Function1<? super Response, Unit> onResponse, @NotNull final Function1<? super Throwable, Unit> onFailure) {
        Intrinsics.checkNotNullParameter(graphqlQueryExecutor, "<this>");
        Intrinsics.checkNotNullParameter(onResponse, "onResponse");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        return graphqlQueryExecutor.execute(new GraphqlQueryExecutor.Callback() { // from class: com.samsung.android.app.sdk.deepsky.search.GraphqlQueryExecutorKt.executeBy.1
            @Override // com.samsung.android.app.sdk.deepsky.search.GraphqlQueryExecutor.Callback
            public void onFailure(@NotNull Throwable e) {
                Intrinsics.checkNotNullParameter(e, "e");
                onFailure.invoke(e);
            }

            @Override // com.samsung.android.app.sdk.deepsky.search.GraphqlQueryExecutor.Callback
            public void onResponse(@NotNull Response response) {
                Intrinsics.checkNotNullParameter(response, "response");
                onResponse.invoke(response);
            }
        });
    }
}
