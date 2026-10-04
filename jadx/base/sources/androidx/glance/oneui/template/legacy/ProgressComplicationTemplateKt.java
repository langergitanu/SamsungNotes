package androidx.glance.oneui.template.legacy;

import android.os.Build;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.TextUnitKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.AbstractC2821a;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.action.Action;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.BoxKt;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.ProgressType;
import androidx.glance.oneui.template.TextType;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a-\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010\n\u001a5\u0010\u0005\u001a\u00020\u00012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010\r\u001a3\u0010\u000e\u001a\u00020\u00012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0003¢\u0006\u0002\u0010\r\u001a+\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0003¢\u0006\u0002\u0010\n¨\u0006\u0010"}, m13886d2 = {"CircularProgressContent", "", "item", "Landroidx/glance/oneui/template/legacy/ProgressTemplateItem;", "(Landroidx/glance/oneui/template/legacy/ProgressTemplateItem;Landroidx/compose/runtime/Composer;I)V", "ProgressComplicationTemplate", "action", "Landroidx/glance/action/Action;", "contentDescription", "", "(Landroidx/glance/oneui/template/legacy/ProgressTemplateItem;Landroidx/glance/action/Action;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", XmlErrorCodes.LIST, "", "(Ljava/util/List;Landroidx/glance/action/Action;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "WidgetLayoutSmall", "WidgetLayoutTiny", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nProgressComplicationTemplate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProgressComplicationTemplate.kt\nandroidx/glance/oneui/template/legacy/ProgressComplicationTemplateKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,243:1\n154#2:244\n*S KotlinDebug\n*F\n+ 1 ProgressComplicationTemplate.kt\nandroidx/glance/oneui/template/legacy/ProgressComplicationTemplateKt\n*L\n127#1:244\n*E\n"})
public final class ProgressComplicationTemplateKt {
    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void CircularProgressContent(final ProgressTemplateItem progressTemplateItem, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(601612898);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(601612898, i, -1, "androidx.glance.oneui.template.legacy.CircularProgressContent (ProgressComplicationTemplate.kt:198)");
        }
        if (progressTemplateItem.getText() != null) {
            composerStartRestartGroup.startReplaceableGroup(-1352420281);
            BoxKt.Box(SizeModifiersKt.fillMaxHeight(SizeModifiersKt.wrapContentWidth(GlanceModifier.INSTANCE)), Alignment.INSTANCE.getCenter(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1169480201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.CircularProgressContent.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                @Composable
                public final void invoke(@Nullable Composer composer2, int i2) {
                    if ((i2 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1169480201, i2, -1, "androidx.glance.oneui.template.legacy.CircularProgressContent.<anonymous> (ProgressComplicationTemplate.kt:205)");
                    }
                    GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                    float f = (float) 2.5d;
                    GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.fillMaxHeight(SizeModifiersKt.wrapContentWidth(companion)), 0.0f, C2256Dp.m20968constructorimpl(f), 0.0f, 0.0f, 13, null);
                    Alignment.Companion companion2 = Alignment.INSTANCE;
                    Alignment topCenter = companion2.getTopCenter();
                    final ProgressTemplateItem progressTemplateItem2 = progressTemplateItem;
                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, -451627545, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.CircularProgressContent.1.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                        @Composable
                        public final void invoke(@Nullable Composer composer3, int i4) {
                            if ((i4 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-451627545, i4, -1, "androidx.glance.oneui.template.legacy.CircularProgressContent.<anonymous>.<anonymous> (ProgressComplicationTemplate.kt:209)");
                            }
                            GlanceModifier glanceModifierWrapContentSize = SizeModifiersKt.wrapContentSize(GlanceModifier.INSTANCE);
                            Alignment center = Alignment.INSTANCE.getCenter();
                            final ProgressTemplateItem progressTemplateItem3 = progressTemplateItem2;
                            BoxKt.Box(glanceModifierWrapContentSize, center, ComposableLambdaKt.composableLambda(composer3, -692745015, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.CircularProgressContent.1.1.1
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer4, int i5) {
                                    if ((i5 & 11) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-692745015, i5, -1, "androidx.glance.oneui.template.legacy.CircularProgressContent.<anonymous>.<anonymous>.<anonymous> (ProgressComplicationTemplate.kt:213)");
                                    }
                                    GlanceAppWidgetTemplatesKt.TemplateProgressIndicator(progressTemplateItem3.getValue(), progressTemplateItem3.getType(), composer4, 0, 0);
                                    ImageData icon = progressTemplateItem3.getIcon();
                                    if (icon != null) {
                                        GlanceAppWidgetTemplatesKt.m21888TemplateIcon3Tup6A(icon, IconSize.INSTANCE.m21903getExtraSmallAKcXBXg(), composer4, 56);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer3, (Alignment.$stable << 3) | 384, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                    int i4 = Alignment.$stable;
                    BoxKt.Box(glanceModifierM21500paddingqDBjuR0$default, topCenter, composableLambda, composer2, (i4 << 3) | 384, 0);
                    GlanceModifier glanceModifierM21500paddingqDBjuR0$default2 = PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.fillMaxHeight(SizeModifiersKt.wrapContentWidth(companion)), 0.0f, 0.0f, 0.0f, C2256Dp.m20968constructorimpl(f), 7, null);
                    Alignment bottomCenter = companion2.getBottomCenter();
                    final ProgressTemplateItem progressTemplateItem3 = progressTemplateItem;
                    BoxKt.Box(glanceModifierM21500paddingqDBjuR0$default2, bottomCenter, ComposableLambdaKt.composableLambda(composer2, -286947234, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.CircularProgressContent.1.2
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                        @Composable
                        public final void invoke(@Nullable Composer composer3, int i5) {
                            if ((i5 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-286947234, i5, -1, "androidx.glance.oneui.template.legacy.CircularProgressContent.<anonymous>.<anonymous> (ProgressComplicationTemplate.kt:222)");
                            }
                            GlanceModifier glanceModifierM21505height3ABfNKs = SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.wrapContentWidth(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(19));
                            Alignment center = Alignment.INSTANCE.getCenter();
                            final ProgressTemplateItem progressTemplateItem4 = progressTemplateItem3;
                            BoxKt.Box(glanceModifierM21505height3ABfNKs, center, ComposableLambdaKt.composableLambda(composer3, -72601920, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.CircularProgressContent.1.2.1
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer4, int i6) {
                                    if ((i6 & 11) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-72601920, i6, -1, "androidx.glance.oneui.template.legacy.CircularProgressContent.<anonymous>.<anonymous>.<anonymous> (ProgressComplicationTemplate.kt:226)");
                                    }
                                    if (progressTemplateItem4.getText().length() <= 6) {
                                        composer4.startReplaceableGroup(-497827770);
                                        GlanceAppWidgetTemplatesKt.m21892TemplateText5OKhOMc(progressTemplateItem4.getText(), GlanceTheme.INSTANCE.getColors(composer4, GlanceTheme.$stable).getOnPrimary(), TextUnitKt.getSp(13), 0, 0, 0, 0, null, 0, composer4, 448, 504);
                                        composer4.endReplaceableGroup();
                                    } else {
                                        composer4.startReplaceableGroup(-497827656);
                                        GlanceAppWidgetTemplatesKt.m21893TemplateTexte4lg5Cc(progressTemplateItem4.getText(), TextType.INSTANCE.m21689getBodygxbDmow(), GlanceTheme.INSTANCE.getColors(composer4, GlanceTheme.$stable).getOnPrimary(), null, 0, composer4, 560, 24);
                                        composer4.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer3, (Alignment.$stable << 3) | 384, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, (i4 << 3) | 384, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1352418817);
            BoxKt.Box(SizeModifiersKt.wrapContentSize(GlanceModifier.INSTANCE), Alignment.INSTANCE.getCenter(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 115227424, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.CircularProgressContent.2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                @Composable
                public final void invoke(@Nullable Composer composer2, int i2) {
                    if ((i2 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(115227424, i2, -1, "androidx.glance.oneui.template.legacy.CircularProgressContent.<anonymous> (ProgressComplicationTemplate.kt:237)");
                    }
                    GlanceAppWidgetTemplatesKt.TemplateProgressIndicator(progressTemplateItem.getValue(), ProgressType.Circular, composer2, 48, 0);
                    ImageData icon = progressTemplateItem.getIcon();
                    if (icon != null) {
                        GlanceAppWidgetTemplatesKt.m21888TemplateIcon3Tup6A(icon, IconSize.INSTANCE.m21906getSmallAKcXBXg(), composer2, 56);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.CircularProgressContent.3
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
                    ProgressComplicationTemplateKt.CircularProgressContent(progressTemplateItem, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Deprecated(message = "It is provided only for One UI 6.x. It is not displayed normally on the device other than One UI 6.x. For a guide to template for One UI 7, refer to wiki page [One UI 7 App Widget Provider].")
    @Composable
    public static final void ProgressComplicationTemplate(@NotNull final ProgressTemplateItem item, @Nullable Action action, @Nullable String str, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(item, "item");
        Composer composerStartRestartGroup = composer.startRestartGroup(727708393);
        final Action action2 = (i2 & 2) != 0 ? null : action;
        final String str2 = (i2 & 4) != 0 ? null : str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(727708393, i, -1, "androidx.glance.oneui.template.legacy.ProgressComplicationTemplate (ProgressComplicationTemplate.kt:70)");
        }
        if (Build.VERSION.SDK_INT > 34) {
            composerStartRestartGroup.startReplaceableGroup(-1352301592);
            BoxKt.Box(GlanceAppWidgetTemplatesKt.createTopLevelModifier(null, str2, composerStartRestartGroup, ((i >> 3) & 112) | 6, 0), null, ComposableSingletons$ProgressComplicationTemplateKt.INSTANCE.m21882getLambda1$glance_oneui_template_release(), composerStartRestartGroup, 384, 2);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1352301479);
            WidgetLayoutTiny(item, action2, str2, composerStartRestartGroup, (i & 896) | 72, 0);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.ProgressComplicationTemplate.1
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
                    ProgressComplicationTemplateKt.ProgressComplicationTemplate(item, action2, str2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void WidgetLayoutSmall(final List<ProgressTemplateItem> list, final Action action, String str, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2030817227);
        if ((i2 & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        final String str2 = str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2030817227, i, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall (ProgressComplicationTemplate.kt:124)");
        }
        GlanceLog.INSTANCE.m2297d(GlanceTemplateLayout.TAG, "templateName=progress size=small dataType=multiple action=" + action);
        final float fM20968constructorimpl = C2256Dp.m20968constructorimpl((float) 17);
        final boolean z = list.get(0).getIcon() != null;
        if (list.get(0).getType() == ProgressType.Linear) {
            composerStartRestartGroup.startReplaceableGroup(1985845131);
            BoxKt.Box(GlanceAppWidgetTemplatesKt.createTopLevelModifier(action, str2, composerStartRestartGroup, ((i >> 3) & 112) | 8, 0), Alignment.INSTANCE.getCenter(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1130971428, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.WidgetLayoutSmall.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                @Composable
                public final void invoke(@Nullable Composer composer2, int i4) {
                    if ((i4 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1130971428, i4, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous> (ProgressComplicationTemplate.kt:133)");
                    }
                    GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
                    final boolean z2 = z;
                    final List<ProgressTemplateItem> list2 = list;
                    final float f = fM20968constructorimpl;
                    RowKt.m21502RowlMAjyxE(glanceModifierWrapContentHeight, 0, 0, ComposableLambdaKt.composableLambda(composer2, 1419761216, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.WidgetLayoutSmall.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                            invoke(rowScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                        @Composable
                        public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i5) {
                            Intrinsics.checkNotNullParameter(Row, "$this$Row");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1419761216, i5, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous>.<anonymous> (ProgressComplicationTemplate.kt:134)");
                            }
                            GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                            float f4 = 5;
                            GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.wrapContentSize(companion), C2256Dp.m20968constructorimpl(f4), 0.0f, 0.0f, 0.0f, 14, null);
                            final List<ProgressTemplateItem> list3 = list2;
                            final float f5 = f;
                            ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21500paddingqDBjuR0$default, 0, 0, ComposableLambdaKt.composableLambda(composer3, -201326666, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.WidgetLayoutSmall.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer4, Integer num) {
                                    invoke(columnScope, composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                @Composable
                                public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer4, int i6) {
                                    Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-201326666, i6, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous>.<anonymous>.<anonymous> (ProgressComplicationTemplate.kt:135)");
                                    }
                                    for (final ProgressTemplateItem progressTemplateItem : list3) {
                                        RowKt.m21502RowlMAjyxE(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.wrapContentWidth(GlanceModifier.INSTANCE), f5), 0, Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w(), ComposableLambdaKt.composableLambda(composer4, 1623740028, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.WidgetLayoutSmall.1.1.1.1
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer5, Integer num) {
                                                invoke(rowScope, composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                            @Composable
                                            public final void invoke(@NotNull RowScope Row2, @Nullable Composer composer5, int i7) {
                                                Intrinsics.checkNotNullParameter(Row2, "$this$Row");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1623740028, i7, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProgressComplicationTemplate.kt:140)");
                                                }
                                                ImageData icon = progressTemplateItem.getIcon();
                                                if (icon != null) {
                                                    GlanceAppWidgetTemplatesKt.m21888TemplateIcon3Tup6A(icon, IconSize.INSTANCE.m21907getTinyAKcXBXg(), composer5, 56);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer4, 3072, 2);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer3, 3072, 6);
                            GlanceModifier glanceModifierM21500paddingqDBjuR0$default2 = PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.wrapContentSize(companion), C2256Dp.m20968constructorimpl(z2 ? 3 : 7), 0.0f, 0.0f, 0.0f, 14, null);
                            final List<ProgressTemplateItem> list4 = list2;
                            final float f6 = f;
                            ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21500paddingqDBjuR0$default2, 0, 0, ComposableLambdaKt.composableLambda(composer3, -1155687699, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.WidgetLayoutSmall.1.1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer4, Integer num) {
                                    invoke(columnScope, composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                @Composable
                                public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer4, int i6) {
                                    Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1155687699, i6, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous>.<anonymous>.<anonymous> (ProgressComplicationTemplate.kt:149)");
                                    }
                                    for (final ProgressTemplateItem progressTemplateItem : list4) {
                                        RowKt.m21502RowlMAjyxE(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.wrapContentWidth(GlanceModifier.INSTANCE), f6), 0, Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w(), ComposableLambdaKt.composableLambda(composer4, 386748467, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.WidgetLayoutSmall.1.1.2.1
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer5, Integer num) {
                                                invoke(rowScope, composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                            @Composable
                                            public final void invoke(@NotNull RowScope Row2, @Nullable Composer composer5, int i7) {
                                                Intrinsics.checkNotNullParameter(Row2, "$this$Row");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(386748467, i7, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProgressComplicationTemplate.kt:154)");
                                                }
                                                String text = progressTemplateItem.getText();
                                                if (text != null) {
                                                    GlanceAppWidgetTemplatesKt.m21893TemplateTexte4lg5Cc(text, TextType.INSTANCE.m21689getBodygxbDmow(), GlanceTheme.INSTANCE.getColors(composer5, GlanceTheme.$stable).getOnSecondary(), null, 0, composer5, 560, 24);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer4, 3072, 2);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer3, 3072, 6);
                            GlanceModifier glanceModifierM21500paddingqDBjuR0$default3 = PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.wrapContentSize(companion), list2.get(0).getText() != null ? C2256Dp.m20968constructorimpl(4) : C2256Dp.m20968constructorimpl(f4), 0.0f, C2256Dp.m20968constructorimpl(9), 0.0f, 10, null);
                            final List<ProgressTemplateItem> list5 = list2;
                            final float f7 = f;
                            ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21500paddingqDBjuR0$default3, 0, 0, ComposableLambdaKt.composableLambda(composer3, 62591918, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.WidgetLayoutSmall.1.1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer4, Integer num) {
                                    invoke(columnScope, composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                @Composable
                                public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer4, int i6) {
                                    Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(62591918, i6, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous>.<anonymous>.<anonymous> (ProgressComplicationTemplate.kt:166)");
                                    }
                                    for (final ProgressTemplateItem progressTemplateItem : list5) {
                                        RowKt.m21502RowlMAjyxE(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), f7), 0, Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w(), ComposableLambdaKt.composableLambda(composer4, 1605028084, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.WidgetLayoutSmall.1.1.3.1
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer5, Integer num) {
                                                invoke(rowScope, composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                            @Composable
                                            public final void invoke(@NotNull RowScope Row2, @Nullable Composer composer5, int i7) {
                                                Intrinsics.checkNotNullParameter(Row2, "$this$Row");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1605028084, i7, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProgressComplicationTemplate.kt:171)");
                                                }
                                                GlanceAppWidgetTemplatesKt.TemplateProgressIndicator(progressTemplateItem.getValue(), ProgressType.Linear, composer5, 48, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer4, 3072, 2);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer3, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(1985847468);
            BoxKt.Box(GlanceAppWidgetTemplatesKt.createTopLevelModifier(action, str2, composerStartRestartGroup, ((i >> 3) & 112) | 8, 0), Alignment.INSTANCE.getCenter(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2038572787, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.WidgetLayoutSmall.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                @Composable
                public final void invoke(@Nullable Composer composer2, int i4) {
                    if ((i4 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2038572787, i4, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous> (ProgressComplicationTemplate.kt:185)");
                    }
                    GlanceModifier glanceModifierFillMaxHeight = SizeModifiersKt.fillMaxHeight(SizeModifiersKt.wrapContentWidth(GlanceModifier.INSTANCE));
                    int iM21431getCenterVerticallymnfRV0w = Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w();
                    final List<ProgressTemplateItem> list2 = list;
                    RowKt.m21502RowlMAjyxE(glanceModifierFillMaxHeight, 0, iM21431getCenterVerticallymnfRV0w, ComposableLambdaKt.composableLambda(composer2, -1359886505, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.WidgetLayoutSmall.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                            invoke(rowScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                        @Composable
                        public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i5) {
                            Intrinsics.checkNotNullParameter(Row, "$this$Row");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1359886505, i5, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous>.<anonymous> (ProgressComplicationTemplate.kt:189)");
                            }
                            ProgressComplicationTemplateKt.CircularProgressContent(list2.get(0), composer3, 8);
                            AbstractC2821a.m2232w(8, GlanceModifier.INSTANCE, composer3, 0, 0);
                            ProgressComplicationTemplateKt.CircularProgressContent(list2.get(1), composer3, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 3072, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final List<ProgressTemplateItem> list2 = list;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.WidgetLayoutSmall.3
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
                    ProgressComplicationTemplateKt.WidgetLayoutSmall(list2, action, str2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void WidgetLayoutTiny(final ProgressTemplateItem progressTemplateItem, final Action action, String str, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1592098240);
        if ((i2 & 4) != 0) {
            str = null;
        }
        final String str2 = str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1592098240, i, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutTiny (ProgressComplicationTemplate.kt:109)");
        }
        GlanceLog.INSTANCE.m2297d(GlanceTemplateLayout.TAG, "templateName=progress size=tiny dataType=single action=" + action);
        BoxKt.Box(GlanceAppWidgetTemplatesKt.createTopLevelModifier(action, str2, composerStartRestartGroup, ((i >> 3) & 112) | 8, 0), Alignment.INSTANCE.getCenter(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 503648158, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.WidgetLayoutTiny.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i4) {
                if ((i4 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(503648158, i4, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutTiny.<anonymous> (ProgressComplicationTemplate.kt:115)");
                }
                ProgressComplicationTemplateKt.CircularProgressContent(progressTemplateItem, composer2, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.WidgetLayoutTiny.2
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
                    ProgressComplicationTemplateKt.WidgetLayoutTiny(progressTemplateItem, action, str2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Deprecated(message = "It is provided only for One UI 6.x. It is not displayed normally on the device other than One UI 6.x. For a guide to template for One UI 7, refer to wiki page [One UI 7 App Widget Provider].")
    @Composable
    public static final void ProgressComplicationTemplate(@Nullable List<ProgressTemplateItem> list, @Nullable Action action, @Nullable String str, @Nullable Composer composer, final int i, final int i2) {
        List<ProgressTemplateItem> list2;
        Action action2;
        String str2;
        final List<ProgressTemplateItem> list3;
        final Action action3;
        final String str3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1195484403);
        int i4 = i2 & 1;
        int i5 = i4 != 0 ? i | 2 : i;
        int i6 = i2 & 2;
        if (i6 != 0) {
            i5 |= 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            i5 |= 384;
        } else if ((i & 896) == 0) {
            i5 |= composerStartRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i2 & 3) == 3 && (i5 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            list3 = list;
            action3 = action;
            str3 = str;
        } else {
            if (i4 != 0) {
                list = CollectionsKt.emptyList();
            }
            if (i6 != 0) {
                action = null;
            }
            if (i7 != 0) {
                str = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1195484403, i5, -1, "androidx.glance.oneui.template.legacy.ProgressComplicationTemplate (ProgressComplicationTemplate.kt:96)");
            }
            if (Build.VERSION.SDK_INT > 34) {
                composerStartRestartGroup.startReplaceableGroup(-1352300597);
                BoxKt.Box(GlanceAppWidgetTemplatesKt.createTopLevelModifier(null, str, composerStartRestartGroup, ((i5 >> 3) & 112) | 6, 0), null, ComposableSingletons$ProgressComplicationTemplateKt.INSTANCE.m21883getLambda2$glance_oneui_template_release(), composerStartRestartGroup, 384, 2);
                composerStartRestartGroup.endReplaceableGroup();
                list2 = list;
                action2 = action;
                str2 = str;
            } else if (!list.isEmpty()) {
                composerStartRestartGroup.startReplaceableGroup(-1352300461);
                list2 = list;
                action2 = action;
                str2 = str;
                WidgetLayoutSmall(list2, action2, str2, composerStartRestartGroup, (i5 & 896) | 72, 0);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                list2 = list;
                action2 = action;
                str2 = str;
                composerStartRestartGroup.startReplaceableGroup(-1352300394);
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            list3 = list2;
            action3 = action2;
            str3 = str2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ProgressComplicationTemplateKt.ProgressComplicationTemplate.2
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
                    ProgressComplicationTemplateKt.ProgressComplicationTemplate(list3, action3, str3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
