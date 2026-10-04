package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.OnRemeasuredModifierKt;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001aZ\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062#\b\u0002\u0010\b\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tH\u0001¢\u0006\u0002\u0010\u000e\u001a-\u0010\u000f\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0012\u001a7\u0010\u000f\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0015\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u0010H\u0002¢\u0006\u0002\u0010\u0016\u001a%\u0010\u0017\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u0010H\u0002¢\u0006\u0002\u0010\u0016\u001a+\u0010\u0018\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u00102\u0006\u0010\u0019\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u0010\u001a\u001a¿\u0001\u0010\u001b\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002*\u00020\u001c2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001e2R\b\u0002\u0010\u001f\u001aL\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(!\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#\u0018\u00010 28\u0010$\u001a4\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110%¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(&\u0012\u0006\u0012\u0004\u0018\u00010\u00070 H\u0001ø\u0001\u0000\u001aH\u0010'\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002*\u00020\u001c2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\r2\b\b\u0002\u0010+\u001a\u00020\r2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-H\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, m13886d2 = {"rememberSwipeableV2State", "Landroidx/compose/material/SwipeableV2State;", "T", "", "initialState", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/SwipeableV2State;", "closestState", "", TypedValues.Cycle.S_WAVE_OFFSET, "(Ljava/util/Map;F)Ljava/lang/Object;", "searchUpwards", "(Ljava/util/Map;FZ)Ljava/lang/Object;", "maxOrNull", "(Ljava/util/Map;)Ljava/lang/Float;", "minOrNull", "requireAnchor", "state", "(Ljava/util/Map;Ljava/lang/Object;)F", "swipeAnchors", "Landroidx/compose/ui/Modifier;", "possibleStates", "", "anchorsChanged", "Lkotlin/Function2;", "oldAnchors", "newAnchors", "", "calculateAnchor", "Landroidx/compose/ui/unit/IntSize;", "layoutSize", "swipeableV2", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SwipeableV2Kt {

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableV2Kt$swipeableV2$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "velocity", ""}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.material.SwipeableV2Kt$swipeableV2$1", m14021f = "SwipeableV2.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C16431 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
        final /* synthetic */ SwipeableV2State<T> $state;
        /* synthetic */ float F$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material.SwipeableV2Kt$swipeableV2$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.material.SwipeableV2Kt$swipeableV2$1$1", m14021f = "SwipeableV2.kt", m14022i = {}, m14023l = {74}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ SwipeableV2State<T> $state;
            final /* synthetic */ float $velocity;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SwipeableV2State<T> swipeableV2State, float f, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$state = swipeableV2State;
                this.$velocity = f;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass1(this.$state, this.$velocity, continuation);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SwipeableV2State<T> swipeableV2State = this.$state;
                    float f = this.$velocity;
                    this.label = 1;
                    if (swipeableV2State.settle(f, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16431(SwipeableV2State<T> swipeableV2State, Continuation<? super C16431> continuation) {
            super(3, continuation);
            this.$state = swipeableV2State;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Float f, Continuation<? super Unit> continuation) {
            return invoke(coroutineScope, f.floatValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new AnonymousClass1(this.$state, this.F$0, null), 3, null);
            return Unit.INSTANCE;
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, float f, @Nullable Continuation<? super Unit> continuation) {
            C16431 c16431 = new C16431(this.$state, continuation);
            c16431.L$0 = coroutineScope;
            c16431.F$0 = f;
            return c16431.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T closestState(Map<T, Float> map, float f) {
        if (map.isEmpty()) {
            throw new IllegalArgumentException("The anchors were empty when trying to find the closest state");
        }
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        if (it.hasNext()) {
            float fAbs = Math.abs(((Number) ((Map.Entry) next).getValue()).floatValue() - f);
            do {
                T next2 = it.next();
                float fAbs2 = Math.abs(((Number) ((Map.Entry) next2).getValue()).floatValue() - f);
                if (Float.compare(fAbs, fAbs2) > 0) {
                    next = next2;
                    fAbs = fAbs2;
                }
            } while (it.hasNext());
        }
        return (T) ((Map.Entry) next).getKey();
    }

    public static /* synthetic */ Object closestState$default(Map map, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        return closestState(map, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Float maxOrNull(Map<T, Float> map) {
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Float minOrNull(Map<T, Float> map) {
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final <T> SwipeableV2State<T> rememberSwipeableV2State(@NotNull final T initialState, @Nullable final AnimationSpec<Float> animationSpec, @Nullable final Function1<? super T, Boolean> function1, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        composer.startReplaceableGroup(-1791789117);
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<T, Boolean>() { // from class: androidx.compose.material.SwipeableV2Kt.rememberSwipeableV2State.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull T it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.TRUE;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1791789117, i, -1, "androidx.compose.material.rememberSwipeableV2State (SwipeableV2.kt:366)");
        }
        SwipeableV2State<T> swipeableV2State = (SwipeableV2State) RememberSaveableKt.m18111rememberSaveable(new Object[0], (Saver) SwipeableV2State.Companion.Saver(animationSpec, function1), (String) null, (Function0) new Function0<SwipeableV2State<T>>() { // from class: androidx.compose.material.SwipeableV2Kt.rememberSwipeableV2State.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SwipeableV2State<T> invoke() {
                return new SwipeableV2State<>(initialState, animationSpec, function1);
            }
        }, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return swipeableV2State;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> float requireAnchor(Map<T, Float> map, T t) {
        Float f = map.get(t);
        if (f != null) {
            return f.floatValue();
        }
        throw new IllegalArgumentException(("Required anchor " + t + " was not found in anchors. Current anchors: " + MapsKt.toMap(map)).toString());
    }

    @ExperimentalMaterialApi
    @NotNull
    public static final <T> Modifier swipeAnchors(@NotNull Modifier modifier, @NotNull final SwipeableV2State<T> state, @NotNull final Set<? extends T> possibleStates, @Nullable final Function2<? super Map<T, Float>, ? super Map<T, Float>, Unit> function2, @NotNull final Function2<? super T, ? super IntSize, Float> calculateAnchor) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(possibleStates, "possibleStates");
        Intrinsics.checkNotNullParameter(calculateAnchor, "calculateAnchor");
        return OnRemeasuredModifierKt.onSizeChanged(modifier, new Function1<IntSize, Unit>() { // from class: androidx.compose.material.SwipeableV2Kt.swipeAnchors.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                m16884invokeozmzZPI(intSize.getPackedValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
            public final void m16884invokeozmzZPI(long j) {
                Function2<Map<T, Float>, Map<T, Float>, Unit> function22;
                Map anchors$material_release = state.getAnchors$material_release();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterable iterable = possibleStates;
                Function2<T, IntSize, Float> function23 = calculateAnchor;
                for (Object obj : iterable) {
                    Float fInvoke = function23.invoke((T) obj, IntSize.m21130boximpl(j));
                    if (fInvoke != null) {
                        linkedHashMap.put(obj, fInvoke);
                    }
                }
                if (Intrinsics.areEqual(anchors$material_release, linkedHashMap)) {
                    return;
                }
                state.updateAnchors$material_release(linkedHashMap);
                if (anchors$material_release.isEmpty() || (function22 = function2) == 0) {
                    return;
                }
                function22.invoke((Map<T, Float>) anchors$material_release, linkedHashMap);
            }
        });
    }

    public static /* synthetic */ Modifier swipeAnchors$default(Modifier modifier, SwipeableV2State swipeableV2State, Set set, Function2 function2, Function2 function22, int i, Object obj) {
        if ((i & 4) != 0) {
            function2 = null;
        }
        return swipeAnchors(modifier, swipeableV2State, set, function2, function22);
    }

    @ExperimentalMaterialApi
    @NotNull
    public static final <T> Modifier swipeableV2(@NotNull Modifier modifier, @NotNull SwipeableV2State<T> state, @NotNull Orientation orientation, boolean z, boolean z2, @Nullable MutableInteractionSource mutableInteractionSource) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return DraggableKt.draggable$default(modifier, state.getDraggableState$material_release(), orientation, z, mutableInteractionSource, state.isAnimationRunning(), null, new C16431(state, null), z2, 32, null);
    }

    public static /* synthetic */ Modifier swipeableV2$default(Modifier modifier, SwipeableV2State swipeableV2State, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = false;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            mutableInteractionSource = null;
        }
        return swipeableV2(modifier, swipeableV2State, orientation, z3, z4, mutableInteractionSource);
    }

    public static /* synthetic */ Object closestState$default(Map map, float f, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return closestState(map, f, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T closestState(Map<T, Float> map, float f, boolean z) {
        if (!map.isEmpty()) {
            Iterator<T> it = map.entrySet().iterator();
            if (it.hasNext()) {
                T next = it.next();
                if (it.hasNext()) {
                    float fFloatValue = ((Number) ((Map.Entry) next).getValue()).floatValue();
                    float f4 = z ? fFloatValue - f : f - fFloatValue;
                    if (f4 < 0.0f) {
                        f4 = Float.POSITIVE_INFINITY;
                    }
                    do {
                        T next2 = it.next();
                        float fFloatValue2 = ((Number) ((Map.Entry) next2).getValue()).floatValue();
                        float f5 = z ? fFloatValue2 - f : f - fFloatValue2;
                        if (f5 < 0.0f) {
                            f5 = Float.POSITIVE_INFINITY;
                        }
                        if (Float.compare(f4, f5) > 0) {
                            next = next2;
                            f4 = f5;
                        }
                    } while (it.hasNext());
                }
                return (T) ((Map.Entry) next).getKey();
            }
            throw new NoSuchElementException();
        }
        throw new IllegalArgumentException("The anchors were empty when trying to find the closest state");
    }
}
