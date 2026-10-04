package p079T;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.base.common.util.CoeditCacheUtils;
import com.samsung.android.support.senl.p148nt.model.domain.coedit.DeleteCoeditNoteUseCase;

/* JADX INFO: renamed from: T.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0289g implements DeleteCoeditNoteUseCase.Callback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ String f750a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Context f751b;

    public C0289g(String str, Context context) {
        this.f750a = str;
        this.f751b = context;
    }

    @Override // com.samsung.android.support.senl.nt.model.domain.coedit.DeleteCoeditNoteUseCase.Callback
    public final void onError(int i) {
        AbstractC0291i.f752a.remove(this.f750a);
    }

    @Override // com.samsung.android.support.senl.nt.model.domain.coedit.DeleteCoeditNoteUseCase.Callback
    public final void onSuccess(int i) {
        Context context = this.f751b;
        String str = this.f750a;
        CoeditCacheUtils.removeCoeditCache(context, str);
        AbstractC0291i.f752a.remove(str);
    }
}
