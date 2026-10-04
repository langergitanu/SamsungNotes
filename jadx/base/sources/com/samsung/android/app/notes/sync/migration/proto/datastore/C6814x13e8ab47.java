package com.samsung.android.app.notes.sync.migration.proto.datastore;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import os_migration_data_types.p233v1.AttachmentMeta;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.proto.datastore.AttachmentMetaDataStoreAccessor$setFileName$updateAttachmentMeta$1 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, m13886d2 = {"<anonymous>", "Los_migration_data_types/v1/AttachmentMeta;", "attachmentMeta"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.app.notes.sync.migration.proto.datastore.AttachmentMetaDataStoreAccessor$setFileName$updateAttachmentMeta$1", m14021f = "AttachmentMetaDataStoreAccessor.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
final class C6814x13e8ab47 extends SuspendLambda implements Function2<AttachmentMeta, Continuation<? super AttachmentMeta>, Object> {
    final /* synthetic */ String $fileName;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6814x13e8ab47(String str, Continuation<? super C6814x13e8ab47> continuation) {
        super(2, continuation);
        this.$fileName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C6814x13e8ab47 c6814x13e8ab47 = new C6814x13e8ab47(this.$fileName, continuation);
        c6814x13e8ab47.L$0 = obj;
        return c6814x13e8ab47;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        AttachmentMeta attachmentMetaBuild = ((AttachmentMeta) this.L$0).toBuilder().setFileName(this.$fileName).build();
        Intrinsics.checkNotNullExpressionValue(attachmentMetaBuild, "build(...)");
        return attachmentMetaBuild;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AttachmentMeta attachmentMeta, Continuation<? super AttachmentMeta> continuation) {
        return ((C6814x13e8ab47) create(attachmentMeta, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
