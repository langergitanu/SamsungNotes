package org.apache.commons.lang3.builder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class IDKey {

    /* JADX INFO: renamed from: id */
    private final int f9767id;
    private final Object value;

    public IDKey(Object obj) {
        this.f9767id = System.identityHashCode(obj);
        this.value = obj;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IDKey)) {
            return false;
        }
        IDKey iDKey = (IDKey) obj;
        return this.f9767id == iDKey.f9767id && this.value == iDKey.value;
    }

    public int hashCode() {
        return this.f9767id;
    }
}
