package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.runtime.State;

/* JADX INFO: renamed from: androidx.compose.foundation.text.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1290a implements CodepointTransformation {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1031a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1032b;

    public /* synthetic */ C1290a(Object obj, int i) {
        this.f1031a = i;
        this.f1032b = obj;
    }

    @Override // androidx.compose.foundation.text.input.internal.CodepointTransformation
    public final int transform(int i, int i2) {
        switch (this.f1031a) {
            case 0:
                return BasicSecureTextFieldKt.BasicSecureTextField_Jb9bMDk$lambda$4$lambda$3((State) this.f1032b, i, i2);
            default:
                return SecureTextFieldController.codepointTransformation$lambda$0((SecureTextFieldController) this.f1032b, i, i2);
        }
    }
}
