package com.samsung.android.support.senl.docscan.rectify.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.samsung.android.support.senl.docscan.C7976R;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.docscan.common.util.DocScanUtils;
import com.samsung.android.support.senl.docscan.rectify.presenter.RectifyEditPresenter;
import com.samsung.android.support.senl.docscan.rectify.view.RectifyImageView;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p122b2.RunnableC4199v;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 P2\u00020\u0001:\u0001PB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003J\u0010\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010\u0013J\u0010\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)J\u001a\u0010'\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010\u001e2\b\u0010(\u001a\u0004\u0018\u00010)J\u0012\u0010+\u001a\u00020$2\b\u0010,\u001a\u0004\u0018\u00010\u001eH\u0002J\u001d\u0010-\u001a\u00020$2\u0010\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f¢\u0006\u0002\u0010/J0\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\nH\u0014J\u001b\u00106\u001a\u00020$2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0002\u0010/J \u00106\u001a\u00020$2\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020 H\u0002J\u0018\u0010;\u001a\u00020$2\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\u0010H\u0002J\u0018\u0010<\u001a\u00020$2\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\u0010H\u0002J\u0018\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u0010H\u0002J\u0018\u0010?\u001a\u00020 2\u0006\u0010>\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u0010H\u0002J\b\u0010@\u001a\u00020$H\u0002J\b\u0010A\u001a\u00020$H\u0002J\b\u0010B\u001a\u00020$H\u0002J \u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020FH\u0002J\u0010\u0010H\u001a\u00020$2\u0006\u0010D\u001a\u00020\nH\u0002J\b\u0010I\u001a\u00020$H\u0002J\u0010\u0010J\u001a\u00020$2\u0006\u0010D\u001a\u00020\nH\u0002J\b\u0010K\u001a\u00020$H\u0002J\b\u0010L\u001a\u00020$H\u0002J\b\u0010?\u001a\u00020$H\u0002J\u0014\u0010M\u001a\u00020$2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010OH\u0002R\u0018\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Q"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/rectify/view/RectifyOverlayView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "DEFAULT_HANDLE_VERTEX", "", "Landroid/graphics/PointF;", "[Landroid/graphics/PointF;", "mPresenter", "Lcom/samsung/android/support/senl/docscan/rectify/presenter/RectifyEditPresenter;", "mContainer", "Landroid/view/View;", "mHandlers", "Lcom/samsung/android/support/senl/docscan/rectify/view/RectifyHandlerView;", "[Lcom/samsung/android/support/senl/docscan/rectify/view/RectifyHandlerView;", "mImageView", "Lcom/samsung/android/support/senl/docscan/rectify/view/RectifyImageView;", "mHandlerPreview", "Lcom/samsung/android/support/senl/docscan/rectify/view/RectifyHandlerPreview;", "mPreview", "Landroid/graphics/Bitmap;", "mIsPreviewLeft", "", "mOnTouchListener", "Landroid/view/View$OnTouchListener;", "init", "", "initialize", "presenter", "setImagePath", DBSchema.DocumentThumbnail.IMAGE_PATH, "", "imageBitmap", "setImageBitmap", "bitmap", "setHandlePosition", "handlePositions", "([Landroid/graphics/PointF;)V", "onLayout", "changed", "left", "top", "right", "bottom", "movePosition", "posList", "targetIdx", "pos", "isHandlerTouched", "initHandlerPreview", "updateHandlerPreview", "updateHandlerPreviewImage", "targetView", "updateHandlerPreviewPosition", "updateHandlerPreviewContainer", "initHandler", "loadHandlerPosition", "setHandlerPosition", "idx", "x", "", "y", "scaleUpHandler", "scaleDownHandlers", "scaleDownHandler", "reDrawHandlerPreview", "showHandlerPreview", "dismissHandlerPreview", "withEndAction", "Ljava/lang/Runnable;", "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRectifyOverlayView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RectifyOverlayView.kt\ncom/samsung/android/support/senl/docscan/rectify/view/RectifyOverlayView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,385:1\n1#2:386\n*E\n"})
public final class RectifyOverlayView extends FrameLayout {

    @NotNull
    private static final String TAG = "RectifyOverlayView";

    @NotNull
    private final PointF[] DEFAULT_HANDLE_VERTEX;
    private View mContainer;

    @Nullable
    private RectifyHandlerPreview mHandlerPreview;

    @Nullable
    private RectifyHandlerView[] mHandlers;
    private RectifyImageView mImageView;
    private boolean mIsPreviewLeft;

    @NotNull
    private final View.OnTouchListener mOnTouchListener;

    @Nullable
    private RectifyEditPresenter mPresenter;

