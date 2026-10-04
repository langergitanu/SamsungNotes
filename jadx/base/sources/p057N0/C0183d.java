package p057N0;

import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.migration.common.Type$Flow;
import com.samsung.android.app.notes.sync.migration.common.Type$Interface;
import com.samsung.android.app.notes.sync.migration.common.Type$Process;
import com.samsung.android.app.notes.sync.synchronization.managers.C6900c;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.smartswitchfileshare.FileShareHelper;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import p001A.AbstractC0000a;
import p042J1.AbstractC0147e;
import p042J1.C0148f;
import p049L0.C0168a;
import p053M0.AbstractC0173a;
import p064P0.C0194a;
import p076S0.C0275a;
import p076S0.C0276b;
import p079T.AbstractC0299q;
import p094X0.C0339a;
import p186h1.AbstractC12031l;
import p234q1.C14433b;

/* JADX INFO: renamed from: N0.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0183d extends AbstractC0173a {

    /* JADX INFO: renamed from: h */
    public static final String f569h = "SS$".concat("InstantBackupTask");

    /* JADX INFO: renamed from: g */
    public File f570g;

    @Override // p053M0.AbstractC0173a
    /* JADX INFO: renamed from: a */
    public final void mo436a() throws Throwable {
        String str;
        C0168a c0168a;
        str = f569h;
        AbstractC0299q.m643n(str, "InstantBackupTask start");
        this.f551c = true;
        c0168a = this.f549a;
        String str2 = c0168a.f514b;
        str2.getClass();
        switch (str2) {
            case "com.samsung.android.intent.action.REQUEST_INSTANT_SNAPSHOT":
                AbstractC0299q.m643n(str, "executeRequestInstantSnapshot");
                try {
                    m447e();
                    m448f();
                    m450h();
                    m449g();
                    break;
                } catch (Exception e) {
                    AbstractC6670b.m4762w(e, new StringBuilder("executeRequestInstantSnapshot exception "), str);
                    break;
                }
                break;
            case "com.samsung.android.intent.action.NOTICE_INSTANT_UPLOAD_DONE":
                AbstractC0299q.m643n(str, "executeNoticeInstantUploadDone");
                AbstractC0299q.m643n(str, "clearBackupData " + Logger.getEncode(c0168a.f515c));
                try {
                    FileUtils.deleteFile(new File(c0168a.f515c));
                    break;
                } catch (IOException e2) {
                    AbstractC0000a.m1B(e2, new StringBuilder("clearBackupData. "), str);
                }
                AbstractC0299q.m643n(str, "clearSnapShot " + Logger.getEncode(this.f570g.getPath()));
                FileUtils.deleteFile(this.f570g.getPath());
                break;
            case "com.samsung.android.intent.action.NOTICE_INSTANT_TASK_CANCELED":
                AbstractC0299q.m643n(str, "executeNoticeTaskCanceled");
                break;
            default:
                AbstractC0299q.m646q(str, "InstantBackupTask invalid intent action");
                break;
        }
        AbstractC0299q.m643n(str, "InstantBackupTask end");
    }

    @Override // p053M0.AbstractC0173a
    /* JADX INFO: renamed from: c */
    public final void mo437c() {
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        C0148f.m355k(100);
        C0148f.m360p(0, 0, this.f549a.f516d);
        C14433b c14433b = this.f552d;
        if (c14433b != null) {
            c14433b.m15040r();
        }
    }

    @Override // p053M0.AbstractC0173a
    /* JADX INFO: renamed from: d */
    public final void mo438d() {
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        C0148f.m355k(2);
    }

    /* JADX INFO: renamed from: e */
    public final void m447e() throws Throwable {
        AbstractC0299q.m643n(f569h, "createBackupData");
        C6900c c6900c = new C6900c();
        C0194a c0194a = new C0194a();
        c0194a.f603a = AbstractC0173a.m435b();
        C0168a c0168a = this.f549a;
        c0194a.f604b = c0168a.f529q;
        c0194a.f605c = c0168a.f515c;
        c0194a.f606d = c0168a.f524l;
        c6900c.m5111a(c0194a);
        C0339a.m671a(c0168a.f526n, c0168a.f527o);
    }

    /* JADX INFO: renamed from: f */
    public final void m448f() throws Exception {
        AbstractC0299q.m643n(f569h, "createSnapShot");
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        C0148f.m355k(31);
        C0168a c0168a = this.f549a;
        List listAsList = Arrays.asList(new C0276b(c0168a.f515c), new C0276b(c0168a.f521i));
        new C0275a().m559a(AbstractC0173a.m435b(), new C6903f(Type$Interface.NONE, Type$Process.NONE, Type$Flow.BACKUP), c0168a.f530r, WDocUtils.getNoteFilePath(AbstractC0173a.m435b(), true) + "SDocBnR/", this.f570g, listAsList);
        C0148f.m355k(41);
    }

    /* JADX INFO: renamed from: g */
    public final void m449g() {
        if (DeviceInfo.isEngMode()) {
            try {
                FileUtils.copyFile(new File(this.f570g.getPath()), new File(AbstractC0173a.m435b().getFilesDir().toString() + "/" + new SimpleDateFormat("MM-dd HH_mm_ss.SSS").format(Long.valueOf(System.currentTimeMillis())) + "_backuplist.json"));
            } catch (IOException e) {
                AbstractC0000a.m1B(e, new StringBuilder("makeDebugBackupList. "), f569h);
            }
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m450h() throws Exception {
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        C0148f.m355k(51);
        Context contextM435b = AbstractC0173a.m435b();
        File file = this.f570g;
        C0168a c0168a = this.f549a;
        Intent intent = c0168a.f513a;
        String str2 = AbstractC12031l.f8796a;
        int iCopy = new FileShareHelper(contextM435b.getApplicationContext(), AbstractC12031l.f8796a).copy(file, intent);
        Locale locale = Locale.ENGLISH;
        AbstractC0299q.m603M(f569h, "transferSnapshot ".concat(AbstractC1974b.m1319l("Intent[", iCopy, c0168a.f513a.getAction(), "] copyCount[", "]")));
        if (iCopy <= 0) {
            throw new Exception("transferSnapshot failed to copy");
        }
        C0148f.m355k(61);
    }
}
