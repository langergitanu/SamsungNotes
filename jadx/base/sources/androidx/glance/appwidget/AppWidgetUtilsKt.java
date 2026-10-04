package androidx.glance.appwidget;

import android.annotation.SuppressLint;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.SizeF;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpKt;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composer;
import androidx.glance.GlanceId;
import androidx.glance.oneui.common.GlanceLog;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0019\u001a\b\u0010\u001a\u001a\u00020\u0011H\u0000\u001a\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0001H\u0000\u001a*\u0010\u001c\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001d\u001a\u00020\u00152\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u001fH\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\fH\u0000\u001a\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0000\u001a\u0018\u0010)\u001a\u00020*2\u000e\b\u0001\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00150,H\u0001\u001a\u0018\u0010-\u001a\u00020&2\u0006\u0010#\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0006H\u0000\u001a\"\u0010/\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a\"\u00103\u001a\b\u0012\u0004\u0012\u00020\u00150,*\u00020*2\u000e\b\u0001\u00104\u001a\b\u0012\u0004\u0012\u00020\u001505H\u0003\u001a\"\u00106\u001a\b\u0012\u0004\u0012\u00020\u00150,*\u00020*2\u000e\b\u0001\u00104\u001a\b\u0012\u0004\u0012\u00020\u001505H\u0001\u001a\u000e\u00107\u001a\u0004\u0018\u00010\u0015*\u00020*H\u0002\u001a\u0012\u00108\u001a\b\u0012\u0004\u0012\u00020\u00150,*\u00020*H\u0001\u001a\u000e\u00109\u001a\u0004\u0018\u00010\u0015*\u00020*H\u0002\u001a\u001f\u0010:\u001a\u00020\u0010*\u00020\u00152\u0006\u0010;\u001a\u00020\u0015H\u0082\u0004ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a\u0019\u0010>\u001a\u00020\u0015*\u00020?2\u0006\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\u0010@\u001a4\u0010A\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020&\u0018\u000105¢\u0006\u0002\bC¢\u0006\u0002\bD0B*\u00020E2\u0006\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020FH\u0000\u001a\u0018\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00150,*\b\u0012\u0004\u0012\u00020\u00150\u001fH\u0001\u001a+\u0010H\u001a\u0012\u0012\u0004\u0012\u0002HJ0Ij\b\u0012\u0004\u0012\u0002HJ`K\"\u0006\b\u0000\u0010J\u0018\u0001*\b\u0012\u0004\u0012\u0002HJ0\u001fH\u0080\b\u001a\f\u0010L\u001a\u00020\u0003*\u00020\u0011H\u0000\u001a\u0016\u0010M\u001a\u00020N*\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\bO\u0010P\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"0\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0006`\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0018\u0010\n\u001a\u00020\u000b*\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0018\u0010\u000f\u001a\u00020\u0010*\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0012\"\u0018\u0010\u0013\u001a\u00020\u0010*\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Q"}, m13886d2 = {"MaxComposeTreeDepth", "", SearchConstants.TargetContents.TAG, "", "metricsMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getMetricsMap", "()Ljava/util/HashMap;", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "Landroid/content/Context;", "getAppWidgetManager", "(Landroid/content/Context;)Landroid/appwidget/AppWidgetManager;", "isFakeId", "", "Landroidx/glance/appwidget/AppWidgetId;", "(Landroidx/glance/appwidget/AppWidgetId;)Z", "isRealId", "appWidgetMinSize", "Landroidx/compose/ui/unit/DpSize;", "displayMetrics", "Landroid/util/DisplayMetrics;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "(Landroid/util/DisplayMetrics;Landroid/appwidget/AppWidgetManager;I)J", "createFakeAppWidgetId", "createUniqueRemoteUiName", "findBestSize", "widgetSize", "layoutSizes", "", "findBestSize-itqla9I", "(JLjava/util/Collection;)Landroidx/compose/ui/unit/DpSize;", "getCurrentDensity", "id", "context", "logException", "", "throwable", "", "optionsBundleOf", "Landroid/os/Bundle;", "sizes", "", "setCurrentDensity", "density", "squareDistance", "layoutSize", "squareDistance-KscErT0", "(JJ)F", "estimateSizes", "minSize", "Lkotlin/Function0;", "extractAllSizes", "extractLandscapeSize", "extractOrientationSizes", "extractPortraitSize", "fitsIn", "other", "fitsIn-KscErT0", "(JJ)Z", "getMinSize", "Landroid/appwidget/AppWidgetProviderInfo;", "(Landroid/appwidget/AppWidgetProviderInfo;Landroid/util/DisplayMetrics;)J", "runGlance", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/glance/GlanceComposable;", "Landroidx/compose/runtime/Composable;", "Landroidx/glance/appwidget/GlanceAppWidget;", "Landroidx/glance/GlanceId;", "sortedBySize", "toArrayList", "Ljava/util/ArrayList;", "T", "Lkotlin/collections/ArrayList;", "toSessionKey", "toSizeF", "Landroid/util/SizeF;", "toSizeF-EaSLcWc", "(J)Landroid/util/SizeF;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAppWidgetUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppWidgetUtils.kt\nandroidx/glance/appwidget/AppWidgetUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,331:1\n272#1:378\n1549#2:332\n1620#2,2:333\n1622#2:336\n1603#2,9:340\n1855#2:349\n1856#2:351\n1612#2:352\n2333#2,14:353\n1789#2,2:368\n1791#2:373\n1549#2:374\n1620#2,3:375\n174#3:335\n154#3:337\n154#3:338\n154#3:339\n189#3:370\n189#3:371\n192#3:372\n1#4:350\n1#4:367\n*S KotlinDebug\n*F\n+ 1 AppWidgetUtils.kt\nandroidx/glance/appwidget/AppWidgetUtilsKt\n*L\n298#1:378\n97#1:332\n97#1:333,2\n97#1:336\n154#1:340,9\n154#1:349\n154#1:351\n154#1:352\n160#1:353,14\n279#1:368,2\n279#1:373\n298#1:374\n298#1:375,3\n97#1:335\n117#1:337\n124#1:338\n131#1:339\n281#1:370\n282#1:371\n284#1:372\n154#1:350\n*E\n"})
public final class AppWidgetUtilsKt {
    public static final int MaxComposeTreeDepth = 50;

