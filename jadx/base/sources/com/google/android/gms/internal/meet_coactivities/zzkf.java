package com.google.android.gms.internal.meet_coactivities;

import com.google.android.meet.addons.ClientQueue;
import com.google.android.meet.addons.ClientQueueEntry;
import com.google.android.meet.addons.CoWatchingQueue;
import com.google.android.meet.addons.ServerQueueParams;
import com.google.common.collect.ImmutableList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkf implements zzkm {
    private zzkf() {
        throw null;
    }

    public static zzkf zzc() {
        return zzkd.zza;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzkm
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final CoWatchingQueue zza(zzqh zzqhVar) {
        CoWatchingQueue.Builder builder = CoWatchingQueue.builder();
        if (zzqhVar.zzh()) {
            zzpz zzpzVarZza = zzqhVar.zza();
            ClientQueue.Builder builder2 = ClientQueue.builder();
            builder2.zza(zzpzVarZza.zza());
            builder2.zzb(ImmutableList.copyOf((ClientQueueEntry[]) zzpzVarZza.zze().stream().map(new Function(this) { // from class: com.google.android.gms.internal.meet_coactivities.zzka
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    zzqb zzqbVar = (zzqb) obj;
                    ClientQueueEntry.Builder builder3 = ClientQueueEntry.builder();
                    builder3.zzb(zzqbVar.zzd());
                    builder3.zza(zzqbVar.zzc());
                    return builder3.zzc();
                }
            }).toArray(new IntFunction() { // from class: com.google.android.gms.internal.meet_coactivities.zzkb
                @Override // java.util.function.IntFunction
                public final Object apply(int i) {
                    return new ClientQueueEntry[i];
                }
            })));
            builder.zza(builder2.zzc());
        }
        if (zzqhVar.zzj()) {
            zzqv zzqvVarZze = zzqhVar.zze();
            ServerQueueParams.Builder builder3 = ServerQueueParams.builder();
            builder3.zza(zzqvVarZze.zze());
            builder3.zzb(zzqvVarZze.zza());
            builder.zzb(builder3.zzc());
        }
        return builder.zzc();
    }

    public final zzqh zzd(CoWatchingQueue coWatchingQueue) {
        zzqg zzqgVarZzb = zzqh.zzb();
        ClientQueue clientQueue = coWatchingQueue.clientQueue();
        if (clientQueue != null) {
            final zzpy zzpyVarZzb = zzpz.zzb();
            zzpyVarZzb.zzb(clientQueue.currentIndex());
            clientQueue.entries().forEach(new Consumer(this) { // from class: com.google.android.gms.internal.meet_coactivities.zzkc
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ClientQueueEntry clientQueueEntry = (ClientQueueEntry) obj;
                    zzqa zzqaVarZza = zzqb.zza();
                    zzqaVarZza.zzb(clientQueueEntry.mediaId());
                    zzqaVarZza.zza(clientQueueEntry.entryId());
                    zzpyVarZzb.zza((zzqb) zzqaVarZza.zzk());
                }
            });
            zzqgVarZzb.zza((zzpz) zzpyVarZzb.zzk());
        }
        ServerQueueParams serverQueueParams = coWatchingQueue.serverQueueParams();
        if (serverQueueParams != null) {
            zzqu zzquVarZzb = zzqv.zzb();
            zzquVarZzb.zza(serverQueueParams.queueId());
            zzquVarZzb.zzb(serverQueueParams.queueVersion());
            zzqgVarZzb.zzb((zzqv) zzquVarZzb.zzk());
        }
        return (zzqh) zzqgVarZzb.zzk();
    }

    public /* synthetic */ zzkf(zzke zzkeVar) {
    }
}
