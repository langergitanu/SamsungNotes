package androidx.compose.foundation.text.selection;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.p109ui.AbsoluteAlignment;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.CacheDrawScope;
import androidx.compose.p109ui.draw.DrawModifierKt;
import androidx.compose.p109ui.draw.DrawResult;
import androidx.compose.p109ui.geometry.InlineClassHelperKt;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.BlendMode;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.CanvasKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorFilter;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.graphics.ImageBitmap;
import androidx.compose.p109ui.graphics.ImageBitmapConfig;
import androidx.compose.p109ui.graphics.ImageBitmapKt;
import androidx.compose.p109ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawContext;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.text.style.ResolvedTextDirection;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.p109ui.window.AndroidPopup_androidKt;
import androidx.compose.p109ui.window.PopupProperties;
import androidx.compose.p109ui.window.SecureFlagPolicy;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010\t\u001aD\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a+\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u0019\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010\u001b\u001a\u00020\u001c*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\"\u0010 \u001a\u00020\u0014*\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u0019\u001a\u00020\rH\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, m13886d2 = {"HandlePopup", "", "positionProvider", "Landroidx/compose/foundation/text/selection/OffsetProvider;", "handleReferencePoint", "Landroidx/compose/ui/Alignment;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/text/selection/OffsetProvider;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionHandle", "offsetProvider", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "handlesCrossed", "minTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "modifier", "Landroidx/compose/ui/Modifier;", "SelectionHandle-pzduO1o", "(Landroidx/compose/foundation/text/selection/OffsetProvider;ZLandroidx/compose/ui/text/style/ResolvedTextDirection;ZJLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SelectionHandleIcon", "iconVisible", "isLeft", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "createHandleImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "Landroidx/compose/ui/draw/CacheDrawScope;", "radius", "", "drawSelectionHandle", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAndroidSelectionHandles.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidSelectionHandles.android.kt\nandroidx/compose/foundation/text/selection/AndroidSelectionHandles_androidKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 4 CanvasDrawScope.kt\nandroidx/compose/ui/graphics/drawscope/CanvasDrawScope\n*L\n1#1,258:1\n1225#2,6:259\n1225#2,6:283\n77#3:265\n546#4,17:266\n*S KotlinDebug\n*F\n+ 1 AndroidSelectionHandles.android.kt\nandroidx/compose/foundation/text/selection/AndroidSelectionHandles_androidKt\n*L\n70#1:259,6\n249#1:283,6\n81#1:265\n213#1:266,17\n*E\n"})
public final class AndroidSelectionHandles_androidKt {
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void HandlePopup(@NotNull final OffsetProvider offsetProvider, @NotNull final Alignment alignment, @NotNull final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(476043083);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(offsetProvider) : composerStartRestartGroup.changedInstance(offsetProvider) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(alignment) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(476043083, i2, -1, "androidx.compose.foundation.text.selection.HandlePopup (AndroidSelectionHandles.android.kt:247)");
            }
            boolean z = false;
            boolean z2 = (i2 & 112) == 32;
            if ((i2 & 14) == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changed(offsetProvider))) {
                z = true;
            }
            boolean z3 = z2 | z;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new HandlePositionProvider(alignment, offsetProvider);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            AndroidPopup_androidKt.Popup((HandlePositionProvider) objRememberedValue, null, new PopupProperties(false, false, false, (SecureFlagPolicy) null, true, false, 15, (DefaultConstructorMarker) null), function2, composerStartRestartGroup, ((i2 << 3) & 7168) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt.HandlePopup.1
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
                    AndroidSelectionHandles_androidKt.HandlePopup(offsetProvider, alignment, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011f  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: SelectionHandle-pzduO1o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16492SelectionHandlepzduO1o(@NotNull final OffsetProvider offsetProvider, final boolean z, @NotNull ResolvedTextDirection resolvedTextDirection, boolean z2, long j, @NotNull final Modifier modifier, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        ResolvedTextDirection resolvedTextDirection2;
        boolean z3;
        long jM21075getUnspecifiedMYxV2XQ;
        final boolean zIsLeftSelectionHandle;
        boolean zChanged;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-843755800);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = ((i & 8) == 0 ? composerStartRestartGroup.changed(offsetProvider) : composerStartRestartGroup.changedInstance(offsetProvider) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i4 |= 384;
            resolvedTextDirection2 = resolvedTextDirection;
        } else {
            resolvedTextDirection2 = resolvedTextDirection;
            if ((i & 384) == 0) {
                i4 |= composerStartRestartGroup.changed(resolvedTextDirection2) ? 256 : 128;
            }
        }
        if ((i2 & 8) != 0) {
            i4 |= 3072;
            z3 = z2;
        } else {
            z3 = z2;
            if ((i & 3072) == 0) {
                i4 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
            }
        }
        if ((i & 24576) == 0) {
            jM21075getUnspecifiedMYxV2XQ = j;
            i4 |= ((i2 & 16) == 0 && composerStartRestartGroup.changed(jM21075getUnspecifiedMYxV2XQ)) ? 16384 : 8192;
        } else {
            jM21075getUnspecifiedMYxV2XQ = j;
        }
        if ((i2 & 32) != 0) {
            i4 |= 196608;
        } else if ((i & 196608) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 131072 : 65536;
        }
        if ((74899 & i4) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 16) != 0) {
                    jM21075getUnspecifiedMYxV2XQ = DpSize.INSTANCE.m21075getUnspecifiedMYxV2XQ();
                    i4 &= -57345;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-843755800, i4, -1, "androidx.compose.foundation.text.selection.SelectionHandle (AndroidSelectionHandles.android.kt:64)");
                }
                zIsLeftSelectionHandle = SelectionHandlesKt.isLeftSelectionHandle(z, resolvedTextDirection, z2);
                AbsoluteAlignment absoluteAlignment = AbsoluteAlignment.INSTANCE;
                Alignment topRight = !zIsLeftSelectionHandle ? absoluteAlignment.getTopRight() : absoluteAlignment.getTopLeft();
                int i5 = i4 & 14;
                zChanged = ((i4 & 112) != 32) | (i5 != 4 || ((i4 & 8) != 0 && composerStartRestartGroup.changedInstance(offsetProvider))) | composerStartRestartGroup.changed(zIsLeftSelectionHandle);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$semanticsModifier$1$1
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
                        public final void invoke2(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            long jMo16143provideF1C5BW0 = offsetProvider.mo16143provideF1C5BW0();
                            semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(z ? Handle.SelectionStart : Handle.SelectionEnd, jMo16143provideF1C5BW0, zIsLeftSelectionHandle ? SelectionHandleAnchor.Left : SelectionHandleAnchor.Right, OffsetKt.m18303isSpecifiedk4lQ0M(jMo16143provideF1C5BW0), null));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue, 1, null);
                final ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                final long j2 = jM21075getUnspecifiedMYxV2XQ;
                HandlePopup(offsetProvider, topRight, ComposableLambdaKt.rememberComposableLambda(280174801, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        if ((i6 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(280174801, i6, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:82)");
                        }
                        ProvidedValue<ViewConfiguration> providedValueProvides = CompositionLocalsKt.getLocalViewConfiguration().provides(viewConfiguration);
                        final long j3 = j2;
                        final boolean z4 = zIsLeftSelectionHandle;
                        final Modifier modifier2 = modifierSemantics$default;
                        final OffsetProvider offsetProvider2 = offsetProvider;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(-1426434671, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            public final void invoke(@Nullable Composer composer3, int i7) {
                                if ((i7 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1426434671, i7, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous>.<anonymous> (AndroidSelectionHandles.android.kt:83)");
                                }
                                if (j3 != InlineClassHelperKt.UnspecifiedPackedFloats) {
                                    composer3.startReplaceGroup(-837727128);
                                    Arrangement.Horizontal right = z4 ? Arrangement.Absolute.INSTANCE.getRight() : Arrangement.Absolute.INSTANCE.getLeft();
                                    Modifier modifierM15895requiredSizeInqDBjuR0$default = SizeKt.m15895requiredSizeInqDBjuR0$default(modifier2, DpSize.m21066getWidthD9Ej5fM(j3), DpSize.m21064getHeightD9Ej5fM(j3), 0.0f, 0.0f, 12, null);
                                    final OffsetProvider offsetProvider3 = offsetProvider2;
                                    boolean z5 = z4;
                                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(right, Alignment.INSTANCE.getTop(), composer3, 0);
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierM15895requiredSizeInqDBjuR0$default);
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                    if (composer3.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer3);
                                    Function2 function2M1177w = AbstractC0622a.m1177w(companion, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
                                    if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                                    }
                                    Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    boolean zChangedInstance = composer3.changedInstance(offsetProvider3);
                                    Object objRememberedValue2 = composer3.rememberedValue();
                                    if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1$1$1$1$1
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            @NotNull
                                            public final Boolean invoke() {
                                                return Boolean.valueOf(OffsetKt.m18303isSpecifiedk4lQ0M(offsetProvider3.mo16143provideF1C5BW0()));
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue2);
                                    }
                                    AndroidSelectionHandles_androidKt.SelectionHandleIcon(companion2, (Function0) objRememberedValue2, z5, composer3, 6);
                                    composer3.endNode();
                                    composer3.endReplaceGroup();
                                } else {
                                    composer3.startReplaceGroup(-836867312);
                                    Modifier modifier3 = modifier2;
                                    boolean zChangedInstance2 = composer3.changedInstance(offsetProvider2);
                                    final OffsetProvider offsetProvider4 = offsetProvider2;
                                    Object objRememberedValue3 = composer3.rememberedValue();
                                    if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue3 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1$1$2$1
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            @NotNull
                                            public final Boolean invoke() {
                                                return Boolean.valueOf(OffsetKt.m18303isSpecifiedk4lQ0M(offsetProvider4.mo16143provideF1C5BW0()));
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue3);
                                    }
                                    AndroidSelectionHandles_androidKt.SelectionHandleIcon(modifier3, (Function0) objRememberedValue3, z4, composer3, 0);
                                    composer3.endReplaceGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, i5 | 384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                jM21075getUnspecifiedMYxV2XQ = j2;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 16) != 0) {
                    i4 &= -57345;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                zIsLeftSelectionHandle = SelectionHandlesKt.isLeftSelectionHandle(z, resolvedTextDirection, z2);
                AbsoluteAlignment absoluteAlignment2 = AbsoluteAlignment.INSTANCE;
                Alignment topRight2 = !zIsLeftSelectionHandle ? absoluteAlignment2.getTopRight() : absoluteAlignment2.getTopLeft();
                int i52 = i4 & 14;
                if (i52 != 4) {
                    zChanged = ((i4 & 112) != 32) | (i52 != 4 || ((i4 & 8) != 0 && composerStartRestartGroup.changedInstance(offsetProvider))) | composerStartRestartGroup.changed(zIsLeftSelectionHandle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$semanticsModifier$1$1
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
                            public final void invoke2(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                long jMo16143provideF1C5BW0 = offsetProvider.mo16143provideF1C5BW0();
                                semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(z ? Handle.SelectionStart : Handle.SelectionEnd, jMo16143provideF1C5BW0, zIsLeftSelectionHandle ? SelectionHandleAnchor.Left : SelectionHandleAnchor.Right, OffsetKt.m18303isSpecifiedk4lQ0M(jMo16143provideF1C5BW0), null));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        final Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue, 1, null);
                        final ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        final long j22 = jM21075getUnspecifiedMYxV2XQ;
                        HandlePopup(offsetProvider, topRight2, ComposableLambdaKt.rememberComposableLambda(280174801, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                if ((i6 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(280174801, i6, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:82)");
                                }
                                ProvidedValue<ViewConfiguration> providedValueProvides = CompositionLocalsKt.getLocalViewConfiguration().provides(viewConfiguration2);
                                final long j3 = j22;
                                final boolean z4 = zIsLeftSelectionHandle;
                                final Modifier modifier2 = modifierSemantics$default2;
                                final OffsetProvider offsetProvider2 = offsetProvider;
                                CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(-1426434671, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    public final void invoke(@Nullable Composer composer3, int i7) {
                                        if ((i7 & 3) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1426434671, i7, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous>.<anonymous> (AndroidSelectionHandles.android.kt:83)");
                                        }
                                        if (j3 != InlineClassHelperKt.UnspecifiedPackedFloats) {
                                            composer3.startReplaceGroup(-837727128);
                                            Arrangement.Horizontal right = z4 ? Arrangement.Absolute.INSTANCE.getRight() : Arrangement.Absolute.INSTANCE.getLeft();
                                            Modifier modifierM15895requiredSizeInqDBjuR0$default = SizeKt.m15895requiredSizeInqDBjuR0$default(modifier2, DpSize.m21066getWidthD9Ej5fM(j3), DpSize.m21064getHeightD9Ej5fM(j3), 0.0f, 0.0f, 12, null);
                                            final OffsetProvider offsetProvider3 = offsetProvider2;
                                            boolean z5 = z4;
                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(right, Alignment.INSTANCE.getTop(), composer3, 0);
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierM15895requiredSizeInqDBjuR0$default);
                                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                                            if (composer3.getApplier() == null) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor);
                                            } else {
                                                composer3.useNode();
                                            }
                                            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer3);
                                            Function2 function2M1177w = AbstractC0622a.m1177w(companion, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
                                            if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                                            }
                                            Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                            boolean zChangedInstance = composer3.changedInstance(offsetProvider3);
                                            Object objRememberedValue2 = composer3.rememberedValue();
                                            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue2 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1$1$1$1$1
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    @NotNull
                                                    public final Boolean invoke() {
                                                        return Boolean.valueOf(OffsetKt.m18303isSpecifiedk4lQ0M(offsetProvider3.mo16143provideF1C5BW0()));
                                                    }
                                                };
                                                composer3.updateRememberedValue(objRememberedValue2);
                                            }
                                            AndroidSelectionHandles_androidKt.SelectionHandleIcon(companion2, (Function0) objRememberedValue2, z5, composer3, 6);
                                            composer3.endNode();
                                            composer3.endReplaceGroup();
                                        } else {
                                            composer3.startReplaceGroup(-836867312);
                                            Modifier modifier3 = modifier2;
                                            boolean zChangedInstance2 = composer3.changedInstance(offsetProvider2);
                                            final OffsetProvider offsetProvider4 = offsetProvider2;
                                            Object objRememberedValue3 = composer3.rememberedValue();
                                            if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue3 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1$1$2$1
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    @NotNull
                                                    public final Boolean invoke() {
                                                        return Boolean.valueOf(OffsetKt.m18303isSpecifiedk4lQ0M(offsetProvider4.mo16143provideF1C5BW0()));
                                                    }
                                                };
                                                composer3.updateRememberedValue(objRememberedValue3);
                                            }
                                            AndroidSelectionHandles_androidKt.SelectionHandleIcon(modifier3, (Function0) objRememberedValue3, z4, composer3, 0);
                                            composer3.endReplaceGroup();
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, i52 | 384);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        jM21075getUnspecifiedMYxV2XQ = j22;
                    }
                }
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final ResolvedTextDirection resolvedTextDirection3 = resolvedTextDirection2;
            final boolean z4 = z3;
            final long j3 = jM21075getUnspecifiedMYxV2XQ;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i6) {
                    AndroidSelectionHandles_androidKt.m16492SelectionHandlepzduO1o(offsetProvider, z, resolvedTextDirection3, z4, j3, modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SelectionHandleIcon(@NotNull final Modifier modifier, @NotNull final Function0<Boolean> function0, final boolean z, @Nullable Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2111672474);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2111672474, i2, -1, "androidx.compose.foundation.text.selection.SelectionHandleIcon (AndroidSelectionHandles.android.kt:122)");
            }
            SpacerKt.Spacer(drawSelectionHandle(SizeKt.m15901sizeVpY3zN4(modifier, SelectionHandlesKt.getHandleWidth(), SelectionHandlesKt.getHandleHeight()), function0, z), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt.SelectionHandleIcon.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    AndroidSelectionHandles_androidKt.SelectionHandleIcon(modifier, function0, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @NotNull
    public static final ImageBitmap createHandleImage(@NotNull CacheDrawScope cacheDrawScope, float f) {
        int iCeil = ((int) Math.ceil(f)) * 2;
        HandleImageCache handleImageCache = HandleImageCache.INSTANCE;
        ImageBitmap imageBitmap = handleImageCache.getImageBitmap();
        Canvas canvas = handleImageCache.getCanvas();
        CanvasDrawScope canvasDrawScope = handleImageCache.getCanvasDrawScope();
        if (imageBitmap == null || canvas == null || iCeil > imageBitmap.getWidth() || iCeil > imageBitmap.getHeight()) {
            imageBitmap = ImageBitmapKt.m18751ImageBitmapx__hDU$default(iCeil, iCeil, ImageBitmapConfig.INSTANCE.m18745getAlpha8_sVssgQ(), false, null, 24, null);
            handleImageCache.setImageBitmap(imageBitmap);
            canvas = CanvasKt.Canvas(imageBitmap);
            handleImageCache.setCanvas(canvas);
        }
        ImageBitmap imageBitmap2 = imageBitmap;
        Canvas canvas2 = canvas;
        if (canvasDrawScope == null) {
            canvasDrawScope = new CanvasDrawScope();
            handleImageCache.setCanvasDrawScope(canvasDrawScope);
        }
        CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
        LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
        long jSize = androidx.compose.p109ui.geometry.SizeKt.Size(imageBitmap2.getWidth(), imageBitmap2.getHeight());
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope2.getDrawParams();
        Density density = drawParams.getDensity();
        LayoutDirection layoutDirection2 = drawParams.getLayoutDirection();
        Canvas canvas3 = drawParams.getCanvas();
        long size = drawParams.getSize();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope2.getDrawParams();
        drawParams2.setDensity(cacheDrawScope);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas2);
        drawParams2.m18996setSizeuvyYCjk(jSize);
        canvas2.save();
        DrawScope.m19070drawRectnJ9OG0$default(canvasDrawScope2, Color.INSTANCE.m18551getBlack0d7_KjU(), 0L, canvasDrawScope2.mo19076getSizeNHjbRc(), 0.0f, null, null, BlendMode.INSTANCE.m18440getClear0nO6VwU(), 58, null);
        DrawScope.m19070drawRectnJ9OG0$default(canvasDrawScope2, ColorKt.Color(4278190080L), Offset.INSTANCE.m18300getZeroF1C5BW0(), androidx.compose.p109ui.geometry.SizeKt.Size(f, f), 0.0f, null, null, 0, 120, null);
        DrawScope.m19057drawCircleVaOC9Bg$default(canvasDrawScope2, ColorKt.Color(4278190080L), f, OffsetKt.Offset(f, f), 0.0f, null, null, 0, 120, null);
        canvas2.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope2.getDrawParams();
        drawParams3.setDensity(density);
        drawParams3.setLayoutDirection(layoutDirection2);
        drawParams3.setCanvas(canvas3);
        drawParams3.m18996setSizeuvyYCjk(size);
        return imageBitmap2;
    }

    @NotNull
    public static final Modifier drawSelectionHandle(@NotNull Modifier modifier, @NotNull final Function0<Boolean> function0, final boolean z) {
        return ComposedModifierKt.composed$default(modifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt.drawSelectionHandle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier modifier2, @Nullable Composer composer, int i) {
                composer.startReplaceGroup(-196777734);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-196777734, i, -1, "androidx.compose.foundation.text.selection.drawSelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:134)");
                }
                final long handleColor = ((TextSelectionColors) composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).getHandleColor();
                boolean zChanged = composer.changed(handleColor) | composer.changed(function0) | composer.changed(z);
                final Function0<Boolean> function02 = function0;
                final boolean z2 = z;
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final DrawResult invoke(@NotNull CacheDrawScope cacheDrawScope) {
                            final ImageBitmap imageBitmapCreateHandleImage = AndroidSelectionHandles_androidKt.createHandleImage(cacheDrawScope, Size.m18353getWidthimpl(cacheDrawScope.m18174getSizeNHjbRc()) / 2.0f);
                            final ColorFilter colorFilterM18566tintxETnrds$default = ColorFilter.Companion.m18566tintxETnrds$default(ColorFilter.INSTANCE, handleColor, 0, 2, null);
                            final Function0<Boolean> function03 = function02;
                            final boolean z3 = z2;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    if (function03.invoke().booleanValue()) {
                                        if (!z3) {
                                            DrawScope.m19060drawImagegbVJVH8$default(contentDrawScope, imageBitmapCreateHandleImage, 0L, 0.0f, null, colorFilterM18566tintxETnrds$default, 0, 46, null);
                                            return;
                                        }
                                        ImageBitmap imageBitmap = imageBitmapCreateHandleImage;
                                        ColorFilter colorFilter = colorFilterM18566tintxETnrds$default;
                                        long jMo19075getCenterF1C5BW0 = contentDrawScope.mo19075getCenterF1C5BW0();
                                        DrawContext drawContext = contentDrawScope.getDrawContext();
                                        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
                                        drawContext.getCanvas().save();
                                        try {
                                            drawContext.getTransform().mo19004scale0AR0LA0(-1.0f, 1.0f, jMo19075getCenterF1C5BW0);
                                            DrawScope.m19060drawImagegbVJVH8$default(contentDrawScope, imageBitmap, 0L, 0.0f, null, colorFilter, 0, 46, null);
                                        } finally {
                                            AbstractC0622a.m1179y(drawContext, jMo18997getSizeNHjbRc);
                                        }
                                    }
                                }
                            });
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierDrawWithCache = DrawModifierKt.drawWithCache(modifier2, (Function1) objRememberedValue);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierDrawWithCache;
            }
        }, 1, null);
    }
}
