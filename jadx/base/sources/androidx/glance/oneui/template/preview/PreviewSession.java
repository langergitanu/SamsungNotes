package androidx.glance.oneui.template.preview;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.ArrayMap;
import android.util.SizeF;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpKt;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.core.view.AbstractC2448b;
import androidx.datastore.preferences.core.Preferences;
import androidx.glance.EmittableWithChildren;
import androidx.glance.appwidget.GlanceAppWidgetManager;
import androidx.glance.appwidget.IgnoreResultKt;
import androidx.glance.appwidget.RemoteViewsRoot;
import androidx.glance.appwidget.multiprocess.CoroutineSession;
import androidx.glance.appwidget.preview.PreviewComposerKt;
import androidx.glance.oneui.common.AppWidgetHostType;
import androidx.glance.oneui.common.AppWidgetManagerKt;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.common.DisplayDeviceType;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.oneui.common.appwidgetsize.AppWidgetSizeInfo;
import androidx.glance.oneui.common.appwidgetsize.HostKey;
import androidx.glance.oneui.common.appwidgetsize.HostSizeInfo;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.GlanceTemplateAppWidget;
import androidx.glance.oneui.template.GlanceTemplateAppWidgetReceiver;
import androidx.glance.oneui.template.TemplateState;
import androidx.glance.oneui.template.utils.SizeUtilsKt;
import androidx.glance.session.Session;
import androidx.glance.state.GlanceState;
import androidx.glance.state.GlanceStateDefinition;
import androidx.glance.state.PreferencesGlanceStateDefinition;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 ?2\u00020\u0001:\u0001?BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\u0010\u0010JB\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001f2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00190!¢\u0006\u0002\b\"H\u0003¢\u0006\u0002\u0010#JB\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&2\u0018\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0(0\u001f2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00190!¢\u0006\u0002\b\"H\u0003¢\u0006\u0002\u0010)J\u001c\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0(2\u0006\u0010+\u001a\u00020\u001cH\u0002J\"\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u0018\u00101\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0080@¢\u0006\u0004\b2\u00103J\b\u00104\u001a\u00020\u0019H\u0016J\u001e\u00105\u001a\u0002062\u0006\u0010%\u001a\u00020&2\u0006\u00107\u001a\u000208H\u0096@¢\u0006\u0002\u00109J%\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u00190!¢\u0006\u0002\b\"¢\u0006\u0002\b;2\u0006\u0010%\u001a\u00020&H\u0016¢\u0006\u0002\u0010<J\u000e\u0010=\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010>R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\fX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\t\u001a\u00020\nX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006@²\u0006\n\u0010A\u001a\u000206X\u008a\u0084\u0002"}, m13886d2 = {"Landroidx/glance/oneui/template/preview/PreviewSession;", "Landroidx/glance/appwidget/multiprocess/CoroutineSession;", "widget", "Landroidx/glance/oneui/template/GlanceTemplateAppWidget;", "receiver", "Ljava/lang/Class;", "Landroidx/glance/oneui/template/GlanceTemplateAppWidgetReceiver;", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "widgetStyle", "Landroidx/glance/oneui/common/AppWidgetStyle;", "hostType", "Landroidx/glance/oneui/common/AppWidgetHostType;", "stateDefinition", "Landroidx/glance/state/GlanceStateDefinition;", "Landroidx/datastore/preferences/core/Preferences;", "(Landroidx/glance/oneui/template/GlanceTemplateAppWidget;Ljava/lang/Class;IIILandroidx/glance/state/GlanceStateDefinition;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "eventSession", "Landroidx/glance/session/Session;", "getEventSession", "()Landroidx/glance/session/Session;", "I", "previewState", "Landroidx/glance/oneui/template/preview/PreviewGlanceState;", "ForEachHost", "", "hostSizeInfos", "", "", "Landroidx/glance/oneui/common/appwidgetsize/HostSizeInfo;", "requestWidgetSize", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/util/Map;Ljava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ForEachSizeAndStyle", "context", "Landroid/content/Context;", "requestStates", "Lkotlin/Pair;", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "convertIntToState", "value", "convertStateToInt", "style", "size", "convertStateToInt-UUrI2l0", "(II)I", "getPreviewGlanceState", "getPreviewGlanceState$glance_oneui_template_release", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosed", "processEmittableTree", "", "root", "Landroidx/glance/EmittableWithChildren;", "(Landroid/content/Context;Landroidx/glance/EmittableWithChildren;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "provideGlance", "Landroidx/glance/GlanceComposable;", "(Landroid/content/Context;)Lkotlin/jvm/functions/Function2;", "snapshotMonitor", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "glance-oneui-template_release", "configIsReady"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPreviewSession.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreviewSession.kt\nandroidx/glance/oneui/template/preview/PreviewSession\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 SparseArray.kt\nandroidx/core/util/SparseArrayKt\n*L\n1#1,299:1\n105#2:300\n82#2,6:301\n106#2,2:307\n92#2:309\n88#2,3:310\n1271#3,2:313\n1285#3,4:315\n1855#3,2:319\n1855#3:321\n766#3:322\n857#3,2:323\n1856#3:325\n1855#3,2:326\n1549#3:332\n1620#3,3:333\n76#4,4:328\n*S KotlinDebug\n*F\n+ 1 PreviewSession.kt\nandroidx/glance/oneui/template/preview/PreviewSession\n*L\n105#1:300\n105#1:301,6\n105#1:307,2\n105#1:309\n105#1:310,3\n119#1:313,2\n119#1:315,4\n182#1:319,2\n211#1:321\n214#1:322\n214#1:323,2\n211#1:325\n253#1:326,2\n271#1:332\n271#1:333,3\n264#1:328,4\n*E\n"})
public final class PreviewSession extends CoroutineSession {

    @NotNull
    public static final String TAG = "GWT:PreviewSession";
    private final int hostType;

    @Nullable
    private PreviewGlanceState previewState;

    @NotNull
    private final Class<? extends GlanceTemplateAppWidgetReceiver> receiver;

    @NotNull
    private final GlanceStateDefinition<Preferences> stateDefinition;

    @NotNull
    private final GlanceTemplateAppWidget widget;
    private final int widgetSize;
    private final int widgetStyle;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: androidx.glance.oneui.template.preview.PreviewSession$processEmittableTree$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.oneui.template.preview.PreviewSession", m14021f = "PreviewSession.kt", m14022i = {0, 0, 0, 0, 1, 1, 1}, m14023l = {253, 271, 280}, m14024m = "processEmittableTree", m14025n = {"this", "manager", "component", "previewsMapping", "this", "manager", "component"}, m14026s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
    public static final class C34791 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C34791(Continuation<? super C34791> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewSession.this.processEmittableTree(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.oneui.template.preview.PreviewSession$snapshotMonitor$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.oneui.template.preview.PreviewSession", m14021f = "PreviewSession.kt", m14022i = {0, 0, 0}, m14023l = {307}, m14024m = "snapshotMonitor", m14025n = {"sent", "observerHandle", "$this$consume$iv$iv"}, m14026s = {"L$0", "L$1", "L$2"})
    public static final class C34811 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C34811(Continuation<? super C34811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewSession.this.snapshotMonitor(this);
        }
    }

    public /* synthetic */ PreviewSession(GlanceTemplateAppWidget glanceTemplateAppWidget, Class cls, int i, int i2, int i4, GlanceStateDefinition glanceStateDefinition, DefaultConstructorMarker defaultConstructorMarker) {
        this(glanceTemplateAppWidget, cls, i, i2, i4, glanceStateDefinition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public final void ForEachHost(final Map<Integer, HostSizeInfo> map, final List<AppWidgetSize> list, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        final int i2;
        final int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1610103517);
        if (ComposerKt.isTraceInProgress()) {
            i2 = i;
            ComposerKt.traceEventStart(1610103517, i2, -1, "androidx.glance.oneui.template.preview.PreviewSession.ForEachHost (PreviewSession.kt:202)");
        } else {
            i2 = i;
        }
        for (Map.Entry<Integer, HostSizeInfo> entry : map.entrySet()) {
            composerStartRestartGroup.startReplaceableGroup(-1803072376);
            int iIntValue = entry.getKey().intValue();
            final HostSizeInfo value = entry.getValue();
            Triple<AppWidgetHostType, DisplayDeviceType, AppWidgetStyle> tripleDecodeHostKey = HostKey.INSTANCE.decodeHostKey(iIntValue);
            if (tripleDecodeHostKey == null) {
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                final int mask = tripleDecodeHostKey.component1().getMask();
                final int mask2 = tripleDecodeHostKey.component2().getMask();
                final int mask3 = tripleDecodeHostKey.component3().getMask();
                List list2 = CollectionsKt.toList(value.getSizeTable().values());
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    int mask4 = ((AppWidgetSize) it.next()).getMask();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list2) {
                        if (AppWidgetSize.m21550equalsimpl0(((AppWidgetSizeInfo) obj).m21618getAppWidgetSizerx25Pp4(), mask4)) {
                            arrayList.add(obj);
                        }
                    }
                    List listSortedWith = CollectionsKt.sortedWith(arrayList, ComparisonsKt.compareBy(new Function1<AppWidgetSizeInfo, Comparable<?>>() { // from class: androidx.glance.oneui.template.preview.PreviewSession$ForEachHost$1$minimumSizeInfo$2
                        @Override // kotlin.jvm.functions.Function1
                        @Nullable
                        public final Comparable<?> invoke(@NotNull AppWidgetSizeInfo it2) {
                            Intrinsics.checkNotNullParameter(it2, "it");
                            return Integer.valueOf(it2.getSpanSize().getCol());
                        }
                    }, new Function1<AppWidgetSizeInfo, Comparable<?>>() { // from class: androidx.glance.oneui.template.preview.PreviewSession$ForEachHost$1$minimumSizeInfo$3
                        @Override // kotlin.jvm.functions.Function1
                        @Nullable
                        public final Comparable<?> invoke(@NotNull AppWidgetSizeInfo it2) {
                            Intrinsics.checkNotNullParameter(it2, "it");
                            return Integer.valueOf(it2.getSpanSize().getRow());
                        }
                    }));
                    AppWidgetSizeInfo appWidgetSizeInfo = listSortedWith != null ? (AppWidgetSizeInfo) CollectionsKt.firstOrNull(listSortedWith) : null;
                    final SizeF dpSize = appWidgetSizeInfo != null ? appWidgetSizeInfo.getDpSize() : null;
                    if (dpSize != null) {
                        i4 = iIntValue;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{CompositionLocalsKt.getLocalWidgetStyle().provides(AppWidgetStyle.m21574boximpl(mask3)), CompositionLocalsKt.getLocalWidgetSize().provides(AppWidgetSize.m21545boximpl(mask4)), CompositionLocalsKt.getLocalHostType().provides(AppWidgetHostType.m21520boximpl(mask)), androidx.glance.appwidget.CompositionLocalsKt.getLocalDensity().provides(Float.valueOf(value.getDensity()))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1172418860, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.preview.PreviewSession$ForEachHost$1$1
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

                            @Composable
                            public final void invoke(@Nullable Composer composer2, int i5) {
                                if ((i5 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1231470928, i5, -1, "androidx.glance.oneui.template.preview.PreviewSession.ForEachHost.<anonymous>.<anonymous> (PreviewSession.kt:225)");
                                }
                                GlanceLog.Companion companion = GlanceLog.INSTANCE;
                                String strM21529toStringimpl = AppWidgetHostType.m21529toStringimpl(mask);
                                String strM21599toStringimpl = DisplayDeviceType.m21599toStringimpl(mask2);
                                String strM21583toStringimpl = AppWidgetStyle.m21583toStringimpl(mask3);
                                SizeF sizeF = dpSize;
                                float density = value.getDensity();
                                StringBuilder sbM16m = AbstractC0000a.m16m("ForEachHost - ", strM21529toStringimpl, " ", strM21599toStringimpl, " ");
                                sbM16m.append(strM21583toStringimpl);
                                sbM16m.append(" ");
                                sbM16m.append(sizeF);
                                sbM16m.append(" ");
                                sbM16m.append(density);
                                companion.m2297d(PreviewSession.TAG, sbM16m.toString());
                                PreviewComposerKt.m21391PreviewSizeBox8HUqYh0(i4, DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(dpSize.getWidth()), C2256Dp.m20968constructorimpl(dpSize.getHeight())), ((Number) composer2.consume(androidx.glance.appwidget.CompositionLocalsKt.getLocalDensity())).floatValue(), function2, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composerStartRestartGroup, 56);
                    } else {
                        i4 = iIntValue;
                    }
                    iIntValue = i4;
                }
                composerStartRestartGroup.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.preview.PreviewSession.ForEachHost.2
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

                public final void invoke(@Nullable Composer composer2, int i5) {
                    PreviewSession.this.ForEachHost(map, list, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public final void ForEachSizeAndStyle(final Context context, final List<Pair<AppWidgetStyle, AppWidgetSize>> list, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        final int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1710750665);
        if (ComposerKt.isTraceInProgress()) {
            i2 = i;
            ComposerKt.traceEventStart(-1710750665, i2, -1, "androidx.glance.oneui.template.preview.PreviewSession.ForEachSizeAndStyle (PreviewSession.kt:180)");
        } else {
            i2 = i;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            final int mask = ((AppWidgetStyle) pair.getFirst()).getMask();
            final int mask2 = ((AppWidgetSize) pair.getSecond()).getMask();
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{CompositionLocalsKt.getLocalWidgetStyle().provides(AppWidgetStyle.m21574boximpl(mask)), CompositionLocalsKt.getLocalWidgetSize().provides(AppWidgetSize.m21545boximpl(mask2))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1126512514, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.preview.PreviewSession$ForEachSizeAndStyle$1$1
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

                @Composable
                public final void invoke(@Nullable Composer composer2, int i4) {
                    if ((i4 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1126512514, i4, -1, "androidx.glance.oneui.template.preview.PreviewSession.ForEachSizeAndStyle.<anonymous>.<anonymous> (PreviewSession.kt:188)");
                    }
                    PreviewComposerKt.m21391PreviewSizeBox8HUqYh0(this.this$0.m21925convertStateToIntUUrI2l0(mask, mask2), SizeUtilsKt.checkSizeIsNotSet(context, composer2, 8), 0.0f, function2, composer2, 0, 4);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.preview.PreviewSession.ForEachSizeAndStyle.2
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
                    PreviewSession.this.ForEachSizeAndStyle(context, list, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    private final Pair<AppWidgetStyle, AppWidgetSize> convertIntToState(int value) {
        int iM21565getAllrx25Pp4 = AppWidgetSize.INSTANCE.m21565getAllrx25Pp4();
        return new Pair<>(AppWidgetStyle.m21574boximpl(AppWidgetStyle.m21575constructorimpl(value >> AppWidgetSize.m21555toArrayListimpl(iM21565getAllrx25Pp4).size())), AppWidgetSize.m21545boximpl(AppWidgetSize.m21547constructorimpl(value & AppWidgetSize.m21557toIntimpl(iM21565getAllrx25Pp4))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: convertStateToInt-UUrI2l0, reason: not valid java name */
    public final int m21925convertStateToIntUUrI2l0(int style, int size) {
        return (AppWidgetStyle.m21582toIntimpl(style) << AppWidgetSize.m21555toArrayListimpl(AppWidgetSize.INSTANCE.m21565getAllrx25Pp4()).size()) | AppWidgetSize.m21557toIntimpl(size);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x009d -> B:21:0x00a1). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getPreviewGlanceState$glance_oneui_template_release(@NotNull Context context, @NotNull Continuation<? super PreviewGlanceState> continuation) throws Throwable {
        PreviewSession$getPreviewGlanceState$1 previewSession$getPreviewGlanceState$1;
        Map linkedHashMap;
        PreviewSession previewSession;
        Iterator it;
        if (continuation instanceof PreviewSession$getPreviewGlanceState$1) {
            previewSession$getPreviewGlanceState$1 = (PreviewSession$getPreviewGlanceState$1) continuation;
            int i = previewSession$getPreviewGlanceState$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                previewSession$getPreviewGlanceState$1.label = i - Integer.MIN_VALUE;
            } else {
                previewSession$getPreviewGlanceState$1 = new PreviewSession$getPreviewGlanceState$1(this, continuation);
            }
        }
        Object obj = previewSession$getPreviewGlanceState$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = previewSession$getPreviewGlanceState$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList<AppWidgetSize> arrayListM21555toArrayListimpl = AppWidgetSize.m21555toArrayListimpl(this.widgetSize);
            linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.m13952k(arrayListM21555toArrayListimpl)), 16));
            previewSession = this;
            it = arrayListM21555toArrayListimpl.iterator();
            if (it.hasNext()) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object obj2 = previewSession$getPreviewGlanceState$1.L$5;
            linkedHashMap = (Map) previewSession$getPreviewGlanceState$1.L$4;
            it = (Iterator) previewSession$getPreviewGlanceState$1.L$3;
            Map map = (LinkedHashMap) previewSession$getPreviewGlanceState$1.L$2;
            Context context2 = (Context) previewSession$getPreviewGlanceState$1.L$1;
            previewSession = (PreviewSession) previewSession$getPreviewGlanceState$1.L$0;
            ResultKt.throwOnFailure(obj);
            linkedHashMap.put(obj2, (Preferences) obj);
            linkedHashMap = map;
            context = context2;
            if (it.hasNext()) {
                Object next = it.next();
                int mask = ((AppWidgetSize) next).getMask();
                GlanceState glanceState = GlanceState.INSTANCE;
                GlanceStateDefinition<Preferences> glanceStateDefinition = previewSession.stateDefinition;
                String strM21928createUniquePreviewNameCZRyut0 = PreviewStateKt.m21928createUniquePreviewNameCZRyut0(previewSession.widget.getClass(), mask);
                previewSession$getPreviewGlanceState$1.L$0 = previewSession;
                previewSession$getPreviewGlanceState$1.L$1 = context;
                previewSession$getPreviewGlanceState$1.L$2 = linkedHashMap;
                previewSession$getPreviewGlanceState$1.L$3 = it;
                previewSession$getPreviewGlanceState$1.L$4 = linkedHashMap;
                previewSession$getPreviewGlanceState$1.L$5 = next;
                previewSession$getPreviewGlanceState$1.label = 1;
                Object value = glanceState.getValue(context, glanceStateDefinition, strM21928createUniquePreviewNameCZRyut0, previewSession$getPreviewGlanceState$1);
                if (value == coroutine_suspended) {
                    return coroutine_suspended;
                }
                context2 = context;
                obj2 = next;
                obj = value;
                map = linkedHashMap;
                linkedHashMap.put(obj2, (Preferences) obj);
                linkedHashMap = map;
                context = context2;
                if (it.hasNext()) {
                    return new PreviewGlanceState(MapsKt.toMutableMap(linkedHashMap));
                }
            }
        }
    }

    @Override // androidx.glance.appwidget.multiprocess.CoroutineSession, androidx.glance.session.Session
    public void onClosed() {
        super.onClosed();
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0207, code lost:
    
        if (r9.sendEvent(r1, r4) == r5) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012e A[LOOP:2: B:46:0x012c->B:47:0x012e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a3 A[LOOP:0: B:54:0x019d->B:56:0x01a3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @Override // androidx.glance.session.Session
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object processEmittableTree(@NotNull Context context, @NotNull EmittableWithChildren emittableWithChildren, @NotNull Continuation<? super Boolean> continuation) {
        C34791 c34791;
        boolean z;
        AppWidgetManager appWidgetManager;
        ComponentName componentName;
        PreviewSession previewSession;
        ComponentName componentName2;
        AppWidgetManager appWidgetManager2;
        SparseArray sparseArray;
        PreviewSession previewSession2;
        int size;
        int i;
        if (continuation instanceof C34791) {
            c34791 = (C34791) continuation;
            int i2 = c34791.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c34791.label = i2 - Integer.MIN_VALUE;
            } else {
                c34791 = new C34791(continuation);
            }
        }
        Object obj = c34791.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c34791.label;
        int i5 = 0;
        boolean z2 = true;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            if (IgnoreResultKt.shouldIgnoreResult(emittableWithChildren) || this.receiver == null) {
                return Boxing.boxBoolean(false);
            }
            Intrinsics.checkNotNull(emittableWithChildren, "null cannot be cast to non-null type androidx.glance.appwidget.RemoteViewsRoot");
            RemoteViewsRoot remoteViewsRoot = (RemoteViewsRoot) emittableWithChildren;
            AppWidgetManager appWidgetManager3 = AppWidgetManager.getInstance(context);
            AppWidgetProviderInfo appWidgetProviderInfoFindProviderInfoFromAllReceiver = PreviewUtilsKt.findProviderInfoFromAllReceiver(context, this.receiver);
            ComponentName componentName3 = appWidgetProviderInfoFindProviderInfoFromAllReceiver != null ? appWidgetProviderInfoFindProviderInfoFromAllReceiver.provider : null;
            if (componentName3 == null) {
                return Boxing.boxBoolean(false);
            }
            Intrinsics.checkNotNull(appWidgetManager3);
            if (!AppWidgetManagerKt.isSupportPreviewForHost(appWidgetManager3) || Build.VERSION.SDK_INT < 36) {
                z = true;
                Class<? extends GlanceTemplateAppWidgetReceiver> cls = this.receiver;
                c34791.L$0 = this;
                c34791.L$1 = appWidgetManager3;
                c34791.L$2 = componentName3;
                c34791.label = 2;
                Object objTranslatePreview = PreviewComposerKt.translatePreview(context, remoteViewsRoot, cls, c34791);
                if (objTranslatePreview != coroutine_suspended) {
                    appWidgetManager = appWidgetManager3;
                    obj = objTranslatePreview;
                    componentName = componentName3;
                    previewSession = this;
                    Iterable<Triple> iterable = (Iterable) obj;
                    ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(iterable));
                    while (r3.hasNext()) {
                    }
                    GlanceLog.INSTANCE.m2301i(TAG, "Generated previews : " + arrayList);
                    Intrinsics.checkNotNull(appWidgetManager);
                    AppWidgetManagerKt.setTemplatePreview(appWidgetManager, componentName, arrayList);
                    PreviewSessionManagerKt.getLatestSessionStates().put(previewSession.getKey(), previewSession.previewState);
                    previewSession2 = previewSession;
                }
            } else {
                SparseArray sparseArray2 = new SparseArray();
                Class<? extends GlanceTemplateAppWidgetReceiver> cls2 = this.receiver;
                c34791.L$0 = this;
                c34791.L$1 = appWidgetManager3;
                c34791.L$2 = componentName3;
                c34791.L$3 = sparseArray2;
                c34791.label = 1;
                Object objTranslatePreview2 = PreviewComposerKt.translatePreview(context, remoteViewsRoot, cls2, c34791);
                if (objTranslatePreview2 != coroutine_suspended) {
                    componentName2 = componentName3;
                    appWidgetManager2 = appWidgetManager3;
                    obj = objTranslatePreview2;
                    sparseArray = sparseArray2;
                    previewSession2 = this;
                    while (r3.hasNext()) {
                    }
                    int i6 = i5;
                    z = z2;
                    SparseArray sparseArray3 = new SparseArray();
                    size = sparseArray.size();
                    i = i6;
                    while (i < size) {
                    }
                    Intrinsics.checkNotNull(appWidgetManager2);
                    AppWidgetManagerKt.setWidgetPreviewForHost(appWidgetManager2, componentName2, sparseArray3);
                }
            }
            return coroutine_suspended;
        }
        if (i4 == 1) {
            sparseArray = (SparseArray) c34791.L$3;
            componentName2 = (ComponentName) c34791.L$2;
            appWidgetManager2 = (AppWidgetManager) c34791.L$1;
            previewSession2 = (PreviewSession) c34791.L$0;
            ResultKt.throwOnFailure(obj);
            for (Triple triple : (Iterable) obj) {
                int iIntValue = ((Number) triple.component1()).intValue();
                RemoteViews remoteViews = (RemoteViews) triple.component2();
                long packedValue = ((DpSize) triple.component3()).getPackedValue();
                int i7 = i5;
                boolean z3 = z2;
                SizeF sizeF = new SizeF(DpSize.m21066getWidthD9Ej5fM(packedValue), DpSize.m21064getHeightD9Ej5fM(packedValue));
                ArrayMap arrayMap = (ArrayMap) sparseArray.get(iIntValue);
                if (arrayMap == null) {
                    arrayMap = new ArrayMap();
                    sparseArray.put(iIntValue, arrayMap);
                }
                arrayMap.put(sizeF, remoteViews);
                i5 = i7;
                z2 = z3;
            }
            int i62 = i5;
            z = z2;
            SparseArray sparseArray32 = new SparseArray();
            size = sparseArray.size();
            i = i62;
            while (i < size) {
                int iKeyAt = sparseArray.keyAt(i);
                ArrayMap arrayMap2 = (ArrayMap) sparseArray.valueAt(i);
                GlanceLog.INSTANCE.m2297d(TAG, "Put " + previewSession2.receiver + " preview-" + iKeyAt + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + arrayMap2);
                sparseArray32.put(iKeyAt, AbstractC2448b.m1846m(arrayMap2));
                i++;
                sparseArray = sparseArray;
            }
            Intrinsics.checkNotNull(appWidgetManager2);
            AppWidgetManagerKt.setWidgetPreviewForHost(appWidgetManager2, componentName2, sparseArray32);
        } else {
            if (i4 != 2) {
                if (i4 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                z = true;
                return Boxing.boxBoolean(z);
            }
            componentName = (ComponentName) c34791.L$2;
            appWidgetManager = (AppWidgetManager) c34791.L$1;
            previewSession = (PreviewSession) c34791.L$0;
            ResultKt.throwOnFailure(obj);
            z = true;
            Iterable<Triple> iterable2 = (Iterable) obj;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(iterable2));
            for (Triple triple2 : iterable2) {
                Pair<AppWidgetStyle, AppWidgetSize> pairConvertIntToState = previewSession.convertIntToState(((Number) triple2.getFirst()).intValue());
                arrayList2.add(new Triple(pairConvertIntToState.getSecond(), pairConvertIntToState.getFirst(), (RemoteViews) triple2.getSecond()));
            }
            GlanceLog.INSTANCE.m2301i(TAG, "Generated previews : " + arrayList2);
            Intrinsics.checkNotNull(appWidgetManager);
            AppWidgetManagerKt.setTemplatePreview(appWidgetManager, componentName, arrayList2);
            PreviewSessionManagerKt.getLatestSessionStates().put(previewSession.getKey(), previewSession.previewState);
            previewSession2 = previewSession;
        }
        CoroutineSession.CancelCoroutine cancelCoroutine = CoroutineSession.CancelCoroutine.INSTANCE;
        c34791.L$0 = null;
        c34791.L$1 = null;
        c34791.L$2 = null;
        c34791.L$3 = null;
        c34791.label = 3;
    }

    public /* bridge */ /* synthetic */ Function0 provideGlance(Context context) {
        return (Function0) mo21926provideGlance(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007f A[Catch: all -> 0x003f, TryCatch #2 {all -> 0x003f, blocks: (B:12:0x003b, B:23:0x0077, B:25:0x007f, B:20:0x0066, B:26:0x008e, B:19:0x0061), top: B:40:0x0027, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008e A[Catch: all -> 0x003f, TRY_LEAVE, TryCatch #2 {all -> 0x003f, blocks: (B:12:0x003b, B:23:0x0077, B:25:0x007f, B:20:0x0066, B:26:0x008e, B:19:0x0061), top: B:40:0x0027, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0074 -> B:23:0x0077). Please report as a decompilation issue!!! */
    @Override // androidx.glance.appwidget.multiprocess.CoroutineSession
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object snapshotMonitor(@NotNull Continuation<? super Unit> continuation) {
        C34811 c34811;
        ObserverHandle observerHandleRegisterGlobalWriteObserver;
        ChannelIterator it;
        AtomicBoolean atomicBoolean;
        ReceiveChannel receiveChannel;
        ReceiveChannel receiveChannel2;
        if (continuation instanceof C34811) {
            c34811 = (C34811) continuation;
            int i = c34811.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c34811.label = i - Integer.MIN_VALUE;
            } else {
                c34811 = new C34811(continuation);
            }
        }
        Object objHasNext = c34811.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c34811.label;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objHasNext);
                    final Channel channelChannel$default = ChannelKt.Channel$default(1, null, null, 6, null);
                    final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
                    observerHandleRegisterGlobalWriteObserver = Snapshot.INSTANCE.registerGlobalWriteObserver(new Function1<Object, Unit>() { // from class: androidx.glance.oneui.template.preview.PreviewSession$snapshotMonitor$observerHandle$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                            invoke2(obj);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Object it2) {
                            Intrinsics.checkNotNullParameter(it2, "it");
                            if (it2 instanceof MutableState) {
                                GlanceLog.INSTANCE.m2297d(PreviewSession.TAG, "State changed " + ((MutableState) it2).getValue());
                            }
                            if (atomicBoolean2.compareAndSet(false, true)) {
                                channelChannel$default.mo23705trySendJP2dKIU(Unit.INSTANCE);
                            }
                        }
                    });
                    it = channelChannel$default.iterator();
                    atomicBoolean = atomicBoolean2;
                    receiveChannel = channelChannel$default;
                    c34811.L$0 = atomicBoolean;
                    c34811.L$1 = observerHandleRegisterGlobalWriteObserver;
                    c34811.L$2 = receiveChannel;
                    c34811.L$3 = it;
                    c34811.label = 1;
                    objHasNext = it.hasNext(c34811);
                    receiveChannel2 = receiveChannel;
                    if (objHasNext == coroutine_suspended) {
                    }
                    if (((Boolean) objHasNext).booleanValue()) {
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (ChannelIterator) c34811.L$3;
                    ReceiveChannel receiveChannel3 = (ReceiveChannel) c34811.L$2;
                    observerHandleRegisterGlobalWriteObserver = (ObserverHandle) c34811.L$1;
                    atomicBoolean = (AtomicBoolean) c34811.L$0;
                    ResultKt.throwOnFailure(objHasNext);
                    receiveChannel2 = receiveChannel3;
                    if (((Boolean) objHasNext).booleanValue()) {
                        atomicBoolean.set(false);
                        Snapshot.INSTANCE.sendApplyNotifications();
                        receiveChannel = receiveChannel2;
                        c34811.L$0 = atomicBoolean;
                        c34811.L$1 = observerHandleRegisterGlobalWriteObserver;
                        c34811.L$2 = receiveChannel;
                        c34811.L$3 = it;
                        c34811.label = 1;
                        objHasNext = it.hasNext(c34811);
                        receiveChannel2 = receiveChannel;
                        if (objHasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (((Boolean) objHasNext).booleanValue()) {
                            Unit unit = Unit.INSTANCE;
                            ChannelsKt.cancelConsumed(receiveChannel2, null);
                            GlanceLog.INSTANCE.m2297d(TAG, "PreviewGlobalSnapshotMonitor disposed");
                            observerHandleRegisterGlobalWriteObserver.dispose();
                            return Unit.INSTANCE;
                        }
                    }
                }
            } finally {
            }
        } catch (Throwable th) {
            GlanceLog.INSTANCE.m2297d(TAG, "PreviewGlobalSnapshotMonitor disposed");
            observerHandleRegisterGlobalWriteObserver.dispose();
            throw th;
        }
    }

    public /* synthetic */ PreviewSession(GlanceTemplateAppWidget glanceTemplateAppWidget, Class cls, int i, int i2, int i4, GlanceStateDefinition glanceStateDefinition, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(glanceTemplateAppWidget, cls, i, i2, i4, (i5 & 32) != 0 ? PreferencesGlanceStateDefinition.INSTANCE : glanceStateDefinition, null);
    }

    @Override // androidx.glance.session.Session
    @NotNull
    /* JADX INFO: renamed from: provideGlance, reason: collision with other method in class */
    public Function2<Composer, Integer, Unit> mo21926provideGlance(@NotNull final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ComposableLambdaKt.composableLambdaInstance(-651899732, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.preview.PreviewSession.provideGlance.1
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
            public final void invoke(@Nullable Composer composer, int i) {
                if ((i & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-651899732, i, -1, "androidx.glance.oneui.template.preview.PreviewSession.provideGlance.<anonymous> (PreviewSession.kt:130)");
                }
                ProvidedValue[] providedValueArr = {androidx.glance.CompositionLocalsKt.getLocalContext().provides(context), CompositionLocalsKt.getLocalTemplateState().provides(new TemplateState(false, false, false, false, 15, null)), androidx.glance.CompositionLocalsKt.getLocalRealDataPreviewMode().provides(Boolean.TRUE)};
                final PreviewSession previewSession = this;
                final Context context2 = context;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer, 1665957868, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.preview.PreviewSession.provideGlance.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    private static final boolean invoke$lambda$0(State<Boolean> state) {
                        return state.getValue().booleanValue();
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
                            ComposerKt.traceEventStart(1665957868, i2, -1, "androidx.glance.oneui.template.preview.PreviewSession.provideGlance.<anonymous>.<anonymous> (PreviewSession.kt:135)");
                        }
                        Unit unit = null;
                        State stateProduceState = SnapshotStateKt.produceState(Boolean.FALSE, new PreviewSession$provideGlance$1$1$configIsReady$2(previewSession, context2, null), composer2, 70);
                        composer2.startReplaceableGroup(-342424140);
                        final Map<Integer, HostSizeInfo> appWidgetSizeInfos = Build.VERSION.SDK_INT >= 36 ? new GlanceAppWidgetManager((Context) composer2.consume(androidx.glance.CompositionLocalsKt.getLocalContext())).getAppWidgetSizeInfos() : MapsKt.emptyMap();
                        composer2.endReplaceableGroup();
                        if (invoke$lambda$0(stateProduceState)) {
                            composer2.startReplaceableGroup(-342423950);
                            PreviewSession previewSession2 = previewSession;
                            Context context3 = context2;
                            composer2.startReplaceableGroup(-492369756);
                            Object objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = PreviewContentReceiverKt.runGlance(previewSession2.widget, context3);
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            composer2.endReplaceableGroup();
                            final Function2 function2 = (Function2) SnapshotStateKt.collectAsState((Flow) objRememberedValue, null, null, composer2, 56, 2).getValue();
                            composer2.startReplaceableGroup(-342423802);
                            if (function2 != null) {
                                final PreviewSession previewSession3 = previewSession;
                                final Context context4 = context2;
                                CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalPreviewState().provides(previewSession3.previewState), ComposableLambdaKt.composableLambda(composer2, -450683749, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.preview.PreviewSession$provideGlance$1$1$2$1
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
                                            ComposerKt.traceEventStart(-450683749, i4, -1, "androidx.glance.oneui.template.preview.PreviewSession.provideGlance.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PreviewSession.kt:154)");
                                        }
                                        if (appWidgetSizeInfos.isEmpty()) {
                                            composer3.startReplaceableGroup(-489402652);
                                            ArrayList arrayList = new ArrayList();
                                            AppWidgetStyle.Companion companion = AppWidgetStyle.INSTANCE;
                                            List listListOf = CollectionsKt.listOf((Object[]) new AppWidgetStyle[]{AppWidgetStyle.m21574boximpl(companion.m21586getColorfulWOdBnnM()), AppWidgetStyle.m21574boximpl(companion.m21587getMonotoneWOdBnnM())});
                                            PreviewSession previewSession4 = previewSession3;
                                            Iterator it = listListOf.iterator();
                                            while (it.hasNext()) {
                                                int mask = ((AppWidgetStyle) it.next()).getMask();
                                                if (AppWidgetStyle.m21576containszt4ubU(previewSession4.widgetStyle, mask)) {
                                                    Iterator<T> it2 = AppWidgetSize.m21555toArrayListimpl(previewSession4.widgetSize).iterator();
                                                    while (it2.hasNext()) {
                                                        int mask2 = ((AppWidgetSize) it2.next()).getMask();
                                                        if (!AppWidgetStyle.m21578equalsimpl0(mask, AppWidgetStyle.INSTANCE.m21587getMonotoneWOdBnnM()) || AppWidgetSize.m21546compareToL2j3NV4(mask2, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) <= 0) {
                                                            arrayList.add(new Pair(AppWidgetStyle.m21574boximpl(mask), AppWidgetSize.m21545boximpl(mask2)));
                                                        }
                                                    }
                                                }
                                            }
                                            previewSession3.ForEachSizeAndStyle(context4, arrayList, function2, composer3, 4168);
                                            composer3.endReplaceableGroup();
                                        } else {
                                            composer3.startReplaceableGroup(-489402778);
                                            PreviewSession previewSession5 = previewSession3;
                                            previewSession5.ForEachHost(appWidgetSizeInfos, AppWidgetSize.m21555toArrayListimpl(previewSession5.widgetSize), function2, composer3, 4168);
                                            composer3.endReplaceableGroup();
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer2, 56);
                                unit = Unit.INSTANCE;
                            }
                            composer2.endReplaceableGroup();
                            if (unit == null) {
                                IgnoreResultKt.IgnoreResult(composer2, 0);
                            }
                            composer2.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(-342422620);
                            IgnoreResultKt.IgnoreResult(composer2, 0);
                            composer2.endReplaceableGroup();
                        }
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
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private PreviewSession(GlanceTemplateAppWidget widget, Class<? extends GlanceTemplateAppWidgetReceiver> receiver, int i, int i2, int i4, GlanceStateDefinition<Preferences> stateDefinition) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        Intrinsics.checkNotNullParameter(stateDefinition, "stateDefinition");
        String name = widget.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        super(name);
        this.widget = widget;
        this.receiver = receiver;
        this.widgetSize = i;
        this.widgetStyle = i2;
        this.hostType = i4;
        this.stateDefinition = stateDefinition;
    }

    @Override // androidx.glance.appwidget.multiprocess.CoroutineSession
    @NotNull
    public Session getEventSession() {
        return this;
    }
}
