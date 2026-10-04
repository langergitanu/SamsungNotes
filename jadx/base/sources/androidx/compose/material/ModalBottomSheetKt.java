package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import androidx.compose.p109ui.input.pointer.SuspendingPointerInputFilterKt;
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
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u001a\u008c\u0001\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a3\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a;\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001b0\u0003H\u0007¢\u0006\u0002\u0010%\u001aC\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010&\u001a\u00020\u001b2\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001b0\u0003H\u0007¢\u0006\u0002\u0010'\u001a,\u0010(\u001a\u00020\b*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010)\u001a\u00020#2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0+H\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006,"}, m13886d2 = {"ModalBottomSheetLayout", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material/ModalBottomSheetState;", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "Landroidx/compose/ui/unit/Dp;", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "scrimColor", "content", "Lkotlin/Function0;", "ModalBottomSheetLayout-BzaUkTc", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ModalBottomSheetState;Landroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "color", "onDismiss", "visible", "", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberModalBottomSheetState", "initialValue", "Landroidx/compose/material/ModalBottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "skipHalfExpanded", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "bottomSheetSwipeable", "fullHeight", "sheetHeightState", "Landroidx/compose/runtime/State;", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ModalBottomSheetKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0287 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0113  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ModalBottomSheetLayout-BzaUkTc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16789ModalBottomSheetLayoutBzaUkTc(@NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> sheetContent, @Nullable Modifier modifier, @Nullable ModalBottomSheetState modalBottomSheetState, @Nullable Shape shape, float f, long j, long j2, long j3, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        final int i4;
        ModalBottomSheetState modalBottomSheetState2;
        Shape shape2;
        int i5;
        float f4;
        long j5;
        int i6;
        long j6;
        int i7;
        int i8;
        Composer composer2;
        ModalBottomSheetState modalBottomSheetStateRememberModalBottomSheetState;
        Shape large;
        long jM16680getSurface0d7_KjU;
        long jM16694contentColorForek8zF_U;
        ModalBottomSheetState modalBottomSheetState3;
        Modifier modifier2;
        final float f5;
        final long j7;
        final long scrimColor;
        ModalBottomSheetState modalBottomSheetState4;
        Object objRememberedValue;
        Composer composer3;
        final float f6;
        final long j8;
        final long j9;
        final Modifier modifier3;
        final Shape shape3;
        final ModalBottomSheetState modalBottomSheetState5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        Intrinsics.checkNotNullParameter(sheetContent, "sheetContent");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1633763156);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(sheetContent) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    modalBottomSheetState2 = modalBottomSheetState;
                    int i11 = composerStartRestartGroup.changed(modalBottomSheetState2) ? 256 : 128;
                    i4 |= i11;
                } else {
                    modalBottomSheetState2 = modalBottomSheetState;
                }
                i4 |= i11;
            } else {
                modalBottomSheetState2 = modalBottomSheetState;
            }
            if ((i & 7168) != 0) {
                shape2 = shape;
                i4 |= ((i2 & 8) == 0 && composerStartRestartGroup.changed(shape2)) ? 2048 : 1024;
            } else {
                shape2 = shape;
            }
            i5 = i2 & 16;
            if (i5 == 0) {
                i4 |= 24576;
                f4 = f;
            } else {
                f4 = f;
                if ((57344 & i) == 0) {
                    i4 |= composerStartRestartGroup.changed(f4) ? 16384 : 8192;
                }
            }
            if ((458752 & i) != 0) {
                j5 = j;
                i4 |= ((i2 & 32) == 0 && composerStartRestartGroup.changed(j5)) ? 131072 : 65536;
            } else {
                j5 = j;
            }
            if ((3670016 & i) == 0) {
                i4 |= ((i2 & 64) == 0 && composerStartRestartGroup.changed(j2)) ? 1048576 : 524288;
            }
            if ((29360128 & i) != 0) {
                i6 = i10;
                j6 = j3;
                i4 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(j6)) ? 8388608 : 4194304;
            } else {
                i6 = i10;
                j6 = j3;
            }
            if ((i2 & 256) != 0) {
                i9 = (234881024 & i) == 0 ? composerStartRestartGroup.changed(content) ? 67108864 : 33554432 : 100663296;
                if ((191739611 & i4) == 38347922 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier;
                    composer3 = composerStartRestartGroup;
                    f6 = f4;
                    scrimColor = j6;
                    modalBottomSheetState5 = modalBottomSheetState2;
                    shape3 = shape2;
                    j9 = j5;
                    j8 = j2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier modifier4 = i6 == 0 ? Modifier.INSTANCE : modifier;
                        if ((i2 & 4) == 0) {
                            int i12 = i4;
                            i7 = -29360129;
                            modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, null, null, composerStartRestartGroup, 6, 6);
                            composer2 = composerStartRestartGroup;
                            i8 = i12 & (-897);
                        } else {
                            i7 = -29360129;
                            i8 = i4;
                            composer2 = composerStartRestartGroup;
                            modalBottomSheetStateRememberModalBottomSheetState = modalBottomSheetState2;
                        }
                        if ((i2 & 8) == 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                            i8 &= -7169;
                        } else {
                            large = shape2;
                        }
                        float fM16788getElevationD9Ej5fM = i5 == 0 ? ModalBottomSheetDefaults.INSTANCE.m16788getElevationD9Ej5fM() : f4;
                        if ((i2 & 32) == 0) {
                            jM16680getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composer2, 6).m16680getSurface0d7_KjU();
                            i8 &= -458753;
                        } else {
                            jM16680getSurface0d7_KjU = j5;
                        }
                        if ((i2 & 64) == 0) {
                            jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(jM16680getSurface0d7_KjU, composer2, (i8 >> 15) & 14);
                            i8 &= -3670017;
                        } else {
                            jM16694contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 128) == 0) {
                            ModalBottomSheetState modalBottomSheetState6 = modalBottomSheetStateRememberModalBottomSheetState;
                            i4 = i8 & i7;
                            modalBottomSheetState3 = modalBottomSheetState6;
                            f5 = fM16788getElevationD9Ej5fM;
                            j7 = jM16694contentColorForek8zF_U;
                            scrimColor = ModalBottomSheetDefaults.INSTANCE.getScrimColor(composer2, 6);
                            j5 = jM16680getSurface0d7_KjU;
                            modifier2 = modifier4;
                        } else {
                            ModalBottomSheetState modalBottomSheetState7 = modalBottomSheetStateRememberModalBottomSheetState;
                            i4 = i8;
                            modalBottomSheetState3 = modalBottomSheetState7;
                            modifier2 = modifier4;
                            j5 = jM16680getSurface0d7_KjU;
                            f5 = fM16788getElevationD9Ej5fM;
                            j7 = jM16694contentColorForek8zF_U;
                            scrimColor = j3;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i4 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i4 &= -7169;
                        }
                        if ((i2 & 32) != 0) {
                            i4 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            i4 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i4 &= -29360129;
                        }
                        large = shape2;
                        f5 = f4;
                        scrimColor = j6;
                        modifier2 = modifier;
                        composer2 = composerStartRestartGroup;
                        modalBottomSheetState3 = modalBottomSheetState2;
                        j7 = j2;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        modalBottomSheetState4 = modalBottomSheetState3;
                    } else {
                        modalBottomSheetState4 = modalBottomSheetState3;
                        ComposerKt.traceEventStart(-1633763156, i4, -1, "androidx.compose.material.ModalBottomSheetLayout (ModalBottomSheet.kt:312)");
                    }
                    composer2.startReplaceableGroup(773894976);
                    composer2.startReplaceableGroup(-492369756);
                    objRememberedValue = composer2.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2), composer2);
                    }
                    composer2.endReplaceableGroup();
                    final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composer2.endReplaceableGroup();
                    Composer composer4 = composer2;
                    final Shape shape4 = large;
                    final long j10 = j5;
                    composer3 = composer4;
                    final ModalBottomSheetState modalBottomSheetState8 = modalBottomSheetState4;
                    Modifier modifier5 = modifier2;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier5, null, false, ComposableLambdaKt.composableLambda(composer3, 1607356310, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer5, Integer num) {
                            invoke(boxWithConstraintsScope, composer5, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                        @Composable
                        public final void invoke(@NotNull BoxWithConstraintsScope BoxWithConstraints, @Nullable Composer composer5, int i13) {
                            int i14;
                            final float f7;
                            Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                            if ((i13 & 14) == 0) {
                                i14 = (composer5.changed(BoxWithConstraints) ? 4 : 2) | i13;
                            } else {
                                i14 = i13;
                            }
                            if ((i14 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1607356310, i13, -1, "androidx.compose.material.ModalBottomSheetLayout.<anonymous> (ModalBottomSheet.kt:325)");
                            }
                            float fM20920getMaxHeightimpl = Constraints.m20920getMaxHeightimpl(BoxWithConstraints.mo15761getConstraintsmsEJaDk());
                            composer5.startReplaceableGroup(-492369756);
                            Object objRememberedValue2 = composer5.rememberedValue();
                            Composer.Companion companion = Composer.INSTANCE;
                            if (objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composer5.updateRememberedValue(objRememberedValue2);
                            }
                            composer5.endReplaceableGroup();
                            final MutableState mutableState = (MutableState) objRememberedValue2;
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
                            Function2<Composer, Integer, Unit> function2 = content;
                            int i15 = i4;
                            long j11 = scrimColor;
                            final ModalBottomSheetState modalBottomSheetState9 = modalBottomSheetState8;
                            final CoroutineScope coroutineScope2 = coroutineScope;
                            composer5.startReplaceableGroup(733328855);
                            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer5, 0, -1323940314);
                            Density density = (Density) composer5.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection = (LayoutDirection) composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion3.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierFillMaxSize$default);
                            if (composer5.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composer5.startReusableNode();
                            if (composer5.getInserting()) {
                                composer5.createNode(constructor);
                            } else {
                                composer5.useNode();
                            }
                            composer5.disableReusing();
                            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer5);
                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer5, composer5), composer5, 2058660585);
                            composer5.startReplaceableGroup(-2137368960);
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composer5.startReplaceableGroup(-402723888);
                            function2.invoke(composer5, Integer.valueOf((i15 >> 24) & 14));
                            ModalBottomSheetKt.m16790Scrim3JVO9M(j11, new Function0<Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1

                                /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1 */
                                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                @DebugMetadata(m14020c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1", m14021f = "ModalBottomSheet.kt", m14022i = {}, m14023l = {335}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                public static final class C15561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ ModalBottomSheetState $sheetState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    public C15561(ModalBottomSheetState modalBottomSheetState, Continuation<? super C15561> continuation) {
                                        super(2, continuation);
                                        this.$sheetState = modalBottomSheetState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    @NotNull
                                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                        return new C15561(this.$sheetState, continuation);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    @Nullable
                                    public final Object invokeSuspend(@NotNull Object obj) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                                            this.label = 1;
                                            if (modalBottomSheetState.hide(this) == coroutine_suspended) {
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
                                        return ((C15561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                                    if (modalBottomSheetState9.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C15561(modalBottomSheetState9, null), 3, null);
                                    }
                                }
                            }, modalBottomSheetState9.getTargetValue() != ModalBottomSheetValue.Hidden, composer5, (i15 >> 21) & 14);
                            composer5.endReplaceableGroup();
                            composer5.endReplaceableGroup();
                            composer5.endReplaceableGroup();
                            composer5.endNode();
                            composer5.endReplaceableGroup();
                            composer5.endReplaceableGroup();
                            Modifier modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), modalBottomSheetState8.getNestedScrollConnection(), null, 2, null);
                            Object obj = modalBottomSheetState8;
                            Object objValueOf = Float.valueOf(fM20920getMaxHeightimpl);
                            final ModalBottomSheetState modalBottomSheetState10 = modalBottomSheetState8;
                            composer5.startReplaceableGroup(511388516);
                            boolean zChanged = composer5.changed(obj) | composer5.changed(objValueOf);
                            Object objRememberedValue3 = composer5.rememberedValue();
                            if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                                f7 = fM20920getMaxHeightimpl;
                                objRememberedValue3 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density2) {
                                        return IntOffset.m21087boximpl(m16794invokeBjo55l4(density2));
                                    }

                                    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                                    public final long m16794invokeBjo55l4(@NotNull Density offset) {
                                        Intrinsics.checkNotNullParameter(offset, "$this$offset");
                                        return IntOffsetKt.IntOffset(0, modalBottomSheetState10.getAnchors$material_release().isEmpty() ? MathKt.roundToInt(f7) : MathKt.roundToInt(modalBottomSheetState10.getOffset().getValue().floatValue()));
                                    }
                                };
                                composer5.updateRememberedValue(objRememberedValue3);
                            } else {
                                f7 = fM20920getMaxHeightimpl;
                            }
                            composer5.endReplaceableGroup();
                            Modifier modifierBottomSheetSwipeable = ModalBottomSheetKt.bottomSheetSwipeable(OffsetKt.offset(modifierNestedScroll$default, (Function1) objRememberedValue3), modalBottomSheetState8, f7, mutableState);
                            composer5.startReplaceableGroup(1157296644);
                            boolean zChanged2 = composer5.changed(mutableState);
                            Object objRememberedValue4 = composer5.rememberedValue();
                            if (zChanged2 || objRememberedValue4 == companion.getEmpty()) {
                                objRememberedValue4 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1
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
                                        mutableState.setValue(Float.valueOf(IntSize.m21137getHeightimpl(it.mo19863getSizeYbymL2g())));
                                    }
                                };
                                composer5.updateRememberedValue(objRememberedValue4);
                            }
                            composer5.endReplaceableGroup();
                            Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierBottomSheetSwipeable, (Function1) objRememberedValue4);
                            final ModalBottomSheetState modalBottomSheetState11 = modalBottomSheetState8;
                            final CoroutineScope coroutineScope3 = coroutineScope;
                            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierOnGloballyPositioned, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1.4
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
                                    if (modalBottomSheetState11.isVisible()) {
                                        final ModalBottomSheetState modalBottomSheetState12 = modalBottomSheetState11;
                                        final CoroutineScope coroutineScope4 = coroutineScope3;
                                        SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.1.4.1

                                            /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$1$1, reason: invalid class name and collision with other inner class name */
                                            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                            @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                            @DebugMetadata(m14020c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$1$1", m14021f = "ModalBottomSheet.kt", m14022i = {}, m14023l = {363}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                            public static final class C145491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ ModalBottomSheetState $sheetState;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                public C145491(ModalBottomSheetState modalBottomSheetState, Continuation<? super C145491> continuation) {
                                                    super(2, continuation);
                                                    this.$sheetState = modalBottomSheetState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                @NotNull
                                                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                                    return new C145491(this.$sheetState, continuation);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                @Nullable
                                                public final Object invokeSuspend(@NotNull Object obj) {
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    int i = this.label;
                                                    if (i == 0) {
                                                        ResultKt.throwOnFailure(obj);
                                                        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                                                        this.label = 1;
                                                        if (modalBottomSheetState.hide(this) == coroutine_suspended) {
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
                                                    return ((C145491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                                                if (modalBottomSheetState12.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, null, new C145491(modalBottomSheetState12, null), 3, null);
                                                }
                                                return Boolean.TRUE;
                                            }
                                        }, 1, null);
                                        if (modalBottomSheetState11.getCurrentValue() == ModalBottomSheetValue.HalfExpanded) {
                                            final ModalBottomSheetState modalBottomSheetState13 = modalBottomSheetState11;
                                            final CoroutineScope coroutineScope5 = coroutineScope3;
                                            SemanticsPropertiesKt.expand$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.1.4.2

                                                /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$2$1, reason: invalid class name */
                                                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                                @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                                @DebugMetadata(m14020c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$2$1", m14021f = "ModalBottomSheet.kt", m14022i = {}, m14023l = {370}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ ModalBottomSheetState $sheetState;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    public AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                                        super(2, continuation);
                                                        this.$sheetState = modalBottomSheetState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    @NotNull
                                                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                                        return new AnonymousClass1(this.$sheetState, continuation);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    @Nullable
                                                    public final Object invokeSuspend(@NotNull Object obj) {
                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        int i = this.label;
                                                        if (i == 0) {
                                                            ResultKt.throwOnFailure(obj);
                                                            ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                                                            this.label = 1;
                                                            if (modalBottomSheetState.expand$material_release(this) == coroutine_suspended) {
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
                                                    if (modalBottomSheetState13.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.Expanded).booleanValue()) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope5, null, null, new AnonymousClass1(modalBottomSheetState13, null), 3, null);
                                                    }
                                                    return Boolean.TRUE;
                                                }
                                            }, 1, null);
                                        } else if (modalBottomSheetState11.getHasHalfExpandedState$material_release()) {
                                            final ModalBottomSheetState modalBottomSheetState14 = modalBottomSheetState11;
                                            final CoroutineScope coroutineScope6 = coroutineScope3;
                                            SemanticsPropertiesKt.collapse$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.1.4.3

                                                /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$3$1, reason: invalid class name */
                                                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                                @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                                @DebugMetadata(m14020c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$3$1", m14021f = "ModalBottomSheet.kt", m14022i = {}, m14023l = {377}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ ModalBottomSheetState $sheetState;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    public AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                                        super(2, continuation);
                                                        this.$sheetState = modalBottomSheetState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    @NotNull
                                                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                                        return new AnonymousClass1(this.$sheetState, continuation);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    @Nullable
                                                    public final Object invokeSuspend(@NotNull Object obj) {
                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        int i = this.label;
                                                        if (i == 0) {
                                                            ResultKt.throwOnFailure(obj);
                                                            ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                                                            this.label = 1;
                                                            if (modalBottomSheetState.halfExpand$material_release(this) == coroutine_suspended) {
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
                                                    if (modalBottomSheetState14.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.HalfExpanded).booleanValue()) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope6, null, null, new AnonymousClass1(modalBottomSheetState14, null), 3, null);
                                                    }
                                                    return Boolean.TRUE;
                                                }
                                            }, 1, null);
                                        }
                                    }
                                }
                            }, 1, null);
                            Shape shape5 = shape4;
                            long j12 = j10;
                            long j13 = j7;
                            float f8 = f5;
                            final Function3<ColumnScope, Composer, Integer, Unit> function3 = sheetContent;
                            final int i16 = i4;
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer5, -1793508390, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1.5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                    invoke(composer6, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer6, int i17) {
                                    if ((i17 & 11) == 2 && composer6.getSkipping()) {
                                        composer6.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1793508390, i17, -1, "androidx.compose.material.ModalBottomSheetLayout.<anonymous>.<anonymous> (ModalBottomSheet.kt:387)");
                                    }
                                    Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                    int i18 = (i16 << 9) & 7168;
                                    composer6.startReplaceableGroup(-483455358);
                                    Modifier.Companion companion4 = Modifier.INSTANCE;
                                    MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer6, 0, -1323940314);
                                    Density density2 = (Density) composer6.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection2 = (LayoutDirection) composer6.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer6.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor2 = companion5.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(companion4);
                                    if (composer6.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer6.startReusableNode();
                                    if (composer6.getInserting()) {
                                        composer6.createNode(constructor2);
                                    } else {
                                        composer6.useNode();
                                    }
                                    composer6.disableReusing();
                                    Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer6);
                                    Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion5, composerM18018constructorimpl2, measurePolicyM1209j, composerM18018constructorimpl2, density2));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion5, composerM18018constructorimpl2, viewConfiguration2, composer6, composer6), composer6, 2058660585);
                                    composer6.startReplaceableGroup(-1163856341);
                                    function32.invoke(ColumnScopeInstance.INSTANCE, composer6, Integer.valueOf(((i18 >> 6) & 112) | 6));
                                    composer6.endReplaceableGroup();
                                    composer6.endReplaceableGroup();
                                    composer6.endNode();
                                    composer6.endReplaceableGroup();
                                    composer6.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            });
                            int i17 = i4;
                            SurfaceKt.m16872SurfaceFjzlyU(modifierSemantics$default, shape5, j12, j13, null, f8, composableLambda, composer5, ((i17 >> 6) & 112) | 1572864 | ((i17 >> 9) & 896) | ((i17 >> 9) & 7168) | ((i17 << 3) & 458752), 16);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer3, ((i4 >> 3) & 14) | 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f6 = f5;
                    j8 = j7;
                    j9 = j10;
                    modifier3 = modifier5;
                    shape3 = shape4;
                    modalBottomSheetState5 = modalBottomSheetState8;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                        invoke(composer5, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer5, int i13) {
                        ModalBottomSheetKt.m16789ModalBottomSheetLayoutBzaUkTc(sheetContent, modifier3, modalBottomSheetState5, shape3, f6, j9, j8, scrimColor, content, composer5, i | 1, i2);
                    }
                });
                return;
            }
            i4 |= i9;
            if ((191739611 & i4) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 == 0) {
                    }
                    if ((i2 & 4) == 0) {
                    }
                    if ((i2 & 8) == 0) {
                    }
                    if (i5 == 0) {
                    }
                    if ((i2 & 32) == 0) {
                    }
                    if ((i2 & 64) == 0) {
                    }
                    if ((i2 & 128) == 0) {
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2.startReplaceableGroup(773894976);
                    composer2.startReplaceableGroup(-492369756);
                    objRememberedValue = composer2.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    composer2.endReplaceableGroup();
                    final CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composer2.endReplaceableGroup();
                    Composer composer42 = composer2;
                    final Shape shape42 = large;
                    final long j102 = j5;
                    composer3 = composer42;
                    final ModalBottomSheetState modalBottomSheetState82 = modalBottomSheetState4;
                    Modifier modifier52 = modifier2;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier52, null, false, ComposableLambdaKt.composableLambda(composer3, 1607356310, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer5, Integer num) {
                            invoke(boxWithConstraintsScope, composer5, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                        @Composable
                        public final void invoke(@NotNull BoxWithConstraintsScope BoxWithConstraints, @Nullable Composer composer5, int i13) {
                            int i14;
                            final float f7;
                            Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                            if ((i13 & 14) == 0) {
                                i14 = (composer5.changed(BoxWithConstraints) ? 4 : 2) | i13;
                            } else {
                                i14 = i13;
                            }
                            if ((i14 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1607356310, i13, -1, "androidx.compose.material.ModalBottomSheetLayout.<anonymous> (ModalBottomSheet.kt:325)");
                            }
                            float fM20920getMaxHeightimpl = Constraints.m20920getMaxHeightimpl(BoxWithConstraints.mo15761getConstraintsmsEJaDk());
                            composer5.startReplaceableGroup(-492369756);
                            Object objRememberedValue2 = composer5.rememberedValue();
                            Composer.Companion companion = Composer.INSTANCE;
                            if (objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composer5.updateRememberedValue(objRememberedValue2);
                            }
                            composer5.endReplaceableGroup();
                            final MutableState<Float> mutableState = (MutableState) objRememberedValue2;
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
                            Function2<Composer, Integer, Unit> function2 = content;
                            int i15 = i4;
                            long j11 = scrimColor;
                            final ModalBottomSheetState modalBottomSheetState9 = modalBottomSheetState82;
                            final CoroutineScope coroutineScope22 = coroutineScope2;
                            composer5.startReplaceableGroup(733328855);
                            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer5, 0, -1323940314);
                            Density density = (Density) composer5.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection = (LayoutDirection) composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion3.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierFillMaxSize$default);
                            if (composer5.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composer5.startReusableNode();
                            if (composer5.getInserting()) {
                                composer5.createNode(constructor);
                            } else {
                                composer5.useNode();
                            }
                            composer5.disableReusing();
                            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer5);
                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer5, composer5), composer5, 2058660585);
                            composer5.startReplaceableGroup(-2137368960);
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composer5.startReplaceableGroup(-402723888);
                            function2.invoke(composer5, Integer.valueOf((i15 >> 24) & 14));
                            ModalBottomSheetKt.m16790Scrim3JVO9M(j11, new Function0<Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1

                                /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1 */
                                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                @DebugMetadata(m14020c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1", m14021f = "ModalBottomSheet.kt", m14022i = {}, m14023l = {335}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                public static final class C15561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ ModalBottomSheetState $sheetState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    public C15561(ModalBottomSheetState modalBottomSheetState, Continuation<? super C15561> continuation) {
                                        super(2, continuation);
                                        this.$sheetState = modalBottomSheetState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    @NotNull
                                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                        return new C15561(this.$sheetState, continuation);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    @Nullable
                                    public final Object invokeSuspend(@NotNull Object obj) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                                            this.label = 1;
                                            if (modalBottomSheetState.hide(this) == coroutine_suspended) {
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
                                        return ((C15561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                                    if (modalBottomSheetState9.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope22, null, null, new C15561(modalBottomSheetState9, null), 3, null);
                                    }
                                }
                            }, modalBottomSheetState9.getTargetValue() != ModalBottomSheetValue.Hidden, composer5, (i15 >> 21) & 14);
                            composer5.endReplaceableGroup();
                            composer5.endReplaceableGroup();
                            composer5.endReplaceableGroup();
                            composer5.endNode();
                            composer5.endReplaceableGroup();
                            composer5.endReplaceableGroup();
                            Modifier modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), modalBottomSheetState82.getNestedScrollConnection(), null, 2, null);
                            Object obj = modalBottomSheetState82;
                            Object objValueOf = Float.valueOf(fM20920getMaxHeightimpl);
                            final ModalBottomSheetState modalBottomSheetState10 = modalBottomSheetState82;
                            composer5.startReplaceableGroup(511388516);
                            boolean zChanged = composer5.changed(obj) | composer5.changed(objValueOf);
                            Object objRememberedValue3 = composer5.rememberedValue();
                            if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                                f7 = fM20920getMaxHeightimpl;
                                objRememberedValue3 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density2) {
                                        return IntOffset.m21087boximpl(m16794invokeBjo55l4(density2));
                                    }

                                    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                                    public final long m16794invokeBjo55l4(@NotNull Density offset) {
                                        Intrinsics.checkNotNullParameter(offset, "$this$offset");
                                        return IntOffsetKt.IntOffset(0, modalBottomSheetState10.getAnchors$material_release().isEmpty() ? MathKt.roundToInt(f7) : MathKt.roundToInt(modalBottomSheetState10.getOffset().getValue().floatValue()));
                                    }
                                };
                                composer5.updateRememberedValue(objRememberedValue3);
                            } else {
                                f7 = fM20920getMaxHeightimpl;
                            }
                            composer5.endReplaceableGroup();
                            Modifier modifierBottomSheetSwipeable = ModalBottomSheetKt.bottomSheetSwipeable(OffsetKt.offset(modifierNestedScroll$default, (Function1) objRememberedValue3), modalBottomSheetState82, f7, mutableState);
                            composer5.startReplaceableGroup(1157296644);
                            boolean zChanged2 = composer5.changed(mutableState);
                            Object objRememberedValue4 = composer5.rememberedValue();
                            if (zChanged2 || objRememberedValue4 == companion.getEmpty()) {
                                objRememberedValue4 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1
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
                                        mutableState.setValue(Float.valueOf(IntSize.m21137getHeightimpl(it.mo19863getSizeYbymL2g())));
                                    }
                                };
                                composer5.updateRememberedValue(objRememberedValue4);
                            }
                            composer5.endReplaceableGroup();
                            Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierBottomSheetSwipeable, (Function1) objRememberedValue4);
                            final ModalBottomSheetState modalBottomSheetState11 = modalBottomSheetState82;
                            final CoroutineScope coroutineScope3 = coroutineScope2;
                            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierOnGloballyPositioned, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1.4
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
                                    if (modalBottomSheetState11.isVisible()) {
                                        final ModalBottomSheetState modalBottomSheetState12 = modalBottomSheetState11;
                                        final CoroutineScope coroutineScope4 = coroutineScope3;
                                        SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.1.4.1

                                            /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$1$1, reason: invalid class name and collision with other inner class name */
                                            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                            @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                            @DebugMetadata(m14020c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$1$1", m14021f = "ModalBottomSheet.kt", m14022i = {}, m14023l = {363}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                            public static final class C145491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ ModalBottomSheetState $sheetState;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                public C145491(ModalBottomSheetState modalBottomSheetState, Continuation<? super C145491> continuation) {
                                                    super(2, continuation);
                                                    this.$sheetState = modalBottomSheetState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                @NotNull
                                                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                                    return new C145491(this.$sheetState, continuation);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                @Nullable
                                                public final Object invokeSuspend(@NotNull Object obj) {
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    int i = this.label;
                                                    if (i == 0) {
                                                        ResultKt.throwOnFailure(obj);
                                                        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                                                        this.label = 1;
                                                        if (modalBottomSheetState.hide(this) == coroutine_suspended) {
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
                                                    return ((C145491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                                                if (modalBottomSheetState12.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, null, new C145491(modalBottomSheetState12, null), 3, null);
                                                }
                                                return Boolean.TRUE;
                                            }
                                        }, 1, null);
                                        if (modalBottomSheetState11.getCurrentValue() == ModalBottomSheetValue.HalfExpanded) {
                                            final ModalBottomSheetState modalBottomSheetState13 = modalBottomSheetState11;
                                            final CoroutineScope coroutineScope5 = coroutineScope3;
                                            SemanticsPropertiesKt.expand$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.1.4.2

                                                /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$2$1, reason: invalid class name */
                                                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                                @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                                @DebugMetadata(m14020c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$2$1", m14021f = "ModalBottomSheet.kt", m14022i = {}, m14023l = {370}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ ModalBottomSheetState $sheetState;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    public AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                                        super(2, continuation);
                                                        this.$sheetState = modalBottomSheetState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    @NotNull
                                                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                                        return new AnonymousClass1(this.$sheetState, continuation);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    @Nullable
                                                    public final Object invokeSuspend(@NotNull Object obj) {
                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        int i = this.label;
                                                        if (i == 0) {
                                                            ResultKt.throwOnFailure(obj);
                                                            ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                                                            this.label = 1;
                                                            if (modalBottomSheetState.expand$material_release(this) == coroutine_suspended) {
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
                                                    if (modalBottomSheetState13.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.Expanded).booleanValue()) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope5, null, null, new AnonymousClass1(modalBottomSheetState13, null), 3, null);
                                                    }
                                                    return Boolean.TRUE;
                                                }
                                            }, 1, null);
                                        } else if (modalBottomSheetState11.getHasHalfExpandedState$material_release()) {
                                            final ModalBottomSheetState modalBottomSheetState14 = modalBottomSheetState11;
                                            final CoroutineScope coroutineScope6 = coroutineScope3;
                                            SemanticsPropertiesKt.collapse$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.1.4.3

                                                /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$3$1, reason: invalid class name */
                                                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                                @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                                @DebugMetadata(m14020c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$3$1", m14021f = "ModalBottomSheet.kt", m14022i = {}, m14023l = {377}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ ModalBottomSheetState $sheetState;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    public AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                                        super(2, continuation);
                                                        this.$sheetState = modalBottomSheetState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    @NotNull
                                                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                                        return new AnonymousClass1(this.$sheetState, continuation);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    @Nullable
                                                    public final Object invokeSuspend(@NotNull Object obj) {
                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        int i = this.label;
                                                        if (i == 0) {
                                                            ResultKt.throwOnFailure(obj);
                                                            ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                                                            this.label = 1;
                                                            if (modalBottomSheetState.halfExpand$material_release(this) == coroutine_suspended) {
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
                                                    if (modalBottomSheetState14.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.HalfExpanded).booleanValue()) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope6, null, null, new AnonymousClass1(modalBottomSheetState14, null), 3, null);
                                                    }
                                                    return Boolean.TRUE;
                                                }
                                            }, 1, null);
                                        }
                                    }
                                }
                            }, 1, null);
                            Shape shape5 = shape42;
                            long j12 = j102;
                            long j13 = j7;
                            float f8 = f5;
                            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3 = sheetContent;
                            final int i16 = i4;
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer5, -1793508390, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1.5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                    invoke(composer6, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer6, int i17) {
                                    if ((i17 & 11) == 2 && composer6.getSkipping()) {
                                        composer6.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1793508390, i17, -1, "androidx.compose.material.ModalBottomSheetLayout.<anonymous>.<anonymous> (ModalBottomSheet.kt:387)");
                                    }
                                    Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                    int i18 = (i16 << 9) & 7168;
                                    composer6.startReplaceableGroup(-483455358);
                                    Modifier.Companion companion4 = Modifier.INSTANCE;
                                    MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer6, 0, -1323940314);
                                    Density density2 = (Density) composer6.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection2 = (LayoutDirection) composer6.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer6.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor2 = companion5.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(companion4);
                                    if (composer6.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer6.startReusableNode();
                                    if (composer6.getInserting()) {
                                        composer6.createNode(constructor2);
                                    } else {
                                        composer6.useNode();
                                    }
                                    composer6.disableReusing();
                                    Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer6);
                                    Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion5, composerM18018constructorimpl2, measurePolicyM1209j, composerM18018constructorimpl2, density2));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion5, composerM18018constructorimpl2, viewConfiguration2, composer6, composer6), composer6, 2058660585);
                                    composer6.startReplaceableGroup(-1163856341);
                                    function32.invoke(ColumnScopeInstance.INSTANCE, composer6, Integer.valueOf(((i18 >> 6) & 112) | 6));
                                    composer6.endReplaceableGroup();
                                    composer6.endReplaceableGroup();
                                    composer6.endNode();
                                    composer6.endReplaceableGroup();
                                    composer6.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            });
                            int i17 = i4;
                            SurfaceKt.m16872SurfaceFjzlyU(modifierSemantics$default, shape5, j12, j13, null, f8, composableLambda, composer5, ((i17 >> 6) & 112) | 1572864 | ((i17 >> 9) & 896) | ((i17 >> 9) & 7168) | ((i17 << 3) & 458752), 16);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer3, ((i4 >> 3) & 14) | 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f6 = f5;
                    j8 = j7;
                    j9 = j102;
                    modifier3 = modifier52;
                    shape3 = shape42;
                    modalBottomSheetState5 = modalBottomSheetState82;
                }
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i & 896) != 0) {
        }
        if ((i & 7168) != 0) {
        }
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        if ((458752 & i) != 0) {
        }
        if ((3670016 & i) == 0) {
        }
        if ((29360128 & i) != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        i4 |= i9;
        if ((191739611 & i4) == 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m16790Scrim3JVO9M(final long j, final Function0<Unit> function0, final boolean z, Composer composer, final int i) {
        int i2;
        Modifier modifierSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(-526532668);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-526532668, i2, -1, "androidx.compose.material.Scrim (ModalBottomSheet.kt:429)");
            }
            if (j != Color.INSTANCE.m18561getUnspecified0d7_KjU()) {
                final State stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, composerStartRestartGroup, 0, 12);
                final String strM16870getString4foXLRw = Strings_androidKt.m16870getString4foXLRw(Strings.INSTANCE.m16864getCloseSheetUdPEhr4(), composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(1010547488);
                if (z) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    boolean zChanged = composerStartRestartGroup.changed(function0);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new ModalBottomSheetKt$Scrim$dismissModifier$1$1(function0, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    boolean zChanged2 = composerStartRestartGroup.changed(strM16870getString4foXLRw) | composerStartRestartGroup.changed(function0);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$dismissModifier$2$1
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
                                SemanticsPropertiesKt.setContentDescription(semantics, strM16870getString4foXLRw);
                                final Function0<Unit> function02 = function0;
                                SemanticsPropertiesKt.onClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$dismissModifier$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    @NotNull
                                    public final Boolean invoke() {
                                        function02.invoke();
                                        return Boolean.TRUE;
                                    }
                                }, 1, null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifierSemantics = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) objRememberedValue2);
                } else {
                    modifierSemantics = Modifier.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(modifierSemantics);
                Color colorM18515boximpl = Color.m18515boximpl(j);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                boolean zChanged3 = composerStartRestartGroup.changed(colorM18515boximpl) | composerStartRestartGroup.changed(stateAnimateFloatAsState);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull DrawScope Canvas) {
                            Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                            DrawScope.m19070drawRectnJ9OG0$default(Canvas, j, 0L, 0L, ModalBottomSheetKt.m16791Scrim_3J_VO9M$lambda0(stateAnimateFloatAsState), null, null, 0, 118, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierThen, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$2
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
                ModalBottomSheetKt.m16790Scrim3JVO9M(j, function0, z, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Scrim_3J_VO9M$lambda-0, reason: not valid java name */
    public static final float m16791Scrim_3J_VO9M$lambda0(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier bottomSheetSwipeable(Modifier modifier, ModalBottomSheetState modalBottomSheetState, float f, State<Float> state) {
        Modifier modifierM16882swipeablepPrIpRY;
        Float value = state.getValue();
        if (value != null) {
            float f4 = f / 2;
            Map mapMapOf = (value.floatValue() < f4 || modalBottomSheetState.getIsSkipHalfExpanded()) ? MapsKt.mapOf(TuplesKt.m13893to(Float.valueOf(f), ModalBottomSheetValue.Hidden), TuplesKt.m13893to(Float.valueOf(f - value.floatValue()), ModalBottomSheetValue.Expanded)) : MapsKt.mapOf(TuplesKt.m13893to(Float.valueOf(f), ModalBottomSheetValue.Hidden), TuplesKt.m13893to(Float.valueOf(f4), ModalBottomSheetValue.HalfExpanded), TuplesKt.m13893to(Float.valueOf(Math.max(0.0f, f - value.floatValue())), ModalBottomSheetValue.Expanded));
            modifierM16882swipeablepPrIpRY = SwipeableKt.m16882swipeablepPrIpRY(Modifier.INSTANCE, modalBottomSheetState, mapMapOf, Orientation.Vertical, (32 & 8) != 0 ? true : modalBottomSheetState.getCurrentValue() != ModalBottomSheetValue.Hidden, (32 & 16) != 0 ? false : false, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? new Function2() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                @Override // kotlin.jvm.functions.Function2
                @NotNull
                public final FixedThreshold invoke(Object obj, Object obj2) {
                    return new FixedThreshold(C2256Dp.m20968constructorimpl(56), null);
                }
            } : null, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m16881getVelocityThresholdD9Ej5fM() : 0.0f);
        } else {
            modifierM16882swipeablepPrIpRY = Modifier.INSTANCE;
        }
        return modifier.then(modifierM16882swipeablepPrIpRY);
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final ModalBottomSheetState rememberModalBottomSheetState(@NotNull final ModalBottomSheetValue initialValue, @Nullable final AnimationSpec<Float> animationSpec, final boolean z, @Nullable final Function1<? super ModalBottomSheetValue, Boolean> function1, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        composer.startReplaceableGroup(-409288536);
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 8) != 0) {
            function1 = new Function1<ModalBottomSheetValue, Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.rememberModalBottomSheetState.1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull ModalBottomSheetValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.TRUE;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-409288536, i, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:239)");
        }
        ModalBottomSheetState modalBottomSheetState = (ModalBottomSheetState) RememberSaveableKt.m18111rememberSaveable(new Object[]{initialValue, animationSpec, Boolean.valueOf(z), function1}, (Saver) ModalBottomSheetState.INSTANCE.Saver(animationSpec, z, function1), (String) null, (Function0) new Function0<ModalBottomSheetState>() { // from class: androidx.compose.material.ModalBottomSheetKt.rememberModalBottomSheetState.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ModalBottomSheetState invoke() {
                return new ModalBottomSheetState(initialValue, animationSpec, z, function1);
            }
        }, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modalBottomSheetState;
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final ModalBottomSheetState rememberModalBottomSheetState(@NotNull ModalBottomSheetValue initialValue, @Nullable AnimationSpec<Float> animationSpec, @Nullable Function1<? super ModalBottomSheetValue, Boolean> function1, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        composer.startReplaceableGroup(-1928569212);
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        AnimationSpec<Float> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = new Function1<ModalBottomSheetValue, Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.rememberModalBottomSheetState.3
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull ModalBottomSheetValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.TRUE;
                }
            };
        }
        Function1<? super ModalBottomSheetValue, Boolean> function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1928569212, i, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:271)");
        }
        ModalBottomSheetState modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(initialValue, animationSpec2, false, function12, composer, (i & 14) | 448 | ((i << 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modalBottomSheetStateRememberModalBottomSheetState;
    }
}
