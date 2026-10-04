package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.messaging.Constants;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00000\u0002B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\tH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\tH\u0000¢\u0006\u0004\b\u001f\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\tH\u0000¢\u0006\u0002\b!J\u001a\u0010\"\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u0011H\u0002J\u0017\u0010$\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\tH\u0000¢\u0006\u0002\b%J\u001f\u0010&\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0002\b'J)\u0010(\u001a\u00020)2\u0006\u0010\u0017\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u00112\b\u0010+\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0002\b,J!\u0010-\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0002\b/J\"\u00100\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0016J\u0016\u00105\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\u0006\u00106\u001a\u00020)R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010X\u0082\u0004R\u0014\u0010\u0012\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00067"}, m13886d2 = {"Lkotlinx/coroutines/channels/ChannelSegment;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/internal/Segment;", "id", "", "prev", NetworkConfig.CLIENTS_CHANNEL, "Lkotlinx/coroutines/channels/BufferedChannel;", "pointers", "", "<init>", "(JLkotlinx/coroutines/channels/ChannelSegment;Lkotlinx/coroutines/channels/BufferedChannel;I)V", "_channel", "getChannel", "()Lkotlinx/coroutines/channels/BufferedChannel;", "data", "Lkotlinx/atomicfu/AtomicArray;", "", "numberOfSlots", "getNumberOfSlots", "()I", "storeElement", "", "index", "element", "storeElement$kotlinx_coroutines_core", "(ILjava/lang/Object;)V", "getElement", "getElement$kotlinx_coroutines_core", "(I)Ljava/lang/Object;", "retrieveElement", "retrieveElement$kotlinx_coroutines_core", "cleanElement", "cleanElement$kotlinx_coroutines_core", "setElementLazy", "value", "getState", "getState$kotlinx_coroutines_core", "setState", "setState$kotlinx_coroutines_core", "casState", "", Constants.MessagePayloadKeys.FROM, "to", "casState$kotlinx_coroutines_core", "getAndSetState", com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ARG_UPDATE, "getAndSetState$kotlinx_coroutines_core", "onCancellation", "cause", "", "context", "Lkotlin/coroutines/CoroutineContext;", "onCancelledRequest", "receiver", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/ChannelSegment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3116:1\n1#2:3117\n*E\n"})
public final class ChannelSegment<E> extends Segment<ChannelSegment<E>> {

    @Nullable
    private final BufferedChannel<E> _channel;
    private final /* synthetic */ AtomicReferenceArray data;

    public ChannelSegment(long j, @Nullable ChannelSegment<E> channelSegment, @Nullable BufferedChannel<E> bufferedChannel, int i) {
        super(j, channelSegment, i);
        this._channel = bufferedChannel;
        this.data = new AtomicReferenceArray(BufferedChannelKt.SEGMENT_SIZE * 2);
    }

    private final /* synthetic */ AtomicReferenceArray getData() {
        return this.data;
    }

    private final void setElementLazy(int index, Object value) {
        getData().set(index * 2, value);
    }

    public final boolean casState$kotlinx_coroutines_core(int index, @Nullable Object from, @Nullable Object to) {
        AtomicReferenceArray data = getData();
        int i = (index * 2) + 1;
        while (!data.compareAndSet(i, from, to)) {
            if (data.get(i) != from) {
                return false;
            }
        }
        return true;
    }

    public final void cleanElement$kotlinx_coroutines_core(int index) {
        setElementLazy(index, null);
    }

    @Nullable
    public final Object getAndSetState$kotlinx_coroutines_core(int index, @Nullable Object update) {
        return getData().getAndSet((index * 2) + 1, update);
    }

    @NotNull
    public final BufferedChannel<E> getChannel() {
        BufferedChannel<E> bufferedChannel = this._channel;
        Intrinsics.checkNotNull(bufferedChannel);
        return bufferedChannel;
    }

    public final E getElement$kotlinx_coroutines_core(int index) {
        return (E) getData().get(index * 2);
    }

    @Override // kotlinx.coroutines.internal.Segment
    public int getNumberOfSlots() {
        return BufferedChannelKt.SEGMENT_SIZE;
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core(int index) {
        return getData().get((index * 2) + 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0060, code lost:
    
        cleanElement$kotlinx_coroutines_core(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0063, code lost:
    
        if (r0 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0065, code lost:
    
        r4 = getChannel().onUndeliveredElement;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006b, code lost:
    
        if (r4 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006d, code lost:
    
        kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElement(r4, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0070, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return;
     */
    @Override // kotlinx.coroutines.internal.Segment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCancellation(int index, @Nullable Throwable cause, @NotNull CoroutineContext context) {
        Function1<E, Unit> function1;
        int i = BufferedChannelKt.SEGMENT_SIZE;
        boolean z = index >= i;
        if (z) {
            index -= i;
        }
        E element$kotlinx_coroutines_core = getElement$kotlinx_coroutines_core(index);
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core(index);
            if ((state$kotlinx_coroutines_core instanceof Waiter) || (state$kotlinx_coroutines_core instanceof WaiterEB)) {
                if (casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, z ? BufferedChannelKt.INTERRUPTED_SEND : BufferedChannelKt.INTERRUPTED_RCV)) {
                    cleanElement$kotlinx_coroutines_core(index);
                    onCancelledRequest(index, !z);
                    if (!z || (function1 = getChannel().onUndeliveredElement) == null) {
                        return;
                    }
                    OnUndeliveredElementKt.callUndeliveredElement(function1, element$kotlinx_coroutines_core, context);
                    return;
                }
            } else {
                if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_SEND || state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_RCV) {
                    break;
                }
                if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_EB && state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_RCV) {
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED || state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                        return;
                    }
                    throw new IllegalStateException(("unexpected state: " + state$kotlinx_coroutines_core).toString());
                }
            }
        }
    }

    public final void onCancelledRequest(int index, boolean receiver) {
        if (receiver) {
            getChannel().waitExpandBufferCompletion$kotlinx_coroutines_core((this.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) index));
        }
        onSlotCleaned();
    }

    public final E retrieveElement$kotlinx_coroutines_core(int index) {
        E element$kotlinx_coroutines_core = getElement$kotlinx_coroutines_core(index);
        cleanElement$kotlinx_coroutines_core(index);
        return element$kotlinx_coroutines_core;
    }

    public final void setState$kotlinx_coroutines_core(int index, @Nullable Object value) {
        getData().set((index * 2) + 1, value);
    }

    public final void storeElement$kotlinx_coroutines_core(int index, E element) {
        setElementLazy(index, element);
    }
}
