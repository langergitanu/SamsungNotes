package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
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
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntOffsetKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
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
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class DrawerKt$BottomDrawer$1 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ long $drawerBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $drawerContent;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ float $drawerElevation;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ BottomDrawerState $drawerState;
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $scrimColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DrawerKt$BottomDrawer$1(boolean z, BottomDrawerState bottomDrawerState, Function2<? super Composer, ? super Integer, Unit> function2, int i, long j, Shape shape, long j2, long j3, float f, CoroutineScope coroutineScope, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.$gesturesEnabled = z;
        this.$drawerState = bottomDrawerState;
        this.$content = function2;
        this.$$dirty = i;
        this.$scrimColor = j;
        this.$drawerShape = shape;
        this.$drawerBackgroundColor = j2;
        this.$drawerContentColor = j3;
        this.$drawerElevation = f;
        this.$scope = coroutineScope;
        this.$drawerContent = function3;
    }

    /* JADX INFO: renamed from: invoke$lambda-1, reason: not valid java name */
    private static final float m16731invoke$lambda1(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: invoke$lambda-2, reason: not valid java name */
    public static final void m16732invoke$lambda2(MutableState<Float> mutableState, float f) {
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
            ComposerKt.traceEventStart(1220102512, i, -1, "androidx.compose.material.BottomDrawer.<anonymous> (Drawer.kt:510)");
        }
        float fM20920getMaxHeightimpl = Constraints.m20920getMaxHeightimpl(BoxWithConstraints.mo15761getConstraintsmsEJaDk());
        Object objValueOf = Float.valueOf(fM20920getMaxHeightimpl);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(objValueOf);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(fM20920getMaxHeightimpl), null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        final MutableState mutableState = (MutableState) objRememberedValue;
        boolean z = Constraints.m20921getMaxWidthimpl(BoxWithConstraints.mo15761getConstraintsmsEJaDk()) > Constraints.m20920getMaxHeightimpl(BoxWithConstraints.mo15761getConstraintsmsEJaDk());
        float f = 0.5f * fM20920getMaxHeightimpl;
        float fMax = Math.max(0.0f, fM20920getMaxHeightimpl - m16731invoke$lambda1(mutableState));
        Map mapMapOf = (m16731invoke$lambda1(mutableState) < f || z) ? MapsKt.mapOf(TuplesKt.m13893to(Float.valueOf(fM20920getMaxHeightimpl), BottomDrawerValue.Closed), TuplesKt.m13893to(Float.valueOf(fMax), BottomDrawerValue.Expanded)) : MapsKt.mapOf(TuplesKt.m13893to(Float.valueOf(fM20920getMaxHeightimpl), BottomDrawerValue.Closed), TuplesKt.m13893to(Float.valueOf(f), BottomDrawerValue.Open), TuplesKt.m13893to(Float.valueOf(fMax), BottomDrawerValue.Expanded));
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierM15903sizeInqDBjuR0$default = SizeKt.m15903sizeInqDBjuR0$default(companion, 0.0f, 0.0f, density.mo15543toDpu2uoSUM(Constraints.m20921getMaxWidthimpl(BoxWithConstraints.mo15761getConstraintsmsEJaDk())), density.mo15543toDpu2uoSUM(Constraints.m20920getMaxHeightimpl(BoxWithConstraints.mo15761getConstraintsmsEJaDk())), 3, null);
        Modifier modifierM16882swipeablepPrIpRY = SwipeableKt.m16882swipeablepPrIpRY(companion.then(this.$gesturesEnabled ? NestedScrollModifierKt.nestedScroll$default(companion, this.$drawerState.getNestedScrollConnection(), null, 2, null) : companion), this.$drawerState, mapMapOf, Orientation.Vertical, (32 & 8) != 0 ? true : this.$gesturesEnabled, (32 & 16) != 0 ? false : false, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? new Function2() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final FixedThreshold invoke(Object obj, Object obj2) {
                return new FixedThreshold(C2256Dp.m20968constructorimpl(56), null);
            }
        } : null, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m16881getVelocityThresholdD9Ej5fM() : 0.0f);
        Function2<Composer, Integer, Unit> function2 = this.$content;
        final int i4 = this.$$dirty;
        long j = this.$scrimColor;
        final BottomDrawerState bottomDrawerState = this.$drawerState;
        Shape shape = this.$drawerShape;
        long j2 = this.$drawerBackgroundColor;
        long j3 = this.$drawerContentColor;
        float f4 = this.$drawerElevation;
        final boolean z2 = this.$gesturesEnabled;
        final CoroutineScope coroutineScope = this.$scope;
        final Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$drawerContent;
        composer.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer, 0, -1323940314);
        Density density2 = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM16882swipeablepPrIpRY);
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density2));
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 2058660585);
        composer.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        composer.startReplaceableGroup(-1660053078);
        function2.invoke(composer, Integer.valueOf((i4 >> 27) & 14));
        DrawerKt.m16723BottomDrawerScrim3JVO9M(j, new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$1

            /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$BottomDrawer$1$1$1$1 */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
            @DebugMetadata(m14020c = "androidx.compose.material.DrawerKt$BottomDrawer$1$1$1$1", m14021f = "Drawer.kt", m14022i = {}, m14023l = {562}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
            public static final class C15141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ BottomDrawerState $drawerState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C15141(BottomDrawerState bottomDrawerState, Continuation<? super C15141> continuation) {
                    super(2, continuation);
                    this.$drawerState = bottomDrawerState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C15141(this.$drawerState, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        BottomDrawerState bottomDrawerState = this.$drawerState;
                        this.label = 1;
                        if (bottomDrawerState.close(this) == coroutine_suspended) {
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
                    return ((C15141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (z2 && bottomDrawerState.getConfirmStateChange$material_release().invoke(BottomDrawerValue.Closed).booleanValue()) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C15141(bottomDrawerState, null), 3, null);
                }
            }
        }, bottomDrawerState.getTargetValue() != BottomDrawerValue.Closed, composer, (i4 >> 24) & 14);
        final String strM16870getString4foXLRw = Strings_androidKt.m16870getString4foXLRw(Strings.INSTANCE.m16867getNavigationMenuUdPEhr4(), composer, 6);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged2 = composer.changed(bottomDrawerState);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$2$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntOffset invoke(Density density3) {
                    return IntOffset.m21087boximpl(m16733invokeBjo55l4(density3));
                }

                /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                public final long m16733invokeBjo55l4(@NotNull Density offset) {
                    Intrinsics.checkNotNullParameter(offset, "$this$offset");
                    return IntOffsetKt.IntOffset(0, MathKt.roundToInt(bottomDrawerState.getOffset().getValue().floatValue()));
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        Modifier modifierOffset = OffsetKt.offset(modifierM15903sizeInqDBjuR0$default, (Function1) objRememberedValue2);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged3 = composer.changed(mutableState);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$3$1
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
                public final void invoke2(@NotNull LayoutCoordinates position) {
                    Intrinsics.checkNotNullParameter(position, "position");
                    DrawerKt$BottomDrawer$1.m16732invoke$lambda2(mutableState, IntSize.m21137getHeightimpl(position.mo19863getSizeYbymL2g()));
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        composer.endReplaceableGroup();
        int i5 = i4 >> 12;
        SurfaceKt.m16872SurfaceFjzlyU(SemanticsModifierKt.semantics$default(OnGloballyPositionedModifierKt.onGloballyPositioned(modifierOffset, (Function1) objRememberedValue3), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4
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
                SemanticsPropertiesKt.setPaneTitle(semantics, strM16870getString4foXLRw);
                if (bottomDrawerState.isOpen()) {
                    final BottomDrawerState bottomDrawerState2 = bottomDrawerState;
                    final CoroutineScope coroutineScope2 = coroutineScope;
                    SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4.1

                        /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                        @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                        @DebugMetadata(m14020c = "androidx.compose.material.DrawerKt$BottomDrawer$1$1$4$1$1", m14021f = "Drawer.kt", m14022i = {}, m14023l = {580}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ BottomDrawerState $drawerState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public AnonymousClass1(BottomDrawerState bottomDrawerState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$drawerState = bottomDrawerState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @NotNull
                            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                return new AnonymousClass1(this.$drawerState, continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    BottomDrawerState bottomDrawerState = this.$drawerState;
                                    this.label = 1;
                                    if (bottomDrawerState.close(this) == coroutine_suspended) {
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
                            if (bottomDrawerState2.getConfirmStateChange$material_release().invoke(BottomDrawerValue.Closed).booleanValue()) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(bottomDrawerState2, null), 3, null);
                            }
                            return Boolean.TRUE;
                        }
                    }, 1, null);
                }
            }
        }, 1, null), shape, j2, j3, null, f4, ComposableLambdaKt.composableLambda(composer, 457750254, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$5
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
            public final void invoke(@Nullable Composer composer2, int i6) {
                if ((i6 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(457750254, i6, -1, "androidx.compose.material.BottomDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:588)");
                }
                Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                int i7 = (i4 << 9) & 7168;
                composer2.startReplaceableGroup(-483455358);
                Modifier.Companion companion3 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer2, 0, -1323940314);
                Density density3 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(companion3);
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer2);
                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl2, measurePolicyM1209j, composerM18018constructorimpl2, density3));
                AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion4, composerM18018constructorimpl2, viewConfiguration2, composer2, composer2), composer2, 2058660585);
                composer2.startReplaceableGroup(-1163856341);
                function32.invoke(ColumnScopeInstance.INSTANCE, composer2, Integer.valueOf(((i7 >> 6) & 112) | 6));
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, ((i4 >> 9) & 112) | 1572864 | (i5 & 896) | (i5 & 7168) | (458752 & i4), 16);
        if (AbstractC1038a.m1225z(composer)) {
            ComposerKt.traceEventEnd();
        }
    }
}
