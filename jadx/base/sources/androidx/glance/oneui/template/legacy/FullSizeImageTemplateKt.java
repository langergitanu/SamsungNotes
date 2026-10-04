package androidx.glance.oneui.template.legacy;

import android.os.Build;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.GlanceModifier;
import androidx.glance.ImageKt;
import androidx.glance.action.Action;
import androidx.glance.layout.BoxKt;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.ContentScale;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.oneui.template.ImageData;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a+\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0003¢\u0006\u0002\u0010\b¨\u0006\n"}, m13886d2 = {"FullSizeImageTemplate", "", "image", "Landroidx/glance/oneui/template/ImageData;", "action", "Landroidx/glance/action/Action;", "contentDescription", "", "(Landroidx/glance/oneui/template/ImageData;Landroidx/glance/action/Action;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "WidgetLayoutTiny", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class FullSizeImageTemplateKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Deprecated(message = "It is provided only for One UI 6.x. It is not displayed normally on the device other than One UI 6.x. For a guide to template for One UI 7, refer to wiki page [One UI 7 App Widget Provider].")
    @Composable
    public static final void FullSizeImageTemplate(@NotNull final ImageData image, @Nullable Action action, @Nullable String str, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(image, "image");
        Composer composerStartRestartGroup = composer.startRestartGroup(-662457994);
        final Action action2 = (i2 & 2) != 0 ? null : action;
        final String str2 = (i2 & 4) != 0 ? null : str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-662457994, i, -1, "androidx.glance.oneui.template.legacy.FullSizeImageTemplate (FullSizeImageTemplate.kt:32)");
        }
        if (Build.VERSION.SDK_INT > 34) {
            composerStartRestartGroup.startReplaceableGroup(569825500);
            BoxKt.Box(GlanceAppWidgetTemplatesKt.createTopLevelModifier(null, str2, composerStartRestartGroup, ((i >> 3) & 112) | 6, 0), null, ComposableSingletons$FullSizeImageTemplateKt.INSTANCE.m21881getLambda1$glance_oneui_template_release(), composerStartRestartGroup, 384, 2);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(569825613);
            WidgetLayoutTiny(image, action2, str2, composerStartRestartGroup, (i & 896) | 72, 0);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.FullSizeImageTemplateKt.FullSizeImageTemplate.1
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
                    FullSizeImageTemplateKt.FullSizeImageTemplate(image, action2, str2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void WidgetLayoutTiny(final ImageData imageData, final Action action, String str, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1660937487);
        if ((i2 & 4) != 0) {
            str = null;
        }
        final String str2 = str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1660937487, i, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutTiny (FullSizeImageTemplate.kt:45)");
        }
        GlanceLog.INSTANCE.m2297d(GlanceTemplateLayout.TAG, "templateName=full-image size=tiny dataType=single action=" + action);
        ColumnKt.m21455ColumnK4GKKTE(GlanceAppWidgetTemplatesKt.createTopLevelModifier(action, str2, composerStartRestartGroup, ((i >> 3) & 112) | 8, 0), 0, 0, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1694125159, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.FullSizeImageTemplateKt.WidgetLayoutTiny.1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                invoke(columnScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
            @Composable
            public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i4) {
                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1694125159, i4, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutTiny.<anonymous> (FullSizeImageTemplate.kt:48)");
                }
                ImageKt.m21259ImageGCr5PR4(imageData.getImageProvider(), imageData.getContentDescription(), SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), ContentScale.INSTANCE.m21466getFillBoundsAe3V0ko(), null, composer2, 8, 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.FullSizeImageTemplateKt.WidgetLayoutTiny.2
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
                    FullSizeImageTemplateKt.WidgetLayoutTiny(imageData, action, str2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
