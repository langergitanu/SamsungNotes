package com.samsung.android.support.senl.p148nt.model.domain.common;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0004J\u0015\u0010\u000b\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\nH\u0004¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/domain/common/BaseUseCase;", "Param", "Result", "", "<init>", "()V", "invoke", "param", "(Ljava/lang/Object;)Ljava/lang/Object;", "onPreExecute", "", "execute", "onPostExecute", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class BaseUseCase<Param, Result> {
    public abstract Result execute(Param param);

    public final Result invoke(Param param) {
        onPreExecute();
        Result resultExecute = execute(param);
        onPostExecute();
        return resultExecute;
    }

    public final void onPostExecute() {
    }

    public final void onPreExecute() {
    }
}
