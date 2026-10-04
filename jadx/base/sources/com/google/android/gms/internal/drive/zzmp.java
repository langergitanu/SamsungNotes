package com.google.android.gms.internal.drive;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
final class zzmp implements Comparable, Map.Entry {
    private Object value;
    private final /* synthetic */ zzmi zzvk;
    private final Comparable zzvn;

    public zzmp(zzmi zzmiVar, Map.Entry entry) {
        this(zzmiVar, (Comparable) entry.getKey(), entry.getValue());
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzmp) obj).getKey());
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return equals(this.zzvn, entry.getKey()) && equals(this.value, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zzvn;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.zzvn;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.value;
        return iHashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.zzvk.zzeu();
        Object obj2 = this.value;
        this.value = obj;
        return obj2;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzvn);
        String strValueOf2 = String.valueOf(this.value);
        StringBuilder sb = new StringBuilder(strValueOf2.length() + strValueOf.length() + 1);
        sb.append(strValueOf);
        sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
        sb.append(strValueOf2);
        return sb.toString();
    }

    public zzmp(zzmi zzmiVar, Comparable comparable, Object obj) {
        this.zzvk = zzmiVar;
        this.zzvn = comparable;
        this.value = obj;
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }
}
