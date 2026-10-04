package com.google.android.gms.internal.drive;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes5.dex */
public final class zzky extends zziw<String> implements zzkz, RandomAccess {
    private static final zzky zztk;
    private static final zzkz zztl;
    private final List<Object> zziu;

    static {
        zzky zzkyVar = new zzky();
        zztk = zzkyVar;
        zzkyVar.zzbp();
        zztl = zzkyVar;
    }

    public zzky() {
        this(10);
    }

    private static String zzf(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzjc ? ((zzjc) obj).zzbt() : zzkm.zze((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzbq();
        this.zziu.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzbq();
        this.zziu.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zziu.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzjc) {
            zzjc zzjcVar = (zzjc) obj;
            String strZzbt = zzjcVar.zzbt();
            if (zzjcVar.zzbu()) {
                this.zziu.set(i, strZzbt);
            }
            return strZzbt;
        }
        byte[] bArr = (byte[]) obj;
        String strZze = zzkm.zze(bArr);
        if (zzkm.zzd(bArr)) {
            this.zziu.set(i, strZze);
        }
        return strZze;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        zzbq();
        return zzf(this.zziu.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zziu.size();
    }

    @Override // com.google.android.gms.internal.drive.zzkz
    public final Object zzao(int i) {
        return this.zziu.get(i);
    }

    @Override // com.google.android.gms.internal.drive.zziw, com.google.android.gms.internal.drive.zzkp
    public final /* bridge */ /* synthetic */ boolean zzbo() {
        return super.zzbo();
    }

    @Override // com.google.android.gms.internal.drive.zzkz
    public final List<?> zzdr() {
        return Collections.unmodifiableList(this.zziu);
    }

    @Override // com.google.android.gms.internal.drive.zzkz
    public final zzkz zzds() {
        return zzbo() ? new zzna(this) : this;
    }

    @Override // com.google.android.gms.internal.drive.zzkp
    public final /* synthetic */ zzkp zzr(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zziu);
        return new zzky((ArrayList<Object>) arrayList);
    }

    public zzky(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzbq();
        if (collection instanceof zzkz) {
            collection = ((zzkz) collection).zzdr();
        }
        boolean zAddAll = this.zziu.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbq();
        Object objRemove = this.zziu.remove(i);
        ((AbstractList) this).modCount++;
        return zzf(objRemove);
    }

    private zzky(ArrayList<Object> arrayList) {
        this.zziu = arrayList;
    }
}
