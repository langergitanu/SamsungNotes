package androidx.glance.appwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.ExperimentalGlanceApi;
import androidx.glance.appwidget.action.LambdaActionBroadcasts;
import androidx.glance.oneui.common.GlanceLog;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.ArrayList;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0017J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0017J\u0014\u0010\u001d\u001a\u00020\r*\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u001c\u0010\u0003\u001a\u00020\u00048WX\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006 "}, m13886d2 = {"Landroidx/glance/appwidget/GlanceAppWidgetReceiver;", "Landroid/appwidget/AppWidgetProvider;", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext$annotations", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "glanceAppWidget", "Landroidx/glance/appwidget/GlanceAppWidget;", "getGlanceAppWidget", "()Landroidx/glance/appwidget/GlanceAppWidget;", "onAppWidgetOptionsChanged", "", "context", "Landroid/content/Context;", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "newOptions", "Landroid/os/Bundle;", "onDeleted", "appWidgetIds", "", "onReceive", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "onUpdate", "updateManager", "Lkotlinx/coroutines/CoroutineScope;", "Companion", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGlanceAppWidgetReceiver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceAppWidgetReceiver.kt\nandroidx/glance/appwidget/GlanceAppWidgetReceiver\n+ 2 GlanceAppWidgetReceiver.kt\nandroidx/glance/appwidget/GlanceAppWidgetReceiverKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,209:1\n201#2,2:210\n203#2,6:213\n1#3:212\n*S KotlinDebug\n*F\n+ 1 GlanceAppWidgetReceiver.kt\nandroidx/glance/appwidget/GlanceAppWidgetReceiver\n*L\n161#1:210,2\n161#1:213,6\n*E\n"})
public abstract class GlanceAppWidgetReceiver extends AppWidgetProvider {

    @NotNull
    public static final String ACTION_DEBUG_UPDATE = "androidx.glance.appwidget.action.DEBUG_UPDATE";

    @NotNull
    private static final String TAG = "GWT:AppWidgetReceiver";

    @NotNull
    private final CoroutineContext coroutineContext = Dispatchers.getDefault();
    public static final int $stable = 8;

