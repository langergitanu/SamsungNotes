package com.samsung.android.support.senl.ntnl.coedit.common.raw;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class Element {
    private final long mHandle;

    public Element() {
        this.mHandle = Element_construct();
    }

    private native void Element_addAttribute(long j, String str, String str2);

    private native long Element_construct();

    private native void Element_finalize(long j);

    private native String Element_getAttribute(long j, String str);

    private native int Element_getAttributeCount(long j);

    private native ArrayList<String> Element_getAttributeKeys(long j);

    private native String Element_getName(long j);

    private native boolean Element_hasAttributeKey(long j, String str);

    private native boolean Element_isEnd(long j);

    private native void Element_setEnd(long j, boolean z);

    private native void Element_setName(long j, String str);

    private native String Element_toString(long j);

    public void addAttribute(String str, String str2) {
        Element_addAttribute(this.mHandle, str, str2);
    }

    public void finalize() {
        Element_finalize(this.mHandle);
    }

    public String getAttribute(String str) {
        return Element_getAttribute(this.mHandle, str);
    }

    public int getAttributeCount() {
        return Element_getAttributeCount(this.mHandle);
    }

    public List<String> getAttributeKeys() {
        return Element_getAttributeKeys(this.mHandle);
    }

    public long getHandle() {
        return this.mHandle;
    }

    public String getName() {
        return Element_getName(this.mHandle);
    }

    public boolean hasAttributeKey(String str) {
        return Element_hasAttributeKey(this.mHandle, str);
    }

    public boolean isEnd() {
        return Element_isEnd(this.mHandle);
    }

    public void setEnd(boolean z) {
        Element_setEnd(this.mHandle, z);
    }

    public void setName(String str) {
        Element_setName(this.mHandle, str);
    }

    public String toString() {
        return Element_toString(this.mHandle);
    }

    public Element(long j) {
        this.mHandle = j;
    }
}
