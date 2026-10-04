package com.samsung.android.app.notes.sync.migration.proto.writer;

import com.samsung.android.app.notes.sync.migration.proto.datastore.C6824f;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import os_migration_data_types.p233v1.AttachmentType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.app.notes.sync.migration.proto.writer.AttachmentMetaWriter$Companion$setAttachmentType$1", m14021f = "AttachmentMetaWriter.kt", m14022i = {}, m14023l = {43}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
final class AttachmentMetaWriter$Companion$setAttachmentType$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AttachmentType $type;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttachmentMetaWriter$Companion$setAttachmentType$1(AttachmentType attachmentType, Continuation<? super AttachmentMetaWriter$Companion$setAttachmentType$1> continuation) {
        super(2, continuation);
        this.$type = attachmentType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AttachmentMetaWriter$Companion$setAttachmentType$1(this.$type, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            C6824f c6824f = AbstractC6833a.f4243a;
            if (c6824f != null) {
                AttachmentType attachmentType = this.$type;
                this.label = 1;
                if (c6824f.m4975b(attachmentType, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AttachmentMetaWriter$Companion$setAttachmentType$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
