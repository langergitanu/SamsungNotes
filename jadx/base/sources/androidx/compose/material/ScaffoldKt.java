package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.UiComposable;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.layout.SubcomposeLayoutKt;
import androidx.compose.p109ui.layout.SubcomposeMeasureScope;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a¢\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\u0019\b\u0002\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192 \b\u0002\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\b\b\u0002\u0010&\u001a\u00020\"2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a£\u0001\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00172\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a!\u00103\u001a\u00020\r2\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u0014H\u0007¢\u0006\u0002\u00107\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00068"}, m13886d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/ScaffoldState;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "isFloatingActionButtonDocked", "", "drawerContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "drawerGesturesEnabled", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-27mzLpw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ScaffoldLayout", "isFabDocked", "fabPosition", "Landroidx/compose/ui/UiComposable;", "snackbar", "fab", "ScaffoldLayout-MDYNRJg", "(ZILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "rememberScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ScaffoldState;", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ScaffoldKt {

    @NotNull
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(new Function0<FabPlacement>() { // from class: androidx.compose.material.ScaffoldKt$LocalFabPlacement$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final FabPlacement invoke() {
            return null;
        }
    });
    private static final float FabSpacing = C2256Dp.m20968constructorimpl(16);

    /* JADX WARN: Removed duplicated region for block: B:101:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x04bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:294:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013a  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Scaffold-27mzLpw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16843Scaffold27mzLpw(@Nullable Modifier modifier, @Nullable ScaffoldState scaffoldState, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, int i, boolean z, @Nullable Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, boolean z2, @Nullable Shape shape, float f, long j, long j2, long j3, long j5, long j6, @NotNull final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i2, final int i4, final int i5) {
        Modifier modifier2;
        int i6;
        ScaffoldState scaffoldState2;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function2M16703getLambda2$material_release;
        int i8;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3M16704getLambda3$material_release;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function2M16705getLambda4$material_release;
        int i10;
        int iM16764getEnd5ygKITE;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        long jM16680getSurface0d7_KjU;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33;
        boolean z3;
        Shape large;
        float fM16721getElevationD9Ej5fM;
        int i20;
        long jM16694contentColorForek8zF_U;
        int i21;
        int i22;
        long scrimColor;
        int i23;
        long jM16669getBackground0d7_KjU;
        int i24;
        int i25;
        long j7;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        boolean z4;
        long jM16694contentColorForek8zF_U2;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function34;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function35;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        boolean z5;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function36;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final ScaffoldState scaffoldState3;
        final boolean z6;
        final int i26;
        final long j8;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function37;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Shape shape2;
        final float f4;
        final long j9;
        final long j10;
        final long j11;
        final long j12;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i27;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1037492569);
        int i28 = i5 & 1;
        if (i28 != 0) {
            i6 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 14) == 0) {
            modifier2 = modifier;
            i6 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i6 = i2;
        }
        if ((i2 & 112) == 0) {
            if ((i5 & 2) == 0) {
                scaffoldState2 = scaffoldState;
                int i29 = composerStartRestartGroup.changed(scaffoldState2) ? 32 : 16;
                i6 |= i29;
            } else {
                scaffoldState2 = scaffoldState;
            }
            i6 |= i29;
        } else {
            scaffoldState2 = scaffoldState;
        }
        int i30 = i5 & 4;
        if (i30 != 0) {
            i6 |= 384;
        } else {
            if ((i2 & 896) == 0) {
                i6 |= composerStartRestartGroup.changed(function2) ? 256 : 128;
            }
            i7 = i5 & 8;
            if (i7 == 0) {
                i6 |= 3072;
            } else {
                if ((i2 & 7168) == 0) {
                    function2M16703getLambda2$material_release = function22;
                    i6 |= composerStartRestartGroup.changed(function2M16703getLambda2$material_release) ? 2048 : 1024;
                }
                i8 = i5 & 16;
                int i31 = 8192;
                if (i8 != 0) {
                    i6 |= 24576;
                    function3M16704getLambda3$material_release = function3;
                } else {
                    function3M16704getLambda3$material_release = function3;
                    if ((i2 & 57344) == 0) {
                        i6 |= composerStartRestartGroup.changed(function3M16704getLambda3$material_release) ? 16384 : 8192;
                    }
                }
                i9 = i5 & 32;
                if (i9 != 0) {
                    i6 |= 196608;
                    function2M16705getLambda4$material_release = function23;
                } else {
                    function2M16705getLambda4$material_release = function23;
                    if ((i2 & 458752) == 0) {
                        i6 |= composerStartRestartGroup.changed(function2M16705getLambda4$material_release) ? 131072 : 65536;
                    }
                }
                i10 = i5 & 64;
                if (i10 != 0) {
                    i6 |= 1572864;
                    iM16764getEnd5ygKITE = i;
                } else {
                    iM16764getEnd5ygKITE = i;
                    if ((i2 & 3670016) == 0) {
                        i6 |= composerStartRestartGroup.changed(iM16764getEnd5ygKITE) ? 1048576 : 524288;
                    }
                }
                i11 = i5 & 128;
                if (i11 != 0) {
                    i6 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    i6 |= composerStartRestartGroup.changed(z) ? 8388608 : 4194304;
                }
                i12 = i5 & 256;
                if (i12 != 0) {
                    i6 |= 100663296;
                } else {
                    if ((i2 & 234881024) == 0) {
                        i13 = i12;
                        i6 |= composerStartRestartGroup.changed(function32) ? 67108864 : 33554432;
                    }
                    i14 = i5 & 512;
                    if (i14 == 0) {
                        i6 |= DriveFile.MODE_READ_WRITE;
                    } else {
                        if ((i2 & 1879048192) == 0) {
                            i15 = i14;
                            i6 |= composerStartRestartGroup.changed(z2) ? 536870912 : 268435456;
                        }
                        if ((i4 & 14) == 0) {
                            i16 = i4 | (((i5 & 1024) == 0 && composerStartRestartGroup.changed(shape)) ? 4 : 2);
                        } else {
                            i16 = i4;
                        }
                        i17 = i5 & 2048;
                        if (i17 != 0) {
                            i16 |= 48;
                        } else {
                            if ((i4 & 112) == 0) {
                                i18 = i17;
                                i16 |= composerStartRestartGroup.changed(f) ? 32 : 16;
                            }
                            if ((i4 & 896) != 0) {
                                i19 = i28;
                                jM16680getSurface0d7_KjU = j;
                                i16 |= ((i5 & 4096) == 0 && composerStartRestartGroup.changed(jM16680getSurface0d7_KjU)) ? 256 : 128;
                            } else {
                                i19 = i28;
                                jM16680getSurface0d7_KjU = j;
                            }
                            if ((i4 & 7168) == 0) {
                                i16 |= ((i5 & 8192) == 0 && composerStartRestartGroup.changed(j2)) ? 2048 : 1024;
                            }
                            if ((i4 & 57344) == 0) {
                                if ((i5 & 16384) == 0 && composerStartRestartGroup.changed(j3)) {
                                    i31 = 16384;
                                }
                                i16 |= i31;
                            }
                            if ((i4 & 458752) == 0) {
                                i16 |= ((i5 & 32768) == 0 && composerStartRestartGroup.changed(j5)) ? 131072 : 65536;
                            }
                            if ((i4 & 3670016) == 0) {
                                i16 |= ((i5 & 65536) == 0 && composerStartRestartGroup.changed(j6)) ? 1048576 : 524288;
                            }
                            if ((i5 & 131072) != 0) {
                                i27 = (i4 & 29360128) == 0 ? composerStartRestartGroup.changed(content) ? 8388608 : 4194304 : 12582912;
                                if ((i6 & 1533916891) == 306783378 && (i16 & 23967451) == 4793490 && composerStartRestartGroup.getSkipping()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    function25 = function2;
                                    z5 = z;
                                    function36 = function32;
                                    j9 = j2;
                                    j10 = j3;
                                    j11 = j5;
                                    j12 = j6;
                                    composer2 = composerStartRestartGroup;
                                    function26 = function2M16703getLambda2$material_release;
                                    scaffoldState3 = scaffoldState2;
                                    i26 = iM16764getEnd5ygKITE;
                                    z6 = z2;
                                    j8 = jM16680getSurface0d7_KjU;
                                    function37 = function3M16704getLambda3$material_release;
                                    function27 = function2M16705getLambda4$material_release;
                                    shape2 = shape;
                                    f4 = f;
                                } else {
                                    composerStartRestartGroup.startDefaults();
                                    if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i19 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if ((i5 & 2) != 0) {
                                            ScaffoldState scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                            i6 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                            scaffoldState2 = scaffoldStateRememberScaffoldState;
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> function2M16702getLambda1$material_release = i30 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m16702getLambda1$material_release() : function2;
                                        if (i7 != 0) {
                                            function2M16703getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m16703getLambda2$material_release();
                                        }
                                        if (i8 != 0) {
                                            function3M16704getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m16704getLambda3$material_release();
                                        }
                                        if (i9 != 0) {
                                            function2M16705getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m16705getLambda4$material_release();
                                        }
                                        if (i10 != 0) {
                                            iM16764getEnd5ygKITE = FabPosition.INSTANCE.m16764getEnd5ygKITE();
                                        }
                                        boolean z7 = i11 == 0 ? false : z;
                                        function33 = i13 == 0 ? null : function32;
                                        z3 = i15 == 0 ? true : z2;
                                        Function2<? super Composer, ? super Integer, Unit> function28 = function2M16702getLambda1$material_release;
                                        if ((i5 & 1024) == 0) {
                                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                            i16 &= -15;
                                        } else {
                                            large = shape;
                                        }
                                        int i32 = i16;
                                        fM16721getElevationD9Ej5fM = i18 == 0 ? DrawerDefaults.INSTANCE.m16721getElevationD9Ej5fM() : f;
                                        if ((i5 & 4096) == 0) {
                                            jM16680getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m16680getSurface0d7_KjU();
                                            i20 = i32 & (-897);
                                        } else {
                                            i20 = i32;
                                        }
                                        boolean z8 = z7;
                                        if ((i5 & 8192) == 0) {
                                            jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(jM16680getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 6) & 14);
                                            i20 &= -7169;
                                        } else {
                                            jM16694contentColorForek8zF_U = j2;
                                        }
                                        if ((i5 & 16384) == 0) {
                                            int i33 = i20;
                                            i21 = 6;
                                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                            i22 = i33 & (-57345);
                                        } else {
                                            int i34 = i20;
                                            i21 = 6;
                                            i22 = i34;
                                            scrimColor = j3;
                                        }
                                        int i35 = i22;
                                        if ((i5 & 32768) == 0) {
                                            jM16669getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i21).m16669getBackground0d7_KjU();
                                            i23 = i35 & (-458753);
                                        } else {
                                            i23 = i35;
                                            jM16669getBackground0d7_KjU = j5;
                                        }
                                        if ((i5 & 65536) == 0) {
                                            Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function38 = function33;
                                            int i36 = i23 & (-3670017);
                                            function24 = function28;
                                            jM16694contentColorForek8zF_U2 = ColorsKt.m16694contentColorForek8zF_U(jM16669getBackground0d7_KjU, composerStartRestartGroup, (i23 >> 15) & 14);
                                            j7 = jM16669getBackground0d7_KjU;
                                            i24 = i6;
                                            z4 = z8;
                                            i25 = i36;
                                            function33 = function38;
                                        } else {
                                            long j13 = jM16669getBackground0d7_KjU;
                                            i24 = i6;
                                            i25 = i23;
                                            j7 = j13;
                                            function24 = function28;
                                            z4 = z8;
                                            jM16694contentColorForek8zF_U2 = j6;
                                        }
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i5 & 2) != 0) {
                                            i6 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                        }
                                        if ((i5 & 1024) != 0) {
                                            i16 &= -15;
                                        }
                                        int i37 = i16;
                                        if ((i5 & 4096) != 0) {
                                            i37 &= -897;
                                        }
                                        if ((i5 & 8192) != 0) {
                                            i37 &= -7169;
                                        }
                                        if ((i5 & 16384) != 0) {
                                            i37 &= -57345;
                                        }
                                        if ((32768 & i5) != 0) {
                                            i37 &= -458753;
                                        }
                                        if ((i5 & 65536) != 0) {
                                            i37 &= -3670017;
                                        }
                                        int i38 = i6;
                                        i25 = i37;
                                        i24 = i38;
                                        z4 = z;
                                        function33 = function32;
                                        z3 = z2;
                                        large = shape;
                                        fM16721getElevationD9Ej5fM = f;
                                        jM16694contentColorForek8zF_U = j2;
                                        scrimColor = j3;
                                        j7 = j5;
                                        jM16694contentColorForek8zF_U2 = j6;
                                        function24 = function2;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    final boolean z9 = z4;
                                    if (ComposerKt.isTraceInProgress()) {
                                        function34 = function33;
                                    } else {
                                        function34 = function33;
                                        ComposerKt.traceEventStart(1037492569, i24, i25, "androidx.compose.material.Scaffold (Scaffold.kt:158)");
                                    }
                                    final int i39 = i24;
                                    final Function2<? super Composer, ? super Integer, Unit> function29 = function2M16703getLambda2$material_release;
                                    final int i40 = i25;
                                    final ScaffoldState scaffoldState4 = scaffoldState2;
                                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function39 = function3M16704getLambda3$material_release;
                                    final Function2<? super Composer, ? super Integer, Unit> function210 = function2M16705getLambda4$material_release;
                                    final int i41 = iM16764getEnd5ygKITE;
                                    final long j14 = j7;
                                    final long j15 = jM16694contentColorForek8zF_U2;
                                    Function2<? super Composer, ? super Integer, Unit> function211 = function24;
                                    final ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier3, Composer composer3, Integer num) {
                                            invoke(modifier3, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                        @Composable
                                        public final void invoke(@NotNull Modifier childModifier, @Nullable Composer composer3, int i42) {
                                            int i43;
                                            Intrinsics.checkNotNullParameter(childModifier, "childModifier");
                                            if ((i42 & 14) == 0) {
                                                i43 = i42 | (composer3.changed(childModifier) ? 4 : 2);
                                            } else {
                                                i43 = i42;
                                            }
                                            if ((i43 & 91) == 18 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1823402604, i43, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:178)");
                                            }
                                            long j16 = j14;
                                            long j17 = j15;
                                            final boolean z10 = z9;
                                            final int i44 = i41;
                                            final Function2<Composer, Integer, Unit> function212 = function24;
                                            final Function3<PaddingValues, Composer, Integer, Unit> function310 = content;
                                            final Function2<Composer, Integer, Unit> function213 = function210;
                                            final Function2<Composer, Integer, Unit> function214 = function29;
                                            final int i45 = i39;
                                            final int i46 = i40;
                                            final Function3<SnackbarHostState, Composer, Integer, Unit> function311 = function39;
                                            final ScaffoldState scaffoldState5 = scaffoldState4;
                                            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer3, -1128984656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.1
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
                                                public final void invoke(@Nullable Composer composer4, int i47) {
                                                    if ((i47 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1128984656, i47, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:179)");
                                                    }
                                                    boolean z11 = z10;
                                                    int i48 = i44;
                                                    Function2<Composer, Integer, Unit> function215 = function212;
                                                    Function3<PaddingValues, Composer, Integer, Unit> function312 = function310;
                                                    final Function3<SnackbarHostState, Composer, Integer, Unit> function313 = function311;
                                                    final ScaffoldState scaffoldState6 = scaffoldState5;
                                                    final int i49 = i45;
                                                    ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer4, 533782017, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.1.1
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

                                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                        @Composable
                                                        public final void invoke(@Nullable Composer composer5, int i50) {
                                                            if ((i50 & 11) == 2 && composer5.getSkipping()) {
                                                                composer5.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(533782017, i50, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:185)");
                                                            }
                                                            function313.invoke(scaffoldState6.getSnackbarHostState(), composer5, Integer.valueOf((i49 >> 9) & 112));
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    });
                                                    Function2<Composer, Integer, Unit> function216 = function213;
                                                    Function2<Composer, Integer, Unit> function217 = function214;
                                                    int i50 = i45;
                                                    ScaffoldKt.m16844ScaffoldLayoutMDYNRJg(z11, i48, function215, function312, composableLambda3, function216, function217, composer4, ((i50 >> 21) & 14) | 24576 | ((i50 >> 15) & 112) | (i50 & 896) | ((i46 >> 12) & 7168) | (458752 & i50) | ((i50 << 9) & 3670016));
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            });
                                            int i47 = 1572864 | (i43 & 14);
                                            int i48 = i40;
                                            SurfaceKt.m16872SurfaceFjzlyU(childModifier, null, j16, j17, null, 0.0f, composableLambda2, composer3, i47 | ((i48 >> 9) & 896) | ((i48 >> 9) & 7168), 50);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                    if (function34 == null) {
                                        composerStartRestartGroup.startReplaceableGroup(-1013848234);
                                        int i42 = i40 << 12;
                                        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function310 = function34;
                                        DrawerKt.m16725ModalDrawerGs3lGvM(function310, modifier2, scaffoldState2.getDrawerState(), z3, large, fM16721getElevationD9Ej5fM, jM16680getSurface0d7_KjU, jM16694contentColorForek8zF_U, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
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
                                            public final void invoke(@Nullable Composer composer3, int i43) {
                                                if ((i43 & 11) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(100842932, i43, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:205)");
                                                }
                                                composableLambda.invoke(Modifier.INSTANCE, composer3, 54);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composerStartRestartGroup, ((i39 >> 24) & 14) | DriveFile.MODE_READ_WRITE | ((i39 << 3) & 112) | ((i39 >> 18) & 7168) | (i42 & 57344) | (i42 & 458752) | (i42 & 3670016) | (i42 & 29360128) | (i42 & 234881024), 0);
                                        function35 = function310;
                                        composer2 = composerStartRestartGroup;
                                        composer2.endReplaceableGroup();
                                    } else {
                                        function35 = function34;
                                        composer2 = composerStartRestartGroup;
                                        composer2.startReplaceableGroup(-1013847725);
                                        composableLambda.invoke(modifier2, composer2, Integer.valueOf((i39 & 14) | 48));
                                        composer2.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    function25 = function211;
                                    z5 = z9;
                                    function36 = function35;
                                    function26 = function2M16703getLambda2$material_release;
                                    scaffoldState3 = scaffoldState2;
                                    z6 = z3;
                                    i26 = iM16764getEnd5ygKITE;
                                    j8 = jM16680getSurface0d7_KjU;
                                    function37 = function3M16704getLambda3$material_release;
                                    function27 = function2M16705getLambda4$material_release;
                                    shape2 = large;
                                    f4 = fM16721getElevationD9Ej5fM;
                                    j9 = jM16694contentColorForek8zF_U;
                                    j10 = scrimColor;
                                    j11 = j7;
                                    j12 = jM16694contentColorForek8zF_U2;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                    return;
                                }
                                final Modifier modifier3 = modifier2;
                                final boolean z10 = z5;
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$2
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

                                    public final void invoke(@Nullable Composer composer3, int i43) {
                                        ScaffoldKt.m16843Scaffold27mzLpw(modifier3, scaffoldState3, function25, function26, function37, function27, i26, z10, function36, z6, shape2, f4, j8, j9, j10, j11, j12, content, composer3, i2 | 1, i4, i5);
                                    }
                                });
                                return;
                            }
                            i16 |= i27;
                            if ((i6 & 1533916891) == 306783378) {
                                composerStartRestartGroup.startDefaults();
                                if ((i2 & 1) != 0) {
                                    if (i19 != 0) {
                                    }
                                    if ((i5 & 2) != 0) {
                                    }
                                    if (i30 == 0) {
                                    }
                                    if (i7 != 0) {
                                    }
                                    if (i8 != 0) {
                                    }
                                    if (i9 != 0) {
                                    }
                                    if (i10 != 0) {
                                    }
                                    if (i11 == 0) {
                                    }
                                    if (i13 == 0) {
                                    }
                                    if (i15 == 0) {
                                    }
                                    Function2<? super Composer, ? super Integer, Unit> function282 = function2M16702getLambda1$material_release;
                                    if ((i5 & 1024) == 0) {
                                    }
                                    int i322 = i16;
                                    if (i18 == 0) {
                                    }
                                    if ((i5 & 4096) == 0) {
                                    }
                                    boolean z82 = z7;
                                    if ((i5 & 8192) == 0) {
                                    }
                                    if ((i5 & 16384) == 0) {
                                    }
                                    int i352 = i22;
                                    if ((i5 & 32768) == 0) {
                                    }
                                    if ((i5 & 65536) == 0) {
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    final boolean z92 = z4;
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    final int i392 = i24;
                                    final Function2<? super Composer, ? super Integer, Unit> function292 = function2M16703getLambda2$material_release;
                                    final int i402 = i25;
                                    final ScaffoldState scaffoldState42 = scaffoldState2;
                                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function392 = function3M16704getLambda3$material_release;
                                    final Function2<? super Composer, ? super Integer, Unit> function2102 = function2M16705getLambda4$material_release;
                                    final int i412 = iM16764getEnd5ygKITE;
                                    final long j142 = j7;
                                    final long j152 = jM16694contentColorForek8zF_U2;
                                    Function2<? super Composer, ? super Integer, Unit> function2112 = function24;
                                    final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier32, Composer composer3, Integer num) {
                                            invoke(modifier32, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                        @Composable
                                        public final void invoke(@NotNull Modifier childModifier, @Nullable Composer composer3, int i422) {
                                            int i43;
                                            Intrinsics.checkNotNullParameter(childModifier, "childModifier");
                                            if ((i422 & 14) == 0) {
                                                i43 = i422 | (composer3.changed(childModifier) ? 4 : 2);
                                            } else {
                                                i43 = i422;
                                            }
                                            if ((i43 & 91) == 18 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1823402604, i43, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:178)");
                                            }
                                            long j16 = j142;
                                            long j17 = j152;
                                            final boolean z102 = z92;
                                            final int i44 = i412;
                                            final Function2<? super Composer, ? super Integer, Unit> function212 = function24;
                                            final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3102 = content;
                                            final Function2<? super Composer, ? super Integer, Unit> function213 = function2102;
                                            final Function2<? super Composer, ? super Integer, Unit> function214 = function292;
                                            final int i45 = i392;
                                            final int i46 = i402;
                                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function311 = function392;
                                            final ScaffoldState scaffoldState5 = scaffoldState42;
                                            ComposableLambda composableLambda22 = ComposableLambdaKt.composableLambda(composer3, -1128984656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.1
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
                                                public final void invoke(@Nullable Composer composer4, int i47) {
                                                    if ((i47 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1128984656, i47, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:179)");
                                                    }
                                                    boolean z11 = z102;
                                                    int i48 = i44;
                                                    Function2<Composer, Integer, Unit> function215 = function212;
                                                    Function3<PaddingValues, Composer, Integer, Unit> function312 = function3102;
                                                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function313 = function311;
                                                    final ScaffoldState scaffoldState6 = scaffoldState5;
                                                    final int i49 = i45;
                                                    ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer4, 533782017, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.1.1
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

                                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                        @Composable
                                                        public final void invoke(@Nullable Composer composer5, int i50) {
                                                            if ((i50 & 11) == 2 && composer5.getSkipping()) {
                                                                composer5.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(533782017, i50, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:185)");
                                                            }
                                                            function313.invoke(scaffoldState6.getSnackbarHostState(), composer5, Integer.valueOf((i49 >> 9) & 112));
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    });
                                                    Function2<Composer, Integer, Unit> function216 = function213;
                                                    Function2<Composer, Integer, Unit> function217 = function214;
                                                    int i50 = i45;
                                                    ScaffoldKt.m16844ScaffoldLayoutMDYNRJg(z11, i48, function215, function312, composableLambda3, function216, function217, composer4, ((i50 >> 21) & 14) | 24576 | ((i50 >> 15) & 112) | (i50 & 896) | ((i46 >> 12) & 7168) | (458752 & i50) | ((i50 << 9) & 3670016));
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            });
                                            int i47 = 1572864 | (i43 & 14);
                                            int i48 = i402;
                                            SurfaceKt.m16872SurfaceFjzlyU(childModifier, null, j16, j17, null, 0.0f, composableLambda22, composer3, i47 | ((i48 >> 9) & 896) | ((i48 >> 9) & 7168), 50);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                    if (function34 == null) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    function25 = function2112;
                                    z5 = z92;
                                    function36 = function35;
                                    function26 = function2M16703getLambda2$material_release;
                                    scaffoldState3 = scaffoldState2;
                                    z6 = z3;
                                    i26 = iM16764getEnd5ygKITE;
                                    j8 = jM16680getSurface0d7_KjU;
                                    function37 = function3M16704getLambda3$material_release;
                                    function27 = function2M16705getLambda4$material_release;
                                    shape2 = large;
                                    f4 = fM16721getElevationD9Ej5fM;
                                    j9 = jM16694contentColorForek8zF_U;
                                    j10 = scrimColor;
                                    j11 = j7;
                                    j12 = jM16694contentColorForek8zF_U2;
                                }
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                            }
                        }
                        i18 = i17;
                        if ((i4 & 896) != 0) {
                        }
                        if ((i4 & 7168) == 0) {
                        }
                        if ((i4 & 57344) == 0) {
                        }
                        if ((i4 & 458752) == 0) {
                        }
                        if ((i4 & 3670016) == 0) {
                        }
                        if ((i5 & 131072) != 0) {
                        }
                        i16 |= i27;
                        if ((i6 & 1533916891) == 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i15 = i14;
                    if ((i4 & 14) == 0) {
                    }
                    i17 = i5 & 2048;
                    if (i17 != 0) {
                    }
                    i18 = i17;
                    if ((i4 & 896) != 0) {
                    }
                    if ((i4 & 7168) == 0) {
                    }
                    if ((i4 & 57344) == 0) {
                    }
                    if ((i4 & 458752) == 0) {
                    }
                    if ((i4 & 3670016) == 0) {
                    }
                    if ((i5 & 131072) != 0) {
                    }
                    i16 |= i27;
                    if ((i6 & 1533916891) == 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i13 = i12;
                i14 = i5 & 512;
                if (i14 == 0) {
                }
                i15 = i14;
                if ((i4 & 14) == 0) {
                }
                i17 = i5 & 2048;
                if (i17 != 0) {
                }
                i18 = i17;
                if ((i4 & 896) != 0) {
                }
                if ((i4 & 7168) == 0) {
                }
                if ((i4 & 57344) == 0) {
                }
                if ((i4 & 458752) == 0) {
                }
                if ((i4 & 3670016) == 0) {
                }
                if ((i5 & 131072) != 0) {
                }
                i16 |= i27;
                if ((i6 & 1533916891) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function2M16703getLambda2$material_release = function22;
            i8 = i5 & 16;
            int i312 = 8192;
            if (i8 != 0) {
            }
            i9 = i5 & 32;
            if (i9 != 0) {
            }
            i10 = i5 & 64;
            if (i10 != 0) {
            }
            i11 = i5 & 128;
            if (i11 != 0) {
            }
            i12 = i5 & 256;
            if (i12 != 0) {
            }
            i13 = i12;
            i14 = i5 & 512;
            if (i14 == 0) {
            }
            i15 = i14;
            if ((i4 & 14) == 0) {
            }
            i17 = i5 & 2048;
            if (i17 != 0) {
            }
            i18 = i17;
            if ((i4 & 896) != 0) {
            }
            if ((i4 & 7168) == 0) {
            }
            if ((i4 & 57344) == 0) {
            }
            if ((i4 & 458752) == 0) {
            }
            if ((i4 & 3670016) == 0) {
            }
            if ((i5 & 131072) != 0) {
            }
            i16 |= i27;
            if ((i6 & 1533916891) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        i7 = i5 & 8;
        if (i7 == 0) {
        }
        function2M16703getLambda2$material_release = function22;
        i8 = i5 & 16;
        int i3122 = 8192;
        if (i8 != 0) {
        }
        i9 = i5 & 32;
        if (i9 != 0) {
        }
        i10 = i5 & 64;
        if (i10 != 0) {
        }
        i11 = i5 & 128;
        if (i11 != 0) {
        }
        i12 = i5 & 256;
        if (i12 != 0) {
        }
        i13 = i12;
        i14 = i5 & 512;
        if (i14 == 0) {
        }
        i15 = i14;
        if ((i4 & 14) == 0) {
        }
        i17 = i5 & 2048;
        if (i17 != 0) {
        }
        i18 = i17;
        if ((i4 & 896) != 0) {
        }
        if ((i4 & 7168) == 0) {
        }
        if ((i4 & 57344) == 0) {
        }
        if ((i4 & 458752) == 0) {
        }
        if ((i4 & 3670016) == 0) {
        }
        if ((i5 & 131072) != 0) {
        }
        i16 |= i27;
        if ((i6 & 1533916891) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @UiComposable
    /* JADX INFO: renamed from: ScaffoldLayout-MDYNRJg, reason: not valid java name */
    public static final void m16844ScaffoldLayoutMDYNRJg(final boolean z, final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1401632215);
        int i4 = (i2 & 14) == 0 ? (composerStartRestartGroup.changed(z) ? 4 : 2) | i2 : i2;
        if ((i2 & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(function2) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(function3) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i4 |= composerStartRestartGroup.changed(function22) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i4 |= composerStartRestartGroup.changed(function23) ? 131072 : 65536;
        }
        if ((3670016 & i2) == 0) {
            i4 |= composerStartRestartGroup.changed(function24) ? 1048576 : 524288;
        }
        if ((2995931 & i4) == 599186 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1401632215, i4, -1, "androidx.compose.material.ScaffoldLayout (Scaffold.kt:227)");
            }
            Object[] objArr = {function2, function22, function23, FabPosition.m16756boximpl(i), Boolean.valueOf(z), function24, function3};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            boolean zChanged = false;
            for (int i5 = 0; i5 < 7; i5++) {
                zChanged |= composerStartRestartGroup.changed(objArr[i5]);
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                final int i6 = i4;
                Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function25 = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m16846invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    @NotNull
                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m16846invoke0kLqBqw(@NotNull final SubcomposeMeasureScope SubcomposeLayout, long j) {
                        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                        final int iM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(j);
                        final int iM20920getMaxHeightimpl = Constraints.m20920getMaxHeightimpl(j);
                        final long jM20912copyZbe2FdA$default = Constraints.m20912copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                        final Function2<Composer, Integer, Unit> function26 = function2;
                        final Function2<Composer, Integer, Unit> function27 = function22;
                        final Function2<Composer, Integer, Unit> function28 = function23;
                        final int i7 = i;
                        final boolean z2 = z;
                        final Function2<Composer, Integer, Unit> function29 = function24;
                        final int i8 = i6;
                        final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
                        return MeasureScope.layout$default(SubcomposeLayout, iM20921getMaxWidthimpl, iM20920getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:83:0x01bb  */
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                                Object obj;
                                Object obj2;
                                final FabPlacement fabPlacement;
                                Object obj3;
                                Integer numValueOf;
                                int height;
                                int iMo15540roundToPx0680j_4;
                                int height2;
                                Object obj4;
                                Object obj5;
                                Placeable.PlacementScope layout = placementScope;
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                List<Measurable> listSubcompose = SubcomposeLayout.subcompose(ScaffoldLayoutContent.TopBar, function26);
                                long j2 = jM20912copyZbe2FdA$default;
                                ArrayList arrayList = new ArrayList(listSubcompose.size());
                                int size = listSubcompose.size();
                                int i9 = 0;
                                for (int i10 = 0; i10 < size; i10++) {
                                    arrayList.add(listSubcompose.get(i10).mo19855measureBRTryo0(j2));
                                }
                                if (arrayList.isEmpty()) {
                                    obj = null;
                                } else {
                                    obj = arrayList.get(0);
                                    int height3 = ((Placeable) obj).getHeight();
                                    int lastIndex = CollectionsKt.getLastIndex(arrayList);
                                    if (1 <= lastIndex) {
                                        int i11 = 1;
                                        while (true) {
                                            Object obj6 = arrayList.get(i11);
                                            int height4 = ((Placeable) obj6).getHeight();
                                            if (height3 < height4) {
                                                obj = obj6;
                                                height3 = height4;
                                            }
                                            if (i11 == lastIndex) {
                                                break;
                                            } else {
                                                i11++;
                                            }
                                        }
                                    }
                                }
                                Placeable placeable = (Placeable) obj;
                                int height5 = placeable != null ? placeable.getHeight() : 0;
                                List<Measurable> listSubcompose2 = SubcomposeLayout.subcompose(ScaffoldLayoutContent.Snackbar, function27);
                                long j3 = jM20912copyZbe2FdA$default;
                                ArrayList arrayList2 = new ArrayList(listSubcompose2.size());
                                int size2 = listSubcompose2.size();
                                for (int i12 = 0; i12 < size2; i12++) {
                                    arrayList2.add(listSubcompose2.get(i12).mo19855measureBRTryo0(j3));
                                }
                                if (arrayList2.isEmpty()) {
                                    obj2 = null;
                                } else {
                                    obj2 = arrayList2.get(0);
                                    int height6 = ((Placeable) obj2).getHeight();
                                    int lastIndex2 = CollectionsKt.getLastIndex(arrayList2);
                                    if (1 <= lastIndex2) {
                                        int i13 = 1;
                                        while (true) {
                                            Object obj7 = arrayList2.get(i13);
                                            int height7 = ((Placeable) obj7).getHeight();
                                            if (height6 < height7) {
                                                obj2 = obj7;
                                                height6 = height7;
                                            }
                                            if (i13 == lastIndex2) {
                                                break;
                                            } else {
                                                i13++;
                                            }
                                        }
                                    }
                                }
                                Placeable placeable2 = (Placeable) obj2;
                                int height8 = placeable2 != null ? placeable2.getHeight() : 0;
                                List<Measurable> listSubcompose3 = SubcomposeLayout.subcompose(ScaffoldLayoutContent.Fab, function28);
                                long j5 = jM20912copyZbe2FdA$default;
                                ArrayList arrayList3 = new ArrayList(listSubcompose3.size());
                                int size3 = listSubcompose3.size();
                                for (int i14 = 0; i14 < size3; i14++) {
                                    arrayList3.add(listSubcompose3.get(i14).mo19855measureBRTryo0(j5));
                                }
                                if (arrayList3.isEmpty()) {
                                    fabPlacement = null;
                                } else {
                                    if (arrayList3.isEmpty()) {
                                        obj4 = null;
                                    } else {
                                        obj4 = arrayList3.get(0);
                                        int width = ((Placeable) obj4).getWidth();
                                        int lastIndex3 = CollectionsKt.getLastIndex(arrayList3);
                                        if (1 <= lastIndex3) {
                                            int i15 = 1;
                                            while (true) {
                                                Object obj8 = arrayList3.get(i15);
                                                int width2 = ((Placeable) obj8).getWidth();
                                                if (width < width2) {
                                                    obj4 = obj8;
                                                    width = width2;
                                                }
                                                if (i15 == lastIndex3) {
                                                    break;
                                                } else {
                                                    i15++;
                                                }
                                            }
                                        }
                                    }
                                    Placeable placeable3 = (Placeable) obj4;
                                    int width3 = placeable3 != null ? placeable3.getWidth() : 0;
                                    if (arrayList3.isEmpty()) {
                                        obj5 = null;
                                    } else {
                                        obj5 = arrayList3.get(0);
                                        int height9 = ((Placeable) obj5).getHeight();
                                        int lastIndex4 = CollectionsKt.getLastIndex(arrayList3);
                                        if (1 <= lastIndex4) {
                                            int i16 = 1;
                                            while (true) {
                                                Object obj9 = arrayList3.get(i16);
                                                int height10 = ((Placeable) obj9).getHeight();
                                                if (height9 < height10) {
                                                    height9 = height10;
                                                    obj5 = obj9;
                                                }
                                                if (i16 == lastIndex4) {
                                                    break;
                                                } else {
                                                    i16++;
                                                }
                                            }
                                        }
                                    }
                                    Placeable placeable4 = (Placeable) obj5;
                                    int height11 = placeable4 != null ? placeable4.getHeight() : 0;
                                    if (width3 != 0 && height11 != 0) {
                                        fabPlacement = new FabPlacement(z2, FabPosition.m16759equalsimpl0(i7, FabPosition.INSTANCE.m16764getEnd5ygKITE()) ? SubcomposeLayout.getLayoutDirection() == LayoutDirection.Ltr ? (iM20921getMaxWidthimpl - SubcomposeLayout.mo15540roundToPx0680j_4(ScaffoldKt.FabSpacing)) - width3 : SubcomposeLayout.mo15540roundToPx0680j_4(ScaffoldKt.FabSpacing) : (iM20921getMaxWidthimpl - width3) / 2, width3, height11);
                                    }
                                }
                                SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeLayout;
                                ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                                final Function2<Composer, Integer, Unit> function210 = function29;
                                final int i17 = i8;
                                List<Measurable> listSubcompose4 = subcomposeMeasureScope.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(1529070963, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1
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
                                    public final void invoke(@Nullable Composer composer2, int i18) {
                                        if ((i18 & 11) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1529070963, i18, -1, "androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:288)");
                                        }
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ScaffoldKt.getLocalFabPlacement().provides(fabPlacement)}, function210, composer2, ((i17 >> 15) & 112) | 8);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }));
                                long j6 = jM20912copyZbe2FdA$default;
                                ArrayList arrayList4 = new ArrayList(listSubcompose4.size());
                                int size4 = listSubcompose4.size();
                                for (int i18 = 0; i18 < size4; i18++) {
                                    arrayList4.add(listSubcompose4.get(i18).mo19855measureBRTryo0(j6));
                                }
                                if (arrayList4.isEmpty()) {
                                    obj3 = null;
                                } else {
                                    obj3 = arrayList4.get(0);
                                    int height12 = ((Placeable) obj3).getHeight();
                                    int lastIndex5 = CollectionsKt.getLastIndex(arrayList4);
                                    if (1 <= lastIndex5) {
                                        int i19 = 1;
                                        while (true) {
                                            Object obj10 = arrayList4.get(i19);
                                            int height13 = ((Placeable) obj10).getHeight();
                                            if (height12 < height13) {
                                                obj3 = obj10;
                                                height12 = height13;
                                            }
                                            if (i19 == lastIndex5) {
                                                break;
                                            } else {
                                                i19++;
                                            }
                                        }
                                    }
                                }
                                Placeable placeable5 = (Placeable) obj3;
                                final int height14 = placeable5 != null ? placeable5.getHeight() : 0;
                                if (fabPlacement != null) {
                                    SubcomposeMeasureScope subcomposeMeasureScope2 = SubcomposeLayout;
                                    boolean z3 = z2;
                                    if (height14 == 0) {
                                        height = fabPlacement.getHeight();
                                        iMo15540roundToPx0680j_4 = subcomposeMeasureScope2.mo15540roundToPx0680j_4(ScaffoldKt.FabSpacing);
                                    } else if (z3) {
                                        height2 = (fabPlacement.getHeight() / 2) + height14;
                                        numValueOf = Integer.valueOf(height2);
                                    } else {
                                        height = fabPlacement.getHeight() + height14;
                                        iMo15540roundToPx0680j_4 = subcomposeMeasureScope2.mo15540roundToPx0680j_4(ScaffoldKt.FabSpacing);
                                    }
                                    height2 = iMo15540roundToPx0680j_4 + height;
                                    numValueOf = Integer.valueOf(height2);
                                } else {
                                    numValueOf = null;
                                }
                                int iIntValue = height8 != 0 ? height8 + (numValueOf != null ? numValueOf.intValue() : height14) : 0;
                                int i20 = iM20920getMaxHeightimpl - height5;
                                final SubcomposeMeasureScope subcomposeMeasureScope3 = SubcomposeLayout;
                                ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                                final Function3<PaddingValues, Composer, Integer, Unit> function33 = function32;
                                final int i21 = i8;
                                List<Measurable> listSubcompose5 = subcomposeMeasureScope3.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(-1132241596, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1
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

                                    @Composable
                                    public final void invoke(@Nullable Composer composer2, int i22) {
                                        if ((i22 & 11) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1132241596, i22, -1, "androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:319)");
                                        }
                                        function33.invoke(PaddingKt.m15851PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, subcomposeMeasureScope3.mo15543toDpu2uoSUM(height14), 7, null), composer2, Integer.valueOf((i21 >> 6) & 112));
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }));
                                long j7 = jM20912copyZbe2FdA$default;
                                ArrayList arrayList5 = new ArrayList(listSubcompose5.size());
                                int size5 = listSubcompose5.size();
                                while (i9 < size5) {
                                    long j8 = j7;
                                    arrayList5.add(listSubcompose5.get(i9).mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j8, 0, 0, 0, i20, 7, null)));
                                    i9++;
                                    j7 = j8;
                                    iIntValue = iIntValue;
                                }
                                int i22 = iIntValue;
                                int size6 = arrayList5.size();
                                int i23 = 0;
                                while (i23 < size6) {
                                    Placeable.PlacementScope.place$default(layout, (Placeable) arrayList5.get(i23), 0, height5, 0.0f, 4, null);
                                    i23++;
                                    layout = placementScope;
                                    arrayList5 = arrayList5;
                                }
                                int size7 = arrayList.size();
                                for (int i24 = 0; i24 < size7; i24++) {
                                    Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList.get(i24), 0, 0, 0.0f, 4, null);
                                }
                                int i25 = iM20920getMaxHeightimpl;
                                int size8 = arrayList2.size();
                                for (int i26 = 0; i26 < size8; i26++) {
                                    Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList2.get(i26), 0, i25 - i22, 0.0f, 4, null);
                                }
                                int i27 = iM20920getMaxHeightimpl;
                                int size9 = arrayList4.size();
                                for (int i28 = 0; i28 < size9; i28++) {
                                    Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList4.get(i28), 0, i27 - height14, 0.0f, 4, null);
                                }
                                int i29 = iM20920getMaxHeightimpl;
                                int size10 = arrayList3.size();
                                for (int i30 = 0; i30 < size10; i30++) {
                                    Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList3.get(i30), fabPlacement != null ? fabPlacement.getLeft() : 0, i29 - (numValueOf != null ? numValueOf.intValue() : 0), 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function25);
                objRememberedValue = function25;
            }
            composerStartRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) objRememberedValue, composerStartRestartGroup, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$2
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

            public final void invoke(@Nullable Composer composer2, int i7) {
                ScaffoldKt.m16844ScaffoldLayoutMDYNRJg(z, i, function2, function3, function22, function23, function24, composer2, i2 | 1);
            }
        });
    }

    @NotNull
    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }

    @Composable
    @NotNull
    public static final ScaffoldState rememberScaffoldState(@Nullable DrawerState drawerState, @Nullable SnackbarHostState snackbarHostState, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1569641925);
        if ((i2 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, composer, 6, 2);
        }
        if ((i2 & 2) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) objRememberedValue;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1569641925, i, -1, "androidx.compose.material.rememberScaffoldState (Scaffold.kt:62)");
        }
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new ScaffoldState(drawerState, snackbarHostState);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        ScaffoldState scaffoldState = (ScaffoldState) objRememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return scaffoldState;
    }
}
