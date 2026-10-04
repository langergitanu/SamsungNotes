package androidx.glance.appwidget;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.glance.GlanceId;
import androidx.glance.appwidget.state.GlanceAppWidgetStateKt;
import androidx.glance.state.GlanceStateDefinition;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p002A0.C0009i;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a*\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\u0002\b\tH\u0086@¢\u0006\u0002\u0010\n\u001a\u001a\u0010\u000b\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000e\u001a6\u0010\u000f\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00130\u0012H\u0086H¢\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "provideContent", "", "Landroidx/glance/appwidget/GlanceAppWidget;", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Landroidx/glance/GlanceComposable;", "(Landroidx/glance/appwidget/GlanceAppWidget;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAll", "context", "Landroid/content/Context;", "(Landroidx/glance/appwidget/GlanceAppWidget;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateIf", "State", "predicate", "Lkotlin/Function1;", "", "(Landroidx/glance/appwidget/GlanceAppWidget;Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGlanceAppWidget.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceAppWidget.kt\nandroidx/glance/appwidget/GlanceAppWidgetKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,327:1\n1855#2,2:328\n1855#2,2:331\n1#3:330\n*S KotlinDebug\n*F\n+ 1 GlanceAppWidget.kt\nandroidx/glance/appwidget/GlanceAppWidgetKt\n*L\n287#1:328,2\n300#1:331,2\n*E\n"})
public final class GlanceAppWidgetKt {

    @NotNull
    private static final String TAG = "GWT:AppWidget";

    /* JADX INFO: renamed from: androidx.glance.appwidget.GlanceAppWidgetKt$provideContent$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidgetKt", m14021f = "GlanceAppWidget.kt", m14022i = {}, m14023l = {320}, m14024m = "provideContent", m14025n = {}, m14026s = {})
    public static final class C28501 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C28501(Continuation<? super C28501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GlanceAppWidgetKt.provideContent(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.GlanceAppWidgetKt$updateAll$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidgetKt", m14021f = "GlanceAppWidget.kt", m14022i = {0, 0, 1, 1}, m14023l = {287, 287}, m14024m = "updateAll", m14025n = {"$this$updateAll", "context", "$this$updateAll", "context"}, m14026s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class C28511 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C28511(Continuation<? super C28511> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GlanceAppWidgetKt.updateAll(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object provideContent(@NotNull GlanceAppWidget glanceAppWidget, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @NotNull Continuation<?> continuation) {
        C28501 c28501;
        if (continuation instanceof C28501) {
            c28501 = (C28501) continuation;
            int i = c28501.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c28501.label = i - Integer.MIN_VALUE;
            } else {
                c28501 = new C28501(continuation);
            }
        }
        Object obj = c28501.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c28501.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ContentReceiver contentReceiver = (ContentReceiver) c28501.get$context().get(ContentReceiver.INSTANCE);
            if (contentReceiver == null) {
                throw new IllegalStateException("provideContent requires a ContentReceiver and should only be called from GlanceAppWidget.provideGlance");
            }
            c28501.label = 1;
            if (contentReceiver.provideContent(function2, c28501) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
    
        if (r7 == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object updateAll(@NotNull GlanceAppWidget glanceAppWidget, @NotNull Context context, @NotNull Continuation<? super Unit> continuation) {
        C28511 c28511;
        GlanceAppWidget glanceAppWidget2;
        Iterator it;
        if (continuation instanceof C28511) {
            c28511 = (C28511) continuation;
            int i = c28511.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c28511.label = i - Integer.MIN_VALUE;
            } else {
                c28511 = new C28511(continuation);
            }
        }
        Object glanceIds = c28511.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c28511.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(glanceIds);
            GlanceAppWidgetManager glanceAppWidgetManager = new GlanceAppWidgetManager(context);
            Class<?> cls = glanceAppWidget.getClass();
            c28511.L$0 = glanceAppWidget;
            c28511.L$1 = context;
            c28511.label = 1;
            glanceIds = glanceAppWidgetManager.getGlanceIds(cls, c28511);
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) c28511.L$2;
                context = (Context) c28511.L$1;
                glanceAppWidget2 = (GlanceAppWidget) c28511.L$0;
                ResultKt.throwOnFailure(glanceIds);
                while (it.hasNext()) {
                    GlanceId glanceId = (GlanceId) it.next();
                    c28511.L$0 = glanceAppWidget2;
                    c28511.L$1 = context;
                    c28511.L$2 = it;
                    c28511.label = 2;
                    if (glanceAppWidget2.update(context, glanceId, c28511) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            context = (Context) c28511.L$1;
            glanceAppWidget = (GlanceAppWidget) c28511.L$0;
            ResultKt.throwOnFailure(glanceIds);
        }
        glanceAppWidget2 = glanceAppWidget;
        it = ((Iterable) glanceIds).iterator();
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ <State> Object updateIf(GlanceAppWidget glanceAppWidget, Context context, Function1<? super State, Boolean> function1, Continuation<? super Unit> continuation) {
        GlanceStateDefinition<?> stateDefinition = glanceAppWidget.getStateDefinition();
        if (stateDefinition == null) {
            throw new IllegalArgumentException("GlanceAppWidget.updateIf cannot be used if no state is defined.");
        }
        GlanceAppWidgetManager glanceAppWidgetManager = new GlanceAppWidgetManager(context);
        Class<?> cls = glanceAppWidget.getClass();
        InlineMarker.mark(0);
        Object glanceIds = glanceAppWidgetManager.getGlanceIds(cls, continuation);
        InlineMarker.mark(1);
        for (GlanceId glanceId : (Iterable) glanceIds) {
            InlineMarker.mark(3);
            InlineMarker.mark(0);
            C0009i c0009i = (Object) GlanceAppWidgetStateKt.getAppWidgetState(context, stateDefinition, glanceId, (Continuation) null);
            InlineMarker.mark(1);
            Intrinsics.reifiedOperationMarker(1, "State");
            if (function1.invoke(c0009i).booleanValue()) {
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                glanceAppWidget.update(context, glanceId, null);
                InlineMarker.mark(1);
            }
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
