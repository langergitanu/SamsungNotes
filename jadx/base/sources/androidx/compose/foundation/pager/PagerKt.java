package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e21\u0010\u001f\u001a-\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010 ¢\u0006\u0002\b#¢\u0006\u0002\b$H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001aâ\u0001\u0010'\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e21\u0010\u001f\u001a-\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010 ¢\u0006\u0002\b#¢\u0006\u0002\b$H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u0017\u0010,\u001a\u00020\u00012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.H\u0082\b\u001aL\u00100\u001a\u00020\u000b*\u00020\u001e2\u0006\u00101\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u000bH\u0000\u001a,\u00109\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00132\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006="}, m13886d2 = {"HorizontalPager", "", "state", "Landroidx/compose/foundation/pager/PagerState;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "", "reverseLayout", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "VerticalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "currentPageOffset", "layoutSize", "spaceBetweenPages", "beforeContentPadding", "afterContentPadding", "currentPage", "currentPageOffsetFraction", "", "pageCount", "pagerSemantics", "isVertical", "scope", "Lkotlinx/coroutines/CoroutineScope;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pager.kt\nandroidx/compose/foundation/pager/PagerKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,511:1\n149#2:512\n149#2:513\n149#2:514\n149#2:515\n*S KotlinDebug\n*F\n+ 1 Pager.kt\nandroidx/compose/foundation/pager/PagerKt\n*L\n110#1:512\n113#1:513\n197#1:514\n200#1:515\n*E\n"})
public final class PagerKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:227:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0100  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: HorizontalPager-oI3XNZo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16091HorizontalPageroI3XNZo(@NotNull final PagerState pagerState, @Nullable Modifier modifier, @Nullable PaddingValues paddingValues, @Nullable PageSize pageSize, int i, float f, @Nullable Alignment.Vertical vertical, @Nullable TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, @Nullable Function1<? super Integer, ? extends Object> function1, @Nullable NestedScrollConnection nestedScrollConnection, @Nullable SnapPosition snapPosition, @NotNull final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, final int i2, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        int i8;
        PageSize pageSize2;
        int i9;
        final int i10;
        int i11;
        float f4;
        int i12;
        Alignment.Vertical centerVertically;
        TargetedFlingBehavior targetedFlingBehavior2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        boolean z3;
        int i22;
        PagerState pagerState2;
        int i23;
        NestedScrollConnection nestedScrollConnectionPageNestedScrollConnection;
        final Function1<? super Integer, ? extends Object> function12;
        NestedScrollConnection nestedScrollConnection2;
        PaddingValues paddingValues2;
        Alignment.Vertical vertical2;
        TargetedFlingBehavior targetedFlingBehavior3;
        PageSize pageSize3;
        int i24;
        int i25;
        float f5;
        boolean z4;
        int i26;
        SnapPosition snapPosition2;
        Composer composer2;
        boolean z5;
        Modifier modifier3;
        Modifier modifier4;
        final PageSize pageSize4;
        final NestedScrollConnection nestedScrollConnection3;
        final boolean z6;
        final boolean z7;
        final float f6;
        final PaddingValues paddingValues3;
        final TargetedFlingBehavior targetedFlingBehavior4;
        final Alignment.Vertical vertical3;
        final SnapPosition snapPosition3;
        final Modifier modifier5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1870896258);
        if ((i5 & 1) != 0) {
            i6 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(pagerState) ? 4 : 2) | i2;
        } else {
            i6 = i2;
        }
        int i27 = i5 & 2;
        if (i27 != 0) {
            i6 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else {
                if ((i2 & 384) == 0) {
                    i6 |= composerStartRestartGroup.changed(paddingValues) ? 256 : 128;
                }
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else {
                    if ((i2 & 3072) == 0) {
                        pageSize2 = pageSize;
                        i6 |= composerStartRestartGroup.changed(pageSize2) ? 2048 : 1024;
                    }
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else {
                        if ((i2 & 24576) == 0) {
                            i10 = i;
                            i6 |= composerStartRestartGroup.changed(i10) ? 16384 : 8192;
                        }
                        i11 = i5 & 32;
                        if (i11 != 0) {
                            i6 |= 196608;
                            f4 = f;
                        } else {
                            f4 = f;
                            if ((i2 & 196608) == 0) {
                                i6 |= composerStartRestartGroup.changed(f4) ? 131072 : 65536;
                            }
                        }
                        i12 = i5 & 64;
                        if (i12 != 0) {
                            i6 |= 1572864;
                            centerVertically = vertical;
                        } else {
                            centerVertically = vertical;
                            if ((i2 & 1572864) == 0) {
                                i6 |= composerStartRestartGroup.changed(centerVertically) ? 1048576 : 524288;
                            }
                        }
                        if ((i2 & 12582912) == 0) {
                            if ((i5 & 128) == 0) {
                                targetedFlingBehavior2 = targetedFlingBehavior;
                                int i28 = composerStartRestartGroup.changed(targetedFlingBehavior2) ? 8388608 : 4194304;
                                i6 |= i28;
                            } else {
                                targetedFlingBehavior2 = targetedFlingBehavior;
                            }
                            i6 |= i28;
                        } else {
                            targetedFlingBehavior2 = targetedFlingBehavior;
                        }
                        i13 = i5 & 256;
                        if (i13 != 0) {
                            i6 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i6 |= composerStartRestartGroup.changed(z) ? 67108864 : 33554432;
                        }
                        i14 = i5 & 512;
                        if (i14 != 0) {
                            i16 = i6 | DriveFile.MODE_READ_WRITE;
                            i15 = i14;
                        } else {
                            if ((i2 & DriveFile.MODE_READ_WRITE) == 0) {
                                i15 = i14;
                                i6 |= composerStartRestartGroup.changed(z2) ? 536870912 : 268435456;
                            } else {
                                i15 = i14;
                            }
                            i16 = i6;
                        }
                        i17 = i5 & 1024;
                        if (i17 != 0) {
                            i18 = i4 | 6;
                        } else if ((i4 & 6) == 0) {
                            i18 = i4 | (composerStartRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i18 = i4;
                        }
                        if ((i4 & 48) == 0) {
                            i19 = i17;
                            i18 |= ((i5 & 2048) == 0 && composerStartRestartGroup.changedInstance(nestedScrollConnection)) ? 32 : 16;
                        } else {
                            i19 = i17;
                        }
                        int i29 = i18;
                        i20 = i5 & 4096;
                        if (i20 != 0) {
                            i21 = i29 | 384;
                        } else {
                            int i30 = i29;
                            if ((i4 & 384) == 0) {
                                i30 |= composerStartRestartGroup.changed(snapPosition) ? 256 : 128;
                            }
                            i21 = i30;
                        }
                        if ((i5 & 8192) == 0) {
                            if ((i4 & 3072) == 0) {
                                i21 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                            }
                            if ((i16 & 306783379) != 306783378 && (i21 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                z7 = z;
                                z6 = z2;
                                function12 = function1;
                                nestedScrollConnection3 = nestedScrollConnection;
                                snapPosition3 = snapPosition;
                                pageSize4 = pageSize2;
                                composer2 = composerStartRestartGroup;
                                f6 = f4;
                                modifier5 = modifier2;
                                vertical3 = centerVertically;
                                targetedFlingBehavior4 = targetedFlingBehavior2;
                                paddingValues3 = paddingValues;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier modifier6 = i27 == 0 ? Modifier.INSTANCE : modifier2;
                                    PaddingValues paddingValuesM15847PaddingValues0680j_4 = i7 == 0 ? PaddingKt.m15847PaddingValues0680j_4(C2256Dp.m20968constructorimpl(0)) : paddingValues;
                                    PageSize pageSize5 = i8 == 0 ? PageSize.Fill.INSTANCE : pageSize2;
                                    int i31 = i9 == 0 ? 0 : i10;
                                    float fM20968constructorimpl = i11 == 0 ? C2256Dp.m20968constructorimpl(0) : f4;
                                    if (i12 != 0) {
                                        centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    }
                                    if ((i5 & 128) == 0) {
                                        z3 = false;
                                        i22 = i20;
                                        pagerState2 = pagerState;
                                        i23 = i21;
                                        TargetedFlingBehavior targetedFlingBehaviorFlingBehavior = PagerDefaults.INSTANCE.flingBehavior(pagerState2, null, null, null, 0.0f, composerStartRestartGroup, (i16 & 14) | 196608, 30);
                                        i16 &= -29360129;
                                        targetedFlingBehavior2 = targetedFlingBehaviorFlingBehavior;
                                    } else {
                                        z3 = false;
                                        i22 = i20;
                                        pagerState2 = pagerState;
                                        i23 = i21;
                                    }
                                    boolean z8 = i13 == 0 ? true : z;
                                    if (i15 == 0) {
                                        z3 = z2;
                                    }
                                    Function1<? super Integer, ? extends Object> function13 = i19 == 0 ? null : function1;
                                    if ((i5 & 2048) == 0) {
                                        nestedScrollConnectionPageNestedScrollConnection = PagerDefaults.INSTANCE.pageNestedScrollConnection(pagerState2, Orientation.Horizontal, composerStartRestartGroup, (i16 & 14) | 432);
                                        i23 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                    } else {
                                        nestedScrollConnectionPageNestedScrollConnection = nestedScrollConnection;
                                    }
                                    if (i22 == 0) {
                                        function12 = function13;
                                        nestedScrollConnection2 = nestedScrollConnectionPageNestedScrollConnection;
                                        paddingValues2 = paddingValuesM15847PaddingValues0680j_4;
                                        vertical2 = centerVertically;
                                        targetedFlingBehavior3 = targetedFlingBehavior2;
                                        pageSize3 = pageSize5;
                                        i25 = i31;
                                        f5 = fM20968constructorimpl;
                                        z4 = z3;
                                        i26 = i16;
                                        snapPosition2 = SnapPosition.Start.INSTANCE;
                                        composer2 = composerStartRestartGroup;
                                        i24 = i23;
                                    } else {
                                        function12 = function13;
                                        nestedScrollConnection2 = nestedScrollConnectionPageNestedScrollConnection;
                                        paddingValues2 = paddingValuesM15847PaddingValues0680j_4;
                                        vertical2 = centerVertically;
                                        targetedFlingBehavior3 = targetedFlingBehavior2;
                                        pageSize3 = pageSize5;
                                        i24 = i23;
                                        i25 = i31;
                                        f5 = fM20968constructorimpl;
                                        z4 = z3;
                                        i26 = i16;
                                        snapPosition2 = snapPosition;
                                        composer2 = composerStartRestartGroup;
                                    }
                                    z5 = z8;
                                    modifier3 = modifier6;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i5 & 128) != 0) {
                                        i16 &= -29360129;
                                    }
                                    if ((i5 & 2048) != 0) {
                                        i21 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                    }
                                    pagerState2 = pagerState;
                                    paddingValues2 = paddingValues;
                                    function12 = function1;
                                    nestedScrollConnection2 = nestedScrollConnection;
                                    i24 = i21;
                                    pageSize3 = pageSize2;
                                    composer2 = composerStartRestartGroup;
                                    modifier3 = modifier2;
                                    vertical2 = centerVertically;
                                    i26 = i16;
                                    z5 = z;
                                    z4 = z2;
                                    snapPosition2 = snapPosition;
                                    f5 = f4;
                                    i25 = i10;
                                    targetedFlingBehavior3 = targetedFlingBehavior2;
                                }
                                composer2.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    modifier4 = modifier3;
                                } else {
                                    modifier4 = modifier3;
                                    ComposerKt.traceEventStart(1870896258, i26, i24, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:124)");
                                }
                                int i32 = i24;
                                int i33 = i26 >> 6;
                                int i34 = ((i26 >> 3) & 14) | 24576 | ((i26 << 3) & 112) | (i26 & 896) | ((i26 >> 18) & 7168) | (i33 & 458752) | (i33 & 3670016);
                                int i35 = i26 << 9;
                                int i36 = i34 | (i35 & 29360128) | (i35 & 234881024) | ((i26 << 18) & 1879048192);
                                int i37 = ((i32 >> 3) & 14) | 384 | ((i32 << 3) & 112) | ((i26 >> 9) & 7168);
                                int i38 = i32 << 6;
                                int i39 = i37 | (i38 & 57344) | (i38 & 458752);
                                Modifier modifier7 = modifier4;
                                LazyLayoutPagerKt.m16087PageruYRUAWA(modifier7, pagerState2, paddingValues2, z4, Orientation.Horizontal, targetedFlingBehavior3, z5, i25, f5, pageSize3, nestedScrollConnection2, function12, Alignment.INSTANCE.getCenterHorizontally(), vertical2, snapPosition2, function4, composer2, i36, i39, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                pageSize4 = pageSize3;
                                nestedScrollConnection3 = nestedScrollConnection2;
                                z6 = z4;
                                z7 = z5;
                                f6 = f5;
                                paddingValues3 = paddingValues2;
                                targetedFlingBehavior4 = targetedFlingBehavior3;
                                i10 = i25;
                                vertical3 = vertical2;
                                snapPosition3 = snapPosition2;
                                modifier5 = modifier7;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$HorizontalPager$1
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

                                    public final void invoke(@Nullable Composer composer3, int i40) {
                                        PagerKt.m16091HorizontalPageroI3XNZo(pagerState, modifier5, paddingValues3, pageSize4, i10, f6, vertical3, targetedFlingBehavior4, z7, z6, function12, nestedScrollConnection3, snapPosition3, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i21 |= 3072;
                        if ((i16 & 306783379) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i27 == 0) {
                                }
                                if (i7 == 0) {
                                }
                                if (i8 == 0) {
                                }
                                if (i9 == 0) {
                                }
                                if (i11 == 0) {
                                }
                                if (i12 != 0) {
                                }
                                if ((i5 & 128) == 0) {
                                }
                                if (i13 == 0) {
                                }
                                if (i15 == 0) {
                                }
                                if (i19 == 0) {
                                }
                                if ((i5 & 2048) == 0) {
                                }
                                if (i22 == 0) {
                                }
                                z5 = z8;
                                modifier3 = modifier6;
                                composer2.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i322 = i24;
                                int i332 = i26 >> 6;
                                int i342 = ((i26 >> 3) & 14) | 24576 | ((i26 << 3) & 112) | (i26 & 896) | ((i26 >> 18) & 7168) | (i332 & 458752) | (i332 & 3670016);
                                int i352 = i26 << 9;
                                int i362 = i342 | (i352 & 29360128) | (i352 & 234881024) | ((i26 << 18) & 1879048192);
                                int i372 = ((i322 >> 3) & 14) | 384 | ((i322 << 3) & 112) | ((i26 >> 9) & 7168);
                                int i382 = i322 << 6;
                                int i392 = i372 | (i382 & 57344) | (i382 & 458752);
                                Modifier modifier72 = modifier4;
                                LazyLayoutPagerKt.m16087PageruYRUAWA(modifier72, pagerState2, paddingValues2, z4, Orientation.Horizontal, targetedFlingBehavior3, z5, i25, f5, pageSize3, nestedScrollConnection2, function12, Alignment.INSTANCE.getCenterHorizontally(), vertical2, snapPosition2, function4, composer2, i362, i392, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                pageSize4 = pageSize3;
                                nestedScrollConnection3 = nestedScrollConnection2;
                                z6 = z4;
                                z7 = z5;
                                f6 = f5;
                                paddingValues3 = paddingValues2;
                                targetedFlingBehavior4 = targetedFlingBehavior3;
                                i10 = i25;
                                vertical3 = vertical2;
                                snapPosition3 = snapPosition2;
                                modifier5 = modifier72;
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i10 = i;
                    i11 = i5 & 32;
                    if (i11 != 0) {
                    }
                    i12 = i5 & 64;
                    if (i12 != 0) {
                    }
                    if ((i2 & 12582912) == 0) {
                    }
                    i13 = i5 & 256;
                    if (i13 != 0) {
                    }
                    i14 = i5 & 512;
                    if (i14 != 0) {
                    }
                    i17 = i5 & 1024;
                    if (i17 != 0) {
                    }
                    if ((i4 & 48) == 0) {
                    }
                    int i292 = i18;
                    i20 = i5 & 4096;
                    if (i20 != 0) {
                    }
                    if ((i5 & 8192) == 0) {
                    }
                    if ((i16 & 306783379) != 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                pageSize2 = pageSize;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                i10 = i;
                i11 = i5 & 32;
                if (i11 != 0) {
                }
                i12 = i5 & 64;
                if (i12 != 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                i13 = i5 & 256;
                if (i13 != 0) {
                }
                i14 = i5 & 512;
                if (i14 != 0) {
                }
                i17 = i5 & 1024;
                if (i17 != 0) {
                }
                if ((i4 & 48) == 0) {
                }
                int i2922 = i18;
                i20 = i5 & 4096;
                if (i20 != 0) {
                }
                if ((i5 & 8192) == 0) {
                }
                if ((i16 & 306783379) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            pageSize2 = pageSize;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            i10 = i;
            i11 = i5 & 32;
            if (i11 != 0) {
            }
            i12 = i5 & 64;
            if (i12 != 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            i13 = i5 & 256;
            if (i13 != 0) {
            }
            i14 = i5 & 512;
            if (i14 != 0) {
            }
            i17 = i5 & 1024;
            if (i17 != 0) {
            }
            if ((i4 & 48) == 0) {
            }
            int i29222 = i18;
            i20 = i5 & 4096;
            if (i20 != 0) {
            }
            if ((i5 & 8192) == 0) {
            }
            if ((i16 & 306783379) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        pageSize2 = pageSize;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        i10 = i;
        i11 = i5 & 32;
        if (i11 != 0) {
        }
        i12 = i5 & 64;
        if (i12 != 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        i13 = i5 & 256;
        if (i13 != 0) {
        }
        i14 = i5 & 512;
        if (i14 != 0) {
        }
        i17 = i5 & 1024;
        if (i17 != 0) {
        }
        if ((i4 & 48) == 0) {
        }
        int i292222 = i18;
        i20 = i5 & 4096;
        if (i20 != 0) {
        }
        if ((i5 & 8192) == 0) {
        }
        if ((i16 & 306783379) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:227:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0100  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: VerticalPager-oI3XNZo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16092VerticalPageroI3XNZo(@NotNull final PagerState pagerState, @Nullable Modifier modifier, @Nullable PaddingValues paddingValues, @Nullable PageSize pageSize, int i, float f, @Nullable Alignment.Horizontal horizontal, @Nullable TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, @Nullable Function1<? super Integer, ? extends Object> function1, @Nullable NestedScrollConnection nestedScrollConnection, @Nullable SnapPosition snapPosition, @NotNull final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, final int i2, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        int i8;
        PageSize pageSize2;
        int i9;
        final int i10;
        int i11;
        float f4;
        int i12;
        Alignment.Horizontal centerHorizontally;
        TargetedFlingBehavior targetedFlingBehavior2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        boolean z3;
        int i22;
        PagerState pagerState2;
        int i23;
        NestedScrollConnection nestedScrollConnectionPageNestedScrollConnection;
        final Function1<? super Integer, ? extends Object> function12;
        NestedScrollConnection nestedScrollConnection2;
        PaddingValues paddingValues2;
        Alignment.Horizontal horizontal2;
        TargetedFlingBehavior targetedFlingBehavior3;
        PageSize pageSize3;
        int i24;
        int i25;
        float f5;
        boolean z4;
        int i26;
        SnapPosition snapPosition2;
        Composer composer2;
        boolean z5;
        Modifier modifier3;
        Modifier modifier4;
        final PageSize pageSize4;
        final SnapPosition snapPosition3;
        final boolean z6;
        final float f6;
        final TargetedFlingBehavior targetedFlingBehavior4;
        final Alignment.Horizontal horizontal3;
        final NestedScrollConnection nestedScrollConnection3;
        final boolean z7;
        final PaddingValues paddingValues3;
        final Modifier modifier5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(909160706);
        if ((i5 & 1) != 0) {
            i6 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(pagerState) ? 4 : 2) | i2;
        } else {
            i6 = i2;
        }
        int i27 = i5 & 2;
        if (i27 != 0) {
            i6 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else {
                if ((i2 & 384) == 0) {
                    i6 |= composerStartRestartGroup.changed(paddingValues) ? 256 : 128;
                }
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else {
                    if ((i2 & 3072) == 0) {
                        pageSize2 = pageSize;
                        i6 |= composerStartRestartGroup.changed(pageSize2) ? 2048 : 1024;
                    }
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else {
                        if ((i2 & 24576) == 0) {
                            i10 = i;
                            i6 |= composerStartRestartGroup.changed(i10) ? 16384 : 8192;
                        }
                        i11 = i5 & 32;
                        if (i11 != 0) {
                            i6 |= 196608;
                            f4 = f;
                        } else {
                            f4 = f;
                            if ((i2 & 196608) == 0) {
                                i6 |= composerStartRestartGroup.changed(f4) ? 131072 : 65536;
                            }
                        }
                        i12 = i5 & 64;
                        if (i12 != 0) {
                            i6 |= 1572864;
                            centerHorizontally = horizontal;
                        } else {
                            centerHorizontally = horizontal;
                            if ((i2 & 1572864) == 0) {
                                i6 |= composerStartRestartGroup.changed(centerHorizontally) ? 1048576 : 524288;
                            }
                        }
                        if ((i2 & 12582912) == 0) {
                            if ((i5 & 128) == 0) {
                                targetedFlingBehavior2 = targetedFlingBehavior;
                                int i28 = composerStartRestartGroup.changed(targetedFlingBehavior2) ? 8388608 : 4194304;
                                i6 |= i28;
                            } else {
                                targetedFlingBehavior2 = targetedFlingBehavior;
                            }
                            i6 |= i28;
                        } else {
                            targetedFlingBehavior2 = targetedFlingBehavior;
                        }
                        i13 = i5 & 256;
                        if (i13 != 0) {
                            i6 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i6 |= composerStartRestartGroup.changed(z) ? 67108864 : 33554432;
                        }
                        i14 = i5 & 512;
                        if (i14 != 0) {
                            i16 = i6 | DriveFile.MODE_READ_WRITE;
                            i15 = i14;
                        } else {
                            if ((i2 & DriveFile.MODE_READ_WRITE) == 0) {
                                i15 = i14;
                                i6 |= composerStartRestartGroup.changed(z2) ? 536870912 : 268435456;
                            } else {
                                i15 = i14;
                            }
                            i16 = i6;
                        }
                        i17 = i5 & 1024;
                        if (i17 != 0) {
                            i18 = i4 | 6;
                        } else if ((i4 & 6) == 0) {
                            i18 = i4 | (composerStartRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i18 = i4;
                        }
                        if ((i4 & 48) == 0) {
                            i19 = i17;
                            i18 |= ((i5 & 2048) == 0 && composerStartRestartGroup.changedInstance(nestedScrollConnection)) ? 32 : 16;
                        } else {
                            i19 = i17;
                        }
                        int i29 = i18;
                        i20 = i5 & 4096;
                        if (i20 != 0) {
                            i21 = i29 | 384;
                        } else {
                            int i30 = i29;
                            if ((i4 & 384) == 0) {
                                i30 |= composerStartRestartGroup.changed(snapPosition) ? 256 : 128;
                            }
                            i21 = i30;
                        }
                        if ((i5 & 8192) == 0) {
                            if ((i4 & 3072) == 0) {
                                i21 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                            }
                            if ((i16 & 306783379) != 306783378 && (i21 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                z6 = z;
                                z7 = z2;
                                function12 = function1;
                                nestedScrollConnection3 = nestedScrollConnection;
                                snapPosition3 = snapPosition;
                                pageSize4 = pageSize2;
                                composer2 = composerStartRestartGroup;
                                f6 = f4;
                                modifier5 = modifier2;
                                horizontal3 = centerHorizontally;
                                targetedFlingBehavior4 = targetedFlingBehavior2;
                                paddingValues3 = paddingValues;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier modifier6 = i27 == 0 ? Modifier.INSTANCE : modifier2;
                                    PaddingValues paddingValuesM15847PaddingValues0680j_4 = i7 == 0 ? PaddingKt.m15847PaddingValues0680j_4(C2256Dp.m20968constructorimpl(0)) : paddingValues;
                                    PageSize pageSize5 = i8 == 0 ? PageSize.Fill.INSTANCE : pageSize2;
                                    int i31 = i9 == 0 ? 0 : i10;
                                    float fM20968constructorimpl = i11 == 0 ? C2256Dp.m20968constructorimpl(0) : f4;
                                    if (i12 != 0) {
                                        centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                    }
                                    if ((i5 & 128) == 0) {
                                        z3 = false;
                                        i22 = i20;
                                        pagerState2 = pagerState;
                                        i23 = i21;
                                        TargetedFlingBehavior targetedFlingBehaviorFlingBehavior = PagerDefaults.INSTANCE.flingBehavior(pagerState2, null, null, null, 0.0f, composerStartRestartGroup, (i16 & 14) | 196608, 30);
                                        i16 &= -29360129;
                                        targetedFlingBehavior2 = targetedFlingBehaviorFlingBehavior;
                                    } else {
                                        z3 = false;
                                        i22 = i20;
                                        pagerState2 = pagerState;
                                        i23 = i21;
                                    }
                                    boolean z8 = i13 == 0 ? true : z;
                                    if (i15 == 0) {
                                        z3 = z2;
                                    }
                                    Function1<? super Integer, ? extends Object> function13 = i19 == 0 ? null : function1;
                                    if ((i5 & 2048) == 0) {
                                        nestedScrollConnectionPageNestedScrollConnection = PagerDefaults.INSTANCE.pageNestedScrollConnection(pagerState2, Orientation.Vertical, composerStartRestartGroup, (i16 & 14) | 432);
                                        i23 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                    } else {
                                        nestedScrollConnectionPageNestedScrollConnection = nestedScrollConnection;
                                    }
                                    if (i22 == 0) {
                                        function12 = function13;
                                        nestedScrollConnection2 = nestedScrollConnectionPageNestedScrollConnection;
                                        paddingValues2 = paddingValuesM15847PaddingValues0680j_4;
                                        horizontal2 = centerHorizontally;
                                        targetedFlingBehavior3 = targetedFlingBehavior2;
                                        pageSize3 = pageSize5;
                                        i25 = i31;
                                        f5 = fM20968constructorimpl;
                                        z4 = z3;
                                        i26 = i16;
                                        snapPosition2 = SnapPosition.Start.INSTANCE;
                                        composer2 = composerStartRestartGroup;
                                        i24 = i23;
                                    } else {
                                        function12 = function13;
                                        nestedScrollConnection2 = nestedScrollConnectionPageNestedScrollConnection;
                                        paddingValues2 = paddingValuesM15847PaddingValues0680j_4;
                                        horizontal2 = centerHorizontally;
                                        targetedFlingBehavior3 = targetedFlingBehavior2;
                                        pageSize3 = pageSize5;
                                        i24 = i23;
                                        i25 = i31;
                                        f5 = fM20968constructorimpl;
                                        z4 = z3;
                                        i26 = i16;
                                        snapPosition2 = snapPosition;
                                        composer2 = composerStartRestartGroup;
                                    }
                                    z5 = z8;
                                    modifier3 = modifier6;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i5 & 128) != 0) {
                                        i16 &= -29360129;
                                    }
                                    if ((i5 & 2048) != 0) {
                                        i21 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                    }
                                    pagerState2 = pagerState;
                                    paddingValues2 = paddingValues;
                                    function12 = function1;
                                    nestedScrollConnection2 = nestedScrollConnection;
                                    i24 = i21;
                                    pageSize3 = pageSize2;
                                    composer2 = composerStartRestartGroup;
                                    modifier3 = modifier2;
                                    horizontal2 = centerHorizontally;
                                    i26 = i16;
                                    z5 = z;
                                    z4 = z2;
                                    snapPosition2 = snapPosition;
                                    f5 = f4;
                                    i25 = i10;
                                    targetedFlingBehavior3 = targetedFlingBehavior2;
                                }
                                composer2.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    modifier4 = modifier3;
                                } else {
                                    modifier4 = modifier3;
                                    ComposerKt.traceEventStart(909160706, i26, i24, "androidx.compose.foundation.pager.VerticalPager (Pager.kt:211)");
                                }
                                int i32 = i24;
                                int i33 = i26 >> 6;
                                int i34 = ((i26 >> 3) & 14) | 24576 | ((i26 << 3) & 112) | (i26 & 896) | ((i26 >> 18) & 7168) | (i33 & 458752) | (i33 & 3670016);
                                int i35 = i26 << 9;
                                int i36 = i34 | (i35 & 29360128) | (i35 & 234881024) | ((i26 << 18) & 1879048192);
                                int i37 = ((i32 >> 3) & 14) | 3072 | ((i32 << 3) & 112) | ((i26 >> 12) & 896);
                                int i38 = i32 << 6;
                                int i39 = i37 | (i38 & 57344) | (i38 & 458752);
                                Modifier modifier7 = modifier4;
                                LazyLayoutPagerKt.m16087PageruYRUAWA(modifier7, pagerState2, paddingValues2, z4, Orientation.Vertical, targetedFlingBehavior3, z5, i25, f5, pageSize3, nestedScrollConnection2, function12, horizontal2, Alignment.INSTANCE.getCenterVertically(), snapPosition2, function4, composer2, i36, i39, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                pageSize4 = pageSize3;
                                snapPosition3 = snapPosition2;
                                z6 = z5;
                                f6 = f5;
                                targetedFlingBehavior4 = targetedFlingBehavior3;
                                i10 = i25;
                                horizontal3 = horizontal2;
                                nestedScrollConnection3 = nestedScrollConnection2;
                                z7 = z4;
                                paddingValues3 = paddingValues2;
                                modifier5 = modifier7;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$VerticalPager$1
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

                                    public final void invoke(@Nullable Composer composer3, int i40) {
                                        PagerKt.m16092VerticalPageroI3XNZo(pagerState, modifier5, paddingValues3, pageSize4, i10, f6, horizontal3, targetedFlingBehavior4, z6, z7, function12, nestedScrollConnection3, snapPosition3, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i21 |= 3072;
                        if ((i16 & 306783379) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i27 == 0) {
                                }
                                if (i7 == 0) {
                                }
                                if (i8 == 0) {
                                }
                                if (i9 == 0) {
                                }
                                if (i11 == 0) {
                                }
                                if (i12 != 0) {
                                }
                                if ((i5 & 128) == 0) {
                                }
                                if (i13 == 0) {
                                }
                                if (i15 == 0) {
                                }
                                if (i19 == 0) {
                                }
                                if ((i5 & 2048) == 0) {
                                }
                                if (i22 == 0) {
                                }
                                z5 = z8;
                                modifier3 = modifier6;
                                composer2.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i322 = i24;
                                int i332 = i26 >> 6;
                                int i342 = ((i26 >> 3) & 14) | 24576 | ((i26 << 3) & 112) | (i26 & 896) | ((i26 >> 18) & 7168) | (i332 & 458752) | (i332 & 3670016);
                                int i352 = i26 << 9;
                                int i362 = i342 | (i352 & 29360128) | (i352 & 234881024) | ((i26 << 18) & 1879048192);
                                int i372 = ((i322 >> 3) & 14) | 3072 | ((i322 << 3) & 112) | ((i26 >> 12) & 896);
                                int i382 = i322 << 6;
                                int i392 = i372 | (i382 & 57344) | (i382 & 458752);
                                Modifier modifier72 = modifier4;
                                LazyLayoutPagerKt.m16087PageruYRUAWA(modifier72, pagerState2, paddingValues2, z4, Orientation.Vertical, targetedFlingBehavior3, z5, i25, f5, pageSize3, nestedScrollConnection2, function12, horizontal2, Alignment.INSTANCE.getCenterVertically(), snapPosition2, function4, composer2, i362, i392, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                pageSize4 = pageSize3;
                                snapPosition3 = snapPosition2;
                                z6 = z5;
                                f6 = f5;
                                targetedFlingBehavior4 = targetedFlingBehavior3;
                                i10 = i25;
                                horizontal3 = horizontal2;
                                nestedScrollConnection3 = nestedScrollConnection2;
                                z7 = z4;
                                paddingValues3 = paddingValues2;
                                modifier5 = modifier72;
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i10 = i;
                    i11 = i5 & 32;
                    if (i11 != 0) {
                    }
                    i12 = i5 & 64;
                    if (i12 != 0) {
                    }
                    if ((i2 & 12582912) == 0) {
                    }
                    i13 = i5 & 256;
                    if (i13 != 0) {
                    }
                    i14 = i5 & 512;
                    if (i14 != 0) {
                    }
                    i17 = i5 & 1024;
                    if (i17 != 0) {
                    }
                    if ((i4 & 48) == 0) {
                    }
                    int i292 = i18;
                    i20 = i5 & 4096;
                    if (i20 != 0) {
                    }
                    if ((i5 & 8192) == 0) {
                    }
                    if ((i16 & 306783379) != 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                pageSize2 = pageSize;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                i10 = i;
                i11 = i5 & 32;
                if (i11 != 0) {
                }
                i12 = i5 & 64;
                if (i12 != 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                i13 = i5 & 256;
                if (i13 != 0) {
                }
                i14 = i5 & 512;
                if (i14 != 0) {
                }
                i17 = i5 & 1024;
                if (i17 != 0) {
                }
                if ((i4 & 48) == 0) {
                }
                int i2922 = i18;
                i20 = i5 & 4096;
                if (i20 != 0) {
                }
                if ((i5 & 8192) == 0) {
                }
                if ((i16 & 306783379) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            pageSize2 = pageSize;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            i10 = i;
            i11 = i5 & 32;
            if (i11 != 0) {
            }
            i12 = i5 & 64;
            if (i12 != 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            i13 = i5 & 256;
            if (i13 != 0) {
            }
            i14 = i5 & 512;
            if (i14 != 0) {
            }
            i17 = i5 & 1024;
            if (i17 != 0) {
            }
            if ((i4 & 48) == 0) {
            }
            int i29222 = i18;
            i20 = i5 & 4096;
            if (i20 != 0) {
            }
            if ((i5 & 8192) == 0) {
            }
            if ((i16 & 306783379) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        pageSize2 = pageSize;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        i10 = i;
        i11 = i5 & 32;
        if (i11 != 0) {
        }
        i12 = i5 & 64;
        if (i12 != 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        i13 = i5 & 256;
        if (i13 != 0) {
        }
        i14 = i5 & 512;
        if (i14 != 0) {
        }
        i17 = i5 & 1024;
        if (i17 != 0) {
        }
        if ((i4 & 48) == 0) {
        }
        int i292222 = i18;
        i20 = i5 & 4096;
        if (i20 != 0) {
        }
        if ((i5 & 8192) == 0) {
        }
        if ((i16 & 306783379) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    public static final int currentPageOffset(@NotNull SnapPosition snapPosition, int i, int i2, int i4, int i5, int i6, int i7, float f, int i8) {
        return MathKt.roundToInt(snapPosition.position(i, i2, i5, i6, i7, i8) - (f * (i2 + i4)));
    }

    @NotNull
    public static final Modifier pagerSemantics(@NotNull Modifier modifier, @NotNull final PagerState pagerState, final boolean z, @NotNull final CoroutineScope coroutineScope, boolean z2) {
        return z2 ? modifier.then(SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt.pagerSemantics.1
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
                if (z) {
                    final PagerState pagerState2 = pagerState;
                    final CoroutineScope coroutineScope2 = coroutineScope;
                    SemanticsPropertiesKt.pageUp$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt.pagerSemantics.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final Boolean invoke() {
                            return Boolean.valueOf(PagerKt.pagerSemantics$performBackwardPaging(pagerState2, coroutineScope2));
                        }
                    }, 1, null);
                    final PagerState pagerState3 = pagerState;
                    final CoroutineScope coroutineScope3 = coroutineScope;
                    SemanticsPropertiesKt.pageDown$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt.pagerSemantics.1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final Boolean invoke() {
                            return Boolean.valueOf(PagerKt.pagerSemantics$performForwardPaging(pagerState3, coroutineScope3));
                        }
                    }, 1, null);
                    return;
                }
                final PagerState pagerState4 = pagerState;
                final CoroutineScope coroutineScope4 = coroutineScope;
                SemanticsPropertiesKt.pageLeft$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt.pagerSemantics.1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Boolean invoke() {
                        return Boolean.valueOf(PagerKt.pagerSemantics$performBackwardPaging(pagerState4, coroutineScope4));
                    }
                }, 1, null);
                final PagerState pagerState5 = pagerState;
                final CoroutineScope coroutineScope5 = coroutineScope;
                SemanticsPropertiesKt.pageRight$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt.pagerSemantics.1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Boolean invoke() {
                        return Boolean.valueOf(PagerKt.pagerSemantics$performForwardPaging(pagerState5, coroutineScope5));
                    }
                }, 1, null);
            }
        }, 1, null)) : modifier.then(Modifier.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performBackwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (!pagerState.getCanScrollBackward()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PagerKt$pagerSemantics$performBackwardPaging$1(pagerState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performForwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (!pagerState.getCanScrollForward()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PagerKt$pagerSemantics$performForwardPaging$1(pagerState, null), 3, null);
        return true;
    }

    private static final void debugLog(Function0<String> function0) {
    }
}
