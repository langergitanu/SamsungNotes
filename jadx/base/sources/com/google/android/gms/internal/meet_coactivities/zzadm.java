package com.google.android.gms.internal.meet_coactivities;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.UserHandle;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@ThreadSafe
final class zzadm implements ServiceConnection, zzacd {
    private static final Logger zza = Logger.getLogger(zzadm.class.getName());
    private final Intent zzb;
    private final int zzc;
    private final zzacc zzd;
    private final Executor zze;

    @Nullable
    private Context zzf;

    @GuardedBy("this")
    private int zzg;
    private int zzh;

    @AnyThread
    public zzadm(Executor executor, Context context, zzabv zzabvVar, Intent intent, @Nullable UserHandle userHandle, int i, zzacc zzaccVar) {
        synchronized (this) {
            this.zzb = intent;
            this.zzc = i;
            this.zzd = zzaccVar;
            this.zzf = context;
            this.zze = executor;
            this.zzg = 1;
            this.zzh = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void zzc(zzabd zzabdVar) {
        Logger logger = zza;
        Level level = Level.FINEST;
        logger.logp(level, "io.grpc.binder.internal.ServiceBinding", "notifyUnbound", "notify unbound ", zzabdVar);
        this.zzf = null;
        if (this.zzh != 4) {
            this.zzh = 4;
            logger.logp(level, "io.grpc.binder.internal.ServiceBinding", "notifyUnbound", "notify unbound - notifying");
            this.zzd.zzb(zzabdVar);
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onBindingDied(ComponentName componentName) {
        zzd(zzabd.zzk.zze("onBindingDied: ".concat(String.valueOf(componentName))));
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onNullBinding(ComponentName componentName) {
        zzd(zzabd.zzi.zze("onNullBinding: ".concat(String.valueOf(componentName))));
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean z;
        synchronized (this) {
            try {
                if (this.zzg == 2) {
                    this.zzg = 3;
                    z = true;
                } else {
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z && this.zzh == 1) {
            this.zzh = 3;
            zza.logp(Level.FINEST, "io.grpc.binder.internal.ServiceBinding", "notifyBound", "notify bound - notifying");
            this.zzd.zza(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        zzd(zzabd.zzk.zze("onServiceDisconnected: ".concat(String.valueOf(componentName))));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b5 A[Catch: all -> 0x0033, TRY_LEAVE, TryCatch #2 {all -> 0x0033, blocks: (B:31:0x0055, B:35:0x00af, B:37:0x00b5, B:38:0x00b7, B:43:0x00ca, B:42:0x00bd, B:13:0x002e, B:29:0x0051, B:49:0x00dc, B:33:0x007d, B:34:0x0096, B:26:0x0044, B:27:0x004a), top: B:51:0x0001, inners: #6 }] */
    @Override // com.google.android.gms.internal.meet_coactivities.zzacd
    @AnyThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void zza() throws Throwable {
        zzadm zzadmVar;
        zzabd zzabdVarZze;
        final zzabd zzabdVar;
        int iOrdinal;
        boolean zBindService;
        try {
            try {
                if (this.zzg == 1) {
                    this.zzg = 2;
                    Context context = this.zzf;
                    Intent intent = this.zzb;
                    int i = this.zzc;
                    zzadl zzadlVar = zzadl.BIND_SERVICE;
                    try {
                        Preconditions.checkState(true, "BindingChannelCredentials is expected to have null devicePolicyAdmin when targetUserHandle is not set");
                        iOrdinal = zzadlVar.ordinal();
                        try {
                        } catch (SecurityException e) {
                            e = e;
                            zzabdVarZze = zzabd.zze.zzd(e).zze("SecurityException from ".concat(String.valueOf(zzadlVar.zza())));
                        } catch (RuntimeException e2) {
                            e = e2;
                            zzabdVarZze = zzabd.zzj.zzd(e).zze("RuntimeException from ".concat(String.valueOf(zzadlVar.zza())));
                        }
                    } catch (SecurityException e3) {
                        e = e3;
                        zzadmVar = this;
                    } catch (RuntimeException e5) {
                        e = e5;
                        zzadmVar = this;
                    }
                    if (iOrdinal == 0) {
                        zzadmVar = this;
                        zBindService = context.bindService(intent, this, i);
                    } else if (iOrdinal != 1) {
                        if (iOrdinal != 2) {
                            zzadmVar = this;
                            zzabdVarZze = zzabd.zzi.zze(zzadlVar.zza() + "(" + String.valueOf(intent) + ") returned false");
                            zzabdVar = zzabdVarZze;
                            if (!zzabdVar.zzj()) {
                                try {
                                    zzadmVar.zzf.unbindService(this);
                                } catch (RuntimeException e6) {
                                    zza.logp(Level.FINE, "io.grpc.binder.internal.ServiceBinding", "handleBindServiceFailure", "Could not clean up after bindService() failure.", (Throwable) e6);
                                }
                                zzadmVar.zzg = 4;
                                zzadmVar.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzadj
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.zza.zzb(zzabdVar);
                                    }
                                });
                                return;
                            }
                        } else {
                            zzadmVar = this;
                            zBindService = ((DevicePolicyManager) context.getSystemService("device_policy")).bindDeviceAdminServiceAsUser((ComponentName) null, intent, zzadmVar, i, (UserHandle) null);
                        }
                        zzabdVarZze = zzabd.zze.zzd(e).zze("SecurityException from ".concat(String.valueOf(zzadlVar.zza())));
                        zzabdVar = zzabdVarZze;
                        if (!zzabdVar.zzj()) {
                        }
                    } else {
                        zzadmVar = this;
                        zBindService = context.bindServiceAsUser(intent, this, i, (UserHandle) null);
                    }
                    if (zBindService) {
                        zzabdVarZze = zzabd.zza;
                    } else {
                        zzabdVarZze = zzabd.zzi.zze(zzadlVar.zza() + "(" + String.valueOf(intent) + ") returned false");
                    }
                    zzabdVar = zzabdVarZze;
                    if (!zzabdVar.zzj()) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    @AnyThread
    public final void zzd(final zzabd zzabdVar) {
        Context context;
        synchronized (this) {
            int i = this.zzg;
            context = (i == 2 || i == 3) ? this.zzf : null;
            this.zzg = 4;
        }
        this.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzadk
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzc(zzabdVar);
            }
        });
        if (context != null) {
            context.unbindService(this);
        }
    }
}
