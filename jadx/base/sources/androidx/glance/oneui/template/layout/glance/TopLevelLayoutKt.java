package androidx.glance.oneui.template.layout.glance;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.BackgroundKt;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.ImageKt;
import androidx.glance.action.Action;
import androidx.glance.appwidget.AppWidgetBackgroundKt;
import androidx.glance.appwidget.AppWidgetModifiersKt;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.ContentScale;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.SpacerKt;
import androidx.glance.oneui.common.AppWidgetConstants;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.AppWidgetBackground;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.SettingPreviewUtilsKt;
import androidx.glance.oneui.template.Shape;
import androidx.glance.oneui.template.TemplateState;
import androidx.glance.oneui.template.TitleBarData;
import androidx.glance.oneui.template.component.glance.TitleBarKt;
import androidx.glance.oneui.template.layout.CommonDimensions;
import androidx.glance.oneui.template.utils.Debug;
import androidx.glance.oneui.template.utils.GlanceModifierUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0006\u001aR\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010\u000f\u001aT\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010\u0018\u001a\u001d\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0003¢\u0006\u0002\u0010\u001d\u001a\r\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\u0010 \u001a\u000f\u0010!\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\u0010\"¨\u0006#"}, m13886d2 = {"BackgroundImageView", "", "modifier", "Landroidx/glance/GlanceModifier;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroidx/glance/GlanceModifier;Landroid/graphics/Bitmap;Landroidx/compose/runtime/Composer;I)V", "GlanceTitleBarLayout", "titleBar", "Landroidx/glance/oneui/template/TitleBarData;", "subtitleContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "actionContent", "content", "(Landroidx/glance/oneui/template/TitleBarData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "GlanceTopLevelLayout", "appWidgetDescription", "", "appWidgetBackground", "Landroidx/glance/oneui/template/AppWidgetBackground;", "onClick", "Landroidx/glance/action/Action;", "appWidgetLabel", "(Ljava/lang/String;Landroidx/glance/oneui/template/AppWidgetBackground;Landroidx/glance/action/Action;Landroidx/glance/oneui/template/TitleBarData;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "adjustCornerRadiusIfNeeded", "theModifier", "hasShape", "", "(Landroidx/glance/GlanceModifier;ZLandroidx/compose/runtime/Composer;I)Landroidx/glance/GlanceModifier;", "getCornerRadiusSize", "Landroidx/compose/ui/unit/Dp;", "(Landroidx/compose/runtime/Composer;I)F", "getDebugText", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTopLevelLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TopLevelLayout.kt\nandroidx/glance/oneui/template/layout/glance/TopLevelLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,240:1\n74#2:241\n74#2:242\n74#2:243\n74#2:244\n74#2:245\n74#2:246\n74#2:248\n74#2:249\n154#3:247\n1#4:250\n*S KotlinDebug\n*F\n+ 1 TopLevelLayout.kt\nandroidx/glance/oneui/template/layout/glance/TopLevelLayoutKt\n*L\n62#1:241\n93#1:242\n95#1:243\n96#1:244\n179#1:245\n196#1:246\n204#1:248\n219#1:249\n196#1:247\n*E\n"})
public final class TopLevelLayoutKt {
    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void BackgroundImageView(final GlanceModifier glanceModifier, final Bitmap bitmap, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2042887968);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2042887968, i, -1, "androidx.glance.oneui.template.layout.glance.BackgroundImageView (TopLevelLayout.kt:50)");
        }
        ImageKt.m21259ImageGCr5PR4(ImageKt.ImageProvider(bitmap), "", AppWidgetModifiersKt.tag(glanceModifier, AppWidgetConstants.VIEW_TAG_KEY_BACKGROUND_IMAGE_VIEW, "true"), ContentScale.INSTANCE.m21465getCropAe3V0ko(), null, composerStartRestartGroup, 56, 16);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TopLevelLayoutKt.BackgroundImageView.1
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
                    TopLevelLayoutKt.BackgroundImageView(glanceModifier, bitmap, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable][androidx.glance.GlanceComposable][androidx.glance.GlanceComposable]]")
    public static final void GlanceTitleBarLayout(@NotNull final TitleBarData titleBar, @Nullable final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable final Function2<? super Composer, ? super Integer, Unit> function22, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(titleBar, "titleBar");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1640527330);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1640527330, i, -1, "androidx.glance.oneui.template.layout.glance.GlanceTitleBarLayout (TopLevelLayout.kt:215)");
        }
        ProvidableCompositionLocal<TemplateState> localTemplateState = CompositionLocalsKt.getLocalTemplateState();
        composerStartRestartGroup.startReplaceableGroup(-1172565183);
        TemplateState templateState = (TemplateState) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTemplateState());
        templateState.setHasTitleBar(titleBar.getShowTitleBar(composerStartRestartGroup, 8));
        composerStartRestartGroup.endReplaceableGroup();
        CompositionLocalKt.CompositionLocalProvider(localTemplateState.provides(templateState), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -336582366, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TopLevelLayoutKt.GlanceTitleBarLayout.2
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
                    ComposerKt.traceEventStart(-336582366, i2, -1, "androidx.glance.oneui.template.layout.glance.GlanceTitleBarLayout.<anonymous> (TopLevelLayout.kt:220)");
                }
                if (titleBar.getIsOverlayWithContent()) {
                    composer2.startReplaceableGroup(-1181590333);
                    Debug debug = Debug.INSTANCE;
                    GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                    final Function2<Composer, Integer, Unit> function23 = content;
                    final TitleBarData titleBarData = titleBar;
                    final Function2<Composer, Integer, Unit> function24 = function2;
                    final Function2<Composer, Integer, Unit> function25 = function22;
                    debug.debugBox(glanceModifierFillMaxSize, null, "Title1", false, ComposableLambdaKt.composableLambda(composer2, 416284766, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TopLevelLayoutKt.GlanceTitleBarLayout.2.1
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
                        public final void invoke(@Nullable Composer composer3, int i4) {
                            if ((i4 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(416284766, i4, -1, "androidx.glance.oneui.template.layout.glance.GlanceTitleBarLayout.<anonymous>.<anonymous> (TopLevelLayout.kt:222)");
                            }
                            composer3.startReplaceableGroup(1405549756);
                            if (!AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composer3.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21573getWideSmallrx25Pp4())) {
                                function23.invoke(composer3, 0);
                            }
                            composer3.endReplaceableGroup();
                            TitleBarKt.GlanceContent(titleBarData, function24, function25, composer3, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 221568, 10);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(-1181590039);
                    Debug debug2 = Debug.INSTANCE;
                    GlanceModifier glanceModifierWrapContentSize = SizeModifiersKt.wrapContentSize(GlanceModifier.INSTANCE);
                    final TitleBarData titleBarData2 = titleBar;
                    final Function2<Composer, Integer, Unit> function26 = function2;
                    final Function2<Composer, Integer, Unit> function27 = function22;
                    final Function2<Composer, Integer, Unit> function28 = content;
                    debug2.debugBox(glanceModifierWrapContentSize, null, "Title2", true, ComposableLambdaKt.composableLambda(composer2, 1713499509, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TopLevelLayoutKt.GlanceTitleBarLayout.2.2
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
                        public final void invoke(@Nullable Composer composer3, int i4) {
                            if ((i4 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1713499509, i4, -1, "androidx.glance.oneui.template.layout.glance.GlanceTitleBarLayout.<anonymous>.<anonymous> (TopLevelLayout.kt:229)");
                            }
                            GlanceModifier glanceModifierFillMaxSize2 = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                            final TitleBarData titleBarData3 = titleBarData2;
                            final Function2<Composer, Integer, Unit> function29 = function26;
                            final Function2<Composer, Integer, Unit> function210 = function27;
                            final Function2<Composer, Integer, Unit> function211 = function28;
                            ColumnKt.m21455ColumnK4GKKTE(glanceModifierFillMaxSize2, 0, 0, ComposableLambdaKt.composableLambda(composer3, 1072504895, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TopLevelLayoutKt.GlanceTitleBarLayout.2.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
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
                                public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer4, int i5) {
                                    Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1072504895, i5, -1, "androidx.glance.oneui.template.layout.glance.GlanceTitleBarLayout.<anonymous>.<anonymous>.<anonymous> (TopLevelLayout.kt:230)");
                                    }
                                    TitleBarKt.GlanceContent(titleBarData3, function29, function210, composer4, 8);
                                    if (!AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composer4.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21573getWideSmallrx25Pp4())) {
                                        function211.invoke(composer4, 0);
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
                    }), composer2, 224640, 2);
                    composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TopLevelLayoutKt.GlanceTitleBarLayout.3
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
                    TopLevelLayoutKt.GlanceTitleBarLayout(titleBar, function2, function22, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01a3  */
    /* JADX WARN: Type inference failed for: r14v12, types: [T, androidx.compose.runtime.internal.ComposableLambda] */
    /* JADX WARN: Type inference failed for: r14v14, types: [T, androidx.compose.runtime.internal.ComposableLambda] */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, androidx.compose.runtime.internal.ComposableLambda] */
    /* JADX WARN: Type inference failed for: r4v7, types: [T, androidx.compose.runtime.internal.ComposableLambda] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void GlanceTopLevelLayout(@NotNull final String appWidgetDescription, @NotNull final AppWidgetBackground appWidgetBackground, @Nullable Action action, @Nullable TitleBarData titleBarData, @Nullable String str, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        String str2;
        final String str3;
        final TitleBarData titleBarData2;
        final Action action2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i5;
        Intrinsics.checkNotNullParameter(appWidgetDescription, "appWidgetDescription");
        Intrinsics.checkNotNullParameter(appWidgetBackground, "appWidgetBackground");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1286642473);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = i | (composerStartRestartGroup.changed(appWidgetDescription) ? 4 : 2);
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(appWidgetBackground) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i4 |= 128;
        }
        int i7 = i2 & 8;
        if (i7 != 0) {
            i4 |= 1024;
        }
        int i8 = i2 & 16;
        if (i8 != 0) {
            i4 |= 24576;
        } else {
            if ((i & 57344) == 0) {
                str2 = str;
                i4 |= composerStartRestartGroup.changed(str2) ? 16384 : 8192;
            }
            if ((i2 & 32) != 0) {
                i5 = (i & 458752) == 0 ? composerStartRestartGroup.changedInstance(content) ? 131072 : 65536 : 196608;
                if ((i2 & 12) == 12 && (374491 & i4) == 74898 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    action2 = action;
                    titleBarData2 = titleBarData;
                    str3 = str2;
                } else {
                    Action action3 = i6 == 0 ? null : action;
                    final TitleBarData titleBarData3 = i7 == 0 ? null : titleBarData;
                    String str4 = i8 == 0 ? null : str2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1286642473, i4, -1, "androidx.glance.oneui.template.layout.glance.GlanceTopLevelLayout (TopLevelLayout.kt:75)");
                    }
                    Action action4 = action3;
                    GlanceModifier glanceModifierTag = AppWidgetModifiersKt.tag(SizeModifiersKt.fillMaxSize(AppWidgetBackgroundKt.appWidgetBackground(GlanceModifierUtilsKt.contentDescription(GlanceModifierUtilsKt.maybeClickable$default(GlanceModifier.INSTANCE, action3, false, action3 != null, action3 == null ? C3094R.drawable.sesl_glance_dim_effect : 0, 2, null), appWidgetDescription))), AppWidgetConstants.VIEW_TAG_DYNAMIC_LABEL, str4);
                    composerStartRestartGroup.startReplaceableGroup(-708600264);
                    boolean z = appWidgetBackground.getShape() == Shape.None && (SettingPreviewUtilsKt.is2x2((Bundle) composerStartRestartGroup.consume(androidx.glance.appwidget.CompositionLocalsKt.getLocalAppWidgetOptions())) || (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalPreviewState()) != null && AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4())));
                    composerStartRestartGroup.endReplaceableGroup();
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    composerStartRestartGroup.startReplaceableGroup(-708599867);
                    if (appWidgetBackground instanceof AppWidgetBackground.Color) {
                        if (appWidgetBackground instanceof AppWidgetBackground.Image) {
                            if (z) {
                                objectRef2.element = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 746917632, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TopLevelLayoutKt.GlanceTopLevelLayout.1
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @Composable
                                    public final void invoke(@Nullable Composer composer2, int i9) {
                                        if ((i9 & 11) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(746917632, i9, -1, "androidx.glance.oneui.template.layout.glance.GlanceTopLevelLayout.<anonymous> (TopLevelLayout.kt:117)");
                                        }
                                        ImageKt.m21259ImageGCr5PR4(((AppWidgetBackground.Image) appWidgetBackground).getImageProvider(), "", SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), ((AppWidgetBackground.Image) appWidgetBackground).getContentScale(), null, composer2, 56, 16);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                                glanceModifierTag = AppWidgetModifiersKt.shapeBackground$default(glanceModifierTag, appWidgetBackground.getShape().getResId(), null, 2, null);
                            } else {
                                AppWidgetBackground.Image image = (AppWidgetBackground.Image) appWidgetBackground;
                                glanceModifierTag = AppWidgetModifiersKt.backgroundTint(BackgroundKt.m21252backgroundPLcKuY0$default(glanceModifierTag, image.getImageProvider(), image.getContentScale(), null, 4, null), null);
                            }
                        } else if (appWidgetBackground instanceof AppWidgetBackground.Gradient) {
                            if (z) {
                                objectRef.element = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1477473071, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TopLevelLayoutKt.GlanceTopLevelLayout.2
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @Composable
                                    public final void invoke(@Nullable Composer composer2, int i9) {
                                        if ((i9 & 11) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1477473071, i9, -1, "androidx.glance.oneui.template.layout.glance.GlanceTopLevelLayout.<anonymous> (TopLevelLayout.kt:141)");
                                        }
                                        SpacerKt.Spacer(AppWidgetModifiersKt.shapeBackground$default(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(0)), appWidgetBackground.getShape().getResId(), null, 2, null), composer2, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                            }
                            glanceModifierTag = AppWidgetModifiersKt.shapeBackground$default(glanceModifierTag, ((AppWidgetBackground.Gradient) appWidgetBackground).getResId(), null, 2, null);
                        } else if (appWidgetBackground instanceof AppWidgetBackground.Bitmap) {
                            if (z) {
                                objectRef.element = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1780377648, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TopLevelLayoutKt.GlanceTopLevelLayout.3
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @Composable
                                    public final void invoke(@Nullable Composer composer2, int i9) {
                                        if ((i9 & 11) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1780377648, i9, -1, "androidx.glance.oneui.template.layout.glance.GlanceTopLevelLayout.<anonymous> (TopLevelLayout.kt:156)");
                                        }
                                        SpacerKt.Spacer(AppWidgetModifiersKt.alpha(AppWidgetModifiersKt.shapeBackground$default(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), appWidgetBackground.getShape().getResId(), null, 2, null), 0.0f), composer2, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                            }
                            objectRef2.element = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1503196317, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TopLevelLayoutKt.GlanceTopLevelLayout.4
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @Composable
                                public final void invoke(@Nullable Composer composer2, int i9) {
                                    if ((i9 & 11) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1503196317, i9, -1, "androidx.glance.oneui.template.layout.glance.GlanceTopLevelLayout.<anonymous> (TopLevelLayout.kt:165)");
                                    }
                                    TopLevelLayoutKt.BackgroundImageView(AppWidgetModifiersKt.alpha(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), ((AppWidgetBackground.Bitmap) appWidgetBackground).getAlpha()), ((AppWidgetBackground.Bitmap) appWidgetBackground).getBitmap(), composer2, 64);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            });
                        } else {
                            glanceModifierTag = AppWidgetModifiersKt.backgroundTint(BackgroundKt.m21250background4WTKRHQ(glanceModifierTag, Color.INSTANCE.m18560getTransparent0d7_KjU()), null);
                        }
                    } else if (z) {
                        composerStartRestartGroup.startReplaceableGroup(-708599762);
                        glanceModifierTag = AppWidgetModifiersKt.shapeBackground(glanceModifierTag, appWidgetBackground.getShape().getResId(), GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getBackground());
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-708599504);
                        glanceModifierTag = AppWidgetModifiersKt.backgroundTint(BackgroundKt.background(glanceModifierTag, GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getBackground()), null);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    String str5 = str4;
                    Debug.INSTANCE.debugBox(adjustCornerRadiusIfNeeded(glanceModifierTag, z, composerStartRestartGroup, 0), null, ((Boolean) composerStartRestartGroup.consume(androidx.glance.CompositionLocalsKt.getLocalRealDataPreviewMode())).booleanValue() ? "Real" : null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1777404160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TopLevelLayoutKt.GlanceTopLevelLayout.5
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

                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                        @Composable
                        public final void invoke(@Nullable Composer composer2, int i9) {
                            if ((i9 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1777404160, i9, -1, "androidx.glance.oneui.template.layout.glance.GlanceTopLevelLayout.<anonymous> (TopLevelLayout.kt:181)");
                            }
                            Function2<Composer, Integer, Unit> function2 = objectRef.element;
                            composer2.startReplaceableGroup(1266283373);
                            if (function2 != null) {
                                function2.invoke(composer2, 0);
                                Unit unit = Unit.INSTANCE;
                            }
                            composer2.endReplaceableGroup();
                            Function2<Composer, Integer, Unit> function22 = objectRef2.element;
                            composer2.startReplaceableGroup(1266283418);
                            if (function22 != null) {
                                function22.invoke(composer2, 0);
                                Unit unit2 = Unit.INSTANCE;
                            }
                            composer2.endReplaceableGroup();
                            if (titleBarData3 != null) {
                                composer2.startReplaceableGroup(1266283491);
                                androidx.glance.oneui.template.layout.TopLevelLayoutKt.TitleBarLayout(titleBarData3, null, null, content, composer2, 8, 6);
                                composer2.endReplaceableGroup();
                            } else {
                                composer2.startReplaceableGroup(1266283564);
                                content.invoke(composer2, 0);
                                composer2.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composerStartRestartGroup, 221184, 10);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    TitleBarData titleBarData4 = titleBarData3;
                    str3 = str5;
                    titleBarData2 = titleBarData4;
                    action2 = action4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TopLevelLayoutKt.GlanceTopLevelLayout.6
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

                        public final void invoke(@Nullable Composer composer2, int i9) {
                            TopLevelLayoutKt.GlanceTopLevelLayout(appWidgetDescription, appWidgetBackground, action2, titleBarData2, str3, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= i5;
            if ((i2 & 12) == 12) {
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if (i8 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Action action42 = action3;
                GlanceModifier glanceModifierTag2 = AppWidgetModifiersKt.tag(SizeModifiersKt.fillMaxSize(AppWidgetBackgroundKt.appWidgetBackground(GlanceModifierUtilsKt.contentDescription(GlanceModifierUtilsKt.maybeClickable$default(GlanceModifier.INSTANCE, action3, false, action3 != null, action3 == null ? C3094R.drawable.sesl_glance_dim_effect : 0, 2, null), appWidgetDescription))), AppWidgetConstants.VIEW_TAG_DYNAMIC_LABEL, str4);
                composerStartRestartGroup.startReplaceableGroup(-708600264);
                if (appWidgetBackground.getShape() == Shape.None) {
                    composerStartRestartGroup.endReplaceableGroup();
                    final Ref.ObjectRef<Function2<Composer, Integer, Unit>> objectRef3 = new Ref.ObjectRef();
                    final Ref.ObjectRef<Function2<Composer, Integer, Unit>> objectRef22 = new Ref.ObjectRef();
                    composerStartRestartGroup.startReplaceableGroup(-708599867);
                    if (appWidgetBackground instanceof AppWidgetBackground.Color) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    String str52 = str4;
                    Debug.INSTANCE.debugBox(adjustCornerRadiusIfNeeded(glanceModifierTag2, z, composerStartRestartGroup, 0), null, ((Boolean) composerStartRestartGroup.consume(androidx.glance.CompositionLocalsKt.getLocalRealDataPreviewMode())).booleanValue() ? "Real" : null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1777404160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TopLevelLayoutKt.GlanceTopLevelLayout.5
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

                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                        @Composable
                        public final void invoke(@Nullable Composer composer2, int i9) {
                            if ((i9 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1777404160, i9, -1, "androidx.glance.oneui.template.layout.glance.GlanceTopLevelLayout.<anonymous> (TopLevelLayout.kt:181)");
                            }
                            Function2<Composer, Integer, Unit> function2 = objectRef3.element;
                            composer2.startReplaceableGroup(1266283373);
                            if (function2 != null) {
                                function2.invoke(composer2, 0);
                                Unit unit = Unit.INSTANCE;
                            }
                            composer2.endReplaceableGroup();
                            Function2<Composer, Integer, Unit> function22 = objectRef22.element;
                            composer2.startReplaceableGroup(1266283418);
                            if (function22 != null) {
                                function22.invoke(composer2, 0);
                                Unit unit2 = Unit.INSTANCE;
                            }
                            composer2.endReplaceableGroup();
                            if (titleBarData3 != null) {
                                composer2.startReplaceableGroup(1266283491);
                                androidx.glance.oneui.template.layout.TopLevelLayoutKt.TitleBarLayout(titleBarData3, null, null, content, composer2, 8, 6);
                                composer2.endReplaceableGroup();
                            } else {
                                composer2.startReplaceableGroup(1266283564);
                                content.invoke(composer2, 0);
                                composer2.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composerStartRestartGroup, 221184, 10);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    TitleBarData titleBarData42 = titleBarData3;
                    str3 = str52;
                    titleBarData2 = titleBarData42;
                    action2 = action42;
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        str2 = str;
        if ((i2 & 32) != 0) {
        }
        i4 |= i5;
        if ((i2 & 12) == 12) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    @Composable
    private static final GlanceModifier adjustCornerRadiusIfNeeded(GlanceModifier glanceModifier, boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(-94241734);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-94241734, i, -1, "androidx.glance.oneui.template.layout.glance.adjustCornerRadiusIfNeeded (TopLevelLayout.kt:202)");
        }
        if (composer.consume(CompositionLocalsKt.getLocalCompositionDelegator()) == null || z) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return glanceModifier;
        }
        GlanceModifier glanceModifierM21286cornerRadius3ABfNKs = CornerRadiusKt.m21286cornerRadius3ABfNKs(glanceModifier, getCornerRadiusSize(composer, 0));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierM21286cornerRadius3ABfNKs;
    }

    @Composable
    public static final float getCornerRadiusSize(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-748691364);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-748691364, i, -1, "androidx.glance.oneui.template.layout.glance.getCornerRadiusSize (TopLevelLayout.kt:194)");
        }
        float fM21777getMaxAppWidgetCornerRadiusD9Ej5fM = AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) < 0 ? CommonDimensions.INSTANCE.m21777getMaxAppWidgetCornerRadiusD9Ej5fM() : C2256Dp.m20968constructorimpl(24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fM21777getMaxAppWidgetCornerRadiusD9Ej5fM;
    }

    @Composable
    @Nullable
    public static final String getDebugText(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-215833271);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-215833271, i, -1, "androidx.glance.oneui.template.layout.glance.getDebugText (TopLevelLayout.kt:60)");
        }
        if (((Boolean) composer.consume(androidx.glance.CompositionLocalsKt.getLocalRealDataPreviewMode())).booleanValue()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return "GeneratedPreview";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return null;
    }
}
