package androidx.work.impl.utils.taskexecutor;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface TaskExecutor {
    default void executeOnTaskThread(@NonNull Runnable runnable) {
        getSerialTaskExecutor().execute(runnable);
    }

    @NonNull
    Executor getMainThreadExecutor();

    @NonNull
    SerialExecutor getSerialTaskExecutor();

    @NonNull
    default CoroutineDispatcher getTaskCoroutineDispatcher() {
        return ExecutorsKt.from(getSerialTaskExecutor());
    }
}
