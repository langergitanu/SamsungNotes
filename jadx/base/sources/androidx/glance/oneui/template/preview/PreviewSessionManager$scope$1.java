package androidx.glance.oneui.template.preview;

import android.content.Context;
import androidx.datastore.preferences.core.Preferences;
import androidx.glance.appwidget.multiprocess.CoroutineSession;
import androidx.glance.appwidget.multiprocess.CoroutineSessionManagerScope;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.GlanceLog;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\t"}, m13886d2 = {"androidx/glance/oneui/template/preview/PreviewSessionManager$scope$1", "Landroidx/glance/appwidget/multiprocess/CoroutineSessionManagerScope;", "startCoroutineSession", "", "context", "Landroid/content/Context;", "session", "Landroidx/glance/appwidget/multiprocess/CoroutineSession;", "(Landroid/content/Context;Landroidx/glance/appwidget/multiprocess/CoroutineSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPreviewSessionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreviewSessionManager.kt\nandroidx/glance/oneui/template/preview/PreviewSessionManager$scope$1\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,70:1\n187#2,3:71\n*S KotlinDebug\n*F\n+ 1 PreviewSessionManager.kt\nandroidx/glance/oneui/template/preview/PreviewSessionManager$scope$1\n*L\n35#1:71,3\n*E\n"})
public final class PreviewSessionManager$scope$1 extends CoroutineSessionManagerScope {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object startCoroutineSession$isStateChangedSinceLastCall(CoroutineSession coroutineSession, Context context, Continuation<? super Boolean> continuation) throws Throwable {
        C3483xee026ca2 c3483xee026ca2;
        Map<AppWidgetSize, Preferences> state;
        Map<AppWidgetSize, Preferences> map;
        if (continuation instanceof C3483xee026ca2) {
            c3483xee026ca2 = (C3483xee026ca2) continuation;
            int i = c3483xee026ca2.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c3483xee026ca2.label = i - Integer.MIN_VALUE;
            } else {
                c3483xee026ca2 = new C3483xee026ca2(continuation);
            }
        }
        Object obj = c3483xee026ca2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c3483xee026ca2.label;
        boolean z = true;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            PreviewGlanceState previewGlanceState = PreviewSessionManagerKt.getLatestSessionStates().get(coroutineSession.getKey());
            if (previewGlanceState == null || (state = previewGlanceState.getState()) == null) {
                return Boxing.boxBoolean(true);
            }
            c3483xee026ca2.L$0 = state;
            c3483xee026ca2.label = 1;
            Object previewGlanceState$glance_oneui_template_release = ((PreviewSession) coroutineSession).getPreviewGlanceState$glance_oneui_template_release(context, c3483xee026ca2);
            if (previewGlanceState$glance_oneui_template_release == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = previewGlanceState$glance_oneui_template_release;
            map = state;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            map = (Map) c3483xee026ca2.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Map<AppWidgetSize, Preferences> state2 = ((PreviewGlanceState) obj).getState();
        if (state2.isEmpty()) {
            z = false;
        } else {
            for (Map.Entry<AppWidgetSize, Preferences> entry : state2.entrySet()) {
                int mask = entry.getKey().getMask();
                Preferences value = entry.getValue();
                if (!map.keySet().contains(AppWidgetSize.m21545boximpl(mask)) || !Intrinsics.areEqual(value, map.get(AppWidgetSize.m21545boximpl(mask)))) {
                    break;
                }
            }
            z = false;
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a5, code lost:
    
        if (kotlinx.coroutines.TimeoutKt.withTimeout(4000, r14, r0) == r1) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.glance.appwidget.multiprocess.CoroutineSessionManagerScope
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object startCoroutineSession(@NotNull Context context, @NotNull CoroutineSession coroutineSession, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        PreviewSessionManager$scope$1$startCoroutineSession$1 previewSessionManager$scope$1$startCoroutineSession$1;
        Exception e;
        CoroutineSession coroutineSession2;
        ConcurrentModificationException e2;
        if (continuation instanceof PreviewSessionManager$scope$1$startCoroutineSession$1) {
            previewSessionManager$scope$1$startCoroutineSession$1 = (PreviewSessionManager$scope$1$startCoroutineSession$1) continuation;
            int i = previewSessionManager$scope$1$startCoroutineSession$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                previewSessionManager$scope$1$startCoroutineSession$1.label = i - Integer.MIN_VALUE;
            } else {
                previewSessionManager$scope$1$startCoroutineSession$1 = new PreviewSessionManager$scope$1$startCoroutineSession$1(this, continuation);
            }
        }
        Object objStartCoroutineSession$isStateChangedSinceLastCall = previewSessionManager$scope$1$startCoroutineSession$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = previewSessionManager$scope$1$startCoroutineSession$1.label;
        try {
        } catch (CancellationException e3) {
            GlanceLog.INSTANCE.m2305w("GWT:PreviewSessionManager", "PreviewSession is finished by " + e3);
        }
        if (i2 == 0) {
            ResultKt.throwOnFailure(objStartCoroutineSession$isStateChangedSinceLastCall);
            if (!(coroutineSession instanceof PreviewSession)) {
                return Unit.INSTANCE;
            }
            previewSessionManager$scope$1$startCoroutineSession$1.L$0 = context;
            previewSessionManager$scope$1$startCoroutineSession$1.L$1 = coroutineSession;
            previewSessionManager$scope$1$startCoroutineSession$1.label = 1;
            objStartCoroutineSession$isStateChangedSinceLastCall = startCoroutineSession$isStateChangedSinceLastCall(coroutineSession, context, previewSessionManager$scope$1$startCoroutineSession$1);
            if (objStartCoroutineSession$isStateChangedSinceLastCall != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineSession2 = (CoroutineSession) previewSessionManager$scope$1$startCoroutineSession$1.L$0;
            try {
                ResultKt.throwOnFailure(objStartCoroutineSession$isStateChangedSinceLastCall);
            } catch (ConcurrentModificationException e5) {
                e2 = e5;
                GlanceLog.INSTANCE.m2305w("GWT:PreviewSessionManager", "ConcurrentModificationException " + e2 + " occurred while " + coroutineSession2.getKey() + "-preview composition");
            } catch (Exception e6) {
                e = e6;
                GlanceLog.INSTANCE.m2305w("GWT:PreviewSessionManager", "Exception " + e + " occurred while " + coroutineSession2.getKey() + "-preview composition");
            }
            return Unit.INSTANCE;
        }
        coroutineSession = (CoroutineSession) previewSessionManager$scope$1$startCoroutineSession$1.L$1;
        context = (Context) previewSessionManager$scope$1$startCoroutineSession$1.L$0;
        ResultKt.throwOnFailure(objStartCoroutineSession$isStateChangedSinceLastCall);
        boolean zBooleanValue = ((Boolean) objStartCoroutineSession$isStateChangedSinceLastCall).booleanValue();
        GlanceLog.INSTANCE.m2297d("GWT:PreviewSessionManager", "State of " + coroutineSession.getKey() + " changed : " + zBooleanValue);
        if (zBooleanValue) {
            try {
                PreviewSessionManager$scope$1$startCoroutineSession$2 previewSessionManager$scope$1$startCoroutineSession$2 = new PreviewSessionManager$scope$1$startCoroutineSession$2(coroutineSession, context, null);
                previewSessionManager$scope$1$startCoroutineSession$1.L$0 = coroutineSession;
                previewSessionManager$scope$1$startCoroutineSession$1.L$1 = null;
                previewSessionManager$scope$1$startCoroutineSession$1.label = 2;
            } catch (ConcurrentModificationException e7) {
                CoroutineSession coroutineSession3 = coroutineSession;
                e2 = e7;
                coroutineSession2 = coroutineSession3;
                GlanceLog.INSTANCE.m2305w("GWT:PreviewSessionManager", "ConcurrentModificationException " + e2 + " occurred while " + coroutineSession2.getKey() + "-preview composition");
            } catch (Exception e8) {
                CoroutineSession coroutineSession4 = coroutineSession;
                e = e8;
                coroutineSession2 = coroutineSession4;
                GlanceLog.INSTANCE.m2305w("GWT:PreviewSessionManager", "Exception " + e + " occurred while " + coroutineSession2.getKey() + "-preview composition");
            }
        }
        return Unit.INSTANCE;
    }
}
