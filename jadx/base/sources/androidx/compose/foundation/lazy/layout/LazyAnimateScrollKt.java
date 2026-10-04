package androidx.compose.foundation.lazy.layout;

import androidx.collection.AbstractC0622a;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import com.android.volley.DefaultRetryPolicy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import opennlp.tools.tokenize.TokenizerME;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0082\b\u001a2\u0010\f\u001a\u00020\b*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0080@¢\u0006\u0002\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0016"}, m13886d2 = {"BoundDistance", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "DEBUG", "", "MinimumDistance", "TargetDistance", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "animateScrollToItem", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "index", "", "scrollOffset", "numOfItemsForTeleport", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;IIILandroidx/compose/ui/unit/Density;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isItemVisible", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyAnimateScroll.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyAnimateScroll.kt\nandroidx/compose/foundation/lazy/layout/LazyAnimateScrollKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,309:1\n149#2:310\n149#2:311\n149#2:312\n*S KotlinDebug\n*F\n+ 1 LazyAnimateScroll.kt\nandroidx/compose/foundation/lazy/layout/LazyAnimateScrollKt\n*L\n36#1:310\n37#1:311\n38#1:312\n*E\n"})
public final class LazyAnimateScrollKt {
    private static final boolean DEBUG = false;
    private static final float TargetDistance = C2256Dp.m20968constructorimpl(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS);
    private static final float BoundDistance = C2256Dp.m20968constructorimpl(1500);
    private static final float MinimumDistance = C2256Dp.m20968constructorimpl(50);

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2", m14021f = "LazyAnimateScroll.kt", m14022i = {0, 0, 0, 0, 0, 0, 0, 0, 1}, m14023l = {174, 272}, m14024m = "invokeSuspend", m14025n = {"$this$scroll", "loop", "anim", "loops", "targetDistancePx", "boundDistancePx", "minDistancePx", "forward", "$this$scroll"}, m14026s = {"L$0", "L$1", "L$2", "L$3", "F$0", "F$1", "F$2", "I$0", "L$0"})
    @SourceDebugExtension({"SMAP\nLazyAnimateScroll.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyAnimateScroll.kt\nandroidx/compose/foundation/lazy/layout/LazyAnimateScrollKt$animateScrollToItem$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 LazyAnimateScroll.kt\nandroidx/compose/foundation/lazy/layout/LazyAnimateScrollKt\n*L\n1#1,309:1\n1#2:310\n42#3,4:311\n42#3,4:315\n*S KotlinDebug\n*F\n+ 1 LazyAnimateScroll.kt\nandroidx/compose/foundation/lazy/layout/LazyAnimateScrollKt$animateScrollToItem$2\n*L\n166#1:311,4\n269#1:315,4\n*E\n"})
    public static final class C11122 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Density $density;
        final /* synthetic */ int $index;
        final /* synthetic */ int $numOfItemsForTeleport;
        final /* synthetic */ int $scrollOffset;
        final /* synthetic */ LazyLayoutAnimateScrollScope $this_animateScrollToItem;
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11122(int i, Density density, LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i2, int i4, Continuation<? super C11122> continuation) {
            super(2, continuation);
            this.$index = i;
            this.$density = density;
            this.$this_animateScrollToItem = lazyLayoutAnimateScrollScope;
            this.$scrollOffset = i2;
            this.$numOfItemsForTeleport = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$isOvershot(boolean z, LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i, int i2) {
            if (z) {
                if (lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() > i) {
                    return true;
                }
                return lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() == i && lazyLayoutAnimateScrollScope.getFirstVisibleItemScrollOffset() > i2;
            }
            if (lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() < i) {
                return true;
            }
            return lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() == i && lazyLayoutAnimateScrollScope.getFirstVisibleItemScrollOffset() < i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C11122 c11122 = new C11122(this.$index, this.$density, this.$this_animateScrollToItem, this.$scrollOffset, this.$numOfItemsForTeleport, continuation);
            c11122.L$0 = obj;
            return c11122;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull ScrollScope scrollScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C11122) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00c9 A[Catch: ItemFoundInScroll -> 0x00f4, TryCatch #2 {ItemFoundInScroll -> 0x00f4, blocks: (B:27:0x00c5, B:29:0x00c9, B:31:0x00d1, B:33:0x00e5, B:43:0x0102, B:47:0x013f), top: B:92:0x00c5 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00e5 A[Catch: ItemFoundInScroll -> 0x00f4, TryCatch #2 {ItemFoundInScroll -> 0x00f4, blocks: (B:27:0x00c5, B:29:0x00c9, B:31:0x00d1, B:33:0x00e5, B:43:0x0102, B:47:0x013f), top: B:92:0x00c5 }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00fb  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x013c  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x013e  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x014a  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x014d  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x018f  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0191  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x01ff  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0201  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x0222  */
        /* JADX WARN: Type inference failed for: r1v14, types: [T, androidx.compose.animation.core.AnimationState] */
        /* JADX WARN: Type inference failed for: r7v0, types: [T, androidx.compose.animation.core.AnimationState] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0191 -> B:90:0x0197). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            float f;
            final ScrollScope scrollScope;
            float fMo15546toPx0680j_4;
            float fMo15546toPx0680j_42;
            float fMo15546toPx0680j_43;
            Ref.BooleanRef booleanRef;
            Ref.ObjectRef objectRef;
            final ScrollScope scrollScope2;
            final float f4;
            float f5;
            final Ref.IntRef intRef;
            int i;
            AnimationState animationStateCopy$default;
            Float fBoxFloat;
            boolean z;
            Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1;
            ScrollScope scrollScope3;
            float fCalculateDistanceTo;
            float fMax;
            final float f6;
            AnimationState animationState;
            Float fBoxFloat2;
            boolean z2;
            Function1<AnimationScope<Float, AnimationVector1D>, Unit> function12;
            ScrollScope scrollScope4;
            Ref.IntRef intRef2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            float f7 = 0.0f;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    scrollScope3 = (ScrollScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    this.$this_animateScrollToItem.snapToItem(scrollScope3, this.$index, this.$scrollOffset);
                    return Unit.INSTANCE;
                }
                int i4 = this.I$0;
                float f8 = this.F$2;
                float f9 = this.F$1;
                float f10 = this.F$0;
                Ref.IntRef intRef3 = (Ref.IntRef) this.L$3;
                objectRef = (Ref.ObjectRef) this.L$2;
                Ref.BooleanRef booleanRef2 = (Ref.BooleanRef) this.L$1;
                scrollScope = (ScrollScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    f5 = f8;
                    f4 = f9;
                    f = 0.0f;
                    scrollScope2 = scrollScope;
                    i = i4;
                    fMo15546toPx0680j_4 = f10;
                    intRef2 = intRef3;
                    booleanRef = booleanRef2;
                    try {
                        try {
                            intRef2.element++;
                        } catch (ItemFoundInScroll e) {
                            e = e;
                            scrollScope = scrollScope2;
                            animationStateCopy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                            final float itemOffset = e.getItemOffset() + this.$scrollOffset;
                            final Ref.FloatRef floatRef = new Ref.FloatRef();
                            fBoxFloat = Boxing.boxFloat(itemOffset);
                            if (((Number) animationStateCopy$default.getVelocity()).floatValue() != f) {
                            }
                            function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.animateScrollToItem.2.5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                    invoke2(animationScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull AnimationScope<Float, AnimationVector1D> animationScope) {
                                    float f11 = itemOffset;
                                    float fCoerceAtLeast = 0.0f;
                                    if (f11 > 0.0f) {
                                        fCoerceAtLeast = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), itemOffset);
                                    } else if (f11 < 0.0f) {
                                        fCoerceAtLeast = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), itemOffset);
                                    }
                                    float f12 = fCoerceAtLeast - floatRef.element;
                                    if (f12 != scrollScope.scrollBy(f12) || fCoerceAtLeast != animationScope.getValue().floatValue()) {
                                        animationScope.cancelAnimation();
                                    }
                                    floatRef.element += f12;
                                }
                            };
                            this.L$0 = scrollScope;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 2;
                            if (SuspendAnimationKt.animateTo$default(animationStateCopy$default, fBoxFloat, null, !z, function1, this, 2, null) != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        }
                    } catch (ItemFoundInScroll e2) {
                        e = e2;
                        f = f7;
                    }
                    intRef = intRef2;
                    f7 = f;
                } catch (ItemFoundInScroll e3) {
                    e = e3;
                    f = 0.0f;
                    animationStateCopy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                    final float itemOffset2 = e.getItemOffset() + this.$scrollOffset;
                    final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                    fBoxFloat = Boxing.boxFloat(itemOffset2);
                    if (((Number) animationStateCopy$default.getVelocity()).floatValue() != f) {
                    }
                    function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.animateScrollToItem.2.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            invoke2(animationScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull AnimationScope<Float, AnimationVector1D> animationScope) {
                            float f11 = itemOffset2;
                            float fCoerceAtLeast = 0.0f;
                            if (f11 > 0.0f) {
                                fCoerceAtLeast = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), itemOffset2);
                            } else if (f11 < 0.0f) {
                                fCoerceAtLeast = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), itemOffset2);
                            }
                            float f12 = fCoerceAtLeast - floatRef2.element;
                            if (f12 != scrollScope.scrollBy(f12) || fCoerceAtLeast != animationScope.getValue().floatValue()) {
                                animationScope.cancelAnimation();
                            }
                            floatRef2.element += f12;
                        }
                    };
                    this.L$0 = scrollScope;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 2;
                    if (SuspendAnimationKt.animateTo$default(animationStateCopy$default, fBoxFloat, null, !z, function1, this, 2, null) != coroutine_suspended) {
                    }
                }
                if (booleanRef.element && this.$this_animateScrollToItem.getItemCount() > 0) {
                    try {
                        fCalculateDistanceTo = this.$this_animateScrollToItem.calculateDistanceTo(this.$index) + this.$scrollOffset;
                    } catch (ItemFoundInScroll e5) {
                        e = e5;
                        scrollScope2 = scrollScope4;
                        scrollScope = scrollScope2;
                        animationStateCopy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                        final float itemOffset22 = e.getItemOffset() + this.$scrollOffset;
                        final Ref.FloatRef floatRef22 = new Ref.FloatRef();
                        fBoxFloat = Boxing.boxFloat(itemOffset22);
                        if (((Number) animationStateCopy$default.getVelocity()).floatValue() != f) {
                        }
                        function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.animateScrollToItem.2.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                invoke2(animationScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull AnimationScope<Float, AnimationVector1D> animationScope) {
                                float f11 = itemOffset22;
                                float fCoerceAtLeast = 0.0f;
                                if (f11 > 0.0f) {
                                    fCoerceAtLeast = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), itemOffset22);
                                } else if (f11 < 0.0f) {
                                    fCoerceAtLeast = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), itemOffset22);
                                }
                                float f12 = fCoerceAtLeast - floatRef22.element;
                                if (f12 != scrollScope.scrollBy(f12) || fCoerceAtLeast != animationScope.getValue().floatValue()) {
                                    animationScope.cancelAnimation();
                                }
                                floatRef22.element += f12;
                            }
                        };
                        this.L$0 = scrollScope;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 2;
                        if (SuspendAnimationKt.animateTo$default(animationStateCopy$default, fBoxFloat, null, !z, function1, this, 2, null) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    if (Math.abs(fCalculateDistanceTo) < fMo15546toPx0680j_4) {
                        if (i != 0) {
                            f6 = fMo15546toPx0680j_4;
                            objectRef.element = AnimationStateKt.copy$default((AnimationState) objectRef.element, 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                            final Ref.FloatRef floatRef3 = new Ref.FloatRef();
                            animationState = (AnimationState) objectRef.element;
                            fBoxFloat2 = Boxing.boxFloat(f6);
                            z2 = !(((Number) ((AnimationState) objectRef.element).getVelocity()).floatValue() != f7);
                            final LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope = this.$this_animateScrollToItem;
                            f = f7;
                            final int i5 = this.$index;
                            final boolean z3 = i == 0;
                            final int i6 = this.$numOfItemsForTeleport;
                            final int i7 = this.$scrollOffset;
                            final Ref.BooleanRef booleanRef3 = booleanRef;
                            final Ref.ObjectRef objectRef2 = objectRef;
                            function12 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.animateScrollToItem.2.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                    invoke2(animationScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull AnimationScope<Float, AnimationVector1D> animationScope) {
                                    if (!LazyAnimateScrollKt.isItemVisible(lazyLayoutAnimateScrollScope, i5)) {
                                        float fCoerceAtMost = (f6 > 0.0f ? RangesKt.coerceAtMost(animationScope.getValue().floatValue(), f6) : RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), f6)) - floatRef3.element;
                                        float fScrollBy = scrollScope2.scrollBy(fCoerceAtMost);
                                        if (!LazyAnimateScrollKt.isItemVisible(lazyLayoutAnimateScrollScope, i5) && !C11122.invokeSuspend$isOvershot(z3, lazyLayoutAnimateScrollScope, i5, i7)) {
                                            if (fCoerceAtMost != fScrollBy) {
                                                animationScope.cancelAnimation();
                                                booleanRef3.element = false;
                                                return;
                                            }
                                            floatRef3.element += fCoerceAtMost;
                                            if (z3) {
                                                if (animationScope.getValue().floatValue() > f4) {
                                                    animationScope.cancelAnimation();
                                                }
                                            } else if (animationScope.getValue().floatValue() < (-f4)) {
                                                animationScope.cancelAnimation();
                                            }
                                            if (z3) {
                                                if (intRef.element >= 2) {
                                                    int lastVisibleItemIndex = i5 - lazyLayoutAnimateScrollScope.getLastVisibleItemIndex();
                                                    int i8 = i6;
                                                    if (lastVisibleItemIndex > i8) {
                                                        lazyLayoutAnimateScrollScope.snapToItem(scrollScope2, i5 - i8, 0);
                                                    }
                                                }
                                            } else if (intRef.element >= 2) {
                                                int firstVisibleItemIndex = lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex();
                                                int i9 = i5;
                                                int i10 = firstVisibleItemIndex - i9;
                                                int i11 = i6;
                                                if (i10 > i11) {
                                                    lazyLayoutAnimateScrollScope.snapToItem(scrollScope2, i9 + i11, 0);
                                                }
                                            }
                                        }
                                    }
                                    if (!C11122.invokeSuspend$isOvershot(z3, lazyLayoutAnimateScrollScope, i5, i7)) {
                                        if (LazyAnimateScrollKt.isItemVisible(lazyLayoutAnimateScrollScope, i5)) {
                                            throw new ItemFoundInScroll(MathKt.roundToInt(lazyLayoutAnimateScrollScope.calculateDistanceTo(i5)), objectRef2.element);
                                        }
                                    } else {
                                        lazyLayoutAnimateScrollScope.snapToItem(scrollScope2, i5, i7);
                                        booleanRef3.element = false;
                                        animationScope.cancelAnimation();
                                    }
                                }
                            };
                            scrollScope4 = scrollScope2;
                            float f11 = f4;
                            intRef2 = intRef;
                            this.L$0 = scrollScope4;
                            this.L$1 = booleanRef3;
                            this.L$2 = objectRef2;
                            this.L$3 = intRef2;
                            this.F$0 = fMo15546toPx0680j_4;
                            this.F$1 = f11;
                            this.F$2 = f5;
                            this.I$0 = i;
                            this.label = 1;
                            float f12 = fMo15546toPx0680j_4;
                            scrollScope2 = scrollScope4;
                            if (SuspendAnimationKt.animateTo$default(animationState, fBoxFloat2, null, z2, function12, this, 2, null) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            f4 = f11;
                            objectRef = objectRef2;
                            booleanRef = booleanRef3;
                            fMo15546toPx0680j_4 = f12;
                            intRef2.element++;
                            intRef = intRef2;
                            f7 = f;
                            if (booleanRef.element) {
                                fCalculateDistanceTo = this.$this_animateScrollToItem.calculateDistanceTo(this.$index) + this.$scrollOffset;
                                if (Math.abs(fCalculateDistanceTo) < fMo15546toPx0680j_4) {
                                    fMax = Math.max(Math.abs(fCalculateDistanceTo), f5);
                                    if (i == 0) {
                                        fMax = -fMax;
                                    }
                                }
                            }
                        } else {
                            fMax = -fMo15546toPx0680j_4;
                        }
                    }
                    f6 = fMax;
                    objectRef.element = AnimationStateKt.copy$default((AnimationState) objectRef.element, 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                    final Ref.FloatRef floatRef32 = new Ref.FloatRef();
                    animationState = (AnimationState) objectRef.element;
                    fBoxFloat2 = Boxing.boxFloat(f6);
                    z2 = !(((Number) ((AnimationState) objectRef.element).getVelocity()).floatValue() != f7);
                    final LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope2 = this.$this_animateScrollToItem;
                    f = f7;
                    final int i52 = this.$index;
                    if (i == 0) {
                    }
                    final int i62 = this.$numOfItemsForTeleport;
                    final int i72 = this.$scrollOffset;
                    final Ref.BooleanRef booleanRef32 = booleanRef;
                    final Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> objectRef22 = objectRef;
                    function12 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.animateScrollToItem.2.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            invoke2(animationScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull AnimationScope<Float, AnimationVector1D> animationScope) {
                            if (!LazyAnimateScrollKt.isItemVisible(lazyLayoutAnimateScrollScope2, i52)) {
                                float fCoerceAtMost = (f6 > 0.0f ? RangesKt.coerceAtMost(animationScope.getValue().floatValue(), f6) : RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), f6)) - floatRef32.element;
                                float fScrollBy = scrollScope2.scrollBy(fCoerceAtMost);
                                if (!LazyAnimateScrollKt.isItemVisible(lazyLayoutAnimateScrollScope2, i52) && !C11122.invokeSuspend$isOvershot(z3, lazyLayoutAnimateScrollScope2, i52, i72)) {
                                    if (fCoerceAtMost != fScrollBy) {
                                        animationScope.cancelAnimation();
                                        booleanRef32.element = false;
                                        return;
                                    }
                                    floatRef32.element += fCoerceAtMost;
                                    if (z3) {
                                        if (animationScope.getValue().floatValue() > f4) {
                                            animationScope.cancelAnimation();
                                        }
                                    } else if (animationScope.getValue().floatValue() < (-f4)) {
                                        animationScope.cancelAnimation();
                                    }
                                    if (z3) {
                                        if (intRef.element >= 2) {
                                            int lastVisibleItemIndex = i52 - lazyLayoutAnimateScrollScope2.getLastVisibleItemIndex();
                                            int i8 = i62;
                                            if (lastVisibleItemIndex > i8) {
                                                lazyLayoutAnimateScrollScope2.snapToItem(scrollScope2, i52 - i8, 0);
                                            }
                                        }
                                    } else if (intRef.element >= 2) {
                                        int firstVisibleItemIndex = lazyLayoutAnimateScrollScope2.getFirstVisibleItemIndex();
                                        int i9 = i52;
                                        int i10 = firstVisibleItemIndex - i9;
                                        int i11 = i62;
                                        if (i10 > i11) {
                                            lazyLayoutAnimateScrollScope2.snapToItem(scrollScope2, i9 + i11, 0);
                                        }
                                    }
                                }
                            }
                            if (!C11122.invokeSuspend$isOvershot(z3, lazyLayoutAnimateScrollScope2, i52, i72)) {
                                if (LazyAnimateScrollKt.isItemVisible(lazyLayoutAnimateScrollScope2, i52)) {
                                    throw new ItemFoundInScroll(MathKt.roundToInt(lazyLayoutAnimateScrollScope2.calculateDistanceTo(i52)), objectRef22.element);
                                }
                            } else {
                                lazyLayoutAnimateScrollScope2.snapToItem(scrollScope2, i52, i72);
                                booleanRef32.element = false;
                                animationScope.cancelAnimation();
                            }
                        }
                    };
                    scrollScope4 = scrollScope2;
                    float f112 = f4;
                    intRef2 = intRef;
                    this.L$0 = scrollScope4;
                    this.L$1 = booleanRef32;
                    this.L$2 = objectRef22;
                    this.L$3 = intRef2;
                    this.F$0 = fMo15546toPx0680j_4;
                    this.F$1 = f112;
                    this.F$2 = f5;
                    this.I$0 = i;
                    this.label = 1;
                    float f122 = fMo15546toPx0680j_4;
                    scrollScope2 = scrollScope4;
                    if (SuspendAnimationKt.animateTo$default(animationState, fBoxFloat2, null, z2, function12, this, 2, null) != coroutine_suspended) {
                    }
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            ScrollScope scrollScope5 = (ScrollScope) this.L$0;
            int i8 = this.$index;
            if (!(((float) i8) >= 0.0f)) {
                throw new IllegalArgumentException(AbstractC0622a.m1167m("Index should be non-negative (", i8, PropertyUtils.MAPPED_DELIM2).toString());
            }
            try {
                fMo15546toPx0680j_4 = this.$density.mo15546toPx0680j_4(LazyAnimateScrollKt.TargetDistance);
                fMo15546toPx0680j_42 = this.$density.mo15546toPx0680j_4(LazyAnimateScrollKt.BoundDistance);
                fMo15546toPx0680j_43 = this.$density.mo15546toPx0680j_4(LazyAnimateScrollKt.MinimumDistance);
                booleanRef = new Ref.BooleanRef();
                booleanRef.element = true;
                objectRef = new Ref.ObjectRef();
                objectRef.element = AnimationStateKt.AnimationState$default(0.0f, 0.0f, 0L, 0L, false, 30, null);
            } catch (ItemFoundInScroll e6) {
                e = e6;
                f = 0.0f;
            }
            if (!LazyAnimateScrollKt.isItemVisible(this.$this_animateScrollToItem, this.$index)) {
                int i9 = this.$index > this.$this_animateScrollToItem.getFirstVisibleItemIndex() ? 1 : 0;
                Ref.IntRef intRef4 = new Ref.IntRef();
                intRef4.element = 1;
                scrollScope2 = scrollScope5;
                f4 = fMo15546toPx0680j_42;
                f5 = fMo15546toPx0680j_43;
                intRef = intRef4;
                i = i9;
                if (booleanRef.element) {
                }
                return Unit.INSTANCE;
            }
            f = 0.0f;
            try {
                throw new ItemFoundInScroll(MathKt.roundToInt(this.$this_animateScrollToItem.calculateDistanceTo(this.$index)), (AnimationState) objectRef.element);
            } catch (ItemFoundInScroll e7) {
                e = e7;
            }
            scrollScope = scrollScope5;
            animationStateCopy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
            final float itemOffset222 = e.getItemOffset() + this.$scrollOffset;
            final Ref.FloatRef floatRef222 = new Ref.FloatRef();
            fBoxFloat = Boxing.boxFloat(itemOffset222);
            z = ((Number) animationStateCopy$default.getVelocity()).floatValue() != f;
            function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.animateScrollToItem.2.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                    invoke2(animationScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull AnimationScope<Float, AnimationVector1D> animationScope) {
                    float f113 = itemOffset222;
                    float fCoerceAtLeast = 0.0f;
                    if (f113 > 0.0f) {
                        fCoerceAtLeast = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), itemOffset222);
                    } else if (f113 < 0.0f) {
                        fCoerceAtLeast = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), itemOffset222);
                    }
                    float f123 = fCoerceAtLeast - floatRef222.element;
                    if (f123 != scrollScope.scrollBy(f123) || fCoerceAtLeast != animationScope.getValue().floatValue()) {
                        animationScope.cancelAnimation();
                    }
                    floatRef222.element += f123;
                }
            };
            this.L$0 = scrollScope;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 2;
            if (SuspendAnimationKt.animateTo$default(animationStateCopy$default, fBoxFloat, null, !z, function1, this, 2, null) != coroutine_suspended) {
                scrollScope3 = scrollScope;
                this.$this_animateScrollToItem.snapToItem(scrollScope3, this.$index, this.$scrollOffset);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
    }

    @Nullable
    public static final Object animateScrollToItem(@NotNull LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i, int i2, int i4, @NotNull Density density, @NotNull Continuation<? super Unit> continuation) {
        Object objScroll = lazyLayoutAnimateScrollScope.scroll(new C11122(i, density, lazyLayoutAnimateScrollScope, i2, i4, null), continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }

    public static final boolean isItemVisible(@NotNull LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i) {
        return i <= lazyLayoutAnimateScrollScope.getLastVisibleItemIndex() && lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() <= i;
    }

    private static final void debugLog(Function0<String> function0) {
    }
}
