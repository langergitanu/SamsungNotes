package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.drive.zzet;
import com.google.android.gms.internal.drive.zzfp;
import com.google.android.gms.internal.drive.zzir;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes5.dex */
public class DriveEventService extends Service implements ChangeListener, CompletionListener, zzd, zzi {
    public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
    private static final GmsLogger zzbz = new GmsLogger("DriveEventService", "");
    private final String name;

    @GuardedBy("this")
    private CountDownLatch zzcj;

    @VisibleForTesting
    @GuardedBy("this")
    zza zzck;

    @GuardedBy("this")
    boolean zzcl;

    @VisibleForTesting
    private int zzcm;

    public static final class zza extends zzir {
        private final WeakReference<DriveEventService> zzcp;

        private zza(DriveEventService driveEventService) {
            this.zzcp = new WeakReference<>(driveEventService);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Message zzb(zzfp zzfpVar) {
            return obtainMessage(1, zzfpVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Message zzy() {
            return obtainMessage(2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    DriveEventService.zzbz.wfmt("DriveEventService", "Unexpected message type: %s", Integer.valueOf(message.what));
                    return;
                } else {
                    getLooper().quit();
                    return;
                }
            }
            DriveEventService driveEventService = this.zzcp.get();
            if (driveEventService != null) {
                driveEventService.zza((zzfp) message.obj);
            } else {
                getLooper().quit();
            }
        }

        public /* synthetic */ zza(DriveEventService driveEventService, zzh zzhVar) {
            this(driveEventService);
        }
    }

    @VisibleForTesting
    public final class zzb extends zzet {
        private zzb() {
        }

        @Override // com.google.android.gms.internal.drive.zzes
        public final void zzc(zzfp zzfpVar) {
            synchronized (DriveEventService.this) {
                try {
                    DriveEventService.this.zzw();
                    zza zzaVar = DriveEventService.this.zzck;
                    if (zzaVar != null) {
                        DriveEventService.this.zzck.sendMessage(zzaVar.zzb(zzfpVar));
                    } else {
                        DriveEventService.zzbz.m3219e("DriveEventService", "Receiving event before initialize is completed.");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public /* synthetic */ zzb(DriveEventService driveEventService, zzh zzhVar) {
            this();
        }
    }

    public DriveEventService(String str) {
        this.zzcl = false;
        this.zzcm = -1;
        this.name = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzw() {
        int callingUid = getCallingUid();
        if (callingUid == this.zzcm) {
            return;
        }
        if (!UidVerifier.isGooglePlayServicesUid(this, callingUid)) {
            throw new SecurityException("Caller is not GooglePlayServices");
        }
        this.zzcm = callingUid;
    }

    @VisibleForTesting
    public int getCallingUid() {
        return Binder.getCallingUid();
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        zzh zzhVar = null;
        if (!ACTION_HANDLE_EVENT.equals(intent.getAction())) {
            return null;
        }
        if (this.zzck == null && !this.zzcl) {
            this.zzcl = true;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.zzcj = new CountDownLatch(1);
            new zzh(this, countDownLatch).start();
            try {
                if (!countDownLatch.await(5000L, TimeUnit.MILLISECONDS)) {
                    zzbz.m3219e("DriveEventService", "Failed to synchronously initialize event handler.");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException("Unable to start event handler", e);
            }
        }
        return new zzb(this, zzhVar).asBinder();
    }

    @Override // com.google.android.gms.drive.events.ChangeListener
    public void onChange(ChangeEvent changeEvent) {
        zzbz.wfmt("DriveEventService", "Unhandled change event in %s: %s", this.name, changeEvent);
    }

    @Override // com.google.android.gms.drive.events.CompletionListener
    public void onCompletion(CompletionEvent completionEvent) {
        zzbz.wfmt("DriveEventService", "Unhandled completion event in %s: %s", this.name, completionEvent);
    }

    @Override // android.app.Service
    public synchronized void onDestroy() {
        zza zzaVar = this.zzck;
        if (zzaVar != null) {
            this.zzck.sendMessage(zzaVar.zzy());
            this.zzck = null;
            try {
                if (!this.zzcj.await(5000L, TimeUnit.MILLISECONDS)) {
                    zzbz.m3225w("DriveEventService", "Failed to synchronously quit event handler. Will quit itself");
                }
            } catch (InterruptedException unused) {
            }
            this.zzcj = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return true;
    }

    @Override // com.google.android.gms.drive.events.zzd
    @ShowFirstParty
    public final void zza(com.google.android.gms.drive.events.zzb zzbVar) {
        zzbz.wfmt("DriveEventService", "Unhandled changes available event in %s: %s", this.name, zzbVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzfp zzfpVar) {
        DriveEvent driveEventZzat = zzfpVar.zzat();
        try {
            int type = driveEventZzat.getType();
            if (type == 1) {
                onChange((ChangeEvent) driveEventZzat);
                return;
            }
            if (type == 2) {
                onCompletion((CompletionEvent) driveEventZzat);
                return;
            }
            if (type == 4) {
                zza((com.google.android.gms.drive.events.zzb) driveEventZzat);
            } else {
                if (type != 7) {
                    zzbz.wfmt("DriveEventService", "Unhandled event: %s", driveEventZzat);
                    return;
                }
                zzbz.wfmt("DriveEventService", "Unhandled transfer state event in %s: %s", this.name, (zzv) driveEventZzat);
            }
        } catch (Exception e) {
            zzbz.m3220e("DriveEventService", "Error handling event in " + this.name, e);
        }
    }

    public DriveEventService() {
        this("DriveEventService");
    }
}
