package androidx.room;

/* JADX INFO: renamed from: androidx.room.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC3848c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1665a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ QueryInterceptorDatabase f1666b;

    public /* synthetic */ RunnableC3848c(QueryInterceptorDatabase queryInterceptorDatabase, int i) {
        this.f1665a = i;
        this.f1666b = queryInterceptorDatabase;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1665a) {
            case 0:
                QueryInterceptorDatabase.endTransaction$lambda$4(this.f1666b);
                break;
            case 1:
                QueryInterceptorDatabase.beginTransactionWithListenerNonExclusive$lambda$3(this.f1666b);
                break;
            case 2:
                QueryInterceptorDatabase.beginTransaction$lambda$0(this.f1666b);
                break;
            case 3:
                QueryInterceptorDatabase.setTransactionSuccessful$lambda$5(this.f1666b);
                break;
            case 4:
                QueryInterceptorDatabase.beginTransactionNonExclusive$lambda$1(this.f1666b);
                break;
            default:
                QueryInterceptorDatabase.beginTransactionWithListener$lambda$2(this.f1666b);
                break;
        }
    }
}
