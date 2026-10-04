package com.samsung.android.app.notes.widget.glance.single;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.glance.AbstractC2821a;
import androidx.glance.BackgroundKt;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.GlanceId;
import androidx.glance.GlanceModifier;
import androidx.glance.ImageKt;
import androidx.glance.ImageProvider;
import androidx.glance.action.Action;
import androidx.glance.action.ActionKt;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.appwidget.GlanceAppWidgetManager;
import androidx.glance.appwidget.ImageButtonKt;
import androidx.glance.appwidget.MarginKt;
import androidx.glance.appwidget.action.SendBroadcastActionKt;
import androidx.glance.appwidget.action.StartActivityIntentActionKt;
import androidx.glance.appwidget.animation.RemoteAnimation;
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
import androidx.glance.oneui.template.AppWidgetBackground;
import androidx.glance.oneui.template.GlanceTemplateAppWidget;
import androidx.glance.oneui.template.TemplateState;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TitleBarData;
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
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.widget.capture.CacheFileManager;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.glance.C6916a;
import com.samsung.android.app.notes.widget.glance.C6917b;
import com.samsung.android.app.notes.widget.glance.list.C6936b;
import com.samsung.android.app.notes.widget.glance.single.common.WidgetSingleGlanceIntent;
import com.samsung.android.app.notes.widget.glance.single.common.WidgetSingleGlanceUtils;
import com.samsung.android.app.notes.widget.glance.single.theme.WidgetSingleGlanceTheme;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0017¢\u0006\u0002\u0010\u000bJ)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J7\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0002Ja\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0007¢\u0006\u0004\b'\u0010(Jq\u0010)\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020 H\u0007¢\u0006\u0004\b,\u0010-J-\u0010.\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020$2\u0006\u0010*\u001a\u00020\rH\u0007¢\u0006\u0002\u0010/J%\u0010.\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u00100\u001a\u000201H\u0007¢\u0006\u0002\u00102J%\u00103\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u00104J\u001d\u00105\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u00106J7\u00107\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0006\u0010*\u001a\u00020\rH\u0003¢\u0006\u0004\b8\u00109J7\u0010:\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0006\u0010*\u001a\u00020\rH\u0003¢\u0006\u0004\b;\u00109J7\u0010<\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0006\u0010*\u001a\u00020\rH\u0007¢\u0006\u0004\b=\u00109J-\u0010>\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020$2\u0006\u0010*\u001a\u00020\rH\u0007¢\u0006\u0002\u0010/J \u0010?\u001a\b\u0012\u0004\u0012\u00020A0@2\u0010\u0010B\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010C\u0018\u00010@H\u0002R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006E²\u0006\u0012\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010C0@X\u008a\u0084\u0002"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/single/WidgetSingleGlance;", "Landroidx/glance/oneui/template/GlanceTemplateAppWidget;", "<init>", "()V", "stateDefinition", "Landroidx/glance/state/GlanceStateDefinition;", "Landroidx/datastore/preferences/core/Preferences;", "getStateDefinition", "()Landroidx/glance/state/GlanceStateDefinition;", "TemplateContent", "", "(Landroidx/compose/runtime/Composer;I)V", "getAppWidgetLabel", "", "context", "Landroid/content/Context;", "title", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "getAppWidgetLabel-nwm-oUQ", "(Landroid/content/Context;Ljava/lang/String;I)Ljava/lang/String;", "UpdateState", "glanceId", "Landroidx/glance/GlanceId;", "typeWidgetView", "currentSizeString", "UpdateState-ACLJZ2c", "(Landroid/content/Context;Landroidx/glance/GlanceId;Ljava/lang/String;Ljava/lang/String;ILandroidx/compose/runtime/Composer;I)V", "titleBar", "Landroidx/glance/oneui/template/TitleBarData;", "ContentWidget", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "uuid", "filePath", "themeManager", "Lcom/samsung/android/app/notes/widget/glance/single/theme/WidgetSingleGlanceTheme;", "widgetUtils", "Lcom/samsung/android/app/notes/widget/glance/single/common/WidgetSingleGlanceUtils;", "ContentWidget-9NJi2jo", "(Landroid/content/Context;Landroidx/glance/GlanceId;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/samsung/android/app/notes/widget/glance/single/theme/WidgetSingleGlanceTheme;Lcom/samsung/android/app/notes/widget/glance/single/common/WidgetSingleGlanceUtils;Landroidx/compose/runtime/Composer;II)V", "ContentWidgetCover", "providerName", "coverScreenCutout", "ContentWidgetCover-h-kgKvA", "(Landroid/content/Context;Landroidx/glance/GlanceId;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/samsung/android/app/notes/widget/glance/single/theme/WidgetSingleGlanceTheme;Lcom/samsung/android/app/notes/widget/glance/single/common/WidgetSingleGlanceUtils;Ljava/lang/String;ILandroidx/compose/runtime/Composer;II)V", "ViewMore", "(Landroid/content/Context;ILcom/samsung/android/app/notes/widget/glance/single/theme/WidgetSingleGlanceTheme;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "openNoteIntent", "Landroid/content/Intent;", "(Landroid/content/Context;Lcom/samsung/android/app/notes/widget/glance/single/theme/WidgetSingleGlanceTheme;Landroid/content/Intent;Landroidx/compose/runtime/Composer;I)V", "WidgetConvertDoc", "(Landroid/content/Context;ILcom/samsung/android/app/notes/widget/glance/single/theme/WidgetSingleGlanceTheme;Landroidx/compose/runtime/Composer;I)V", "WidgetLoading", "(Landroid/content/Context;Lcom/samsung/android/app/notes/widget/glance/single/theme/WidgetSingleGlanceTheme;Landroidx/compose/runtime/Composer;I)V", "WidgetEmpty", "WidgetEmpty-gaecCbA", "(Landroid/content/Context;IILcom/samsung/android/app/notes/widget/glance/single/theme/WidgetSingleGlanceTheme;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "WidgetSingleExtraLargeCoverEmpty", "WidgetSingleExtraLargeCoverEmpty-gaecCbA", "WidgetEmptyMedium", "WidgetEmptyMedium-gaecCbA", "WidgetEmptySmall", "getImageProvider", "", "Landroidx/glance/ImageProvider;", "listBitmap", "Landroid/graphics/Bitmap;", "Companion", "ntHomeWidget_release", "listBitmapState"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetSingleGlance.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetSingleGlance.kt\ncom/samsung/android/app/notes/widget/glance/single/WidgetSingleGlance\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 CompositionLocals.kt\nandroidx/glance/CompositionLocalsKt\n+ 4 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 5 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 6 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,950:1\n77#2:951\n77#2:952\n77#2:953\n77#2:954\n74#2:957\n74#2:960\n74#2:963\n74#2:966\n74#2:969\n74#2:972\n74#2:975\n74#2:978\n74#2:981\n74#2:984\n74#2:987\n74#2:990\n74#2:993\n77#2:1012\n77#2:1013\n77#2:1015\n77#2:1023\n77#2:1024\n72#3:955\n61#3:956\n72#3:958\n61#3:959\n72#3:961\n61#3:962\n72#3:964\n61#3:965\n72#3:967\n61#3:968\n72#3:970\n61#3:971\n72#3:973\n61#3:974\n72#3:976\n61#3:977\n72#3:979\n61#3:980\n72#3:982\n61#3:983\n72#3:985\n61#3:986\n72#3:988\n61#3:989\n72#3:991\n61#3:992\n1225#4,6:994\n1225#4,6:1000\n149#5:1006\n149#5:1007\n149#5:1008\n149#5:1009\n149#5:1010\n149#5:1011\n149#5:1014\n149#5:1016\n149#5:1017\n169#5:1018\n169#5:1019\n149#5:1020\n169#5:1021\n149#5:1022\n169#5:1025\n169#5:1026\n169#5:1027\n169#5:1028\n81#6:1029\n*S KotlinDebug\n*F\n+ 1 WidgetSingleGlance.kt\ncom/samsung/android/app/notes/widget/glance/single/WidgetSingleGlance\n*L\n113#1:951\n114#1:952\n115#1:953\n116#1:954\n117#1:957\n118#1:960\n119#1:963\n120#1:966\n122#1:969\n123#1:972\n124#1:975\n125#1:978\n126#1:981\n127#1:984\n128#1:987\n129#1:990\n130#1:993\n712#1:1012\n713#1:1013\n717#1:1015\n865#1:1023\n866#1:1024\n117#1:955\n117#1:956\n118#1:958\n118#1:959\n119#1:961\n119#1:962\n120#1:964\n120#1:965\n122#1:967\n122#1:968\n123#1:970\n123#1:971\n124#1:973\n124#1:974\n125#1:976\n125#1:977\n126#1:979\n126#1:980\n127#1:982\n127#1:983\n128#1:985\n128#1:986\n129#1:988\n129#1:989\n130#1:991\n130#1:992\n210#1:994,6\n246#1:1000,6\n361#1:1006\n363#1:1007\n493#1:1008\n537#1:1009\n588#1:1010\n626#1:1011\n715#1:1014\n726#1:1016\n729#1:1017\n730#1:1018\n732#1:1019\n735#1:1020\n737#1:1021\n739#1:1022\n870#1:1025\n872#1:1026\n875#1:1027\n876#1:1028\n246#1:1029\n*E\n"})
public final class WidgetSingleGlance extends GlanceTemplateAppWidget {

    @NotNull
    public static final String TAG = "WidgetSingleGlance";

    @NotNull
    private final GlanceStateDefinition<Preferences> stateDefinition = PreferencesGlanceStateDefinition.INSTANCE;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final Preferences.Key<Long> requestTimeKey = PreferencesKeys.longKey("requestTimeKey");

    @NotNull
    private static final Preferences.Key<String> typeWidgetViewKey = PreferencesKeys.stringKey("typeWidgetView");

    @NotNull
    private static final Preferences.Key<String> lastSizeKey = PreferencesKeys.stringKey("lastSizeKey");

    @NotNull
    private static final Preferences.Key<String> providerNameKey = PreferencesKeys.stringKey("providerNameKey");

    @NotNull
    private static final Preferences.Key<Integer> transparencyKey = PreferencesKeys.intKey("transparencyKey");

    @NotNull
    private static final Preferences.Key<Integer> backgroundColorKey = PreferencesKeys.intKey("backgroundColorKey");

    @NotNull
    private static final Preferences.Key<Integer> darkModeKey = PreferencesKeys.intKey("darkModeKey");

    @NotNull
    private static final Preferences.Key<Boolean> matchSettingKey = PreferencesKeys.booleanKey("matchSettingKey");

    @NotNull
    private static final Preferences.Key<String> uuidKey = PreferencesKeys.stringKey("uuidKey");

    @NotNull
    private static final Preferences.Key<String> filePathKey = PreferencesKeys.stringKey("filePathKey");

    @NotNull
    private static final Preferences.Key<Integer> backgroundShapeKey = PreferencesKeys.intKey("backgroundShapeKey");

    @NotNull
    private static final Preferences.Key<Boolean> backgroundOnOffKey = PreferencesKeys.booleanKey("backgroundOnOffKey");

    @NotNull
    private static final Preferences.Key<Integer> coverScreenCutoutKey = PreferencesKeys.intKey("coverScreenCutoutKey");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\nR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\nR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\nR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\nR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\nR\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\nR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\n¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/single/WidgetSingleGlance$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "requestTimeKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getRequestTimeKey", "()Landroidx/datastore/preferences/core/Preferences$Key;", "typeWidgetViewKey", "getTypeWidgetViewKey", "lastSizeKey", "getLastSizeKey", "providerNameKey", "getProviderNameKey", "transparencyKey", "", "getTransparencyKey", "backgroundColorKey", "getBackgroundColorKey", "darkModeKey", "getDarkModeKey", "matchSettingKey", "", "getMatchSettingKey", "uuidKey", "getUuidKey", "filePathKey", "getFilePathKey", "backgroundShapeKey", "getBackgroundShapeKey", "backgroundOnOffKey", "getBackgroundOnOffKey", "coverScreenCutoutKey", "getCoverScreenCutoutKey", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Preferences.Key<Integer> getBackgroundColorKey() {
            return WidgetSingleGlance.backgroundColorKey;
        }

