package androidx.appsearch.app;

import android.content.Context;
import android.os.UserHandle;
import androidx.annotation.RestrictTo;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class JetpackAppSearchEnvironment implements AppSearchEnvironment {
    @Override // androidx.appsearch.app.AppSearchEnvironment
    public ExecutorService createCachedThreadPoolExecutor() {
        return Executors.newCachedThreadPool();
    }

    @Override // androidx.appsearch.app.AppSearchEnvironment
    public ExecutorService createExecutorService(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, int i4) {
        return new ThreadPoolExecutor(i, i2, j, timeUnit, blockingQueue);
    }

    @Override // androidx.appsearch.app.AppSearchEnvironment
    public ExecutorService createSingleThreadExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Override // androidx.appsearch.app.AppSearchEnvironment
    public File getAppSearchDir(Context context, UserHandle userHandle) {
        return new File(context.getFilesDir(), "appsearch");
    }

    @Override // androidx.appsearch.app.AppSearchEnvironment
    public File getCacheDir(Context context) {
        return context.getCacheDir();
    }

    @Override // androidx.appsearch.app.AppSearchEnvironment
    public int getEnvironment() {
        return 1;
    }

    @Override // androidx.appsearch.app.AppSearchEnvironment
    public boolean isInfoLoggingEnabled() {
        return true;
    }

    @Override // androidx.appsearch.app.AppSearchEnvironment
    public Context createContextAsUser(Context context, UserHandle userHandle) {
        return context;
    }
}
