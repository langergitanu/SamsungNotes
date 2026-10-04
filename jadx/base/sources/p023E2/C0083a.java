package p023E2;

import com.samsung.android.support.senl.document.memoconverter.ProgressListener;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.sdoc.LMemoConverterWrapper;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.sdoc.TMemoConverterWrapper;
import java.util.ArrayList;

/* JADX INFO: renamed from: E2.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C0083a implements ProgressListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f287a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ArrayList f288b;

    public /* synthetic */ C0083a(ArrayList arrayList, int i) {
        this.f287a = i;
        this.f288b = arrayList;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.ProgressListener
    public final void onProgress(int i, int i2, ArrayList arrayList) {
        switch (this.f287a) {
            case 0:
                LMemoConverterWrapper.convert$lambda$0(this.f288b, i, i2, arrayList);
                break;
            default:
                TMemoConverterWrapper.convert$lambda$0(this.f288b, i, i2, arrayList);
                break;
        }
    }
}
