package com.samsung.android.support.senl.p148nt.stt.presenter;

import com.samsung.android.support.senl.p148nt.stt.presenter.STTUpdateDataTask;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.util.UrlUtil;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.presenter.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class C11523b implements STTUpdateDataTask.Callback, FaultBarrier.ThrowableSupplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ boolean f7880a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f7881b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f7882c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f7883d;

    public /* synthetic */ C11523b(Object obj, String str, Object obj2, boolean z) {
        this.f7880a = z;
        this.f7882c = obj;
        this.f7881b = str;
        this.f7883d = obj2;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public Object get() {
        StringBuilder sb = (StringBuilder) this.f7882c;
        String str = (String) this.f7883d;
        return UrlUtil.lambda$addUrlParameter$0(this.f7880a, sb, this.f7881b, str);
    }

    @Override // com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask.Callback
    public void onFinished(boolean z) {
        STTPresenter.removeDataFromFile$lambda$44(this.f7880a, (STTPresenter) this.f7882c, this.f7881b, (Function0) this.f7883d, z);
    }
}
