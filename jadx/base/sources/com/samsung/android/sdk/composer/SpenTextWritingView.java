package com.samsung.android.sdk.composer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.compose.runtime.AbstractC1974b;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.composer.document.capture.SpenNoteCapturePage;
import com.samsung.android.sdk.composer.input.SpenNoteObjectInserter;
import com.samsung.android.sdk.composer.writing.SpenNoteWritingViewManager;
import com.samsung.android.sdk.pen.control.ISpenControlObjectManager;
import com.samsung.android.sdk.pen.control.SpenControlObjectManager;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.engine.SpenColorPickerListener;
import com.samsung.android.sdk.pen.engine.SpenPenSound;
import com.samsung.android.sdk.pen.engine.SpenScrollBar;
import com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface;
import com.samsung.android.sdk.pen.engine.pointericon.SpenHoverPointerIcon;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.spen.libwrapper.MotionEventWrapper;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000Û\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f*\u00012\u0018\u0000 }2\u00020\u00012\u00020\u0002:\u0001}B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0010\u00108\u001a\u0002092\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u000e\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020<J\b\u0010=\u001a\u000209H\u0002J\b\u0010>\u001a\u000209H\u0002J\u0012\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u0002092\u0006\u0010\u0003\u001a\u00020\u0004H\u0014J\b\u0010D\u001a\u000209H\u0016J\b\u0010E\u001a\u000209H\u0014J\u0012\u0010F\u001a\u00020$2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u000e\u0010I\u001a\u0002092\u0006\u0010J\u001a\u00020\u000bJ\u000e\u0010K\u001a\u0002092\u0006\u0010L\u001a\u00020MJ\u000e\u0010N\u001a\u0002092\u0006\u0010O\u001a\u00020$J\b\u0010P\u001a\u000209H\u0014J\u0010\u0010Q\u001a\u0002092\u0006\u0010R\u001a\u00020$H\u0016J0\u0010S\u001a\u0002092\u0006\u0010T\u001a\u00020$2\u0006\u0010U\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u000bH\u0014J\u0010\u0010Y\u001a\u0002092\u0006\u0010Z\u001a\u00020[H\u0014J\b\u0010\\\u001a\u000209H\u0014J\b\u0010]\u001a\u00020$H\u0016J\b\u0010^\u001a\u00020_H\u0016J0\u0010`\u001a\u0002092\u0006\u0010T\u001a\u00020$2\u0006\u0010U\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u000bH\u0016J\u0010\u0010a\u001a\u00020$2\u0006\u0010b\u001a\u00020cH\u0016J\b\u0010d\u001a\u000209H\u0016J\u0006\u0010e\u001a\u000209J\b\u0010f\u001a\u000209H\u0002J\u0006\u0010g\u001a\u000209J\u0010\u0010h\u001a\u0002092\u0006\u0010i\u001a\u00020\u000bH\u0016J\u0010\u0010j\u001a\u0002092\u0006\u0010b\u001a\u00020cH\u0002J1\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00002\u0006\u0010n\u001a\u00020l2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020 H\u0082 J\u0011\u0010t\u001a\u0002092\u0006\u0010u\u001a\u00020lH\u0082 J\u0011\u0010v\u001a\u00020l2\u0006\u0010u\u001a\u00020lH\u0082 J\u0011\u0010w\u001a\u00020l2\u0006\u0010u\u001a\u00020lH\u0082 J\u0019\u0010x\u001a\u0002092\u0006\u0010u\u001a\u00020l2\u0006\u0010\u0013\u001a\u00020lH\u0082 J\u0019\u0010y\u001a\u0002092\u0006\u0010u\u001a\u00020l2\u0006\u0010z\u001a\u00020$H\u0082 J\u0011\u0010{\u001a\u0002092\u0006\u0010u\u001a\u00020lH\u0082 J\u0019\u0010|\u001a\u0002092\u0006\u0010u\u001a\u00020l2\u0006\u0010i\u001a\u00020\u000bH\u0082 R\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103R\u0014\u00104\u001a\u0002058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006~"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/SpenTextWritingView;", "Lcom/samsung/android/sdk/composer/SpenTextView;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "noteWritingViewManager", "Lcom/samsung/android/sdk/composer/writing/SpenNoteWritingViewManager;", "getNoteWritingViewManager", "()Lcom/samsung/android/sdk/composer/writing/SpenNoteWritingViewManager;", "setNoteWritingViewManager", "(Lcom/samsung/android/sdk/composer/writing/SpenNoteWritingViewManager;)V", "controlObjectManager", "Lcom/samsung/android/sdk/pen/control/SpenControlObjectManager;", "getControlObjectManager", "()Lcom/samsung/android/sdk/pen/control/SpenControlObjectManager;", "setControlObjectManager", "(Lcom/samsung/android/sdk/pen/control/SpenControlObjectManager;)V", "noteObjectInserter", "Lcom/samsung/android/sdk/composer/input/SpenNoteObjectInserter;", "getNoteObjectInserter", "()Lcom/samsung/android/sdk/composer/input/SpenNoteObjectInserter;", "setNoteObjectInserter", "(Lcom/samsung/android/sdk/composer/input/SpenNoteObjectInserter;)V", "spenPenSound", "Lcom/samsung/android/sdk/pen/engine/SpenPenSound;", "spenScrollBar", "Lcom/samsung/android/sdk/pen/engine/SpenScrollBar;", "mIsPenButtonEnabledAtActionDown", "", "mIsLazyUpdateStarted", "mIsLazyUpdateEndRequestLayout", "mLazyUpdatePreRect", "Landroid/graphics/Rect;", "mJob", "Lkotlinx/coroutines/CompletableJob;", "mLowQualityCacheBitmap", "Landroid/graphics/Bitmap;", "mCapture", "Lcom/samsung/android/sdk/composer/document/capture/SpenNoteCapturePage;", "mPaint", "Landroid/graphics/Paint;", "onScrollBarChangeListener", "com/samsung/android/sdk/composer/SpenTextWritingView$onScrollBarChangeListener$1", "Lcom/samsung/android/sdk/composer/SpenTextWritingView$onScrollBarChangeListener$1;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "initialize", "", "setColorPickerListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/engine/SpenColorPickerListener;", "initControlObjectManager", "initScrollBar", "getOwnerPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "obj", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "initNativeInstance", "close", "finalizeNativeInstance", "setDocument", "doc", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "setEditMode", "mode", "addPrivateImeSettings", "options", "", "setScrollBarEnabled", "enabled", "onAttachedToWindow", "onWindowFocusChanged", "hasWindowFocus", "onLayout", "changed", "left", "top", "right", "bottom", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onDetachedFromWindow", "isNativeHandleValid", "getView", "Landroid/view/ViewGroup;", "handleLayout", "handleTouch", "event", "Landroid/view/MotionEvent;", "handleZoom", "startLazyViewUpdate", "createLowQualityBitmap", "endLazyViewUpdate", "setBackgroundColor", "color", "convertMotionEventPenButtonAction", "Native_init", "", "view", "contextHandle", "drawLoop", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopInterface;", "hoverPointerIcon", "Lcom/samsung/android/sdk/pen/engine/pointericon/SpenHoverPointerIcon;", "penSound", "Native_finalize", "nativeHandle", "Native_getNoteWritingView", "Native_getNoteObjectInserter", "Native_setControlObjectManager", "Native_startLazyViewUpdate", "forceClear", "Native_endLazyViewUpdate", "Native_setBackgroundColor", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenTextWritingView extends SpenTextView implements CoroutineScope {

    @NotNull
    private static final String TAG = "SpenTextWritingView";
    public SpenControlObjectManager controlObjectManager;
    private SpenNoteCapturePage mCapture;
    private boolean mIsLazyUpdateEndRequestLayout;
    private boolean mIsLazyUpdateStarted;
    private boolean mIsPenButtonEnabledAtActionDown;

    @NotNull
    private final CompletableJob mJob;

    @NotNull
    private Rect mLazyUpdatePreRect;

    @Nullable
    private Bitmap mLowQualityCacheBitmap;

    @NotNull
    private final Paint mPaint;
    public SpenNoteObjectInserter noteObjectInserter;
    public SpenNoteWritingViewManager noteWritingViewManager;

    @NotNull
    private final SpenTextWritingView$onScrollBarChangeListener$1 onScrollBarChangeListener;
    private SpenPenSound spenPenSound;
    private SpenScrollBar spenScrollBar;

    /* JADX INFO: renamed from: com.samsung.android.sdk.composer.SpenTextWritingView$createLowQualityBitmap$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.sdk.composer.SpenTextWritingView$createLowQualityBitmap$1", m14021f = "SpenTextWritingView.kt", m14022i = {}, m14023l = {342}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C72511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C72511(Continuation<? super C72511> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SpenTextWritingView.this.new C72511(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SpenWNote mDocument = SpenTextWritingView.this.getMDocument();
                if (mDocument != null) {
                    SpenTextWritingView spenTextWritingView = SpenTextWritingView.this;
                    SpenNoteCapturePage spenNoteCapturePage = spenTextWritingView.mCapture;
                    if (spenNoteCapturePage == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCapture");
                        spenNoteCapturePage = null;
                    }
                    spenNoteCapturePage.setWNote(mDocument);
                    SpenNoteCapturePage spenNoteCapturePage2 = spenTextWritingView.mCapture;
                    if (spenNoteCapturePage2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCapture");
                        spenNoteCapturePage2 = null;
                    }
                    spenNoteCapturePage2.setContents(mDocument.getPage(0), mDocument.getBodyText(), 0);
                    SpenNoteCapturePage spenNoteCapturePage3 = spenTextWritingView.mCapture;
                    if (spenNoteCapturePage3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCapture");
                        spenNoteCapturePage3 = null;
                    }
                    spenNoteCapturePage3.setBackgroundColorEnabled(false);
                    SpenNoteCapturePage spenNoteCapturePage4 = spenTextWritingView.mCapture;
                    if (spenNoteCapturePage4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCapture");
                        spenNoteCapturePage4 = null;
                    }
                    spenNoteCapturePage4.setColorTheme(spenTextWritingView.getMSpenComposerContext().getMColorTheme());
                    RectF rectF = new RectF(0.0f, 0.0f, mDocument.getWidth(), mDocument.getHeight());
                    SpenNoteCapturePage spenNoteCapturePage5 = spenTextWritingView.mCapture;
                    if (spenNoteCapturePage5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCapture");
                        spenNoteCapturePage5 = null;
                    }
                    Bitmap bitmapCaptureRect = spenNoteCapturePage5.captureRect(rectF);
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    SpenTextWritingView$createLowQualityBitmap$1$1$1 spenTextWritingView$createLowQualityBitmap$1$1$1 = new SpenTextWritingView$createLowQualityBitmap$1$1$1(spenTextWritingView, bitmapCaptureRect, null);
                    this.label = 1;
                    if (BuildersKt.withContext(main, spenTextWritingView$createLowQualityBitmap$1$1$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C72511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.samsung.android.sdk.composer.SpenTextWritingView$onScrollBarChangeListener$1] */
    public SpenTextWritingView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLazyUpdatePreRect = new Rect();
        this.mJob = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.mPaint = new Paint(1);
        this.onScrollBarChangeListener = new SpenScrollBar.OnScrollBarChangedListener() { // from class: com.samsung.android.sdk.composer.SpenTextWritingView$onScrollBarChangeListener$1
            @Override // com.samsung.android.sdk.pen.engine.SpenScrollBar.OnScrollBarChangedListener
            public void onScrollHorizontal(PointF pointF) {
                SpenScrollBar.OnScrollBarChangedListener.DefaultImpls.onScrollHorizontal(this, pointF);
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenScrollBar.OnScrollBarChangedListener
            public void onScrollVertical(PointF position) {
                Intrinsics.checkNotNullParameter(position, "position");
                this.this$0.getMSpenNoteZoomScroller().setPan(position);
            }
        };
        initialize(context);
    }

    private final native void Native_endLazyViewUpdate(long nativeHandle);

    private final native void Native_finalize(long nativeHandle);

    private final native long Native_getNoteObjectInserter(long nativeHandle);

    private final native long Native_getNoteWritingView(long nativeHandle);

    private final native long Native_init(SpenTextWritingView view, long contextHandle, SpenDrawLoopInterface drawLoop, SpenHoverPointerIcon hoverPointerIcon, SpenPenSound penSound);

    private final native void Native_setBackgroundColor(long nativeHandle, int color);

    private final native void Native_setControlObjectManager(long nativeHandle, long controlObjectManager);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void Native_startLazyViewUpdate(long nativeHandle, boolean forceClear);

    private final void convertMotionEventPenButtonAction(MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            this.mIsPenButtonEnabledAtActionDown = event.getButtonState() == 32;
        }
        if (this.mIsPenButtonEnabledAtActionDown) {
            if (action == 0) {
                event.setAction(MotionEventWrapper.ACTION_PEN_DOWN);
                return;
            }
            if (action == 1) {
                event.setAction(MotionEventWrapper.ACTION_PEN_UP);
            } else if (action == 2) {
                event.setAction(MotionEventWrapper.ACTION_PEN_MOVE);
            } else {
                if (action != 3) {
                    return;
                }
                event.setAction(MotionEventWrapper.ACTION_PEN_CANCEL);
            }
        }
    }

    private final void createLowQualityBitmap() {
        BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getDefault(), null, new C72511(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SpenWPage getOwnerPage(SpenObjectBase obj) {
        SpenWNote mDocument = getMDocument();
        if (mDocument == null) {
            return null;
        }
        int pageCount = mDocument.getPageCount();
        for (int i = 0; i < pageCount; i++) {
            if (mDocument.getPage(i).isObjectContained(obj)) {
                return mDocument.getPage(i);
            }
        }
        return null;
    }

    private final void initControlObjectManager() {
        setControlObjectManager(new SpenControlObjectManager(getContext(), this));
        Native_setControlObjectManager(getMNativeHandle(), getControlObjectManager().getNativeHandle());
        getControlObjectManager().setControlActionListener(new ISpenControlObjectManager.ControlActionListener() { // from class: com.samsung.android.sdk.composer.SpenTextWritingView.initControlObjectManager.1
            @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager.ControlActionListener
            public boolean isFloatingViewShown() {
                return false;
            }

            @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager.ControlActionListener
            public void onRequestCoordinateInfo(ISpenControlObjectManager.CoordinateInfo coordinateInfo, SpenObjectBase objectBase) {
                PointF pointF = new PointF();
                if ((objectBase != null ? SpenTextWritingView.this.getOwnerPage(objectBase) : null) != null) {
                    pointF.set(r5.getOffset().x, r5.getOffset().y);
                }
                if (coordinateInfo != null) {
                    SpenTextWritingView spenTextWritingView = SpenTextWritingView.this;
                    coordinateInfo.zoomRatio = spenTextWritingView.getMSpenNoteZoomScroller().getContentScale() * spenTextWritingView.getMSpenNoteZoomScroller().getZoomScale();
                    PointF pan = spenTextWritingView.getMSpenNoteZoomScroller().getPan();
                    if (pan == null) {
                        pan = new PointF();
                    }
                    coordinateInfo.pan = pan;
                    PointF pointF2 = coordinateInfo.startPos;
                    float f = pointF.x;
                    float f4 = coordinateInfo.zoomRatio;
                    pointF2.set(f * f4, pointF.y * f4);
                }
            }

            @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager.ControlActionListener
            public void onRequestMoveIntoScreen(SpenObjectBase objectBase) {
                if (objectBase == null) {
                    return;
                }
                PointF pointF = new PointF();
                if (SpenTextWritingView.this.getOwnerPage(objectBase) != null) {
                    pointF.set(r1.getOffset().x, r1.getOffset().y);
                }
                RectF rect = objectBase.getRect();
                rect.offset(pointF.x, pointF.y);
                SpenTextWritingView.this.getMSpenNoteZoomScroller().scrollToContentRect(rect);
            }

            @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager.ControlActionListener
            public void onRequestSelectObject(SpenObjectBase objectBase) {
                SpenWNote mDocument;
                if (SpenTextWritingView.this.getMDocument() != null) {
                    SpenWNote mDocument2 = SpenTextWritingView.this.getMDocument();
                    ArrayList<SpenObjectBase> selectedObject = mDocument2 != null ? mDocument2.getSelectedObject() : null;
                    if (selectedObject != null && selectedObject.size() > 0 && (mDocument = SpenTextWritingView.this.getMDocument()) != null) {
                        Intrinsics.checkNotNull(null, "null cannot be cast to non-null type java.util.ArrayList<com.samsung.android.sdk.pen.document.SpenObjectBase>");
                        mDocument.selectObject((ArrayList<SpenObjectBase>) null);
                    }
                    SpenWNote mDocument3 = SpenTextWritingView.this.getMDocument();
                    if (mDocument3 != null) {
                        mDocument3.selectObject(objectBase);
                    }
                }
            }
        });
    }

    private final void initScrollBar() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SpenScrollBar spenScrollBar = new SpenScrollBar(context);
        this.spenScrollBar = spenScrollBar;
        spenScrollBar.enableScroll(true);
        SpenScrollBar spenScrollBar2 = this.spenScrollBar;
        SpenScrollBar spenScrollBar3 = null;
        if (spenScrollBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spenScrollBar");
            spenScrollBar2 = null;
        }
        spenScrollBar2.enableVerticalScroll(true);
        SpenScrollBar spenScrollBar4 = this.spenScrollBar;
        if (spenScrollBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spenScrollBar");
            spenScrollBar4 = null;
        }
        spenScrollBar4.enableHorizontalScroll(false);
        SpenScrollBar spenScrollBar5 = this.spenScrollBar;
        if (spenScrollBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spenScrollBar");
            spenScrollBar5 = null;
        }
        spenScrollBar5.setOnScrollBarChangeListener(this.onScrollBarChangeListener);
        SpenScrollBar spenScrollBar6 = this.spenScrollBar;
        if (spenScrollBar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spenScrollBar");
        } else {
            spenScrollBar3 = spenScrollBar6;
        }
        addView(spenScrollBar3);
    }

    private final void initialize(Context context) {
        long jNative_getNoteWritingView = Native_getNoteWritingView(getMNativeHandle());
        SpenDisplay mSpenDisplay = getMSpenDisplay();
        SpenPenSound spenPenSound = this.spenPenSound;
        if (spenPenSound == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spenPenSound");
            spenPenSound = null;
        }
        setNoteWritingViewManager(new SpenNoteWritingViewManager(context, this, jNative_getNoteWritingView, mSpenDisplay, spenPenSound));
        getNoteWritingViewManager().setFrontBufferRenderingEnabled(true, new boolean[0]);
        getNoteWritingViewManager().setPredictionEnabled(true, new boolean[0]);
        initControlObjectManager();
        setNoteObjectInserter(new SpenNoteObjectInserter());
        getNoteObjectInserter().setNativeHandle(Native_getNoteObjectInserter(getMNativeHandle()));
        initScrollBar();
        this.mCapture = new SpenNoteCapturePage(context);
    }

    public final void addPrivateImeSettings(@NotNull String options) {
        Intrinsics.checkNotNullParameter(options, "options");
        Log.i(TAG, "addPrivateImeSettings : " + options);
        getMNoteTextManager().addPrivateImeSettings(options);
    }

    @Override // com.samsung.android.sdk.composer.SpenTextView, com.samsung.android.sdk.composer.SpenZoomScrollView
    public void close() {
        Log.i(TAG, "TextWritingView::close - " + System.identityHashCode(this));
        getNoteWritingViewManager().close();
        SpenPenSound spenPenSound = this.spenPenSound;
        if (spenPenSound == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spenPenSound");
            spenPenSound = null;
        }
        spenPenSound.close();
        SpenScrollBar spenScrollBar = this.spenScrollBar;
        if (spenScrollBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spenScrollBar");
            spenScrollBar = null;
        }
        spenScrollBar.close();
        getControlObjectManager().close();
        getControlObjectManager().setControlActionListener(null);
        super.close();
    }

    public final void endLazyViewUpdate() {
        if (getMNativeHandle() == 0) {
            return;
        }
        this.mIsLazyUpdateStarted = false;
        Bitmap bitmap = this.mLowQualityCacheBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.mLowQualityCacheBitmap = null;
        Native_endLazyViewUpdate(getMNativeHandle());
        this.mIsLazyUpdateEndRequestLayout = true;
        requestLayout();
        invalidate();
    }

    @Override // com.samsung.android.sdk.composer.SpenTextView
    public void finalizeNativeInstance() {
        Native_finalize(getMNativeHandle());
    }

    @NotNull
    public final SpenControlObjectManager getControlObjectManager() {
        SpenControlObjectManager spenControlObjectManager = this.controlObjectManager;
        if (spenControlObjectManager != null) {
            return spenControlObjectManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("controlObjectManager");
        return null;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return Dispatchers.getMain().plus(this.mJob);
    }

    @NotNull
    public final SpenNoteObjectInserter getNoteObjectInserter() {
        SpenNoteObjectInserter spenNoteObjectInserter = this.noteObjectInserter;
        if (spenNoteObjectInserter != null) {
            return spenNoteObjectInserter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("noteObjectInserter");
        return null;
    }

    @NotNull
    public final SpenNoteWritingViewManager getNoteWritingViewManager() {
        SpenNoteWritingViewManager spenNoteWritingViewManager = this.noteWritingViewManager;
        if (spenNoteWritingViewManager != null) {
            return spenNoteWritingViewManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("noteWritingViewManager");
        return null;
    }

    @Override // com.samsung.android.sdk.composer.SpenTextView, com.samsung.android.sdk.composer.SpenZoomScrollView
    @NotNull
    public ViewGroup getView() {
        return this;
    }

    @Override // com.samsung.android.sdk.composer.SpenTextView, com.samsung.android.sdk.composer.SpenZoomScrollView
    public void handleLayout(boolean changed, int left, int top, int right, int bottom) {
        super.handleLayout(changed, left, top, right, bottom);
        getNoteWritingViewManager().onLayout(changed, left, top, right, bottom);
        getControlObjectManager().setScreenSize(getMScreenWidth(), getMScreenHeight());
        SpenScrollBar spenScrollBar = this.spenScrollBar;
        if (spenScrollBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spenScrollBar");
            spenScrollBar = null;
        }
        spenScrollBar.setScreenSize(getMScreenWidth(), getMScreenHeight());
    }

    @Override // com.samsung.android.sdk.composer.SpenTextView, com.samsung.android.sdk.composer.SpenZoomScrollView
    public boolean handleTouch(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Build.VERSION.SDK_INT >= 34) {
            convertMotionEventPenButtonAction(event);
        }
        if (event.getActionMasked() == 0) {
            if (getNoteWritingViewManager().getSpenLatencyConfiguration().checkAndUpdateUnbufferedDispatch()) {
                requestUnbufferedDispatch(event);
            }
            int historySize = event.getHistorySize();
            for (int i = 0; i < historySize; i++) {
                Log.i(TAG, "[JavaGesture] TextWritingView index : " + i + " , down time : " + event.getDownTime() + " , eventTime : " + event.getHistoricalEventTime(i));
            }
            long downTime = event.getDownTime();
            long eventTime = event.getEventTime();
            StringBuilder sbM1323p = AbstractC1974b.m1323p(downTime, "[JavaGesture] TextWritingView down time : ", ", eventTime : ");
            sbM1323p.append(eventTime);
            Log.i(TAG, sbM1323p.toString());
        }
        int toolTypeAction = getNoteWritingViewManager().getToolTypeAction(event.getToolType(0));
        SpenPenSound spenPenSound = this.spenPenSound;
        if (spenPenSound == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spenPenSound");
            spenPenSound = null;
        }
        spenPenSound.onTouch(event, toolTypeAction);
        getControlObjectManager().onTouch(event);
        return super.handleTouch(event);
    }

    @Override // com.samsung.android.sdk.composer.SpenTextView
    public void handleZoom() {
        PointF delta = getMSpenNoteZoomScroller().getDelta();
        float contentWidth = getMSpenNoteZoomScroller().getContentWidth() - getMScreenWidth();
        float contentHeight = getMSpenNoteZoomScroller().getContentHeight() - getMScreenHeight();
        float contentWidth2 = getMSpenNoteZoomScroller().getContentWidth() * getMSpenNoteZoomScroller().getZoomScale() * getMSpenNoteZoomScroller().getContentScale();
        float contentHeight2 = getMSpenNoteZoomScroller().getContentHeight() * getMSpenNoteZoomScroller().getZoomScale() * getMSpenNoteZoomScroller().getContentScale();
        if (delta != null) {
            SpenScrollBar spenScrollBar = this.spenScrollBar;
            if (spenScrollBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("spenScrollBar");
                spenScrollBar = null;
            }
            spenScrollBar.setDeltaValue(delta.x, delta.y, contentWidth, contentHeight, (int) contentWidth2, (int) contentHeight2);
        }
    }

    @Override // com.samsung.android.sdk.composer.SpenTextView
    public void initNativeInstance(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.spenPenSound = new SpenPenSound(context);
        long handle = getMSpenComposerContext().getHandle();
        SpenDrawLoopInterface mSpenDrawLoop = getMSpenDrawLoop();
        SpenHoverPointerIcon mHoverPointerIcon = getMHoverPointerIcon();
        SpenPenSound spenPenSound = this.spenPenSound;
        if (spenPenSound == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spenPenSound");
            spenPenSound = null;
        }
        setMNativeHandle(Native_init(this, handle, mSpenDrawLoop, mHoverPointerIcon, spenPenSound));
    }

    @Override // com.samsung.android.sdk.composer.SpenTextView, com.samsung.android.sdk.composer.SpenZoomScrollView
    public boolean isNativeHandleValid() {
        return getMNativeHandle() != 0;
    }

    @Override // com.samsung.android.sdk.composer.SpenTextView, com.samsung.android.sdk.composer.SpenZoomScrollView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isNativeHandleValid() || this.noteWritingViewManager == null) {
            return;
        }
        Log.i(TAG, "TextWritingView onAttatchedToWindow");
        getNoteWritingViewManager().onAttachedToWindow();
    }

    @Override // com.samsung.android.sdk.composer.SpenTextView, com.samsung.android.sdk.composer.SpenZoomScrollView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Job.DefaultImpls.cancel$default((Job) this.mJob, (CancellationException) null, 1, (Object) null);
    }

    @Override // com.samsung.android.sdk.composer.SpenTextView, com.samsung.android.sdk.composer.SpenZoomScrollView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!this.mIsLazyUpdateStarted || (bitmap = this.mLowQualityCacheBitmap) == null) {
            super.onDraw(canvas);
            return;
        }
        PointF pan = getMSpenNoteZoomScroller().getPan();
        if (pan != null) {
            canvas.drawBitmap(bitmap, 0.0f, -pan.y, this.mPaint);
        }
    }

    @Override // com.samsung.android.sdk.composer.SpenZoomScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (this.mIsLazyUpdateStarted) {
            return;
        }
        if (this.mIsLazyUpdateEndRequestLayout) {
            if (!Intrinsics.areEqual(new Rect(left, top, right, bottom), this.mLazyUpdatePreRect)) {
                changed = true;
            }
            this.mIsLazyUpdateEndRequestLayout = false;
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override // com.samsung.android.sdk.composer.SpenTextView, com.samsung.android.sdk.composer.SpenZoomScrollView, android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        getMNoteTextManager().onWindowFocusChanged(hasWindowFocus);
        if (this.spenPenSound == null) {
            return;
        }
        SpenPenSound spenPenSound = null;
        if (hasWindowFocus) {
            Log.d(TAG, "onWindowFocusChanged() - hasWindowFocus : true");
            SpenPenSound spenPenSound2 = this.spenPenSound;
            if (spenPenSound2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("spenPenSound");
            } else {
                spenPenSound = spenPenSound2;
            }
            spenPenSound.registerPenSoundSolution();
            return;
        }
        Log.d(TAG, "onWindowFocusChanged() - hasWindowFocus : false");
        SpenPenSound spenPenSound3 = this.spenPenSound;
        if (spenPenSound3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spenPenSound");
        } else {
            spenPenSound = spenPenSound3;
        }
        spenPenSound.unregisterPenSoundSolution();
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        if (getMNativeHandle() == 0) {
            return;
        }
        Native_setBackgroundColor(getMNativeHandle(), color);
    }

    public final void setColorPickerListener(@NotNull SpenColorPickerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getNoteWritingViewManager().setColorPickerListener(listener);
    }

    public final void setControlObjectManager(@NotNull SpenControlObjectManager spenControlObjectManager) {
        Intrinsics.checkNotNullParameter(spenControlObjectManager, "<set-?>");
        this.controlObjectManager = spenControlObjectManager;
    }

    @Override // com.samsung.android.sdk.composer.SpenTextView
    public boolean setDocument(@Nullable SpenWNote doc) {
        Log.i(TAG, "TextWritingView::setDocument" + doc);
        boolean document = super.setDocument(doc);
        getNoteWritingViewManager().setMinZoomScale(1.0f);
        getNoteWritingViewManager().setDocument(getMDocument());
        if (getMDocument() != null) {
            SpenPenSound spenPenSound = this.spenPenSound;
            if (spenPenSound == null) {
                Intrinsics.throwUninitializedPropertyAccessException("spenPenSound");
                spenPenSound = null;
            }
            spenPenSound.registerPenSoundSolution();
        }
        return document;
    }

    public final void setEditMode(int mode) {
        getMSpenComposerContext().setEditMode(mode);
    }

    public final void setNoteObjectInserter(@NotNull SpenNoteObjectInserter spenNoteObjectInserter) {
        Intrinsics.checkNotNullParameter(spenNoteObjectInserter, "<set-?>");
        this.noteObjectInserter = spenNoteObjectInserter;
    }

    public final void setNoteWritingViewManager(@NotNull SpenNoteWritingViewManager spenNoteWritingViewManager) {
        Intrinsics.checkNotNullParameter(spenNoteWritingViewManager, "<set-?>");
        this.noteWritingViewManager = spenNoteWritingViewManager;
    }

    public final void setScrollBarEnabled(boolean enabled) {
        SpenScrollBar spenScrollBar = this.spenScrollBar;
        if (spenScrollBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spenScrollBar");
            spenScrollBar = null;
        }
        spenScrollBar.enableScroll(enabled);
    }

    public final void startLazyViewUpdate() {
        if (getMNativeHandle() == 0 || this.mIsLazyUpdateStarted) {
            return;
        }
        this.mIsLazyUpdateStarted = true;
        this.mLazyUpdatePreRect = new Rect(getLeft(), getTop(), getRight(), getBottom());
        createLowQualityBitmap();
        Native_startLazyViewUpdate(getMNativeHandle(), false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.samsung.android.sdk.composer.SpenTextWritingView$onScrollBarChangeListener$1] */
    public SpenTextWritingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLazyUpdatePreRect = new Rect();
        this.mJob = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.mPaint = new Paint(1);
        this.onScrollBarChangeListener = new SpenScrollBar.OnScrollBarChangedListener() { // from class: com.samsung.android.sdk.composer.SpenTextWritingView$onScrollBarChangeListener$1
            @Override // com.samsung.android.sdk.pen.engine.SpenScrollBar.OnScrollBarChangedListener
            public void onScrollHorizontal(PointF pointF) {
                SpenScrollBar.OnScrollBarChangedListener.DefaultImpls.onScrollHorizontal(this, pointF);
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenScrollBar.OnScrollBarChangedListener
            public void onScrollVertical(PointF position) {
                Intrinsics.checkNotNullParameter(position, "position");
                this.this$0.getMSpenNoteZoomScroller().setPan(position);
            }
        };
        initialize(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.samsung.android.sdk.composer.SpenTextWritingView$onScrollBarChangeListener$1] */
    public SpenTextWritingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLazyUpdatePreRect = new Rect();
        this.mJob = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.mPaint = new Paint(1);
        this.onScrollBarChangeListener = new SpenScrollBar.OnScrollBarChangedListener() { // from class: com.samsung.android.sdk.composer.SpenTextWritingView$onScrollBarChangeListener$1
            @Override // com.samsung.android.sdk.pen.engine.SpenScrollBar.OnScrollBarChangedListener
            public void onScrollHorizontal(PointF pointF) {
                SpenScrollBar.OnScrollBarChangedListener.DefaultImpls.onScrollHorizontal(this, pointF);
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenScrollBar.OnScrollBarChangedListener
            public void onScrollVertical(PointF position) {
                Intrinsics.checkNotNullParameter(position, "position");
                this.this$0.getMSpenNoteZoomScroller().setPan(position);
            }
        };
        initialize(context);
    }
}
