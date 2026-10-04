package androidx.test.core.app;

import android.app.UiAutomation;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.test.core.internal.p115os.HandlerExecutor;
import androidx.test.core.view.ViewCapture;
import androidx.test.internal.util.Checks;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.platform.graphics.HardwareRendererCompat;
import androidx.test.platform.view.inspector.WindowInspectorCompat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u0002\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u0006\u0010\u0005\u001a\u00020\u0006\u001a\b\u0010\u0007\u001a\u00020\u0006H\u0007\u001a!\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m13886d2 = {"canTakeScreenshot", "", "forceRedrawGlobalWindowViews", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "takeScreenshot", "Landroid/graphics/Bitmap;", "takeScreenshotNoSync", "takeScreenshotOnNextFrame", "uiAutomation", "Landroid/app/UiAutomation;", "hardwareDrawingEnabled", "(Landroid/app/UiAutomation;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_java_androidx_test_core-core_internal_kt"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@JvmName(name = "DeviceCapture")
@SourceDebugExtension({"SMAP\nDeviceCapture.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceCapture.kt\nandroidx/test/core/app/DeviceCapture\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,160:1\n314#2,11:161\n*S KotlinDebug\n*F\n+ 1 DeviceCapture.kt\nandroidx/test/core/app/DeviceCapture\n*L\n138#1:161,11\n*E\n"})
public final class DeviceCapture {

    /* JADX INFO: renamed from: androidx.test.core.app.DeviceCapture$forceRedrawGlobalWindowViews$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.test.core.app.DeviceCapture", m14021f = "DeviceCapture.kt", m14022i = {}, m14023l = {126}, m14024m = "forceRedrawGlobalWindowViews", m14025n = {}, m14026s = {})
    public static final class C38871 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C38871(Continuation<? super C38871> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeviceCapture.forceRedrawGlobalWindowViews(this);
        }
    }

    /* JADX INFO: renamed from: androidx.test.core.app.DeviceCapture$takeScreenshotNoSync$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.test.core.app.DeviceCapture$takeScreenshotNoSync$1", m14021f = "DeviceCapture.kt", m14022i = {}, m14023l = {113}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C38881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        final /* synthetic */ Ref.ObjectRef<Bitmap> $bitmap;
        final /* synthetic */ Ref.ObjectRef<Exception> $exception;
        final /* synthetic */ boolean $hardwareDrawingEnabled;
        final /* synthetic */ UiAutomation $uiAutomation;
        int label;

        /* JADX INFO: renamed from: androidx.test.core.app.DeviceCapture$takeScreenshotNoSync$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.test.core.app.DeviceCapture$takeScreenshotNoSync$1$1", m14021f = "DeviceCapture.kt", m14022i = {}, m14023l = {114, 115}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        @SourceDebugExtension({"SMAP\nDeviceCapture.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceCapture.kt\nandroidx/test/core/app/DeviceCapture$takeScreenshotNoSync$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,160:1\n1#2:161\n*E\n"})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
            final /* synthetic */ Ref.ObjectRef<Bitmap> $bitmap;
            final /* synthetic */ Ref.ObjectRef<Exception> $exception;
            final /* synthetic */ boolean $hardwareDrawingEnabled;
            final /* synthetic */ UiAutomation $uiAutomation;
            Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Ref.ObjectRef<Bitmap> objectRef, UiAutomation uiAutomation, boolean z, Ref.ObjectRef<Exception> objectRef2, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$bitmap = objectRef;
                this.$uiAutomation = uiAutomation;
                this.$hardwareDrawingEnabled = z;
                this.$exception = objectRef2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass1(this.$bitmap, this.$uiAutomation, this.$hardwareDrawingEnabled, this.$exception, continuation);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(@NotNull Object obj) throws Exception {
                Ref.ObjectRef<Bitmap> objectRef;
                T t;
                Exception exc;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (DeviceCapture.forceRedrawGlobalWindowViews(this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    t = obj;
                    objectRef.element = t;
                    exc = this.$exception.element;
                    if (exc == null) {
                        throw exc;
                    }
                    Bitmap bitmap = this.$bitmap.element;
                    Intrinsics.checkNotNull(bitmap);
                    return bitmap;
                }
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef<Bitmap> objectRef2 = this.$bitmap;
                UiAutomation uiAutomation = this.$uiAutomation;
                Intrinsics.checkNotNullExpressionValue(uiAutomation, "uiAutomation");
                boolean z = this.$hardwareDrawingEnabled;
                this.L$0 = objectRef2;
                this.label = 2;
                Object objTakeScreenshotOnNextFrame = DeviceCapture.takeScreenshotOnNextFrame(uiAutomation, z, this);
                if (objTakeScreenshotOnNextFrame != coroutine_suspended) {
                    objectRef = objectRef2;
                    t = objTakeScreenshotOnNextFrame;
                    objectRef.element = t;
                    exc = this.$exception.element;
                    if (exc == null) {
                    }
                }
                return coroutine_suspended;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Bitmap> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C38881(Ref.ObjectRef<Bitmap> objectRef, UiAutomation uiAutomation, boolean z, Ref.ObjectRef<Exception> objectRef2, Continuation<? super C38881> continuation) {
            super(2, continuation);
            this.$bitmap = objectRef;
            this.$uiAutomation = uiAutomation;
            this.$hardwareDrawingEnabled = z;
            this.$exception = objectRef2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C38881(this.$bitmap, this.$uiAutomation, this.$hardwareDrawingEnabled, this.$exception, continuation);
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
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Duration.Companion companion = Duration.INSTANCE;
            long duration = DurationKt.toDuration(5, DurationUnit.SECONDS);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$bitmap, this.$uiAutomation, this.$hardwareDrawingEnabled, this.$exception, null);
            this.label = 1;
            Object objM23703withTimeoutKLykuaI = TimeoutKt.m23703withTimeoutKLykuaI(duration, anonymousClass1, this);
            return objM23703withTimeoutKLykuaI == coroutine_suspended ? coroutine_suspended : objM23703withTimeoutKLykuaI;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Bitmap> continuation) {
            return ((C38881) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean canTakeScreenshot() {
        return (InstrumentationRegistry.getInstrumentation().getUiAutomation() == null || Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object forceRedrawGlobalWindowViews(Continuation<? super Unit> continuation) throws WindowInspectorCompat.ViewRetrievalException {
        C38871 c38871;
        Iterator<View> it;
        if (continuation instanceof C38871) {
            c38871 = (C38871) continuation;
            int i = c38871.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c38871.label = i - Integer.MIN_VALUE;
            } else {
                c38871 = new C38871(continuation);
            }
        }
        Object obj = c38871.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c38871.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            List<View> globalWindowViews = WindowInspectorCompat.getGlobalWindowViews();
            Log.d("DeviceCapture", "Found " + globalWindowViews.size() + " global views to redraw");
            it = globalWindowViews.iterator();
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) c38871.L$0;
            ResultKt.throwOnFailure(obj);
        }
        while (it.hasNext()) {
            View view = it.next();
            Intrinsics.checkNotNullExpressionValue(view, "view");
            c38871.L$0 = it;
            c38871.label = 1;
            if (ViewCapture.forceRedraw(view, c38871) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public static final Bitmap takeScreenshot() {
        InstrumentationRegistry.getInstrumentation().waitForIdleSync();
        return takeScreenshotNoSync();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final Bitmap takeScreenshotNoSync() {
        Checks.checkState(canTakeScreenshot());
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        CoroutineDispatcher coroutineDispatcherFrom = ExecutorsKt.from(new HandlerExecutor(new Handler(Looper.getMainLooper())));
        UiAutomation uiAutomation = InstrumentationRegistry.getInstrumentation().getUiAutomation();
        if (uiAutomation == null) {
            throw new RuntimeException("uiautomation is null");
        }
        boolean zIsDrawingEnabled = HardwareRendererCompat.isDrawingEnabled();
        HardwareRendererCompat.setDrawingEnabled(true);
        return (Bitmap) BuildersKt.runBlocking(coroutineDispatcherFrom, new C38881(objectRef, uiAutomation, zIsDrawingEnabled, objectRef2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object takeScreenshotOnNextFrame(final UiAutomation uiAutomation, final boolean z, Continuation<? super Bitmap> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.test.core.app.DeviceCapture$takeScreenshotOnNextFrame$2$1
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                Bitmap bitmapTakeScreenshot = null;
                int i = 1;
                while (true) {
                    if (i >= 4) {
                        break;
                    }
                    bitmapTakeScreenshot = uiAutomation.takeScreenshot();
                    if (bitmapTakeScreenshot != null) {
                        Log.i("DeviceCapture", "got bitmap, returning");
                        break;
                    }
                    i++;
                }
                HardwareRendererCompat.setDrawingEnabled(z);
                if (bitmapTakeScreenshot != null) {
                    cancellableContinuationImpl.resume(bitmapTakeScreenshot, new Function1<Throwable, Unit>() { // from class: androidx.test.core.app.DeviceCapture$takeScreenshotOnNextFrame$2$1.1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }
                    });
                    return;
                }
                Log.w("DeviceCapture", "failed to get bitmap, returning exception");
                CancellableContinuation<Bitmap> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m22215constructorimpl(ResultKt.createFailure(new RuntimeException("uiAutomation.takeScreenshot returned null"))));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
