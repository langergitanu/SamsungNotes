package androidx.glance.appwidget.state;

import android.content.Context;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.glance.GlanceId;
import androidx.glance.appwidget.AppWidgetId;
import androidx.glance.appwidget.AppWidgetUtilsKt;
import androidx.glance.appwidget.GlanceAppWidget;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.state.GlanceState;
import androidx.glance.state.GlanceStateDefinition;
import androidx.glance.state.PreferencesGlanceStateDefinition;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\n\u001aB\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000eH\u0086@¢\u0006\u0002\u0010\u0012\u001aV\u0010\u000b\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000eH\u0086@¢\u0006\u0002\u0010\u0013\u001a(\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003*\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u0015\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "getAppWidgetState", "T", "context", "Landroid/content/Context;", "definition", "Landroidx/glance/state/GlanceStateDefinition;", "glanceId", "Landroidx/glance/GlanceId;", "(Landroid/content/Context;Landroidx/glance/state/GlanceStateDefinition;Landroidx/glance/GlanceId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAppWidgetState", "", "updateState", "Lkotlin/Function2;", "Landroidx/datastore/preferences/core/MutablePreferences;", "Lkotlin/coroutines/Continuation;", "", "(Landroid/content/Context;Landroidx/glance/GlanceId;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroid/content/Context;Landroidx/glance/state/GlanceStateDefinition;Landroidx/glance/GlanceId;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/glance/appwidget/GlanceAppWidget;", "(Landroidx/glance/appwidget/GlanceAppWidget;Landroid/content/Context;Landroidx/glance/GlanceId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGlanceAppWidgetState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceAppWidgetState.kt\nandroidx/glance/appwidget/state/GlanceAppWidgetStateKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n1#2:101\n*E\n"})
public final class GlanceAppWidgetStateKt {

    @NotNull
    private static final String TAG = "GWT:GlanceAppWidgetState";

    /* JADX INFO: renamed from: androidx.glance.appwidget.state.GlanceAppWidgetStateKt$updateAppWidgetState$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, m13886d2 = {"<anonymous>", "Landroidx/datastore/preferences/core/Preferences;", LangPackConfigConstants.LANGUAGE_CODE_IT}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.state.GlanceAppWidgetStateKt$updateAppWidgetState$4", m14021f = "GlanceAppWidgetState.kt", m14022i = {}, m14023l = {80}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C30694 extends SuspendLambda implements Function2<Preferences, Continuation<? super Preferences>, Object> {
        final /* synthetic */ Function2<MutablePreferences, Continuation<? super Unit>, Object> $updateState;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C30694(Function2<? super MutablePreferences, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C30694> continuation) {
            super(2, continuation);
            this.$updateState = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C30694 c30694 = new C30694(this.$updateState, continuation);
            c30694.L$0 = obj;
            return c30694;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull Preferences preferences, @Nullable Continuation<? super Preferences> continuation) {
            return ((C30694) create(preferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                ResultKt.throwOnFailure(obj);
                return mutablePreferences;
            }
            ResultKt.throwOnFailure(obj);
            MutablePreferences mutablePreferences2 = ((Preferences) this.L$0).toMutablePreferences();
            Function2<MutablePreferences, Continuation<? super Unit>, Object> function2 = this.$updateState;
            this.L$0 = mutablePreferences2;
            this.label = 1;
            return function2.invoke(mutablePreferences2, this) == coroutine_suspended ? coroutine_suspended : mutablePreferences2;
        }
    }

    @Nullable
    public static final <T> Object getAppWidgetState(@NotNull Context context, @NotNull GlanceStateDefinition<T> glanceStateDefinition, @NotNull GlanceId glanceId, @NotNull Continuation<? super T> continuation) {
        if (glanceId instanceof AppWidgetId) {
            return GlanceState.INSTANCE.getValue(context, glanceStateDefinition, AppWidgetUtilsKt.createUniqueRemoteUiName(((AppWidgetId) glanceId).getAppWidgetId()), continuation);
        }
        throw new IllegalArgumentException("The glance ID is not the one of an App Widget");
    }

    @Nullable
    public static final <T> Object updateAppWidgetState(@NotNull Context context, @NotNull GlanceStateDefinition<T> glanceStateDefinition, @NotNull GlanceId glanceId, @NotNull Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        if (!(glanceId instanceof AppWidgetId)) {
            throw new IllegalArgumentException("The glance ID is not the one of an App Widget");
        }
        GlanceLog.INSTANCE.m2297d(TAG, "updateAppWidgetState / " + glanceId);
        return GlanceState.INSTANCE.updateValue(context, glanceStateDefinition, AppWidgetUtilsKt.createUniqueRemoteUiName(((AppWidgetId) glanceId).getAppWidgetId()), function2, continuation);
    }

    @Nullable
    public static final <T> Object getAppWidgetState(@NotNull GlanceAppWidget glanceAppWidget, @NotNull Context context, @NotNull GlanceId glanceId, @NotNull Continuation<? super T> continuation) {
        GlanceStateDefinition<?> stateDefinition = glanceAppWidget.getStateDefinition();
        if (stateDefinition != null) {
            Object appWidgetState = getAppWidgetState(context, stateDefinition, glanceId, continuation);
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return appWidgetState;
        }
        throw new IllegalStateException("No state defined in this provider");
    }

    @Nullable
    public static final Object updateAppWidgetState(@NotNull Context context, @NotNull GlanceId glanceId, @NotNull Function2<? super MutablePreferences, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        Object objUpdateAppWidgetState = updateAppWidgetState(context, PreferencesGlanceStateDefinition.INSTANCE, glanceId, new C30694(function2, null), continuation);
        return objUpdateAppWidgetState == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateAppWidgetState : Unit.INSTANCE;
    }
}
