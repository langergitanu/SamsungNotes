package com.microsoft.identity.common.java.storage;

import com.opencsv.ResultSetColumnNameHelperService;
import io.opentelemetry.context.Context;
import java.util.function.Function;

/* JADX INFO: renamed from: com.microsoft.identity.common.java.storage.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C6438a implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3606a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3607b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f3608c;

    public /* synthetic */ C6438a(Object obj, Object obj2, int i) {
        this.f3606a = i;
        this.f3607b = obj;
        this.f3608c = obj2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f3606a) {
            case 0:
                return ((StringSeparatedMultiTypeNameValueStorage) this.f3607b).lambda$getStoreForSeparator$0((String) this.f3608c, (String) obj);
            case 1:
                return ((ResultSetColumnNameHelperService) this.f3607b).lambda$getColumnValueSubset$1((String[]) this.f3608c, (String) obj);
            default:
                return ((Context) this.f3607b).lambda$wrapFunction$4((Function) this.f3608c, obj);
        }
    }
}
