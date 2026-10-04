package p024F;

import com.samsung.android.app.notes.sync.coedit.deletecore.CoeditDeleteLocalSharedSdocTask;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.model.domain.coedit.DeleteCoeditNoteUseCase;
import java.util.ArrayList;

/* JADX INFO: renamed from: F.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C0084a implements DeleteCoeditNoteUseCase.ResultCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f289a = 1;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f290b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ ArrayList f291c;

    public /* synthetic */ C0084a(String str, ArrayList arrayList) {
        this.f290b = str;
        this.f291c = arrayList;
    }

    @Override // com.samsung.android.support.senl.nt.model.domain.coedit.DeleteCoeditNoteUseCase.ResultCallback
    public final void onResult(int i) {
        switch (this.f289a) {
            case 0:
                CoeditDeleteLocalSharedSdocTask.lambda$doInBackground$0(this.f291c, this.f290b, i);
                break;
            default:
                StringBuilder sb = new StringBuilder("deleteItems, onResult, uuid: ");
                String str = this.f290b;
                sb.append(str);
                sb.append(", result: ");
                sb.append(i);
                Debugger.m8607d("Coedit$SesCoeditUtil", sb.toString());
                if (i == 300) {
                    this.f291c.add(str);
                }
                break;
        }
    }

    public /* synthetic */ C0084a(ArrayList arrayList, String str) {
        this.f291c = arrayList;
        this.f290b = str;
    }
}
