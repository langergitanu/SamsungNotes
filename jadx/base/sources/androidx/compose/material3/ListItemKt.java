package androidx.compose.material3;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.app.FrameMetricsAggregator;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a¬\u0001\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u0001H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u007f\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\"2\u001c\u0010#\u001a\u0018\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000b0$¢\u0006\u0002\b\u000e¢\u0006\u0002\b&H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a8\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,2\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000eH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001aN\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000b0$¢\u0006\u0002\b\u000e¢\u0006\u0002\b&2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001aN\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000b0$¢\u0006\u0002\b\u000e¢\u0006\u0002\b&2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00102\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00064"}, m13886d2 = {"ContentEndPadding", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "LeadingContentEndPadding", "ListItemHorizontalPadding", "ListItemThreeLineVerticalPadding", "ListItemVerticalPadding", "ThreeLineListItemContainerHeight", "TrailingHorizontalPadding", "TwoLineListItemContainerHeight", "ListItem", "", "headlineText", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "overlineText", "supportingText", "leadingContent", "trailingContent", "colors", "Landroidx/compose/material3/ListItemColors;", "tonalElevation", "shadowElevation", "ListItem-HXNGIdc", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ListItemColors;FFLandroidx/compose/runtime/Composer;II)V", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "minHeight", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "ListItem-xOgov6c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFFFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ProvideTextStyleFromToken", "color", "textToken", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "ProvideTextStyleFromToken-3J-VO9M", "(JLandroidx/compose/material3/tokens/TypographyKeyTokens;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "topAlign", "", "leadingContent-iJQMabo", "(Lkotlin/jvm/functions/Function2;JZLandroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function3;", "trailingContent-iJQMabo", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ListItemKt {
    private static final float ContentEndPadding;
    private static final float LeadingContentEndPadding;
    private static final float ListItemHorizontalPadding;
    private static final float ListItemThreeLineVerticalPadding;
    private static final float ListItemVerticalPadding;
    private static final float TrailingHorizontalPadding;
    private static final float TwoLineListItemContainerHeight = C2256Dp.m20968constructorimpl(72);
    private static final float ThreeLineListItemContainerHeight = C2256Dp.m20968constructorimpl(88);

    static {
        float f = 8;
        ListItemVerticalPadding = C2256Dp.m20968constructorimpl(f);
        float f4 = 16;
        ListItemThreeLineVerticalPadding = C2256Dp.m20968constructorimpl(f4);
        ListItemHorizontalPadding = C2256Dp.m20968constructorimpl(f4);
        LeadingContentEndPadding = C2256Dp.m20968constructorimpl(f4);
        ContentEndPadding = C2256Dp.m20968constructorimpl(f);
        TrailingHorizontalPadding = C2256Dp.m20968constructorimpl(f);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0106  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ListItem-HXNGIdc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17208ListItemHXNGIdc(@NotNull final Function2<? super Composer, ? super Integer, Unit> headlineText, @Nullable Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, @Nullable ListItemColors listItemColors, float f, float f4, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i7;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i9;
        int i10;
        int i11;
        int i12;
        float f5;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Composer composer2;
        int i13;
        int i14;
        ListItemColors listItemColorsM17206colorsJ08w3E;
        float fM17207getElevationD9Ej5fM;
        float f6;
        final ListItemColors listItemColors2;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        Composer composer3;
        Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final float f7;
        final float f8;
        final ListItemColors listItemColors3;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(headlineText, "headlineText");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1647707763);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(headlineText) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i15 = i2 & 2;
        if (i15 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 896) == 0) {
                    function25 = function2;
                    i4 |= composerStartRestartGroup.changed(function25) ? 256 : 128;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 7168) == 0) {
                        function26 = function22;
                        i4 |= composerStartRestartGroup.changed(function26) ? 2048 : 1024;
                    }
                    i7 = i2 & 16;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else {
                        if ((i & 57344) == 0) {
                            i4 |= composerStartRestartGroup.changed(function23) ? 16384 : 8192;
                        }
                        i8 = i2 & 32;
                        if (i8 != 0) {
                            i4 |= 196608;
                        } else {
                            if ((i & 458752) == 0) {
                                function27 = function24;
                                i4 |= composerStartRestartGroup.changed(function27) ? 131072 : 65536;
                            }
                            if ((i & 3670016) == 0) {
                                i4 |= ((i2 & 64) == 0 && composerStartRestartGroup.changed(listItemColors)) ? 1048576 : 524288;
                            }
                            i9 = i2 & 128;
                            if (i9 == 0) {
                                i4 |= 12582912;
                            } else {
                                if ((i & 29360128) == 0) {
                                    i10 = i9;
                                    i4 |= composerStartRestartGroup.changed(f) ? 8388608 : 4194304;
                                }
                                i11 = i2 & 256;
                                if (i11 == 0) {
                                    if ((i & 234881024) == 0) {
                                        i12 = i11;
                                        f5 = f4;
                                        i4 |= composerStartRestartGroup.changed(f5) ? 67108864 : 33554432;
                                    }
                                    if ((i4 & 191739611) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                                        composerStartRestartGroup.startDefaults();
                                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                            if (i15 != 0) {
                                                modifier2 = Modifier.INSTANCE;
                                            }
                                            if (i5 != 0) {
                                                function25 = null;
                                            }
                                            if (i6 != 0) {
                                                function26 = null;
                                            }
                                            function28 = i7 == 0 ? null : function23;
                                            Function2<? super Composer, ? super Integer, Unit> function214 = i8 == 0 ? function27 : null;
                                            if ((i2 & 64) == 0) {
                                                i13 = i10;
                                                i14 = i12;
                                                listItemColorsM17206colorsJ08w3E = ListItemDefaults.INSTANCE.m17206colorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, DriveFile.MODE_READ_WRITE, FrameMetricsAggregator.EVERY_DURATION);
                                                composer2 = composerStartRestartGroup;
                                                i4 &= -3670017;
                                            } else {
                                                composer2 = composerStartRestartGroup;
                                                i13 = i10;
                                                i14 = i12;
                                                listItemColorsM17206colorsJ08w3E = listItemColors;
                                            }
                                            float fM17207getElevationD9Ej5fM2 = i13 == 0 ? ListItemDefaults.INSTANCE.m17207getElevationD9Ej5fM() : f;
                                            if (i14 == 0) {
                                                function27 = function214;
                                                f6 = fM17207getElevationD9Ej5fM2;
                                                fM17207getElevationD9Ej5fM = ListItemDefaults.INSTANCE.m17207getElevationD9Ej5fM();
                                            } else {
                                                fM17207getElevationD9Ej5fM = f4;
                                                function27 = function214;
                                                f6 = fM17207getElevationD9Ej5fM2;
                                            }
                                        } else {
                                            composerStartRestartGroup.skipToGroupEnd();
                                            if ((i2 & 64) != 0) {
                                                i4 &= -3670017;
                                            }
                                            function28 = function23;
                                            f6 = f;
                                            composer2 = composerStartRestartGroup;
                                            fM17207getElevationD9Ej5fM = f5;
                                            listItemColorsM17206colorsJ08w3E = listItemColors;
                                        }
                                        composer2.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1647707763, i4, -1, "androidx.compose.material3.ListItem (ListItem.kt:71)");
                                        }
                                        if (function25 == null || function26 != null) {
                                            listItemColors2 = listItemColorsM17206colorsJ08w3E;
                                            function29 = function27;
                                            if (function25 != null) {
                                                composer2.startReplaceableGroup(-85612818);
                                                final int i16 = i4;
                                                final Function2<? super Composer, ? super Integer, Unit> function215 = function28;
                                                final Function2<? super Composer, ? super Integer, Unit> function216 = function26;
                                                int i17 = i4 >> 9;
                                                composer3 = composer2;
                                                m17209ListItemxOgov6c(modifier2, null, listItemColors2.containerColor$material3_release(composer2, (i4 >> 18) & 14).getValue().m18535unboximpl(), listItemColors2.headlineColor$material3_release(true, composer2, ((i4 >> 15) & 112) | 6).getValue().m18535unboximpl(), f6, fM17207getElevationD9Ej5fM, TwoLineListItemContainerHeight, PaddingKt.m15848PaddingValuesYgX7TsA(ListItemHorizontalPadding, ListItemVerticalPadding), ComposableLambdaKt.composableLambda(composer2, 48069791, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                                                        invoke(rowScope, composer4, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                    @Composable
                                                    public final void invoke(@NotNull RowScope ListItem, @Nullable Composer composer4, int i18) {
                                                        int i19;
                                                        Composer composer5;
                                                        Intrinsics.checkNotNullParameter(ListItem, "$this$ListItem");
                                                        if ((i18 & 14) == 0) {
                                                            i19 = i18 | (composer4.changed(ListItem) ? 4 : 2);
                                                        } else {
                                                            i19 = i18;
                                                        }
                                                        if ((i19 & 91) == 18 && composer4.getSkipping()) {
                                                            composer4.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(48069791, i19, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:129)");
                                                        }
                                                        composer4.startReplaceableGroup(1316673775);
                                                        Function2<Composer, Integer, Unit> function217 = function215;
                                                        if (function217 != null) {
                                                            composer5 = composer4;
                                                            ListItemKt.m17215leadingContentiJQMabo(function217, listItemColors2.leadingIconColor$material3_release(true, composer4, ((i16 >> 15) & 112) | 6).getValue().m18535unboximpl(), false, composer4, ((i16 >> 12) & 14) | 384).invoke(ListItem, composer5, Integer.valueOf(i19 & 14));
                                                        } else {
                                                            composer5 = composer4;
                                                        }
                                                        composer5.endReplaceableGroup();
                                                        Modifier.Companion companion = Modifier.INSTANCE;
                                                        Modifier modifierWeight$default = RowScope.weight$default(ListItem, companion, 1.0f, false, 2, null);
                                                        Alignment.Companion companion2 = Alignment.INSTANCE;
                                                        Modifier modifierAlign = ListItem.align(modifierWeight$default, companion2.getCenterVertically());
                                                        ListItemColors listItemColors4 = listItemColors2;
                                                        int i20 = i16;
                                                        Function2<Composer, Integer, Unit> function218 = headlineText;
                                                        Function2<Composer, Integer, Unit> function219 = function216;
                                                        composer5.startReplaceableGroup(733328855);
                                                        MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composer5, 0, -1323940314);
                                                        Density density = (Density) composer5.consume(CompositionLocalsKt.getLocalDensity());
                                                        LayoutDirection layoutDirection = (LayoutDirection) composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                                        Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierAlign);
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
                                                        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer5, composer5), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-2137368960);
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        composer5.startReplaceableGroup(691896537);
                                                        composer5.startReplaceableGroup(-483455358);
                                                        MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(companion2, Arrangement.INSTANCE.getTop(), composer5, 0, -1323940314);
                                                        Density density2 = (Density) composer5.consume(CompositionLocalsKt.getLocalDensity());
                                                        LayoutDirection layoutDirection2 = (LayoutDirection) composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(companion);
                                                        if (composer5.getApplier() == null) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor2);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        composer5.disableReusing();
                                                        Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer5);
                                                        Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1209j, composerM18018constructorimpl2, density2));
                                                        function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composer5, composer5), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-1163856341);
                                                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                                        composer5.startReplaceableGroup(-1123604189);
                                                        long jM18535unboximpl = listItemColors4.headlineColor$material3_release(true, composer5, ((i20 >> 15) & 112) | 6).getValue().m18535unboximpl();
                                                        ListTokens listTokens = ListTokens.INSTANCE;
                                                        Composer composer6 = composer5;
                                                        ListItemKt.m17210ProvideTextStyleFromToken3JVO9M(jM18535unboximpl, listTokens.getListItemLabelTextFont(), function218, composer6, ((i20 << 6) & 896) | 48);
                                                        long jM18535unboximpl2 = listItemColors4.supportingColor$material3_release(composer6, (i20 >> 18) & 14).getValue().m18535unboximpl();
                                                        TypographyKeyTokens listItemSupportingTextFont = listTokens.getListItemSupportingTextFont();
                                                        Intrinsics.checkNotNull(function219);
                                                        ListItemKt.m17210ProvideTextStyleFromToken3JVO9M(jM18535unboximpl2, listItemSupportingTextFont, function219, composer6, 48);
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endNode();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endNode();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        Function2<Composer, Integer, Unit> function220 = function29;
                                                        if (function220 != null) {
                                                            ListItemKt.m17216trailingContentiJQMabo(function220, listItemColors2.trailingIconColor$material3_release(true, composer6, ((i16 >> 15) & 112) | 6).getValue().m18535unboximpl(), false, composer6, ((i16 >> 15) & 14) | 384).invoke(ListItem, composer6, Integer.valueOf(i19 & 14));
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }), composer3, 114819072 | ((i4 >> 3) & 14) | (i17 & 57344) | (i17 & 458752), 2);
                                                composer3.endReplaceableGroup();
                                            } else if (function26 == null) {
                                                composer2.startReplaceableGroup(-85611073);
                                                final int i18 = i4;
                                                final Function2<? super Composer, ? super Integer, Unit> function217 = function28;
                                                final Function2<? super Composer, ? super Integer, Unit> function218 = function25;
                                                int i19 = i4 >> 9;
                                                composer3 = composer2;
                                                m17209ListItemxOgov6c(modifier2, null, listItemColors2.containerColor$material3_release(composer2, (i4 >> 18) & 14).getValue().m18535unboximpl(), listItemColors2.headlineColor$material3_release(true, composer2, ((i4 >> 15) & 112) | 6).getValue().m18535unboximpl(), f6, fM17207getElevationD9Ej5fM, TwoLineListItemContainerHeight, PaddingKt.m15848PaddingValuesYgX7TsA(ListItemHorizontalPadding, ListItemVerticalPadding), ComposableLambdaKt.composableLambda(composer2, 1733969726, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                                                        invoke(rowScope, composer4, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                    @Composable
                                                    public final void invoke(@NotNull RowScope ListItem, @Nullable Composer composer4, int i20) {
                                                        int i21;
                                                        Composer composer5;
                                                        Intrinsics.checkNotNullParameter(ListItem, "$this$ListItem");
                                                        if ((i20 & 14) == 0) {
                                                            i21 = i20 | (composer4.changed(ListItem) ? 4 : 2);
                                                        } else {
                                                            i21 = i20;
                                                        }
                                                        if ((i21 & 91) == 18 && composer4.getSkipping()) {
                                                            composer4.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1733969726, i21, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:173)");
                                                        }
                                                        composer4.startReplaceableGroup(1316675520);
                                                        Function2<Composer, Integer, Unit> function219 = function217;
                                                        if (function219 != null) {
                                                            composer5 = composer4;
                                                            ListItemKt.m17215leadingContentiJQMabo(function219, listItemColors2.leadingIconColor$material3_release(true, composer4, ((i18 >> 15) & 112) | 6).getValue().m18535unboximpl(), false, composer4, ((i18 >> 12) & 14) | 384).invoke(ListItem, composer5, Integer.valueOf(i21 & 14));
                                                        } else {
                                                            composer5 = composer4;
                                                        }
                                                        composer5.endReplaceableGroup();
                                                        Modifier.Companion companion = Modifier.INSTANCE;
                                                        Modifier modifierWeight$default = RowScope.weight$default(ListItem, companion, 1.0f, false, 2, null);
                                                        Alignment.Companion companion2 = Alignment.INSTANCE;
                                                        Modifier modifierAlign = ListItem.align(modifierWeight$default, companion2.getCenterVertically());
                                                        ListItemColors listItemColors4 = listItemColors2;
                                                        int i22 = i18;
                                                        Function2<Composer, Integer, Unit> function220 = function218;
                                                        Function2<Composer, Integer, Unit> function221 = headlineText;
                                                        composer5.startReplaceableGroup(733328855);
                                                        MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composer5, 0, -1323940314);
                                                        Density density = (Density) composer5.consume(CompositionLocalsKt.getLocalDensity());
                                                        LayoutDirection layoutDirection = (LayoutDirection) composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                                        Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierAlign);
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
                                                        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer5, composer5), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-2137368960);
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        composer5.startReplaceableGroup(-1917170824);
                                                        composer5.startReplaceableGroup(-483455358);
                                                        MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(companion2, Arrangement.INSTANCE.getTop(), composer5, 0, -1323940314);
                                                        Density density2 = (Density) composer5.consume(CompositionLocalsKt.getLocalDensity());
                                                        LayoutDirection layoutDirection2 = (LayoutDirection) composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(companion);
                                                        if (composer5.getApplier() == null) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor2);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        composer5.disableReusing();
                                                        Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer5);
                                                        Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1209j, composerM18018constructorimpl2, density2));
                                                        function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composer5, composer5), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-1163856341);
                                                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                                        composer5.startReplaceableGroup(562295746);
                                                        long jM18535unboximpl = listItemColors4.overlineColor$material3_release(composer5, (i22 >> 18) & 14).getValue().m18535unboximpl();
                                                        ListTokens listTokens = ListTokens.INSTANCE;
                                                        Composer composer6 = composer5;
                                                        ListItemKt.m17210ProvideTextStyleFromToken3JVO9M(jM18535unboximpl, listTokens.getListItemOverlineFont(), function220, composer6, (i22 & 896) | 48);
                                                        ListItemKt.m17210ProvideTextStyleFromToken3JVO9M(listItemColors4.headlineColor$material3_release(true, composer6, ((i22 >> 15) & 112) | 6).getValue().m18535unboximpl(), listTokens.getListItemLabelTextFont(), function221, composer6, ((i22 << 6) & 896) | 48);
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endNode();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endNode();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        Function2<Composer, Integer, Unit> function222 = function29;
                                                        if (function222 != null) {
                                                            ListItemKt.m17216trailingContentiJQMabo(function222, listItemColors2.trailingIconColor$material3_release(true, composer6, ((i18 >> 15) & 112) | 6).getValue().m18535unboximpl(), false, composer6, ((i18 >> 15) & 14) | 384).invoke(ListItem, composer6, Integer.valueOf(i21 & 14));
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }), composer3, 114819072 | ((i4 >> 3) & 14) | (i19 & 57344) | (i19 & 458752), 2);
                                                composer3.endReplaceableGroup();
                                            } else {
                                                composer2.startReplaceableGroup(-85609368);
                                                final int i20 = i4;
                                                final Function2<? super Composer, ? super Integer, Unit> function219 = function28;
                                                final Function2<? super Composer, ? super Integer, Unit> function220 = function25;
                                                final Function2<? super Composer, ? super Integer, Unit> function221 = function26;
                                                int i21 = i4 >> 9;
                                                composer3 = composer2;
                                                modifier3 = modifier2;
                                                m17209ListItemxOgov6c(modifier3, null, listItemColors2.containerColor$material3_release(composer2, (i4 >> 18) & 14).getValue().m18535unboximpl(), listItemColors2.headlineColor$material3_release(true, composer2, ((i4 >> 15) & 112) | 6).getValue().m18535unboximpl(), f6, fM17207getElevationD9Ej5fM, ThreeLineListItemContainerHeight, PaddingKt.m15848PaddingValuesYgX7TsA(ListItemHorizontalPadding, ListItemThreeLineVerticalPadding), ComposableLambdaKt.composableLambda(composer2, -1269203265, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$4
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                                                        invoke(rowScope, composer4, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                    @Composable
                                                    public final void invoke(@NotNull RowScope ListItem, @Nullable Composer composer4, int i22) {
                                                        int i23;
                                                        Composer composer5;
                                                        Intrinsics.checkNotNullParameter(ListItem, "$this$ListItem");
                                                        if ((i22 & 14) == 0) {
                                                            i23 = i22 | (composer4.changed(ListItem) ? 4 : 2);
                                                        } else {
                                                            i23 = i22;
                                                        }
                                                        if ((i23 & 91) == 18 && composer4.getSkipping()) {
                                                            composer4.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1269203265, i23, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:220)");
                                                        }
                                                        composer4.startReplaceableGroup(1316677284);
                                                        Function2<Composer, Integer, Unit> function222 = function219;
                                                        if (function222 != null) {
                                                            composer5 = composer4;
                                                            ListItemKt.m17215leadingContentiJQMabo(function222, listItemColors2.leadingIconColor$material3_release(true, composer4, ((i20 >> 15) & 112) | 6).getValue().m18535unboximpl(), true, composer4, ((i20 >> 12) & 14) | 384).invoke(ListItem, composer5, Integer.valueOf(i23 & 14));
                                                        } else {
                                                            composer5 = composer4;
                                                        }
                                                        composer5.endReplaceableGroup();
                                                        Modifier.Companion companion = Modifier.INSTANCE;
                                                        Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(RowScope.weight$default(ListItem, companion, 1.0f, false, 2, null), 0.0f, 0.0f, ListItemKt.ContentEndPadding, 0.0f, 11, null);
                                                        ListItemColors listItemColors4 = listItemColors2;
                                                        int i24 = i20;
                                                        Function2<Composer, Integer, Unit> function223 = function220;
                                                        Function2<Composer, Integer, Unit> function224 = headlineText;
                                                        Function2<Composer, Integer, Unit> function225 = function221;
                                                        composer5.startReplaceableGroup(733328855);
                                                        Alignment.Companion companion2 = Alignment.INSTANCE;
                                                        MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composer5, 0, -1323940314);
                                                        Density density = (Density) composer5.consume(CompositionLocalsKt.getLocalDensity());
                                                        LayoutDirection layoutDirection = (LayoutDirection) composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                                        Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
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
                                                        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer5, composer5), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-2137368960);
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        composer5.startReplaceableGroup(-729239559);
                                                        composer5.startReplaceableGroup(-483455358);
                                                        MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(companion2, Arrangement.INSTANCE.getTop(), composer5, 0, -1323940314);
                                                        Density density2 = (Density) composer5.consume(CompositionLocalsKt.getLocalDensity());
                                                        LayoutDirection layoutDirection2 = (LayoutDirection) composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(companion);
                                                        if (composer5.getApplier() == null) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor2);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        composer5.disableReusing();
                                                        Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer5);
                                                        Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1209j, composerM18018constructorimpl2, density2));
                                                        function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composer5, composer5), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-1163856341);
                                                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                                        composer5.startReplaceableGroup(-466219709);
                                                        int i25 = (i24 >> 18) & 14;
                                                        long jM18535unboximpl = listItemColors4.overlineColor$material3_release(composer5, i25).getValue().m18535unboximpl();
                                                        ListTokens listTokens = ListTokens.INSTANCE;
                                                        Composer composer6 = composer5;
                                                        ListItemKt.m17210ProvideTextStyleFromToken3JVO9M(jM18535unboximpl, listTokens.getListItemOverlineFont(), function223, composer6, (i24 & 896) | 48);
                                                        ListItemKt.m17210ProvideTextStyleFromToken3JVO9M(listItemColors4.headlineColor$material3_release(true, composer6, ((i24 >> 15) & 112) | 6).getValue().m18535unboximpl(), listTokens.getListItemLabelTextFont(), function224, composer6, ((i24 << 6) & 896) | 48);
                                                        ListItemKt.m17210ProvideTextStyleFromToken3JVO9M(listItemColors4.supportingColor$material3_release(composer6, i25).getValue().m18535unboximpl(), listTokens.getListItemSupportingTextFont(), function225, composer6, ((i24 >> 3) & 896) | 48);
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endNode();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endNode();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        Function2<Composer, Integer, Unit> function226 = function29;
                                                        if (function226 != null) {
                                                            ListItemKt.m17216trailingContentiJQMabo(function226, listItemColors2.trailingIconColor$material3_release(true, composer6, ((i20 >> 15) & 112) | 6).getValue().m18535unboximpl(), true, composer6, ((i20 >> 15) & 14) | 384).invoke(ListItem, composer6, Integer.valueOf(i23 & 14));
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }), composer3, 114819072 | ((i4 >> 3) & 14) | (i21 & 57344) | (i21 & 458752), 2);
                                                composer3.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                function210 = function28;
                                                function211 = function25;
                                                function212 = function26;
                                                f7 = f6;
                                                f8 = fM17207getElevationD9Ej5fM;
                                                listItemColors3 = listItemColors2;
                                                function213 = function29;
                                                modifier4 = modifier3;
                                            }
                                        } else {
                                            composer2.startReplaceableGroup(-85614273);
                                            final ListItemColors listItemColors4 = listItemColorsM17206colorsJ08w3E;
                                            final int i22 = i4;
                                            final Function2<? super Composer, ? super Integer, Unit> function222 = function28;
                                            final Function2<? super Composer, ? super Integer, Unit> function223 = function27;
                                            listItemColors2 = listItemColors4;
                                            function29 = function223;
                                            int i23 = i4 >> 9;
                                            composer3 = composer2;
                                            m17209ListItemxOgov6c(modifier2, null, listItemColorsM17206colorsJ08w3E.containerColor$material3_release(composer2, (i4 >> 18) & 14).getValue().m18535unboximpl(), listItemColorsM17206colorsJ08w3E.headlineColor$material3_release(true, composer2, ((i4 >> 15) & 112) | 6).getValue().m18535unboximpl(), f6, fM17207getElevationD9Ej5fM, ListTokens.INSTANCE.m17724getListItemContainerHeightD9Ej5fM(), PaddingKt.m15848PaddingValuesYgX7TsA(ListItemHorizontalPadding, ListItemVerticalPadding), ComposableLambdaKt.composableLambda(composer2, 967218806, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                                                    invoke(rowScope, composer4, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                @Composable
                                                public final void invoke(@NotNull RowScope ListItem, @Nullable Composer composer4, int i24) {
                                                    int i25;
                                                    Composer composer5;
                                                    Intrinsics.checkNotNullParameter(ListItem, "$this$ListItem");
                                                    if ((i24 & 14) == 0) {
                                                        i25 = i24 | (composer4.changed(ListItem) ? 4 : 2);
                                                    } else {
                                                        i25 = i24;
                                                    }
                                                    if ((i25 & 91) == 18 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(967218806, i25, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:92)");
                                                    }
                                                    composer4.startReplaceableGroup(1316672324);
                                                    Function2<Composer, Integer, Unit> function224 = function222;
                                                    if (function224 != null) {
                                                        composer5 = composer4;
                                                        ListItemKt.m17215leadingContentiJQMabo(function224, listItemColors4.leadingIconColor$material3_release(true, composer4, ((i22 >> 15) & 112) | 6).getValue().m18535unboximpl(), false, composer4, ((i22 >> 12) & 14) | 384).invoke(ListItem, composer5, Integer.valueOf(i25 & 14));
                                                    } else {
                                                        composer5 = composer4;
                                                    }
                                                    composer5.endReplaceableGroup();
                                                    Modifier modifierWeight$default = RowScope.weight$default(ListItem, Modifier.INSTANCE, 1.0f, false, 2, null);
                                                    Alignment.Companion companion = Alignment.INSTANCE;
                                                    Modifier modifierAlign = ListItem.align(modifierWeight$default, companion.getCenterVertically());
                                                    ListItemColors listItemColors5 = listItemColors4;
                                                    int i26 = i22;
                                                    Function2<Composer, Integer, Unit> function225 = headlineText;
                                                    composer5.startReplaceableGroup(733328855);
                                                    MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion, false, composer5, 0, -1323940314);
                                                    Density density = (Density) composer5.consume(CompositionLocalsKt.getLocalDensity());
                                                    LayoutDirection layoutDirection = (LayoutDirection) composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierAlign);
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
                                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer5, composer5), composer5, 2058660585);
                                                    composer5.startReplaceableGroup(-2137368960);
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    composer5.startReplaceableGroup(181297456);
                                                    Composer composer6 = composer5;
                                                    ListItemKt.m17210ProvideTextStyleFromToken3JVO9M(listItemColors5.headlineColor$material3_release(true, composer5, ((i26 >> 15) & 112) | 6).getValue().m18535unboximpl(), ListTokens.INSTANCE.getListItemLabelTextFont(), function225, composer6, ((i26 << 6) & 896) | 48);
                                                    composer6.endReplaceableGroup();
                                                    composer6.endReplaceableGroup();
                                                    composer6.endReplaceableGroup();
                                                    composer6.endNode();
                                                    composer6.endReplaceableGroup();
                                                    composer6.endReplaceableGroup();
                                                    Function2<Composer, Integer, Unit> function226 = function223;
                                                    if (function226 != null) {
                                                        ListItemKt.m17216trailingContentiJQMabo(function226, listItemColors4.trailingIconColor$material3_release(true, composer6, ((i22 >> 15) & 112) | 6).getValue().m18535unboximpl(), false, composer6, ((i22 >> 15) & 14) | 384).invoke(ListItem, composer6, Integer.valueOf(i25 & 14));
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }), composer3, 114819072 | ((i4 >> 3) & 14) | (i23 & 57344) | (i23 & 458752), 2);
                                            composer3.endReplaceableGroup();
                                        }
                                        modifier3 = modifier2;
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        function210 = function28;
                                        function211 = function25;
                                        function212 = function26;
                                        f7 = f6;
                                        f8 = fM17207getElevationD9Ej5fM;
                                        listItemColors3 = listItemColors2;
                                        function213 = function29;
                                        modifier4 = modifier3;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        f7 = f;
                                        composer3 = composerStartRestartGroup;
                                        modifier4 = modifier2;
                                        function211 = function25;
                                        function212 = function26;
                                        f8 = f5;
                                        function213 = function27;
                                        function210 = function23;
                                        listItemColors3 = listItemColors;
                                    }
                                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup != null) {
                                        return;
                                    }
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$5
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

                                        public final void invoke(@Nullable Composer composer4, int i24) {
                                            ListItemKt.m17208ListItemHXNGIdc(headlineText, modifier4, function211, function212, function210, function213, listItemColors3, f7, f8, composer4, i | 1, i2);
                                        }
                                    });
                                    return;
                                }
                                i4 |= 100663296;
                                i12 = i11;
                                f5 = f4;
                                if ((i4 & 191739611) == 38347922) {
                                    composerStartRestartGroup.startDefaults();
                                    if ((i & 1) != 0) {
                                        if (i15 != 0) {
                                        }
                                        if (i5 != 0) {
                                        }
                                        if (i6 != 0) {
                                        }
                                        if (i7 == 0) {
                                        }
                                        if (i8 == 0) {
                                        }
                                        if ((i2 & 64) == 0) {
                                        }
                                        if (i13 == 0) {
                                        }
                                        if (i14 == 0) {
                                        }
                                        composer2.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        if (function25 == null) {
                                            listItemColors2 = listItemColorsM17206colorsJ08w3E;
                                            function29 = function27;
                                            if (function25 != null) {
                                            }
                                            modifier3 = modifier2;
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            function210 = function28;
                                            function211 = function25;
                                            function212 = function26;
                                            f7 = f6;
                                            f8 = fM17207getElevationD9Ej5fM;
                                            listItemColors3 = listItemColors2;
                                            function213 = function29;
                                            modifier4 = modifier3;
                                        }
                                    }
                                }
                                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                }
                            }
                            i10 = i9;
                            i11 = i2 & 256;
                            if (i11 == 0) {
                            }
                            i12 = i11;
                            f5 = f4;
                            if ((i4 & 191739611) == 38347922) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        function27 = function24;
                        if ((i & 3670016) == 0) {
                        }
                        i9 = i2 & 128;
                        if (i9 == 0) {
                        }
                        i10 = i9;
                        i11 = i2 & 256;
                        if (i11 == 0) {
                        }
                        i12 = i11;
                        f5 = f4;
                        if ((i4 & 191739611) == 38347922) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                    }
                    function27 = function24;
                    if ((i & 3670016) == 0) {
                    }
                    i9 = i2 & 128;
                    if (i9 == 0) {
                    }
                    i10 = i9;
                    i11 = i2 & 256;
                    if (i11 == 0) {
                    }
                    i12 = i11;
                    f5 = f4;
                    if ((i4 & 191739611) == 38347922) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function26 = function22;
                i7 = i2 & 16;
                if (i7 == 0) {
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                }
                function27 = function24;
                if ((i & 3670016) == 0) {
                }
                i9 = i2 & 128;
                if (i9 == 0) {
                }
                i10 = i9;
                i11 = i2 & 256;
                if (i11 == 0) {
                }
                i12 = i11;
                f5 = f4;
                if ((i4 & 191739611) == 38347922) {
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function25 = function2;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            function26 = function22;
            i7 = i2 & 16;
            if (i7 == 0) {
            }
            i8 = i2 & 32;
            if (i8 != 0) {
            }
            function27 = function24;
            if ((i & 3670016) == 0) {
            }
            i9 = i2 & 128;
            if (i9 == 0) {
            }
            i10 = i9;
            i11 = i2 & 256;
            if (i11 == 0) {
            }
            i12 = i11;
            f5 = f4;
            if ((i4 & 191739611) == 38347922) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        function25 = function2;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        function26 = function22;
        i7 = i2 & 16;
        if (i7 == 0) {
        }
        i8 = i2 & 32;
        if (i8 != 0) {
        }
        function27 = function24;
        if ((i & 3670016) == 0) {
        }
        i9 = i2 & 128;
        if (i9 == 0) {
        }
        i10 = i9;
        i11 = i2 & 256;
        if (i11 == 0) {
        }
        i12 = i11;
        f5 = f4;
        if ((i4 & 191739611) == 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0206 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0118  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ListItem-xOgov6c, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17209ListItemxOgov6c(Modifier modifier, Shape shape, long j, long j2, float f, float f4, final float f5, final PaddingValues paddingValues, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        final int i4;
        Shape shape2;
        long containerColor;
        long contentColor;
        float f6;
        int i5;
        float fM17207getElevationD9Ej5fM;
        int i6;
        Composer composer2;
        final Modifier modifier3;
        final Shape shape3;
        final long j3;
        final long j5;
        final float f7;
        final float f8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(1069030861);
        int i9 = i2 & 1;
        if (i9 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                shape2 = shape;
                int i10 = composerStartRestartGroup.changed(shape2) ? 32 : 16;
                i4 |= i10;
            } else {
                shape2 = shape;
            }
            i4 |= i10;
        } else {
            shape2 = shape;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                containerColor = j;
                int i11 = composerStartRestartGroup.changed(containerColor) ? 256 : 128;
                i4 |= i11;
            } else {
                containerColor = j;
            }
            i4 |= i11;
        } else {
            containerColor = j;
        }
        if ((i & 7168) == 0) {
            contentColor = j2;
            i4 |= ((i2 & 8) == 0 && composerStartRestartGroup.changed(contentColor)) ? 2048 : 1024;
        } else {
            contentColor = j2;
        }
        int i12 = i2 & 16;
        if (i12 != 0) {
            i4 |= 24576;
        } else if ((i & 57344) == 0) {
            i4 |= composerStartRestartGroup.changed(f) ? 16384 : 8192;
        }
        int i13 = i2 & 32;
        if (i13 != 0) {
            i4 |= 196608;
        } else if ((i & 458752) == 0) {
            i4 |= composerStartRestartGroup.changed(f4) ? 131072 : 65536;
        }
        if ((i2 & 64) == 0) {
            i8 = (i & 3670016) == 0 ? composerStartRestartGroup.changed(f5) ? 1048576 : 524288 : 1572864;
            if ((i2 & 128) == 0) {
                i4 |= 12582912;
            } else if ((29360128 & i) == 0) {
                i4 |= composerStartRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
            }
            if ((i2 & 256) != 0) {
                i7 = (234881024 & i) == 0 ? composerStartRestartGroup.changed(function3) ? 67108864 : 33554432 : 100663296;
                if ((191739611 & i4) == 38347922 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    f8 = f4;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier2;
                    shape3 = shape2;
                    j3 = containerColor;
                    j5 = contentColor;
                    f7 = f;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 2) != 0) {
                            Shape shape4 = ListItemDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                            shape2 = shape4;
                        }
                        if ((i2 & 4) != 0) {
                            containerColor = ListItemDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            contentColor = ListItemDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        }
                        float fM17207getElevationD9Ej5fM2 = i12 == 0 ? ListItemDefaults.INSTANCE.m17207getElevationD9Ej5fM() : f;
                        if (i13 == 0) {
                            f6 = fM17207getElevationD9Ej5fM2;
                            i5 = 12582912;
                            fM17207getElevationD9Ej5fM = ListItemDefaults.INSTANCE.m17207getElevationD9Ej5fM();
                        } else {
                            f6 = fM17207getElevationD9Ej5fM2;
                            i5 = 12582912;
                            fM17207getElevationD9Ej5fM = f4;
                        }
                        i6 = 458752;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                        }
                        if ((i2 & 4) != 0) {
                            i4 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i4 &= -7169;
                        }
                        fM17207getElevationD9Ej5fM = f4;
                        i6 = 458752;
                        i5 = 12582912;
                        f6 = f;
                    }
                    long j6 = contentColor;
                    Modifier modifier4 = modifier2;
                    Shape shape5 = shape2;
                    long j7 = containerColor;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1069030861, i4, -1, "androidx.compose.material3.ListItem (ListItem.kt:280)");
                    }
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m17325SurfaceT9BRK9s(modifier4, shape5, j7, j6, f6, fM17207getElevationD9Ej5fM, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1393735016, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$6
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
                                ComposerKt.traceEventStart(1393735016, i14, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:298)");
                            }
                            Modifier modifierPadding = PaddingKt.padding(SizeKt.m15887heightInVpY3zN4$default(Modifier.INSTANCE, f5, 0.0f, 2, null), paddingValues);
                            Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                            int i15 = (i4 >> 15) & 7168;
                            composer3.startReplaceableGroup(693286680);
                            MeasurePolicy measurePolicyM1208i = AbstractC1038a.m1208i(Alignment.INSTANCE, Arrangement.INSTANCE.getStart(), composer3, 0, -1323940314);
                            Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
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
                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1208i, composerM18018constructorimpl, density));
                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                            composer3.startReplaceableGroup(-678309503);
                            function32.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i15 >> 6) & 112) | 6));
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, i5 | (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (i6 & i4), 64);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    shape3 = shape5;
                    j3 = j7;
                    j5 = j6;
                    f7 = f6;
                    f8 = fM17207getElevationD9Ej5fM;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$7
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

                    public final void invoke(@Nullable Composer composer3, int i14) {
                        ListItemKt.m17209ListItemxOgov6c(modifier3, shape3, j3, j5, f7, f8, f5, paddingValues, function3, composer3, i | 1, i2);
                    }
                });
                return;
            }
            i4 |= i7;
            if ((191739611 & i4) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                    }
                    if ((i2 & 2) != 0) {
                    }
                    if ((i2 & 4) != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i13 == 0) {
                    }
                    i6 = 458752;
                    long j62 = contentColor;
                    Modifier modifier42 = modifier2;
                    Shape shape52 = shape2;
                    long j72 = containerColor;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m17325SurfaceT9BRK9s(modifier42, shape52, j72, j62, f6, fM17207getElevationD9Ej5fM, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1393735016, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$6
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
                                ComposerKt.traceEventStart(1393735016, i14, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:298)");
                            }
                            Modifier modifierPadding = PaddingKt.padding(SizeKt.m15887heightInVpY3zN4$default(Modifier.INSTANCE, f5, 0.0f, 2, null), paddingValues);
                            Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                            int i15 = (i4 >> 15) & 7168;
                            composer3.startReplaceableGroup(693286680);
                            MeasurePolicy measurePolicyM1208i = AbstractC1038a.m1208i(Alignment.INSTANCE, Arrangement.INSTANCE.getStart(), composer3, 0, -1323940314);
                            Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
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
                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1208i, composerM18018constructorimpl, density));
                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                            composer3.startReplaceableGroup(-678309503);
                            function32.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i15 >> 6) & 112) | 6));
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, i5 | (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (i6 & i4), 64);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier42;
                    shape3 = shape52;
                    j3 = j72;
                    j5 = j62;
                    f7 = f6;
                    f8 = fM17207getElevationD9Ej5fM;
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        i4 |= i8;
        if ((i2 & 128) == 0) {
        }
        if ((i2 & 256) != 0) {
        }
        i4 |= i7;
        if ((191739611 & i4) == 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /* JADX INFO: renamed from: ProvideTextStyleFromToken-3J-VO9M, reason: not valid java name */
    public static final void m17210ProvideTextStyleFromToken3JVO9M(final long j, final TypographyKeyTokens typographyKeyTokens, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        final int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1133967795);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(typographyKeyTokens) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(function2) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1133967795, i2, -1, "androidx.compose.material3.ProvideTextStyleFromToken (ListItem.kt:489)");
            }
            final TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), typographyKeyTokens);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -514310925, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ProvideTextStyleFromToken$1
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
                public final void invoke(@Nullable Composer composer2, int i4) {
                    if ((i4 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-514310925, i4, -1, "androidx.compose.material3.ProvideTextStyleFromToken.<anonymous> (ListItem.kt:495)");
                    }
                    TextKt.ProvideTextStyle(textStyleFromToken, function2, composer2, (i2 >> 3) & 112);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ProvideTextStyleFromToken$2
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
                ListItemKt.m17210ProvideTextStyleFromToken3JVO9M(j, typographyKeyTokens, function2, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[_[androidx.compose.ui.UiComposable]:[_]]")
    /* JADX INFO: renamed from: leadingContent-iJQMabo, reason: not valid java name */
    public static final Function3<RowScope, Composer, Integer, Unit> m17215leadingContentiJQMabo(final Function2<? super Composer, ? super Integer, Unit> function2, final long j, final boolean z, Composer composer, final int i) {
        composer.startReplaceableGroup(292744125);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(292744125, i, -1, "androidx.compose.material3.leadingContent (ListItem.kt:309)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -1755598478, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$leadingContent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                invoke(rowScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@NotNull final RowScope rowScope, @Nullable Composer composer2, int i2) {
                int i4;
                Intrinsics.checkNotNullParameter(rowScope, "$this$null");
                if ((i2 & 14) == 0) {
                    i4 = (composer2.changed(rowScope) ? 4 : 2) | i2;
                } else {
                    i4 = i2;
                }
                if ((i4 & 91) == 18 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1755598478, i2, -1, "androidx.compose.material3.leadingContent.<anonymous> (ListItem.kt:314)");
                }
                ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j))};
                final boolean z2 = z;
                final Function2<Composer, Integer, Unit> function22 = function2;
                final int i5 = i;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1636714958, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$leadingContent$1.1
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
                    public final void invoke(@Nullable Composer composer3, int i6) {
                        if ((i6 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1636714958, i6, -1, "androidx.compose.material3.leadingContent.<anonymous>.<anonymous> (ListItem.kt:316)");
                        }
                        if (z2) {
                            composer3.startReplaceableGroup(377880875);
                            Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, ListItemKt.LeadingContentEndPadding, 0.0f, 11, null);
                            Alignment topStart = Alignment.INSTANCE.getTopStart();
                            Function2<Composer, Integer, Unit> function23 = function22;
                            int i7 = i5;
                            composer3.startReplaceableGroup(733328855);
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topStart, false, composer3, 6);
                            Density density = (Density) AbstractC1038a.m1211l(composer3, -1323940314);
                            LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
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
                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            composer3.startReplaceableGroup(-2137368960);
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composer3.startReplaceableGroup(781903379);
                            function23.invoke(composer3, Integer.valueOf(i7 & 14));
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(377881084);
                            RowScope rowScope2 = rowScope;
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            Alignment.Companion companion3 = Alignment.INSTANCE;
                            Modifier modifierM15858paddingqDBjuR0$default2 = PaddingKt.m15858paddingqDBjuR0$default(rowScope2.align(companion2, companion3.getCenterVertically()), 0.0f, 0.0f, ListItemKt.LeadingContentEndPadding, 0.0f, 11, null);
                            Function2<Composer, Integer, Unit> function24 = function22;
                            int i8 = i5;
                            composer3.startReplaceableGroup(733328855);
                            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion3, false, composer3, 0, -1323940314);
                            Density density2 = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection2 = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default2);
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
                            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion4, composerM18018constructorimpl2, viewConfiguration2, composer3, composer3), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            composer3.startReplaceableGroup(-2137368960);
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            composer3.startReplaceableGroup(-1395522852);
                            function24.invoke(composer3, Integer.valueOf(i8 & 14));
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[_[androidx.compose.ui.UiComposable]:[_]]")
    /* JADX INFO: renamed from: trailingContent-iJQMabo, reason: not valid java name */
    public static final Function3<RowScope, Composer, Integer, Unit> m17216trailingContentiJQMabo(final Function2<? super Composer, ? super Integer, Unit> function2, final long j, final boolean z, Composer composer, final int i) {
        composer.startReplaceableGroup(2067138571);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2067138571, i, -1, "androidx.compose.material3.trailingContent (ListItem.kt:334)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -1301939978, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$trailingContent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                invoke(rowScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@NotNull RowScope rowScope, @Nullable Composer composer2, int i2) {
                int i4;
                Intrinsics.checkNotNullParameter(rowScope, "$this$null");
                if ((i2 & 14) == 0) {
                    i4 = (composer2.changed(rowScope) ? 4 : 2) | i2;
                } else {
                    i4 = i2;
                }
                if ((i4 & 91) == 18 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1301939978, i2, -1, "androidx.compose.material3.trailingContent.<anonymous> (ListItem.kt:339)");
                }
                if (z) {
                    composer2.startReplaceableGroup(1857837855);
                    Modifier modifierM15856paddingVpY3zN4$default = PaddingKt.m15856paddingVpY3zN4$default(Modifier.INSTANCE, ListItemKt.TrailingHorizontalPadding, 0.0f, 2, null);
                    Alignment topStart = Alignment.INSTANCE.getTopStart();
                    long j2 = j;
                    Function2<Composer, Integer, Unit> function22 = function2;
                    int i5 = i;
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topStart, false, composer2, 6);
                    Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                    LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15856paddingVpY3zN4$default);
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    composer2.disableReusing();
                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                    function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    composer2.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    composer2.startReplaceableGroup(-1890987531);
                    ListItemKt.m17210ProvideTextStyleFromToken3JVO9M(j2, ListTokens.INSTANCE.getListItemTrailingSupportingTextFont(), function22, composer2, ((i5 >> 3) & 14) | 48 | ((i5 << 6) & 896));
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(1857838233);
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    Alignment.Companion companion3 = Alignment.INSTANCE;
                    Modifier modifierM15856paddingVpY3zN4$default2 = PaddingKt.m15856paddingVpY3zN4$default(rowScope.align(companion2, companion3.getCenterVertically()), ListItemKt.TrailingHorizontalPadding, 0.0f, 2, null);
                    long j3 = j;
                    Function2<Composer, Integer, Unit> function23 = function2;
                    int i6 = i;
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion3, false, composer2, 0, -1323940314);
                    Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15856paddingVpY3zN4$default2);
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
                    Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                    function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion4, composerM18018constructorimpl2, viewConfiguration2, composer2, composer2), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    composer2.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    composer2.startReplaceableGroup(-471095028);
                    ListItemKt.m17210ProvideTextStyleFromToken3JVO9M(j3, ListTokens.INSTANCE.getListItemTrailingSupportingTextFont(), function23, composer2, ((i6 << 6) & 896) | ((i6 >> 3) & 14) | 48);
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }
}
