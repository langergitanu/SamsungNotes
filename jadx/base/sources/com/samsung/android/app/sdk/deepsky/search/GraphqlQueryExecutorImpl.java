package com.samsung.android.app.sdk.deepsky.search;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.credentials.provider.C2558c;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import com.samsung.android.app.sdk.deepsky.contract.search.Promise;
import com.samsung.android.app.sdk.deepsky.contract.search.RequestData;
import com.samsung.android.app.sdk.deepsky.contract.search.ResponseData;
import com.samsung.android.app.sdk.deepsky.search.GraphqlQueryExecutor;
import com.samsung.android.app.sdk.deepsky.search.GraphqlQueryExecutorImpl;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.sec.spp.push.Config;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import p099Y2.C0347a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\t\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016J\u0018\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0005H\u0002J \u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050*2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/search/GraphqlQueryExecutorImpl;", "Lcom/samsung/android/app/sdk/deepsky/search/GraphqlQueryExecutor;", Config.NOTIFICATION_INTENT_SENDER, "Lcom/samsung/android/app/sdk/deepsky/search/CommandSender;", "query", "", "(Lcom/samsung/android/app/sdk/deepsky/search/CommandSender;Ljava/lang/String;)V", "canceled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "dispatcher", "Ljava/util/concurrent/Executor;", "isCanceled", "", "()Z", "logger", "Lcom/samsung/android/app/sdk/deepsky/search/Logger;", Contract.VARIABLE, "awaitResponse", "", Contract.PROMISE, "Lcom/samsung/android/app/sdk/deepsky/contract/search/Promise;", "cancel", "commandSearch", "Lcom/samsung/android/app/sdk/deepsky/contract/search/ResponseData;", "data", "Lcom/samsung/android/app/sdk/deepsky/contract/search/RequestData;", "execute", "Lcom/samsung/android/app/sdk/deepsky/search/Cancelable;", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/app/sdk/deepsky/search/GraphqlQueryExecutor$Callback;", "fetchResponse", "future", "Ljava/util/concurrent/Future;", "Lcom/samsung/android/app/sdk/deepsky/search/Response;", "log", "priority", "", "message", "throwable", "", "requestSearch", "resolve", "Ljava/util/concurrent/CompletableFuture;", "responseSearch", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGraphqlQueryExecutorImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GraphqlQueryExecutorImpl.kt\ncom/samsung/android/app/sdk/deepsky/search/GraphqlQueryExecutorImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,187:1\n1#2:188\n*E\n"})
public final class GraphqlQueryExecutorImpl implements GraphqlQueryExecutor {

    @NotNull
    private final AtomicBoolean canceled;

    @NotNull
    private Executor dispatcher;

    @NotNull
    private Logger logger;

    @NotNull
    private final String query;

    @NotNull
    private final CommandSender sender;

    @NotNull
    private String variable;

