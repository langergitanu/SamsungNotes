package com.samsung.android.support.senl.p148nt.app.sync.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.app.notes.sync.migration.MigrationService;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p186h1.AbstractC12027h;
import p186h1.C12020a;
import p186h1.CallableC12025f;
import p186h1.CallableC12026g;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class MigrationReceiver extends BroadcastReceiver {
    private static final String TAG = "SS$MigrationReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        long jLongValue;
        PackageManagerCompat.Companion companion = PackageManagerCompat.INSTANCE;
        if (companion.getInstance().isKMemoPackage(context)) {
            Debugger.m8607d(TAG, "onReceive NOT support PostMemo");
            return;
        }
        if (DeviceInfo.isOtherCorpDevice()) {
            Debugger.m8607d(TAG, "onReceive NOT support otherCorpDevice");
            return;
        }
        if (intent == null || intent.getAction() == null) {
            Debugger.m8609e(TAG, "onReceive intent or action is null.");
            return;
        }
        PostLaunchManager.getInstance().executeBaseLogics();
        Debugger.m8614f(TAG, "onReceive version/action " + companion.getInstance().getVersionInfo(context) + "/" + intent.getAction());
        String str = AbstractC12027h.f8778a;
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        Intrinsics.checkNotNull(action);
        if (!StringsKt.m14162r(action, "com.samsung.android.intent.action.REQUEST_PREPARE_SAMSUNGNOTE")) {
            C12020a.m13620N().f8772b = intent;
            ServiceManager.INSTANCE.getInstance().startService(BaseUtils.getApplicationContext(), new Intent(BaseUtils.getApplicationContext(), (Class<?>) MigrationService.class));
            return;
        }
        ExecutorService executorService = AbstractC12027h.f8790m;
        String str2 = AbstractC12027h.f8778a;
        Intrinsics.checkNotNullParameter(context, "context");
        AbstractC12027h.f8789l = context;
        Intent intent2 = new Intent("com.samsung.android.intent.action.RESPONSE_PREPARE_SAMSUNGNOTE");
        try {
            Future futureSubmit = executorService.submit(new CallableC12025f());
            Intrinsics.checkNotNull(futureSubmit, "null cannot be cast to non-null type java.util.concurrent.FutureTask<*>");
            Object obj = ((FutureTask) futureSubmit).get();
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            jLongValue = ((Long) obj).longValue();
        } catch (InterruptedException e) {
            Debugger.INSTANCE.m8621e(str2, "getContentCount# " + e.getMessage());
            jLongValue = 0;
        } catch (ExecutionException e2) {
            Debugger.INSTANCE.m8621e(str2, "getContentCount# " + e2.getMessage());
            jLongValue = 0;
        }
        Pair pair = new Pair(0L, 0L);
        try {
            Future futureSubmit2 = executorService.submit(new CallableC12026g());
            Intrinsics.checkNotNull(futureSubmit2, "null cannot be cast to non-null type java.util.concurrent.FutureTask<*>");
            Object obj2 = ((FutureTask) futureSubmit2).get();
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Pair<kotlin.Long, kotlin.Long>");
            pair = (Pair) obj2;
        } catch (InterruptedException e3) {
            Debugger.INSTANCE.m8621e(str2, "getLargestFileSize# " + e3.getMessage());
        } catch (ExecutionException e5) {
            Debugger.INSTANCE.m8621e(str2, "getLargestFileSize# " + e5.getMessage());
        }
        long jLongValue2 = ((Number) pair.getFirst()).longValue();
        long jLongValue3 = ((Number) pair.getSecond()).longValue();
        intent2.putExtra("IS_AVAILABLE_BNR", AbstractC12027h.f8782e);
        intent2.putExtra("BNR_ERROR_CODE", 0);
        intent2.putExtra("CONTENT_COUNT", jLongValue);
        intent2.putExtra("DATA_SIZE", jLongValue2);
        intent2.putExtra("BACKUP_TIMEOUT", AbstractC12027h.f8784g);
        intent2.putExtra("RESTORE_TIMEOUT", AbstractC12027h.f8785h);
        intent2.putExtra("REQUIRED_SPACE_BACKUP", ((long) AbstractC12027h.f8786i) * jLongValue2);
        long j = jLongValue2 / ((long) AbstractC12027h.f8780c);
        intent2.putExtra("REQUIRED_TIME_BACKUP", ((long) AbstractC12027h.f8787j) * j);
        intent2.putExtra("REQUIRED_TIME_RESTORE", ((long) AbstractC12027h.f8788k) * j);
        intent2.putExtra("IS_SUPPORT_STUB", AbstractC12027h.f8783f);
        intent2.putExtra("LARGEST_FILE_SIZE", jLongValue3);
        context.sendBroadcast(intent2, "com.wssnps.permission.COM_WSSNPS");
        Debugger.Companion companion2 = Debugger.INSTANCE;
        StringBuilder sbM1323p = AbstractC1974b.m1323p(jLongValue, "sendPrepareResponseIntent# contentCount/dataSize/largestFileSize ", " ");
        sbM1323p.append(jLongValue2);
        sbM1323p.append(" ");
        sbM1323p.append(jLongValue3);
        companion2.m8619d(str2, sbM1323p.toString());
    }
}
