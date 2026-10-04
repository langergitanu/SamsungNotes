package com.samsung.android.support.senl.p148nt.app.settings.main;

import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper$mTurnOnWiFiSyncOnlyConfirmDialogFragmentListener$1$onConfirm$1 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"com/samsung/android/support/senl/nt/app/settings/main/SettingsSyncHelper$mTurnOnWiFiSyncOnlyConfirmDialogFragmentListener$1$onConfirm$1", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Callback;", "PROGRESS_TAG", "", "onStart", "", "task", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "onEnd", "result", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class C8823xcc108cb6 implements WorkerTask.Callback {
    final /* synthetic */ SettingsBaseFragment $fragment;
    private final String PROGRESS_TAG = "progress_dialog";
    final /* synthetic */ C8822xaa7b352c this$0;

    public C8823xcc108cb6(SettingsBaseFragment settingsBaseFragment, C8822xaa7b352c c8822xaa7b352c) {
        this.$fragment = settingsBaseFragment;
        this.this$0 = c8822xaa7b352c;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
    public void onEnd(WorkerTask.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C8824xdc9e5e1b(this.$fragment, this, this.this$0, null), 3, null);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
    public void onStart(WorkerTask<?> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C8825x1d4dc322(task, this.$fragment, this, null), 3, null);
    }
}
