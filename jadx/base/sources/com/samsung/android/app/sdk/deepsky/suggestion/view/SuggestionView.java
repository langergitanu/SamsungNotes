package com.samsung.android.app.sdk.deepsky.suggestion.view;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceControlViewHost;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.work.impl.utils.AbstractC4113a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionData;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.view.SuggestionViewContracts;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.view.SurfaceViewInfo;
import com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionView;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p066P2.RunnableC0201c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@RequiresApi(30)
@Metadata(m13885d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0007\u0018\u0000 M2\u00020\u0001:\u0005MNOPQB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0011H\u0002J\u0010\u0010)\u001a\u00020%2\u0006\u0010(\u001a\u00020\u0011H\u0002J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0011H\u0002J\b\u0010+\u001a\u00020\u001fH\u0014J\b\u0010,\u001a\u00020\u001fH\u0014J0\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0014J\u0018\u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0014J\u0018\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0007H\u0014J \u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020\u0016H\u0002J\b\u0010>\u001a\u00020\u001fH\u0002J\b\u0010?\u001a\u00020\u001fH\u0007J\u0018\u0010@\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020%H\u0002J\u0018\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007H\u0002J\u0010\u0010D\u001a\u00020\u001f2\b\u0010E\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010F\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020\rJ\u0010\u0010G\u001a\u00020\u001f2\b\u0010E\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010H\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020$H\u0002J\u000e\u0010I\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020\u0018J\u001f\u0010J\u001a\u00020\u001f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010KJ\u0010\u0010L\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0011H\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\u0019\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "clickConsumer", "Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionView$OnSuggestionClickListener;", "dismissedConsumer", "Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionView$OnDismissedListener;", "expiredConsumer", "Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionView$OnExpiredListener;", "latestConfig", "Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionViewConfig;", "latestLayoutHeight", "Ljava/lang/Integer;", "latestMeasuredHeight", "latestSurfacePkg", "Landroid/view/SurfaceControlViewHost$SurfacePackage;", "motionEventConsumer", "Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionView$OnMotionEventListener;", "onLayoutConsumer", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "width", "height", "", "surfaceView", "Landroid/view/SurfaceView;", "updaterHash", "", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SurfaceViewInfo;", "Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SurfacePackageUpdater;", "containsConfig", "", ExternalDataConstants.EmbeddingConfig.KEY, "createSurfacePackageUpdater", "measureHeight", "onAttachedToWindow", "onDetachedFromWindow", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "putUpdater", "info", "updater", "surfacePkg", "releaseUpdaters", "releaseViewConfig", "requestSurfacePackage", "resolveDrawingHeight", "measuredHeight", "minHeight", "setOnClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnDismissedListener", "setOnExpiredListener", "setOnLayoutConsumer", "setOnMotionEventListener", "setSurfaceViewLayoutParam", "(Ljava/lang/Integer;I)V", "setViewConfig", "Companion", "OnDismissedListener", "OnExpiredListener", "OnMotionEventListener", "OnSuggestionClickListener", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSuggestionView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuggestionView.kt\ncom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,322:1\n1#2:323\n215#3,2:324\n*S KotlinDebug\n*F\n+ 1 SuggestionView.kt\ncom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionView\n*L\n285#1:324,2\n*E\n"})
public final class SuggestionView extends FrameLayout {

    @NotNull
    private static final String TAG = "SSS:SuggestionView";

    @Nullable
    private OnSuggestionClickListener clickConsumer;

    @Nullable
    private OnDismissedListener dismissedConsumer;

    @Nullable
    private OnExpiredListener expiredConsumer;

    @Nullable
    private SuggestionViewConfig latestConfig;

    @Nullable
    private Integer latestLayoutHeight;

    @Nullable
    private Integer latestMeasuredHeight;

    @Nullable
    private SurfaceControlViewHost.SurfacePackage latestSurfacePkg;

    @Nullable
    private OnMotionEventListener motionEventConsumer;

    @Nullable
    private Function2<? super Integer, ? super Integer, Unit> onLayoutConsumer;

    @NotNull
    private final SurfaceView surfaceView;

