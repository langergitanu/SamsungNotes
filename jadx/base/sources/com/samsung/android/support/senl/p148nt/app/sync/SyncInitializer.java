package com.samsung.android.support.senl.p148nt.app.sync;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.google.firebase.FirebaseApp;
import com.samsung.android.app.notes.sync.C6751f;
import com.samsung.android.app.notes.sync.common.SyncInitState$InitState;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p148nt.app.converter.ExternalConverterContractImpl;
import com.samsung.android.support.senl.p148nt.app.main.sharednotebook.presenter.GcsGroupNetworkUtils;
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
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.lang.ref.WeakReference;
import p044K.AbstractC0159b;
import p052M.C0171a;
import p052M.InterfaceC0172b;
import p086V.C0322h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SyncInitializer {
    private static final String TAG = "SyncInitializer";

    public static synchronized void lazyInitialize(Context context) {
        try {
            if (AbstractC0159b.f493a == SyncInitState$InitState.notInitialized) {
                AbstractC0159b.f493a = SyncInitState$InitState.Initializing;
                Debugger.m8615i(TAG, "LazyInitialize() : start");
                C0322h c0322hM670a = C0322h.m670a();
                if (c0322hM670a.f815a == null) {
                    Debugger.m8615i(TAG, "LazyInitialize() : AppInfoContract is null!");
                    c0322hM670a.f815a = new AppInfoContractImpl(context);
                }
                c0322hM670a.f823i = new MemoConverterContractImpl();
                c0322hM670a.f824j = new ExternalConverterContractImpl();
                c0322hM670a.f816b = new ZipUtilContractImpl();
                c0322hM670a.f826l = new LockUtilsContractImpl();
                c0322hM670a.f818d = new NotificationContractImpl();
                c0322hM670a.f828n = new SyncManagerContractImpl();
                c0322hM670a.f831q = new SDocResolverContractImpl();
                c0322hM670a.f827m = new WidgetContractImpl();
                c0322hM670a.f821g = new ToastModelContractImpl();
                c0322hM670a.f819e = new NotificationModelContractImpl();
                c0322hM670a.f820f = new TipCardModelContractImpl();
                c0322hM670a.f822h = new DialogContractImpl();
                c0322hM670a.f833s = new CoeditDownloadContractImpl();
                c0322hM670a.f832r = new SaveNoteResolverContractImpl();
                c0322hM670a.f829o = new SDocCategoryResolverContractImpl();
                c0322hM670a.f825k = new SDocCipherInputStreamContractImpl();
                c0322hM670a.f817c = new SDocCipherOutputStreamContractImpl();
                c0322hM670a.f830p = new SDocTagResolverContractImpl();
                C6751f.m4890a(context).m4891b();
                C0171a.m429a().f544b = new InterfaceC0172b() { // from class: com.samsung.android.support.senl.nt.app.sync.SyncInitializer.1
                    @Override // p052M.InterfaceC0172b
                    public void showGoToSettingsDialog(WeakReference<Activity> weakReference) {
                        GcsGroupNetworkUtils.showGoToSettingsDialog(weakReference);
                    }
                };
                AbstractC0159b.f493a = SyncInitState$InitState.initialized;
                Debugger.m8615i(TAG, "LazyInitialize() finish");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void quickInitialize(Context context) {
        Debugger.m8615i(TAG, "quickInitialize() start");
        C0322h c0322hM670a = C0322h.m670a();
        if (c0322hM670a.f815a == null) {
            c0322hM670a.f815a = new AppInfoContractImpl(context);
        }
        if (SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel()) {
            Debugger.m8615i(TAG, "quickInitialize() finish");
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            FirebaseApp.initializeApp(context);
        } catch (Throwable th) {
            Debugger.m8612ef("FirebaseUtil", "[PUSH] fail to initialize the firebase : " + th);
        }
        Debugger.m8615i(TAG, "quickInitialize() finish : et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
    }
}
