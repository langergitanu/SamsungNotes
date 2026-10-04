package com.google.android.appfunctions;

import com.google.android.appfunctions.AppFunctionDocument;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u001a7\u0010\u0007\u001a\u00020\u00012'\u0010\u0002\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0002\b\u0006H\u0086@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m13886d2 = {"appFunctionDocument", "Lcom/google/android/appfunctions/AppFunctionDocument;", "block", "Lkotlin/Function1;", "Lcom/google/android/appfunctions/AppFunctionDocument$Builder;", "", "Lkotlin/ExtensionFunctionType;", "suspendAppFunctionDocument", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 2, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAppFunctionDocument.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppFunctionDocument.kt\ncom/google/android/appfunctions/AppFunctionDocumentKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,487:1\n1#2:488\n*E\n"})
public final class AppFunctionDocumentKt {

    /* JADX INFO: renamed from: com.google.android.appfunctions.AppFunctionDocumentKt$suspendAppFunctionDocument$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.google.android.appfunctions.AppFunctionDocumentKt", m14021f = "AppFunctionDocument.kt", m14022i = {}, m14023l = {24}, m14024m = "suspendAppFunctionDocument", m14025n = {}, m14026s = {})
    public static final class C44771 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C44771(Continuation<? super C44771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppFunctionDocumentKt.suspendAppFunctionDocument(null, this);
        }
    }

    @NotNull
    public static final AppFunctionDocument appFunctionDocument(@NotNull Function1<? super AppFunctionDocument.Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        AppFunctionDocument.Builder builder = new AppFunctionDocument.Builder();
        block.invoke(builder);
        return builder.build();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object suspendAppFunctionDocument(@NotNull Function2<? super AppFunctionDocument.Builder, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super AppFunctionDocument> continuation) {
        C44771 c44771;
        AppFunctionDocument.Builder builder;
        if (continuation instanceof C44771) {
            c44771 = (C44771) continuation;
            int i = c44771.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c44771.label = i - Integer.MIN_VALUE;
            } else {
                c44771 = new C44771(continuation);
            }
        }
        Object obj = c44771.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c44771.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            AppFunctionDocument.Builder builder2 = new AppFunctionDocument.Builder();
            c44771.L$0 = builder2;
            c44771.label = 1;
            if (function2.invoke(builder2, c44771) == coroutine_suspended) {
                return coroutine_suspended;
            }
            builder = builder2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            builder = (AppFunctionDocument.Builder) c44771.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return builder.build();
    }
}
