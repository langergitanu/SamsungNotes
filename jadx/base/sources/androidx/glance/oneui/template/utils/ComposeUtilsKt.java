package androidx.glance.oneui.template.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.ClipKt;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shadow;
import androidx.compose.p109ui.layout.ContentScale;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.glance.AbstractC2821a;
import androidx.glance.ImageProvider;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.ContentScale;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.text.TextShadowStyle;
import androidx.glance.unit.ColorProvider;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0082\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\rH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0011\u0010\u0017\u001a\u00020\u0018*\u00020\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001a\u0016\u0010\u0017\u001a\u00020\u001b*\u00020\u001cH\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0016\u0010\u0017\u001a\u00020\u001f*\u00020 H\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u0016\u0010\u0017\u001a\u00020\u0010*\u00020#H\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a\u0011\u0010\u0017\u001a\u00020&*\u00020'H\u0001¢\u0006\u0002\u0010(\u001a\u0011\u0010\u0017\u001a\u00020\t*\u00020\u0012H\u0001¢\u0006\u0002\u0010)\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006*"}, m13886d2 = {"ImageButton", "", "provider", "Landroidx/glance/ImageProvider;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "backgroundResId", "", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "padding", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "contentTint", "Landroidx/glance/unit/ColorProvider;", "bitmapWidth", "bitmapHeight", "ImageButton-ucPst7w", "(Landroidx/glance/ImageProvider;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Color;IFFLandroidx/compose/ui/layout/ContentScale;Landroidx/glance/unit/ColorProvider;FFLandroidx/compose/runtime/Composer;III)V", MarkdownConverter.PREFIX_NAME, "Landroidx/compose/ui/Alignment;", "Landroidx/glance/layout/Alignment;", "(Landroidx/glance/layout/Alignment;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Alignment;", "Landroidx/compose/ui/Alignment$Horizontal;", "Landroidx/glance/layout/Alignment$Horizontal;", "convert-qKStY7A", "(ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Alignment$Horizontal;", "Landroidx/compose/ui/Alignment$Vertical;", "Landroidx/glance/layout/Alignment$Vertical;", "convert-r7CXYeA", "(ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Alignment$Vertical;", "Landroidx/glance/layout/ContentScale;", "convert-Nx_grj4", "(ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/ContentScale;", "Landroidx/compose/ui/graphics/Shadow;", "Landroidx/glance/text/TextShadowStyle;", "(Landroidx/glance/text/TextShadowStyle;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shadow;", "(Landroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;I)J", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nComposeUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComposeUtils.kt\nandroidx/glance/oneui/template/utils/ComposeUtilsKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 4 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 5 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 6 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n*L\n1#1,157:1\n74#2:158\n76#2:170\n74#2:197\n154#3:159\n154#3:160\n154#3:161\n154#3:162\n154#3:163\n154#3:196\n154#3:198\n154#3:199\n68#4,5:164\n73#4:195\n77#4:204\n75#5:169\n76#5,11:171\n89#5:203\n460#6,13:182\n473#6,3:200\n*S KotlinDebug\n*F\n+ 1 ComposeUtils.kt\nandroidx/glance/oneui/template/utils/ComposeUtilsKt\n*L\n34#1:158\n105#1:170\n117#1:197\n98#1:159\n99#1:160\n102#1:161\n103#1:162\n108#1:163\n116#1:196\n139#1:198\n153#1:199\n105#1:164,5\n105#1:195\n105#1:204\n105#1:169\n105#1:171,11\n105#1:203\n105#1:182,13\n105#1:200,3\n*E\n"})
public final class ComposeUtilsKt {
    /* JADX WARN: Removed duplicated region for block: B:70:0x0230  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ImageButton-ucPst7w, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21961ImageButtonucPst7w(@NotNull final ImageProvider provider, @Nullable final String str, @Nullable Modifier modifier, @Nullable Color color, @DrawableRes int i, float f, float f4, @Nullable ContentScale contentScale, @Nullable ColorProvider colorProvider, float f5, float f6, @Nullable Composer composer, final int i2, final int i4, final int i5) {
        Composer composer2;
        float f7;
        Intrinsics.checkNotNullParameter(provider, "provider");
        Composer composerStartRestartGroup = composer.startRestartGroup(1162623851);
        Modifier modifier2 = (i5 & 4) != 0 ? Modifier.INSTANCE : modifier;
        Color color2 = (i5 & 8) != 0 ? null : color;
        int i6 = (i5 & 16) != 0 ? 0 : i;
        float fM20968constructorimpl = (i5 & 32) != 0 ? C2256Dp.m20968constructorimpl(0) : f;
        float fM20968constructorimpl2 = (i5 & 64) != 0 ? C2256Dp.m20968constructorimpl(0) : f4;
        ContentScale fit = (i5 & 128) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        ColorProvider colorProvider2 = (i5 & 256) != 0 ? null : colorProvider;
        float fM20968constructorimpl3 = (i5 & 512) != 0 ? C2256Dp.m20968constructorimpl(0) : f5;
        float fM20968constructorimpl4 = (i5 & 1024) != 0 ? C2256Dp.m20968constructorimpl(0) : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1162623851, i2, i4, "androidx.glance.oneui.template.utils.ImageButton (ComposeUtils.kt:103)");
        }
        Modifier modifierM15409backgroundbw27NRU$default = (i6 != 0 || color2 == null) ? BackgroundKt.m15409backgroundbw27NRU$default(modifier2, Color.INSTANCE.m18560getTransparent0d7_KjU(), null, 2, null) : C2256Dp.m20967compareTo0680j_4(fM20968constructorimpl, C2256Dp.m20968constructorimpl((float) 0)) > 0 ? BackgroundKt.m15408backgroundbw27NRU(modifier2, color2.m18535unboximpl(), RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(fM20968constructorimpl)) : BackgroundKt.m15409backgroundbw27NRU$default(modifier2, color2.m18535unboximpl(), null, 2, null);
        Alignment center = Alignment.INSTANCE.getCenter();
        composerStartRestartGroup.startReplaceableGroup(733328855);
        Modifier modifier3 = modifierM15409backgroundbw27NRU$default;
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
        Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        final Modifier modifier4 = modifier2;
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        final Color color3 = color2;
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        final ContentScale contentScale2 = fit;
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier3);
        if (composerStartRestartGroup.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(-307938405);
        if (i6 != 0) {
            float f8 = 0;
            if (C2256Dp.m20967compareTo0680j_4(fM20968constructorimpl3, C2256Dp.m20968constructorimpl(f8)) <= 0 || C2256Dp.m20967compareTo0680j_4(fM20968constructorimpl4, C2256Dp.m20968constructorimpl(f8)) <= 0) {
                composer2 = composerStartRestartGroup;
                f7 = fM20968constructorimpl4;
            } else {
                Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                Drawable drawable = context.getDrawable(i6);
                if (drawable instanceof GradientDrawable) {
                    composerStartRestartGroup.startReplaceableGroup(1072252046);
                    float f9 = context.getResources().getDisplayMetrics().density;
                    f7 = fM20968constructorimpl4;
                    ImageKt.m15465Image5hnEew(AndroidImageBitmap_androidKt.asImageBitmap(DrawableKt.toBitmap$default(drawable, (int) (fM20968constructorimpl3 * f9), (int) (f9 * fM20968constructorimpl4), null, 4, null)), null, ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(fM20968constructorimpl)), null, null, 0.0f, null, 0, composerStartRestartGroup, 56, 248);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceableGroup();
                } else {
                    composer2 = composerStartRestartGroup;
                    f7 = fM20968constructorimpl4;
                    composer2.startReplaceableGroup(1072252630);
                    androidx.glance.oneui.template.component.compose.ImageKt.ComposeImage(new ImageData(androidx.glance.ImageKt.ImageProvider(i6), null, null, null, null, false, 60, null), ClipKt.clip(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(fM20968constructorimpl)), null, C2256Dp.m20967compareTo0680j_4(fM20968constructorimpl, C2256Dp.m20968constructorimpl(f8)) > 0, composer2, 8, 4);
                    composer2.endReplaceableGroup();
                }
            }
        }
        composer2.endReplaceableGroup();
        final ColorProvider colorProvider3 = colorProvider2;
        androidx.glance.oneui.template.component.compose.ImageKt.ComposeImage(new ImageData(provider, str, null, colorProvider3, null, false, 52, null), PaddingKt.m15854padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), fM20968constructorimpl2), contentScale2, C2256Dp.m20967compareTo0680j_4(fM20968constructorimpl, C2256Dp.m20968constructorimpl((float) 0)) > 0, composer2, ((i2 >> 15) & 896) | 8, 0);
        if (AbstractC2821a.m2209D(composer2)) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final float f10 = f7;
            final float f11 = fM20968constructorimpl2;
            final float f12 = fM20968constructorimpl3;
            final int i7 = i6;
            final float f13 = fM20968constructorimpl;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.utils.ComposeUtilsKt$ImageButton$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer3, int i8) {
                    ComposeUtilsKt.m21961ImageButtonucPst7w(provider, str, modifier4, color3, i7, f13, f11, contentScale2, colorProvider3, f12, f10, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                }
            });
        }
    }

    @Composable
    public static final long convert(@NotNull ColorProvider colorProvider, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(colorProvider, "<this>");
        composer.startReplaceableGroup(-126565321);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-126565321, i, -1, "androidx.glance.oneui.template.utils.convert (ComposeUtils.kt:32)");
        }
        long jMo21422getColorvNxB06k = colorProvider.mo21422getColorvNxB06k((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return jMo21422getColorvNxB06k;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: convert-Nx_grj4, reason: not valid java name */
    public static final ContentScale m21962convertNx_grj4(int i, @Nullable Composer composer, int i2) {
        composer.startReplaceableGroup(-127429770);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-127429770, i2, -1, "androidx.glance.oneui.template.utils.convert (ComposeUtils.kt:37)");
        }
        ContentScale.Companion companion = androidx.glance.layout.ContentScale.INSTANCE;
        androidx.compose.p109ui.layout.ContentScale crop = androidx.glance.layout.ContentScale.m21461equalsimpl0(i, companion.m21465getCropAe3V0ko()) ? androidx.compose.p109ui.layout.ContentScale.INSTANCE.getCrop() : androidx.glance.layout.ContentScale.m21461equalsimpl0(i, companion.m21467getFitAe3V0ko()) ? androidx.compose.p109ui.layout.ContentScale.INSTANCE.getFit() : androidx.compose.p109ui.layout.ContentScale.INSTANCE.getFillBounds();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return crop;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: convert-qKStY7A, reason: not valid java name */
    public static final Alignment.Horizontal m21963convertqKStY7A(int i, @Nullable Composer composer, int i2) {
        Alignment.Horizontal end;
        composer.startReplaceableGroup(-123228708);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-123228708, i2, -1, "androidx.glance.oneui.template.utils.convert (ComposeUtils.kt:46)");
        }
        Alignment.Horizontal.Companion companion = Alignment.Horizontal.INSTANCE;
        if (Alignment.Horizontal.m21438equalsimpl0(i, companion.m21442getCenterHorizontallyPGIyAqw())) {
            end = androidx.compose.p109ui.Alignment.INSTANCE.getCenterHorizontally();
        } else if (Alignment.Horizontal.m21438equalsimpl0(i, companion.m21444getStartPGIyAqw())) {
            end = androidx.compose.p109ui.Alignment.INSTANCE.getStart();
        } else {
            if (!Alignment.Horizontal.m21438equalsimpl0(i, companion.m21443getEndPGIyAqw())) {
                throw new IllegalArgumentException(AbstractC0541b.m772n("Unknown Alignment.Horizontal: ", Alignment.Horizontal.m21440toStringimpl(i)));
            }
            end = androidx.compose.p109ui.Alignment.INSTANCE.getEnd();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return end;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: convert-r7CXYeA, reason: not valid java name */
    public static final Alignment.Vertical m21964convertr7CXYeA(int i, @Nullable Composer composer, int i2) {
        Alignment.Vertical bottom;
        composer.startReplaceableGroup(1883979392);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1883979392, i2, -1, "androidx.glance.oneui.template.utils.convert (ComposeUtils.kt:59)");
        }
        Alignment.Vertical.Companion companion = Alignment.Vertical.INSTANCE;
        if (Alignment.Vertical.m21448equalsimpl0(i, companion.m21453getCenterVerticallymnfRV0w())) {
            bottom = androidx.compose.p109ui.Alignment.INSTANCE.getCenterVertically();
        } else if (Alignment.Vertical.m21448equalsimpl0(i, companion.m21454getTopmnfRV0w())) {
            bottom = androidx.compose.p109ui.Alignment.INSTANCE.getTop();
        } else {
            if (!Alignment.Vertical.m21448equalsimpl0(i, companion.m21452getBottommnfRV0w())) {
                throw new IllegalArgumentException(AbstractC0541b.m772n("Unknown Alignment.Vertical: ", Alignment.Vertical.m21450toStringimpl(i)));
            }
            bottom = androidx.compose.p109ui.Alignment.INSTANCE.getBottom();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bottom;
    }

    @Composable
    @NotNull
    public static final androidx.compose.p109ui.Alignment convert(@NotNull androidx.glance.layout.Alignment alignment, @Nullable Composer composer, int i) {
        androidx.compose.p109ui.Alignment centerStart;
        Intrinsics.checkNotNullParameter(alignment, "<this>");
        composer.startReplaceableGroup(-1699587032);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1699587032, i, -1, "androidx.glance.oneui.template.utils.convert (ComposeUtils.kt:71)");
        }
        if (Alignment.Horizontal.m21438equalsimpl0(alignment.getHorizontal(), Alignment.Horizontal.INSTANCE.m21444getStartPGIyAqw())) {
            int vertical = alignment.getVertical();
            Alignment.Companion companion = androidx.glance.layout.Alignment.INSTANCE;
            if (Alignment.Vertical.m21448equalsimpl0(vertical, companion.m21434getTopmnfRV0w())) {
                centerStart = androidx.compose.p109ui.Alignment.INSTANCE.getTopStart();
            } else {
                centerStart = Alignment.Vertical.m21448equalsimpl0(vertical, companion.m21429getBottommnfRV0w()) ? androidx.compose.p109ui.Alignment.INSTANCE.getBottomStart() : androidx.compose.p109ui.Alignment.INSTANCE.getCenterStart();
            }
        } else {
            centerStart = androidx.compose.p109ui.Alignment.INSTANCE.getCenterStart();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return centerStart;
    }

    @Composable
    @NotNull
    public static final Shadow convert(@NotNull TextShadowStyle textShadowStyle, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(textShadowStyle, "<this>");
        composer.startReplaceableGroup(1430884892);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1430884892, i, -1, "androidx.glance.oneui.template.utils.convert (ComposeUtils.kt:85)");
        }
        Shadow shadow = new Shadow(textShadowStyle.getColor(), OffsetKt.Offset(textShadowStyle.getDx(), textShadowStyle.getDy()), textShadowStyle.getRadius(), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shadow;
    }
}
