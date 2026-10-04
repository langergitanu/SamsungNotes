package androidx.glance.appwidget.action;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.annotation.IdRes;
import androidx.core.os.BundleKt;
import androidx.glance.action.Action;
import androidx.glance.action.ActionParameters;
import androidx.glance.action.ActionParametersKt;
import androidx.glance.action.LambdaAction;
import androidx.glance.action.MutableActionParameters;
import androidx.glance.action.StartActivityAction;
import androidx.glance.action.StartActivityClassAction;
import androidx.glance.action.StartActivityComponentAction;
import androidx.glance.appwidget.TranslationContext;
import androidx.glance.oneui.common.GlanceLog;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0000\u001a\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a8\u0010\u000f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0002\u001aB\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u000bH\u0002\u001a\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\u0018\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0012H\u0002\u001a\u0018\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011*\u00020\u001cH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "applyAction", "", "translationContext", "Landroidx/glance/appwidget/TranslationContext;", "rv", "Landroid/widget/RemoteViews;", "action", "Landroidx/glance/action/Action;", "viewId", "", "getBroadcastReceiverIntent", "Landroid/content/Intent;", "Landroidx/glance/appwidget/action/SendBroadcastAction;", "getFillInIntentForAction", "editParams", "Lkotlin/Function1;", "Landroidx/glance/action/ActionParameters;", "getPendingIntentForAction", "Landroid/app/PendingIntent;", "mutability", "getServiceIntent", "Landroidx/glance/appwidget/action/StartServiceAction;", "getStartActivityIntent", "Landroidx/glance/action/StartActivityAction;", ActionHandler.PARAMS, "getActionParameters", "Landroidx/glance/appwidget/action/CompoundButtonAction;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nApplyAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ApplyAction.kt\nandroidx/glance/appwidget/action/ApplyActionKt\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,388:1\n125#2:389\n152#2,3:390\n37#3,2:393\n*S KotlinDebug\n*F\n+ 1 ApplyAction.kt\nandroidx/glance/appwidget/action/ApplyActionKt\n*L\n335#1:389\n335#1:390,3\n337#1:393,2\n*E\n"})
public final class ApplyActionKt {

    @NotNull
    private static final String TAG = "GWT:ApplyAction";

