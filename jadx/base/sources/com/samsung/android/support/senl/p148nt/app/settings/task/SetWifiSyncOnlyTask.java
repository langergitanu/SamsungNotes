package com.samsung.android.support.senl.p148nt.app.settings.task;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p244u1.C14477a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/task/SetWifiSyncOnlyTask;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "", "<init>", "()V", "execute", "", "taskParams", "(Ljava/lang/Boolean;)V", "getTag", "", "getResult", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SetWifiSyncOnlyTask extends WorkerTask<Boolean> {

    @NotNull
    private static final String TAG = "SetWifiSyncOnlyTask";

    public SetWifiSyncOnlyTask() {
        super(0, null, 3, null);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    public WorkerTask.Result getResult() {
        return new WorkerTask.Result() { // from class: com.samsung.android.support.senl.nt.app.settings.task.SetWifiSyncOnlyTask.getResult.1
            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
            public int getHashCode() {
                return 0;
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
            public String getTag() {
                return SetWifiSyncOnlyTask.TAG;
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void execute(@Nullable Boolean taskParams) {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        C14477a.m15065b().f10283a.m5103m(applicationContext, Intrinsics.areEqual(taskParams, Boolean.TRUE), false);
    }
}
