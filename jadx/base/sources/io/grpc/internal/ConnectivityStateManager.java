package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import io.grpc.ConnectivityState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@NotThreadSafe
final class ConnectivityStateManager {
    private ArrayList<Listener> listeners = new ArrayList<>();
    private volatile ConnectivityState state = ConnectivityState.IDLE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Listener {
        final Runnable callback;
        final Executor executor;

        public Listener(Runnable runnable, Executor executor) {
            this.callback = runnable;
            this.executor = executor;
        }

        public void runInExecutor() {
            this.executor.execute(this.callback);
        }
    }

    public ConnectivityState getState() {
        ConnectivityState connectivityState = this.state;
        if (connectivityState != null) {
            return connectivityState;
        }
        throw new UnsupportedOperationException("Channel state API is not implemented");
    }

    public void gotoState(@Nonnull ConnectivityState connectivityState) {
        Preconditions.checkNotNull(connectivityState, "newState");
        if (this.state == connectivityState || this.state == ConnectivityState.SHUTDOWN) {
            return;
        }
        this.state = connectivityState;
        if (this.listeners.isEmpty()) {
            return;
        }
        ArrayList<Listener> arrayList = this.listeners;
        this.listeners = new ArrayList<>();
        Iterator<Listener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().runInExecutor();
        }
    }

    public void notifyWhenStateChanged(Runnable runnable, Executor executor, ConnectivityState connectivityState) {
        Preconditions.checkNotNull(runnable, Profile.PhoneNumberData.TYPE_CALLBACK);
        Preconditions.checkNotNull(executor, "executor");
        Preconditions.checkNotNull(connectivityState, "source");
        Listener listener = new Listener(runnable, executor);
        if (this.state != connectivityState) {
            listener.runInExecutor();
        } else {
            this.listeners.add(listener);
        }
    }
}
