package androidx.glance.oneui.template.layout;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.DimenRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import androidx.glance.GlanceId;
import androidx.glance.GlanceTheme;
import androidx.glance.GlanceThemeKt;
import androidx.glance.action.Action;
import androidx.glance.appwidget.AppWidgetId;
import androidx.glance.appwidget.GlanceAppWidgetManager;
import androidx.glance.color.ColorProviders;
import androidx.glance.color.DayNightColorProvider;
import androidx.glance.oneui.common.AppWidgetHostType;
import androidx.glance.oneui.common.AppWidgetManagerKt;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.common.AppWidgetUtilsKt;
import androidx.glance.oneui.common.DeviceTypeUtil;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.oneui.common.appwidgetsize.AppWidgetSizeInfo;
import androidx.glance.oneui.common.appwidgetsize.SpanSize;
import androidx.glance.oneui.template.AppWidgetBackground;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.SettingPreviewUtilsKt;
import androidx.glance.oneui.template.Shape;
import androidx.glance.oneui.template.TemplateCompositor;
import androidx.glance.oneui.template.TemplateState;
import androidx.glance.oneui.template.TitleBarData;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.FixedColorProvider;
import androidx.glance.unit.ResourceColorProvider;
import com.adobe.internal.xmp.XMPConst;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aV\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\f¢\u0006\u0002\b\r2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\b0\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0010\u001ac\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\b0\f¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001ab\u0010\u0011\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00012\b\b\u0002\u0010\u001e\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00012\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\b0\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\"\u001a\u0017\u0010#\u001a\u00020$2\b\b\u0001\u0010%\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010&\u001a\u001b\u0010'\u001a\b\u0012\u0004\u0012\u00020$0(2\u0006\u0010\u001e\u001a\u00020\u0018H\u0003¢\u0006\u0002\u0010)\u001a<\u0010*\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\b0\f¢\u0006\u0002\b\rH\u0003¢\u0006\u0002\u0010+\u001a\u0011\u0010,\u001a\u00020\u0001*\u00020\u001aH\u0001¢\u0006\u0002\u0010-\u001a\u0011\u0010,\u001a\u00020\u0001*\u00020.H\u0003¢\u0006\u0002\u0010/\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "Landroid/content/Context;", "getAppWidgetManager", "(Landroid/content/Context;)Landroid/appwidget/AppWidgetManager;", "TitleBarLayout", "", "titleBar", "Landroidx/glance/oneui/template/TitleBarData;", "subtitleContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "actionContent", "content", "(Landroidx/glance/oneui/template/TitleBarData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TopLevelLayout", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "defaultPreviewSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "previewDescription", "previewBackground", "Landroidx/glance/oneui/template/AppWidgetBackground;", "themeColors", "Landroidx/glance/color/ColorProviders;", "TopLevelLayout-qgZcuA0", "(IILjava/lang/String;Landroidx/glance/oneui/template/AppWidgetBackground;Landroidx/glance/color/ColorProviders;Landroidx/glance/oneui/template/TitleBarData;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "appWidgetDescription", "appWidgetBackground", "onClick", "Landroidx/glance/action/Action;", "appWidgetLabel", "(Ljava/lang/String;Landroidx/glance/oneui/template/AppWidgetBackground;Landroidx/glance/color/ColorProviders;Landroidx/glance/oneui/template/TitleBarData;Landroidx/glance/action/Action;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "dimensionResource", "Landroidx/compose/ui/unit/Dp;", "id", "(ILandroidx/compose/runtime/Composer;I)F", "getCornerRadius", "", "(Landroidx/glance/oneui/template/AppWidgetBackground;Landroidx/compose/runtime/Composer;I)Ljava/util/List;", "glancePreview", "(Ljava/lang/String;Landroidx/glance/oneui/template/AppWidgetBackground;Landroidx/glance/oneui/template/TitleBarData;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "toDebugString", "(Landroidx/glance/color/ColorProviders;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "Landroidx/glance/unit/ColorProvider;", "(Landroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTopLevelLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TopLevelLayout.kt\nandroidx/glance/oneui/template/layout/TopLevelLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,306:1\n74#2:307\n74#2:308\n74#2:309\n74#2:310\n74#2:311\n74#2:312\n74#2:313\n74#2:314\n74#2:315\n74#2:316\n*S KotlinDebug\n*F\n+ 1 TopLevelLayout.kt\nandroidx/glance/oneui/template/layout/TopLevelLayoutKt\n*L\n77#1:307\n82#1:308\n108#1:309\n124#1:310\n153#1:311\n154#1:312\n224#1:313\n227#1:314\n252#1:315\n300#1:316\n*E\n"})
public final class TopLevelLayoutKt {

    @NotNull
    private static final String TAG = "GWT:TopLevelLayout";

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void TitleBarLayout(@NotNull final TitleBarData titleBar, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(titleBar, "titleBar");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-308843192);
        Function2<? super Composer, ? super Integer, Unit> function23 = (i2 & 2) != 0 ? null : function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = (i2 & 4) != 0 ? null : function22;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-308843192, i, -1, "androidx.glance.oneui.template.layout.TitleBarLayout (TopLevelLayout.kt:250)");
        }
        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composerStartRestartGroup.startReplaceableGroup(-1888368937);
            androidx.glance.oneui.template.layout.glance.TopLevelLayoutKt.GlanceTitleBarLayout(titleBar, function23, function24, content, composerStartRestartGroup, (i & 112) | 8 | (i & 896) | (i & 7168));
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1888368844);
            androidx.glance.oneui.template.layout.compose.TopLevelLayoutKt.ComposeTitleBarLayout(titleBar, function23, function24, content, composerStartRestartGroup, (i & 112) | 8 | (i & 896) | (i & 7168));
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function2<? super Composer, ? super Integer, Unit> function25 = function23;
            final Function2<? super Composer, ? super Integer, Unit> function26 = function24;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.TopLevelLayoutKt.TitleBarLayout.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    TopLevelLayoutKt.TitleBarLayout(titleBar, function25, function26, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0132  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TopLevelLayout(@NotNull final String appWidgetDescription, @Nullable AppWidgetBackground appWidgetBackground, @Nullable ColorProviders colorProviders, @Nullable TitleBarData titleBarData, @Nullable Action action, @Nullable String str, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        AppWidgetBackground color;
        ColorProviders colorProviders2;
        int i5;
        int i6;
        int i7;
        String str2;
        final TitleBarData titleBarData2;
        int i8;
        final AppWidgetBackground appWidgetBackground2;
        final ColorProviders colorProviders3;
        final Action action2;
        final String str3;
        ColorProviders monotoneColorProviders;
        ColorProviders colorProviders4;
        final Action action3;
        final TitleBarData titleBarData3;
        final String str4;
        final ColorProviders colorProviders5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        Intrinsics.checkNotNullParameter(appWidgetDescription, "appWidgetDescription");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1653483472);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(appWidgetDescription) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                color = appWidgetBackground;
                int i10 = composerStartRestartGroup.changed(color) ? 32 : 16;
                i4 |= i10;
            } else {
                color = appWidgetBackground;
            }
            i4 |= i10;
        } else {
            color = appWidgetBackground;
        }
        int i11 = i2 & 4;
        if (i11 != 0) {
            i4 |= 384;
        } else {
            if ((i & 896) == 0) {
                colorProviders2 = colorProviders;
                i4 |= composerStartRestartGroup.changed(colorProviders2) ? 256 : 128;
            }
            i5 = i2 & 8;
            if (i5 != 0) {
                i4 |= 1024;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                i4 |= 8192;
            }
            i7 = i2 & 32;
            if (i7 == 0) {
                i4 |= 196608;
            } else {
                if ((458752 & i) == 0) {
                    str2 = str;
                    i4 |= composerStartRestartGroup.changed(str2) ? 131072 : 65536;
                }
                if ((i2 & 64) == 0) {
                    i9 = (3670016 & i) == 0 ? composerStartRestartGroup.changedInstance(content) ? 1048576 : 524288 : 1572864;
                    if ((i2 & 24) != 24 && (2995931 & i4) == 599186 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        titleBarData3 = titleBarData;
                        appWidgetBackground2 = color;
                        colorProviders5 = colorProviders2;
                        str4 = str2;
                        action3 = action;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if ((i2 & 2) != 0) {
                                color = new AppWidgetBackground.Color(null, 1, null);
                                i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                            }
                            if (i11 != 0) {
                                colorProviders2 = null;
                            }
                            titleBarData2 = i5 == 0 ? null : titleBarData;
                            Action action4 = i6 == 0 ? null : action;
                            i8 = i4;
                            appWidgetBackground2 = color;
                            colorProviders3 = colorProviders2;
                            action2 = action4;
                            str3 = i7 == 0 ? null : str2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                            }
                            titleBarData2 = titleBarData;
                            i8 = i4;
                            appWidgetBackground2 = color;
                            colorProviders3 = colorProviders2;
                            str3 = str2;
                            action2 = action;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1653483472, i8, -1, "androidx.glance.oneui.template.layout.TopLevelLayout (TopLevelLayout.kt:75)");
                        }
                        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup2 != null) {
                                scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.TopLevelLayoutKt.TopLevelLayout.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@Nullable Composer composer2, int i12) {
                                        TopLevelLayoutKt.TopLevelLayout(appWidgetDescription, appWidgetBackground2, colorProviders3, titleBarData2, action2, str3, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        ColorProviders colorProviders6 = colorProviders3;
                        if (!AppWidgetStyle.m21578equalsimpl0(((AppWidgetStyle) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetStyle())).getMask(), AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM())) {
                            monotoneColorProviders = ColorProvidersKt.getMonotoneColorProviders();
                        } else if (colorProviders6 == null) {
                            monotoneColorProviders = ColorProvidersKt.getDefaultColorProviders();
                        } else {
                            colorProviders4 = colorProviders6;
                            final Action action5 = action2;
                            final TitleBarData titleBarData4 = titleBarData2;
                            final String str5 = str3;
                            Function2<Composer, Integer, Unit> function2 = new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.TopLevelLayoutKt.TopLevelLayout.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
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
                                public final void invoke(@Nullable Composer composer2, int i12) {
                                    if ((i12 & 11) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1555823257, i12, -1, "androidx.glance.oneui.template.layout.TopLevelLayout.<anonymous> (TopLevelLayout.kt:87)");
                                    }
                                    GlanceLog.Companion companion = GlanceLog.INSTANCE;
                                    boolean z = !Intrinsics.areEqual(appWidgetDescription, "");
                                    AppWidgetBackground appWidgetBackground3 = appWidgetBackground2;
                                    boolean z2 = str5 != null;
                                    companion.m2301i("GlanceTemplate", "appWidgetDescription=" + z + ", appWidgetBackground=" + appWidgetBackground3 + ", appWidgetLabel=" + z2 + ", colors=" + TopLevelLayoutKt.toDebugString(GlanceTheme.INSTANCE.getColors(composer2, GlanceTheme.$stable), composer2, ColorProviders.$stable));
                                    androidx.glance.oneui.template.layout.glance.TopLevelLayoutKt.GlanceTopLevelLayout(appWidgetDescription, appWidgetBackground2, action5, titleBarData4, str5, content, composer2, 4608, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            };
                            action3 = action5;
                            titleBarData3 = titleBarData4;
                            str4 = str5;
                            GlanceThemeKt.GlanceTheme(colorProviders4, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1555823257, true, function2), composerStartRestartGroup, ColorProviders.$stable | 48, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            colorProviders5 = colorProviders6;
                        }
                        colorProviders4 = monotoneColorProviders;
                        final Action action52 = action2;
                        final TitleBarData titleBarData42 = titleBarData2;
                        final String str52 = str3;
                        Function2<Composer, Integer, Unit> function22 = new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.TopLevelLayoutKt.TopLevelLayout.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                            public final void invoke(@Nullable Composer composer2, int i12) {
                                if ((i12 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1555823257, i12, -1, "androidx.glance.oneui.template.layout.TopLevelLayout.<anonymous> (TopLevelLayout.kt:87)");
                                }
                                GlanceLog.Companion companion = GlanceLog.INSTANCE;
                                boolean z = !Intrinsics.areEqual(appWidgetDescription, "");
                                AppWidgetBackground appWidgetBackground3 = appWidgetBackground2;
                                boolean z2 = str52 != null;
                                companion.m2301i("GlanceTemplate", "appWidgetDescription=" + z + ", appWidgetBackground=" + appWidgetBackground3 + ", appWidgetLabel=" + z2 + ", colors=" + TopLevelLayoutKt.toDebugString(GlanceTheme.INSTANCE.getColors(composer2, GlanceTheme.$stable), composer2, ColorProviders.$stable));
                                androidx.glance.oneui.template.layout.glance.TopLevelLayoutKt.GlanceTopLevelLayout(appWidgetDescription, appWidgetBackground2, action52, titleBarData42, str52, content, composer2, 4608, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        };
                        action3 = action52;
                        titleBarData3 = titleBarData42;
                        str4 = str52;
                        GlanceThemeKt.GlanceTheme(colorProviders4, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1555823257, true, function22), composerStartRestartGroup, ColorProviders.$stable | 48, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        colorProviders5 = colorProviders6;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.TopLevelLayoutKt.TopLevelLayout.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer2, int i12) {
                                TopLevelLayoutKt.TopLevelLayout(appWidgetDescription, appWidgetBackground2, colorProviders5, titleBarData3, action3, str4, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= i9;
                if ((i2 & 24) != 24) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i2 & 2) != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (i6 == 0) {
                        }
                        i8 = i4;
                        appWidgetBackground2 = color;
                        colorProviders3 = colorProviders2;
                        action2 = action4;
                        if (i7 == 0) {
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            str2 = str;
            if ((i2 & 64) == 0) {
            }
            i4 |= i9;
            if ((i2 & 24) != 24) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        colorProviders2 = colorProviders;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        i7 = i2 & 32;
        if (i7 == 0) {
        }
        str2 = str;
        if ((i2 & 64) == 0) {
        }
        i4 |= i9;
        if ((i2 & 24) != 24) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0111  */
    @Composable
    @RequiresApi(31)
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: TopLevelLayout-qgZcuA0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21789TopLevelLayoutqgZcuA0(final int i, final int i2, @Nullable String str, @Nullable AppWidgetBackground appWidgetBackground, @Nullable ColorProviders colorProviders, @Nullable TitleBarData titleBarData, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i4, final int i5) {
        int i6;
        String str2;
        AppWidgetBackground color;
        int i7;
        ColorProviders colorProviders2;
        int i8;
        final TitleBarData titleBarData2;
        final String str3;
        final AppWidgetBackground appWidgetBackground2;
        Context context;
        final ColorProviders colorProviders3;
        final TitleBarData titleBarData3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-171501704);
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 14) == 0) {
            i6 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i4 & 112) == 0) {
            i6 |= composerStartRestartGroup.changed(i2) ? 32 : 16;
        }
        int i10 = i5 & 4;
        if (i10 != 0) {
            i6 |= 384;
        } else {
            if ((i4 & 896) == 0) {
                str2 = str;
                i6 |= composerStartRestartGroup.changed(str2) ? 256 : 128;
            }
            if ((i4 & 7168) != 0) {
                if ((i5 & 8) == 0) {
                    color = appWidgetBackground;
                    int i11 = composerStartRestartGroup.changed(color) ? 2048 : 1024;
                    i6 |= i11;
                } else {
                    color = appWidgetBackground;
                }
                i6 |= i11;
            } else {
                color = appWidgetBackground;
            }
            i7 = i5 & 16;
            if (i7 == 0) {
                i6 |= 24576;
            } else {
                if ((57344 & i4) == 0) {
                    colorProviders2 = colorProviders;
                    i6 |= composerStartRestartGroup.changed(colorProviders2) ? 16384 : 8192;
                }
                i8 = i5 & 32;
                if (i8 != 0) {
                    i6 |= 65536;
                }
                if ((i5 & 64) == 0) {
                    i9 = (3670016 & i4) == 0 ? composerStartRestartGroup.changedInstance(content) ? 1048576 : 524288 : 1572864;
                    if (i8 != 32 && (2995931 & i6) == 599186 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        str3 = str2;
                        appWidgetBackground2 = color;
                        colorProviders3 = colorProviders2;
                        titleBarData3 = titleBarData;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i4 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                str2 = null;
                            }
                            if ((i5 & 8) != 0) {
                                i6 &= -7169;
                                color = new AppWidgetBackground.Color(null, 1, null);
                            }
                            if (i7 != 0) {
                                colorProviders2 = null;
                            }
                            if (i8 == 0) {
                                titleBarData2 = null;
                            }
                            str3 = str2;
                            appWidgetBackground2 = color;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-171501704, i6, -1, "androidx.glance.oneui.template.layout.TopLevelLayout (TopLevelLayout.kt:150)");
                            }
                            if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getCompose())) {
                                composerStartRestartGroup.startReplaceableGroup(-1424403474);
                                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-1424403424);
                                context = (Context) composerStartRestartGroup.consume(androidx.glance.CompositionLocalsKt.getLocalContext());
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                            AppWidgetManager appWidgetManager = getAppWidgetManager(context);
                            GlanceAppWidgetManager glanceAppWidgetManager = new GlanceAppWidgetManager(context);
                            final Bundle appWidgetOptions = appWidgetManager.getAppWidgetOptions(i);
                            final int iM21539getBindAppWidgetSizenwmoUQ = AppWidgetManagerKt.m21539getBindAppWidgetSizenwmoUQ(appWidgetManager, i, i2);
                            Map<SpanSize, AppWidgetSizeInfo> mapEmptyMap = (i <= 0 || Build.VERSION.SDK_INT < 36) ? MapsKt.emptyMap() : glanceAppWidgetManager.getAppWidgetSizeInfo(i).getSizeTable();
                            ProvidedValue<GlanceId> providedValueProvides = androidx.glance.CompositionLocalsKt.getLocalGlanceId().provides(new AppWidgetId(i));
                            ProvidableCompositionLocal<Bundle> localAppWidgetOptions = androidx.glance.appwidget.CompositionLocalsKt.getLocalAppWidgetOptions();
                            Intrinsics.checkNotNull(appWidgetOptions);
                            ProvidedValue<Bundle> providedValueProvides2 = localAppWidgetOptions.provides(appWidgetOptions);
                            ProvidableCompositionLocal<AppWidgetSize> localWidgetSize = CompositionLocalsKt.getLocalWidgetSize();
                            AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
                            final ColorProviders colorProviders4 = colorProviders2;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{providedValueProvides, providedValueProvides2, localWidgetSize.provides(AppWidgetSize.m21545boximpl((AppWidgetSize.m21546compareToL2j3NV4(iM21539getBindAppWidgetSizenwmoUQ, companion.m21571getTinyrx25Pp4()) >= 0 || AppWidgetSize.m21546compareToL2j3NV4(iM21539getBindAppWidgetSizenwmoUQ, companion.m21567getExtraLargeLongrx25Pp4()) > 0) ? companion.m21569getMediumrx25Pp4() : iM21539getBindAppWidgetSizenwmoUQ)), CompositionLocalsKt.getLocalWidgetStyle().provides(AppWidgetStyle.m21574boximpl(AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM())), CompositionLocalsKt.getLocalTemplateState().provides(TemplateState.INSTANCE.get(appWidgetOptions)), CompositionLocalsKt.getLocalDeviceType().provides(DeviceTypeUtil.INSTANCE.get(context)), CompositionLocalsKt.getLocalHostType().provides(AppWidgetHostType.m21520boximpl(AppWidgetUtilsKt.extractWidgetHost(appWidgetOptions))), CompositionLocalsKt.getLocalWidgetSizeInfos().provides(mapEmptyMap)}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1482073032, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.TopLevelLayoutKt.TopLevelLayout.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
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
                                public final void invoke(@Nullable Composer composer2, int i12) {
                                    if ((i12 & 11) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1482073032, i12, -1, "androidx.glance.oneui.template.layout.TopLevelLayout.<anonymous> (TopLevelLayout.kt:177)");
                                    }
                                    ColorProviders defaultColorProviders = colorProviders4;
                                    if (defaultColorProviders == null) {
                                        defaultColorProviders = ColorProvidersKt.getDefaultColorProviders();
                                    }
                                    final int i13 = i;
                                    final String str4 = str3;
                                    final AppWidgetBackground appWidgetBackground3 = appWidgetBackground2;
                                    final int i14 = iM21539getBindAppWidgetSizenwmoUQ;
                                    final Bundle bundle = appWidgetOptions;
                                    final TitleBarData titleBarData4 = titleBarData2;
                                    final Function2<Composer, Integer, Unit> function2 = content;
                                    GlanceThemeKt.GlanceTheme(defaultColorProviders, ComposableLambdaKt.composableLambda(composer2, 1457601761, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.TopLevelLayoutKt.TopLevelLayout.4.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
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
                                        public final void invoke(@Nullable Composer composer3, int i15) {
                                            if ((i15 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1457601761, i15, -1, "androidx.glance.oneui.template.layout.TopLevelLayout.<anonymous>.<anonymous> (TopLevelLayout.kt:179)");
                                            }
                                            TemplateState templateState = (TemplateState) composer3.consume(CompositionLocalsKt.getLocalTemplateState());
                                            GlanceLog.Companion companion2 = GlanceLog.INSTANCE;
                                            int i16 = i13;
                                            boolean z = str4 != null;
                                            AppWidgetBackground appWidgetBackground4 = appWidgetBackground3;
                                            String strM21559toStringimpl = AppWidgetSize.m21559toStringimpl(i14);
                                            String debugString = TopLevelLayoutKt.toDebugString(GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable), composer3, ColorProviders.$stable);
                                            boolean iconLabelOn = templateState.getIconLabelOn();
                                            boolean widgetLabelOn = templateState.getWidgetLabelOn();
                                            StringBuilder sbM2226q = AbstractC2821a.m2226q("appWidgetId=", i16, ", previewDescription=", z, ", previewBackground=");
                                            sbM2226q.append(appWidgetBackground4);
                                            sbM2226q.append(", previewSize=");
                                            sbM2226q.append(strM21559toStringimpl);
                                            sbM2226q.append(", colors=");
                                            sbM2226q.append(debugString);
                                            sbM2226q.append(", iconLabelOn=");
                                            sbM2226q.append(iconLabelOn);
                                            sbM2226q.append(", widgetLabelOn=");
                                            sbM2226q.append(widgetLabelOn);
                                            companion2.m2297d(TopLevelLayoutKt.TAG, sbM2226q.toString());
                                            ProvidableCompositionLocal<DpSize> localSize = androidx.glance.CompositionLocalsKt.getLocalSize();
                                            Bundle options = bundle;
                                            Intrinsics.checkNotNullExpressionValue(options, "$options");
                                            ProvidedValue<DpSize> providedValueProvides3 = localSize.provides(DpSize.m21054boximpl(SettingPreviewUtilsKt.m21668estimatePreviewSizeqK15sPk(options, i14, composer3, 8)));
                                            final int i17 = i13;
                                            final int i18 = i14;
                                            final Bundle bundle2 = bundle;
                                            final String str5 = str4;
                                            final AppWidgetBackground appWidgetBackground5 = appWidgetBackground3;
                                            final TitleBarData titleBarData5 = titleBarData4;
                                            final Function2<Composer, Integer, Unit> function22 = function2;
                                            CompositionLocalKt.CompositionLocalProvider(providedValueProvides3, ComposableLambdaKt.composableLambda(composer3, -998957023, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.TopLevelLayoutKt.TopLevelLayout.4.1.1
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
                                                public final void invoke(@Nullable Composer composer4, int i19) {
                                                    int layoutMode;
                                                    if ((i19 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-998957023, i19, -1, "androidx.glance.oneui.template.layout.TopLevelLayout.<anonymous>.<anonymous>.<anonymous> (TopLevelLayout.kt:190)");
                                                    }
                                                    if (Intrinsics.areEqual(composer4.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getCompose())) {
                                                        composer4.startReplaceableGroup(2011981461);
                                                        composer4.startReplaceableGroup(2011981524);
                                                        if (i17 == -1) {
                                                            layoutMode = i18;
                                                        } else {
                                                            Bundle options2 = bundle2;
                                                            Intrinsics.checkNotNullExpressionValue(options2, "$options");
                                                            layoutMode = AppWidgetUtilsKt.getLayoutMode(options2, (Context) composer4.consume(AndroidCompositionLocals_androidKt.getLocalContext()), i17, DpSize.m21066getWidthD9Ej5fM(((DpSize) composer4.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue()), DpSize.m21064getHeightD9Ej5fM(((DpSize) composer4.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue()));
                                                        }
                                                        composer4.endReplaceableGroup();
                                                        ProvidedValue<AppWidgetSize> providedValueProvides4 = CompositionLocalsKt.getLocalWidgetSize().provides(AppWidgetSize.m21545boximpl(layoutMode));
                                                        final String str6 = str5;
                                                        final AppWidgetBackground appWidgetBackground6 = appWidgetBackground5;
                                                        final TitleBarData titleBarData6 = titleBarData5;
                                                        final Function2<Composer, Integer, Unit> function23 = function22;
                                                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides4, ComposableLambdaKt.composableLambda(composer4, -423455578, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.TopLevelLayoutKt.TopLevelLayout.4.1.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                                invoke(composer5, num.intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                                            @Composable
                                                            public final void invoke(@Nullable Composer composer5, int i20) {
                                                                if ((i20 & 11) == 2 && composer5.getSkipping()) {
                                                                    composer5.skipToGroupEnd();
                                                                    return;
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-423455578, i20, -1, "androidx.glance.oneui.template.layout.TopLevelLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TopLevelLayout.kt:201)");
                                                                }
                                                                androidx.glance.oneui.template.layout.compose.TopLevelLayoutKt.ComposeTopLevelLayout(str6, appWidgetBackground6, titleBarData6, function23, composer5, 512);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }), composer4, ProvidedValue.$stable | 48);
                                                        composer4.endReplaceableGroup();
                                                    } else {
                                                        composer4.startReplaceableGroup(2011982267);
                                                        TopLevelLayoutKt.glancePreview(str5, appWidgetBackground5, titleBarData5, function22, composer4, 512);
                                                        composer4.endReplaceableGroup();
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }), composer3, ProvidedValue.$stable | 48);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer2, ColorProviders.$stable | 48, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composerStartRestartGroup, 56);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            colorProviders3 = colorProviders4;
                            titleBarData3 = titleBarData2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i5 & 8) != 0) {
                                i6 &= -7169;
                            }
                        }
                        titleBarData2 = titleBarData;
                        str3 = str2;
                        appWidgetBackground2 = color;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getCompose())) {
                        }
                        AppWidgetManager appWidgetManager2 = getAppWidgetManager(context);
                        GlanceAppWidgetManager glanceAppWidgetManager2 = new GlanceAppWidgetManager(context);
                        final Bundle appWidgetOptions2 = appWidgetManager2.getAppWidgetOptions(i);
                        final int iM21539getBindAppWidgetSizenwmoUQ2 = AppWidgetManagerKt.m21539getBindAppWidgetSizenwmoUQ(appWidgetManager2, i, i2);
                        if (i <= 0) {
                            ProvidedValue<GlanceId> providedValueProvides3 = androidx.glance.CompositionLocalsKt.getLocalGlanceId().provides(new AppWidgetId(i));
                            ProvidableCompositionLocal<Bundle> localAppWidgetOptions2 = androidx.glance.appwidget.CompositionLocalsKt.getLocalAppWidgetOptions();
                            Intrinsics.checkNotNull(appWidgetOptions2);
                            ProvidedValue<Bundle> providedValueProvides22 = localAppWidgetOptions2.provides(appWidgetOptions2);
                            ProvidableCompositionLocal<AppWidgetSize> localWidgetSize2 = CompositionLocalsKt.getLocalWidgetSize();
                            AppWidgetSize.Companion companion2 = AppWidgetSize.INSTANCE;
                            if (AppWidgetSize.m21546compareToL2j3NV4(iM21539getBindAppWidgetSizenwmoUQ2, companion2.m21571getTinyrx25Pp4()) >= 0) {
                                final ColorProviders colorProviders42 = colorProviders2;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{providedValueProvides3, providedValueProvides22, localWidgetSize2.provides(AppWidgetSize.m21545boximpl((AppWidgetSize.m21546compareToL2j3NV4(iM21539getBindAppWidgetSizenwmoUQ2, companion2.m21571getTinyrx25Pp4()) >= 0 || AppWidgetSize.m21546compareToL2j3NV4(iM21539getBindAppWidgetSizenwmoUQ2, companion2.m21567getExtraLargeLongrx25Pp4()) > 0) ? companion2.m21569getMediumrx25Pp4() : iM21539getBindAppWidgetSizenwmoUQ2)), CompositionLocalsKt.getLocalWidgetStyle().provides(AppWidgetStyle.m21574boximpl(AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM())), CompositionLocalsKt.getLocalTemplateState().provides(TemplateState.INSTANCE.get(appWidgetOptions2)), CompositionLocalsKt.getLocalDeviceType().provides(DeviceTypeUtil.INSTANCE.get(context)), CompositionLocalsKt.getLocalHostType().provides(AppWidgetHostType.m21520boximpl(AppWidgetUtilsKt.extractWidgetHost(appWidgetOptions2))), CompositionLocalsKt.getLocalWidgetSizeInfos().provides(mapEmptyMap)}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1482073032, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.TopLevelLayoutKt.TopLevelLayout.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
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
                                    public final void invoke(@Nullable Composer composer2, int i12) {
                                        if ((i12 & 11) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1482073032, i12, -1, "androidx.glance.oneui.template.layout.TopLevelLayout.<anonymous> (TopLevelLayout.kt:177)");
                                        }
                                        ColorProviders defaultColorProviders = colorProviders42;
                                        if (defaultColorProviders == null) {
                                            defaultColorProviders = ColorProvidersKt.getDefaultColorProviders();
                                        }
                                        final int i13 = i;
                                        final String str4 = str3;
                                        final AppWidgetBackground appWidgetBackground3 = appWidgetBackground2;
                                        final int i14 = iM21539getBindAppWidgetSizenwmoUQ2;
                                        final Bundle bundle = appWidgetOptions2;
                                        final TitleBarData titleBarData4 = titleBarData2;
                                        final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                                        GlanceThemeKt.GlanceTheme(defaultColorProviders, ComposableLambdaKt.composableLambda(composer2, 1457601761, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.TopLevelLayoutKt.TopLevelLayout.4.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
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
                                            public final void invoke(@Nullable Composer composer3, int i15) {
                                                if ((i15 & 11) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1457601761, i15, -1, "androidx.glance.oneui.template.layout.TopLevelLayout.<anonymous>.<anonymous> (TopLevelLayout.kt:179)");
                                                }
                                                TemplateState templateState = (TemplateState) composer3.consume(CompositionLocalsKt.getLocalTemplateState());
                                                GlanceLog.Companion companion22 = GlanceLog.INSTANCE;
                                                int i16 = i13;
                                                boolean z = str4 != null;
                                                AppWidgetBackground appWidgetBackground4 = appWidgetBackground3;
                                                String strM21559toStringimpl = AppWidgetSize.m21559toStringimpl(i14);
                                                String debugString = TopLevelLayoutKt.toDebugString(GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable), composer3, ColorProviders.$stable);
                                                boolean iconLabelOn = templateState.getIconLabelOn();
                                                boolean widgetLabelOn = templateState.getWidgetLabelOn();
                                                StringBuilder sbM2226q = AbstractC2821a.m2226q("appWidgetId=", i16, ", previewDescription=", z, ", previewBackground=");
                                                sbM2226q.append(appWidgetBackground4);
                                                sbM2226q.append(", previewSize=");
                                                sbM2226q.append(strM21559toStringimpl);
                                                sbM2226q.append(", colors=");
                                                sbM2226q.append(debugString);
                                                sbM2226q.append(", iconLabelOn=");
                                                sbM2226q.append(iconLabelOn);
                                                sbM2226q.append(", widgetLabelOn=");
                                                sbM2226q.append(widgetLabelOn);
                                                companion22.m2297d(TopLevelLayoutKt.TAG, sbM2226q.toString());
                                                ProvidableCompositionLocal<DpSize> localSize = androidx.glance.CompositionLocalsKt.getLocalSize();
                                                Bundle options = bundle;
                                                Intrinsics.checkNotNullExpressionValue(options, "$options");
                                                ProvidedValue<DpSize> providedValueProvides32 = localSize.provides(DpSize.m21054boximpl(SettingPreviewUtilsKt.m21668estimatePreviewSizeqK15sPk(options, i14, composer3, 8)));
                                                final int i17 = i13;
                                                final int i18 = i14;
                                                final Bundle bundle2 = bundle;
                                                final String str5 = str4;
                                                final AppWidgetBackground appWidgetBackground5 = appWidgetBackground3;
                                                final TitleBarData titleBarData5 = titleBarData4;
                                                final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                                                CompositionLocalKt.CompositionLocalProvider(providedValueProvides32, ComposableLambdaKt.composableLambda(composer3, -998957023, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.TopLevelLayoutKt.TopLevelLayout.4.1.1
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
                                                    public final void invoke(@Nullable Composer composer4, int i19) {
                                                        int layoutMode;
                                                        if ((i19 & 11) == 2 && composer4.getSkipping()) {
                                                            composer4.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-998957023, i19, -1, "androidx.glance.oneui.template.layout.TopLevelLayout.<anonymous>.<anonymous>.<anonymous> (TopLevelLayout.kt:190)");
                                                        }
                                                        if (Intrinsics.areEqual(composer4.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getCompose())) {
                                                            composer4.startReplaceableGroup(2011981461);
                                                            composer4.startReplaceableGroup(2011981524);
                                                            if (i17 == -1) {
                                                                layoutMode = i18;
                                                            } else {
                                                                Bundle options2 = bundle2;
                                                                Intrinsics.checkNotNullExpressionValue(options2, "$options");
                                                                layoutMode = AppWidgetUtilsKt.getLayoutMode(options2, (Context) composer4.consume(AndroidCompositionLocals_androidKt.getLocalContext()), i17, DpSize.m21066getWidthD9Ej5fM(((DpSize) composer4.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue()), DpSize.m21064getHeightD9Ej5fM(((DpSize) composer4.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue()));
                                                            }
                                                            composer4.endReplaceableGroup();
                                                            ProvidedValue<AppWidgetSize> providedValueProvides4 = CompositionLocalsKt.getLocalWidgetSize().provides(AppWidgetSize.m21545boximpl(layoutMode));
                                                            final String str6 = str5;
                                                            final AppWidgetBackground appWidgetBackground6 = appWidgetBackground5;
                                                            final TitleBarData titleBarData6 = titleBarData5;
                                                            final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
                                                            CompositionLocalKt.CompositionLocalProvider(providedValueProvides4, ComposableLambdaKt.composableLambda(composer4, -423455578, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.TopLevelLayoutKt.TopLevelLayout.4.1.1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(2);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function2
                                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                                    invoke(composer5, num.intValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                                                @Composable
                                                                public final void invoke(@Nullable Composer composer5, int i20) {
                                                                    if ((i20 & 11) == 2 && composer5.getSkipping()) {
                                                                        composer5.skipToGroupEnd();
                                                                        return;
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-423455578, i20, -1, "androidx.glance.oneui.template.layout.TopLevelLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TopLevelLayout.kt:201)");
                                                                    }
                                                                    androidx.glance.oneui.template.layout.compose.TopLevelLayoutKt.ComposeTopLevelLayout(str6, appWidgetBackground6, titleBarData6, function23, composer5, 512);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                            }), composer4, ProvidedValue.$stable | 48);
                                                            composer4.endReplaceableGroup();
                                                        } else {
                                                            composer4.startReplaceableGroup(2011982267);
                                                            TopLevelLayoutKt.glancePreview(str5, appWidgetBackground5, titleBarData5, function22, composer4, 512);
                                                            composer4.endReplaceableGroup();
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }), composer3, ProvidedValue.$stable | 48);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer2, ColorProviders.$stable | 48, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composerStartRestartGroup, 56);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                colorProviders3 = colorProviders42;
                                titleBarData3 = titleBarData2;
                            }
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.TopLevelLayoutKt.TopLevelLayout.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer2, int i12) {
                                TopLevelLayoutKt.m21789TopLevelLayoutqgZcuA0(i, i2, str3, appWidgetBackground2, colorProviders3, titleBarData3, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                            }
                        });
                        return;
                    }
                    return;
                }
                i6 |= i9;
                if (i8 != 32) {
                    composerStartRestartGroup.startDefaults();
                    if ((i4 & 1) != 0) {
                        if (i10 != 0) {
                        }
                        if ((i5 & 8) != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 == 0) {
                            titleBarData2 = titleBarData;
                        }
                        str3 = str2;
                        appWidgetBackground2 = color;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getCompose())) {
                        }
                        AppWidgetManager appWidgetManager22 = getAppWidgetManager(context);
                        GlanceAppWidgetManager glanceAppWidgetManager22 = new GlanceAppWidgetManager(context);
                        final Bundle appWidgetOptions22 = appWidgetManager22.getAppWidgetOptions(i);
                        final int iM21539getBindAppWidgetSizenwmoUQ22 = AppWidgetManagerKt.m21539getBindAppWidgetSizenwmoUQ(appWidgetManager22, i, i2);
                        if (i <= 0) {
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            colorProviders2 = colorProviders;
            i8 = i5 & 32;
            if (i8 != 0) {
            }
            if ((i5 & 64) == 0) {
            }
            i6 |= i9;
            if (i8 != 32) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        str2 = str;
        if ((i4 & 7168) != 0) {
        }
        i7 = i5 & 16;
        if (i7 == 0) {
        }
        colorProviders2 = colorProviders;
        i8 = i5 & 32;
        if (i8 != 0) {
        }
        if ((i5 & 64) == 0) {
        }
        i6 |= i9;
        if (i8 != 32) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    @Composable
    private static final float dimensionResource(@DimenRes int i, Composer composer, int i2) {
        composer.startReplaceableGroup(-1993041905);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1993041905, i2, -1, "androidx.glance.oneui.template.layout.dimensionResource (TopLevelLayout.kt:122)");
        }
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(((Context) composer.consume(androidx.glance.CompositionLocalsKt.getLocalContext())).getResources().getDimension(i) / (r5.getResources().getConfiguration().densityDpi / 160.0f));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fM20968constructorimpl;
    }

    private static final AppWidgetManager getAppWidgetManager(Context context) {
        Object systemService = context.getSystemService("appwidget");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.appwidget.AppWidgetManager");
        return (AppWidgetManager) systemService;
    }

    @Composable
    private static final List<C2256Dp> getCornerRadius(AppWidgetBackground appWidgetBackground, Composer composer, int i) {
        composer.startReplaceableGroup(1273147018);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1273147018, i, -1, "androidx.glance.oneui.template.layout.getCornerRadius (TopLevelLayout.kt:106)");
        }
        composer.startReplaceableGroup(-1030135014);
        boolean z = appWidgetBackground.getShape() != Shape.None && SettingPreviewUtilsKt.is2x2((Bundle) composer.consume(androidx.glance.appwidget.CompositionLocalsKt.getLocalAppWidgetOptions()));
        composer.endReplaceableGroup();
        if (z) {
            composer.startReplaceableGroup(-1030134915);
            List<C2256Dp> listListOf = CollectionsKt.listOf((Object[]) new C2256Dp[]{C2256Dp.m20966boximpl(dimensionResource(appWidgetBackground.getShape().getTopLeftRadius(), composer, 0)), C2256Dp.m20966boximpl(dimensionResource(appWidgetBackground.getShape().getTopRightRadius(), composer, 0)), C2256Dp.m20966boximpl(dimensionResource(appWidgetBackground.getShape().getBottomLeftRadius(), composer, 0)), C2256Dp.m20966boximpl(dimensionResource(appWidgetBackground.getShape().getBottomRightRadius(), composer, 0))});
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return listListOf;
        }
        composer.startReplaceableGroup(-1030134573);
        float cornerRadiusSize = androidx.glance.oneui.template.layout.glance.TopLevelLayoutKt.getCornerRadiusSize(composer, 0);
        List<C2256Dp> listListOf2 = CollectionsKt.listOf((Object[]) new C2256Dp[]{C2256Dp.m20966boximpl(cornerRadiusSize), C2256Dp.m20966boximpl(cornerRadiusSize), C2256Dp.m20966boximpl(cornerRadiusSize), C2256Dp.m20966boximpl(cornerRadiusSize)});
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return listListOf2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.compose.ui.UiComposable]]")
    public static final void glancePreview(String str, AppWidgetBackground appWidgetBackground, TitleBarData titleBarData, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        final String str2;
        final AppWidgetBackground appWidgetBackground2;
        final TitleBarData titleBarData2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        Composer composerStartRestartGroup = composer.startRestartGroup(1856113133);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1856113133, i, -1, "androidx.glance.oneui.template.layout.glancePreview (TopLevelLayout.kt:222)");
        }
        final Function2 function23 = (Function2) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositionDelegator());
        if (function23 == null) {
            str2 = str;
            appWidgetBackground2 = appWidgetBackground;
            titleBarData2 = titleBarData;
            function22 = function2;
        } else {
            str2 = str;
            appWidgetBackground2 = appWidgetBackground;
            titleBarData2 = titleBarData;
            function22 = function2;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{CompositionLocalsKt.getLocalCornerRadius().provides(getCornerRadius(appWidgetBackground, composerStartRestartGroup, (i >> 3) & 14)), CompositionLocalsKt.getLocalContainerScale().provides(Float.valueOf(androidx.glance.oneui.template.layout.compose.TopLevelLayoutKt.getContentScale((Bundle) composerStartRestartGroup.consume(androidx.glance.appwidget.CompositionLocalsKt.getLocalAppWidgetOptions()))))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1971082528, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.TopLevelLayoutKt$glancePreview$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                        ComposerKt.traceEventStart(1971082528, i2, -1, "androidx.glance.oneui.template.layout.glancePreview.<anonymous>.<anonymous> (TopLevelLayout.kt:228)");
                    }
                    function23.invoke(composer2, 0);
                    String str3 = str2;
                    if (str3 == null) {
                        str3 = "";
                    }
                    androidx.glance.oneui.template.layout.glance.TopLevelLayoutKt.GlanceTopLevelLayout(str3, appWidgetBackground2, null, titleBarData2, null, function22, composer2, 29056, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, 56);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function2<? super Composer, ? super Integer, Unit> function24 = function22;
            final TitleBarData titleBarData3 = titleBarData2;
            final AppWidgetBackground appWidgetBackground3 = appWidgetBackground2;
            final String str3 = str2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.TopLevelLayoutKt.glancePreview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    TopLevelLayoutKt.glancePreview(str3, appWidgetBackground3, titleBarData3, function24, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Composable
    @NotNull
    public static final String toDebugString(@NotNull ColorProviders colorProviders, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(colorProviders, "<this>");
        composer.startReplaceableGroup(1179041181);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1179041181, i, -1, "androidx.glance.oneui.template.layout.toDebugString (TopLevelLayout.kt:276)");
        }
        String debugString = toDebugString(colorProviders.getPrimary(), composer, 8);
        String debugString2 = toDebugString(colorProviders.getOnPrimary(), composer, 8);
        String debugString3 = toDebugString(colorProviders.getPrimaryContainer(), composer, 8);
        String debugString4 = toDebugString(colorProviders.getOnPrimaryContainer(), composer, 8);
        String debugString5 = toDebugString(colorProviders.getBackground(), composer, 8);
        String debugString6 = toDebugString(colorProviders.getOnBackground(), composer, 8);
        String debugString7 = toDebugString(colorProviders.getSurface(), composer, 8);
        String debugString8 = toDebugString(colorProviders.getOnSurface(), composer, 8);
        String debugString9 = toDebugString(colorProviders.getSurfaceVariant(), composer, 8);
        String debugString10 = toDebugString(colorProviders.getOnSurfaceVariant(), composer, 8);
        String debugString11 = toDebugString(colorProviders.getInverseOnSurface(), composer, 8);
        String debugString12 = toDebugString(colorProviders.getInverseSurface(), composer, 8);
        StringBuilder sbM16m = AbstractC0000a.m16m("ColorProviders(primary=", debugString, ", onPrimary=", debugString2, ", primaryContainer=");
        AbstractC2821a.m2207B(sbM16m, debugString3, ", onPrimaryContainer=", debugString4, ", background=");
        AbstractC2821a.m2207B(sbM16m, debugString5, ", onBackground=", debugString6, ", surface=");
        AbstractC2821a.m2207B(sbM16m, debugString7, ", onSurface=", debugString8, ", surfaceVariant=");
        AbstractC2821a.m2207B(sbM16m, debugString9, ", onSurfaceVariant=", debugString10, ", inverseOnSurface=");
        String strM1626p = AbstractC2322a.m1626p(sbM16m, debugString11, ", inverseSurface=", debugString12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return strM1626p;
    }

    @Composable
    private static final String toDebugString(ColorProvider colorProvider, Composer composer, int i) {
        String strM773o;
        composer.startReplaceableGroup(1153678756);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1153678756, i, -1, "androidx.glance.oneui.template.layout.toDebugString (TopLevelLayout.kt:292)");
        }
        if (colorProvider instanceof FixedColorProvider) {
            strM773o = AbstractC0541b.m773o("[fixedColor=", Integer.toHexString(ColorKt.m18579toArgb8_81llA(((FixedColorProvider) colorProvider).m22060getColor0d7_KjU())), "]");
        } else if (colorProvider instanceof DayNightColorProvider) {
            DayNightColorProvider dayNightColorProvider = (DayNightColorProvider) colorProvider;
            strM773o = AbstractC0541b.m775q("[day=", Integer.toHexString(ColorKt.m18579toArgb8_81llA(dayNightColorProvider.m21424getDay0d7_KjU())), " night=", Integer.toHexString(ColorKt.m18579toArgb8_81llA(dayNightColorProvider.m21425getNight0d7_KjU())), "]");
        } else if (colorProvider instanceof ResourceColorProvider) {
            strM773o = AbstractC0541b.m773o("[resColor=", Integer.toHexString(ColorKt.m18579toArgb8_81llA(colorProvider.mo21422getColorvNxB06k((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())))), "]");
        } else {
            strM773o = XMPConst.ARRAY_ITEM_NAME;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return strM773o;
    }
}
