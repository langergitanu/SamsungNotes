package org.apache.poi.sun.java2d.cmm;

import org.apache.poi.java.awt.color.CMMException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Profile {
    private final long nativePtr;

    public Profile(long j) {
        this.nativePtr = j;
    }

    public final long getNativePtr() {
        long j = this.nativePtr;
        if (j != 0) {
            return j;
        }
        throw new CMMException("Invalid profile: ptr is null");
    }
}
