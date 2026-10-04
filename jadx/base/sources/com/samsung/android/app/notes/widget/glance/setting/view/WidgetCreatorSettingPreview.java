package com.samsung.android.app.notes.widget.glance.setting.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.ImageKt;
import androidx.glance.appwidget.action.SendBroadcastActionKt;
import androidx.glance.color.ColorProviders;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.AppWidgetBackground;
import androidx.glance.oneui.template.BadgeData;
import androidx.glance.oneui.template.GridData;
import androidx.glance.oneui.template.GridItem;
import androidx.glance.oneui.template.GridTemplateKt;
import androidx.glance.oneui.template.ImageType;
import androidx.glance.oneui.template.ImageWithBackgroundData;
import androidx.glance.oneui.template.Shape;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.layout.TopLevelLayoutKt;
import androidx.glance.unit.ColorProviderKt;
import com.samsung.android.app.notes.C6635R;
import com.samsung.android.app.notes.glance.setting.presenter.WidgetCreatorSettingPresenter;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.glance.common.WidgetCreatorUtil;
import com.samsung.android.app.notes.widget.glance.list.setting.view.C6953f;
import com.samsung.android.app.notes.widget.glance.theme.WidgetCreatorThemeManger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\fJ$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eH\u0002J%\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorSettingPreview;", "", "parent", "Landroid/view/View;", "presenter", "Lcom/samsung/android/app/notes/glance/setting/presenter/WidgetCreatorSettingPresenter;", "<init>", "(Landroid/view/View;Lcom/samsung/android/app/notes/glance/setting/presenter/WidgetCreatorSettingPresenter;)V", "setContent", "", "requestTime", "", "(JLandroidx/compose/runtime/Composer;I)V", "gridData", "", "Landroidx/glance/oneui/template/GridItem;", "context", "Landroid/content/Context;", "selectedItems", "", "getShape", "Landroidx/glance/oneui/template/Shape;", "shapeBG", "backgrounOnOff", "", "size", "Landroidx/glance/oneui/common/AppWidgetSize;", "getShape-nwm-oUQ", "(IZI)Landroidx/glance/oneui/template/Shape;", "getSize", "getSize-rx25Pp4", "()I", "Companion", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetCreatorSettingPreview.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetCreatorSettingPreview.kt\ncom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorSettingPreview\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n*L\n1#1,177:1\n149#2:178\n71#3:179\n69#3,5:180\n74#3:213\n78#3:217\n79#4,6:185\n86#4,4:200\n90#4,2:210\n94#4:216\n368#5,9:191\n377#5:212\n378#5,2:214\n4034#6,6:204\n*S KotlinDebug\n*F\n+ 1 WidgetCreatorSettingPreview.kt\ncom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorSettingPreview\n*L\n49#1:178\n45#1:179\n45#1:180,5\n45#1:213\n45#1:217\n45#1:185,6\n45#1:200,4\n45#1:210,2\n45#1:216\n45#1:191,9\n45#1:212\n45#1:214,2\n45#1:204,6\n*E\n"})
public final class WidgetCreatorSettingPreview {

    @NotNull
    public static final String TAG = "WidgetCreatorSettingPreview";

    @NotNull
    private final View parent;

    @NotNull
    private final WidgetCreatorSettingPresenter presenter;
    public static final int $stable = 8;

