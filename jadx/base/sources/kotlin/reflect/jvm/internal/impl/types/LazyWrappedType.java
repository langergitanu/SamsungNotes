package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class LazyWrappedType extends WrappedType {

    @NotNull
    private final Function0<KotlinType> computation;

    @NotNull
    private final NotNullLazyValue<KotlinType> lazyValue;

    @NotNull
    private final StorageManager storageManager;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyWrappedType(@NotNull StorageManager storageManager, @NotNull Function0<? extends KotlinType> computation) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(computation, "computation");
        this.storageManager = storageManager;
        this.computation = computation;
        this.lazyValue = storageManager.createLazyValue(computation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType refine$lambda$0(KotlinTypeRefiner kotlinTypeRefiner, LazyWrappedType this$0) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "$kotlinTypeRefiner");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return kotlinTypeRefiner.refineType((KotlinTypeMarker) this$0.computation.invoke());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.WrappedType
    @NotNull
    public KotlinType getDelegate() {
        return this.lazyValue.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.WrappedType
    public boolean isComputed() {
        return this.lazyValue.isComputed();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    public LazyWrappedType refine(@NotNull final KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new LazyWrappedType(this.storageManager, new Function0(kotlinTypeRefiner, this) { // from class: kotlin.reflect.jvm.internal.impl.types.LazyWrappedType$$Lambda$0
            private final KotlinTypeRefiner arg$0;
            private final LazyWrappedType arg$1;

            {
                this.arg$0 = kotlinTypeRefiner;
                this.arg$1 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return LazyWrappedType.refine$lambda$0(this.arg$0, this.arg$1);
            }
        });
    }
}
