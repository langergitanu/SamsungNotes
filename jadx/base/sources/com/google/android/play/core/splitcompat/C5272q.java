package com.google.android.play.core.splitcompat;

import androidx.annotation.NonNull;
import androidx.glance.AbstractC2821a;
import java.io.File;

/* JADX INFO: renamed from: com.google.android.play.core.splitcompat.q */
/* JADX INFO: loaded from: classes5.dex */
final class C5272q {

    /* JADX INFO: renamed from: a */
    private final File f3056a;

    /* JADX INFO: renamed from: b */
    private final String f3057b;

    public C5272q() {
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public File m4099a() {
        return this.f3056a;
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public String m4100b() {
        return this.f3057b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C5272q) {
            C5272q c5272q = (C5272q) obj;
            if (this.f3056a.equals(c5272q.m4099a()) && this.f3057b.equals(c5272q.m4100b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f3056a.hashCode() ^ 1000003) * 1000003) ^ this.f3057b.hashCode();
    }

    public String toString() {
        String strValueOf = String.valueOf(this.f3056a);
        String str = this.f3057b;
        StringBuilder sb = new StringBuilder(strValueOf.length() + 35 + str.length());
        AbstractC2821a.m2207B(sb, "SplitFileInfo{splitFile=", strValueOf, ", splitId=", str);
        sb.append("}");
        return sb.toString();
    }

    public C5272q(File file, String str) {
        this();
        if (file == null) {
            throw new NullPointerException("Null splitFile");
        }
        this.f3056a = file;
        if (str == null) {
            throw new NullPointerException("Null splitId");
        }
        this.f3057b = str;
    }
}
