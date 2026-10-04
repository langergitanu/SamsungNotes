package com.samsung.android.app.notes.widget.glance;

import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.runtime.AbstractC1974b;
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
import androidx.glance.appwidget.action.StartActivityIntentActionKt;
import androidx.glance.color.ColorProviders;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.AppWidgetBackground;
import androidx.glance.oneui.template.GlanceTemplateAppWidget;
import androidx.glance.oneui.template.GridData;
import androidx.glance.oneui.template.GridItem;
import androidx.glance.oneui.template.GridTemplateKt;
import androidx.glance.oneui.template.ImageType;
import androidx.glance.oneui.template.ImageWithBackgroundData;
import androidx.glance.oneui.template.Shape;
import androidx.glance.oneui.template.layout.TopLevelLayoutKt;
import androidx.glance.state.GlanceStateDefinition;
import androidx.glance.state.PreferencesGlanceStateDefinition;
import androidx.glance.unit.ColorProviderKt;
import com.samsung.android.app.notes.C6635R;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.glance.common.WidgetCreatorUtil;
import com.samsung.android.app.notes.widget.glance.theme.WidgetCreatorThemeManger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
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
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0017¢\u0006\u0002\u0010\u000bJ+\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0007¢\u0006\u0002\u0010\u0013J%\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/WidgetCreator;", "Landroidx/glance/oneui/template/GlanceTemplateAppWidget;", "<init>", "()V", "stateDefinition", "Landroidx/glance/state/GlanceStateDefinition;", "Landroidx/datastore/preferences/core/Preferences;", "getStateDefinition", "()Landroidx/glance/state/GlanceStateDefinition;", "TemplateContent", "", "(Landroidx/compose/runtime/Composer;I)V", "GridContent", "context", "Landroid/content/Context;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "selectedItems", "", "(Landroid/content/Context;ILjava/util/List;Landroidx/compose/runtime/Composer;I)V", "getShape", "Landroidx/glance/oneui/template/Shape;", "shapeBG", "backgrounOnOff", "", "size", "Landroidx/glance/oneui/common/AppWidgetSize;", "getShape-nwm-oUQ", "(IZI)Landroidx/glance/oneui/template/Shape;", "Companion", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetCreator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetCreator.kt\ncom/samsung/android/app/notes/widget/glance/WidgetCreator\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 CompositionLocals.kt\nandroidx/glance/CompositionLocalsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,193:1\n77#2:194\n77#2:195\n74#2:198\n77#2:199\n74#2:202\n74#2:205\n74#2:208\n74#2:211\n74#2:214\n74#2:217\n74#2:220\n72#3:196\n61#3:197\n72#3:200\n61#3:201\n72#3:203\n61#3:204\n72#3:206\n61#3:207\n72#3:209\n61#3:210\n72#3:212\n61#3:213\n72#3:215\n61#3:216\n72#3:218\n61#3:219\n1563#4:221\n1634#4,3:222\n*S KotlinDebug\n*F\n+ 1 WidgetCreator.kt\ncom/samsung/android/app/notes/widget/glance/WidgetCreator\n*L\n56#1:194\n57#1:195\n58#1:198\n59#1:199\n60#1:202\n61#1:205\n62#1:208\n63#1:211\n64#1:214\n65#1:217\n66#1:220\n58#1:196\n58#1:197\n60#1:200\n60#1:201\n61#1:203\n61#1:204\n62#1:206\n62#1:207\n63#1:209\n63#1:210\n64#1:212\n64#1:213\n65#1:215\n65#1:216\n66#1:218\n66#1:219\n67#1:221\n67#1:222,3\n*E\n"})
public final class WidgetCreator extends GlanceTemplateAppWidget {

    @NotNull
    private static final String TAG = "WidgetCreator";

    @NotNull
    private final GlanceStateDefinition<Preferences> stateDefinition = PreferencesGlanceStateDefinition.INSTANCE;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final Preferences.Key<Integer> transparencyKey = PreferencesKeys.intKey("transparencyKey");

    @NotNull
    private static final Preferences.Key<Integer> backgroundColorKey = PreferencesKeys.intKey("backgroundColorKey");

    @NotNull
    private static final Preferences.Key<Integer> darkModeKey = PreferencesKeys.intKey("darkModeKey");

