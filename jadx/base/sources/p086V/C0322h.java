package p086V;

import com.samsung.android.support.senl.p148nt.app.converter.ExternalConverterContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.AppInfoContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.CoeditDownloadContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.DialogContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.LockUtilsContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.MemoConverterContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.NotificationContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.NotificationModelContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.SDocCategoryResolverContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.SDocCipherInputStreamContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.SDocCipherOutputStreamContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.SDocResolverContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.SDocTagResolverContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.SaveNoteResolverContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.SyncManagerContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.TipCardModelContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.ToastModelContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.WidgetContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.ZipUtilContractImpl;

/* JADX INFO: renamed from: V.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0322h {

    /* JADX INFO: renamed from: t */
    public static C0322h f814t;

    /* JADX INFO: renamed from: a */
    public AppInfoContractImpl f815a;

    /* JADX INFO: renamed from: b */
    public ZipUtilContractImpl f816b;

    /* JADX INFO: renamed from: c */
    public SDocCipherOutputStreamContractImpl f817c;

    /* JADX INFO: renamed from: d */
    public NotificationContractImpl f818d;

    /* JADX INFO: renamed from: e */
    public NotificationModelContractImpl f819e;

    /* JADX INFO: renamed from: f */
    public TipCardModelContractImpl f820f;

    /* JADX INFO: renamed from: g */
    public ToastModelContractImpl f821g;

    /* JADX INFO: renamed from: h */
    public DialogContractImpl f822h;

    /* JADX INFO: renamed from: i */
    public MemoConverterContractImpl f823i;

    /* JADX INFO: renamed from: j */
    public ExternalConverterContractImpl f824j;

    /* JADX INFO: renamed from: k */
    public SDocCipherInputStreamContractImpl f825k;

    /* JADX INFO: renamed from: l */
    public LockUtilsContractImpl f826l;

    /* JADX INFO: renamed from: m */
    public WidgetContractImpl f827m;

    /* JADX INFO: renamed from: n */
    public SyncManagerContractImpl f828n;

    /* JADX INFO: renamed from: o */
    public SDocCategoryResolverContractImpl f829o;

    /* JADX INFO: renamed from: p */
    public SDocTagResolverContractImpl f830p;

    /* JADX INFO: renamed from: q */
    public SDocResolverContractImpl f831q;

    /* JADX INFO: renamed from: r */
    public SaveNoteResolverContractImpl f832r;

    /* JADX INFO: renamed from: s */
    public CoeditDownloadContractImpl f833s;

    /* JADX INFO: renamed from: a */
    public static synchronized C0322h m670a() {
        try {
            if (f814t == null) {
                f814t = new C0322h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f814t;
    }
}
