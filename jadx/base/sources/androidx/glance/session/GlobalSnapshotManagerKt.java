package androidx.glance.session;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u00020\u0003H\u0087@¢\u0006\u0002\u0010\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "globalSnapshotMonitor", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGlobalSnapshotManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlobalSnapshotManager.kt\nandroidx/glance/session/GlobalSnapshotManagerKt\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,85:1\n105#2:86\n82#2,6:87\n106#2,2:93\n92#2:95\n88#2,3:96\n*S KotlinDebug\n*F\n+ 1 GlobalSnapshotManager.kt\nandroidx/glance/session/GlobalSnapshotManagerKt\n*L\n75#1:86\n75#1:87,6\n75#1:93,2\n75#1:95\n75#1:96,3\n*E\n"})
public final class GlobalSnapshotManagerKt {

    @NotNull
    private static final String TAG = "GWT:GlobalSnapshotManager";

    /* JADX INFO: renamed from: androidx.glance.session.GlobalSnapshotManagerKt$globalSnapshotMonitor$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.session.GlobalSnapshotManagerKt", m14021f = "GlobalSnapshotManager.kt", m14022i = {0, 0, 0}, m14023l = {93}, m14024m = "globalSnapshotMonitor", m14025n = {"sent", "observerHandle", "$this$consume$iv$iv"}, m14026s = {"L$0", "L$1", "L$2"})
    public static final class C35011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C35011(Continuation<? super C35011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GlobalSnapshotManagerKt.globalSnapshotMonitor(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b A[Catch: all -> 0x003b, TryCatch #2 {all -> 0x003b, blocks: (B:12:0x0037, B:23:0x0073, B:25:0x007b, B:20:0x0062, B:26:0x008a, B:19:0x005d), top: B:38:0x0023, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008a A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #2 {all -> 0x003b, blocks: (B:12:0x0037, B:23:0x0073, B:25:0x007b, B:20:0x0062, B:26:0x008a, B:19:0x005d), top: B:38:0x0023, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0070 -> B:23:0x0073). Please report as a decompilation issue!!! */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object globalSnapshotMonitor(@NotNull Continuation<? super Unit> continuation) {
        C35011 c35011;
        ObserverHandle observerHandleRegisterGlobalWriteObserver;
        ChannelIterator it;
        AtomicBoolean atomicBoolean;
        ReceiveChannel receiveChannel;
        ReceiveChannel receiveChannel2;
        if (continuation instanceof C35011) {
            c35011 = (C35011) continuation;
            int i = c35011.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c35011.label = i - Integer.MIN_VALUE;
            } else {
                c35011 = new C35011(continuation);
            }
        }
        Object objHasNext = c35011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c35011.label;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objHasNext);
                    final Channel channelChannel$default = ChannelKt.Channel$default(1, null, null, 6, null);
                    final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
                    observerHandleRegisterGlobalWriteObserver = Snapshot.INSTANCE.registerGlobalWriteObserver(new Function1<Object, Unit>() { // from class: androidx.glance.session.GlobalSnapshotManagerKt$globalSnapshotMonitor$observerHandle$1
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
                            if (atomicBoolean2.compareAndSet(false, true)) {
                                channelChannel$default.mo23705trySendJP2dKIU(Unit.INSTANCE);
                            }
                        }
                    });
                    it = channelChannel$default.iterator();
                    atomicBoolean = atomicBoolean2;
                    receiveChannel = channelChannel$default;
                    c35011.L$0 = atomicBoolean;
                    c35011.L$1 = observerHandleRegisterGlobalWriteObserver;
                    c35011.L$2 = receiveChannel;
                    c35011.L$3 = it;
                    c35011.label = 1;
                    objHasNext = it.hasNext(c35011);
                    receiveChannel2 = receiveChannel;
                    if (objHasNext == coroutine_suspended) {
                    }
                    if (((Boolean) objHasNext).booleanValue()) {
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (ChannelIterator) c35011.L$3;
                    ReceiveChannel receiveChannel3 = (ReceiveChannel) c35011.L$2;
                    observerHandleRegisterGlobalWriteObserver = (ObserverHandle) c35011.L$1;
                    atomicBoolean = (AtomicBoolean) c35011.L$0;
                    ResultKt.throwOnFailure(objHasNext);
                    receiveChannel2 = receiveChannel3;
                    if (((Boolean) objHasNext).booleanValue()) {
                        atomicBoolean.set(false);
                        Snapshot.INSTANCE.sendApplyNotifications();
                        receiveChannel = receiveChannel2;
                        c35011.L$0 = atomicBoolean;
                        c35011.L$1 = observerHandleRegisterGlobalWriteObserver;
                        c35011.L$2 = receiveChannel;
                        c35011.L$3 = it;
                        c35011.label = 1;
                        objHasNext = it.hasNext(c35011);
                        receiveChannel2 = receiveChannel;
                        if (objHasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (((Boolean) objHasNext).booleanValue()) {
                            Unit unit = Unit.INSTANCE;
                            ChannelsKt.cancelConsumed(receiveChannel2, null);
                            observerHandleRegisterGlobalWriteObserver.dispose();
                            return Unit.INSTANCE;
                        }
                    }
                }
            } finally {
            }
        } catch (Throwable th) {
            observerHandleRegisterGlobalWriteObserver.dispose();
            throw th;
        }
    }
}
