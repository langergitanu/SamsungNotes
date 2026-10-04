package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerSizeKt;
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
import com.google.android.gms.drive.DriveFile;
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
@Metadata(m13885d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0089\u0001\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001ar\u0010\u001a\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\nH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, m13886d2 = {"ExtendedFabIconPadding", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "ExtendedFabSize", "ExtendedFabTextPadding", "FabSize", "ExtendedFloatingActionButton", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "onClick", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "ExtendedFloatingActionButton-wqdebIU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Landroidx/compose/runtime/Composer;II)V", "FloatingActionButton", "content", "FloatingActionButton-bogVsAg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class FloatingActionButtonKt {
    private static final float FabSize = C2256Dp.m20968constructorimpl(56);
    private static final float ExtendedFabSize = C2256Dp.m20968constructorimpl(48);
    private static final float ExtendedFabIconPadding = C2256Dp.m20968constructorimpl(12);
    private static final float ExtendedFabTextPadding = C2256Dp.m20968constructorimpl(20);

    /* JADX WARN: Removed duplicated region for block: B:100:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011c  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ExtendedFloatingActionButton-wqdebIU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16770ExtendedFloatingActionButtonwqdebIU(@NotNull final Function2<? super Composer, ? super Integer, Unit> text, @NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Shape shape, long j, long j2, @Nullable FloatingActionButtonElevation floatingActionButtonElevation, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function22;
        int i6;
        Shape shape2;
        int i7;
        long j3;
        int i8;
        int i9;
        long jM16694contentColorForek8zF_U;
        FloatingActionButtonElevation floatingActionButtonElevationM16769elevationxZ9QkE;
        MutableInteractionSource mutableInteractionSource2;
        Shape shapeCopy;
        long jM16678getSecondary0d7_KjU;
        MutableInteractionSource mutableInteractionSource3;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        long j5;
        final int i10;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final Modifier modifier3;
        final long j6;
        final long j7;
        final Shape shape3;
        final MutableInteractionSource mutableInteractionSource4;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1555720195);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(onClick) ? 32 : 16;
        }
        int i11 = i2 & 4;
        if (i11 != 0) {
            i4 |= 384;
        } else {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    function22 = function2;
                    i4 |= composerStartRestartGroup.changed(function22) ? 2048 : 1024;
                }
                i6 = i2 & 16;
                if (i6 == 0) {
                    if ((i & 57344) == 0) {
                        i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 16384 : 8192;
                    }
                    if ((i & 458752) != 0) {
                        if ((i2 & 32) == 0) {
                            shape2 = shape;
                            int i12 = composerStartRestartGroup.changed(shape2) ? 131072 : 65536;
                            i4 |= i12;
                        } else {
                            shape2 = shape;
                        }
                        i4 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    if ((i & 3670016) != 0) {
                        i7 = 57344;
                        j3 = j;
                        i4 |= ((i2 & 64) == 0 && composerStartRestartGroup.changed(j3)) ? 1048576 : 524288;
                    } else {
                        i7 = 57344;
                        j3 = j;
                    }
                    if ((i & 29360128) != 0) {
                        i9 = 458752;
                        jM16694contentColorForek8zF_U = j2;
                        i8 = i4 | (((i2 & 128) == 0 && composerStartRestartGroup.changed(jM16694contentColorForek8zF_U)) ? 8388608 : 4194304);
                    } else {
                        i8 = i4;
                        i9 = 458752;
                        jM16694contentColorForek8zF_U = j2;
                    }
                    if ((i & 234881024) != 0) {
                        if ((i2 & 256) == 0) {
                            floatingActionButtonElevationM16769elevationxZ9QkE = floatingActionButtonElevation;
                            int i13 = composerStartRestartGroup.changed(floatingActionButtonElevationM16769elevationxZ9QkE) ? 67108864 : 33554432;
                            i8 |= i13;
                        } else {
                            floatingActionButtonElevationM16769elevationxZ9QkE = floatingActionButtonElevation;
                        }
                        i8 |= i13;
                    } else {
                        floatingActionButtonElevationM16769elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    if ((i8 & 191739611) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function22 = null;
                            }
                            if (i6 == 0) {
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
                            if ((i2 & 32) == 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i8 &= -458753;
                            } else {
                                shapeCopy = shape2;
                            }
                            if ((i2 & 64) == 0) {
                                jM16678getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m16678getSecondary0d7_KjU();
                                i8 &= -3670017;
                            } else {
                                jM16678getSecondary0d7_KjU = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(jM16678getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                                i8 &= -29360129;
                            }
                            if ((i2 & 256) == 0) {
                                floatingActionButtonElevationM16769elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m16769elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                                long j8 = jM16694contentColorForek8zF_U;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                function23 = function22;
                                i10 = i8 & (-234881025);
                                j5 = j8;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                                function23 = function22;
                                j5 = jM16694contentColorForek8zF_U;
                                i10 = i8;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i8 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i8 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i8 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i8 &= -234881025;
                            }
                            function23 = function22;
                            jM16678getSecondary0d7_KjU = j3;
                            shapeCopy = shape2;
                            j5 = jM16694contentColorForek8zF_U;
                            i10 = i8;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (!ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1555720195, i10, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:143)");
                        }
                        float f = ExtendedFabSize;
                        Modifier modifier4 = modifier2;
                        Modifier modifierM15903sizeInqDBjuR0$default = SizeKt.m15903sizeInqDBjuR0$default(modifier4, f, f, 0.0f, 0.0f, 12, null);
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                            public final void invoke(@Nullable Composer composer2, int i14) {
                                if ((i14 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1418981691, i14, -1, "androidx.compose.material.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:165)");
                                }
                                float f4 = function23 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding;
                                Modifier.Companion companion = Modifier.INSTANCE;
                                Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(companion, f4, 0.0f, FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 10, null);
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function2<Composer, Integer, Unit> function25 = function23;
                                int i15 = i10;
                                Function2<Composer, Integer, Unit> function26 = text;
                                composer2.startReplaceableGroup(693286680);
                                MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically, composer2, 48, -1323940314);
                                Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
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
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1207h, composerM18018constructorimpl, density));
                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                                composer2.startReplaceableGroup(-678309503);
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-388203689);
                                composer2.startReplaceableGroup(-1435223762);
                                if (function25 != null) {
                                    function25.invoke(composer2, Integer.valueOf((i15 >> 9) & 14));
                                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, FloatingActionButtonKt.ExtendedFabIconPadding), composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                if (AbstractC1038a.m1199D(composer2, i15 & 14, function26)) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        int i14 = ((i10 >> 3) & 14) | 12582912;
                        int i15 = i10 >> 6;
                        long j9 = jM16678getSecondary0d7_KjU;
                        long j10 = j5;
                        FloatingActionButtonElevation floatingActionButtonElevation3 = floatingActionButtonElevationM16769elevationxZ9QkE;
                        m16771FloatingActionButtonbogVsAg(onClick, modifierM15903sizeInqDBjuR0$default, mutableInteractionSource3, shapeCopy, j9, j10, floatingActionButtonElevation3, composableLambda, composerStartRestartGroup, (i15 & 3670016) | i14 | (i15 & 896) | (i15 & 7168) | (i15 & i7) | (i15 & i9), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        floatingActionButtonElevation2 = floatingActionButtonElevation3;
                        modifier3 = modifier4;
                        j6 = j10;
                        j7 = j9;
                        shape3 = shapeCopy;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        function24 = function23;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        function24 = function22;
                        j7 = j3;
                        j6 = jM16694contentColorForek8zF_U;
                        mutableInteractionSource4 = mutableInteractionSource;
                        modifier3 = modifier2;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM16769elevationxZ9QkE;
                        shape3 = shape2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$3
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

                        public final void invoke(@Nullable Composer composer2, int i16) {
                            FloatingActionButtonKt.m16770ExtendedFloatingActionButtonwqdebIU(text, onClick, modifier3, function24, mutableInteractionSource4, shape3, j7, j6, floatingActionButtonElevation2, composer2, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= 24576;
                if ((i & 458752) != 0) {
                }
                if ((i & 3670016) != 0) {
                }
                if ((i & 29360128) != 0) {
                }
                if ((i & 234881024) != 0) {
                }
                if ((i8 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) == 0) {
                        }
                        if ((i2 & 64) == 0) {
                        }
                        if ((i2 & 128) != 0) {
                        }
                        if ((i2 & 256) == 0) {
                        }
                        composerStartRestartGroup.endDefaults();
                        if (!ComposerKt.isTraceInProgress()) {
                        }
                        float f4 = ExtendedFabSize;
                        Modifier modifier42 = modifier2;
                        Modifier modifierM15903sizeInqDBjuR0$default2 = SizeKt.m15903sizeInqDBjuR0$default(modifier42, f4, f4, 0.0f, 0.0f, 12, null);
                        ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                            public final void invoke(@Nullable Composer composer2, int i142) {
                                if ((i142 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1418981691, i142, -1, "androidx.compose.material.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:165)");
                                }
                                float f42 = function23 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding;
                                Modifier.Companion companion = Modifier.INSTANCE;
                                Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(companion, f42, 0.0f, FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 10, null);
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function2<Composer, Integer, Unit> function25 = function23;
                                int i152 = i10;
                                Function2<Composer, Integer, Unit> function26 = text;
                                composer2.startReplaceableGroup(693286680);
                                MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically, composer2, 48, -1323940314);
                                Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
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
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1207h, composerM18018constructorimpl, density));
                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                                composer2.startReplaceableGroup(-678309503);
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-388203689);
                                composer2.startReplaceableGroup(-1435223762);
                                if (function25 != null) {
                                    function25.invoke(composer2, Integer.valueOf((i152 >> 9) & 14));
                                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, FloatingActionButtonKt.ExtendedFabIconPadding), composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                if (AbstractC1038a.m1199D(composer2, i152 & 14, function26)) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        int i142 = ((i10 >> 3) & 14) | 12582912;
                        int i152 = i10 >> 6;
                        long j92 = jM16678getSecondary0d7_KjU;
                        long j102 = j5;
                        FloatingActionButtonElevation floatingActionButtonElevation32 = floatingActionButtonElevationM16769elevationxZ9QkE;
                        m16771FloatingActionButtonbogVsAg(onClick, modifierM15903sizeInqDBjuR0$default2, mutableInteractionSource3, shapeCopy, j92, j102, floatingActionButtonElevation32, composableLambda2, composerStartRestartGroup, (i152 & 3670016) | i142 | (i152 & 896) | (i152 & 7168) | (i152 & i7) | (i152 & i9), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        floatingActionButtonElevation2 = floatingActionButtonElevation32;
                        modifier3 = modifier42;
                        j6 = j102;
                        j7 = j92;
                        shape3 = shapeCopy;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        function24 = function23;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function22 = function2;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            if ((i & 458752) != 0) {
            }
            if ((i & 3670016) != 0) {
            }
            if ((i & 29360128) != 0) {
            }
            if ((i & 234881024) != 0) {
            }
            if ((i8 & 191739611) == 38347922) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        function22 = function2;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        if ((i & 458752) != 0) {
        }
        if ((i & 3670016) != 0) {
        }
        if ((i & 29360128) != 0) {
        }
        if ((i & 234881024) != 0) {
        }
        if ((i8 & 191739611) == 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0248 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0117  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: FloatingActionButton-bogVsAg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16771FloatingActionButtonbogVsAg(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Shape shape, long j, long j2, @Nullable FloatingActionButtonElevation floatingActionButtonElevation, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Shape shapeCopy;
        long jM16678getSecondary0d7_KjU;
        int i6;
        int i7;
        long jM16694contentColorForek8zF_U;
        FloatingActionButtonElevation floatingActionButtonElevation2;
        FloatingActionButtonElevation floatingActionButtonElevationM16769elevationxZ9QkE;
        final Modifier modifier3;
        final long j3;
        final FloatingActionButtonElevation floatingActionButtonElevation3;
        final long j5;
        final Shape shape2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1028985328);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
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
                    mutableInteractionSource2 = mutableInteractionSource;
                    i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 256 : 128;
                }
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        shapeCopy = shape;
                        int i10 = composerStartRestartGroup.changed(shapeCopy) ? 2048 : 1024;
                        i4 |= i10;
                    } else {
                        shapeCopy = shape;
                    }
                    i4 |= i10;
                } else {
                    shapeCopy = shape;
                }
                if ((i & 57344) == 0) {
                    jM16678getSecondary0d7_KjU = j;
                    i4 |= ((i2 & 16) == 0 && composerStartRestartGroup.changed(jM16678getSecondary0d7_KjU)) ? 16384 : 8192;
                } else {
                    jM16678getSecondary0d7_KjU = j;
                }
                if ((i & 458752) == 0) {
                    i6 = 57344;
                    if ((i2 & 32) == 0) {
                        i7 = 458752;
                        jM16694contentColorForek8zF_U = j2;
                        int i11 = composerStartRestartGroup.changed(jM16694contentColorForek8zF_U) ? 131072 : 65536;
                        i4 |= i11;
                    } else {
                        i7 = 458752;
                        jM16694contentColorForek8zF_U = j2;
                    }
                    i4 |= i11;
                } else {
                    i6 = 57344;
                    i7 = 458752;
                    jM16694contentColorForek8zF_U = j2;
                }
                if ((i & 3670016) == 0) {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                    i4 |= ((i2 & 64) == 0 && composerStartRestartGroup.changed(floatingActionButtonElevation2)) ? 1048576 : 524288;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                if ((i2 & 128) == 0) {
                    i8 = (29360128 & i) == 0 ? composerStartRestartGroup.changed(content) ? 8388608 : 4194304 : 12582912;
                    if ((23967451 & i4) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if ((i2 & 8) != 0) {
                                i4 &= -7169;
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            }
                            if ((i2 & 16) != 0) {
                                jM16678getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m16678getSecondary0d7_KjU();
                                i4 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(jM16678getSecondary0d7_KjU, composerStartRestartGroup, (i4 >> 12) & 14);
                                i4 &= -458753;
                            }
                            if ((i2 & 64) == 0) {
                                floatingActionButtonElevationM16769elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m16769elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                                i4 &= -3670017;
                            }
                            Modifier modifier4 = modifier2;
                            Shape shape3 = shapeCopy;
                            final long j6 = jM16694contentColorForek8zF_U;
                            MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                            final int i12 = i4;
                            long j7 = jM16678getSecondary0d7_KjU;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1028985328, i12, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:78)");
                            }
                            float fM20982unboximpl = floatingActionButtonElevationM16769elevationxZ9QkE.elevation(mutableInteractionSource4, composerStartRestartGroup, ((i12 >> 6) & 14) | ((i12 >> 15) & 112)).getValue().m20982unboximpl();
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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
                                public final void invoke(@Nullable Composer composer2, int i13) {
                                    if ((i13 & 11) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1972871863, i13, -1, "androidx.compose.material.FloatingActionButton.<anonymous> (FloatingActionButton.kt:96)");
                                    }
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m18527getAlphaimpl(j6)))};
                                    final Function2<Composer, Integer, Unit> function2 = content;
                                    final int i14 = i12;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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
                                        public final void invoke(@Nullable Composer composer3, int i15) {
                                            if ((i15 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1867794295, i15, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:97)");
                                            }
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer3, 6).getButton();
                                            final Function2<Composer, Integer, Unit> function22 = function2;
                                            final int i16 = i14;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer3, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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
                                                public final void invoke(@Nullable Composer composer4, int i17) {
                                                    if ((i17 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1567914264, i17, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:98)");
                                                    }
                                                    Modifier modifierM15883defaultMinSizeVpY3zN4 = SizeKt.m15883defaultMinSizeVpY3zN4(Modifier.INSTANCE, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                                    Alignment center = Alignment.INSTANCE.getCenter();
                                                    Function2<Composer, Integer, Unit> function23 = function22;
                                                    int i18 = i16;
                                                    composer4.startReplaceableGroup(733328855);
                                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                                                    Density density = (Density) AbstractC1038a.m1211l(composer4, -1323940314);
                                                    LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15883defaultMinSizeVpY3zN4);
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
                                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                                    composer4.startReplaceableGroup(-2137368960);
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    composer4.startReplaceableGroup(-1049034642);
                                                    if (AbstractC1038a.m1199D(composer4, (i18 >> 21) & 14, function23)) {
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
                            });
                            int i13 = (i12 & 14) | DriveFile.MODE_READ_WRITE | (i12 & 112) | (i12 & 7168) | (i12 & i6) | (i12 & i7) | ((i12 << 18) & 234881024);
                            FloatingActionButtonElevation floatingActionButtonElevation4 = floatingActionButtonElevationM16769elevationxZ9QkE;
                            SurfaceKt.m16873SurfaceLPr_se0(onClick, modifier4, false, shape3, j7, j6, null, fM20982unboximpl, mutableInteractionSource4, composableLambda, composerStartRestartGroup, i13, 68);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            j3 = j6;
                            floatingActionButtonElevation3 = floatingActionButtonElevation4;
                            j5 = j7;
                            shape2 = shape3;
                            mutableInteractionSource3 = mutableInteractionSource4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i4 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i4 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i4 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i4 &= -3670017;
                            }
                        }
                        floatingActionButtonElevationM16769elevationxZ9QkE = floatingActionButtonElevation2;
                        Modifier modifier42 = modifier2;
                        Shape shape32 = shapeCopy;
                        final long j62 = jM16694contentColorForek8zF_U;
                        MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                        final int i122 = i4;
                        long j72 = jM16678getSecondary0d7_KjU;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        float fM20982unboximpl2 = floatingActionButtonElevationM16769elevationxZ9QkE.elevation(mutableInteractionSource42, composerStartRestartGroup, ((i122 >> 6) & 14) | ((i122 >> 15) & 112)).getValue().m20982unboximpl();
                        ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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
                            public final void invoke(@Nullable Composer composer2, int i132) {
                                if ((i132 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1972871863, i132, -1, "androidx.compose.material.FloatingActionButton.<anonymous> (FloatingActionButton.kt:96)");
                                }
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m18527getAlphaimpl(j62)))};
                                final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                                final int i14 = i122;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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
                                    public final void invoke(@Nullable Composer composer3, int i15) {
                                        if ((i15 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1867794295, i15, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:97)");
                                        }
                                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer3, 6).getButton();
                                        final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                                        final int i16 = i14;
                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer3, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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
                                            public final void invoke(@Nullable Composer composer4, int i17) {
                                                if ((i17 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1567914264, i17, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:98)");
                                                }
                                                Modifier modifierM15883defaultMinSizeVpY3zN4 = SizeKt.m15883defaultMinSizeVpY3zN4(Modifier.INSTANCE, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                                Alignment center = Alignment.INSTANCE.getCenter();
                                                Function2<Composer, Integer, Unit> function23 = function22;
                                                int i18 = i16;
                                                composer4.startReplaceableGroup(733328855);
                                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                                                Density density = (Density) AbstractC1038a.m1211l(composer4, -1323940314);
                                                LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15883defaultMinSizeVpY3zN4);
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
                                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                                composer4.startReplaceableGroup(-2137368960);
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                composer4.startReplaceableGroup(-1049034642);
                                                if (AbstractC1038a.m1199D(composer4, (i18 >> 21) & 14, function23)) {
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
                        });
                        int i132 = (i122 & 14) | DriveFile.MODE_READ_WRITE | (i122 & 112) | (i122 & 7168) | (i122 & i6) | (i122 & i7) | ((i122 << 18) & 234881024);
                        FloatingActionButtonElevation floatingActionButtonElevation42 = floatingActionButtonElevationM16769elevationxZ9QkE;
                        SurfaceKt.m16873SurfaceLPr_se0(onClick, modifier42, false, shape32, j72, j62, null, fM20982unboximpl2, mutableInteractionSource42, composableLambda2, composerStartRestartGroup, i132, 68);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier42;
                        j3 = j62;
                        floatingActionButtonElevation3 = floatingActionButtonElevation42;
                        j5 = j72;
                        shape2 = shape32;
                        mutableInteractionSource3 = mutableInteractionSource42;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        shape2 = shapeCopy;
                        j5 = jM16678getSecondary0d7_KjU;
                        floatingActionButtonElevation3 = floatingActionButtonElevation2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        j3 = jM16694contentColorForek8zF_U;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3
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

                        public final void invoke(@Nullable Composer composer2, int i14) {
                            FloatingActionButtonKt.m16771FloatingActionButtonbogVsAg(onClick, modifier3, mutableInteractionSource3, shape2, j5, j3, floatingActionButtonElevation3, content, composer2, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= i8;
                if ((23967451 & i4) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i2 & 8) != 0) {
                        }
                        if ((i2 & 16) != 0) {
                        }
                        if ((i2 & 32) != 0) {
                        }
                        if ((i2 & 64) == 0) {
                            floatingActionButtonElevationM16769elevationxZ9QkE = floatingActionButtonElevation2;
                        }
                        Modifier modifier422 = modifier2;
                        Shape shape322 = shapeCopy;
                        final long j622 = jM16694contentColorForek8zF_U;
                        MutableInteractionSource mutableInteractionSource422 = mutableInteractionSource2;
                        final int i1222 = i4;
                        long j722 = jM16678getSecondary0d7_KjU;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        float fM20982unboximpl22 = floatingActionButtonElevationM16769elevationxZ9QkE.elevation(mutableInteractionSource422, composerStartRestartGroup, ((i1222 >> 6) & 14) | ((i1222 >> 15) & 112)).getValue().m20982unboximpl();
                        ComposableLambda composableLambda22 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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
                            public final void invoke(@Nullable Composer composer2, int i1322) {
                                if ((i1322 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1972871863, i1322, -1, "androidx.compose.material.FloatingActionButton.<anonymous> (FloatingActionButton.kt:96)");
                                }
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m18527getAlphaimpl(j622)))};
                                final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                                final int i14 = i1222;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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
                                    public final void invoke(@Nullable Composer composer3, int i15) {
                                        if ((i15 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1867794295, i15, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:97)");
                                        }
                                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer3, 6).getButton();
                                        final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                                        final int i16 = i14;
                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer3, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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
                                            public final void invoke(@Nullable Composer composer4, int i17) {
                                                if ((i17 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1567914264, i17, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:98)");
                                                }
                                                Modifier modifierM15883defaultMinSizeVpY3zN4 = SizeKt.m15883defaultMinSizeVpY3zN4(Modifier.INSTANCE, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                                Alignment center = Alignment.INSTANCE.getCenter();
                                                Function2<Composer, Integer, Unit> function23 = function22;
                                                int i18 = i16;
                                                composer4.startReplaceableGroup(733328855);
                                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                                                Density density = (Density) AbstractC1038a.m1211l(composer4, -1323940314);
                                                LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15883defaultMinSizeVpY3zN4);
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
                                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                                composer4.startReplaceableGroup(-2137368960);
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                composer4.startReplaceableGroup(-1049034642);
                                                if (AbstractC1038a.m1199D(composer4, (i18 >> 21) & 14, function23)) {
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
                        });
                        int i1322 = (i1222 & 14) | DriveFile.MODE_READ_WRITE | (i1222 & 112) | (i1222 & 7168) | (i1222 & i6) | (i1222 & i7) | ((i1222 << 18) & 234881024);
                        FloatingActionButtonElevation floatingActionButtonElevation422 = floatingActionButtonElevationM16769elevationxZ9QkE;
                        SurfaceKt.m16873SurfaceLPr_se0(onClick, modifier422, false, shape322, j722, j622, null, fM20982unboximpl22, mutableInteractionSource422, composableLambda22, composerStartRestartGroup, i1322, 68);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier422;
                        j3 = j622;
                        floatingActionButtonElevation3 = floatingActionButtonElevation422;
                        j5 = j722;
                        shape2 = shape322;
                        mutableInteractionSource3 = mutableInteractionSource422;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 7168) == 0) {
            }
            if ((i & 57344) == 0) {
            }
            if ((i & 458752) == 0) {
            }
            if ((i & 3670016) == 0) {
            }
            if ((i2 & 128) == 0) {
            }
            i4 |= i8;
            if ((23967451 & i4) == 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i & 7168) == 0) {
        }
        if ((i & 57344) == 0) {
        }
        if ((i & 458752) == 0) {
        }
        if ((i & 3670016) == 0) {
        }
        if ((i2 & 128) == 0) {
        }
        i4 |= i8;
        if ((23967451 & i4) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
