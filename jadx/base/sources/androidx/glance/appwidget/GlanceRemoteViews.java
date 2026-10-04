package androidx.glance.appwidget;

import android.content.Context;
import android.os.Bundle;
import androidx.compose.runtime.BroadcastFrameClock;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JV\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\b\u0015H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010\u0019R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, m13886d2 = {"Landroidx/glance/appwidget/GlanceRemoteViews;", "", "()V", "layoutConfiguration", "Landroidx/glance/appwidget/LayoutConfiguration;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "compose", "Landroidx/glance/appwidget/RemoteViewsCompositionResult;", "context", "Landroid/content/Context;", "size", "Landroidx/compose/ui/unit/DpSize;", "state", "appWidgetOptions", "Landroid/os/Bundle;", "skipInteraction", "", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "compose-8HUqYh0", "(Landroid/content/Context;JLjava/lang/Object;Landroid/os/Bundle;ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initializeLayoutConfiguration", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@ExperimentalGlanceRemoteViewsApi
@SourceDebugExtension({"SMAP\nGlanceRemoteViews.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceRemoteViews.kt\nandroidx/glance/appwidget/GlanceRemoteViews\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,140:1\n120#2,10:141\n*S KotlinDebug\n*F\n+ 1 GlanceRemoteViews.kt\nandroidx/glance/appwidget/GlanceRemoteViews\n*L\n132#1:141,10\n*E\n"})
public final class GlanceRemoteViews {
    public static final int $stable = 8;

    @Nullable
    private LayoutConfiguration layoutConfiguration;

    @NotNull
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    /* JADX INFO: renamed from: androidx.glance.appwidget.GlanceRemoteViews$initializeLayoutConfiguration$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceRemoteViews", m14021f = "GlanceRemoteViews.kt", m14022i = {0, 0, 0}, m14023l = {146}, m14024m = "initializeLayoutConfiguration", m14025n = {"this", "context", "$this$withLock_u24default$iv"}, m14026s = {"L$0", "L$1", "L$2"})
    public static final class C28651 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C28651(Continuation<? super C28651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GlanceRemoteViews.this.initializeLayoutConfiguration(null, this);
        }
    }

    /* JADX INFO: renamed from: compose-8HUqYh0$default, reason: not valid java name */
    public static /* synthetic */ Object m21295compose8HUqYh0$default(GlanceRemoteViews glanceRemoteViews, Context context, long j, Object obj, Bundle bundle, boolean z, Function2 function2, Continuation continuation, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        Object obj3 = obj;
        if ((i & 8) != 0) {
            bundle = new Bundle();
        }
        return glanceRemoteViews.m21296compose8HUqYh0(context, j, obj3, bundle, (i & 16) != 0 ? false : z, function2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object initializeLayoutConfiguration(Context context, Continuation<? super LayoutConfiguration> continuation) {
        C28651 c28651;
        Mutex mutex;
        GlanceRemoteViews glanceRemoteViews;
        if (continuation instanceof C28651) {
            c28651 = (C28651) continuation;
            int i = c28651.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c28651.label = i - Integer.MIN_VALUE;
            } else {
                c28651 = new C28651(continuation);
            }
        }
        Object obj = c28651.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c28651.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            LayoutConfiguration layoutConfiguration = this.layoutConfiguration;
            if (layoutConfiguration != null) {
                return layoutConfiguration;
            }
            mutex = this.mutex;
            c28651.L$0 = this;
            c28651.L$1 = context;
            c28651.L$2 = mutex;
            c28651.label = 1;
            if (mutex.lock(null, c28651) == coroutine_suspended) {
                return coroutine_suspended;
            }
            glanceRemoteViews = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Mutex mutex2 = (Mutex) c28651.L$2;
            Context context2 = (Context) c28651.L$1;
            glanceRemoteViews = (GlanceRemoteViews) c28651.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            context = context2;
        }
        try {
            LayoutConfiguration layoutConfigurationCreate$glance_appwidget_release = glanceRemoteViews.layoutConfiguration;
            if (layoutConfigurationCreate$glance_appwidget_release == null) {
                layoutConfigurationCreate$glance_appwidget_release = LayoutConfiguration.INSTANCE.create$glance_appwidget_release(context, 0);
            }
            glanceRemoteViews.layoutConfiguration = layoutConfigurationCreate$glance_appwidget_release;
            Intrinsics.checkNotNull(layoutConfigurationCreate$glance_appwidget_release);
            mutex.unlock(null);
            return layoutConfigurationCreate$glance_appwidget_release;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: compose-8HUqYh0, reason: not valid java name */
    public final Object m21296compose8HUqYh0(@NotNull Context context, long j, @Nullable Object obj, @NotNull Bundle bundle, boolean z, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @NotNull Continuation<? super RemoteViewsCompositionResult> continuation) {
        return BuildersKt.withContext(new BroadcastFrameClock(null, 1, null), new GlanceRemoteViews$compose$2(z, this, context, j, obj, bundle, function2, null), continuation);
    }
}
