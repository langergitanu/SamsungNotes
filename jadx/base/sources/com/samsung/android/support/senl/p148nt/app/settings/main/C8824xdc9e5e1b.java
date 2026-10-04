package com.samsung.android.support.senl.p148nt.app.settings.main;

import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper$mTurnOnWiFiSyncOnlyConfirmDialogFragmentListener$1$onConfirm$1$onEnd$1 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper$mTurnOnWiFiSyncOnlyConfirmDialogFragmentListener$1$onConfirm$1$onEnd$1", m14021f = "SettingsSyncHelper.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class C8824xdc9e5e1b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SettingsBaseFragment $fragment;
    int label;
    final /* synthetic */ C8823xcc108cb6 this$0;
    final /* synthetic */ C8822xaa7b352c this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8824xdc9e5e1b(SettingsBaseFragment settingsBaseFragment, C8823xcc108cb6 c8823xcc108cb6, C8822xaa7b352c c8822xaa7b352c, Continuation<? super C8824xdc9e5e1b> continuation) {
        super(2, continuation);
        this.$fragment = settingsBaseFragment;
        this.this$0 = c8823xcc108cb6;
        this.this$1 = c8822xaa7b352c;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C8824xdc9e5e1b(this.$fragment, this.this$0, this.this$1, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        DialogFragment dialogFragment = (DialogFragment) this.$fragment.getChildFragmentManager().findFragmentByTag(this.this$0.PROGRESS_TAG);
        if (dialogFragment != null) {
            dialogFragment.dismissAllowingStateLoss();
        }
        this.this$1.onConfirm();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C8824xdc9e5e1b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
