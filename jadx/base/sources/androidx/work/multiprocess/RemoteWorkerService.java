package androidx.work.multiprocess;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public class RemoteWorkerService extends Service {
    static final String TAG = Logger.tagWithPrefix("RemoteWorkerService");
    private IBinder mBinder;

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@NonNull Intent intent) {
        Logger.get().info(TAG, "Binding to RemoteWorkerService");
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mBinder = new ListenableWorkerImpl(this);
    }
}
