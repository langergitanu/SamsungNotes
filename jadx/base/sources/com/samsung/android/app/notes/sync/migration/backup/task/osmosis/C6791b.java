package com.samsung.android.app.notes.sync.migration.backup.task.osmosis;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.smartswitchfileshare.FileShareHelper;
import com.samsung.android.support.senl.p145cm.base.common.util.HashUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import p042J1.AbstractC0147e;
import p042J1.C0148f;
import p049L0.C0168a;
import p053M0.AbstractC0173a;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p186h1.AbstractC12031l;
import p234q1.C14433b;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.backup.task.osmosis.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6791b extends AbstractC0173a {

    /* JADX INFO: renamed from: n */
    public static final String f4195n = "SS$".concat("OSmosisEntireBackupTask");

    /* JADX INFO: renamed from: g */
    public final String f4196g;

    /* JADX INFO: renamed from: h */
    public final String f4197h;

    /* JADX INFO: renamed from: i */
    public final Uri f4198i;

    /* JADX INFO: renamed from: j */
    public final Uri f4199j;

    /* JADX INFO: renamed from: k */
    public int f4200k;

    /* JADX INFO: renamed from: l */
    public final CoroutineScope f4201l;

    /* JADX INFO: renamed from: m */
    public OSmosisBackupTask$State f4202m;

    public C6791b(C0168a c0168a) {
        Uri uri;
        super(c0168a);
        this.f4196g = "";
        this.f4197h = "";
        this.f4201l = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.f4202m = OSmosisBackupTask$State.NONE;
        this.f4196g = AbstractC0541b.m756B(c0168a.f515c, "/NOTES/data");
        this.f4197h = AbstractC0541b.m756B(c0168a.f515c, "/NOTES_ATTACHMENTS/data");
        Context contextM435b = AbstractC0173a.m435b();
        Intent intent = c0168a.f513a;
        if (Build.VERSION.SDK_INT >= 35) {
            String str = AbstractC12031l.f8796a;
            uri = (Uri) new FileShareHelper(contextM435b.getApplicationContext(), AbstractC12031l.f8796a).getPathUris(intent).getFirst();
        } else {
            uri = (Uri) AbstractC12031l.m13715e(contextM435b).get(0);
        }
        Context applicationContext = AbstractC0173a.m435b().getApplicationContext();
        String str2 = AbstractC12031l.f8796a;
        this.f4198i = new FileShareHelper(applicationContext, str2).createDirectory(uri, "NOTES");
        this.f4199j = new FileShareHelper(AbstractC0173a.m435b().getApplicationContext(), str2).createDirectory(uri, "NOTES_ATTACHMENTS");
    }

    /* JADX INFO: renamed from: e */
    public static File m4954e(File file) {
        String strExtractFileName = FileUtils.extractFileName(file.getAbsolutePath());
        String strGenerateSha256 = HashUtils.generateSha256(strExtractFileName);
        if (strGenerateSha256 == null) {
            throw new IllegalArgumentException(AbstractC0541b.m772n("changeDataFileName failed create hash: ", strExtractFileName));
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        String strReplace = StringsKt__StringsJVMKt.replace(absolutePath, strExtractFileName, strGenerateSha256, false);
        FileUtils.moveFile(file.getAbsolutePath(), strReplace);
        return new File(strReplace);
    }

    @Override // p053M0.AbstractC0173a
    /* JADX INFO: renamed from: a */
    public final void mo436a() {
        String str = f4195n;
        AbstractC0299q.m643n(str, "doInBackground");
        AbstractC0299q.m643n(str, "transferBackupData");
        OSmosisBackupTask$State oSmosisBackupTask$State = OSmosisBackupTask$State.NOTES_TRANSFERRING;
        this.f4202m = oSmosisBackupTask$State;
        int i = AbstractC6790a.f4194a[oSmosisBackupTask$State.ordinal()];
        this.f4200k = i != 1 ? i != 2 ? this.f4200k : 30 : 10;
        File[] fileArrListFiles = new File(this.f4196g).listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                Context contextM435b = AbstractC0173a.m435b();
                Intrinsics.checkNotNull(file);
                AbstractC12031l.m13720j(contextM435b, m4954e(file), this.f4198i);
            }
        }
        OSmosisBackupTask$State oSmosisBackupTask$State2 = OSmosisBackupTask$State.ATTACHMENT_TRANSFERRING;
        this.f4202m = oSmosisBackupTask$State2;
        int i2 = AbstractC6790a.f4194a[oSmosisBackupTask$State2.ordinal()];
        this.f4200k = i2 != 1 ? i2 != 2 ? this.f4200k : 30 : 10;
        File[] fileArrListFiles2 = new File(this.f4197h).listFiles();
        if (fileArrListFiles2 != null) {
            for (File file2 : fileArrListFiles2) {
                Context contextM435b2 = AbstractC0173a.m435b();
                Intrinsics.checkNotNull(file2);
                AbstractC12031l.m13720j(contextM435b2, m4954e(file2), this.f4199j);
            }
        }
    }

    @Override // p053M0.AbstractC0173a
    /* JADX INFO: renamed from: c */
    public final void mo437c() {
        AbstractC0299q.m643n(f4195n, "onPostExecute");
        CoroutineScopeKt.cancel$default(this.f4201l, null, 1, null);
        String str = C0148f.f420k;
        AbstractC0147e.f419a.f439i = false;
        C0148f.m356l(100);
        C0168a c0168a = this.f549a;
        String str2 = c0168a.f516d;
        String str3 = c0168a.f518f;
        Debugger.m8615i("SS$SmartSwitchUtils", "com.samsung.android.intent.action.RESPONSE_BACKUP_OSMOSIS_NOTES: res = 0 code = 0 source = " + str2);
        Intent intent = new Intent("com.samsung.android.intent.action.RESPONSE_BACKUP_OSMOSIS_NOTES");
        intent.putExtra("RESULT", 0);
        intent.putExtra("ERR_CODE", 0);
        intent.putExtra("REQ_SIZE", 0);
        intent.putExtra("SOURCE", str2);
        intent.putExtra("EXPORT_SESSION_TIME", str3);
        C0322h.m670a().f815a.getAppContext().sendBroadcast(intent, "com.wssnps.permission.COM_WSSNPS");
        C14433b c14433b = this.f552d;
        if (c14433b != null) {
            c14433b.m15040r();
        }
    }

    @Override // p053M0.AbstractC0173a
    /* JADX INFO: renamed from: d */
    public final void mo438d() {
        AbstractC0299q.m643n(f4195n, "onPreExecute");
        String str = C0148f.f420k;
        AbstractC0147e.f419a.f439i = true;
        C0148f.m356l(1);
        BuildersKt__Builders_commonKt.launch$default(this.f4201l, null, null, new OSmosisBackupTask$onPreExecute$1(this, null), 3, null);
    }
}
