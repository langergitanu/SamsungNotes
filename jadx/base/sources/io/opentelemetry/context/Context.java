package io.opentelemetry.context;

import androidx.compose.p109ui.text.input.ExecutorC2252b;
import com.google.errorprone.annotations.MustBeClosed;
import com.microsoft.identity.common.java.storage.C6438a;
import com.opencsv.bean.C6618c;
import com.samsung.android.imagetranslation.inpainting.C7126a;
import com.samsung.android.sdk.scs.p142ai.text.bnlp.CallableC7766b;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.RunnableC10960a;
import com.vladsch.flexmark.ast.util.C11782e;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import p122b2.C4183f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface Context {
    static Context current() {
        Context contextCurrent = ContextStorage.get().current();
        return contextCurrent != null ? contextCurrent : root();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void lambda$taskWrapping$0(Executor executor, Runnable runnable) {
        executor.execute(current().wrap(runnable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default void lambda$wrap$1(Runnable runnable) {
        Scope scopeMakeCurrent = makeCurrent();
        try {
            runnable.run();
            if (scopeMakeCurrent != null) {
                scopeMakeCurrent.close();
            }
        } catch (Throwable th) {
            if (scopeMakeCurrent != null) {
                try {
                    scopeMakeCurrent.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default Object lambda$wrap$2(Callable callable) {
        Scope scopeMakeCurrent = makeCurrent();
        try {
            Object objCall = callable.call();
            if (scopeMakeCurrent != null) {
                scopeMakeCurrent.close();
            }
            return objCall;
        } catch (Throwable th) {
            if (scopeMakeCurrent != null) {
                try {
                    scopeMakeCurrent.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default void lambda$wrap$3(Executor executor, Runnable runnable) {
        executor.execute(wrap(runnable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default void lambda$wrapConsumer$6(Consumer consumer, Object obj) {
        Scope scopeMakeCurrent = makeCurrent();
        try {
            consumer.accept(obj);
            if (scopeMakeCurrent != null) {
                scopeMakeCurrent.close();
            }
        } catch (Throwable th) {
            if (scopeMakeCurrent != null) {
                try {
                    scopeMakeCurrent.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default void lambda$wrapConsumer$7(BiConsumer biConsumer, Object obj, Object obj2) {
        Scope scopeMakeCurrent = makeCurrent();
        try {
            biConsumer.accept(obj, obj2);
            if (scopeMakeCurrent != null) {
                scopeMakeCurrent.close();
            }
        } catch (Throwable th) {
            if (scopeMakeCurrent != null) {
                try {
                    scopeMakeCurrent.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default Object lambda$wrapFunction$4(Function function, Object obj) {
        Scope scopeMakeCurrent = makeCurrent();
        try {
            Object objApply = function.apply(obj);
            if (scopeMakeCurrent != null) {
                scopeMakeCurrent.close();
            }
            return objApply;
        } catch (Throwable th) {
            if (scopeMakeCurrent != null) {
                try {
                    scopeMakeCurrent.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default Object lambda$wrapFunction$5(BiFunction biFunction, Object obj, Object obj2) {
        Scope scopeMakeCurrent = makeCurrent();
        try {
            Object objApply = biFunction.apply(obj, obj2);
            if (scopeMakeCurrent != null) {
                scopeMakeCurrent.close();
            }
            return objApply;
        } catch (Throwable th) {
            if (scopeMakeCurrent != null) {
                try {
                    scopeMakeCurrent.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default Object lambda$wrapSupplier$8(Supplier supplier) {
        Scope scopeMakeCurrent = makeCurrent();
        try {
            Object obj = supplier.get();
            if (scopeMakeCurrent != null) {
                scopeMakeCurrent.close();
            }
            return obj;
        } catch (Throwable th) {
            if (scopeMakeCurrent != null) {
                try {
                    scopeMakeCurrent.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    static Context root() {
        return ContextStorage.get().root();
    }

    static Executor taskWrapping(Executor executor) {
        return new ExecutorC2252b(executor, 1);
    }

    @Nullable
    <V> V get(ContextKey<V> contextKey);

    @MustBeClosed
    default Scope makeCurrent() {
        return ContextStorage.get().attach(this);
    }

    <V> Context with(ContextKey<V> contextKey, V v);

    default Context with(ImplicitContextKeyed implicitContextKeyed) {
        return implicitContextKeyed.storeInContext(this);
    }

    default Runnable wrap(Runnable runnable) {
        return new RunnableC10960a(this, runnable, 26);
    }

    default <T> Consumer<T> wrapConsumer(Consumer<T> consumer) {
        return new C6618c(this, consumer, 9);
    }

    default <T, U> Function<T, U> wrapFunction(Function<T, U> function) {
        return new C6438a(this, function, 2);
    }

    default <T> Supplier<T> wrapSupplier(Supplier<T> supplier) {
        return new C4183f(this, supplier, 8);
    }

    static ExecutorService taskWrapping(ExecutorService executorService) {
        return new CurrentContextExecutorService(executorService);
    }

    default <T> Callable<T> wrap(Callable<T> callable) {
        return new CallableC7766b(this, callable, 7);
    }

    default <T, U> BiConsumer<T, U> wrapConsumer(BiConsumer<T, U> biConsumer) {
        return new C7126a(this, biConsumer, 4);
    }

    default <T, U, V> BiFunction<T, U, V> wrapFunction(BiFunction<T, U, V> biFunction) {
        return new C11782e(this, biFunction, 1);
    }

    default Executor wrap(final Executor executor) {
        return new Executor() { // from class: io.opentelemetry.context.a
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.f8964a.lambda$wrap$3(executor, runnable);
            }
        };
    }

    default ExecutorService wrap(ExecutorService executorService) {
        return new ContextExecutorService(this, executorService);
    }

    default ScheduledExecutorService wrap(ScheduledExecutorService scheduledExecutorService) {
        return new ContextScheduledExecutorService(this, scheduledExecutorService);
    }
}
