package androidx.compose.foundation.pager;

import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p109ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p109ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p109ui.input.pointer.PointerEvent;
import androidx.compose.p109ui.input.pointer.PointerEventKt;
import androidx.compose.p109ui.input.pointer.PointerEventPass;
import androidx.compose.p109ui.input.pointer.PointerInputChange;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import androidx.compose.p109ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import com.google.android.gms.drive.DriveFile;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÞ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"21\u0010#\u001a-\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010$¢\u0006\u0002\b'¢\u0006\u0002\b(H\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u0081\u0001\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010\u0004\u001a\u00020\u000521\u0010#\u001a-\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010$¢\u0006\u0002\b'¢\u0006\u0002\b(2#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00182\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100,H\u0003¢\u0006\u0002\u0010/\u001a\u0014\u00100\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061"}, m13886d2 = {"Pager", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Pager-uYRUAWA", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZIFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "rememberPagerItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "pageCount", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "dragDirectionDetector", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyLayoutPager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyLayoutPager.kt\nandroidx/compose/foundation/pager/LazyLayoutPagerKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 Effects.kt\nandroidx/compose/runtime/EffectsKt\n+ 5 Effects.kt\nandroidx/compose/runtime/EffectsKt$rememberCoroutineScope$1\n+ 6 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,397:1\n149#2:398\n1225#3,6:399\n1225#3,3:410\n1228#3,3:416\n1225#3,6:420\n1225#3,6:426\n1225#3,6:433\n1225#3,6:440\n481#4:405\n480#4,4:406\n484#4,2:413\n488#4:419\n480#5:415\n77#6:432\n77#6:439\n*S KotlinDebug\n*F\n+ 1 LazyLayoutPager.kt\nandroidx/compose/foundation/pager/LazyLayoutPagerKt\n*L\n87#1:398\n112#1:399,6\n114#1:410,3\n114#1:416,3\n129#1:420,6\n137#1:426,6\n142#1:433,6\n262#1:440,6\n114#1:405\n114#1:406,4\n114#1:413,2\n114#1:419\n114#1:415\n141#1:432\n173#1:439\n*E\n"})
public final class LazyLayoutPagerKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1", m14021f = "LazyLayoutPager.kt", m14022i = {}, m14023l = {284}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C11711 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PagerState $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1", m14021f = "LazyLayoutPager.kt", m14022i = {}, m14023l = {285}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $$this$pointerInput;
            final /* synthetic */ PagerState $state;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
            @DebugMetadata(m14020c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1", m14021f = "LazyLayoutPager.kt", m14022i = {0, 1, 1, 1}, m14023l = {287, 291}, m14024m = "invokeSuspend", m14025n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "downEvent", "upEventOrCancellation"}, m14026s = {"L$0", "L$0", "L$1", "L$2"})
            @SourceDebugExtension({"SMAP\nLazyLayoutPager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyLayoutPager.kt\nandroidx/compose/foundation/pager/LazyLayoutPagerKt$dragDirectionDetector$1$1$1\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,397:1\n86#2,2:398\n33#2,6:400\n88#2:406\n*S KotlinDebug\n*F\n+ 1 LazyLayoutPager.kt\nandroidx/compose/foundation/pager/LazyLayoutPagerKt$dragDirectionDetector$1$1$1\n*L\n292#1:398,2\n292#1:400,6\n292#1:406\n*E\n"})
            public static final class C145361 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PagerState $state;
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C145361(PagerState pagerState, Continuation<? super C145361> continuation) {
                    super(2, continuation);
                    this.$state = pagerState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    C145361 c145361 = new C145361(this.$state, continuation);
                    c145361.L$0 = obj;
                    return c145361;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((C145361) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
                
                    if (r11 == r0) goto L17;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:16:0x0065, code lost:
                
                    if (r11 == r0) goto L17;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:17:0x0067, code lost:
                
                    return r0;
                 */
                /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
                /* JADX WARN: Removed duplicated region for block: B:25:0x0091  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0065 -> B:18:0x0068). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(@NotNull Object obj) {
                    AwaitPointerEventScope awaitPointerEventScope;
                    AwaitPointerEventScope awaitPointerEventScope2;
                    PointerInputChange pointerInputChange;
                    PointerInputChange pointerInputChange2;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        PointerEventPass pointerEventPass = PointerEventPass.Initial;
                        this.L$0 = awaitPointerEventScope;
                        this.label = 1;
                        obj = TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, false, pointerEventPass, this);
                    } else if (i == 1) {
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        pointerInputChange = (PointerInputChange) this.L$2;
                        pointerInputChange2 = (PointerInputChange) this.L$1;
                        awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        PointerEvent pointerEvent = (PointerEvent) obj;
                        List<PointerInputChange> changes = pointerEvent.getChanges();
                        int size = changes.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                pointerInputChange = pointerEvent.getChanges().get(0);
                                break;
                            }
                            if (!PointerEventKt.changedToUp(changes.get(i2))) {
                                break;
                            }
                            i2++;
                        }
                        if (pointerInputChange == null) {
                            this.$state.m16104setUpDownDifferencek4lQ0M$foundation_release(Offset.m18288minusMKHz9U(pointerInputChange.getPosition(), pointerInputChange2.getPosition()));
                            return Unit.INSTANCE;
                        }
                        PointerEventPass pointerEventPass2 = PointerEventPass.Initial;
                        this.L$0 = awaitPointerEventScope2;
                        this.L$1 = pointerInputChange2;
                        this.L$2 = pointerInputChange;
                        this.label = 2;
                        obj = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass2, this);
                    }
                    this.$state.m16104setUpDownDifferencek4lQ0M$foundation_release(Offset.INSTANCE.m18300getZeroF1C5BW0());
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    pointerInputChange = null;
                    pointerInputChange2 = (PointerInputChange) obj;
                    if (pointerInputChange == null) {
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(PointerInputScope pointerInputScope, PagerState pagerState, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$pointerInput = pointerInputScope;
                this.$state = pagerState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass1(this.$$this$pointerInput, this.$state, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PointerInputScope pointerInputScope = this.$$this$pointerInput;
                    C145361 c145361 = new C145361(this.$state, null);
                    this.label = 1;
                    if (ForEachGestureKt.awaitEachGesture(pointerInputScope, c145361, this) == coroutine_suspended) {
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
        public C11711(PagerState pagerState, Continuation<? super C11711> continuation) {
            super(2, continuation);
            this.$state = pagerState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C11711 c11711 = new C11711(this.$state, continuation);
            c11711.L$0 = obj;
            return c11711;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C11711) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1((PointerInputScope) this.L$0, this.$state, null);
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(anonymousClass1, this) == coroutine_suspended) {
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
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:250:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011c  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Pager-uYRUAWA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16087PageruYRUAWA(@NotNull final Modifier modifier, @NotNull PagerState pagerState, @NotNull final PaddingValues paddingValues, final boolean z, @NotNull final Orientation orientation, @NotNull final TargetedFlingBehavior targetedFlingBehavior, final boolean z2, int i, float f, @NotNull final PageSize pageSize, @NotNull NestedScrollConnection nestedScrollConnection, @Nullable final Function1<? super Integer, ? extends Object> function1, @NotNull final Alignment.Horizontal horizontal, @NotNull final Alignment.Vertical vertical, @NotNull final SnapPosition snapPosition, @NotNull final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, final int i2, final int i4, final int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        final NestedScrollConnection nestedScrollConnection2;
        Composer composer2;
        final int i14;
        final float f4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i15;
        final PagerState pagerState2 = pagerState;
        Composer composerStartRestartGroup = composer.startRestartGroup(538371694);
        if ((i5 & 1) != 0) {
            i6 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i6 = i2;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i2 & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(pagerState2) ? 32 : 16;
        }
        if ((i5 & 4) != 0) {
            i6 |= 384;
        } else {
            if ((i2 & 384) == 0) {
                i6 |= composerStartRestartGroup.changed(paddingValues) ? 256 : 128;
            }
            if ((i5 & 8) == 0) {
                i6 |= 3072;
            } else {
                if ((i2 & 3072) == 0) {
                    i6 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
                }
                if ((i5 & 16) != 0) {
                    i6 |= 24576;
                } else if ((i2 & 24576) == 0) {
                    i6 |= composerStartRestartGroup.changed(orientation) ? 16384 : 8192;
                }
                if ((i5 & 32) != 0) {
                    i6 |= 196608;
                } else if ((i2 & 196608) == 0) {
                    i6 |= composerStartRestartGroup.changed(targetedFlingBehavior) ? 131072 : 65536;
                }
                if ((i5 & 64) == 0) {
                    i15 = (1572864 & i2) == 0 ? composerStartRestartGroup.changed(z2) ? 1048576 : 524288 : 1572864;
                    i7 = i5 & 128;
                    if (i7 == 0) {
                        i6 |= 12582912;
                        i8 = i;
                    } else {
                        i8 = i;
                        if ((i2 & 12582912) == 0) {
                            i6 |= composerStartRestartGroup.changed(i8) ? 8388608 : 4194304;
                        }
                    }
                    i9 = i5 & 256;
                    if (i9 == 0) {
                        i6 |= 100663296;
                    } else if ((i2 & 100663296) == 0) {
                        i6 |= composerStartRestartGroup.changed(f) ? 67108864 : 33554432;
                    }
                    if ((i5 & 512) == 0) {
                        i6 |= DriveFile.MODE_READ_WRITE;
                    } else {
                        if ((805306368 & i2) == 0) {
                            i6 |= composerStartRestartGroup.changed(pageSize) ? 536870912 : 268435456;
                        }
                        if ((i5 & 1024) != 0) {
                            i10 = i4 | 6;
                        } else if ((i4 & 6) == 0) {
                            i10 = (composerStartRestartGroup.changedInstance(nestedScrollConnection) ? 4 : 2) | i4;
                        } else {
                            i10 = i4;
                        }
                        int i16 = i10;
                        if ((i5 & 2048) != 0) {
                            i11 = i16 | 48;
                        } else if ((i4 & 48) == 0) {
                            i11 = i16 | (composerStartRestartGroup.changedInstance(function1) ? 32 : 16);
                        } else {
                            i11 = i16;
                        }
                        if ((i5 & 4096) != 0) {
                            i11 |= 384;
                        } else {
                            if ((i4 & 384) == 0) {
                                i11 |= composerStartRestartGroup.changed(horizontal) ? 256 : 128;
                            }
                            if ((i5 & 8192) == 0) {
                                i11 |= 3072;
                            } else {
                                if ((i4 & 3072) == 0) {
                                    i11 |= composerStartRestartGroup.changed(vertical) ? 2048 : 1024;
                                }
                                if ((i5 & 16384) == 0) {
                                    if ((i4 & 24576) == 0) {
                                        i11 |= composerStartRestartGroup.changed(snapPosition) ? 16384 : 8192;
                                    }
                                    if ((i5 & 32768) == 0) {
                                        i12 = i11 | 196608;
                                    } else {
                                        int i17 = i11;
                                        if ((i4 & 196608) == 0) {
                                            i12 = i17 | (composerStartRestartGroup.changedInstance(function4) ? 131072 : 65536);
                                        } else {
                                            i12 = i17;
                                        }
                                    }
                                    if ((i6 & 306783379) != 306783378 && (74899 & i12) == 74898 && composerStartRestartGroup.getSkipping()) {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        f4 = f;
                                        nestedScrollConnection2 = nestedScrollConnection;
                                        composer2 = composerStartRestartGroup;
                                        i14 = i8;
                                    } else {
                                        i13 = i7 == 0 ? 0 : i8;
                                        float fM20968constructorimpl = i9 == 0 ? C2256Dp.m20968constructorimpl(0) : f;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(538371694, i6, i12, "androidx.compose.foundation.pager.Pager (LazyLayoutPager.kt:101)");
                                        }
                                        if (i13 >= 0) {
                                            throw new IllegalArgumentException(AbstractC0000a.m11h(i13, "beyondViewportPageCount should be greater than or equal to 0, you selected ").toString());
                                        }
                                        int i18 = i6 & 112;
                                        boolean z3 = i18 == 32;
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = new Function0<Integer>() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$pagerItemProvider$1$1
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                @NotNull
                                                public final Integer invoke() {
                                                    return Integer.valueOf(pagerState2.getPageCount());
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        int i19 = i6 >> 3;
                                        int i20 = i12;
                                        int i21 = i19 & 14;
                                        int i22 = i20 >> 12;
                                        int i23 = i6;
                                        Function0<PagerLazyLayoutItemProvider> function0RememberPagerItemProviderLambda = rememberPagerItemProviderLambda(pagerState2, function4, function1, (Function0) objRememberedValue, composerStartRestartGroup, i21 | (i22 & 112) | ((i20 << 3) & 896));
                                        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        Composer.Companion companion = Composer.INSTANCE;
                                        if (objRememberedValue2 == companion.getEmpty()) {
                                            objRememberedValue2 = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup), composerStartRestartGroup);
                                        }
                                        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                                        boolean z4 = i18 == 32;
                                        Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (z4 || objRememberedValue3 == companion.getEmpty()) {
                                            objRememberedValue3 = new Function0<Integer>() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$measurePolicy$1$1
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                @NotNull
                                                public final Integer invoke() {
                                                    return Integer.valueOf(pagerState2.getPageCount());
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                        }
                                        int i24 = i23 & 7168;
                                        int i25 = i23 >> 6;
                                        int i26 = i20 << 18;
                                        float f5 = fM20968constructorimpl;
                                        int i27 = i13;
                                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2M16097rememberPagerMeasurePolicy8u0NR3k = PagerMeasurePolicyKt.m16097rememberPagerMeasurePolicy8u0NR3k(function0RememberPagerItemProviderLambda, pagerState2, paddingValues, z, orientation, i27, f5, pageSize, horizontal, vertical, snapPosition, coroutineScope, (Function0) objRememberedValue3, composerStartRestartGroup, (i23 & 65520) | (i25 & 458752) | (i25 & 3670016) | (i25 & 29360128) | (i26 & 234881024) | (i26 & 1879048192), i22 & 14);
                                        Orientation orientation2 = Orientation.Vertical;
                                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberPagerSemanticState = PagerSemanticsKt.rememberPagerSemanticState(pagerState2, orientation == orientation2, composerStartRestartGroup, i21);
                                        boolean z5 = (i18 == 32) | ((i23 & 458752) == 131072);
                                        Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                        if (z5 || objRememberedValue4 == companion.getEmpty()) {
                                            objRememberedValue4 = new PagerWrapperFlingBehavior(targetedFlingBehavior, pagerState2);
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                        }
                                        PagerWrapperFlingBehavior pagerWrapperFlingBehavior = (PagerWrapperFlingBehavior) objRememberedValue4;
                                        BringIntoViewSpec bringIntoViewSpec = (BringIntoViewSpec) composerStartRestartGroup.consume(BringIntoViewSpec_androidKt.getLocalBringIntoViewSpec());
                                        boolean zChanged = (i18 == 32) | composerStartRestartGroup.changed(bringIntoViewSpec);
                                        Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                        if (zChanged || objRememberedValue5 == companion.getEmpty()) {
                                            objRememberedValue5 = new PagerBringIntoViewSpec(pagerState2, bringIntoViewSpec);
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                        }
                                        PagerBringIntoViewSpec pagerBringIntoViewSpec = (PagerBringIntoViewSpec) objRememberedValue5;
                                        Modifier modifierLazyLayoutSemantics = LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(pagerState2.getRemeasurementModifier()).then(pagerState2.getAwaitLayoutModifier()), function0RememberPagerItemProviderLambda, lazyLayoutSemanticStateRememberPagerSemanticState, orientation, z2, z, composerStartRestartGroup, (i19 & 7168) | (i25 & 57344) | ((i23 << 6) & 458752));
                                        boolean z6 = orientation == orientation2;
                                        int i28 = i23 << 3;
                                        Modifier modifierScrollingContainer = ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(PagerKt.pagerSemantics(modifierLazyLayoutSemantics, pagerState2, z6, coroutineScope, z2), PagerBeyondBoundsModifierKt.rememberPagerBeyondBoundsState(pagerState2, i27, composerStartRestartGroup, i21 | ((i23 >> 18) & 112)), pagerState2.getBeyondBoundsInfo(), z, (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation, z2, composerStartRestartGroup, (i23 & 3670016) | (MutableVector.$stable << 6) | i24 | (i28 & 458752)), pagerState2, orientation, z2, z, pagerWrapperFlingBehavior, pagerState2.getInternalInteractionSource(), pagerBringIntoViewSpec, composerStartRestartGroup, i18 | (i25 & 896) | ((i23 >> 9) & 7168) | (57344 & i28), 0);
                                        pagerState2 = pagerState2;
                                        nestedScrollConnection2 = nestedScrollConnection;
                                        LazyLayoutKt.LazyLayout(function0RememberPagerItemProviderLambda, NestedScrollModifierKt.nestedScroll$default(dragDirectionDetector(modifierScrollingContainer, pagerState2), nestedScrollConnection2, null, 2, null), pagerState2.getPrefetchState(), function2M16097rememberPagerMeasurePolicy8u0NR3k, composerStartRestartGroup, 0, 0);
                                        composer2 = composerStartRestartGroup;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        i14 = i27;
                                        f4 = f5;
                                    }
                                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup == null) {
                                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(@Nullable Composer composer3, int i29) {
                                                LazyLayoutPagerKt.m16087PageruYRUAWA(modifier, pagerState2, paddingValues, z, orientation, targetedFlingBehavior, z2, i14, f4, pageSize, nestedScrollConnection2, function1, horizontal, vertical, snapPosition, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i11 |= 24576;
                                if ((i5 & 32768) == 0) {
                                }
                                if ((i6 & 306783379) != 306783378) {
                                    if (i7 == 0) {
                                    }
                                    if (i9 == 0) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    if (i13 >= 0) {
                                    }
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                }
                            }
                            if ((i5 & 16384) == 0) {
                            }
                            if ((i5 & 32768) == 0) {
                            }
                            if ((i6 & 306783379) != 306783378) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                            }
                        }
                        if ((i5 & 8192) == 0) {
                        }
                        if ((i5 & 16384) == 0) {
                        }
                        if ((i5 & 32768) == 0) {
                        }
                        if ((i6 & 306783379) != 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    if ((i5 & 1024) != 0) {
                    }
                    int i162 = i10;
                    if ((i5 & 2048) != 0) {
                    }
                    if ((i5 & 4096) != 0) {
                    }
                    if ((i5 & 8192) == 0) {
                    }
                    if ((i5 & 16384) == 0) {
                    }
                    if ((i5 & 32768) == 0) {
                    }
                    if ((i6 & 306783379) != 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i6 |= i15;
                i7 = i5 & 128;
                if (i7 == 0) {
                }
                i9 = i5 & 256;
                if (i9 == 0) {
                }
                if ((i5 & 512) == 0) {
                }
                if ((i5 & 1024) != 0) {
                }
                int i1622 = i10;
                if ((i5 & 2048) != 0) {
                }
                if ((i5 & 4096) != 0) {
                }
                if ((i5 & 8192) == 0) {
                }
                if ((i5 & 16384) == 0) {
                }
                if ((i5 & 32768) == 0) {
                }
                if ((i6 & 306783379) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            if ((i5 & 16) != 0) {
            }
            if ((i5 & 32) != 0) {
            }
            if ((i5 & 64) == 0) {
            }
            i6 |= i15;
            i7 = i5 & 128;
            if (i7 == 0) {
            }
            i9 = i5 & 256;
            if (i9 == 0) {
            }
            if ((i5 & 512) == 0) {
            }
            if ((i5 & 1024) != 0) {
            }
            int i16222 = i10;
            if ((i5 & 2048) != 0) {
            }
            if ((i5 & 4096) != 0) {
            }
            if ((i5 & 8192) == 0) {
            }
            if ((i5 & 16384) == 0) {
            }
            if ((i5 & 32768) == 0) {
            }
            if ((i6 & 306783379) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i5 & 8) == 0) {
        }
        if ((i5 & 16) != 0) {
        }
        if ((i5 & 32) != 0) {
        }
        if ((i5 & 64) == 0) {
        }
        i6 |= i15;
        i7 = i5 & 128;
        if (i7 == 0) {
        }
        i9 = i5 & 256;
        if (i9 == 0) {
        }
        if ((i5 & 512) == 0) {
        }
        if ((i5 & 1024) != 0) {
        }
        int i162222 = i10;
        if ((i5 & 2048) != 0) {
        }
        if ((i5 & 4096) != 0) {
        }
        if ((i5 & 8192) == 0) {
        }
        if ((i5 & 16384) == 0) {
        }
        if ((i5 & 32768) == 0) {
        }
        if ((i6 & 306783379) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final Modifier dragDirectionDetector(Modifier modifier, PagerState pagerState) {
        return modifier.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, pagerState, new C11711(pagerState, null)));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    private static final Function0<PagerLazyLayoutItemProvider> rememberPagerItemProviderLambda(final PagerState pagerState, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Function1<? super Integer, ? extends Object> function1, final Function0<Integer> function0, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1372505274, i, -1, "androidx.compose.foundation.pager.rememberPagerItemProviderLambda (LazyLayoutPager.kt:258)");
        }
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composer, (i >> 3) & 14);
        final State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function1, composer, (i >> 6) & 14);
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer.changed(pagerState)) || (i & 6) == 4) | composer.changed(stateRememberUpdatedState) | composer.changed(stateRememberUpdatedState2) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(function0)) || (i & 3072) == 2048);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            final State stateDerivedStateOf = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new Function0<PagerLayoutIntervalContent>() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$intervalContentState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final PagerLayoutIntervalContent invoke() {
                    return new PagerLayoutIntervalContent(stateRememberUpdatedState.getValue(), stateRememberUpdatedState2.getValue(), function0.invoke().intValue());
                }
            });
            final State stateDerivedStateOf2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new Function0<PagerLazyLayoutItemProvider>() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$itemProviderState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final PagerLazyLayoutItemProvider invoke() {
                    PagerLayoutIntervalContent value = stateDerivedStateOf.getValue();
                    return new PagerLazyLayoutItemProvider(pagerState, value, new NearestRangeKeyIndexMap(pagerState.getNearestRange$foundation_release(), value));
                }
            });
            objRememberedValue = new PropertyReference0Impl(stateDerivedStateOf2) { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$1
                @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                @Nullable
                public Object get() {
                    return ((State) this.receiver).getValue();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        KProperty0 kProperty0 = (KProperty0) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return kProperty0;
    }
}