    @NotNull
    private static final Preferences.Key<Boolean> matchSettingKey = PreferencesKeys.booleanKey("matchSettingKey");

    @NotNull
    private static final Preferences.Key<Set<String>> selectedItemsKey = PreferencesKeys.stringSetKey("selectedItemsKey");

    @NotNull
    private static final Preferences.Key<Long> requestTimeKey = PreferencesKeys.longKey("requestTimeKey");

    @NotNull
    private static final Preferences.Key<Integer> shapeBGKey = PreferencesKeys.intKey("shapeBGKey");

    @NotNull
    private static final Preferences.Key<Boolean> backgroundOnOffKey = PreferencesKeys.booleanKey("backgroundOnOffKey");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\nR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\nR\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\n¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/WidgetCreator$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "transparencyKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getTransparencyKey", "()Landroidx/datastore/preferences/core/Preferences$Key;", "backgroundColorKey", "getBackgroundColorKey", "darkModeKey", "getDarkModeKey", "matchSettingKey", "", "getMatchSettingKey", "selectedItemsKey", "", "getSelectedItemsKey", "requestTimeKey", "", "getRequestTimeKey", "shapeBGKey", "getShapeBGKey", "backgroundOnOffKey", "getBackgroundOnOffKey", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Preferences.Key<Integer> getBackgroundColorKey() {
            return WidgetCreator.backgroundColorKey;
        }

        @NotNull
        public final Preferences.Key<Boolean> getBackgroundOnOffKey() {
            return WidgetCreator.backgroundOnOffKey;
        }

        @NotNull
        public final Preferences.Key<Integer> getDarkModeKey() {
            return WidgetCreator.darkModeKey;
        }

        @NotNull
        public final Preferences.Key<Boolean> getMatchSettingKey() {
            return WidgetCreator.matchSettingKey;
        }

        @NotNull
        public final Preferences.Key<Long> getRequestTimeKey() {
            return WidgetCreator.requestTimeKey;
        }

        @NotNull
        public final Preferences.Key<Set<String>> getSelectedItemsKey() {
            return WidgetCreator.selectedItemsKey;
        }

        @NotNull
        public final Preferences.Key<Integer> getShapeBGKey() {
            return WidgetCreator.shapeBGKey;
        }

