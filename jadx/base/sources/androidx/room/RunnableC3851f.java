package androidx.room;

/* JADX INFO: renamed from: androidx.room.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC3851f implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1674a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ QueryInterceptorStatement f1675b;

    public /* synthetic */ RunnableC3851f(QueryInterceptorStatement queryInterceptorStatement, int i) {
        this.f1674a = i;
        this.f1675b = queryInterceptorStatement;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1674a) {
            case 0:
                QueryInterceptorStatement.simpleQueryForLong$lambda$3(this.f1675b);
                break;
            case 1:
                QueryInterceptorStatement.executeInsert$lambda$2(this.f1675b);
                break;
            case 2:
                QueryInterceptorStatement.simpleQueryForString$lambda$4(this.f1675b);
                break;
            case 3:
                QueryInterceptorStatement.execute$lambda$0(this.f1675b);
                break;
            default:
                QueryInterceptorStatement.executeUpdateDelete$lambda$1(this.f1675b);
                break;
        }
    }
}