    @Nullable
    private Bitmap mPreview;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RectifyOverlayView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.DEFAULT_HANDLE_VERTEX = new PointF[]{new PointF(0.0f, 0.0f), new PointF(1.0f, 0.0f), new PointF(1.0f, 1.0f), new PointF(0.0f, 1.0f)};
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.support.senl.docscan.rectify.view.RectifyOverlayView$mOnTouchListener$1
            private PointF startPos;
            private int target = -2;

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View v, MotionEvent event) {
                Intrinsics.checkNotNullParameter(v, "v");
                Intrinsics.checkNotNullParameter(event, "event");
                PointF pointF = new PointF(event.getX() + v.getX(), event.getY() + v.getY());
                RectifyEditPresenter rectifyEditPresenter = this.this$0.mPresenter;
                Intrinsics.checkNotNull(rectifyEditPresenter);
                PointF[] realPositionListFromRatio = rectifyEditPresenter.getRealPositionListFromRatio();
                RectifyEditPresenter rectifyEditPresenter2 = this.this$0.mPresenter;
                Intrinsics.checkNotNull(rectifyEditPresenter2);
                rectifyEditPresenter2.setDelta(pointF);
                RectifyEditPresenter rectifyEditPresenter3 = this.this$0.mPresenter;
                Intrinsics.checkNotNull(rectifyEditPresenter3);
                int numOfAngle = rectifyEditPresenter3.getNumOfAngle();
                int action = event.getAction();
                if (action == 0) {
                    RectifyEditPresenter rectifyEditPresenter4 = this.this$0.mPresenter;
                    Intrinsics.checkNotNull(rectifyEditPresenter4);
                    int touchedObject = rectifyEditPresenter4.getTouchedObject(pointF, realPositionListFromRatio);
                    this.target = touchedObject;
                    if (touchedObject == -2) {
                        Logger.m7145d("RectifyOverlayView", "onTouch# ACTION_DOWN outside");
                        return true;
                    }
                    if (touchedObject == -1) {
                        Logger.m7145d("RectifyOverlayView", "onTouch# ACTION_DOWN inside");
                    } else {
                        Logger.m7145d("RectifyOverlayView", "onTouch# ACTION_DOWN " + touchedObject);
                        if (this.target < numOfAngle) {
                            PointF pointF2 = realPositionListFromRatio[this.target];
                            this.startPos = new PointF(pointF2.x, pointF2.y);
                            this.this$0.scaleUpHandler(this.target);
                            RectifyOverlayView rectifyOverlayView = this.this$0;
                            int i = this.target;
                            PointF pointF3 = this.startPos;
                            Intrinsics.checkNotNull(pointF3);
                            rectifyOverlayView.initHandlerPreview(i, pointF3);
                        }
                    }
                } else if (action == 1) {
                    int i2 = this.target;
                    if (i2 != -1 && i2 != -2) {
                        this.this$0.initHandler();
                    }
                } else {
                    if (action != 2) {
                        return false;
                    }
                    int i4 = this.target;
                    if (i4 == -2) {
                        return true;
                    }
                    if (i4 == -1) {
                        RectifyEditPresenter rectifyEditPresenter5 = this.this$0.mPresenter;
                        Intrinsics.checkNotNull(rectifyEditPresenter5);
                        if (!rectifyEditPresenter5.canMoveAllPosition((PointF[]) Arrays.copyOf(realPositionListFromRatio, realPositionListFromRatio.length))) {
                            return false;
                        }
                        this.this$0.movePosition(realPositionListFromRatio);
                    } else if (i4 < numOfAngle) {
                        PointF pointF4 = realPositionListFromRatio[this.target];
                        PointF pointF5 = new PointF(pointF4.x, pointF4.y);
                        RectifyEditPresenter rectifyEditPresenter6 = this.this$0.mPresenter;
                        Intrinsics.checkNotNull(rectifyEditPresenter6);
                        int i5 = this.target;
                        PointF pointF6 = this.startPos;
                        Intrinsics.checkNotNull(pointF6);
                        if (!rectifyEditPresenter6.canMovePosition(i5, pointF6, pointF5, realPositionListFromRatio)) {
                            return false;
                        }
                        this.this$0.movePosition(this.target, pointF5, true);
                    } else if (i4 < numOfAngle * 2) {
                        RectifyEditPresenter rectifyEditPresenter7 = this.this$0.mPresenter;
                        Intrinsics.checkNotNull(rectifyEditPresenter7);
                        if (!rectifyEditPresenter7.canMoveLine(i4 - numOfAngle, realPositionListFromRatio)) {
                            return false;
                        }
                        this.this$0.movePosition(realPositionListFromRatio);
                    }
                    RectifyImageView rectifyImageView = this.this$0.mImageView;
                    if (rectifyImageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mImageView");
                        rectifyImageView = null;
                    }
                    rectifyImageView.invalidate();
                }
                return true;
            }
        };
        init(context);
    }

    private final void dismissHandlerPreview(Runnable withEndAction) {
        Logger.m7145d(TAG, "dismissHandlerPreview# ");
        RectifyHandlerPreview rectifyHandlerPreview = this.mHandlerPreview;
        Intrinsics.checkNotNull(rectifyHandlerPreview);
        rectifyHandlerPreview.animate().scaleX(0.0f).scaleY(0.0f).withEndAction(new RunnableC4199v(this, withEndAction, 15)).setDuration(100L).start();
    }

    public static /* synthetic */ void dismissHandlerPreview$default(RectifyOverlayView rectifyOverlayView, Runnable runnable, int i, Object obj) {
        if ((i & 1) != 0) {
            runnable = null;
        }
        rectifyOverlayView.dismissHandlerPreview(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismissHandlerPreview$lambda$5(RectifyOverlayView rectifyOverlayView, Runnable runnable) {
        RectifyHandlerPreview rectifyHandlerPreview = rectifyOverlayView.mHandlerPreview;
        Intrinsics.checkNotNull(rectifyHandlerPreview);
        rectifyHandlerPreview.setVisibility(8);
        if (runnable != null) {
            runnable.run();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void init(Context context) {
        LayoutInflater.from(context).inflate(C7976R.layout.rectify_overlay_view, (ViewGroup) this, true);
        View viewFindViewById = findViewById(C7976R.id.image_view_container);
        this.mContainer = viewFindViewById;
        RectifyImageView rectifyImageView = null;
        if (viewFindViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            viewFindViewById = null;
        }
        viewFindViewById.setOnTouchListener(this.mOnTouchListener);
        RectifyImageView rectifyImageView2 = (RectifyImageView) findViewById(C7976R.id.image_view);
        this.mImageView = rectifyImageView2;
        if (rectifyImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
        } else {
            rectifyImageView = rectifyImageView2;
        }
        rectifyImageView.setContract(new RectifyImageView.Contract() { // from class: com.samsung.android.support.senl.docscan.rectify.view.RectifyOverlayView.init.1
            @Override // com.samsung.android.support.senl.docscan.rectify.view.RectifyImageView.Contract
            public int getNumOfAngle() {
                if (RectifyOverlayView.this.mPresenter == null) {
                    return 4;
                }
                RectifyEditPresenter rectifyEditPresenter = RectifyOverlayView.this.mPresenter;
                Intrinsics.checkNotNull(rectifyEditPresenter);
                return rectifyEditPresenter.getNumOfAngle();
            }

            @Override // com.samsung.android.support.senl.docscan.rectify.view.RectifyImageView.Contract
            public PointF getVertexFromIndex(int index) {
                RectifyEditPresenter rectifyEditPresenter = RectifyOverlayView.this.mPresenter;
                Intrinsics.checkNotNull(rectifyEditPresenter);
                return rectifyEditPresenter.getVertex(index);
            }

            @Override // com.samsung.android.support.senl.docscan.rectify.view.RectifyImageView.Contract
            public void onLayout() {
                RectifyEditPresenter rectifyEditPresenter = RectifyOverlayView.this.mPresenter;
                Intrinsics.checkNotNull(rectifyEditPresenter);
                RectifyImageView rectifyImageView3 = RectifyOverlayView.this.mImageView;
                RectifyImageView rectifyImageView4 = null;
                if (rectifyImageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mImageView");
                    rectifyImageView3 = null;
                }
                rectifyEditPresenter.setImageX(rectifyImageView3.getX());
                RectifyEditPresenter rectifyEditPresenter2 = RectifyOverlayView.this.mPresenter;
                Intrinsics.checkNotNull(rectifyEditPresenter2);
                RectifyImageView rectifyImageView5 = RectifyOverlayView.this.mImageView;
                if (rectifyImageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mImageView");
                } else {
                    rectifyImageView4 = rectifyImageView5;
                }
                rectifyEditPresenter2.setImageY(rectifyImageView4.getY());
            }

            @Override // com.samsung.android.support.senl.docscan.rectify.view.RectifyImageView.Contract
            public void onMeasured(float width, float height) {
                RectifyEditPresenter rectifyEditPresenter = RectifyOverlayView.this.mPresenter;
                Intrinsics.checkNotNull(rectifyEditPresenter);
                rectifyEditPresenter.setImageWidth(width);
                RectifyEditPresenter rectifyEditPresenter2 = RectifyOverlayView.this.mPresenter;
                Intrinsics.checkNotNull(rectifyEditPresenter2);
                rectifyEditPresenter2.setImageHeight(height);
            }
        });
        this.mHandlerPreview = (RectifyHandlerPreview) findViewById(C7976R.id.rectify_handler_preview);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initHandler() {
        loadHandlerPosition();
        scaleDownHandlers();
        dismissHandlerPreview$default(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initHandlerPreview(int targetIdx, PointF pos) {
        RectifyHandlerView[] rectifyHandlerViewArr = this.mHandlers;
        Intrinsics.checkNotNull(rectifyHandlerViewArr);
        RectifyHandlerView rectifyHandlerView = rectifyHandlerViewArr[targetIdx];
        Intrinsics.checkNotNull(rectifyHandlerView);
        View viewFindViewById = rectifyHandlerView.findViewById(C7976R.id.handler_view);
        Intrinsics.checkNotNull(viewFindViewById);
        updateHandlerPreviewImage(viewFindViewById, pos);
        updateHandlerPreviewPosition(viewFindViewById, pos);
        showHandlerPreview();
    }

    private final void loadHandlerPosition() {
        RectifyEditPresenter rectifyEditPresenter = this.mPresenter;
        Intrinsics.checkNotNull(rectifyEditPresenter);
        rectifyEditPresenter.sortVertexList();
        RectifyEditPresenter rectifyEditPresenter2 = this.mPresenter;
        Intrinsics.checkNotNull(rectifyEditPresenter2);
        PointF[] realPositionListFromRatio = rectifyEditPresenter2.getRealPositionListFromRatio();
        RectifyEditPresenter rectifyEditPresenter3 = this.mPresenter;
        Intrinsics.checkNotNull(rectifyEditPresenter3);
        int numOfAngle = rectifyEditPresenter3.getNumOfAngle();
        for (int i = 0; i < numOfAngle; i++) {
            PointF pointF = realPositionListFromRatio[i];
            setHandlerPosition(i, pointF.x, pointF.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void movePosition(PointF[] posList) {
        int length = posList.length;
        for (int i = 0; i < length; i++) {
            movePosition(i, posList[i], false);
        }
    }

    private final void reDrawHandlerPreview() {
        dismissHandlerPreview(new RunnableC7989a(this, 0));
    }

    private final void scaleDownHandler(int idx) {
        RectifyHandlerView[] rectifyHandlerViewArr = this.mHandlers;
        Intrinsics.checkNotNull(rectifyHandlerViewArr);
        if (rectifyHandlerViewArr[idx] == null) {
            return;
        }
        RectifyHandlerView[] rectifyHandlerViewArr2 = this.mHandlers;
        Intrinsics.checkNotNull(rectifyHandlerViewArr2);
        RectifyHandlerView rectifyHandlerView = rectifyHandlerViewArr2[idx];
        Intrinsics.checkNotNull(rectifyHandlerView);
        rectifyHandlerView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100L).start();
    }

    private final void scaleDownHandlers() {
        RectifyEditPresenter rectifyEditPresenter = this.mPresenter;
        Intrinsics.checkNotNull(rectifyEditPresenter);
        int numOfAngle = rectifyEditPresenter.getNumOfAngle();
        for (int i = 0; i < numOfAngle; i++) {
            scaleDownHandler(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scaleUpHandler(int idx) {
        RectifyHandlerView[] rectifyHandlerViewArr = this.mHandlers;
        Intrinsics.checkNotNull(rectifyHandlerViewArr);
        if (rectifyHandlerViewArr[idx] == null) {
            return;
        }
        RectifyHandlerView[] rectifyHandlerViewArr2 = this.mHandlers;
        Intrinsics.checkNotNull(rectifyHandlerViewArr2);
        RectifyHandlerView rectifyHandlerView = rectifyHandlerViewArr2[idx];
        Intrinsics.checkNotNull(rectifyHandlerView);
        rectifyHandlerView.animate().scaleX(1.5f).scaleY(1.5f).setDuration(100L).start();
    }

    private final void setHandlerPosition(final int idx, final float x, final float y2) {
        RectifyHandlerView[] rectifyHandlerViewArr = this.mHandlers;
        Intrinsics.checkNotNull(rectifyHandlerViewArr);
        if (rectifyHandlerViewArr[idx] == null) {
            return;
        }
        RectifyHandlerView[] rectifyHandlerViewArr2 = this.mHandlers;
        Intrinsics.checkNotNull(rectifyHandlerViewArr2);
        RectifyHandlerView rectifyHandlerView = rectifyHandlerViewArr2[idx];
        Intrinsics.checkNotNull(rectifyHandlerView);
        rectifyHandlerView.post(new Runnable() { // from class: com.samsung.android.support.senl.docscan.rectify.view.b
            @Override // java.lang.Runnable
            public final void run() {
                RectifyOverlayView.setHandlerPosition$lambda$1(this.f5896a, idx, x, y2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setHandlerPosition$lambda$1(RectifyOverlayView rectifyOverlayView, int i, float f, float f4) {
        RectifyHandlerView[] rectifyHandlerViewArr = rectifyOverlayView.mHandlers;
        Intrinsics.checkNotNull(rectifyHandlerViewArr);
        RectifyHandlerView rectifyHandlerView = rectifyHandlerViewArr[i];
        Intrinsics.checkNotNull(rectifyHandlerView);
        rectifyHandlerView.setX(f);
        RectifyHandlerView[] rectifyHandlerViewArr2 = rectifyOverlayView.mHandlers;
        Intrinsics.checkNotNull(rectifyHandlerViewArr2);
        RectifyHandlerView rectifyHandlerView2 = rectifyHandlerViewArr2[i];
        Intrinsics.checkNotNull(rectifyHandlerView2);
        rectifyHandlerView2.setY(f4);
    }

    private final void setImageBitmap(Bitmap bitmap) {
        RectifyImageView rectifyImageView = this.mImageView;
        if (rectifyImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
            rectifyImageView = null;
        }
        rectifyImageView.setImageBitmap(bitmap);
        RectifyEditPresenter rectifyEditPresenter = this.mPresenter;
        Intrinsics.checkNotNull(rectifyEditPresenter);
        rectifyEditPresenter.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showHandlerPreview() {
        Logger.m7145d(TAG, "showHandlerPreview# ");
        RectifyHandlerPreview rectifyHandlerPreview = this.mHandlerPreview;
        Intrinsics.checkNotNull(rectifyHandlerPreview);
        rectifyHandlerPreview.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100L).withStartAction(new RunnableC7989a(this, 2)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showHandlerPreview$lambda$3(RectifyOverlayView rectifyOverlayView) {
        RectifyHandlerPreview rectifyHandlerPreview = rectifyOverlayView.mHandlerPreview;
        Intrinsics.checkNotNull(rectifyHandlerPreview);
        rectifyHandlerPreview.setVisibility(0);
        rectifyOverlayView.updateHandlerPreviewPosition();
    }

    private final void updateHandlerPreview(int targetIdx, PointF pos) {
        RectifyHandlerView[] rectifyHandlerViewArr = this.mHandlers;
        Intrinsics.checkNotNull(rectifyHandlerViewArr);
        RectifyHandlerView rectifyHandlerView = rectifyHandlerViewArr[targetIdx];
        Intrinsics.checkNotNull(rectifyHandlerView);
        View viewFindViewById = rectifyHandlerView.findViewById(C7976R.id.handler_view);
        Intrinsics.checkNotNull(viewFindViewById);
        updateHandlerPreviewImage(viewFindViewById, pos);
        if (updateHandlerPreviewPosition(viewFindViewById, pos)) {
            reDrawHandlerPreview();
        }
    }

    private final void updateHandlerPreviewContainer() {
        RectifyImageView rectifyImageView = this.mImageView;
        RectifyImageView rectifyImageView2 = null;
        if (rectifyImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
            rectifyImageView = null;
        }
        rectifyImageView.setDrawLine(false);
        View view = this.mContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view = null;
        }
        int width = view.getWidth();
        View view2 = this.mContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view2 = null;
        }
        int height = view2.getHeight();
        if (width > 0 && height > 0) {
            Bitmap bitmap = this.mPreview;
            if (bitmap != null) {
                Intrinsics.checkNotNull(bitmap);
                bitmap.recycle();
            }
            this.mPreview = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Bitmap bitmap2 = this.mPreview;
            Intrinsics.checkNotNull(bitmap2);
            Canvas canvas = new Canvas(bitmap2);
            View view3 = this.mContainer;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                view3 = null;
            }
            view3.layout(0, 0, width, height);
            View view4 = this.mContainer;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                view4 = null;
            }
            view4.draw(canvas);
        }
        RectifyImageView rectifyImageView3 = this.mImageView;
        if (rectifyImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
        } else {
            rectifyImageView2 = rectifyImageView3;
        }
        rectifyImageView2.setDrawLine(true);
    }

    private final void updateHandlerPreviewImage(View targetView, PointF pos) {
        try {
            if (this.mPreview == null) {
                return;
            }
            RectifyHandlerPreview rectifyHandlerPreview = this.mHandlerPreview;
            Intrinsics.checkNotNull(rectifyHandlerPreview);
            Bitmap bitmap = this.mPreview;
            Intrinsics.checkNotNull(bitmap);
            rectifyHandlerPreview.setHandlerPreview(Bitmap.createBitmap(bitmap, (int) (targetView.getX() + pos.x), (int) (targetView.getY() + pos.y), targetView.getWidth(), targetView.getHeight()));
        } catch (IllegalArgumentException e) {
            Logger.m7146e(TAG, "updateHandlerPreviewImage# IllegalArgumentException: " + e.getMessage());
        }
    }

    private final boolean updateHandlerPreviewPosition(View targetView, PointF pos) {
        float width = (targetView.getWidth() / 2.0f) + targetView.getX() + pos.x;
        View view = this.mContainer;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view = null;
        }
        float x = view.getX();
        View view3 = this.mContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        } else {
            view2 = view3;
        }
        boolean z = (((float) view2.getWidth()) / 2.0f) + x < width;
        boolean z2 = z != this.mIsPreviewLeft;
        this.mIsPreviewLeft = z;
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void updateHandlerPreviewPosition$lambda$4(RectifyOverlayView rectifyOverlayView) {
        float width;
        float height;
        float dimension = rectifyOverlayView.getResources().getDimension(C7976R.dimen.rectify_overlay_view_padding);
        RectifyImageView rectifyImageView = null;
        if (rectifyOverlayView.mIsPreviewLeft) {
            RectifyImageView rectifyImageView2 = rectifyOverlayView.mImageView;
            if (rectifyImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mImageView");
                rectifyImageView2 = null;
            }
            float x = rectifyImageView2.getX();
            Intrinsics.checkNotNull(rectifyOverlayView.mHandlerPreview);
            width = (x - r4.getWidth()) - dimension;
        } else {
            RectifyImageView rectifyImageView3 = rectifyOverlayView.mImageView;
            if (rectifyImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mImageView");
                rectifyImageView3 = null;
            }
            float x2 = rectifyImageView3.getX();
            RectifyImageView rectifyImageView4 = rectifyOverlayView.mImageView;
            if (rectifyImageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mImageView");
                rectifyImageView4 = null;
            }
            width = x2 + rectifyImageView4.getWidth() + dimension;
        }
        if (width < 0.0f) {
            if (rectifyOverlayView.mIsPreviewLeft) {
                RectifyImageView rectifyImageView5 = rectifyOverlayView.mImageView;
                if (rectifyImageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mImageView");
                    rectifyImageView5 = null;
                }
                width = rectifyImageView5.getX();
            } else {
                RectifyImageView rectifyImageView6 = rectifyOverlayView.mImageView;
                if (rectifyImageView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mImageView");
                    rectifyImageView6 = null;
                }
                float x5 = rectifyImageView6.getX();
                RectifyImageView rectifyImageView7 = rectifyOverlayView.mImageView;
                if (rectifyImageView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mImageView");
                    rectifyImageView7 = null;
                }
                float width2 = x5 + rectifyImageView7.getWidth();
                Intrinsics.checkNotNull(rectifyOverlayView.mHandlerPreview);
                width = width2 - r5.getWidth();
            }
            RectifyImageView rectifyImageView8 = rectifyOverlayView.mImageView;
            if (rectifyImageView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mImageView");
                rectifyImageView8 = null;
            }
            float y2 = rectifyImageView8.getY();
            Intrinsics.checkNotNull(rectifyOverlayView.mHandlerPreview);
            height = (y2 - r6.getHeight()) - dimension;
            if (height < 0.0f) {
                RectifyImageView rectifyImageView9 = rectifyOverlayView.mImageView;
                if (rectifyImageView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mImageView");
                } else {
                    rectifyImageView = rectifyImageView9;
                }
                height = rectifyImageView.getY();
            }
        } else {
            View view = rectifyOverlayView.mContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                view = null;
            }
            float x6 = view.getX();
            View view2 = rectifyOverlayView.mContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                view2 = null;
            }
            float width3 = x6 + view2.getWidth();
            Intrinsics.checkNotNull(rectifyOverlayView.mHandlerPreview);
            if (width3 > r6.getWidth() + width) {
                RectifyImageView rectifyImageView10 = rectifyOverlayView.mImageView;
                if (rectifyImageView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mImageView");
                } else {
                    rectifyImageView = rectifyImageView10;
                }
                height = rectifyImageView.getY();
            }
        }
        RectifyHandlerPreview rectifyHandlerPreview = rectifyOverlayView.mHandlerPreview;
        Intrinsics.checkNotNull(rectifyHandlerPreview);
        rectifyHandlerPreview.setX(width);
        RectifyHandlerPreview rectifyHandlerPreview2 = rectifyOverlayView.mHandlerPreview;
        Intrinsics.checkNotNull(rectifyHandlerPreview2);
        rectifyHandlerPreview2.setY(height);
    }

    public final void initialize(@Nullable RectifyEditPresenter presenter) {
        this.mPresenter = presenter;
        Intrinsics.checkNotNull(presenter);
        presenter.setInterpolation(getResources().getDimension(C7976R.dimen.rectify_handler_select_radius));
        RectifyEditPresenter rectifyEditPresenter = this.mPresenter;
        Intrinsics.checkNotNull(rectifyEditPresenter);
        rectifyEditPresenter.setHandlerSize(getResources().getDimension(C7976R.dimen.rectify_handler_view_size));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            updateHandlerPreviewContainer();
        }
        loadHandlerPosition();
    }

    public final void setHandlePosition(@Nullable PointF[] handlePositions) {
        if (handlePositions == null) {
            handlePositions = this.DEFAULT_HANDLE_VERTEX;
        }
        RectifyHandlerView[] rectifyHandlerViewArr = this.mHandlers;
        if (rectifyHandlerViewArr != null) {
            Intrinsics.checkNotNull(rectifyHandlerViewArr);
            int length = rectifyHandlerViewArr.length;
            for (int i = 0; i < length; i++) {
                RectifyHandlerView[] rectifyHandlerViewArr2 = this.mHandlers;
                Intrinsics.checkNotNull(rectifyHandlerViewArr2);
                RectifyHandlerView rectifyHandlerView = rectifyHandlerViewArr2[i];
                if (rectifyHandlerView != null) {
                    ViewParent parent = rectifyHandlerView.getParent();
                    Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                    ((ViewGroup) parent).removeView(rectifyHandlerView);
                    RectifyHandlerView[] rectifyHandlerViewArr3 = this.mHandlers;
                    Intrinsics.checkNotNull(rectifyHandlerViewArr3);
                    rectifyHandlerViewArr3[i] = null;
                }
            }
            this.mHandlers = null;
        }
        int length2 = handlePositions.length;
        RectifyEditPresenter rectifyEditPresenter = this.mPresenter;
        Intrinsics.checkNotNull(rectifyEditPresenter);
        rectifyEditPresenter.setNumOfAngle(length2);
        this.mHandlers = new RectifyHandlerView[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            if (handlePositions[i2] == null) {
                handlePositions[i2] = this.DEFAULT_HANDLE_VERTEX[i2];
            }
            RectifyHandlerView[] rectifyHandlerViewArr4 = this.mHandlers;
            Intrinsics.checkNotNull(rectifyHandlerViewArr4);
            if (rectifyHandlerViewArr4[i2] == null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                RectifyHandlerView rectifyHandlerView2 = new RectifyHandlerView(context);
                RectifyHandlerView[] rectifyHandlerViewArr5 = this.mHandlers;
                Intrinsics.checkNotNull(rectifyHandlerViewArr5);
                rectifyHandlerViewArr5[i2] = rectifyHandlerView2;
                addView(rectifyHandlerView2);
            }
            RectifyEditPresenter rectifyEditPresenter2 = this.mPresenter;
            Intrinsics.checkNotNull(rectifyEditPresenter2);
            PointF pointF = handlePositions[i2];
            Intrinsics.checkNotNull(pointF);
            rectifyEditPresenter2.setVertex(i2, pointF);
        }
    }

    public final void setImagePath(@Nullable String imagePath) {
        RectifyEditPresenter rectifyEditPresenter = this.mPresenter;
        Intrinsics.checkNotNull(rectifyEditPresenter);
        rectifyEditPresenter.setImagePath(imagePath);
        setImageBitmap(DocScanUtils.getBitmapImageFromPath(imagePath));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void movePosition(int targetIdx, PointF pos, boolean isHandlerTouched) {
        RectifyHandlerView[] rectifyHandlerViewArr = this.mHandlers;
        Intrinsics.checkNotNull(rectifyHandlerViewArr);
        RectifyHandlerView rectifyHandlerView = rectifyHandlerViewArr[targetIdx];
        Intrinsics.checkNotNull(rectifyHandlerView);
        rectifyHandlerView.setX(pos.x);
        RectifyHandlerView[] rectifyHandlerViewArr2 = this.mHandlers;
        Intrinsics.checkNotNull(rectifyHandlerViewArr2);
        RectifyHandlerView rectifyHandlerView2 = rectifyHandlerViewArr2[targetIdx];
        Intrinsics.checkNotNull(rectifyHandlerView2);
        rectifyHandlerView2.setY(pos.y);
        RectifyEditPresenter rectifyEditPresenter = this.mPresenter;
        Intrinsics.checkNotNull(rectifyEditPresenter);
        RectifyEditPresenter rectifyEditPresenter2 = this.mPresenter;
        Intrinsics.checkNotNull(rectifyEditPresenter2);
        rectifyEditPresenter.setVertex(targetIdx, rectifyEditPresenter2.getRatioFromRealPosition(pos));
        if (isHandlerTouched) {
            updateHandlerPreview(targetIdx, pos);
        }
    }

    public final void setImagePath(@Nullable Bitmap imageBitmap, @Nullable String imagePath) {
        RectifyEditPresenter rectifyEditPresenter = this.mPresenter;
        Intrinsics.checkNotNull(rectifyEditPresenter);
        rectifyEditPresenter.setImagePath(imagePath);
        setImageBitmap(imageBitmap);
    }

    private final void updateHandlerPreviewPosition() {
        RectifyHandlerPreview rectifyHandlerPreview = this.mHandlerPreview;
        Intrinsics.checkNotNull(rectifyHandlerPreview);
        rectifyHandlerPreview.post(new RunnableC7989a(this, 1));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RectifyOverlayView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.DEFAULT_HANDLE_VERTEX = new PointF[]{new PointF(0.0f, 0.0f), new PointF(1.0f, 0.0f), new PointF(1.0f, 1.0f), new PointF(0.0f, 1.0f)};
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.support.senl.docscan.rectify.view.RectifyOverlayView$mOnTouchListener$1
            private PointF startPos;
            private int target = -2;

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View v, MotionEvent event) {
                Intrinsics.checkNotNullParameter(v, "v");
                Intrinsics.checkNotNullParameter(event, "event");
                PointF pointF = new PointF(event.getX() + v.getX(), event.getY() + v.getY());
                RectifyEditPresenter rectifyEditPresenter = this.this$0.mPresenter;
                Intrinsics.checkNotNull(rectifyEditPresenter);
                PointF[] realPositionListFromRatio = rectifyEditPresenter.getRealPositionListFromRatio();
                RectifyEditPresenter rectifyEditPresenter2 = this.this$0.mPresenter;
                Intrinsics.checkNotNull(rectifyEditPresenter2);
                rectifyEditPresenter2.setDelta(pointF);
                RectifyEditPresenter rectifyEditPresenter3 = this.this$0.mPresenter;
                Intrinsics.checkNotNull(rectifyEditPresenter3);
                int numOfAngle = rectifyEditPresenter3.getNumOfAngle();
                int action = event.getAction();
                if (action == 0) {
                    RectifyEditPresenter rectifyEditPresenter4 = this.this$0.mPresenter;
                    Intrinsics.checkNotNull(rectifyEditPresenter4);
                    int touchedObject = rectifyEditPresenter4.getTouchedObject(pointF, realPositionListFromRatio);
                    this.target = touchedObject;
                    if (touchedObject == -2) {
                        Logger.m7145d("RectifyOverlayView", "onTouch# ACTION_DOWN outside");
                        return true;
                    }
                    if (touchedObject == -1) {
                        Logger.m7145d("RectifyOverlayView", "onTouch# ACTION_DOWN inside");
                    } else {
                        Logger.m7145d("RectifyOverlayView", "onTouch# ACTION_DOWN " + touchedObject);
                        if (this.target < numOfAngle) {
                            PointF pointF2 = realPositionListFromRatio[this.target];
                            this.startPos = new PointF(pointF2.x, pointF2.y);
                            this.this$0.scaleUpHandler(this.target);
                            RectifyOverlayView rectifyOverlayView = this.this$0;
                            int i = this.target;
                            PointF pointF3 = this.startPos;
                            Intrinsics.checkNotNull(pointF3);
                            rectifyOverlayView.initHandlerPreview(i, pointF3);
                        }
                    }
                } else if (action == 1) {
                    int i2 = this.target;
                    if (i2 != -1 && i2 != -2) {
                        this.this$0.initHandler();
                    }
                } else {
                    if (action != 2) {
                        return false;
                    }
                    int i4 = this.target;
                    if (i4 == -2) {
                        return true;
                    }
                    if (i4 == -1) {
                        RectifyEditPresenter rectifyEditPresenter5 = this.this$0.mPresenter;
                        Intrinsics.checkNotNull(rectifyEditPresenter5);
                        if (!rectifyEditPresenter5.canMoveAllPosition((PointF[]) Arrays.copyOf(realPositionListFromRatio, realPositionListFromRatio.length))) {
                            return false;
                        }
                        this.this$0.movePosition(realPositionListFromRatio);
                    } else if (i4 < numOfAngle) {
                        PointF pointF4 = realPositionListFromRatio[this.target];
                        PointF pointF5 = new PointF(pointF4.x, pointF4.y);
                        RectifyEditPresenter rectifyEditPresenter6 = this.this$0.mPresenter;
                        Intrinsics.checkNotNull(rectifyEditPresenter6);
                        int i5 = this.target;
                        PointF pointF6 = this.startPos;
                        Intrinsics.checkNotNull(pointF6);
                        if (!rectifyEditPresenter6.canMovePosition(i5, pointF6, pointF5, realPositionListFromRatio)) {
                            return false;
                        }
                        this.this$0.movePosition(this.target, pointF5, true);
                    } else if (i4 < numOfAngle * 2) {
                        RectifyEditPresenter rectifyEditPresenter7 = this.this$0.mPresenter;
                        Intrinsics.checkNotNull(rectifyEditPresenter7);
                        if (!rectifyEditPresenter7.canMoveLine(i4 - numOfAngle, realPositionListFromRatio)) {
                            return false;
                        }
                        this.this$0.movePosition(realPositionListFromRatio);
                    }
                    RectifyImageView rectifyImageView = this.this$0.mImageView;
                    if (rectifyImageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mImageView");
                        rectifyImageView = null;
                    }
                    rectifyImageView.invalidate();
                }
                return true;
            }
        };
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RectifyOverlayView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.DEFAULT_HANDLE_VERTEX = new PointF[]{new PointF(0.0f, 0.0f), new PointF(1.0f, 0.0f), new PointF(1.0f, 1.0f), new PointF(0.0f, 1.0f)};
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.support.senl.docscan.rectify.view.RectifyOverlayView$mOnTouchListener$1
            private PointF startPos;
            private int target = -2;

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View v, MotionEvent event) {
                Intrinsics.checkNotNullParameter(v, "v");
                Intrinsics.checkNotNullParameter(event, "event");
                PointF pointF = new PointF(event.getX() + v.getX(), event.getY() + v.getY());
                RectifyEditPresenter rectifyEditPresenter = this.this$0.mPresenter;
                Intrinsics.checkNotNull(rectifyEditPresenter);
                PointF[] realPositionListFromRatio = rectifyEditPresenter.getRealPositionListFromRatio();
                RectifyEditPresenter rectifyEditPresenter2 = this.this$0.mPresenter;
                Intrinsics.checkNotNull(rectifyEditPresenter2);
                rectifyEditPresenter2.setDelta(pointF);
                RectifyEditPresenter rectifyEditPresenter3 = this.this$0.mPresenter;
                Intrinsics.checkNotNull(rectifyEditPresenter3);
                int numOfAngle = rectifyEditPresenter3.getNumOfAngle();
                int action = event.getAction();
                if (action == 0) {
                    RectifyEditPresenter rectifyEditPresenter4 = this.this$0.mPresenter;
                    Intrinsics.checkNotNull(rectifyEditPresenter4);
                    int touchedObject = rectifyEditPresenter4.getTouchedObject(pointF, realPositionListFromRatio);
                    this.target = touchedObject;
                    if (touchedObject == -2) {
                        Logger.m7145d("RectifyOverlayView", "onTouch# ACTION_DOWN outside");
                        return true;
                    }
                    if (touchedObject == -1) {
                        Logger.m7145d("RectifyOverlayView", "onTouch# ACTION_DOWN inside");
                    } else {
                        Logger.m7145d("RectifyOverlayView", "onTouch# ACTION_DOWN " + touchedObject);
                        if (this.target < numOfAngle) {
                            PointF pointF2 = realPositionListFromRatio[this.target];
                            this.startPos = new PointF(pointF2.x, pointF2.y);
                            this.this$0.scaleUpHandler(this.target);
                            RectifyOverlayView rectifyOverlayView = this.this$0;
                            int i2 = this.target;
                            PointF pointF3 = this.startPos;
                            Intrinsics.checkNotNull(pointF3);
                            rectifyOverlayView.initHandlerPreview(i2, pointF3);
                        }
                    }
                } else if (action == 1) {
                    int i22 = this.target;
                    if (i22 != -1 && i22 != -2) {
                        this.this$0.initHandler();
                    }
                } else {
                    if (action != 2) {
                        return false;
                    }
                    int i4 = this.target;
                    if (i4 == -2) {
                        return true;
                    }
                    if (i4 == -1) {
                        RectifyEditPresenter rectifyEditPresenter5 = this.this$0.mPresenter;
                        Intrinsics.checkNotNull(rectifyEditPresenter5);
                        if (!rectifyEditPresenter5.canMoveAllPosition((PointF[]) Arrays.copyOf(realPositionListFromRatio, realPositionListFromRatio.length))) {
                            return false;
                        }
                        this.this$0.movePosition(realPositionListFromRatio);
                    } else if (i4 < numOfAngle) {
                        PointF pointF4 = realPositionListFromRatio[this.target];
                        PointF pointF5 = new PointF(pointF4.x, pointF4.y);
                        RectifyEditPresenter rectifyEditPresenter6 = this.this$0.mPresenter;
                        Intrinsics.checkNotNull(rectifyEditPresenter6);
                        int i5 = this.target;
                        PointF pointF6 = this.startPos;
                        Intrinsics.checkNotNull(pointF6);
                        if (!rectifyEditPresenter6.canMovePosition(i5, pointF6, pointF5, realPositionListFromRatio)) {
                            return false;
                        }
                        this.this$0.movePosition(this.target, pointF5, true);
                    } else if (i4 < numOfAngle * 2) {
                        RectifyEditPresenter rectifyEditPresenter7 = this.this$0.mPresenter;
                        Intrinsics.checkNotNull(rectifyEditPresenter7);
                        if (!rectifyEditPresenter7.canMoveLine(i4 - numOfAngle, realPositionListFromRatio)) {
                            return false;
                        }
                        this.this$0.movePosition(realPositionListFromRatio);
                    }
                    RectifyImageView rectifyImageView = this.this$0.mImageView;
                    if (rectifyImageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mImageView");
                        rectifyImageView = null;
                    }
                    rectifyImageView.invalidate();
                }
                return true;
            }
        };
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RectifyOverlayView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.DEFAULT_HANDLE_VERTEX = new PointF[]{new PointF(0.0f, 0.0f), new PointF(1.0f, 0.0f), new PointF(1.0f, 1.0f), new PointF(0.0f, 1.0f)};
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.support.senl.docscan.rectify.view.RectifyOverlayView$mOnTouchListener$1
            private PointF startPos;
            private int target = -2;

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View v, MotionEvent event) {
                Intrinsics.checkNotNullParameter(v, "v");
                Intrinsics.checkNotNullParameter(event, "event");
                PointF pointF = new PointF(event.getX() + v.getX(), event.getY() + v.getY());
                RectifyEditPresenter rectifyEditPresenter = this.this$0.mPresenter;
                Intrinsics.checkNotNull(rectifyEditPresenter);
                PointF[] realPositionListFromRatio = rectifyEditPresenter.getRealPositionListFromRatio();
                RectifyEditPresenter rectifyEditPresenter2 = this.this$0.mPresenter;
                Intrinsics.checkNotNull(rectifyEditPresenter2);
                rectifyEditPresenter2.setDelta(pointF);
                RectifyEditPresenter rectifyEditPresenter3 = this.this$0.mPresenter;
                Intrinsics.checkNotNull(rectifyEditPresenter3);
                int numOfAngle = rectifyEditPresenter3.getNumOfAngle();
                int action = event.getAction();
                if (action == 0) {
                    RectifyEditPresenter rectifyEditPresenter4 = this.this$0.mPresenter;
                    Intrinsics.checkNotNull(rectifyEditPresenter4);
                    int touchedObject = rectifyEditPresenter4.getTouchedObject(pointF, realPositionListFromRatio);
                    this.target = touchedObject;
                    if (touchedObject == -2) {
                        Logger.m7145d("RectifyOverlayView", "onTouch# ACTION_DOWN outside");
                        return true;
                    }
                    if (touchedObject == -1) {
                        Logger.m7145d("RectifyOverlayView", "onTouch# ACTION_DOWN inside");
                    } else {
                        Logger.m7145d("RectifyOverlayView", "onTouch# ACTION_DOWN " + touchedObject);
                        if (this.target < numOfAngle) {
                            PointF pointF2 = realPositionListFromRatio[this.target];
                            this.startPos = new PointF(pointF2.x, pointF2.y);
                            this.this$0.scaleUpHandler(this.target);
                            RectifyOverlayView rectifyOverlayView = this.this$0;
                            int i22 = this.target;
                            PointF pointF3 = this.startPos;
                            Intrinsics.checkNotNull(pointF3);
                            rectifyOverlayView.initHandlerPreview(i22, pointF3);
                        }
                    }
                } else if (action == 1) {
                    int i222 = this.target;
                    if (i222 != -1 && i222 != -2) {
                        this.this$0.initHandler();
                    }
                } else {
                    if (action != 2) {
                        return false;
                    }
                    int i4 = this.target;
                    if (i4 == -2) {
                        return true;
                    }
                    if (i4 == -1) {
                        RectifyEditPresenter rectifyEditPresenter5 = this.this$0.mPresenter;
                        Intrinsics.checkNotNull(rectifyEditPresenter5);
                        if (!rectifyEditPresenter5.canMoveAllPosition((PointF[]) Arrays.copyOf(realPositionListFromRatio, realPositionListFromRatio.length))) {
                            return false;
                        }
                        this.this$0.movePosition(realPositionListFromRatio);
                    } else if (i4 < numOfAngle) {
                        PointF pointF4 = realPositionListFromRatio[this.target];
                        PointF pointF5 = new PointF(pointF4.x, pointF4.y);
                        RectifyEditPresenter rectifyEditPresenter6 = this.this$0.mPresenter;
                        Intrinsics.checkNotNull(rectifyEditPresenter6);
                        int i5 = this.target;
                        PointF pointF6 = this.startPos;
                        Intrinsics.checkNotNull(pointF6);
                        if (!rectifyEditPresenter6.canMovePosition(i5, pointF6, pointF5, realPositionListFromRatio)) {
                            return false;
                        }
                        this.this$0.movePosition(this.target, pointF5, true);
                    } else if (i4 < numOfAngle * 2) {
                        RectifyEditPresenter rectifyEditPresenter7 = this.this$0.mPresenter;
                        Intrinsics.checkNotNull(rectifyEditPresenter7);
                        if (!rectifyEditPresenter7.canMoveLine(i4 - numOfAngle, realPositionListFromRatio)) {
                            return false;
                        }
                        this.this$0.movePosition(realPositionListFromRatio);
                    }
                    RectifyImageView rectifyImageView = this.this$0.mImageView;
                    if (rectifyImageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mImageView");
                        rectifyImageView = null;
                    }
                    rectifyImageView.invalidate();
                }
                return true;
            }
        };
        init(context);
    }
}
