package com.samsung.android.app.notes.sync.migration;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.notes.sync.migration.MigrationService;
import com.samsung.android.app.notes.sync.migration.common.Type$Process;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.ProgressListener;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import p020E.C0073a;
import p042J1.AbstractC0147e;
import p042J1.AbstractC0155m;
import p042J1.C0148f;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p186h1.AbstractC12031l;
import p186h1.C12020a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6798g {

    /* JADX INFO: renamed from: k */
    public static final String f4220k = "SS$".concat("MigrationManager");

    /* JADX INFO: renamed from: l */
    public static C6798g f4221l = null;

    /* JADX INFO: renamed from: f */
    public MigrationService f4227f;

    /* JADX INFO: renamed from: g */
    public ServiceConnection f4228g;

    /* JADX INFO: renamed from: a */
    public Class f4222a = null;

    /* JADX INFO: renamed from: b */
    public ProgressListener f4223b = null;

    /* JADX INFO: renamed from: c */
    public int f4224c = 0;

    /* JADX INFO: renamed from: d */
    public int f4225d = 0;

    /* JADX INFO: renamed from: h */
    public final ConcurrentLinkedQueue f4229h = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: i */
    public final ConcurrentLinkedQueue f4230i = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: j */
    public final C0073a f4231j = new C0073a(this, 7);

    /* JADX INFO: renamed from: e */
    public final C6789b f4226e = new C6789b();

    /* JADX INFO: renamed from: a */
    public static void m4956a(C6798g c6798g) {
        c6798g.getClass();
        String str = f4220k;
        AbstractC0299q.m643n(str, "clearBnRFiles start");
        String str2 = C0148f.f420k;
        if (!AbstractC0147e.f419a.m365f()) {
            AbstractC0299q.m643n(str, "clearBnRFiles no task running, delete path");
            m4961g(new File(C0148f.m351d()));
            m4961g(new File(AbstractC0155m.m387b(C0148f.m352e(), "NMEMO")));
            m4961g(new File(AbstractC0155m.m387b(C0148f.m352e(), "ETC")));
            m4961g(new File(AbstractC0155m.m387b(C0148f.m351d(), "SmartSwitchRestoreDB")));
            m4961g(new File(C0148f.f421l));
            m4961g(new File(C0148f.f422m));
            m4961g(new File(C0148f.f423n));
            m4961g(new File(C0148f.f424o));
            m4961g(new File(C0148f.f425p));
            m4961g(new File(C0148f.f426q));
            m4961g(new File(C0148f.f428s));
            m4961g(new File(C0148f.f429t));
            m4961g(new File(C0148f.f430u));
        }
        AbstractC0299q.m643n(str, "clearBnRFiles end");
    }

    /* JADX INFO: renamed from: b */
    public static void m4957b(C6798g c6798g) {
        c6798g.getClass();
        AbstractC0299q.m643n(f4220k, "clearRetryFiles");
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        m4961g(new File(C0148f.m351d()));
    }

    /* JADX INFO: renamed from: c */
    public static void m4958c(C6798g c6798g, int i, int i2) {
        if (c6798g.f4223b != null) {
            AbstractC0299q.m643n(f4220k, "notifyOnProgressImportListener " + i + "/" + i2);
            c6798g.f4223b.onProgress();
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m4959d(C6798g c6798g, Type$Process type$Process, int i) {
        if (type$Process == Type$Process.ENTIRE) {
            String str = C0148f.f420k;
            AbstractC0147e.f419a.m367j(i);
        } else {
            String str2 = C0148f.f420k;
            AbstractC0147e.f419a.getClass();
            C0148f.m355k(i);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m4960e(C6798g c6798g, int i) {
        if (i != 1) {
            if (i == 2) {
                String str = C0148f.f420k;
                AbstractC0147e.f419a.f436f = true;
                return;
            }
            if (i == 4) {
                String str2 = C0148f.f420k;
                AbstractC0147e.f419a.f437g = true;
                return;
            }
            if (i == 8 || i == 16 || i == 32) {
                String str3 = C0148f.f420k;
                AbstractC0147e.f419a.f435e = true;
                return;
            } else if (i != 64 && i != 128) {
                if (i == 256) {
                    String str4 = C0148f.f420k;
                    AbstractC0147e.f419a.f438h = true;
                    return;
                } else if (i != 1024 && i != 2048 && i != 4096) {
                    return;
                }
            }
        }
        String str5 = C0148f.f420k;
        AbstractC0147e.f419a.f434d = true;
    }

    /* JADX INFO: renamed from: g */
    public static void m4961g(File file) {
        if (file.exists()) {
            try {
                FileUtils.deleteFile(file);
            } catch (IOException e) {
                AbstractC0299q.m646q(f4220k, "deleteFile failed to delete " + file.getName() + SQLKeyword.COMMA + e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: h */
    public static synchronized C6798g m4962h() {
        try {
            if (f4221l == null) {
                f4221l = new C6798g();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4221l;
    }

    /* JADX INFO: renamed from: k */
    public static void m4963k(Type$Process type$Process, String str, String str2, String str3, int i, int i2) {
        if (type$Process == Type$Process.ENTIRE) {
            String str4 = C0148f.f420k;
            AbstractC0147e.f419a.getClass();
            C0148f.m358n(i, i2, str2, str3);
        } else if ("com.samsung.android.intent.action.REQUEST_INSTANT_SNAPSHOT".equals(str)) {
            String str5 = C0148f.f420k;
            AbstractC0147e.f419a.getClass();
            C0148f.m360p(i, i2, str2);
        } else {
            String str6 = C0148f.f420k;
            AbstractC0147e.f419a.getClass();
            C0148f.m359o(i, i2, str2, str3);
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m4964f() {
        AbstractC0299q.m643n(f4220k, "connectService");
        this.f4228g = new ServiceConnection() { // from class: com.samsung.android.app.notes.sync.migration.MigrationManager$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                AbstractC0299q.m643n(C6798g.f4220k, "onServiceConnected");
                this.this$0.f4227f = ((MigrationService.LocalBinder) iBinder).getService();
                Iterator it = this.this$0.f4230i.iterator();
                while (it.hasNext()) {
                    Executors.newSingleThreadExecutor(new SenlThreadFactory(C6798g.f4220k)).execute((Runnable) it.next());
                }
                Iterator it2 = this.this$0.f4229h.iterator();
                while (it2.hasNext()) {
                    Executors.newSingleThreadExecutor(new SenlThreadFactory(AbstractC0622a.m1170p(C6798g.f4220k, "SELF", new StringBuilder()))).execute((Runnable) it2.next());
                }
                this.this$0.f4230i.clear();
                this.this$0.f4229h.clear();
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                AbstractC0299q.m643n(C6798g.f4220k, "onServiceDisconnected");
                C6798g c6798g = this.this$0;
                c6798g.f4227f = null;
                c6798g.f4230i.clear();
                this.this$0.f4229h.clear();
                String str = C0148f.f420k;
                StringBuilder sb = AbstractC0147e.f419a.f440j;
                if (sb.length() > 0) {
                    Debugger.m8607d("SS$SmartSwitchUtils", "printHistoricalLogs " + ((Object) sb));
                    sb.setLength(0);
                }
            }
        };
        Context appContext = C0322h.m670a().f815a.getAppContext();
        appContext.bindService(new Intent(appContext, (Class<?>) MigrationService.class), this.f4228g, 1);
    }

    /* JADX INFO: renamed from: i */
    public final void m4965i(int i, int i2) {
        if (this.f4223b != null) {
            AbstractC0299q.m643n(f4220k, "notifyOnEndImportListener " + i + "/" + i2);
            this.f4223b.onEnd();
        }
    }

    /* JADX INFO: renamed from: j */
    public final void m4966j() {
        Class cls = this.f4222a;
        String str = f4220k;
        if (cls == null) {
            AbstractC0299q.m643n(str, "refreshTarget is ignored, target is null");
            return;
        }
        try {
            AbstractC0299q.m643n(str, "refreshTarget preferenceUpdated/true");
            Context appContext = C0322h.m670a().f815a.getAppContext();
            Intent intent = new Intent(appContext, (Class<?>) this.f4222a);
            intent.putExtra(Constants.PREFERENCE_UPDATED, true);
            intent.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
            appContext.startActivity(intent);
        } catch (Exception e) {
            AbstractC0299q.m646q(str, "refreshTarget failed " + e.getMessage());
        } finally {
            this.f4222a = null;
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m4967l(Intent intent) {
        m4964f();
        this.f4230i.add(new RunnableC6794c(this, intent, 0));
    }

    /* JADX INFO: renamed from: m */
    public final void m4968m() {
        if (this.f4227f == null || ServiceManager.INSTANCE.getInstance().isForegroundStarted(this.f4227f)) {
            return;
        }
        this.f4227f.startForegroundService();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005a  */
    /* JADX INFO: renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4969n(Class cls) {
        boolean z;
        Context appContext = C0322h.m670a().f815a.getAppContext();
        String str = AbstractC12031l.f8796a;
        if (!AbstractC12031l.m13711a(appContext)) {
            String str2 = C0148f.f420k;
            AbstractC0147e.f419a.getClass();
            boolean zExists = new File(C0148f.m351d()).exists();
            AbstractC0299q.m643n(str, "existSDocBnRFiles ret " + zExists);
            if (!zExists) {
                boolean zExists2 = new File(C0148f.f420k).exists();
                AbstractC0299q.m643n(str, "existSmartSwitchRestoreFolder ret " + zExists2);
                z = zExists2;
            }
        }
        AbstractC0299q.m603M(str, "existSmartSwitchData ret " + z);
        if (z) {
            String str3 = C0148f.f420k;
            if (AbstractC0147e.f419a.m365f()) {
                return;
            }
            String strM15155o = AbstractC14517a.m15155o((Intent) C12020a.m13620N().f8772b);
            String str4 = f4220k;
            AbstractC0299q.m643n(str4, "isRunningInstantSnapShot intentAction " + strM15155o);
            if ("com.samsung.android.intent.action.REQUEST_INSTANT_SNAPSHOT".equals(strM15155o)) {
                return;
            }
            AbstractC0299q.m643n(str4, "startSelfRestoreMigration");
            m4964f();
            this.f4229h.add(new RunnableC6795d(this, cls, appContext));
        }
    }

    /* JADX INFO: renamed from: o */
    public final void m4970o() {
        if (this.f4227f != null && ServiceManager.INSTANCE.getInstance().isForegroundStarted(this.f4227f)) {
            this.f4227f.stopForegroundService();
        }
        this.f4228g = null;
    }

    /* JADX INFO: renamed from: p */
    public final void m4971p() {
        String str = C0148f.f420k;
        if (AbstractC0147e.f419a.m365f()) {
            return;
        }
        m4970o();
        int i = this.f4225d;
        int i2 = this.f4224c;
        if (i < i2) {
            m4965i(i2, i2);
        }
        this.f4225d = 0;
        this.f4224c = 0;
    }
}
