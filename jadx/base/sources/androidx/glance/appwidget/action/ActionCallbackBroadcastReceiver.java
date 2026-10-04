package androidx.glance.appwidget.action;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.os.BundleKt;
import androidx.glance.action.ActionParameters;
import androidx.glance.action.ActionParametersKt;
import androidx.glance.action.MutableActionParameters;
import androidx.glance.appwidget.AppWidgetId;
import androidx.glance.appwidget.AppWidgetUtilsKt;
import androidx.glance.appwidget.CoroutineBroadcastReceiverKt;
import androidx.glance.appwidget.action.RunCallbackAction;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, m13886d2 = {"Landroidx/glance/appwidget/action/ActionCallbackBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "Companion", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ActionCallbackBroadcastReceiver extends BroadcastReceiver {
    public static final int $stable = 0;

    @NotNull
    private static final String AppWidgetId = "ActionCallbackBroadcastReceiver:appWidgetId";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String ExtraCallbackClassName = "ActionCallbackBroadcastReceiver:callbackClass";

    @NotNull
    private static final String ExtraParameters = "ActionCallbackBroadcastReceiver:parameters";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\u0014\u0010\u0013\u001a\u00020\b*\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Landroidx/glance/appwidget/action/ActionCallbackBroadcastReceiver$Companion;", "", "()V", "AppWidgetId", "", "ExtraCallbackClassName", "ExtraParameters", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "callbackClass", "Ljava/lang/Class;", "Landroidx/glance/appwidget/action/ActionCallback;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "parameters", "Landroidx/glance/action/ActionParameters;", "createIntent$glance_appwidget_release", "putParameterExtras", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nActionCallbackBroadcastReceiver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionCallbackBroadcastReceiver.kt\nandroidx/glance/appwidget/action/ActionCallbackBroadcastReceiver$Companion\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,99:1\n125#2:100\n152#2,3:101\n37#3,2:104\n*S KotlinDebug\n*F\n+ 1 ActionCallbackBroadcastReceiver.kt\nandroidx/glance/appwidget/action/ActionCallbackBroadcastReceiver$Companion\n*L\n91#1:100\n91#1:101,3\n93#1:104,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Intent putParameterExtras(Intent intent, ActionParameters actionParameters) {
            Map<ActionParameters.Key<? extends Object>, Object> mapAsMap = actionParameters.asMap();
            ArrayList arrayList = new ArrayList(mapAsMap.size());
            for (Map.Entry<ActionParameters.Key<? extends Object>, Object> entry : mapAsMap.entrySet()) {
                ActionParameters.Key<? extends Object> key = entry.getKey();
                arrayList.add(TuplesKt.m13893to(key.getName(), entry.getValue()));
            }
            Pair[] pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
            intent.putExtra(ActionCallbackBroadcastReceiver.ExtraParameters, BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length)));
            return intent;
        }

        @NotNull
        public final Intent createIntent$glance_appwidget_release(@NotNull Context context, @NotNull Class<? extends ActionCallback> callbackClass, int appWidgetId, @NotNull ActionParameters parameters) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callbackClass, "callbackClass");
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            Intent intentPutExtra = new Intent(context, (Class<?>) ActionCallbackBroadcastReceiver.class).setPackage(context.getPackageName()).putExtra(ActionCallbackBroadcastReceiver.ExtraCallbackClassName, callbackClass.getCanonicalName()).putExtra(ActionCallbackBroadcastReceiver.AppWidgetId, appWidgetId);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
            return putParameterExtras(intentPutExtra, parameters);
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.action.ActionCallbackBroadcastReceiver$onReceive$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.action.ActionCallbackBroadcastReceiver$onReceive$1", m14021f = "ActionCallbackBroadcastReceiver.kt", m14022i = {}, m14023l = {64}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    @SourceDebugExtension({"SMAP\nActionCallbackBroadcastReceiver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionCallbackBroadcastReceiver.kt\nandroidx/glance/appwidget/action/ActionCallbackBroadcastReceiver$onReceive$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,99:1\n1855#2,2:100\n*S KotlinDebug\n*F\n+ 1 ActionCallbackBroadcastReceiver.kt\nandroidx/glance/appwidget/action/ActionCallbackBroadcastReceiver$onReceive$1\n*L\n47#1:100,2\n*E\n"})
    public static final class C29201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Intent $intent;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29201(Intent intent, Context context, Continuation<? super C29201> continuation) {
            super(2, continuation);
            this.$intent = intent;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C29201(this.$intent, this.$context, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Bundle extras = this.$intent.getExtras();
                    if (extras == null) {
                        throw new IllegalArgumentException("The intent must have action parameters extras.");
                    }
                    Intrinsics.checkNotNullExpressionValue(extras, "requireNotNull(...)");
                    Bundle bundle = extras.getBundle(ActionCallbackBroadcastReceiver.ExtraParameters);
                    if (bundle == null) {
                        throw new IllegalArgumentException("The intent must contain a parameters bundle using extra: ActionCallbackBroadcastReceiver:parameters");
                    }
                    Intrinsics.checkNotNullExpressionValue(bundle, "requireNotNull(...)");
                    MutableActionParameters mutableActionParametersMutableActionParametersOf = ActionParametersKt.mutableActionParametersOf(new ActionParameters.Pair[0]);
                    Set<String> setKeySet = bundle.keySet();
                    Intrinsics.checkNotNullExpressionValue(setKeySet, "keySet(...)");
                    for (String str : setKeySet) {
                        Intrinsics.checkNotNull(str);
                        mutableActionParametersMutableActionParametersOf.set(new ActionParameters.Key(str), bundle.get(str));
                    }
                    if (extras.containsKey("android.widget.extra.CHECKED")) {
                        mutableActionParametersMutableActionParametersOf.set(ToggleableKt.getToggleableStateKey(), Boxing.boxBoolean(extras.getBoolean("android.widget.extra.CHECKED")));
                    }
                    String string = extras.getString(ActionCallbackBroadcastReceiver.ExtraCallbackClassName);
                    if (string == null) {
                        throw new IllegalArgumentException("The intent must contain a work class name string using extra: ActionCallbackBroadcastReceiver:callbackClass");
                    }
                    Intrinsics.checkNotNullExpressionValue(string, "requireNotNull(...)");
                    if (!this.$intent.hasExtra(ActionCallbackBroadcastReceiver.AppWidgetId)) {
                        throw new IllegalArgumentException("To update the widget, the intent must contain the AppWidgetId integer using extra: ActionCallbackBroadcastReceiver:appWidgetId");
                    }
                    AppWidgetId appWidgetId = new AppWidgetId(extras.getInt(ActionCallbackBroadcastReceiver.AppWidgetId));
                    RunCallbackAction.Companion companion = RunCallbackAction.INSTANCE;
                    Context context = this.$context;
                    this.label = 1;
                    if (companion.run(context, string, appWidgetId, mutableActionParametersMutableActionParametersOf, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (CancellationException e) {
                throw e;
            } catch (Throwable th) {
                AppWidgetUtilsKt.logException(th);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C29201) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        CoroutineBroadcastReceiverKt.goAsync$default(this, null, new C29201(intent, context, null), 1, null);
    }
}
