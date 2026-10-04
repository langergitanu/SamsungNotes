package com.google.android.gms.internal.meet_coactivities;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.android.meet.addons.AddonMeetingInfo;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzgj {
    private static final zzkz zza = zzkz.zzj("com/google/android/meet/addons/internal/CoActivityStartInfoProvider");
    private static final Duration zzb = Duration.ofSeconds(1);

    /* JADX WARN: Multi-variable type inference failed */
    public static zzgi zza(final Context context, String str, final long j, zziv zzivVar, boolean z) {
        AddonMeetingInfo.MeetingStatus meetingStatus;
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        ImmutableList immutableList = zzde.zzc;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            zzj zzjVar = (zzj) immutableList.get(i);
            String str2 = (String) Preconditions.checkNotNull((String) zzde.zzb.get(zzjVar));
            try {
                if (packageManager.getApplicationInfo(str2, 0).enabled) {
                    arrayList.add(zzjVar);
                }
            } catch (PackageManager.NameNotFoundException unused) {
                ((zzkv) zza.zzc().zzh("com/google/android/meet/addons/internal/CoActivityStartInfoProvider", "isInstalled", 135, "CoActivityStartInfoProvider.java")).zzp("App Package %s is not installed", str2);
            }
        }
        if (arrayList.size() == 1) {
            return new zzgi(zzb((zzj) arrayList.get(0), str, j, z), !zzc(packageManager, r0), null);
        }
        int size2 = arrayList.size();
        int i2 = 0;
        while (i2 < size2) {
            zzj zzjVar2 = (zzj) arrayList.get(i2);
            final String str3 = (String) Preconditions.checkNotNull((String) zzde.zzb.get(zzjVar2));
            try {
                meetingStatus = ((AddonMeetingInfo) CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: com.google.android.gms.internal.meet_coactivities.zzis
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                        Optional optionalEmpty = Optional.empty();
                        Objects.requireNonNull(completer);
                        zzjb.zza(context, optionalEmpty, new zzje(new zzit(completer)), Optional.of(str3), j);
                        return "zziq";
                    }
                }).get(zzb.toMillis(), TimeUnit.MILLISECONDS)).meetingStatus();
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                ((zzkv) ((zzkv) zza.zze().zzg(e)).zzh("com/google/android/meet/addons/internal/CoActivityStartInfoProvider", "isMeetingOngoing", STBorder.INT_ZANY_TRIANGLES, "CoActivityStartInfoProvider.java")).zzp("Fail to detect ongoing calls in app: %s.", str3);
            }
            boolean z2 = meetingStatus.equals(AddonMeetingInfo.MeetingStatus.CONNECTED) || meetingStatus.equals(AddonMeetingInfo.MeetingStatus.CONNECTED_WITH_ADDON_SESSION);
            i2++;
            if (z2) {
                if (zzc(packageManager, zzjVar2)) {
                    ((zzkv) zza.zzc().zzh("com/google/android/meet/addons/internal/CoActivityStartInfoProvider", "getCoActivityStartInfo", 68, "CoActivityStartInfoProvider.java")).zzp("Package: %s hosting the ongoing meeting is updated.", str3);
                    return new zzgi(zzb(zzjVar2, str, j, z), false, null);
                }
                ((zzkv) zza.zzc().zzh("com/google/android/meet/addons/internal/CoActivityStartInfoProvider", "getCoActivityStartInfo", 79, "CoActivityStartInfoProvider.java")).zzp("Package: %s hosting the ongoing meeting is outdated. Cannot connect.", str3);
                return new zzgi(zzb(zzjVar2, str, j, z), true, null);
            }
        }
        int size3 = arrayList.size();
        int i4 = 0;
        while (i4 < size3) {
            zzj zzjVar3 = (zzj) arrayList.get(i4);
            i4++;
            if (zzc(packageManager, zzjVar3)) {
                return new zzgi(zzb(zzjVar3, str, j, z), false, null);
            }
        }
        return new zzgi(zzb(zzj.HOST_APP_UNKNOWN, str, j, z), false, null);
    }

    private static zzp zzb(zzj zzjVar, String str, long j, boolean z) {
        zzo zzoVarZzc = zzp.zzc();
        zzoVarZzc.zzc(zzjVar);
        zzoVarZzc.zza(str);
        zzoVarZzc.zzb(j);
        zzoVarZzc.zzd(z);
        return (zzp) zzoVarZzc.zzk();
    }

    private static boolean zzc(PackageManager packageManager, zzj zzjVar) {
        String str = (String) Preconditions.checkNotNull((String) zzde.zzb.get(zzjVar));
        try {
            long longVersionCode = Build.VERSION.SDK_INT >= 28 ? packageManager.getPackageInfo(str, 0).getLongVersionCode() : r9.versionCode;
            zzkz zzkzVar = zza;
            ((zzkv) zzkzVar.zzc().zzh("com/google/android/meet/addons/internal/CoActivityStartInfoProvider", "isVersionUpdated", 152, "CoActivityStartInfoProvider.java")).zzr("%s long version code is: %s", str, longVersionCode);
            Long l = (Long) Preconditions.checkNotNull((Long) zzde.zza.get(zzjVar));
            if (longVersionCode >= l.longValue()) {
                return true;
            }
            ((zzkv) zzkzVar.zzc().zzh("com/google/android/meet/addons/internal/CoActivityStartInfoProvider", "isVersionUpdated", 159, "CoActivityStartInfoProvider.java")).zzt("App Package %s is too old to support live sharing, minimal version is %s and app version is %s.,", str, l, Long.valueOf(longVersionCode));
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            ((zzkv) zza.zzc().zzh("com/google/android/meet/addons/internal/CoActivityStartInfoProvider", "isVersionUpdated", 154, "CoActivityStartInfoProvider.java")).zzp("App Package %s is not installed", str);
            return false;
        }
    }
}