    public static final void applyAction(@NotNull TranslationContext translationContext, @NotNull RemoteViews rv, @NotNull Action action, @IdRes int i) {
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(action, "action");
        Integer actionTargetId = translationContext.getActionTargetId();
        if (actionTargetId != null) {
            i = actionTargetId.intValue();
        }
        int i2 = i;
        try {
            try {
                if (translationContext.isLazyCollectionDescendant()) {
                    Intent fillInIntentForAction$default = getFillInIntentForAction$default(action, translationContext, i2, null, 8, null);
                    if (!(action instanceof CompoundButtonAction) || Build.VERSION.SDK_INT < 31) {
                        rv.setOnClickFillInIntent(i2, fillInIntentForAction$default);
                        return;
                    } else {
                        ApplyActionApi31Impl.INSTANCE.setOnCheckedChangeResponse(rv, i2, fillInIntentForAction$default);
                        return;
                    }
                }
                PendingIntent pendingIntentForAction$default = getPendingIntentForAction$default(action, translationContext, i2, null, 0, 24, null);
                if (!(action instanceof CompoundButtonAction) || Build.VERSION.SDK_INT < 31) {
                    rv.setOnClickPendingIntent(i2, pendingIntentForAction$default);
                } else {
                    ApplyActionApi31Impl.INSTANCE.setOnCheckedChangeResponse(rv, i2, pendingIntentForAction$default);
                }
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                GlanceLog.INSTANCE.m2300e(TAG, "Unrecognized Action: " + action, th2);
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static final Function1<ActionParameters, ActionParameters> getActionParameters(final CompoundButtonAction compoundButtonAction) {
        return new Function1<ActionParameters, ActionParameters>() { // from class: androidx.glance.appwidget.action.ApplyActionKt.getActionParameters.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final ActionParameters invoke(@NotNull ActionParameters params) {
                Intrinsics.checkNotNullParameter(params, "params");
                if (Build.VERSION.SDK_INT >= 31) {
                    return params;
                }
                MutableActionParameters mutableParameters = ActionParametersKt.toMutableParameters(params);
                mutableParameters.set(ToggleableKt.getToggleableStateKey(), Boolean.valueOf(!compoundButtonAction.getChecked()));
                return mutableParameters;
            }
        };
    }

    private static final Intent getBroadcastReceiverIntent(SendBroadcastAction sendBroadcastAction, TranslationContext translationContext) {
        if (sendBroadcastAction instanceof SendBroadcastComponentAction) {
            Intent component = new Intent().setComponent(((SendBroadcastComponentAction) sendBroadcastAction).getComponentName());
            Intrinsics.checkNotNullExpressionValue(component, "setComponent(...)");
            return component;
        }
        if (sendBroadcastAction instanceof SendBroadcastClassAction) {
            return new Intent(translationContext.getContext(), ((SendBroadcastClassAction) sendBroadcastAction).getReceiverClass());
        }
        if (sendBroadcastAction instanceof SendBroadcastIntentAction) {
            return ((SendBroadcastIntentAction) sendBroadcastAction).getIntent();
        }
        if (!(sendBroadcastAction instanceof SendBroadcastActionAction)) {
            throw new NoWhenBranchMatchedException();
        }
        SendBroadcastActionAction sendBroadcastActionAction = (SendBroadcastActionAction) sendBroadcastAction;
        Intent component2 = new Intent(sendBroadcastActionAction.getAction()).setComponent(sendBroadcastActionAction.getComponentName());
        Intrinsics.checkNotNullExpressionValue(component2, "setComponent(...)");
        return component2;
    }

    private static final Intent getFillInIntentForAction(Action action, TranslationContext translationContext, @IdRes int i, Function1<? super ActionParameters, ? extends ActionParameters> function1) {
        if (action instanceof StartActivityAction) {
            StartActivityAction startActivityAction = (StartActivityAction) action;
            Intent startActivityIntent = getStartActivityIntent(startActivityAction, translationContext, function1.invoke(startActivityAction.getParameters()));
            if (startActivityIntent.getData() == null) {
                startActivityIntent.setData(ActionTrampolineKt.createUniqueUri$default(translationContext, i, ActionTrampolineType.CALLBACK, null, 8, null));
            }
            return startActivityIntent;
        }
        if (action instanceof StartServiceAction) {
            StartServiceAction startServiceAction = (StartServiceAction) action;
            return ActionTrampolineKt.applyTrampolineIntent$default(getServiceIntent(startServiceAction, translationContext), translationContext, i, startServiceAction.getIsForegroundService() ? ActionTrampolineType.FOREGROUND_SERVICE : ActionTrampolineType.SERVICE, null, 8, null);
        }
        if (action instanceof SendBroadcastAction) {
            return ActionTrampolineKt.applyTrampolineIntent$default(getBroadcastReceiverIntent((SendBroadcastAction) action, translationContext), translationContext, i, ActionTrampolineType.BROADCAST, null, 8, null);
        }
        if (action instanceof RunCallbackAction) {
            RunCallbackAction runCallbackAction = (RunCallbackAction) action;
            return ActionTrampolineKt.applyTrampolineIntent$default(ActionCallbackBroadcastReceiver.INSTANCE.createIntent$glance_appwidget_release(translationContext.getContext(), runCallbackAction.getCallbackClass(), translationContext.getAppWidgetId(), function1.invoke(runCallbackAction.getParameters())), translationContext, i, ActionTrampolineType.BROADCAST, null, 8, null);
        }
        if (action instanceof LambdaAction) {
            if (translationContext.getActionBroadcastReceiver() != null) {
                return ActionTrampolineKt.applyTrampolineIntent$default(LambdaActionBroadcasts.INSTANCE.createIntent$glance_appwidget_release(translationContext.getActionBroadcastReceiver(), ((LambdaAction) action).getKey(), translationContext.getAppWidgetId()), translationContext, i, ActionTrampolineType.BROADCAST, null, 8, null);
            }
            throw new IllegalArgumentException("In order to use LambdaAction, actionBroadcastReceiver must be provided");
        }
        if (action instanceof CompoundButtonAction) {
            CompoundButtonAction compoundButtonAction = (CompoundButtonAction) action;
            return getFillInIntentForAction(compoundButtonAction.getInnerAction(), translationContext, i, getActionParameters(compoundButtonAction));
        }
        throw new IllegalStateException(("Cannot create fill-in Intent for action type: " + action).toString());
    }

    public static /* synthetic */ Intent getFillInIntentForAction$default(Action action, TranslationContext translationContext, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            function1 = new Function1<ActionParameters, ActionParameters>() { // from class: androidx.glance.appwidget.action.ApplyActionKt.getFillInIntentForAction.1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ActionParameters invoke(@NotNull ActionParameters it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it;
                }
            };
        }
        return getFillInIntentForAction(action, translationContext, i, function1);
    }

