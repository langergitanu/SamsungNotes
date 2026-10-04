package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
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
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aá\u0002\u0010\u0003\u001a\u00020\u00042\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f¢\u0006\u0002\b\b2\u0019\b\u0002\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\b2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f¢\u0006\u0002\b\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u00012 \b\u0002\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0002\b\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u001f\u001a\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u00012\b\b\u0002\u0010\"\u001a\u00020\u001b2\b\b\u0002\u0010#\u001a\u00020\u001b2\b\b\u0002\u0010$\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020\u001b2\b\b\u0002\u0010&\u001a\u00020\u001b2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aw\u0010+\u001a\u00020\u00042\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\b2\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\b2\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\b2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\b2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u0010\u0013\u001a\u00020\u0014H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a+\u00103\u001a\u00020\r2\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u00020\u0011H\u0007¢\u0006\u0002\u00109\u001a;\u0010:\u001a\u0002072\u0006\u0010;\u001a\u00020<2\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u0002000>2\u0014\b\u0002\u0010?\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00160\u0006H\u0007¢\u0006\u0002\u0010@\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006A"}, m13886d2 = {"FabEndSpacing", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "BottomSheetScaffold", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/BottomSheetScaffoldState;", "topBar", "Lkotlin/Function0;", "snackbarHost", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "sheetGesturesEnabled", "", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetPeekHeight", "drawerContent", "drawerGesturesEnabled", "drawerShape", "drawerElevation", "drawerBackgroundColor", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-bGncdBI", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;IIII)V", "BottomSheetScaffoldStack", "body", "bottomSheet", "bottomSheetOffset", "Landroidx/compose/runtime/State;", "", "BottomSheetScaffoldStack-SlNgfk0", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/State;ILandroidx/compose/runtime/Composer;I)V", "rememberBottomSheetScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "bottomSheetState", "Landroidx/compose/material/BottomSheetState;", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "rememberBottomSheetState", "initialValue", "Landroidx/compose/material/BottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetState;", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class BottomSheetScaffoldKt {
    private static final float FabEndSpacing = C2256Dp.m20968constructorimpl(16);

    /* JADX WARN: Removed duplicated region for block: B:100:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0611 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0612  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0139  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: BottomSheetScaffold-bGncdBI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16619BottomSheetScaffoldbGncdBI(@NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> sheetContent, @Nullable Modifier modifier, @Nullable BottomSheetScaffoldState bottomSheetScaffoldState, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, int i, boolean z, @Nullable Shape shape, float f, long j, long j2, float f4, @Nullable Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, boolean z2, @Nullable Shape shape2, float f5, long j3, long j5, long j6, long j7, long j8, @NotNull final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i2, final int i4, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        BottomSheetScaffoldState bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
        int i8;
        int i9;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3M16701getLambda1$material_release;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        long j9;
        Composer composer2;
        boolean z3;
        int i23;
        Shape large;
        int i24;
        long jM16680getSurface0d7_KjU;
        long jM16694contentColorForek8zF_U;
        Shape large2;
        float f6;
        long jM16680getSurface0d7_KjU2;
        float f7;
        long jM16694contentColorForek8zF_U2;
        long j10;
        int i25;
        long scrimColor;
        long jM16669getBackground0d7_KjU;
        int i26;
        Shape shape3;
        int i27;
        boolean z4;
        Modifier modifier3;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function33;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function34;
        boolean z5;
        int i28;
        long j11;
        long j12;
        long jM16694contentColorForek8zF_U3;
        long j13;
        Shape shape4;
        BottomSheetScaffoldState bottomSheetScaffoldState2;
        float f8;
        long j14;
        int i29;
        float f9;
        long j15;
        int i30;
        Function2<? super Composer, ? super Integer, Unit> function23;
        float f10;
        Function2<? super Composer, ? super Integer, Unit> function24;
        long j16;
        int i31;
        Object objRememberedValue;
        final boolean z6;
        Composer composer3;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final long j17;
        final float f11;
        final Shape shape5;
        final float f12;
        final long j18;
        final long j19;
        final long j20;
        final Shape shape6;
        final float f13;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function35;
        final BottomSheetScaffoldState bottomSheetScaffoldState3;
        final boolean z7;
        final Modifier modifier4;
        final int i32;
        final long j21;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function36;
        final long j22;
        final long j23;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(sheetContent, "sheetContent");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(46422755);
        if ((i6 & 1) != 0) {
            i7 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i7 = (composerStartRestartGroup.changed(sheetContent) ? 4 : 2) | i2;
        } else {
            i7 = i2;
        }
        int i33 = i6 & 2;
        if (i33 != 0) {
            i7 |= 48;
        } else {
            if ((i2 & 112) == 0) {
                modifier2 = modifier;
                i7 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 896) != 0) {
                if ((i6 & 4) == 0) {
                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                    int i34 = composerStartRestartGroup.changed(bottomSheetScaffoldStateRememberBottomSheetScaffoldState) ? 256 : 128;
                    i7 |= i34;
                } else {
                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                }
                i7 |= i34;
            } else {
                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
            }
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else {
                if ((i2 & 7168) == 0) {
                    i7 |= composerStartRestartGroup.changed(function2) ? 2048 : 1024;
                }
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                    function3M16701getLambda1$material_release = function3;
                } else {
                    function3M16701getLambda1$material_release = function3;
                    if ((i2 & 57344) == 0) {
                        i7 |= composerStartRestartGroup.changed(function3M16701getLambda1$material_release) ? 16384 : 8192;
                    }
                }
                i10 = i6 & 32;
                if (i10 != 0) {
                    i7 |= 196608;
                } else if ((i2 & 458752) == 0) {
                    i7 |= composerStartRestartGroup.changed(function22) ? 131072 : 65536;
                }
                i11 = i6 & 64;
                if (i11 != 0) {
                    i7 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    i7 |= composerStartRestartGroup.changed(i) ? 1048576 : 524288;
                }
                i12 = i6 & 128;
                if (i12 != 0) {
                    i7 |= 12582912;
                } else {
                    if ((i2 & 29360128) == 0) {
                        i13 = i12;
                        i7 |= composerStartRestartGroup.changed(z) ? 8388608 : 4194304;
                    }
                    if ((i2 & 234881024) == 0) {
                        i7 |= ((i6 & 256) == 0 && composerStartRestartGroup.changed(shape)) ? 67108864 : 33554432;
                    }
                    i14 = i6 & 512;
                    if (i14 == 0) {
                        i7 |= DriveFile.MODE_READ_WRITE;
                    } else {
                        if ((i2 & 1879048192) == 0) {
                            i15 = i14;
                            i7 |= composerStartRestartGroup.changed(f) ? 536870912 : 268435456;
                        }
                        if ((i4 & 14) == 0) {
                            i16 = (((i6 & 1024) == 0 && composerStartRestartGroup.changed(j)) ? 4 : 2) | i4;
                        } else {
                            i16 = i4;
                        }
                        if ((i4 & 112) == 0) {
                            i16 |= ((i6 & 2048) == 0 && composerStartRestartGroup.changed(j2)) ? 32 : 16;
                        }
                        i17 = i6 & 4096;
                        if (i17 != 0) {
                            i16 |= 384;
                        } else {
                            if ((i4 & 896) == 0) {
                                i16 |= composerStartRestartGroup.changed(f4) ? 256 : 128;
                            }
                            i18 = i6 & 8192;
                            if (i18 == 0) {
                                i16 |= 3072;
                            } else {
                                if ((i4 & 7168) == 0) {
                                    i16 |= composerStartRestartGroup.changed(function32) ? 2048 : 1024;
                                }
                                i19 = i6 & 16384;
                                if (i19 == 0) {
                                    if ((i4 & 57344) == 0) {
                                        i20 = i19;
                                        i16 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
                                    }
                                    if ((i4 & 458752) == 0) {
                                        i16 |= ((i6 & 32768) == 0 && composerStartRestartGroup.changed(shape2)) ? 131072 : 65536;
                                    }
                                    i21 = i6 & 65536;
                                    if (i21 == 0) {
                                        i16 |= 1572864;
                                    } else if ((i4 & 3670016) == 0) {
                                        i16 |= composerStartRestartGroup.changed(f5) ? 1048576 : 524288;
                                    }
                                    if ((i4 & 29360128) == 0) {
                                        i16 |= ((i6 & 131072) == 0 && composerStartRestartGroup.changed(j3)) ? 8388608 : 4194304;
                                    }
                                    if ((i4 & 234881024) == 0) {
                                        i16 |= ((i6 & 262144) == 0 && composerStartRestartGroup.changed(j5)) ? 67108864 : 33554432;
                                    }
                                    if ((i4 & 1879048192) == 0) {
                                        i16 |= ((i6 & 524288) == 0 && composerStartRestartGroup.changed(j6)) ? 536870912 : 268435456;
                                    }
                                    int i35 = i16;
                                    if ((i5 & 14) != 0) {
                                        i22 = i5 | (((i6 & 1048576) == 0 && composerStartRestartGroup.changed(j7)) ? 4 : 2);
                                    } else {
                                        i22 = i5;
                                    }
                                    if ((i5 & 112) != 0) {
                                        j9 = j8;
                                        i22 |= ((i6 & 2097152) == 0 && composerStartRestartGroup.changed(j9)) ? 32 : 16;
                                    } else {
                                        j9 = j8;
                                    }
                                    if ((i6 & 4194304) == 0) {
                                        i22 |= 384;
                                    } else if ((i5 & 896) == 0) {
                                        i22 |= composerStartRestartGroup.changed(content) ? 256 : 128;
                                    }
                                    int i36 = i22;
                                    if ((1533916891 & i7) != 306783378 && (i35 & 1533916891) == 306783378 && (i36 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        function25 = function2;
                                        function26 = function22;
                                        shape5 = shape;
                                        j19 = j;
                                        function36 = function32;
                                        z6 = z2;
                                        shape6 = shape2;
                                        f13 = f5;
                                        j23 = j3;
                                        j17 = j5;
                                        j18 = j6;
                                        j20 = j7;
                                        j22 = j9;
                                        composer3 = composerStartRestartGroup;
                                        modifier4 = modifier2;
                                        bottomSheetScaffoldState3 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                        function35 = function3M16701getLambda1$material_release;
                                        i32 = i;
                                        z7 = z;
                                        f12 = f;
                                        j21 = j2;
                                        f11 = f4;
                                    } else {
                                        composerStartRestartGroup.startDefaults();
                                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                            if (i33 != 0) {
                                                modifier2 = Modifier.INSTANCE;
                                            }
                                            if ((i6 & 4) == 0) {
                                                i23 = i17;
                                                composer2 = composerStartRestartGroup;
                                                i7 &= -897;
                                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, null, composerStartRestartGroup, 0, 7);
                                                z3 = true;
                                            } else {
                                                composer2 = composerStartRestartGroup;
                                                z3 = true;
                                                i23 = i17;
                                            }
                                            Function2<? super Composer, ? super Integer, Unit> function27 = i8 == 0 ? null : function2;
                                            if (i9 != 0) {
                                                function3M16701getLambda1$material_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m16701getLambda1$material_release();
                                            }
                                            Function2<? super Composer, ? super Integer, Unit> function28 = i10 == 0 ? null : function22;
                                            int iM16764getEnd5ygKITE = i11 == 0 ? FabPosition.INSTANCE.m16764getEnd5ygKITE() : i;
                                            boolean z8 = i13 == 0 ? z3 : z;
                                            int i37 = i23;
                                            if ((i6 & 256) == 0) {
                                                large = MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                                                i7 &= -234881025;
                                            } else {
                                                large = shape;
                                            }
                                            float fM16617getSheetElevationD9Ej5fM = i15 == 0 ? BottomSheetScaffoldDefaults.INSTANCE.m16617getSheetElevationD9Ej5fM() : f;
                                            if ((i6 & 1024) == 0) {
                                                i24 = i36;
                                                jM16680getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composer2, 6).m16680getSurface0d7_KjU();
                                                i35 &= -15;
                                            } else {
                                                i24 = i36;
                                                jM16680getSurface0d7_KjU = j;
                                            }
                                            if ((i6 & 2048) == 0) {
                                                jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(jM16680getSurface0d7_KjU, composer2, i35 & 14);
                                                i35 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                            } else {
                                                jM16694contentColorForek8zF_U = j2;
                                            }
                                            float fM16618getSheetPeekHeightD9Ej5fM = i37 == 0 ? BottomSheetScaffoldDefaults.INSTANCE.m16618getSheetPeekHeightD9Ej5fM() : f4;
                                            Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function37 = i18 == 0 ? null : function32;
                                            boolean z9 = i20 == 0 ? true : z2;
                                            long j24 = jM16680getSurface0d7_KjU;
                                            if ((i6 & 32768) == 0) {
                                                large2 = MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                                                i35 &= -458753;
                                            } else {
                                                large2 = shape2;
                                            }
                                            float fM16721getElevationD9Ej5fM = i21 == 0 ? DrawerDefaults.INSTANCE.m16721getElevationD9Ej5fM() : f5;
                                            Shape shape7 = large2;
                                            if ((i6 & 131072) == 0) {
                                                f6 = fM16721getElevationD9Ej5fM;
                                                jM16680getSurface0d7_KjU2 = MaterialTheme.INSTANCE.getColors(composer2, 6).m16680getSurface0d7_KjU();
                                                i35 &= -29360129;
                                            } else {
                                                f6 = fM16721getElevationD9Ej5fM;
                                                jM16680getSurface0d7_KjU2 = j3;
                                            }
                                            if ((i6 & 262144) == 0) {
                                                f7 = fM16618getSheetPeekHeightD9Ej5fM;
                                                jM16694contentColorForek8zF_U2 = ColorsKt.m16694contentColorForek8zF_U(jM16680getSurface0d7_KjU2, composer2, (i35 >> 21) & 14);
                                                i35 &= -234881025;
                                            } else {
                                                f7 = fM16618getSheetPeekHeightD9Ej5fM;
                                                jM16694contentColorForek8zF_U2 = j5;
                                            }
                                            if ((i6 & 524288) == 0) {
                                                j10 = jM16680getSurface0d7_KjU2;
                                                i25 = 6;
                                                scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composer2, 6);
                                                i35 &= -1879048193;
                                            } else {
                                                j10 = jM16680getSurface0d7_KjU2;
                                                i25 = 6;
                                                scrimColor = j6;
                                            }
                                            long j25 = scrimColor;
                                            if ((i6 & 1048576) == 0) {
                                                jM16669getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composer2, i25).m16669getBackground0d7_KjU();
                                                i26 = i24 & (-15);
                                            } else {
                                                jM16669getBackground0d7_KjU = j7;
                                                i26 = i24;
                                            }
                                            if ((i6 & 2097152) == 0) {
                                                int i38 = i26;
                                                shape3 = shape7;
                                                i27 = iM16764getEnd5ygKITE;
                                                modifier3 = modifier2;
                                                function33 = function3M16701getLambda1$material_release;
                                                function34 = function37;
                                                z5 = z9;
                                                i28 = i35;
                                                jM16694contentColorForek8zF_U3 = ColorsKt.m16694contentColorForek8zF_U(jM16669getBackground0d7_KjU, composer2, i38 & 14);
                                                j13 = jM16669getBackground0d7_KjU;
                                                i29 = i38 & LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                                z4 = z8;
                                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                                j11 = jM16694contentColorForek8zF_U2;
                                                j12 = j24;
                                                f9 = f7;
                                                shape4 = large;
                                                f8 = fM16617getSheetElevationD9Ej5fM;
                                                j14 = jM16694contentColorForek8zF_U;
                                            } else {
                                                int i39 = i26;
                                                shape3 = shape7;
                                                i27 = iM16764getEnd5ygKITE;
                                                z4 = z8;
                                                modifier3 = modifier2;
                                                function33 = function3M16701getLambda1$material_release;
                                                function34 = function37;
                                                z5 = z9;
                                                i28 = i35;
                                                j11 = jM16694contentColorForek8zF_U2;
                                                j12 = j24;
                                                jM16694contentColorForek8zF_U3 = j8;
                                                j13 = jM16669getBackground0d7_KjU;
                                                shape4 = large;
                                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                                f8 = fM16617getSheetElevationD9Ej5fM;
                                                j14 = jM16694contentColorForek8zF_U;
                                                i29 = i39;
                                                f9 = f7;
                                            }
                                            j15 = j25;
                                            i30 = i7;
                                            function23 = function27;
                                            f10 = f6;
                                            function24 = function28;
                                            j16 = j10;
                                        } else {
                                            composerStartRestartGroup.skipToGroupEnd();
                                            if ((i6 & 4) != 0) {
                                                i7 &= -897;
                                            }
                                            if ((i6 & 256) != 0) {
                                                i7 &= -234881025;
                                            }
                                            if ((i6 & 1024) != 0) {
                                                i35 &= -15;
                                            }
                                            if ((i6 & 2048) != 0) {
                                                i35 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                            }
                                            if ((32768 & i6) != 0) {
                                                i35 &= -458753;
                                            }
                                            if ((i6 & 131072) != 0) {
                                                i35 &= -29360129;
                                            }
                                            if ((262144 & i6) != 0) {
                                                i35 &= -234881025;
                                            }
                                            if ((i6 & 524288) != 0) {
                                                i35 &= -1879048193;
                                            }
                                            if ((i6 & 1048576) != 0) {
                                                i36 &= -15;
                                            }
                                            if ((2097152 & i6) != 0) {
                                                i36 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                            }
                                            function23 = function2;
                                            function24 = function22;
                                            i27 = i;
                                            z4 = z;
                                            shape4 = shape;
                                            f8 = f;
                                            j12 = j;
                                            j14 = j2;
                                            function34 = function32;
                                            z5 = z2;
                                            shape3 = shape2;
                                            j11 = j5;
                                            j15 = j6;
                                            j13 = j7;
                                            i29 = i36;
                                            modifier3 = modifier2;
                                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                            function33 = function3M16701getLambda1$material_release;
                                            i28 = i35;
                                            f9 = f4;
                                            jM16694contentColorForek8zF_U3 = j9;
                                            composer2 = composerStartRestartGroup;
                                            j16 = j3;
                                            i30 = i7;
                                            f10 = f5;
                                        }
                                        composer2.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            i31 = i29;
                                        } else {
                                            i31 = i29;
                                            ComposerKt.traceEventStart(46422755, i30, i28, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:258)");
                                        }
                                        composer2.startReplaceableGroup(773894976);
                                        composer2.startReplaceableGroup(-492369756);
                                        objRememberedValue = composer2.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2), composer2);
                                        }
                                        composer2.endReplaceableGroup();
                                        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                                        composer2.endReplaceableGroup();
                                        Composer composer4 = composer2;
                                        long j26 = jM16694contentColorForek8zF_U3;
                                        long j27 = j15;
                                        int i40 = i30;
                                        long j28 = j16;
                                        long j29 = j11;
                                        long j30 = j13;
                                        BottomSheetScaffoldState bottomSheetScaffoldState4 = bottomSheetScaffoldState2;
                                        Modifier modifier5 = modifier3;
                                        BoxWithConstraintsKt.BoxWithConstraints(modifier5, null, false, ComposableLambdaKt.composableLambda(composer4, -440488519, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, z4, function34, z5, shape3, f10, j28, j29, j27, i28, f9, coroutineScope, i27, i40, j30, j26, i31, function23, content, shape4, j12, j14, f8, sheetContent, function24, function33)), composer4, ((i40 >> 3) & 14) | 3072, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        z6 = z5;
                                        composer3 = composer4;
                                        function25 = function23;
                                        j17 = j29;
                                        f11 = f9;
                                        shape5 = shape4;
                                        f12 = f8;
                                        j18 = j27;
                                        j19 = j12;
                                        j20 = j30;
                                        shape6 = shape3;
                                        f13 = f10;
                                        function26 = function24;
                                        function35 = function33;
                                        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function38 = function34;
                                        bottomSheetScaffoldState3 = bottomSheetScaffoldState4;
                                        z7 = z4;
                                        modifier4 = modifier5;
                                        i32 = i27;
                                        j21 = j14;
                                        function36 = function38;
                                        j22 = j26;
                                        j23 = j28;
                                    }
                                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup != null) {
                                        return;
                                    }
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

                                        public final void invoke(@Nullable Composer composer5, int i41) {
                                            BottomSheetScaffoldKt.m16619BottomSheetScaffoldbGncdBI(sheetContent, modifier4, bottomSheetScaffoldState3, function25, function35, function26, i32, z7, shape5, f12, j19, j21, f11, function36, z6, shape6, f13, j23, j17, j18, j20, j22, content, composer5, i2 | 1, i4, i5, i6);
                                        }
                                    });
                                    return;
                                }
                                i16 |= 24576;
                                i20 = i19;
                                if ((i4 & 458752) == 0) {
                                }
                                i21 = i6 & 65536;
                                if (i21 == 0) {
                                }
                                if ((i4 & 29360128) == 0) {
                                }
                                if ((i4 & 234881024) == 0) {
                                }
                                if ((i4 & 1879048192) == 0) {
                                }
                                int i352 = i16;
                                if ((i5 & 14) != 0) {
                                }
                                if ((i5 & 112) != 0) {
                                }
                                if ((i6 & 4194304) == 0) {
                                }
                                int i362 = i22;
                                if ((1533916891 & i7) != 306783378) {
                                    composerStartRestartGroup.startDefaults();
                                    if ((i2 & 1) != 0) {
                                        if (i33 != 0) {
                                        }
                                        if ((i6 & 4) == 0) {
                                        }
                                        if (i8 == 0) {
                                        }
                                        if (i9 != 0) {
                                        }
                                        if (i10 == 0) {
                                        }
                                        if (i11 == 0) {
                                        }
                                        if (i13 == 0) {
                                        }
                                        int i372 = i23;
                                        if ((i6 & 256) == 0) {
                                        }
                                        if (i15 == 0) {
                                        }
                                        if ((i6 & 1024) == 0) {
                                        }
                                        if ((i6 & 2048) == 0) {
                                        }
                                        if (i372 == 0) {
                                        }
                                        if (i18 == 0) {
                                        }
                                        if (i20 == 0) {
                                        }
                                        long j242 = jM16680getSurface0d7_KjU;
                                        if ((i6 & 32768) == 0) {
                                        }
                                        if (i21 == 0) {
                                        }
                                        Shape shape72 = large2;
                                        if ((i6 & 131072) == 0) {
                                        }
                                        if ((i6 & 262144) == 0) {
                                        }
                                        if ((i6 & 524288) == 0) {
                                        }
                                        long j252 = scrimColor;
                                        if ((i6 & 1048576) == 0) {
                                        }
                                        if ((i6 & 2097152) == 0) {
                                        }
                                        j15 = j252;
                                        i30 = i7;
                                        function23 = function27;
                                        f10 = f6;
                                        function24 = function28;
                                        j16 = j10;
                                        composer2.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        composer2.startReplaceableGroup(773894976);
                                        composer2.startReplaceableGroup(-492369756);
                                        objRememberedValue = composer2.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        }
                                        composer2.endReplaceableGroup();
                                        CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                                        composer2.endReplaceableGroup();
                                        Composer composer42 = composer2;
                                        long j262 = jM16694contentColorForek8zF_U3;
                                        long j272 = j15;
                                        int i402 = i30;
                                        long j282 = j16;
                                        long j292 = j11;
                                        long j302 = j13;
                                        BottomSheetScaffoldState bottomSheetScaffoldState42 = bottomSheetScaffoldState2;
                                        Modifier modifier52 = modifier3;
                                        BoxWithConstraintsKt.BoxWithConstraints(modifier52, null, false, ComposableLambdaKt.composableLambda(composer42, -440488519, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, z4, function34, z5, shape3, f10, j282, j292, j272, i28, f9, coroutineScope2, i27, i402, j302, j262, i31, function23, content, shape4, j12, j14, f8, sheetContent, function24, function33)), composer42, ((i402 >> 3) & 14) | 3072, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        z6 = z5;
                                        composer3 = composer42;
                                        function25 = function23;
                                        j17 = j292;
                                        f11 = f9;
                                        shape5 = shape4;
                                        f12 = f8;
                                        j18 = j272;
                                        j19 = j12;
                                        j20 = j302;
                                        shape6 = shape3;
                                        f13 = f10;
                                        function26 = function24;
                                        function35 = function33;
                                        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function382 = function34;
                                        bottomSheetScaffoldState3 = bottomSheetScaffoldState42;
                                        z7 = z4;
                                        modifier4 = modifier52;
                                        i32 = i27;
                                        j21 = j14;
                                        function36 = function382;
                                        j22 = j262;
                                        j23 = j282;
                                    }
                                }
                                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                }
                            }
                            i19 = i6 & 16384;
                            if (i19 == 0) {
                            }
                            i20 = i19;
                            if ((i4 & 458752) == 0) {
                            }
                            i21 = i6 & 65536;
                            if (i21 == 0) {
                            }
                            if ((i4 & 29360128) == 0) {
                            }
                            if ((i4 & 234881024) == 0) {
                            }
                            if ((i4 & 1879048192) == 0) {
                            }
                            int i3522 = i16;
                            if ((i5 & 14) != 0) {
                            }
                            if ((i5 & 112) != 0) {
                            }
                            if ((i6 & 4194304) == 0) {
                            }
                            int i3622 = i22;
                            if ((1533916891 & i7) != 306783378) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i18 = i6 & 8192;
                        if (i18 == 0) {
                        }
                        i19 = i6 & 16384;
                        if (i19 == 0) {
                        }
                        i20 = i19;
                        if ((i4 & 458752) == 0) {
                        }
                        i21 = i6 & 65536;
                        if (i21 == 0) {
                        }
                        if ((i4 & 29360128) == 0) {
                        }
                        if ((i4 & 234881024) == 0) {
                        }
                        if ((i4 & 1879048192) == 0) {
                        }
                        int i35222 = i16;
                        if ((i5 & 14) != 0) {
                        }
                        if ((i5 & 112) != 0) {
                        }
                        if ((i6 & 4194304) == 0) {
                        }
                        int i36222 = i22;
                        if ((1533916891 & i7) != 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i15 = i14;
                    if ((i4 & 14) == 0) {
                    }
                    if ((i4 & 112) == 0) {
                    }
                    i17 = i6 & 4096;
                    if (i17 != 0) {
                    }
                    i18 = i6 & 8192;
                    if (i18 == 0) {
                    }
                    i19 = i6 & 16384;
                    if (i19 == 0) {
                    }
                    i20 = i19;
                    if ((i4 & 458752) == 0) {
                    }
                    i21 = i6 & 65536;
                    if (i21 == 0) {
                    }
                    if ((i4 & 29360128) == 0) {
                    }
                    if ((i4 & 234881024) == 0) {
                    }
                    if ((i4 & 1879048192) == 0) {
                    }
                    int i352222 = i16;
                    if ((i5 & 14) != 0) {
                    }
                    if ((i5 & 112) != 0) {
                    }
                    if ((i6 & 4194304) == 0) {
                    }
                    int i362222 = i22;
                    if ((1533916891 & i7) != 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i13 = i12;
                if ((i2 & 234881024) == 0) {
                }
                i14 = i6 & 512;
                if (i14 == 0) {
                }
                i15 = i14;
                if ((i4 & 14) == 0) {
                }
                if ((i4 & 112) == 0) {
                }
                i17 = i6 & 4096;
                if (i17 != 0) {
                }
                i18 = i6 & 8192;
                if (i18 == 0) {
                }
                i19 = i6 & 16384;
                if (i19 == 0) {
                }
                i20 = i19;
                if ((i4 & 458752) == 0) {
                }
                i21 = i6 & 65536;
                if (i21 == 0) {
                }
                if ((i4 & 29360128) == 0) {
                }
                if ((i4 & 234881024) == 0) {
                }
                if ((i4 & 1879048192) == 0) {
                }
                int i3522222 = i16;
                if ((i5 & 14) != 0) {
                }
                if ((i5 & 112) != 0) {
                }
                if ((i6 & 4194304) == 0) {
                }
                int i3622222 = i22;
                if ((1533916891 & i7) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            i10 = i6 & 32;
            if (i10 != 0) {
            }
            i11 = i6 & 64;
            if (i11 != 0) {
            }
            i12 = i6 & 128;
            if (i12 != 0) {
            }
            i13 = i12;
            if ((i2 & 234881024) == 0) {
            }
            i14 = i6 & 512;
            if (i14 == 0) {
            }
            i15 = i14;
            if ((i4 & 14) == 0) {
            }
            if ((i4 & 112) == 0) {
            }
            i17 = i6 & 4096;
            if (i17 != 0) {
            }
            i18 = i6 & 8192;
            if (i18 == 0) {
            }
            i19 = i6 & 16384;
            if (i19 == 0) {
            }
            i20 = i19;
            if ((i4 & 458752) == 0) {
            }
            i21 = i6 & 65536;
            if (i21 == 0) {
            }
            if ((i4 & 29360128) == 0) {
            }
            if ((i4 & 234881024) == 0) {
            }
            if ((i4 & 1879048192) == 0) {
            }
            int i35222222 = i16;
            if ((i5 & 14) != 0) {
            }
            if ((i5 & 112) != 0) {
            }
            if ((i6 & 4194304) == 0) {
            }
            int i36222222 = i22;
            if ((1533916891 & i7) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 896) != 0) {
        }
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        i10 = i6 & 32;
        if (i10 != 0) {
        }
        i11 = i6 & 64;
        if (i11 != 0) {
        }
        i12 = i6 & 128;
        if (i12 != 0) {
        }
        i13 = i12;
        if ((i2 & 234881024) == 0) {
        }
        i14 = i6 & 512;
        if (i14 == 0) {
        }
        i15 = i14;
        if ((i4 & 14) == 0) {
        }
        if ((i4 & 112) == 0) {
        }
        i17 = i6 & 4096;
        if (i17 != 0) {
        }
        i18 = i6 & 8192;
        if (i18 == 0) {
        }
        i19 = i6 & 16384;
        if (i19 == 0) {
        }
        i20 = i19;
        if ((i4 & 458752) == 0) {
        }
        i21 = i6 & 65536;
        if (i21 == 0) {
        }
        if ((i4 & 29360128) == 0) {
        }
        if ((i4 & 234881024) == 0) {
        }
        if ((i4 & 1879048192) == 0) {
        }
        int i352222222 = i16;
        if ((i5 & 14) != 0) {
        }
        if ((i5 & 112) != 0) {
        }
        if ((i6 & 4194304) == 0) {
        }
        int i362222222 = i22;
        if ((1533916891 & i7) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: BottomSheetScaffoldStack-SlNgfk0, reason: not valid java name */
    public static final void m16620BottomSheetScaffoldStackSlNgfk0(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final State<Float> state, final int i, Composer composer, final int i2) {
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(172426443);
        if ((i2 & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(function2) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(function22) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(function23) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(function24) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i4 |= composerStartRestartGroup.changed(state) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 131072 : 65536;
        }
        if ((374491 & i4) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(172426443, i4, -1, "androidx.compose.material.BottomSheetScaffoldStack (BottomSheetScaffold.kt:382)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldStack$2
                @Override // androidx.compose.p109ui.layout.MeasurePolicy
                @NotNull
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo15214measure3p2s80s(@NotNull final MeasureScope Layout, @NotNull final List<? extends Measurable> measurables, final long j) {
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    final Placeable placeableMo19855measureBRTryo0 = ((Measurable) CollectionsKt.first((List) measurables)).mo19855measureBRTryo0(j);
                    int width = placeableMo19855measureBRTryo0.getWidth();
                    int height = placeableMo19855measureBRTryo0.getHeight();
                    final State<Float> state2 = state;
                    final int i5 = i;
                    return MeasureScope.layout$default(Layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldStack$2$measure$1
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

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Placeable.PlacementScope layout) {
                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                            Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo0, 0, 0, 0.0f, 4, null);
                            List listDrop = CollectionsKt.drop(measurables, 1);
                            long j2 = j;
                            ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(listDrop));
                            Iterator it = listDrop.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((Measurable) it.next()).mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j2, 0, 0, 0, 0, 10, null)));
                            }
                            Placeable placeable = (Placeable) arrayList.get(0);
                            Placeable placeable2 = (Placeable) arrayList.get(1);
                            Placeable placeable3 = (Placeable) arrayList.get(2);
                            int iRoundToInt = MathKt.roundToInt(state2.getValue().floatValue());
                            Placeable.PlacementScope.placeRelative$default(layout, placeable, 0, iRoundToInt, 0.0f, 4, null);
                            Placeable.PlacementScope.placeRelative$default(layout, placeable2, FabPosition.m16759equalsimpl0(i5, FabPosition.INSTANCE.m16763getCenter5ygKITE()) ? AbstractC1038a.m1205f(placeable2, placeableMo19855measureBRTryo0.getWidth(), 2) : (placeableMo19855measureBRTryo0.getWidth() - placeable2.getWidth()) - Layout.mo15540roundToPx0680j_4(BottomSheetScaffoldKt.FabEndSpacing), iRoundToInt - (placeable2.getHeight() / 2), 0.0f, 4, null);
                            Placeable.PlacementScope.placeRelative$default(layout, placeable3, AbstractC1038a.m1205f(placeable3, placeableMo19855measureBRTryo0.getWidth(), 2), placeableMo19855measureBRTryo0.getHeight() - placeable3.getHeight(), 0.0f, 4, null);
                        }
                    }, 4, null);
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Modifier.Companion companion = Modifier.INSTANCE;
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl, measurePolicy, companion2.getSetMeasurePolicy());
            Updater.m18025setimpl(composerM18018constructorimpl, density, companion2.getSetDensity());
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
            composerStartRestartGroup.startReplaceableGroup(-1162539198);
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i4 & 14));
            function22.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 3) & 14));
            function23.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 6) & 14));
            function24.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 9) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldStack$3
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

            public final void invoke(@Nullable Composer composer2, int i5) {
                BottomSheetScaffoldKt.m16620BottomSheetScaffoldStackSlNgfk0(function2, function22, function23, function24, state, i, composer2, i2 | 1);
            }
        });
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(@Nullable DrawerState drawerState, @Nullable BottomSheetState bottomSheetState, @Nullable SnackbarHostState snackbarHostState, @Nullable Composer composer, int i, int i2) {
        Composer composer2;
        composer.startReplaceableGroup(-1353009744);
        if ((i2 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, composer, 6, 2);
        }
        if ((i2 & 2) != 0) {
            composer2 = composer;
            bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed, null, null, composer2, 6, 6);
        } else {
            composer2 = composer;
        }
        if ((i2 & 4) != 0) {
            composer2.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer2.updateRememberedValue(objRememberedValue);
            }
            composer2.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) objRememberedValue;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1353009744, i, -1, "androidx.compose.material.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:195)");
        }
        composer2.startReplaceableGroup(1618982084);
        boolean zChanged = composer2.changed(drawerState) | composer2.changed(bottomSheetState) | composer2.changed(snackbarHostState);
        Object objRememberedValue2 = composer2.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new BottomSheetScaffoldState(drawerState, bottomSheetState, snackbarHostState);
            composer2.updateRememberedValue(objRememberedValue2);
        }
        composer2.endReplaceableGroup();
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) objRememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final BottomSheetState rememberBottomSheetState(@NotNull final BottomSheetValue initialValue, @Nullable final AnimationSpec<Float> animationSpec, @Nullable final Function1<? super BottomSheetValue, Boolean> function1, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        composer.startReplaceableGroup(1808153344);
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<BottomSheetValue, Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.rememberBottomSheetState.1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull BottomSheetValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.TRUE;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1808153344, i, -1, "androidx.compose.material.rememberBottomSheetState (BottomSheetScaffold.kt:151)");
        }
        BottomSheetState bottomSheetState = (BottomSheetState) RememberSaveableKt.m18111rememberSaveable(new Object[]{animationSpec}, (Saver) BottomSheetState.INSTANCE.Saver(animationSpec, function1), (String) null, (Function0) new Function0<BottomSheetState>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.rememberBottomSheetState.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final BottomSheetState invoke() {
                return new BottomSheetState(initialValue, animationSpec, function1);
            }
        }, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bottomSheetState;
    }
}
