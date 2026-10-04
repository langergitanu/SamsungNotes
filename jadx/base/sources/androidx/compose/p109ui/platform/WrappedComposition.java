package androidx.compose.p109ui.platform;

import android.view.View;
import androidx.compose.p109ui.C2026R;
import androidx.compose.p109ui.platform.AndroidComposeView;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionServiceKey;
import androidx.compose.runtime.CompositionServices;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.apache.poi.sun.awt.AppContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0002\u0010\u0007J\b\u0010\u0019\u001a\u00020\u0012H\u0016J#\u0010\u001a\u001a\u0004\u0018\u0001H\u001b\"\u0004\b\u0000\u0010\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001dH\u0016¢\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J \u0010$\u001a\u00020\u00122\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u0013H\u0016¢\u0006\u0002\u0010&R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u001b\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, m13886d2 = {"Landroidx/compose/ui/platform/WrappedComposition;", "Landroidx/compose/runtime/Composition;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/compose/runtime/CompositionServices;", "owner", "Landroidx/compose/ui/platform/AndroidComposeView;", ShareApi.ORIGINAL_SIZE_IMAGE, "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/runtime/Composition;)V", "addedToLifecycle", "Landroidx/lifecycle/Lifecycle;", AppContext.DISPOSED_PROPERTY_NAME, "", "hasInvalidations", "getHasInvalidations", "()Z", "isDisposed", "lastContent", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "getOriginal", "()Landroidx/compose/runtime/Composition;", "getOwner", "()Landroidx/compose/ui/platform/AndroidComposeView;", "dispose", "getCompositionService", "T", "key", "Landroidx/compose/runtime/CompositionServiceKey;", "(Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "setContent", "content", "(Lkotlin/jvm/functions/Function2;)V", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class WrappedComposition implements Composition, LifecycleEventObserver, CompositionServices {

    @Nullable
    private Lifecycle addedToLifecycle;
    private boolean disposed;

    @NotNull
    private Function2<? super Composer, ? super Integer, Unit> lastContent = ComposableSingletons$Wrapper_androidKt.INSTANCE.m20192getLambda1$ui_release();

    @NotNull
    private final Composition original;

    @NotNull
    private final AndroidComposeView owner;

    public WrappedComposition(@NotNull AndroidComposeView androidComposeView, @NotNull Composition composition) {
        this.owner = androidComposeView;
        this.original = composition;
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        if (!this.disposed) {
            this.disposed = true;
            this.owner.getView().setTag(C2026R.id.wrapped_composition_tag, null);
            Lifecycle lifecycle = this.addedToLifecycle;
            if (lifecycle != null) {
                lifecycle.removeObserver(this);
            }
        }
        this.original.dispose();
    }

    @Override // androidx.compose.runtime.CompositionServices
    @Nullable
    public <T> T getCompositionService(@NotNull CompositionServiceKey<T> key) {
        Composition composition = this.original;
        CompositionServices compositionServices = composition instanceof CompositionServices ? (CompositionServices) composition : null;
        if (compositionServices != null) {
            return (T) compositionServices.getCompositionService(key);
        }
        return null;
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        return this.original.getHasInvalidations();
    }

    @NotNull
    public final Composition getOriginal() {
        return this.original;
    }

    @NotNull
    public final AndroidComposeView getOwner() {
        return this.owner;
    }

    @Override // androidx.compose.runtime.Composition
    /* JADX INFO: renamed from: isDisposed */
    public boolean getDisposed() {
        return this.original.getDisposed();
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            dispose();
        } else {
            if (event != Lifecycle.Event.ON_CREATE || this.disposed) {
                return;
            }
            setContent(this.lastContent);
        }
    }

    @Override // androidx.compose.runtime.Composition
    @ComposableInferredTarget(scheme = "[0[0]]")
    public void setContent(@NotNull final Function2<? super Composer, ? super Integer, Unit> content) {
        this.owner.setOnViewTreeOwnersAvailable(new Function1<AndroidComposeView.ViewTreeOwners, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition.setContent.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AndroidComposeView.ViewTreeOwners viewTreeOwners) {
                invoke2(viewTreeOwners);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull AndroidComposeView.ViewTreeOwners viewTreeOwners) {
                if (WrappedComposition.this.disposed) {
                    return;
                }
                Lifecycle lifecycle = viewTreeOwners.getLifecycleOwner().getLifecycle();
                WrappedComposition.this.lastContent = content;
                if (WrappedComposition.this.addedToLifecycle == null) {
                    WrappedComposition.this.addedToLifecycle = lifecycle;
                    lifecycle.addObserver(WrappedComposition.this);
                } else if (lifecycle.getState().isAtLeast(Lifecycle.State.CREATED)) {
                    Composition original = WrappedComposition.this.getOriginal();
                    final WrappedComposition wrappedComposition = WrappedComposition.this;
                    final Function2<Composer, Integer, Unit> function2 = content;
                    original.setContent(ComposableLambdaKt.composableLambdaInstance(-2000640158, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition.setContent.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @Composable
                        public final void invoke(@Nullable Composer composer, int i) {
                            if ((i & 3) == 2 && composer.getSkipping()) {
                                composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2000640158, i, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous> (Wrapper.android.kt:134)");
                            }
                            Object tag = wrappedComposition.getOwner().getTag(C2026R.id.inspection_slot_table_set);
                            Set<CompositionData> set = TypeIntrinsics.isMutableSet(tag) ? (Set) tag : null;
                            if (set == null) {
                                Object parent = wrappedComposition.getOwner().getParent();
                                View view = parent instanceof View ? (View) parent : null;
                                Object tag2 = view != null ? view.getTag(C2026R.id.inspection_slot_table_set) : null;
                                set = TypeIntrinsics.isMutableSet(tag2) ? (Set) tag2 : null;
                            }
                            if (set != null) {
                                set.add(composer.getCompositionData());
                                composer.collectParameterInformation();
                            }
                            AndroidComposeView owner = wrappedComposition.getOwner();
                            boolean zChangedInstance = composer.changedInstance(wrappedComposition);
                            WrappedComposition wrappedComposition2 = wrappedComposition;
                            Object objRememberedValue = composer.rememberedValue();
                            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new WrappedComposition$setContent$1$1$1$1(wrappedComposition2, null);
                                composer.updateRememberedValue(objRememberedValue);
                            }
                            EffectsKt.LaunchedEffect(owner, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue, composer, 0);
                            AndroidComposeView owner2 = wrappedComposition.getOwner();
                            boolean zChangedInstance2 = composer.changedInstance(wrappedComposition);
                            WrappedComposition wrappedComposition3 = wrappedComposition;
                            Object objRememberedValue2 = composer.rememberedValue();
                            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new WrappedComposition$setContent$1$1$2$1(wrappedComposition3, null);
                                composer.updateRememberedValue(objRememberedValue2);
                            }
                            EffectsKt.LaunchedEffect(owner2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composer, 0);
                            ProvidedValue<Set<CompositionData>> providedValueProvides = InspectionTablesKt.getLocalInspectionTables().provides(set);
                            final WrappedComposition wrappedComposition4 = wrappedComposition;
                            final Function2<Composer, Integer, Unit> function22 = function2;
                            CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(-1193460702, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition.setContent.1.1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @Composable
                                public final void invoke(@Nullable Composer composer2, int i2) {
                                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1193460702, i2, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous>.<anonymous> (Wrapper.android.kt:154)");
                                    }
                                    AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals(wrappedComposition4.getOwner(), function22, composer2, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer, 54), composer, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }));
                }
            }
        });
    }
}
