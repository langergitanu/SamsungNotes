package androidx.glance.oneui.template.component;

import androidx.annotation.DimenRes;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.TemplateCompositor;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt;
import androidx.glance.oneui.template.layout.glance.ListLayoutKt;
import androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt;
import androidx.glance.oneui.template.layout.glance.combine.CombineLayoutKt;
import androidx.glance.text.ComplexUnit;
import androidx.glance.text.TextPercentData;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.namefind.BilouCodec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a)\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000f\u001a)\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000f\u001a\u001f\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a*\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a4\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a*\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\t\u001a>\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a'\u0010$\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010(\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006)"}, m13886d2 = {"AutoTemplateText", "", "textData", "Landroidx/glance/oneui/template/TextData;", "textPercentSize", "Landroidx/glance/text/TextPercentData;", "fontWeight", "Landroidx/glance/text/FontWeight;", "AutoTemplateText-RbqdM5c", "(Landroidx/glance/oneui/template/TextData;Landroidx/glance/text/TextPercentData;ILandroidx/compose/runtime/Composer;I)V", "TemplateCombineText", "Landroidx/glance/oneui/template/TypedTextData;", "viewWidth", "", "viewHeight", "(Landroidx/glance/oneui/template/TypedTextData;FFLandroidx/compose/runtime/Composer;II)V", "TemplateGraphText", "TemplateListText", "itemCountInSmall", "", "(Landroidx/glance/oneui/template/TypedTextData;ILandroidx/compose/runtime/Composer;II)V", "TemplateText", "textSize", "Landroidx/compose/ui/unit/Dp;", "TemplateText-GUlxjmo", "(Landroidx/glance/oneui/template/TextData;FILandroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/unit/TextUnit;", "maxFontScale", "TemplateText-3SkNqBk", "(Landroidx/glance/oneui/template/TextData;JIFLandroidx/compose/runtime/Composer;II)V", "TemplateText-RbqdM5c", "textSizeId", BilouCodec.UNIT, "Landroidx/glance/text/ComplexUnit;", "TemplateText-2T94tj4", "(Landroidx/glance/oneui/template/TextData;ILandroidx/glance/text/ComplexUnit;IFLandroidx/compose/runtime/Composer;II)V", "TemplateTextBlockText", "fromSingleBlock", "", "textCountInSmall", "(Landroidx/glance/oneui/template/TypedTextData;ZILandroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nText.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Text.kt\nandroidx/glance/oneui/template/component/TextKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,229:1\n74#2:230\n74#2:231\n74#2:232\n74#2:233\n74#2:234\n74#2:235\n74#2:236\n74#2:237\n74#2:238\n*S KotlinDebug\n*F\n+ 1 Text.kt\nandroidx/glance/oneui/template/component/TextKt\n*L\n39#1:230\n64#1:231\n96#1:232\n116#1:233\n137#1:234\n153#1:235\n177#1:236\n198#1:237\n223#1:238\n*E\n"})
public final class TextKt {
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: AutoTemplateText-RbqdM5c, reason: not valid java name */
    public static final void m21707AutoTemplateTextRbqdM5c(@NotNull TextData textData, @NotNull TextPercentData textPercentSize, int i, @Nullable Composer composer, final int i2) {
        final TextData textData2;
        final TextPercentData textPercentData;
        final int i4;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(textPercentSize, "textPercentSize");
        Composer composerStartRestartGroup = composer.startRestartGroup(1239409041);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1239409041, i2, -1, "androidx.glance.oneui.template.component.AutoTemplateText (Text.kt:36)");
        }
        ColorProvider textColor = textData.getTextColor();
        composerStartRestartGroup.startReplaceableGroup(-1226234646);
        if (textColor == null) {
            textColor = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground();
        }
        ColorProvider colorProvider = textColor;
        composerStartRestartGroup.endReplaceableGroup();
        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composerStartRestartGroup.startReplaceableGroup(-1226234530);
            int i5 = i2 << 3;
            textData2 = textData;
            textPercentData = textPercentSize;
            i4 = i;
            androidx.glance.oneui.template.component.glance.TextKt.m21749GlanceAutoText2T94tj4(null, textData2, textPercentData, i4, colorProvider, composerStartRestartGroup, (TextPercentData.$stable << 6) | 32832 | (i5 & 896) | (i5 & 7168), 1);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            textData2 = textData;
            textPercentData = textPercentSize;
            i4 = i;
            composerStartRestartGroup.startReplaceableGroup(-1226234335);
            int i6 = i2 << 3;
            androidx.glance.oneui.template.component.compose.TextKt.m21727ComposeAutoText2T94tj4(null, textData2, textPercentData, i4, colorProvider, composerStartRestartGroup, (TextPercentData.$stable << 6) | 32832 | (i6 & 896) | (i6 & 7168), 1);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.TextKt$AutoTemplateText$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i7) {
                    TextKt.m21707AutoTemplateTextRbqdM5c(textData2, textPercentData, i4, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void TemplateCombineText(@NotNull final TypedTextData textData, float f, float f4, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        float f5;
        float f6;
        Composer composer2;
        final float f7;
        final float f8;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1583519594);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(textData) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(f4) ? 256 : 128;
        }
        if ((i4 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            f7 = f;
            f8 = f4;
            composer2 = composerStartRestartGroup;
        } else {
            float f9 = i5 != 0 ? 0.0f : f;
            float f10 = i6 != 0 ? 0.0f : f4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1583519594, i4, -1, "androidx.glance.oneui.template.component.TemplateCombineText (Text.kt:175)");
            }
            if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
                composerStartRestartGroup.startReplaceableGroup(849924758);
                int i7 = i4 & 14;
                int i8 = i4 << 9;
                composer2 = composerStartRestartGroup;
                float f11 = f10;
                CombineLayoutKt.m21864GlanceCombineTextIxUqPG8(textData, null, 0, null, f9, f11, composer2, i7 | (57344 & i8) | (i8 & 458752), 14);
                f5 = f9;
                f6 = f11;
                composer2.endReplaceableGroup();
            } else {
                f5 = f9;
                f6 = f10;
                composerStartRestartGroup.startReplaceableGroup(849924855);
                androidx.glance.oneui.template.layout.compose.combine.CombineLayoutKt.ComposeCombineText(textData, null, null, 0.0f, 0.0f, composerStartRestartGroup, i4 & 14, 30);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f7 = f5;
            f8 = f6;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.TextKt.TemplateCombineText.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer3, int i9) {
                    TextKt.TemplateCombineText(textData, f7, f8, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void TemplateGraphText(@NotNull final TypedTextData textData, float f, float f4, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        final float f5;
        final float f6;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1562387225);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(textData) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i4 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            f5 = f;
            f6 = f4;
        } else {
            float f7 = (i2 & 2) != 0 ? 0.0f : f;
            float f8 = (i2 & 4) != 0 ? 0.0f : f4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1562387225, i4, -1, "androidx.glance.oneui.template.component.TemplateGraphText (Text.kt:220)");
            }
            ColorProvider textColor = textData.getTextColor();
            composerStartRestartGroup.startReplaceableGroup(1599781558);
            if (textColor == null) {
                textColor = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground();
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
                composerStartRestartGroup.startReplaceableGroup(1599781674);
                LinearGraphLayoutKt.m21840GlanceGraphTextlL68QWg(textData, textData.getTextType(), textColor, null, composerStartRestartGroup, (i4 & 14) | 512, 8);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(1599781751);
                androidx.glance.oneui.template.layout.compose.LinearGraphLayoutKt.m21800ComposeGraphTextlL68QWg(textData, textData.getTextType(), textColor, null, composerStartRestartGroup, (i4 & 14) | 512, 8);
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f5 = f7;
            f6 = f8;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.TextKt.TemplateGraphText.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i5) {
                    TextKt.TemplateGraphText(textData, f5, f6, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void TemplateListText(@NotNull TypedTextData textData, final int i, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        final TypedTextData typedTextData;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Composer composerStartRestartGroup = composer.startRestartGroup(-688781660);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(textData) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i6 = i4 & 2;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i5 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            typedTextData = textData;
        } else {
            int i7 = i6 != 0 ? 2 : i;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-688781660, i5, -1, "androidx.glance.oneui.template.component.TemplateListText (Text.kt:150)");
            }
            ColorProvider textColor = textData.getTextColor();
            composerStartRestartGroup.startReplaceableGroup(1930279870);
            if (textColor == null) {
                textColor = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground();
            }
            ColorProvider colorProvider = textColor;
            composerStartRestartGroup.endReplaceableGroup();
            if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
                composerStartRestartGroup.startReplaceableGroup(1930279986);
                typedTextData = textData;
                ListLayoutKt.m21845GlanceListTexte4lg5Cc(typedTextData, textData.getTextType(), colorProvider, null, i7, composerStartRestartGroup, (i5 & 14) | 512 | ((i5 << 9) & 57344), 8);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                typedTextData = textData;
                composerStartRestartGroup.startReplaceableGroup(1930280165);
                androidx.glance.oneui.template.layout.compose.ListLayoutKt.m21805ComposeListTexte4lg5Cc(typedTextData, typedTextData.getTextType(), colorProvider, null, i7, composerStartRestartGroup, (i5 & 14) | 512 | ((i5 << 9) & 57344), 8);
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            i = i7;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.TextKt.TemplateListText.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i8) {
                    TextKt.TemplateListText(typedTextData, i, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: TemplateText-2T94tj4, reason: not valid java name */
    public static final void m21708TemplateText2T94tj4(@NotNull final TextData textData, @DimenRes final int i, @NotNull final ComplexUnit unit, final int i2, float f, @Nullable Composer composer, final int i4, final int i5) {
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1735143739);
        float f4 = (i5 & 16) != 0 ? 0.0f : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1735143739, i4, -1, "androidx.glance.oneui.template.component.TemplateText (Text.kt:134)");
        }
        ColorProvider textColor = textData.getTextColor();
        composerStartRestartGroup.startReplaceableGroup(607599647);
        if (textColor == null) {
            textColor = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground();
        }
        ColorProvider colorProvider = textColor;
        composerStartRestartGroup.endReplaceableGroup();
        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composerStartRestartGroup.startReplaceableGroup(607599763);
            androidx.glance.oneui.template.component.glance.TextKt.m21751GlanceText4QGO3ko(textData, i, unit, i2, colorProvider, null, f4, composerStartRestartGroup, (i4 & 112) | 32776 | (i4 & 896) | (i4 & 7168) | (3670016 & (i4 << 6)), 32);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(607599875);
            androidx.glance.oneui.template.component.compose.TextKt.m21729ComposeText4QGO3ko(textData, i, unit, i2, colorProvider, null, f4, composerStartRestartGroup, (i4 & 112) | 32776 | (i4 & 896) | (i4 & 7168) | (3670016 & (i4 << 6)), 32);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final float f5 = f4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.TextKt$TemplateText$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i6) {
                    TextKt.m21708TemplateText2T94tj4(textData, i, unit, i2, f5, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: TemplateText-3SkNqBk, reason: not valid java name */
    public static final void m21709TemplateText3SkNqBk(@NotNull final TextData textData, final long j, final int i, float f, @Nullable Composer composer, final int i2, final int i4) {
        Intrinsics.checkNotNullParameter(textData, "textData");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1094838109);
        float f4 = (i4 & 8) != 0 ? 0.0f : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1094838109, i2, -1, "androidx.glance.oneui.template.component.TemplateText (Text.kt:113)");
        }
        ColorProvider textColor = textData.getTextColor();
        composerStartRestartGroup.startReplaceableGroup(607598923);
        if (textColor == null) {
            textColor = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground();
        }
        ColorProvider colorProvider = textColor;
        composerStartRestartGroup.endReplaceableGroup();
        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composerStartRestartGroup.startReplaceableGroup(607599039);
            androidx.glance.oneui.template.component.glance.TextKt.m21753GlanceTextKuOwvYU(textData, j, i, colorProvider, null, f4, composerStartRestartGroup, (i2 & 112) | 4104 | (i2 & 896) | (458752 & (i2 << 6)), 16);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(607599143);
            androidx.glance.oneui.template.component.compose.TextKt.m21731ComposeTextKuOwvYU(textData, j, i, colorProvider, null, f4, composerStartRestartGroup, (i2 & 112) | 4104 | (i2 & 896) | (458752 & (i2 << 6)), 16);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final float f5 = f4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.TextKt$TemplateText$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i5) {
                    TextKt.m21709TemplateText3SkNqBk(textData, j, i, f5, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: TemplateText-GUlxjmo, reason: not valid java name */
    public static final void m21710TemplateTextGUlxjmo(@NotNull TextData textData, float f, int i, @Nullable Composer composer, final int i2) {
        final TextData textData2;
        final float f4;
        final int i4;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2038836178);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2038836178, i2, -1, "androidx.glance.oneui.template.component.TemplateText (Text.kt:93)");
        }
        ColorProvider textColor = textData.getTextColor();
        composerStartRestartGroup.startReplaceableGroup(607598407);
        if (textColor == null) {
            textColor = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground();
        }
        ColorProvider colorProvider = textColor;
        composerStartRestartGroup.endReplaceableGroup();
        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composerStartRestartGroup.startReplaceableGroup(607598523);
            textData2 = textData;
            f4 = f;
            i4 = i;
            androidx.glance.oneui.template.component.glance.TextKt.m21752GlanceTextFbLeKfk(textData2, f4, i4, colorProvider, null, composerStartRestartGroup, (i2 & 112) | 4104 | (i2 & 896), 16);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            textData2 = textData;
            f4 = f;
            i4 = i;
            composerStartRestartGroup.startReplaceableGroup(607598598);
            androidx.glance.oneui.template.component.compose.TextKt.m21730ComposeTextFbLeKfk(textData2, f4, i4, colorProvider, null, composerStartRestartGroup, (i2 & 112) | 4104 | (i2 & 896), 16);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.TextKt$TemplateText$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i5) {
                    TextKt.m21710TemplateTextGUlxjmo(textData2, f4, i4, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: TemplateText-RbqdM5c, reason: not valid java name */
    public static final void m21711TemplateTextRbqdM5c(@NotNull TextData textData, @NotNull TextPercentData textPercentSize, int i, @Nullable Composer composer, final int i2) {
        final TextData textData2;
        final TextPercentData textPercentData;
        final int i4;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(textPercentSize, "textPercentSize");
        Composer composerStartRestartGroup = composer.startRestartGroup(1648402496);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1648402496, i2, -1, "androidx.glance.oneui.template.component.TemplateText (Text.kt:61)");
        }
        ColorProvider textColor = textData.getTextColor();
        composerStartRestartGroup.startReplaceableGroup(607597365);
        if (textColor == null) {
            textColor = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground();
        }
        ColorProvider colorProvider = textColor;
        composerStartRestartGroup.endReplaceableGroup();
        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composerStartRestartGroup.startReplaceableGroup(607597481);
            int i5 = i2 << 3;
            textData2 = textData;
            textPercentData = textPercentSize;
            i4 = i;
            androidx.glance.oneui.template.component.glance.TextKt.m21750GlanceText2T94tj4(textPercentSize.getTextCategory() != null ? SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE) : GlanceModifier.INSTANCE, textData2, textPercentData, i4, colorProvider, composerStartRestartGroup, (TextPercentData.$stable << 6) | 32832 | (i5 & 896) | (i5 & 7168), 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            textData2 = textData;
            textPercentData = textPercentSize;
            i4 = i;
            composerStartRestartGroup.startReplaceableGroup(607597855);
            int i6 = i2 << 3;
            androidx.glance.oneui.template.component.compose.TextKt.m21728ComposeText2T94tj4(textPercentData.getTextCategory() != null ? SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null) : Modifier.INSTANCE, textData2, textPercentData, i4, colorProvider, composerStartRestartGroup, (TextPercentData.$stable << 6) | 32832 | (i6 & 896) | (i6 & 7168), 0);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.TextKt$TemplateText$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i7) {
                    TextKt.m21711TemplateTextRbqdM5c(textData2, textPercentData, i4, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void TemplateTextBlockText(@NotNull TypedTextData textData, boolean z, int i, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        TypedTextData typedTextData;
        boolean z2;
        final int i6;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1507079466);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(textData) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        int i7 = i4 & 4;
        if (i7 != 0) {
            i5 |= 384;
        } else if ((i2 & 896) == 0) {
            i5 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i5 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            typedTextData = textData;
            z2 = z;
            i6 = i;
        } else {
            if (i7 != 0) {
                i = 1;
            }
            int i8 = i;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1507079466, i5, -1, "androidx.glance.oneui.template.component.TemplateTextBlockText (Text.kt:195)");
            }
            ColorProvider textColor = textData.getTextColor();
            composerStartRestartGroup.startReplaceableGroup(2005050866);
            if (textColor == null) {
                textColor = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground();
            }
            ColorProvider colorProvider = textColor;
            composerStartRestartGroup.endReplaceableGroup();
            if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
                composerStartRestartGroup.startReplaceableGroup(2005050982);
                typedTextData = textData;
                z2 = z;
                TextBlockLayoutKt.GlanceTextBlockText(typedTextData, z2, colorProvider, null, i8, composerStartRestartGroup, (i5 & 14) | 512 | (i5 & 112) | ((i5 << 6) & 57344), 8);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                typedTextData = textData;
                z2 = z;
                composerStartRestartGroup.startReplaceableGroup(2005051171);
                androidx.glance.oneui.template.layout.compose.TextBlockLayoutKt.ComposeTextBlockText(typedTextData, z2, colorProvider, null, i8, composerStartRestartGroup, (i5 & 14) | 512 | (i5 & 112) | ((i5 << 6) & 57344), 8);
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            i6 = i8;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final TypedTextData typedTextData2 = typedTextData;
            final boolean z3 = z2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.TextKt.TemplateTextBlockText.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i9) {
                    TextKt.TemplateTextBlockText(typedTextData2, z3, i6, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }
}
