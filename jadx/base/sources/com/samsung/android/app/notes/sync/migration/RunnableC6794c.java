package com.samsung.android.app.notes.sync.migration;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.migration.common.Type$Flow;
import com.samsung.android.app.notes.sync.migration.common.Type$Interface;
import com.samsung.android.app.notes.sync.migration.common.Type$Process;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.smartswitchfileshare.Constants;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import p001A.AbstractC0000a;
import p042J1.AbstractC0147e;
import p042J1.AbstractC0155m;
import p042J1.C0148f;
import p049L0.C0168a;
import p053M0.AbstractC0173a;
import p057N0.C0180a;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p174d1.C11972a;
import p176e1.AbstractC11975a;
import p176e1.AbstractC11976b;
import p186h1.AbstractC12030k;
import p186h1.AbstractC12031l;
import p186h1.C12020a;
import p186h1.C12021b;
import p234q1.C14433b;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC6794c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4210a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Intent f4211b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C6798g f4212c;

    public /* synthetic */ RunnableC6794c(C6798g c6798g, Intent intent, int i) {
        this.f4210a = i;
        this.f4212c = c6798g;
        this.f4211b = intent;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        String absolutePath;
        C6835r c6835r;
        String str;
        int i;
        boolean z;
        String[] list;
        int i2 = this.f4210a;
        Intent intent = this.f4211b;
        C6798g c6798g = this.f4212c;
        switch (i2) {
            case 0:
                Context appContext = C0322h.m670a().f815a.getAppContext();
                String str2 = AbstractC12031l.f8796a;
                Type$Interface type$InterfaceM15156p = AbstractC14517a.m15156p(intent);
                Type$Process type$ProcessM15158r = AbstractC14517a.m15158r(intent);
                int i4 = AbstractC12030k.f8795a[type$InterfaceM15156p.ordinal()];
                if (i4 == 1) {
                    String strM15160t = AbstractC14517a.m15160t(intent, Constants.SAVE_PATH_EXTRAS);
                    try {
                        absolutePath = new File(AbstractC12031l.m13712b(appContext, "/SmartSwitch/OSmosisBackUp/", AbstractC12031l.m13713c(appContext, AbstractC12031l.m13716f(appContext, intent)))).getAbsolutePath();
                    } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                        AbstractC0299q.m646q(str2, "getOsmosisBackUpPath exception " + e.getMessage());
                        absolutePath = strM15160t;
                    }
                    AbstractC0299q.m603M(str2, "getOsmosisBackUpPath path " + Logger.getEncode(absolutePath));
                } else if (i4 != 2) {
                    AbstractC0299q.m646q(str2, "getBackUpPath wrong interface");
                    absolutePath = AbstractC14517a.m15160t(intent, Constants.SAVE_PATH_EXTRAS);
                } else if (type$ProcessM15158r == Type$Process.INSTANT) {
                    absolutePath = AbstractC12031l.m13714d(appContext);
                } else {
                    String strM15160t2 = AbstractC14517a.m15160t(intent, Constants.SAVE_PATH_EXTRAS);
                    try {
                        if (AbstractC12031l.m13719i() && !SecureFolderConstants.SECURE_FOLDER_PACKAGE.equals(AbstractC14517a.m15160t(intent, "SOURCE"))) {
                            strM15160t2 = new File(AbstractC12031l.m13712b(appContext, "/SmartSwitch/BackUp/", AbstractC12031l.m13713c(appContext, AbstractC12031l.m13716f(appContext, intent)))).getAbsolutePath();
                        }
                    } catch (IllegalArgumentException | IndexOutOfBoundsException e2) {
                        AbstractC0299q.m646q(str2, "getEntireBackUpPath exception " + e2.getMessage());
                    }
                    absolutePath = strM15160t2;
                    AbstractC0299q.m603M(str2, "getEntireBackUpPath path " + Logger.getEncode(absolutePath));
                }
                String strM15160t3 = AbstractC14517a.m15160t(intent, "SESSION_KEY");
                String strM15160t4 = AbstractC14517a.m15160t(intent, "SOURCE");
                String strM15160t5 = AbstractC14517a.m15160t(intent, "EXPORT_SESSION_TIME");
                int intExtra = intent.getIntExtra("SECURITY_LEVEL", 0);
                int intExtra2 = intent.getIntExtra("ACTION", 0);
                int intExtra3 = intent.getIntExtra("FILE_METADATA_BATCH_SIZE", 0);
                String strM15160t6 = AbstractC14517a.m15160t(intent, "PREPARE_TYPE");
                String str3 = C6798g.f4220k;
                StringBuilder sbM15l = AbstractC0000a.m15l("startBackup received from ", strM15160t4, " Extra params path[");
                sbM15l.append(Logger.getEncode(absolutePath));
                sbM15l.append("], security[");
                sbM15l.append(intExtra);
                sbM15l.append("], action[");
                sbM15l.append(intExtra2);
                sbM15l.append("]");
                AbstractC0299q.m643n(str3, sbM15l.toString());
                if (intExtra2 == 0) {
                    C0168a c0168a = new C0168a();
                    c0168a.f513a = intent;
                    c0168a.f515c = absolutePath;
                    c0168a.f516d = strM15160t4;
                    c0168a.f517e = strM15160t3;
                    c0168a.f518f = strM15160t5;
                    c0168a.f519g = intExtra;
                    c0168a.f531s = intExtra3;
                    c0168a.f532t = strM15160t6;
                    c0168a.f514b = AbstractC14517a.m15155o(intent);
                    String str4 = C0148f.f420k;
                    AbstractC0147e.f419a.getClass();
                    c0168a.f520h = WDocUtils.getNoteDirPath(C0322h.m670a().f815a.getAppContext());
                    c0168a.f526n = AbstractC0155m.m387b(WDocUtils.getNoteDirPath(C0322h.m670a().f815a.getAppContext()), "app_templates/added");
                    if (!TextUtils.isEmpty(c0168a.f520h)) {
                        c0168a.f521i = C0148f.m352e();
                        c0168a.f522j = C0148f.m349b();
                    }
                    if (!TextUtils.isEmpty(c0168a.f515c)) {
                        c0168a.f523k = AbstractC0155m.m387b(c0168a.f515c, com.samsung.android.support.senl.p148nt.base.common.constants.Constants.SMART_SWITCH_RESTORE_DIR_NAME);
                        c0168a.f524l = AbstractC0155m.m387b(c0168a.f515c, "SSWL");
                        c0168a.f525m = AbstractC0155m.m387b(c0168a.f515c, "SmartSwitchRestoreDB");
                        c0168a.f527o = AbstractC0155m.m387b(c0168a.f515c, "pageTemplate");
                    }
                    c0168a.f528p = c0168a.f513a.getBooleanExtra("EXCLUDE_TRASH", false);
                    AbstractC0299q.m643n(C0168a.f512u, "initialize excludeTrash " + c0168a.f528p);
                    Type$Interface type$InterfaceM15156p2 = AbstractC14517a.m15156p(c0168a.f513a);
                    Type$Process type$ProcessM15158r2 = AbstractC14517a.m15158r(c0168a.f513a);
                    c0168a.f529q = new C6903f(type$InterfaceM15156p2, type$ProcessM15158r2, Type$Flow.NONE);
                    Type$Process type$Process = Type$Process.INSTANT;
                    if (type$ProcessM15158r2 == type$Process) {
                        String strM15160t7 = AbstractC14517a.m15160t(c0168a.f513a, "TARGET_PACKAGE");
                        if (TextUtils.isEmpty(strM15160t7) || !strM15160t7.equals("SmartSwitch")) {
                            c0168a.f530r = "com.samsung.android.scloud";
                        } else {
                            c0168a.f530r = "com.sec.android.easyMover";
                        }
                    }
                    c6798g.getClass();
                    AbstractC0299q.m643n(str3, "startBackup");
                    c6798g.m4968m();
                    C6789b c6789b = c6798g.f4226e;
                    c6789b.f4193d = new C14433b(c6798g, 8);
                    c6789b.f4191b = c0168a;
                    C6903f c6903f = c0168a.f529q;
                    Type$Interface type$Interface = (Type$Interface) c6903f.f4474b;
                    Type$Process type$Process2 = (Type$Process) c6903f.f4475c;
                    String str5 = C6789b.f4189e;
                    AbstractC0299q.m643n(str5, "onStartBackup interfaceType/processType " + type$Interface + "/" + type$Process2);
                    if (type$Process2 != type$Process) {
                        c6789b.m4953a(c6789b.f4193d);
                        break;
                    } else {
                        c6835r = c6789b.f4192c;
                        String str6 = c6789b.f4191b.f514b;
                        str6.getClass();
                        switch (str6) {
                            case "com.samsung.android.intent.action.REQUEST_BACKUP_OSMOSIS_NOTES":
                            case "com.samsung.android.intent.action.REQUEST_PREPARE_OSMOSIS_NOTES":
                            case "com.samsung.android.intent.action.REQUEST_INSTANT_SNAPSHOT":
                                String str7 = C6835r.f4246f;
                                AbstractC0299q.m643n(str7, "onReady state " + c6835r.f4251e);
                                MigrationScheduler$State migrationScheduler$State = c6835r.f4251e;
                                if (migrationScheduler$State == MigrationScheduler$State.NONE || migrationScheduler$State == MigrationScheduler$State.FINISH) {
                                    c6835r.f4251e = MigrationScheduler$State.READY;
                                    c6835r.f4248b = new C12021b(5);
                                    Timer timer = new Timer();
                                    c6835r.f4249c = timer;
                                    timer.schedule(new C0180a(c6835r, 1), 0L, 2000L);
                                    Timer timer2 = new Timer();
                                    c6835r.f4250d = timer2;
                                    timer2.schedule(new C6799h(), 0L, 2000L);
                                    new SenlThreadFactory(str7.concat("$ComposerStartManager")).newThread(new RunnableC6801j(c6835r)).start();
                                    new SenlThreadFactory(str7.concat("$SyncStartManager")).newThread(new RunnableC6803l(c6835r)).start();
                                    new SenlThreadFactory(str7.concat("$ModelStartManager")).newThread(new RunnableC6805n(c6835r)).start();
                                    new SenlThreadFactory(str7.concat("$MainListStartManager")).newThread(new RunnableC6806o(c6835r)).start();
                                    new SenlThreadFactory(str7.concat("$CoeditStartManager")).newThread(new RunnableC6807p(c6835r)).start();
                                    try {
                                        c6835r.f4248b.await();
                                    } catch (InterruptedException e3) {
                                        AbstractC0299q.m643n(str7, "startCountDownLatch " + e3.getMessage());
                                    }
                                    boolean z2 = c6835r.f4248b.f8774a;
                                    AbstractC0299q.m643n(str7, "onStart interrupted " + z2);
                                    if (!z2) {
                                        c6835r.f4251e = MigrationScheduler$State.START;
                                        c6835r.f4250d.cancel();
                                        C6789b c6789b2 = c6835r.f4247a;
                                        c6789b2.getClass();
                                        AbstractC0299q.m643n(str5, "onStartBackup");
                                        c6789b2.m4953a(c6789b2.f4193d);
                                        break;
                                    }
                                    break;
                                }
                                break;
                            case "com.samsung.android.intent.action.NOTICE_INSTANT_UPLOAD_DONE":
                                c6835r.m4999c();
                                c6789b.m4953a(c6789b.f4193d);
                                break;
                            case "com.samsung.android.intent.action.NOTICE_INSTANT_TASK_CANCELED":
                                c6835r.getClass();
                                AbstractC0299q.m643n(C6835r.f4246f, "onStop");
                                MigrationScheduler$State migrationScheduler$State2 = MigrationScheduler$State.STOP;
                                if (c6835r.m4998b(migrationScheduler$State2)) {
                                    c6835r.f4251e = migrationScheduler$State2;
                                    C12021b c12021b = c6835r.f4248b;
                                    c12021b.getClass();
                                    AbstractC0299q.m643n(C12021b.f8773b, "interrupt");
                                    if (c12021b.getCount() != 0) {
                                        c12021b.f8774a = true;
                                        while (c12021b.getCount() > 0) {
                                            c12021b.countDown();
                                        }
                                    }
                                }
                                c6835r.m4999c();
                                c6789b.m4953a(c6789b.f4193d);
                                break;
                        }
                    }
                } else if (intExtra2 != 2) {
                    AbstractC0299q.m646q(str3, "startBackup invalid action, stopped");
                    Type$Process type$ProcessM15158r3 = AbstractC14517a.m15158r(intent);
                    c6798g.getClass();
                    if (type$ProcessM15158r3 == Type$Process.ENTIRE) {
                        String str8 = C0148f.f420k;
                        AbstractC0147e.f419a.getClass();
                        C0148f.m357m(1, 1, strM15160t4, strM15160t5);
                    } else {
                        String str9 = C0148f.f420k;
                        AbstractC0147e.f419a.getClass();
                        C0148f.m360p(1, 1, strM15160t4);
                    }
                    break;
                } else {
                    c6798g.getClass();
                    AbstractC0299q.m643n(str3, "stopBackUp");
                    c6798g.m4970o();
                    AbstractC0173a abstractC0173a = c6798g.f4226e.f4190a;
                    if (abstractC0173a != null && abstractC0173a.f551c) {
                        AbstractC0299q.m643n(AbstractC0173a.f548f, "stop");
                        abstractC0173a.f550b = true;
                        break;
                    }
                }
                break;
            case 1:
                Context appContext2 = C0322h.m670a().f815a.getAppContext();
                String str10 = AbstractC12031l.f8796a;
                String strM15160t8 = AbstractC14517a.m15160t(intent, Constants.SAVE_PATH_EXTRAS);
                try {
                    if (AbstractC12031l.m13719i()) {
                        ArrayList arrayListM13716f = AbstractC12031l.m13716f(appContext2, intent);
                        strM15160t8 = AbstractC12031l.m13722l(appContext2, AbstractC12031l.m13712b(appContext2, "/SmartSwitch/Restore/", AbstractC12031l.m13713c(appContext2, arrayListM13716f)), strM15160t8, arrayListM13716f);
                    }
                } catch (IllegalArgumentException | IndexOutOfBoundsException e5) {
                    AbstractC0299q.m646q(str10, "getReceivedRestorePath exception " + e5.getMessage());
                }
                AbstractC0299q.m603M(str10, "getReceivedRestorePath path " + Logger.getEncode(strM15160t8));
                String strM15160t9 = AbstractC14517a.m15160t(intent, "SESSION_KEY");
                String strM15160t10 = AbstractC14517a.m15160t(intent, "SOURCE");
                String strM15160t11 = AbstractC14517a.m15160t(intent, "EXPORT_SESSION_TIME");
                int intExtra4 = intent.getIntExtra("SECURITY_LEVEL", 0);
                String str11 = C6798g.f4220k;
                String strConcat = !strM15160t8.endsWith("/") ? strM15160t8.concat("/") : strM15160t8;
                if (strConcat.contains("/SamsungNote/")) {
                    StringBuilder sb = new StringBuilder("This model name is ");
                    String str12 = Build.MODEL;
                    sb.append(str12);
                    AbstractC0299q.m643n(str11, sb.toString());
                    if (str12.contains("SM-J250") || str12.contains("SM-A530") || str12.contains("SM-A730")) {
                        str = strM15160t10;
                        i = 128;
                    } else {
                        str = strM15160t10;
                        i = 1;
                    }
                } else if (strConcat.contains("/NMemo/")) {
                    str = strM15160t10;
                    i = 8;
                } else if (strConcat.contains("/Etc/")) {
                    str = strM15160t10;
                    i = 2;
                } else {
                    AbstractC0299q.m646q(str11, "getRestoreVersion not exist proper folder");
                    C6798g.m4963k(AbstractC14517a.m15158r(intent), AbstractC14517a.m15155o(intent), strM15160t10, strM15160t11, 1, 1);
                    str = strM15160t10;
                    i = 0;
                }
                AbstractC0299q.m643n(str11, "startRestoreMigration " + intent.getAction() + " received from " + str + "Extra params path[" + strM15160t8 + "], security[" + intExtra4 + "]");
                if (i == 0) {
                    AbstractC0299q.m643n(str11, "checkBackUpFile version is none");
                    z = false;
                } else {
                    File file = new File(strM15160t8);
                    if (!file.isDirectory() || (list = file.list()) == null) {
                        z = false;
                    } else {
                        z = false;
                        for (String str13 : list) {
                            if (str13 != null) {
                                File file2 = new File(str13);
                                if ((i == 1 && file2.getName().equals("sdoc.bk")) || ((i == 8 && file2.getName().equals("memo.bk")) || ((i == 2 && file2.getName().equals("memo.bk")) || (i == 128 && file2.getName().equals("sdoc.bk"))))) {
                                    z = true;
                                }
                            }
                        }
                    }
                    AbstractC0299q.m643n(str11, "checkBackUpFile restoreMemo isValid " + z + " version " + i);
                }
                if (z) {
                    c6798g.m4968m();
                    String str14 = C0148f.f420k;
                    C0148f c0148f = AbstractC0147e.f419a;
                    c0148f.f431a = str;
                    c0148f.f432b = strM15160t11;
                    C6798g.m4959d(c6798g, AbstractC14517a.m15158r(intent), 0);
                    String str15 = C6798g.f4220k;
                    AbstractC0299q.m643n(str15, "startSmartSwitchRestoreMigration");
                    if (i == 1 || i == 128) {
                        try {
                            FileUtils.forceRenameTo(AbstractC0155m.m387b(strM15160t8, "sdoc.bk"), AbstractC0155m.m387b(strM15160t8, "sdoc_rename.bk"));
                            c0148f.f434d = true;
                        } catch (IOException e6) {
                            StringBuilder sbM778t = AbstractC0541b.m778t(i, "startSmartSwitchRestoreMigration version ", SQLKeyword.COMMA);
                            sbM778t.append(e6.getMessage());
                            AbstractC0299q.m643n(str15, sbM778t.toString());
                        }
                    } else if (i == 8) {
                        try {
                            FileUtils.forceRenameTo(AbstractC0155m.m387b(strM15160t8, "memo.bk"), AbstractC0155m.m387b(strM15160t8, "memo_rename.bk"));
                            c0148f.f435e = true;
                        } catch (IOException e7) {
                            StringBuilder sbM778t2 = AbstractC0541b.m778t(i, "startSmartSwitchRestoreMigration version ", SQLKeyword.COMMA);
                            sbM778t2.append(e7.getMessage());
                            AbstractC0299q.m643n(str15, sbM778t2.toString());
                        }
                    } else if (i == 2) {
                        try {
                            FileUtils.forceRenameTo(AbstractC0155m.m387b(strM15160t8, "memo.bk"), AbstractC0155m.m387b(strM15160t8, "memo_rename.bk"));
                            c0148f.f436f = true;
                        } catch (IOException e8) {
                            StringBuilder sbM778t3 = AbstractC0541b.m778t(i, "startSmartSwitchRestoreMigration version ", SQLKeyword.COMMA);
                            sbM778t3.append(e8.getMessage());
                            AbstractC0299q.m643n(str15, sbM778t3.toString());
                        }
                    }
                    C12020a c12020a = new C12020a(11, (byte) 0);
                    C11972a c11972a = (C11972a) c12020a.f8772b;
                    c11972a.f8536a = strM15160t8;
                    c11972a.f8538c = str;
                    c11972a.f8539d = strM15160t9;
                    c11972a.f8540e = strM15160t11;
                    c11972a.f8541f = intExtra4;
                    c11972a.f8542g = i;
                    c11972a.f8543h = true;
                    c11972a.f8544i = intent;
                    ArrayList arrayListM13553a = AbstractC11976b.m13553a(c12020a.m13630I());
                    if (arrayListM13553a.isEmpty()) {
                        AbstractC0299q.m646q(str15, "startSmartSwitchRestoreMigration failed to create restore task");
                    } else {
                        Iterator it = arrayListM13553a.iterator();
                        while (it.hasNext()) {
                            ((AbstractC11975a) it.next()).f8564n = c6798g.f4231j;
                        }
                        c6798g.f4226e.getClass();
                        C6789b.m4952b(arrayListM13553a);
                    }
                } else {
                    AbstractC0299q.m646q(C6798g.f4220k, "startRestoreMigration proper files are not detected in ".concat(strM15160t8));
                    C6798g.m4963k(AbstractC14517a.m15158r(intent), AbstractC14517a.m15155o(intent), str, strM15160t11, 1, 1);
                }
                break;
            case 2:
                String strM13714d = AbstractC12031l.m13714d(C0322h.m670a().f815a.getAppContext());
                String strM15160t12 = AbstractC14517a.m15160t(intent, "SESSION_KEY");
                String strM15160t13 = AbstractC14517a.m15160t(intent, "SOURCE");
                String strM15160t14 = AbstractC14517a.m15160t(intent, "EXPORT_SESSION_TIME");
                int intExtra5 = intent.getIntExtra("SECURITY_LEVEL", 0);
                c6798g.getClass();
                int i5 = "com.samsung.android.intent.action.REQUEST_INSTANT_SNAPSHOT".equals(AbstractC14517a.m15155o(intent)) ? 4096 : 1024;
                String str16 = C6798g.f4220k;
                AbstractC0299q.m643n(str16, "startInstantRestoreMigration " + intent.getAction() + " received from " + strM15160t13 + " extra params path[" + strM13714d + "], security[" + intExtra5 + "]");
                C12020a c12020a2 = new C12020a(11, (byte) 0);
                C11972a c11972a2 = (C11972a) c12020a2.f8772b;
                c11972a2.f8536a = strM13714d;
                c11972a2.f8538c = strM15160t13;
                c11972a2.f8539d = strM15160t12;
                c11972a2.f8540e = strM15160t14;
                c11972a2.f8541f = intExtra5;
                c11972a2.f8542g = i5;
                c11972a2.f8543h = true;
                c11972a2.f8544i = intent;
                ArrayList arrayListM13553a2 = AbstractC11976b.m13553a(c12020a2.m13630I());
                if (arrayListM13553a2.isEmpty()) {
                    AbstractC0299q.m646q(str16, "startInstantRestoreMigration failed to create restore task");
                } else {
                    c6798g.m4968m();
                    Iterator it2 = arrayListM13553a2.iterator();
                    while (it2.hasNext()) {
                        ((AbstractC11975a) it2.next()).f8564n = c6798g.f4231j;
                    }
                    c6798g.f4226e.getClass();
                    C6789b.m4952b(arrayListM13553a2);
                }
                break;
            default:
                Context appContext3 = C0322h.m670a().f815a.getAppContext();
                String str17 = AbstractC12031l.f8796a;
                String strM15160t15 = AbstractC14517a.m15160t(intent, Constants.SAVE_PATH_EXTRAS);
                try {
                    strM15160t15 = new File(AbstractC12031l.m13712b(appContext3, "/SmartSwitch/OSmosisBackUp/", AbstractC12031l.m13713c(appContext3, AbstractC12031l.m13716f(appContext3, intent)))).getAbsolutePath();
                } catch (IllegalArgumentException | IndexOutOfBoundsException e9) {
                    AbstractC0299q.m646q(str17, "getOsmosisRestorePath exception " + e9.getMessage());
                }
                AbstractC0299q.m603M(str17, "getOsmosisRestorePath path " + Logger.getEncode(strM15160t15));
                String strM15160t16 = AbstractC14517a.m15160t(intent, "SESSION_KEY");
                String strM15160t17 = AbstractC14517a.m15160t(intent, "SOURCE");
                String strM15160t18 = AbstractC14517a.m15160t(intent, "EXPORT_SESSION_TIME");
                int intExtra6 = intent.getIntExtra("SECURITY_LEVEL", 0);
                String str18 = C6798g.f4220k;
                AbstractC0299q.m643n(str18, "startOSmosisRestore " + intent.getAction() + " received from " + strM15160t17 + " extra params path[" + strM15160t15 + "], security[" + intExtra6 + "]");
                C12020a c12020a3 = new C12020a(11, (byte) 0);
                C11972a c11972a3 = (C11972a) c12020a3.f8772b;
                c11972a3.f8536a = strM15160t15;
                c11972a3.f8538c = strM15160t17;
                c11972a3.f8539d = strM15160t16;
                c11972a3.f8540e = strM15160t18;
                c11972a3.f8541f = intExtra6;
                c11972a3.f8542g = 8192;
                c11972a3.f8543h = true;
                c11972a3.f8544i = intent;
                ArrayList arrayListM13553a3 = AbstractC11976b.m13553a(c12020a3.m13630I());
                if (arrayListM13553a3.isEmpty()) {
                    AbstractC0299q.m646q(str18, "startOSmosisRestore failed to create restore task");
                } else {
                    c6798g.m4968m();
                    Iterator it3 = arrayListM13553a3.iterator();
                    while (it3.hasNext()) {
                        ((AbstractC11975a) it3.next()).f8564n = c6798g.f4231j;
                    }
                    c6798g.f4226e.getClass();
                    C6789b.m4952b(arrayListM13553a3);
                }
                break;
        }
    }
}
