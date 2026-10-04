package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ThreadSafe
public final class SharedResourceHolder {
    static final long DESTROY_DELAY_SECONDS = 1;
    private static final SharedResourceHolder holder = new SharedResourceHolder(new ScheduledExecutorFactory() { // from class: io.grpc.internal.SharedResourceHolder.1
        @Override // io.grpc.internal.SharedResourceHolder.ScheduledExecutorFactory
        public ScheduledExecutorService createScheduledExecutor() {
            return Executors.newSingleThreadScheduledExecutor(GrpcUtil.getThreadFactory("grpc-shared-destroyer-%d", true));
        }
    });
    private ScheduledExecutorService destroyer;
    private final ScheduledExecutorFactory destroyerFactory;
    private final IdentityHashMap<Resource<?>, Instance> instances = new IdentityHashMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Instance {
        ScheduledFuture<?> destroyTask;
        final Object payload;
        int refcount;

        public Instance(Object obj) {
            this.payload = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Resource<T> {
        void close(T t);

        T create();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ScheduledExecutorFactory {
        ScheduledExecutorService createScheduledExecutor();
    }

    public SharedResourceHolder(ScheduledExecutorFactory scheduledExecutorFactory) {
        this.destroyerFactory = scheduledExecutorFactory;
    }

    public static <T> T get(Resource<T> resource) {
        return (T) holder.getInternal(resource);
    }

    public static <T> T release(Resource<T> resource, T t) {
        return (T) holder.releaseInternal(resource, t);
    }

    public synchronized <T> T getInternal(Resource<T> resource) {
        Instance instance;
        try {
            instance = this.instances.get(resource);
            if (instance == null) {
                instance = new Instance(resource.create());
                this.instances.put(resource, instance);
            }
            ScheduledFuture<?> scheduledFuture = instance.destroyTask;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                instance.destroyTask = null;
            }
            instance.refcount++;
        } catch (Throwable th) {
            throw th;
        }
        return (T) instance.payload;
    }

    public synchronized <T> T releaseInternal(final Resource<T> resource, final T t) {
        try {
            final Instance instance = this.instances.get(resource);
            if (instance == null) {
                throw new IllegalArgumentException("No cached instance found for " + resource);
            }
            Preconditions.checkArgument(t == instance.payload, "Releasing the wrong instance");
            Preconditions.checkState(instance.refcount > 0, "Refcount has already reached zero");
            int i = instance.refcount - 1;
            instance.refcount = i;
            if (i == 0) {
                Preconditions.checkState(instance.destroyTask == null, "Destroy task already scheduled");
                if (this.destroyer == null) {
                    this.destroyer = this.destroyerFactory.createScheduledExecutor();
                }
                instance.destroyTask = this.destroyer.schedule(new LogExceptionRunnable(new Runnable() { // from class: io.grpc.internal.SharedResourceHolder.2
                    /* JADX WARN: Finally extract failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SharedResourceHolder.this) {
                            try {
                                if (instance.refcount == 0) {
                                    try {
                                        resource.close(t);
                                        SharedResourceHolder.this.instances.remove(resource);
                                        if (SharedResourceHolder.this.instances.isEmpty()) {
                                            SharedResourceHolder.this.destroyer.shutdown();
                                            SharedResourceHolder.this.destroyer = null;
                                        }
                                    } catch (Throwable th) {
                                        SharedResourceHolder.this.instances.remove(resource);
                                        if (SharedResourceHolder.this.instances.isEmpty()) {
                                            SharedResourceHolder.this.destroyer.shutdown();
                                            SharedResourceHolder.this.destroyer = null;
                                        }
                                        throw th;
                                    }
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }
                }), 1L, TimeUnit.SECONDS);
            }
        } catch (Throwable th) {
            throw th;
        }
        return null;
    }
}
