package androidx.window.layout;

import android.app.Activity;
import androidx.arch.core.executor.ExecutorC0579a;
import androidx.core.util.Consumer;
import androidx.window.layout.WindowInfoTrackerImpl;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Landroidx/window/layout/WindowInfoTrackerImpl;", "Landroidx/window/layout/WindowInfoTracker;", "windowMetricsCalculator", "Landroidx/window/layout/WindowMetricsCalculator;", "windowBackend", "Landroidx/window/layout/WindowBackend;", "(Landroidx/window/layout/WindowMetricsCalculator;Landroidx/window/layout/WindowBackend;)V", "windowLayoutInfo", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/layout/WindowLayoutInfo;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "Companion", "window_release"}, m13887k = 1, m13888mv = {1, 6, 0}, m13890xi = 48)
public final class WindowInfoTrackerImpl implements WindowInfoTracker {
    private static final int BUFFER_CAPACITY = 10;

    @NotNull
    private final WindowBackend windowBackend;

    @NotNull
    private final WindowMetricsCalculator windowMetricsCalculator;

    /* JADX INFO: renamed from: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/window/layout/WindowLayoutInfo;"}, m13887k = 3, m13888mv = {1, 6, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", m14021f = "WindowInfoTrackerImpl.kt", m14022i = {0, 0, 1, 1}, m14023l = {54, 55}, m14024m = "invokeSuspend", m14025n = {"$this$flow", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "$this$flow", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER}, m14026s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class C40231 extends SuspendLambda implements Function2<FlowCollector<? super WindowLayoutInfo>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C40231(Activity activity, Continuation<? super C40231> continuation) {
            super(2, continuation);
            this.$activity = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invokeSuspend$lambda-0, reason: not valid java name */
        public static final void m22073invokeSuspend$lambda0(Channel channel, WindowLayoutInfo info) {
            Intrinsics.checkNotNullExpressionValue(info, "info");
            channel.mo23705trySendJP2dKIU(info);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C40231 c40231 = WindowInfoTrackerImpl.this.new C40231(this.$activity, continuation);
            c40231.L$0 = obj;
            return c40231;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0091, code lost:
        
            if (r5.emit(r11, r10) == r0) goto L26;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x007f A[Catch: all -> 0x001f, TRY_LEAVE, TryCatch #0 {all -> 0x001f, blocks: (B:7:0x001a, B:18:0x0065, B:22:0x0077, B:24:0x007f, B:14:0x0036, B:17:0x0061), top: B:31:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0091 -> B:8:0x001d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            FlowCollector flowCollector;
            Consumer<WindowLayoutInfo> consumer;
            ChannelIterator it;
            FlowCollector flowCollector2;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    flowCollector = (FlowCollector) this.L$0;
                    final Channel channelChannel$default = ChannelKt.Channel$default(10, BufferOverflow.DROP_OLDEST, null, 4, null);
                    consumer = new Consumer() { // from class: androidx.window.layout.a
                        @Override // androidx.core.util.Consumer
                        public final void accept(Object obj2) {
                            WindowInfoTrackerImpl.C40231.m22073invokeSuspend$lambda0(channelChannel$default, (WindowLayoutInfo) obj2);
                        }
                    };
                    WindowInfoTrackerImpl.this.windowBackend.registerLayoutChangeCallback(this.$activity, new ExecutorC0579a(2), consumer);
                    it = channelChannel$default.iterator();
                    this.L$0 = flowCollector;
                    this.L$1 = consumer;
                    this.L$2 = it;
                    this.label = 1;
                    objHasNext = it.hasNext(this);
                    if (objHasNext != coroutine_suspended) {
                    }
                } else if (i == 1) {
                    it = (ChannelIterator) this.L$2;
                    consumer = (Consumer) this.L$1;
                    flowCollector2 = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) obj).booleanValue()) {
                    }
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (ChannelIterator) this.L$2;
                    consumer = (Consumer) this.L$1;
                    flowCollector2 = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    flowCollector = flowCollector2;
                    this.L$0 = flowCollector;
                    this.L$1 = consumer;
                    this.L$2 = it;
                    this.label = 1;
                    objHasNext = it.hasNext(this);
                    if (objHasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowCollector2 = flowCollector;
                    obj = objHasNext;
                    if (((Boolean) obj).booleanValue()) {
                        WindowInfoTrackerImpl.this.windowBackend.unregisterLayoutChangeCallback(consumer);
                        return Unit.INSTANCE;
                    }
                    WindowLayoutInfo windowLayoutInfo = (WindowLayoutInfo) it.next();
                    this.L$0 = flowCollector2;
                    this.L$1 = consumer;
                    this.L$2 = it;
                    this.label = 2;
                }
            } catch (Throwable th) {
                WindowInfoTrackerImpl.this.windowBackend.unregisterLayoutChangeCallback(consumer);
                throw th;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull FlowCollector<? super WindowLayoutInfo> flowCollector, @Nullable Continuation<? super Unit> continuation) {
            return ((C40231) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public WindowInfoTrackerImpl(@NotNull WindowMetricsCalculator windowMetricsCalculator, @NotNull WindowBackend windowBackend) {
        Intrinsics.checkNotNullParameter(windowMetricsCalculator, "windowMetricsCalculator");
        Intrinsics.checkNotNullParameter(windowBackend, "windowBackend");
        this.windowMetricsCalculator = windowMetricsCalculator;
        this.windowBackend = windowBackend;
    }

    @Override // androidx.window.layout.WindowInfoTracker
    @NotNull
    public Flow<WindowLayoutInfo> windowLayoutInfo(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return FlowKt.flow(new C40231(activity, null));
    }
}
