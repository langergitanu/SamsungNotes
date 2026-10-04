package com.microsoft.identity.common.java.util.ported;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.logging.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum LocalBroadcaster {
    INSTANCE;

    private static final String TAG = "LocalBroadcaster";
    private static ExecutorService sBroadcastExecutor = Executors.newSingleThreadExecutor();
    final ConcurrentHashMap<String, IReceiverCallback> mReceivers = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IReceiverCallback {
        void onReceive(@NonNull PropertyBag propertyBag);
    }

    LocalBroadcaster() {
    }

    public static void resetBroadcast() {
        shutdownAndAwaitTerminationForBroadcasterService();
        sBroadcastExecutor = Executors.newSingleThreadExecutor();
    }

    private static void shutdownAndAwaitTerminationForBroadcasterService() {
        sBroadcastExecutor.shutdown();
        try {
            ExecutorService executorService = sBroadcastExecutor;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (executorService.awaitTermination(20L, timeUnit)) {
                return;
            }
            sBroadcastExecutor.shutdownNow();
            if (sBroadcastExecutor.awaitTermination(5L, timeUnit)) {
                return;
            }
            Logger.info(TAG + ":shutdownAndAwaitTerminationForBroadcasterService", "broadcastExecutor did not terminate");
        } catch (InterruptedException unused) {
            sBroadcastExecutor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public void broadcast(@NonNull final String str, @NonNull final PropertyBag propertyBag) {
        if (str == null) {
            throw new NullPointerException("alias is marked non-null but is null");
        }
        if (propertyBag == null) {
            throw new NullPointerException("propertyBag is marked non-null but is null");
        }
        sBroadcastExecutor.execute(new Runnable() { // from class: com.microsoft.identity.common.java.util.ported.LocalBroadcaster.1
            @Override // java.lang.Runnable
            public void run() {
                IReceiverCallback iReceiverCallback = LocalBroadcaster.this.mReceivers.get(str);
                if (iReceiverCallback != null) {
                    Logger.info(LocalBroadcaster.TAG + ":broadcast", "broadcasting to alias: " + str);
                    iReceiverCallback.onReceive(propertyBag);
                    return;
                }
                Logger.info(LocalBroadcaster.TAG + ":broadcast", "No callback is registered with alias: " + str + ". Do nothing.");
            }
        });
    }

    public void clearReceivers() {
        this.mReceivers.clear();
    }

    public boolean hasReceivers(@NonNull String str) {
        if (str != null) {
            return this.mReceivers.containsKey(str);
        }
        throw new NullPointerException("alias is marked non-null but is null");
    }

    public void registerCallback(@NonNull String str, @NonNull IReceiverCallback iReceiverCallback) {
        if (str == null) {
            throw new NullPointerException("alias is marked non-null but is null");
        }
        if (iReceiverCallback == null) {
            throw new NullPointerException("callback is marked non-null but is null");
        }
        if (this.mReceivers.containsKey(str)) {
            Logger.warn(AbstractC0622a.m1170p(TAG, ":registerCallback", new StringBuilder()), "The alias: " + str + " has already been registered. It will be overwritten");
        }
        Logger.info(AbstractC0622a.m1170p(TAG, ":registerCallback", new StringBuilder()), "Registering alias: ".concat(str));
        this.mReceivers.put(str, iReceiverCallback);
    }

    public void unregisterCallback(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("alias is marked non-null but is null");
        }
        Logger.info(AbstractC0622a.m1170p(TAG, ":unregisterCallback", new StringBuilder()), "Removing alias: ".concat(str));
        this.mReceivers.remove(str);
    }
}
