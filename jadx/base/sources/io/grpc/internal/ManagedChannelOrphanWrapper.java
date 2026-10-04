package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import io.grpc.ManagedChannel;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class ManagedChannelOrphanWrapper extends ForwardingManagedChannel {
    private final ManagedChannelReference phantom;
    private static final ReferenceQueue<ManagedChannelOrphanWrapper> refqueue = new ReferenceQueue<>();
    private static final ConcurrentMap<ManagedChannelReference, ManagedChannelReference> refs = new ConcurrentHashMap();
    private static final Logger logger = Logger.getLogger(ManagedChannelOrphanWrapper.class.getName());

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public static final class ManagedChannelReference extends WeakReference<ManagedChannelOrphanWrapper> {
        private static final String ALLOCATION_SITE_PROPERTY_NAME = "io.grpc.ManagedChannel.enableAllocationTracking";
        private static final boolean ENABLE_ALLOCATION_TRACKING = Boolean.parseBoolean(System.getProperty(ALLOCATION_SITE_PROPERTY_NAME, "true"));
        private static final RuntimeException missingCallSite = missingCallSite();
        private final Reference<RuntimeException> allocationSite;
        private final String channelStr;
        private final ReferenceQueue<ManagedChannelOrphanWrapper> refqueue;
        private final ConcurrentMap<ManagedChannelReference, ManagedChannelReference> refs;
        private final AtomicBoolean shutdown;

        public ManagedChannelReference(ManagedChannelOrphanWrapper managedChannelOrphanWrapper, ManagedChannel managedChannel, ReferenceQueue<ManagedChannelOrphanWrapper> referenceQueue, ConcurrentMap<ManagedChannelReference, ManagedChannelReference> concurrentMap) {
            super(managedChannelOrphanWrapper, referenceQueue);
            this.shutdown = new AtomicBoolean();
            this.allocationSite = new SoftReference(ENABLE_ALLOCATION_TRACKING ? new RuntimeException("ManagedChannel allocation site") : missingCallSite);
            this.channelStr = managedChannel.toString();
            this.refqueue = referenceQueue;
            this.refs = concurrentMap;
            concurrentMap.put(this, this);
            cleanQueue(referenceQueue);
        }

        @VisibleForTesting
        public static int cleanQueue(ReferenceQueue<ManagedChannelOrphanWrapper> referenceQueue) {
            int i = 0;
            while (true) {
                ManagedChannelReference managedChannelReference = (ManagedChannelReference) referenceQueue.poll();
                if (managedChannelReference == null) {
                    return i;
                }
                RuntimeException runtimeException = managedChannelReference.allocationSite.get();
                managedChannelReference.clearInternal();
                if (!managedChannelReference.shutdown.get()) {
                    i++;
                    Level level = Level.SEVERE;
                    if (ManagedChannelOrphanWrapper.logger.isLoggable(level)) {
                        LogRecord logRecord = new LogRecord(level, "*~*~*~ Previous channel {0} was not shutdown properly!!! ~*~*~*" + System.getProperty(SystemProperties.LINE_SEPARATOR) + "    Make sure to call shutdown()/shutdownNow() and wait until awaitTermination() returns true.");
                        logRecord.setLoggerName(ManagedChannelOrphanWrapper.logger.getName());
                        logRecord.setParameters(new Object[]{managedChannelReference.channelStr});
                        logRecord.setThrown(runtimeException);
                        ManagedChannelOrphanWrapper.logger.log(logRecord);
                    }
                }
            }
        }

        private void clearInternal() {
            super.clear();
            this.refs.remove(this);
            this.allocationSite.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSafely() {
            if (this.shutdown.getAndSet(true)) {
                return;
            }
            clear();
        }

        private static RuntimeException missingCallSite() {
            RuntimeException runtimeException = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
            runtimeException.setStackTrace(new StackTraceElement[0]);
            return runtimeException;
        }

        @Override // java.lang.ref.Reference
        public void clear() {
            clearInternal();
            cleanQueue(this.refqueue);
        }
    }

    public ManagedChannelOrphanWrapper(ManagedChannel managedChannel) {
        this(managedChannel, refqueue, refs);
    }

    @Override // io.grpc.internal.ForwardingManagedChannel, io.grpc.ManagedChannel
    public ManagedChannel shutdown() {
        this.phantom.clearSafely();
        return super.shutdown();
    }

    @Override // io.grpc.internal.ForwardingManagedChannel, io.grpc.ManagedChannel
    public ManagedChannel shutdownNow() {
        this.phantom.clearSafely();
        return super.shutdownNow();
    }

    @VisibleForTesting
    public ManagedChannelOrphanWrapper(ManagedChannel managedChannel, ReferenceQueue<ManagedChannelOrphanWrapper> referenceQueue, ConcurrentMap<ManagedChannelReference, ManagedChannelReference> concurrentMap) {
        super(managedChannel);
        this.phantom = new ManagedChannelReference(this, managedChannel, referenceQueue, concurrentMap);
    }
}
