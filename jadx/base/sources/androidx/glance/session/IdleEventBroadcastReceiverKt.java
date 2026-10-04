package androidx.glance.session;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aX\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00052\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0080@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"observeIdleEvents", "T", "context", "Landroid/content/Context;", "onIdle", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "block", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class IdleEventBroadcastReceiverKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.glance.session.IdleEventBroadcastReceiverKt$observeIdleEvents$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.session.IdleEventBroadcastReceiverKt$observeIdleEvents$2", m14021f = "IdleEventBroadcastReceiver.kt", m14022i = {0}, m14023l = {88}, m14024m = "invokeSuspend", m14025n = {"idleReceiver"}, m14026s = {"L$0"})
    public static final class C35022<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
        final /* synthetic */ Context $context;
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $onIdle;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C35022(Context context, Function1<? super Continuation<? super T>, ? extends Object> function1, Function1<? super Continuation<? super Unit>, ? extends Object> function12, Continuation<? super C35022> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$block = function1;
            this.$onIdle = function12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C35022 c35022 = new C35022(this.$context, this.$block, this.$onIdle, continuation);
            c35022.L$0 = obj;
            return c35022;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            IdleEventBroadcastReceiver idleEventBroadcastReceiver;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                idleEventBroadcastReceiver = (IdleEventBroadcastReceiver) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    this.$context.unregisterReceiver(idleEventBroadcastReceiver);
                    return obj;
                } catch (Throwable th) {
                    th = th;
                    this.$context.unregisterReceiver(idleEventBroadcastReceiver);
                    throw th;
                }
            }
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            final Function1<Continuation<? super Unit>, Object> function1 = this.$onIdle;
            IdleEventBroadcastReceiver idleEventBroadcastReceiver2 = new IdleEventBroadcastReceiver(new Function0<Unit>() { // from class: androidx.glance.session.IdleEventBroadcastReceiverKt$observeIdleEvents$2$idleReceiver$1

                /* JADX INFO: renamed from: androidx.glance.session.IdleEventBroadcastReceiverKt$observeIdleEvents$2$idleReceiver$1$1 */
                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
                @DebugMetadata(m14020c = "androidx.glance.session.IdleEventBroadcastReceiverKt$observeIdleEvents$2$idleReceiver$1$1", m14021f = "IdleEventBroadcastReceiver.kt", m14022i = {}, m14023l = {84}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                public static final class C35031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $onIdle;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public C35031(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super C35031> continuation) {
                        super(2, continuation);
                        this.$onIdle = function1;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return new C35031(this.$onIdle, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function1<Continuation<? super Unit>, Object> function1 = this.$onIdle;
                            this.label = 1;
                            if (function1.invoke(this) == coroutine_suspended) {
                                return coroutine_suspended;
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
                    @Nullable
                    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                        return ((C35031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C35031(function1, null), 3, null);
                }
            });
            this.$context.registerReceiver(idleEventBroadcastReceiver2, IdleEventBroadcastReceiver.INSTANCE.getFilter());
            try {
                idleEventBroadcastReceiver2.checkIdleStatus$glance_release(this.$context);
                Function1<Continuation<? super T>, Object> function12 = this.$block;
                this.L$0 = idleEventBroadcastReceiver2;
                this.label = 1;
                obj = function12.invoke(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                idleEventBroadcastReceiver = idleEventBroadcastReceiver2;
                this.$context.unregisterReceiver(idleEventBroadcastReceiver);
                return obj;
            } catch (Throwable th2) {
                th = th2;
                idleEventBroadcastReceiver = idleEventBroadcastReceiver2;
                this.$context.unregisterReceiver(idleEventBroadcastReceiver);
                throw th;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super T> continuation) {
            return ((C35022) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Nullable
    public static final <T> Object observeIdleEvents(@NotNull Context context, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> function1, @NotNull Function1<? super Continuation<? super T>, ? extends Object> function12, @NotNull Continuation<? super T> continuation) {
        return CoroutineScopeKt.coroutineScope(new C35022(context, function12, function1, null), continuation);
    }
}
