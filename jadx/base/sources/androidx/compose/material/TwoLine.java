package androidx.compose.material;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J~\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010\u001eR\u0019\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0007\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\t\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\n\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\f\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\r\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000e\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000f\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0010\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0011\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0012\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, m13886d2 = {"Landroidx/compose/material/TwoLine;", "", "()V", "ContentLeftPadding", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "ContentRightPadding", "IconLeftPadding", "IconMinPaddedWidth", "IconVerticalPadding", "MinHeight", "MinHeightWithIcon", "OverlineBaselineOffset", "OverlineToPrimaryBaselineOffset", "PrimaryBaselineOffsetNoIcon", "PrimaryBaselineOffsetWithIcon", "PrimaryToSecondaryBaselineOffsetNoIcon", "PrimaryToSecondaryBaselineOffsetWithIcon", "TrailingRightPadding", "ListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "text", "secondaryText", "overlineText", "trailing", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
final class TwoLine {
    private static final float ContentLeftPadding;
    private static final float ContentRightPadding;
    private static final float IconLeftPadding;
    private static final float IconVerticalPadding;
    private static final float OverlineToPrimaryBaselineOffset;
    private static final float PrimaryToSecondaryBaselineOffsetNoIcon;
    private static final float PrimaryToSecondaryBaselineOffsetWithIcon;
    private static final float TrailingRightPadding;

    @NotNull
    public static final TwoLine INSTANCE = new TwoLine();
    private static final float MinHeight = C2256Dp.m20968constructorimpl(64);
    private static final float MinHeightWithIcon = C2256Dp.m20968constructorimpl(72);
    private static final float IconMinPaddedWidth = C2256Dp.m20968constructorimpl(40);
    private static final float OverlineBaselineOffset = C2256Dp.m20968constructorimpl(24);
    private static final float PrimaryBaselineOffsetNoIcon = C2256Dp.m20968constructorimpl(28);
    private static final float PrimaryBaselineOffsetWithIcon = C2256Dp.m20968constructorimpl(32);

    static {
        float f = 16;
        IconLeftPadding = C2256Dp.m20968constructorimpl(f);
        IconVerticalPadding = C2256Dp.m20968constructorimpl(f);
        ContentLeftPadding = C2256Dp.m20968constructorimpl(f);
        ContentRightPadding = C2256Dp.m20968constructorimpl(f);
        float f4 = 20;
        OverlineToPrimaryBaselineOffset = C2256Dp.m20968constructorimpl(f4);
        PrimaryToSecondaryBaselineOffsetNoIcon = C2256Dp.m20968constructorimpl(f4);
        PrimaryToSecondaryBaselineOffsetWithIcon = C2256Dp.m20968constructorimpl(f4);
        TrailingRightPadding = C2256Dp.m20968constructorimpl(f);
    }

    private TwoLine() {
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0309 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01b6  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void ListItem(@Nullable Modifier modifier, @Nullable final Function2<? super Composer, ? super Integer, Unit> function2, @NotNull final Function2<? super Composer, ? super Integer, Unit> text, @Nullable final Function2<? super Composer, ? super Integer, Unit> function22, @Nullable final Function2<? super Composer, ? super Integer, Unit> function23, @Nullable final Function2<? super Composer, ? super Integer, Unit> function24, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        final int i4;
        Modifier modifier3;
        final float f;
        final int i5;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1340612993);
        int i7 = i2 & 1;
        if (i7 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(function2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(text) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(function22) ? 2048 : 1024;
        }
        if ((i2 & 16) != 0) {
            i4 |= 24576;
        } else if ((57344 & i) == 0) {
            i4 |= composerStartRestartGroup.changed(function23) ? 16384 : 8192;
        }
        if ((i2 & 32) == 0) {
            i6 = (458752 & i) == 0 ? composerStartRestartGroup.changed(function24) ? 131072 : 65536 : 196608;
            if ((i2 & 64) == 0) {
                i4 |= 1572864;
            } else if ((3670016 & i) == 0) {
                i4 |= composerStartRestartGroup.changed(this) ? 1048576 : 524288;
            }
            if ((2995931 & i4) == 599186 || !composerStartRestartGroup.getSkipping()) {
                Modifier modifier5 = i7 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1340612993, i4, -1, "androidx.compose.material.TwoLine.ListItem (ListItem.kt:196)");
                }
                float f4 = function2 != null ? MinHeight : MinHeightWithIcon;
                Modifier modifierM15887heightInVpY3zN4$default = SizeKt.m15887heightInVpY3zN4$default(modifier5, f4, 0.0f, 2, null);
                composerStartRestartGroup.startReplaceableGroup(693286680);
                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                Alignment.Companion companion = Alignment.INSTANCE;
                Modifier modifier6 = modifier5;
                MeasurePolicy measurePolicyM1208i = AbstractC1038a.m1208i(companion, start, composerStartRestartGroup, 0, -1323940314);
                Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                float f5 = f4;
                ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15887heightInVpY3zN4$default);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(constructor);
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1208i, composerM18018constructorimpl, density));
                function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-678309503);
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1912737507);
                Modifier.Companion companion3 = Modifier.INSTANCE;
                Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null), ContentLeftPadding, 0.0f, ContentRightPadding, 0.0f, 10, null);
                composerStartRestartGroup.startReplaceableGroup(-269995367);
                if (function2 == null) {
                    float f6 = IconLeftPadding;
                    Modifier modifierM15903sizeInqDBjuR0$default = SizeKt.m15903sizeInqDBjuR0$default(companion3, C2256Dp.m20968constructorimpl(f6 + IconMinPaddedWidth), f5, 0.0f, 0.0f, 12, null);
                    f = f5;
                    float f7 = IconVerticalPadding;
                    Modifier modifierM15858paddingqDBjuR0$default2 = PaddingKt.m15858paddingqDBjuR0$default(modifierM15903sizeInqDBjuR0$default, f6, f7, 0.0f, f7, 4, null);
                    Alignment topStart = companion.getTopStart();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topStart, false, composerStartRestartGroup, 6);
                    Density density2 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
                    LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    modifier3 = modifierM15858paddingqDBjuR0$default;
                    Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default2);
                    if (composerStartRestartGroup.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                    Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl2, density2));
                    function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1698757508);
                    AbstractC1038a.m1222w(composerStartRestartGroup, (i4 >> 3) & 14, function2);
                } else {
                    modifier3 = modifierM15858paddingqDBjuR0$default;
                    f = f5;
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (function23 == null) {
                    composerStartRestartGroup.startReplaceableGroup(-269994745);
                    i5 = i4;
                    ListItemKt.BaselinesOffsetColumn(CollectionsKt.listOf((Object[]) new C2256Dp[]{C2256Dp.m20966boximpl(OverlineBaselineOffset), C2256Dp.m20966boximpl(OverlineToPrimaryBaselineOffset)}), modifier3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1675021441, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TwoLine$ListItem$1$2
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
                                ComposerKt.traceEventStart(-1675021441, i8, -1, "androidx.compose.material.TwoLine.ListItem.<anonymous>.<anonymous> (ListItem.kt:229)");
                            }
                            function23.invoke(composer2, Integer.valueOf((i4 >> 12) & 14));
                            if (AbstractC1038a.m1196A(composer2, (i4 >> 6) & 14, text)) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composerStartRestartGroup, 384, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    i5 = i4;
                    Modifier modifier7 = modifier3;
                    composerStartRestartGroup.startReplaceableGroup(-269994465);
                    ListItemKt.BaselinesOffsetColumn(CollectionsKt.listOf((Object[]) new C2256Dp[]{C2256Dp.m20966boximpl(function2 != null ? PrimaryBaselineOffsetWithIcon : PrimaryBaselineOffsetNoIcon), C2256Dp.m20966boximpl(function2 != null ? PrimaryToSecondaryBaselineOffsetWithIcon : PrimaryToSecondaryBaselineOffsetNoIcon)}), modifier7, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 993836488, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TwoLine$ListItem$1$3
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
                                ComposerKt.traceEventStart(993836488, i8, -1, "androidx.compose.material.TwoLine.ListItem.<anonymous>.<anonymous> (ListItem.kt:248)");
                            }
                            text.invoke(composer2, Integer.valueOf((i5 >> 6) & 14));
                            Function2<Composer, Integer, Unit> function25 = function22;
                            Intrinsics.checkNotNull(function25);
                            function25.invoke(composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composerStartRestartGroup, 384, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (function24 != null) {
                    ListItemKt.m16776OffsetToBaselineOrCenterKz89ssw(function2 != null ? PrimaryBaselineOffsetWithIcon : PrimaryBaselineOffsetNoIcon, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1696992176, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TwoLine$ListItem$1$4
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
                                ComposerKt.traceEventStart(-1696992176, i8, -1, "androidx.compose.material.TwoLine.ListItem.<anonymous>.<anonymous> (ListItem.kt:260)");
                            }
                            Modifier modifierM15858paddingqDBjuR0$default3 = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.m15887heightInVpY3zN4$default(Modifier.INSTANCE, f, 0.0f, 2, null), 0.0f, 0.0f, TwoLine.TrailingRightPadding, 0.0f, 11, null);
                            Alignment center = Alignment.INSTANCE.getCenter();
                            Function2<Composer, Integer, Unit> function25 = function24;
                            int i9 = i5;
                            composer2.startReplaceableGroup(733328855);
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                            Density density3 = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                            LayoutDirection layoutDirection3 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default3);
                            if (composer2.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor3);
                            } else {
                                composer2.useNode();
                            }
                            composer2.disableReusing();
                            Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composer2);
                            Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, composerM18018constructorimpl3, density3));
                            AbstractC1038a.m1221v(0, function3MaterializerOf3, AbstractC1038a.m1206g(companion4, composerM18018constructorimpl3, viewConfiguration3, composer2, composer2), composer2, 2058660585);
                            composer2.startReplaceableGroup(-2137368960);
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(868648534);
                            if (AbstractC1038a.m1199D(composer2, (i9 >> 15) & 14, function25)) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composerStartRestartGroup, 384, 2);
                }
                if (AbstractC1038a.m1225z(composerStartRestartGroup)) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TwoLine.ListItem.2
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

                public final void invoke(@Nullable Composer composer2, int i8) {
                    TwoLine.this.ListItem(modifier4, function2, text, function22, function23, function24, composer2, i | 1, i2);
                }
            });
            return;
        }
        i4 |= i6;
        if ((i2 & 64) == 0) {
        }
        if ((2995931 & i4) == 599186) {
            if (i7 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (function2 != null) {
            }
            Modifier modifierM15887heightInVpY3zN4$default2 = SizeKt.m15887heightInVpY3zN4$default(modifier5, f4, 0.0f, 2, null);
            composerStartRestartGroup.startReplaceableGroup(693286680);
            Arrangement.Horizontal start2 = Arrangement.INSTANCE.getStart();
            Alignment.Companion companion4 = Alignment.INSTANCE;
            Modifier modifier62 = modifier5;
            MeasurePolicy measurePolicyM1208i2 = AbstractC1038a.m1208i(companion4, start2, composerStartRestartGroup, 0, -1323940314);
            Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            float f52 = f4;
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor3 = companion22.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierM15887heightInVpY3zN4$default2);
            if (composerStartRestartGroup.getApplier() == null) {
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion22, composerM18018constructorimpl3, measurePolicyM1208i2, composerM18018constructorimpl3, density3));
            function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion22, composerM18018constructorimpl3, viewConfiguration3, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-678309503);
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(1912737507);
            Modifier.Companion companion32 = Modifier.INSTANCE;
            Modifier modifierM15858paddingqDBjuR0$default3 = PaddingKt.m15858paddingqDBjuR0$default(RowScope.weight$default(rowScopeInstance2, companion32, 1.0f, false, 2, null), ContentLeftPadding, 0.0f, ContentRightPadding, 0.0f, 10, null);
            composerStartRestartGroup.startReplaceableGroup(-269995367);
            if (function2 == null) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (function23 == null) {
            }
            if (function24 != null) {
            }
            if (AbstractC1038a.m1225z(composerStartRestartGroup)) {
            }
            modifier4 = modifier62;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
