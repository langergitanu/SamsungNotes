package androidx.test.internal.runner.intent;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.test.runner.intent.IntentCallback;
import androidx.test.runner.intent.IntentMonitor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class IntentMonitorImpl implements IntentMonitor {
    private static final String TAG = "IntentMonitorImpl";
    private final List<WeakReference<IntentCallback>> callbacks = new ArrayList();

    @Override // androidx.test.runner.intent.IntentMonitor
    public void addIntentCallback(@NonNull IntentCallback intentCallback) {
        if (intentCallback == null) {
            throw new NullPointerException("callback cannot be null!");
        }
        synchronized (this.callbacks) {
            try {
                Iterator<WeakReference<IntentCallback>> it = this.callbacks.iterator();
                boolean z = true;
                while (it.hasNext()) {
                    IntentCallback intentCallback2 = it.next().get();
                    if (intentCallback2 == null) {
                        it.remove();
                    } else if (intentCallback2 == intentCallback) {
                        z = false;
                    }
                }
                if (z) {
                    this.callbacks.add(new WeakReference<>(intentCallback));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.test.runner.intent.IntentMonitor
    public void removeIntentCallback(@NonNull IntentCallback intentCallback) {
        if (intentCallback == null) {
            throw new NullPointerException("callback cannot be null!");
        }
        synchronized (this.callbacks) {
            try {
                Iterator<WeakReference<IntentCallback>> it = this.callbacks.iterator();
                while (it.hasNext()) {
                    IntentCallback intentCallback2 = it.next().get();
                    if (intentCallback2 == null) {
                        it.remove();
                    } else if (intentCallback2 == intentCallback) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void signalIntent(Intent intent) {
        synchronized (this.callbacks) {
            Iterator<WeakReference<IntentCallback>> it = this.callbacks.iterator();
            while (it.hasNext()) {
                IntentCallback intentCallback = it.next().get();
                if (intentCallback == null) {
                    it.remove();
                } else {
                    try {
                        intentCallback.onIntentSent(new Intent(intent));
                    } catch (RuntimeException e) {
                        Log.e(TAG, String.format("Callback threw exception! (callback: %s intent: %s)", intentCallback, intent), e);
                    }
                }
            }
        }
    }
}