    private static final PendingIntent getPendingIntentForAction(Action action, TranslationContext translationContext, @IdRes int i, Function1<? super ActionParameters, ? extends ActionParameters> function1, int i2) {
        if (action instanceof StartActivityAction) {
            StartActivityAction startActivityAction = (StartActivityAction) action;
            ActionParameters actionParametersInvoke = function1.invoke(startActivityAction.getParameters());
            Context context = translationContext.getContext();
            Intent startActivityIntent = getStartActivityIntent(startActivityAction, translationContext, actionParametersInvoke);
            if (startActivityIntent.getData() == null) {
                startActivityIntent.setData(ActionTrampolineKt.createUniqueUri$default(translationContext, i, ActionTrampolineType.CALLBACK, null, 8, null));
            }
            Unit unit = Unit.INSTANCE;
            PendingIntent activity = PendingIntent.getActivity(context, 0, startActivityIntent, i2 | 134217728, startActivityAction.getActivityOptions());
            Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
            return activity;
        }
        if (action instanceof StartServiceAction) {
            StartServiceAction startServiceAction = (StartServiceAction) action;
            Intent serviceIntent = getServiceIntent(startServiceAction, translationContext);
            if (serviceIntent.getData() == null) {
                serviceIntent.setData(ActionTrampolineKt.createUniqueUri$default(translationContext, i, ActionTrampolineType.CALLBACK, null, 8, null));
            }
            if (startServiceAction.getIsForegroundService()) {
                return ApplyActionApi26Impl.INSTANCE.getForegroundServicePendingIntent(translationContext.getContext(), serviceIntent);
            }
            PendingIntent service = PendingIntent.getService(translationContext.getContext(), 0, serviceIntent, i2 | 134217728);
            Intrinsics.checkNotNull(service);
            return service;
        }
        if (action instanceof SendBroadcastAction) {
            Context context2 = translationContext.getContext();
            Intent broadcastReceiverIntent = getBroadcastReceiverIntent((SendBroadcastAction) action, translationContext);
            if (broadcastReceiverIntent.getData() == null) {
                broadcastReceiverIntent.setData(ActionTrampolineKt.createUniqueUri$default(translationContext, i, ActionTrampolineType.CALLBACK, null, 8, null));
            }
            Unit unit2 = Unit.INSTANCE;
            PendingIntent broadcast = PendingIntent.getBroadcast(context2, 0, broadcastReceiverIntent, i2 | 134217728);
            Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
            return broadcast;
        }
        if (action instanceof RunCallbackAction) {
            Context context3 = translationContext.getContext();
            RunCallbackAction runCallbackAction = (RunCallbackAction) action;
            Intent intentCreateIntent$glance_appwidget_release = ActionCallbackBroadcastReceiver.INSTANCE.createIntent$glance_appwidget_release(translationContext.getContext(), runCallbackAction.getCallbackClass(), translationContext.getAppWidgetId(), function1.invoke(runCallbackAction.getParameters()));
            intentCreateIntent$glance_appwidget_release.setData(ActionTrampolineKt.createUniqueUri$default(translationContext, i, ActionTrampolineType.CALLBACK, null, 8, null));
            Unit unit3 = Unit.INSTANCE;
            PendingIntent broadcast2 = PendingIntent.getBroadcast(context3, 0, intentCreateIntent$glance_appwidget_release, i2 | 134217728);
            Intrinsics.checkNotNullExpressionValue(broadcast2, "getBroadcast(...)");
            return broadcast2;
        }
        if (action instanceof LambdaAction) {
            if (translationContext.getActionBroadcastReceiver() == null) {
                throw new IllegalArgumentException("In order to use LambdaAction, actionBroadcastReceiver must be provided");
            }
            Context context4 = translationContext.getContext();
            LambdaAction lambdaAction = (LambdaAction) action;
            Intent intentCreateIntent$glance_appwidget_release2 = LambdaActionBroadcasts.INSTANCE.createIntent$glance_appwidget_release(translationContext.getActionBroadcastReceiver(), lambdaAction.getKey(), translationContext.getAppWidgetId());
            intentCreateIntent$glance_appwidget_release2.setData(ActionTrampolineKt.createUniqueUri(translationContext, i, ActionTrampolineType.CALLBACK, lambdaAction.getKey()));
            Unit unit4 = Unit.INSTANCE;
            PendingIntent broadcast3 = PendingIntent.getBroadcast(context4, 0, intentCreateIntent$glance_appwidget_release2, i2 | 134217728);
            Intrinsics.checkNotNullExpressionValue(broadcast3, "getBroadcast(...)");
            return broadcast3;
        }
        if (!(action instanceof CompoundButtonAction)) {
            throw new IllegalStateException(("Cannot create PendingIntent for action type: " + action).toString());
        }
        CompoundButtonAction compoundButtonAction = (CompoundButtonAction) action;
        Action innerAction = compoundButtonAction.getInnerAction();
        Function1<ActionParameters, ActionParameters> actionParameters = getActionParameters(compoundButtonAction);
        if (Build.VERSION.SDK_INT >= 31 && !(compoundButtonAction.getInnerAction() instanceof LambdaAction)) {
            i2 = 33554432;
        }
        return getPendingIntentForAction(innerAction, translationContext, i, actionParameters, i2);
    }

