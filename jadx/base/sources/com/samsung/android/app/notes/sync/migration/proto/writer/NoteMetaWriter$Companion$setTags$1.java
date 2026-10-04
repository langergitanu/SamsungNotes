package com.samsung.android.app.notes.sync.migration.proto.writer;

import com.samsung.android.app.notes.sync.migration.proto.datastore.C6832n;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.app.notes.sync.migration.proto.writer.NoteMetaWriter$Companion$setTags$1", m14021f = "NoteMetaWriter.kt", m14022i = {}, m14023l = {42}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
final class NoteMetaWriter$Companion$setTags$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $tags;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoteMetaWriter$Companion$setTags$1(List<String> list, Continuation<? super NoteMetaWriter$Companion$setTags$1> continuation) {
        super(2, continuation);
        this.$tags = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NoteMetaWriter$Companion$setTags$1(this.$tags, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            C6832n c6832n = AbstractC6833a.f4244b;
            if (c6832n != null) {
                List<String> list = this.$tags;
                this.label = 1;
                if (c6832n.m4984f(list, this) == coroutine_suspended) {
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
        return ((NoteMetaWriter$Companion$setTags$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
