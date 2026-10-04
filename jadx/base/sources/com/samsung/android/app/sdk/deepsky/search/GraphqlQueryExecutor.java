package com.samsung.android.app.sdk.deepsky.search;

import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u000e\u000fJ\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/search/GraphqlQueryExecutor;", "Lcom/samsung/android/app/sdk/deepsky/search/Cancelable;", "dispatcher", "Ljava/util/concurrent/Executor;", "execute", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/app/sdk/deepsky/search/GraphqlQueryExecutor$Callback;", "future", "Ljava/util/concurrent/Future;", "Lcom/samsung/android/app/sdk/deepsky/search/Response;", "logger", "Lcom/samsung/android/app/sdk/deepsky/search/Logger;", Contract.VARIABLE, "", "Callback", "Factory", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface GraphqlQueryExecutor extends Cancelable {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/search/GraphqlQueryExecutor$Callback;", "", "onFailure", "", "e", "", "onResponse", "response", "Lcom/samsung/android/app/sdk/deepsky/search/Response;", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface Callback {
        void onFailure(@NotNull Throwable e);

        void onResponse(@NotNull Response response);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/search/GraphqlQueryExecutor$Factory;", "", "query", "Lcom/samsung/android/app/sdk/deepsky/search/GraphqlQueryExecutor;", "", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface Factory {
        @NotNull
        GraphqlQueryExecutor query(@NotNull String query);
    }

    @NotNull
    GraphqlQueryExecutor dispatcher(@NotNull Executor dispatcher);

    @NotNull
    Cancelable execute(@NotNull Callback callback);

    @NotNull
    Future<Response> future();

    @NotNull
    GraphqlQueryExecutor logger(@NotNull Logger logger);

    @NotNull
    GraphqlQueryExecutor variable(@NotNull String variable);
}