        @NotNull
        public final Preferences.Key<Boolean> getBackgroundOnOffKey() {
            return WidgetSingleGlance.backgroundOnOffKey;
        }

        @NotNull
        public final Preferences.Key<Integer> getBackgroundShapeKey() {
            return WidgetSingleGlance.backgroundShapeKey;
        }

        @NotNull
        public final Preferences.Key<Integer> getCoverScreenCutoutKey() {
            return WidgetSingleGlance.coverScreenCutoutKey;
        }

        @NotNull
        public final Preferences.Key<Integer> getDarkModeKey() {
            return WidgetSingleGlance.darkModeKey;
        }

        @NotNull
        public final Preferences.Key<String> getFilePathKey() {
            return WidgetSingleGlance.filePathKey;
        }

        @NotNull
        public final Preferences.Key<String> getLastSizeKey() {
            return WidgetSingleGlance.lastSizeKey;
        }

        @NotNull
        public final Preferences.Key<Boolean> getMatchSettingKey() {
            return WidgetSingleGlance.matchSettingKey;
        }

        @NotNull
        public final Preferences.Key<String> getProviderNameKey() {
            return WidgetSingleGlance.providerNameKey;
        }

        @NotNull
        public final Preferences.Key<Long> getRequestTimeKey() {
            return WidgetSingleGlance.requestTimeKey;
        }

        @NotNull
        public final Preferences.Key<Integer> getTransparencyKey() {
            return WidgetSingleGlance.transparencyKey;
        }

        @NotNull
        public final Preferences.Key<String> getTypeWidgetViewKey() {
            return WidgetSingleGlance.typeWidgetViewKey;
        }