    @NotNull
    private static final String TAG = "GWT:AppWidgetUtils";

    @NotNull
    private static final HashMap<Integer, Float> metricsMap = new HashMap<>();

    /* JADX INFO: renamed from: androidx.glance.appwidget.AppWidgetUtilsKt$runGlance$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00050\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/Function0;", "Landroidx/glance/GlanceComposable;", "Landroidx/compose/runtime/Composable;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.AppWidgetUtilsKt$runGlance$1", m14021f = "AppWidgetUtils.kt", m14022i = {}, m14023l = {269}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C28301 extends SuspendLambda implements Function2<ProducerScope<? super Function2<? super Composer, ? super Integer, ? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ GlanceId $id;
        final /* synthetic */ GlanceAppWidget $this_runGlance;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.glance.appwidget.AppWidgetUtilsKt$runGlance$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.glance.appwidget.AppWidgetUtilsKt$runGlance$1$1", m14021f = "AppWidgetUtils.kt", m14022i = {}, m14023l = {269}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $context;
            final /* synthetic */ GlanceId $id;
            final /* synthetic */ GlanceAppWidget $this_runGlance;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(GlanceAppWidget glanceAppWidget, Context context, GlanceId glanceId, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$this_runGlance = glanceAppWidget;
                this.$context = context;
                this.$id = glanceId;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass1(this.$this_runGlance, this.$context, this.$id, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    GlanceAppWidget glanceAppWidget = this.$this_runGlance;
                    Context context = this.$context;
                    GlanceId glanceId = this.$id;
                    this.label = 1;
                    if (glanceAppWidget.provideGlance(context, glanceId, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28301(GlanceAppWidget glanceAppWidget, Context context, GlanceId glanceId, Continuation<? super C28301> continuation) {
            super(2, continuation);
            this.$this_runGlance = glanceAppWidget;
            this.$context = context;
            this.$id = glanceId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C28301 c28301 = new C28301(this.$this_runGlance, this.$context, this.$id, continuation);
            c28301.L$0 = obj;
            return c28301;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Function2<? super Composer, ? super Integer, ? extends Unit>> producerScope, Continuation<? super Unit> continuation) {
            return invoke2((ProducerScope<? super Function2<? super Composer, ? super Integer, Unit>>) producerScope, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AppWidgetUtilsKt$runGlance$1$receiver$1 appWidgetUtilsKt$runGlance$1$receiver$1 = new AppWidgetUtilsKt$runGlance$1$receiver$1(new AtomicReference(null), (ProducerScope) this.L$0);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_runGlance, this.$context, this.$id, null);
                this.label = 1;
                if (BuildersKt.withContext(appWidgetUtilsKt$runGlance$1$receiver$1, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull ProducerScope<? super Function2<? super Composer, ? super Integer, Unit>> producerScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C28301) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public static final long appWidgetMinSize(@NotNull DisplayMetrics displayMetrics, @NotNull AppWidgetManager appWidgetManager, int i) {
        Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        AppWidgetProviderInfo appWidgetInfo = appWidgetManager.getAppWidgetInfo(i);
        if (appWidgetInfo == null) {
            return DpSize.INSTANCE.m21076getZeroMYxV2XQ();
        }
        return DpKt.m20990DpSizeYgX7TsA(UtilsKt.pixelsToDp(Math.min(appWidgetInfo.minWidth, (appWidgetInfo.resizeMode & 1) != 0 ? appWidgetInfo.minResizeWidth : Integer.MAX_VALUE), displayMetrics.density), UtilsKt.pixelsToDp(Math.min(appWidgetInfo.minHeight, (appWidgetInfo.resizeMode & 2) != 0 ? appWidgetInfo.minResizeHeight : Integer.MAX_VALUE), displayMetrics.density));
    }

    @NotNull
    public static final AppWidgetId createFakeAppWidgetId() {
        return new AppWidgetId(RandomKt.nextInt(Random.INSTANCE, new IntRange(Integer.MIN_VALUE, -2)));
    }

    @NotNull
    public static final String createUniqueRemoteUiName(int i) {
        return AbstractC0000a.m11h(i, "appWidget-");
    }

    @SuppressLint({"PrimitiveInCollection"})
    private static final List<DpSize> estimateSizes(Bundle bundle, @SuppressLint({"PrimitiveInLambda"}) Function0<DpSize> function0) {
        int i = bundle.getInt("appWidgetMinHeight", 0);
        int i2 = bundle.getInt("appWidgetMaxHeight", 0);
        int i4 = bundle.getInt("appWidgetMinWidth", 0);
        int i5 = bundle.getInt("appWidgetMaxWidth", 0);
        return (i == 0 || i2 == 0 || i4 == 0 || i5 == 0) ? CollectionsKt.listOf(function0.invoke()) : CollectionsKt.listOf((Object[]) new DpSize[]{DpSize.m21054boximpl(DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(i4), C2256Dp.m20968constructorimpl(i2))), DpSize.m21054boximpl(DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(i5), C2256Dp.m20968constructorimpl(i)))});
    }

    @SuppressLint({"PrimitiveInCollection", "ListIterator"})
    @NotNull
    public static final List<DpSize> extractAllSizes(@NotNull Bundle bundle, @SuppressLint({"PrimitiveInLambda"}) @NotNull Function0<DpSize> minSize) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(minSize, "minSize");
        ArrayList<SizeF> parcelableArrayList = bundle.getParcelableArrayList("appWidgetSizes");
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            return estimateSizes(bundle, minSize);
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(parcelableArrayList));
        for (SizeF sizeF : parcelableArrayList) {
            arrayList.add(DpSize.m21054boximpl(DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(sizeF.getWidth()), C2256Dp.m20968constructorimpl(sizeF.getHeight()))));
        }
        return arrayList;
    }

    private static final DpSize extractLandscapeSize(Bundle bundle) {
        int i = bundle.getInt("appWidgetMinHeight", 0);
        int i2 = bundle.getInt("appWidgetMaxWidth", 0);
        if (i == 0 || i2 == 0) {
            return null;
        }
        return DpSize.m21054boximpl(DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(i2), C2256Dp.m20968constructorimpl(i)));
    }

