package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;

/* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1348f implements CancellationSignal.OnCancelListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1045a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1046b;

    public /* synthetic */ C1348f(Object obj, int i) {
        this.f1045a = i;
        this.f1046b = obj;
    }

    @Override // android.os.CancellationSignal.OnCancelListener
    public final void onCancel() {
        switch (this.f1045a) {
            case 0:
                HandwritingGestureApi34.previewHandwritingGesture$lambda$9((TextFieldSelectionManager) this.f1046b);
                break;
            default:
                HandwritingGestureApi34.previewHandwritingGesture$lambda$1((TransformedTextFieldState) this.f1046b);
                break;
        }
    }
}
