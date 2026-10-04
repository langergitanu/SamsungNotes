package com.google.android.play.core.internal;

/* JADX INFO: renamed from: com.google.android.play.core.internal.cl */
/* JADX INFO: loaded from: classes5.dex */
public final class C5217cl<T> implements InterfaceC5219cn, InterfaceC5215cj {

    /* JADX INFO: renamed from: a */
    private static final Object f2983a = new Object();

    /* JADX INFO: renamed from: b */
    private volatile InterfaceC5219cn<T> f2984b;

    /* JADX INFO: renamed from: c */
    private volatile Object f2985c = f2983a;

    private C5217cl(InterfaceC5219cn<T> interfaceC5219cn) {
        this.f2984b = interfaceC5219cn;
    }

    /* JADX INFO: renamed from: a */
    public static <P extends InterfaceC5219cn<T>, T> InterfaceC5219cn<T> m3981a(P p) {
        C5195bq.m3944a(p);
        return p instanceof C5217cl ? p : new C5217cl(p);
    }

    /* JADX INFO: renamed from: b */
    public static <P extends InterfaceC5219cn<T>, T> InterfaceC5215cj<T> m3982b(P p) {
        if (p instanceof InterfaceC5215cj) {
            return (InterfaceC5215cj) p;
        }
        C5195bq.m3944a(p);
        return new C5217cl(p);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final T mo3591a() {
        T tMo3591a;
        T t = (T) this.f2985c;
        Object obj = f2983a;
        if (t != obj) {
            return t;
        }
        synchronized (this) {
            try {
                tMo3591a = (T) this.f2985c;
                if (tMo3591a == obj) {
                    tMo3591a = this.f2984b.mo3591a();
                    Object obj2 = this.f2985c;
                    if (obj2 != obj && !(obj2 instanceof C5218cm) && obj2 != tMo3591a) {
                        String strValueOf = String.valueOf(obj2);
                        String strValueOf2 = String.valueOf(tMo3591a);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 118 + strValueOf2.length());
                        sb.append("Scoped provider was invoked recursively returning different results: ");
                        sb.append(strValueOf);
                        sb.append(" & ");
                        sb.append(strValueOf2);
                        sb.append(". This is likely due to a circular dependency.");
                        throw new IllegalStateException(sb.toString());
                    }
                    this.f2985c = tMo3591a;
                    this.f2984b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return tMo3591a;
    }
}
