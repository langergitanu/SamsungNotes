package androidx.glance.oneui.template.component;

import androidx.annotation.DimenRes;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.ImageWithBackgroundData;
import androidx.glance.oneui.template.TemplateCompositor;
import androidx.glance.oneui.template.utils.ComposeUtilsKt;
import androidx.glance.unit.ColorProvider;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u000e2\b\b\u0001\u0010\b\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, m13886d2 = {"TemplateImageButton", "", "data", "Landroidx/glance/oneui/template/ImageWithBackgroundData;", "size", "Landroidx/compose/ui/unit/Dp;", "TemplateImageButton-ziNgDLE", "(Landroidx/glance/oneui/template/ImageWithBackgroundData;FLandroidx/compose/runtime/Composer;I)V", "padding", "TemplateImageButton-73KfpEQ", "(Landroidx/glance/oneui/template/ImageWithBackgroundData;FFLandroidx/compose/runtime/Composer;I)V", "modifier", "Landroidx/glance/GlanceModifier;", "(Landroidx/glance/oneui/template/ImageWithBackgroundData;Landroidx/glance/GlanceModifier;Landroidx/compose/runtime/Composer;I)V", "", "(Landroidx/glance/oneui/template/ImageWithBackgroundData;IILandroidx/compose/runtime/Composer;I)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImageButton.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageButton.kt\nandroidx/glance/oneui/template/component/ImageButtonKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n74#2:75\n74#2:76\n74#2:77\n1#3:78\n*S KotlinDebug\n*F\n+ 1 ImageButton.kt\nandroidx/glance/oneui/template/component/ImageButtonKt\n*L\n19#1:75\n28#1:76\n58#1:77\n*E\n"})
public final class ImageButtonKt {
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void TemplateImageButton(@NotNull ImageWithBackgroundData data, @DimenRes int i, @DimenRes int i2, @Nullable Composer composer, final int i4) {
        final ImageWithBackgroundData imageWithBackgroundData;
        final int i5;
        final int i6;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(1847643037);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1847643037, i4, -1, "androidx.glance.oneui.template.component.TemplateImageButton (ImageButton.kt:55)");
        }
        ColorProvider backgroundColor = data.getBackgroundColor();
        composerStartRestartGroup.startReplaceableGroup(250503262);
        if (backgroundColor == null) {
            backgroundColor = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnSurface();
        }
        ColorProvider colorProvider = backgroundColor;
        composerStartRestartGroup.endReplaceableGroup();
        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composerStartRestartGroup.startReplaceableGroup(250503377);
            imageWithBackgroundData = data;
            i5 = i;
            i6 = i2;
            androidx.glance.oneui.template.component.glance.ImageButtonKt.GlanceImageButton(imageWithBackgroundData, i5, i6, colorProvider, (GlanceModifier) null, composerStartRestartGroup, (i4 & 112) | 4104 | (i4 & 896), 16);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            imageWithBackgroundData = data;
            i5 = i;
            i6 = i2;
            composerStartRestartGroup.startReplaceableGroup(250503454);
            androidx.glance.oneui.template.component.compose.ImageButtonKt.m21715ComposeImageButtonuDo3WH8(imageWithBackgroundData, i5, i6, ComposeUtilsKt.convert(colorProvider, composerStartRestartGroup, 8), null, composerStartRestartGroup, 8 | (i4 & 112) | (i4 & 896), 16);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.ImageButtonKt.TemplateImageButton.5
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
                    ImageButtonKt.TemplateImageButton(imageWithBackgroundData, i5, i6, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: TemplateImageButton-73KfpEQ, reason: not valid java name */
    public static final void m21703TemplateImageButton73KfpEQ(@NotNull ImageWithBackgroundData data, float f, float f4, @Nullable Composer composer, final int i) {
        final ImageWithBackgroundData imageWithBackgroundData;
        final float f5;
        final float f6;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(2893783);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2893783, i, -1, "androidx.glance.oneui.template.component.TemplateImageButton (ImageButton.kt:26)");
        }
        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composerStartRestartGroup.startReplaceableGroup(250502580);
            composerStartRestartGroup.startReplaceableGroup(250502626);
            if (data.getBackgroundColor() == null) {
                data.setBackgroundColor$glance_oneui_template_release(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getSurface());
            }
            composerStartRestartGroup.endReplaceableGroup();
            imageWithBackgroundData = data;
            f5 = f;
            f6 = f4;
            androidx.glance.oneui.template.component.glance.ImageButtonKt.m21740GlanceImageButtondjqsMU(imageWithBackgroundData, f5, f6, null, composerStartRestartGroup, (i & 112) | 8 | (i & 896), 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            imageWithBackgroundData = data;
            f5 = f;
            f6 = f4;
            composerStartRestartGroup.startReplaceableGroup(250502844);
            composerStartRestartGroup.startReplaceableGroup(250502891);
            if (imageWithBackgroundData.getBackgroundColor() == null) {
                imageWithBackgroundData.setBackgroundColor$glance_oneui_template_release(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getSurface());
            }
            composerStartRestartGroup.endReplaceableGroup();
            androidx.glance.oneui.template.component.compose.ImageButtonKt.m21714ComposeImageButtondjqsMU(imageWithBackgroundData, f5, f6, null, composerStartRestartGroup, (i & 112) | 8 | (i & 896), 8);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.ImageButtonKt.TemplateImageButton.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    ImageButtonKt.m21703TemplateImageButton73KfpEQ(imageWithBackgroundData, f5, f6, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Deprecated(message = "", replaceWith = @ReplaceWith(expression = "TemplateImageButton(data, size, padding)", imports = {}))
    @Composable
    /* JADX INFO: renamed from: TemplateImageButton-ziNgDLE, reason: not valid java name */
    public static final void m21704TemplateImageButtonziNgDLE(@NotNull ImageWithBackgroundData data, float f, @Nullable Composer composer, final int i) {
        final ImageWithBackgroundData imageWithBackgroundData;
        final float f4;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(1199141507);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1199141507, i, -1, "androidx.glance.oneui.template.component.TemplateImageButton (ImageButton.kt:16)");
        }
        ColorProvider backgroundColor = data.getBackgroundColor();
        composerStartRestartGroup.startReplaceableGroup(250502166);
        if (backgroundColor == null) {
            backgroundColor = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnSurface();
        }
        ColorProvider colorProvider = backgroundColor;
        composerStartRestartGroup.endReplaceableGroup();
        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composerStartRestartGroup.startReplaceableGroup(250502281);
            imageWithBackgroundData = data;
            f4 = f;
            androidx.glance.oneui.template.component.glance.ImageButtonKt.m21739GlanceImageButtonDzVHIIc(imageWithBackgroundData, f4, colorProvider, null, composerStartRestartGroup, (i & 112) | 520, 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            imageWithBackgroundData = data;
            f4 = f;
            composerStartRestartGroup.startReplaceableGroup(250502349);
            androidx.glance.oneui.template.component.compose.ImageButtonKt.m21713ComposeImageButtonPZHvWI(imageWithBackgroundData, f4, ComposeUtilsKt.convert(colorProvider, composerStartRestartGroup, 8), null, composerStartRestartGroup, (i & 112) | 8, 8);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.ImageButtonKt.TemplateImageButton.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    ImageButtonKt.m21704TemplateImageButtonziNgDLE(imageWithBackgroundData, f4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void TemplateImageButton(@NotNull final ImageWithBackgroundData data, @NotNull final GlanceModifier modifier, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(1748791394);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1748791394, i, -1, "androidx.glance.oneui.template.component.TemplateImageButton (ImageButton.kt:65)");
        }
        composerStartRestartGroup.startReplaceableGroup(250503666);
        if (data.getBackgroundColor() == null) {
            data.setBackgroundColor$glance_oneui_template_release(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnSurface());
        }
        composerStartRestartGroup.endReplaceableGroup();
        androidx.glance.oneui.template.component.glance.ImageButtonKt.GlanceImageButton(data, modifier, composerStartRestartGroup, (i & 112) | 8, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.ImageButtonKt.TemplateImageButton.7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    ImageButtonKt.TemplateImageButton(data, modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
