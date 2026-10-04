package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import com.samsung.android.support.senl.p148nt.app.lock.LockActivity;

/* JADX INFO: renamed from: androidx.core.view.inputmethod.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C2458a implements InputConnectionCompat.OnCommitContentListener, OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ View f1340a;

    public /* synthetic */ C2458a(View view) {
        this.f1340a = view;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return LockActivity.registerOnApplyWindowInsetsListener$lambda$0(this.f1340a, view, windowInsetsCompat);
    }

    @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
    public boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
        return InputConnectionCompat.lambda$createOnCommitContentListenerUsingPerformReceiveContent$0(this.f1340a, inputContentInfoCompat, i, bundle);
    }
}