    public static /* synthetic */ PendingIntent getPendingIntentForAction$default(Action action, TranslationContext translationContext, int i, Function1 function1, int i2, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            function1 = new Function1<ActionParameters, ActionParameters>() { // from class: androidx.glance.appwidget.action.ApplyActionKt.getPendingIntentForAction.1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ActionParameters invoke(@NotNull ActionParameters it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it;
                }
            };
        }
        if ((i4 & 16) != 0) {
            i2 = 67108864;
        }
        return getPendingIntentForAction(action, translationContext, i, function1, i2);
    }

    private static final Intent getServiceIntent(StartServiceAction startServiceAction, TranslationContext translationContext) {
        if (startServiceAction instanceof StartServiceComponentAction) {
            Intent component = new Intent().setComponent(((StartServiceComponentAction) startServiceAction).getComponentName());
            Intrinsics.checkNotNullExpressionValue(component, "setComponent(...)");
            return component;
        }
        if (startServiceAction instanceof StartServiceClassAction) {
            return new Intent(translationContext.getContext(), ((StartServiceClassAction) startServiceAction).getServiceClass());
        }
        if (startServiceAction instanceof StartServiceIntentAction) {
            return ((StartServiceIntentAction) startServiceAction).getIntent();
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final Intent getStartActivityIntent(StartActivityAction startActivityAction, TranslationContext translationContext, ActionParameters actionParameters) {
        Intent intent;
        if (startActivityAction instanceof StartActivityComponentAction) {
            intent = new Intent().setComponent(((StartActivityComponentAction) startActivityAction).getComponentName());
        } else if (startActivityAction instanceof StartActivityClassAction) {
            intent = new Intent(translationContext.getContext(), ((StartActivityClassAction) startActivityAction).getActivityClass());
        } else {
            if (!(startActivityAction instanceof StartActivityIntentAction)) {
                throw new IllegalStateException(("Action type not defined in app widget package: " + startActivityAction).toString());
            }
            intent = ((StartActivityIntentAction) startActivityAction).getIntent();
        }
        Intrinsics.checkNotNull(intent);
        Map<ActionParameters.Key<? extends Object>, Object> mapAsMap = actionParameters.asMap();
        ArrayList arrayList = new ArrayList(mapAsMap.size());
        for (Map.Entry<ActionParameters.Key<? extends Object>, Object> entry : mapAsMap.entrySet()) {
            arrayList.add(TuplesKt.m13893to(entry.getKey().getName(), entry.getValue()));
        }
        Pair[] pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        intent.putExtras(BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length)));
        return intent;
    }
}
