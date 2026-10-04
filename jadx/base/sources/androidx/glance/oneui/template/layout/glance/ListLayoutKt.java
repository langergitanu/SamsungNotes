package androidx.glance.oneui.template.layout.glance;

import android.content.Context;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.BackgroundKt;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.appwidget.AppWidgetModifiersKt;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.appwidget.MarginKt;
import androidx.glance.appwidget.lazy.LazyItemScope;
import androidx.glance.appwidget.lazy.LazyListKt;
import androidx.glance.appwidget.lazy.LazyListScope;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.BoxKt;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.SpacerKt;
import androidx.glance.oneui.common.AppWidgetHostType;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.oneui.common.PreviewMode;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.CheckBoxListItem;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.CustomCheckBoxListItem;
import androidx.glance.oneui.template.CustomLeadingContentData;
import androidx.glance.oneui.template.CustomListItem;
import androidx.glance.oneui.template.ImageWithBackgroundData;
import androidx.glance.oneui.template.LeadingContentData;
import androidx.glance.oneui.template.ListData;
import androidx.glance.oneui.template.ListItem;
import androidx.glance.oneui.template.ListItemCategory;
import androidx.glance.oneui.template.ProgressListItem;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.oneui.template.component.glance.ImageKt;
import androidx.glance.oneui.template.component.glance.ProgressIndicatorKt;
import androidx.glance.oneui.template.component.glance.TextKt;
import androidx.glance.oneui.template.layout.CommonDimensions;
import androidx.glance.oneui.template.layout.ListLayoutDimensions;
import androidx.glance.oneui.template.layout.ListLayoutTextSizes;
import androidx.glance.oneui.template.layout.TextSize;
import androidx.glance.oneui.template.utils.Debug;
import androidx.glance.oneui.template.utils.GlanceModifierUtilsKt;
import androidx.glance.oneui.template.utils.ResourceUtilsKt;
import androidx.glance.text.TextPercentData;
import androidx.glance.unit.ColorProvider;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aV\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001aV\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a>\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010&\u001a\u00020\u0007H\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006)"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "GlanceListItem", "", "item", "Landroidx/glance/oneui/template/ListItem;", "index", "", "visibleItemCount", "listAlignment", "Landroidx/glance/layout/Alignment$Vertical;", "modifier", "Landroidx/glance/GlanceModifier;", "hasPaddingStart", "", "hasPaddingEnd", "dividerColor", "Landroidx/glance/unit/ColorProvider;", "GlanceListItem-ajneRBI", "(Landroidx/glance/oneui/template/ListItem;IIILandroidx/glance/GlanceModifier;ZZLandroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;II)V", "GlanceListLayout", "data", "Landroidx/glance/oneui/template/ListData;", "fillMaxWidth", "fillMaxHeight", "listPaddingTop", "Landroidx/compose/ui/unit/Dp;", "listPaddingBottom", "hasItemPaddingStart", "hasItemPaddingEnd", "GlanceListLayout-YlGCr2M", "(Landroidx/glance/oneui/template/ListData;ZZFFZZLandroidx/compose/runtime/Composer;II)V", "GlanceListText", "textData", "Landroidx/glance/oneui/template/TextData;", "textType", "Landroidx/glance/oneui/template/TextType;", "textColor", "visibleItemCountInSmall", "GlanceListText-e4lg5Cc", "(Landroidx/glance/oneui/template/TextData;ILandroidx/glance/unit/ColorProvider;Landroidx/glance/GlanceModifier;ILandroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nListLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListLayout.kt\nandroidx/glance/oneui/template/layout/glance/ListLayoutKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,604:1\n154#2:605\n154#2:606\n154#2:609\n174#2:612\n154#2:613\n154#2:614\n154#2:615\n154#2:616\n174#2:618\n154#2:619\n154#2:620\n154#2:621\n154#2:622\n154#2:623\n74#3:607\n74#3:608\n74#3:610\n74#3:611\n74#3:617\n*S KotlinDebug\n*F\n+ 1 ListLayout.kt\nandroidx/glance/oneui/template/layout/glance/ListLayoutKt\n*L\n68#1:605\n69#1:606\n199#1:609\n210#1:612\n216#1:613\n217#1:614\n221#1:615\n222#1:616\n295#1:618\n512#1:619\n513#1:620\n517#1:621\n519#1:622\n522#1:623\n77#1:607\n192#1:608\n204#1:610\n205#1:611\n290#1:617\n*E\n"})
public final class ListLayoutKt {

    @NotNull
    private static final String TAG = "GWT:ListLayout";

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: GlanceListItem-ajneRBI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21843GlanceListItemajneRBI(final ListItem listItem, final int i, final int i2, final int i4, final GlanceModifier glanceModifier, final boolean z, final boolean z2, ColorProvider colorProvider, Composer composer, int i5, final int i6) {
        int i7;
        final ColorProvider colorProvider2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1462819516);
        ColorProvider colorProvider3 = (i6 & 128) != 0 ? null : colorProvider;
        if (ComposerKt.isTraceInProgress()) {
            i7 = i5;
            ComposerKt.traceEventStart(1462819516, i7, -1, "androidx.glance.oneui.template.layout.glance.GlanceListItem (ListLayout.kt:190)");
        } else {
            i7 = i5;
        }
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        boolean z3 = i2 > 1 && i < i2 + (-1);
        GlanceLog.INSTANCE.m2301i(TAG, "GlanceListItem index : " + i + " isNotLastItem : " + z3);
        GlanceModifier glanceModifierM21286cornerRadius3ABfNKs = CornerRadiusKt.m21286cornerRadius3ABfNKs(GlanceModifierUtilsKt.contentDescription(GlanceModifierUtilsKt.maybeClickable$default(glanceModifier, listItem.getOnClick(), false, false, 0, 14, null), listItem.getContentDescription()), C2256Dp.m20968constructorimpl((float) 2));
        if (listItem instanceof ProgressListItem) {
            composerStartRestartGroup.startReplaceableGroup(-139730682);
            GlanceListItem_ajneRBI$ProgressListItem(listItem, mask, i, z, z2, glanceModifierM21286cornerRadius3ABfNKs, z3, composerStartRestartGroup, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            if (!(listItem instanceof ListItemCategory)) {
                composerStartRestartGroup.startReplaceableGroup(-139730601);
                colorProvider2 = colorProvider3;
                GlanceListItem_ajneRBI$DefaultListItem(listItem, mask, z, z2, z3, i4, i2, glanceModifierM21286cornerRadius3ABfNKs, colorProvider2, composerStartRestartGroup, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    final int i8 = i7;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt$GlanceListItem$1
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
                            ListLayoutKt.m21843GlanceListItemajneRBI(listItem, i, i2, i4, glanceModifier, z, z2, colorProvider2, composer2, RecomposeScopeImplKt.updateChangedFlags(i8 | 1), i6);
                        }
                    });
                    return;
                }
                return;
            }
            composerStartRestartGroup.startReplaceableGroup(-139730632);
            GlanceListItem_ajneRBI$CategoryText(listItem, glanceModifier, z, i, z2, composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
        }
        colorProvider2 = colorProvider3;
        if (ComposerKt.isTraceInProgress()) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    private static final void GlanceListItem_ajneRBI$CategoryText(final ListItem listItem, final GlanceModifier glanceModifier, final boolean z, final int i, final boolean z2, Composer composer, int i2) {
        Composer composer2;
        composer.startReplaceableGroup(860540429);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(860540429, i2, -1, "androidx.glance.oneui.template.layout.glance.GlanceListItem.CategoryText (ListLayout.kt:258)");
        }
        if (listItem instanceof ListItemCategory) {
            composer2 = composer;
            Debug.INSTANCE.debugBox(null, null, "List4", false, ComposableLambdaKt.composableLambda(composer, 1919428433, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt$GlanceListItem$CategoryText$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.traceEventStart(1919428433, i4, -1, "androidx.glance.oneui.template.layout.glance.GlanceListItem.CategoryText.<anonymous> (ListLayout.kt:261)");
                    }
                    ListLayoutKt.m21845GlanceListTexte4lg5Cc(listItem.getMainText(), TextType.INSTANCE.m21694getTitlegxbDmow(), GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable).getOnBackground(), MarginKt.m21309marginqDBjuR0(glanceModifier, z ? ListLayoutDimensions.INSTANCE.m21780getDefaultItemHorizontalPaddingD9Ej5fM() : CommonDimensions.INSTANCE.m21779getTextAdditionalPaddingD9Ej5fM(), C2256Dp.m20968constructorimpl(i != 0 ? 10 : 0), z2 ? ListLayoutDimensions.INSTANCE.m21780getDefaultItemHorizontalPaddingD9Ej5fM() : CommonDimensions.INSTANCE.m21779getTextAdditionalPaddingD9Ej5fM(), C2256Dp.m20968constructorimpl(6)), 0, composer3, 560, 16);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer2, 221568, 11);
        } else {
            composer2 = composer;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    private static final void GlanceListItem_ajneRBI$DefaultListItem(final ListItem listItem, int i, final boolean z, final boolean z2, final boolean z3, int i2, final int i4, final GlanceModifier glanceModifier, final ColorProvider colorProvider, Composer composer, int i5) {
        composer.startReplaceableGroup(-1193638494);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1193638494, i5, -1, "androidx.glance.oneui.template.layout.glance.GlanceListItem.DefaultListItem (ListLayout.kt:288)");
        }
        final Context context = (Context) composer.consume(androidx.glance.CompositionLocalsKt.getLocalContext());
        final float fM20968constructorimpl = C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, listItem.getSubText() != null ? C3094R.dimen.sesl_glance_list_default_item_medium_height_with_2_line : C3094R.dimen.sesl_glance_list_default_item_medium_height_with_1_line));
        GlanceModifier glanceModifierWrapContentHeight = listItem.getMainText().getMaxLines() >= 3 ? SizeModifiersKt.wrapContentHeight(GlanceModifier.INSTANCE) : SizeModifiersKt.m21505height3ABfNKs(GlanceModifier.INSTANCE, fM20968constructorimpl);
        final TypedTextData mainText = listItem.getMainText();
        if (TextType.m21684equalsimpl0(mainText.getTextType(), TextType.INSTANCE.m21691getDisplaygxbDmow())) {
            composer.startReplaceableGroup(-812833208);
            Debug.INSTANCE.debugBox(MarginKt.m21310marginqDBjuR0$default(SizeModifiersKt.wrapContentHeight(GlanceModifier.INSTANCE), z ? CommonDimensions.INSTANCE.m21775getLayoutHorizontalPaddingD9Ej5fM() : C2256Dp.m20968constructorimpl(0), 0.0f, z2 ? CommonDimensions.INSTANCE.m21775getLayoutHorizontalPaddingD9Ej5fM() : C2256Dp.m20968constructorimpl(0), z3 ? Alignment.Vertical.m21448equalsimpl0(i2, Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w()) ? C2256Dp.m20968constructorimpl(6) : C2256Dp.m20968constructorimpl(3) : C2256Dp.m20968constructorimpl(0), 2, null), null, "List8", false, ComposableLambdaKt.composableLambda(composer, -369623750, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt$GlanceListItem$DefaultListItem$1$2
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
                public final void invoke(@Nullable Composer composer2, int i6) {
                    if ((i6 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-369623750, i6, -1, "androidx.glance.oneui.template.layout.glance.GlanceListItem.DefaultListItem.<anonymous>.<anonymous> (ListLayout.kt:526)");
                    }
                    Debug.INSTANCE.debugBox(SizeModifiersKt.m21505height3ABfNKs(GlanceModifier.INSTANCE, fM20968constructorimpl), null, null, false, ComposableSingletons$ListLayoutKt.INSTANCE.m21831getLambda1$glance_oneui_template_release(), composer2, 221184, 14);
                    GlanceModifier glanceModifier2 = glanceModifier;
                    int iM21429getBottommnfRV0w = Alignment.INSTANCE.m21429getBottommnfRV0w();
                    final ListItem listItem2 = listItem;
                    final TypedTextData typedTextData = mainText;
                    RowKt.m21502RowlMAjyxE(glanceModifier2, 0, iM21429getBottommnfRV0w, ComposableLambdaKt.composableLambda(composer2, 740678742, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt$GlanceListItem$DefaultListItem$1$2.1
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
                        public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i7) {
                            Intrinsics.checkNotNullParameter(Row, "$this$Row");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(740678742, i7, -1, "androidx.glance.oneui.template.layout.glance.GlanceListItem.DefaultListItem.<anonymous>.<anonymous>.<anonymous> (ListLayout.kt:530)");
                            }
                            ListItem listItem3 = listItem2;
                            if (listItem3 instanceof CustomCheckBoxListItem) {
                                composer3.startReplaceableGroup(-533647111);
                                ListItem listItem4 = listItem2;
                                ((CustomCheckBoxListItem) listItem4).CustomContent((CustomCheckBoxListItem) listItem4, composer3, 0);
                                composer3.endReplaceableGroup();
                            } else if (listItem3 instanceof CustomListItem) {
                                composer3.startReplaceableGroup(-533647037);
                                ListItem listItem5 = listItem2;
                                ((CustomListItem) listItem5).CustomContent((CustomListItem) listItem5, composer3, 0);
                                composer3.endReplaceableGroup();
                            } else {
                                composer3.startReplaceableGroup(-533646981);
                                ListLayoutKt.m21845GlanceListTexte4lg5Cc(typedTextData, TextType.INSTANCE.m21691getDisplaygxbDmow(), ColorProvidersKt.override(GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable).getOnBackground(), typedTextData.getTextColor()), null, 0, composer3, 560, 24);
                                final TypedTextData subText = listItem2.getSubText();
                                if (subText != null) {
                                    Debug.INSTANCE.debugBox(PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.fillMaxHeight(Row.defaultWeight(GlanceModifier.INSTANCE)), 0.0f, 0.0f, 0.0f, C2256Dp.m20968constructorimpl(2), 7, null), Alignment.INSTANCE.getBottomStart(), "List9", false, ComposableLambdaKt.composableLambda(composer3, 1646838416, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt$GlanceListItem$DefaultListItem$1$2$1$1$1
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
                                        public final void invoke(@Nullable Composer composer4, int i8) {
                                            if ((i8 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1646838416, i8, -1, "androidx.glance.oneui.template.layout.glance.GlanceListItem.DefaultListItem.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ListLayout.kt:550)");
                                            }
                                            ListLayoutKt.m21845GlanceListTexte4lg5Cc(subText, TextType.INSTANCE.m21693getLabelgxbDmow(), ColorProvidersKt.override(GlanceTheme.INSTANCE.getColors(composer4, GlanceTheme.$stable).getOnSurfaceVariant(), subText.getTextColor()), null, 0, composer4, 560, 24);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer3, (Alignment.$stable << 3) | 221568, 8);
                                }
                                composer3.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 3072, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer, 221568, 10);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-812845304);
            final boolean z4 = AppWidgetSize.m21546compareToL2j3NV4(i, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) >= 0;
            final boolean z5 = listItem.getLeadingContentData() != null;
            final GlanceModifier glanceModifier2 = glanceModifierWrapContentHeight;
            ColumnKt.m21455ColumnK4GKKTE(SizeModifiersKt.wrapContentHeight(GlanceModifier.INSTANCE), 0, 0, ComposableLambdaKt.composableLambda(composer, -12403146, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt$GlanceListItem$DefaultListItem$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i6) {
                    GlanceModifier glanceModifierM21310marginqDBjuR0$default;
                    Intrinsics.checkNotNullParameter(Column, "$this$Column");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-12403146, i6, -1, "androidx.glance.oneui.template.layout.glance.GlanceListItem.DefaultListItem.<anonymous>.<anonymous> (ListLayout.kt:303)");
                    }
                    Debug debug = Debug.INSTANCE;
                    GlanceModifier glanceModifierM21310marginqDBjuR0$default2 = MarginKt.m21310marginqDBjuR0$default(glanceModifier2, z ? z4 ? z5 ? C2256Dp.m20968constructorimpl(14) : C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_list_item_start_padding_over_medium)) : ListLayoutDimensions.INSTANCE.m21781getSmallItemHorizontalPaddingD9Ej5fM() : z5 ? C2256Dp.m20968constructorimpl(0) : CommonDimensions.INSTANCE.m21779getTextAdditionalPaddingD9Ej5fM(), 0.0f, z2 ? z4 ? ListLayoutDimensions.INSTANCE.m21780getDefaultItemHorizontalPaddingD9Ej5fM() : ListLayoutDimensions.INSTANCE.m21781getSmallItemHorizontalPaddingD9Ej5fM() : CommonDimensions.INSTANCE.m21779getTextAdditionalPaddingD9Ej5fM(), (z3 && !z4 && i4 == 2) ? C2256Dp.m20968constructorimpl(2) : C2256Dp.m20968constructorimpl(0), 2, null);
                    final GlanceModifier glanceModifier3 = glanceModifier;
                    final boolean z6 = z5;
                    final boolean z7 = z4;
                    final Context context2 = context;
                    final ListItem listItem2 = listItem;
                    final int i7 = i4;
                    final TypedTextData typedTextData = mainText;
                    debug.debugBox(glanceModifierM21310marginqDBjuR0$default2, null, "List5", false, ComposableLambdaKt.composableLambda(composer2, -954312211, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt$GlanceListItem$DefaultListItem$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        public final void invoke(@Nullable Composer composer3, int i8) {
                            if ((i8 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-954312211, i8, -1, "androidx.glance.oneui.template.layout.glance.GlanceListItem.DefaultListItem.<anonymous>.<anonymous>.<anonymous> (ListLayout.kt:347)");
                            }
                            GlanceModifier glanceModifier4 = glanceModifier3;
                            int iM21431getCenterVerticallymnfRV0w = Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w();
                            final boolean z8 = z6;
                            final boolean z9 = z7;
                            final Context context3 = context2;
                            final ListItem listItem3 = listItem2;
                            final int i9 = i7;
                            final TypedTextData typedTextData2 = typedTextData;
                            RowKt.m21502RowlMAjyxE(glanceModifier4, 0, iM21431getCenterVerticallymnfRV0w, ComposableLambdaKt.composableLambda(composer3, -2130162679, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt.GlanceListItem.DefaultListItem.1.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                                    invoke(rowScope, composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                @Composable
                                public final void invoke(@NotNull RowScope Row, @Nullable Composer composer4, int i10) {
                                    Composer composer5 = composer4;
                                    Intrinsics.checkNotNullParameter(Row, "$this$Row");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2130162679, i10, -1, "androidx.glance.oneui.template.layout.glance.GlanceListItem.DefaultListItem.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ListLayout.kt:351)");
                                    }
                                    composer5.startReplaceableGroup(136850486);
                                    if (z8) {
                                        float fM20968constructorimpl2 = z9 ? C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context3, C3094R.dimen.sesl_glance_list_item_icon_size)) : C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context3, C3094R.dimen.sesl_glance_list_item_small_icon_size));
                                        if (listItem3.getLeadingContentData() instanceof CustomLeadingContentData) {
                                            composer5.startReplaceableGroup(136851079);
                                            Debug debug2 = Debug.INSTANCE;
                                            GlanceModifier glanceModifierM21506size3ABfNKs = SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, fM20968constructorimpl2);
                                            final ListItem listItem4 = listItem3;
                                            debug2.debugBox(glanceModifierM21506size3ABfNKs, null, "List6", false, ComposableLambdaKt.composableLambda(composer5, -1301208182, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt.GlanceListItem.DefaultListItem.1.1.1.1.1
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                    invoke(composer6, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                                @Composable
                                                public final void invoke(@Nullable Composer composer6, int i11) {
                                                    if ((i11 & 11) == 2 && composer6.getSkipping()) {
                                                        composer6.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1301208182, i11, -1, "androidx.glance.oneui.template.layout.glance.GlanceListItem.DefaultListItem.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ListLayout.kt:362)");
                                                    }
                                                    ((CustomLeadingContentData) listItem4.getLeadingContentData()).LeadingContent(composer6, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }), composer4, 221568, 10);
                                            composer5 = composer4;
                                            composer5.endReplaceableGroup();
                                        } else {
                                            composer5.startReplaceableGroup(136851333);
                                            LeadingContentData leadingContentData = listItem3.getLeadingContentData();
                                            ImageWithBackgroundData icon = leadingContentData != null ? leadingContentData.getIcon() : null;
                                            if (icon != null) {
                                                if (listItem3 instanceof CheckBoxListItem) {
                                                    composer5.startReplaceableGroup(1659923255);
                                                    composer5.startReplaceableGroup(1659923424);
                                                    icon.setImageTintColor$glance_oneui_template_release(GlanceTheme.INSTANCE.getColors(composer5, GlanceTheme.$stable).getOnBackground());
                                                    composer5.endReplaceableGroup();
                                                    ImageKt.m21747GlanceImageziNgDLE(icon, fM20968constructorimpl2, composer5, 8);
                                                    composer5.endReplaceableGroup();
                                                } else {
                                                    composer5.startReplaceableGroup(1659923812);
                                                    ImageKt.m21746GlanceImagecuCYCYk(icon, CornerRadiusKt.m21286cornerRadius3ABfNKs(BackgroundKt.background(SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, fM20968constructorimpl2), ColorProvidersKt.override(GlanceTheme.INSTANCE.getColors(composer5, GlanceTheme.$stable).getSurface(), icon.getBackgroundColor())), CommonDimensions.INSTANCE.m21773getDefaultCornerRadiusD9Ej5fM()), 0, composer5, 8, 4);
                                                    composer5.endReplaceableGroup();
                                                }
                                            }
                                            composer5.endReplaceableGroup();
                                        }
                                        SpacerKt.Spacer(SizeModifiersKt.m21508width3ABfNKs(GlanceModifier.INSTANCE, z9 ? C2256Dp.m20968constructorimpl(8) : i9 < 3 ? C2256Dp.m20968constructorimpl(4) : C2256Dp.m20968constructorimpl(3)), composer5, 0, 0);
                                    }
                                    composer5.endReplaceableGroup();
                                    ListItem listItem5 = listItem3;
                                    if (listItem5 instanceof CustomCheckBoxListItem) {
                                        composer5.startReplaceableGroup(136853736);
                                        ListItem listItem6 = listItem3;
                                        ((CustomCheckBoxListItem) listItem6).CustomContent((CustomCheckBoxListItem) listItem6, composer5, 0);
                                        composer5.endReplaceableGroup();
                                    } else if (listItem5 instanceof CustomListItem) {
                                        composer5.startReplaceableGroup(136853814);
                                        ListItem listItem7 = listItem3;
                                        ((CustomListItem) listItem7).CustomContent((CustomListItem) listItem7, composer5, 0);
                                        composer5.endReplaceableGroup();
                                    } else {
                                        composer5.startReplaceableGroup(136853874);
                                        GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.wrapContentHeight(Row.defaultWeight(GlanceModifier.INSTANCE)), 0.0f, z9 ? C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context3, C3094R.dimen.sesl_glance_list_item_top_padding)) : C2256Dp.m20968constructorimpl(0), 0.0f, z9 ? listItem3.getSubText() != null ? C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context3, C3094R.dimen.sesl_glance_list_item_bottom_padding_with_sub_text)) : C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context3, C3094R.dimen.sesl_glance_list_item_bottom_padding)) : C2256Dp.m20968constructorimpl(0), 5, null);
                                        final TypedTextData typedTextData3 = typedTextData2;
                                        final int i11 = i9;
                                        final ListItem listItem8 = listItem3;
                                        final boolean z10 = z8;
                                        ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21500paddingqDBjuR0$default, 0, 0, ComposableLambdaKt.composableLambda(composer5, 1347692722, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt.GlanceListItem.DefaultListItem.1.1.1.1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer6, Integer num) {
                                                invoke(columnScope, composer6, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                            @Composable
                                            public final void invoke(@NotNull ColumnScope Column2, @Nullable Composer composer6, int i12) {
                                                Intrinsics.checkNotNullParameter(Column2, "$this$Column");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1347692722, i12, -1, "androidx.glance.oneui.template.layout.glance.GlanceListItem.DefaultListItem.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ListLayout.kt:443)");
                                                }
                                                TypedTextData typedTextData4 = typedTextData3;
                                                TextType.Companion companion = TextType.INSTANCE;
                                                int iM21689getBodygxbDmow = companion.m21689getBodygxbDmow();
                                                GlanceTheme glanceTheme = GlanceTheme.INSTANCE;
                                                int i13 = GlanceTheme.$stable;
                                                ListLayoutKt.m21845GlanceListTexte4lg5Cc(typedTextData4, iM21689getBodygxbDmow, ColorProvidersKt.override(glanceTheme.getColors(composer6, i13).getOnBackground(), typedTextData3.getTextColor()), null, i11, composer6, 560, 8);
                                                if (listItem8.getSubText() != null) {
                                                    boolean z11 = z10;
                                                    ListItem listItem9 = listItem8;
                                                    SpacerKt.Spacer(SizeModifiersKt.m21505height3ABfNKs(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl((float) (z11 ? 0.8d : 0.71d))), composer6, 0, 0);
                                                    ListLayoutKt.m21845GlanceListTexte4lg5Cc(listItem9.getSubText(), companion.m21690getDescriptiongxbDmow(), ColorProvidersKt.override(glanceTheme.getColors(composer6, i13).getOnSurfaceVariant(), listItem9.getSubText().getTextColor()), null, 0, composer6, 560, 24);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer5, 3072, 6);
                                        composer4.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer3, 3072, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 221568, 10);
                    if (z4 && z3) {
                        float f = ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_list_default_item_icon_start_padding);
                        boolean z8 = z;
                        if (z8 && z2) {
                            glanceModifierM21310marginqDBjuR0$default = MarginKt.m21310marginqDBjuR0$default(GlanceModifier.INSTANCE, z5 ? C2256Dp.m20968constructorimpl(f) : CommonDimensions.INSTANCE.m21775getLayoutHorizontalPaddingD9Ej5fM(), 0.0f, CommonDimensions.INSTANCE.m21775getLayoutHorizontalPaddingD9Ej5fM(), 0.0f, 10, null);
                        } else if (z8) {
                            glanceModifierM21310marginqDBjuR0$default = MarginKt.m21310marginqDBjuR0$default(GlanceModifier.INSTANCE, z5 ? C2256Dp.m20968constructorimpl(f) : CommonDimensions.INSTANCE.m21775getLayoutHorizontalPaddingD9Ej5fM(), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            glanceModifierM21310marginqDBjuR0$default = z2 ? MarginKt.m21310marginqDBjuR0$default(GlanceModifier.INSTANCE, 0.0f, 0.0f, CommonDimensions.INSTANCE.m21775getLayoutHorizontalPaddingD9Ej5fM(), 0.0f, 11, null) : GlanceModifier.INSTANCE;
                        }
                        GlanceModifier glanceModifierWrapContentHeight2 = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(glanceModifierM21310marginqDBjuR0$default));
                        final ColorProvider colorProvider2 = colorProvider;
                        BoxKt.Box(glanceModifierWrapContentHeight2, null, ComposableLambdaKt.composableLambda(composer2, 476271325, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt$GlanceListItem$DefaultListItem$1$1.2
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
                            public final void invoke(@Nullable Composer composer3, int i8) {
                                if ((i8 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(476271325, i8, -1, "androidx.glance.oneui.template.layout.glance.GlanceListItem.DefaultListItem.<anonymous>.<anonymous>.<anonymous> (ListLayout.kt:502)");
                                }
                                TextBlockLayoutKt.GlanceDivider(false, colorProvider2, composer3, 70, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, 384, 2);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer, 3072, 6);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    private static final void GlanceListItem_ajneRBI$ProgressListItem(final ListItem listItem, final int i, int i2, boolean z, boolean z2, final GlanceModifier glanceModifier, final boolean z3, Composer composer, int i4) {
        GlanceModifier glanceModifierM21310marginqDBjuR0$default;
        composer.startReplaceableGroup(794143642);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(794143642, i4, -1, "androidx.glance.oneui.template.layout.glance.GlanceListItem.ProgressListItem (ListLayout.kt:201)");
        }
        if (listItem instanceof ProgressListItem) {
            Context context = (Context) composer.consume(androidx.glance.CompositionLocalsKt.getLocalContext());
            final int mask = ((AppWidgetHostType) composer.consume(CompositionLocalsKt.getLocalHostType())).getMask();
            float fM20968constructorimpl = AppWidgetHostType.m21524equalsimpl0(mask, AppWidgetHostType.INSTANCE.m21535getHomemn_SBp8()) ? C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_list_progress_item_start_padding_over_medium)) : CommonDimensions.INSTANCE.m21775getLayoutHorizontalPaddingD9Ej5fM();
            final boolean zM21550equalsimpl0 = AppWidgetSize.m21550equalsimpl0(i, AppWidgetSize.INSTANCE.m21573getWideSmallrx25Pp4());
            if (zM21550equalsimpl0) {
                glanceModifierM21310marginqDBjuR0$default = MarginKt.m21310marginqDBjuR0$default(GlanceModifier.INSTANCE, i2 == 0 ? CommonDimensions.INSTANCE.m21775getLayoutHorizontalPaddingD9Ej5fM() : C2256Dp.m20968constructorimpl(3), 0.0f, i2 == 0 ? C2256Dp.m20968constructorimpl(3) : CommonDimensions.INSTANCE.m21775getLayoutHorizontalPaddingD9Ej5fM(), 0.0f, 10, null);
            } else {
                GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                float fM20968constructorimpl2 = z ? fM20968constructorimpl : C2256Dp.m20968constructorimpl(0);
                if (!z2) {
                    fM20968constructorimpl = C2256Dp.m20968constructorimpl(0);
                }
                glanceModifierM21310marginqDBjuR0$default = MarginKt.m21310marginqDBjuR0$default(companion, fM20968constructorimpl2, 0.0f, fM20968constructorimpl, 0.0f, 10, null);
            }
            ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21310marginqDBjuR0$default, 0, 0, ComposableLambdaKt.composableLambda(composer, -91347989, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt$GlanceListItem$ProgressListItem$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i5) {
                    Intrinsics.checkNotNullParameter(Column, "$this$Column");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-91347989, i5, -1, "androidx.glance.oneui.template.layout.glance.GlanceListItem.ProgressListItem.<anonymous> (ListLayout.kt:225)");
                    }
                    Debug debug = Debug.INSTANCE;
                    GlanceModifier glanceModifier2 = glanceModifier;
                    final int i6 = i;
                    final ListItem listItem2 = listItem;
                    final int i7 = mask;
                    debug.debugBox(glanceModifier2, null, "List3", false, ComposableLambdaKt.composableLambda(composer2, 1159629652, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt$GlanceListItem$ProgressListItem$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        public final void invoke(@Nullable Composer composer3, int i8) {
                            if ((i8 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1159629652, i8, -1, "androidx.glance.oneui.template.layout.glance.GlanceListItem.ProgressListItem.<anonymous>.<anonymous> (ListLayout.kt:226)");
                            }
                            int i9 = i6;
                            AppWidgetSize.Companion companion2 = AppWidgetSize.INSTANCE;
                            if (AppWidgetSize.m21550equalsimpl0(i9, companion2.m21570getSmallrx25Pp4())) {
                                composer3.startReplaceableGroup(1304347901);
                                ProgressIndicatorKt.GlanceLinearProgressIndicator(((ProgressListItem) listItem2).getProgress(), 0, composer3, 8, 2);
                                composer3.endReplaceableGroup();
                            } else if (AppWidgetSize.m21550equalsimpl0(i9, companion2.m21573getWideSmallrx25Pp4())) {
                                composer3.startReplaceableGroup(1304348025);
                                ProgressIndicatorKt.m21748GlanceLinearProgressIndicatorziNgDLE(((ProgressListItem) listItem2).getProgress(), C2256Dp.m20968constructorimpl(26), composer3, 56);
                                composer3.endReplaceableGroup();
                            } else {
                                composer3.startReplaceableGroup(1304348137);
                                ProgressIndicatorKt.GlanceLinearProgressIndicator(((ProgressListItem) listItem2).getProgress(), AppWidgetHostType.m21524equalsimpl0(i7, AppWidgetHostType.INSTANCE.m21535getHomemn_SBp8()) ? C3094R.dimen.sesl_glance_list_progress_item_medium_height : C3094R.dimen.sesl_glance_list_progress_item_medium_height_at_monotone, composer3, 8, 0);
                                composer3.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 221568, 10);
                    if (z3 && !zM21550equalsimpl0) {
                        SpacerKt.Spacer((AppWidgetSize.m21546compareToL2j3NV4(i, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) < 0 || !AppWidgetHostType.m21524equalsimpl0(mask, AppWidgetHostType.INSTANCE.m21535getHomemn_SBp8())) ? SizeModifiersKt.m21505height3ABfNKs(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(4)) : SizeModifiersKt.height(GlanceModifier.INSTANCE, C3094R.dimen.sesl_glance_list_progress_item_medium_vertical_margin), composer2, 0, 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer, 3072, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: GlanceListLayout-YlGCr2M, reason: not valid java name */
    public static final void m21844GlanceListLayoutYlGCr2M(@NotNull final ListData data, boolean z, boolean z2, float f, float f4, boolean z3, boolean z4, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        float f5;
        float f6;
        GlanceModifier glanceModifierFillMaxHeight;
        Alignment centerStart;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(513138535);
        boolean z5 = (i2 & 2) != 0 ? true : z;
        final boolean z6 = (i2 & 4) != 0 ? true : z2;
        final float fM20968constructorimpl = (i2 & 8) != 0 ? C2256Dp.m20968constructorimpl(0) : f;
        float fM20968constructorimpl2 = (i2 & 16) != 0 ? C2256Dp.m20968constructorimpl(0) : f4;
        boolean z7 = (i2 & 32) != 0 ? true : z3;
        boolean z8 = (i2 & 64) != 0 ? true : z4;
        if (ComposerKt.isTraceInProgress()) {
            i4 = i;
            ComposerKt.traceEventStart(513138535, i4, -1, "androidx.glance.oneui.template.layout.glance.GlanceListLayout (ListLayout.kt:71)");
        } else {
            i4 = i;
        }
        if (data.getItems().isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final boolean z9 = z5;
                final float f7 = fM20968constructorimpl2;
                final boolean z10 = z7;
                final boolean z11 = z8;
                final int i5 = i4;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt$GlanceListLayout$1
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
                        ListLayoutKt.m21844GlanceListLayoutYlGCr2M(data, z9, z6, fM20968constructorimpl, f7, z10, z11, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        final boolean z12 = z5;
        final boolean z13 = z7;
        final boolean z14 = z8;
        final boolean z15 = z6;
        boolean z16 = AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) >= 0;
        if (z16) {
            float f8 = fM20968constructorimpl;
            float f9 = fM20968constructorimpl2;
            glanceModifierFillMaxHeight = PaddingKt.m21500paddingqDBjuR0$default(GlanceModifier.INSTANCE, 0.0f, f8, 0.0f, f9, 5, null);
            f5 = f8;
            f6 = f9;
        } else {
            f5 = fM20968constructorimpl;
            f6 = fM20968constructorimpl2;
            glanceModifierFillMaxHeight = GlanceModifier.INSTANCE;
        }
        if (z12) {
            glanceModifierFillMaxHeight = SizeModifiersKt.fillMaxWidth(glanceModifierFillMaxHeight);
        }
        if (z15) {
            glanceModifierFillMaxHeight = SizeModifiersKt.fillMaxHeight(glanceModifierFillMaxHeight);
        }
        final int contentAlign = data.getContentAlign();
        Debug debug = Debug.INSTANCE;
        if (!z16) {
            centerStart = Alignment.INSTANCE.getCenterStart();
        } else if (z15) {
            Alignment.Companion companion = Alignment.INSTANCE;
            centerStart = Alignment.Vertical.m21448equalsimpl0(contentAlign, companion.m21434getTopmnfRV0w()) ? companion.getTopStart() : Alignment.Vertical.m21448equalsimpl0(contentAlign, companion.m21431getCenterVerticallymnfRV0w()) ? companion.getCenterStart() : companion.getBottomStart();
        } else {
            centerStart = Alignment.INSTANCE.getTopStart();
        }
        final boolean z17 = z16;
        debug.debugBox(glanceModifierFillMaxHeight, centerStart, "List1", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1539868446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt$GlanceListLayout$2
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
            public final void invoke(@Nullable Composer composer2, int i6) {
                if ((i6 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1539868446, i6, -1, "androidx.glance.oneui.template.layout.glance.GlanceListLayout.<anonymous> (ListLayout.kt:110)");
                }
                final List listTake = CollectionsKt.take(data.getItems(), ListLayoutDimensions.INSTANCE.m21782getVisibleItemCountvA4zNRs(data.getItems(), contentAlign, composer2, 392));
                GlanceModifier glanceModifierWrapContentHeight = z12 ? SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)) : GlanceModifier.INSTANCE;
                composer2.startReplaceableGroup(-2111462779);
                boolean z18 = false;
                boolean z19 = z17 && !PreviewMode.m21609equalsimpl0(((PreviewMode) composer2.consume(CompositionLocalsKt.getLocalPreviewMode())).getMask(), PreviewMode.INSTANCE.m21614getDummyBmZA40c());
                composer2.endReplaceableGroup();
                if (z19) {
                    composer2.startReplaceableGroup(-2111462712);
                    GlanceModifier glanceModifierScrollToPosition = data.isScrollable$glance_oneui_template_release() ? glanceModifierWrapContentHeight : AppWidgetModifiersKt.scrollToPosition(glanceModifierWrapContentHeight, data.getScrollToPosition());
                    final int i7 = contentAlign;
                    final boolean z20 = z13;
                    final boolean z21 = z14;
                    final ListData listData = data;
                    final GlanceModifier glanceModifier = glanceModifierWrapContentHeight;
                    LazyListKt.m21344LazyColumnEiNPFjs(glanceModifierScrollToPosition, 0, new Function1<LazyListScope, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt$GlanceListLayout$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                            invoke2(lazyListScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull LazyListScope LazyColumn) {
                            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                            final List<ListItem> list = listTake;
                            final int i8 = i7;
                            final GlanceModifier glanceModifier2 = glanceModifier;
                            final boolean z22 = z20;
                            final boolean z23 = z21;
                            final ListData listData2 = listData;
                            LazyColumn.items(list.size(), new Function1<Integer, Long>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt$GlanceListLayout$2$1$invoke$$inlined$itemsIndexed$default$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @NotNull
                                public final Long invoke(int i9) {
                                    list.get(i9);
                                    return Long.MIN_VALUE;
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Long invoke(Integer num) {
                                    return invoke(num.intValue());
                                }
                            }, ComposableLambdaKt.composableLambdaInstance(-1405343893, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt$GlanceListLayout$2$1$invoke$$inlined$itemsIndexed$default$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer3, Integer num2) {
                                    invoke(lazyItemScope, num.intValue(), composer3, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                @Composable
                                public final void invoke(@NotNull LazyItemScope items, int i9, @Nullable Composer composer3, int i10) {
                                    int i11;
                                    Intrinsics.checkNotNullParameter(items, "$this$items");
                                    if ((i10 & 14) == 0) {
                                        i11 = (composer3.changed(items) ? 4 : 2) | i10;
                                    } else {
                                        i11 = i10;
                                    }
                                    if ((i10 & 112) == 0) {
                                        i11 |= composer3.changed(i9) ? 32 : 16;
                                    }
                                    if ((i11 & 731) == 146 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1405343893, i11, -1, "androidx.glance.appwidget.lazy.itemsIndexed.<anonymous> (LazyList.kt:241)");
                                    }
                                    ListLayoutKt.m21843GlanceListItemajneRBI((ListItem) list.get(i9), i9, list.size(), i8, glanceModifier2, z22, z23, listData2.getDividerColor(), composer3, (i11 & 112) | 16777224, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }));
                        }
                    }, composer2, 0, 2);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(-2111461969);
                    if (AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composer2.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21573getWideSmallrx25Pp4()) && (CollectionsKt.first((List) data.getItems()) instanceof ProgressListItem)) {
                        z18 = true;
                    }
                    composer2.endReplaceableGroup();
                    if (z18) {
                        composer2.startReplaceableGroup(-2111461850);
                        GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                        int iM21431getCenterVerticallymnfRV0w = Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w();
                        final boolean z22 = z13;
                        final boolean z23 = z14;
                        RowKt.m21502RowlMAjyxE(glanceModifierFillMaxSize, 0, iM21431getCenterVerticallymnfRV0w, ComposableLambdaKt.composableLambda(composer2, 897496630, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt$GlanceListLayout$2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                            public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i8) {
                                Intrinsics.checkNotNullParameter(Row, "$this$Row");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(897496630, i8, -1, "androidx.glance.oneui.template.layout.glance.GlanceListLayout.<anonymous>.<anonymous> (ListLayout.kt:147)");
                                }
                                final List<ListItem> list = listTake;
                                final boolean z24 = z22;
                                final boolean z25 = z23;
                                final int i9 = 0;
                                for (Object obj : list) {
                                    int i10 = i9 + 1;
                                    if (i9 < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    final ListItem listItem = (ListItem) obj;
                                    Debug.INSTANCE.debugBox(SizeModifiersKt.wrapContentHeight(Row.defaultWeight(GlanceModifier.INSTANCE)), null, "List2", false, ComposableLambdaKt.composableLambda(composer3, 2064898183, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt$GlanceListLayout$2$2$1$1
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

                                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                        @Composable
                                        public final void invoke(@Nullable Composer composer4, int i11) {
                                            if ((i11 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(2064898183, i11, -1, "androidx.glance.oneui.template.layout.glance.GlanceListLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ListLayout.kt:149)");
                                            }
                                            ListLayoutKt.m21843GlanceListItemajneRBI(listItem, i9, list.size(), Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w(), SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), z24, z25, null, composer4, 8, 128);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer3, 221568, 10);
                                    i9 = i10;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, 3072, 2);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(-2111461066);
                        final int i8 = contentAlign;
                        final boolean z24 = z13;
                        final boolean z25 = z14;
                        final ListData listData2 = data;
                        final GlanceModifier glanceModifier2 = glanceModifierWrapContentHeight;
                        ColumnKt.m21455ColumnK4GKKTE(glanceModifierWrapContentHeight, 0, 0, ComposableLambdaKt.composableLambda(composer2, -936427708, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt$GlanceListLayout$2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                                invoke(columnScope, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                            @Composable
                            public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer3, int i9) {
                                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-936427708, i9, -1, "androidx.glance.oneui.template.layout.glance.GlanceListLayout.<anonymous>.<anonymous> (ListLayout.kt:163)");
                                }
                                List<ListItem> list = listTake;
                                int i10 = i8;
                                GlanceModifier glanceModifier3 = glanceModifier2;
                                boolean z26 = z24;
                                boolean z27 = z25;
                                ListData listData3 = listData2;
                                int i11 = 0;
                                for (Object obj : list) {
                                    int i12 = i11 + 1;
                                    if (i11 < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    ListLayoutKt.m21843GlanceListItemajneRBI((ListItem) obj, i11, list.size(), i10, glanceModifier3, z26, z27, listData3.getDividerColor(), composer3, 16777224, 0);
                                    i11 = i12;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, 3072, 6);
                        composer2.endReplaceableGroup();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (Alignment.$stable << 3) | 221568, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            final float f10 = f5;
            final float f11 = f6;
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt$GlanceListLayout$3
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
                    ListLayoutKt.m21844GlanceListLayoutYlGCr2M(data, z12, z15, f10, f11, z13, z14, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: GlanceListText-e4lg5Cc, reason: not valid java name */
    public static final void m21845GlanceListTexte4lg5Cc(@NotNull final TextData textData, final int i, @NotNull final ColorProvider textColor, @Nullable GlanceModifier glanceModifier, int i2, @Nullable Composer composer, final int i4, final int i5) {
        TextSize labelText;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(-805958196);
        GlanceModifier glanceModifier2 = (i5 & 8) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        final int i6 = (i5 & 16) != 0 ? 2 : i2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-805958196, i4, -1, "androidx.glance.oneui.template.layout.glance.GlanceListText (ListLayout.kt:586)");
        }
        TextType.Companion companion = TextType.INSTANCE;
        if (TextType.m21684equalsimpl0(i, companion.m21691getDisplaygxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(-129999779);
            labelText = ListLayoutTextSizes.INSTANCE.getDisplayText(composerStartRestartGroup, 6);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (TextType.m21684equalsimpl0(i, companion.m21694getTitlegxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(-129999713);
            labelText = ListLayoutTextSizes.INSTANCE.getTitleText(composerStartRestartGroup, 6);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (TextType.m21684equalsimpl0(i, companion.m21689getBodygxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(-129999650);
            labelText = ListLayoutTextSizes.INSTANCE.bodyText(i6, composerStartRestartGroup, ((i4 >> 12) & 14) | 48, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (TextType.m21684equalsimpl0(i, companion.m21690getDescriptiongxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(-129999556);
            labelText = ListLayoutTextSizes.INSTANCE.getDescriptionText(composerStartRestartGroup, 6);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-129999496);
            labelText = ListLayoutTextSizes.INSTANCE.getLabelText(composerStartRestartGroup, 6);
            composerStartRestartGroup.endReplaceableGroup();
        }
        TextKt.GlanceText(textData, labelText, textColor, glanceModifier2, composerStartRestartGroup, (TextPercentData.$stable << 3) | 520 | (i4 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final GlanceModifier glanceModifier3 = glanceModifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.ListLayoutKt$GlanceListText$1
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
                    ListLayoutKt.m21845GlanceListTexte4lg5Cc(textData, i, textColor, glanceModifier3, i6, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }
}