    @NotNull
    private final Map<SurfaceViewInfo, SurfacePackageUpdater> updaterHash;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionView$OnDismissedListener;", "", "onDismissed", "", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface OnDismissedListener {
        void onDismissed();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionView$OnExpiredListener;", "", "onExpired", "", "cause", "", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface OnExpiredListener {
        void onExpired(@NotNull String cause);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionView$OnMotionEventListener;", "", "onMotionEvent", "", "actionId", "", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface OnMotionEventListener {
        void onMotionEvent(int actionId);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionView$OnSuggestionClickListener;", "", "onClick", "", "data", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionData;", "viewId", "", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface OnSuggestionClickListener {
        void onClick(@NotNull SuggestionData data, int viewId);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SuggestionView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean containsConfig(SuggestionViewConfig config) {
        SurfacePackageUpdater surfacePackageUpdater = (SurfacePackageUpdater) CollectionsKt.firstOrNull(this.updaterHash.values());
        if (surfacePackageUpdater == null || !surfacePackageUpdater.isAlreadyConnected(config)) {
            return false;
        }
        Log.i(TAG, "containsConfig, already connected.");
        return true;
    }

    private final SurfacePackageUpdater createSurfacePackageUpdater(SuggestionViewConfig config) {
        if (config.getEnableLocalOnly()) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            return new SurfacePackageUpdaterLocalImpl(context, config);
        }
        Bundle extras = config.getItem().getExtras();
        if (extras != null ? extras.containsKey(SuggestionViewContracts.SERVICE_VERSION_KEY) : false) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            return new SurfacePackageUpdaterRemoteImpl(context2, config);
        }
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        return new SurfacePackageUpdaterLocalImpl(context3, config);
    }

    private final int measureHeight(SuggestionViewConfig config) {
        Log.d(TAG, "measureHeight, minHeight: " + config.getListMinHeight());
        return config.getListMinHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void putUpdater(SurfaceViewInfo info, SurfacePackageUpdater updater, SurfaceControlViewHost.SurfacePackage surfacePkg) {
        AbstractC0541b.m755A(info.hashCode(), "putUpdater, ", TAG);
        this.updaterHash.put(info, updater);
        this.latestSurfacePkg = surfacePkg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseUpdaters() {
        for (Map.Entry<SurfaceViewInfo, SurfacePackageUpdater> entry : this.updaterHash.entrySet()) {
            SurfaceViewInfo key = entry.getKey();
            SurfacePackageUpdater value = entry.getValue();
            Log.d(TAG, "releaseUpdaters, " + key.hashCode());
            value.onSurfacePackageReleased(key);
        }
        this.updaterHash.clear();
        SurfaceControlViewHost.SurfacePackage surfacePackage = this.latestSurfacePkg;
        if (surfacePackage != null) {
            surfacePackage.release();
        }
    }

    private final void requestSurfacePackage(final SurfaceViewInfo info, final SurfacePackageUpdater updater) {
        Object objM22215constructorimpl;
        AbstractC0541b.m755A(info.hashCode(), "requestSurfacePackage, info: ", TAG);
        try {
            Result.Companion companion = Result.INSTANCE;
            updater.getSurfacePackage(info, new Function3<SurfaceControlViewHost.SurfacePackage, Integer, Integer, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionView$requestSurfacePackage$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(SurfaceControlViewHost.SurfacePackage surfacePackage, Integer num, Integer num2) {
                    invoke(AbstractC4113a.m2453g(surfacePackage), num.intValue(), num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull SurfaceControlViewHost.SurfacePackage surfacePkg, int i, int i2) {
                    Intrinsics.checkNotNullParameter(surfacePkg, "surfacePkg");
                    Log.d("SSS:SuggestionView", "received, SurfacePackage, " + i + SQLKeyword.COMMA + i2);
                    this.$this_runCatching.setSurfaceViewLayoutParam(Integer.valueOf(i), i2);
                    this.$this_runCatching.releaseUpdaters();
                    this.$this_runCatching.surfaceView.setChildSurfacePackage(surfacePkg);
                    this.$this_runCatching.surfaceView.setVisibility(0);
                    this.$this_runCatching.putUpdater(info, updater, surfacePkg);
                    this.$this_runCatching.setOnLayoutConsumer(info);
                    Integer num = this.$this_runCatching.latestLayoutHeight;
                    if ((num == null || i2 != num.intValue()) && (this.$this_runCatching.latestLayoutHeight != null)) {
                        Log.i("SSS:SuggestionView", "received, different layoutHeight: " + this.$this_runCatching.latestLayoutHeight);
                        info.setHeight(this.$this_runCatching.latestLayoutHeight);
                        updater.relayout(info);
                    }
                }
            });
            updater.setOnClickListener(new Function2<SuggestionData, Integer, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionView$requestSurfacePackage$1$2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(SuggestionData suggestionData, Integer num) {
                    invoke(suggestionData, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull SuggestionData data, int i) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    Log.i("SSS:SuggestionView", "clicked, data: " + data.getId() + ", viewId: " + i);
                    SuggestionView.OnSuggestionClickListener onSuggestionClickListener = this.$this_runCatching.clickConsumer;
                    if (onSuggestionClickListener != null) {
                        onSuggestionClickListener.onClick(data, i);
                    }
                }
            });
            updater.setOnMotionEventListener(new Function1<Integer, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionView$requestSurfacePackage$1$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i) {
                    AbstractC0541b.m755A(i, "motionEvent, actionId: ", "SSS:SuggestionView");
                    SuggestionView.OnMotionEventListener onMotionEventListener = this.$this_runCatching.motionEventConsumer;
                    if (onMotionEventListener != null) {
                        onMotionEventListener.onMotionEvent(i);
                    }
                }
            });
            updater.setOnDisconnectedListener(new Function1<String, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionView$requestSurfacePackage$1$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Log.i("SSS:SuggestionView", "disconnected, cause: " + it);
                    this.$this_runCatching.releaseUpdaters();
                    SuggestionView.OnExpiredListener onExpiredListener = this.$this_runCatching.expiredConsumer;
                    if (onExpiredListener != null) {
                        onExpiredListener.onExpired(it);
                    }
                    this.$this_runCatching.surfaceView.setVisibility(4);
                    this.$this_runCatching.latestConfig = null;
                }
            });
            updater.setOnDismissedListener(new Function0<Unit>() { // from class: com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionView$requestSurfacePackage$1$5
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Log.i("SSS:SuggestionView", "dismissed");
                    SuggestionView.OnDismissedListener onDismissedListener = this.$this_runCatching.dismissedConsumer;
                    if (onDismissedListener != null) {
                        onDismissedListener.onDismissed();
                    }
                    this.$this_runCatching.surfaceView.setVisibility(4);
                    this.$this_runCatching.latestConfig = null;
                }
            });
            updater.setOnLayoutChangedListener(new Function2<Integer, Integer, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionView$requestSurfacePackage$1$6
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                    invoke(num.intValue(), num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i, int i2) {
                    AbstractC2322a.m1631u(i2, "layoutChanged, height: ", "SSS:SuggestionView");
                    this.$this_runCatching.setSurfaceViewLayoutParam(null, i2);
                }
            });
            objM22215constructorimpl = Result.m22215constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            AbstractC2322a.m1636z("requestSurfacePackage, ", thM22218exceptionOrNullimpl.getLocalizedMessage(), TAG);
            this.surfaceView.setVisibility(4);
            this.latestConfig = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int resolveDrawingHeight(int measuredHeight, int minHeight) {
        return (measuredHeight != 0 && measuredHeight >= minHeight) ? measuredHeight : minHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setOnLayoutConsumer(final SurfaceViewInfo info) {
        this.onLayoutConsumer = new Function2<Integer, Integer, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionView.setOnLayoutConsumer.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final void invoke(int i, int i2) {
                AbstractC0541b.m783y(i, i2, "onLayout, view, ", SQLKeyword.COMMA, SuggestionView.TAG);
                int measuredWidth = SuggestionView.this.getMeasuredWidth();
                SuggestionView suggestionView = SuggestionView.this;
                int height = suggestionView.surfaceView.getHeight();
                Integer minHeight = info.getMinHeight();
                int iResolveDrawingHeight = suggestionView.resolveDrawingHeight(height, minHeight != null ? minHeight.intValue() : SuggestionView.this.surfaceView.getHeight());
                SuggestionView.this.setSurfaceViewLayoutParam(Integer.valueOf(measuredWidth), iResolveDrawingHeight);
                for (Map.Entry entry : SuggestionView.this.updaterHash.entrySet()) {
                    SurfaceViewInfo surfaceViewInfo = (SurfaceViewInfo) entry.getKey();
                    SurfacePackageUpdater surfacePackageUpdater = (SurfacePackageUpdater) entry.getValue();
                    AbstractC6670b.m4744e(measuredWidth, iResolveDrawingHeight, "onLayout, request wh: ", SQLKeyword.COMMA, SuggestionView.TAG);
                    surfaceViewInfo.setWidth(Integer.valueOf(measuredWidth));
                    surfaceViewInfo.setHeight(Integer.valueOf(iResolveDrawingHeight));
                    surfacePackageUpdater.relayout(surfaceViewInfo);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSurfaceViewLayoutParam(Integer width, int height) {
        Log.d(TAG, "setSurfaceViewLayoutParam, width: " + width + ", height: " + height);
        SurfaceView surfaceView = this.surfaceView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width != null ? width.intValue() : this.surfaceView.getLayoutParams().width, height);
        layoutParams.gravity = 1;
        surfaceView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setViewConfig$lambda$1(SuggestionView this$0, SuggestionViewConfig config, SurfacePackageUpdater surfacePackageUpdater) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(surfacePackageUpdater, "$surfacePackageUpdater");
        int iResolveDrawingHeight = this$0.resolveDrawingHeight(this$0.surfaceView.getHeight(), config.getListMinHeight());
        AbstractC0000a.m26w(AbstractC0622a.m1173s(this$0.surfaceView.getWidth(), this$0.surfaceView.getHeight(), "setViewConfig ", SQLKeyword.COMMA, ", height: "), TAG, iResolveDrawingHeight);
        IBinder hostToken = this$0.surfaceView.getHostToken();
        if (hostToken == null) {
            Log.w(TAG, "setViewConfig, hostToken is null.");
            return;
        }
        int displayId = this$0.surfaceView.getDisplay().getDisplayId();
        int width = this$0.surfaceView.getWidth();
        int listMinHeight = config.getListMinHeight();
        String hexString = Integer.toHexString(this$0.surfaceView.hashCode());
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(surfaceView.hashCode())");
        this$0.requestSurfacePackage(new SurfaceViewInfo(0, hexString, hostToken, Integer.valueOf(displayId), Integer.valueOf(width), Integer.valueOf(iResolveDrawingHeight), Integer.valueOf(listMinHeight), null, 129, null), surfacePackageUpdater);
        this$0.latestConfig = config;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SuggestionViewConfig suggestionViewConfig = this.latestConfig;
        if (suggestionViewConfig != null) {
            Log.d(TAG, "onAttachedToWindow, setViewConfig");
            setViewConfig(suggestionViewConfig);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d(TAG, "onDetachedFromWindow");
        releaseUpdaters();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int i = bottom - top;
        Log.d(TAG, "onLayout, changed: " + changed + ", height: " + i);
        if (changed) {
            this.latestLayoutHeight = Integer.valueOf(i);
            Function2<? super Integer, ? super Integer, Unit> function2 = this.onLayoutConsumer;
            if (function2 != null) {
                function2.invoke(Integer.valueOf(right - left), Integer.valueOf(i));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0022 A[PHI: r7
      0x0022: PHI (r7v10 java.lang.Integer) = (r7v1 java.lang.Integer), (r7v4 java.lang.Integer) binds: [B:7:0x0020, B:13:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int iIntValue;
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        AbstractC0541b.m783y(size, size2, "onMeasure, width: ", ", height: ", TAG);
        if (View.MeasureSpec.getMode(heightMeasureSpec) == 1073741824) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        Integer numValueOf = this.latestMeasuredHeight;
        if (numValueOf == null) {
            SuggestionViewConfig suggestionViewConfig = this.latestConfig;
            numValueOf = suggestionViewConfig != null ? Integer.valueOf(suggestionViewConfig.getListMinHeight()) : null;
            iIntValue = numValueOf != null ? numValueOf.intValue() : 0;
        }
        if (size2 >= iIntValue) {
            size2 = iIntValue;
        }
        AbstractC0541b.m783y(iIntValue, size2, "onMeasure, measuredHeight: ", ", retHeight: ", TAG);
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NotNull View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (Intrinsics.areEqual(changedView, this)) {
            Log.i(TAG, "onVisibilityChanged, " + changedView + SQLKeyword.COMMA + visibility);
            if (visibility == 0) {
                this.surfaceView.setZOrderOnTop(true);
            } else {
                this.surfaceView.setZOrderOnTop(false);
            }
        }
    }

    @MainThread
    public final void releaseViewConfig() {
        releaseUpdaters();
        this.latestConfig = null;
        this.latestMeasuredHeight = null;
    }

    public final void setOnClickListener(@Nullable OnSuggestionClickListener listener) {
        this.clickConsumer = listener;
    }

    public final void setOnDismissedListener(@NotNull OnDismissedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.dismissedConsumer = listener;
    }

    public final void setOnExpiredListener(@Nullable OnExpiredListener listener) {
        this.expiredConsumer = listener;
    }

    public final void setOnMotionEventListener(@NotNull OnMotionEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.motionEventConsumer = listener;
    }

    @MainThread
    public final void setViewConfig(@NotNull SuggestionViewConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        AbstractC6670b.m4756q("setViewConfig, itemId: ", config.getItem().getId(), TAG);
        if (containsConfig(config)) {
            return;
        }
        if (getChildCount() == 0) {
            View view = this.surfaceView;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 1;
            Unit unit = Unit.INSTANCE;
            addView(view, layoutParams);
        }
        this.latestMeasuredHeight = Integer.valueOf(measureHeight(config));
        post(new RunnableC0201c(this, 17, config, createSurfacePackageUpdater(config)));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SuggestionView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SuggestionView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SuggestionView(Context context, AttributeSet attributeSet, int i, int i2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SuggestionView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        SurfaceView surfaceView = new SurfaceView(context, attributeSet, i, i2);
        this.surfaceView = surfaceView;
        this.updaterHash = new LinkedHashMap();
        surfaceView.setVisibility(4);
        surfaceView.setZOrderOnTop(true);
        surfaceView.getHolder().setFormat(-2);
        surfaceView.getHolder().setSizeFromLayout();
        setImportantForAccessibility(2);
    }
}
