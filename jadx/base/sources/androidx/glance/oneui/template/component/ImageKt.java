package androidx.glance.oneui.template.component;

import androidx.annotation.DimenRes;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.glance.GlanceModifier;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.TemplateCompositor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\b\u001a\u00020\u000f2\b\b\u0001\u0010\t\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0011\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, m13886d2 = {"TemplateImage", "", "data", "Landroidx/glance/oneui/template/ImageData;", "size", "Landroidx/compose/ui/unit/Dp;", "TemplateImage-ziNgDLE", "(Landroidx/glance/oneui/template/ImageData;FLandroidx/compose/runtime/Composer;I)V", "width", "height", "TemplateImage-73KfpEQ", "(Landroidx/glance/oneui/template/ImageData;FFLandroidx/compose/runtime/Composer;I)V", "modifier", "Landroidx/glance/GlanceModifier;", "(Landroidx/glance/oneui/template/ImageData;Landroidx/glance/GlanceModifier;Landroidx/compose/runtime/Composer;I)V", "", "(Landroidx/glance/oneui/template/ImageData;ILandroidx/compose/runtime/Composer;I)V", "(Landroidx/glance/oneui/template/ImageData;IILandroidx/compose/runtime/Composer;I)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Image.kt\nandroidx/glance/oneui/template/component/ImageKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,53:1\n74#2:54\n74#2:55\n74#2:56\n74#2:57\n*S KotlinDebug\n*F\n+ 1 Image.kt\nandroidx/glance/oneui/template/component/ImageKt\n*L\n15#1:54\n24#1:55\n33#1:56\n42#1:57\n*E\n"})
public final class ImageKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TemplateImage(@NotNull final ImageData data, @DimenRes final int i, @Nullable Composer composer, final int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(506858566);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(506858566, i2, -1, "androidx.glance.oneui.template.component.TemplateImage (Image.kt:31)");
        }
        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composerStartRestartGroup.startReplaceableGroup(1347346086);
            androidx.glance.oneui.template.component.glance.ImageKt.GlanceImage(data, i, composerStartRestartGroup, (i2 & 112) | 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(1347346131);
            androidx.glance.oneui.template.component.compose.ImageKt.ComposeImage(data, i, false, composerStartRestartGroup, (i2 & 112) | 392);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.ImageKt.TemplateImage.3
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
                    ImageKt.TemplateImage(data, i, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: TemplateImage-73KfpEQ, reason: not valid java name */
    public static final void m21705TemplateImage73KfpEQ(@NotNull ImageData data, float f, float f4, @Nullable Composer composer, final int i) {
        final ImageData imageData;
        final float f5;
        final float f6;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(910027043);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(910027043, i, -1, "androidx.glance.oneui.template.component.TemplateImage (Image.kt:22)");
        }
        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composerStartRestartGroup.startReplaceableGroup(1347345822);
            androidx.glance.oneui.template.component.glance.ImageKt.m21745GlanceImage73KfpEQ(data, f, f4, composerStartRestartGroup, (i & 112) | 8 | (i & 896));
            composerStartRestartGroup.endReplaceableGroup();
            imageData = data;
            f5 = f;
            f6 = f4;
        } else {
            composerStartRestartGroup.startReplaceableGroup(1347345876);
            imageData = data;
            f5 = f;
            f6 = f4;
            androidx.glance.oneui.template.component.compose.ImageKt.m21720ComposeImageWMci_g0(imageData, f5, f6, false, composerStartRestartGroup, (i & 112) | 3080 | (i & 896));
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.ImageKt.TemplateImage.2
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
                    ImageKt.m21705TemplateImage73KfpEQ(imageData, f5, f6, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: TemplateImage-ziNgDLE, reason: not valid java name */
    public static final void m21706TemplateImageziNgDLE(@NotNull final ImageData data, final float f, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1875795813);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1875795813, i, -1, "androidx.glance.oneui.template.component.TemplateImage (Image.kt:13)");
        }
        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composerStartRestartGroup.startReplaceableGroup(1347345574);
            androidx.glance.oneui.template.component.glance.ImageKt.m21747GlanceImageziNgDLE(data, f, composerStartRestartGroup, (i & 112) | 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(1347345619);
            androidx.glance.oneui.template.component.compose.ImageKt.m21721ComposeImagerAjV9yQ(data, f, false, composerStartRestartGroup, (i & 112) | 392);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.ImageKt.TemplateImage.1
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
                    ImageKt.m21706TemplateImageziNgDLE(data, f, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TemplateImage(@NotNull ImageData data, @DimenRes int i, @DimenRes int i2, @Nullable Composer composer, final int i4) {
        final ImageData imageData;
        final int i5;
        final int i6;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(317944553);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(317944553, i4, -1, "androidx.glance.oneui.template.component.TemplateImage (Image.kt:40)");
        }
        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composerStartRestartGroup.startReplaceableGroup(1347346356);
            androidx.glance.oneui.template.component.glance.ImageKt.GlanceImage(data, i, i2, composerStartRestartGroup, (i4 & 112) | 8 | (i4 & 896));
            composerStartRestartGroup.endReplaceableGroup();
            imageData = data;
            i5 = i;
            i6 = i2;
        } else {
            composerStartRestartGroup.startReplaceableGroup(1347346410);
            imageData = data;
            i5 = i;
            i6 = i2;
            androidx.glance.oneui.template.component.compose.ImageKt.ComposeImage(imageData, i5, i6, false, composerStartRestartGroup, (i4 & 112) | 3080 | (i4 & 896));
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.ImageKt.TemplateImage.4
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
                    ImageKt.TemplateImage(imageData, i5, i6, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1));
                }
            });
        }
    }

    @Composable
    public static final void TemplateImage(@NotNull final ImageData data, @NotNull final GlanceModifier modifier, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(-20064070);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-20064070, i, -1, "androidx.glance.oneui.template.component.TemplateImage (Image.kt:49)");
        }
        androidx.glance.oneui.template.component.glance.ImageKt.m21746GlanceImagecuCYCYk(data, modifier, 0, composerStartRestartGroup, (i & 112) | 8, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.ImageKt.TemplateImage.5
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
                    ImageKt.TemplateImage(data, modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
