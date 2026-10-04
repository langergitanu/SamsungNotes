package p022E1;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.HandleVoice;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReader;
import java.util.concurrent.atomic.AtomicReference;
import p173d0.C11971a;

/* JADX INFO: renamed from: E1.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C0079e implements DocumentFileManager.IOAction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f274a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f275b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f276c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f277d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f278e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f279f;

    public /* synthetic */ C0079e(C0082h c0082h, AtomicReference atomicReference, String str, String str2, Throwable[] thArr) {
        this.f277d = c0082h;
        this.f278e = atomicReference;
        this.f275b = str;
        this.f276c = str2;
        this.f279f = thArr;
    }

    @Override // com.samsung.android.support.senl.nt.model.documents.file.DocumentFileManager.IOAction
    public final Object operate() {
        switch (this.f274a) {
            case 0:
                C0082h c0082h = (C0082h) this.f277d;
                AtomicReference atomicReference = (AtomicReference) this.f278e;
                String str = this.f275b;
                String str2 = this.f276c;
                Throwable[] thArr = (Throwable[]) this.f279f;
                try {
                    atomicReference.set(new C11971a(c0082h.f286b.f262e, str));
                    ((C11971a) atomicReference.get()).m13531f(str2);
                    break;
                } catch (Throwable th) {
                    thArr[0] = th;
                }
                return str2;
            default:
                return ((HandleVoice) this.f277d).lambda$handleVoiceData$0(this.f275b, (Context) this.f278e, this.f276c, (SpenVoiceTextDataReader) this.f279f);
        }
    }

    public /* synthetic */ C0079e(HandleVoice handleVoice, String str, Context context, String str2, SpenVoiceTextDataReader spenVoiceTextDataReader) {
        this.f277d = handleVoice;
        this.f275b = str;
        this.f278e = context;
        this.f276c = str2;
        this.f279f = spenVoiceTextDataReader;
    }
}
