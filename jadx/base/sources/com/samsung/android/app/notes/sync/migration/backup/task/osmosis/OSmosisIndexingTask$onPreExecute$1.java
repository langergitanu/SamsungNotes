package com.samsung.android.app.notes.sync.migration.backup.task.osmosis;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import p042J1.AbstractC0147e;
import p042J1.C0148f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.app.notes.sync.migration.backup.task.osmosis.OSmosisIndexingTask$onPreExecute$1", m14021f = "OSmosisIndexingTask.kt", m14022i = {0}, m14023l = {274}, m14024m = "invokeSuspend", m14025n = {"$this$launch"}, m14026s = {"L$0"})
final class OSmosisIndexingTask$onPreExecute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ C6793d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OSmosisIndexingTask$onPreExecute$1(C6793d c6793d, Continuation<? super OSmosisIndexingTask$onPreExecute$1> continuation) {
        super(2, continuation);
        this.this$0 = c6793d;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OSmosisIndexingTask$onPreExecute$1 oSmosisIndexingTask$onPreExecute$1 = new OSmosisIndexingTask$onPreExecute$1(this.this$0, continuation);
        oSmosisIndexingTask$onPreExecute$1.L$0 = obj;
        return oSmosisIndexingTask$onPreExecute$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[LOOP:0: B:9:0x0023->B:35:?, LOOP_END, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        int i;
        int i2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        while (CoroutineScopeKt.isActive(coroutineScope)) {
            String str = C0148f.f420k;
            C0148f c0148f = AbstractC0147e.f419a;
            C6793d c6793d = this.this$0;
            int i5 = AbstractC6792c.f4203a[c6793d.f4209k.ordinal()];
            if (i5 == 1) {
                int i6 = c6793d.f4207i;
                i = i6 < 89 ? i6 + 1 : 89;
                c6793d.f4207i = i;
            } else if (i5 != 2) {
                i2 = c6793d.f4207i;
                c0148f.getClass();
                C0148f.m356l(i2);
                this.L$0 = coroutineScope;
                this.label = 1;
                if (DelayKt.delay(60000L, this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                int i7 = c6793d.f4207i;
                i = i7 < 99 ? i7 + 1 : 99;
                c6793d.f4207i = i;
            }
            i2 = i;
            c0148f.getClass();
            C0148f.m356l(i2);
            this.L$0 = coroutineScope;
            this.label = 1;
            if (DelayKt.delay(60000L, this) != coroutine_suspended) {
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OSmosisIndexingTask$onPreExecute$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
