package com.samsung.android.app.sdk.deepsky.search;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.samsung.android.app.sdk.deepsky.common.ContentProviderCaller;
import com.samsung.android.app.sdk.deepsky.common.SystemDataSource;
import com.samsung.android.app.sdk.deepsky.search.GraphqlQueryExecutor;
import com.sec.spp.push.Config;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0010H\u0016J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/search/SearchImpl;", "Lcom/samsung/android/app/sdk/deepsky/search/GraphqlQueryExecutor$Factory;", "Lcom/samsung/android/app/sdk/deepsky/search/Search;", "context", "Landroid/content/Context;", "contentProviderCaller", "Lcom/samsung/android/app/sdk/deepsky/common/ContentProviderCaller;", "systemDatasource", "Lcom/samsung/android/app/sdk/deepsky/common/SystemDataSource;", "(Landroid/content/Context;Lcom/samsung/android/app/sdk/deepsky/common/ContentProviderCaller;Lcom/samsung/android/app/sdk/deepsky/common/SystemDataSource;)V", "commandSender", "Lcom/samsung/android/app/sdk/deepsky/search/CommandSender;", "checkIfAccessAllowed", "", "query", "Lcom/samsung/android/app/sdk/deepsky/search/GraphqlQueryExecutor;", "", "setSender", "", Config.NOTIFICATION_INTENT_SENDER, "setSender$deepsky_sdk_smartsuggestion_6_1_0_release", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SearchImpl implements GraphqlQueryExecutor.Factory, Search {

    @NotNull
    private static final String TAG = "Search";

    @NotNull
    private CommandSender commandSender;

    @NotNull
    private final ContentProviderCaller contentProviderCaller;

    @NotNull
    private final Context context;

    @NotNull
    private final SystemDataSource systemDatasource;

    public SearchImpl(@NotNull Context context, @NotNull ContentProviderCaller contentProviderCaller, @NotNull SystemDataSource systemDatasource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contentProviderCaller, "contentProviderCaller");
        Intrinsics.checkNotNullParameter(systemDatasource, "systemDatasource");
        this.context = context;
        this.contentProviderCaller = contentProviderCaller;
        this.systemDatasource = systemDatasource;
        this.commandSender = new CommandSender() { // from class: com.samsung.android.app.sdk.deepsky.search.SearchImpl$commandSender$1
            @Override // com.samsung.android.app.sdk.deepsky.search.CommandSender
            @NotNull
            public Executor getMainThreadDispatcher() {
                return this.this$0.systemDatasource.getMainThreadDispatcher();
            }

            @Override // com.samsung.android.app.sdk.deepsky.search.CommandSender
            @NotNull
            public Bundle newBundle() {
                return this.this$0.systemDatasource.newBundle();
            }

            @Override // com.samsung.android.app.sdk.deepsky.search.CommandSender
            public void registerContentObserver(@NotNull Uri uri, @NotNull ContentObserver observer) {
                Intrinsics.checkNotNullParameter(uri, "uri");
                Intrinsics.checkNotNullParameter(observer, "observer");
                this.this$0.systemDatasource.registerContentObserver(uri, false, observer);
            }

            @Override // com.samsung.android.app.sdk.deepsky.search.CommandSender
            @Nullable
            public Bundle sendCommand(@NotNull String method, @NotNull Bundle bundle) {
                Intrinsics.checkNotNullParameter(method, "method");
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                return this.this$0.contentProviderCaller.sendCommand(method, bundle);
            }

            @Override // com.samsung.android.app.sdk.deepsky.search.CommandSender
            public void unregisterContentObserver(@NotNull ContentObserver observer) {
                Intrinsics.checkNotNullParameter(observer, "observer");
                this.this$0.systemDatasource.unregisterContentObserver(observer);
            }
        };
    }

    public final boolean checkIfAccessAllowed() {
        return true;
    }

    @Override // com.samsung.android.app.sdk.deepsky.search.GraphqlQueryExecutor.Factory, com.samsung.android.app.sdk.deepsky.search.Search
    @NotNull
    public GraphqlQueryExecutor query(@NotNull String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        return new GraphqlQueryExecutorImpl(this.commandSender, query).logger(new Logger() { // from class: com.samsung.android.app.sdk.deepsky.search.SearchImpl.query.1
            @Override // com.samsung.android.app.sdk.deepsky.search.Logger
            public final void log(int i, @NotNull String message, @Nullable Throwable th, @NotNull Object[] objArr) {
                Intrinsics.checkNotNullParameter(message, "message");
                Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 3>");
                if (i == 6) {
                    Log.e(SearchImpl.TAG, message, th);
                }
            }
        });
    }

    public final void setSender$deepsky_sdk_smartsuggestion_6_1_0_release(@NotNull CommandSender sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        this.commandSender = sender;
    }
}
