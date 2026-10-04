package com.samsung.android.app.notes.widget.glance.single;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.BackgroundKt;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.GlanceModifier;
import androidx.glance.action.ActionKt;
import androidx.glance.appwidget.AndroidRemoteViewsKt;
import androidx.glance.appwidget.MarginKt;
import androidx.glance.appwidget.action.StartActivityIntentActionKt;
import androidx.glance.appwidget.lazy.LazyItemScope;
import androidx.glance.appwidget.lazy.LazyListKt;
import androidx.glance.appwidget.lazy.LazyListScope;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.BoxKt;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.SpacerKt;
import androidx.glance.oneui.common.AppWidgetSize;
import com.samsung.android.app.notes.widget.glance.single.common.WidgetSingleGlanceUtils;
import com.samsung.android.app.notes.widget.glance.single.theme.WidgetSingleGlanceTheme;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetSingleGlance.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetSingleGlance.kt\ncom/samsung/android/app/notes/widget/glance/single/WidgetSingleGlance$ContentWidget$2\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,950:1\n149#2:951\n149#2:952\n149#2:953\n149#2:954\n1225#3,6:955\n*S KotlinDebug\n*F\n+ 1 WidgetSingleGlance.kt\ncom/samsung/android/app/notes/widget/glance/single/WidgetSingleGlance$ContentWidget$2\n*L\n267#1:951\n269#1:952\n271#1:953\n273#1:954\n275#1:955,6\n*E\n"})
public final class WidgetSingleGlance$ContentWidget$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ long $colorDivider;
    final /* synthetic */ Context $context;
    final /* synthetic */ List<Bitmap> $listBitmap;
    final /* synthetic */ MutableState<List<Bitmap>> $listBitmapState$delegate;
    final /* synthetic */ Intent $openNoteIntent;
    final /* synthetic */ WidgetSingleGlanceTheme $themeManager;
    final /* synthetic */ String $title;
    final /* synthetic */ int $widgetSize;
    final /* synthetic */ WidgetSingleGlanceUtils $widgetUtils;
    final /* synthetic */ WidgetSingleGlance this$0;

    public WidgetSingleGlance$ContentWidget$2(int i, String str, MutableState<List<Bitmap>> mutableState, Intent intent, List<Bitmap> list, WidgetSingleGlanceUtils widgetSingleGlanceUtils, long j, WidgetSingleGlance widgetSingleGlance, Context context, WidgetSingleGlanceTheme widgetSingleGlanceTheme) {
        this.$widgetSize = i;
        this.$title = str;
        this.$listBitmapState$delegate = mutableState;
        this.$openNoteIntent = intent;
        this.$listBitmap = list;
        this.$widgetUtils = widgetSingleGlanceUtils;
        this.$colorDivider = j;
        this.this$0 = widgetSingleGlance;
        this.$context = context;
        this.$themeManager = widgetSingleGlanceTheme;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(final MutableState mutableState, final Intent intent, final List list, final WidgetSingleGlanceUtils widgetSingleGlanceUtils, final WidgetSingleGlance widgetSingleGlance, final Context context, final WidgetSingleGlanceTheme widgetSingleGlanceTheme, final long j, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.items$default(LazyColumn, WidgetSingleGlance.ContentWidget_9NJi2jo$lambda$5(mutableState).size(), null, ComposableLambdaKt.composableLambdaInstance(1195087124, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$ContentWidget$2$1$1$1
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            @Composable
            public final void invoke(LazyItemScope items, final int i, Composer composer, int i2) {
                Intrinsics.checkNotNullParameter(items, "$this$items");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1195087124, i2, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ContentWidget.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetSingleGlance.kt:276)");
                }
                float f = 14;
                GlanceModifier glanceModifierClickable = ActionKt.clickable(MarginKt.m21310marginqDBjuR0$default(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(f), 0.0f, C2256Dp.m20968constructorimpl(f), 0.0f, 10, null), StartActivityIntentActionKt.actionStartActivity$default(intent, null, 2, null), true, true);
                final List<Bitmap> list2 = list;
                final Intent intent2 = intent;
                final WidgetSingleGlanceUtils widgetSingleGlanceUtils2 = widgetSingleGlanceUtils;
                final WidgetSingleGlance widgetSingleGlance2 = widgetSingleGlance;
                final Context context2 = context;
                final WidgetSingleGlanceTheme widgetSingleGlanceTheme2 = widgetSingleGlanceTheme;
                final MutableState<List<Bitmap>> mutableState2 = mutableState;
                final long j2 = j;
                ColumnKt.m21455ColumnK4GKKTE(glanceModifierClickable, 0, 0, ComposableLambdaKt.rememberComposableLambda(602161162, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$ContentWidget$2$1$1$1.1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                        invoke(columnScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @Composable
                    public final void invoke(ColumnScope Column, Composer composer2, int i4) {
                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(602161162, i4, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ContentWidget.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetSingleGlance.kt:286)");
                        }
                        final RemoteViews remoteViews = new RemoteViews(((Context) composer2.consume(CompositionLocalsKt.getLocalContext())).getPackageName(), C11391R.layout.widget_item_col_img);
                        int i5 = C11391R.id.content_image;
                        List<Bitmap> list3 = list2;
                        remoteViews.setImageViewBitmap(i5, list3 != null ? list3.get(i) : null);
                        BoxKt.Box(ActionKt.clickable(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), StartActivityIntentActionKt.actionStartActivity$default(intent2, null, 2, null), true, true), Alignment.INSTANCE.getTopCenter(), ComposableLambdaKt.rememberComposableLambda(1377410536, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ContentWidget.2.1.1.1.1.1
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
                                    ComposerKt.traceEventStart(1377410536, i6, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ContentWidget.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetSingleGlance.kt:299)");
                                }
                                AndroidRemoteViewsKt.AndroidRemoteViews(remoteViews, SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), composer3, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, (Alignment.$stable << 3) | 384, 0);
                        composer2.startReplaceGroup(-1143671848);
                        if (widgetSingleGlanceUtils2.getIsAddLine() && i == 0 && WidgetSingleGlance.ContentWidget_9NJi2jo$lambda$5(mutableState2).size() > 1) {
                            final long j3 = j2;
                            BoxKt.Box(null, null, ComposableLambdaKt.rememberComposableLambda(-806332285, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ContentWidget.2.1.1.1.1.2
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
                                        ComposerKt.traceEventStart(-806332285, i6, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ContentWidget.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetSingleGlance.kt:309)");
                                    }
                                    GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                                    float f4 = 1;
                                    SpacerKt.Spacer(BackgroundKt.m21250background4WTKRHQ(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(companion), C2256Dp.m20968constructorimpl(f4)), j3), composer3, 0, 0);
                                    SpacerKt.Spacer(BackgroundKt.m21250background4WTKRHQ(SizeModifiersKt.m21505height3ABfNKs(MarginKt.m21310marginqDBjuR0$default(SizeModifiersKt.fillMaxWidth(companion), 0.0f, C2256Dp.m20968constructorimpl(5), 0.0f, 0.0f, 13, null), C2256Dp.m20968constructorimpl(f4)), j3), composer3, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer2, 54), composer2, 384, 3);
                        }
                        composer2.endReplaceGroup();
                        if (i == WidgetSingleGlance.ContentWidget_9NJi2jo$lambda$5(mutableState2).size() - 1 && widgetSingleGlanceUtils2.getViewMore()) {
                            widgetSingleGlance2.ViewMore(context2, widgetSingleGlanceTheme2, intent2, composer2, 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer, 54), composer, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 2, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(Composer composer, int i) {
        float fM20968constructorimpl;
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(128586524, i, -1, "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance.ContentWidget.<anonymous> (WidgetSingleGlance.kt:260)");
        }
        GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
        int i2 = this.$widgetSize;
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21546compareToL2j3NV4(i2, companion.m21570getSmallrx25Pp4()) <= 0) {
            fM20968constructorimpl = C2256Dp.m20968constructorimpl(7);
        } else {
            String str = this.$title;
            fM20968constructorimpl = (str == null || str.length() == 0) ? C2256Dp.m20968constructorimpl(14) : C2256Dp.m20968constructorimpl(0);
        }
        GlanceModifier glanceModifierM21310marginqDBjuR0$default = MarginKt.m21310marginqDBjuR0$default(glanceModifierWrapContentHeight, 0.0f, fM20968constructorimpl, 0.0f, C2256Dp.m20968constructorimpl(AppWidgetSize.m21546compareToL2j3NV4(this.$widgetSize, companion.m21570getSmallrx25Pp4()) <= 0 ? 7 : 14), 5, null);
        composer.startReplaceGroup(-1224400529);
        boolean zChanged = composer.changed(this.$listBitmapState$delegate) | composer.changedInstance(this.$openNoteIntent) | composer.changedInstance(this.$listBitmap) | composer.changedInstance(this.$widgetUtils) | composer.changed(this.$colorDivider) | composer.changedInstance(this.this$0) | composer.changedInstance(this.$context) | composer.changedInstance(this.$themeManager);
        final MutableState<List<Bitmap>> mutableState = this.$listBitmapState$delegate;
        final Intent intent = this.$openNoteIntent;
        final List<Bitmap> list = this.$listBitmap;
        final WidgetSingleGlanceUtils widgetSingleGlanceUtils = this.$widgetUtils;
        final WidgetSingleGlance widgetSingleGlance = this.this$0;
        final Context context = this.$context;
        final WidgetSingleGlanceTheme widgetSingleGlanceTheme = this.$themeManager;
        final long j = this.$colorDivider;
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Function1 function1 = new Function1() { // from class: com.samsung.android.app.notes.widget.glance.single.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WidgetSingleGlance$ContentWidget$2.invoke$lambda$1$lambda$0(mutableState, intent, list, widgetSingleGlanceUtils, widgetSingleGlance, context, widgetSingleGlanceTheme, j, (LazyListScope) obj);
                }
            };
            composer.updateRememberedValue(function1);
            objRememberedValue = function1;
        }
        composer.endReplaceGroup();
        LazyListKt.m21344LazyColumnEiNPFjs(glanceModifierM21310marginqDBjuR0$default, 0, (Function1) objRememberedValue, composer, 0, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
