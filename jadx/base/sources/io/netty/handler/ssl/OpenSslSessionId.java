package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class OpenSslSessionId {
    static final OpenSslSessionId NULL_ID = new OpenSslSessionId(EmptyArrays.EMPTY_BYTES);
    private final int hashCode;

    /* JADX INFO: renamed from: id */
    private final byte[] f8942id;

    public OpenSslSessionId(byte[] bArr) {
        this.f8942id = bArr;
        this.hashCode = Arrays.hashCode(bArr);
    }

    public byte[] cloneBytes() {
        return (byte[]) this.f8942id.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OpenSslSessionId) {
            return Arrays.equals(this.f8942id, ((OpenSslSessionId) obj).f8942id);
        }
        return false;
    }

    public int hashCode() {
        return this.hashCode;
    }

    public String toString() {
        return "OpenSslSessionId{id=" + Arrays.toString(this.f8942id) + '}';
    }
}