    @SuppressLint({"PrimitiveInCollection"})
    @NotNull
    public static final List<DpSize> extractOrientationSizes(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        return CollectionsKt.listOfNotNull((Object[]) new DpSize[]{extractLandscapeSize(bundle), extractPortraitSize(bundle)});
    }

    private static final DpSize extractPortraitSize(Bundle bundle) {
        int i = bundle.getInt("appWidgetMaxHeight", 0);
        int i2 = bundle.getInt("appWidgetMinWidth", 0);
        if (i == 0 || i2 == 0) {
            return null;
        }
        return DpSize.m21054boximpl(DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(i2), C2256Dp.m20968constructorimpl(i)));
    }

    @SuppressLint({"ListIterator"})
    @Nullable
    /* JADX INFO: renamed from: findBestSize-itqla9I, reason: not valid java name */
    public static final DpSize m21264findBestSizeitqla9I(long j, @NotNull Collection<DpSize> layoutSizes) {
        Object next;
        Intrinsics.checkNotNullParameter(layoutSizes, "layoutSizes");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = layoutSizes.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            long packedValue = ((DpSize) it.next()).getPackedValue();
            Pair pairM13893to = m21265fitsInKscErT0(packedValue, j) ? TuplesKt.m13893to(DpSize.m21054boximpl(packedValue), Float.valueOf(m21266squareDistanceKscErT0(j, packedValue))) : null;
            if (pairM13893to != null) {
                arrayList.add(pairM13893to);
            }
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                float fFloatValue = ((Number) ((Pair) next).getSecond()).floatValue();
                do {
                    Object next2 = it2.next();
                    float fFloatValue2 = ((Number) ((Pair) next2).getSecond()).floatValue();
                    if (Float.compare(fFloatValue, fFloatValue2) > 0) {
                        next = next2;
                        fFloatValue = fFloatValue2;
                    }
                } while (it2.hasNext());
            }
        } else {
            next = null;
        }
        Pair pair = (Pair) next;
        if (pair != null) {
            return (DpSize) pair.getFirst();
        }
        return null;
    }

    /* JADX INFO: renamed from: fitsIn-KscErT0, reason: not valid java name */
    private static final boolean m21265fitsInKscErT0(long j, long j2) {
        float f = 1;
        return ((float) Math.ceil((double) DpSize.m21066getWidthD9Ej5fM(j2))) + f > DpSize.m21066getWidthD9Ej5fM(j) && ((float) Math.ceil((double) DpSize.m21064getHeightD9Ej5fM(j2))) + f > DpSize.m21064getHeightD9Ej5fM(j);
    }

    @NotNull
    public static final AppWidgetManager getAppWidgetManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("appwidget");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.appwidget.AppWidgetManager");
        return (AppWidgetManager) systemService;
    }

    public static final float getCurrentDensity(int i, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (i == -1) {
            return context.getResources().getDisplayMetrics().density;
        }
        Float f = metricsMap.get(Integer.valueOf(i));
        return f == null ? context.getResources().getDisplayMetrics().density : f.floatValue();
    }

    @NotNull
    public static final HashMap<Integer, Float> getMetricsMap() {
        return metricsMap;
    }

    public static final long getMinSize(@NotNull AppWidgetProviderInfo appWidgetProviderInfo, @NotNull DisplayMetrics displayMetrics) {
        Intrinsics.checkNotNullParameter(appWidgetProviderInfo, "<this>");
        Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
        return DpKt.m20990DpSizeYgX7TsA(UtilsKt.pixelsToDp(Math.min(appWidgetProviderInfo.minWidth, (appWidgetProviderInfo.resizeMode & 1) != 0 ? appWidgetProviderInfo.minResizeWidth : Integer.MAX_VALUE), displayMetrics.density), UtilsKt.pixelsToDp(Math.min(appWidgetProviderInfo.minHeight, (appWidgetProviderInfo.resizeMode & 2) != 0 ? appWidgetProviderInfo.minResizeHeight : Integer.MAX_VALUE), displayMetrics.density));
    }

    public static final boolean isFakeId(@NotNull AppWidgetId appWidgetId) {
        Intrinsics.checkNotNullParameter(appWidgetId, "<this>");
        int appWidgetId2 = appWidgetId.getAppWidgetId();
        return Integer.MIN_VALUE <= appWidgetId2 && appWidgetId2 < -1;
    }

    public static final boolean isRealId(@NotNull AppWidgetId appWidgetId) {
        Intrinsics.checkNotNullParameter(appWidgetId, "<this>");
        return !isFakeId(appWidgetId);
    }

    public static final void logException(@NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        GlanceLog.INSTANCE.m2300e(TAG, "Error in Glance App Widget", throwable);
    }

    @SuppressLint({"ListIterator"})
    @NotNull
    public static final Bundle optionsBundleOf(@SuppressLint({"PrimitiveInCollection"}) @NotNull List<DpSize> sizes) {
        Intrinsics.checkNotNullParameter(sizes, "sizes");
        if (sizes.isEmpty()) {
            throw new IllegalArgumentException("There must be at least one size");
        }
        Pair pairM13893to = TuplesKt.m13893to(sizes.get(0), sizes.get(0));
        Iterator<T> it = sizes.iterator();
        while (it.hasNext()) {
            long packedValue = ((DpSize) it.next()).getPackedValue();
            pairM13893to = TuplesKt.m13893to(DpSize.m21054boximpl(DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(Math.min(DpSize.m21066getWidthD9Ej5fM(((DpSize) pairM13893to.getFirst()).getPackedValue()), DpSize.m21066getWidthD9Ej5fM(packedValue))), C2256Dp.m20968constructorimpl(Math.min(DpSize.m21064getHeightD9Ej5fM(((DpSize) pairM13893to.getFirst()).getPackedValue()), DpSize.m21064getHeightD9Ej5fM(packedValue))))), DpSize.m21054boximpl(DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(Math.max(DpSize.m21066getWidthD9Ej5fM(((DpSize) pairM13893to.getSecond()).getPackedValue()), DpSize.m21066getWidthD9Ej5fM(packedValue))), C2256Dp.m20968constructorimpl(Math.max(DpSize.m21064getHeightD9Ej5fM(((DpSize) pairM13893to.getSecond()).getPackedValue()), DpSize.m21064getHeightD9Ej5fM(packedValue))))));
        }
        long packedValue2 = ((DpSize) pairM13893to.component1()).getPackedValue();
        long packedValue3 = ((DpSize) pairM13893to.component2()).getPackedValue();
        Bundle bundle = new Bundle();
        bundle.putInt("appWidgetMinWidth", (int) DpSize.m21066getWidthD9Ej5fM(packedValue2));
        bundle.putInt("appWidgetMinHeight", (int) DpSize.m21064getHeightD9Ej5fM(packedValue2));
        bundle.putInt("appWidgetMaxWidth", (int) DpSize.m21066getWidthD9Ej5fM(packedValue3));
        bundle.putInt("appWidgetMaxHeight", (int) DpSize.m21064getHeightD9Ej5fM(packedValue3));
        if (Build.VERSION.SDK_INT >= 31) {
            List<DpSize> list = sizes;
            ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(m21267toSizeFEaSLcWc(((DpSize) it2.next()).getPackedValue()));
            }
            bundle.putParcelableArrayList("appWidgetSizes", new ArrayList<>(arrayList));
        }
        return bundle;
    }

    @NotNull
    public static final Flow<Function2<Composer, Integer, Unit>> runGlance(@NotNull GlanceAppWidget glanceAppWidget, @NotNull Context context, @NotNull GlanceId id) {
        Intrinsics.checkNotNullParameter(glanceAppWidget, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(id, "id");
        return FlowKt.channelFlow(new C28301(glanceAppWidget, context, id, null));
    }

    public static final void setCurrentDensity(int i, float f) {
        if (f > 0.0f) {
            GlanceLog.INSTANCE.m2297d(TAG, "setCurrentDensity " + i + " " + f);
            metricsMap.put(Integer.valueOf(i), Float.valueOf(f));
        }
    }

    @SuppressLint({"PrimitiveInCollection"})
    @NotNull
    public static final List<DpSize> sortedBySize(@NotNull Collection<DpSize> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return CollectionsKt.sortedWith(collection, ComparisonsKt.compareBy(new Function1<DpSize, Comparable<?>>() { // from class: androidx.glance.appwidget.AppWidgetUtilsKt.sortedBySize.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Comparable<?> invoke(DpSize dpSize) {
                return m21268invokeEaSLcWc(dpSize.getPackedValue());
            }

            @Nullable
            /* JADX INFO: renamed from: invoke-EaSLcWc, reason: not valid java name */
            public final Comparable<?> m21268invokeEaSLcWc(long j) {
                return Float.valueOf(DpSize.m21064getHeightD9Ej5fM(j) * DpSize.m21066getWidthD9Ej5fM(j));
            }
        }, new Function1<DpSize, Comparable<?>>() { // from class: androidx.glance.appwidget.AppWidgetUtilsKt.sortedBySize.2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Comparable<?> invoke(DpSize dpSize) {
                return m21269invokeEaSLcWc(dpSize.getPackedValue());
            }

            @Nullable
            /* JADX INFO: renamed from: invoke-EaSLcWc, reason: not valid java name */
            public final Comparable<?> m21269invokeEaSLcWc(long j) {
                return Float.valueOf(DpSize.m21066getWidthD9Ej5fM(j));
            }
        }));
    }

    /* JADX INFO: renamed from: squareDistance-KscErT0, reason: not valid java name */
    private static final float m21266squareDistanceKscErT0(long j, long j2) {
        float fM21066getWidthD9Ej5fM = DpSize.m21066getWidthD9Ej5fM(j) - DpSize.m21066getWidthD9Ej5fM(j2);
        float fM21064getHeightD9Ej5fM = DpSize.m21064getHeightD9Ej5fM(j) - DpSize.m21064getHeightD9Ej5fM(j2);
        return (fM21064getHeightD9Ej5fM * fM21064getHeightD9Ej5fM) + (fM21066getWidthD9Ej5fM * fM21066getWidthD9Ej5fM);
    }

    public static final /* synthetic */ <T> ArrayList<T> toArrayList(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new ArrayList<>(collection);
    }

    @NotNull
    public static final String toSessionKey(@NotNull AppWidgetId appWidgetId) {
        Intrinsics.checkNotNullParameter(appWidgetId, "<this>");
        return createUniqueRemoteUiName(appWidgetId.getAppWidgetId());
    }

    @NotNull
    /* JADX INFO: renamed from: toSizeF-EaSLcWc, reason: not valid java name */
    public static final SizeF m21267toSizeFEaSLcWc(long j) {
        return new SizeF(DpSize.m21066getWidthD9Ej5fM(j), DpSize.m21064getHeightD9Ej5fM(j));
    }
}
