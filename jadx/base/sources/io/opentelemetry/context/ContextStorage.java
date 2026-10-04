package io.opentelemetry.context;

import java.util.function.Function;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ContextStorage {
    static void addWrapper(Function<? super ContextStorage, ? extends ContextStorage> function) {
        ContextStorageWrappers.addWrapper(function);
    }

    static ContextStorage defaultStorage() {
        return ThreadLocalContextStorage.INSTANCE;
    }

    static ContextStorage get() {
        return LazyStorage.get();
    }

    Scope attach(Context context);

    @Nullable
    Context current();

    default Context root() {
        return ArrayBasedContext.root();
    }
}
