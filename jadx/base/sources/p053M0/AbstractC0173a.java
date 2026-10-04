package p053M0;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import p049L0.C0168a;
import p086V.C0322h;
import p234q1.C14433b;

/* JADX INFO: renamed from: M0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0173a {

    /* JADX INFO: renamed from: f */
    public static final String f548f = "SS$".concat("BackupTask");

    /* JADX INFO: renamed from: a */
    public final C0168a f549a;

    /* JADX INFO: renamed from: d */
    public C14433b f552d;

    /* JADX INFO: renamed from: b */
    public boolean f550b = false;

    /* JADX INFO: renamed from: c */
    public boolean f551c = false;

    /* JADX INFO: renamed from: e */
    public final NotesDocumentRepository f553e = NotesDataRepositoryFactory.newInstance(m435b()).createDocumentDataRepository();

    public AbstractC0173a(C0168a c0168a) {
        this.f549a = c0168a;
        SpenSdkInitializer.initialize(m435b());
    }

    /* JADX INFO: renamed from: b */
    public static Context m435b() {
        return C0322h.m670a().f815a.getAppContext();
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo436a();

    /* JADX INFO: renamed from: c */
    public abstract void mo437c();

    /* JADX INFO: renamed from: d */
    public abstract void mo438d();
}
