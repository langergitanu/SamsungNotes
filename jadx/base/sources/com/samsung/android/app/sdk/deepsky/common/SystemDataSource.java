package com.samsung.android.app.sdk.deepsky.common;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/common/SystemDataSource;", "", "getMainThreadDispatcher", "Ljava/util/concurrent/Executor;", "newBundle", "Landroid/os/Bundle;", "registerContentObserver", "", "uri", "Landroid/net/Uri;", "notifyForDescendants", "", "observer", "Landroid/database/ContentObserver;", "unregisterContentObserver", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface SystemDataSource {
    @NotNull
    Executor getMainThreadDispatcher();

    @NotNull
    Bundle newBundle();

    void registerContentObserver(@NotNull Uri uri, boolean notifyForDescendants, @NotNull ContentObserver observer);

    void unregisterContentObserver(@NotNull ContentObserver observer);
}
