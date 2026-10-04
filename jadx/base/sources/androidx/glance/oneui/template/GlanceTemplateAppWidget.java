package androidx.glance.oneui.template;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.glance.AbstractC2821a;
import androidx.glance.GlanceComposable;
import androidx.glance.GlanceId;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.GlanceThemeKt;
import androidx.glance.appwidget.AppWidgetId;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.appwidget.GlanceAppWidget;
import androidx.glance.appwidget.GlanceAppWidgetKt;
import androidx.glance.appwidget.GlanceAppWidgetManager;
import androidx.glance.appwidget.SizeMode;
import androidx.glance.appwidget.state.GlanceAppWidgetStateKt;
import androidx.glance.color.ColorProviders;
import androidx.glance.layout.BoxKt;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.oneui.common.AppWidgetHostType;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.common.AppWidgetUtilsKt;
import androidx.glance.oneui.common.DeviceType;
import androidx.glance.oneui.common.DeviceTypeUtil;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.oneui.common.appwidgetsize.AppWidgetSizeInfo;
import androidx.glance.oneui.common.appwidgetsize.SpanSize;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.oneui.template.layout.TopLevelLayoutKt;
import androidx.glance.oneui.template.preview.CachedPreviewAttributes;
import androidx.glance.oneui.template.preview.PreviewContentReceiverKt;
import androidx.glance.oneui.template.preview.PreviewSessionManager;
import androidx.glance.oneui.template.utils.SizeUtilsKt;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b'\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0007\u001a\u00020\bH\u0017¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\bH'¢\u0006\u0002\u0010\tJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0080@¢\u0006\u0004\b\u0013\u0010\u0014J0\u0010\u0015\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0080@¢\u0006\u0004\b\u001b\u0010\u001cJD\u0010\u001d\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00102$\b\u0002\u0010\u001f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\"\u0012\u0006\u0012\u0004\u0018\u00010#0 H\u0086@¢\u0006\u0002\u0010$R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006&"}, m13886d2 = {"Landroidx/glance/oneui/template/GlanceTemplateAppWidget;", "Landroidx/glance/appwidget/GlanceAppWidget;", "()V", "sizeMode", "Landroidx/glance/appwidget/SizeMode;", "getSizeMode", "()Landroidx/glance/appwidget/SizeMode;", "PreviewContent", "", "(Landroidx/compose/runtime/Composer;I)V", "TemplateContent", "provideGlance", "", "context", "Landroid/content/Context;", "id", "Landroidx/glance/GlanceId;", "(Landroid/content/Context;Landroidx/glance/GlanceId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "providePreview", "providePreview$glance_oneui_template_release", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePreview", "receiver", "Ljava/lang/Class;", "Landroidx/glance/oneui/template/GlanceTemplateAppWidgetReceiver;", "widgetAttributes", "Landroidx/glance/oneui/template/preview/CachedPreviewAttributes;", "updatePreview$glance_oneui_template_release", "(Landroid/content/Context;Ljava/lang/Class;Landroidx/glance/oneui/template/preview/CachedPreviewAttributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStateAndWidget", "glanceId", "updateState", "Lkotlin/Function2;", "Landroidx/datastore/preferences/core/MutablePreferences;", "Lkotlin/coroutines/Continuation;", "", "(Landroid/content/Context;Landroidx/glance/GlanceId;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class GlanceTemplateAppWidget extends GlanceAppWidget {

    @NotNull
    private static final String TAG = "GWT:TemplateAppWidget";

    @NotNull
    private final SizeMode sizeMode;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: androidx.glance.oneui.template.GlanceTemplateAppWidget$provideGlance$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.oneui.template.GlanceTemplateAppWidget", m14021f = "GlanceTemplateAppWidget.kt", m14022i = {}, m14023l = {67}, m14024m = "provideGlance", m14025n = {}, m14026s = {})
    public static final class C30831 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C30831(Continuation<? super C30831> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GlanceTemplateAppWidget.this.provideGlance(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.oneui.template.GlanceTemplateAppWidget$updateStateAndWidget$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.oneui.template.GlanceTemplateAppWidget", m14021f = "GlanceTemplateAppWidget.kt", m14022i = {0, 0, 0}, m14023l = {JPEG.RST1, 210}, m14024m = "updateStateAndWidget", m14025n = {"this", "context", "glanceId"}, m14026s = {"L$0", "L$1", "L$2"})
    public static final class C30861 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C30861(Continuation<? super C30861> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GlanceTemplateAppWidget.this.updateStateAndWidget(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.oneui.template.GlanceTemplateAppWidget$updateStateAndWidget$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", LangPackConfigConstants.LANGUAGE_CODE_IT, "Landroidx/datastore/preferences/core/MutablePreferences;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.oneui.template.GlanceTemplateAppWidget$updateStateAndWidget$2", m14021f = "GlanceTemplateAppWidget.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C30872 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
        int label;

        public C30872(Continuation<? super C30872> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C30872(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull MutablePreferences mutablePreferences, @Nullable Continuation<? super Unit> continuation) {
            return ((C30872) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    public GlanceTemplateAppWidget() {
        super(0, 1, null);
        this.sizeMode = SizeMode.Exact.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object updateStateAndWidget$default(GlanceTemplateAppWidget glanceTemplateAppWidget, Context context, GlanceId glanceId, Function2 function2, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateStateAndWidget");
        }
        if ((i & 4) != 0) {
            function2 = new C30872(null);
        }
        return glanceTemplateAppWidget.updateStateAndWidget(context, glanceId, function2, continuation);
    }

    @Composable
    @GlanceComposable
    public void PreviewContent(@Nullable Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1356961278);
        if ((i & 1) == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1356961278, i, -1, "androidx.glance.oneui.template.GlanceTemplateAppWidget.PreviewContent (GlanceTemplateAppWidget.kt:176)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.GlanceTemplateAppWidget.PreviewContent.1
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
                    GlanceTemplateAppWidget.this.PreviewContent(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Composable
    @GlanceComposable
    public abstract void TemplateContent(@Nullable Composer composer, int i);

    @Override // androidx.glance.appwidget.GlanceAppWidget
    @NotNull
    public SizeMode getSizeMode() {
        return this.sizeMode;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.glance.appwidget.GlanceAppWidget
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object provideGlance(@NotNull final Context context, @NotNull GlanceId glanceId, @NotNull Continuation<?> continuation) {
        C30831 c30831;
        if (continuation instanceof C30831) {
            c30831 = (C30831) continuation;
            int i = c30831.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c30831.label = i - Integer.MIN_VALUE;
            } else {
                c30831 = new C30831(continuation);
            }
        }
        Object obj = c30831.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c30831.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ComposableLambda composableLambdaComposableLambdaInstance = ComposableLambdaKt.composableLambdaInstance(-2035785034, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.GlanceTemplateAppWidget.provideGlance.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i4) {
                    int appWidgetId;
                    if ((i4 & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    int appWidgetId2 = -1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2035785034, i4, -1, "androidx.glance.oneui.template.GlanceTemplateAppWidget.provideGlance.<anonymous> (GlanceTemplateAppWidget.kt:67)");
                    }
                    Bundle bundle = (Bundle) composer.consume(androidx.glance.appwidget.CompositionLocalsKt.getLocalAppWidgetOptions());
                    composer.startReplaceableGroup(366575134);
                    if (composer.consume(androidx.glance.CompositionLocalsKt.getLocalGlanceId()) instanceof AppWidgetId) {
                        Object objConsume = composer.consume(androidx.glance.CompositionLocalsKt.getLocalGlanceId());
                        Intrinsics.checkNotNull(objConsume, "null cannot be cast to non-null type androidx.glance.appwidget.AppWidgetId");
                        appWidgetId = ((AppWidgetId) objConsume).getAppWidgetId();
                    } else {
                        appWidgetId = -1;
                    }
                    composer.endReplaceableGroup();
                    Map<SpanSize, AppWidgetSizeInfo> mapEmptyMap = (appWidgetId <= 0 || Build.VERSION.SDK_INT < 36) ? MapsKt.emptyMap() : new GlanceAppWidgetManager((Context) composer.consume(androidx.glance.CompositionLocalsKt.getLocalContext())).getAppWidgetSizeInfo(appWidgetId).getSizeTable();
                    ProvidedValue<DeviceType> providedValueProvides = CompositionLocalsKt.getLocalDeviceType().provides(DeviceTypeUtil.INSTANCE.get(context));
                    ProvidedValue<AppWidgetHostType> providedValueProvides2 = CompositionLocalsKt.getLocalHostType().provides(AppWidgetHostType.m21520boximpl(AppWidgetUtilsKt.extractWidgetHost(bundle)));
                    ProvidableCompositionLocal<AppWidgetSize> localWidgetSize = CompositionLocalsKt.getLocalWidgetSize();
                    Context context2 = (Context) composer.consume(androidx.glance.CompositionLocalsKt.getLocalContext());
                    composer.startReplaceableGroup(366575874);
                    if (composer.consume(androidx.glance.CompositionLocalsKt.getLocalGlanceId()) instanceof AppWidgetId) {
                        Object objConsume2 = composer.consume(androidx.glance.CompositionLocalsKt.getLocalGlanceId());
                        Intrinsics.checkNotNull(objConsume2, "null cannot be cast to non-null type androidx.glance.appwidget.AppWidgetId");
                        appWidgetId2 = ((AppWidgetId) objConsume2).getAppWidgetId();
                    }
                    composer.endReplaceableGroup();
                    ProvidedValue[] providedValueArr = {providedValueProvides, providedValueProvides2, localWidgetSize.provides(AppWidgetSize.m21545boximpl(AppWidgetUtilsKt.getLayoutMode(bundle, context2, appWidgetId2, DpSize.m21066getWidthD9Ej5fM(((DpSize) composer.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue()), DpSize.m21064getHeightD9Ej5fM(((DpSize) composer.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue())))), CompositionLocalsKt.getLocalWidgetStyle().provides(AppWidgetStyle.m21574boximpl(AppWidgetUtilsKt.extractWidgetStyle(bundle))), CompositionLocalsKt.getLocalCompositor().provides(TemplateCompositor.INSTANCE.getGlance()), CompositionLocalsKt.getLocalTemplateState().provides(TemplateState.INSTANCE.get(bundle)), androidx.glance.CompositionLocalsKt.getLocalRealDataPreviewMode().provides(Boolean.FALSE), CompositionLocalsKt.getLocalWidgetSizeInfos().provides(mapEmptyMap)};
                    final Context context3 = context;
                    final GlanceTemplateAppWidget glanceTemplateAppWidget = this;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer, -756471946, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.GlanceTemplateAppWidget.provideGlance.2.1
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
                        public final void invoke(@Nullable Composer composer2, int i5) {
                            if ((i5 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-756471946, i5, -1, "androidx.glance.oneui.template.GlanceTemplateAppWidget.provideGlance.<anonymous>.<anonymous> (GlanceTemplateAppWidget.kt:97)");
                            }
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            final TemplateState templateState = (TemplateState) composer2.consume(CompositionLocalsKt.getLocalTemplateState());
                            if (Build.VERSION.SDK_INT <= 34) {
                                composer2.startReplaceableGroup(895476084);
                                ColorProviders complicationColorProviders = ColorProvidersKt.getComplicationColorProviders();
                                final Context context4 = context3;
                                final GlanceTemplateAppWidget glanceTemplateAppWidget2 = glanceTemplateAppWidget;
                                GlanceThemeKt.GlanceTheme(complicationColorProviders, ComposableLambdaKt.composableLambda(composer2, 1181288250, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.GlanceTemplateAppWidget.provideGlance.2.1.1
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
                                    public final void invoke(@Nullable Composer composer3, int i6) {
                                        if ((i6 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1181288250, i6, -1, "androidx.glance.oneui.template.GlanceTemplateAppWidget.provideGlance.<anonymous>.<anonymous>.<anonymous> (GlanceTemplateAppWidget.kt:102)");
                                        }
                                        GlanceLog.INSTANCE.m2301i(GlanceTemplateAppWidget.TAG, "[common-2.0.14] provideContent: widgetId=" + composer3.consume(androidx.glance.CompositionLocalsKt.getLocalGlanceId()) + ", showShadow=" + templateState.getShowShadow() + ", colors=" + TopLevelLayoutKt.toDebugString(GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable), composer3, ColorProviders.$stable));
                                        ProvidedValue<DpSize> providedValueProvides3 = androidx.glance.CompositionLocalsKt.getLocalSize().provides(DpSize.m21054boximpl(SizeUtilsKt.checkSizeIsNotSet(context4, composer3, 8)));
                                        final GlanceTemplateAppWidget glanceTemplateAppWidget3 = glanceTemplateAppWidget2;
                                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides3, ComposableLambdaKt.composableLambda(composer3, 1213946490, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.GlanceTemplateAppWidget.provideGlance.2.1.1.1
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
                                            public final void invoke(@Nullable Composer composer4, int i7) {
                                                if ((i7 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1213946490, i7, -1, "androidx.glance.oneui.template.GlanceTemplateAppWidget.provideGlance.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GlanceTemplateAppWidget.kt:109)");
                                                }
                                                glanceTemplateAppWidget3.TemplateContent(composer4, 8);
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
                                composer2.endReplaceableGroup();
                            } else {
                                composer2.startReplaceableGroup(895476691);
                                GlanceLog.Companion companion = GlanceLog.INSTANCE;
                                Object objConsume3 = composer2.consume(androidx.glance.CompositionLocalsKt.getLocalGlanceId());
                                String strM21073toStringimpl = DpSize.m21073toStringimpl(((DpSize) composer2.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue());
                                String strM21559toStringimpl = AppWidgetSize.m21559toStringimpl(((AppWidgetSize) composer2.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask());
                                String strM21583toStringimpl = AppWidgetStyle.m21583toStringimpl(((AppWidgetStyle) composer2.consume(CompositionLocalsKt.getLocalWidgetStyle())).getMask());
                                String strM21529toStringimpl = AppWidgetHostType.m21529toStringimpl(((AppWidgetHostType) composer2.consume(CompositionLocalsKt.getLocalHostType())).getMask());
                                boolean iconLabelOn = templateState.getIconLabelOn();
                                boolean widgetLabelOn = templateState.getWidgetLabelOn();
                                Object objConsume4 = composer2.consume(CompositionLocalsKt.getLocalDeviceType());
                                StringBuilder sb = new StringBuilder("[common-2.0.14] provideContent: widgetId=");
                                sb.append(objConsume3);
                                sb.append(", dpsize=");
                                sb.append(strM21073toStringimpl);
                                sb.append(", size=");
                                AbstractC2821a.m2207B(sb, strM21559toStringimpl, ", style=", strM21583toStringimpl, ", host=");
                                sb.append(strM21529toStringimpl);
                                sb.append(", iconLabelOn=");
                                sb.append(iconLabelOn);
                                sb.append(", widgetLabelOn=");
                                sb.append(widgetLabelOn);
                                sb.append(", deviceType=");
                                sb.append(objConsume4);
                                companion.m2301i(GlanceTemplateAppWidget.TAG, sb.toString());
                                ProvidedValue<DpSize> providedValueProvides3 = androidx.glance.CompositionLocalsKt.getLocalSize().provides(DpSize.m21054boximpl(SizeUtilsKt.checkSizeIsNotSet(context3, composer2, 8)));
                                final GlanceTemplateAppWidget glanceTemplateAppWidget3 = glanceTemplateAppWidget;
                                CompositionLocalKt.CompositionLocalProvider(providedValueProvides3, ComposableLambdaKt.composableLambda(composer2, -1082953510, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.GlanceTemplateAppWidget.provideGlance.2.1.2
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
                                    public final void invoke(@Nullable Composer composer3, int i6) {
                                        if ((i6 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1082953510, i6, -1, "androidx.glance.oneui.template.GlanceTemplateAppWidget.provideGlance.<anonymous>.<anonymous>.<anonymous> (GlanceTemplateAppWidget.kt:129)");
                                        }
                                        if (AppWidgetHostType.m21524equalsimpl0(((AppWidgetHostType) composer3.consume(CompositionLocalsKt.getLocalHostType())).getMask(), AppWidgetHostType.INSTANCE.m21537getUnknownmn_SBp8())) {
                                            composer3.startReplaceableGroup(-1809409225);
                                            GlanceModifier glanceModifierCornerRadius = CornerRadiusKt.cornerRadius(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), android.R.dimen.system_app_widget_background_radius);
                                            final GlanceTemplateAppWidget glanceTemplateAppWidget4 = glanceTemplateAppWidget3;
                                            BoxKt.Box(glanceModifierCornerRadius, null, ComposableLambdaKt.composableLambda(composer3, -422494765, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.GlanceTemplateAppWidget.provideGlance.2.1.2.1
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
                                                public final void invoke(@Nullable Composer composer4, int i7) {
                                                    if ((i7 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-422494765, i7, -1, "androidx.glance.oneui.template.GlanceTemplateAppWidget.provideGlance.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GlanceTemplateAppWidget.kt:144)");
                                                    }
                                                    glanceTemplateAppWidget4.TemplateContent(composer4, 8);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }), composer3, 384, 2);
                                            composer3.endReplaceableGroup();
                                        } else {
                                            composer3.startReplaceableGroup(-1809408452);
                                            glanceTemplateAppWidget3.TemplateContent(composer3, 8);
                                            composer3.endReplaceableGroup();
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer2, ProvidedValue.$stable | 48);
                                composer2.endReplaceableGroup();
                            }
                            GlanceLog.INSTANCE.m2301i(GlanceTemplateAppWidget.TAG, "provideGlance " + composer2.consume(androidx.glance.CompositionLocalsKt.getLocalGlanceId()) + " elapsed : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            });
            c30831.label = 1;
            if (GlanceAppWidgetKt.provideContent(this, composableLambdaComposableLambdaInstance, c30831) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object providePreview$glance_oneui_template_release(@NotNull final Context context, @NotNull Continuation<?> continuation) {
        GlanceTemplateAppWidget$providePreview$1 glanceTemplateAppWidget$providePreview$1;
        if (continuation instanceof GlanceTemplateAppWidget$providePreview$1) {
            glanceTemplateAppWidget$providePreview$1 = (GlanceTemplateAppWidget$providePreview$1) continuation;
            int i = glanceTemplateAppWidget$providePreview$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                glanceTemplateAppWidget$providePreview$1.label = i - Integer.MIN_VALUE;
            } else {
                glanceTemplateAppWidget$providePreview$1 = new GlanceTemplateAppWidget$providePreview$1(this, continuation);
            }
        }
        Object obj = glanceTemplateAppWidget$providePreview$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = glanceTemplateAppWidget$providePreview$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ComposableLambda composableLambdaComposableLambdaInstance = ComposableLambdaKt.composableLambdaInstance(333368937, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.GlanceTemplateAppWidget$providePreview$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i4) {
                    if ((i4 & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(333368937, i4, -1, "androidx.glance.oneui.template.GlanceTemplateAppWidget.providePreview.<anonymous> (GlanceTemplateAppWidget.kt:163)");
                    }
                    ProvidedValue[] providedValueArr = {androidx.glance.CompositionLocalsKt.getLocalContext().provides(context), androidx.glance.CompositionLocalsKt.getLocalGlanceId().provides(new AppWidgetId(-1)), CompositionLocalsKt.getLocalCompositor().provides(TemplateCompositor.INSTANCE.getGlance())};
                    final GlanceTemplateAppWidget glanceTemplateAppWidget = this;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer, 236089769, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.GlanceTemplateAppWidget$providePreview$2.1
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
                        public final void invoke(@Nullable Composer composer2, int i5) {
                            if ((i5 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(236089769, i5, -1, "androidx.glance.oneui.template.GlanceTemplateAppWidget.providePreview.<anonymous>.<anonymous> (GlanceTemplateAppWidget.kt:170)");
                            }
                            GlanceLog.INSTANCE.m2301i("GWT:TemplateAppWidget", "[common-2.0.14] providePreview: widgetId=" + composer2.consume(androidx.glance.CompositionLocalsKt.getLocalGlanceId()));
                            glanceTemplateAppWidget.PreviewContent(composer2, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            });
            glanceTemplateAppWidget$providePreview$1.label = 1;
            if (PreviewContentReceiverKt.providePreviewContent(this, composableLambdaComposableLambdaInstance, glanceTemplateAppWidget$providePreview$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Nullable
    public final Object updatePreview$glance_oneui_template_release(@NotNull Context context, @NotNull Class<? extends GlanceTemplateAppWidgetReceiver> cls, @NotNull CachedPreviewAttributes cachedPreviewAttributes, @NotNull Continuation<? super Unit> continuation) {
        GlanceLog.INSTANCE.m2297d(TAG, "updatePreview: " + cls + " / " + cachedPreviewAttributes);
        Object objRunWithLock = PreviewSessionManager.INSTANCE.runWithLock(new GlanceTemplateAppWidget$updatePreview$2(context, this, cls, cachedPreviewAttributes, null), continuation);
        return objRunWithLock == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunWithLock : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0065, code lost:
    
        if (r8.update(r6, r7, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateStateAndWidget(@NotNull Context context, @NotNull GlanceId glanceId, @NotNull Function2<? super MutablePreferences, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        C30861 c30861;
        GlanceTemplateAppWidget glanceTemplateAppWidget;
        if (continuation instanceof C30861) {
            c30861 = (C30861) continuation;
            int i = c30861.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c30861.label = i - Integer.MIN_VALUE;
            } else {
                c30861 = new C30861(continuation);
            }
        }
        Object obj = c30861.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c30861.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c30861.L$0 = this;
            c30861.L$1 = context;
            c30861.L$2 = glanceId;
            c30861.label = 1;
            if (GlanceAppWidgetStateKt.updateAppWidgetState(context, glanceId, function2, c30861) != coroutine_suspended) {
                glanceTemplateAppWidget = this;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        glanceId = (GlanceId) c30861.L$2;
        context = (Context) c30861.L$1;
        glanceTemplateAppWidget = (GlanceTemplateAppWidget) c30861.L$0;
        ResultKt.throwOnFailure(obj);
        c30861.L$0 = null;
        c30861.L$1 = null;
        c30861.L$2 = null;
        c30861.label = 2;
    }
}
