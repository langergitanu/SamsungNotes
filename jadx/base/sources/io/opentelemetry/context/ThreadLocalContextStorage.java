package io.opentelemetry.context;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
enum ThreadLocalContextStorage implements ContextStorage {
    INSTANCE;

    private static final Logger logger = Logger.getLogger(ThreadLocalContextStorage.class.getName());
    private static final ThreadLocal<Context> THREAD_LOCAL_STORAGE = new ThreadLocal<>();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$attach$0(Context context, Context context2) {
        if (current() != context) {
            logger.log(Level.FINE, "Context in storage not the expected context, Scope.close was not called correctly");
        }
        THREAD_LOCAL_STORAGE.set(context2);
    }

    @Override // io.opentelemetry.context.ContextStorage
    public Scope attach(final Context context) {
        if (context == null) {
            return NoopScope.INSTANCE;
        }
        final Context contextCurrent = current();
        if (context == contextCurrent) {
            return NoopScope.INSTANCE;
        }
        THREAD_LOCAL_STORAGE.set(context);
        return new Scope() { // from class: io.opentelemetry.context.c
            @Override // io.opentelemetry.context.Scope, java.lang.AutoCloseable
            public final void close() {
                this.f8966a.lambda$attach$0(context, contextCurrent);
            }
        };
    }

    @Override // io.opentelemetry.context.ContextStorage
    @Nullable
    public Context current() {
        return THREAD_LOCAL_STORAGE.get();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum NoopScope implements Scope {
        INSTANCE;

        @Override // io.opentelemetry.context.Scope, java.lang.AutoCloseable
        public void close() {
        }
    }
}
