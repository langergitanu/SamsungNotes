package p025F0;

import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;

/* JADX INFO: renamed from: F0.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0096k {

    /* JADX INFO: renamed from: c */
    public static final C0095j f315c = new C0095j();

    /* JADX INFO: renamed from: a */
    public final SpenObjectShape f316a;

    /* JADX INFO: renamed from: b */
    public int f317b;

    public C0096k(SpenObjectTextBox spenObjectTextBox) {
        SpenObjectShape spenObjectShape = new SpenObjectShape();
        this.f316a = spenObjectShape;
        try {
            spenObjectShape.copy(spenObjectTextBox);
        } catch (SpenAlreadyClosedException e) {
            MSLogger.m8634e("RichTextData", "copy failed ", e);
        }
        spenObjectTextBox.getText();
        spenObjectTextBox.getTextSpan();
        spenObjectTextBox.getTextParagraph();
        this.f317b = -197380;
    }
}
