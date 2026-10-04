package androidx.glance.appwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.glance.EmittableWithChildren;
import androidx.glance.GlanceId;
import androidx.glance.action.LambdaAction;
import androidx.glance.appwidget.LayoutConfiguration;
import androidx.glance.appwidget.multiprocess.MultiProcessSessionManagerKt;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.session.Session;
import androidx.glance.state.ConfigManager;
import androidx.glance.state.GlanceState;
import androidx.glance.state.GlanceStateDefinition;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000 O2\u00020\u0001:\u0005OPQRSBW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\b\u0010-\u001a\u00020.H\u0016J\u0018\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u000200H\u0016J\u001e\u00106\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0096@¢\u0006\u0002\u00107J\u001e\u00108\u001a\u00020\u000f2\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020:H\u0096@¢\u0006\u0002\u0010;J\u001e\u0010<\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u0010=\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010>J%\u0010?\u001a\u0012\u0012\u0004\u0012\u0002000@¢\u0006\u0002\bA¢\u0006\u0002\bB2\u0006\u00101\u001a\u000202H\u0016¢\u0006\u0002\u0010CJ\u0016\u0010D\u001a\u0002002\u0006\u0010E\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010FJ\b\u0010G\u001a\u00020\u001dH\u0016J\u0016\u0010H\u001a\u0002002\u0006\u0010I\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010JJ\u000e\u0010K\u001a\u000200H\u0086@¢\u0006\u0002\u0010LJ\u000e\u0010M\u001a\u00020NH\u0086@¢\u0006\u0002\u0010LR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00118B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0!X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R/\u0010%\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010\u001a\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006T²\u0006\n\u0010U\u001a\u00020VX\u008a\u008e\u0002²\u0006\n\u0010W\u001a\u00020\u000fX\u008a\u0084\u0002"}, m13886d2 = {"Landroidx/glance/appwidget/AppWidgetSession;", "Landroidx/glance/session/Session;", "widget", "Landroidx/glance/appwidget/GlanceAppWidget;", "id", "Landroidx/glance/appwidget/AppWidgetId;", "initialOptions", "Landroid/os/Bundle;", "configManager", "Landroidx/glance/state/ConfigManager;", "lambdaReceiver", "Landroid/content/ComponentName;", "sizeMode", "Landroidx/glance/appwidget/SizeMode;", "shouldPublish", "", "initialGlanceState", "", "(Landroidx/glance/appwidget/GlanceAppWidget;Landroidx/glance/appwidget/AppWidgetId;Landroid/os/Bundle;Landroidx/glance/state/ConfigManager;Landroid/content/ComponentName;Landroidx/glance/appwidget/SizeMode;ZLjava/lang/Object;)V", "<set-?>", "glanceState", "getGlanceState", "()Ljava/lang/Object;", "setGlanceState", "(Ljava/lang/Object;)V", "glanceState$delegate", "Landroidx/compose/runtime/MutableState;", "lambdas", "", "", "", "Landroidx/glance/action/LambdaAction;", "lastRemoteViews", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroid/widget/RemoteViews;", "getLastRemoteViews$glance_appwidget_release", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "options", "getOptions", "()Landroid/os/Bundle;", "setOptions", "(Landroid/os/Bundle;)V", "options$delegate", "parentJob", "Lkotlinx/coroutines/CompletableJob;", "createRootEmittable", "Landroidx/glance/appwidget/RemoteViewsRoot;", "notifyWidgetOfError", "", "context", "Landroid/content/Context;", "throwable", "", "onClosed", "onCompositionError", "(Landroid/content/Context;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processEmittableTree", "root", "Landroidx/glance/EmittableWithChildren;", "(Landroid/content/Context;Landroidx/glance/EmittableWithChildren;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processEvent", "event", "(Landroid/content/Context;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "provideGlance", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/glance/GlanceComposable;", "(Landroid/content/Context;)Lkotlin/jvm/functions/Function2;", "runLambda", "key", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "updateAppWidgetOptions", "newOptions", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateGlance", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForReady", "Lkotlinx/coroutines/Job;", "Companion", "RunLambda", "UpdateAppWidgetOptions", "UpdateGlanceState", "WaitForReady", "glance-appwidget_release", "minSize", "Landroidx/compose/ui/unit/DpSize;", "configIsReady"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAppWidgetSession.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppWidgetSession.kt\nandroidx/glance/appwidget/AppWidgetSession\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 3 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot$Companion\n+ 4 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,337:1\n81#2:338\n107#2,2:339\n81#2:341\n107#2,2:342\n437#3,3:344\n441#3,3:353\n437#3,3:356\n441#3,3:365\n437#3,3:368\n441#3,3:378\n129#4,5:347\n129#4,5:359\n129#4,3:371\n133#4:376\n1#5:352\n1#5:364\n1#5:377\n1#5:381\n1855#6,2:374\n*S KotlinDebug\n*F\n+ 1 AppWidgetSession.kt\nandroidx/glance/appwidget/AppWidgetSession\n*L\n104#1:338\n104#1:339,2\n105#1:341\n105#1:342,2\n227#1:344,3\n227#1:353,3\n239#1:356,3\n239#1:365,3\n245#1:368,3\n245#1:378,3\n227#1:347,5\n239#1:359,5\n245#1:371,3\n245#1:376\n227#1:352\n239#1:364\n245#1:377\n246#1:374,2\n*E\n"})
public final class AppWidgetSession extends Session {

