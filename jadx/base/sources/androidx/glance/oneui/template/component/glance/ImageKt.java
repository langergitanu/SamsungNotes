package androidx.glance.oneui.template.component.glance;

import androidx.annotation.DimenRes;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.glance.ColorFilter;
import androidx.glance.GlanceModifier;
import androidx.glance.ImageProvider;
import androidx.glance.appwidget.AppWidgetModifiersKt;
import androidx.glance.layout.ContentScale;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.ImageType;
import androidx.glance.oneui.template.utils.GlanceModifierUtilsKt;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0012H\u0001¢\u0006\u0002\u0010\u0013\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\b\u001a\u00020\u00122\b\b\u0001\u0010\t\u001a\u00020\u0012H\u0001¢\u0006\u0002\u0010\u0014\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, m13886d2 = {"GlanceImage", "", "data", "Landroidx/glance/oneui/template/ImageData;", "size", "Landroidx/compose/ui/unit/Dp;", "GlanceImage-ziNgDLE", "(Landroidx/glance/oneui/template/ImageData;FLandroidx/compose/runtime/Composer;I)V", "width", "height", "GlanceImage-73KfpEQ", "(Landroidx/glance/oneui/template/ImageData;FFLandroidx/compose/runtime/Composer;I)V", "modifier", "Landroidx/glance/GlanceModifier;", "contentScale", "Landroidx/glance/layout/ContentScale;", "GlanceImage-cuCYCYk", "(Landroidx/glance/oneui/template/ImageData;Landroidx/glance/GlanceModifier;ILandroidx/compose/runtime/Composer;II)V", "", "(Landroidx/glance/oneui/template/ImageData;ILandroidx/compose/runtime/Composer;I)V", "(Landroidx/glance/oneui/template/ImageData;IILandroidx/compose/runtime/Composer;I)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Image.kt\nandroidx/glance/oneui/template/component/glance/ImageKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,109:1\n154#2:110\n154#2:111\n74#3:112\n*S KotlinDebug\n*F\n+ 1 Image.kt\nandroidx/glance/oneui/template/component/glance/ImageKt\n*L\n26#1:110\n38#1:111\n81#1:112\n*E\n"})
public final class ImageKt {
    @Composable
    public static final void GlanceImage(@NotNull final ImageData data, @DimenRes final int i, @Nullable Composer composer, final int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(17447826);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(17447826, i2, -1, "androidx.glance.oneui.template.component.glance.GlanceImage (Image.kt:46)");
        }
        m21746GlanceImagecuCYCYk(data, i == 0 ? SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE) : SizeModifiersKt.size(GlanceModifier.INSTANCE, i), 0, composerStartRestartGroup, 8, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ImageKt.GlanceImage.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    ImageKt.GlanceImage(data, i, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    @Composable
    /* JADX INFO: renamed from: GlanceImage-73KfpEQ, reason: not valid java name */
    public static final void m21745GlanceImage73KfpEQ(@NotNull final ImageData data, final float f, final float f4, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(614593941);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(614593941, i, -1, "androidx.glance.oneui.template.component.glance.GlanceImage (Image.kt:34)");
        }
        float f5 = 0;
        m21746GlanceImagecuCYCYk(data, (C2256Dp.m20967compareTo0680j_4(f, C2256Dp.m20968constructorimpl(f5)) <= 0 || C2256Dp.m20967compareTo0680j_4(f4, C2256Dp.m20968constructorimpl(f5)) <= 0) ? SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE) : SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.m21508width3ABfNKs(GlanceModifier.INSTANCE, f), f4), 0, composerStartRestartGroup, 8, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ImageKt.GlanceImage.2
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
                    ImageKt.m21745GlanceImage73KfpEQ(data, f, f4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Composable
    /* JADX INFO: renamed from: GlanceImage-cuCYCYk, reason: not valid java name */
    public static final void m21746GlanceImagecuCYCYk(@NotNull final ImageData data, @NotNull final GlanceModifier modifier, int i, @Nullable Composer composer, int i2, final int i4) {
        int i5;
        int iM21467getFitAe3V0ko;
        int i6;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(1812337231);
        if ((i4 & 4) != 0) {
            i5 = i2;
            i6 = i5 & (-897);
            iM21467getFitAe3V0ko = data.getImageType() == ImageType.Icon ? ContentScale.INSTANCE.m21467getFitAe3V0ko() : ContentScale.INSTANCE.m21465getCropAe3V0ko();
        } else {
            i5 = i2;
            iM21467getFitAe3V0ko = i;
            i6 = i5;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1812337231, i6, -1, "androidx.glance.oneui.template.component.glance.GlanceImage (Image.kt:79)");
        }
        if (AppWidgetStyle.m21578equalsimpl0(((AppWidgetStyle) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetStyle())).getMask(), AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM()) || data.getImageType() != ImageType.Icon) {
            ColorFilter colorFilterTint = null;
            int i7 = i6;
            composerStartRestartGroup.startReplaceableGroup(-1061000639);
            ImageProvider imageProvider = data.getImageProvider();
            String contentDescription = data.getContentDescription();
            GlanceModifier glanceModifierKeepColor = AppWidgetModifiersKt.keepColor(GlanceModifierUtilsKt.maybeAnimation(modifier, data.getAnimation()), data.getKeepColor());
            if (data.getImageTintColor() != null) {
                ColorFilter.Companion companion = ColorFilter.INSTANCE;
                ColorProvider imageTintColor = data.getImageTintColor();
                Intrinsics.checkNotNull(imageTintColor);
                colorFilterTint = companion.tint(imageTintColor);
            }
            androidx.glance.ImageKt.m21259ImageGCr5PR4(imageProvider, contentDescription, glanceModifierKeepColor, iM21467getFitAe3V0ko, colorFilterTint, composerStartRestartGroup, (ColorFilter.$stable << 12) | ((i7 << 3) & 7168) | 8, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1061000221);
            ColorFilter colorFilterTint2 = null;
            ImageProvider imageProvider2 = data.getImageProvider();
            int i8 = i6;
            String contentDescription2 = data.getContentDescription();
            GlanceModifier glanceModifierKeepColor2 = AppWidgetModifiersKt.keepColor(GlanceModifierUtilsKt.maybeAnimation(modifier, data.getAnimation()), data.getKeepColor());
            if (data.getImageTintColor() != null) {
                ColorFilter.Companion companion2 = ColorFilter.INSTANCE;
                ColorProvider imageTintColor2 = data.getImageTintColor();
                Intrinsics.checkNotNull(imageTintColor2);
                colorFilterTint2 = companion2.tint(imageTintColor2);
            }
            androidx.glance.ImageKt.m21259ImageGCr5PR4(imageProvider2, contentDescription2, glanceModifierKeepColor2, iM21467getFitAe3V0ko, colorFilterTint2, composerStartRestartGroup, (ColorFilter.$stable << 12) | ((i8 << 3) & 7168) | 8, 0);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final int i9 = iM21467getFitAe3V0ko;
            final int i10 = i5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ImageKt.GlanceImage.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i11) {
                    ImageKt.m21746GlanceImagecuCYCYk(data, modifier, i9, composer2, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i4);
                }
            });
        }
    }

    @Composable
    /* JADX INFO: renamed from: GlanceImage-ziNgDLE, reason: not valid java name */
    public static final void m21747GlanceImageziNgDLE(@NotNull final ImageData data, final float f, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-838012439);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-838012439, i, -1, "androidx.glance.oneui.template.component.glance.GlanceImage (Image.kt:22)");
        }
        m21746GlanceImagecuCYCYk(data, C2256Dp.m20967compareTo0680j_4(f, C2256Dp.m20968constructorimpl((float) 0)) <= 0 ? SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE) : SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, f), 0, composerStartRestartGroup, 8, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ImageKt.GlanceImage.1
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
                    ImageKt.m21747GlanceImageziNgDLE(data, f, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Composable
    public static final void GlanceImage(@NotNull final ImageData data, @DimenRes final int i, @DimenRes final int i2, @Nullable Composer composer, final int i4) {
        GlanceModifier glanceModifierFillMaxSize;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-141297009);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-141297009, i4, -1, "androidx.glance.oneui.template.component.glance.GlanceImage (Image.kt:58)");
        }
        if (i != 0 && i2 != 0) {
            glanceModifierFillMaxSize = SizeModifiersKt.height(SizeModifiersKt.width(GlanceModifier.INSTANCE, i), i2);
        } else {
            glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
        }
        m21746GlanceImagecuCYCYk(data, glanceModifierFillMaxSize, 0, composerStartRestartGroup, 8, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ImageKt.GlanceImage.4
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
                    ImageKt.GlanceImage(data, i, i2, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1));
                }
            });
        }
    }
}
