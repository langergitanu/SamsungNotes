package com.samsung.android.app.notes.sync.migration.proto.datastore;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.app.notes.sync.migration.proto.datastore.NoteMetaDataStoreAccessor", m14021f = "NoteMetaDataStoreAccessor.kt", m14022i = {}, m14023l = {42}, m14024m = "setCreationDataMillisSinceEpoch", m14025n = {}, m14026s = {})
final class NoteMetaDataStoreAccessor$setCreationDataMillisSinceEpoch$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ C6832n this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoteMetaDataStoreAccessor$setCreationDataMillisSinceEpoch$1(C6832n c6832n, Continuation<? super NoteMetaDataStoreAccessor$setCreationDataMillisSinceEpoch$1> continuation) {
        super(continuation);
        this.this$0 = c6832n;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m4979a(0L, this);
    }
}
