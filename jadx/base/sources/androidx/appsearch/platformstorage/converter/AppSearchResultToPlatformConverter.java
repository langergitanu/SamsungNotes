package androidx.appsearch.platformstorage.converter;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.AppSearchBatchResult;
import androidx.appsearch.app.AppSearchResult;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.appsearch.platformstorage.AbstractC0573h;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.Preconditions;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class AppSearchResultToPlatformConverter {
    private AppSearchResultToPlatformConverter() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"WrongConstant"})
    public static <K, PlatformValue, JetpackValue> AppSearchBatchResult<K, JetpackValue> platformAppSearchBatchResultToJetpack(android.app.appsearch.AppSearchBatchResult<K, PlatformValue> appSearchBatchResult, Function<PlatformValue, JetpackValue> function) {
        Preconditions.checkNotNull(appSearchBatchResult);
        Preconditions.checkNotNull(function);
        AppSearchBatchResult.Builder builder = new AppSearchBatchResult.Builder();
        for (Map.Entry entry : appSearchBatchResult.getSuccesses().entrySet()) {
            try {
                builder.setSuccess(entry.getKey(), function.apply(entry.getValue()));
            } catch (Throwable th) {
                builder.setResult(entry.getKey(), AppSearchResult.throwableToFailedResult(th));
            }
        }
        for (Map.Entry entry2 : appSearchBatchResult.getFailures().entrySet()) {
            builder.setFailure(entry2.getKey(), AbstractC0573h.m1054b(entry2.getValue()).getResultCode(), AbstractC0573h.m1054b(entry2.getValue()).getErrorMessage());
        }
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"WrongConstant"})
    public static <PlatformType, JetpackType> void platformAppSearchResultToFuture(android.app.appsearch.AppSearchResult<PlatformType> appSearchResult, ResolvableFuture<JetpackType> resolvableFuture, Function<PlatformType, JetpackType> function) {
        Preconditions.checkNotNull(appSearchResult);
        Preconditions.checkNotNull(resolvableFuture);
        if (!appSearchResult.isSuccess()) {
            resolvableFuture.setException(new AppSearchException(appSearchResult.getResultCode(), appSearchResult.getErrorMessage()));
            return;
        }
        try {
            resolvableFuture.set(function.apply(appSearchResult.getResultValue()));
        } catch (Throwable th) {
            resolvableFuture.setException(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"WrongConstant"})
    public static <PlatformType, JetpackType> AppSearchResult<JetpackType> platformAppSearchResultToJetpack(android.app.appsearch.AppSearchResult<PlatformType> appSearchResult, Function<PlatformType, JetpackType> function) {
        Preconditions.checkNotNull(appSearchResult);
        if (!appSearchResult.isSuccess()) {
            return AppSearchResult.newFailedResult(appSearchResult.getResultCode(), appSearchResult.getErrorMessage());
        }
        try {
            return AppSearchResult.newSuccessfulResult(function.apply(appSearchResult.getResultValue()));
        } catch (Throwable th) {
            return AppSearchResult.throwableToFailedResult(th);
        }
    }

    public static <T> void platformAppSearchResultToFuture(android.app.appsearch.AppSearchResult<T> appSearchResult, ResolvableFuture<T> resolvableFuture) {
        platformAppSearchResultToFuture(appSearchResult, resolvableFuture, Function.identity());
    }
}
