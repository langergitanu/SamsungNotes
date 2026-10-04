package androidx.glance.oneui.template;

import android.content.BroadcastReceiver;
import androidx.glance.oneui.common.GlanceLog;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aD\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\fH\u0000¢\u0006\u0002\u0010\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "goAsync", "", "Landroid/content/BroadcastReceiver;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroid/content/BroadcastReceiver;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class GlanceTemplateAppWidgetReceiverKt {

    @NotNull
    private static final String TAG = "GWT:Receiver";

    /* JADX INFO: renamed from: androidx.glance.oneui.template.GlanceTemplateAppWidgetReceiverKt$goAsync$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.oneui.template.GlanceTemplateAppWidgetReceiverKt$goAsync$1", m14021f = "GlanceTemplateAppWidgetReceiver.kt", m14022i = {}, m14023l = {41}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C30881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ CoroutineScope $coroutineScope;
        final /* synthetic */ BroadcastReceiver.PendingResult $pendingResult;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C30881(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, CoroutineScope coroutineScope, BroadcastReceiver.PendingResult pendingResult, Continuation<? super C30881> continuation) {
            super(2, continuation);
            this.$block = function2;
            this.$coroutineScope = coroutineScope;
            this.$pendingResult = pendingResult;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C30881 c30881 = new C30881(this.$block, this.$coroutineScope, this.$pendingResult, continuation);
            c30881.L$0 = obj;
            return c30881;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    try {
                        try {
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                                Function2<CoroutineScope, Continuation<? super Unit>, Object> function2 = this.$block;
                                this.label = 1;
                                if (function2.invoke(coroutineScope, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                        } catch (Throwable th) {
                            CoroutineScopeKt.cancel$default(this.$coroutineScope, null, 1, null);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        GlanceLog.INSTANCE.m2300e(GlanceTemplateAppWidgetReceiverKt.TAG, "BroadcastReceiver execution failed", th2);
                    }
                    CoroutineScopeKt.cancel$default(this.$coroutineScope, null, 1, null);
                    return Unit.INSTANCE;
                } finally {
                    try {
                        this.$pendingResult.finish();
                    } catch (IllegalStateException e) {
                        GlanceLog.INSTANCE.m2300e(GlanceTemplateAppWidgetReceiverKt.TAG, "Error thrown when trying to finish broadcast", e);
                    }
                }
            } catch (CancellationException e2) {
                throw e2;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C30881) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public static final void goAsync(@NotNull BroadcastReceiver broadcastReceiver, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(broadcastReceiver, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(block, "block");
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(coroutineContext));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new C30881(block, CoroutineScope, broadcastReceiver.goAsync(), null), 3, null);
    }

    public static /* synthetic */ void goAsync$default(BroadcastReceiver broadcastReceiver, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getDefault();
        }
        goAsync(broadcastReceiver, coroutineContext, function2);
    }
}
