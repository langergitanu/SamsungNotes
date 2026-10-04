package androidx.glance.appwidget.action;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.GlanceId;
import androidx.glance.action.Action;
import androidx.glance.action.ActionParameters;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001d\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0019\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, m13886d2 = {"Landroidx/glance/appwidget/action/RunCallbackAction;", "Landroidx/glance/action/Action;", "callbackClass", "Ljava/lang/Class;", "Landroidx/glance/appwidget/action/ActionCallback;", "parameters", "Landroidx/glance/action/ActionParameters;", "(Ljava/lang/Class;Landroidx/glance/action/ActionParameters;)V", "getCallbackClass", "()Ljava/lang/Class;", "getParameters", "()Landroidx/glance/action/ActionParameters;", "Companion", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class RunCallbackAction implements Action {

    @NotNull
    private final Class<? extends ActionCallback> callbackClass;

    @NotNull
    private final ActionParameters parameters;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m13886d2 = {"Landroidx/glance/appwidget/action/RunCallbackAction$Companion;", "", "()V", "run", "", "context", "Landroid/content/Context;", SearchIndexablesContract.BaseColumns.COLUMN_CLASS_NAME, "", "glanceId", "Landroidx/glance/GlanceId;", "parameters", "Landroidx/glance/action/ActionParameters;", "(Landroid/content/Context;Ljava/lang/String;Landroidx/glance/GlanceId;Landroidx/glance/action/ActionParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final Object run(@NotNull Context context, @NotNull String str, @NotNull GlanceId glanceId, @NotNull ActionParameters actionParameters, @NotNull Continuation<? super Unit> continuation) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
            Class<?> cls = Class.forName(str);
            if (!ActionCallback.class.isAssignableFrom(cls)) {
                throw new IllegalStateException("Provided class must implement ActionCallback.");
            }
            Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type androidx.glance.appwidget.action.ActionCallback");
            Object objOnAction = ((ActionCallback) objNewInstance).onAction(context, glanceId, actionParameters, continuation);
            return objOnAction == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objOnAction : Unit.INSTANCE;
        }

        private Companion() {
        }
    }

    public RunCallbackAction(@NotNull Class<? extends ActionCallback> callbackClass, @NotNull ActionParameters parameters) {
        Intrinsics.checkNotNullParameter(callbackClass, "callbackClass");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.callbackClass = callbackClass;
        this.parameters = parameters;
    }

    @NotNull
    public final Class<? extends ActionCallback> getCallbackClass() {
        return this.callbackClass;
    }

    @NotNull
    public final ActionParameters getParameters() {
        return this.parameters;
    }
}
