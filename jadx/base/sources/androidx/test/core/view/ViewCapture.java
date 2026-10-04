package androidx.test.core.view;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.credentials.provider.utils.AbstractC2561c;
import androidx.test.core.internal.p115os.HandlerExecutor;
import androidx.test.internal.platform.ServiceLoaderWrapper;
import androidx.test.internal.platform.p117os.ControlledLooper;
import androidx.test.internal.platform.reflect.ReflectionException;
import androidx.test.internal.platform.reflect.ReflectiveField;
import androidx.test.internal.platform.reflect.ReflectiveMethod;
import androidx.test.internal.util.Checks;
import androidx.test.platform.graphics.HardwareRendererCompat;
import com.google.common.util.concurrent.ListenableFuture;
import com.microsoft.identity.common.java.WarningType;
import java.util.function.Consumer;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001a!\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t*\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u0004H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a!\u0010\r\u001a\u00020\u0003*\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001e\u0010\u000e\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000\u001a)\u0010\u0010\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0083@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a/\u0010\u0010\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0083@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a'\u0010\u0015\u001a\u00020\u0003*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0083@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\f\u0010\u0018\u001a\u00020\u0006*\u00020\u0004H\u0002\u001a\f\u0010\u0019\u001a\u00020\u0006*\u00020\u0004H\u0002\u001a\f\u0010\u001a\u001a\u00020\u0013*\u00020\u0004H\u0002\u001a\u0014\u0010\u001b\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dH\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, m13886d2 = {"getControlledLooper", "Landroidx/test/internal/platform/os/ControlledLooper;", "captureToBitmap", "Landroid/graphics/Bitmap;", "Landroid/view/View;", "rect", "Landroid/graphics/Rect;", "(Landroid/view/View;Landroid/graphics/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "captureToBitmapAsync", "Lcom/google/common/util/concurrent/ListenableFuture;", "forceRedraw", "", "(Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateBitmap", "generateBitmapFromDraw", "destBitmap", "generateBitmapFromPixelCopy", "(Landroid/view/View;Landroid/graphics/Bitmap;Landroid/graphics/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "surface", "Landroid/view/Surface;", "(Landroid/view/View;Landroid/view/Surface;Landroid/graphics/Bitmap;Landroid/graphics/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateBitmapFromSurfaceViewPixelCopy", "Landroid/view/SurfaceView;", "(Landroid/view/SurfaceView;Landroid/graphics/Bitmap;Landroid/graphics/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBoundsInSurface", "getBoundsInWindow", "getSurface", "reflectivelyGetLocationInSurface", "locationInSurface", "", "core_java_androidx_test_core-core_internal_kt"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@JvmName(name = "ViewCapture")
@SourceDebugExtension({"SMAP\nViewCapture.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewCapture.kt\nandroidx/test/core/view/ViewCapture\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,321:1\n314#2,11:322\n314#2,11:333\n314#2,11:344\n314#2,11:355\n*S KotlinDebug\n*F\n+ 1 ViewCapture.kt\nandroidx/test/core/view/ViewCapture\n*L\n130#1:322,11\n178#1:333,11\n216#1:344,11\n304#1:355,11\n*E\n"})
public final class ViewCapture {

