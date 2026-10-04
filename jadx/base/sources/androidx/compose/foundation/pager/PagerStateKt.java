package androidx.compose.foundation.pager;

import androidx.annotation.FloatRange;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import androidx.compose.p109ui.layout.AlignmentLine;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000m\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\r\u001a(\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0003\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015\u001a\u0017\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0015H\u0082\b\u001a/\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0003\u0010\u001c\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015H\u0007¢\u0006\u0002\u0010\u001d\u001aO\u0010\u001e\u001a\u00020\u0017*\u00020\u001f2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00132\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130#2\u001d\u0010$\u001a\u0019\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00170%¢\u0006\u0002\b'H\u0082@¢\u0006\u0002\u0010(\u001a\u0012\u0010)\u001a\u00020\u0017*\u00020\u0010H\u0080@¢\u0006\u0002\u0010*\u001a\u0012\u0010+\u001a\u00020\u0017*\u00020\u0010H\u0080@¢\u0006\u0002\u0010*\u001a\u0014\u0010,\u001a\u00020-*\u00020.2\u0006\u0010\u0014\u001a\u00020\nH\u0000\u001a\u0014\u0010/\u001a\u00020-*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\nH\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u00060"}, m13886d2 = {"DefaultPositionThreshold", "Landroidx/compose/ui/unit/Dp;", "getDefaultPositionThreshold", "()F", TokenizerME.NO_SPLIT, "EmptyLayoutInfo", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "getEmptyLayoutInfo", "()Landroidx/compose/foundation/pager/PagerMeasureResult;", "MaxPagesForAnimateScroll", "", "PagesToPrefetch", "UnitDensity", "androidx/compose/foundation/pager/PagerStateKt$UnitDensity$1", "Landroidx/compose/foundation/pager/PagerStateKt$UnitDensity$1;", "PagerState", "Landroidx/compose/foundation/pager/PagerState;", "currentPage", "currentPageOffsetFraction", "", "pageCount", "Lkotlin/Function0;", "debugLog", "", "generateMsg", "", "rememberPagerState", "initialPage", "initialPageOffsetFraction", "(IFLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/pager/PagerState;", "animateScrollToPage", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "targetPage", "targetPageOffsetToSnappedPosition", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "updateTargetPage", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;IFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToNextPage", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToPreviousPage", "calculateNewMaxScrollOffset", "", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "calculateNewMinScrollOffset", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPagerState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerState.kt\nandroidx/compose/foundation/pager/PagerStateKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,961:1\n868#1,4:968\n1225#2,6:962\n149#3:972\n*S KotlinDebug\n*F\n+ 1 PagerState.kt\nandroidx/compose/foundation/pager/PagerStateKt\n*L\n895#1:968,4\n88#1:962,6\n828#1:972\n*E\n"})
public final class PagerStateKt {
    private static final int MaxPagesForAnimateScroll = 3;
    public static final int PagesToPrefetch = 1;
    private static final float DefaultPositionThreshold = C2256Dp.m20968constructorimpl(56);

    @NotNull
    private static final PagerMeasureResult EmptyLayoutInfo = new PagerMeasureResult(CollectionsKt.emptyList(), 0, 0, 0, Orientation.Horizontal, 0, 0, false, 0, null, null, 0.0f, 0, false, SnapPosition.Start.INSTANCE, new MeasureResult() { // from class: androidx.compose.foundation.pager.PagerStateKt$EmptyLayoutInfo$1

        @NotNull
        private final Map<AlignmentLine, Integer> alignmentLines = MapsKt.emptyMap();
        private final int height;
        private final int width;

        @Override // androidx.compose.p109ui.layout.MeasureResult
        @NotNull
        public Map<AlignmentLine, Integer> getAlignmentLines() {
            return this.alignmentLines;
        }

        @Override // androidx.compose.p109ui.layout.MeasureResult
        public int getHeight() {
            return this.height;
        }

        @Override // androidx.compose.p109ui.layout.MeasureResult
        public int getWidth() {
            return this.width;
        }

        public static /* synthetic */ void getAlignmentLines$annotations() {
        }

        @Override // androidx.compose.p109ui.layout.MeasureResult
        public void placeChildren() {
        }
    }, false, null, null, CoroutineScopeKt.CoroutineScope(EmptyCoroutineContext.INSTANCE), 393216, null);

    @NotNull
    private static final PagerStateKt$UnitDensity$1 UnitDensity = new Density() { // from class: androidx.compose.foundation.pager.PagerStateKt$UnitDensity$1
        private final float density = 1.0f;
        private final float fontScale = 1.0f;

        @Override // androidx.compose.p109ui.unit.Density
        public float getDensity() {
            return this.density;
        }

        @Override // androidx.compose.p109ui.unit.FontScaling
        public float getFontScale() {
            return this.fontScale;
        }
    };

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerStateKt$animateScrollToPage$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.pager.PagerStateKt$animateScrollToPage$2", m14021f = "PagerState.kt", m14022i = {}, m14023l = {953}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    @SourceDebugExtension({"SMAP\nPagerState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerState.kt\nandroidx/compose/foundation/pager/PagerStateKt$animateScrollToPage$2\n+ 2 PagerState.kt\nandroidx/compose/foundation/pager/PagerStateKt\n*L\n1#1,961:1\n868#2,4:962\n868#2,4:966\n*S KotlinDebug\n*F\n+ 1 PagerState.kt\nandroidx/compose/foundation/pager/PagerStateKt$animateScrollToPage$2\n*L\n938#1:962,4\n951#1:966,4\n*E\n"})
    public static final class C11852 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ int $targetPage;
        final /* synthetic */ float $targetPageOffsetToSnappedPosition;
        final /* synthetic */ LazyLayoutAnimateScrollScope $this_animateScrollToPage;
        final /* synthetic */ Function2<ScrollScope, Integer, Unit> $updateTargetPage;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C11852(Function2<? super ScrollScope, ? super Integer, Unit> function2, int i, LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, float f, AnimationSpec<Float> animationSpec, Continuation<? super C11852> continuation) {
            super(2, continuation);
            this.$updateTargetPage = function2;
            this.$targetPage = i;
            this.$this_animateScrollToPage = lazyLayoutAnimateScrollScope;
            this.$targetPageOffsetToSnappedPosition = f;
            this.$animationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C11852 c11852 = new C11852(this.$updateTargetPage, this.$targetPage, this.$this_animateScrollToPage, this.$targetPageOffsetToSnappedPosition, this.$animationSpec, continuation);
            c11852.L$0 = obj;
            return c11852;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull ScrollScope scrollScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C11852) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ScrollScope scrollScope = (ScrollScope) this.L$0;
                this.$updateTargetPage.invoke(scrollScope, Boxing.boxInt(this.$targetPage));
                boolean z = this.$targetPage > this.$this_animateScrollToPage.getFirstVisibleItemIndex();
                int lastVisibleItemIndex = (this.$this_animateScrollToPage.getLastVisibleItemIndex() - this.$this_animateScrollToPage.getFirstVisibleItemIndex()) + 1;
                if (((z && this.$targetPage > this.$this_animateScrollToPage.getLastVisibleItemIndex()) || (!z && this.$targetPage < this.$this_animateScrollToPage.getFirstVisibleItemIndex())) && Math.abs(this.$targetPage - this.$this_animateScrollToPage.getFirstVisibleItemIndex()) >= 3) {
                    this.$this_animateScrollToPage.snapToItem(scrollScope, z ? RangesKt.coerceAtLeast(this.$targetPage - lastVisibleItemIndex, this.$this_animateScrollToPage.getFirstVisibleItemIndex()) : RangesKt.coerceAtMost(this.$targetPage + lastVisibleItemIndex, this.$this_animateScrollToPage.getFirstVisibleItemIndex()), 0);
                }
                float fCalculateDistanceTo = this.$this_animateScrollToPage.calculateDistanceTo(this.$targetPage) + this.$targetPageOffsetToSnappedPosition;
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                AnimationSpec<Float> animationSpec = this.$animationSpec;
                Function2<Float, Float, Unit> function2 = new Function2<Float, Float, Unit>() { // from class: androidx.compose.foundation.pager.PagerStateKt.animateScrollToPage.2.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Float f, Float f4) {
                        invoke(f.floatValue(), f4.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f, float f4) {
                        floatRef.element += scrollScope.scrollBy(f - floatRef.element);
                    }
                };
                this.label = 1;
                if (SuspendAnimationKt.animate$default(0.0f, fCalculateDistanceTo, 0.0f, animationSpec, function2, this, 4, null) == coroutine_suspended) {
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

    @NotNull
    public static final PagerState PagerState(int i, @FloatRange(from = -0.5d, m705to = 0.5d) float f, @NotNull Function0<Integer> function0) {
        return new DefaultPagerState(i, f, function0);
    }

    public static /* synthetic */ PagerState PagerState$default(int i, float f, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        return PagerState(i, f, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object animateScrollToPage(LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i, float f, AnimationSpec<Float> animationSpec, Function2<? super ScrollScope, ? super Integer, Unit> function2, Continuation<? super Unit> continuation) {
        Object objScroll = lazyLayoutAnimateScrollScope.scroll(new C11852(function2, i, lazyLayoutAnimateScrollScope, f, animationSpec, null), continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }

    @Nullable
    public static final Object animateToNextPage(@NotNull PagerState pagerState, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        if (pagerState.getCurrentPage() + 1 >= pagerState.getPageCount()) {
            return Unit.INSTANCE;
        }
        Object objAnimateScrollToPage$default = PagerState.animateScrollToPage$default(pagerState, pagerState.getCurrentPage() + 1, 0.0f, null, continuation, 6, null);
        return objAnimateScrollToPage$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateScrollToPage$default : Unit.INSTANCE;
    }

    @Nullable
    public static final Object animateToPreviousPage(@NotNull PagerState pagerState, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        if (pagerState.getCurrentPage() - 1 < 0) {
            return Unit.INSTANCE;
        }
        Object objAnimateScrollToPage$default = PagerState.animateScrollToPage$default(pagerState, pagerState.getCurrentPage() - 1, 0.0f, null, continuation, 6, null);
        return objAnimateScrollToPage$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateScrollToPage$default : Unit.INSTANCE;
    }

    public static final long calculateNewMaxScrollOffset(@NotNull PagerLayoutInfo pagerLayoutInfo, int i) {
        long pageSize = (((long) i) * ((long) (pagerLayoutInfo.getPageSize() + pagerLayoutInfo.getPageSpacing()))) + ((long) pagerLayoutInfo.getBeforeContentPadding()) + ((long) pagerLayoutInfo.getAfterContentPadding());
        int iM21138getWidthimpl = pagerLayoutInfo.getOrientation() == Orientation.Horizontal ? IntSize.m21138getWidthimpl(pagerLayoutInfo.mo16093getViewportSizeYbymL2g()) : IntSize.m21137getHeightimpl(pagerLayoutInfo.mo16093getViewportSizeYbymL2g());
        return RangesKt.coerceAtLeast(pageSize - ((long) (iM21138getWidthimpl - RangesKt.coerceIn(pagerLayoutInfo.getSnapPosition().position(iM21138getWidthimpl, pagerLayoutInfo.getPageSize(), pagerLayoutInfo.getBeforeContentPadding(), pagerLayoutInfo.getAfterContentPadding(), i - 1, i), 0, iM21138getWidthimpl))), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long calculateNewMinScrollOffset(PagerMeasureResult pagerMeasureResult, int i) {
        int iM21138getWidthimpl = pagerMeasureResult.getOrientation() == Orientation.Horizontal ? IntSize.m21138getWidthimpl(pagerMeasureResult.mo16093getViewportSizeYbymL2g()) : IntSize.m21137getHeightimpl(pagerMeasureResult.mo16093getViewportSizeYbymL2g());
        return RangesKt.coerceIn(pagerMeasureResult.getSnapPosition().position(iM21138getWidthimpl, pagerMeasureResult.getPageSize(), pagerMeasureResult.getBeforeContentPadding(), pagerMeasureResult.getAfterContentPadding(), 0, i), 0, iM21138getWidthimpl);
    }

    public static final float getDefaultPositionThreshold() {
        return DefaultPositionThreshold;
    }

    @NotNull
    public static final PagerMeasureResult getEmptyLayoutInfo() {
        return EmptyLayoutInfo;
    }

    @Composable
    @NotNull
    public static final PagerState rememberPagerState(final int i, @FloatRange(from = -0.5d, m705to = 0.5d) final float f, @NotNull final Function0<Integer> function0, @Nullable Composer composer, int i2, int i4) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            f = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1210768637, i2, -1, "androidx.compose.foundation.pager.rememberPagerState (PagerState.kt:86)");
        }
        Object[] objArr = new Object[0];
        Saver<DefaultPagerState, ?> saver = DefaultPagerState.INSTANCE.getSaver();
        boolean z = ((((i2 & 14) ^ 6) > 4 && composer.changed(i)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(f)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && composer.changed(function0)) || (i2 & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0<DefaultPagerState>() { // from class: androidx.compose.foundation.pager.PagerStateKt$rememberPagerState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final DefaultPagerState invoke() {
                    return new DefaultPagerState(i, f, function0);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        DefaultPagerState defaultPagerState = (DefaultPagerState) RememberSaveableKt.m18111rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) objRememberedValue, composer, 0, 4);
        defaultPagerState.getPageCountState().setValue(function0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultPagerState;
    }

    private static final void debugLog(Function0<String> function0) {
    }
}
