package com.samsung.android.app.notes.widget.lockbrief;

import android.content.Context;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.glance.AbstractC2821a;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.GlanceId;
import androidx.glance.ImageKt;
import androidx.glance.appwidget.GlanceAppWidgetManager;
import androidx.glance.appwidget.action.SendBroadcastActionKt;
import androidx.glance.oneui.template.AppWidgetBackground;
import androidx.glance.oneui.template.GlanceTemplateAppWidget;
import androidx.glance.oneui.template.GridData;
import androidx.glance.oneui.template.GridItem;
import androidx.glance.oneui.template.GridTemplateKt;
import androidx.glance.oneui.template.ImageType;
import androidx.glance.oneui.template.ImageWithBackgroundData;
import androidx.glance.oneui.template.layout.TopLevelLayoutKt;
import androidx.glance.state.GlanceStateDefinition;
import androidx.glance.state.PreferencesGlanceStateDefinition;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import com.samsung.android.app.notes.C6635R;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.glance.C6916a;
import com.samsung.android.app.notes.widget.glance.common.WidgetCreatorUtil;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0017¢\u0006\u0002\u0010\u000bJ$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/lockbrief/WidgetCreatorLockBrief;", "Landroidx/glance/oneui/template/GlanceTemplateAppWidget;", "<init>", "()V", "stateDefinition", "Landroidx/glance/state/GlanceStateDefinition;", "Landroidx/datastore/preferences/core/Preferences;", "getStateDefinition", "()Landroidx/glance/state/GlanceStateDefinition;", "TemplateContent", "", "(Landroidx/compose/runtime/Composer;I)V", "creatorLockBriefGirdData", "Landroidx/glance/oneui/template/GridData;", "context", "Landroid/content/Context;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "selectedItems", "", "Companion", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetCreatorLockBrief.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetCreatorLockBrief.kt\ncom/samsung/android/app/notes/widget/lockbrief/WidgetCreatorLockBrief\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 CompositionLocals.kt\nandroidx/glance/CompositionLocalsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,150:1\n77#2:151\n74#2:154\n77#2:155\n74#2:158\n72#3:152\n61#3:153\n72#3:156\n61#3:157\n1563#4:159\n1634#4,3:160\n*S KotlinDebug\n*F\n+ 1 WidgetCreatorLockBrief.kt\ncom/samsung/android/app/notes/widget/lockbrief/WidgetCreatorLockBrief\n*L\n43#1:151\n44#1:154\n45#1:155\n46#1:158\n44#1:152\n44#1:153\n46#1:156\n46#1:157\n47#1:159\n47#1:160,3\n*E\n"})
public final class WidgetCreatorLockBrief extends GlanceTemplateAppWidget {

    @NotNull
    private static final String TAG = "WidgetCreatorLockBrief";

    @NotNull
    private static final String providerName = "WidgetCreatorLockBriefProvider";

    @NotNull
    private final GlanceStateDefinition<Preferences> stateDefinition = PreferencesGlanceStateDefinition.INSTANCE;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final Preferences.Key<Long> requestTimeKey = PreferencesKeys.longKey("requestTimeKey");

    @NotNull
    private static final Preferences.Key<Set<String>> selectedItemsKey = PreferencesKeys.stringSetKey("selectedItemsKey");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/lockbrief/WidgetCreatorLockBrief$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "providerName", "requestTimeKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getRequestTimeKey", "()Landroidx/datastore/preferences/core/Preferences$Key;", "selectedItemsKey", "", "getSelectedItemsKey", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Preferences.Key<Long> getRequestTimeKey() {
            return WidgetCreatorLockBrief.requestTimeKey;
        }