    /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.search.GraphqlQueryExecutorImpl$execute$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, m13886d2 = {"<anonymous>", "", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "kotlin.jvm.PlatformType", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class C70211 extends Lambda implements Function1<String, Unit> {
        final /* synthetic */ GraphqlQueryExecutor.Callback $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C70211(GraphqlQueryExecutor.Callback callback) {
            super(1);
            this.$callback = callback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$1(String it, GraphqlQueryExecutor.Callback callback) {
            Error error;
            Intrinsics.checkNotNullParameter(callback, "$callback");
            ResponseData.Companion companion = ResponseData.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            List<Error> listConvertErrorList = companion.convertErrorList(it);
            if (listConvertErrorList == null || (error = (Error) CollectionsKt.firstOrNull((List) listConvertErrorList)) == null) {
                callback.onResponse(new Response(it, listConvertErrorList));
            } else {
                callback.onFailure(error);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final String str) {
            GraphqlQueryExecutorImpl.this.log(3, "execute, thenAccept: " + str);
            if (!GraphqlQueryExecutorImpl.this.isCanceled()) {
                Executor executor = GraphqlQueryExecutorImpl.this.dispatcher;
                final GraphqlQueryExecutor.Callback callback = this.$callback;
                executor.execute(new Runnable() { // from class: com.samsung.android.app.sdk.deepsky.search.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        GraphqlQueryExecutorImpl.C70211.invoke$lambda$1(str, callback);
                    }
                });
            } else {
                GraphqlQueryExecutorImpl graphqlQueryExecutorImpl = GraphqlQueryExecutorImpl.this;
                graphqlQueryExecutorImpl.log(3, "execute, isCanceled: " + graphqlQueryExecutorImpl.isCanceled());
            }
        }
    }

    public GraphqlQueryExecutorImpl(@NotNull CommandSender sender, @NotNull String query) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(query, "query");
        this.sender = sender;
        this.query = query;
        this.variable = "";
        this.logger = new C0347a(24);
        this.dispatcher = sender.getMainThreadDispatcher();
        this.canceled = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void awaitResponse(final Promise promise) {
        Object objM22215constructorimpl;
        HandlerThread handlerThread = new HandlerThread(AbstractC0622a.m1169o("GraphqlQueryExecutor-", Instant.now().toEpochMilli()));
        handlerThread.start();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Handler handler = new Handler(handlerThread.getLooper());
        ContentObserver contentObserver = new ContentObserver(handler) { // from class: com.samsung.android.app.sdk.deepsky.search.GraphqlQueryExecutorImpl$awaitResponse$observer$1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange) {
                super.onChange(selfChange);
                countDownLatch.countDown();
                this.log(3, "awaitResponse, onChange, promiseId: " + promise.getId());
            }
        };
        CommandSender commandSender = this.sender;
        Uri uri = Uri.parse(promise.getNotifyUri());
        Intrinsics.checkNotNullExpressionValue(uri, "parse(promise.notifyUri)");
        commandSender.registerContentObserver(uri, contentObserver);
        try {
            Result.Companion companion = Result.INSTANCE;
            log(3, "awaitResponse, await");
            objM22215constructorimpl = Result.m22215constructorimpl(Boolean.valueOf(countDownLatch.await(1L, TimeUnit.MINUTES)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            log(6, "awaitResponse, onFailure", thM22218exceptionOrNullimpl);
        }
        this.sender.unregisterContentObserver(contentObserver);
        handlerThread.quitSafely();
    }

    private final ResponseData commandSearch(RequestData data) {
        CommandSender commandSender = this.sender;
        Bundle bundleNewBundle = commandSender.newBundle();
        bundleNewBundle.putAll(data.getBundle());
        Unit unit = Unit.INSTANCE;
        Bundle bundleSendCommand = commandSender.sendCommand("command_search", bundleNewBundle);
        ResponseData.Companion companion = ResponseData.INSTANCE;
        if (bundleSendCommand == null) {
            bundleSendCommand = new Bundle();
        }
        return companion.from(bundleSendCommand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ResponseData fetchResponse(Promise promise) {
        log(3, AbstractC0541b.m772n("fetchResponse, promiseId ", promise.getId()));
        ResponseData responseDataResponseSearch = responseSearch(new RequestData.Builder().setPromise(promise.getRaw()).build());
        log(3, AbstractC0541b.m772n("fetchResponse, response: ", responseDataResponseSearch.getResponse()));
        return responseDataResponseSearch;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response future$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (Response) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void log(int priority, String message) {
        this.logger.log(priority, message, null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logger$lambda$0(int i, String str, Throwable th, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 3>");
    }

    private final ResponseData requestSearch(RequestData data) {
        CommandSender commandSender = this.sender;
        Bundle bundleNewBundle = commandSender.newBundle();
        bundleNewBundle.putAll(data.getBundle());
        Unit unit = Unit.INSTANCE;
        Bundle bundleSendCommand = commandSender.sendCommand("request_search", bundleNewBundle);
        ResponseData.Companion companion = ResponseData.INSTANCE;
        if (bundleSendCommand == null) {
            bundleSendCommand = new Bundle();
        }
        return companion.from(bundleSendCommand);
    }

    private final CompletableFuture<String> resolve(final RequestData data) {
        CompletableFuture<String> completableFutureThenApply = CompletableFuture.supplyAsync(new Supplier() { // from class: com.samsung.android.app.sdk.deepsky.search.a
            @Override // java.util.function.Supplier
            public final Object get() {
                return GraphqlQueryExecutorImpl.resolve$lambda$6(this.f4732a, data);
            }
        }).thenApply((Function) new C2558c(new Function1<ResponseData, String>() { // from class: com.samsung.android.app.sdk.deepsky.search.GraphqlQueryExecutorImpl.resolve.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(ResponseData responseData) {
                if (responseData.getHasError()) {
                    GraphqlQueryExecutorImpl.this.log(6, "resolve, hasError: " + responseData.getResponse());
                    return responseData.getResponse();
                }
                Promise promise = responseData.getPromise();
                if (promise == null) {
                    throw new IllegalArgumentException("promise is null");
                }
                GraphqlQueryExecutorImpl.this.awaitResponse(promise);
                ResponseData responseDataFetchResponse = GraphqlQueryExecutorImpl.this.fetchResponse(promise);
                GraphqlQueryExecutorImpl graphqlQueryExecutorImpl = GraphqlQueryExecutorImpl.this;
                RequestData requestData = data;
                if (responseDataFetchResponse.getHasError()) {
                    graphqlQueryExecutorImpl.log(6, "resolve, hasError: " + responseDataFetchResponse.getResponse());
                    graphqlQueryExecutorImpl.log(6, "resolve, query: " + requestData.getQuery());
                }
                return responseDataFetchResponse.getResponse();
            }
        }, 11));
        Intrinsics.checkNotNullExpressionValue(completableFutureThenApply, "private fun resolve(data….response\n        }\n    }");
        return completableFutureThenApply;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ResponseData resolve$lambda$6(GraphqlQueryExecutorImpl this$0, RequestData data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        return this$0.requestSearch(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    private final ResponseData responseSearch(RequestData data) {
        CommandSender commandSender = this.sender;
        Bundle bundleNewBundle = commandSender.newBundle();
        bundleNewBundle.putAll(data.getBundle());
        Unit unit = Unit.INSTANCE;
        Bundle bundleSendCommand = commandSender.sendCommand("response_search", bundleNewBundle);
        ResponseData.Companion companion = ResponseData.INSTANCE;
        if (bundleSendCommand == null) {
            bundleSendCommand = new Bundle();
        }
        return companion.from(bundleSendCommand);
    }

    @Override // com.samsung.android.app.sdk.deepsky.search.Cancelable
    public void cancel() {
        log(3, "cancel");
        this.canceled.set(true);
    }

    @Override // com.samsung.android.app.sdk.deepsky.search.GraphqlQueryExecutor
    @NotNull
    public GraphqlQueryExecutor dispatcher(@NotNull Executor dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        return this;
    }

    @Override // com.samsung.android.app.sdk.deepsky.search.GraphqlQueryExecutor
    @NotNull
    public Cancelable execute(@NotNull GraphqlQueryExecutor.Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        log(3, "execute");
        resolve(new RequestData.Builder().setQuery(this.query).setVariable(this.variable).build()).thenAccept((Consumer<? super String>) new C7027b(new C70211(callback), 0));
        return this;
    }

    @Override // com.samsung.android.app.sdk.deepsky.search.GraphqlQueryExecutor
    @NotNull
    public Future<Response> future() {
        Future futureThenApply = resolve(new RequestData.Builder().setQuery(this.query).setVariable(this.variable).build()).thenApply((Function<? super String, ? extends U>) new C2558c(new Function1<String, Response>() { // from class: com.samsung.android.app.sdk.deepsky.search.GraphqlQueryExecutorImpl.future.1
            @Override // kotlin.jvm.functions.Function1
            public final Response invoke(String it) {
                ResponseData.Companion companion = ResponseData.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                return new Response(it, companion.convertErrorList(it));
            }
        }, 10));
        Intrinsics.checkNotNullExpressionValue(futureThenApply, "resolve(data)\n          …s = errors)\n            }");
        return futureThenApply;
    }

    @Override // com.samsung.android.app.sdk.deepsky.search.Cancelable
    public boolean isCanceled() {
        return this.canceled.get();
    }

    @Override // com.samsung.android.app.sdk.deepsky.search.GraphqlQueryExecutor
    @NotNull
    public GraphqlQueryExecutor logger(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        return this;
    }

    @Override // com.samsung.android.app.sdk.deepsky.search.GraphqlQueryExecutor
    @NotNull
    public GraphqlQueryExecutor variable(@NotNull String variable) {
        Object objM22215constructorimpl;
        Intrinsics.checkNotNullParameter(variable, "variable");
        try {
            Result.Companion companion = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(new JSONObject(variable));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            log(6, "invalid variable", thM22218exceptionOrNullimpl);
        }
        if (Result.m22222isSuccessimpl(objM22215constructorimpl)) {
            this.variable = variable;
        }
        return this;
    }

    private final void log(int priority, String message, Throwable throwable) {
        this.logger.log(priority, message, throwable, new Object[0]);
    }
}
