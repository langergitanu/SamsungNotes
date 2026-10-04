package androidx.glance.oneui.template.component.compose;

import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.layout.ContentScale;
import androidx.compose.p109ui.res.PrimitiveResources_androidKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.glance.ImageProvider;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.ImageType;
import androidx.glance.oneui.template.ImageWithBackgroundData;
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
@Metadata(m13885d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u001a4\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001aF\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\b\u001a\u00020\tH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u000e2\b\b\u0001\u0010\f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00132\b\b\u0002\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\u0014\u001a4\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a6\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001aF\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, m13886d2 = {"ComposeImageButton", "", "data", "Landroidx/glance/oneui/template/ImageData;", "size", "Landroidx/compose/ui/unit/Dp;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "ComposeImageButton-PZ-HvWI", "(Landroidx/glance/oneui/template/ImageData;FJLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "padding", "backgroundResId", "", "ComposeImageButton-LFFoFBE", "(Landroidx/glance/oneui/template/ImageData;FFJILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ComposeImageButton-uDo3WH8", "(Landroidx/glance/oneui/template/ImageData;IIJLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Landroidx/glance/oneui/template/ImageWithBackgroundData;", "(Landroidx/glance/oneui/template/ImageWithBackgroundData;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ComposeImageButton-djqs-MU", "(Landroidx/glance/oneui/template/ImageWithBackgroundData;FFLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ImageButtonInternal", "ImageButtonInternal-BAq54LU", "(Landroidx/glance/oneui/template/ImageData;Landroidx/compose/ui/graphics/Color;ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "ImageButtonInternal-TbyQ11s", "(Landroidx/glance/oneui/template/ImageData;FFLandroidx/compose/ui/graphics/Color;ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImageButton.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageButton.kt\nandroidx/glance/oneui/template/component/compose/ImageButtonKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/Dp\n+ 3 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 4 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,160:1\n88#2:161\n58#2:162\n75#2:163\n74#3:164\n74#3:168\n74#3:169\n154#4:165\n154#4:166\n154#4:167\n*S KotlinDebug\n*F\n+ 1 ImageButton.kt\nandroidx/glance/oneui/template/component/compose/ImageButtonKt\n*L\n35#1:161\n35#1:162\n35#1:163\n93#1:164\n121#1:168\n122#1:169\n113#1:165\n114#1:166\n116#1:167\n*E\n"})
public final class ImageButtonKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ComposeImageButton(@NotNull final ImageWithBackgroundData data, @Nullable Modifier modifier, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1289569106);
        if ((i2 & 2) != 0) {
            modifier = Modifier.INSTANCE;
        }
        final Modifier modifier2 = modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1289569106, i, -1, "androidx.glance.oneui.template.component.compose.ComposeImageButton (ImageButton.kt:156)");
        }
        ColorProvider backgroundColor = data.getBackgroundColor();
        composerStartRestartGroup.startReplaceableGroup(129462971);
        Color colorM18515boximpl = backgroundColor == null ? null : Color.m18515boximpl(ComposeUtilsKt.convert(backgroundColor, composerStartRestartGroup, 8));
        composerStartRestartGroup.endReplaceableGroup();
        m21716ImageButtonInternalBAq54LU(data, colorM18515boximpl, 0, modifier2, composerStartRestartGroup, ((i << 6) & 7168) | 392);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ImageButtonKt.ComposeImageButton.5
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
                    ImageButtonKt.ComposeImageButton(data, modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ComposeImageButton-LFFoFBE, reason: not valid java name */
    public static final void m21712ComposeImageButtonLFFoFBE(@NotNull final ImageData data, final float f, final float f4, final long j, int i, @Nullable Modifier modifier, @Nullable Composer composer, final int i2, final int i4) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(1173456232);
        final int i5 = (i4 & 16) != 0 ? 0 : i;
        final Modifier modifier2 = (i4 & 32) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1173456232, i2, -1, "androidx.glance.oneui.template.component.compose.ComposeImageButton (ImageButton.kt:47)");
        }
        m21717ImageButtonInternalTbyQ11s(data, f, f4, Color.m18515boximpl(j), i5, modifier2, composerStartRestartGroup, (i2 & 112) | 8 | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ImageButtonKt.ComposeImageButton.2
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
                    ImageButtonKt.m21712ComposeImageButtonLFFoFBE(data, f, f4, j, i5, modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Deprecated(message = "", replaceWith = @ReplaceWith(expression = "ComposeImageButton(data, size, padding, backgroundColor, modifier)", imports = {}))
    @Composable
    /* JADX INFO: renamed from: ComposeImageButton-PZ-HvWI, reason: not valid java name */
    public static final void m21713ComposeImageButtonPZHvWI(@NotNull final ImageData data, final float f, final long j, @Nullable Modifier modifier, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(187399647);
        Modifier modifier2 = (i2 & 8) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(187399647, i, -1, "androidx.glance.oneui.template.component.compose.ComposeImageButton (ImageButton.kt:33)");
        }
        m21712ComposeImageButtonLFFoFBE(data, f, C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(f - C2256Dp.m20968constructorimpl(0.6667f * f)) / 2), j, 0, modifier2, composerStartRestartGroup, (i & 112) | 24584 | ((i << 3) & 7168) | ((i << 6) & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ImageButtonKt.ComposeImageButton.1
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
                    ImageButtonKt.m21713ComposeImageButtonPZHvWI(data, f, j, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ComposeImageButton-djqs-MU, reason: not valid java name */
    public static final void m21714ComposeImageButtondjqsMU(@NotNull final ImageWithBackgroundData data, final float f, final float f4, @Nullable Modifier modifier, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-414417106);
        Modifier modifier2 = (i2 & 8) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-414417106, i, -1, "androidx.glance.oneui.template.component.compose.ComposeImageButton (ImageButton.kt:56)");
        }
        ColorProvider backgroundColor = data.getBackgroundColor();
        composerStartRestartGroup.startReplaceableGroup(129460138);
        Color colorM18515boximpl = backgroundColor == null ? null : Color.m18515boximpl(ComposeUtilsKt.convert(backgroundColor, composerStartRestartGroup, 8));
        composerStartRestartGroup.endReplaceableGroup();
        m21717ImageButtonInternalTbyQ11s(data, f, f4, colorM18515boximpl, data.getBackgroundResId(), modifier2, composerStartRestartGroup, (i & 112) | 8 | (i & 896) | ((i << 6) & 458752));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ImageButtonKt.ComposeImageButton.3
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
                    ImageButtonKt.m21714ComposeImageButtondjqsMU(data, f, f4, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ComposeImageButton-uDo3WH8, reason: not valid java name */
    public static final void m21715ComposeImageButtonuDo3WH8(@NotNull final ImageData data, @DimenRes final int i, @DimenRes final int i2, final long j, @Nullable Modifier modifier, @Nullable Composer composer, final int i4, final int i5) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1376276507);
        Modifier modifier2 = (i5 & 16) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1376276507, i4, -1, "androidx.glance.oneui.template.component.compose.ComposeImageButton (ImageButton.kt:74)");
        }
        m21717ImageButtonInternalTbyQ11s(data, PrimitiveResources_androidKt.dimensionResource(i, composerStartRestartGroup, (i4 >> 3) & 14), PrimitiveResources_androidKt.dimensionResource(i2, composerStartRestartGroup, (i4 >> 6) & 14), Color.m18515boximpl(j), 0, modifier2, composerStartRestartGroup, (i4 & 7168) | 24584 | (458752 & (i4 << 3)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ImageButtonKt.ComposeImageButton.4
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
                    ImageButtonKt.m21715ComposeImageButtonuDo3WH8(data, i, i2, j, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ImageButtonInternal-BAq54LU, reason: not valid java name */
    public static final void m21716ImageButtonInternalBAq54LU(final ImageData imageData, final Color color, @DrawableRes final int i, final Modifier modifier, Composer composer, final int i2) {
        Color colorM18515boximpl;
        Composer composerStartRestartGroup = composer.startRestartGroup(1026404821);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1026404821, i2, -1, "androidx.glance.oneui.template.component.compose.ImageButtonInternal (ImageButton.kt:131)");
        }
        ImageProvider imageProvider = imageData.getImageProvider();
        String contentDescription = imageData.getContentDescription();
        ColorProvider imageTintColor = imageData.getImageTintColor();
        if (color != null) {
            colorM18515boximpl = Color.m18515boximpl(imageData.getImageType() == ImageType.AppIcon ? Color.INSTANCE.m18560getTransparent0d7_KjU() : color.m18535unboximpl());
        } else {
            colorM18515boximpl = null;
        }
        ComposeUtilsKt.m21961ImageButtonucPst7w(imageProvider, contentDescription, modifier, colorM18515boximpl, i, 0.0f, 0.0f, imageData.getImageType() == ImageType.Image ? ContentScale.INSTANCE.getCrop() : ContentScale.INSTANCE.getFit(), imageTintColor, 0.0f, 0.0f, composerStartRestartGroup, ((i2 >> 3) & 896) | 134217736 | ((i2 << 6) & 57344), 0, 1632);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ImageButtonKt$ImageButtonInternal$2
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
                    ImageButtonKt.m21716ImageButtonInternalBAq54LU(imageData, color, i, modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ImageButtonInternal-TbyQ11s, reason: not valid java name */
    public static final void m21717ImageButtonInternalTbyQ11s(final ImageData imageData, final float f, final float f4, final Color color, @DrawableRes final int i, final Modifier modifier, Composer composer, final int i2) {
        Color colorM18515boximpl;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1042139243);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1042139243, i2, -1, "androidx.glance.oneui.template.component.compose.ImageButtonInternal (ImageButton.kt:91)");
        }
        boolean zM21550equalsimpl0 = AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21571getTinyrx25Pp4());
        ImageProvider imageProvider = imageData.getImageProvider();
        String contentDescription = imageData.getContentDescription();
        ColorProvider imageTintColor = imageData.getImageTintColor();
        if (color != null) {
            colorM18515boximpl = Color.m18515boximpl(imageData.getImageType() == ImageType.AppIcon ? Color.INSTANCE.m18560getTransparent0d7_KjU() : color.m18535unboximpl());
        } else {
            colorM18515boximpl = null;
        }
        ContentScale crop = imageData.getImageType() == ImageType.Image ? ContentScale.INSTANCE.getCrop() : ContentScale.INSTANCE.getFit();
        float fM20968constructorimpl = imageData.getImageType() != ImageType.AppIcon ? f : C2256Dp.m20968constructorimpl(0);
        float fM20968constructorimpl2 = imageData.getImageType() == ImageType.Icon ? f4 : C2256Dp.m20968constructorimpl(0);
        Modifier modifierFillMaxSize$default = C2256Dp.m20973equalsimpl0(f, C2256Dp.m20968constructorimpl((float) 0)) ? SizeKt.fillMaxSize$default(modifier, 0.0f, 1, null) : SizeKt.m15899size3ABfNKs(modifier, f);
        composerStartRestartGroup.startReplaceableGroup(1023638096);
        float fM21066getWidthD9Ej5fM = zM21550equalsimpl0 ? DpSize.m21066getWidthD9Ej5fM(((DpSize) composerStartRestartGroup.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue()) : f;
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.startReplaceableGroup(1023638166);
        float fM21064getHeightD9Ej5fM = zM21550equalsimpl0 ? DpSize.m21064getHeightD9Ej5fM(((DpSize) composerStartRestartGroup.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue()) : f;
        composerStartRestartGroup.endReplaceableGroup();
        ComposeUtilsKt.m21961ImageButtonucPst7w(imageProvider, contentDescription, modifierFillMaxSize$default, colorM18515boximpl, i, fM20968constructorimpl, fM20968constructorimpl2, crop, imageTintColor, fM21066getWidthD9Ej5fM, fM21064getHeightD9Ej5fM, composerStartRestartGroup, (57344 & i2) | 134217736, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ImageButtonKt$ImageButtonInternal$1
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
                    ImageButtonKt.m21717ImageButtonInternalTbyQ11s(imageData, f, f4, color, i, modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }
}
