package androidx.glance.appwidget.multiprocess;

import android.content.Context;
import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.EmittableWithChildren;
import androidx.glance.appwidget.AppWidgetId;
import androidx.glance.appwidget.AppWidgetSession;
import androidx.glance.appwidget.AppWidgetUtilsKt;
import androidx.glance.appwidget.GlanceAppWidget;
import androidx.glance.appwidget.IgnoreResultKt;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.session.Session;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u0000 12\u00020\u0001:\u00011B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"J%\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u001f0$¢\u0006\u0002\b%¢\u0006\u0002\b&2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020)H\u0086@¢\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010-J\u000e\u0010.\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010/J\u000e\u00100\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010/R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u00062"}, m13886d2 = {"Landroidx/glance/appwidget/multiprocess/MultiProcessSession;", "Landroidx/glance/appwidget/multiprocess/CoroutineSession;", "key", "Landroidx/glance/appwidget/AppWidgetId;", "widget", "Landroidx/glance/appwidget/GlanceAppWidget;", "options", "Landroid/os/Bundle;", "(Landroidx/glance/appwidget/AppWidgetId;Landroidx/glance/appwidget/GlanceAppWidget;Landroid/os/Bundle;)V", "eventSession", "Landroidx/glance/session/Session;", "getEventSession", "()Landroidx/glance/session/Session;", "getOptions", "()Landroid/os/Bundle;", "session", "Landroidx/glance/appwidget/AppWidgetSession;", "updatedAtLeastOnce", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getUpdatedAtLeastOnce$glance_appwidget_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "getWidget", "()Landroidx/glance/appwidget/GlanceAppWidget;", "processEmittableTree", "", "context", "Landroid/content/Context;", "root", "Landroidx/glance/EmittableWithChildren;", "(Landroid/content/Context;Landroidx/glance/EmittableWithChildren;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processEvent", "", "event", "", "(Landroid/content/Context;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "provideGlance", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/glance/GlanceComposable;", "(Landroid/content/Context;)Lkotlin/jvm/functions/Function2;", "runLambda", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAppWidgetOptions", "newOptions", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateGlance", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForReady", "Companion", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class MultiProcessSession extends CoroutineSession {

    @NotNull
    private static final String TAG = "GWT:MultiProcessSession";

    @Nullable
    private final Bundle options;

    @NotNull
    private final AppWidgetSession session;

    @NotNull
    private final AtomicBoolean updatedAtLeastOnce;

    @NotNull
    private final GlanceAppWidget widget;
    public static final int $stable = 8;

    public /* synthetic */ MultiProcessSession(AppWidgetId appWidgetId, GlanceAppWidget glanceAppWidget, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appWidgetId, glanceAppWidget, (i & 4) != 0 ? null : bundle);
    }

    @Override // androidx.glance.appwidget.multiprocess.CoroutineSession
    @NotNull
    public Session getEventSession() {
        return this.session;
    }

    @Nullable
    public final Bundle getOptions() {
        return this.options;
    }

    @NotNull
    /* JADX INFO: renamed from: getUpdatedAtLeastOnce$glance_appwidget_release, reason: from getter */
    public final AtomicBoolean getUpdatedAtLeastOnce() {
        return this.updatedAtLeastOnce;
    }

    @NotNull
    public final GlanceAppWidget getWidget() {
        return this.widget;
    }

    @Override // androidx.glance.session.Session
    @Nullable
    public Object processEmittableTree(@NotNull Context context, @NotNull EmittableWithChildren emittableWithChildren, @NotNull Continuation<? super Boolean> continuation) {
        GlanceLog.INSTANCE.m2301i(TAG, "processEmittableTree-" + getKey());
        if (!IgnoreResultKt.shouldIgnoreResult(emittableWithChildren)) {
            this.updatedAtLeastOnce.set(true);
        }
        return this.session.processEmittableTree(context, emittableWithChildren, continuation);
    }

    @Override // androidx.glance.appwidget.multiprocess.CoroutineSession, androidx.glance.session.Session
    @Nullable
    public Object processEvent(@NotNull Context context, @NotNull Object obj, @NotNull Continuation<? super Unit> continuation) {
        GlanceLog.INSTANCE.m2301i(TAG, "processEvent-" + getKey() + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + obj);
        Object objProcessEvent = this.session.processEvent(context, obj, continuation);
        return objProcessEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessEvent : Unit.INSTANCE;
    }

    @Override // androidx.glance.session.Session
    @NotNull
    /* JADX INFO: renamed from: provideGlance */
    public Function2<Composer, Integer, Unit> mo21926provideGlance(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.session.mo21926provideGlance(context);
    }

    @Nullable
    public final Object runLambda(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        GlanceLog.INSTANCE.m2297d(TAG, "runLambda");
        Object objRunLambda = this.session.runLambda(str, continuation);
        return objRunLambda == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunLambda : Unit.INSTANCE;
    }

    @Nullable
    public final Object updateAppWidgetOptions(@NotNull Bundle bundle, @NotNull Continuation<? super Unit> continuation) {
        GlanceLog.INSTANCE.m2301i(TAG, "updateAppWidgetOptions-" + getKey());
        Object objUpdateAppWidgetOptions = this.session.updateAppWidgetOptions(bundle, continuation);
        return objUpdateAppWidgetOptions == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateAppWidgetOptions : Unit.INSTANCE;
    }

    @Nullable
    public final Object updateGlance(@NotNull Continuation<? super Unit> continuation) {
        GlanceLog.INSTANCE.m2301i(TAG, "updateGlance-" + getKey());
        Object objUpdateGlance = this.session.updateGlance(continuation);
        return objUpdateGlance == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateGlance : Unit.INSTANCE;
    }

    @Nullable
    public final Object waitForReady(@NotNull Continuation<? super Unit> continuation) {
        Object objWaitForReady = this.session.waitForReady(continuation);
        return objWaitForReady == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWaitForReady : Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiProcessSession(@NotNull AppWidgetId key, @NotNull GlanceAppWidget widget, @Nullable Bundle bundle) {
        super(AppWidgetUtilsKt.toSessionKey(key));
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(widget, "widget");
        this.widget = widget;
        this.options = bundle;
        this.session = new AppWidgetSession(widget, key, bundle, null, null, null, false, null, 248, null);
        this.updatedAtLeastOnce = new AtomicBoolean(false);
    }
}
