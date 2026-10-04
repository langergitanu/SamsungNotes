package androidx.room;

import androidx.sqlite.p113db.SupportSQLiteQuery;

/* JADX INFO: renamed from: androidx.room.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC3850e implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1670a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ QueryInterceptorDatabase f1671b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ SupportSQLiteQuery f1672c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ QueryInterceptorProgram f1673d;

    public /* synthetic */ RunnableC3850e(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram, int i) {
        this.f1670a = i;
        this.f1671b = queryInterceptorDatabase;
        this.f1672c = supportSQLiteQuery;
        this.f1673d = queryInterceptorProgram;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1670a) {
            case 0:
                QueryInterceptorDatabase.query$lambda$8(this.f1671b, this.f1672c, this.f1673d);
                break;
            default:
                QueryInterceptorDatabase.query$lambda$9(this.f1671b, this.f1672c, this.f1673d);
                break;
        }
    }
}
