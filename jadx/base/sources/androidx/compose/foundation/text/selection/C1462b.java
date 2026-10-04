package androidx.compose.foundation.text.selection;

import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.textselection.TextSelectionHelper;
import java.util.Comparator;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: androidx.compose.foundation.text.selection.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1462b implements Comparator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1050a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Function2 f1051b;

    public /* synthetic */ C1462b(Function2 function2, int i) {
        this.f1050a = i;
        this.f1051b = function2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f1050a) {
            case 0:
                return SelectionRegistrarImpl.sort$lambda$2(this.f1051b, obj, obj2);
            default:
                return TextSelectionHelper.findNearestLineInBlockLineByLine$lambda$25(this.f1051b, obj, obj2);
        }
    }
}