    public WidgetCreatorSettingPreview(@NotNull View parent, @NotNull WidgetCreatorSettingPresenter presenter) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.parent = parent;
        this.presenter = presenter;
    }

    /* JADX INFO: renamed from: getSize-rx25Pp4, reason: not valid java name */
    private final int m22132getSizerx25Pp4() {
        int column = this.presenter.getMModel().getColumn();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        Context context = this.parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return companion.m21564getKiq_Kzg(context, column, 2);
    }

    private final List<GridItem> gridData(Context context, List<Integer> selectedItems) {
        Context context2 = context;
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = selectedItems.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (iIntValue == 0) {
                context2 = context;
                arrayList.add(new GridItem(new ImageWithBackgroundData(ImageKt.ImageProvider(C6635R.drawable.glance_list), context.getResources().getString(C6635R.string.widget_creator_open_samsung_notes), ImageType.Icon, ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(4294920778L)), 0, null, null, false, 240, null), null, null, null, SendBroadcastActionKt.actionSendBroadcast(WidgetCreatorUtil.addIntentToLaunchNotes$default(WidgetCreatorUtil.INSTANCE, context2, 0, null, 6, null)), null, false, 110, null));
            } else if (iIntValue == 1) {
                TextData textData = null;
                TextData textData2 = null;
                String str = null;
                BadgeData badgeData = null;
                boolean z = false;
                arrayList.add(new GridItem(new ImageWithBackgroundData(ImageKt.ImageProvider(C6635R.drawable.glance_text), context2.getString(C6635R.string.widget_creator_start_note_text), ImageType.Icon, ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(4282340607L)), 0, null, null, false, 240, null), textData, textData2, str, SendBroadcastActionKt.actionSendBroadcast(WidgetCreatorUtil.addIntentToComposerText$default(WidgetCreatorUtil.INSTANCE, context2, 0, null, 6, null)), badgeData, z, 110, null));
                context2 = context;
            } else if (iIntValue == 2) {
                TextData textData3 = null;
                TextData textData4 = null;
                String str2 = null;
                BadgeData badgeData2 = null;
                boolean z2 = false;
                arrayList.add(new GridItem(new ImageWithBackgroundData(ImageKt.ImageProvider(C6635R.drawable.glance_handwriting), context2.getString(C6635R.string.widget_creator_start_note_handwriting), ImageType.Icon, ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(4279944646L)), 0, null, null, false, 240, null), textData3, textData4, str2, SendBroadcastActionKt.actionSendBroadcast(WidgetCreatorUtil.addIntentToComposerPen$default(WidgetCreatorUtil.INSTANCE, context2, 0, null, 6, null)), badgeData2, z2, 110, null));
            } else if (iIntValue == 3) {
                TextData textData5 = null;
                TextData textData6 = null;
                String str3 = null;
                BadgeData badgeData3 = null;
                boolean z3 = false;
                arrayList.add(new GridItem(new ImageWithBackgroundData(ImageKt.ImageProvider(C6635R.drawable.glance_brush), context2.getString(C6635R.string.widget_creator_start_note_drawing), ImageType.Icon, ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(4287305967L)), 0, null, null, false, 240, null), textData5, textData6, str3, SendBroadcastActionKt.actionSendBroadcast(WidgetCreatorUtil.addIntentToComposerDrawing$default(WidgetCreatorUtil.INSTANCE, context2, 0, null, 6, null)), badgeData3, z3, 110, null));
            } else if (iIntValue == 4) {
                TextData textData7 = null;
                TextData textData8 = null;
                String str4 = null;
                BadgeData badgeData4 = null;
                boolean z4 = false;
                arrayList.add(new GridItem(new ImageWithBackgroundData(ImageKt.ImageProvider(C6635R.drawable.glance_image), context2.getString(C6635R.string.widget_creator_start_note_image), ImageType.Icon, ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(4294531757L)), 0, null, null, false, 240, null), textData7, textData8, str4, SendBroadcastActionKt.actionSendBroadcast(WidgetCreatorUtil.addIntentToComposerImage$default(WidgetCreatorUtil.INSTANCE, context2, 0, null, 6, null)), badgeData4, z4, 110, null));
            } else if (iIntValue == 5) {
                TextData textData9 = null;
                TextData textData10 = null;
                String str5 = null;
                BadgeData badgeData5 = null;
                boolean z5 = false;
                arrayList.add(new GridItem(new ImageWithBackgroundData(ImageKt.ImageProvider(C6635R.drawable.glance_voice), context2.getString(C6635R.string.widget_creator_start_note_recording), ImageType.Icon, ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(4293603427L)), 0, null, null, false, 240, null), textData9, textData10, str5, SendBroadcastActionKt.actionSendBroadcast(WidgetCreatorUtil.addIntentToComposerVoice$default(WidgetCreatorUtil.INSTANCE, context2, 0, null, 6, null)), badgeData5, z5, 110, null));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setContent$lambda$1(WidgetCreatorSettingPreview widgetCreatorSettingPreview, long j, int i, Composer composer, int i2) {
        widgetCreatorSettingPreview.setContent(j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    @NotNull
    /* JADX INFO: renamed from: getShape-nwm-oUQ, reason: not valid java name */
    public final Shape m22133getShapenwmoUQ(int shapeBG, boolean backgrounOnOff, int size) {
        return (AppWidgetSize.m21550equalsimpl0(size, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) && backgrounOnOff) ? shapeBG != 1 ? shapeBG != 2 ? shapeBG != 3 ? shapeBG != 4 ? Shape.None : Shape.RightSpeechBalloon : Shape.LeftSpeechBalloon : Shape.LeftLeaf : Shape.RightLeaf : Shape.None;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @SuppressLint({"UnrememberedMutableState"})
    public final void setContent(long j, @Nullable Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1409225036);
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(j) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1409225036, i2, -1, "com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorSettingPreview.setContent (WidgetCreatorSettingPreview.kt:38)");
            }
            SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Long.valueOf(j), null, 2, null);
            Context context = this.parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            WidgetCreatorThemeManger widgetCreatorThemeManger = new WidgetCreatorThemeManger(context, this.presenter.getWidgetId(), this.presenter.getMModel().getTransparency(), this.presenter.getMModel().getBackgroundColor(), this.presenter.getMModel().getDarkMode(), this.presenter.getMModel().getMatchSetting(), this.presenter.getMModel().getBackgroundOnOff());
            Context context2 = this.parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            final List<GridItem> listGridData = gridData(context2, this.presenter.getMModel().getSelectedItems());
            WidgetLogger.m5154d(TAG, "Update widget creator setting preview: " + j + ", data: " + this.presenter.getMModel().getSelectedItems());
            float f = (float) 20;
            float f4 = (float) 22;
            Modifier modifierM15857paddingqDBjuR0 = PaddingKt.m15857paddingqDBjuR0(SizeKt.fillMaxHeight$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15857paddingqDBjuR0);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w = AbstractC0622a.m1177w(companion, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
            if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
            }
            Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            TopLevelLayoutKt.m21789TopLevelLayoutqgZcuA0(this.presenter.getWidgetId(), m22132getSizerx25Pp4(), "Preview", new AppWidgetBackground.Color(m22133getShapenwmoUQ(this.presenter.getMModel().getBackgroundShape(), this.presenter.getMModel().getBackgroundOnOff(), m22132getSizerx25Pp4())), widgetCreatorThemeManger.updateBackground(), null, ComposableLambdaKt.rememberComposableLambda(-1163125602, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorSettingPreview$setContent$1$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(Composer composer2, int i4) {
                    if ((i4 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1163125602, i4, -1, "com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorSettingPreview.setContent.<anonymous>.<anonymous> (WidgetCreatorSettingPreview.kt:58)");
                    }
                    GridTemplateKt.GridTemplate(new GridData(listGridData), composer2, GridData.$stable);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (AppWidgetBackground.Color.$stable << 9) | 1573248 | (ColorProviders.$stable << 12), 32);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6953f(this, j, i, 1));
        }
    }
}
