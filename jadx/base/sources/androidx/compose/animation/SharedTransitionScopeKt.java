package androidx.compose.animation;

import androidx.collection.AbstractC0622a;
import androidx.collection.MutableScatterMap;
import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.DrawModifierKt;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p109ui.graphics.GraphicsLayerScope;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p109ui.layout.ContentScale;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.layout.LayoutModifierKt;
import androidx.compose.p109ui.layout.LookaheadScope;
import androidx.compose.p109ui.layout.LookaheadScopeKt;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001cH\u0003\u001a5\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\u001c\u0010*\u001a\u0018\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020'0+¢\u0006\u0002\b-¢\u0006\u0002\b.H\u0007¢\u0006\u0002\u0010/\u001a1\u00100\u001a\u00020'2\"\u0010*\u001a\u001e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020'0\u0005¢\u0006\u0002\b-¢\u0006\u0002\b.H\u0007¢\u0006\u0002\u00101\u001a\"\u00102\u001a\u00020)*\u00020)2\u0006\u00103\u001a\u00020\u001d2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u000f\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0003\"\u001b\u0010\u0012\u001a\u00020\u00138@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015\"\u000e\u0010\u0018\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000\".\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001a0\u001a8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u0003\"\u0018\u0010\u001f\u001a\u00020\u000b*\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!\"\u0018\u0010\u001f\u001a\u00020\u000b*\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010\"¨\u00065"}, m13886d2 = {"DefaultBoundsTransform", "Landroidx/compose/animation/BoundsTransform;", "getDefaultBoundsTransform$annotations", "()V", "DefaultClipInOverlayDuringTransition", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/Path;", "DefaultEnabled", "Lkotlin/Function0;", "", "DefaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/geometry/Rect;", "ParentClip", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "getParentClip$annotations", "SharedTransitionObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "getSharedTransitionObserver", "()Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "SharedTransitionObserver$delegate", "Lkotlin/Lazy;", "VisualDebugging", "cachedScaleToBoundsImplMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/layout/ContentScale;", "Landroidx/compose/ui/Alignment;", "Landroidx/compose/animation/ScaleToBoundsImpl;", "getCachedScaleToBoundsImplMap$annotations", "shouldCache", "getShouldCache", "(Landroidx/compose/ui/Alignment;)Z", "(Landroidx/compose/ui/layout/ContentScale;)Z", "ScaleToBoundsCached", "contentScale", "alignment", "SharedTransitionLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/animation/SharedTransitionScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SharedTransitionScope", "(Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "createContentScaleModifier", "scaleToBounds", "isEnabled", "animation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSharedTransitionScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedTransitionScope.kt\nandroidx/compose/animation/SharedTransitionScopeKt\n+ 2 ScatterMap.kt\nandroidx/collection/MutableScatterMap\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1337:1\n863#2:1338\n863#2:1340\n1#3:1339\n1#3:1341\n*S KotlinDebug\n*F\n+ 1 SharedTransitionScope.kt\nandroidx/compose/animation/SharedTransitionScopeKt\n*L\n1302#1:1338\n1303#1:1340\n1302#1:1339\n1303#1:1341\n*E\n"})
public final class SharedTransitionScopeKt {
    public static final boolean VisualDebugging = false;

