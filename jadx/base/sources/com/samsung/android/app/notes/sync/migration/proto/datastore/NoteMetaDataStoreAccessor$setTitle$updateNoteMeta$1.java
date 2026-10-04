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
import os_migration_data_types.p233v1.NoteMeta;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, m13886d2 = {"<anonymous>", "Los_migration_data_types/v1/NoteMeta;", "noteMeta"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.app.notes.sync.migration.proto.datastore.NoteMetaDataStoreAccessor$setTitle$updateNoteMeta$1", m14021f = "NoteMetaDataStoreAccessor.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
final class NoteMetaDataStoreAccessor$setTitle$updateNoteMeta$1 extends SuspendLambda implements Function2<NoteMeta, Continuation<? super NoteMeta>, Object> {
    final /* synthetic */ String $title;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoteMetaDataStoreAccessor$setTitle$updateNoteMeta$1(String str, Continuation<? super NoteMetaDataStoreAccessor$setTitle$updateNoteMeta$1> continuation) {
        super(2, continuation);
        this.$title = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NoteMetaDataStoreAccessor$setTitle$updateNoteMeta$1 noteMetaDataStoreAccessor$setTitle$updateNoteMeta$1 = new NoteMetaDataStoreAccessor$setTitle$updateNoteMeta$1(this.$title, continuation);
        noteMetaDataStoreAccessor$setTitle$updateNoteMeta$1.L$0 = obj;
        return noteMetaDataStoreAccessor$setTitle$updateNoteMeta$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        NoteMeta noteMetaBuild = ((NoteMeta) this.L$0).toBuilder().setTitle(this.$title).build();
        Intrinsics.checkNotNullExpressionValue(noteMetaBuild, "build(...)");
        return noteMetaBuild;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(NoteMeta noteMeta, Continuation<? super NoteMeta> continuation) {
        return ((NoteMetaDataStoreAccessor$setTitle$updateNoteMeta$1) create(noteMeta, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
