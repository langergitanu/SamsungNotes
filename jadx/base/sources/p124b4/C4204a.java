package p124b4;

import androidx.arch.core.util.Function;
import com.samsung.android.support.senl.p148nt.data.repository.recognition.NotesStrokeRepository;
import java.util.List;

/* JADX INFO: renamed from: b4.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C4204a implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1835a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NotesStrokeRepository f1836b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f1837c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int[] f1838d;

    public /* synthetic */ C4204a(NotesStrokeRepository notesStrokeRepository, String str, int[] iArr, int i) {
        this.f1835a = i;
        this.f1836b = notesStrokeRepository;
        this.f1837c = str;
        this.f1838d = iArr;
    }

    @Override // androidx.arch.core.util.Function
    /* JADX INFO: renamed from: apply */
    public final Object mo22196apply(Object obj) {
        switch (this.f1835a) {
            case 0:
                return this.f1836b.lambda$deleteByUuidAndPageIds$1(this.f1837c, this.f1838d, (List) obj);
            default:
                return this.f1836b.lambda$deleteByUuidAndPageIdsWithExcludedTypes$2(this.f1837c, this.f1838d, (List) obj);
        }
    }
}
