package com.samsung.android.app.notes.sync.migration.proto.datastore;

import com.samsung.android.support.senl.p148nt.base.common.util.Base16Utils;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import os_migration_data_types.p233v1.NoteMeta;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.app.notes.sync.migration.proto.datastore.NoteMetaDataStoreAccessor", m14021f = "NoteMetaDataStoreAccessor.kt", m14022i = {0}, m14023l = {114}, m14024m = "getBase16String", m14025n = {"bos"}, m14026s = {"L$0"})
final class NoteMetaDataStoreAccessor$getBase16String$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ C6832n this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoteMetaDataStoreAccessor$getBase16String$1(C6832n c6832n, Continuation<? super NoteMetaDataStoreAccessor$getBase16String$1> continuation) {
        super(continuation);
        this.this$0 = c6832n;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        NoteMetaDataStoreAccessor$getBase16String$1 noteMetaDataStoreAccessor$getBase16String$1;
        ByteArrayOutputStream byteArrayOutputStream;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        C6832n c6832n = this.this$0;
        c6832n.getClass();
        int i = this.label;
        if ((i & Integer.MIN_VALUE) != 0) {
            this.label = i - Integer.MIN_VALUE;
            noteMetaDataStoreAccessor$getBase16String$1 = this;
        } else {
            noteMetaDataStoreAccessor$getBase16String$1 = new NoteMetaDataStoreAccessor$getBase16String$1(c6832n, this);
        }
        Object obj2 = noteMetaDataStoreAccessor$getBase16String$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = noteMetaDataStoreAccessor$getBase16String$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            Flow data = c6832n.f4242a.getData();
            noteMetaDataStoreAccessor$getBase16String$1.L$0 = byteArrayOutputStream2;
            noteMetaDataStoreAccessor$getBase16String$1.label = 1;
            Object objFirst = FlowKt.first(data, noteMetaDataStoreAccessor$getBase16String$1);
            if (objFirst == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj2 = objFirst;
            byteArrayOutputStream = byteArrayOutputStream2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteArrayOutputStream = (ByteArrayOutputStream) noteMetaDataStoreAccessor$getBase16String$1.L$0;
            ResultKt.throwOnFailure(obj2);
        }
        ((NoteMeta) obj2).writeTo(byteArrayOutputStream);
        return Base16Utils.encode(byteArrayOutputStream.toByteArray());
    }
}