        @NotNull
        public final Preferences.Key<Set<String>> getSelectedItemsKey() {
            return WidgetCreatorLockBrief.selectedItemsKey;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TemplateContent$lambda$1(WidgetCreatorLockBrief widgetCreatorLockBrief, int i, Composer composer, int i2) {
        widgetCreatorLockBrief.TemplateContent(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    @Override // androidx.glance.oneui.template.GlanceTemplateAppWidget
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public void TemplateContent(@Nullable Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1074916140);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1074916140, i2, -1, "com.samsung.android.app.notes.widget.lockbrief.WidgetCreatorLockBrief.TemplateContent (WidgetCreatorLockBrief.kt:41)");
            }
            final Context context = (Context) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalContext());
            Preferences.Key<Long> key = requestTimeKey;
            Object objM4741b = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
            if (objM4741b == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
            }
            Long l = (Long) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b, key);
            long jLongValue = l != null ? l.longValue() : 0L;
            final int appWidgetId = new GlanceAppWidgetManager(context).getAppWidgetId((GlanceId) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalGlanceId()));
            Preferences.Key<Set<String>> key2 = selectedItemsKey;
            Object objM4741b2 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
            if (objM4741b2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
            }
            Set of = (Set) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b2, key2);
            if (of == null) {
                of = SetsKt.setOf((Object[]) new String[]{"0", "1", "2", "3"});
            }
            Set set = of;
            ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(set));
            Iterator it = set.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(Integer.parseInt((String) it.next())));
            }
            final List listSorted = CollectionsKt.sorted(arrayList);
            WidgetLogger.m5154d(TAG, "onUpdate: timeUpdate: " + jLongValue + ", selectedItems: " + listSorted);
            TopLevelLayoutKt.TopLevelLayout("My app widget's content description", AppWidgetBackground.Transparent.INSTANCE, null, null, null, context.getResources().getString(C6635R.string.app_name_simple), ComposableLambdaKt.rememberComposableLambda(360883080, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.lockbrief.WidgetCreatorLockBrief.TemplateContent.1
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
                        ComposerKt.traceEventStart(360883080, i4, -1, "com.samsung.android.app.notes.widget.lockbrief.WidgetCreatorLockBrief.TemplateContent.<anonymous> (WidgetCreatorLockBrief.kt:54)");
                    }
                    GridTemplateKt.GridTemplate(WidgetCreatorLockBrief.this.creatorLockBriefGirdData(context, appWidgetId, listSorted), composer2, GridData.$stable);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (AppWidgetBackground.Transparent.$stable << 3) | 1572870, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6916a(this, i, 3));
        }
    }

    @NotNull
    public final GridData creatorLockBriefGirdData(@NotNull Context context, int appWidgetId, @NotNull List<Integer> selectedItems) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
        ArrayList arrayList = new ArrayList();
        ColorProvider colorProviderM22055ColorProvider8_81llA = ColorProviderKt.m22055ColorProvider8_81llA(Color.m18524copywmQWz5c$default(ColorKt.Color(4294967295L), 0.15f, 0.0f, 0.0f, 0.0f, 14, null));
        Iterator<Integer> it = selectedItems.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (iIntValue == 0) {
                arrayList.add(new GridItem(new ImageWithBackgroundData(ImageKt.ImageProvider(C6635R.drawable.widget_creator_lock_brief_ic_notes), context.getResources().getString(C6635R.string.widget_creator_open_samsung_notes), ImageType.Icon, colorProviderM22055ColorProvider8_81llA, 0, null, null, false, 240, null), null, null, null, SendBroadcastActionKt.actionSendBroadcast(WidgetCreatorUtil.INSTANCE.addIntentToLaunchNotes(context, appWidgetId, providerName)), null, false, 110, null));
            } else if (iIntValue == 1) {
                arrayList.add(new GridItem(new ImageWithBackgroundData(ImageKt.ImageProvider(C6635R.drawable.widget_creator_lock_brief_ic_text), context.getString(C6635R.string.widget_creator_start_note_text), ImageType.Icon, colorProviderM22055ColorProvider8_81llA, 0, null, null, false, 240, null), null, null, null, SendBroadcastActionKt.actionSendBroadcast(WidgetCreatorUtil.INSTANCE.addIntentToComposerText(context, appWidgetId, providerName)), null, false, 110, null));
            } else if (iIntValue == 2) {
                arrayList.add(new GridItem(new ImageWithBackgroundData(ImageKt.ImageProvider(C6635R.drawable.widget_creator_lock_brief_ic_writing), context.getString(C6635R.string.widget_creator_start_note_handwriting), ImageType.Icon, colorProviderM22055ColorProvider8_81llA, 0, null, null, false, 240, null), null, null, null, SendBroadcastActionKt.actionSendBroadcast(WidgetCreatorUtil.INSTANCE.addIntentToComposerPen(context, appWidgetId, providerName)), null, false, 110, null));
            } else if (iIntValue == 3) {
                arrayList.add(new GridItem(new ImageWithBackgroundData(ImageKt.ImageProvider(C6635R.drawable.widget_creator_lock_brief_ic_color_paint), context.getString(C6635R.string.widget_creator_start_note_drawing), ImageType.Icon, colorProviderM22055ColorProvider8_81llA, 0, null, null, false, 240, null), null, null, null, SendBroadcastActionKt.actionSendBroadcast(WidgetCreatorUtil.INSTANCE.addIntentToComposerDrawing(context, appWidgetId, providerName)), null, false, 110, null));
            } else if (iIntValue == 4) {
                arrayList.add(new GridItem(new ImageWithBackgroundData(ImageKt.ImageProvider(C6635R.drawable.widget_creator_lock_brief_ic_image), context.getString(C6635R.string.widget_creator_start_note_image), ImageType.Icon, colorProviderM22055ColorProvider8_81llA, 0, null, null, false, 240, null), null, null, null, SendBroadcastActionKt.actionSendBroadcast(WidgetCreatorUtil.INSTANCE.addIntentToComposerImage(context, appWidgetId, providerName)), null, false, 110, null));
            } else if (iIntValue == 5) {
                arrayList.add(new GridItem(new ImageWithBackgroundData(ImageKt.ImageProvider(C6635R.drawable.widget_creator_lock_brief_ic_voice), context.getString(C6635R.string.widget_creator_start_note_recording), ImageType.Icon, colorProviderM22055ColorProvider8_81llA, 0, null, null, false, 240, null), null, null, null, SendBroadcastActionKt.actionSendBroadcast(WidgetCreatorUtil.INSTANCE.addIntentToComposerVoice(context, appWidgetId, providerName)), null, false, 110, null));
            }
        }
        return new GridData(arrayList);
    }

    @Override // androidx.glance.appwidget.GlanceAppWidget
    @NotNull
    public GlanceStateDefinition<Preferences> getStateDefinition() {
        return this.stateDefinition;
    }
}