        @NotNull
        public final Preferences.Key<Integer> getTransparencyKey() {
            return WidgetCreator.transparencyKey;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GridContent$lambda$2(WidgetCreator widgetCreator, Context context, int i, List list, int i2, Composer composer, int i4) {
        widgetCreator.GridContent(context, i, list, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TemplateContent$lambda$1(WidgetCreator widgetCreator, int i, Composer composer, int i2) {
        widgetCreator.TemplateContent(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void GridContent(@NotNull Context context, int i, @NotNull List<Integer> selectedItems, @Nullable Composer composer, int i2) {
        int i4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
        Composer composerStartRestartGroup = composer.startRestartGroup(822551195);
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(context) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(selectedItems) ? 256 : 128;
        }
        if ((i4 & 131) == 130 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(822551195, i4, -1, "com.samsung.android.app.notes.widget.glance.WidgetCreator.GridContent (WidgetCreator.kt:86)");
            }
            ArrayList arrayList = new ArrayList();
            Iterator<Integer> it = selectedItems.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (iIntValue == 0) {
                    arrayList.add(new GridItem(new ImageWithBackgroundData(ImageKt.ImageProvider(C6635R.drawable.glance_list), null, ImageType.Icon, ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(4294920778L)), 0, null, null, false, 242, null), null, null, context.getResources().getString(C6635R.string.widget_creator_open_samsung_notes), StartActivityIntentActionKt.actionStartActivity$default(WidgetCreatorUtil.INSTANCE.getLaunchNotesIntent(context), null, 2, null), null, false, 102, null));
                } else if (iIntValue == 1) {
                    arrayList.add(new GridItem(new ImageWithBackgroundData(ImageKt.ImageProvider(C6635R.drawable.glance_text), null, ImageType.Icon, ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(4282340607L)), 0, null, null, false, 242, null), null, null, context.getString(C6635R.string.widget_creator_start_note_text), StartActivityIntentActionKt.actionStartActivity$default(WidgetCreatorUtil.INSTANCE.getOpenIntent(context, ComposerConstants.NEW_MEMO_OPEN), null, 2, null), null, false, 102, null));
                } else if (iIntValue == 2) {
                    arrayList.add(new GridItem(new ImageWithBackgroundData(ImageKt.ImageProvider(C6635R.drawable.glance_handwriting), null, ImageType.Icon, ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(4279944646L)), 0, null, null, false, 242, null), null, null, context.getString(C6635R.string.widget_creator_start_note_handwriting), StartActivityIntentActionKt.actionStartActivity$default(WidgetCreatorUtil.INSTANCE.getOpenIntent(context, ComposerConstants.NEW_MEMO_WRITING_OPEN), null, 2, null), null, false, 102, null));
                } else if (iIntValue == 3) {
                    arrayList.add(new GridItem(new ImageWithBackgroundData(ImageKt.ImageProvider(C6635R.drawable.glance_brush), null, ImageType.Icon, ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(4287305967L)), 0, null, null, false, 242, null), null, null, context.getString(C6635R.string.widget_creator_start_note_drawing), StartActivityIntentActionKt.actionStartActivity$default(WidgetCreatorUtil.INSTANCE.getOpenIntent(context, ComposerConstants.NEW_MEMO_DRAWING_OPEN), null, 2, null), null, false, 102, null));
                } else if (iIntValue == 4) {
                    arrayList.add(new GridItem(new ImageWithBackgroundData(ImageKt.ImageProvider(C6635R.drawable.glance_image), null, ImageType.Icon, ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(4294531757L)), 0, null, null, false, 242, null), null, null, context.getString(C6635R.string.widget_creator_start_note_image), StartActivityIntentActionKt.actionStartActivity$default(WidgetCreatorUtil.INSTANCE.getOpenIntent(context, ComposerConstants.NEW_MEMO_INSERT_OPEN), null, 2, null), null, false, 102, null));
                } else if (iIntValue == 5) {
                    arrayList.add(new GridItem(new ImageWithBackgroundData(ImageKt.ImageProvider(C6635R.drawable.glance_voice), null, ImageType.Icon, ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(4293603427L)), 0, null, null, false, 242, null), null, null, context.getString(C6635R.string.widget_creator_start_note_recording), StartActivityIntentActionKt.actionStartActivity$default(WidgetCreatorUtil.INSTANCE.getOpenIntent(context, ComposerConstants.NEW_MEMO_VOICE_OPEN), null, 2, null), null, false, 102, null));
                }
            }
            GridTemplateKt.GridTemplate(new GridData(arrayList), composerStartRestartGroup, GridData.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6917b(this, context, i, selectedItems, i2, 0));
        }
    }

    @Override // androidx.glance.oneui.template.GlanceTemplateAppWidget
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public void TemplateContent(@Nullable Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1117961951);
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changedInstance(this) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1117961951, i2, -1, "com.samsung.android.app.notes.widget.glance.WidgetCreator.TemplateContent (WidgetCreator.kt:54)");
            }
            final Context context = (Context) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalContext());
            int mask = ((AppWidgetSize) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask();
            Preferences.Key<Long> key = requestTimeKey;
            Object objM4741b = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
            if (objM4741b == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
            }
            Long l = (Long) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b, key);
            long jLongValue = l != null ? l.longValue() : 0L;
            final int appWidgetId = new GlanceAppWidgetManager(context).getAppWidgetId((GlanceId) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalGlanceId()));
            Preferences.Key<Integer> key2 = transparencyKey;
            Object objM4741b2 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
            if (objM4741b2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
            }
            Integer num = (Integer) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b2, key2);
            int iIntValue = num != null ? num.intValue() : 75;
            Preferences.Key<Integer> key3 = backgroundColorKey;
            Object objM4741b3 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
            if (objM4741b3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
            }
            Integer num2 = (Integer) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b3, key3);
            int iIntValue2 = num2 != null ? num2.intValue() : 1;
            Preferences.Key<Integer> key4 = darkModeKey;
            Object objM4741b4 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
            if (objM4741b4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
            }
            Integer num3 = (Integer) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b4, key4);
            int iIntValue3 = num3 != null ? num3.intValue() : 1;
            Preferences.Key<Boolean> key5 = matchSettingKey;
            Object objM4741b5 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
            if (objM4741b5 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
            }
            Boolean bool = (Boolean) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b5, key5);
            boolean zBooleanValue = bool != null ? bool.booleanValue() : true;
            Preferences.Key<Integer> key6 = shapeBGKey;
            Object objM4741b6 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
            if (objM4741b6 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
            }
            Integer num4 = (Integer) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b6, key6);
            int iIntValue4 = num4 != null ? num4.intValue() : 0;
            Preferences.Key<Boolean> key7 = backgroundOnOffKey;
            Object objM4741b7 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
            if (objM4741b7 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
            }
            Boolean bool2 = (Boolean) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b7, key7);
            boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : true;
            Preferences.Key<Set<String>> key8 = selectedItemsKey;
            Object objM4741b8 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
            if (objM4741b8 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
            }
            Set of = (Set) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b8, key8);
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
            WidgetCreatorThemeManger widgetCreatorThemeManger = new WidgetCreatorThemeManger(context, appWidgetId, iIntValue, iIntValue2, iIntValue3, zBooleanValue, zBooleanValue2);
            long jCurrentTimeMillis = System.currentTimeMillis();
            StringBuilder sbM1323p = AbstractC1974b.m1323p(jLongValue, "onUpdate: timeUpdate: ", ", currentTime: ");
            sbM1323p.append(jCurrentTimeMillis);
            sbM1323p.append(", transparency: ");
            sbM1323p.append(iIntValue);
            AbstractC0622a.m1180z(sbM1323p, iIntValue2, iIntValue3, ", backgroundColor: ", ", darkMode: ");
            sbM1323p.append(", matchSetting: ");
            sbM1323p.append(zBooleanValue);
            sbM1323p.append(", selectedItems: ");
            sbM1323p.append(listSorted);
            sbM1323p.append(", shape: ");
            sbM1323p.append(iIntValue4);
            WidgetLogger.m5154d(TAG, sbM1323p.toString());
            composerStartRestartGroup = composerStartRestartGroup;
            TopLevelLayoutKt.TopLevelLayout(AbstractC0541b.m757C(context.getResources().getString(C6635R.string.notes), " ", context.getResources().getString(C6635R.string.widget_toolbar)), new AppWidgetBackground.Color(m22121getShapenwmoUQ(iIntValue4, zBooleanValue2, mask)), widgetCreatorThemeManger.updateBackground(), null, null, context.getResources().getString(C6635R.string.app_name_simple), ComposableLambdaKt.rememberComposableLambda(-1310201941, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.WidgetCreator.TemplateContent.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num5) {
                    invoke(composer2, num5.intValue());
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
                        ComposerKt.traceEventStart(-1310201941, i4, -1, "com.samsung.android.app.notes.widget.glance.WidgetCreator.TemplateContent.<anonymous> (WidgetCreator.kt:78)");
                    }
                    WidgetCreator.this.GridContent(context, appWidgetId, listSorted, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (AppWidgetBackground.Color.$stable << 3) | 1572864 | (ColorProviders.$stable << 6), 24);
            WidgetLogger.m5154d(TAG, "onUpdate: content widget done# WidgetId: " + appWidgetId + ", currentTime: " + System.currentTimeMillis() + ", durationTime: " + ((r3 - jLongValue) / 1000.0d));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6916a(this, i, 0));
        }
    }

    @NotNull
    /* JADX INFO: renamed from: getShape-nwm-oUQ, reason: not valid java name */
    public final Shape m22121getShapenwmoUQ(int shapeBG, boolean backgrounOnOff, int size) {
        return (AppWidgetSize.m21550equalsimpl0(size, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) && backgrounOnOff) ? shapeBG != 1 ? shapeBG != 2 ? shapeBG != 3 ? shapeBG != 4 ? Shape.None : Shape.RightSpeechBalloon : Shape.LeftSpeechBalloon : Shape.LeftLeaf : Shape.RightLeaf : Shape.None;
    }

    @Override // androidx.glance.appwidget.GlanceAppWidget
    @NotNull
    public GlanceStateDefinition<Preferences> getStateDefinition() {
        return this.stateDefinition;
    }
}
