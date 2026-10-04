package com.samsung.android.app.notes.widget.glance.list;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.p109ui.unit.TextUnit;
import androidx.compose.p109ui.unit.TextUnitKt;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.glance.AbstractC2821a;
import androidx.glance.BackgroundKt;
import androidx.glance.ColorFilter;
import androidx.glance.GlanceId;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.ImageKt;
import androidx.glance.ImageProvider;
import androidx.glance.action.Action;
import androidx.glance.action.ActionKt;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.appwidget.GlanceAppWidgetManager;
import androidx.glance.appwidget.ImageButtonKt;
import androidx.glance.appwidget.MarginKt;
import androidx.glance.appwidget.action.SendBroadcastActionKt;
import androidx.glance.appwidget.animation.RemoteAnimation;
import androidx.glance.appwidget.lazy.LazyItemScope;
import androidx.glance.appwidget.lazy.LazyListKt;
import androidx.glance.appwidget.lazy.LazyListScope;
import androidx.glance.color.ColorProviders;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.BoxKt;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.ContentScale;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.SpacerKt;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.ActionButtonData;
import androidx.glance.oneui.template.ActionIcon;
import androidx.glance.oneui.template.AppWidgetBackground;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.CustomListItem;
import androidx.glance.oneui.template.GlanceTemplateAppWidget;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.ImageWithBackgroundData;
import androidx.glance.oneui.template.ListItem;
import androidx.glance.oneui.template.Shape;
import androidx.glance.oneui.template.TemplateState;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TitleBarData;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.oneui.template.component.TextKt;
import androidx.glance.oneui.template.layout.CommonDimensions;
import androidx.glance.oneui.template.layout.TopLevelLayoutKt;
import androidx.glance.state.GlanceStateDefinition;
import androidx.glance.state.PreferencesGlanceStateDefinition;
import androidx.glance.text.ComplexUnit;
import androidx.glance.text.FontFamily;
import androidx.glance.text.FontStyle;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextAlign;
import androidx.glance.text.TextDecoration;
import androidx.glance.text.TextShadowStyle;
import androidx.glance.text.TextStyle;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.cover.WidgetListExtraLargeCoverProvider;
import com.samsung.android.app.notes.widget.glance.C6916a;
import com.samsung.android.app.notes.widget.glance.list.WidgetListGlance;
import com.samsung.android.app.notes.widget.glance.list.common.WidgetListGlanceItem;
import com.samsung.android.app.notes.widget.glance.list.common.WidgetListGlanceUtils;
import com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceLoadingView;
import com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceTheme;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 62\u00020\u0001:\u000267B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0017¢\u0006\u0002\u0010\u000bJ%\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015JK\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001e2\u0006\u0010\"\u001a\u00020\u001fH\u0003¢\u0006\u0002\u0010#J/\u0010$\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0010\u0010 \u001a\f\u0012\b\u0012\u00060%R\u00020\u00000\u001e2\u0006\u0010\"\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010&J/\u0010'\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0010\u0010(\u001a\f\u0012\b\u0012\u00060%R\u00020\u00000\u001e2\u0006\u0010\"\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010&JU\u0010)\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u001f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0010\u0010(\u001a\f\u0012\b\u0012\u00060%R\u00020\u00000\u001e2\u0006\u0010*\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010+J@\u0010,\u001a\f\u0012\b\u0012\u00060%R\u00020\u00000\u001e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002J7\u0010-\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001fH\u0003¢\u0006\u0004\b/\u00100J7\u00101\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001fH\u0007¢\u0006\u0004\b2\u00100J-\u00103\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001fH\u0007¢\u0006\u0002\u00104J-\u00105\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001fH\u0003¢\u0006\u0002\u00104R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u00068"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/list/WidgetListGlance;", "Landroidx/glance/oneui/template/GlanceTemplateAppWidget;", "<init>", "()V", "stateDefinition", "Landroidx/glance/state/GlanceStateDefinition;", "Landroidx/datastore/preferences/core/Preferences;", "getStateDefinition", "()Landroidx/glance/state/GlanceStateDefinition;", "TemplateContent", "", "(Landroidx/compose/runtime/Composer;I)V", "getShape", "Landroidx/glance/oneui/template/Shape;", "shapeBG", "", "backgroundOnOff", "", "size", "Landroidx/glance/oneui/common/AppWidgetSize;", "getShape-nwm-oUQ", "(IZI)Landroidx/glance/oneui/template/Shape;", "getTitleBar", "Landroidx/glance/oneui/template/TitleBarData;", "context", "Landroid/content/Context;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "themeManager", "Lcom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceTheme;", "uuidList", "", "", "buildItemList", "Landroidx/glance/oneui/template/ListItem;", "providerName", "(Landroid/content/Context;ILcom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceTheme;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/glance/oneui/template/TitleBarData;", "ListTemp", "Lcom/samsung/android/app/notes/widget/glance/list/WidgetListGlance$WidgetListItem;", "(Lcom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceTheme;Ljava/util/List;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "ListTempCustom", "listData", "ListTempForWidgetCover", "coverScreenCutout", "(Landroid/content/Context;ILjava/lang/String;Ljava/util/List;Lcom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceTheme;Ljava/util/List;ILandroidx/compose/runtime/Composer;I)V", "buildItem", "WidgetListEmpty", "widgetSize", "WidgetListEmpty-gaecCbA", "(Landroid/content/Context;IILcom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceTheme;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "WidgetEmptyMedium", "WidgetEmptyMedium-gaecCbA", "WidgetEmptySmall", "(Landroid/content/Context;ILcom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceTheme;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "WidgetListExtraLargeCoverEmpty", "Companion", "WidgetListItem", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetListGlance.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetListGlance.kt\ncom/samsung/android/app/notes/widget/glance/list/WidgetListGlance\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 CompositionLocals.kt\nandroidx/glance/CompositionLocalsKt\n+ 4 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,876:1\n77#2:877\n77#2:878\n77#2:879\n74#2:882\n74#2:885\n74#2:888\n74#2:891\n74#2:894\n74#2:897\n74#2:900\n74#2:903\n74#2:906\n74#2:909\n77#2:910\n77#2:914\n77#2:915\n77#2:917\n77#2:925\n77#2:926\n72#3:880\n61#3:881\n72#3:883\n61#3:884\n72#3:886\n61#3:887\n72#3:889\n61#3:890\n72#3:892\n61#3:893\n72#3:895\n61#3:896\n72#3:898\n61#3:899\n72#3:901\n61#3:902\n72#3:904\n61#3:905\n72#3:907\n61#3:908\n149#4:911\n149#4:912\n149#4:913\n149#4:916\n149#4:918\n149#4:919\n169#4:920\n169#4:921\n149#4:922\n169#4:923\n149#4:924\n169#4:927\n169#4:928\n169#4:929\n169#4:930\n*S KotlinDebug\n*F\n+ 1 WidgetListGlance.kt\ncom/samsung/android/app/notes/widget/glance/list/WidgetListGlance\n*L\n111#1:877\n112#1:878\n113#1:879\n114#1:882\n115#1:885\n116#1:888\n117#1:891\n118#1:894\n119#1:897\n120#1:900\n121#1:903\n122#1:906\n123#1:909\n205#1:910\n603#1:914\n604#1:915\n608#1:917\n757#1:925\n758#1:926\n114#1:880\n114#1:881\n115#1:883\n115#1:884\n116#1:886\n116#1:887\n117#1:889\n117#1:890\n118#1:892\n118#1:893\n119#1:895\n119#1:896\n120#1:898\n120#1:899\n121#1:901\n121#1:902\n122#1:904\n122#1:905\n123#1:907\n123#1:908\n218#1:911\n219#1:912\n339#1:913\n606#1:916\n617#1:918\n620#1:919\n621#1:920\n623#1:921\n626#1:922\n628#1:923\n630#1:924\n762#1:927\n764#1:928\n767#1:929\n768#1:930\n*E\n"})
public final class WidgetListGlance extends GlanceTemplateAppWidget {

    @NotNull
    private static final String TAG = "WidgetListGlance";

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
    private static final Preferences.Key<String> uuidListKey = PreferencesKeys.stringKey("uuidListKey");

    @NotNull
    private static final Preferences.Key<Long> requestTimeKey = PreferencesKeys.longKey("requestTimeKey");

    @NotNull
    private static final Preferences.Key<Integer> backgroundShapeKey = PreferencesKeys.intKey("backgroundShapeKey");

    @NotNull
    private static final Preferences.Key<Boolean> backgroundOnOffKey = PreferencesKeys.booleanKey("backgroundOnOffKey");

    @NotNull
    private static final Preferences.Key<String> providerNameKey = PreferencesKeys.stringKey("providerNameKey");

    @NotNull
    private static final Preferences.Key<Integer> coverScreenCutoutKey = PreferencesKeys.intKey("coverScreenCutoutKey");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\nR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\n¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/list/WidgetListGlance$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "transparencyKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getTransparencyKey", "()Landroidx/datastore/preferences/core/Preferences$Key;", "backgroundColorKey", "getBackgroundColorKey", "darkModeKey", "getDarkModeKey", "matchSettingKey", "", "getMatchSettingKey", "uuidListKey", "getUuidListKey", "requestTimeKey", "", "getRequestTimeKey", "backgroundShapeKey", "getBackgroundShapeKey", "backgroundOnOffKey", "getBackgroundOnOffKey", "providerNameKey", "getProviderNameKey", "coverScreenCutoutKey", "getCoverScreenCutoutKey", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Preferences.Key<Integer> getBackgroundColorKey() {
            return WidgetListGlance.backgroundColorKey;
        }

        @NotNull
        public final Preferences.Key<Boolean> getBackgroundOnOffKey() {
            return WidgetListGlance.backgroundOnOffKey;
        }

        @NotNull
        public final Preferences.Key<Integer> getBackgroundShapeKey() {
            return WidgetListGlance.backgroundShapeKey;
        }

        @NotNull
        public final Preferences.Key<Integer> getCoverScreenCutoutKey() {
            return WidgetListGlance.coverScreenCutoutKey;
        }

        @NotNull
        public final Preferences.Key<Integer> getDarkModeKey() {
            return WidgetListGlance.darkModeKey;
        }

        @NotNull
        public final Preferences.Key<Boolean> getMatchSettingKey() {
            return WidgetListGlance.matchSettingKey;
        }

        @NotNull
        public final Preferences.Key<String> getProviderNameKey() {
            return WidgetListGlance.providerNameKey;
        }

        @NotNull
        public final Preferences.Key<Long> getRequestTimeKey() {
            return WidgetListGlance.requestTimeKey;
        }

        @NotNull
        public final Preferences.Key<Integer> getTransparencyKey() {
            return WidgetListGlance.transparencyKey;
        }

