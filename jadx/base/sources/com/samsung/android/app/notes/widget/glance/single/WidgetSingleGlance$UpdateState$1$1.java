package com.samsung.android.app.notes.widget.glance.single;

import android.content.Context;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.glance.GlanceId;
import androidx.glance.appwidget.state.GlanceAppWidgetStateKt;
import com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance;
import com.sun.imageio.plugins.jpeg.JPEG;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$UpdateState$1$1", m14021f = "WidgetSingleGlance.kt", m14022i = {}, m14023l = {211, JPEG.SOI}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class WidgetSingleGlance$UpdateState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $currentSizeString;
    final /* synthetic */ GlanceId $glanceId;
    final /* synthetic */ String $typeWidgetView;
    int label;
    final /* synthetic */ WidgetSingleGlance this$0;

    /* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$UpdateState$1$1$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m13886d2 = {"<anonymous>", "", "state", "Landroidx/datastore/preferences/core/MutablePreferences;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance$UpdateState$1$1$1", m14021f = "WidgetSingleGlance.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C69821 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $currentSizeString;
        final /* synthetic */ String $typeWidgetView;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69821(String str, String str2, Continuation<? super C69821> continuation) {
            super(2, continuation);
            this.$typeWidgetView = str;
            this.$currentSizeString = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C69821 c69821 = new C69821(this.$typeWidgetView, this.$currentSizeString, continuation);
            c69821.L$0 = obj;
            return c69821;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
            return ((C69821) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
            WidgetSingleGlance.Companion companion = WidgetSingleGlance.INSTANCE;
            mutablePreferences.set(companion.getRequestTimeKey(), Boxing.boxLong(System.currentTimeMillis()));
            mutablePreferences.set(companion.getTypeWidgetViewKey(), this.$typeWidgetView);
            mutablePreferences.set(companion.getLastSizeKey(), this.$currentSizeString);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSingleGlance$UpdateState$1$1(Context context, GlanceId glanceId, WidgetSingleGlance widgetSingleGlance, String str, String str2, Continuation<? super WidgetSingleGlance$UpdateState$1$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$glanceId = glanceId;
        this.this$0 = widgetSingleGlance;
        this.$typeWidgetView = str;
        this.$currentSizeString = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WidgetSingleGlance$UpdateState$1$1(this.$context, this.$glanceId, this.this$0, this.$typeWidgetView, this.$currentSizeString, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
    
        if (r9.update(r1, r3, r8) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Context context = this.$context;
            GlanceId glanceId = this.$glanceId;
            C69821 c69821 = new C69821(this.$typeWidgetView, this.$currentSizeString, null);
            this.label = 1;
            if (GlanceAppWidgetStateKt.updateAppWidgetState(context, glanceId, c69821, this) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        WidgetSingleGlance widgetSingleGlance = this.this$0;
        Context context2 = this.$context;
        GlanceId glanceId2 = this.$glanceId;
        this.label = 2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WidgetSingleGlance$UpdateState$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