    @NotNull
    private static final Function0<Boolean> DefaultEnabled = new Function0<Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$DefaultEnabled$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    };

    @NotNull
    private static final SpringSpec<Rect> DefaultSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.INSTANCE), 1, null);

    @NotNull
    private static final SharedTransitionScope.OverlayClip ParentClip = new SharedTransitionScope.OverlayClip() { // from class: androidx.compose.animation.SharedTransitionScopeKt$ParentClip$1
        @Override // androidx.compose.animation.SharedTransitionScope.OverlayClip
        @Nullable
        public Path getClipPath(@NotNull SharedTransitionScope.SharedContentState state, @NotNull Rect bounds, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
            SharedTransitionScope.SharedContentState parentSharedContentState = state.getParentSharedContentState();
            if (parentSharedContentState != null) {
                return parentSharedContentState.getClipPathInOverlay();
            }
            return null;
        }
    };

    @NotNull
    private static final Function2<LayoutDirection, Density, Path> DefaultClipInOverlayDuringTransition = new Function2() { // from class: androidx.compose.animation.SharedTransitionScopeKt$DefaultClipInOverlayDuringTransition$1
        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Void invoke(@NotNull LayoutDirection layoutDirection, @NotNull Density density) {
            return null;
        }
    };

    @NotNull
    private static final BoundsTransform DefaultBoundsTransform = new C0709b();

    @NotNull
    private static final Lazy SharedTransitionObserver$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SnapshotStateObserver>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionObserver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final SnapshotStateObserver invoke() {
            SnapshotStateObserver snapshotStateObserver = new SnapshotStateObserver(new Function1<Function0<? extends Unit>, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionObserver$2.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
                    invoke2((Function0<Unit>) function0);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Function0<Unit> function0) {
                    function0.invoke();
                }
            });
            snapshotStateObserver.start();
            return snapshotStateObserver;
        }
    });

    @NotNull
    private static final MutableScatterMap<ContentScale, MutableScatterMap<Alignment, ScaleToBoundsImpl>> cachedScaleToBoundsImplMap = new MutableScatterMap<>(0, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec DefaultBoundsTransform$lambda$0(Rect rect, Rect rect2) {
        return DefaultSpring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalSharedTransitionApi
    public static final ScaleToBoundsImpl ScaleToBoundsCached(ContentScale contentScale, Alignment alignment) {
        if (!getShouldCache(contentScale) || !getShouldCache(alignment)) {
            return new ScaleToBoundsImpl(contentScale, alignment);
        }
        MutableScatterMap<ContentScale, MutableScatterMap<Alignment, ScaleToBoundsImpl>> mutableScatterMap = cachedScaleToBoundsImplMap;
        MutableScatterMap<Alignment, ScaleToBoundsImpl> mutableScatterMap2 = mutableScatterMap.get(contentScale);
        if (mutableScatterMap2 == null) {
            mutableScatterMap2 = new MutableScatterMap<>(0, 1, null);
            mutableScatterMap.set(contentScale, mutableScatterMap2);
        }
        MutableScatterMap<Alignment, ScaleToBoundsImpl> mutableScatterMap3 = mutableScatterMap2;
        ScaleToBoundsImpl scaleToBoundsImpl = mutableScatterMap3.get(alignment);
        if (scaleToBoundsImpl == null) {
            scaleToBoundsImpl = new ScaleToBoundsImpl(contentScale, alignment);
            mutableScatterMap3.set(alignment, scaleToBoundsImpl);
        }
        return scaleToBoundsImpl;
    }

    @ExperimentalSharedTransitionApi
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void SharedTransitionLayout(@Nullable final Modifier modifier, @NotNull final Function3<? super SharedTransitionScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(2043053727);
        int i5 = i2 & 1;
        if (i5 != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i5 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2043053727, i4, -1, "androidx.compose.animation.SharedTransitionLayout (SharedTransitionScope.kt:111)");
            }
            SharedTransitionScope(ComposableLambdaKt.rememberComposableLambda(-130587847, true, new Function4<SharedTransitionScope, Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt.SharedTransitionLayout.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(SharedTransitionScope sharedTransitionScope, Modifier modifier2, Composer composer2, Integer num) {
                    invoke(sharedTransitionScope, modifier2, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@NotNull SharedTransitionScope sharedTransitionScope, @NotNull Modifier modifier2, @Nullable Composer composer2, int i6) {
                    int i7;
                    if ((i6 & 6) == 0) {
                        i7 = (composer2.changed(sharedTransitionScope) ? 4 : 2) | i6;
                    } else {
                        i7 = i6;
                    }
                    if ((i6 & 48) == 0) {
                        i7 |= composer2.changed(modifier2) ? 32 : 16;
                    }
                    if ((i7 & 147) == 146 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-130587847, i7, -1, "androidx.compose.animation.SharedTransitionLayout.<anonymous> (SharedTransitionScope.kt:115)");
                    }
                    Modifier modifierThen = modifier.then(modifier2);
                    Function3<SharedTransitionScope, Composer, Integer, Unit> function32 = function3;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierThen);
                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                    Function2 function2M1177w = AbstractC0622a.m1177w(companion, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
                    if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                    }
                    Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    function32.invoke(sharedTransitionScope, composer2, Integer.valueOf(i7 & 14));
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt.SharedTransitionLayout.2
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

                public final void invoke(@Nullable Composer composer2, int i6) {
                    SharedTransitionScopeKt.SharedTransitionLayout(modifier, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ExperimentalSharedTransitionApi
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void SharedTransitionScope(@NotNull final Function4<? super SharedTransitionScope, ? super Modifier, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2093217917);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2093217917, i2, -1, "androidx.compose.animation.SharedTransitionScope (SharedTransitionScope.kt:138)");
            }
            LookaheadScopeKt.LookaheadScope(ComposableLambdaKt.rememberComposableLambda(-863967934, true, new Function3<LookaheadScope, Composer, Integer, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt.SharedTransitionScope.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LookaheadScope lookaheadScope, Composer composer2, Integer num) {
                    invoke(lookaheadScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@NotNull LookaheadScope lookaheadScope, @Nullable Composer composer2, int i4) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-863967934, i4, -1, "androidx.compose.animation.SharedTransitionScope.<anonymous> (SharedTransitionScope.kt:140)");
                    }
                    Object objRememberedValue = composer2.rememberedValue();
                    Composer.Companion companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2), composer2);
                    }
                    CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    Object objRememberedValue2 = composer2.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new SharedTransitionScopeImpl(lookaheadScope, coroutineScope);
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    final SharedTransitionScopeImpl sharedTransitionScopeImpl = (SharedTransitionScopeImpl) objRememberedValue2;
                    Function4<SharedTransitionScope, Modifier, Composer, Integer, Unit> function42 = function4;
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    Object objRememberedValue3 = composer2.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1$1$1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                return m15285invoke3p2s80s(measureScope, measurable, constraints.getValue());
                            }

                            @NotNull
                            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                            public final MeasureResult m15285invoke3p2s80s(@NotNull final MeasureScope measureScope, @NotNull Measurable measurable, long j) {
                                final Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(j);
                                int width = placeableMo19855measureBRTryo0.getWidth();
                                int height = placeableMo19855measureBRTryo0.getHeight();
                                final SharedTransitionScopeImpl sharedTransitionScopeImpl2 = sharedTransitionScopeImpl;
                                return MeasureScope.layout$default(measureScope, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                                        LayoutCoordinates coordinates = placementScope.getCoordinates();
                                        if (coordinates != null) {
                                            if (measureScope.isLookingAhead()) {
                                                sharedTransitionScopeImpl2.setNullableLookaheadRoot$animation_release(coordinates);
                                            } else {
                                                sharedTransitionScopeImpl2.setRoot$animation_release(coordinates);
                                            }
                                        }
                                        Placeable.PlacementScope.place$default(placementScope, placeableMo19855measureBRTryo0, 0, 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    Modifier modifierLayout = LayoutModifierKt.layout(companion2, (Function3) objRememberedValue3);
                    Object objRememberedValue4 = composer2.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1$2$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                                invoke2(contentDrawScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull ContentDrawScope contentDrawScope) {
                                contentDrawScope.drawContent();
                                sharedTransitionScopeImpl.drawInOverlay$animation_release(contentDrawScope);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    function42.invoke(sharedTransitionScopeImpl, DrawModifierKt.drawWithContent(modifierLayout, (Function1) objRememberedValue4), composer2, 6);
                    Unit unit = Unit.INSTANCE;
                    Object objRememberedValue5 = composer2.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1$3$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            @NotNull
                            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                                final SharedTransitionScopeImpl sharedTransitionScopeImpl2 = sharedTransitionScopeImpl;
                                return new DisposableEffectResult() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1$3$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        SharedTransitionScopeKt.getSharedTransitionObserver().clear(sharedTransitionScopeImpl2);
                                    }
                                };
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    EffectsKt.DisposableEffect(unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue5, composer2, 54);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt.SharedTransitionScope.2
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

                public final void invoke(@Nullable Composer composer2, int i4) {
                    SharedTransitionScopeKt.SharedTransitionScope(function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier createContentScaleModifier(Modifier modifier, ScaleToBoundsImpl scaleToBoundsImpl, final Function0<Boolean> function0) {
        return modifier.then(Intrinsics.areEqual(scaleToBoundsImpl.getContentScale(), ContentScale.INSTANCE.getCrop()) ? GraphicsLayerModifierKt.graphicsLayer(Modifier.INSTANCE, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt.createContentScaleModifier.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GraphicsLayerScope graphicsLayerScope) {
                graphicsLayerScope.setClip(function0.invoke().booleanValue());
            }
        }) : Modifier.INSTANCE).then(new SkipToLookaheadElement(scaleToBoundsImpl, function0));
    }

    @NotNull
    public static final SnapshotStateObserver getSharedTransitionObserver() {
        return (SnapshotStateObserver) SharedTransitionObserver$delegate.getValue();
    }

    private static final boolean getShouldCache(Alignment alignment) {
        Alignment.Companion companion = Alignment.INSTANCE;
        return alignment == companion.getTopStart() || alignment == companion.getTopCenter() || alignment == companion.getTopEnd() || alignment == companion.getCenterStart() || alignment == companion.getCenter() || alignment == companion.getCenterEnd() || alignment == companion.getBottomStart() || alignment == companion.getBottomCenter() || alignment == companion.getBottomEnd();
    }

    private static final boolean getShouldCache(ContentScale contentScale) {
        ContentScale.Companion companion = ContentScale.INSTANCE;
        return contentScale == companion.getFillWidth() || contentScale == companion.getFillHeight() || contentScale == companion.getFillBounds() || contentScale == companion.getFit() || contentScale == companion.getCrop() || contentScale == companion.getNone() || contentScale == companion.getInside();
    }

    @ExperimentalSharedTransitionApi
    private static /* synthetic */ void getCachedScaleToBoundsImplMap$annotations() {
    }

    @ExperimentalSharedTransitionApi
    private static /* synthetic */ void getDefaultBoundsTransform$annotations() {
    }

    @ExperimentalSharedTransitionApi
    private static /* synthetic */ void getParentClip$annotations() {
    }
}
