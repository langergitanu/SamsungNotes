package p178f0;

import android.text.TextUtils;

/* JADX INFO: renamed from: f0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C11978a {

    /* JADX INFO: renamed from: a */
    public int f8569a;

    /* JADX INFO: renamed from: b */
    public String f8570b;

    /* JADX INFO: renamed from: c */
    public String f8571c;

    /* JADX INFO: renamed from: d */
    public int f8572d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11978a)) {
            return false;
        }
        C11978a c11978a = (C11978a) obj;
        return this.f8569a == c11978a.f8569a && TextUtils.equals(this.f8571c, c11978a.f8571c) && TextUtils.equals(this.f8570b, c11978a.f8570b) && this.f8572d == c11978a.f8572d;
    }
}
