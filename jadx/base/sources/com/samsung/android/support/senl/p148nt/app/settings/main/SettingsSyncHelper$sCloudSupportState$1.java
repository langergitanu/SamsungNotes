package com.samsung.android.support.senl.p148nt.app.settings.main;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper$sCloudSupportState$1", m14021f = "SettingsSyncHelper.kt", m14022i = {}, m14023l = {893}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class SettingsSyncHelper$sCloudSupportState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref.IntRef $sCloudSupportState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsSyncHelper$sCloudSupportState$1(Context context, Ref.IntRef intRef, Continuation<? super SettingsSyncHelper$sCloudSupportState$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$sCloudSupportState = intRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsSyncHelper$sCloudSupportState$1(this.$context, this.$sCloudSupportState, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SettingsSyncHelper$sCloudSupportState$1$state$1 settingsSyncHelper$sCloudSupportState$1$state$1 = new SettingsSyncHelper$sCloudSupportState$1$state$1(this.$context, null);
            this.label = 1;
            obj = TimeoutKt.withTimeoutOrNull(5000L, settingsSyncHelper$sCloudSupportState$1$state$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Integer num = (Integer) obj;
        if (num == null) {
            return null;
        }
        this.$sCloudSupportState.element = num.intValue();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingsSyncHelper$sCloudSupportState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