    /* JADX INFO: renamed from: androidx.test.core.view.ViewCapture$captureToBitmap$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.test.core.view.ViewCapture", m14021f = "ViewCapture.kt", m14022i = {0, 0, 0, 1}, m14023l = {93, 94}, m14024m = "captureToBitmap", m14025n = {"$this$captureToBitmap", "rect", "hardwareDrawingEnabled", "hardwareDrawingEnabled"}, m14026s = {"L$0", "L$1", "Z$0", "Z$0"})
    public static final class C39011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C39011(Continuation<? super C39011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ViewCapture.captureToBitmap(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.test.core.view.ViewCapture$captureToBitmapAsync$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.test.core.view.ViewCapture$captureToBitmapAsync$1", m14021f = "ViewCapture.kt", m14022i = {}, m14023l = {110}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C39021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        final /* synthetic */ Rect $rect;
        final /* synthetic */ View $this_captureToBitmapAsync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C39021(View view, Rect rect, Continuation<? super C39021> continuation) {
            super(2, continuation);
            this.$this_captureToBitmapAsync = view;
            this.$rect = rect;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C39021(this.$this_captureToBitmapAsync, this.$rect, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
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
            View view = this.$this_captureToBitmapAsync;
            Rect rect = this.$rect;
            this.label = 1;
            Object objCaptureToBitmap = ViewCapture.captureToBitmap(view, rect, this);
            return objCaptureToBitmap == coroutine_suspended ? coroutine_suspended : objCaptureToBitmap;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Bitmap> continuation) {
            return ((C39021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.test.core.view.ViewCapture$forceRedraw$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.test.core.view.ViewCapture", m14021f = "ViewCapture.kt", m14022i = {0, 0}, m14023l = {322}, m14024m = "forceRedraw", m14025n = {"$this$forceRedraw", "drawListener"}, m14026s = {"L$0", "L$1"})
    public static final class C39031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C39031(Continuation<? super C39031> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ViewCapture.forceRedraw(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v7, types: [boolean] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object captureToBitmap(@NotNull View view, @Nullable Rect rect, @NotNull Continuation<? super Bitmap> continuation) throws Throwable {
        C39011 c39011;
        boolean zIsDrawingEnabled;
        View view2;
        if (continuation instanceof C39011) {
            c39011 = (C39011) continuation;
            int i = c39011.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c39011.label = i - Integer.MIN_VALUE;
            } else {
                c39011 = new C39011(continuation);
            }
        }
        Object obj = c39011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c39011.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Checks.checkState(view.isAttachedToWindow(), "View must be attached to a window", new Object[0]);
                Checks.checkState(view.getHandler().getLooper().isCurrentThread(), "Must be called from view's handler thread. Current: " + Thread.currentThread().getName() + ", view handler: " + view.getHandler().getLooper().getThread().getName(), new Object[0]);
                zIsDrawingEnabled = HardwareRendererCompat.isDrawingEnabled();
                HardwareRendererCompat.setDrawingEnabled(true);
                try {
                    c39011.L$0 = view;
                    c39011.L$1 = rect;
                    c39011.Z$0 = zIsDrawingEnabled;
                    c39011.label = 1;
                    Object objForceRedraw = forceRedraw(view, c39011);
                    view2 = view;
                    if (objForceRedraw == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } catch (Throwable th) {
                    th = th;
                    view = zIsDrawingEnabled;
                    HardwareRendererCompat.setDrawingEnabled(view);
                    throw th;
                }
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z = c39011.Z$0;
                ResultKt.throwOnFailure(obj);
                view = z;
                Bitmap bitmap = (Bitmap) obj;
                HardwareRendererCompat.setDrawingEnabled(view);
                Intrinsics.checkNotNull(bitmap);
                return bitmap;
            }
            boolean z2 = c39011.Z$0;
            rect = (Rect) c39011.L$1;
            View view3 = (View) c39011.L$0;
            ResultKt.throwOnFailure(obj);
            zIsDrawingEnabled = z2;
            view2 = view3;
            c39011.L$0 = null;
            c39011.L$1 = null;
            c39011.Z$0 = zIsDrawingEnabled;
            c39011.label = 2;
            Object objGenerateBitmap = generateBitmap(view2, rect, c39011);
            if (objGenerateBitmap != coroutine_suspended) {
                boolean z3 = zIsDrawingEnabled;
                obj = objGenerateBitmap;
                view = z3;
                Bitmap bitmap2 = (Bitmap) obj;
                HardwareRendererCompat.setDrawingEnabled(view);
                Intrinsics.checkNotNull(bitmap2);
                return bitmap2;
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static /* synthetic */ Object captureToBitmap$default(View view, Rect rect, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            rect = null;
        }
        return captureToBitmap(view, rect, continuation);
    }

    @NotNull
    public static final ListenableFuture<Bitmap> captureToBitmapAsync(@NotNull View view, @Nullable Rect rect) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return SuspendToFutureAdapter.launchFuture$default(SuspendToFutureAdapter.INSTANCE, Dispatchers.getMain(), false, new C39021(view, rect, null), 2, null);
    }

    public static /* synthetic */ ListenableFuture captureToBitmapAsync$default(View view, Rect rect, int i, Object obj) {
        if ((i & 1) != 0) {
            rect = null;
        }
        return captureToBitmapAsync(view, rect);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, androidx.test.core.view.ViewCapture$forceRedraw$2$2] */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object forceRedraw(@NotNull View view, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        C39031 c39031;
        final View view2;
        final Ref.ObjectRef objectRef;
        Throwable th;
        if (continuation instanceof C39031) {
            c39031 = (C39031) continuation;
            int i = c39031.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c39031.label = i - Integer.MIN_VALUE;
            } else {
                c39031 = new C39031(continuation);
            }
        }
        Object obj = c39031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c39031.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Checks.checkState(view.getHandler().getLooper().isCurrentThread(), "Must be called from view's handler thread", new Object[0]);
            if (!getControlledLooper().areDrawCallbacksSupported()) {
                Log.i("ViewCapture", "Skipping forceRedraw as it is not supported");
                return Unit.INSTANCE;
            }
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            try {
                c39031.L$0 = view;
                c39031.L$1 = objectRef2;
                c39031.label = 1;
                final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c39031), 1);
                cancellableContinuationImpl.initCancellability();
                if (Build.VERSION.SDK_INT < 29 || !view.isHardwareAccelerated()) {
                    objectRef2.element = new ViewTreeObserver.OnDrawListener() { // from class: androidx.test.core.view.ViewCapture$forceRedraw$2$2
                        private boolean handled;

                        public final boolean getHandled() {
                            return this.handled;
                        }

                        @Override // android.view.ViewTreeObserver.OnDrawListener
                        public void onDraw() {
                            if (this.handled) {
                                return;
                            }
                            this.handled = true;
                            CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl;
                            Result.Companion companion = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m22215constructorimpl(Unit.INSTANCE));
                        }

                        public final void setHandled(boolean z) {
                            this.handled = z;
                        }
                    };
                    view.getViewTreeObserver().addOnDrawListener((ViewTreeObserver.OnDrawListener) objectRef2.element);
                } else {
                    view.getViewTreeObserver().registerFrameCommitCallback(new Runnable() { // from class: androidx.test.core.view.ViewCapture$forceRedraw$2$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            Log.i("forceRedraw", "FrameCommitCallback complete");
                            CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl;
                            Result.Companion companion = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m22215constructorimpl(Unit.INSTANCE));
                        }
                    });
                }
                view.invalidate();
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(c39031);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                view2 = view;
                objectRef = objectRef2;
            } catch (Throwable th2) {
                view2 = view;
                objectRef = objectRef2;
                th = th2;
                if (objectRef.element != 0) {
                }
                throw th;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) c39031.L$1;
            view2 = (View) c39031.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                if (objectRef.element != 0) {
                    view2.getHandler().post(new Runnable() { // from class: androidx.test.core.view.ViewCapture.forceRedraw.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            view2.getViewTreeObserver().removeOnDrawListener(objectRef.element);
                        }
                    });
                }
                throw th;
            }
        }
        Unit unit = Unit.INSTANCE;
        if (objectRef.element != 0) {
            view2.getHandler().post(new Runnable() { // from class: androidx.test.core.view.ViewCapture.forceRedraw.3
                @Override // java.lang.Runnable
                public final void run() {
                    view2.getViewTreeObserver().removeOnDrawListener(objectRef.element);
                }
            });
        }
        return unit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object generateBitmap(View view, Rect rect, Continuation<? super Bitmap> continuation) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(rect != null ? rect.width() : view.getWidth(), rect != null ? rect.height() : view.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(rectWidth, … Bitmap.Config.ARGB_8888)");
        return Build.VERSION.SDK_INT >= 34 ? generateBitmapFromPixelCopy(view, bitmapCreateBitmap, rect, continuation) : view instanceof SurfaceView ? generateBitmapFromSurfaceViewPixelCopy((SurfaceView) view, bitmapCreateBitmap, rect, continuation) : generateBitmapFromPixelCopy(view, getSurface(view), bitmapCreateBitmap, rect, continuation);
    }

    public static /* synthetic */ Object generateBitmap$default(View view, Rect rect, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            rect = null;
        }
        return generateBitmap(view, rect, continuation);
    }

    @NotNull
    public static final Bitmap generateBitmapFromDraw(@NotNull View view, @NotNull Bitmap destBitmap, @Nullable Rect rect) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(destBitmap, "destBitmap");
        destBitmap.setDensity(view.getResources().getDisplayMetrics().densityDpi);
        view.computeScroll();
        Canvas canvas = new Canvas(destBitmap);
        canvas.translate(-view.getScrollX(), -view.getScrollY());
        if (rect != null) {
            canvas.translate(-rect.left, -rect.top);
        }
        view.draw(canvas);
        return destBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(26)
    public static final Object generateBitmapFromPixelCopy(View view, Surface surface, final Bitmap bitmap, Rect rect, Continuation<? super Bitmap> continuation) throws ReflectionException {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Rect boundsInSurface = getBoundsInSurface(view);
        if (rect != null) {
            int i = boundsInSurface.left;
            int i2 = rect.left + i;
            int i4 = boundsInSurface.top;
            boundsInSurface = new Rect(i2, rect.top + i4, i + rect.right, i4 + rect.bottom);
        }
        PixelCopy.request(surface, boundsInSurface, bitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: androidx.test.core.view.ViewCapture$generateBitmapFromPixelCopy$2$onCopyFinished$1
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i5) {
                if (i5 == 0) {
                    CancellableContinuation<Bitmap> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m22215constructorimpl(bitmap));
                } else {
                    CancellableContinuation<Bitmap> cancellableContinuation2 = cancellableContinuationImpl;
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation2.resumeWith(Result.m22215constructorimpl(ResultKt.createFailure(new RuntimeException(AbstractC0000a.m11h(i5, "PixelCopy failed: ")))));
                }
            }
        }, new Handler(Looper.getMainLooper()));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static /* synthetic */ Object generateBitmapFromPixelCopy$default(View view, Bitmap bitmap, Rect rect, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            rect = null;
        }
        return generateBitmapFromPixelCopy(view, bitmap, rect, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(26)
    public static final Object generateBitmapFromSurfaceViewPixelCopy(SurfaceView surfaceView, final Bitmap bitmap, Rect rect, Continuation<? super Bitmap> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        PixelCopy.request(surfaceView, rect, bitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: androidx.test.core.view.ViewCapture$generateBitmapFromSurfaceViewPixelCopy$2$onCopyFinished$1
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i) {
                if (i == 0) {
                    CancellableContinuation<Bitmap> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m22215constructorimpl(bitmap));
                } else {
                    CancellableContinuation<Bitmap> cancellableContinuation2 = cancellableContinuationImpl;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    RuntimeException runtimeException = new RuntimeException(AbstractC2322a.m1624n("PixelCopy failed: %d", new Object[]{Integer.valueOf(i)}, 1, "format(format, *args)"));
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation2.resumeWith(Result.m22215constructorimpl(ResultKt.createFailure(runtimeException)));
                }
            }
        }, surfaceView.getHandler());
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect getBoundsInSurface(View view) throws ReflectionException {
        int[] iArr = {0, 0};
        if (Build.VERSION.SDK_INT < 29) {
            reflectivelyGetLocationInSurface(view, iArr);
        } else {
            view.getLocationInSurface(iArr);
        }
        int i = iArr[0];
        int i2 = iArr[1];
        Rect rect = new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
        Log.d("ViewCapture", "getBoundsInSurface " + rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect getBoundsInWindow(View view) {
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
    }

    private static final ControlledLooper getControlledLooper() {
        Object objLoadSingleService = ServiceLoaderWrapper.loadSingleService(ControlledLooper.class, new ServiceLoaderWrapper.Factory() { // from class: androidx.test.core.view.ViewCapture.getControlledLooper.1
            @Override // androidx.test.internal.platform.ServiceLoaderWrapper.Factory
            public final ControlledLooper create() {
                return ControlledLooper.NO_OP_CONTROLLED_LOOPER;
            }
        });
        Intrinsics.checkNotNullExpressionValue(objLoadSingleService, "loadSingleService(Contro…_OP_CONTROLLED_LOOPER\n  }");
        return (ControlledLooper) objLoadSingleService;
    }

    private static final Surface getSurface(View view) throws ReflectionException {
        Object obj = new ReflectiveField("android.view.ViewRootImpl", "mSurface").get(new ReflectiveMethod((Class<?>) View.class, "getViewRootImpl", (Class<?>[]) new Class[0]).invoke(view, new Object[0]));
        Intrinsics.checkNotNullExpressionValue(obj, "ReflectiveField<Surface>…rface\").get(viewRootImpl)");
        return (Surface) obj;
    }

    @SuppressLint({WarningType.NewApi})
    private static final void reflectivelyGetLocationInSurface(View view, int[] iArr) throws ReflectionException {
        view.getLocationInWindow(iArr);
        if (Build.VERSION.SDK_INT >= 28) {
            Log.w("ViewCapture", "Could not calculate offset of view in surface on API 28, resulting image may have incorrect positioning");
            return;
        }
        Rect rect = (Rect) new ReflectiveField((Class<?>) WindowManager.LayoutParams.class, "surfaceInsets").get((WindowManager.LayoutParams) new ReflectiveField("android.view.ViewRootImpl", "mWindowAttributes").get(new ReflectiveMethod((Class<?>) View.class, "getViewRootImpl", (Class<?>[]) new Class[0]).invoke(view, new Object[0])));
        iArr[0] = iArr[0] + rect.left;
        iArr[1] = iArr[1] + rect.top;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(34)
    public static final Object generateBitmapFromPixelCopy(View view, Bitmap bitmap, Rect rect, Continuation<? super Bitmap> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        PixelCopy.Request.Builder builderOfWindow = PixelCopy.Request.Builder.ofWindow(view);
        if (rect == null) {
            rect = getBoundsInWindow(view);
        }
        PixelCopy.Request requestBuild = builderOfWindow.setSourceRect(rect).setDestinationBitmap(bitmap).build();
        Intrinsics.checkNotNullExpressionValue(requestBuild, "ofWindow(this)\n        .…tBitmap)\n        .build()");
        Consumer consumer = new Consumer() { // from class: androidx.test.core.view.ViewCapture$generateBitmapFromPixelCopy$4$onCopyFinished$1
            @Override // java.util.function.Consumer
            public /* bridge */ /* synthetic */ void accept(Object obj) {
                accept(AbstractC2561c.m2145r(obj));
            }

            public final void accept(PixelCopy.Result result) {
                if (result.getStatus() == 0) {
                    CancellableContinuation<Bitmap> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m22215constructorimpl(result.getBitmap()));
                } else {
                    CancellableContinuation<Bitmap> cancellableContinuation2 = cancellableContinuationImpl;
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation2.resumeWith(Result.m22215constructorimpl(ResultKt.createFailure(new RuntimeException("PixelCopy failed: $(result.status)"))));
                }
            }
        };
        Handler handler = view.getHandler();
        Intrinsics.checkNotNullExpressionValue(handler, "handler");
        PixelCopy.request(requestBuild, new HandlerExecutor(handler), consumer);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