    @Deprecated
    public static final boolean DEBUG = true;

    @Deprecated
    @NotNull
    public static final String TAG = "GWT:AppWidgetSession";

    @NotNull
    private final ConfigManager configManager;

    /* JADX INFO: renamed from: glanceState$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState glanceState;

    @NotNull
    private final AppWidgetId id;

    @Nullable
    private final ComponentName lambdaReceiver;

    @NotNull
    private Map<String, ? extends List<LambdaAction>> lambdas;

    @NotNull
    private final MutableStateFlow<RemoteViews> lastRemoteViews;

    /* JADX INFO: renamed from: options$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState options;

    @NotNull
    private final CompletableJob parentJob;
    private final boolean shouldPublish;

    @NotNull
    private final SizeMode sizeMode;

    @NotNull
    private final GlanceAppWidget widget;

    @NotNull
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/appwidget/AppWidgetSession$Companion;", "", "()V", "DEBUG", "", SearchConstants.TargetContents.TAG, "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/appwidget/AppWidgetSession$RunLambda;", "", "key", "", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @VisibleForTesting
    public static final class RunLambda {
        public static final int $stable = 0;

        @NotNull
        private final String key;

        public RunLambda(@NotNull String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/appwidget/AppWidgetSession$UpdateAppWidgetOptions;", "", "newOptions", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "getNewOptions", "()Landroid/os/Bundle;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @VisibleForTesting
    public static final class UpdateAppWidgetOptions {
        public static final int $stable = 8;

        @NotNull
        private final Bundle newOptions;

        public UpdateAppWidgetOptions(@NotNull Bundle newOptions) {
            Intrinsics.checkNotNullParameter(newOptions, "newOptions");
            this.newOptions = newOptions;
        }

        @NotNull
        public final Bundle getNewOptions() {
            return this.newOptions;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/appwidget/AppWidgetSession$UpdateGlanceState;", "", "()V", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @VisibleForTesting
    public static final class UpdateGlanceState {
        public static final int $stable = 0;

        @NotNull
        public static final UpdateGlanceState INSTANCE = new UpdateGlanceState();

        private UpdateGlanceState() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/appwidget/AppWidgetSession$WaitForReady;", "", "job", "Lkotlinx/coroutines/CompletableJob;", "(Lkotlinx/coroutines/CompletableJob;)V", "getJob", "()Lkotlinx/coroutines/CompletableJob;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @VisibleForTesting
    public static final class WaitForReady {
        public static final int $stable = 8;

        @NotNull
        private final CompletableJob job;

        public WaitForReady(@NotNull CompletableJob job) {
            Intrinsics.checkNotNullParameter(job, "job");
            this.job = job;
        }

        @NotNull
        public final CompletableJob getJob() {
            return this.job;
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.AppWidgetSession$processEmittableTree$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.AppWidgetSession", m14021f = "AppWidgetSession.kt", m14022i = {0, 0, 0}, m14023l = {180, 210, 210, 210, 210}, m14024m = "processEmittableTree", m14025n = {"this", "context", "root"}, m14026s = {"L$0", "L$1", "L$2"})
    public static final class C28261 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C28261(Continuation<? super C28261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppWidgetSession.this.processEmittableTree(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.AppWidgetSession$processEvent$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.AppWidgetSession", m14021f = "AppWidgetSession.kt", m14022i = {0}, m14023l = {JPEG.APP1}, m14024m = "processEvent", m14025n = {"this"}, m14026s = {"L$0"})
    public static final class C28271 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C28271(Continuation<? super C28271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppWidgetSession.this.processEvent(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.AppWidgetSession$waitForReady$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.AppWidgetSession", m14021f = "AppWidgetSession.kt", m14022i = {0}, m14023l = {291}, m14024m = "waitForReady", m14025n = {"event"}, m14026s = {"L$0"})
    public static final class C28291 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C28291(Continuation<? super C28291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppWidgetSession.this.waitForReady(this);
        }
    }

    public /* synthetic */ AppWidgetSession(GlanceAppWidget glanceAppWidget, AppWidgetId appWidgetId, Bundle bundle, ConfigManager configManager, ComponentName componentName, SizeMode sizeMode, boolean z, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(glanceAppWidget, appWidgetId, (i & 4) != 0 ? null : bundle, (i & 8) != 0 ? GlanceState.INSTANCE : configManager, (i & 16) != 0 ? null : componentName, (i & 32) != 0 ? glanceAppWidget.getSizeMode() : sizeMode, (i & 64) != 0 ? true : z, (i & 128) != 0 ? null : obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getGlanceState() {
        return this.glanceState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Bundle getOptions() {
        return (Bundle) this.options.getValue();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void notifyWidgetOfError(Context context, Throwable throwable) throws Throwable {
        AppWidgetUtilsKt.logException(throwable);
        if (!this.shouldPublish) {
            throw throwable;
        }
        GlanceAppWidget glanceAppWidget = this.widget;
        AppWidgetId appWidgetId = this.id;
        glanceAppWidget.onCompositionError(context, appWidgetId, appWidgetId.getAppWidgetId(), throwable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setGlanceState(Object obj) {
        this.glanceState.setValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setOptions(Bundle bundle) {
        this.options.setValue(bundle);
    }

    @NotNull
    public final MutableStateFlow<RemoteViews> getLastRemoteViews$glance_appwidget_release() {
        return this.lastRemoteViews;
    }

    @Override // androidx.glance.session.Session
    public void onClosed() {
        Job.DefaultImpls.cancel$default((Job) this.parentJob, (CancellationException) null, 1, (Object) null);
    }

    @Override // androidx.glance.session.Session
    @Nullable
    public Object onCompositionError(@NotNull Context context, @NotNull Throwable th, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        notifyWidgetOfError(context, th);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:(4:18|60|77|78)(1:(2:15|16)(3:17|72|73)))(1:19))(2:20|(2:22|23)(3:24|(1:27)|76))|28|85|29|(2:31|(1:33)(2:40|41))|34|42|43|83|44|45|86|46|(4:48|49|88|50)(1:55)|56|57|(3:(0)|(0)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f3, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f4, code lost:
    
        r5 = r3;
        r3 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00f7, code lost:
    
        r16 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00fb, code lost:
    
        r5 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00fc, code lost:
    
        r16 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0189, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x019f, code lost:
    
        if (r5.save(r6) == r7) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01a8, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01a9, code lost:
    
        r3 = r16;
        r5 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01af, code lost:
    
        r16 = true;
        r5 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01c4, code lost:
    
        if (r5.save(r6) == r7) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01d5, code lost:
    
        if (r5.save(r6) != r7) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01eb, code lost:
    
        if (r5.save(r6) == r7) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    @Override // androidx.glance.session.Session
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object processEmittableTree(@NotNull Context context, @NotNull EmittableWithChildren emittableWithChildren, @NotNull Continuation<? super Boolean> continuation) throws Throwable {
        C28261 c28261;
        Context context2;
        AppWidgetSession appWidgetSession;
        EmittableWithChildren emittableWithChildren2;
        boolean z;
        if (continuation instanceof C28261) {
            c28261 = (C28261) continuation;
            int i = c28261.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c28261.label = i - Integer.MIN_VALUE;
            } else {
                c28261 = new C28261(continuation);
            }
        }
        Object objLoad$glance_appwidget_release = c28261.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c28261.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objLoad$glance_appwidget_release);
            if (IgnoreResultKt.shouldIgnoreResult(emittableWithChildren)) {
                GlanceLog.INSTANCE.m2301i(TAG, "processEmittableTree-" + this.id + " is ignored");
                return Boxing.boxBoolean(false);
            }
            GlanceLog.INSTANCE.m2301i(TAG, "processEmittableTree / " + this.id + " / " + MultiProcessSessionManagerKt.getCurrentThread());
            Intrinsics.checkNotNull(emittableWithChildren, "null cannot be cast to non-null type androidx.glance.appwidget.RemoteViewsRoot");
            LayoutConfiguration.Companion companion = LayoutConfiguration.INSTANCE;
            int appWidgetId = this.id.getAppWidgetId();
            c28261.L$0 = this;
            c28261.L$1 = context;
            c28261.L$2 = emittableWithChildren;
            c28261.label = 1;
            objLoad$glance_appwidget_release = companion.load$glance_appwidget_release(context, appWidgetId, c28261);
            if (objLoad$glance_appwidget_release != coroutine_suspended) {
                context2 = context;
                appWidgetSession = this;
                emittableWithChildren2 = emittableWithChildren;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 == 2 || i2 == 3 || i2 == 4) {
                ResultKt.throwOnFailure(objLoad$glance_appwidget_release);
                z = true;
                Tracing.INSTANCE.endGlanceAppWidgetUpdate();
                return Boxing.boxBoolean(z);
            }
            if (i2 != 5) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            th = (Throwable) c28261.L$0;
            ResultKt.throwOnFailure(objLoad$glance_appwidget_release);
            Tracing.INSTANCE.endGlanceAppWidgetUpdate();
            throw th;
        }
        emittableWithChildren2 = (EmittableWithChildren) c28261.L$2;
        Context context3 = (Context) c28261.L$1;
        appWidgetSession = (AppWidgetSession) c28261.L$0;
        ResultKt.throwOnFailure(objLoad$glance_appwidget_release);
        context2 = context3;
        LayoutConfiguration layoutConfiguration = (LayoutConfiguration) objLoad$glance_appwidget_release;
        AppWidgetManager appWidgetManager = AppWidgetUtilsKt.getAppWidgetManager(context2);
        ComponentName componentName = appWidgetSession.lambdaReceiver;
        if (componentName == null) {
            AppWidgetProviderInfo appWidgetInfo = appWidgetManager.getAppWidgetInfo(appWidgetSession.id.getAppWidgetId());
            if (appWidgetInfo == null) {
                throw new IllegalArgumentException(("No app widget info for " + appWidgetSession.id.getAppWidgetId()).toString());
            }
            componentName = appWidgetInfo.provider;
        }
        ComponentName componentName2 = componentName;
        NormalizeCompositionTreeKt.normalizeCompositionTree((RemoteViewsRoot) emittableWithChildren2);
        appWidgetSession.lambdas = NormalizeCompositionTreeKt.updateLambdaActionKeys(emittableWithChildren2);
        RemoteViews remoteViewsM21316translateComposition_rDzMTw = RemoteViewsTranslatorKt.m21316translateComposition_rDzMTw(context2, appWidgetSession.id.getAppWidgetId(), (RemoteViewsRoot) emittableWithChildren2, layoutConfiguration, layoutConfiguration.addLayout(emittableWithChildren2), DpSize.INSTANCE.m21075getUnspecifiedMYxV2XQ(), (128 & 64) != 0 ? null : componentName2, (128 & 128) != 0 ? false : false);
        Context context4 = context2;
        LayoutConfiguration layoutConfiguration2 = layoutConfiguration;
        if (appWidgetSession.shouldPublish) {
            GlanceLog.Companion companion2 = GlanceLog.INSTANCE;
            int appWidgetId2 = appWidgetSession.id.getAppWidgetId();
            z = true;
            try {
                companion2.m2301i(TAG, "UpdateAppWidget / " + appWidgetId2 + SQLKeyword.COMMA + remoteViewsM21316translateComposition_rDzMTw + " / lastViewId : " + RemoteViewsTranslatorKt.getLastUsedViewId());
                appWidgetManager.updateAppWidget(appWidgetSession.id.getAppWidgetId(), remoteViewsM21316translateComposition_rDzMTw);
            } catch (CancellationException unused) {
                c28261.L$0 = null;
                c28261.L$1 = null;
                c28261.L$2 = null;
                c28261.label = 3;
            } catch (Throwable th) {
                th = th;
                try {
                    appWidgetSession.notifyWidgetOfError(context4, th);
                    c28261.L$0 = null;
                    c28261.L$1 = null;
                    c28261.L$2 = null;
                    c28261.label = 4;
                } catch (Throwable th2) {
                    th = th2;
                    c28261.L$0 = th;
                    c28261.L$1 = null;
                    c28261.L$2 = null;
                    c28261.label = 5;
                }
            }
        } else {
            z = true;
        }
        appWidgetSession.lastRemoteViews.setValue(remoteViewsM21316translateComposition_rDzMTw);
        c28261.L$0 = null;
        c28261.L$1 = null;
        c28261.L$2 = null;
        c28261.label = 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.glance.session.Session
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object processEvent(@NotNull Context context, @NotNull Object obj, @NotNull Continuation<? super Unit> continuation) {
        C28271 c28271;
        MutableSnapshot mutableSnapshotTakeMutableSnapshot$default;
        Snapshot snapshotMakeCurrent;
        AppWidgetSession appWidgetSession;
        if (continuation instanceof C28271) {
            c28271 = (C28271) continuation;
            int i = c28271.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c28271.label = i - Integer.MIN_VALUE;
            } else {
                c28271 = new C28271(continuation);
            }
        }
        Object value = c28271.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c28271.label;
        Unit unit = null;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(value);
                    if (!(obj instanceof UpdateGlanceState)) {
                        if (obj instanceof UpdateAppWidgetOptions) {
                            GlanceLog.INSTANCE.m2301i(TAG, "Received UpdateAppWidgetOptions(" + ((UpdateAppWidgetOptions) obj).getNewOptions() + ") eventfor session(" + getKey() + ")");
                            mutableSnapshotTakeMutableSnapshot$default = Snapshot.Companion.takeMutableSnapshot$default(Snapshot.INSTANCE, null, null, 3, null);
                            try {
                                snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot$default.makeCurrent();
                                try {
                                    setOptions(((UpdateAppWidgetOptions) obj).getNewOptions());
                                    Unit unit2 = Unit.INSTANCE;
                                    mutableSnapshotTakeMutableSnapshot$default.restoreCurrent(snapshotMakeCurrent);
                                    mutableSnapshotTakeMutableSnapshot$default.apply().check();
                                    mutableSnapshotTakeMutableSnapshot$default.dispose();
                                } finally {
                                }
                            } finally {
                            }
                        } else if (obj instanceof RunLambda) {
                            RunLambda runLambda = (RunLambda) obj;
                            GlanceLog.INSTANCE.m2301i(TAG, AbstractC0541b.m775q("Received RunLambda(", runLambda.getKey(), ") action for session(", getKey(), ")"));
                            mutableSnapshotTakeMutableSnapshot$default = Snapshot.Companion.takeMutableSnapshot$default(Snapshot.INSTANCE, null, null, 3, null);
                            try {
                                snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot$default.makeCurrent();
                                try {
                                    List<LambdaAction> list = this.lambdas.get(((RunLambda) obj).getKey());
                                    if (list != null) {
                                        Iterator<T> it = list.iterator();
                                        while (it.hasNext()) {
                                            ((LambdaAction) it.next()).getBlock().invoke();
                                        }
                                        unit = Unit.INSTANCE;
                                    }
                                    mutableSnapshotTakeMutableSnapshot$default.restoreCurrent(snapshotMakeCurrent);
                                    mutableSnapshotTakeMutableSnapshot$default.apply().check();
                                    mutableSnapshotTakeMutableSnapshot$default.dispose();
                                    if (unit == null) {
                                        GlanceLog.INSTANCE.m2305w(TAG, AbstractC0541b.m775q("Triggering Action(", runLambda.getKey(), ") for session(", getKey(), ") failed"));
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            } finally {
                            }
                        } else {
                            if (!(obj instanceof WaitForReady)) {
                                throw new IllegalArgumentException(AbstractC0541b.m768j(obj.getClass(), "Sent unrecognized event type ", " to AppWidgetSession"));
                            }
                            CompletableJob job = ((WaitForReady) obj).getJob();
                            if (job.isActive()) {
                                job.complete();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    GlanceLog.INSTANCE.m2301i(TAG, "Received UpdateGlanceState event for session(" + getKey() + ")");
                    GlanceStateDefinition<?> stateDefinition = this.widget.getStateDefinition();
                    if (stateDefinition != null) {
                        ConfigManager configManager = this.configManager;
                        String key = getKey();
                        c28271.L$0 = this;
                        c28271.label = 1;
                        value = configManager.getValue(context, stateDefinition, key, c28271);
                        if (value == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        appWidgetSession = this;
                    } else {
                        appWidgetSession = this;
                        value = null;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    appWidgetSession = (AppWidgetSession) c28271.L$0;
                    ResultKt.throwOnFailure(value);
                }
                appWidgetSession.setGlanceState(value);
                Unit unit3 = Unit.INSTANCE;
                mutableSnapshotTakeMutableSnapshot$default.restoreCurrent(snapshotMakeCurrent);
                mutableSnapshotTakeMutableSnapshot$default.apply().check();
                return Unit.INSTANCE;
            } finally {
            }
            snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot$default.makeCurrent();
        } finally {
        }
        mutableSnapshotTakeMutableSnapshot$default = Snapshot.Companion.takeMutableSnapshot$default(Snapshot.INSTANCE, null, null, 3, null);
    }

    @Override // androidx.glance.session.Session
    @NotNull
    /* JADX INFO: renamed from: provideGlance */
    public Function2<Composer, Integer, Unit> mo21926provideGlance(@NotNull final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ComposableLambdaKt.composableLambdaInstance(-1784282257, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.AppWidgetSession.provideGlance.1

            /* JADX INFO: renamed from: androidx.glance.appwidget.AppWidgetSession$provideGlance$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, m13886d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
            @SourceDebugExtension({"SMAP\nAppWidgetSession.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppWidgetSession.kt\nandroidx/glance/appwidget/AppWidgetSession$provideGlance$1$1\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 4 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 5 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,337:1\n74#2:338\n25#3:339\n25#3:346\n1116#4,6:340\n1116#4,6:347\n81#5:353\n107#5,2:354\n81#5:356\n*S KotlinDebug\n*F\n+ 1 AppWidgetSession.kt\nandroidx/glance/appwidget/AppWidgetSession$provideGlance$1$1\n*L\n123#1:338\n124#1:339\n153#1:346\n124#1:340,6\n153#1:347,6\n124#1:353\n124#1:354,2\n125#1:356\n*E\n"})
            public static final class AnonymousClass1 extends Lambda implements Function2<Composer, Integer, Unit> {
                final /* synthetic */ Context $context;
                final /* synthetic */ AppWidgetSession this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(AppWidgetSession appWidgetSession, Context context) {
                    super(2);
                    this.this$0 = appWidgetSession;
                    this.$context = context;
                }

                private static final long invoke$lambda$1(MutableState<DpSize> mutableState) {
                    return mutableState.getValue().getPackedValue();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void invoke$lambda$2(MutableState<DpSize> mutableState, long j) {
                    mutableState.setValue(DpSize.m21054boximpl(j));
                }

                private static final boolean invoke$lambda$3(State<Boolean> state) {
                    return state.getValue().booleanValue();
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i) {
                    Composer composer2;
                    if ((i & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1688971311, i, -1, "androidx.glance.appwidget.AppWidgetSession.provideGlance.<anonymous>.<anonymous> (AppWidgetSession.kt:122)");
                    }
                    AppWidgetUtilsKt.setCurrentDensity(this.this$0.id.getAppWidgetId(), ((Number) composer.consume(CompositionLocalsKt.getLocalDensity())).floatValue());
                    composer.startReplaceableGroup(-492369756);
                    Object objRememberedValue = composer.rememberedValue();
                    Composer.Companion companion = Composer.INSTANCE;
                    Unit unit = null;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DpSize.m21054boximpl(DpSize.INSTANCE.m21076getZeroMYxV2XQ()), null, 2, null);
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    composer.endReplaceableGroup();
                    MutableState mutableState = (MutableState) objRememberedValue;
                    if (invoke$lambda$3(SnapshotStateKt.produceState(Boolean.FALSE, new AppWidgetSession$provideGlance$1$1$configIsReady$2(this.this$0, this.$context, mutableState, null), composer, 70))) {
                        composer.startReplaceableGroup(-1186214796);
                        AppWidgetSession appWidgetSession = this.this$0;
                        Context context = this.$context;
                        composer.startReplaceableGroup(-492369756);
                        Object objRememberedValue2 = composer.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = AppWidgetUtilsKt.runGlance(appWidgetSession.widget, context, appWidgetSession.id);
                            composer.updateRememberedValue(objRememberedValue2);
                        }
                        composer.endReplaceableGroup();
                        composer2 = composer;
                        Function2 function2 = (Function2) SnapshotStateKt.collectAsState((Flow) objRememberedValue2, null, null, composer2, 56, 2).getValue();
                        composer2.startReplaceableGroup(-1186214665);
                        if (function2 != null) {
                            AppWidgetSession appWidgetSession2 = this.this$0;
                            GlanceLog.INSTANCE.m2301i(AppWidgetSession.TAG, "widget-" + appWidgetSession2.id + " collectAsState " + function2);
                            SizeBoxKt.m21318ForEachSizeeVKgIn8(appWidgetSession2.sizeMode, invoke$lambda$1(mutableState), function2, composer2, 0);
                            composer2 = composer2;
                            unit = Unit.INSTANCE;
                        }
                        composer2.endReplaceableGroup();
                        if (unit == null) {
                            IgnoreResultKt.IgnoreResult(composer2, 0);
                        }
                        composer2.endReplaceableGroup();
                    } else {
                        composer2 = composer;
                        composer2.startReplaceableGroup(-1186214473);
                        IgnoreResultKt.IgnoreResult(composer2, 0);
                        composer2.endReplaceableGroup();
                    }
                    final AppWidgetSession appWidgetSession3 = this.this$0;
                    EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.glance.appwidget.AppWidgetSession.provideGlance.1.1.3
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
                            appWidgetSession3.getGlanceState();
                        }
                    }, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }

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
                    ComposerKt.traceEventStart(-1784282257, i, -1, "androidx.glance.appwidget.AppWidgetSession.provideGlance.<anonymous> (AppWidgetSession.kt:113)");
                }
                Bundle options = AppWidgetSession.this.getOptions();
                float fExtractDisplayDensity = options != null ? androidx.glance.oneui.common.AppWidgetUtilsKt.extractDisplayDensity(options) : 0.0f;
                if (fExtractDisplayDensity == 0.0f) {
                    fExtractDisplayDensity = context.getResources().getDisplayMetrics().density;
                }
                ProvidedValue<Context> providedValueProvides = androidx.glance.CompositionLocalsKt.getLocalContext().provides(context);
                ProvidedValue<GlanceId> providedValueProvides2 = androidx.glance.CompositionLocalsKt.getLocalGlanceId().provides(AppWidgetSession.this.id);
                ProvidableCompositionLocal<Bundle> localAppWidgetOptions = CompositionLocalsKt.getLocalAppWidgetOptions();
                Bundle options2 = AppWidgetSession.this.getOptions();
                if (options2 == null) {
                    options2 = Bundle.EMPTY;
                }
                Intrinsics.checkNotNull(options2);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{providedValueProvides, providedValueProvides2, localAppWidgetOptions.provides(options2), CompositionLocalsKt.getLocalDensity().provides(Float.valueOf(fExtractDisplayDensity)), androidx.glance.CompositionLocalsKt.getLocalState().provides(AppWidgetSession.this.getGlanceState())}, ComposableLambdaKt.composableLambda(composer, 1688971311, true, new AnonymousClass1(AppWidgetSession.this, context)), composer, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    @Nullable
    public final Object runLambda(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        Object objSendEvent = sendEvent(new RunLambda(str), continuation);
        return objSendEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendEvent : Unit.INSTANCE;
    }

    @NotNull
    public String toString() {
        String str = "AppWidgetSession{" + Integer.toHexString(System.identityHashCode(this)) + " id=" + this.id.getAppWidgetId() + " widget=" + this.widget.getClass().getName() + " }";
        Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        return str;
    }

    @Nullable
    public final Object updateAppWidgetOptions(@NotNull Bundle bundle, @NotNull Continuation<? super Unit> continuation) {
        Object objSendEvent = sendEvent(new UpdateAppWidgetOptions(bundle), continuation);
        return objSendEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendEvent : Unit.INSTANCE;
    }

    @Nullable
    public final Object updateGlance(@NotNull Continuation<? super Unit> continuation) {
        Object objSendEvent = sendEvent(UpdateGlanceState.INSTANCE, continuation);
        return objSendEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendEvent : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object waitForReady(@NotNull Continuation<? super Job> continuation) {
        C28291 c28291;
        WaitForReady waitForReady;
        if (continuation instanceof C28291) {
            c28291 = (C28291) continuation;
            int i = c28291.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c28291.label = i - Integer.MIN_VALUE;
            } else {
                c28291 = new C28291(continuation);
            }
        }
        Object obj = c28291.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c28291.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            WaitForReady waitForReady2 = new WaitForReady(JobKt.Job((Job) this.parentJob));
            c28291.L$0 = waitForReady2;
            c28291.label = 1;
            if (sendEvent(waitForReady2, c28291) == coroutine_suspended) {
                return coroutine_suspended;
            }
            waitForReady = waitForReady2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            waitForReady = (WaitForReady) c28291.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return waitForReady.getJob();
    }

    @Override // androidx.glance.session.Session
    @NotNull
    public RemoteViewsRoot createRootEmittable() {
        return new RemoteViewsRoot(50);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppWidgetSession(@NotNull GlanceAppWidget widget, @NotNull AppWidgetId id, @Nullable Bundle bundle, @NotNull ConfigManager configManager, @Nullable ComponentName componentName, @NotNull SizeMode sizeMode, boolean z, @Nullable Object obj) {
        super(AppWidgetUtilsKt.toSessionKey(id));
        Intrinsics.checkNotNullParameter(widget, "widget");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(configManager, "configManager");
        Intrinsics.checkNotNullParameter(sizeMode, "sizeMode");
        this.widget = widget;
        this.id = id;
        this.configManager = configManager;
        this.lambdaReceiver = componentName;
        this.sizeMode = sizeMode;
        this.shouldPublish = z;
        if (AppWidgetUtilsKt.isFakeId(id)) {
            if (componentName == null) {
                throw new IllegalArgumentException("If the AppWidgetSession is not created for a bound widget, you must provide a lambda action receiver");
            }
            if (z) {
                throw new IllegalArgumentException("Cannot publish RemoteViews to AppWidgetManager since we are not running for a bound widget");
            }
        }
        this.glanceState = SnapshotStateKt.mutableStateOf(obj, SnapshotStateKt.neverEqualPolicy());
        this.options = SnapshotStateKt.mutableStateOf(bundle, SnapshotStateKt.neverEqualPolicy());
        this.lambdas = MapsKt.emptyMap();
        this.parentJob = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.lastRemoteViews = StateFlowKt.MutableStateFlow(null);
    }
}