    /* JADX INFO: renamed from: androidx.glance.appwidget.GlanceAppWidgetReceiver$onAppWidgetOptionsChanged$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidgetReceiver$onAppWidgetOptionsChanged$1", m14021f = "GlanceAppWidgetReceiver.kt", m14022i = {}, m14023l = {139}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C28591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $appWidgetId;
        final /* synthetic */ Context $context;
        final /* synthetic */ Bundle $newOptions;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28591(Context context, int i, Bundle bundle, Continuation<? super C28591> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$appWidgetId = i;
            this.$newOptions = bundle;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C28591 c28591 = GlanceAppWidgetReceiver.this.new C28591(this.$context, this.$appWidgetId, this.$newOptions, continuation);
            c28591.L$0 = obj;
            return c28591;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                GlanceAppWidgetReceiver.this.updateManager((CoroutineScope) this.L$0, this.$context);
                GlanceAppWidget glanceAppWidget = GlanceAppWidgetReceiver.this.getGlanceAppWidget();
                Context context = this.$context;
                int i2 = this.$appWidgetId;
                Bundle bundle = this.$newOptions;
                this.label = 1;
                if (glanceAppWidget.resize$glance_appwidget_release(context, i2, bundle, this) == coroutine_suspended) {
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
            return ((C28591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.GlanceAppWidgetReceiver$onDeleted$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidgetReceiver$onDeleted$1", m14021f = "GlanceAppWidgetReceiver.kt", m14022i = {0}, m14023l = {147}, m14024m = "invokeSuspend", m14025n = {"$this$forEach$iv"}, m14026s = {"L$0"})
    @SourceDebugExtension({"SMAP\nGlanceAppWidgetReceiver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceAppWidgetReceiver.kt\nandroidx/glance/appwidget/GlanceAppWidgetReceiver$onDeleted$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,209:1\n13330#2,2:210\n*S KotlinDebug\n*F\n+ 1 GlanceAppWidgetReceiver.kt\nandroidx/glance/appwidget/GlanceAppWidgetReceiver$onDeleted$1\n*L\n147#1:210,2\n*E\n"})
    public static final class C28601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int[] $appWidgetIds;
        final /* synthetic */ Context $context;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28601(Context context, int[] iArr, Continuation<? super C28601> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$appWidgetIds = iArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C28601 c28601 = GlanceAppWidgetReceiver.this.new C28601(this.$context, this.$appWidgetIds, continuation);
            c28601.L$0 = obj;
            return c28601;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x005b -> B:13:0x005e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            GlanceAppWidgetReceiver glanceAppWidgetReceiver;
            int length;
            Context context;
            int i;
            int[] iArr;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                GlanceAppWidgetReceiver.this.updateManager((CoroutineScope) this.L$0, this.$context);
                int[] iArr2 = this.$appWidgetIds;
                GlanceAppWidgetReceiver glanceAppWidgetReceiver2 = GlanceAppWidgetReceiver.this;
                Context context2 = this.$context;
                glanceAppWidgetReceiver = glanceAppWidgetReceiver2;
                length = iArr2.length;
                context = context2;
                i = 0;
                iArr = iArr2;
                if (i < length) {
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                length = this.I$1;
                i = this.I$0;
                context = (Context) this.L$2;
                glanceAppWidgetReceiver = (GlanceAppWidgetReceiver) this.L$1;
                iArr = (int[]) this.L$0;
                ResultKt.throwOnFailure(obj);
                i++;
                if (i < length) {
                    int i4 = iArr[i];
                    GlanceAppWidget glanceAppWidget = glanceAppWidgetReceiver.getGlanceAppWidget();
                    this.L$0 = iArr;
                    this.L$1 = glanceAppWidgetReceiver;
                    this.L$2 = context;
                    this.I$0 = i;
                    this.I$1 = length;
                    this.label = 1;
                    if (glanceAppWidget.deleted$glance_appwidget_release(context, i4, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i++;
                    if (i < length) {
                        return Unit.INSTANCE;
                    }
                }
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C28601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.GlanceAppWidgetReceiver$onUpdate$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidgetReceiver$onUpdate$1", m14021f = "GlanceAppWidgetReceiver.kt", m14022i = {}, m14023l = {126}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    @SourceDebugExtension({"SMAP\nGlanceAppWidgetReceiver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceAppWidgetReceiver.kt\nandroidx/glance/appwidget/GlanceAppWidgetReceiver$onUpdate$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,209:1\n11095#2:210\n11430#2,3:211\n*S KotlinDebug\n*F\n+ 1 GlanceAppWidgetReceiver.kt\nandroidx/glance/appwidget/GlanceAppWidgetReceiver$onUpdate$1\n*L\n108#1:210\n108#1:211,3\n*E\n"})
    public static final class C28611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int[] $appWidgetIds;
        final /* synthetic */ Context $context;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28611(Context context, int[] iArr, Continuation<? super C28611> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$appWidgetIds = iArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C28611 c28611 = GlanceAppWidgetReceiver.this.new C28611(this.$context, this.$appWidgetIds, continuation);
            c28611.L$0 = obj;
            return c28611;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                GlanceAppWidgetReceiver.this.updateManager(coroutineScope, this.$context);
                int[] iArr = this.$appWidgetIds;
                GlanceAppWidgetReceiver glanceAppWidgetReceiver = GlanceAppWidgetReceiver.this;
                Context context = this.$context;
                ArrayList arrayList = new ArrayList(iArr.length);
                int length = iArr.length;
                int i2 = 0;
                while (i2 < length) {
                    arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new GlanceAppWidgetReceiver$onUpdate$1$1$1(glanceAppWidgetReceiver, context, iArr[i2], iArr, null), 3, null));
                    i2++;
                    iArr = iArr;
                    glanceAppWidgetReceiver = glanceAppWidgetReceiver;
                    context = context;
                }
                this.label = 1;
                if (AwaitKt.awaitAll(arrayList, this) == coroutine_suspended) {
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
            return ((C28611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.GlanceAppWidgetReceiver$updateManager$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidgetReceiver$updateManager$1", m14021f = "GlanceAppWidgetReceiver.kt", m14022i = {}, m14023l = {155}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    @SourceDebugExtension({"SMAP\nGlanceAppWidgetReceiver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceAppWidgetReceiver.kt\nandroidx/glance/appwidget/GlanceAppWidgetReceiver$updateManager$1\n+ 2 GlanceAppWidgetReceiver.kt\nandroidx/glance/appwidget/GlanceAppWidgetReceiverKt\n*L\n1#1,209:1\n201#2,8:210\n*S KotlinDebug\n*F\n+ 1 GlanceAppWidgetReceiver.kt\nandroidx/glance/appwidget/GlanceAppWidgetReceiver$updateManager$1\n*L\n153#1:210,8\n*E\n"})
    public static final class C28621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ GlanceAppWidgetReceiver this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28621(Context context, GlanceAppWidgetReceiver glanceAppWidgetReceiver, Continuation<? super C28621> continuation) {
            super(2, continuation);
            this.$context = context;
            this.this$0 = glanceAppWidgetReceiver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C28621(this.$context, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Context context = this.$context;
                    GlanceAppWidgetReceiver glanceAppWidgetReceiver = this.this$0;
                    GlanceAppWidgetManager glanceAppWidgetManager = new GlanceAppWidgetManager(context);
                    GlanceAppWidget glanceAppWidget = glanceAppWidgetReceiver.getGlanceAppWidget();
                    this.label = 1;
                    if (glanceAppWidgetManager.updateReceiver$glance_appwidget_release(glanceAppWidgetReceiver, glanceAppWidget, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (CancellationException unused) {
            } catch (Throwable th) {
                AppWidgetUtilsKt.logException(th);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C28621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateManager(CoroutineScope coroutineScope, Context context) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C28621(context, this, null), 3, null);
    }

    @ExperimentalGlanceApi
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @NotNull
    public abstract GlanceAppWidget getGlanceAppWidget();

    @Override // android.appwidget.AppWidgetProvider
    @CallSuper
    public void onAppWidgetOptionsChanged(@NotNull Context context, @NotNull AppWidgetManager appWidgetManager, int appWidgetId, @NotNull Bundle newOptions) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(newOptions, "newOptions");
        CoroutineBroadcastReceiverKt.goAsync(this, getCoroutineContext(), new C28591(context, appWidgetId, newOptions, null));
    }

    @Override // android.appwidget.AppWidgetProvider
    @CallSuper
    public void onDeleted(@NotNull Context context, @NotNull int[] appWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetIds, "appWidgetIds");
        CoroutineBroadcastReceiverKt.goAsync(this, getCoroutineContext(), new C28601(context, appWidgetIds, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c3 A[Catch: all -> 0x007f, CancellationException -> 0x00f3, TryCatch #3 {CancellationException -> 0x00f3, all -> 0x007f, blocks: (B:21:0x0078, B:28:0x0089, B:29:0x0091, B:30:0x0092, B:31:0x009a, B:32:0x009b, B:48:0x00ec, B:38:0x00b1, B:40:0x00c3, B:42:0x00ce, B:44:0x00da, B:43:0x00d6, B:46:0x00e4, B:47:0x00eb, B:35:0x00a6), top: B:55:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e4 A[Catch: all -> 0x007f, CancellationException -> 0x00f3, TryCatch #3 {CancellationException -> 0x00f3, all -> 0x007f, blocks: (B:21:0x0078, B:28:0x0089, B:29:0x0091, B:30:0x0092, B:31:0x009a, B:32:0x009b, B:48:0x00ec, B:38:0x00b1, B:40:0x00c3, B:42:0x00ce, B:44:0x00da, B:43:0x00d6, B:46:0x00e4, B:47:0x00eb, B:35:0x00a6), top: B:55:0x0039 }] */
    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        String action;
        Context context2;
        String canonicalName;
        int[] appWidgetIds;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            GlanceLog.INSTANCE.m2301i(TAG, "[appwidget-2.0.12] onReceive: action=" + intent.getAction() + " this=" + getClass().getName());
            action = intent.getAction();
        } catch (CancellationException unused) {
            return;
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (action == null) {
                context2 = context;
            } else {
                int iHashCode = action.hashCode();
                if (iHashCode == -19011148) {
                    context2 = context;
                    if (!action.equals("android.intent.action.LOCALE_CHANGED")) {
                    }
                    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context2);
                    String packageName = context2.getPackageName();
                    canonicalName = getClass().getCanonicalName();
                    if (canonicalName != null) {
                    }
                } else {
                    if (iHashCode == 649033583) {
                        context2 = context;
                        if (!action.equals(ACTION_DEBUG_UPDATE)) {
                        }
                        AppWidgetManager appWidgetManager2 = AppWidgetManager.getInstance(context2);
                        String packageName2 = context2.getPackageName();
                        canonicalName = getClass().getCanonicalName();
                        if (canonicalName != null) {
                            throw new IllegalStateException("no canonical name");
                        }
                        ComponentName componentName = new ComponentName(packageName2, canonicalName);
                        if (intent.hasExtra("appWidgetIds")) {
                            appWidgetIds = intent.getIntArrayExtra("appWidgetIds");
                            Intrinsics.checkNotNull(appWidgetIds);
                        } else {
                            appWidgetIds = appWidgetManager2.getAppWidgetIds(componentName);
                        }
                        Intrinsics.checkNotNull(appWidgetManager2);
                        Intrinsics.checkNotNull(appWidgetIds);
                        onUpdate(context2, appWidgetManager2, appWidgetIds);
                        return;
                    }
                    if (iHashCode == 1989767543 && action.equals(LambdaActionBroadcasts.ActionTriggerLambda)) {
                        String stringExtra = intent.getStringExtra(LambdaActionBroadcasts.ExtraActionKey);
                        if (stringExtra == null) {
                            throw new IllegalStateException("Intent is missing ActionKey extra");
                        }
                        Intrinsics.checkNotNull(stringExtra);
                        int intExtra = intent.getIntExtra(LambdaActionBroadcasts.ExtraAppWidgetId, -1);
                        if (intExtra == -1) {
                            throw new IllegalStateException("Intent is missing AppWidgetId extra");
                        }
                        CoroutineBroadcastReceiverKt.goAsync(this, getCoroutineContext(), new GlanceAppWidgetReceiver$onReceive$1$1(this, context, intExtra, stringExtra, null));
                        return;
                    }
                    context2 = context;
                }
            }
            super.onReceive(context2, intent);
        } catch (CancellationException unused2) {
        } catch (Throwable th2) {
            th = th2;
            AppWidgetUtilsKt.logException(th);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    @CallSuper
    public void onUpdate(@NotNull Context context, @NotNull AppWidgetManager appWidgetManager, @NotNull int[] appWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(appWidgetIds, "appWidgetIds");
        CoroutineBroadcastReceiverKt.goAsync(this, getCoroutineContext(), new C28611(context, appWidgetIds, null));
    }

    @ExperimentalGlanceApi
    public static /* synthetic */ void getCoroutineContext$annotations() {
    }
}
