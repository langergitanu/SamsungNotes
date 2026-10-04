package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.gms.drive.DriveFile;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
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
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class BottomSheetScaffoldKt$BottomSheetScaffold$1 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ int $$dirty2;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ long $drawerBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $drawerContent;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ float $drawerElevation;
    final /* synthetic */ boolean $drawerGesturesEnabled;
    final /* synthetic */ long $drawerScrimColor;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $sheetBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $sheetContent;
    final /* synthetic */ long $sheetContentColor;
    final /* synthetic */ float $sheetElevation;
    final /* synthetic */ boolean $sheetGesturesEnabled;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ Shape $sheetShape;
    final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BottomSheetScaffoldKt$BottomSheetScaffold$1(BottomSheetScaffoldState bottomSheetScaffoldState, boolean z, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, boolean z2, Shape shape, float f, long j, long j2, long j3, int i, float f4, CoroutineScope coroutineScope, int i2, int i4, long j5, long j6, int i5, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32, Shape shape2, long j7, long j8, float f5, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function34) {
        super(3);
        this.$scaffoldState = bottomSheetScaffoldState;
        this.$sheetGesturesEnabled = z;
        this.$drawerContent = function3;
        this.$drawerGesturesEnabled = z2;
        this.$drawerShape = shape;
        this.$drawerElevation = f;
        this.$drawerBackgroundColor = j;
        this.$drawerContentColor = j2;
        this.$drawerScrimColor = j3;
        this.$$dirty1 = i;
        this.$sheetPeekHeight = f4;
        this.$scope = coroutineScope;
        this.$floatingActionButtonPosition = i2;
        this.$$dirty = i4;
        this.$backgroundColor = j5;
        this.$contentColor = j6;
        this.$$dirty2 = i5;
        this.$topBar = function2;
        this.$content = function32;
        this.$sheetShape = shape2;
        this.$sheetBackgroundColor = j7;
        this.$sheetContentColor = j8;
        this.$sheetElevation = f5;
        this.$sheetContent = function33;
        this.$floatingActionButton = function22;
        this.$snackbarHost = function34;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: invoke$lambda-2, reason: not valid java name */
    public static final float m16624invoke$lambda2(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: invoke$lambda-3, reason: not valid java name */
    public static final void m16625invoke$lambda3(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
        invoke(boxWithConstraintsScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull BoxWithConstraintsScope BoxWithConstraints, @Nullable Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        if ((i & 14) == 0) {
            i2 = (composer.changed(BoxWithConstraints) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-440488519, i, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:284)");
        }
        float fM20920getMaxHeightimpl = Constraints.m20920getMaxHeightimpl(BoxWithConstraints.mo15761getConstraintsmsEJaDk());
        final float fMo15546toPx0680j_4 = ((Density) composer.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(this.$sheetPeekHeight);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(fM20920getMaxHeightimpl), null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        final MutableState mutableState = (MutableState) objRememberedValue;
        Modifier modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, this.$scaffoldState.getBottomSheetState().getNestedScrollConnection(), null, 2, null);
        BottomSheetState bottomSheetState = this.$scaffoldState.getBottomSheetState();
        Map mapMapOf = MapsKt.mapOf(TuplesKt.m13893to(Float.valueOf(fM20920getMaxHeightimpl - fMo15546toPx0680j_4), BottomSheetValue.Collapsed), TuplesKt.m13893to(Float.valueOf(fM20920getMaxHeightimpl - m16624invoke$lambda2(mutableState)), BottomSheetValue.Expanded));
        Modifier modifierM16882swipeablepPrIpRY = SwipeableKt.m16882swipeablepPrIpRY(modifierNestedScroll$default, bottomSheetState, mapMapOf, Orientation.Vertical, (32 & 8) != 0 ? true : this.$sheetGesturesEnabled, (32 & 16) != 0 ? false : false, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? new Function2() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final FixedThreshold invoke(Object obj, Object obj2) {
                return new FixedThreshold(C2256Dp.m20968constructorimpl(56), null);
            }
        } : null, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m16881getVelocityThresholdD9Ej5fM() : 0.0f);
        final BottomSheetScaffoldState bottomSheetScaffoldState = this.$scaffoldState;
        final CoroutineScope coroutineScope = this.$scope;
        final Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierM16882swipeablepPrIpRY, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                if (fMo15546toPx0680j_4 == BottomSheetScaffoldKt$BottomSheetScaffold$1.m16624invoke$lambda2(mutableState)) {
                    return;
                }
                if (bottomSheetScaffoldState.getBottomSheetState().isCollapsed()) {
                    final BottomSheetScaffoldState bottomSheetScaffoldState2 = bottomSheetScaffoldState;
                    final CoroutineScope coroutineScope2 = coroutineScope;
                    SemanticsPropertiesKt.expand$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1.1

                        /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                        @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                        @DebugMetadata(m14020c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1$1$1", m14021f = "BottomSheetScaffold.kt", m14022i = {}, m14023l = {307}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public AnonymousClass1(BottomSheetScaffoldState bottomSheetScaffoldState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$scaffoldState = bottomSheetScaffoldState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @NotNull
                            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                return new AnonymousClass1(this.$scaffoldState, continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    BottomSheetState bottomSheetState = this.$scaffoldState.getBottomSheetState();
                                    this.label = 1;
                                    if (bottomSheetState.expand(this) == coroutine_suspended) {
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
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final Boolean invoke() {
                            if (bottomSheetScaffoldState2.getBottomSheetState().getConfirmStateChange$material_release().invoke(BottomSheetValue.Expanded).booleanValue()) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(bottomSheetScaffoldState2, null), 3, null);
                            }
                            return Boolean.TRUE;
                        }
                    }, 1, null);
                } else {
                    final BottomSheetScaffoldState bottomSheetScaffoldState3 = bottomSheetScaffoldState;
                    final CoroutineScope coroutineScope3 = coroutineScope;
                    SemanticsPropertiesKt.collapse$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1.2

                        /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                        @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                        @DebugMetadata(m14020c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1$2$1", m14021f = "BottomSheetScaffold.kt", m14022i = {}, m14023l = {314}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public AnonymousClass1(BottomSheetScaffoldState bottomSheetScaffoldState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$scaffoldState = bottomSheetScaffoldState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @NotNull
                            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                return new AnonymousClass1(this.$scaffoldState, continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    BottomSheetState bottomSheetState = this.$scaffoldState.getBottomSheetState();
                                    this.label = 1;
                                    if (bottomSheetState.collapse(this) == coroutine_suspended) {
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
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final Boolean invoke() {
                            if (bottomSheetScaffoldState3.getBottomSheetState().getConfirmStateChange$material_release().invoke(BottomSheetValue.Collapsed).booleanValue()) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass1(bottomSheetScaffoldState3, null), 3, null);
                            }
                            return Boolean.TRUE;
                        }
                    }, 1, null);
                }
            }
        }, 1, null);
        final BottomSheetScaffoldState bottomSheetScaffoldState2 = this.$scaffoldState;
        final int i4 = this.$floatingActionButtonPosition;
        final int i5 = this.$$dirty;
        final long j = this.$backgroundColor;
        final long j2 = this.$contentColor;
        final int i6 = this.$$dirty2;
        final Function2<Composer, Integer, Unit> function2 = this.$topBar;
        final Function3<PaddingValues, Composer, Integer, Unit> function3 = this.$content;
        final float f = this.$sheetPeekHeight;
        final Shape shape = this.$sheetShape;
        final long j3 = this.$sheetBackgroundColor;
        final long j5 = this.$sheetContentColor;
        final float f4 = this.$sheetElevation;
        final int i7 = this.$$dirty1;
        final Function3<ColumnScope, Composer, Integer, Unit> function32 = this.$sheetContent;
        final Function2<Composer, Integer, Unit> function22 = this.$floatingActionButton;
        final Function3<SnackbarHostState, Composer, Integer, Unit> function33 = this.$snackbarHost;
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -455982883, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1
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

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i8) {
                if ((i8 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-455982883, i8, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:321)");
                }
                final long j6 = j;
                final long j7 = j2;
                final int i9 = i6;
                final Function2<Composer, Integer, Unit> function23 = function2;
                final int i10 = i5;
                final Function3<PaddingValues, Composer, Integer, Unit> function34 = function3;
                final float f5 = f;
                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, 729683080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1.1
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

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer3, int i11) {
                        if ((i11 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(729683080, i11, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:323)");
                        }
                        long j8 = j6;
                        long j9 = j7;
                        final Function2<Composer, Integer, Unit> function24 = function23;
                        final int i12 = i10;
                        final Function3<PaddingValues, Composer, Integer, Unit> function35 = function34;
                        final float f6 = f5;
                        final int i13 = i9;
                        ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 2013303492, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.BottomSheetScaffold.1.child.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer4, int i14) {
                                if ((i14 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2013303492, i14, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:327)");
                                }
                                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                Function2<Composer, Integer, Unit> function25 = function24;
                                int i15 = i12;
                                Function3<PaddingValues, Composer, Integer, Unit> function36 = function35;
                                float f7 = f6;
                                int i16 = i13;
                                composer4.startReplaceableGroup(-483455358);
                                MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer4, 0, -1323940314);
                                Density density = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierFillMaxSize$default);
                                if (composer4.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor);
                                } else {
                                    composer4.useNode();
                                }
                                composer4.disableReusing();
                                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer4);
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                composer4.startReplaceableGroup(-1163856341);
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                composer4.startReplaceableGroup(521184014);
                                composer4.startReplaceableGroup(-1579943829);
                                if (function25 != null) {
                                    function25.invoke(composer4, Integer.valueOf((i15 >> 9) & 14));
                                }
                                composer4.endReplaceableGroup();
                                function36.invoke(PaddingKt.m15851PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f7, 7, null), composer4, Integer.valueOf((i16 >> 3) & 112));
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
                                composer4.endNode();
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        int i14 = i9;
                        SurfaceKt.m16872SurfaceFjzlyU(null, null, j8, j9, null, 0.0f, composableLambda3, composer3, ((i14 << 6) & 896) | 1572864 | ((i14 << 6) & 7168), 51);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                });
                final Modifier modifier = modifierSemantics$default;
                final float f6 = f;
                final MutableState<Float> mutableState2 = mutableState;
                final Shape shape2 = shape;
                final long j8 = j3;
                final long j9 = j5;
                final float f7 = f4;
                final int i11 = i5;
                final int i12 = i7;
                final Function3<ColumnScope, Composer, Integer, Unit> function35 = function32;
                ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer2, -1113066167, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1.2
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

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer3, int i13) {
                        if ((i13 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1113066167, i13, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:334)");
                        }
                        Modifier modifierM15890requiredHeightInVpY3zN4$default = SizeKt.m15890requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), f6, 0.0f, 2, null);
                        final MutableState<Float> mutableState3 = mutableState2;
                        composer3.startReplaceableGroup(1157296644);
                        boolean zChanged = composer3.changed(mutableState3);
                        Object objRememberedValue2 = composer3.rememberedValue();
                        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                    invoke2(layoutCoordinates);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull LayoutCoordinates it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    BottomSheetScaffoldKt$BottomSheetScaffold$1.m16625invoke$lambda3(mutableState3, IntSize.m21137getHeightimpl(it.mo19863getSizeYbymL2g()));
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM15890requiredHeightInVpY3zN4$default, (Function1) objRememberedValue2);
                        Shape shape3 = shape2;
                        long j10 = j8;
                        long j11 = j9;
                        float f8 = f7;
                        final Function3<ColumnScope, Composer, Integer, Unit> function36 = function35;
                        final int i14 = i11;
                        ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composer3, 170554245, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.BottomSheetScaffold.1.child.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer4, int i15) {
                                if ((i15 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(170554245, i15, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:346)");
                                }
                                Function3<ColumnScope, Composer, Integer, Unit> function37 = function36;
                                int i16 = (i14 << 9) & 7168;
                                composer4.startReplaceableGroup(-483455358);
                                Modifier.Companion companion = Modifier.INSTANCE;
                                MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer4, 0, -1323940314);
                                Density density = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
                                if (composer4.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor);
                                } else {
                                    composer4.useNode();
                                }
                                composer4.disableReusing();
                                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer4);
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                composer4.startReplaceableGroup(-1163856341);
                                function37.invoke(ColumnScopeInstance.INSTANCE, composer4, Integer.valueOf(((i16 >> 6) & 112) | 6));
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
                                composer4.endNode();
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        int i15 = i11;
                        int i16 = i12;
                        SurfaceKt.m16872SurfaceFjzlyU(modifierOnGloballyPositioned, shape3, j10, j11, null, f8, composableLambda4, composer3, ((i15 >> 12) & 458752) | ((i15 >> 21) & 112) | 1572864 | ((i16 << 6) & 896) | ((i16 << 6) & 7168), 16);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                });
                final Function2<Composer, Integer, Unit> function24 = function22;
                final int i13 = i5;
                ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composer2, 1339151882, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1.3
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

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer3, int i14) {
                        if ((i14 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1339151882, i14, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:349)");
                        }
                        Function2<Composer, Integer, Unit> function25 = function24;
                        int i15 = i13;
                        composer3.startReplaceableGroup(733328855);
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer3, 0, -1323940314);
                        Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
                        if (composer3.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        composer3.disableReusing();
                        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer3);
                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                        composer3.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        composer3.startReplaceableGroup(-1521336816);
                        if (function25 != null) {
                            function25.invoke(composer3, Integer.valueOf((i15 >> 15) & 14));
                        }
                        if (AbstractC1038a.m1225z(composer3)) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                });
                final Function3<SnackbarHostState, Composer, Integer, Unit> function36 = function33;
                final BottomSheetScaffoldState bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                final int i14 = i5;
                BottomSheetScaffoldKt.m16620BottomSheetScaffoldStackSlNgfk0(composableLambda2, composableLambda3, composableLambda4, ComposableLambdaKt.composableLambda(composer2, -503597365, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1.4
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

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer3, int i15) {
                        if ((i15 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-503597365, i15, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:354)");
                        }
                        Function3<SnackbarHostState, Composer, Integer, Unit> function37 = function36;
                        BottomSheetScaffoldState bottomSheetScaffoldState4 = bottomSheetScaffoldState3;
                        int i16 = i14;
                        composer3.startReplaceableGroup(733328855);
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer3, 0, -1323940314);
                        Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
                        if (composer3.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        composer3.disableReusing();
                        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer3);
                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                        composer3.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        composer3.startReplaceableGroup(930881233);
                        function37.invoke(bottomSheetScaffoldState4.getSnackbarHostState(), composer3, Integer.valueOf((i16 >> 9) & 112));
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), bottomSheetScaffoldState2.getBottomSheetState().getOffset(), i4, composer2, ((i5 >> 3) & 458752) | 3510);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
        if (this.$drawerContent == null) {
            composer.startReplaceableGroup(-249545651);
            composableLambda.invoke(composer, 6);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-249545614);
            Function3<ColumnScope, Composer, Integer, Unit> function34 = this.$drawerContent;
            DrawerState drawerState = this.$scaffoldState.getDrawerState();
            boolean z = this.$drawerGesturesEnabled;
            Shape shape2 = this.$drawerShape;
            float f5 = this.$drawerElevation;
            long j6 = this.$drawerBackgroundColor;
            long j7 = this.$drawerContentColor;
            long j8 = this.$drawerScrimColor;
            int i8 = this.$$dirty1;
            int i9 = ((i8 >> 9) & 14) | DriveFile.MODE_READ_WRITE;
            int i10 = i8 >> 3;
            DrawerKt.m16725ModalDrawerGs3lGvM(function34, null, drawerState, z, shape2, f5, j6, j7, j8, composableLambda, composer, (i10 & 7168) | i9 | (57344 & i10) | (458752 & i10) | (3670016 & i10) | (29360128 & i10) | (i10 & 234881024), 2);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
