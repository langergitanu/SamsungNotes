package com.samsung.android.support.senl.p148nt.app.settings.main;

import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper$mTurnOnWiFiSyncOnlyConfirmDialogFragmentListener$1$onConfirm$1$onStart$1 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper$mTurnOnWiFiSyncOnlyConfirmDialogFragmentListener$1$onConfirm$1$onStart$1", m14021f = "SettingsSyncHelper.kt", m14022i = {}, m14023l = {780, 781}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class C8825x1d4dc322 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SettingsBaseFragment $fragment;
    final /* synthetic */ WorkerTask<?> $task;
    int label;
    final /* synthetic */ C8823xcc108cb6 this$0;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper$mTurnOnWiFiSyncOnlyConfirmDialogFragmentListener$1$onConfirm$1$onStart$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper$mTurnOnWiFiSyncOnlyConfirmDialogFragmentListener$1$onConfirm$1$onStart$1$1", m14021f = "SettingsSyncHelper.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SettingsBaseFragment $fragment;
        final /* synthetic */ WorkerTask<?> $task;
        int label;
        final /* synthetic */ C8823xcc108cb6 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WorkerTask<?> workerTask, SettingsBaseFragment settingsBaseFragment, C8823xcc108cb6 c8823xcc108cb6, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$task = workerTask;
            this.$fragment = settingsBaseFragment;
            this.this$0 = c8823xcc108cb6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$task, this.$fragment, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.$task.isCompleted() || this.$task.isCancelled()) {
                return Unit.INSTANCE;
            }
            DialogFragment dialogFragmentCreateCircleProgressDialogFragment = DialogUtils.createCircleProgressDialogFragment();
            dialogFragmentCreateCircleProgressDialogFragment.setCancelable(false);
            dialogFragmentCreateCircleProgressDialogFragment.show(this.$fragment.getChildFragmentManager(), this.this$0.PROGRESS_TAG);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8825x1d4dc322(WorkerTask<?> workerTask, SettingsBaseFragment settingsBaseFragment, C8823xcc108cb6 c8823xcc108cb6, Continuation<? super C8825x1d4dc322> continuation) {
        super(2, continuation);
        this.$task = workerTask;
        this.$fragment = settingsBaseFragment;
        this.this$0 = c8823xcc108cb6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C8825x1d4dc322(this.$task, this.$fragment, this.this$0, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r8, r1, r7) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(200L, this) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        MainCoroutineDispatcher main = Dispatchers.getMain();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$task, this.$fragment, this.this$0, null);
        this.label = 2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C8825x1d4dc322) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
