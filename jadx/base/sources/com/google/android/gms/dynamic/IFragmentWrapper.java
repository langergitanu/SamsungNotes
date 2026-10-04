package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzc;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface IFragmentWrapper extends IInterface {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends com.google.android.gms.internal.common.zzb implements IFragmentWrapper {
        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        @NonNull
        public static IFragmentWrapper asInterface(@NonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            return iInterfaceQueryLocalInterface instanceof IFragmentWrapper ? (IFragmentWrapper) iInterfaceQueryLocalInterface : new zza(iBinder);
        }

        @Override // com.google.android.gms.internal.common.zzb
        public final boolean zza(int i, @NonNull Parcel parcel, @NonNull Parcel parcel2, int i2) {
            switch (i) {
                case 2:
                    IObjectWrapper iObjectWrapperZzg = zzg();
                    parcel2.writeNoException();
                    zzc.zze(parcel2, iObjectWrapperZzg);
                    return true;
                case 3:
                    Bundle bundleZzd = zzd();
                    parcel2.writeNoException();
                    zzc.zzd(parcel2, bundleZzd);
                    return true;
                case 4:
                    int iZzb = zzb();
                    parcel2.writeNoException();
                    parcel2.writeInt(iZzb);
                    return true;
                case 5:
                    IFragmentWrapper iFragmentWrapperZze = zze();
                    parcel2.writeNoException();
                    zzc.zze(parcel2, iFragmentWrapperZze);
                    return true;
                case 6:
                    IObjectWrapper iObjectWrapperZzh = zzh();
                    parcel2.writeNoException();
                    zzc.zze(parcel2, iObjectWrapperZzh);
                    return true;
                case 7:
                    boolean zZzs = zzs();
                    parcel2.writeNoException();
                    int i4 = zzc.zza;
                    parcel2.writeInt(zZzs ? 1 : 0);
                    return true;
                case 8:
                    String strZzj = zzj();
                    parcel2.writeNoException();
                    parcel2.writeString(strZzj);
                    return true;
                case 9:
                    IFragmentWrapper iFragmentWrapperZzf = zzf();
                    parcel2.writeNoException();
                    zzc.zze(parcel2, iFragmentWrapperZzf);
                    return true;
                case 10:
                    int iZzc = zzc();
                    parcel2.writeNoException();
                    parcel2.writeInt(iZzc);
                    return true;
                case 11:
                    boolean zZzt = zzt();
                    parcel2.writeNoException();
                    int i5 = zzc.zza;
                    parcel2.writeInt(zZzt ? 1 : 0);
                    return true;
                case 12:
                    IObjectWrapper iObjectWrapperZzi = zzi();
                    parcel2.writeNoException();
                    zzc.zze(parcel2, iObjectWrapperZzi);
                    return true;
                case 13:
                    boolean zZzu = zzu();
                    parcel2.writeNoException();
                    int i6 = zzc.zza;
                    parcel2.writeInt(zZzu ? 1 : 0);
                    return true;
                case 14:
                    boolean zZzv = zzv();
                    parcel2.writeNoException();
                    int i7 = zzc.zza;
                    parcel2.writeInt(zZzv ? 1 : 0);
                    return true;
                case 15:
                    boolean zZzw = zzw();
                    parcel2.writeNoException();
                    int i8 = zzc.zza;
                    parcel2.writeInt(zZzw ? 1 : 0);
                    return true;
                case 16:
                    boolean zZzx = zzx();
                    parcel2.writeNoException();
                    int i9 = zzc.zza;
                    parcel2.writeInt(zZzx ? 1 : 0);
                    return true;
                case 17:
                    boolean zZzy = zzy();
                    parcel2.writeNoException();
                    int i10 = zzc.zza;
                    parcel2.writeInt(zZzy ? 1 : 0);
                    return true;
                case 18:
                    boolean zZzz = zzz();
                    parcel2.writeNoException();
                    int i11 = zzc.zza;
                    parcel2.writeInt(zZzz ? 1 : 0);
                    return true;
                case 19:
                    boolean zZzA = zzA();
                    parcel2.writeNoException();
                    int i12 = zzc.zza;
                    parcel2.writeInt(zZzA ? 1 : 0);
                    return true;
                case 20:
                    IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzc.zzb(parcel);
                    zzk(iObjectWrapperAsInterface);
                    parcel2.writeNoException();
                    return true;
                case 21:
                    boolean zZzf = zzc.zzf(parcel);
                    zzc.zzb(parcel);
                    zzl(zZzf);
                    parcel2.writeNoException();
                    return true;
                case 22:
                    boolean zZzf2 = zzc.zzf(parcel);
                    zzc.zzb(parcel);
                    zzm(zZzf2);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    boolean zZzf3 = zzc.zzf(parcel);
                    zzc.zzb(parcel);
                    zzn(zZzf3);
                    parcel2.writeNoException();
                    return true;
                case 24:
                    boolean zZzf4 = zzc.zzf(parcel);
                    zzc.zzb(parcel);
                    zzo(zZzf4);
                    parcel2.writeNoException();
                    return true;
                case 25:
                    Intent intent = (Intent) zzc.zza(parcel, Intent.CREATOR);
                    zzc.zzb(parcel);
                    zzp(intent);
                    parcel2.writeNoException();
                    return true;
                case 26:
                    Intent intent2 = (Intent) zzc.zza(parcel, Intent.CREATOR);
                    int i13 = parcel.readInt();
                    zzc.zzb(parcel);
                    zzq(intent2, i13);
                    parcel2.writeNoException();
                    return true;
                case 27:
                    IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzc.zzb(parcel);
                    zzr(iObjectWrapperAsInterface2);
                    parcel2.writeNoException();
                    return true;
                default:
                    return false;
            }
        }
    }

    boolean zzA();

    int zzb();

    int zzc();

    @Nullable
    Bundle zzd();

    @Nullable
    IFragmentWrapper zze();

    @Nullable
    IFragmentWrapper zzf();

    @NonNull
    IObjectWrapper zzg();

    @NonNull
    IObjectWrapper zzh();

    @NonNull
    IObjectWrapper zzi();

    @Nullable
    String zzj();

    void zzk(@NonNull IObjectWrapper iObjectWrapper);

    void zzl(boolean z);

    void zzm(boolean z);

    void zzn(boolean z);

    void zzo(boolean z);

    void zzp(@NonNull Intent intent);

    void zzq(@NonNull Intent intent, int i);

    void zzr(@NonNull IObjectWrapper iObjectWrapper);

    boolean zzs();

    boolean zzt();

    boolean zzu();

    boolean zzv();

    boolean zzw();

    boolean zzx();

    boolean zzy();

    boolean zzz();
}