        @NotNull
        public final Preferences.Key<String> getUuidListKey() {
            return WidgetListGlance.uuidListKey;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance$ListTempCustom$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nWidgetListGlance.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetListGlance.kt\ncom/samsung/android/app/notes/widget/glance/list/WidgetListGlance$ListTempCustom$1\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 LazyList.kt\nandroidx/glance/appwidget/lazy/LazyListKt\n*L\n1#1,876:1\n1225#2,6:877\n236#3,8:883\n*S KotlinDebug\n*F\n+ 1 WidgetListGlance.kt\ncom/samsung/android/app/notes/widget/glance/list/WidgetListGlance$ListTempCustom$1\n*L\n227#1:877,6\n228#1:883,8\n*E\n"})
    public static final class C69181 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ long $colorDivider;
        final /* synthetic */ float $iconSize;
        final /* synthetic */ List<WidgetListItem> $listData;
        final /* synthetic */ long $strokeIconColor;
        final /* synthetic */ int $strokeIconWidth;
        final /* synthetic */ WidgetListGlanceTheme $themeManager;
        final /* synthetic */ int $visibleItemCount;

        public C69181(List<WidgetListItem> list, int i, float f, long j, WidgetListGlanceTheme widgetListGlanceTheme, long j2, int i2) {
            this.$listData = list;
            this.$visibleItemCount = i;
            this.$iconSize = f;
            this.$strokeIconColor = j;
            this.$themeManager = widgetListGlanceTheme;
            this.$colorDivider = j2;
            this.$strokeIconWidth = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$2$lambda$1(final List list, final int i, final float f, final long j, final int i2, final WidgetListGlanceTheme widgetListGlanceTheme, final long j2, LazyListScope LazyColumn) {
            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
            LazyColumn.items(list.size(), new Function1<Integer, Long>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance$ListTempCustom$1$invoke$lambda$2$lambda$1$$inlined$itemsIndexed$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @NotNull
                public final Long invoke(int i4) {
                    list.get(i4);
                    return Long.MIN_VALUE;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Long invoke(Integer num) {
                    return invoke(num.intValue());
                }
            }, ComposableLambdaKt.composableLambdaInstance(-1405343893, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance$ListTempCustom$1$invoke$lambda$2$lambda$1$$inlined$itemsIndexed$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@NotNull LazyItemScope items, int i4, @Nullable Composer composer, int i5) {
                    int i6;
                    Intrinsics.checkNotNullParameter(items, "$this$items");
                    if ((i5 & 14) == 0) {
                        i6 = (composer.changed(items) ? 4 : 2) | i5;
                    } else {
                        i6 = i5;
                    }
                    if ((i5 & 112) == 0) {
                        i6 |= composer.changed(i4) ? 32 : 16;
                    }
                    if ((i6 & 731) == 146 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1405343893, i6, -1, "androidx.glance.appwidget.lazy.itemsIndexed.<anonymous> (LazyList.kt:241)");
                    }
                    final WidgetListGlance.WidgetListItem widgetListItem = (WidgetListGlance.WidgetListItem) list.get(i4);
                    composer.startReplaceGroup(-694351301);
                    int i7 = i;
                    final boolean z = i7 > 1 && i4 < i7 - 1;
                    final float f4 = f;
                    final long j3 = j;
                    final int i8 = i2;
                    final WidgetListGlanceTheme widgetListGlanceTheme2 = widgetListGlanceTheme;
                    final long j5 = j2;
                    ColumnKt.m21455ColumnK4GKKTE(null, 0, 0, ComposableLambdaKt.rememberComposableLambda(-1733145995, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance$ListTempCustom$1$1$1$1$1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                            invoke(columnScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                        @Composable
                        public final void invoke(ColumnScope Column, Composer composer2, int i9) {
                            Intrinsics.checkNotNullParameter(Column, "$this$Column");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1733145995, i9, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempCustom.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:230)");
                            }
                            GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                            float f5 = 15;
                            GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(companion, C2256Dp.m20968constructorimpl(f5), 0.0f, C2256Dp.m20968constructorimpl(f5), C2256Dp.m20968constructorimpl(0), 2, null);
                            final WidgetListGlance.WidgetListItem widgetListItem2 = widgetListItem;
                            final float f6 = f4;
                            final long j6 = j3;
                            final int i10 = i8;
                            final WidgetListGlanceTheme widgetListGlanceTheme3 = widgetListGlanceTheme2;
                            BoxKt.Box(glanceModifierM21500paddingqDBjuR0$default, null, ComposableLambdaKt.rememberComposableLambda(1670347091, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance$ListTempCustom$1$1$1$1$1.1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(Composer composer3, int i11) {
                                    if ((i11 & 3) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1670347091, i11, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempCustom.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:238)");
                                    }
                                    GlanceModifier glanceModifierM21286cornerRadius3ABfNKs = CornerRadiusKt.m21286cornerRadius3ABfNKs(SizeModifiersKt.wrapContentSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(2));
                                    final WidgetListGlance.WidgetListItem widgetListItem3 = widgetListItem2;
                                    final float f7 = f6;
                                    final long j7 = j6;
                                    final int i12 = i10;
                                    final WidgetListGlanceTheme widgetListGlanceTheme4 = widgetListGlanceTheme3;
                                    BoxKt.Box(glanceModifierM21286cornerRadius3ABfNKs, null, ComposableLambdaKt.rememberComposableLambda(1285217589, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempCustom.1.1.1.1.1.1.1
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                        @Composable
                                        public final void invoke(Composer composer4, int i13) {
                                            if ((i13 & 3) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1285217589, i13, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempCustom.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:243)");
                                            }
                                            GlanceModifier glanceModifierFillMaxWidth = SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE);
                                            Action onClick = widgetListItem3.getOnClick();
                                            Intrinsics.checkNotNull(onClick);
                                            GlanceModifier glanceModifierM21286cornerRadius3ABfNKs2 = CornerRadiusKt.m21286cornerRadius3ABfNKs(ActionKt.clickable(glanceModifierFillMaxWidth, onClick, C11391R.drawable.sesl_glance_dim_effect), C2256Dp.m20968constructorimpl(2));
                                            int iM21431getCenterVerticallymnfRV0w = Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w();
                                            final WidgetListGlance.WidgetListItem widgetListItem4 = widgetListItem3;
                                            final float f8 = f7;
                                            final long j8 = j7;
                                            final int i14 = i12;
                                            final WidgetListGlanceTheme widgetListGlanceTheme5 = widgetListGlanceTheme4;
                                            RowKt.m21502RowlMAjyxE(glanceModifierM21286cornerRadius3ABfNKs2, 0, iM21431getCenterVerticallymnfRV0w, ComposableLambdaKt.rememberComposableLambda(318467481, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempCustom.1.1.1.1.1.1.1.1
                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer5, Integer num) {
                                                    invoke(rowScope, composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                @Composable
                                                public final void invoke(RowScope Row, Composer composer5, int i15) {
                                                    Intrinsics.checkNotNullParameter(Row, "$this$Row");
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(318467481, i15, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempCustom.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:252)");
                                                    }
                                                    composer5.startReplaceGroup(1104573632);
                                                    if (widgetListItem4.getIcon() != null) {
                                                        GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                                                        GlanceModifier glanceModifierM21496padding3ABfNKs = PaddingKt.m21496padding3ABfNKs(CornerRadiusKt.m21286cornerRadius3ABfNKs(BackgroundKt.m21250background4WTKRHQ(SizeModifiersKt.m21506size3ABfNKs(companion2, C2256Dp.m20968constructorimpl(f8)), j8), C2256Dp.m20968constructorimpl(f8 / 2)), C2256Dp.m20968constructorimpl(i14));
                                                        Alignment center = Alignment.INSTANCE.getCenter();
                                                        final WidgetListGlance.WidgetListItem widgetListItem5 = widgetListItem4;
                                                        final float f9 = f8;
                                                        final int i16 = i14;
                                                        BoxKt.Box(glanceModifierM21496padding3ABfNKs, center, ComposableLambdaKt.rememberComposableLambda(1840013970, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempCustom.1.1.1.1.1.1.1.1.1
                                                            @Override // kotlin.jvm.functions.Function2
                                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                                invoke(composer6, num.intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                            @Composable
                                                            public final void invoke(Composer composer6, int i17) {
                                                                if ((i17 & 3) == 2 && composer6.getSkipping()) {
                                                                    composer6.skipToGroupEnd();
                                                                    return;
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1840013970, i17, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempCustom.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:261)");
                                                                }
                                                                ImageKt.m21259ImageGCr5PR4(widgetListItem5.getIcon().getImageProvider(), "thumbnail", CornerRadiusKt.m21286cornerRadius3ABfNKs(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(f9 - (i16 * 2)) / 2)), ContentScale.INSTANCE.m21465getCropAe3V0ko(), null, composer6, 48, 16);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }, composer5, 54), composer5, (Alignment.$stable << 3) | 384, 0);
                                                        SpacerKt.Spacer(SizeModifiersKt.m21508width3ABfNKs(companion2, C2256Dp.m20968constructorimpl(8)), composer5, 0, 0);
                                                    }
                                                    composer5.endReplaceGroup();
                                                    GlanceModifier glanceModifierM21500paddingqDBjuR0$default2 = PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.wrapContentHeight(Row.defaultWeight(GlanceModifier.INSTANCE)), 0.0f, C2256Dp.m20968constructorimpl(7), 0.0f, C2256Dp.m20968constructorimpl((float) 5.2d), 5, null);
                                                    final WidgetListGlance.WidgetListItem widgetListItem6 = widgetListItem4;
                                                    final WidgetListGlanceTheme widgetListGlanceTheme6 = widgetListGlanceTheme5;
                                                    ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21500paddingqDBjuR0$default2, 0, 0, ComposableLambdaKt.rememberComposableLambda(-1678809969, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempCustom.1.1.1.1.1.1.1.1.2
                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer6, Integer num) {
                                                            invoke(columnScope, composer6, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                        @Composable
                                                        public final void invoke(ColumnScope Column2, Composer composer6, int i17) {
                                                            Intrinsics.checkNotNullParameter(Column2, "$this$Column");
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1678809969, i17, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempCustom.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:285)");
                                                            }
                                                            widgetListItem6.TitleTextTemplate(widgetListGlanceTheme6, composer6, 0);
                                                            GlanceModifier.Companion companion3 = GlanceModifier.INSTANCE;
                                                            SpacerKt.Spacer(SizeModifiersKt.m21505height3ABfNKs(companion3, C2256Dp.m20968constructorimpl((float) 0.8d)), composer6, 0, 0);
                                                            GlanceModifier glanceModifierWrapContentSize = SizeModifiersKt.wrapContentSize(companion3);
                                                            int iM21431getCenterVerticallymnfRV0w2 = Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w();
                                                            final WidgetListGlance.WidgetListItem widgetListItem7 = widgetListItem6;
                                                            final WidgetListGlanceTheme widgetListGlanceTheme7 = widgetListGlanceTheme6;
                                                            RowKt.m21502RowlMAjyxE(glanceModifierWrapContentSize, 0, iM21431getCenterVerticallymnfRV0w2, ComposableLambdaKt.rememberComposableLambda(-1972782093, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempCustom.1.1.1.1.1.1.1.1.2.1
                                                                @Override // kotlin.jvm.functions.Function3
                                                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer7, Integer num) {
                                                                    invoke(rowScope, composer7, num.intValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                                @Composable
                                                                public final void invoke(RowScope Row2, Composer composer7, int i18) {
                                                                    Intrinsics.checkNotNullParameter(Row2, "$this$Row");
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1972782093, i18, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempCustom.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:292)");
                                                                    }
                                                                    widgetListItem7.TimeTextTemplate(widgetListGlanceTheme7, composer7, 0);
                                                                    int size = widgetListItem7.getIcons().size();
                                                                    WidgetListGlance.WidgetListItem widgetListItem8 = widgetListItem7;
                                                                    for (int i19 = 0; i19 < size; i19++) {
                                                                        float f10 = 13;
                                                                        androidx.glance.oneui.template.component.ImageKt.m21705TemplateImage73KfpEQ(widgetListItem8.getIcons().get(i19), C2256Dp.m20968constructorimpl(f10), C2256Dp.m20968constructorimpl(f10), composer7, ImageData.$stable | 432);
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                            }, composer6, 54), composer6, 3072, 2);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }, composer5, 54), composer5, 3072, 6);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, composer4, 54), composer4, 3072, 2);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer3, 54), composer3, 384, 2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer2, 54), composer2, 384, 2);
                            if (z) {
                                GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(PaddingKt.m21500paddingqDBjuR0$default(companion, C2256Dp.m20968constructorimpl(DeviceUtils.isTabletModel() ? 57 : 46), 0.0f, C2256Dp.m20968constructorimpl(14), 0.0f, 10, null)));
                                final long j7 = j5;
                                BoxKt.Box(glanceModifierWrapContentHeight, null, ComposableLambdaKt.rememberComposableLambda(-1044920722, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance$ListTempCustom$1$1$1$1$1.2
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(Composer composer3, int i11) {
                                        if ((i11 & 3) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1044920722, i11, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempCustom.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:316)");
                                        }
                                        SpacerKt.Spacer(BackgroundKt.m21250background4WTKRHQ(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(1)), j7), composer3, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer2, 54), composer2, 384, 2);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer, 54), composer, 3072, 7);
                    composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(Composer composer, int i) {
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1829261957, i, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempCustom.<anonymous> (WidgetListGlance.kt:222)");
            }
            GlanceModifier glanceModifierFillMaxHeight = SizeModifiersKt.fillMaxHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
            composer.startReplaceGroup(-1224400529);
            boolean zChangedInstance = composer.changedInstance(this.$listData) | composer.changed(this.$visibleItemCount) | composer.changed(this.$iconSize) | composer.changed(this.$strokeIconColor) | composer.changedInstance(this.$themeManager) | composer.changed(this.$colorDivider);
            final List<WidgetListItem> list = this.$listData;
            final int i2 = this.$visibleItemCount;
            final float f = this.$iconSize;
            final long j = this.$strokeIconColor;
            final int i4 = this.$strokeIconWidth;
            final WidgetListGlanceTheme widgetListGlanceTheme = this.$themeManager;
            final long j2 = this.$colorDivider;
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.samsung.android.app.notes.widget.glance.list.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WidgetListGlance.C69181.invoke$lambda$2$lambda$1(list, i2, f, j, i4, widgetListGlanceTheme, j2, (LazyListScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceGroup();
            LazyListKt.m21344LazyColumnEiNPFjs(glanceModifierFillMaxHeight, 0, (Function1) objRememberedValue, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListTemp$lambda$1(WidgetListGlance widgetListGlance, WidgetListGlanceTheme widgetListGlanceTheme, List list, String str, int i, Composer composer, int i2) {
        widgetListGlance.ListTemp(widgetListGlanceTheme, list, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListTempCustom$lambda$2(WidgetListGlance widgetListGlance, WidgetListGlanceTheme widgetListGlanceTheme, List list, String str, int i, Composer composer, int i2) {
        widgetListGlance.ListTempCustom(widgetListGlanceTheme, list, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListTempForWidgetCover$lambda$3(WidgetListGlance widgetListGlance, Context context, int i, String str, List list, WidgetListGlanceTheme widgetListGlanceTheme, List list2, int i2, int i4, Composer composer, int i5) {
        widgetListGlance.ListTempForWidgetCover(context, i, str, list, widgetListGlanceTheme, list2, i2, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TemplateContent$lambda$0(WidgetListGlance widgetListGlance, int i, Composer composer, int i2) {
        widgetListGlance.TemplateContent(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WidgetEmptyMedium_gaecCbA$lambda$5(WidgetListGlance widgetListGlance, Context context, int i, int i2, WidgetListGlanceTheme widgetListGlanceTheme, String str, int i4, Composer composer, int i5) {
        widgetListGlance.m22125WidgetEmptyMediumgaecCbA(context, i, i2, widgetListGlanceTheme, str, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WidgetEmptySmall$lambda$6(WidgetListGlance widgetListGlance, Context context, int i, WidgetListGlanceTheme widgetListGlanceTheme, String str, int i2, Composer composer, int i4) {
        widgetListGlance.WidgetEmptySmall(context, i, widgetListGlanceTheme, str, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    /* JADX INFO: renamed from: WidgetListEmpty-gaecCbA, reason: not valid java name */
    public final void m22123WidgetListEmptygaecCbA(Context context, int i, int i2, WidgetListGlanceTheme widgetListGlanceTheme, String str, Composer composer, int i4) {
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1077761655);
        if ((i4 & 6) == 0) {
            i5 = (composerStartRestartGroup.changedInstance(context) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerStartRestartGroup.changed(i2) ? 256 : 128;
        }
        if ((i4 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(widgetListGlanceTheme) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changed(str) ? 16384 : 8192;
        }
        if ((196608 & i4) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(this) ? 131072 : 65536;
        }
        if ((74899 & i5) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1077761655, i5, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetListEmpty (WidgetListGlance.kt:592)");
            }
            if (AppWidgetSize.m21546compareToL2j3NV4(i2, AppWidgetSize.INSTANCE.m21570getSmallrx25Pp4()) <= 0) {
                composerStartRestartGroup.startReplaceGroup(1578256863);
                int i6 = i5 & 126;
                int i7 = i5 >> 3;
                WidgetEmptySmall(context, i, widgetListGlanceTheme, str, composerStartRestartGroup, i6 | (i7 & 896) | (i7 & 7168) | (i7 & 57344));
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1578352498);
                m22125WidgetEmptyMediumgaecCbA(context, i, i2, widgetListGlanceTheme, str, composerStartRestartGroup, i5 & 524286);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6935a(this, context, i, i2, widgetListGlanceTheme, str, i4, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WidgetListEmpty_gaecCbA$lambda$4(WidgetListGlance widgetListGlance, Context context, int i, int i2, WidgetListGlanceTheme widgetListGlanceTheme, String str, int i4, Composer composer, int i5) {
        widgetListGlance.m22123WidgetListEmptygaecCbA(context, i, i2, widgetListGlanceTheme, str, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public final void WidgetListExtraLargeCoverEmpty(final Context context, final int i, final WidgetListGlanceTheme widgetListGlanceTheme, final String str, Composer composer, int i2) {
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(702974479);
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(context) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(widgetListGlanceTheme) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(str) ? 2048 : 1024;
        }
        if ((i4 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(702974479, i4, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetListExtraLargeCoverEmpty (WidgetListGlance.kt:831)");
            }
            GlanceModifier glanceModifierClickable = ActionKt.clickable(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), SendBroadcastActionKt.actionSendBroadcast(WidgetListGlanceUtils.INSTANCE.addStartNotePicker(context, i, str)));
            Alignment.Companion companion = Alignment.INSTANCE;
            ColumnKt.m21455ColumnK4GKKTE(glanceModifierClickable, companion.m21431getCenterVerticallymnfRV0w(), companion.m21430getCenterHorizontallyPGIyAqw(), ComposableLambdaKt.rememberComposableLambda(-1529792891, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetListExtraLargeCoverEmpty.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                    invoke(columnScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                @Composable
                public final void invoke(ColumnScope Column, Composer composer2, int i5) {
                    Intrinsics.checkNotNullParameter(Column, "$this$Column");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1529792891, i5, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetListExtraLargeCoverEmpty.<anonymous> (WidgetListGlance.kt:839)");
                    }
                    GlanceModifier glanceModifierM21286cornerRadius3ABfNKs = CornerRadiusKt.m21286cornerRadius3ABfNKs(SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(38)), CommonDimensions.INSTANCE.m21773getDefaultCornerRadiusD9Ej5fM());
                    final Context context2 = context;
                    final int i6 = i;
                    final String str2 = str;
                    BoxKt.Box(glanceModifierM21286cornerRadius3ABfNKs, null, ComposableLambdaKt.rememberComposableLambda(-1560231965, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetListExtraLargeCoverEmpty.1.1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                        @Composable
                        public final void invoke(Composer composer3, int i7) {
                            if ((i7 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1560231965, i7, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetListExtraLargeCoverEmpty.<anonymous>.<anonymous> (WidgetListGlance.kt:844)");
                            }
                            ImageButtonKt.m21297ImageButtonaCxP0qg(ImageKt.ImageProvider(C11391R.drawable.ic_induce_app_icon), context2.getResources().getString(C11391R.string.app_name_simple), SendBroadcastActionKt.actionSendBroadcast(WidgetListGlanceUtils.INSTANCE.addStartNotePicker(context2, i6, str2)), BackgroundKt.background(PaddingKt.m21496padding3ABfNKs(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl((float) 6.3d)), ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU())), false, ContentScale.INSTANCE.m21465getCropAe3V0ko(), null, composer3, 0, 80);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 384, 2);
                    TextData textData = new TextData(C11391R.string.app_name_simple, widgetListGlanceTheme.updateListItemTitleColor(), 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32764, (DefaultConstructorMarker) null);
                    long sp = TextUnitKt.getSp(14);
                    FontWeight.Companion companion2 = FontWeight.INSTANCE;
                    int iM21996getBoldWjrlUT0 = companion2.m21996getBoldWjrlUT0();
                    int i7 = TextData.$stable;
                    TextKt.m21709TemplateText3SkNqBk(textData, sp, iM21996getBoldWjrlUT0, 0.0f, composer2, i7 | 48, 8);
                    TextKt.m21709TemplateText3SkNqBk(new TextData(C11391R.string.widget_preview_note_list_tap_to_add_notes, widgetListGlanceTheme.updateBodyTextColor(), 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32764, (DefaultConstructorMarker) null), TextUnitKt.getSp(12), companion2.m21998getNormalWjrlUT0(), 0.0f, composer2, i7 | 48, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 3072, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6937c(this, context, i, widgetListGlanceTheme, str, i2, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WidgetListExtraLargeCoverEmpty$lambda$7(WidgetListGlance widgetListGlance, Context context, int i, WidgetListGlanceTheme widgetListGlanceTheme, String str, int i2, Composer composer, int i4) {
        widgetListGlance.WidgetListExtraLargeCoverEmpty(context, i, widgetListGlanceTheme, str, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    private final List<WidgetListItem> buildItem(Context context, int appWidgetId, String providerName, WidgetListGlanceTheme themeManager, List<String> uuidList) {
        ArrayList arrayList = new ArrayList();
        MainListDocumentDataRepository mainListDocumentDataRepositoryCreateMainListDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository();
        boolean zIsBlackBackground = themeManager.isBlackBackground();
        for (String str : uuidList) {
            MainListDocumentData mainListDocumentData = mainListDocumentDataRepositoryCreateMainListDocumentDataRepository.get(str);
            if (mainListDocumentData != null) {
                WidgetListGlanceItem widgetListGlanceItem = new WidgetListGlanceItem(context, appWidgetId, mainListDocumentData, str, mainListDocumentData.getIsLock() != 5, zIsBlackBackground);
                arrayList.add(new WidgetListItem(this, widgetListGlanceItem.getTitle(), widgetListGlanceItem.getTime(), widgetListGlanceItem.getIcon(), widgetListGlanceItem.getIconVoiceAndFavorite(themeManager.updateListItemIconVoiceColor()), null, SendBroadcastActionKt.actionSendBroadcast(widgetListGlanceItem.addIntentOpenNote(providerName)), context, appWidgetId, themeManager, 16, null));
            }
        }
        return arrayList;
    }

    @Composable
    private final TitleBarData getTitleBar(Context context, int i, WidgetListGlanceTheme widgetListGlanceTheme, List<String> list, List<? extends ListItem> list2, String str, Composer composer, int i2) {
        ActionButtonData actionButtonData;
        composer.startReplaceGroup(-892080740);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-892080740, i2, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.getTitleBar (WidgetListGlance.kt:174)");
        }
        if (list2.isEmpty() || Intrinsics.areEqual(str, WidgetListExtraLargeCoverProvider.TAG)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return null;
        }
        String string = context.getResources().getString(C11391R.string.app_name_simple);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        TextData textData = new TextData(string, ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18551getBlack0d7_KjU()), 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32764, (DefaultConstructorMarker) null);
        if (list2.size() < 10) {
            actionButtonData = new ActionButtonData((Intrinsics.areEqual(str, "WidgetListProvider") || Intrinsics.areEqual(str, BaseWidgetConstant.WIDGET_LIST_LOCK_BRIEF_PROVIDER_NAME)) ? ActionIcon.Add : ActionIcon.MoreOptions, context.getResources().getString(C11391R.string.add_note), SendBroadcastActionKt.actionSendBroadcast((Intrinsics.areEqual(str, "WidgetListProvider") || Intrinsics.areEqual(str, BaseWidgetConstant.WIDGET_LIST_LOCK_BRIEF_PROVIDER_NAME)) ? WidgetListGlanceUtils.INSTANCE.addIntentPickNotes(context, i, list, str) : WidgetListGlanceUtils.INSTANCE.intentStartSetting(context, i, list, str)), widgetListGlanceTheme.updateListItemTitleColor(), false, false, 48, null);
        } else {
            actionButtonData = null;
        }
        TitleBarData titleBarData = new TitleBarData(textData, null, actionButtonData, null, false, 26, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return titleBarData;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void ListTemp(@NotNull WidgetListGlanceTheme themeManager, @NotNull List<WidgetListItem> buildItemList, @NotNull String providerName, @Nullable Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(themeManager, "themeManager");
        Intrinsics.checkNotNullParameter(buildItemList, "buildItemList");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Composer composerStartRestartGroup = composer.startRestartGroup(611366674);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(themeManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(buildItemList) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(providerName) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(611366674, i2, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTemp (WidgetListGlance.kt:196)");
            }
            ListTempCustom(themeManager, buildItemList, providerName, composerStartRestartGroup, i2 & 8190);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6936b(this, themeManager, buildItemList, providerName, i, 1));
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void ListTempCustom(@NotNull WidgetListGlanceTheme themeManager, @NotNull List<WidgetListItem> listData, @NotNull String providerName, @Nullable Composer composer, int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(themeManager, "themeManager");
        Intrinsics.checkNotNullParameter(listData, "listData");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Composer composerStartRestartGroup = composer.startRestartGroup(230923555);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(themeManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(listData) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(providerName) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(230923555, i2, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempCustom (WidgetListGlance.kt:201)");
            }
            int size = listData.size();
            long jColor = themeManager.isBlackBackground() ? ColorKt.Color(654311423) : ColorKt.Color(637534208);
            boolean z = AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) >= 0;
            float f = 28.0f;
            if (Build.VERSION.SDK_INT >= 31 && DeviceUtils.isTabletModel() && !Intrinsics.areEqual(providerName, BaseWidgetConstant.WIDGET_LIST_LOCK_BRIEF_PROVIDER_NAME)) {
                f = 34.0f;
            }
            composer2 = composerStartRestartGroup;
            BoxKt.Box(PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.fillMaxHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), 0.0f, C2256Dp.m20968constructorimpl(z ? 0 : 6), 0.0f, C2256Dp.m20968constructorimpl(z ? 14 : 5), 5, null), Alignment.INSTANCE.getCenterStart(), ComposableLambdaKt.rememberComposableLambda(1829261957, true, new C69181(listData, size, f, ColorKt.Color(themeManager.isBlackBackground() ? 654311423 : 436207616), themeManager, jColor, 1), composerStartRestartGroup, 54), composer2, (Alignment.$stable << 3) | 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6936b(this, themeManager, listData, providerName, i, 0));
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public final void ListTempForWidgetCover(@NotNull final Context context, final int i, @NotNull final String providerName, @NotNull final List<String> uuidList, @NotNull final WidgetListGlanceTheme themeManager, @NotNull final List<WidgetListItem> listData, final int i2, @Nullable Composer composer, final int i4) {
        int i5;
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        Intrinsics.checkNotNullParameter(themeManager, "themeManager");
        Intrinsics.checkNotNullParameter(listData, "listData");
        Composer composerStartRestartGroup = composer.startRestartGroup(1797882297);
        if ((i4 & 6) == 0) {
            i5 = (composerStartRestartGroup.changedInstance(context) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 = i;
            i5 |= composerStartRestartGroup.changed(i6) ? 32 : 16;
        } else {
            i6 = i;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerStartRestartGroup.changed(providerName) ? 256 : 128;
        }
        if ((i4 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(uuidList) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(themeManager) ? 16384 : 8192;
        }
        if ((196608 & i4) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(listData) ? 131072 : 65536;
        }
        if ((1572864 & i4) == 0) {
            i5 |= composerStartRestartGroup.changed(i2) ? 1048576 : 524288;
        }
        if ((599187 & i5) == 599186 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1797882297, i5, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover (WidgetListGlance.kt:332)");
            }
            final int size = listData.size();
            final long jColor = ColorKt.Color(themeManager.isBlackBackground() ? 654311423 : 637534208);
            final int i7 = i6;
            composer2 = composerStartRestartGroup;
            ColumnKt.m21455ColumnK4GKKTE(MarginKt.m21310marginqDBjuR0$default(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), 0.0f, 0.0f, 0.0f, C2256Dp.m20968constructorimpl(i2 == 2 ? 78 : 0), 7, null), Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w(), 0, ComposableLambdaKt.rememberComposableLambda(-1602060881, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover.1

                /* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance$ListTempForWidgetCover$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
                @SourceDebugExtension({"SMAP\nWidgetListGlance.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetListGlance.kt\ncom/samsung/android/app/notes/widget/glance/list/WidgetListGlance$ListTempForWidgetCover$1$2\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 LazyList.kt\nandroidx/glance/appwidget/lazy/LazyListKt\n*L\n1#1,876:1\n1225#2,6:877\n236#3,8:883\n*S KotlinDebug\n*F\n+ 1 WidgetListGlance.kt\ncom/samsung/android/app/notes/widget/glance/list/WidgetListGlance$ListTempForWidgetCover$1$2\n*L\n407#1:877,6\n408#1:883,8\n*E\n"})
                public static final class AnonymousClass2 implements Function2<Composer, Integer, Unit> {
                    final /* synthetic */ long $colorDivider;
                    final /* synthetic */ List<WidgetListItem> $listData;
                    final /* synthetic */ WidgetListGlanceTheme $themeManager;
                    final /* synthetic */ int $visibleItemCount;

                    public AnonymousClass2(List<WidgetListItem> list, int i, WidgetListGlanceTheme widgetListGlanceTheme, long j) {
                        this.$listData = list;
                        this.$visibleItemCount = i;
                        this.$themeManager = widgetListGlanceTheme;
                        this.$colorDivider = j;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$2$lambda$1(final List list, final int i, final WidgetListGlanceTheme widgetListGlanceTheme, final long j, LazyListScope LazyColumn) {
                        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                        LazyColumn.items(list.size(), new Function1<Integer, Long>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance$ListTempForWidgetCover$1$2$invoke$lambda$2$lambda$1$$inlined$itemsIndexed$default$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @NotNull
                            public final Long invoke(int i2) {
                                list.get(i2);
                                return Long.MIN_VALUE;
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Long invoke(Integer num) {
                                return invoke(num.intValue());
                            }
                        }, ComposableLambdaKt.composableLambdaInstance(-1405343893, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance$ListTempForWidgetCover$1$2$invoke$lambda$2$lambda$1$$inlined$itemsIndexed$default$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            @Composable
                            public final void invoke(@NotNull LazyItemScope items, int i2, @Nullable Composer composer, int i4) {
                                int i5;
                                Intrinsics.checkNotNullParameter(items, "$this$items");
                                if ((i4 & 14) == 0) {
                                    i5 = (composer.changed(items) ? 4 : 2) | i4;
                                } else {
                                    i5 = i4;
                                }
                                if ((i4 & 112) == 0) {
                                    i5 |= composer.changed(i2) ? 32 : 16;
                                }
                                if ((i5 & 731) == 146 && composer.getSkipping()) {
                                    composer.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1405343893, i5, -1, "androidx.glance.appwidget.lazy.itemsIndexed.<anonymous> (LazyList.kt:241)");
                                }
                                final WidgetListGlance.WidgetListItem widgetListItem = (WidgetListGlance.WidgetListItem) list.get(i2);
                                composer.startReplaceGroup(987178044);
                                int i6 = i;
                                final boolean z = i6 > 1 && i2 < i6 - 1;
                                final WidgetListGlanceTheme widgetListGlanceTheme2 = widgetListGlanceTheme;
                                final long j2 = j;
                                ColumnKt.m21455ColumnK4GKKTE(null, 0, 0, ComposableLambdaKt.rememberComposableLambda(-656445795, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance$ListTempForWidgetCover$1$2$1$1$1$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                                        invoke(columnScope, composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(ColumnScope Column, Composer composer2, int i7) {
                                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-656445795, i7, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:410)");
                                        }
                                        GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                                        float f = 16;
                                        GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(companion, C2256Dp.m20968constructorimpl(14), 0.0f, C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(0), 2, null);
                                        final WidgetListGlance.WidgetListItem widgetListItem2 = widgetListItem;
                                        final WidgetListGlanceTheme widgetListGlanceTheme3 = widgetListGlanceTheme2;
                                        BoxKt.Box(glanceModifierM21500paddingqDBjuR0$default, null, ComposableLambdaKt.rememberComposableLambda(1250822015, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance$ListTempForWidgetCover$1$2$1$1$1$1.1
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                            @Composable
                                            public final void invoke(Composer composer3, int i8) {
                                                if ((i8 & 3) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1250822015, i8, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:418)");
                                                }
                                                GlanceModifier glanceModifierFillMaxWidth = SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE);
                                                Action onClick = widgetListItem2.getOnClick();
                                                Intrinsics.checkNotNull(onClick);
                                                GlanceModifier glanceModifierM21286cornerRadius3ABfNKs = CornerRadiusKt.m21286cornerRadius3ABfNKs(ActionKt.clickable(glanceModifierFillMaxWidth, onClick), C2256Dp.m20968constructorimpl(2));
                                                int iM21431getCenterVerticallymnfRV0w = Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w();
                                                final WidgetListGlance.WidgetListItem widgetListItem3 = widgetListItem2;
                                                final WidgetListGlanceTheme widgetListGlanceTheme4 = widgetListGlanceTheme3;
                                                RowKt.m21502RowlMAjyxE(glanceModifierM21286cornerRadius3ABfNKs, 0, iM21431getCenterVerticallymnfRV0w, ComposableLambdaKt.rememberComposableLambda(-719154717, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover.1.2.1.1.1.1.1.1
                                                    @Override // kotlin.jvm.functions.Function3
                                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                                                        invoke(rowScope, composer4, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                    @Composable
                                                    public final void invoke(RowScope Row, Composer composer4, int i9) {
                                                        Intrinsics.checkNotNullParameter(Row, "$this$Row");
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-719154717, i9, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:425)");
                                                        }
                                                        GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                                                        GlanceModifier glanceModifierM21506size3ABfNKs = SizeModifiersKt.m21506size3ABfNKs(CornerRadiusKt.m21286cornerRadius3ABfNKs(companion2, C2256Dp.m20968constructorimpl(1)), C2256Dp.m20968constructorimpl(28));
                                                        Alignment center = Alignment.INSTANCE.getCenter();
                                                        final WidgetListGlance.WidgetListItem widgetListItem4 = widgetListItem3;
                                                        BoxKt.Box(glanceModifierM21506size3ABfNKs, center, ComposableLambdaKt.rememberComposableLambda(405686721, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover.1.2.1.1.1.1.1.1.1
                                                            @Override // kotlin.jvm.functions.Function2
                                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                                invoke(composer5, num.intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                            @Composable
                                                            public final void invoke(Composer composer5, int i10) {
                                                                if ((i10 & 3) == 2 && composer5.getSkipping()) {
                                                                    composer5.skipToGroupEnd();
                                                                    return;
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(405686721, i10, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:431)");
                                                                }
                                                                ImageWithBackgroundData icon = widgetListItem4.getIcon();
                                                                ImageProvider imageProvider = icon != null ? icon.getImageProvider() : null;
                                                                Intrinsics.checkNotNull(imageProvider);
                                                                ImageKt.m21259ImageGCr5PR4(imageProvider, "thumbnail", SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), ContentScale.INSTANCE.m21465getCropAe3V0ko(), null, composer5, 48, 16);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }, composer4, 54), composer4, (Alignment.$stable << 3) | 384, 0);
                                                        SpacerKt.Spacer(SizeModifiersKt.m21508width3ABfNKs(companion2, C2256Dp.m20968constructorimpl(8)), composer4, 0, 0);
                                                        GlanceModifier glanceModifierM21500paddingqDBjuR0$default2 = PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.wrapContentHeight(Row.defaultWeight(companion2)), 0.0f, C2256Dp.m20968constructorimpl(7), 0.0f, C2256Dp.m20968constructorimpl((float) 5.2d), 5, null);
                                                        final WidgetListGlance.WidgetListItem widgetListItem5 = widgetListItem3;
                                                        final WidgetListGlanceTheme widgetListGlanceTheme5 = widgetListGlanceTheme4;
                                                        ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21500paddingqDBjuR0$default2, 0, 0, ComposableLambdaKt.rememberComposableLambda(251162585, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover.1.2.1.1.1.1.1.1.2
                                                            @Override // kotlin.jvm.functions.Function3
                                                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer5, Integer num) {
                                                                invoke(columnScope, composer5, num.intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                            @Composable
                                                            public final void invoke(ColumnScope Column2, Composer composer5, int i10) {
                                                                Intrinsics.checkNotNullParameter(Column2, "$this$Column");
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(251162585, i10, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:452)");
                                                                }
                                                                widgetListItem5.TitleTextTemplate(widgetListGlanceTheme5, composer5, 0);
                                                                GlanceModifier.Companion companion3 = GlanceModifier.INSTANCE;
                                                                SpacerKt.Spacer(SizeModifiersKt.m21505height3ABfNKs(companion3, C2256Dp.m20968constructorimpl((float) 0.8d)), composer5, 0, 0);
                                                                GlanceModifier glanceModifierWrapContentSize = SizeModifiersKt.wrapContentSize(companion3);
                                                                int iM21431getCenterVerticallymnfRV0w2 = Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w();
                                                                final WidgetListGlance.WidgetListItem widgetListItem6 = widgetListItem5;
                                                                final WidgetListGlanceTheme widgetListGlanceTheme6 = widgetListGlanceTheme5;
                                                                RowKt.m21502RowlMAjyxE(glanceModifierWrapContentSize, 0, iM21431getCenterVerticallymnfRV0w2, ComposableLambdaKt.rememberComposableLambda(-1218952899, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover.1.2.1.1.1.1.1.1.2.1
                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer6, Integer num) {
                                                                        invoke(rowScope, composer6, num.intValue());
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                                    @Composable
                                                                    public final void invoke(RowScope Row2, Composer composer6, int i11) {
                                                                        Intrinsics.checkNotNullParameter(Row2, "$this$Row");
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-1218952899, i11, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:459)");
                                                                        }
                                                                        widgetListItem6.TimeTextTemplate(widgetListGlanceTheme6, composer6, 0);
                                                                        int size = widgetListItem6.getIcons().size();
                                                                        WidgetListGlance.WidgetListItem widgetListItem7 = widgetListItem6;
                                                                        for (int i12 = 0; i12 < size; i12++) {
                                                                            float f4 = 13;
                                                                            androidx.glance.oneui.template.component.ImageKt.m21705TemplateImage73KfpEQ(widgetListItem7.getIcons().get(i12), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f4), composer6, ImageData.$stable | 432);
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                }, composer5, 54), composer5, 3072, 2);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }, composer4, 54), composer4, 3072, 6);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, composer3, 54), composer3, 3072, 2);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composer2, 54), composer2, 384, 2);
                                        if (z) {
                                            GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(PaddingKt.m21500paddingqDBjuR0$default(companion, C2256Dp.m20968constructorimpl(36), 0.0f, C2256Dp.m20968constructorimpl(f), 0.0f, 10, null)));
                                            final long j3 = j2;
                                            BoxKt.Box(glanceModifierWrapContentHeight, null, ComposableLambdaKt.rememberComposableLambda(-1962439740, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance$ListTempForWidgetCover$1$2$1$1$1$1.2
                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                    invoke(composer3, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                @Composable
                                                public final void invoke(Composer composer3, int i8) {
                                                    if ((i8 & 3) == 2 && composer3.getSkipping()) {
                                                        composer3.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1962439740, i8, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:478)");
                                                    }
                                                    SpacerKt.Spacer(BackgroundKt.m21250background4WTKRHQ(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(1)), j3), composer3, 0, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, composer2, 54), composer2, 384, 2);
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer, 54), composer, 3072, 7);
                                composer.endReplaceGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    public final void invoke(Composer composer, int i) {
                        if ((i & 3) == 2 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1582233459, i, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover.<anonymous>.<anonymous> (WidgetListGlance.kt:402)");
                        }
                        GlanceModifier glanceModifierFillMaxHeight = SizeModifiersKt.fillMaxHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
                        composer.startReplaceGroup(-1224400529);
                        boolean zChangedInstance = composer.changedInstance(this.$listData) | composer.changed(this.$visibleItemCount) | composer.changedInstance(this.$themeManager) | composer.changed(this.$colorDivider);
                        final List<WidgetListItem> list = this.$listData;
                        final int i2 = this.$visibleItemCount;
                        final WidgetListGlanceTheme widgetListGlanceTheme = this.$themeManager;
                        final long j = this.$colorDivider;
                        Object objRememberedValue = composer.rememberedValue();
                        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.samsung.android.app.notes.widget.glance.list.f
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return WidgetListGlance.C69231.AnonymousClass2.invoke$lambda$2$lambda$1(list, i2, widgetListGlanceTheme, j, (LazyListScope) obj);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue);
                        }
                        composer.endReplaceGroup();
                        LazyListKt.m21344LazyColumnEiNPFjs(glanceModifierFillMaxHeight, 0, (Function1) objRememberedValue, composer, 0, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                @Composable
                public final void invoke(ColumnScope Column, Composer composer3, int i8) {
                    GlanceModifier glanceModifierM21309marginqDBjuR0;
                    Intrinsics.checkNotNullParameter(Column, "$this$Column");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1602060881, i8, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover.<anonymous> (WidgetListGlance.kt:341)");
                    }
                    if (i2 == 1) {
                        float f = 0;
                        glanceModifierM21309marginqDBjuR0 = MarginKt.m21309marginqDBjuR0(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(84)), C2256Dp.m20968constructorimpl(JPEG.SOF6), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(16), C2256Dp.m20968constructorimpl(f));
                    } else {
                        float f4 = 16;
                        glanceModifierM21309marginqDBjuR0 = MarginKt.m21309marginqDBjuR0(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(14), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(12));
                    }
                    int iM21453getCenterVerticallymnfRV0w = Alignment.Vertical.INSTANCE.m21453getCenterVerticallymnfRV0w();
                    int iM21430getCenterHorizontallyPGIyAqw = i2 == 1 ? Alignment.INSTANCE.m21430getCenterHorizontallyPGIyAqw() : Alignment.INSTANCE.m21433getStartPGIyAqw();
                    final WidgetListGlanceTheme widgetListGlanceTheme = themeManager;
                    final Context context2 = context;
                    final int i9 = i7;
                    final List<String> list = uuidList;
                    final String str = providerName;
                    RowKt.m21502RowlMAjyxE(glanceModifierM21309marginqDBjuR0, iM21430getCenterHorizontallyPGIyAqw, iM21453getCenterVerticallymnfRV0w, ComposableLambdaKt.rememberComposableLambda(-607378669, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover.1.1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                            invoke(rowScope, composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                        @Composable
                        public final void invoke(RowScope Row, Composer composer4, int i10) {
                            Intrinsics.checkNotNullParameter(Row, "$this$Row");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-607378669, i10, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover.<anonymous>.<anonymous> (WidgetListGlance.kt:361)");
                            }
                            GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                            GlanceModifier glanceModifierDefaultWeight = Row.defaultWeight(companion);
                            final WidgetListGlanceTheme widgetListGlanceTheme2 = widgetListGlanceTheme;
                            BoxKt.Box(glanceModifierDefaultWeight, null, ComposableLambdaKt.rememberComposableLambda(-1257875087, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover.1.1.1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                @Composable
                                public final void invoke(Composer composer5, int i11) {
                                    if ((i11 & 3) == 2 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1257875087, i11, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:365)");
                                    }
                                    TextKt.m21709TemplateText3SkNqBk(new TextData("Notes", widgetListGlanceTheme2.updateListItemTitleColor(), 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32764, (DefaultConstructorMarker) null), TextUnitKt.getSp(16), FontWeight.INSTANCE.m21996getBoldWjrlUT0(), 0.0f, composer5, TextData.$stable | 48, 8);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer4, 54), composer4, 384, 2);
                            GlanceModifier glanceModifierM21286cornerRadius3ABfNKs = CornerRadiusKt.m21286cornerRadius3ABfNKs(BackgroundKt.background(SizeModifiersKt.m21506size3ABfNKs(companion, C2256Dp.m20968constructorimpl(22)), ColorProvidersKt.override(GlanceTheme.INSTANCE.getColors(composer4, GlanceTheme.$stable).getSurface(), widgetListGlanceTheme.getColorSurface())), CommonDimensions.INSTANCE.m21773getDefaultCornerRadiusD9Ej5fM());
                            final Context context3 = context2;
                            final int i11 = i9;
                            final List<String> list2 = list;
                            final String str2 = str;
                            BoxKt.Box(glanceModifierM21286cornerRadius3ABfNKs, null, ComposableLambdaKt.rememberComposableLambda(1175336, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover.1.1.2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                @Composable
                                public final void invoke(Composer composer5, int i12) {
                                    if ((i12 & 3) == 2 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1175336, i12, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.ListTempForWidgetCover.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:381)");
                                    }
                                    ImageButtonKt.m21297ImageButtonaCxP0qg(ImageKt.ImageProvider(C11391R.drawable.sesl_glance_ic_more), "add", SendBroadcastActionKt.actionSendBroadcast(WidgetListGlanceUtils.INSTANCE.intentStartSetting(context3, i11, list2, str2)), BackgroundKt.background(PaddingKt.m21496padding3ABfNKs(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(2)), ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU())), false, ContentScale.INSTANCE.m21465getCropAe3V0ko(), ColorFilter.INSTANCE.tint(GlanceTheme.INSTANCE.getColors(composer5, GlanceTheme.$stable).getOnSurface()), composer5, (ColorFilter.$stable << 18) | 48, 16);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer4, 54), composer4, 384, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer3, 54), composer3, 3072, 0);
                    BoxKt.Box(MarginKt.m21310marginqDBjuR0$default(SizeModifiersKt.fillMaxHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), 0.0f, 0.0f, 0.0f, C2256Dp.m20968constructorimpl(16), 7, null), Alignment.INSTANCE.getTopStart(), ComposableLambdaKt.rememberComposableLambda(-1582233459, true, new AnonymousClass2(listData, size, themeManager, jColor), composer3, 54), composer3, (Alignment.$stable << 3) | 384, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composer2, 3072, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.samsung.android.app.notes.widget.glance.list.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    int iIntValue = ((Integer) obj2).intValue();
                    return WidgetListGlance.ListTempForWidgetCover$lambda$3(this, context, i, providerName, uuidList, themeManager, listData, i2, i4, (Composer) obj, iIntValue);
                }
            });
        }
    }

    @Override // androidx.glance.oneui.template.GlanceTemplateAppWidget
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public void TemplateContent(@Nullable Composer composer, int i) {
        int i2;
        Composer composer2;
        WidgetListGlance widgetListGlance;
        WidgetListGlance widgetListGlance2 = this;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1472114645);
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changedInstance(widgetListGlance2) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
            widgetListGlance = widgetListGlance2;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1472114645, i2, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.TemplateContent (WidgetListGlance.kt:109)");
            }
            final Context context = (Context) composerStartRestartGroup.consume(androidx.glance.CompositionLocalsKt.getLocalContext());
            final int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
            final int appWidgetId = new GlanceAppWidgetManager(context).getAppWidgetId((GlanceId) composerStartRestartGroup.consume(androidx.glance.CompositionLocalsKt.getLocalGlanceId()));
            Preferences.Key<Long> key = requestTimeKey;
            Object objM4741b = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
            if (objM4741b == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
            }
            Long l = (Long) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b, key);
            long jLongValue = l != null ? l.longValue() : 0L;
            Preferences.Key<String> key2 = providerNameKey;
            Object objM4741b2 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
            if (objM4741b2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
            }
            String str = (String) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b2, key2);
            if (str == null) {
                str = "WidgetListProvider";
            }
            Preferences.Key<Integer> key3 = transparencyKey;
            Object objM4741b3 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
            if (objM4741b3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
            }
            Integer num = (Integer) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b3, key3);
            int iIntValue = num != null ? num.intValue() : 75;
            Preferences.Key<Integer> key4 = backgroundColorKey;
            Object objM4741b4 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
            if (objM4741b4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
            }
            Integer num2 = (Integer) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b4, key4);
            int iIntValue2 = num2 != null ? num2.intValue() : 1;
            Preferences.Key<Integer> key5 = darkModeKey;
            Object objM4741b5 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
            if (objM4741b5 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
            }
            Integer num3 = (Integer) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b5, key5);
            int iIntValue3 = num3 != null ? num3.intValue() : 1;
            Preferences.Key<Boolean> key6 = matchSettingKey;
            Object objM4741b6 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
            if (objM4741b6 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
            }
            Boolean bool = (Boolean) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b6, key6);
            boolean zBooleanValue = bool != null ? bool.booleanValue() : true;
            Preferences.Key<String> key7 = uuidListKey;
            Object objM4741b7 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
            if (objM4741b7 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
            }
            String str2 = (String) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b7, key7);
            if (str2 == null) {
                str2 = "";
            }
            Preferences.Key<Integer> key8 = backgroundShapeKey;
            Object objM4741b8 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
            if (objM4741b8 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
            }
            Integer num4 = (Integer) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b8, key8);
            int iIntValue4 = num4 != null ? num4.intValue() : 0;
            Preferences.Key<Boolean> key9 = backgroundOnOffKey;
            int i4 = iIntValue4;
            Object objM4741b9 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
            if (objM4741b9 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
            }
            Boolean bool2 = (Boolean) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b9, key9);
            boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : true;
            Preferences.Key<Integer> key10 = coverScreenCutoutKey;
            boolean z = zBooleanValue2;
            Object objM4741b10 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
            if (objM4741b10 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
            }
            Integer num5 = (Integer) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b10, key10);
            int iIntValue5 = num5 != null ? num5.intValue() : 0;
            final List<String> listConvertStringToList = WidgetPreferenceManager.INSTANCE.convertStringToList(str2);
            int i5 = iIntValue2;
            final WidgetListGlanceTheme widgetListGlanceTheme = new WidgetListGlanceTheme(context, appWidgetId, iIntValue, i5, iIntValue3, zBooleanValue, z);
            Composer composer3 = composerStartRestartGroup;
            final int i6 = iIntValue5;
            boolean z2 = zBooleanValue;
            final List<WidgetListItem> listBuildItem = buildItem(context, appWidgetId, str, widgetListGlanceTheme, listConvertStringToList);
            long jCurrentTimeMillis = System.currentTimeMillis();
            final String str3 = str;
            StringBuilder sbM1323p = AbstractC1974b.m1323p(jLongValue, "onUpdate: timeUpdate: ", ", currentTime: ");
            sbM1323p.append(jCurrentTimeMillis);
            sbM1323p.append(", appWidgetId: ");
            sbM1323p.append(appWidgetId);
            AbstractC0622a.m1180z(sbM1323p, iIntValue, i5, ", transparency: ", ", backgroundColor: ");
            sbM1323p.append(", darkMode: ");
            sbM1323p.append(iIntValue3);
            sbM1323p.append(", matchSetting: ");
            sbM1323p.append(z2);
            sbM1323p.append(", backgroundShape: ");
            sbM1323p.append(i4);
            sbM1323p.append(", uuidList: ");
            sbM1323p.append(listConvertStringToList);
            sbM1323p.append(", coverScreenCutout: ");
            sbM1323p.append(i6);
            WidgetLogger.m5154d(TAG, sbM1323p.toString());
            WidgetListGlance widgetListGlance3 = this;
            TopLevelLayoutKt.TopLevelLayout(AbstractC0541b.m757C(context.getResources().getString(C11391R.string.notes), " ", context.getResources().getString(C11391R.string.widget_list)), widgetListGlanceTheme.getAppWidgetBackground(listConvertStringToList, m22126getShapenwmoUQ(i4, z, mask), str3), widgetListGlanceTheme.updateBackground(), getTitleBar(context, appWidgetId, widgetListGlanceTheme, listConvertStringToList, listBuildItem, str3, composer3, (i2 << 18) & 3670016), null, context.getResources().getString(C11391R.string.app_name_simple), ComposableLambdaKt.rememberComposableLambda(1329786847, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.TemplateContent.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num6) {
                    invoke(composer4, num6.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(Composer composer4, int i7) {
                    if ((i7 & 3) == 2 && composer4.getSkipping()) {
                        composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1329786847, i7, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.TemplateContent.<anonymous> (WidgetListGlance.kt:135)");
                    }
                    if (!listConvertStringToList.isEmpty() && !listBuildItem.isEmpty()) {
                        composer4.startReplaceGroup(-1098298291);
                        if (Intrinsics.areEqual(str3, WidgetListExtraLargeCoverProvider.TAG)) {
                            composer4.startReplaceGroup(-1098229657);
                            this.ListTempForWidgetCover(context, appWidgetId, str3, listConvertStringToList, widgetListGlanceTheme, listBuildItem, i6, composer4, 0);
                            composer4.endReplaceGroup();
                        } else {
                            composer4.startReplaceGroup(-1098070968);
                            this.ListTemp(widgetListGlanceTheme, listBuildItem, str3, composer4, 0);
                            composer4.endReplaceGroup();
                        }
                        composer4.endReplaceGroup();
                    } else if (listConvertStringToList.isEmpty()) {
                        composer4.startReplaceGroup(-1097661737);
                        if (Intrinsics.areEqual(str3, WidgetListExtraLargeCoverProvider.TAG)) {
                            composer4.startReplaceGroup(-1097594901);
                            this.WidgetListExtraLargeCoverEmpty(context, appWidgetId, widgetListGlanceTheme, str3, composer4, 0);
                            composer4.endReplaceGroup();
                        } else {
                            composer4.startReplaceGroup(-1097469971);
                            this.m22123WidgetListEmptygaecCbA(context, appWidgetId, mask, widgetListGlanceTheme, str3, composer4, 0);
                            composer4.endReplaceGroup();
                        }
                        composer4.endReplaceGroup();
                    } else {
                        composer4.startReplaceGroup(-1097929174);
                        new WidgetListGlanceLoadingView().Content(listConvertStringToList.size(), AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composer4.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) >= 0, widgetListGlanceTheme, composer4, 0);
                        composer4.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer3, 54), composer3, (AppWidgetBackground.$stable << 3) | 1572864 | (ColorProviders.$stable << 6) | (TitleBarData.$stable << 9), 16);
            WidgetLogger.m5154d(TAG, "onUpdate: content widget done# WidgetId: " + appWidgetId + ", currentTime: " + System.currentTimeMillis() + ", durationTime: " + ((r3 - r25) / 1000.0d));
            widgetListGlance = widgetListGlance3;
            composer2 = composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                widgetListGlance = widgetListGlance3;
                composer2 = composer3;
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6916a(widgetListGlance, i, 1));
        }
    }

    @Composable
    /* JADX INFO: renamed from: WidgetEmptyMedium-gaecCbA, reason: not valid java name */
    public final void m22125WidgetEmptyMediumgaecCbA(@NotNull final Context context, int i, int i2, @NotNull final WidgetListGlanceTheme themeManager, @NotNull final String providerName, @Nullable Composer composer, int i4) {
        int i5;
        Composer composer2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(themeManager, "themeManager");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Composer composerStartRestartGroup = composer.startRestartGroup(1633462166);
        if ((i4 & 6) == 0) {
            i5 = (composerStartRestartGroup.changedInstance(context) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerStartRestartGroup.changed(i2) ? 256 : 128;
        }
        if ((i4 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(themeManager) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changed(providerName) ? 16384 : 8192;
        }
        if ((i5 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1633462166, i5, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptyMedium (WidgetListGlance.kt:601)");
            }
            int i6 = ((Bundle) composerStartRestartGroup.consume(androidx.glance.appwidget.CompositionLocalsKt.getLocalAppWidgetOptions())).getInt("semAppWidgetRowSpan");
            int i7 = ((Bundle) composerStartRestartGroup.consume(androidx.glance.appwidget.CompositionLocalsKt.getLocalAppWidgetOptions())).getInt("semAppWidgetColumnSpan");
            composerStartRestartGroup.startReplaceGroup(2094091750);
            float fM21064getHeightD9Ej5fM = (i6 <= 2 || i7 < 4) ? DpSize.m21064getHeightD9Ej5fM(((DpSize) composerStartRestartGroup.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue()) : C2256Dp.m20968constructorimpl(180);
            composerStartRestartGroup.endReplaceGroup();
            final Ref.FloatRef floatRef = new Ref.FloatRef();
            final Ref.LongRef longRef = new Ref.LongRef();
            final Ref.LongRef longRef2 = new Ref.LongRef();
            final Ref.FloatRef floatRef2 = new Ref.FloatRef();
            final Ref.FloatRef floatRef3 = new Ref.FloatRef();
            if (Intrinsics.areEqual(providerName, BaseWidgetConstant.WIDGET_LIST_LOCK_BRIEF_PROVIDER_NAME)) {
                floatRef.element = C2256Dp.m20968constructorimpl(36);
                composer2 = composerStartRestartGroup;
                longRef.element = TextUnitKt.getSp(11);
                longRef2.element = TextUnitKt.getSp(9);
                floatRef2.element = C2256Dp.m20968constructorimpl(54);
                floatRef3.element = C2256Dp.m20968constructorimpl(context.getResources().getDimension(C11391R.dimen.widget_glance_medium_sub_title_margin_bottom));
            } else {
                composer2 = composerStartRestartGroup;
                floatRef.element = C2256Dp.m20968constructorimpl(context.getResources().getDimension(C11391R.dimen.widget_glance_medium_icon_size_with_title));
                longRef.element = TextUnitKt.getSp(14);
                longRef2.element = TextUnitKt.getSp(12);
                floatRef2.element = C2256Dp.m20968constructorimpl(56);
                if (context.getResources().getConfiguration().orientation == 2) {
                    floatRef3.element = C2256Dp.m20968constructorimpl(context.getResources().getDimension(C11391R.dimen.widget_glance_medium_sub_title_margin_bottom));
                } else {
                    floatRef3.element = C2256Dp.m20968constructorimpl(16);
                }
            }
            final int i8 = AppWidgetSize.m21546compareToL2j3NV4(i2, AppWidgetSize.INSTANCE.m21568getLargerx25Pp4()) >= 0 ? ContextUtils.isNightMode(context) ? C11391R.drawable.notes_fg_graphic_large_dark : C11391R.drawable.notes_fg_graphic_large : ContextUtils.isNightMode(context) ? C11391R.drawable.notes_fg_graphic_medium_dark : C11391R.drawable.notes_fg_graphic_medium;
            final float f = fM21064getHeightD9Ej5fM;
            BoxKt.Box(ActionKt.clickable(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), SendBroadcastActionKt.actionSendBroadcast(WidgetListGlanceUtils.INSTANCE.addStartNotePicker(context, i, providerName)), C11391R.drawable.sesl_glance_dim_effect), null, ComposableLambdaKt.rememberComposableLambda(-175122696, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance$WidgetEmptyMedium$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(Composer composer3, int i9) {
                    if ((i9 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-175122696, i9, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptyMedium.<anonymous> (WidgetListGlance.kt:656)");
                    }
                    composer3.startReplaceGroup(-789185189);
                    if (!Intrinsics.areEqual(providerName, BaseWidgetConstant.WIDGET_LIST_LOCK_BRIEF_PROVIDER_NAME)) {
                        GlanceModifier glanceModifierM21505height3ABfNKs = SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), f);
                        final int i10 = i8;
                        final Context context2 = context;
                        BoxKt.Box(glanceModifierM21505height3ABfNKs, null, ComposableLambdaKt.rememberComposableLambda(221571953, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance$WidgetEmptyMedium$1.1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @Composable
                            public final void invoke(Composer composer4, int i11) {
                                if ((i11 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(221571953, i11, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptyMedium.<anonymous>.<anonymous> (WidgetListGlance.kt:662)");
                                }
                                ImageKt.m21259ImageGCr5PR4(ImageKt.ImageProvider(i10), context2.getResources().getString(C11391R.string.widget_welcome_page_title_start), SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), ContentScale.INSTANCE.m21465getCropAe3V0ko(), null, composer4, 0, 16);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54), composer3, 384, 2);
                    }
                    composer3.endReplaceGroup();
                    GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                    float f4 = 14;
                    GlanceModifier glanceModifierM21499paddingqDBjuR0 = PaddingKt.m21499paddingqDBjuR0(SizeModifiersKt.wrapContentSize(companion), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(0));
                    Alignment.Companion companion2 = Alignment.INSTANCE;
                    Alignment topStart = companion2.getTopStart();
                    final Ref.FloatRef floatRef4 = floatRef;
                    final Context context3 = context;
                    BoxKt.Box(glanceModifierM21499paddingqDBjuR0, topStart, ComposableLambdaKt.rememberComposableLambda(-2120352554, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance$WidgetEmptyMedium$1.2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @Composable
                        public final void invoke(Composer composer4, int i11) {
                            if ((i11 & 3) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2120352554, i11, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptyMedium.<anonymous>.<anonymous> (WidgetListGlance.kt:678)");
                            }
                            GlanceModifier glanceModifierM21506size3ABfNKs = SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, floatRef4.element);
                            final Context context4 = context3;
                            BoxKt.Box(glanceModifierM21506size3ABfNKs, null, ComposableLambdaKt.rememberComposableLambda(1553385912, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptyMedium.1.2.1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @Composable
                                public final void invoke(Composer composer5, int i12) {
                                    if ((i12 & 3) == 2 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1553385912, i12, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptyMedium.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:682)");
                                    }
                                    ImageKt.m21259ImageGCr5PR4(ImageKt.ImageProvider(C11391R.drawable.ic_widget_note_512), context4.getResources().getString(C11391R.string.app_name_simple), SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), ContentScale.INSTANCE.m21465getCropAe3V0ko(), null, composer5, 0, 16);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer4, 54), composer4, 384, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer3, 54), composer3, (Alignment.$stable << 3) | 384, 0);
                    float f5 = 16;
                    GlanceModifier glanceModifierM21499paddingqDBjuR02 = PaddingKt.m21499paddingqDBjuR0(SizeModifiersKt.fillMaxSize(companion), C2256Dp.m20968constructorimpl(f5), floatRef2.element, C2256Dp.m20968constructorimpl(f5), floatRef3.element);
                    int iM21429getBottommnfRV0w = companion2.m21429getBottommnfRV0w();
                    int iM21433getStartPGIyAqw = companion2.m21433getStartPGIyAqw();
                    final Context context4 = context;
                    final Ref.LongRef longRef3 = longRef;
                    final WidgetListGlanceTheme widgetListGlanceTheme = themeManager;
                    final Ref.LongRef longRef4 = longRef2;
                    ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21499paddingqDBjuR02, iM21429getBottommnfRV0w, iM21433getStartPGIyAqw, ComposableLambdaKt.rememberComposableLambda(1032551150, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance$WidgetEmptyMedium$1.3
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer4, Integer num) {
                            invoke(columnScope, composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @Composable
                        public final void invoke(ColumnScope Column, Composer composer4, int i11) {
                            Intrinsics.checkNotNullParameter(Column, "$this$Column");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1032551150, i11, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptyMedium.<anonymous>.<anonymous> (WidgetListGlance.kt:699)");
                            }
                            GlanceModifier.Companion companion3 = GlanceModifier.INSTANCE;
                            GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(companion3));
                            final Context context5 = context4;
                            final Ref.LongRef longRef5 = longRef3;
                            final WidgetListGlanceTheme widgetListGlanceTheme2 = widgetListGlanceTheme;
                            BoxKt.Box(glanceModifierWrapContentHeight, null, ComposableLambdaKt.rememberComposableLambda(1931939276, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptyMedium.1.3.1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @Composable
                                public final void invoke(Composer composer5, int i12) {
                                    if ((i12 & 3) == 2 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1931939276, i12, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptyMedium.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:704)");
                                    }
                                    TextData textData = new TextData(C11391R.string.widget_welcome_page_title_get_started, (ColorProvider) null, 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32766, (DefaultConstructorMarker) null);
                                    String text = textData.getText();
                                    if (text == null) {
                                        text = context5.getResources().getString(C11391R.string.widget_welcome_page_title_get_started);
                                        Intrinsics.checkNotNullExpressionValue(text, "getString(...)");
                                    }
                                    String str = text;
                                    long j = longRef5.element;
                                    int iM21999getSemiBoldWjrlUT0 = FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0();
                                    FontFamily fontFamily = textData.getFontFamily();
                                    int iM22011getStartROrN78o = TextAlign.INSTANCE.m22011getStartROrN78o();
                                    TextDecoration textDecoration = textData.getTextDecoration();
                                    int textDirection = textData.getTextDirection();
                                    androidx.glance.text.TextKt.Text(str, (GlanceModifier) null, new TextStyle(widgetListGlanceTheme2.updateWelcomePageTextColor(), TextUnit.m21151boximpl(j), FontWeight.m21989boximpl(iM21999getSemiBoldWjrlUT0), null, TextAlign.m22000boximpl(iM22011getStartROrN78o), textDecoration, fontFamily, textDirection, false, null, ComplexUnit.f1613DP, 0, null, null, 0, 31496, null), 1, 0.0f, composer5, 27648, 2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer4, 54), composer4, 384, 2);
                            SpacerKt.Spacer(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(companion3), C2256Dp.m20968constructorimpl(1)), composer4, 0, 0);
                            GlanceModifier glanceModifierWrapContentHeight2 = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(companion3));
                            final Context context6 = context4;
                            final Ref.LongRef longRef6 = longRef4;
                            final WidgetListGlanceTheme widgetListGlanceTheme3 = widgetListGlanceTheme;
                            BoxKt.Box(glanceModifierWrapContentHeight2, null, ComposableLambdaKt.rememberComposableLambda(2038489027, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptyMedium.1.3.2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @Composable
                                public final void invoke(Composer composer5, int i12) {
                                    if ((i12 & 3) == 2 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2038489027, i12, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptyMedium.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:733)");
                                    }
                                    TextData textData = new TextData(C11391R.string.widget_preview_note_list_tap_to_add_notes, (ColorProvider) null, 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32766, (DefaultConstructorMarker) null);
                                    String text = textData.getText();
                                    if (text == null) {
                                        text = context6.getResources().getString(C11391R.string.widget_preview_note_list_tap_to_add_notes);
                                        Intrinsics.checkNotNullExpressionValue(text, "getString(...)");
                                    }
                                    String str = text;
                                    long j = longRef6.element;
                                    int iM21998getNormalWjrlUT0 = FontWeight.INSTANCE.m21998getNormalWjrlUT0();
                                    FontFamily fontFamily = textData.getFontFamily();
                                    int iM22011getStartROrN78o = TextAlign.INSTANCE.m22011getStartROrN78o();
                                    TextDecoration textDecoration = textData.getTextDecoration();
                                    int textDirection = textData.getTextDirection();
                                    androidx.glance.text.TextKt.Text(str, (GlanceModifier) null, new TextStyle(widgetListGlanceTheme3.updateWelcomePageTextColor(), TextUnit.m21151boximpl(j), FontWeight.m21989boximpl(iM21998getNormalWjrlUT0), null, TextAlign.m22000boximpl(iM22011getStartROrN78o), textDecoration, fontFamily, textDirection, false, null, ComplexUnit.f1613DP, 0, null, null, 0, 31496, null), 2, 0.0f, composer5, 27648, 2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer4, 54), composer4, 384, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer3, 54), composer3, 3072, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer2, 54), composer2, 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6935a(this, context, i, i2, themeManager, providerName, i4, 1));
        }
    }

    @Composable
    public final void WidgetEmptySmall(@NotNull final Context context, int i, @NotNull final WidgetListGlanceTheme themeManager, @NotNull String providerName, @Nullable Composer composer, int i2) {
        int i4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(themeManager, "themeManager");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Composer composerStartRestartGroup = composer.startRestartGroup(1475273716);
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(context) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(themeManager) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(providerName) ? 2048 : 1024;
        }
        if ((i4 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1475273716, i4, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptySmall (WidgetListGlance.kt:755)");
            }
            boolean z = ((TemplateState) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTemplateState())).getIconLabelOn() && ((TemplateState) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTemplateState())).getWidgetLabelOn();
            final float fM20968constructorimpl = context.getResources().getConfiguration().orientation == 2 ? z ? C2256Dp.m20968constructorimpl(context.getResources().getDimension(C11391R.dimen.widget_glance_small_icon_size_without_title_land)) : C2256Dp.m20968constructorimpl(context.getResources().getDimension(C11391R.dimen.widget_glance_small_icon_size_with_title_land)) : z ? C2256Dp.m20968constructorimpl(context.getResources().getDimension(C11391R.dimen.widget_glance_small_icon_size_with_title)) : C2256Dp.m20968constructorimpl(context.getResources().getDimension(C11391R.dimen.widget_glance_small_icon_size_without_title));
            GlanceModifier glanceModifierClickable = ActionKt.clickable(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), SendBroadcastActionKt.actionSendBroadcast(WidgetListGlanceUtils.INSTANCE.addStartNotePicker(context, i, providerName)), C11391R.drawable.sesl_glance_dim_effect);
            Alignment.Companion companion = Alignment.INSTANCE;
            RowKt.m21502RowlMAjyxE(glanceModifierClickable, companion.m21433getStartPGIyAqw(), companion.m21431getCenterVerticallymnfRV0w(), ComposableLambdaKt.rememberComposableLambda(886263128, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptySmall.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                    invoke(rowScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(RowScope Row, Composer composer2, int i5) {
                    Intrinsics.checkNotNullParameter(Row, "$this$Row");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(886263128, i5, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptySmall.<anonymous> (WidgetListGlance.kt:779)");
                    }
                    GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                    float f = 0;
                    float f4 = 8;
                    GlanceModifier glanceModifierM21499paddingqDBjuR0 = PaddingKt.m21499paddingqDBjuR0(SizeModifiersKt.wrapContentSize(companion2), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(6), C2256Dp.m20968constructorimpl(f));
                    Alignment.Companion companion3 = Alignment.INSTANCE;
                    Alignment centerStart = companion3.getCenterStart();
                    final float f5 = fM20968constructorimpl;
                    final Context context2 = context;
                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-663572042, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptySmall.1.1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @Composable
                        public final void invoke(Composer composer3, int i6) {
                            if ((i6 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-663572042, i6, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptySmall.<anonymous>.<anonymous> (WidgetListGlance.kt:785)");
                            }
                            GlanceModifier glanceModifierM21506size3ABfNKs = SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, f5);
                            final Context context3 = context2;
                            BoxKt.Box(glanceModifierM21506size3ABfNKs, null, ComposableLambdaKt.rememberComposableLambda(1572294680, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptySmall.1.1.1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @Composable
                                public final void invoke(Composer composer4, int i7) {
                                    if ((i7 & 3) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1572294680, i7, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptySmall.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:789)");
                                    }
                                    ImageKt.m21259ImageGCr5PR4(ImageKt.ImageProvider(C11391R.drawable.ic_widget_note_512), context3.getResources().getString(C11391R.string.app_name_simple), SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), ContentScale.INSTANCE.m21465getCropAe3V0ko(), null, composer4, 0, 16);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), composer3, 384, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54);
                    int i6 = Alignment.$stable;
                    BoxKt.Box(glanceModifierM21499paddingqDBjuR0, centerStart, composableLambdaRememberComposableLambda, composer2, (i6 << 3) | 384, 0);
                    GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.wrapContentSize(companion2), 0.0f, 0.0f, C2256Dp.m20968constructorimpl(f4), 0.0f, 11, null);
                    Alignment center = companion3.getCenter();
                    final Context context3 = context;
                    final WidgetListGlanceTheme widgetListGlanceTheme = themeManager;
                    BoxKt.Box(glanceModifierM21500paddingqDBjuR0$default, center, ComposableLambdaKt.rememberComposableLambda(173024877, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptySmall.1.2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @Composable
                        public final void invoke(Composer composer3, int i7) {
                            if ((i7 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(173024877, i7, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptySmall.<anonymous>.<anonymous> (WidgetListGlance.kt:804)");
                            }
                            GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
                            final Context context4 = context3;
                            final WidgetListGlanceTheme widgetListGlanceTheme2 = widgetListGlanceTheme;
                            BoxKt.Box(glanceModifierWrapContentHeight, null, ComposableLambdaKt.rememberComposableLambda(1357296719, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptySmall.1.2.1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @Composable
                                public final void invoke(Composer composer4, int i8) {
                                    if ((i8 & 3) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1357296719, i8, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetEmptySmall.<anonymous>.<anonymous>.<anonymous> (WidgetListGlance.kt:809)");
                                    }
                                    TextData textData = new TextData(C11391R.string.widget_welcome_page_title_start, (ColorProvider) null, 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32766, (DefaultConstructorMarker) null);
                                    String text = textData.getText();
                                    if (text == null) {
                                        text = context4.getResources().getString(C11391R.string.widget_welcome_page_title_start);
                                        Intrinsics.checkNotNullExpressionValue(text, "getString(...)");
                                    }
                                    String str = text;
                                    long sp = TextUnitKt.getSp(15.0f);
                                    int iM21999getSemiBoldWjrlUT0 = FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0();
                                    FontFamily fontFamily = textData.getFontFamily();
                                    int iM22011getStartROrN78o = TextAlign.INSTANCE.m22011getStartROrN78o();
                                    TextDecoration textDecoration = textData.getTextDecoration();
                                    int textDirection = textData.getTextDirection();
                                    FontStyle fontStyle = null;
                                    boolean z2 = false;
                                    TextShadowStyle textShadowStyle = null;
                                    androidx.glance.text.TextKt.Text(str, (GlanceModifier) null, new TextStyle(widgetListGlanceTheme2.updateWelcomePageTextColor(), TextUnit.m21151boximpl(sp), FontWeight.m21989boximpl(iM21999getSemiBoldWjrlUT0), fontStyle, TextAlign.m22000boximpl(iM22011getStartROrN78o), textDecoration, fontFamily, textDirection, z2, textShadowStyle, ComplexUnit.f1613DP, 0, null, null, 0, 31496, null), 1, 0.0f, composer4, 27648, 2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), composer3, 384, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, (i6 << 3) | 384, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 3072, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6937c(this, context, i, themeManager, providerName, i2, 1));
        }
    }

    @NotNull
    /* JADX INFO: renamed from: getShape-nwm-oUQ, reason: not valid java name */
    public final Shape m22126getShapenwmoUQ(int shapeBG, boolean backgroundOnOff, int size) {
        return (AppWidgetSize.m21550equalsimpl0(size, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) && backgroundOnOff) ? shapeBG != 1 ? shapeBG != 2 ? shapeBG != 3 ? shapeBG != 4 ? Shape.None : Shape.RightSpeechBalloon : Shape.LeftSpeechBalloon : Shape.LeftLeaf : Shape.RightLeaf : Shape.None;
    }

    @Override // androidx.glance.appwidget.GlanceAppWidget
    @NotNull
    public GlanceStateDefinition<Preferences> getStateDefinition() {
        return this.stateDefinition;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0001H\u0017¢\u0006\u0002\u0010(J\u0015\u0010)\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010*J\u0015\u0010+\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010*R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/list/WidgetListGlance$WidgetListItem;", "Landroidx/glance/oneui/template/CustomListItem;", "mainText", "Landroidx/glance/oneui/template/TypedTextData;", "time", "icon", "Landroidx/glance/oneui/template/ImageWithBackgroundData;", "icons", "", "Landroidx/glance/oneui/template/ImageData;", "contentDescription", "", "onClick", "Landroidx/glance/action/Action;", "context", "Landroid/content/Context;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "themeManager", "Lcom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceTheme;", "<init>", "(Lcom/samsung/android/app/notes/widget/glance/list/WidgetListGlance;Landroidx/glance/oneui/template/TypedTextData;Landroidx/glance/oneui/template/TypedTextData;Landroidx/glance/oneui/template/ImageWithBackgroundData;Ljava/util/List;Ljava/lang/String;Landroidx/glance/action/Action;Landroid/content/Context;ILcom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceTheme;)V", "getTime", "()Landroidx/glance/oneui/template/TypedTextData;", "getIcon", "()Landroidx/glance/oneui/template/ImageWithBackgroundData;", "getIcons", "()Ljava/util/List;", "mContext", "getMContext", "()Landroid/content/Context;", "mAppWidgetId", "getMAppWidgetId", "()I", "mThemeManager", "getMThemeManager", "()Lcom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceTheme;", "CustomContent", "", "item", "(Landroidx/glance/oneui/template/CustomListItem;Landroidx/compose/runtime/Composer;I)V", "TitleTextTemplate", "(Lcom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceTheme;Landroidx/compose/runtime/Composer;I)V", "TimeTextTemplate", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nWidgetListGlance.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetListGlance.kt\ncom/samsung/android/app/notes/widget/glance/list/WidgetListGlance$WidgetListItem\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,876:1\n149#2:877\n159#2:878\n*S KotlinDebug\n*F\n+ 1 WidgetListGlance.kt\ncom/samsung/android/app/notes/widget/glance/list/WidgetListGlance$WidgetListItem\n*L\n548#1:877\n549#1:878\n*E\n"})
    public final class WidgetListItem extends CustomListItem {

        @Nullable
        private final ImageWithBackgroundData icon;

        @NotNull
        private final List<ImageData> icons;
        private final int mAppWidgetId;

        @NotNull
        private final Context mContext;

        @NotNull
        private final WidgetListGlanceTheme mThemeManager;
        final /* synthetic */ WidgetListGlance this$0;

        @NotNull
        private final TypedTextData time;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public WidgetListItem(@NotNull WidgetListGlance widgetListGlance, @NotNull TypedTextData mainText, @Nullable TypedTextData time, @NotNull ImageWithBackgroundData imageWithBackgroundData, @Nullable List<? extends ImageData> icons, @Nullable String str, @NotNull Action action, Context context, @NotNull int i, WidgetListGlanceTheme themeManager) {
            super(mainText, null, imageWithBackgroundData, null, action, 10, null);
            Intrinsics.checkNotNullParameter(mainText, "mainText");
            Intrinsics.checkNotNullParameter(time, "time");
            Intrinsics.checkNotNullParameter(icons, "icons");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(themeManager, "themeManager");
            this.this$0 = widgetListGlance;
            this.time = time;
            this.icon = imageWithBackgroundData;
            this.icons = icons;
            this.mContext = context;
            this.mAppWidgetId = i;
            this.mThemeManager = themeManager;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit CustomContent$lambda$0(WidgetListItem widgetListItem, CustomListItem customListItem, int i, Composer composer, int i2) {
            widgetListItem.CustomContent(customListItem, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit TimeTextTemplate$lambda$2(WidgetListItem widgetListItem, WidgetListGlanceTheme widgetListGlanceTheme, int i, Composer composer, int i2) {
            widgetListItem.TimeTextTemplate(widgetListGlanceTheme, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit TitleTextTemplate$lambda$1(WidgetListItem widgetListItem, WidgetListGlanceTheme widgetListGlanceTheme, int i, Composer composer, int i2) {
            widgetListItem.TitleTextTemplate(widgetListGlanceTheme, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            return Unit.INSTANCE;
        }

        @Override // androidx.glance.oneui.template.CustomListItem
        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public void CustomContent(@NotNull CustomListItem item, @Nullable Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(item, "item");
            Composer composerStartRestartGroup = composer.startRestartGroup(-141754075);
            if ((i & 48) == 0) {
                i2 = (composerStartRestartGroup.changedInstance(this) ? 32 : 16) | i;
            } else {
                i2 = i;
            }
            if ((i2 & 17) == 16 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-141754075, i2, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetListItem.CustomContent (WidgetListGlance.kt:541)");
                }
                ColumnKt.m21455ColumnK4GKKTE(PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), 0.0f, C2256Dp.m20968constructorimpl(7), 0.0f, C2256Dp.m20968constructorimpl((float) 7.2d), 5, null), 0, 0, ComposableLambdaKt.rememberComposableLambda(-909350373, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance$WidgetListItem$CustomContent$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                        invoke(columnScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    public final void invoke(ColumnScope Column, Composer composer2, int i4) {
                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-909350373, i4, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetListItem.CustomContent.<anonymous> (WidgetListGlance.kt:551)");
                        }
                        WidgetListGlance.WidgetListItem widgetListItem = this.this$0;
                        widgetListItem.TitleTextTemplate(widgetListItem.getMThemeManager(), composer2, 0);
                        GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                        SpacerKt.Spacer(SizeModifiersKt.m21505height3ABfNKs(companion, C2256Dp.m20968constructorimpl((float) 0.8d)), composer2, 0, 0);
                        GlanceModifier glanceModifierWrapContentSize = SizeModifiersKt.wrapContentSize(companion);
                        int iM21431getCenterVerticallymnfRV0w = Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w();
                        final WidgetListGlance.WidgetListItem widgetListItem2 = this.this$0;
                        RowKt.m21502RowlMAjyxE(glanceModifierWrapContentSize, 0, iM21431getCenterVerticallymnfRV0w, ComposableLambdaKt.rememberComposableLambda(927157631, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.WidgetListGlance$WidgetListItem$CustomContent$1.1
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                invoke(rowScope, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(RowScope Row, Composer composer3, int i5) {
                                Intrinsics.checkNotNullParameter(Row, "$this$Row");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(927157631, i5, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetListItem.CustomContent.<anonymous>.<anonymous> (WidgetListGlance.kt:557)");
                                }
                                WidgetListGlance.WidgetListItem widgetListItem3 = widgetListItem2;
                                widgetListItem3.TimeTextTemplate(widgetListItem3.getMThemeManager(), composer3, 0);
                                int size = widgetListItem2.getIcons().size();
                                WidgetListGlance.WidgetListItem widgetListItem4 = widgetListItem2;
                                for (int i6 = 0; i6 < size; i6++) {
                                    SpacerKt.Spacer(SizeModifiersKt.m21508width3ABfNKs(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(3)), composer3, 0, 0);
                                    float f = 13;
                                    androidx.glance.oneui.template.component.ImageKt.m21705TemplateImage73KfpEQ(widgetListItem4.getIcons().get(i6), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f), composer3, ImageData.$stable | 432);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, 3072, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new C6941g(this, item, i, 2));
            }
        }

        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
        @Composable
        public final void TimeTextTemplate(@NotNull WidgetListGlanceTheme themeManager, @Nullable Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(themeManager, "themeManager");
            Composer composerStartRestartGroup = composer.startRestartGroup(-1859943960);
            if ((i & 6) == 0) {
                i2 = (composerStartRestartGroup.changedInstance(themeManager) ? 4 : 2) | i;
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
                    ComposerKt.traceEventStart(-1859943960, i2, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetListItem.TimeTextTemplate (WidgetListGlance.kt:579)");
                }
                String text = this.time.getText();
                Intrinsics.checkNotNull(text);
                TextKt.m21709TemplateText3SkNqBk(new TextData(text, themeManager.updateListItemTimeColor(), 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32764, (DefaultConstructorMarker) null), TextUnitKt.getSp(12), FontWeight.INSTANCE.m21998getNormalWjrlUT0(), 0.0f, composerStartRestartGroup, TextData.$stable | 48, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new C6941g(this, themeManager, i, 0));
            }
        }

        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
        @Composable
        public final void TitleTextTemplate(@NotNull WidgetListGlanceTheme themeManager, @Nullable Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(themeManager, "themeManager");
            Composer composerStartRestartGroup = composer.startRestartGroup(-292444711);
            if ((i & 6) == 0) {
                i2 = (composerStartRestartGroup.changedInstance(themeManager) ? 4 : 2) | i;
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
                    ComposerKt.traceEventStart(-292444711, i2, -1, "com.samsung.android.app.notes.widget.glance.list.WidgetListGlance.WidgetListItem.TitleTextTemplate (WidgetListGlance.kt:567)");
                }
                String text = getMainText().getText();
                Intrinsics.checkNotNull(text);
                TextKt.m21709TemplateText3SkNqBk(new TextData(text, themeManager.updateListItemTitleColor(), 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32764, (DefaultConstructorMarker) null), TextUnitKt.getSp(14), FontWeight.INSTANCE.m21997getMediumWjrlUT0(), 0.0f, composerStartRestartGroup, TextData.$stable | 48, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new C6941g(this, themeManager, i, 1));
            }
        }

        @Nullable
        public final ImageWithBackgroundData getIcon() {
            return this.icon;
        }

        @NotNull
        public final List<ImageData> getIcons() {
            return this.icons;
        }

        public final int getMAppWidgetId() {
            return this.mAppWidgetId;
        }

        @NotNull
        public final Context getMContext() {
            return this.mContext;
        }

        @NotNull
        public final WidgetListGlanceTheme getMThemeManager() {
            return this.mThemeManager;
        }

        @NotNull
        public final TypedTextData getTime() {
            return this.time;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ WidgetListItem(WidgetListGlance widgetListGlance, TypedTextData typedTextData, TypedTextData typedTextData2, ImageWithBackgroundData imageWithBackgroundData, List list, String str, Action action, Context context, int i, WidgetListGlanceTheme widgetListGlanceTheme, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            WidgetListGlanceTheme widgetListGlanceTheme2;
            int i4;
            Context context2;
            Action action2;
            str = (i2 & 16) != 0 ? null : str;
            if ((i2 & 32) != 0) {
                widgetListGlanceTheme2 = widgetListGlanceTheme;
                i4 = i;
                context2 = context;
                action2 = null;
            } else {
                widgetListGlanceTheme2 = widgetListGlanceTheme;
                i4 = i;
                context2 = context;
                action2 = action;
            }
            this(widgetListGlance, typedTextData, typedTextData2, imageWithBackgroundData, list, str, action2, context2, i4, widgetListGlanceTheme2);
        }
    }
}