        @NotNull
        public final Preferences.Key<String> getUuidKey() {
            return WidgetSingleGlance.uuidKey;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentWidgetCover_h_kgKvA$lambda$7(WidgetSingleGlance widgetSingleGlance, Context context, GlanceId glanceId, int i, String str, String str2, String str3, int i2, String str4, WidgetSingleGlanceTheme widgetSingleGlanceTheme, WidgetSingleGlanceUtils widgetSingleGlanceUtils, String str5, int i4, int i5, int i6, Composer composer, int i7) {
        widgetSingleGlance.m22140ContentWidgetCoverhkgKvA(context, glanceId, i, str, str2, str3, i2, str4, widgetSingleGlanceTheme, widgetSingleGlanceUtils, str5, i4, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentWidget_9NJi2jo$lambda$3(WidgetSingleGlance widgetSingleGlance, Context context, GlanceId glanceId, int i, String str, String str2, String str3, int i2, String str4, WidgetSingleGlanceTheme widgetSingleGlanceTheme, WidgetSingleGlanceUtils widgetSingleGlanceUtils, int i4, int i5, Composer composer, int i6) {
        widgetSingleGlance.m22139ContentWidget9NJi2jo(context, glanceId, i, str, str2, str3, i2, str4, widgetSingleGlanceTheme, widgetSingleGlanceUtils, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Bitmap> ContentWidget_9NJi2jo$lambda$5(MutableState<List<Bitmap>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentWidget_9NJi2jo$lambda$6(WidgetSingleGlance widgetSingleGlance, Context context, GlanceId glanceId, int i, String str, String str2, String str3, int i2, String str4, WidgetSingleGlanceTheme widgetSingleGlanceTheme, WidgetSingleGlanceUtils widgetSingleGlanceUtils, int i4, int i5, Composer composer, int i6) {
        widgetSingleGlance.m22139ContentWidget9NJi2jo(context, glanceId, i, str, str2, str3, i2, str4, widgetSingleGlanceTheme, widgetSingleGlanceUtils, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TemplateContent$lambda$0(WidgetSingleGlance widgetSingleGlance, int i, Composer composer, int i2) {
        widgetSingleGlance.TemplateContent(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpdateState_ACLJZ2c$lambda$2(WidgetSingleGlance widgetSingleGlance, Context context, GlanceId glanceId, String str, String str2, int i, int i2, Composer composer, int i4) {
        widgetSingleGlance.m22141UpdateStateACLJZ2c(context, glanceId, str, str2, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ViewMore$lambda$8(WidgetSingleGlance widgetSingleGlance, Context context, int i, WidgetSingleGlanceTheme widgetSingleGlanceTheme, String str, int i2, Composer composer, int i4) {
        widgetSingleGlance.ViewMore(context, i, widgetSingleGlanceTheme, str, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ViewMore$lambda$9(WidgetSingleGlance widgetSingleGlance, Context context, WidgetSingleGlanceTheme widgetSingleGlanceTheme, Intent intent, int i, Composer composer, int i2) {
        widgetSingleGlance.ViewMore(context, widgetSingleGlanceTheme, intent, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WidgetConvertDoc$lambda$10(WidgetSingleGlance widgetSingleGlance, Context context, int i, WidgetSingleGlanceTheme widgetSingleGlanceTheme, int i2, Composer composer, int i4) {
        widgetSingleGlance.WidgetConvertDoc(context, i, widgetSingleGlanceTheme, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    /* JADX INFO: renamed from: WidgetEmpty-gaecCbA, reason: not valid java name */
    public final void m22134WidgetEmptygaecCbA(Context context, int i, int i2, WidgetSingleGlanceTheme widgetSingleGlanceTheme, String str, Composer composer, int i4) {
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(1657417739);
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
            i5 |= composerStartRestartGroup.changedInstance(widgetSingleGlanceTheme) ? 2048 : 1024;
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
                ComposerKt.traceEventStart(1657417739, i5, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmpty (WidgetSingleGlance.kt:652)");
            }
            if (AppWidgetSize.m21546compareToL2j3NV4(i2, AppWidgetSize.INSTANCE.m21570getSmallrx25Pp4()) <= 0) {
                composerStartRestartGroup.startReplaceGroup(1188069597);
                int i6 = i5 & 126;
                int i7 = i5 >> 3;
                WidgetEmptySmall(context, i, widgetSingleGlanceTheme, str, composerStartRestartGroup, i6 | (i7 & 896) | (i7 & 7168) | (i7 & 57344));
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1188165232);
                m22142WidgetEmptyMediumgaecCbA(context, i, i2, widgetSingleGlanceTheme, str, composerStartRestartGroup, i5 & 524286);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6994c(this, context, i, i2, widgetSingleGlanceTheme, str, i4, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WidgetEmptyMedium_gaecCbA$lambda$14(WidgetSingleGlance widgetSingleGlance, Context context, int i, int i2, WidgetSingleGlanceTheme widgetSingleGlanceTheme, String str, int i4, Composer composer, int i5) {
        widgetSingleGlance.m22142WidgetEmptyMediumgaecCbA(context, i, i2, widgetSingleGlanceTheme, str, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WidgetEmptySmall$lambda$15(WidgetSingleGlance widgetSingleGlance, Context context, int i, WidgetSingleGlanceTheme widgetSingleGlanceTheme, String str, int i2, Composer composer, int i4) {
        widgetSingleGlance.WidgetEmptySmall(context, i, widgetSingleGlanceTheme, str, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WidgetEmpty_gaecCbA$lambda$12(WidgetSingleGlance widgetSingleGlance, Context context, int i, int i2, WidgetSingleGlanceTheme widgetSingleGlanceTheme, String str, int i4, Composer composer, int i5) {
        widgetSingleGlance.m22134WidgetEmptygaecCbA(context, i, i2, widgetSingleGlanceTheme, str, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WidgetLoading$lambda$11(WidgetSingleGlance widgetSingleGlance, Context context, WidgetSingleGlanceTheme widgetSingleGlanceTheme, int i, Composer composer, int i2) {
        widgetSingleGlance.WidgetLoading(context, widgetSingleGlanceTheme, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: WidgetSingleExtraLargeCoverEmpty-gaecCbA, reason: not valid java name */
    public final void m22135WidgetSingleExtraLargeCoverEmptygaecCbA(final Context context, final int i, int i2, final WidgetSingleGlanceTheme widgetSingleGlanceTheme, final String str, Composer composer, int i4) {
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-235402677);
        if ((i4 & 6) == 0) {
            i5 = (composerStartRestartGroup.changedInstance(context) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i4 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(widgetSingleGlanceTheme) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changed(str) ? 16384 : 8192;
        }
        if ((i5 & 9235) == 9234 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-235402677, i5, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetSingleExtraLargeCoverEmpty (WidgetSingleGlance.kt:661)");
            }
            GlanceModifier glanceModifierClickable = ActionKt.clickable(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), SendBroadcastActionKt.actionSendBroadcast(WidgetSingleGlanceIntent.INSTANCE.intentStartNotePicker(context, i, str)));
            Alignment.Companion companion = Alignment.INSTANCE;
            ColumnKt.m21455ColumnK4GKKTE(glanceModifierClickable, companion.m21431getCenterVerticallymnfRV0w(), companion.m21430getCenterHorizontallyPGIyAqw(), ComposableLambdaKt.rememberComposableLambda(820131009, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$WidgetSingleExtraLargeCoverEmpty$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                    invoke(columnScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                @Composable
                public final void invoke(ColumnScope Column, Composer composer2, int i6) {
                    Intrinsics.checkNotNullParameter(Column, "$this$Column");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(820131009, i6, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetSingleExtraLargeCoverEmpty.<anonymous> (WidgetSingleGlance.kt:671)");
                    }
                    GlanceModifier glanceModifierM21286cornerRadius3ABfNKs = CornerRadiusKt.m21286cornerRadius3ABfNKs(BackgroundKt.background(SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(38)), ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(4294917180L))), CommonDimensions.INSTANCE.m21773getDefaultCornerRadiusD9Ej5fM());
                    final Context context2 = context;
                    final int i7 = i;
                    final String str2 = str;
                    BoxKt.Box(glanceModifierM21286cornerRadius3ABfNKs, null, ComposableLambdaKt.rememberComposableLambda(-1258093537, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$WidgetSingleExtraLargeCoverEmpty$1.1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                        @Composable
                        public final void invoke(Composer composer3, int i8) {
                            if ((i8 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1258093537, i8, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetSingleExtraLargeCoverEmpty.<anonymous>.<anonymous> (WidgetSingleGlance.kt:677)");
                            }
                            ImageButtonKt.m21297ImageButtonaCxP0qg(ImageKt.ImageProvider(C11391R.drawable.ic_induce_app_icon), context2.getResources().getString(C11391R.string.app_name_simple), SendBroadcastActionKt.actionSendBroadcast(WidgetSingleGlanceIntent.INSTANCE.intentStartNotePicker(context2, i7, str2)), BackgroundKt.background(PaddingKt.m21496padding3ABfNKs(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl((float) 6.3d)), ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU())), false, ContentScale.INSTANCE.m21465getCropAe3V0ko(), null, composer3, 0, 80);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 384, 2);
                    TextData textData = new TextData(C11391R.string.app_name_simple, ColorProviderKt.m22055ColorProvider8_81llA(widgetSingleGlanceTheme.m22146updateTitleTextColor0d7_KjU()), 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32764, (DefaultConstructorMarker) null);
                    long sp = TextUnitKt.getSp(14);
                    FontWeight.Companion companion2 = FontWeight.INSTANCE;
                    int iM21996getBoldWjrlUT0 = companion2.m21996getBoldWjrlUT0();
                    int i8 = TextData.$stable;
                    TextKt.m21709TemplateText3SkNqBk(textData, sp, iM21996getBoldWjrlUT0, 0.0f, composer2, i8 | 48, 8);
                    TextKt.m21709TemplateText3SkNqBk(new TextData(C11391R.string.tap_to_choose_a_note, widgetSingleGlanceTheme.updateBodyTextColor(), 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32764, (DefaultConstructorMarker) null), TextUnitKt.getSp(12), companion2.m21998getNormalWjrlUT0(), 0.0f, composer2, i8 | 48, 8);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new C6994c(this, context, i, i2, widgetSingleGlanceTheme, str, i4, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WidgetSingleExtraLargeCoverEmpty_gaecCbA$lambda$13(WidgetSingleGlance widgetSingleGlance, Context context, int i, int i2, WidgetSingleGlanceTheme widgetSingleGlanceTheme, String str, int i4, Composer composer, int i5) {
        widgetSingleGlance.m22135WidgetSingleExtraLargeCoverEmptygaecCbA(context, i, i2, widgetSingleGlanceTheme, str, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: getAppWidgetLabel-nwm-oUQ, reason: not valid java name */
    private final String m22138getAppWidgetLabelnwmoUQ(Context context, String title, int widgetSize) {
        String string = context.getResources().getString(C11391R.string.app_name_simple);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return (title == null || title.length() == 0 || AppWidgetSize.m21546compareToL2j3NV4(widgetSize, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) >= 0) ? string : title;
    }

    private final List<ImageProvider> getImageProvider(List<Bitmap> listBitmap) {
        ArrayList arrayList = new ArrayList();
        if (listBitmap == null) {
            listBitmap = new ArrayList<>();
        }
        for (Bitmap bitmap : listBitmap) {
            if (bitmap != null) {
                arrayList.add(ImageKt.ImageProvider(bitmap));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TitleBarData titleBar(String title) {
        if (title == null || title.length() == 0) {
            return null;
        }
        ColorProvider colorProvider = null;
        int i = 0;
        TextDecoration textDecoration = null;
        int i2 = 0;
        FontFamily fontFamily = null;
        int i4 = 0;
        boolean z = false;
        boolean z2 = false;
        TextShadowStyle textShadowStyle = null;
        String str = null;
        RemoteAnimation remoteAnimation = null;
        boolean z3 = false;
        int i5 = 0;
        int i6 = 0;
        ActionButtonData actionButtonData = null;
        boolean z4 = false;
        return new TitleBarData(new TextData(title, colorProvider, i, textDecoration, i2, fontFamily, i4, z, z2, textShadowStyle, str, remoteAnimation, z3, i5, i6, 32766, (DefaultConstructorMarker) null), null, 0 == true ? 1 : 0, actionButtonData, z4, 30, 0 == true ? 1 : 0);
    }

    @Composable
    /* JADX INFO: renamed from: ContentWidget-9NJi2jo, reason: not valid java name */
    public final void m22139ContentWidget9NJi2jo(@NotNull final Context context, @NotNull final GlanceId glanceId, final int i, @NotNull final String uuid, @NotNull final String filePath, @NotNull final String currentSizeString, final int i2, @Nullable final String str, @NotNull final WidgetSingleGlanceTheme themeManager, @NotNull final WidgetSingleGlanceUtils widgetUtils, @Nullable Composer composer, final int i4, final int i5) {
        int i6;
        int i7;
        String str2;
        int i8;
        int i9;
        int i10;
        Object objMutableStateOf$default;
        Composer composer2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(glanceId, "glanceId");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(currentSizeString, "currentSizeString");
        Intrinsics.checkNotNullParameter(themeManager, "themeManager");
        Intrinsics.checkNotNullParameter(widgetUtils, "widgetUtils");
        Composer composerStartRestartGroup = composer.startRestartGroup(-486063558);
        if ((i4 & 6) == 0) {
            i6 = (composerStartRestartGroup.changedInstance(context) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(glanceId) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i6 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i4 & 3072) == 0) {
            i6 |= composerStartRestartGroup.changed(uuid) ? 2048 : 1024;
        }
        if ((196608 & i4) == 0) {
            i6 |= composerStartRestartGroup.changed(currentSizeString) ? 131072 : 65536;
        }
        if ((1572864 & i4) == 0) {
            i7 = i2;
            i6 |= composerStartRestartGroup.changed(i7) ? 1048576 : 524288;
        } else {
            i7 = i2;
        }
        if ((12582912 & i4) == 0) {
            str2 = str;
            i6 |= composerStartRestartGroup.changed(str2) ? 8388608 : 4194304;
        } else {
            str2 = str;
        }
        if ((i4 & 100663296) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(themeManager) ? 67108864 : 33554432;
        }
        if ((i4 & DriveFile.MODE_READ_WRITE) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(widgetUtils) ? 536870912 : 268435456;
        }
        if ((i5 & 6) == 0) {
            i8 = i5 | (composerStartRestartGroup.changedInstance(this) ? 4 : 2);
        } else {
            i8 = i5;
        }
        if ((i6 & 306775187) != 306775186 || (i8 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-486063558, i6, i8, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ContentWidget (WidgetSingleGlance.kt:231)");
            }
            List<Bitmap> listCreateContent = widgetUtils.createContent(themeManager.isPageDark());
            long jColor = ColorKt.Color(themeManager.isWhiteTextColor() ? 4292730333L : 4282400832L);
            composerStartRestartGroup.startReplaceGroup(1044372821);
            if (widgetUtils.isBitmapNull(listCreateContent)) {
                i9 = i8;
            } else {
                CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
                i9 = i8;
                if (companion.getInstance().isValidFiles(uuid) && companion.getInstance().isCreateWidgetState(context, uuid, i)) {
                    WidgetPreferenceManager.INSTANCE.saveUpdateWidgetContentDone(i, true);
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    boolean zChanged = composerStartRestartGroup.changed(listCreateContent);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        i10 = 2;
                        objMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(listCreateContent == null ? new ArrayList<>() : listCreateContent, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objMutableStateOf$default);
                    } else {
                        objMutableStateOf$default = objRememberedValue;
                        i10 = 2;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Intent openNoteIntent = WidgetSingleGlanceIntent.INSTANCE.getOpenNoteIntent(context, uuid);
                    BoxKt.Box(ActionKt.clickable(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), StartActivityIntentActionKt.actionStartActivity$default(openNoteIntent, null, i10, null), true, true), Alignment.INSTANCE.getTopCenter(), ComposableLambdaKt.rememberComposableLambda(128586524, true, new WidgetSingleGlance$ContentWidget$2(i7, str2, (MutableState) objMutableStateOf$default, openNoteIntent, listCreateContent, widgetUtils, jColor, this, context, themeManager), composerStartRestartGroup, 54), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
            WidgetLogger.INSTANCE.m5157e(TAG, "Content widget# wait cache loading, WidgetId: " + i);
            WidgetPreferenceManager.INSTANCE.saveUpdateWidgetContentDone(i, false);
            int i11 = i6 >> 6;
            m22141UpdateStateACLJZ2c(context, glanceId, WidgetConstant.LOADING_VIEW, currentSizeString, i2, composerStartRestartGroup, (i6 & 14) | 384 | (i6 & 112) | (i11 & 7168) | (i11 & 57344) | ((i9 << 15) & 458752));
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final int i12 = 0;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2(this) { // from class: com.samsung.android.app.notes.widget.glance.single.d

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ WidgetSingleGlance f4656b;

                    {
                        this.f4656b = this;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Composer composer3 = (Composer) obj;
                        switch (i12) {
                            case 0:
                                return WidgetSingleGlance.ContentWidget_9NJi2jo$lambda$3(this.f4656b, context, glanceId, i, uuid, filePath, currentSizeString, i2, str, themeManager, widgetUtils, i4, i5, composer3, ((Integer) obj2).intValue());
                            default:
                                return WidgetSingleGlance.ContentWidget_9NJi2jo$lambda$6(this.f4656b, context, glanceId, i, uuid, filePath, currentSizeString, i2, str, themeManager, widgetUtils, i4, i5, composer3, ((Integer) obj2).intValue());
                        }
                    }
                });
                return;
            }
            return;
        }
        composerStartRestartGroup.skipToGroupEnd();
        composer2 = composerStartRestartGroup;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            final int i13 = 1;
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2(this) { // from class: com.samsung.android.app.notes.widget.glance.single.d

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ WidgetSingleGlance f4656b;

                {
                    this.f4656b = this;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Composer composer3 = (Composer) obj;
                    switch (i13) {
                        case 0:
                            return WidgetSingleGlance.ContentWidget_9NJi2jo$lambda$3(this.f4656b, context, glanceId, i, uuid, filePath, currentSizeString, i2, str, themeManager, widgetUtils, i4, i5, composer3, ((Integer) obj2).intValue());
                        default:
                            return WidgetSingleGlance.ContentWidget_9NJi2jo$lambda$6(this.f4656b, context, glanceId, i, uuid, filePath, currentSizeString, i2, str, themeManager, widgetUtils, i4, i5, composer3, ((Integer) obj2).intValue());
                    }
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x01b9  */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: ContentWidgetCover-h-kgKvA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m22140ContentWidgetCoverhkgKvA(@NotNull final Context context, @NotNull final GlanceId glanceId, final int i, @NotNull final String uuid, @NotNull final String filePath, @NotNull final String currentSizeString, final int i2, @Nullable final String str, @NotNull final WidgetSingleGlanceTheme themeManager, @NotNull final WidgetSingleGlanceUtils widgetUtils, @NotNull final String providerName, final int i4, @Nullable Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        int i9;
        WidgetSingleGlance widgetSingleGlance;
        List<Bitmap> list;
        Composer composer2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(glanceId, "glanceId");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(currentSizeString, "currentSizeString");
        Intrinsics.checkNotNullParameter(themeManager, "themeManager");
        Intrinsics.checkNotNullParameter(widgetUtils, "widgetUtils");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Composer composerStartRestartGroup = composer.startRestartGroup(1848951795);
        if ((i5 & 6) == 0) {
            i7 = (composerStartRestartGroup.changedInstance(context) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(glanceId) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i7 |= composerStartRestartGroup.changed(uuid) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= composerStartRestartGroup.changed(filePath) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i7 |= composerStartRestartGroup.changed(currentSizeString) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i8 = i2;
            i7 |= composerStartRestartGroup.changed(i8) ? 1048576 : 524288;
        } else {
            i8 = i2;
        }
        if ((i5 & 12582912) == 0) {
            i7 |= composerStartRestartGroup.changed(str) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(themeManager) ? 67108864 : 33554432;
        }
        if ((i5 & DriveFile.MODE_READ_WRITE) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(widgetUtils) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            i9 = i6 | (composerStartRestartGroup.changed(providerName) ? 4 : 2);
        } else {
            i9 = i6;
        }
        if ((i6 & 48) == 0) {
            i9 |= composerStartRestartGroup.changed(i4) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i9 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        int i10 = i9;
        if ((i7 & 306783379) == 306783378 && (i10 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1848951795, i7, i10, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ContentWidgetCover (WidgetSingleGlance.kt:338)");
            }
            List<Bitmap> listCreateContent = widgetUtils.createContent(themeManager.isPageDark());
            final long jColor = ColorKt.Color(themeManager.isWhiteTextColor() ? 4292730333L : 4282400832L);
            composerStartRestartGroup.startReplaceGroup(-1273765954);
            if (!widgetUtils.isBitmapNull(listCreateContent)) {
                CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
                if (companion.getInstance().isValidFiles(uuid) && companion.getInstance().isCreateWidgetState(context, uuid, i)) {
                    WidgetPreferenceManager.INSTANCE.saveUpdateWidgetContentDone(i, true);
                    list = listCreateContent;
                    widgetSingleGlance = this;
                } else {
                    WidgetLogger.INSTANCE.m5157e(TAG, "Content widget cover# wait cache loading, WidgetId: " + i);
                    WidgetPreferenceManager.INSTANCE.saveUpdateWidgetContentDone(i, false);
                    CacheFileManager.INSTANCE.getInstance().createCacheInfo(context, uuid, filePath, i);
                    int i11 = i7 >> 6;
                    widgetSingleGlance = this;
                    list = listCreateContent;
                    widgetSingleGlance.m22141UpdateStateACLJZ2c(context, glanceId, WidgetConstant.LOADING_VIEW, currentSizeString, i8, composerStartRestartGroup, (i7 & 14) | 384 | (i7 & 112) | (i11 & 7168) | (i11 & 57344) | ((i10 << 9) & 458752));
                }
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
                final List<ImageProvider> imageProvider = widgetSingleGlance.getImageProvider(list);
                final List<Bitmap> list2 = list;
                ColumnKt.m21455ColumnK4GKKTE(ActionKt.clickable(MarginKt.m21310marginqDBjuR0$default(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), 0.0f, i4 == 1 ? C2256Dp.m20968constructorimpl(84) : C2256Dp.m20968constructorimpl(0), 0.0f, 0.0f, 13, null), SendBroadcastActionKt.actionSendBroadcast(WidgetSingleGlanceIntent.INSTANCE.intentOpenMemoListFromWidget(context, i, providerName)), true, true), Alignment.Vertical.INSTANCE.m21454getTopmnfRV0w(), 0, ComposableLambdaKt.rememberComposableLambda(909476285, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$ContentWidgetCover$1

                    /* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$ContentWidgetCover$1$2 */
                    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
                    @SourceDebugExtension({"SMAP\nWidgetSingleGlance.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetSingleGlance.kt\ncom/samsung/android/app/notes/widget/glance/single/WidgetSingleGlance$ContentWidgetCover$1$2\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,950:1\n149#2:951\n149#2:952\n149#2:953\n1225#3,6:954\n*S KotlinDebug\n*F\n+ 1 WidgetSingleGlance.kt\ncom/samsung/android/app/notes/widget/glance/single/WidgetSingleGlance$ContentWidgetCover$1$2\n*L\n420#1:951\n422#1:952\n424#1:953\n426#1:954,6\n*E\n"})
                    public static final class C69792 implements Function2<Composer, Integer, Unit> {
                        final /* synthetic */ int $appWidgetId;
                        final /* synthetic */ long $colorDivider;
                        final /* synthetic */ Context $context;
                        final /* synthetic */ List<Bitmap> $listBitmap;
                        final /* synthetic */ List<ImageProvider> $listImageProvider;
                        final /* synthetic */ String $providerName;
                        final /* synthetic */ WidgetSingleGlanceTheme $themeManager;
                        final /* synthetic */ String $title;
                        final /* synthetic */ WidgetSingleGlanceUtils $widgetUtils;
                        final /* synthetic */ WidgetSingleGlance this$0;

                        /* JADX WARN: Multi-variable type inference failed */
                        public C69792(String str, List<? extends ImageProvider> list, Context context, int i, String str2, List<Bitmap> list2, WidgetSingleGlanceUtils widgetSingleGlanceUtils, long j, WidgetSingleGlance widgetSingleGlance, WidgetSingleGlanceTheme widgetSingleGlanceTheme) {
                            this.$title = str;
                            this.$listImageProvider = list;
                            this.$context = context;
                            this.$appWidgetId = i;
                            this.$providerName = str2;
                            this.$listBitmap = list2;
                            this.$widgetUtils = widgetSingleGlanceUtils;
                            this.$colorDivider = j;
                            this.this$0 = widgetSingleGlance;
                            this.$themeManager = widgetSingleGlanceTheme;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final Unit invoke$lambda$1$lambda$0(List list, final Context context, final int i, final String str, final List list2, final WidgetSingleGlanceUtils widgetSingleGlanceUtils, final WidgetSingleGlance widgetSingleGlance, final WidgetSingleGlanceTheme widgetSingleGlanceTheme, final long j, LazyListScope LazyColumn) {
                            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                            LazyListScope.items$default(LazyColumn, list.size(), null, ComposableLambdaKt.composableLambdaInstance(1607796631, true, 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002f: INVOKE 
                                  (r22v0 'LazyColumn' androidx.glance.appwidget.lazy.LazyListScope)
                                  (wrap:int:0x0007: INVOKE (r12v0 'list' java.util.List) INTERFACE call: java.util.List.size():int A[MD:():int (c), WRAPPED] (LINE:8))
                                  (null kotlin.jvm.functions.Function1)
                                  (wrap:androidx.compose.runtime.internal.ComposableLambda:0x0021: INVOKE 
                                  (1607796631 int)
                                  true
                                  (wrap:kotlin.jvm.functions.Function4<androidx.glance.appwidget.lazy.LazyItemScope, java.lang.Integer, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>:0x001a: CONSTRUCTOR 
                                  (r13v0 'context' android.content.Context A[DONT_INLINE])
                                  (r14v0 'i' int A[DONT_INLINE])
                                  (r15v0 'str' java.lang.String A[DONT_INLINE])
                                  (r16v0 'list2' java.util.List A[DONT_INLINE])
                                  (r17v0 'widgetSingleGlanceUtils' com.samsung.android.app.notes.widget.glance.single.common.WidgetSingleGlanceUtils A[DONT_INLINE])
                                  (r18v0 'widgetSingleGlance' com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance A[DONT_INLINE])
                                  (r19v0 'widgetSingleGlanceTheme' com.samsung.android.app.notes.widget.glance.single.theme.WidgetSingleGlanceTheme A[DONT_INLINE])
                                  (r20v0 'j' long A[DONT_INLINE])
                                 A[MD:(android.content.Context, int, java.lang.String, java.util.List<android.graphics.Bitmap>, com.samsung.android.app.notes.widget.glance.single.common.WidgetSingleGlanceUtils, com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance, com.samsung.android.app.notes.widget.glance.single.theme.WidgetSingleGlanceTheme, long):void (m), WRAPPED] (LINE:27) call: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$ContentWidgetCover$1$2$1$1$1.<init>(android.content.Context, int, java.lang.String, java.util.List, com.samsung.android.app.notes.widget.glance.single.common.WidgetSingleGlanceUtils, com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance, com.samsung.android.app.notes.widget.glance.single.theme.WidgetSingleGlanceTheme, long):void type: CONSTRUCTOR)
                                 STATIC call: androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(int, boolean, java.lang.Object):androidx.compose.runtime.internal.ComposableLambda A[MD:(int, boolean, java.lang.Object):androidx.compose.runtime.internal.ComposableLambda (m), WRAPPED] (LINE:34))
                                  (2 int)
                                  (null java.lang.Object)
                                 STATIC call: androidx.glance.appwidget.lazy.LazyListScope.items$default(androidx.glance.appwidget.lazy.LazyListScope, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function4, int, java.lang.Object):void A[MD:(androidx.glance.appwidget.lazy.LazyListScope, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function4, int, java.lang.Object):void (m)] (LINE:48) in method: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$ContentWidgetCover$1.2.invoke$lambda$1$lambda$0(java.util.List, android.content.Context, int, java.lang.String, java.util.List, com.samsung.android.app.notes.widget.glance.single.common.WidgetSingleGlanceUtils, com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance, com.samsung.android.app.notes.widget.glance.single.theme.WidgetSingleGlanceTheme, long, androidx.glance.appwidget.lazy.LazyListScope):kotlin.Unit, file: classes7.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:303)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$ContentWidgetCover$1$2$1$1$1, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 15 more
                                */
                            /*
                                java.lang.String r0 = "$this$LazyColumn"
                                r1 = r22
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
                                int r12 = r12.size()
                                com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$ContentWidgetCover$1$2$1$1$1 r2 = new com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$ContentWidgetCover$1$2$1$1$1
                                r3 = r13
                                r4 = r14
                                r5 = r15
                                r6 = r16
                                r7 = r17
                                r8 = r18
                                r9 = r19
                                r10 = r20
                                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
                                r13 = 1607796631(0x5fd50797, float:3.0700808E19)
                                r14 = 1
                                androidx.compose.runtime.internal.ComposableLambda r15 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r13, r14, r2)
                                r13 = 2
                                r14 = 0
                                r0 = 0
                                r16 = r13
                                r17 = r14
                                r14 = r0
                                r13 = r12
                                r12 = r1
                                androidx.glance.appwidget.lazy.LazyListScope.items$default(r12, r13, r14, r15, r16, r17)
                                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                                return r12
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$ContentWidgetCover$1.C69792.invoke$lambda$1$lambda$0(java.util.List, android.content.Context, int, java.lang.String, java.util.List, com.samsung.android.app.notes.widget.glance.single.common.WidgetSingleGlanceUtils, com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance, com.samsung.android.app.notes.widget.glance.single.theme.WidgetSingleGlanceTheme, long, androidx.glance.appwidget.lazy.LazyListScope):kotlin.Unit");
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                        @Composable
                        public final void invoke(Composer composer, int i) {
                            if ((i & 3) == 2 && composer.getSkipping()) {
                                composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2020671903, i, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ContentWidgetCover.<anonymous>.<anonymous> (WidgetSingleGlance.kt:413)");
                            }
                            GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
                            String str = this.$title;
                            GlanceModifier glanceModifierM21310marginqDBjuR0$default = MarginKt.m21310marginqDBjuR0$default(glanceModifierWrapContentHeight, 0.0f, (str == null || str.length() == 0) ? C2256Dp.m20968constructorimpl(14) : C2256Dp.m20968constructorimpl(0), 0.0f, C2256Dp.m20968constructorimpl(14), 5, null);
                            composer.startReplaceGroup(-1224400529);
                            boolean zChangedInstance = composer.changedInstance(this.$listImageProvider) | composer.changedInstance(this.$context) | composer.changed(this.$appWidgetId) | composer.changed(this.$providerName) | composer.changedInstance(this.$listBitmap) | composer.changedInstance(this.$widgetUtils) | composer.changed(this.$colorDivider) | composer.changedInstance(this.this$0) | composer.changedInstance(this.$themeManager);
                            final List<ImageProvider> list = this.$listImageProvider;
                            final Context context = this.$context;
                            final int i2 = this.$appWidgetId;
                            final String str2 = this.$providerName;
                            final List<Bitmap> list2 = this.$listBitmap;
                            final WidgetSingleGlanceUtils widgetSingleGlanceUtils = this.$widgetUtils;
                            final WidgetSingleGlance widgetSingleGlance = this.this$0;
                            final WidgetSingleGlanceTheme widgetSingleGlanceTheme = this.$themeManager;
                            final long j = this.$colorDivider;
                            Object objRememberedValue = composer.rememberedValue();
                            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                Function1 function1 = 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00bd: CONSTRUCTOR (r5v2 'function1' kotlin.jvm.functions.Function1) = 
                                      (r6v1 'list' java.util.List<androidx.glance.ImageProvider> A[DONT_INLINE])
                                      (r7v1 'context' android.content.Context A[DONT_INLINE])
                                      (r8v1 'i2' int A[DONT_INLINE])
                                      (r9v1 'str2' java.lang.String A[DONT_INLINE])
                                      (r10v1 'list2' java.util.List<android.graphics.Bitmap> A[DONT_INLINE])
                                      (r11v1 'widgetSingleGlanceUtils' com.samsung.android.app.notes.widget.glance.single.common.WidgetSingleGlanceUtils A[DONT_INLINE])
                                      (r12v0 'widgetSingleGlance' com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance A[DONT_INLINE])
                                      (r13v0 'widgetSingleGlanceTheme' com.samsung.android.app.notes.widget.glance.single.theme.WidgetSingleGlanceTheme A[DONT_INLINE])
                                      (r14v0 'j' long A[DONT_INLINE])
                                     A[DECLARE_VAR, MD:(java.util.List, android.content.Context, int, java.lang.String, java.util.List, com.samsung.android.app.notes.widget.glance.single.common.WidgetSingleGlanceUtils, com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance, com.samsung.android.app.notes.widget.glance.single.theme.WidgetSingleGlanceTheme, long):void (m)] (LINE:15) call: com.samsung.android.app.notes.widget.glance.single.h.<init>(java.util.List, android.content.Context, int, java.lang.String, java.util.List, com.samsung.android.app.notes.widget.glance.single.common.WidgetSingleGlanceUtils, com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance, com.samsung.android.app.notes.widget.glance.single.theme.WidgetSingleGlanceTheme, long):void type: CONSTRUCTOR in method: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$ContentWidgetCover$1.2.invoke(androidx.compose.runtime.Composer, int):void, file: classes7.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:303)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.samsung.android.app.notes.widget.glance.single.h, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                    	... 25 more
                                    */
                                /*
                                    Method dump skipped, instruction units count: 217
                                    To view this dump add '--comments-level debug' option
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$ContentWidgetCover$1.C69792.invoke(androidx.compose.runtime.Composer, int):void");
                            }
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                            invoke(columnScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                        @Composable
                        public final void invoke(ColumnScope Column, Composer composer3, int i12) {
                            Intrinsics.checkNotNullParameter(Column, "$this$Column");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(909476285, i12, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ContentWidgetCover.<anonymous> (WidgetSingleGlance.kt:372)");
                            }
                            composer3.startReplaceGroup(2128350523);
                            String str2 = str;
                            if (str2 != null && str2.length() != 0 && Intrinsics.areEqual(providerName, "WidgetSingleExtraLargeCoverProvider")) {
                                float f = 16;
                                GlanceModifier glanceModifierClickable = ActionKt.clickable(MarginKt.m21309marginqDBjuR0(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(14), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(12)), SendBroadcastActionKt.actionSendBroadcast(WidgetSingleGlanceIntent.INSTANCE.intentOpenMemoListFromWidget(context, i, providerName)), true, true);
                                Alignment topStart = Alignment.INSTANCE.getTopStart();
                                final String str3 = str;
                                final WidgetSingleGlanceTheme widgetSingleGlanceTheme = themeManager;
                                BoxKt.Box(glanceModifierClickable, topStart, ComposableLambdaKt.rememberComposableLambda(2082897764, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$ContentWidgetCover$1.1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                    @Composable
                                    public final void invoke(Composer composer4, int i13) {
                                        if ((i13 & 3) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2082897764, i13, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ContentWidgetCover.<anonymous>.<anonymous> (WidgetSingleGlance.kt:390)");
                                        }
                                        TextKt.m21709TemplateText3SkNqBk(new TextData(str3, ColorProviderKt.m22055ColorProvider8_81llA(widgetSingleGlanceTheme.m22146updateTitleTextColor0d7_KjU()), 0, (TextDecoration) null, 0, (FontFamily) null, 1, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32700, (DefaultConstructorMarker) null), TextUnitKt.getSp(14), FontWeight.INSTANCE.m21996getBoldWjrlUT0(), 0.0f, composer4, TextData.$stable | 48, 8);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer3, 54), composer3, (Alignment.$stable << 3) | 384, 0);
                            }
                            composer3.endReplaceGroup();
                            BoxKt.Box(ActionKt.clickable(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), SendBroadcastActionKt.actionSendBroadcast(WidgetSingleGlanceIntent.INSTANCE.intentOpenMemoListFromWidget(context, i, providerName)), true, true), Alignment.INSTANCE.getTopCenter(), ComposableLambdaKt.rememberComposableLambda(2020671903, true, new C69792(str, imageProvider, context, i, providerName, list2, widgetUtils, jColor, this, themeManager), composer3, 54), composer3, (Alignment.$stable << 3) | 384, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 3072, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.samsung.android.app.notes.widget.glance.single.a
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        int iIntValue = ((Integer) obj2).intValue();
                        return WidgetSingleGlance.ContentWidgetCover_h_kgKvA$lambda$7(this.f4627a, context, glanceId, i, uuid, filePath, currentSizeString, i2, str, themeManager, widgetUtils, providerName, i4, i5, i6, (Composer) obj, iIntValue);
                    }
                });
            }
        }

        @Override // androidx.glance.oneui.template.GlanceTemplateAppWidget
        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
        @Composable
        public void TemplateContent(@Nullable Composer composer, int i) {
            int i2;
            WidgetSingleGlanceUtils widgetSingleGlanceUtils;
            NotesDocumentEntity notesDocumentEntity;
            long j;
            String str;
            int i4;
            Action action;
            WidgetSingleGlance widgetSingleGlance;
            Composer composer2;
            Action actionActionSendBroadcast;
            Composer composerStartRestartGroup = composer.startRestartGroup(906175233);
            if ((i & 6) == 0) {
                i2 = i | (composerStartRestartGroup.changedInstance(this) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
                composer2 = composerStartRestartGroup;
                widgetSingleGlance = this;
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(906175233, i2, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.TemplateContent (WidgetSingleGlance.kt:111)");
                }
                final Context context = (Context) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalContext());
                int mask = ((AppWidgetSize) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask();
                final int appWidgetId = new GlanceAppWidgetManager(context).getAppWidgetId((GlanceId) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalGlanceId()));
                final GlanceId glanceId = (GlanceId) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalGlanceId());
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
                String str2 = (String) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b2, key2);
                String str3 = str2 == null ? BaseWidgetConstant.WIDGET_SINGLE_PROVIDER_NAME : str2;
                Preferences.Key<String> key3 = typeWidgetViewKey;
                Object objM4741b3 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
                if (objM4741b3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
                }
                String str4 = (String) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b3, key3);
                if (str4 == null) {
                    str4 = WidgetConstant.EMPTY_VIEW;
                }
                final String str5 = str4;
                Preferences.Key<String> key4 = lastSizeKey;
                Object objM4741b4 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
                if (objM4741b4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
                }
                String str6 = (String) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b4, key4);
                final String strM21559toStringimpl = AppWidgetSize.m21559toStringimpl(mask);
                Preferences.Key<Integer> key5 = transparencyKey;
                Object objM4741b5 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
                if (objM4741b5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
                }
                Integer num = (Integer) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b5, key5);
                int iIntValue = num != null ? num.intValue() : 75;
                Preferences.Key<Integer> key6 = backgroundColorKey;
                Object objM4741b6 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
                if (objM4741b6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
                }
                Integer num2 = (Integer) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b6, key6);
                int iIntValue2 = num2 != null ? num2.intValue() : 1;
                Preferences.Key<Integer> key7 = darkModeKey;
                int i5 = iIntValue2;
                Object objM4741b7 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
                if (objM4741b7 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
                }
                Integer num3 = (Integer) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b7, key7);
                int iIntValue3 = num3 != null ? num3.intValue() : 1;
                Preferences.Key<Boolean> key8 = matchSettingKey;
                int i6 = iIntValue3;
                Object objM4741b8 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
                if (objM4741b8 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
                }
                Boolean bool = (Boolean) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b8, key8);
                boolean zBooleanValue = bool != null ? bool.booleanValue() : true;
                Preferences.Key<Integer> key9 = backgroundShapeKey;
                boolean z = zBooleanValue;
                Object objM4741b9 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
                if (objM4741b9 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
                }
                Integer num4 = (Integer) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b9, key9);
                boolean z2 = false;
                int iIntValue4 = num4 != null ? num4.intValue() : 0;
                Preferences.Key<Boolean> key10 = backgroundOnOffKey;
                int i7 = iIntValue;
                Object objM4741b10 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
                if (objM4741b10 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
                }
                Boolean bool2 = (Boolean) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b10, key10);
                boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : true;
                Preferences.Key<String> key11 = filePathKey;
                boolean z3 = zBooleanValue2;
                Object objM4741b11 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
                if (objM4741b11 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
                }
                String str7 = (String) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b11, key11);
                if (str7 == null) {
                    str7 = BaseWidgetConstant.NONE;
                }
                Preferences.Key<String> key12 = uuidKey;
                Object objM4741b12 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
                if (objM4741b12 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
                }
                String str8 = (String) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b12, key12);
                String str9 = str8 == null ? BaseWidgetConstant.NONE : str8;
                Preferences.Key<Integer> key13 = coverScreenCutoutKey;
                Object objM4741b13 = AbstractC6670b.m4741b(1333953144, composerStartRestartGroup, -534706435);
                if (objM4741b13 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
                }
                Integer num5 = (Integer) AbstractC2821a.m2217h(composerStartRestartGroup, (Preferences) objM4741b13, key13);
                final int iIntValue5 = num5 != null ? num5.intValue() : 0;
                final String str10 = str9;
                int i8 = iIntValue4;
                long j2 = jLongValue;
                final WidgetSingleGlanceTheme widgetSingleGlanceTheme = new WidgetSingleGlanceTheme(context, appWidgetId, str10, i7, i5, i6, z, z3, str5, str3);
                WidgetSingleGlanceUtils widgetSingleGlanceUtils2 = new WidgetSingleGlanceUtils(context, appWidgetId, str10, str3);
                String str11 = str3;
                NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
                Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
                NotesDocumentEntity notesDocumentEntity2 = notesDocumentRepositoryCreateDocumentDataRepository.get(str10);
                final String title = widgetSingleGlanceUtils2.getTitle(notesDocumentEntity2);
                if (notesDocumentEntity2 != null) {
                    notesDocumentEntity = notesDocumentEntity2;
                    widgetSingleGlanceUtils = widgetSingleGlanceUtils2;
                    if (notesDocumentEntity.getIsLock() == 5) {
                        z2 = true;
                    }
                } else {
                    widgetSingleGlanceUtils = widgetSingleGlanceUtils2;
                    notesDocumentEntity = notesDocumentEntity2;
                }
                final boolean z4 = !z2;
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strM21559toStringimpl2 = AppWidgetSize.m21559toStringimpl(mask);
                StringBuilder sbM1323p = AbstractC1974b.m1323p(j2, "onUpdate: timeUpdate: ", ", currentTime: ");
                sbM1323p.append(jCurrentTimeMillis);
                sbM1323p.append(", appWidgetId: ");
                sbM1323p.append(appWidgetId);
                AbstractC0622a.m1180z(sbM1323p, i7, i5, ", transparency: ", ",backgroundColor: ");
                sbM1323p.append(", darkMode: ");
                sbM1323p.append(i6);
                sbM1323p.append(", matchSetting: ");
                sbM1323p.append(z);
                sbM1323p.append(", backgroundOnOff: ");
                sbM1323p.append(z3);
                sbM1323p.append(", backgroundShape: ");
                sbM1323p.append(i8);
                AbstractC2821a.m2207B(sbM1323p, ", filePath: ", str7, ", uuid: ", str10);
                AbstractC2821a.m2207B(sbM1323p, ", title: ", title, ", typeWidgetView: ", str5);
                AbstractC2821a.m2207B(sbM1323p, ", lastSize: ", str6, ", currentSize: ", strM21559toStringimpl);
                sbM1323p.append(", widgetSize: ");
                sbM1323p.append(strM21559toStringimpl2);
                sbM1323p.append(", coverScreenCutout: ");
                sbM1323p.append(iIntValue5);
                Logger.m8702i(TAG, sbM1323p.toString());
                String strM757C = AbstractC0541b.m757C(context.getResources().getString(C11391R.string.notes), " ", context.getResources().getString(C11391R.string.widget_show_note));
                final WidgetSingleGlanceUtils widgetSingleGlanceUtils3 = widgetSingleGlanceUtils;
                AppWidgetBackground appWidgetBackground = widgetSingleGlanceTheme.getAppWidgetBackground(widgetSingleGlanceUtils3.m22143getShapenwmoUQ(i8, z3, mask));
                ColorProviders colorProvidersUpdateBackground$default = WidgetSingleGlanceTheme.updateBackground$default(widgetSingleGlanceTheme, null, 1, null);
                final String str12 = str7;
                String strM22138getAppWidgetLabelnwmoUQ = m22138getAppWidgetLabelnwmoUQ(context, title, mask);
                TitleBarData titleBarDataTitleBar = titleBar(title);
                if (title == null || title.length() == 0) {
                    j = j2;
                    str = str11;
                    i4 = mask;
                    action = null;
                } else {
                    str = str11;
                    i4 = mask;
                    if (Intrinsics.areEqual(str, BaseWidgetConstant.WIDGET_SINGLE_PROVIDER_NAME)) {
                        j = j2;
                        actionActionSendBroadcast = StartActivityIntentActionKt.actionStartActivity$default(WidgetSingleGlanceIntent.INSTANCE.getOpenNoteIntent(context, str10), null, 2, null);
                    } else {
                        j = j2;
                        actionActionSendBroadcast = SendBroadcastActionKt.actionSendBroadcast(WidgetSingleGlanceIntent.INSTANCE.intentOpenMemoListFromWidget(context, appWidgetId, str));
                    }
                    action = actionActionSendBroadcast;
                }
                final int i9 = i4;
                final NotesDocumentEntity notesDocumentEntity3 = notesDocumentEntity;
                final String str13 = str;
                Function2<Composer, Integer, Unit> function2 = new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.TemplateContent.1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num6) {
                        invoke(composer3, num6.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    public final void invoke(Composer composer3, int i10) {
                        Composer composer4;
                        if ((i10 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(150154165, i10, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.TemplateContent.<anonymous> (WidgetSingleGlance.kt:162)");
                        }
                        if (Intrinsics.areEqual(str5, WidgetConstant.LOADING_VIEW)) {
                            composer3.startReplaceGroup(-2113124126);
                            WidgetLogger.INSTANCE.m5157e(WidgetSingleGlance.TAG, "loading, WidgetId: " + appWidgetId);
                            this.WidgetLoading(context, widgetSingleGlanceTheme, composer3, 0);
                            composer3.endReplaceGroup();
                        } else if (Intrinsics.areEqual(str5, WidgetConstant.EMPTY_VIEW) || str10.length() == 0 || Intrinsics.areEqual(str10, BaseWidgetConstant.NONE) || !z4) {
                            composer3.startReplaceGroup(-2112857867);
                            WidgetLogger.INSTANCE.m5157e(WidgetSingleGlance.TAG, "empty view: " + appWidgetId);
                            if (Intrinsics.areEqual(str13, "WidgetSingleExtraLargeCoverProvider")) {
                                composer3.startReplaceGroup(-2112726489);
                                this.m22135WidgetSingleExtraLargeCoverEmptygaecCbA(context, appWidgetId, i9, widgetSingleGlanceTheme, str13, composer3, 0);
                                composer3.endReplaceGroup();
                            } else {
                                composer3.startReplaceGroup(-2112588260);
                                this.m22134WidgetEmptygaecCbA(context, appWidgetId, i9, widgetSingleGlanceTheme, str13, composer3, 0);
                                composer3.endReplaceGroup();
                            }
                            composer3.endReplaceGroup();
                        } else if (Intrinsics.areEqual(str5, WidgetConstant.CONVERT_VIEW) || WidgetUtils.INSTANCE.isSDoc(context, str10)) {
                            composer3.startReplaceGroup(-2112367602);
                            WidgetLogger.INSTANCE.m5157e(WidgetSingleGlance.TAG, "Convert doc, WidgetId: " + appWidgetId);
                            this.WidgetConvertDoc(context, appWidgetId, widgetSingleGlanceTheme, composer3, 0);
                            composer3.endReplaceGroup();
                        } else if (!Intrinsics.areEqual(str5, WidgetConstant.NORMAL_VIEW) || notesDocumentEntity3 == null) {
                            composer3.startReplaceGroup(-2111470338);
                            WidgetLogger.INSTANCE.m5157e(WidgetSingleGlance.TAG, "loading bas, WidgetId: " + appWidgetId);
                            this.WidgetLoading(context, widgetSingleGlanceTheme, composer3, 0);
                            composer3.endReplaceGroup();
                        } else {
                            composer3.startReplaceGroup(-2112114022);
                            WidgetLogger.INSTANCE.m5157e(WidgetSingleGlance.TAG, "Normal view, WidgetId: " + appWidgetId);
                            if (Intrinsics.areEqual(str13, BaseWidgetConstant.WIDGET_SINGLE_PROVIDER_NAME)) {
                                composer3.startReplaceGroup(-2111997214);
                                this.m22139ContentWidget9NJi2jo(context, glanceId, appWidgetId, str10, str12, strM21559toStringimpl, i9, title, widgetSingleGlanceTheme, widgetSingleGlanceUtils3, composer3, 0, 0);
                                composer4 = composer3;
                                composer4.endReplaceGroup();
                            } else {
                                composer3.startReplaceGroup(-2111756964);
                                this.m22140ContentWidgetCoverhkgKvA(context, glanceId, appWidgetId, str10, str12, strM21559toStringimpl, i9, title, widgetSingleGlanceTheme, widgetSingleGlanceUtils3, str13, iIntValue5, composer3, 0, 0);
                                composer4 = composer3;
                                composer4.endReplaceGroup();
                            }
                            composer4.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                };
                widgetSingleGlance = this;
                composer2 = composerStartRestartGroup;
                TopLevelLayoutKt.TopLevelLayout(strM757C, appWidgetBackground, colorProvidersUpdateBackground$default, titleBarDataTitleBar, action, strM22138getAppWidgetLabelnwmoUQ, ComposableLambdaKt.rememberComposableLambda(150154165, true, function2, composer2, 54), composer2, (AppWidgetBackground.$stable << 3) | 1572864 | (ColorProviders.$stable << 6) | (TitleBarData.$stable << 9), 0);
                WidgetLogger.m5154d(TAG, "onUpdate: content widget done# WidgetId: " + appWidgetId + ", currentTime: " + System.currentTimeMillis() + ", durationTime: " + ((r1 - j) / 1000.0d));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new C6916a(widgetSingleGlance, i, 2));
            }
        }

        @Composable
        /* JADX INFO: renamed from: UpdateState-ACLJZ2c, reason: not valid java name */
        public final void m22141UpdateStateACLJZ2c(@NotNull final Context context, @NotNull final GlanceId glanceId, @NotNull final String typeWidgetView, @NotNull final String currentSizeString, int i, @Nullable Composer composer, final int i2) {
            int i4;
            int i5;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(glanceId, "glanceId");
            Intrinsics.checkNotNullParameter(typeWidgetView, "typeWidgetView");
            Intrinsics.checkNotNullParameter(currentSizeString, "currentSizeString");
            Composer composerStartRestartGroup = composer.startRestartGroup(-170510082);
            if ((i2 & 6) == 0) {
                i4 = (composerStartRestartGroup.changedInstance(context) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(glanceId) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                i4 |= composerStartRestartGroup.changed(typeWidgetView) ? 256 : 128;
            }
            if ((i2 & 3072) == 0) {
                i4 |= composerStartRestartGroup.changed(currentSizeString) ? 2048 : 1024;
            }
            if ((i2 & 24576) == 0) {
                i5 = i;
                i4 |= composerStartRestartGroup.changed(i5) ? 16384 : 8192;
            } else {
                i5 = i;
            }
            if ((196608 & i2) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(this) ? 131072 : 65536;
            }
            int i6 = i4;
            if ((74899 & i6) == 74898 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-170510082, i6, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.UpdateState (WidgetSingleGlance.kt:208)");
                }
                AppWidgetSize appWidgetSizeM21545boximpl = AppWidgetSize.m21545boximpl(i5);
                composerStartRestartGroup.startReplaceGroup(-1224400529);
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(glanceId) | ((i6 & 896) == 256) | ((i6 & 7168) == 2048) | composerStartRestartGroup.changedInstance(this);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    WidgetSingleGlance$UpdateState$1$1 widgetSingleGlance$UpdateState$1$1 = new WidgetSingleGlance$UpdateState$1$1(context, glanceId, this, typeWidgetView, currentSizeString, null);
                    composerStartRestartGroup.updateRememberedValue(widgetSingleGlance$UpdateState$1$1);
                    objRememberedValue = widgetSingleGlance$UpdateState$1$1;
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(appWidgetSizeM21545boximpl, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue, composerStartRestartGroup, (i6 >> 12) & 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final int i7 = i5;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.samsung.android.app.notes.widget.glance.single.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        int iIntValue = ((Integer) obj2).intValue();
                        return WidgetSingleGlance.UpdateState_ACLJZ2c$lambda$2(this.f4676a, context, glanceId, typeWidgetView, currentSizeString, i7, i2, (Composer) obj, iIntValue);
                    }
                });
            }
        }

        @Composable
        public final void ViewMore(@NotNull final Context context, final int i, @NotNull final WidgetSingleGlanceTheme themeManager, @NotNull final String providerName, @Nullable Composer composer, int i2) {
            int i4;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(themeManager, "themeManager");
            Intrinsics.checkNotNullParameter(providerName, "providerName");
            Composer composerStartRestartGroup = composer.startRestartGroup(1659927736);
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
                    ComposerKt.traceEventStart(1659927736, i4, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ViewMore (WidgetSingleGlance.kt:487)");
                }
                BoxKt.Box(MarginKt.m21310marginqDBjuR0$default(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), 0.0f, C2256Dp.m20968constructorimpl(4), 0.0f, 0.0f, 13, null), Alignment.INSTANCE.getCenter(), ComposableLambdaKt.rememberComposableLambda(1631892886, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ViewMore.1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @Composable
                    public final void invoke(Composer composer2, int i5) {
                        if ((i5 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1631892886, i5, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ViewMore.<anonymous> (WidgetSingleGlance.kt:495)");
                        }
                        GlanceModifier glanceModifierClickable = ActionKt.clickable(BackgroundKt.m21250background4WTKRHQ(CornerRadiusKt.m21286cornerRadius3ABfNKs(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.wrapContentWidth(PaddingKt.m21497paddingVpY3zN4(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(12), C2256Dp.m20968constructorimpl(8)))), C2256Dp.m20968constructorimpl(18)), themeManager.m22147updateViewMoreBackgroundColor0d7_KjU()), SendBroadcastActionKt.actionSendBroadcast(WidgetSingleGlanceIntent.INSTANCE.intentOpenMemoListFromWidget(context, i, providerName)), C11391R.drawable.sesl_glance_dim_effect);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        final Context context2 = context;
                        final WidgetSingleGlanceTheme widgetSingleGlanceTheme = themeManager;
                        BoxKt.Box(glanceModifierClickable, center, ComposableLambdaKt.rememberComposableLambda(-11055240, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ViewMore.1.1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Composable
                            public final void invoke(Composer composer3, int i6) {
                                if ((i6 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-11055240, i6, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ViewMore.<anonymous>.<anonymous> (WidgetSingleGlance.kt:508)");
                                }
                                String string = context2.getResources().getString(C11391R.string.to_view_more);
                                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                int i7 = 0;
                                TextData textData = new TextData(string, (ColorProvider) null, 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, context2.getResources().getString(C11391R.string.to_view_more), (RemoteAnimation) null, false, i7, 0, 31742, (DefaultConstructorMarker) null);
                                String string2 = context2.getResources().getString(C11391R.string.to_view_more);
                                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                long sp = TextUnitKt.getSp(12.0f);
                                int iM21996getBoldWjrlUT0 = FontWeight.INSTANCE.m21996getBoldWjrlUT0();
                                FontFamily fontFamily = textData.getFontFamily();
                                int iM22007getCenterROrN78o = TextAlign.INSTANCE.m22007getCenterROrN78o();
                                TextDecoration textDecoration = textData.getTextDecoration();
                                int textDirection = textData.getTextDirection();
                                boolean z = false;
                                Object[] objArr = 0 == true ? 1 : 0;
                                Object[] objArr2 = 0 == true ? 1 : 0;
                                androidx.glance.text.TextKt.Text(string2, (GlanceModifier) null, new TextStyle(ColorProviderKt.m22055ColorProvider8_81llA(widgetSingleGlanceTheme.m22146updateTitleTextColor0d7_KjU()), TextUnit.m21151boximpl(sp), FontWeight.m21989boximpl(iM21996getBoldWjrlUT0), objArr, TextAlign.m22000boximpl(iM22007getCenterROrN78o), textDecoration, fontFamily, textDirection, z, objArr2, ComplexUnit.f1613DP, i7, null, null, 0, 31496, null), 1, 0.0f, composer3, 3072, 18);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, (Alignment.$stable << 3) | 384, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new C6996e(this, context, i, themeManager, providerName, i2, 1));
            }
        }

        @Composable
        public final void WidgetConvertDoc(@NotNull final Context context, int i, @NotNull final WidgetSingleGlanceTheme themeManager, @Nullable Composer composer, int i2) {
            int i4;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(themeManager, "themeManager");
            Composer composerStartRestartGroup = composer.startRestartGroup(919346280);
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
            if ((i4 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(919346280, i4, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetConvertDoc (WidgetSingleGlance.kt:575)");
                }
                String string = context.getResources().getString(C11391R.string.widget_convert_document);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                Action actionActionSendBroadcast = SendBroadcastActionKt.actionSendBroadcast(WidgetSingleGlanceIntent.INSTANCE.intentConvertWidget(context, i));
                final TextData textData = new TextData(string, themeManager.updateBodyTextColor(), 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, string, (RemoteAnimation) null, false, 0, 0, 31740, (DefaultConstructorMarker) null);
                float f = 14;
                BoxKt.Box(ActionKt.clickable(PaddingKt.m21497paddingVpY3zN4(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f)), actionActionSendBroadcast), Alignment.INSTANCE.getCenter(), ComposableLambdaKt.rememberComposableLambda(50265930, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetConvertDoc.1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @Composable
                    public final void invoke(Composer composer2, int i5) {
                        int i6;
                        if ((i5 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(50265930, i5, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetConvertDoc.<anonymous> (WidgetSingleGlance.kt:591)");
                        }
                        String text = textData.getText();
                        if (text == null) {
                            text = context.getResources().getString(C11391R.string.widget_text_loading);
                            Intrinsics.checkNotNullExpressionValue(text, "getString(...)");
                        }
                        String str = text;
                        long sp = TextUnitKt.getSp(12.0f);
                        int iM21998getNormalWjrlUT0 = FontWeight.INSTANCE.m21998getNormalWjrlUT0();
                        FontFamily fontFamily = textData.getFontFamily();
                        int iM22011getStartROrN78o = TextAlign.INSTANCE.m22011getStartROrN78o();
                        TextDecoration textDecoration = textData.getTextDecoration();
                        int textDirection = textData.getTextDirection();
                        FontStyle fontStyle = null;
                        boolean z = false;
                        TextShadowStyle textShadowStyle = null;
                        TextStyle textStyle = new TextStyle(themeManager.updateBodyTextColor(), TextUnit.m21151boximpl(sp), FontWeight.m21989boximpl(iM21998getNormalWjrlUT0), fontStyle, TextAlign.m22000boximpl(iM22011getStartROrN78o), textDecoration, fontFamily, textDirection, z, textShadowStyle, ComplexUnit.f1613DP, 0, null, null, 0, 31496, null);
                        int mask = ((AppWidgetSize) composer2.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask();
                        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
                        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4())) {
                            i6 = 1;
                        } else {
                            AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4());
                            i6 = 3;
                        }
                        androidx.glance.text.TextKt.Text(str, (GlanceModifier) null, textStyle, i6, 0.0f, composer2, 24576, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new C6917b(this, context, i, themeManager, i2, 1));
            }
        }

        @Composable
        /* JADX INFO: renamed from: WidgetEmptyMedium-gaecCbA, reason: not valid java name */
        public final void m22142WidgetEmptyMediumgaecCbA(@NotNull final Context context, int i, int i2, @NotNull final WidgetSingleGlanceTheme themeManager, @NotNull final String providerName, @Nullable Composer composer, int i4) {
            int i5;
            Composer composer2;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(themeManager, "themeManager");
            Intrinsics.checkNotNullParameter(providerName, "providerName");
            Composer composerStartRestartGroup = composer.startRestartGroup(-118050730);
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
                    ComposerKt.traceEventStart(-118050730, i5, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptyMedium (WidgetSingleGlance.kt:710)");
                }
                int i6 = ((Bundle) composerStartRestartGroup.consume(androidx.glance.appwidget.CompositionLocalsKt.getLocalAppWidgetOptions())).getInt("semAppWidgetRowSpan");
                int i7 = ((Bundle) composerStartRestartGroup.consume(androidx.glance.appwidget.CompositionLocalsKt.getLocalAppWidgetOptions())).getInt("semAppWidgetColumnSpan");
                composerStartRestartGroup.startReplaceGroup(-1777588506);
                float fM21064getHeightD9Ej5fM = (i6 <= 2 || i7 < 4) ? DpSize.m21064getHeightD9Ej5fM(((DpSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSize())).getPackedValue()) : C2256Dp.m20968constructorimpl(180);
                composerStartRestartGroup.endReplaceGroup();
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                final Ref.LongRef longRef = new Ref.LongRef();
                final Ref.LongRef longRef2 = new Ref.LongRef();
                final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                final Ref.FloatRef floatRef3 = new Ref.FloatRef();
                if (Intrinsics.areEqual(providerName, BaseWidgetConstant.WIDGET_SINGLE_LOCK_BRIEF_PROVIDER_NAME)) {
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
                BoxKt.Box(ActionKt.clickable(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), SendBroadcastActionKt.actionSendBroadcast(WidgetSingleGlanceIntent.INSTANCE.intentStartNotePicker(context, i, providerName)), C11391R.drawable.sesl_glance_dim_effect), null, ComposableLambdaKt.rememberComposableLambda(-54698568, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$WidgetEmptyMedium$1
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
                            ComposerKt.traceEventStart(-54698568, i9, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptyMedium.<anonymous> (WidgetSingleGlance.kt:764)");
                        }
                        composer3.startReplaceGroup(-1025715211);
                        if (!Intrinsics.areEqual(providerName, BaseWidgetConstant.WIDGET_SINGLE_LOCK_BRIEF_PROVIDER_NAME)) {
                            GlanceModifier glanceModifierM21505height3ABfNKs = SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), f);
                            final int i10 = i8;
                            BoxKt.Box(glanceModifierM21505height3ABfNKs, null, ComposableLambdaKt.rememberComposableLambda(208070961, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$WidgetEmptyMedium$1.1
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
                                        ComposerKt.traceEventStart(208070961, i11, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptyMedium.<anonymous>.<anonymous> (WidgetSingleGlance.kt:770)");
                                    }
                                    ImageKt.m21259ImageGCr5PR4(ImageKt.ImageProvider(i10), "Empty widget illustrationBg", SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), ContentScale.INSTANCE.m21465getCropAe3V0ko(), null, composer4, 48, 16);
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
                        final Context context2 = context;
                        BoxKt.Box(glanceModifierM21499paddingqDBjuR0, topStart, ComposableLambdaKt.rememberComposableLambda(305055126, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$WidgetEmptyMedium$1.2
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
                                    ComposerKt.traceEventStart(305055126, i11, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptyMedium.<anonymous>.<anonymous> (WidgetSingleGlance.kt:786)");
                                }
                                GlanceModifier glanceModifierM21506size3ABfNKs = SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, floatRef4.element);
                                final Context context3 = context2;
                                BoxKt.Box(glanceModifierM21506size3ABfNKs, null, ComposableLambdaKt.rememberComposableLambda(-502951816, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptyMedium.1.2.1
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
                                            ComposerKt.traceEventStart(-502951816, i12, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptyMedium.<anonymous>.<anonymous>.<anonymous> (WidgetSingleGlance.kt:790)");
                                        }
                                        ImageKt.m21259ImageGCr5PR4(ImageKt.ImageProvider(C11391R.drawable.ic_widget_note_512), context3.getResources().getString(C11391R.string.app_name_simple), SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), ContentScale.INSTANCE.m21465getCropAe3V0ko(), null, composer5, 0, 16);
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
                        final Context context3 = context;
                        final Ref.LongRef longRef3 = longRef;
                        final WidgetSingleGlanceTheme widgetSingleGlanceTheme = themeManager;
                        final Ref.LongRef longRef4 = longRef2;
                        ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21499paddingqDBjuR02, iM21429getBottommnfRV0w, iM21433getStartPGIyAqw, ComposableLambdaKt.rememberComposableLambda(640199598, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$WidgetEmptyMedium$1.3
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer4, Integer num) {
                                invoke(columnScope, composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @Composable
                            public final void invoke(ColumnScope Column, Composer composer4, int i11) {
                                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(640199598, i11, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptyMedium.<anonymous>.<anonymous> (WidgetSingleGlance.kt:807)");
                                }
                                GlanceModifier.Companion companion3 = GlanceModifier.INSTANCE;
                                GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(companion3));
                                final Context context4 = context3;
                                final Ref.LongRef longRef5 = longRef3;
                                final WidgetSingleGlanceTheme widgetSingleGlanceTheme2 = widgetSingleGlanceTheme;
                                BoxKt.Box(glanceModifierWrapContentHeight, null, ComposableLambdaKt.rememberComposableLambda(728400012, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptyMedium.1.3.1
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
                                            ComposerKt.traceEventStart(728400012, i12, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptyMedium.<anonymous>.<anonymous>.<anonymous> (WidgetSingleGlance.kt:812)");
                                        }
                                        TextData textData = new TextData(C11391R.string.widget_welcome_page_title_get_started, (ColorProvider) null, 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32766, (DefaultConstructorMarker) null);
                                        String text = textData.getText();
                                        if (text == null) {
                                            text = context4.getResources().getString(C11391R.string.widget_welcome_page_title_get_started);
                                            Intrinsics.checkNotNullExpressionValue(text, "getString(...)");
                                        }
                                        String str = text;
                                        long j = longRef5.element;
                                        int iM21999getSemiBoldWjrlUT0 = FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0();
                                        FontFamily fontFamily = textData.getFontFamily();
                                        int iM22011getStartROrN78o = TextAlign.INSTANCE.m22011getStartROrN78o();
                                        TextDecoration textDecoration = textData.getTextDecoration();
                                        int textDirection = textData.getTextDirection();
                                        androidx.glance.text.TextKt.Text(str, (GlanceModifier) null, new TextStyle(widgetSingleGlanceTheme2.updateWelcomePageTextColor(), TextUnit.m21151boximpl(j), FontWeight.m21989boximpl(iM21999getSemiBoldWjrlUT0), null, TextAlign.m22000boximpl(iM22011getStartROrN78o), textDecoration, fontFamily, textDirection, false, null, ComplexUnit.f1613DP, 0, null, null, 0, 31496, null), 1, 0.0f, composer5, 27648, 2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer4, 54), composer4, 384, 2);
                                SpacerKt.Spacer(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(companion3), C2256Dp.m20968constructorimpl(1)), composer4, 0, 0);
                                GlanceModifier glanceModifierWrapContentHeight2 = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(companion3));
                                final Context context5 = context3;
                                final Ref.LongRef longRef6 = longRef4;
                                final WidgetSingleGlanceTheme widgetSingleGlanceTheme3 = widgetSingleGlanceTheme;
                                BoxKt.Box(glanceModifierWrapContentHeight2, null, ComposableLambdaKt.rememberComposableLambda(-1251316861, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptyMedium.1.3.2
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
                                            ComposerKt.traceEventStart(-1251316861, i12, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptyMedium.<anonymous>.<anonymous>.<anonymous> (WidgetSingleGlance.kt:841)");
                                        }
                                        TextData textData = new TextData(C11391R.string.tap_to_choose_a_note, (ColorProvider) null, 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32766, (DefaultConstructorMarker) null);
                                        String text = textData.getText();
                                        if (text == null) {
                                            text = context5.getResources().getString(C11391R.string.tap_to_choose_a_note);
                                            Intrinsics.checkNotNullExpressionValue(text, "getString(...)");
                                        }
                                        String str = text;
                                        long j = longRef6.element;
                                        int iM21998getNormalWjrlUT0 = FontWeight.INSTANCE.m21998getNormalWjrlUT0();
                                        FontFamily fontFamily = textData.getFontFamily();
                                        int iM22011getStartROrN78o = TextAlign.INSTANCE.m22011getStartROrN78o();
                                        TextDecoration textDecoration = textData.getTextDecoration();
                                        int textDirection = textData.getTextDirection();
                                        androidx.glance.text.TextKt.Text(str, (GlanceModifier) null, new TextStyle(widgetSingleGlanceTheme3.updateWelcomePageTextColor(), TextUnit.m21151boximpl(j), FontWeight.m21989boximpl(iM21998getNormalWjrlUT0), null, TextAlign.m22000boximpl(iM22011getStartROrN78o), textDecoration, fontFamily, textDirection, false, null, ComplexUnit.f1613DP, 0, null, null, 0, 31496, null), 2, 0.0f, composer5, 27648, 2);
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
                scopeUpdateScopeEndRestartGroup.updateScope(new C6994c(this, context, i, i2, themeManager, providerName, i4, 2));
            }
        }

        @Composable
        public final void WidgetEmptySmall(@NotNull final Context context, int i, @NotNull final WidgetSingleGlanceTheme themeManager, @NotNull String providerName, @Nullable Composer composer, int i2) {
            int i4;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(themeManager, "themeManager");
            Intrinsics.checkNotNullParameter(providerName, "providerName");
            Composer composerStartRestartGroup = composer.startRestartGroup(-1196577100);
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
                    ComposerKt.traceEventStart(-1196577100, i4, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptySmall (WidgetSingleGlance.kt:863)");
                }
                boolean z = ((TemplateState) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalTemplateState())).getIconLabelOn() && ((TemplateState) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalTemplateState())).getWidgetLabelOn();
                final float fM20968constructorimpl = context.getResources().getConfiguration().orientation == 2 ? z ? C2256Dp.m20968constructorimpl(context.getResources().getDimension(C11391R.dimen.widget_glance_small_icon_size_without_title_land)) : C2256Dp.m20968constructorimpl(context.getResources().getDimension(C11391R.dimen.widget_glance_small_icon_size_with_title_land)) : z ? C2256Dp.m20968constructorimpl(context.getResources().getDimension(C11391R.dimen.widget_glance_small_icon_size_with_title)) : C2256Dp.m20968constructorimpl(context.getResources().getDimension(C11391R.dimen.widget_glance_small_icon_size_without_title));
                GlanceModifier glanceModifierClickable = ActionKt.clickable(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), SendBroadcastActionKt.actionSendBroadcast(WidgetSingleGlanceIntent.INSTANCE.intentStartNotePicker(context, i, providerName)), C11391R.drawable.sesl_glance_dim_effect);
                Alignment.Companion companion = Alignment.INSTANCE;
                RowKt.m21502RowlMAjyxE(glanceModifierClickable, companion.m21433getStartPGIyAqw(), companion.m21431getCenterVerticallymnfRV0w(), ComposableLambdaKt.rememberComposableLambda(1842639896, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptySmall.1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                        invoke(rowScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @Composable
                    public final void invoke(RowScope Row, Composer composer2, int i5) {
                        Intrinsics.checkNotNullParameter(Row, "$this$Row");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1842639896, i5, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptySmall.<anonymous> (WidgetSingleGlance.kt:887)");
                        }
                        GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                        float f = 0;
                        float f4 = 8;
                        GlanceModifier glanceModifierM21499paddingqDBjuR0 = PaddingKt.m21499paddingqDBjuR0(SizeModifiersKt.wrapContentSize(companion2), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(6), C2256Dp.m20968constructorimpl(f));
                        Alignment.Companion companion3 = Alignment.INSTANCE;
                        Alignment centerStart = companion3.getCenterStart();
                        final float f5 = fM20968constructorimpl;
                        final Context context2 = context;
                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(787520118, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptySmall.1.1
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
                                    ComposerKt.traceEventStart(787520118, i6, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptySmall.<anonymous>.<anonymous> (WidgetSingleGlance.kt:893)");
                                }
                                GlanceModifier glanceModifierM21506size3ABfNKs = SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, f5);
                                final Context context3 = context2;
                                BoxKt.Box(glanceModifierM21506size3ABfNKs, null, ComposableLambdaKt.rememberComposableLambda(787068632, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptySmall.1.1.1
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
                                            ComposerKt.traceEventStart(787068632, i7, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptySmall.<anonymous>.<anonymous>.<anonymous> (WidgetSingleGlance.kt:897)");
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
                        final WidgetSingleGlanceTheme widgetSingleGlanceTheme = themeManager;
                        BoxKt.Box(glanceModifierM21500paddingqDBjuR0$default, center, ComposableLambdaKt.rememberComposableLambda(855992365, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptySmall.1.2
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
                                    ComposerKt.traceEventStart(855992365, i7, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptySmall.<anonymous>.<anonymous> (WidgetSingleGlance.kt:913)");
                                }
                                GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
                                final Context context4 = context3;
                                final WidgetSingleGlanceTheme widgetSingleGlanceTheme2 = widgetSingleGlanceTheme;
                                BoxKt.Box(glanceModifierWrapContentHeight, null, ComposableLambdaKt.rememberComposableLambda(422114319, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptySmall.1.2.1
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
                                            ComposerKt.traceEventStart(422114319, i8, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetEmptySmall.<anonymous>.<anonymous>.<anonymous> (WidgetSingleGlance.kt:918)");
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
                                        androidx.glance.text.TextKt.Text(str, (GlanceModifier) null, new TextStyle(widgetSingleGlanceTheme2.updateWelcomePageTextColor(), TextUnit.m21151boximpl(sp), FontWeight.m21989boximpl(iM21999getSemiBoldWjrlUT0), fontStyle, TextAlign.m22000boximpl(iM22011getStartROrN78o), textDecoration, fontFamily, textDirection, z2, textShadowStyle, ComplexUnit.f1613DP, 0, null, null, 0, 31496, null), 1, 0.0f, composer4, 27648, 2);
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
                scopeUpdateScopeEndRestartGroup.updateScope(new C6996e(this, context, i, themeManager, providerName, i2, 0));
            }
        }

        @Composable
        public final void WidgetLoading(@NotNull final Context context, @NotNull final WidgetSingleGlanceTheme themeManager, @Nullable Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(themeManager, "themeManager");
            Composer composerStartRestartGroup = composer.startRestartGroup(1035336728);
            if ((i & 6) == 0) {
                i2 = (composerStartRestartGroup.changedInstance(context) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= composerStartRestartGroup.changedInstance(themeManager) ? 32 : 16;
            }
            if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1035336728, i2, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetLoading (WidgetSingleGlance.kt:614)");
                }
                String string = context.getResources().getString(C11391R.string.widget_text_loading);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                final TextData textData = new TextData(string, themeManager.updateBodyTextColor(), 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, string, (RemoteAnimation) null, false, 0, 0, 31740, (DefaultConstructorMarker) null);
                float f = 14;
                BoxKt.Box(PaddingKt.m21497paddingVpY3zN4(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f)), Alignment.INSTANCE.getCenter(), ComposableLambdaKt.rememberComposableLambda(-1167740042, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetLoading.1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @Composable
                    public final void invoke(Composer composer2, int i4) {
                        int i5;
                        if ((i4 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1167740042, i4, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.WidgetLoading.<anonymous> (WidgetSingleGlance.kt:628)");
                        }
                        String text = textData.getText();
                        if (text == null) {
                            text = context.getResources().getString(C11391R.string.widget_text_loading);
                            Intrinsics.checkNotNullExpressionValue(text, "getString(...)");
                        }
                        String str = text;
                        long sp = TextUnitKt.getSp(12.0f);
                        int iM21998getNormalWjrlUT0 = FontWeight.INSTANCE.m21998getNormalWjrlUT0();
                        FontFamily fontFamily = textData.getFontFamily();
                        int iM22011getStartROrN78o = TextAlign.INSTANCE.m22011getStartROrN78o();
                        TextDecoration textDecoration = textData.getTextDecoration();
                        int textDirection = textData.getTextDirection();
                        FontStyle fontStyle = null;
                        boolean z = false;
                        TextShadowStyle textShadowStyle = null;
                        TextStyle textStyle = new TextStyle(themeManager.updateBodyTextColor(), TextUnit.m21151boximpl(sp), FontWeight.m21989boximpl(iM21998getNormalWjrlUT0), fontStyle, TextAlign.m22000boximpl(iM22011getStartROrN78o), textDecoration, fontFamily, textDirection, z, textShadowStyle, ComplexUnit.f1613DP, 0, null, null, 0, 31496, null);
                        int mask = ((AppWidgetSize) composer2.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask();
                        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
                        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4())) {
                            i5 = 1;
                        } else {
                            AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4());
                            i5 = 3;
                        }
                        androidx.glance.text.TextKt.Text(str, (GlanceModifier) null, textStyle, i5, 0.0f, composer2, 24576, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new C6993b(this, context, themeManager, i));
            }
        }

        @Override // androidx.glance.appwidget.GlanceAppWidget
        @NotNull
        public GlanceStateDefinition<Preferences> getStateDefinition() {
            return this.stateDefinition;
        }

        @Composable
        public final void ViewMore(@NotNull final Context context, @NotNull final WidgetSingleGlanceTheme themeManager, @NotNull final Intent openNoteIntent, @Nullable Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(themeManager, "themeManager");
            Intrinsics.checkNotNullParameter(openNoteIntent, "openNoteIntent");
            Composer composerStartRestartGroup = composer.startRestartGroup(191288390);
            if ((i & 6) == 0) {
                i2 = (composerStartRestartGroup.changedInstance(context) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= composerStartRestartGroup.changedInstance(themeManager) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                i2 |= composerStartRestartGroup.changedInstance(openNoteIntent) ? 256 : 128;
            }
            if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(191288390, i2, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ViewMore (WidgetSingleGlance.kt:531)");
                }
                BoxKt.Box(MarginKt.m21310marginqDBjuR0$default(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), 0.0f, C2256Dp.m20968constructorimpl(4), 0.0f, 0.0f, 13, null), Alignment.INSTANCE.getCenter(), ComposableLambdaKt.rememberComposableLambda(453389348, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ViewMore.3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @Composable
                    public final void invoke(Composer composer2, int i4) {
                        if ((i4 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(453389348, i4, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ViewMore.<anonymous> (WidgetSingleGlance.kt:539)");
                        }
                        GlanceModifier glanceModifierClickable = ActionKt.clickable(BackgroundKt.m21250background4WTKRHQ(CornerRadiusKt.m21286cornerRadius3ABfNKs(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.wrapContentWidth(PaddingKt.m21497paddingVpY3zN4(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(12), C2256Dp.m20968constructorimpl(8)))), C2256Dp.m20968constructorimpl(18)), themeManager.m22147updateViewMoreBackgroundColor0d7_KjU()), StartActivityIntentActionKt.actionStartActivity$default(openNoteIntent, null, 2, null), C11391R.drawable.sesl_glance_dim_effect);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        final Context context2 = context;
                        final WidgetSingleGlanceTheme widgetSingleGlanceTheme = themeManager;
                        BoxKt.Box(glanceModifierClickable, center, ComposableLambdaKt.rememberComposableLambda(732235526, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ViewMore.3.1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Composable
                            public final void invoke(Composer composer3, int i5) {
                                if ((i5 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(732235526, i5, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ViewMore.<anonymous>.<anonymous> (WidgetSingleGlance.kt:552)");
                                }
                                String string = context2.getResources().getString(C11391R.string.to_view_more);
                                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                int i6 = 0;
                                TextData textData = new TextData(string, (ColorProvider) null, 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, context2.getResources().getString(C11391R.string.to_view_more), (RemoteAnimation) null, false, i6, 0, 31742, (DefaultConstructorMarker) null);
                                String string2 = context2.getResources().getString(C11391R.string.to_view_more);
                                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                long sp = TextUnitKt.getSp(12.0f);
                                int iM21996getBoldWjrlUT0 = FontWeight.INSTANCE.m21996getBoldWjrlUT0();
                                FontFamily fontFamily = textData.getFontFamily();
                                int iM22007getCenterROrN78o = TextAlign.INSTANCE.m22007getCenterROrN78o();
                                TextDecoration textDecoration = textData.getTextDecoration();
                                int textDirection = textData.getTextDirection();
                                boolean z = false;
                                Object[] objArr = 0 == true ? 1 : 0;
                                Object[] objArr2 = 0 == true ? 1 : 0;
                                androidx.glance.text.TextKt.Text(string2, (GlanceModifier) null, new TextStyle(ColorProviderKt.m22055ColorProvider8_81llA(widgetSingleGlanceTheme.m22146updateTitleTextColor0d7_KjU()), TextUnit.m21151boximpl(sp), FontWeight.m21989boximpl(iM21996getBoldWjrlUT0), objArr, TextAlign.m22000boximpl(iM22007getCenterROrN78o), textDecoration, fontFamily, textDirection, z, objArr2, ComplexUnit.f1613DP, i6, null, null, 0, 31496, null), 1, 0.0f, composer3, 3072, 18);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, (Alignment.$stable << 3) | 384, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new C6936b(this, context, themeManager, openNoteIntent, i, 2));
            }
        }
    }
