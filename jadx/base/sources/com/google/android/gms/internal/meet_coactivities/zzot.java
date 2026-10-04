package com.google.android.gms.internal.meet_coactivities;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzot extends AbstractMap {
    private static final Comparator zza = new zzoq();
    private final Object[] zzb;
    private final int[] zzc;
    private final Set zzd;
    private Integer zze;
    private String zzf;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.meet_coactivities.zzot, java.util.AbstractMap] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public zzot(zzot zzotVar, zzot zzotVar2) {
        int i;
        Object objZzc;
        Object[] objArr;
        zzot abstractMap = new AbstractMap();
        int i2 = -1;
        abstractMap.zzd = new zzos(abstractMap, -1);
        abstractMap.zze = null;
        abstractMap.zzf = null;
        int size = zzotVar2.size() + zzotVar.size();
        int i4 = zzotVar.zzc[zzotVar.size()] + zzotVar2.zzc[zzotVar2.size()];
        int i5 = size + 1;
        Object[] objArr2 = new Object[i4];
        int[] iArr = new int[i5];
        int i6 = 0;
        iArr[0] = size;
        Map.Entry entryZze = zzotVar.zze(0);
        Map.Entry entryZze2 = zzotVar2.zze(0);
        int i7 = 0;
        int i8 = 0;
        int iZzd = size;
        int i9 = 0;
        while (true) {
            int i10 = 1;
            if (entryZze == null && entryZze2 == null) {
                break;
            }
            int i11 = i9 + 1;
            int iCompareTo = entryZze == null ? 1 : entryZze2 == null ? i2 : i6;
            if (iCompareTo == 0 && (iCompareTo = ((String) entryZze.getKey()).compareTo((String) entryZze2.getKey())) == 0) {
                int i12 = i8 + 1;
                int i13 = i7 + 1;
                objArr2[i9] = abstractMap.zzf((String) entryZze.getKey(), i9);
                zzos zzosVar = (zzos) entryZze.getValue();
                zzos zzosVar2 = (zzos) entryZze2.getValue();
                int i14 = 0;
                int i15 = 0;
                abstractMap = abstractMap;
                while (true) {
                    if (i14 >= zzosVar.zza() - zzosVar.zzb() && i15 >= zzosVar2.zza() - zzosVar2.zzb()) {
                        break;
                    }
                    int iCompare = i14 == zzosVar.zza() - zzosVar.zzb() ? i10 : i15 == zzosVar2.zza() - zzosVar2.zzb() ? -1 : 0;
                    iCompare = iCompare == 0 ? zzov.zza.compare(zzosVar.zzc(i14), zzosVar2.zzc(i15)) : iCompare;
                    if (iCompare < 0) {
                        i = i14 + 1;
                        objZzc = zzosVar.zzc(i14);
                    } else {
                        int i16 = i15 + 1;
                        Object objZzc2 = zzosVar2.zzc(i15);
                        i15 = i16;
                        i = iCompare == 0 ? i14 + 1 : i14;
                        objZzc = objZzc2;
                    }
                    objArr2[iZzd] = objZzc;
                    i14 = i;
                    iZzd++;
                    i10 = 1;
                    abstractMap = this;
                }
                iArr[i11] = iZzd;
                entryZze = zzotVar.zze(i13);
                entryZze2 = zzotVar2.zze(i12);
                i8 = i12;
                i7 = i13;
                i9 = i11;
                i2 = -1;
                i6 = 0;
            } else {
                if (iCompareTo < 0) {
                    i7++;
                    iZzd = zzd(entryZze, i9, iZzd, objArr2, iArr);
                    entryZze = zzotVar.zze(i7);
                } else {
                    Map.Entry entry = entryZze;
                    i8++;
                    int iZzd2 = zzd(entryZze2, i9, iZzd, objArr2, iArr);
                    entryZze2 = zzotVar2.zze(i8);
                    iZzd = iZzd2;
                    entryZze = entry;
                }
                i9 = i11;
                i2 = -1;
                i6 = 0;
                abstractMap = this;
            }
        }
        int i17 = iArr[i6];
        int i18 = i17 - i9;
        if (i18 != 0) {
            for (int i19 = i6; i19 <= i9; i19++) {
                iArr[i19] = iArr[i19] - i18;
            }
            int i20 = iArr[i9];
            int i21 = i20 - i9;
            if (zzg(i4, i20)) {
                objArr = new Object[i20];
                System.arraycopy(objArr2, i6, objArr, i6, i9);
            } else {
                objArr = objArr2;
            }
            System.arraycopy(objArr2, i17, objArr, i9, i21);
            objArr2 = objArr;
        }
        abstractMap.zzb = objArr2;
        int i22 = iArr[i6] + 1;
        abstractMap.zzc = zzg(i5, i22) ? Arrays.copyOf(iArr, i22) : iArr;
    }

    private final int zzd(Map.Entry entry, int i, int i2, Object[] objArr, int[] iArr) {
        zzos zzosVar = (zzos) entry.getValue();
        int iZza = zzosVar.zza() - zzosVar.zzb();
        System.arraycopy(zzosVar.zzb.zzb, zzosVar.zzb(), objArr, i2, iZza);
        objArr[i] = zzf((String) entry.getKey(), i);
        int i4 = i2 + iZza;
        iArr[i + 1] = i4;
        return i4;
    }

    private final Map.Entry zze(int i) {
        if (i < this.zzc[0]) {
            return (Map.Entry) this.zzb[i];
        }
        return null;
    }

    private final Map.Entry zzf(String str, int i) {
        return new AbstractMap.SimpleImmutableEntry(str, new zzos(this, i));
    }

    private static boolean zzg(int i, int i2) {
        return i > 16 && i * 9 > i2 * 10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return this.zzd;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        if (this.zze == null) {
            this.zze = Integer.valueOf(super.hashCode());
        }
        return this.zze.intValue();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        if (this.zzf == null) {
            this.zzf = super.toString();
        }
        return this.zzf;
    }

    public zzot(List list) {
        this.zzd = new zzos(this, -1);
        this.zze = null;
        this.zzf = null;
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            int size = list.size();
            Object[] objArr = new Object[size];
            Iterator it2 = list.iterator();
            if (!it2.hasNext()) {
                int[] iArr = {0};
                this.zzb = zzg(size, 0) ? Arrays.copyOf(objArr, 0) : objArr;
                this.zzc = iArr;
                return;
            }
            zzop.zza((zzop) it2.next());
            throw null;
        }
        zzop.zza((zzop) it.next());
        throw null;
    }
}
