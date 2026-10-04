package androidx.room;

/* JADX INFO: renamed from: androidx.room.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC3849d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1667a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ QueryInterceptorDatabase f1668b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f1669c;

    public /* synthetic */ RunnableC3849d(QueryInterceptorDatabase queryInterceptorDatabase, String str, int i) {
        this.f1667a = i;
        this.f1668b = queryInterceptorDatabase;
        this.f1669c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1667a) {
            case 0:
                QueryInterceptorDatabase.query$lambda$6(this.f1668b, this.f1669c);
                break;
            default:
                QueryInterceptorDatabase.execSQL$lambda$10(this.f1668b, this.f1669c);
                break;
        }
    }
}
