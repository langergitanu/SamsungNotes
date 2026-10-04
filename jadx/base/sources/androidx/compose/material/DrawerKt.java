package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import androidx.compose.p109ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
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
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.drive.DriveFile;
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
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import opennlp.tools.tokenize.TokenizerME;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0096\u0001\u0010\b\u001a\u00020\t2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a3\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00192\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\u0006\u0010#\u001a\u00020\u0014H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a\u0096\u0001\u0010&\u001a\u00020\t2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020'2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001aA\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u00142\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d2\u0006\u0010!\u001a\u00020\u0019H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a \u00100\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0002H\u0002\u001a+\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u0002062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00140\u000bH\u0007¢\u0006\u0002\u00108\u001a+\u00109\u001a\u00020'2\u0006\u00105\u001a\u00020:2\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u00140\u000bH\u0007¢\u0006\u0002\u0010;\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006<"}, m13886d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomDrawerOpenFraction", "DrawerVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "EndDrawerPadding", "BottomDrawer", "", "drawerContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerState", "Landroidx/compose/material/BottomDrawerState;", "gesturesEnabled", "", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "scrimColor", "content", "Lkotlin/Function0;", "BottomDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomDrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BottomDrawerScrim", "color", "onDismiss", "visible", "BottomDrawerScrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "ModalDrawer", "Landroidx/compose/material/DrawerState;", "ModalDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/DrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", AbstractCircuitBreaker.PROPERTY_NAME, "onClose", "fraction", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateFraction", "a", "b", "pos", "rememberBottomDrawerState", "initialValue", "Landroidx/compose/material/BottomDrawerValue;", "confirmStateChange", "(Landroidx/compose/material/BottomDrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomDrawerState;", "rememberDrawerState", "Landroidx/compose/material/DrawerValue;", "(Landroidx/compose/material/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DrawerState;", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class DrawerKt {
    private static final float BottomDrawerOpenFraction = 0.5f;
    private static final float EndDrawerPadding = C2256Dp.m20968constructorimpl(56);
    private static final float DrawerVelocityThreshold = C2256Dp.m20968constructorimpl(400);

    @NotNull
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(256, 0, null, 6, null);

    /* JADX WARN: Removed duplicated region for block: B:100:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0106  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: BottomDrawer-Gs3lGvM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16722BottomDrawerGs3lGvM(@NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> drawerContent, @Nullable Modifier modifier, @Nullable BottomDrawerState bottomDrawerState, boolean z, @Nullable Shape shape, float f, long j, long j2, long j3, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        BottomDrawerState bottomDrawerState2;
        int i5;
        boolean z2;
        Shape shape2;
        int i6;
        float f4;
        int i7;
        long jM16680getSurface0d7_KjU;
        int i8;
        Modifier modifier3;
        BottomDrawerState bottomDrawerStateRememberBottomDrawerState;
        Shape large;
        long jM16694contentColorForek8zF_U;
        long scrimColor;
        BottomDrawerState bottomDrawerState3;
        int i9;
        Modifier modifier4;
        Shape shape3;
        long j5;
        float f5;
        long j6;
        Object objRememberedValue;
        Composer composer2;
        final boolean z3;
        final BottomDrawerState bottomDrawerState4;
        final Modifier modifier5;
        final Shape shape4;
        final long j7;
        final long j8;
        final float f6;
        final long j9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(drawerContent, "drawerContent");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(625649286);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(drawerContent) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    bottomDrawerState2 = bottomDrawerState;
                    int i11 = composerStartRestartGroup.changed(bottomDrawerState2) ? 256 : 128;
                    i4 |= i11;
                } else {
                    bottomDrawerState2 = bottomDrawerState;
                }
                i4 |= i11;
            } else {
                bottomDrawerState2 = bottomDrawerState;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        int i12 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                        i4 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i4 |= i12;
                } else {
                    shape2 = shape;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else {
                    if ((458752 & i) == 0) {
                        f4 = f;
                        i4 |= composerStartRestartGroup.changed(f4) ? 131072 : 65536;
                    }
                    if ((i & 3670016) != 0) {
                        if ((i2 & 64) == 0) {
                            i7 = i10;
                            jM16680getSurface0d7_KjU = j;
                            int i13 = composerStartRestartGroup.changed(jM16680getSurface0d7_KjU) ? 1048576 : 524288;
                            i4 |= i13;
                        } else {
                            i7 = i10;
                            jM16680getSurface0d7_KjU = j;
                        }
                        i4 |= i13;
                    } else {
                        i7 = i10;
                        jM16680getSurface0d7_KjU = j;
                    }
                    if ((i & 29360128) == 0) {
                        i4 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(j2)) ? 8388608 : 4194304;
                    }
                    if ((i & 234881024) == 0) {
                        i4 |= ((i2 & 256) == 0 && composerStartRestartGroup.changed(j3)) ? 67108864 : 33554432;
                    }
                    if ((i2 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            i8 = composerStartRestartGroup.changed(content) ? 536870912 : 268435456;
                        }
                        if ((1533916891 & i4) == 306783378 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            composer2 = composerStartRestartGroup;
                            modifier5 = modifier2;
                            bottomDrawerState4 = bottomDrawerState2;
                            z3 = z2;
                            shape4 = shape2;
                            j8 = j2;
                            j9 = j3;
                            j7 = jM16680getSurface0d7_KjU;
                            f6 = f4;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier modifier6 = i7 == 0 ? Modifier.INSTANCE : modifier2;
                                if ((i2 & 4) == 0) {
                                    modifier3 = modifier6;
                                    bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                    i4 &= -897;
                                } else {
                                    modifier3 = modifier6;
                                    bottomDrawerStateRememberBottomDrawerState = bottomDrawerState2;
                                }
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 16) == 0) {
                                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                    i4 &= -57345;
                                } else {
                                    large = shape2;
                                }
                                float fM16721getElevationD9Ej5fM = i6 == 0 ? DrawerDefaults.INSTANCE.m16721getElevationD9Ej5fM() : f4;
                                if ((i2 & 64) != 0) {
                                    jM16680getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m16680getSurface0d7_KjU();
                                    i4 &= -3670017;
                                }
                                if ((i2 & 128) == 0) {
                                    jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(jM16680getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 18) & 14);
                                    i4 &= -29360129;
                                } else {
                                    jM16694contentColorForek8zF_U = j2;
                                }
                                if ((i2 & 256) == 0) {
                                    scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                    i4 &= -234881025;
                                } else {
                                    scrimColor = j3;
                                }
                                bottomDrawerState3 = bottomDrawerStateRememberBottomDrawerState;
                                i9 = i4;
                                modifier4 = modifier3;
                                shape3 = large;
                                j5 = jM16694contentColorForek8zF_U;
                                f5 = fM16721getElevationD9Ej5fM;
                                j6 = jM16680getSurface0d7_KjU;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                if ((i2 & 256) != 0) {
                                    i4 &= -234881025;
                                }
                                scrimColor = j3;
                                i9 = i4;
                                modifier4 = modifier2;
                                bottomDrawerState3 = bottomDrawerState2;
                                j6 = jM16680getSurface0d7_KjU;
                                shape3 = shape2;
                                f5 = f4;
                                j5 = j2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(625649286, i9, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:496)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup), composerStartRestartGroup);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            BottomDrawerState bottomDrawerState5 = bottomDrawerState3;
                            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null);
                            Modifier modifier7 = modifier4;
                            composer2 = composerStartRestartGroup;
                            int i14 = i9;
                            boolean z4 = z2;
                            long j10 = j5;
                            long j11 = scrimColor;
                            BoxWithConstraintsKt.BoxWithConstraints(modifierFillMaxSize$default, null, false, ComposableLambdaKt.composableLambda(composer2, 1220102512, true, new DrawerKt$BottomDrawer$1(z4, bottomDrawerState5, content, i14, j11, shape3, j6, j10, f5, coroutineScope, drawerContent)), composer2, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z3 = z4;
                            bottomDrawerState4 = bottomDrawerState5;
                            modifier5 = modifier7;
                            shape4 = shape3;
                            j7 = j6;
                            j8 = j10;
                            f6 = f5;
                            j9 = j11;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2
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

                            public final void invoke(@Nullable Composer composer3, int i15) {
                                DrawerKt.m16722BottomDrawerGs3lGvM(drawerContent, modifier5, bottomDrawerState4, z3, shape4, f6, j7, j8, j9, content, composer3, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i8 = DriveFile.MODE_READ_WRITE;
                    i4 |= i8;
                    if ((1533916891 & i4) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i7 == 0) {
                            }
                            if ((i2 & 4) == 0) {
                            }
                            if (i5 != 0) {
                            }
                            if ((i2 & 16) == 0) {
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 64) != 0) {
                            }
                            if ((i2 & 128) == 0) {
                            }
                            if ((i2 & 256) == 0) {
                            }
                            bottomDrawerState3 = bottomDrawerStateRememberBottomDrawerState;
                            i9 = i4;
                            modifier4 = modifier3;
                            shape3 = large;
                            j5 = jM16694contentColorForek8zF_U;
                            f5 = fM16721getElevationD9Ej5fM;
                            j6 = jM16680getSurface0d7_KjU;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            BottomDrawerState bottomDrawerState52 = bottomDrawerState3;
                            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null);
                            Modifier modifier72 = modifier4;
                            composer2 = composerStartRestartGroup;
                            int i142 = i9;
                            boolean z42 = z2;
                            long j102 = j5;
                            long j112 = scrimColor;
                            BoxWithConstraintsKt.BoxWithConstraints(modifierFillMaxSize$default2, null, false, ComposableLambdaKt.composableLambda(composer2, 1220102512, true, new DrawerKt$BottomDrawer$1(z42, bottomDrawerState52, content, i142, j112, shape3, j6, j102, f5, coroutineScope2, drawerContent)), composer2, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            z3 = z42;
                            bottomDrawerState4 = bottomDrawerState52;
                            modifier5 = modifier72;
                            shape4 = shape3;
                            j7 = j6;
                            j8 = j102;
                            f6 = f5;
                            j9 = j112;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                f4 = f;
                if ((i & 3670016) != 0) {
                }
                if ((i & 29360128) == 0) {
                }
                if ((i & 234881024) == 0) {
                }
                if ((i2 & 512) != 0) {
                }
                i4 |= i8;
                if ((1533916891 & i4) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((57344 & i) == 0) {
            }
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            f4 = f;
            if ((i & 3670016) != 0) {
            }
            if ((i & 29360128) == 0) {
            }
            if ((i & 234881024) == 0) {
            }
            if ((i2 & 512) != 0) {
            }
            i4 |= i8;
            if ((1533916891 & i4) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 896) != 0) {
        }
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        if ((57344 & i) == 0) {
        }
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        f4 = f;
        if ((i & 3670016) != 0) {
        }
        if ((i & 29360128) == 0) {
        }
        if ((i & 234881024) == 0) {
        }
        if ((i2 & 512) != 0) {
        }
        i4 |= i8;
        if ((1533916891 & i4) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: BottomDrawerScrim-3J-VO9M, reason: not valid java name */
    public static final void m16723BottomDrawerScrim3JVO9M(final long j, final Function0<Unit> function0, final boolean z, Composer composer, final int i) {
        int i2;
        Modifier modifierSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(-513067266);
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
                ComposerKt.traceEventStart(-513067266, i2, -1, "androidx.compose.material.BottomDrawerScrim (Drawer.kt:619)");
            }
            if (j != Color.INSTANCE.m18561getUnspecified0d7_KjU()) {
                final State stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, composerStartRestartGroup, 0, 12);
                final String strM16870getString4foXLRw = Strings_androidKt.m16870getString4foXLRw(Strings.INSTANCE.m16863getCloseDrawerUdPEhr4(), composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1298949409);
                if (z) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    boolean zChanged = composerStartRestartGroup.changed(function0);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new DrawerKt$BottomDrawerScrim$dismissModifier$1$1(function0, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    boolean zChanged2 = composerStartRestartGroup.changed(strM16870getString4foXLRw) | composerStartRestartGroup.changed(function0);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$dismissModifier$2$1
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
                                SemanticsPropertiesKt.onClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$dismissModifier$2$1.1
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
                    objRememberedValue3 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$1$1
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
                            DrawScope.m19070drawRectnJ9OG0$default(Canvas, j, 0L, 0L, DrawerKt.m16724BottomDrawerScrim_3J_VO9M$lambda2(stateAnimateFloatAsState), null, null, 0, 118, null);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$2
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
                DrawerKt.m16723BottomDrawerScrim3JVO9M(j, function0, z, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: BottomDrawerScrim_3J_VO9M$lambda-2, reason: not valid java name */
    public static final float m16724BottomDrawerScrim_3J_VO9M$lambda2(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0106  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ModalDrawer-Gs3lGvM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16725ModalDrawerGs3lGvM(@NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> drawerContent, @Nullable Modifier modifier, @Nullable DrawerState drawerState, boolean z, @Nullable Shape shape, float f, long j, long j2, long j3, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        DrawerState drawerState2;
        int i5;
        boolean z2;
        Shape shape2;
        int i6;
        float f4;
        int i7;
        long jM16680getSurface0d7_KjU;
        int i8;
        Modifier modifier3;
        DrawerState drawerStateRememberDrawerState;
        Shape large;
        long jM16694contentColorForek8zF_U;
        int i9;
        long j5;
        final Shape shape3;
        long scrimColor;
        final float f5;
        boolean z3;
        final long j6;
        Modifier modifier4;
        Object objRememberedValue;
        Composer composer2;
        final long j7;
        final Shape shape4;
        final float f6;
        final long j8;
        final DrawerState drawerState3;
        final boolean z4;
        final Modifier modifier5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(drawerContent, "drawerContent");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1305806945);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(drawerContent) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    drawerState2 = drawerState;
                    int i11 = composerStartRestartGroup.changed(drawerState2) ? 256 : 128;
                    i4 |= i11;
                } else {
                    drawerState2 = drawerState;
                }
                i4 |= i11;
            } else {
                drawerState2 = drawerState;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        int i12 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                        i4 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i4 |= i12;
                } else {
                    shape2 = shape;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else {
                    if ((458752 & i) == 0) {
                        f4 = f;
                        i4 |= composerStartRestartGroup.changed(f4) ? 131072 : 65536;
                    }
                    if ((i & 3670016) != 0) {
                        if ((i2 & 64) == 0) {
                            i7 = i10;
                            jM16680getSurface0d7_KjU = j;
                            int i13 = composerStartRestartGroup.changed(jM16680getSurface0d7_KjU) ? 1048576 : 524288;
                            i4 |= i13;
                        } else {
                            i7 = i10;
                            jM16680getSurface0d7_KjU = j;
                        }
                        i4 |= i13;
                    } else {
                        i7 = i10;
                        jM16680getSurface0d7_KjU = j;
                    }
                    if ((i & 29360128) == 0) {
                        i4 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(j2)) ? 8388608 : 4194304;
                    }
                    if ((i & 234881024) == 0) {
                        i4 |= ((i2 & 256) == 0 && composerStartRestartGroup.changed(j3)) ? 67108864 : 33554432;
                    }
                    if ((i2 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            i8 = composerStartRestartGroup.changed(content) ? 536870912 : 268435456;
                        }
                        if ((1533916891 & i4) == 306783378 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            composer2 = composerStartRestartGroup;
                            modifier5 = modifier2;
                            drawerState3 = drawerState2;
                            z4 = z2;
                            j6 = j2;
                            j7 = jM16680getSurface0d7_KjU;
                            shape4 = shape2;
                            f6 = f4;
                            j8 = j3;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier modifier6 = i7 == 0 ? Modifier.INSTANCE : modifier2;
                                if ((i2 & 4) == 0) {
                                    modifier3 = modifier6;
                                    drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                    i4 &= -897;
                                } else {
                                    modifier3 = modifier6;
                                    drawerStateRememberDrawerState = drawerState2;
                                }
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 16) == 0) {
                                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                    i4 &= -57345;
                                } else {
                                    large = shape2;
                                }
                                float fM16721getElevationD9Ej5fM = i6 == 0 ? DrawerDefaults.INSTANCE.m16721getElevationD9Ej5fM() : f4;
                                if ((i2 & 64) != 0) {
                                    jM16680getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m16680getSurface0d7_KjU();
                                    i4 &= -3670017;
                                }
                                if ((i2 & 128) == 0) {
                                    jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(jM16680getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 18) & 14);
                                    i4 &= -29360129;
                                } else {
                                    jM16694contentColorForek8zF_U = j2;
                                }
                                if ((i2 & 256) == 0) {
                                    scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                    Shape shape5 = large;
                                    i9 = i4 & (-234881025);
                                    j5 = jM16680getSurface0d7_KjU;
                                    shape3 = shape5;
                                } else {
                                    Shape shape6 = large;
                                    i9 = i4;
                                    j5 = jM16680getSurface0d7_KjU;
                                    shape3 = shape6;
                                    scrimColor = j3;
                                }
                                f5 = fM16721getElevationD9Ej5fM;
                                z3 = z2;
                                j6 = jM16694contentColorForek8zF_U;
                                drawerState2 = drawerStateRememberDrawerState;
                                modifier4 = modifier3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                if ((i2 & 256) != 0) {
                                    i4 &= -234881025;
                                }
                                scrimColor = j3;
                                modifier4 = modifier2;
                                z3 = z2;
                                j6 = j2;
                                i9 = i4;
                                j5 = jM16680getSurface0d7_KjU;
                                shape3 = shape2;
                                f5 = f4;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1305806945, i9, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:373)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup), composerStartRestartGroup);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            final boolean z5 = z3;
                            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null);
                            Modifier modifier7 = modifier4;
                            composer2 = composerStartRestartGroup;
                            final int i14 = i9;
                            final DrawerState drawerState4 = drawerState2;
                            j7 = j5;
                            final long j9 = scrimColor;
                            BoxWithConstraintsKt.BoxWithConstraints(modifierFillMaxSize$default, null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, Integer num) {
                                    invoke(boxWithConstraintsScope, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@NotNull BoxWithConstraintsScope BoxWithConstraints, @Nullable Composer composer3, int i15) {
                                    int i16;
                                    Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                                    if ((i15 & 14) == 0) {
                                        i16 = (composer3.changed(BoxWithConstraints) ? 4 : 2) | i15;
                                    } else {
                                        i16 = i15;
                                    }
                                    if ((i16 & 91) == 18 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(816674999, i15, -1, "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:386)");
                                    }
                                    long jMo15761getConstraintsmsEJaDk = BoxWithConstraints.mo15761getConstraintsmsEJaDk();
                                    if (!Constraints.m20917getHasBoundedWidthimpl(jMo15761getConstraintsmsEJaDk)) {
                                        throw new IllegalStateException("Drawer shouldn't have infinite width");
                                    }
                                    final float f7 = -Constraints.m20921getMaxWidthimpl(jMo15761getConstraintsmsEJaDk);
                                    final float f8 = 0.0f;
                                    Map mapMapOf = MapsKt.mapOf(TuplesKt.m13893to(Float.valueOf(f7), DrawerValue.Closed), TuplesKt.m13893to(Float.valueOf(0.0f), DrawerValue.Open));
                                    boolean z6 = composer3.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    Modifier modifierM16882swipeablepPrIpRY = SwipeableKt.m16882swipeablepPrIpRY(companion, drawerState4.getSwipeableState$material_release(), mapMapOf, Orientation.Horizontal, (32 & 8) != 0 ? true : z5, (32 & 16) != 0 ? false : z6, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? new Function2() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                                        @Override // kotlin.jvm.functions.Function2
                                        @NotNull
                                        public final FixedThreshold invoke(Object obj, Object obj2) {
                                            return new FixedThreshold(C2256Dp.m20968constructorimpl(56), null);
                                        }
                                    } : new Function2<DrawerValue, DrawerValue, ThresholdConfig>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1.1
                                        @Override // kotlin.jvm.functions.Function2
                                        @NotNull
                                        public final ThresholdConfig invoke(@NotNull DrawerValue drawerValue, @NotNull DrawerValue drawerValue2) {
                                            Intrinsics.checkNotNullParameter(drawerValue, "<anonymous parameter 0>");
                                            Intrinsics.checkNotNullParameter(drawerValue2, "<anonymous parameter 1>");
                                            return new FractionalThreshold(0.5f);
                                        }
                                    }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m16881getVelocityThresholdD9Ej5fM() : DrawerKt.DrawerVelocityThreshold);
                                    final DrawerState drawerState5 = drawerState4;
                                    final int i17 = i14;
                                    long j10 = j9;
                                    Shape shape7 = shape3;
                                    long j11 = j7;
                                    long j12 = j6;
                                    float f9 = f5;
                                    Function2<Composer, Integer, Unit> function2 = content;
                                    final boolean z7 = z5;
                                    final CoroutineScope coroutineScope2 = coroutineScope;
                                    final Function3<ColumnScope, Composer, Integer, Unit> function3 = drawerContent;
                                    composer3.startReplaceableGroup(733328855);
                                    Alignment.Companion companion2 = Alignment.INSTANCE;
                                    MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composer3, 0, -1323940314);
                                    Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM16882swipeablepPrIpRY);
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
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                    function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    composer3.startReplaceableGroup(-2137368960);
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer3.startReplaceableGroup(-1263168067);
                                    composer3.startReplaceableGroup(733328855);
                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer3, 0);
                                    Density density2 = (Density) AbstractC1038a.m1211l(composer3, -1323940314);
                                    LayoutDirection layoutDirection2 = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(companion);
                                    if (composer3.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor2);
                                    } else {
                                        composer3.useNode();
                                    }
                                    composer3.disableReusing();
                                    Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer3);
                                    Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl2, density2));
                                    function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composer3, composer3), composer3, 0);
                                    AbstractC1038a.m1220u(2058660585, -2137368960, composer3, 32495683);
                                    function2.invoke(composer3, Integer.valueOf((i17 >> 27) & 14));
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    boolean zIsOpen = drawerState5.isOpen();
                                    Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2

                                        /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1 */
                                        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                        @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                        @DebugMetadata(m14020c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1", m14021f = "Drawer.kt", m14022i = {}, m14023l = {TypedValues.Cycle.TYPE_WAVE_SHAPE}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                        public static final class C15191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ DrawerState $drawerState;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            public C15191(DrawerState drawerState, Continuation<? super C15191> continuation) {
                                                super(2, continuation);
                                                this.$drawerState = drawerState;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            @NotNull
                                            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                                return new C15191(this.$drawerState, continuation);
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            @Nullable
                                            public final Object invokeSuspend(@NotNull Object obj) {
                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                int i = this.label;
                                                if (i == 0) {
                                                    ResultKt.throwOnFailure(obj);
                                                    DrawerState drawerState = this.$drawerState;
                                                    this.label = 1;
                                                    if (drawerState.close(this) == coroutine_suspended) {
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
                                                return ((C15191) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                                            if (z7 && drawerState5.getSwipeableState$material_release().getConfirmStateChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C15191(drawerState5, null), 3, null);
                                            }
                                        }
                                    };
                                    Object objValueOf = Float.valueOf(f7);
                                    Object objValueOf2 = Float.valueOf(0.0f);
                                    composer3.startReplaceableGroup(1618982084);
                                    boolean zChanged = composer3.changed(objValueOf) | composer3.changed(objValueOf2) | composer3.changed(drawerState5);
                                    Object objRememberedValue2 = composer3.rememberedValue();
                                    if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = new Function0<Float>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$3$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            @NotNull
                                            public final Float invoke() {
                                                return Float.valueOf(DrawerKt.calculateFraction(f7, f8, drawerState5.getOffset().getValue().floatValue()));
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue2);
                                    }
                                    composer3.endReplaceableGroup();
                                    DrawerKt.m16726ScrimBx497Mc(zIsOpen, function0, (Function0) objRememberedValue2, j10, composer3, (i17 >> 15) & 7168);
                                    final String strM16870getString4foXLRw = Strings_androidKt.m16870getString4foXLRw(Strings.INSTANCE.m16867getNavigationMenuUdPEhr4(), composer3, 6);
                                    Density density3 = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                    Modifier modifierM15902sizeInqDBjuR0 = SizeKt.m15902sizeInqDBjuR0(companion, density3.mo15543toDpu2uoSUM(Constraints.m20923getMinWidthimpl(jMo15761getConstraintsmsEJaDk)), density3.mo15543toDpu2uoSUM(Constraints.m20922getMinHeightimpl(jMo15761getConstraintsmsEJaDk)), density3.mo15543toDpu2uoSUM(Constraints.m20921getMaxWidthimpl(jMo15761getConstraintsmsEJaDk)), density3.mo15543toDpu2uoSUM(Constraints.m20920getMaxHeightimpl(jMo15761getConstraintsmsEJaDk)));
                                    composer3.startReplaceableGroup(1157296644);
                                    boolean zChanged2 = composer3.changed(drawerState5);
                                    Object objRememberedValue3 = composer3.rememberedValue();
                                    if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue3 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$5$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ IntOffset invoke(Density density4) {
                                                return IntOffset.m21087boximpl(m16735invokeBjo55l4(density4));
                                            }

                                            /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                                            public final long m16735invokeBjo55l4(@NotNull Density offset) {
                                                Intrinsics.checkNotNullParameter(offset, "$this$offset");
                                                return IntOffsetKt.IntOffset(MathKt.roundToInt(drawerState5.getOffset().getValue().floatValue()), 0);
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue3);
                                    }
                                    composer3.endReplaceableGroup();
                                    int i18 = i17 >> 12;
                                    SurfaceKt.m16872SurfaceFjzlyU(SemanticsModifierKt.semantics$default(PaddingKt.m15858paddingqDBjuR0$default(OffsetKt.offset(modifierM15902sizeInqDBjuR0, (Function1) objRememberedValue3), 0.0f, 0.0f, DrawerKt.EndDrawerPadding, 0.0f, 11, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6
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
                                            if (drawerState5.isOpen()) {
                                                final DrawerState drawerState6 = drawerState5;
                                                final CoroutineScope coroutineScope3 = coroutineScope2;
                                                SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6.1

                                                    /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1, reason: invalid class name */
                                                    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                                    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                                    @DebugMetadata(m14020c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1", m14021f = "Drawer.kt", m14022i = {}, m14023l = {450}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                        final /* synthetic */ DrawerState $drawerState;
                                                        int label;

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        public AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                                            super(2, continuation);
                                                            this.$drawerState = drawerState;
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
                                                                DrawerState drawerState = this.$drawerState;
                                                                this.label = 1;
                                                                if (drawerState.close(this) == coroutine_suspended) {
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
                                                        if (drawerState6.getSwipeableState$material_release().getConfirmStateChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass1(drawerState6, null), 3, null);
                                                        }
                                                        return Boolean.TRUE;
                                                    }
                                                }, 1, null);
                                            }
                                        }
                                    }, 1, null), shape7, j11, j12, null, f9, ComposableLambdaKt.composableLambda(composer3, -1941234439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$7
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
                                        public final void invoke(@Nullable Composer composer4, int i19) {
                                            if ((i19 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1941234439, i19, -1, "androidx.compose.material.ModalDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:458)");
                                            }
                                            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                            int i20 = ((i17 << 9) & 7168) | 6;
                                            composer4.startReplaceableGroup(-483455358);
                                            MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer4, 0, -1323940314);
                                            Density density4 = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                            LayoutDirection layoutDirection3 = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxSize$default2);
                                            if (composer4.getApplier() == null) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer4.createNode(constructor3);
                                            } else {
                                                composer4.useNode();
                                            }
                                            composer4.disableReusing();
                                            Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composer4);
                                            Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl3, measurePolicyM1209j, composerM18018constructorimpl3, density4));
                                            AbstractC1038a.m1221v(0, function3MaterializerOf3, AbstractC1038a.m1206g(companion4, composerM18018constructorimpl3, viewConfiguration3, composer4, composer4), composer4, 2058660585);
                                            composer4.startReplaceableGroup(-1163856341);
                                            function32.invoke(ColumnScopeInstance.INSTANCE, composer4, Integer.valueOf(((i20 >> 6) & 112) | 6));
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            composer4.endNode();
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer3, ((i17 >> 9) & 112) | 1572864 | (i18 & 896) | (i18 & 7168) | (458752 & i17), 16);
                                    if (AbstractC1038a.m1225z(composer3)) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape4 = shape3;
                            f6 = f5;
                            j8 = j9;
                            drawerState3 = drawerState4;
                            z4 = z5;
                            modifier5 = modifier7;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$2
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

                            public final void invoke(@Nullable Composer composer3, int i15) {
                                DrawerKt.m16725ModalDrawerGs3lGvM(drawerContent, modifier5, drawerState3, z4, shape4, f6, j7, j6, j8, content, composer3, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i8 = DriveFile.MODE_READ_WRITE;
                    i4 |= i8;
                    if ((1533916891 & i4) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i7 == 0) {
                            }
                            if ((i2 & 4) == 0) {
                            }
                            if (i5 != 0) {
                            }
                            if ((i2 & 16) == 0) {
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 64) != 0) {
                            }
                            if ((i2 & 128) == 0) {
                            }
                            if ((i2 & 256) == 0) {
                            }
                            f5 = fM16721getElevationD9Ej5fM;
                            z3 = z2;
                            j6 = jM16694contentColorForek8zF_U;
                            drawerState2 = drawerStateRememberDrawerState;
                            modifier4 = modifier3;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            final CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            final boolean z52 = z3;
                            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null);
                            Modifier modifier72 = modifier4;
                            composer2 = composerStartRestartGroup;
                            final int i142 = i9;
                            final DrawerState drawerState42 = drawerState2;
                            j7 = j5;
                            final long j92 = scrimColor;
                            BoxWithConstraintsKt.BoxWithConstraints(modifierFillMaxSize$default2, null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, Integer num) {
                                    invoke(boxWithConstraintsScope, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@NotNull BoxWithConstraintsScope BoxWithConstraints, @Nullable Composer composer3, int i15) {
                                    int i16;
                                    Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                                    if ((i15 & 14) == 0) {
                                        i16 = (composer3.changed(BoxWithConstraints) ? 4 : 2) | i15;
                                    } else {
                                        i16 = i15;
                                    }
                                    if ((i16 & 91) == 18 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(816674999, i15, -1, "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:386)");
                                    }
                                    long jMo15761getConstraintsmsEJaDk = BoxWithConstraints.mo15761getConstraintsmsEJaDk();
                                    if (!Constraints.m20917getHasBoundedWidthimpl(jMo15761getConstraintsmsEJaDk)) {
                                        throw new IllegalStateException("Drawer shouldn't have infinite width");
                                    }
                                    final float f7 = -Constraints.m20921getMaxWidthimpl(jMo15761getConstraintsmsEJaDk);
                                    final float f8 = 0.0f;
                                    Map mapMapOf = MapsKt.mapOf(TuplesKt.m13893to(Float.valueOf(f7), DrawerValue.Closed), TuplesKt.m13893to(Float.valueOf(0.0f), DrawerValue.Open));
                                    boolean z6 = composer3.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    Modifier modifierM16882swipeablepPrIpRY = SwipeableKt.m16882swipeablepPrIpRY(companion, drawerState42.getSwipeableState$material_release(), mapMapOf, Orientation.Horizontal, (32 & 8) != 0 ? true : z52, (32 & 16) != 0 ? false : z6, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? new Function2() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                                        @Override // kotlin.jvm.functions.Function2
                                        @NotNull
                                        public final FixedThreshold invoke(Object obj, Object obj2) {
                                            return new FixedThreshold(C2256Dp.m20968constructorimpl(56), null);
                                        }
                                    } : new Function2<DrawerValue, DrawerValue, ThresholdConfig>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1.1
                                        @Override // kotlin.jvm.functions.Function2
                                        @NotNull
                                        public final ThresholdConfig invoke(@NotNull DrawerValue drawerValue, @NotNull DrawerValue drawerValue2) {
                                            Intrinsics.checkNotNullParameter(drawerValue, "<anonymous parameter 0>");
                                            Intrinsics.checkNotNullParameter(drawerValue2, "<anonymous parameter 1>");
                                            return new FractionalThreshold(0.5f);
                                        }
                                    }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m16881getVelocityThresholdD9Ej5fM() : DrawerKt.DrawerVelocityThreshold);
                                    final DrawerState drawerState5 = drawerState42;
                                    final int i17 = i142;
                                    long j10 = j92;
                                    Shape shape7 = shape3;
                                    long j11 = j7;
                                    long j12 = j6;
                                    float f9 = f5;
                                    Function2<Composer, Integer, Unit> function2 = content;
                                    final boolean z7 = z52;
                                    final CoroutineScope coroutineScope22 = coroutineScope2;
                                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3 = drawerContent;
                                    composer3.startReplaceableGroup(733328855);
                                    Alignment.Companion companion2 = Alignment.INSTANCE;
                                    MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composer3, 0, -1323940314);
                                    Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM16882swipeablepPrIpRY);
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
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                    function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    composer3.startReplaceableGroup(-2137368960);
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer3.startReplaceableGroup(-1263168067);
                                    composer3.startReplaceableGroup(733328855);
                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer3, 0);
                                    Density density2 = (Density) AbstractC1038a.m1211l(composer3, -1323940314);
                                    LayoutDirection layoutDirection2 = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(companion);
                                    if (composer3.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor2);
                                    } else {
                                        composer3.useNode();
                                    }
                                    composer3.disableReusing();
                                    Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer3);
                                    Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl2, density2));
                                    function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composer3, composer3), composer3, 0);
                                    AbstractC1038a.m1220u(2058660585, -2137368960, composer3, 32495683);
                                    function2.invoke(composer3, Integer.valueOf((i17 >> 27) & 14));
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    boolean zIsOpen = drawerState5.isOpen();
                                    Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2

                                        /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1 */
                                        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                        @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                        @DebugMetadata(m14020c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1", m14021f = "Drawer.kt", m14022i = {}, m14023l = {TypedValues.Cycle.TYPE_WAVE_SHAPE}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                        public static final class C15191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ DrawerState $drawerState;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            public C15191(DrawerState drawerState, Continuation<? super C15191> continuation) {
                                                super(2, continuation);
                                                this.$drawerState = drawerState;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            @NotNull
                                            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                                return new C15191(this.$drawerState, continuation);
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            @Nullable
                                            public final Object invokeSuspend(@NotNull Object obj) {
                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                int i = this.label;
                                                if (i == 0) {
                                                    ResultKt.throwOnFailure(obj);
                                                    DrawerState drawerState = this.$drawerState;
                                                    this.label = 1;
                                                    if (drawerState.close(this) == coroutine_suspended) {
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
                                                return ((C15191) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                                            if (z7 && drawerState5.getSwipeableState$material_release().getConfirmStateChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope22, null, null, new C15191(drawerState5, null), 3, null);
                                            }
                                        }
                                    };
                                    Object objValueOf = Float.valueOf(f7);
                                    Object objValueOf2 = Float.valueOf(0.0f);
                                    composer3.startReplaceableGroup(1618982084);
                                    boolean zChanged = composer3.changed(objValueOf) | composer3.changed(objValueOf2) | composer3.changed(drawerState5);
                                    Object objRememberedValue2 = composer3.rememberedValue();
                                    if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = new Function0<Float>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$3$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            @NotNull
                                            public final Float invoke() {
                                                return Float.valueOf(DrawerKt.calculateFraction(f7, f8, drawerState5.getOffset().getValue().floatValue()));
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue2);
                                    }
                                    composer3.endReplaceableGroup();
                                    DrawerKt.m16726ScrimBx497Mc(zIsOpen, function0, (Function0) objRememberedValue2, j10, composer3, (i17 >> 15) & 7168);
                                    final String strM16870getString4foXLRw = Strings_androidKt.m16870getString4foXLRw(Strings.INSTANCE.m16867getNavigationMenuUdPEhr4(), composer3, 6);
                                    Density density3 = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                    Modifier modifierM15902sizeInqDBjuR0 = SizeKt.m15902sizeInqDBjuR0(companion, density3.mo15543toDpu2uoSUM(Constraints.m20923getMinWidthimpl(jMo15761getConstraintsmsEJaDk)), density3.mo15543toDpu2uoSUM(Constraints.m20922getMinHeightimpl(jMo15761getConstraintsmsEJaDk)), density3.mo15543toDpu2uoSUM(Constraints.m20921getMaxWidthimpl(jMo15761getConstraintsmsEJaDk)), density3.mo15543toDpu2uoSUM(Constraints.m20920getMaxHeightimpl(jMo15761getConstraintsmsEJaDk)));
                                    composer3.startReplaceableGroup(1157296644);
                                    boolean zChanged2 = composer3.changed(drawerState5);
                                    Object objRememberedValue3 = composer3.rememberedValue();
                                    if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue3 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$5$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ IntOffset invoke(Density density4) {
                                                return IntOffset.m21087boximpl(m16735invokeBjo55l4(density4));
                                            }

                                            /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                                            public final long m16735invokeBjo55l4(@NotNull Density offset) {
                                                Intrinsics.checkNotNullParameter(offset, "$this$offset");
                                                return IntOffsetKt.IntOffset(MathKt.roundToInt(drawerState5.getOffset().getValue().floatValue()), 0);
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue3);
                                    }
                                    composer3.endReplaceableGroup();
                                    int i18 = i17 >> 12;
                                    SurfaceKt.m16872SurfaceFjzlyU(SemanticsModifierKt.semantics$default(PaddingKt.m15858paddingqDBjuR0$default(OffsetKt.offset(modifierM15902sizeInqDBjuR0, (Function1) objRememberedValue3), 0.0f, 0.0f, DrawerKt.EndDrawerPadding, 0.0f, 11, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6
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
                                            if (drawerState5.isOpen()) {
                                                final DrawerState drawerState6 = drawerState5;
                                                final CoroutineScope coroutineScope3 = coroutineScope22;
                                                SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6.1

                                                    /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1, reason: invalid class name */
                                                    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                                    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                                    @DebugMetadata(m14020c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1", m14021f = "Drawer.kt", m14022i = {}, m14023l = {450}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                        final /* synthetic */ DrawerState $drawerState;
                                                        int label;

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        public AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                                            super(2, continuation);
                                                            this.$drawerState = drawerState;
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
                                                                DrawerState drawerState = this.$drawerState;
                                                                this.label = 1;
                                                                if (drawerState.close(this) == coroutine_suspended) {
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
                                                        if (drawerState6.getSwipeableState$material_release().getConfirmStateChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass1(drawerState6, null), 3, null);
                                                        }
                                                        return Boolean.TRUE;
                                                    }
                                                }, 1, null);
                                            }
                                        }
                                    }, 1, null), shape7, j11, j12, null, f9, ComposableLambdaKt.composableLambda(composer3, -1941234439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$7
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
                                        public final void invoke(@Nullable Composer composer4, int i19) {
                                            if ((i19 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1941234439, i19, -1, "androidx.compose.material.ModalDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:458)");
                                            }
                                            Modifier modifierFillMaxSize$default22 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                            int i20 = ((i17 << 9) & 7168) | 6;
                                            composer4.startReplaceableGroup(-483455358);
                                            MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer4, 0, -1323940314);
                                            Density density4 = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                            LayoutDirection layoutDirection3 = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxSize$default22);
                                            if (composer4.getApplier() == null) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer4.createNode(constructor3);
                                            } else {
                                                composer4.useNode();
                                            }
                                            composer4.disableReusing();
                                            Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composer4);
                                            Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl3, measurePolicyM1209j, composerM18018constructorimpl3, density4));
                                            AbstractC1038a.m1221v(0, function3MaterializerOf3, AbstractC1038a.m1206g(companion4, composerM18018constructorimpl3, viewConfiguration3, composer4, composer4), composer4, 2058660585);
                                            composer4.startReplaceableGroup(-1163856341);
                                            function32.invoke(ColumnScopeInstance.INSTANCE, composer4, Integer.valueOf(((i20 >> 6) & 112) | 6));
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            composer4.endNode();
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer3, ((i17 >> 9) & 112) | 1572864 | (i18 & 896) | (i18 & 7168) | (458752 & i17), 16);
                                    if (AbstractC1038a.m1225z(composer3)) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            shape4 = shape3;
                            f6 = f5;
                            j8 = j92;
                            drawerState3 = drawerState42;
                            z4 = z52;
                            modifier5 = modifier72;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                f4 = f;
                if ((i & 3670016) != 0) {
                }
                if ((i & 29360128) == 0) {
                }
                if ((i & 234881024) == 0) {
                }
                if ((i2 & 512) != 0) {
                }
                i4 |= i8;
                if ((1533916891 & i4) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((57344 & i) == 0) {
            }
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            f4 = f;
            if ((i & 3670016) != 0) {
            }
            if ((i & 29360128) == 0) {
            }
            if ((i & 234881024) == 0) {
            }
            if ((i2 & 512) != 0) {
            }
            i4 |= i8;
            if ((1533916891 & i4) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 896) != 0) {
        }
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        if ((57344 & i) == 0) {
        }
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        f4 = f;
        if ((i & 3670016) != 0) {
        }
        if ((i & 29360128) == 0) {
        }
        if ((i & 234881024) == 0) {
        }
        if ((i2 & 512) != 0) {
        }
        i4 |= i8;
        if ((1533916891 & i4) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Scrim-Bx497Mc, reason: not valid java name */
    public static final void m16726ScrimBx497Mc(final boolean z, final Function0<Unit> function0, final Function0<Float> function02, final long j, Composer composer, final int i) {
        int i2;
        Modifier modifierSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(1983403750);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(function02) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 2048 : 1024;
        }
        if ((i2 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1983403750, i2, -1, "androidx.compose.material.Scrim (Drawer.kt:654)");
            }
            final String strM16870getString4foXLRw = Strings_androidKt.m16870getString4foXLRw(Strings.INSTANCE.m16863getCloseDrawerUdPEhr4(), composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(1010554047);
            if (z) {
                Modifier.Companion companion = Modifier.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                boolean zChanged = composerStartRestartGroup.changed(function0);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new DrawerKt$Scrim$dismissDrawer$1$1(function0, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                boolean zChanged2 = composerStartRestartGroup.changed(strM16870getString4foXLRw) | composerStartRestartGroup.changed(function0);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1
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
                            final Function0<Unit> function03 = function0;
                            SemanticsPropertiesKt.onClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                @NotNull
                                public final Boolean invoke() {
                                    function03.invoke();
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
            boolean zChanged3 = composerStartRestartGroup.changed(colorM18515boximpl) | composerStartRestartGroup.changed(function02);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$1$1
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
                        DrawScope.m19070drawRectnJ9OG0$default(Canvas, j, 0L, 0L, function02.invoke().floatValue(), null, null, 0, 118, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierThen, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$2
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
                DrawerKt.m16726ScrimBx497Mc(z, function0, function02, j, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateFraction(float f, float f4, float f5) {
        return RangesKt.coerceIn((f5 - f) / (f4 - f), 0.0f, 1.0f);
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final BottomDrawerState rememberBottomDrawerState(@NotNull final BottomDrawerValue initialValue, @Nullable final Function1<? super BottomDrawerValue, Boolean> function1, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        composer.startReplaceableGroup(-598115156);
        if ((i2 & 2) != 0) {
            function1 = new Function1<BottomDrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt.rememberBottomDrawerState.1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull BottomDrawerValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.TRUE;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-598115156, i, -1, "androidx.compose.material.rememberBottomDrawerState (Drawer.kt:333)");
        }
        Object[] objArr = new Object[0];
        Saver<BottomDrawerState, BottomDrawerValue> Saver = BottomDrawerState.Companion.Saver(function1);
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(initialValue) | composer.changed(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0<BottomDrawerState>() { // from class: androidx.compose.material.DrawerKt$rememberBottomDrawerState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final BottomDrawerState invoke() {
                    return new BottomDrawerState(initialValue, function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        BottomDrawerState bottomDrawerState = (BottomDrawerState) RememberSaveableKt.m18111rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) objRememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bottomDrawerState;
    }

    @Composable
    @NotNull
    public static final DrawerState rememberDrawerState(@NotNull final DrawerValue initialValue, @Nullable final Function1<? super DrawerValue, Boolean> function1, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        composer.startReplaceableGroup(-1435874229);
        if ((i2 & 2) != 0) {
            function1 = new Function1<DrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt.rememberDrawerState.1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull DrawerValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.TRUE;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1435874229, i, -1, "androidx.compose.material.rememberDrawerState (Drawer.kt:316)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.INSTANCE.Saver(function1);
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(initialValue) | composer.changed(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0<DrawerState>() { // from class: androidx.compose.material.DrawerKt$rememberDrawerState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final DrawerState invoke() {
                    return new DrawerState(initialValue, function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DrawerState drawerState = (DrawerState) RememberSaveableKt.m18111rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) objRememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return drawerState;
    }
}
