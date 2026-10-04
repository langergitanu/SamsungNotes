package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
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
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0081\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a_\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0018\u001au\u0010\u0019\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001a\u001aS\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001b\u001a\u007f\u0010\u001c\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a]\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u001d"}, m13886d2 = {"Card", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/CardColors;", "elevation", "Landroidx/compose/material3/CardElevation;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ElevatedCard", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedCard", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class CardKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01f3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0133  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Card(@Nullable Modifier modifier, @Nullable Shape shape, @Nullable CardColors cardColors, @Nullable CardElevation cardElevation, @Nullable BorderStroke borderStroke, @NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        final int i4;
        Shape shape2;
        CardColors cardColorsM17018cardColorsro_MJ88;
        CardElevation cardElevation2;
        BorderStroke borderStroke2;
        Shape shape3;
        InteractionSource interactionSource;
        Composer composer2;
        CardElevation cardElevationM17019cardElevationaqJV_2Y;
        Modifier modifier3;
        CardElevation cardElevation3;
        BorderStroke borderStroke3;
        Shape shape4;
        final CardElevation cardElevation4;
        final CardColors cardColors2;
        final Modifier modifier4;
        final Shape shape5;
        final BorderStroke borderStroke4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i5;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1179621553);
        int i6 = i2 & 1;
        if (i6 != 0) {
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
                int i7 = composerStartRestartGroup.changed(shape2) ? 32 : 16;
                i4 |= i7;
            } else {
                shape2 = shape;
            }
            i4 |= i7;
        } else {
            shape2 = shape;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                cardColorsM17018cardColorsro_MJ88 = cardColors;
                int i8 = composerStartRestartGroup.changed(cardColorsM17018cardColorsro_MJ88) ? 256 : 128;
                i4 |= i8;
            } else {
                cardColorsM17018cardColorsro_MJ88 = cardColors;
            }
            i4 |= i8;
        } else {
            cardColorsM17018cardColorsro_MJ88 = cardColors;
        }
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                cardElevation2 = cardElevation;
                int i9 = composerStartRestartGroup.changed(cardElevation2) ? 2048 : 1024;
                i4 |= i9;
            } else {
                cardElevation2 = cardElevation;
            }
            i4 |= i9;
        } else {
            cardElevation2 = cardElevation;
        }
        int i10 = i2 & 16;
        if (i10 != 0) {
            i4 |= 24576;
        } else {
            if ((57344 & i) == 0) {
                borderStroke2 = borderStroke;
                i4 |= composerStartRestartGroup.changed(borderStroke2) ? 16384 : 8192;
            }
            if ((i2 & 32) != 0) {
                i5 = (458752 & i) == 0 ? composerStartRestartGroup.changed(content) ? 131072 : 65536 : 196608;
                if ((374491 & i4) == 74898 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier2;
                    shape5 = shape2;
                    cardColors2 = cardColorsM17018cardColorsro_MJ88;
                    cardElevation4 = cardElevation2;
                    borderStroke4 = borderStroke2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier modifier5 = i6 == 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 2) == 0) {
                            shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 4) == 0) {
                            interactionSource = null;
                            composer2 = composerStartRestartGroup;
                            cardColorsM17018cardColorsro_MJ88 = CardDefaults.INSTANCE.m17018cardColorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i4 &= -897;
                        } else {
                            interactionSource = null;
                            composer2 = composerStartRestartGroup;
                        }
                        if ((i2 & 8) == 0) {
                            composerStartRestartGroup = composer2;
                            cardElevationM17019cardElevationaqJV_2Y = CardDefaults.INSTANCE.m17019cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i4 &= -7169;
                        } else {
                            composerStartRestartGroup = composer2;
                            cardElevationM17019cardElevationaqJV_2Y = cardElevation;
                        }
                        CardElevation cardElevation5 = cardElevationM17019cardElevationaqJV_2Y;
                        modifier3 = modifier5;
                        cardElevation3 = cardElevation5;
                        if (i10 == 0) {
                            shape4 = shape3;
                            borderStroke3 = interactionSource;
                        } else {
                            borderStroke3 = borderStroke;
                            shape4 = shape3;
                        }
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
                        cardElevation3 = cardElevation2;
                        borderStroke3 = borderStroke2;
                        modifier3 = modifier2;
                        shape4 = shape2;
                        interactionSource = null;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1179621553, i4, -1, "androidx.compose.material3.Card (Card.kt:75)");
                    }
                    int i11 = i4 >> 3;
                    int i12 = (i11 & 112) | 6;
                    int i13 = (i11 & 896) | 54;
                    Composer composer3 = composerStartRestartGroup;
                    SurfaceKt.m17325SurfaceT9BRK9s(modifier3, shape4, cardColorsM17018cardColorsro_MJ88.containerColor$material3_release(true, composerStartRestartGroup, i12).getValue().m18535unboximpl(), cardColorsM17018cardColorsro_MJ88.contentColor$material3_release(true, composerStartRestartGroup, i12).getValue().m18535unboximpl(), cardElevation3.tonalElevation$material3_release(true, interactionSource, composerStartRestartGroup, i13).getValue().m20982unboximpl(), cardElevation3.shadowElevation$material3_release(true, interactionSource, composerStartRestartGroup, i13).getValue().m20982unboximpl(), borderStroke3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 664103990, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.Card.1
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
                        public final void invoke(@Nullable Composer composer4, int i14) {
                            if ((i14 & 11) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(664103990, i14, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:91)");
                            }
                            Function3<ColumnScope, Composer, Integer, Unit> function3 = content;
                            int i15 = (i4 >> 6) & 7168;
                            composer4.startReplaceableGroup(-483455358);
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer4, 0, -1323940314);
                            Density density = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion2.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
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
                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                            composer4.startReplaceableGroup(-1163856341);
                            function3.invoke(ColumnScopeInstance.INSTANCE, composer4, Integer.valueOf(((i15 >> 6) & 112) | 6));
                            composer4.endReplaceableGroup();
                            composer4.endReplaceableGroup();
                            composer4.endNode();
                            composer4.endReplaceableGroup();
                            composer4.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer3, 12582912 | (i4 & 14) | (i4 & 112) | ((i4 << 6) & 3670016), 0);
                    composerStartRestartGroup = composer3;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    cardElevation4 = cardElevation3;
                    cardColors2 = cardColorsM17018cardColorsro_MJ88;
                    modifier4 = modifier3;
                    shape5 = shape4;
                    borderStroke4 = borderStroke3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.Card.2
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

                    public final void invoke(@Nullable Composer composer4, int i14) {
                        CardKt.Card(modifier4, shape5, cardColors2, cardElevation4, borderStroke4, content, composer4, i | 1, i2);
                    }
                });
                return;
            }
            i4 |= i5;
            if ((374491 & i4) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 == 0) {
                    }
                    if ((i2 & 2) == 0) {
                    }
                    if ((i2 & 4) == 0) {
                    }
                    if ((i2 & 8) == 0) {
                    }
                    CardElevation cardElevation52 = cardElevationM17019cardElevationaqJV_2Y;
                    modifier3 = modifier5;
                    cardElevation3 = cardElevation52;
                    if (i10 == 0) {
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i112 = i4 >> 3;
                    int i122 = (i112 & 112) | 6;
                    int i132 = (i112 & 896) | 54;
                    Composer composer32 = composerStartRestartGroup;
                    SurfaceKt.m17325SurfaceT9BRK9s(modifier3, shape4, cardColorsM17018cardColorsro_MJ88.containerColor$material3_release(true, composerStartRestartGroup, i122).getValue().m18535unboximpl(), cardColorsM17018cardColorsro_MJ88.contentColor$material3_release(true, composerStartRestartGroup, i122).getValue().m18535unboximpl(), cardElevation3.tonalElevation$material3_release(true, interactionSource, composerStartRestartGroup, i132).getValue().m20982unboximpl(), cardElevation3.shadowElevation$material3_release(true, interactionSource, composerStartRestartGroup, i132).getValue().m20982unboximpl(), borderStroke3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 664103990, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.Card.1
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
                        public final void invoke(@Nullable Composer composer4, int i14) {
                            if ((i14 & 11) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(664103990, i14, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:91)");
                            }
                            Function3<ColumnScope, Composer, Integer, Unit> function3 = content;
                            int i15 = (i4 >> 6) & 7168;
                            composer4.startReplaceableGroup(-483455358);
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer4, 0, -1323940314);
                            Density density = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion2.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
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
                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                            composer4.startReplaceableGroup(-1163856341);
                            function3.invoke(ColumnScopeInstance.INSTANCE, composer4, Integer.valueOf(((i15 >> 6) & 112) | 6));
                            composer4.endReplaceableGroup();
                            composer4.endReplaceableGroup();
                            composer4.endNode();
                            composer4.endReplaceableGroup();
                            composer4.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer32, 12582912 | (i4 & 14) | (i4 & 112) | ((i4 << 6) & 3670016), 0);
                    composerStartRestartGroup = composer32;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    cardElevation4 = cardElevation3;
                    cardColors2 = cardColorsM17018cardColorsro_MJ88;
                    modifier4 = modifier3;
                    shape5 = shape4;
                    borderStroke4 = borderStroke3;
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        borderStroke2 = borderStroke;
        if ((i2 & 32) != 0) {
        }
        i4 |= i5;
        if ((374491 & i4) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0163  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedCard(@Nullable Modifier modifier, @Nullable Shape shape, @Nullable CardColors cardColors, @Nullable CardElevation cardElevation, @NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i4;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevation2;
        Modifier modifier3;
        Shape elevatedShape;
        Composer composer2;
        CardColors cardColorsM17020elevatedCardColorsro_MJ88;
        int i5;
        CardElevation cardElevationM17021elevatedCardElevationaqJV_2Y;
        final CardElevation cardElevation3;
        final CardColors cardColors3;
        final Shape shape3;
        final Modifier modifier4;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(895940201);
        int i6 = i2 & 1;
        if (i6 != 0) {
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
                int i7 = composerStartRestartGroup.changed(shape2) ? 32 : 16;
                i4 |= i7;
            } else {
                shape2 = shape;
            }
            i4 |= i7;
        } else {
            shape2 = shape;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                cardColors2 = cardColors;
                int i8 = composerStartRestartGroup.changed(cardColors2) ? 256 : 128;
                i4 |= i8;
            } else {
                cardColors2 = cardColors;
            }
            i4 |= i8;
        } else {
            cardColors2 = cardColors;
        }
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                cardElevation2 = cardElevation;
                int i9 = composerStartRestartGroup.changed(cardElevation2) ? 2048 : 1024;
                i4 |= i9;
            } else {
                cardElevation2 = cardElevation;
            }
            i4 |= i9;
        } else {
            cardElevation2 = cardElevation;
        }
        if ((i2 & 16) != 0) {
            i4 |= 24576;
        } else if ((57344 & i) == 0) {
            i4 |= composerStartRestartGroup.changed(content) ? 16384 : 8192;
        }
        if ((46811 & i4) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier4 = modifier2;
            shape3 = shape2;
            composer2 = composerStartRestartGroup;
            cardColors3 = cardColors2;
            cardElevation3 = cardElevation2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                modifier3 = i6 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i2 & 2) != 0) {
                    elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                } else {
                    elevatedShape = shape2;
                }
                if ((i2 & 4) != 0) {
                    cardColorsM17020elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m17020elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    composer2 = composerStartRestartGroup;
                    i4 &= -897;
                } else {
                    composer2 = composerStartRestartGroup;
                    cardColorsM17020elevatedCardColorsro_MJ88 = cardColors2;
                }
                if ((i2 & 8) != 0) {
                    i5 = i4 & (-7169);
                    cardElevationM17021elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m17021elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, 1572864, 63);
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(895940201, i5, -1, "androidx.compose.material3.ElevatedCard (Card.kt:183)");
                }
                Modifier modifier5 = modifier3;
                Shape shape4 = elevatedShape;
                CardColors cardColors4 = cardColorsM17020elevatedCardColorsro_MJ88;
                Card(modifier5, shape4, cardColors4, cardElevationM17021elevatedCardElevationaqJV_2Y, null, content, composer2, (i5 & 14) | 24576 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | ((i5 << 3) & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                cardElevation3 = cardElevationM17021elevatedCardElevationaqJV_2Y;
                cardColors3 = cardColors4;
                shape3 = shape4;
                modifier4 = modifier5;
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
                modifier3 = modifier2;
                elevatedShape = shape2;
                composer2 = composerStartRestartGroup;
                cardColorsM17020elevatedCardColorsro_MJ88 = cardColors2;
            }
            i5 = i4;
            cardElevationM17021elevatedCardElevationaqJV_2Y = cardElevation2;
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier modifier52 = modifier3;
            Shape shape42 = elevatedShape;
            CardColors cardColors42 = cardColorsM17020elevatedCardColorsro_MJ88;
            Card(modifier52, shape42, cardColors42, cardElevationM17021elevatedCardElevationaqJV_2Y, null, content, composer2, (i5 & 14) | 24576 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | ((i5 << 3) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            cardElevation3 = cardElevationM17021elevatedCardElevationaqJV_2Y;
            cardColors3 = cardColors42;
            shape3 = shape42;
            modifier4 = modifier52;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.ElevatedCard.1
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

            public final void invoke(@Nullable Composer composer3, int i10) {
                CardKt.ElevatedCard(modifier4, shape3, cardColors3, cardElevation3, content, composer3, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011b  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedCard(@Nullable Modifier modifier, @Nullable Shape shape, @Nullable CardColors cardColors, @Nullable CardElevation cardElevation, @Nullable BorderStroke borderStroke, @NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i4;
        Shape shape2;
        CardColors cardColorsM17022outlinedCardColorsro_MJ88;
        CardElevation cardElevationM17023outlinedCardElevationaqJV_2Y;
        BorderStroke borderStroke2;
        Modifier modifier3;
        Shape outlinedShape;
        Composer composer2;
        int i5;
        CardElevation cardElevation2;
        BorderStroke borderStrokeOutlinedCardBorder;
        Composer composer3;
        final BorderStroke borderStroke3;
        final CardElevation cardElevation3;
        final CardColors cardColors2;
        final Shape shape3;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(740336179);
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
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                shape2 = shape;
                int i8 = composerStartRestartGroup.changed(shape2) ? 32 : 16;
                i4 |= i8;
            } else {
                shape2 = shape;
            }
            i4 |= i8;
        } else {
            shape2 = shape;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                cardColorsM17022outlinedCardColorsro_MJ88 = cardColors;
                int i9 = composerStartRestartGroup.changed(cardColorsM17022outlinedCardColorsro_MJ88) ? 256 : 128;
                i4 |= i9;
            } else {
                cardColorsM17022outlinedCardColorsro_MJ88 = cardColors;
            }
            i4 |= i9;
        } else {
            cardColorsM17022outlinedCardColorsro_MJ88 = cardColors;
        }
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                cardElevationM17023outlinedCardElevationaqJV_2Y = cardElevation;
                int i10 = composerStartRestartGroup.changed(cardElevationM17023outlinedCardElevationaqJV_2Y) ? 2048 : 1024;
                i4 |= i10;
            } else {
                cardElevationM17023outlinedCardElevationaqJV_2Y = cardElevation;
            }
            i4 |= i10;
        } else {
            cardElevationM17023outlinedCardElevationaqJV_2Y = cardElevation;
        }
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                borderStroke2 = borderStroke;
                int i11 = composerStartRestartGroup.changed(borderStroke2) ? 16384 : 8192;
                i4 |= i11;
            } else {
                borderStroke2 = borderStroke;
            }
            i4 |= i11;
        } else {
            borderStroke2 = borderStroke;
        }
        if ((i2 & 32) == 0) {
            i6 = (458752 & i) == 0 ? composerStartRestartGroup.changed(content) ? 131072 : 65536 : 196608;
            if ((374491 & i4) == 74898 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    modifier3 = i7 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) == 0) {
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                    } else {
                        outlinedShape = shape2;
                    }
                    if ((i2 & 4) == 0) {
                        composer2 = composerStartRestartGroup;
                        i4 &= -897;
                        cardColorsM17022outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m17022outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if ((i2 & 8) == 0) {
                        composerStartRestartGroup = composer2;
                        i4 &= -7169;
                        cardElevationM17023outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m17023outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, 1572864, 63);
                    } else {
                        composerStartRestartGroup = composer2;
                    }
                    if ((i2 & 16) == 0) {
                        borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(false, composerStartRestartGroup, 48, 1);
                        CardElevation cardElevation4 = cardElevationM17023outlinedCardElevationaqJV_2Y;
                        i5 = i4 & (-57345);
                        cardElevation2 = cardElevation4;
                    } else {
                        CardElevation cardElevation5 = cardElevationM17023outlinedCardElevationaqJV_2Y;
                        i5 = i4;
                        cardElevation2 = cardElevation5;
                        borderStrokeOutlinedCardBorder = borderStroke;
                    }
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
                    if ((i2 & 16) != 0) {
                        i4 &= -57345;
                    }
                    CardElevation cardElevation6 = cardElevationM17023outlinedCardElevationaqJV_2Y;
                    i5 = i4;
                    cardElevation2 = cardElevation6;
                    modifier3 = modifier2;
                    outlinedShape = shape2;
                    borderStrokeOutlinedCardBorder = borderStroke2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(740336179, i5, -1, "androidx.compose.material3.OutlinedCard (Card.kt:277)");
                }
                CardColors cardColors3 = cardColorsM17022outlinedCardColorsro_MJ88;
                Modifier modifier5 = modifier3;
                Shape shape4 = outlinedShape;
                Card(modifier5, shape4, cardColors3, cardElevation2, borderStrokeOutlinedCardBorder, content, composerStartRestartGroup, 524286 & i5, 0);
                composer3 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                borderStroke3 = borderStrokeOutlinedCardBorder;
                cardElevation3 = cardElevation2;
                cardColors2 = cardColors3;
                shape3 = shape4;
                modifier4 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
                shape3 = shape2;
                composer3 = composerStartRestartGroup;
                cardColors2 = cardColorsM17022outlinedCardColorsro_MJ88;
                cardElevation3 = cardElevationM17023outlinedCardElevationaqJV_2Y;
                borderStroke3 = borderStroke2;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.OutlinedCard.1
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

                public final void invoke(@Nullable Composer composer4, int i12) {
                    CardKt.OutlinedCard(modifier4, shape3, cardColors2, cardElevation3, borderStroke3, content, composer4, i | 1, i2);
                }
            });
            return;
        }
        i4 |= i6;
        if ((374491 & i4) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i7 == 0) {
                }
                if ((i2 & 2) == 0) {
                }
                if ((i2 & 4) == 0) {
                }
                if ((i2 & 8) == 0) {
                }
                if ((i2 & 16) == 0) {
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                CardColors cardColors32 = cardColorsM17022outlinedCardColorsro_MJ88;
                Modifier modifier52 = modifier3;
                Shape shape42 = outlinedShape;
                Card(modifier52, shape42, cardColors32, cardElevation2, borderStrokeOutlinedCardBorder, content, composerStartRestartGroup, 524286 & i5, 0);
                composer3 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                }
                borderStroke3 = borderStrokeOutlinedCardBorder;
                cardElevation3 = cardElevation2;
                cardColors2 = cardColors32;
                shape3 = shape42;
                modifier4 = modifier52;
            }
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x021a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0116  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedCard(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable Shape shape, @Nullable CardColors cardColors, @Nullable CardElevation cardElevation, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        Shape elevatedShape;
        CardColors cardColorsM17020elevatedCardColorsro_MJ88;
        CardElevation cardElevation2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifier3;
        Composer composer2;
        CardElevation cardElevationM17021elevatedCardElevationaqJV_2Y;
        int i7;
        boolean z3;
        CardElevation cardElevation3;
        Shape shape2;
        CardColors cardColors2;
        final MutableInteractionSource mutableInteractionSource3;
        Composer composer3;
        final CardElevation cardElevation4;
        final CardColors cardColors3;
        final Shape shape3;
        final boolean z4;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1850977784);
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
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        elevatedShape = shape;
                        int i10 = composerStartRestartGroup.changed(elevatedShape) ? 2048 : 1024;
                        i4 |= i10;
                    } else {
                        elevatedShape = shape;
                    }
                    i4 |= i10;
                } else {
                    elevatedShape = shape;
                }
                if ((i & 57344) == 0) {
                    if ((i2 & 16) == 0) {
                        cardColorsM17020elevatedCardColorsro_MJ88 = cardColors;
                        int i11 = composerStartRestartGroup.changed(cardColorsM17020elevatedCardColorsro_MJ88) ? 16384 : 8192;
                        i4 |= i11;
                    } else {
                        cardColorsM17020elevatedCardColorsro_MJ88 = cardColors;
                    }
                    i4 |= i11;
                } else {
                    cardColorsM17020elevatedCardColorsro_MJ88 = cardColors;
                }
                if ((i & 458752) == 0) {
                    if ((i2 & 32) == 0) {
                        cardElevation2 = cardElevation;
                        int i12 = composerStartRestartGroup.changed(cardElevation2) ? 131072 : 65536;
                        i4 |= i12;
                    } else {
                        cardElevation2 = cardElevation;
                    }
                    i4 |= i12;
                } else {
                    cardElevation2 = cardElevation;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else {
                    if ((3670016 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                    }
                    if ((i2 & 128) != 0) {
                        i8 = (i & 29360128) == 0 ? composerStartRestartGroup.changed(content) ? 8388608 : 4194304 : 12582912;
                        if ((23967451 & i4) == 4793490 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            z4 = z2;
                            shape3 = elevatedShape;
                            composer3 = composerStartRestartGroup;
                            cardColors3 = cardColorsM17020elevatedCardColorsro_MJ88;
                            cardElevation4 = cardElevation2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
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
                                boolean z5 = z2;
                                i7 = i4;
                                z3 = z5;
                                modifier3 = modifier2;
                                shape2 = elevatedShape;
                                cardColors2 = cardColorsM17020elevatedCardColorsro_MJ88;
                                cardElevation3 = cardElevation2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            } else {
                                modifier3 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 8) != 0) {
                                    i4 &= -7169;
                                    elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 16) == 0) {
                                    composer2 = composerStartRestartGroup;
                                    i4 &= -57345;
                                    cardColorsM17020elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m17020elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if ((i2 & 32) == 0) {
                                    cardElevationM17021elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m17021elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, 1572864, 63);
                                    composerStartRestartGroup = composer2;
                                    i4 &= -458753;
                                } else {
                                    composerStartRestartGroup = composer2;
                                    cardElevationM17021elevatedCardElevationaqJV_2Y = cardElevation;
                                }
                                if (i6 == 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    boolean z6 = z2;
                                    i7 = i4;
                                    z3 = z6;
                                    cardElevation3 = cardElevationM17021elevatedCardElevationaqJV_2Y;
                                    shape2 = elevatedShape;
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    cardColors2 = cardColorsM17020elevatedCardColorsro_MJ88;
                                } else {
                                    boolean z7 = z2;
                                    i7 = i4;
                                    z3 = z7;
                                    cardElevation3 = cardElevationM17021elevatedCardElevationaqJV_2Y;
                                    shape2 = elevatedShape;
                                    cardColors2 = cardColorsM17020elevatedCardColorsro_MJ88;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1850977784, i7, -1, "androidx.compose.material3.ElevatedCard (Card.kt:230)");
                            }
                            int i13 = (i7 & 14) | 1572864 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (i7 & 57344) | (i7 & 458752);
                            int i14 = i7 << 3;
                            Card(onClick, modifier3, z3, shape2, cardColors2, cardElevation3, null, mutableInteractionSource3, content, composerStartRestartGroup, i13 | (i14 & 29360128) | (i14 & 234881024), 0);
                            composer3 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            cardElevation4 = cardElevation3;
                            cardColors3 = cardColors2;
                            shape3 = shape2;
                            z4 = z3;
                            modifier4 = modifier3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.ElevatedCard.3
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

                            public final void invoke(@Nullable Composer composer4, int i15) {
                                CardKt.ElevatedCard(onClick, modifier4, z4, shape3, cardColors3, cardElevation4, mutableInteractionSource3, content, composer4, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= i8;
                    if ((23967451 & i4) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i9 == 0) {
                            }
                            if (i5 != 0) {
                            }
                            if ((i2 & 8) != 0) {
                            }
                            if ((i2 & 16) == 0) {
                            }
                            if ((i2 & 32) == 0) {
                            }
                            if (i6 == 0) {
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i132 = (i7 & 14) | 1572864 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (i7 & 57344) | (i7 & 458752);
                            int i142 = i7 << 3;
                            Card(onClick, modifier3, z3, shape2, cardColors2, cardElevation3, null, mutableInteractionSource3, content, composerStartRestartGroup, i132 | (i142 & 29360128) | (i142 & 234881024), 0);
                            composer3 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            cardElevation4 = cardElevation3;
                            cardColors3 = cardColors2;
                            shape3 = shape2;
                            z4 = z3;
                            modifier4 = modifier3;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 128) != 0) {
                }
                i4 |= i8;
                if ((23967451 & i4) == 4793490) {
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 7168) == 0) {
            }
            if ((i & 57344) == 0) {
            }
            if ((i & 458752) == 0) {
            }
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 128) != 0) {
            }
            i4 |= i8;
            if ((23967451 & i4) == 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i & 7168) == 0) {
        }
        if ((i & 57344) == 0) {
        }
        if ((i & 458752) == 0) {
        }
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 128) != 0) {
        }
        i4 |= i8;
        if ((23967451 & i4) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0243 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0100  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedCard(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable Shape shape, @Nullable CardColors cardColors, @Nullable CardElevation cardElevation, @Nullable BorderStroke borderStroke, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        Shape outlinedShape;
        CardColors cardColorsM17022outlinedCardColorsro_MJ88;
        CardElevation cardElevationM17023outlinedCardElevationaqJV_2Y;
        BorderStroke borderStroke2;
        int i6;
        Composer composer2;
        int i7;
        BorderStroke borderStrokeOutlinedCardBorder;
        int i8;
        Modifier modifier3;
        boolean z3;
        CardColors cardColors2;
        CardElevation cardElevation2;
        BorderStroke borderStroke3;
        Shape shape2;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer3;
        final MutableInteractionSource mutableInteractionSource3;
        final BorderStroke borderStroke4;
        final CardElevation cardElevation3;
        final CardColors cardColors3;
        final Shape shape3;
        final boolean z4;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-727137250);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
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
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 896) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        outlinedShape = shape;
                        int i11 = composerStartRestartGroup.changed(outlinedShape) ? 2048 : 1024;
                        i4 |= i11;
                    } else {
                        outlinedShape = shape;
                    }
                    i4 |= i11;
                } else {
                    outlinedShape = shape;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        cardColorsM17022outlinedCardColorsro_MJ88 = cardColors;
                        int i12 = composerStartRestartGroup.changed(cardColorsM17022outlinedCardColorsro_MJ88) ? 16384 : 8192;
                        i4 |= i12;
                    } else {
                        cardColorsM17022outlinedCardColorsro_MJ88 = cardColors;
                    }
                    i4 |= i12;
                } else {
                    cardColorsM17022outlinedCardColorsro_MJ88 = cardColors;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        cardElevationM17023outlinedCardElevationaqJV_2Y = cardElevation;
                        int i13 = composerStartRestartGroup.changed(cardElevationM17023outlinedCardElevationaqJV_2Y) ? 131072 : 65536;
                        i4 |= i13;
                    } else {
                        cardElevationM17023outlinedCardElevationaqJV_2Y = cardElevation;
                    }
                    i4 |= i13;
                } else {
                    cardElevationM17023outlinedCardElevationaqJV_2Y = cardElevation;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        borderStroke2 = borderStroke;
                        int i14 = composerStartRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                        i4 |= i14;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    i4 |= i14;
                } else {
                    borderStroke2 = borderStroke;
                }
                i6 = i2 & 128;
                if (i6 != 0) {
                    i4 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
                }
                if ((i2 & 256) == 0) {
                    i9 = (234881024 & i) == 0 ? composerStartRestartGroup.changed(content) ? 67108864 : 33554432 : 100663296;
                    if ((191739611 & i4) != 38347922 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        mutableInteractionSource3 = mutableInteractionSource;
                        modifier4 = modifier2;
                        z4 = z2;
                        shape3 = outlinedShape;
                        composer3 = composerStartRestartGroup;
                        cardColors3 = cardColorsM17022outlinedCardColorsro_MJ88;
                        cardElevation3 = cardElevationM17023outlinedCardElevationaqJV_2Y;
                        borderStroke4 = borderStroke2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 8) != 0) {
                                i4 &= -7169;
                                outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 16) == 0) {
                                i7 = i6;
                                composer2 = composerStartRestartGroup;
                                i4 &= -57345;
                                cardColorsM17022outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m17022outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                composer2 = composerStartRestartGroup;
                                i7 = i6;
                            }
                            if ((i2 & 32) == 0) {
                                composerStartRestartGroup = composer2;
                                i4 &= -458753;
                                cardElevationM17023outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m17023outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, 1572864, 63);
                            } else {
                                composerStartRestartGroup = composer2;
                            }
                            if ((i2 & 64) == 0) {
                                borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z2, composerStartRestartGroup, ((i4 >> 6) & 14) | 48, 0);
                                i4 = (-3670017) & i4;
                            } else {
                                borderStrokeOutlinedCardBorder = borderStroke;
                            }
                            if (i7 == 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                Shape shape4 = outlinedShape;
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                i8 = i4;
                                z3 = z2;
                                borderStroke3 = borderStrokeOutlinedCardBorder;
                                shape2 = shape4;
                                modifier3 = modifier2;
                                cardColors2 = cardColorsM17022outlinedCardColorsro_MJ88;
                                cardElevation2 = cardElevationM17023outlinedCardElevationaqJV_2Y;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-727137250, i8, -1, "androidx.compose.material3.OutlinedCard (Card.kt:326)");
                                }
                                Card(onClick, modifier3, z3, shape2, cardColors2, cardElevation2, borderStroke3, mutableInteractionSource2, content, composerStartRestartGroup, 268435454 & i8, 0);
                                composer3 = composerStartRestartGroup;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                mutableInteractionSource3 = mutableInteractionSource2;
                                borderStroke4 = borderStroke3;
                                cardElevation3 = cardElevation2;
                                cardColors3 = cardColors2;
                                shape3 = shape2;
                                z4 = z3;
                                modifier4 = modifier3;
                            } else {
                                i8 = i4;
                                modifier3 = modifier2;
                                z3 = z2;
                                cardColors2 = cardColorsM17022outlinedCardColorsro_MJ88;
                                cardElevation2 = cardElevationM17023outlinedCardElevationaqJV_2Y;
                                borderStroke3 = borderStrokeOutlinedCardBorder;
                                shape2 = outlinedShape;
                            }
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
                            i8 = i4;
                            modifier3 = modifier2;
                            z3 = z2;
                            shape2 = outlinedShape;
                            cardColors2 = cardColorsM17022outlinedCardColorsro_MJ88;
                            cardElevation2 = cardElevationM17023outlinedCardElevationaqJV_2Y;
                            borderStroke3 = borderStroke2;
                        }
                        mutableInteractionSource2 = mutableInteractionSource;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        Card(onClick, modifier3, z3, shape2, cardColors2, cardElevation2, borderStroke3, mutableInteractionSource2, content, composerStartRestartGroup, 268435454 & i8, 0);
                        composer3 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        borderStroke4 = borderStroke3;
                        cardElevation3 = cardElevation2;
                        cardColors3 = cardColors2;
                        shape3 = shape2;
                        z4 = z3;
                        modifier4 = modifier3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.OutlinedCard.3
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

                        public final void invoke(@Nullable Composer composer4, int i15) {
                            CardKt.OutlinedCard(onClick, modifier4, z4, shape3, cardColors3, cardElevation3, borderStroke4, mutableInteractionSource3, content, composer4, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= i9;
                if ((191739611 & i4) != 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i2 & 8) != 0) {
                        }
                        if ((i2 & 16) == 0) {
                        }
                        if ((i2 & 32) == 0) {
                        }
                        if ((i2 & 64) == 0) {
                        }
                        if (i7 == 0) {
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 7168) == 0) {
            }
            if ((57344 & i) == 0) {
            }
            if ((458752 & i) == 0) {
            }
            if ((3670016 & i) == 0) {
            }
            i6 = i2 & 128;
            if (i6 != 0) {
            }
            if ((i2 & 256) == 0) {
            }
            i4 |= i9;
            if ((191739611 & i4) != 38347922) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i & 7168) == 0) {
        }
        if ((57344 & i) == 0) {
        }
        if ((458752 & i) == 0) {
        }
        if ((3670016 & i) == 0) {
        }
        i6 = i2 & 128;
        if (i6 != 0) {
        }
        if ((i2 & 256) == 0) {
        }
        i4 |= i9;
        if ((191739611 & i4) != 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0103  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Card(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable Shape shape, @Nullable CardColors cardColors, @Nullable CardElevation cardElevation, @Nullable BorderStroke borderStroke, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        final int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevation2;
        int i6;
        BorderStroke borderStroke2;
        int i7;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape3;
        Composer composer2;
        int i8;
        CardColors cardColorsM17018cardColorsro_MJ88;
        CardElevation cardElevationM17019cardElevationaqJV_2Y;
        int i9;
        MutableInteractionSource mutableInteractionSource3;
        CardElevation cardElevation3;
        BorderStroke borderStroke3;
        Shape shape4;
        CardColors cardColors3;
        Composer composer3;
        final Shape shape5;
        final BorderStroke borderStroke4;
        final MutableInteractionSource mutableInteractionSource4;
        final CardElevation cardElevation4;
        final CardColors cardColors4;
        final boolean z3;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2024281376);
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
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i12 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i4 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i4 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        cardColors2 = cardColors;
                        int i13 = composerStartRestartGroup.changed(cardColors2) ? 16384 : 8192;
                        i4 |= i13;
                    } else {
                        cardColors2 = cardColors;
                    }
                    i4 |= i13;
                } else {
                    cardColors2 = cardColors;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        cardElevation2 = cardElevation;
                        int i14 = composerStartRestartGroup.changed(cardElevation2) ? 131072 : 65536;
                        i4 |= i14;
                    } else {
                        cardElevation2 = cardElevation;
                    }
                    i4 |= i14;
                } else {
                    cardElevation2 = cardElevation;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else {
                    if ((3670016 & i) == 0) {
                        borderStroke2 = borderStroke;
                        i4 |= composerStartRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                    }
                    i7 = i2 & 128;
                    if (i7 == 0) {
                        i4 |= 12582912;
                        mutableInteractionSource2 = mutableInteractionSource;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if ((i & 29360128) == 0) {
                            i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 8388608 : 4194304;
                        }
                    }
                    if ((i2 & 256) != 0) {
                        i10 = (i & 234881024) == 0 ? composerStartRestartGroup.changed(content) ? 67108864 : 33554432 : 100663296;
                        if ((191739611 & i4) == 38347922 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            mutableInteractionSource4 = mutableInteractionSource2;
                            modifier3 = modifier2;
                            z3 = z2;
                            shape5 = shape2;
                            cardColors4 = cardColors2;
                            cardElevation4 = cardElevation2;
                            borderStroke4 = borderStroke2;
                            composer3 = composerStartRestartGroup;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
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
                                shape4 = shape2;
                                cardColors3 = cardColors2;
                                borderStroke3 = borderStroke2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                composer2 = composerStartRestartGroup;
                                cardElevation3 = cardElevation2;
                            } else {
                                Modifier modifier4 = i11 == 0 ? Modifier.INSTANCE : modifier2;
                                boolean z4 = i5 == 0 ? true : z2;
                                if ((i2 & 8) == 0) {
                                    i4 &= -7169;
                                    shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                } else {
                                    shape3 = shape2;
                                }
                                int i15 = i4;
                                if ((i2 & 16) == 0) {
                                    i8 = i7;
                                    composer2 = composerStartRestartGroup;
                                    i15 &= -57345;
                                    cardColorsM17018cardColorsro_MJ88 = CardDefaults.INSTANCE.m17018cardColorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    i8 = i7;
                                    cardColorsM17018cardColorsro_MJ88 = cardColors2;
                                }
                                if ((i2 & 32) == 0) {
                                    Composer composer4 = composer2;
                                    cardElevationM17019cardElevationaqJV_2Y = CardDefaults.INSTANCE.m17019cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer4, 1572864, 63);
                                    composer2 = composer4;
                                    i9 = i15 & (-458753);
                                } else {
                                    cardElevationM17019cardElevationaqJV_2Y = cardElevation;
                                    i9 = i15;
                                }
                                BorderStroke borderStroke5 = i6 == 0 ? null : borderStroke;
                                if (i8 != 0) {
                                    composer2.startReplaceableGroup(-492369756);
                                    Object objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    composer2.endReplaceableGroup();
                                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                }
                                mutableInteractionSource3 = mutableInteractionSource2;
                                cardElevation3 = cardElevationM17019cardElevationaqJV_2Y;
                                i4 = i9;
                                borderStroke3 = borderStroke5;
                                z2 = z4;
                                shape4 = shape3;
                                modifier2 = modifier4;
                                cardColors3 = cardColorsM17018cardColorsro_MJ88;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2024281376, i4, -1, "androidx.compose.material3.Card (Card.kt:131)");
                            }
                            int i16 = (i4 >> 6) & 14;
                            int i17 = i4 >> 9;
                            int i18 = (i17 & 112) | i16;
                            int i19 = i16 | ((i4 >> 18) & 112) | (i17 & 896);
                            CardColors cardColors5 = cardColors3;
                            int i20 = i4 << 6;
                            int i21 = (i4 & 8190) | (i20 & 234881024) | (i20 & 1879048192);
                            CardElevation cardElevation5 = cardElevation3;
                            boolean z5 = z2;
                            Composer composer5 = composer2;
                            Modifier modifier5 = modifier2;
                            SurfaceKt.m17328Surfaceo_FOJdg(onClick, modifier5, z5, shape4, cardColors3.containerColor$material3_release(z2, composer2, i18).getValue().m18535unboximpl(), cardColors3.contentColor$material3_release(z2, composer2, i18).getValue().m18535unboximpl(), cardElevation3.tonalElevation$material3_release(z2, mutableInteractionSource3, composer2, i19).getValue().m20982unboximpl(), cardElevation3.shadowElevation$material3_release(z2, mutableInteractionSource3, composer2, i19).getValue().m20982unboximpl(), borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composer2, 776921067, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.Card.4
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
                                public final void invoke(@Nullable Composer composer6, int i22) {
                                    if ((i22 & 11) == 2 && composer6.getSkipping()) {
                                        composer6.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(776921067, i22, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:153)");
                                    }
                                    Function3<ColumnScope, Composer, Integer, Unit> function3 = content;
                                    int i23 = (i4 >> 15) & 7168;
                                    composer6.startReplaceableGroup(-483455358);
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer6, 0, -1323940314);
                                    Density density = (Density) composer6.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer6.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer6.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
                                    if (composer6.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer6.startReusableNode();
                                    if (composer6.getInserting()) {
                                        composer6.createNode(constructor);
                                    } else {
                                        composer6.useNode();
                                    }
                                    composer6.disableReusing();
                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer6);
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer6, composer6), composer6, 2058660585);
                                    composer6.startReplaceableGroup(-1163856341);
                                    function3.invoke(ColumnScopeInstance.INSTANCE, composer6, Integer.valueOf(((i23 >> 6) & 112) | 6));
                                    composer6.endReplaceableGroup();
                                    composer6.endReplaceableGroup();
                                    composer6.endNode();
                                    composer6.endReplaceableGroup();
                                    composer6.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer5, i21, 6, 0);
                            composer3 = composer5;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape5 = shape4;
                            borderStroke4 = borderStroke3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            cardElevation4 = cardElevation5;
                            cardColors4 = cardColors5;
                            z3 = z5;
                            modifier3 = modifier5;
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.Card.5
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

                            public final void invoke(@Nullable Composer composer6, int i22) {
                                CardKt.Card(onClick, modifier3, z3, shape5, cardColors4, cardElevation4, borderStroke4, mutableInteractionSource4, content, composer6, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= i10;
                    if ((191739611 & i4) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i11 == 0) {
                            }
                            if (i5 == 0) {
                            }
                            if ((i2 & 8) == 0) {
                            }
                            int i152 = i4;
                            if ((i2 & 16) == 0) {
                            }
                            if ((i2 & 32) == 0) {
                            }
                            if (i6 == 0) {
                            }
                            if (i8 != 0) {
                            }
                            mutableInteractionSource3 = mutableInteractionSource2;
                            cardElevation3 = cardElevationM17019cardElevationaqJV_2Y;
                            i4 = i9;
                            borderStroke3 = borderStroke5;
                            z2 = z4;
                            shape4 = shape3;
                            modifier2 = modifier4;
                            cardColors3 = cardColorsM17018cardColorsro_MJ88;
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i162 = (i4 >> 6) & 14;
                            int i172 = i4 >> 9;
                            int i182 = (i172 & 112) | i162;
                            int i192 = i162 | ((i4 >> 18) & 112) | (i172 & 896);
                            CardColors cardColors52 = cardColors3;
                            int i202 = i4 << 6;
                            int i212 = (i4 & 8190) | (i202 & 234881024) | (i202 & 1879048192);
                            CardElevation cardElevation52 = cardElevation3;
                            boolean z52 = z2;
                            Composer composer52 = composer2;
                            Modifier modifier52 = modifier2;
                            SurfaceKt.m17328Surfaceo_FOJdg(onClick, modifier52, z52, shape4, cardColors3.containerColor$material3_release(z2, composer2, i182).getValue().m18535unboximpl(), cardColors3.contentColor$material3_release(z2, composer2, i182).getValue().m18535unboximpl(), cardElevation3.tonalElevation$material3_release(z2, mutableInteractionSource3, composer2, i192).getValue().m20982unboximpl(), cardElevation3.shadowElevation$material3_release(z2, mutableInteractionSource3, composer2, i192).getValue().m20982unboximpl(), borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composer2, 776921067, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.Card.4
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
                                public final void invoke(@Nullable Composer composer6, int i22) {
                                    if ((i22 & 11) == 2 && composer6.getSkipping()) {
                                        composer6.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(776921067, i22, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:153)");
                                    }
                                    Function3<ColumnScope, Composer, Integer, Unit> function3 = content;
                                    int i23 = (i4 >> 15) & 7168;
                                    composer6.startReplaceableGroup(-483455358);
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer6, 0, -1323940314);
                                    Density density = (Density) composer6.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer6.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer6.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
                                    if (composer6.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer6.startReusableNode();
                                    if (composer6.getInserting()) {
                                        composer6.createNode(constructor);
                                    } else {
                                        composer6.useNode();
                                    }
                                    composer6.disableReusing();
                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer6);
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer6, composer6), composer6, 2058660585);
                                    composer6.startReplaceableGroup(-1163856341);
                                    function3.invoke(ColumnScopeInstance.INSTANCE, composer6, Integer.valueOf(((i23 >> 6) & 112) | 6));
                                    composer6.endReplaceableGroup();
                                    composer6.endReplaceableGroup();
                                    composer6.endNode();
                                    composer6.endReplaceableGroup();
                                    composer6.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer52, i212, 6, 0);
                            composer3 = composer52;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            shape5 = shape4;
                            borderStroke4 = borderStroke3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            cardElevation4 = cardElevation52;
                            cardColors4 = cardColors52;
                            z3 = z52;
                            modifier3 = modifier52;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                borderStroke2 = borderStroke;
                i7 = i2 & 128;
                if (i7 == 0) {
                }
                if ((i2 & 256) != 0) {
                }
                i4 |= i10;
                if ((191739611 & i4) == 38347922) {
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 7168) == 0) {
            }
            if ((57344 & i) == 0) {
            }
            if ((458752 & i) == 0) {
            }
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            borderStroke2 = borderStroke;
            i7 = i2 & 128;
            if (i7 == 0) {
            }
            if ((i2 & 256) != 0) {
            }
            i4 |= i10;
            if ((191739611 & i4) == 38347922) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i & 7168) == 0) {
        }
        if ((57344 & i) == 0) {
        }
        if ((458752 & i) == 0) {
        }
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        borderStroke2 = borderStroke;
        i7 = i2 & 128;
        if (i7 == 0) {
        }
        if ((i2 & 256) != 0) {
        }
        i4 |= i10;
        if ((191739611 & i4) == 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
