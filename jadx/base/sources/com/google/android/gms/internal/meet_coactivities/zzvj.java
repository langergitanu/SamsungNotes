package com.google.android.gms.internal.meet_coactivities;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzvj extends zzvk {
    public zzvj(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvk
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvk
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.meet_coactivities.zzvl.zzi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.meet_coactivities.zzvl.zzj(java.lang.Object, long, boolean):void */
    /* JADX WARN: Method inline failed with exception
    java.lang.ArrayIndexOutOfBoundsException: arraycopy: length -1 is negative
    	at java.base/java.lang.System.arraycopy(Native Method)
    	at java.base/java.util.ArrayList.shiftTailOverGap(ArrayList.java:828)
    	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1774)
    	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1743)
    	at jadx.core.dex.instructions.args.SSAVar.removeUse(SSAVar.java:139)
    	at jadx.core.utils.InsnRemover.unbindArgUsage(InsnRemover.java:170)
    	at jadx.core.dex.nodes.InsnNode.replaceArg(InsnNode.java:137)
    	at jadx.core.dex.regions.conditions.IfCondition.replaceArg(IfCondition.java:270)
    	at jadx.core.dex.instructions.mods.TernaryInsn.replaceArg(TernaryInsn.java:67)
    	at jadx.core.dex.nodes.InsnNode.replaceArg(InsnNode.java:141)
    	at jadx.core.dex.visitors.InlineMethods.replaceRegs(InlineMethods.java:127)
    	at jadx.core.dex.visitors.InlineMethods.inlineMethod(InlineMethods.java:86)
    	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:78)
    	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:50)
     */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.meet_coactivities.zzvl.zzj(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.meet_coactivities.zzvk
    public final void zzc(Object obj, long j, boolean z) {
        if (zzvl.zzb) {
            zzvl.zzi(obj, j, z);
        } else {
            zzvl.zzj(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvk
    public final void zzd(Object obj, long j, byte b) {
        if (zzvl.zzb) {
            zzvl.zzD(obj, j, b);
        } else {
            zzvl.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvk
    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvk
    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvk
    public final boolean zzg(Object obj, long j) {
        return zzvl.zzb ? zzvl.zzt(obj, j) : zzvl.zzu(obj, j);
    }
}
