package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.ClipKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.Role;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.app.FrameMetricsAggregator;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import kotlin.Unit;
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
@Metadata(m13885d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u008e\u0001\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010 \u001aÄ\u0001\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020#2\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010%\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010&\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\t\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, m13886d2 = {"HorizontalPadding", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "LeadingIconEndSpacing", "LeadingIconStartSpacing", "SelectedIconContainerSize", "SelectedOverlayOpacity", "", "SurfaceOverlayOpacity", "TrailingIconSpacing", "Chip", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ChipColors;", "leadingIcon", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "selected", "Landroidx/compose/material/SelectableChipColors;", "selectedIcon", "trailingIcon", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/SelectableChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ChipKt {
    private static final float LeadingIconEndSpacing;
    private static final float SelectedOverlayOpacity = 0.16f;
    private static final float SurfaceOverlayOpacity = 0.12f;
    private static final float TrailingIconSpacing;
    private static final float HorizontalPadding = C2256Dp.m20968constructorimpl(12);
    private static final float LeadingIconStartSpacing = C2256Dp.m20968constructorimpl(4);
    private static final float SelectedIconContainerSize = C2256Dp.m20968constructorimpl(24);

    static {
        float f = 8;
        LeadingIconEndSpacing = C2256Dp.m20968constructorimpl(f);
        TrailingIconSpacing = C2256Dp.m20968constructorimpl(f);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0270 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0108  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Chip(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Shape shape, @Nullable BorderStroke borderStroke, @Nullable ChipColors chipColors, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @NotNull final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        Shape shapeCopy;
        int i7;
        BorderStroke borderStroke2;
        ChipColors chipColorsM16656chipColors5tl4gsc;
        int i8;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function22;
        final Shape shape2;
        final BorderStroke borderStroke3;
        final ChipColors chipColors2;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final boolean z3;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-368396408);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i11 = i2 & 2;
        if (i11 != 0) {
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
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 7168) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 2048 : 1024;
                    }
                    if ((57344 & i) != 0) {
                        if ((i2 & 16) == 0) {
                            shapeCopy = shape;
                            int i12 = composerStartRestartGroup.changed(shapeCopy) ? 16384 : 8192;
                            i4 |= i12;
                        } else {
                            shapeCopy = shape;
                        }
                        i4 |= i12;
                    } else {
                        shapeCopy = shape;
                    }
                    i7 = i2 & 32;
                    if (i7 == 0) {
                        i4 |= 196608;
                    } else {
                        if ((458752 & i) == 0) {
                            borderStroke2 = borderStroke;
                            i4 |= composerStartRestartGroup.changed(borderStroke2) ? 131072 : 65536;
                        }
                        if ((i & 3670016) == 0) {
                            chipColorsM16656chipColors5tl4gsc = chipColors;
                            i4 |= ((i2 & 64) == 0 && composerStartRestartGroup.changed(chipColorsM16656chipColors5tl4gsc)) ? 1048576 : 524288;
                        } else {
                            chipColorsM16656chipColors5tl4gsc = chipColors;
                        }
                        i8 = i2 & 128;
                        if (i8 != 0) {
                            i4 |= 12582912;
                            i9 = i8;
                        } else {
                            i9 = i8;
                            if ((i & 29360128) == 0) {
                                i4 |= composerStartRestartGroup.changed(function2) ? 8388608 : 4194304;
                            }
                        }
                        if ((i2 & 256) == 0) {
                            i10 = (i & 234881024) == 0 ? composerStartRestartGroup.changed(content) ? 67108864 : 33554432 : 100663296;
                            if ((191739611 & i4) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i11 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i5 != 0) {
                                        z2 = true;
                                    }
                                    if (i6 != 0) {
                                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        composerStartRestartGroup.endReplaceableGroup();
                                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i4 &= -57345;
                                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    }
                                    if (i7 != 0) {
                                        borderStroke2 = null;
                                    }
                                    if ((i2 & 64) != 0) {
                                        chipColorsM16656chipColors5tl4gsc = ChipDefaults.INSTANCE.m16656chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                        i4 &= -3670017;
                                    }
                                    if (i9 == 0) {
                                        function22 = null;
                                    }
                                    final ChipColors chipColors3 = chipColorsM16656chipColors5tl4gsc;
                                    final int i13 = i4;
                                    final boolean z4 = z2;
                                    Shape shape3 = shapeCopy;
                                    BorderStroke borderStroke4 = borderStroke2;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-368396408, i13, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                                    }
                                    int i14 = ((i13 >> 6) & 14) | ((i13 >> 15) & 112);
                                    final State<Color> stateContentColor = chipColors3.contentColor(z4, composerStartRestartGroup, i14);
                                    final Function2<? super Composer, ? super Integer, Unit> function24 = function22;
                                    Modifier modifier4 = modifier2;
                                    SurfaceKt.m16873SurfaceLPr_se0(onClick, modifier4, z4, shape3, chipColors3.backgroundColor(z4, composerStartRestartGroup, i14).getValue().m18535unboximpl(), Color.m18524copywmQWz5c$default(m16664Chip$lambda1(stateContentColor), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke4, 0.0f, mutableInteractionSource2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.2
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
                                        public final void invoke(@Nullable Composer composer2, int i15) {
                                            if ((i15 & 11) == 2 && composer2.getSkipping()) {
                                                composer2.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(139076687, i15, -1, "androidx.compose.material.Chip.<anonymous> (Chip.kt:108)");
                                            }
                                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m18527getAlphaimpl(ChipKt.m16664Chip$lambda1(stateContentColor))))};
                                            final Function2<Composer, Integer, Unit> function25 = function24;
                                            final ChipColors chipColors4 = chipColors3;
                                            final boolean z5 = z4;
                                            final int i16 = i13;
                                            final Function3<RowScope, Composer, Integer, Unit> function3 = content;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 667535631, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.2.1
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
                                                public final void invoke(@Nullable Composer composer3, int i17) {
                                                    if ((i17 & 11) == 2 && composer3.getSkipping()) {
                                                        composer3.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(667535631, i17, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous> (Chip.kt:109)");
                                                    }
                                                    TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer3, 6).getBody2();
                                                    final Function2<Composer, Integer, Unit> function26 = function25;
                                                    final ChipColors chipColors5 = chipColors4;
                                                    final boolean z6 = z5;
                                                    final int i18 = i16;
                                                    final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                                    TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer3, -1131213696, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.2.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        /* JADX INFO: renamed from: invoke$lambda-1$lambda-0, reason: not valid java name */
                                                        private static final long m16666invoke$lambda1$lambda0(State<Color> state) {
                                                            return state.getValue().m18535unboximpl();
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
                                                                ComposerKt.traceEventStart(-1131213696, i19, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:112)");
                                                            }
                                                            Modifier.Companion companion = Modifier.INSTANCE;
                                                            Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.m15884defaultMinSizeVpY3zN4$default(companion, 0.0f, ChipDefaults.INSTANCE.m16659getMinHeightD9Ej5fM(), 1, null), function26 == null ? ChipKt.HorizontalPadding : C2256Dp.m20968constructorimpl(0), 0.0f, ChipKt.HorizontalPadding, 0.0f, 10, null);
                                                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                            Function2<Composer, Integer, Unit> function27 = function26;
                                                            ChipColors chipColors6 = chipColors5;
                                                            boolean z7 = z6;
                                                            int i20 = i18;
                                                            Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                                            composer4.startReplaceableGroup(693286680);
                                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer4, 54);
                                                            Density density = (Density) AbstractC1038a.m1211l(composer4, -1323940314);
                                                            LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                                            Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
                                                            if (composer4.getApplier() == null) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer4.startReusableNode();
                                                            if (composer4.getInserting()) {
                                                                composer4.createNode(constructor);
                                                            } else {
                                                                composer4.useNode();
                                                            }
                                                            composer4.disableReusing();
                                                            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer4);
                                                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                                                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                                            composer4.startReplaceableGroup(-678309503);
                                                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                                            composer4.startReplaceableGroup(951468004);
                                                            composer4.startReplaceableGroup(2084788874);
                                                            if (function27 != null) {
                                                                SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, ChipKt.LeadingIconStartSpacing), composer4, 6);
                                                                State<Color> stateLeadingIconContentColor = chipColors6.leadingIconContentColor(z7, composer4, ((i20 >> 6) & 14) | ((i20 >> 15) & 112));
                                                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(m16666invoke$lambda1$lambda0(stateLeadingIconContentColor))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m18527getAlphaimpl(m16666invoke$lambda1$lambda0(stateLeadingIconContentColor))))}, function27, composer4, ((i20 >> 18) & 112) | 8);
                                                                SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, ChipKt.LeadingIconEndSpacing), composer4, 6);
                                                            }
                                                            composer4.endReplaceableGroup();
                                                            function33.invoke(rowScopeInstance, composer4, Integer.valueOf(((i20 >> 21) & 112) | 6));
                                                            composer4.endReplaceableGroup();
                                                            composer4.endReplaceableGroup();
                                                            composer4.endReplaceableGroup();
                                                            composer4.endNode();
                                                            composer4.endReplaceableGroup();
                                                            composer4.endReplaceableGroup();
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }), composer3, 48);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }), composer2, 56);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composerStartRestartGroup, ((i13 << 15) & 234881024) | (i13 & 14) | DriveFile.MODE_READ_WRITE | (i13 & 112) | (i13 & 896) | ((i13 >> 3) & 7168) | ((i13 << 3) & 3670016), 128);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    shape2 = shape3;
                                    borderStroke3 = borderStroke4;
                                    chipColors2 = chipColors3;
                                    function23 = function24;
                                    z3 = z4;
                                    modifier3 = modifier4;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 16) != 0) {
                                        i4 &= -57345;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i4 &= -3670017;
                                    }
                                }
                                function22 = function2;
                                final ChipColors chipColors32 = chipColorsM16656chipColors5tl4gsc;
                                final int i132 = i4;
                                final boolean z42 = z2;
                                Shape shape32 = shapeCopy;
                                BorderStroke borderStroke42 = borderStroke2;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i142 = ((i132 >> 6) & 14) | ((i132 >> 15) & 112);
                                final State<Color> stateContentColor2 = chipColors32.contentColor(z42, composerStartRestartGroup, i142);
                                final Function2<? super Composer, ? super Integer, Unit> function242 = function22;
                                Modifier modifier42 = modifier2;
                                SurfaceKt.m16873SurfaceLPr_se0(onClick, modifier42, z42, shape32, chipColors32.backgroundColor(z42, composerStartRestartGroup, i142).getValue().m18535unboximpl(), Color.m18524copywmQWz5c$default(m16664Chip$lambda1(stateContentColor2), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke42, 0.0f, mutableInteractionSource2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.2
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
                                    public final void invoke(@Nullable Composer composer2, int i15) {
                                        if ((i15 & 11) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(139076687, i15, -1, "androidx.compose.material.Chip.<anonymous> (Chip.kt:108)");
                                        }
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m18527getAlphaimpl(ChipKt.m16664Chip$lambda1(stateContentColor2))))};
                                        final Function2<? super Composer, ? super Integer, Unit> function25 = function242;
                                        final ChipColors chipColors4 = chipColors32;
                                        final boolean z5 = z42;
                                        final int i16 = i132;
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 667535631, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.2.1
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
                                            public final void invoke(@Nullable Composer composer3, int i17) {
                                                if ((i17 & 11) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(667535631, i17, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous> (Chip.kt:109)");
                                                }
                                                TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer3, 6).getBody2();
                                                final Function2<? super Composer, ? super Integer, Unit> function26 = function25;
                                                final ChipColors chipColors5 = chipColors4;
                                                final boolean z6 = z5;
                                                final int i18 = i16;
                                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                                TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer3, -1131213696, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    /* JADX INFO: renamed from: invoke$lambda-1$lambda-0, reason: not valid java name */
                                                    private static final long m16666invoke$lambda1$lambda0(State<Color> state) {
                                                        return state.getValue().m18535unboximpl();
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
                                                            ComposerKt.traceEventStart(-1131213696, i19, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:112)");
                                                        }
                                                        Modifier.Companion companion = Modifier.INSTANCE;
                                                        Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.m15884defaultMinSizeVpY3zN4$default(companion, 0.0f, ChipDefaults.INSTANCE.m16659getMinHeightD9Ej5fM(), 1, null), function26 == null ? ChipKt.HorizontalPadding : C2256Dp.m20968constructorimpl(0), 0.0f, ChipKt.HorizontalPadding, 0.0f, 10, null);
                                                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function2<Composer, Integer, Unit> function27 = function26;
                                                        ChipColors chipColors6 = chipColors5;
                                                        boolean z7 = z6;
                                                        int i20 = i18;
                                                        Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                                        composer4.startReplaceableGroup(693286680);
                                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer4, 54);
                                                        Density density = (Density) AbstractC1038a.m1211l(composer4, -1323940314);
                                                        LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
                                                        if (composer4.getApplier() == null) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer4.startReusableNode();
                                                        if (composer4.getInserting()) {
                                                            composer4.createNode(constructor);
                                                        } else {
                                                            composer4.useNode();
                                                        }
                                                        composer4.disableReusing();
                                                        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer4);
                                                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                                                        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                                        composer4.startReplaceableGroup(-678309503);
                                                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                                        composer4.startReplaceableGroup(951468004);
                                                        composer4.startReplaceableGroup(2084788874);
                                                        if (function27 != null) {
                                                            SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, ChipKt.LeadingIconStartSpacing), composer4, 6);
                                                            State<Color> stateLeadingIconContentColor = chipColors6.leadingIconContentColor(z7, composer4, ((i20 >> 6) & 14) | ((i20 >> 15) & 112));
                                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(m16666invoke$lambda1$lambda0(stateLeadingIconContentColor))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m18527getAlphaimpl(m16666invoke$lambda1$lambda0(stateLeadingIconContentColor))))}, function27, composer4, ((i20 >> 18) & 112) | 8);
                                                            SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, ChipKt.LeadingIconEndSpacing), composer4, 6);
                                                        }
                                                        composer4.endReplaceableGroup();
                                                        function33.invoke(rowScopeInstance, composer4, Integer.valueOf(((i20 >> 21) & 112) | 6));
                                                        composer4.endReplaceableGroup();
                                                        composer4.endReplaceableGroup();
                                                        composer4.endReplaceableGroup();
                                                        composer4.endNode();
                                                        composer4.endReplaceableGroup();
                                                        composer4.endReplaceableGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }), composer3, 48);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer2, 56);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composerStartRestartGroup, ((i132 << 15) & 234881024) | (i132 & 14) | DriveFile.MODE_READ_WRITE | (i132 & 112) | (i132 & 896) | ((i132 >> 3) & 7168) | ((i132 << 3) & 3670016), 128);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                shape2 = shape32;
                                borderStroke3 = borderStroke42;
                                chipColors2 = chipColors32;
                                function23 = function242;
                                z3 = z42;
                                modifier3 = modifier42;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                function23 = function2;
                                z3 = z2;
                                borderStroke3 = borderStroke2;
                                chipColors2 = chipColorsM16656chipColors5tl4gsc;
                                modifier3 = modifier2;
                                shape2 = shapeCopy;
                            }
                            final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.3
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

                                public final void invoke(@Nullable Composer composer2, int i15) {
                                    ChipKt.Chip(onClick, modifier3, z3, mutableInteractionSource3, shape2, borderStroke3, chipColors2, function23, content, composer2, i | 1, i2);
                                }
                            });
                            return;
                        }
                        i4 |= i10;
                        if ((191739611 & i4) == 38347922) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i11 != 0) {
                                }
                                if (i5 != 0) {
                                }
                                if (i6 != 0) {
                                }
                                if ((i2 & 16) != 0) {
                                }
                                if (i7 != 0) {
                                }
                                if ((i2 & 64) != 0) {
                                }
                                if (i9 == 0) {
                                    function22 = function2;
                                }
                                final ChipColors chipColors322 = chipColorsM16656chipColors5tl4gsc;
                                final int i1322 = i4;
                                final boolean z422 = z2;
                                Shape shape322 = shapeCopy;
                                BorderStroke borderStroke422 = borderStroke2;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i1422 = ((i1322 >> 6) & 14) | ((i1322 >> 15) & 112);
                                final State<Color> stateContentColor22 = chipColors322.contentColor(z422, composerStartRestartGroup, i1422);
                                final Function2<? super Composer, ? super Integer, Unit> function2422 = function22;
                                Modifier modifier422 = modifier2;
                                SurfaceKt.m16873SurfaceLPr_se0(onClick, modifier422, z422, shape322, chipColors322.backgroundColor(z422, composerStartRestartGroup, i1422).getValue().m18535unboximpl(), Color.m18524copywmQWz5c$default(m16664Chip$lambda1(stateContentColor22), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke422, 0.0f, mutableInteractionSource2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.2
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
                                    public final void invoke(@Nullable Composer composer2, int i15) {
                                        if ((i15 & 11) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(139076687, i15, -1, "androidx.compose.material.Chip.<anonymous> (Chip.kt:108)");
                                        }
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m18527getAlphaimpl(ChipKt.m16664Chip$lambda1(stateContentColor22))))};
                                        final Function2<? super Composer, ? super Integer, Unit> function25 = function2422;
                                        final ChipColors chipColors4 = chipColors322;
                                        final boolean z5 = z422;
                                        final int i16 = i1322;
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 667535631, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.2.1
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
                                            public final void invoke(@Nullable Composer composer3, int i17) {
                                                if ((i17 & 11) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(667535631, i17, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous> (Chip.kt:109)");
                                                }
                                                TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer3, 6).getBody2();
                                                final Function2<? super Composer, ? super Integer, Unit> function26 = function25;
                                                final ChipColors chipColors5 = chipColors4;
                                                final boolean z6 = z5;
                                                final int i18 = i16;
                                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                                TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer3, -1131213696, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    /* JADX INFO: renamed from: invoke$lambda-1$lambda-0, reason: not valid java name */
                                                    private static final long m16666invoke$lambda1$lambda0(State<Color> state) {
                                                        return state.getValue().m18535unboximpl();
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
                                                            ComposerKt.traceEventStart(-1131213696, i19, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:112)");
                                                        }
                                                        Modifier.Companion companion = Modifier.INSTANCE;
                                                        Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.m15884defaultMinSizeVpY3zN4$default(companion, 0.0f, ChipDefaults.INSTANCE.m16659getMinHeightD9Ej5fM(), 1, null), function26 == null ? ChipKt.HorizontalPadding : C2256Dp.m20968constructorimpl(0), 0.0f, ChipKt.HorizontalPadding, 0.0f, 10, null);
                                                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function2<Composer, Integer, Unit> function27 = function26;
                                                        ChipColors chipColors6 = chipColors5;
                                                        boolean z7 = z6;
                                                        int i20 = i18;
                                                        Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                                        composer4.startReplaceableGroup(693286680);
                                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer4, 54);
                                                        Density density = (Density) AbstractC1038a.m1211l(composer4, -1323940314);
                                                        LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
                                                        if (composer4.getApplier() == null) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer4.startReusableNode();
                                                        if (composer4.getInserting()) {
                                                            composer4.createNode(constructor);
                                                        } else {
                                                            composer4.useNode();
                                                        }
                                                        composer4.disableReusing();
                                                        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer4);
                                                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                                                        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                                        composer4.startReplaceableGroup(-678309503);
                                                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                                        composer4.startReplaceableGroup(951468004);
                                                        composer4.startReplaceableGroup(2084788874);
                                                        if (function27 != null) {
                                                            SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, ChipKt.LeadingIconStartSpacing), composer4, 6);
                                                            State<Color> stateLeadingIconContentColor = chipColors6.leadingIconContentColor(z7, composer4, ((i20 >> 6) & 14) | ((i20 >> 15) & 112));
                                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(m16666invoke$lambda1$lambda0(stateLeadingIconContentColor))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m18527getAlphaimpl(m16666invoke$lambda1$lambda0(stateLeadingIconContentColor))))}, function27, composer4, ((i20 >> 18) & 112) | 8);
                                                            SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, ChipKt.LeadingIconEndSpacing), composer4, 6);
                                                        }
                                                        composer4.endReplaceableGroup();
                                                        function33.invoke(rowScopeInstance, composer4, Integer.valueOf(((i20 >> 21) & 112) | 6));
                                                        composer4.endReplaceableGroup();
                                                        composer4.endReplaceableGroup();
                                                        composer4.endReplaceableGroup();
                                                        composer4.endNode();
                                                        composer4.endReplaceableGroup();
                                                        composer4.endReplaceableGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }), composer3, 48);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer2, 56);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composerStartRestartGroup, ((i1322 << 15) & 234881024) | (i1322 & 14) | DriveFile.MODE_READ_WRITE | (i1322 & 112) | (i1322 & 896) | ((i1322 >> 3) & 7168) | ((i1322 << 3) & 3670016), 128);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                shape2 = shape322;
                                borderStroke3 = borderStroke422;
                                chipColors2 = chipColors322;
                                function23 = function2422;
                                z3 = z422;
                                modifier3 = modifier422;
                            }
                        }
                        final MutableInteractionSource mutableInteractionSource32 = mutableInteractionSource2;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    borderStroke2 = borderStroke;
                    if ((i & 3670016) == 0) {
                    }
                    i8 = i2 & 128;
                    if (i8 != 0) {
                    }
                    if ((i2 & 256) == 0) {
                    }
                    i4 |= i10;
                    if ((191739611 & i4) == 38347922) {
                    }
                    final MutableInteractionSource mutableInteractionSource322 = mutableInteractionSource2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((57344 & i) != 0) {
                }
                i7 = i2 & 32;
                if (i7 == 0) {
                }
                borderStroke2 = borderStroke;
                if ((i & 3670016) == 0) {
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                }
                if ((i2 & 256) == 0) {
                }
                i4 |= i10;
                if ((191739611 & i4) == 38347922) {
                }
                final MutableInteractionSource mutableInteractionSource3222 = mutableInteractionSource2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((57344 & i) != 0) {
            }
            i7 = i2 & 32;
            if (i7 == 0) {
            }
            borderStroke2 = borderStroke;
            if ((i & 3670016) == 0) {
            }
            i8 = i2 & 128;
            if (i8 != 0) {
            }
            if ((i2 & 256) == 0) {
            }
            i4 |= i10;
            if ((191739611 & i4) == 38347922) {
            }
            final MutableInteractionSource mutableInteractionSource32222 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((57344 & i) != 0) {
        }
        i7 = i2 & 32;
        if (i7 == 0) {
        }
        borderStroke2 = borderStroke;
        if ((i & 3670016) == 0) {
        }
        i8 = i2 & 128;
        if (i8 != 0) {
        }
        if ((i2 & 256) == 0) {
        }
        i4 |= i10;
        if ((191739611 & i4) == 38347922) {
        }
        final MutableInteractionSource mutableInteractionSource322222 = mutableInteractionSource2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Chip$lambda-1, reason: not valid java name */
    public static final long m16664Chip$lambda1(State<Color> state) {
        return state.getValue().m18535unboximpl();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0369 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0121  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilterChip(final boolean z, @NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z2, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Shape shape, @Nullable BorderStroke borderStroke, @Nullable SelectableChipColors selectableChipColors, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @NotNull final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        int i7;
        Shape shapeCopy;
        int i8;
        BorderStroke borderStroke2;
        SelectableChipColors selectableChipColorsM16657filterChipColorsJ08w3E;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i14;
        final int i15;
        int i16;
        MutableInteractionSource mutableInteractionSource2;
        int i17;
        Composer composer2;
        int i18;
        int i19;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Modifier modifier3;
        Shape shape2;
        BorderStroke borderStroke3;
        final SelectableChipColors selectableChipColors2;
        MutableInteractionSource mutableInteractionSource3;
        final int i20;
        Function2<? super Composer, ? super Integer, Unit> function27;
        final boolean z3;
        Composer composer3;
        final Shape shape3;
        final BorderStroke borderStroke4;
        final MutableInteractionSource mutableInteractionSource4;
        final Modifier modifier4;
        final boolean z4;
        final SelectableChipColors selectableChipColors3;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1259208246);
        if ((i4 & 1) != 0) {
            i5 = i | 6;
        } else if ((i & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i5 = i;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(onClick) ? 32 : 16;
        }
        int i21 = i4 & 4;
        if (i21 != 0) {
            i5 |= 384;
        } else {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    i5 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else if ((i & 57344) == 0) {
                    i5 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 16384 : 8192;
                }
                if ((i & 458752) == 0) {
                    shapeCopy = shape;
                    i5 |= ((i4 & 32) == 0 && composerStartRestartGroup.changed(shapeCopy)) ? 131072 : 65536;
                } else {
                    shapeCopy = shape;
                }
                i8 = i4 & 64;
                if (i8 != 0) {
                    i5 |= 1572864;
                    borderStroke2 = borderStroke;
                } else {
                    borderStroke2 = borderStroke;
                    if ((i & 3670016) == 0) {
                        i5 |= composerStartRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                    }
                }
                if ((i & 29360128) == 0) {
                    if ((i4 & 128) == 0) {
                        selectableChipColorsM16657filterChipColorsJ08w3E = selectableChipColors;
                        int i22 = composerStartRestartGroup.changed(selectableChipColorsM16657filterChipColorsJ08w3E) ? 8388608 : 4194304;
                        i5 |= i22;
                    } else {
                        selectableChipColorsM16657filterChipColorsJ08w3E = selectableChipColors;
                    }
                    i5 |= i22;
                } else {
                    selectableChipColorsM16657filterChipColorsJ08w3E = selectableChipColors;
                }
                i9 = i4 & 256;
                if (i9 != 0) {
                    i5 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    i5 |= composerStartRestartGroup.changed(function2) ? 67108864 : 33554432;
                }
                i10 = i4 & 512;
                if (i10 == 0) {
                    if ((i & 1879048192) == 0) {
                        i11 = i10;
                        i5 |= composerStartRestartGroup.changed(function22) ? 536870912 : 268435456;
                    }
                    i12 = i4 & 1024;
                    if (i12 == 0) {
                        i14 = i2 | 6;
                        i13 = i12;
                        function24 = function23;
                    } else if ((i2 & 14) == 0) {
                        i13 = i12;
                        function24 = function23;
                        i14 = i2 | (composerStartRestartGroup.changed(function24) ? 4 : 2);
                    } else {
                        i13 = i12;
                        function24 = function23;
                        i14 = i2;
                    }
                    if ((i4 & 2048) == 0) {
                        i14 |= 48;
                    } else if ((i2 & 112) == 0) {
                        i14 |= composerStartRestartGroup.changed(content) ? 32 : 16;
                    }
                    i15 = i14;
                    i16 = i5;
                    if ((i16 & 1533916891) != 306783378 && (i15 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        z4 = z2;
                        composer3 = composerStartRestartGroup;
                        shape3 = shapeCopy;
                        borderStroke4 = borderStroke2;
                        selectableChipColors3 = selectableChipColorsM16657filterChipColorsJ08w3E;
                        modifier4 = modifier2;
                        function210 = function24;
                        mutableInteractionSource4 = mutableInteractionSource;
                        function28 = function2;
                        function29 = function22;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier5 = i21 == 0 ? Modifier.INSTANCE : modifier2;
                            boolean z5 = i6 == 0 ? true : z2;
                            if (i7 == 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i4 & 32) == 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i17 = i16 & (-458753);
                            } else {
                                i17 = i16;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i4 & 128) == 0) {
                                i19 = i13;
                                i18 = i11;
                                selectableChipColorsM16657filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m16657filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, DriveFile.MODE_READ_WRITE, FrameMetricsAggregator.EVERY_DURATION);
                                composer2 = composerStartRestartGroup;
                                i17 &= -29360129;
                            } else {
                                composer2 = composerStartRestartGroup;
                                i18 = i11;
                                i19 = i13;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function211 = i9 == 0 ? null : function2;
                            Modifier modifier6 = modifier5;
                            function25 = i18 == 0 ? null : function22;
                            function26 = function211;
                            modifier3 = modifier6;
                            shape2 = shapeCopy;
                            borderStroke3 = borderStroke2;
                            selectableChipColors2 = selectableChipColorsM16657filterChipColorsJ08w3E;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            i20 = i17;
                            function27 = i19 == 0 ? null : function23;
                            z3 = z5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            int i23 = (i4 & 32) != 0 ? i16 & (-458753) : i16;
                            if ((i4 & 128) != 0) {
                                i23 &= -29360129;
                            }
                            mutableInteractionSource3 = mutableInteractionSource;
                            composer2 = composerStartRestartGroup;
                            shape2 = shapeCopy;
                            borderStroke3 = borderStroke2;
                            selectableChipColors2 = selectableChipColorsM16657filterChipColorsJ08w3E;
                            function27 = function24;
                            z3 = z2;
                            function26 = function2;
                            modifier3 = modifier2;
                            i20 = i23;
                            function25 = function22;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1259208246, i20, i15, "androidx.compose.material.FilterChip (Chip.kt:183)");
                        }
                        int i24 = i20 << 3;
                        int i25 = ((i20 >> 9) & 14) | (i24 & 112) | ((i20 >> 15) & 896);
                        final State<Color> stateContentColor = selectableChipColors2.contentColor(z3, z, composer2, i25);
                        final Function2<? super Composer, ? super Integer, Unit> function212 = function26;
                        final Function2<? super Composer, ? super Integer, Unit> function213 = function25;
                        final Function2<? super Composer, ? super Integer, Unit> function214 = function27;
                        MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                        SelectableChipColors selectableChipColors4 = selectableChipColors2;
                        boolean z6 = z3;
                        Modifier modifier7 = modifier3;
                        Shape shape4 = shape2;
                        Composer composer4 = composer2;
                        BorderStroke borderStroke5 = borderStroke3;
                        SurfaceKt.m16874SurfaceNy5ogXk(z, onClick, SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                SemanticsPropertiesKt.m20285setRolekuIjeqM(semantics, Role.INSTANCE.m20267getCheckboxo7Vup1c());
                            }
                        }, 1, null), false, shape4, selectableChipColors2.backgroundColor(z3, z, composer2, i25).getValue().m18535unboximpl(), Color.m18524copywmQWz5c$default(stateContentColor.getValue().m18535unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke5, 0.0f, mutableInteractionSource5, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 722126431, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.3
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
                            public final void invoke(@Nullable Composer composer5, int i26) {
                                if ((i26 & 11) == 2 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(722126431, i26, -1, "androidx.compose.material.FilterChip.<anonymous> (Chip.kt:208)");
                                }
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m18527getAlphaimpl(stateContentColor.getValue().m18535unboximpl())))};
                                final Function2<Composer, Integer, Unit> function215 = function212;
                                final boolean z7 = z;
                                final Function2<Composer, Integer, Unit> function216 = function213;
                                final Function2<Composer, Integer, Unit> function217 = function214;
                                final Function3<RowScope, Composer, Integer, Unit> function3 = content;
                                final int i27 = i15;
                                final SelectableChipColors selectableChipColors5 = selectableChipColors2;
                                final boolean z8 = z3;
                                final int i28 = i20;
                                final State<Color> state = stateContentColor;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer5, 1582291359, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.3.1
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
                                    public final void invoke(@Nullable Composer composer6, int i29) {
                                        if ((i29 & 11) == 2 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1582291359, i29, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous> (Chip.kt:209)");
                                        }
                                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer6, 6).getBody2();
                                        final Function2<Composer, Integer, Unit> function218 = function215;
                                        final boolean z9 = z7;
                                        final Function2<Composer, Integer, Unit> function219 = function216;
                                        final Function2<Composer, Integer, Unit> function220 = function217;
                                        final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                        final int i30 = i27;
                                        final SelectableChipColors selectableChipColors6 = selectableChipColors5;
                                        final boolean z10 = z8;
                                        final int i31 = i28;
                                        final State<Color> state2 = state;
                                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer6, -1543702066, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.3.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                                                invoke(composer7, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                            @Composable
                                            public final void invoke(@Nullable Composer composer7, int i32) {
                                                RowScopeInstance rowScopeInstance;
                                                long jM18535unboximpl;
                                                Modifier modifierClip;
                                                if ((i32 & 11) == 2 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1543702066, i32, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:212)");
                                                }
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.m15884defaultMinSizeVpY3zN4$default(companion, 0.0f, ChipDefaults.INSTANCE.m16659getMinHeightD9Ej5fM(), 1, null), (function218 != null || (z9 && function219 != null)) ? C2256Dp.m20968constructorimpl(0) : ChipKt.HorizontalPadding, 0.0f, function220 == null ? ChipKt.HorizontalPadding : C2256Dp.m20968constructorimpl(0), 0.0f, 10, null);
                                                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                Alignment.Companion companion2 = Alignment.INSTANCE;
                                                Alignment.Vertical centerVertically = companion2.getCenterVertically();
                                                Function2<Composer, Integer, Unit> function221 = function218;
                                                boolean z11 = z9;
                                                Function2<Composer, Integer, Unit> function222 = function219;
                                                Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                                int i33 = i30;
                                                Function2<Composer, Integer, Unit> function223 = function220;
                                                SelectableChipColors selectableChipColors7 = selectableChipColors6;
                                                boolean z12 = z10;
                                                int i34 = i31;
                                                State<Color> state3 = state2;
                                                composer7.startReplaceableGroup(693286680);
                                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer7, 54);
                                                Density density = (Density) AbstractC1038a.m1211l(composer7, -1323940314);
                                                LayoutDirection layoutDirection = (LayoutDirection) composer7.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer7.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
                                                if (composer7.getApplier() == null) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer7.startReusableNode();
                                                if (composer7.getInserting()) {
                                                    composer7.createNode(constructor);
                                                } else {
                                                    composer7.useNode();
                                                }
                                                composer7.disableReusing();
                                                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer7);
                                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                                                function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer7, composer7), composer7, 0);
                                                composer7.startReplaceableGroup(2058660585);
                                                composer7.startReplaceableGroup(-678309503);
                                                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                                composer7.startReplaceableGroup(1218705642);
                                                composer7.startReplaceableGroup(-1943412137);
                                                int i35 = 6;
                                                if (function221 != null || (z11 && function222 != null)) {
                                                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, ChipKt.LeadingIconStartSpacing), composer7, 6);
                                                    composer7.startReplaceableGroup(733328855);
                                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer7, 0);
                                                    Density density2 = (Density) AbstractC1038a.m1211l(composer7, -1323940314);
                                                    LayoutDirection layoutDirection2 = (LayoutDirection) composer7.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer7.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                    Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                                    rowScopeInstance = rowScopeInstance2;
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(companion);
                                                    if (composer7.getApplier() == null) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer7.startReusableNode();
                                                    if (composer7.getInserting()) {
                                                        composer7.createNode(constructor2);
                                                    } else {
                                                        composer7.useNode();
                                                    }
                                                    composer7.disableReusing();
                                                    Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer7);
                                                    Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl2, density2));
                                                    function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composer7, composer7), composer7, 0);
                                                    composer7.startReplaceableGroup(2058660585);
                                                    composer7.startReplaceableGroup(-2137368960);
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    composer7.startReplaceableGroup(-626917591);
                                                    composer7.startReplaceableGroup(649985595);
                                                    if (function221 != null) {
                                                        State<Color> stateLeadingIconColor = selectableChipColors7.leadingIconColor(z12, z11, composer7, ((i34 >> 9) & 14) | ((i34 << 3) & 112) | ((i34 >> 15) & 896));
                                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(stateLeadingIconColor.getValue()), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m18527getAlphaimpl(stateLeadingIconColor.getValue().m18535unboximpl())))}, function221, composer7, ((i34 >> 21) & 112) | 8);
                                                    }
                                                    composer7.endReplaceableGroup();
                                                    composer7.startReplaceableGroup(-1943411323);
                                                    if (z11 && function222 != null) {
                                                        long jM18535unboximpl2 = state3.getValue().m18535unboximpl();
                                                        composer7.startReplaceableGroup(649986426);
                                                        if (function221 != null) {
                                                            modifierClip = ClipKt.clip(BackgroundKt.m15408backgroundbw27NRU(SizeKt.m15891requiredSize3ABfNKs(companion, ChipKt.SelectedIconContainerSize), state3.getValue().m18535unboximpl(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
                                                            jM18535unboximpl = selectableChipColors7.backgroundColor(z12, z11, composer7, ((i34 >> 9) & 14) | ((i34 << 3) & 112) | ((i34 >> 15) & 896)).getValue().m18535unboximpl();
                                                        } else {
                                                            jM18535unboximpl = jM18535unboximpl2;
                                                            modifierClip = companion;
                                                        }
                                                        composer7.endReplaceableGroup();
                                                        Alignment center = companion2.getCenter();
                                                        composer7.startReplaceableGroup(733328855);
                                                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, false, composer7, 6);
                                                        Density density3 = (Density) AbstractC1038a.m1211l(composer7, -1323940314);
                                                        LayoutDirection layoutDirection3 = (LayoutDirection) composer7.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                        ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer7.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                        Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierClip);
                                                        if (composer7.getApplier() == null) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer7.startReusableNode();
                                                        if (composer7.getInserting()) {
                                                            composer7.createNode(constructor3);
                                                        } else {
                                                            composer7.useNode();
                                                        }
                                                        composer7.disableReusing();
                                                        Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composer7);
                                                        Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, composerM18018constructorimpl3, density3));
                                                        function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl3, viewConfiguration3, composer7, composer7), composer7, 0);
                                                        composer7.startReplaceableGroup(2058660585);
                                                        composer7.startReplaceableGroup(-2137368960);
                                                        composer7.startReplaceableGroup(-370889391);
                                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(jM18535unboximpl))}, function222, composer7, ((i34 >> 24) & 112) | 8);
                                                        composer7.endReplaceableGroup();
                                                        composer7.endReplaceableGroup();
                                                        composer7.endReplaceableGroup();
                                                        composer7.endNode();
                                                        composer7.endReplaceableGroup();
                                                        composer7.endReplaceableGroup();
                                                    }
                                                    composer7.endReplaceableGroup();
                                                    composer7.endReplaceableGroup();
                                                    composer7.endReplaceableGroup();
                                                    composer7.endReplaceableGroup();
                                                    composer7.endNode();
                                                    composer7.endReplaceableGroup();
                                                    composer7.endReplaceableGroup();
                                                    i35 = 6;
                                                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, ChipKt.LeadingIconEndSpacing), composer7, 6);
                                                } else {
                                                    rowScopeInstance = rowScopeInstance2;
                                                }
                                                composer7.endReplaceableGroup();
                                                function33.invoke(rowScopeInstance, composer7, Integer.valueOf((i33 & 112) | i35));
                                                if (function223 != null) {
                                                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, ChipKt.TrailingIconSpacing), composer7, i35);
                                                    function223.invoke(composer7, Integer.valueOf(i33 & 14));
                                                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, ChipKt.TrailingIconSpacing), composer7, i35);
                                                }
                                                if (AbstractC1038a.m1225z(composer7)) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer6, 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer5, 56);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer4, (i20 & 126) | ((i20 >> 3) & 57344) | (i24 & 29360128) | ((i20 << 15) & 1879048192), 6, 264);
                        composer3 = composer4;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape3 = shape4;
                        borderStroke4 = borderStroke5;
                        mutableInteractionSource4 = mutableInteractionSource5;
                        modifier4 = modifier7;
                        z4 = z6;
                        selectableChipColors3 = selectableChipColors4;
                        function28 = function212;
                        function29 = function213;
                        function210 = function214;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.4
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

                        public final void invoke(@Nullable Composer composer5, int i26) {
                            ChipKt.FilterChip(z, onClick, modifier4, z4, mutableInteractionSource4, shape3, borderStroke4, selectableChipColors3, function28, function29, function210, content, composer5, i | 1, i2, i4);
                        }
                    });
                    return;
                }
                i5 |= DriveFile.MODE_READ_WRITE;
                i11 = i10;
                i12 = i4 & 1024;
                if (i12 == 0) {
                }
                if ((i4 & 2048) == 0) {
                }
                i15 = i14;
                i16 = i5;
                if ((i16 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i21 == 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if ((i4 & 32) == 0) {
                        }
                        if (i8 != 0) {
                        }
                        if ((i4 & 128) == 0) {
                        }
                        if (i9 == 0) {
                        }
                        Modifier modifier62 = modifier5;
                        function25 = i18 == 0 ? null : function22;
                        function26 = function211;
                        modifier3 = modifier62;
                        shape2 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        selectableChipColors2 = selectableChipColorsM16657filterChipColorsJ08w3E;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        i20 = i17;
                        if (i19 == 0) {
                        }
                        z3 = z5;
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i242 = i20 << 3;
                        int i252 = ((i20 >> 9) & 14) | (i242 & 112) | ((i20 >> 15) & 896);
                        final State<Color> stateContentColor2 = selectableChipColors2.contentColor(z3, z, composer2, i252);
                        final Function2<? super Composer, ? super Integer, Unit> function2122 = function26;
                        final Function2<? super Composer, ? super Integer, Unit> function2132 = function25;
                        final Function2<? super Composer, ? super Integer, Unit> function2142 = function27;
                        MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
                        SelectableChipColors selectableChipColors42 = selectableChipColors2;
                        boolean z62 = z3;
                        Modifier modifier72 = modifier3;
                        Shape shape42 = shape2;
                        Composer composer42 = composer2;
                        BorderStroke borderStroke52 = borderStroke3;
                        SurfaceKt.m16874SurfaceNy5ogXk(z, onClick, SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                SemanticsPropertiesKt.m20285setRolekuIjeqM(semantics, Role.INSTANCE.m20267getCheckboxo7Vup1c());
                            }
                        }, 1, null), false, shape42, selectableChipColors2.backgroundColor(z3, z, composer2, i252).getValue().m18535unboximpl(), Color.m18524copywmQWz5c$default(stateContentColor2.getValue().m18535unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke52, 0.0f, mutableInteractionSource52, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 722126431, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.3
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
                            public final void invoke(@Nullable Composer composer5, int i26) {
                                if ((i26 & 11) == 2 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(722126431, i26, -1, "androidx.compose.material.FilterChip.<anonymous> (Chip.kt:208)");
                                }
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m18527getAlphaimpl(stateContentColor2.getValue().m18535unboximpl())))};
                                final Function2<? super Composer, ? super Integer, Unit> function215 = function2122;
                                final boolean z7 = z;
                                final Function2<? super Composer, ? super Integer, Unit> function216 = function2132;
                                final Function2<? super Composer, ? super Integer, Unit> function217 = function2142;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final int i27 = i15;
                                final SelectableChipColors selectableChipColors5 = selectableChipColors2;
                                final boolean z8 = z3;
                                final int i28 = i20;
                                final State<Color> state = stateContentColor2;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer5, 1582291359, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.3.1
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
                                    public final void invoke(@Nullable Composer composer6, int i29) {
                                        if ((i29 & 11) == 2 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1582291359, i29, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous> (Chip.kt:209)");
                                        }
                                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer6, 6).getBody2();
                                        final Function2<? super Composer, ? super Integer, Unit> function218 = function215;
                                        final boolean z9 = z7;
                                        final Function2<? super Composer, ? super Integer, Unit> function219 = function216;
                                        final Function2<? super Composer, ? super Integer, Unit> function220 = function217;
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                        final int i30 = i27;
                                        final SelectableChipColors selectableChipColors6 = selectableChipColors5;
                                        final boolean z10 = z8;
                                        final int i31 = i28;
                                        final State<Color> state2 = state;
                                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer6, -1543702066, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.3.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                                                invoke(composer7, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                            @Composable
                                            public final void invoke(@Nullable Composer composer7, int i32) {
                                                RowScopeInstance rowScopeInstance;
                                                long jM18535unboximpl;
                                                Modifier modifierClip;
                                                if ((i32 & 11) == 2 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1543702066, i32, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:212)");
                                                }
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.m15884defaultMinSizeVpY3zN4$default(companion, 0.0f, ChipDefaults.INSTANCE.m16659getMinHeightD9Ej5fM(), 1, null), (function218 != null || (z9 && function219 != null)) ? C2256Dp.m20968constructorimpl(0) : ChipKt.HorizontalPadding, 0.0f, function220 == null ? ChipKt.HorizontalPadding : C2256Dp.m20968constructorimpl(0), 0.0f, 10, null);
                                                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                Alignment.Companion companion2 = Alignment.INSTANCE;
                                                Alignment.Vertical centerVertically = companion2.getCenterVertically();
                                                Function2<Composer, Integer, Unit> function221 = function218;
                                                boolean z11 = z9;
                                                Function2<Composer, Integer, Unit> function222 = function219;
                                                Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                                int i33 = i30;
                                                Function2<Composer, Integer, Unit> function223 = function220;
                                                SelectableChipColors selectableChipColors7 = selectableChipColors6;
                                                boolean z12 = z10;
                                                int i34 = i31;
                                                State<Color> state3 = state2;
                                                composer7.startReplaceableGroup(693286680);
                                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer7, 54);
                                                Density density = (Density) AbstractC1038a.m1211l(composer7, -1323940314);
                                                LayoutDirection layoutDirection = (LayoutDirection) composer7.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer7.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
                                                if (composer7.getApplier() == null) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer7.startReusableNode();
                                                if (composer7.getInserting()) {
                                                    composer7.createNode(constructor);
                                                } else {
                                                    composer7.useNode();
                                                }
                                                composer7.disableReusing();
                                                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer7);
                                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                                                function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer7, composer7), composer7, 0);
                                                composer7.startReplaceableGroup(2058660585);
                                                composer7.startReplaceableGroup(-678309503);
                                                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                                composer7.startReplaceableGroup(1218705642);
                                                composer7.startReplaceableGroup(-1943412137);
                                                int i35 = 6;
                                                if (function221 != null || (z11 && function222 != null)) {
                                                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, ChipKt.LeadingIconStartSpacing), composer7, 6);
                                                    composer7.startReplaceableGroup(733328855);
                                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer7, 0);
                                                    Density density2 = (Density) AbstractC1038a.m1211l(composer7, -1323940314);
                                                    LayoutDirection layoutDirection2 = (LayoutDirection) composer7.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer7.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                    Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                                    rowScopeInstance = rowScopeInstance2;
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(companion);
                                                    if (composer7.getApplier() == null) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer7.startReusableNode();
                                                    if (composer7.getInserting()) {
                                                        composer7.createNode(constructor2);
                                                    } else {
                                                        composer7.useNode();
                                                    }
                                                    composer7.disableReusing();
                                                    Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer7);
                                                    Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl2, density2));
                                                    function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composer7, composer7), composer7, 0);
                                                    composer7.startReplaceableGroup(2058660585);
                                                    composer7.startReplaceableGroup(-2137368960);
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    composer7.startReplaceableGroup(-626917591);
                                                    composer7.startReplaceableGroup(649985595);
                                                    if (function221 != null) {
                                                        State<Color> stateLeadingIconColor = selectableChipColors7.leadingIconColor(z12, z11, composer7, ((i34 >> 9) & 14) | ((i34 << 3) & 112) | ((i34 >> 15) & 896));
                                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(stateLeadingIconColor.getValue()), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m18527getAlphaimpl(stateLeadingIconColor.getValue().m18535unboximpl())))}, function221, composer7, ((i34 >> 21) & 112) | 8);
                                                    }
                                                    composer7.endReplaceableGroup();
                                                    composer7.startReplaceableGroup(-1943411323);
                                                    if (z11 && function222 != null) {
                                                        long jM18535unboximpl2 = state3.getValue().m18535unboximpl();
                                                        composer7.startReplaceableGroup(649986426);
                                                        if (function221 != null) {
                                                            modifierClip = ClipKt.clip(BackgroundKt.m15408backgroundbw27NRU(SizeKt.m15891requiredSize3ABfNKs(companion, ChipKt.SelectedIconContainerSize), state3.getValue().m18535unboximpl(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
                                                            jM18535unboximpl = selectableChipColors7.backgroundColor(z12, z11, composer7, ((i34 >> 9) & 14) | ((i34 << 3) & 112) | ((i34 >> 15) & 896)).getValue().m18535unboximpl();
                                                        } else {
                                                            jM18535unboximpl = jM18535unboximpl2;
                                                            modifierClip = companion;
                                                        }
                                                        composer7.endReplaceableGroup();
                                                        Alignment center = companion2.getCenter();
                                                        composer7.startReplaceableGroup(733328855);
                                                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, false, composer7, 6);
                                                        Density density3 = (Density) AbstractC1038a.m1211l(composer7, -1323940314);
                                                        LayoutDirection layoutDirection3 = (LayoutDirection) composer7.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                        ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer7.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                        Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierClip);
                                                        if (composer7.getApplier() == null) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer7.startReusableNode();
                                                        if (composer7.getInserting()) {
                                                            composer7.createNode(constructor3);
                                                        } else {
                                                            composer7.useNode();
                                                        }
                                                        composer7.disableReusing();
                                                        Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composer7);
                                                        Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, composerM18018constructorimpl3, density3));
                                                        function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl3, viewConfiguration3, composer7, composer7), composer7, 0);
                                                        composer7.startReplaceableGroup(2058660585);
                                                        composer7.startReplaceableGroup(-2137368960);
                                                        composer7.startReplaceableGroup(-370889391);
                                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(jM18535unboximpl))}, function222, composer7, ((i34 >> 24) & 112) | 8);
                                                        composer7.endReplaceableGroup();
                                                        composer7.endReplaceableGroup();
                                                        composer7.endReplaceableGroup();
                                                        composer7.endNode();
                                                        composer7.endReplaceableGroup();
                                                        composer7.endReplaceableGroup();
                                                    }
                                                    composer7.endReplaceableGroup();
                                                    composer7.endReplaceableGroup();
                                                    composer7.endReplaceableGroup();
                                                    composer7.endReplaceableGroup();
                                                    composer7.endNode();
                                                    composer7.endReplaceableGroup();
                                                    composer7.endReplaceableGroup();
                                                    i35 = 6;
                                                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, ChipKt.LeadingIconEndSpacing), composer7, 6);
                                                } else {
                                                    rowScopeInstance = rowScopeInstance2;
                                                }
                                                composer7.endReplaceableGroup();
                                                function33.invoke(rowScopeInstance, composer7, Integer.valueOf((i33 & 112) | i35));
                                                if (function223 != null) {
                                                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, ChipKt.TrailingIconSpacing), composer7, i35);
                                                    function223.invoke(composer7, Integer.valueOf(i33 & 14));
                                                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, ChipKt.TrailingIconSpacing), composer7, i35);
                                                }
                                                if (AbstractC1038a.m1225z(composer7)) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer6, 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer5, 56);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer42, (i20 & 126) | ((i20 >> 3) & 57344) | (i242 & 29360128) | ((i20 << 15) & 1879048192), 6, 264);
                        composer3 = composer42;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        shape3 = shape42;
                        borderStroke4 = borderStroke52;
                        mutableInteractionSource4 = mutableInteractionSource52;
                        modifier4 = modifier72;
                        z4 = z62;
                        selectableChipColors3 = selectableChipColors42;
                        function28 = function2122;
                        function29 = function2132;
                        function210 = function2142;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            if ((i & 458752) == 0) {
            }
            i8 = i4 & 64;
            if (i8 != 0) {
            }
            if ((i & 29360128) == 0) {
            }
            i9 = i4 & 256;
            if (i9 != 0) {
            }
            i10 = i4 & 512;
            if (i10 == 0) {
            }
            i11 = i10;
            i12 = i4 & 1024;
            if (i12 == 0) {
            }
            if ((i4 & 2048) == 0) {
            }
            i15 = i14;
            i16 = i5;
            if ((i16 & 1533916891) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        if ((i & 458752) == 0) {
        }
        i8 = i4 & 64;
        if (i8 != 0) {
        }
        if ((i & 29360128) == 0) {
        }
        i9 = i4 & 256;
        if (i9 != 0) {
        }
        i10 = i4 & 512;
        if (i10 == 0) {
        }
        i11 = i10;
        i12 = i4 & 1024;
        if (i12 == 0) {
        }
        if ((i4 & 2048) == 0) {
        }
        i15 = i14;
        i16 = i5;
        if ((i16 & 1533916891) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
