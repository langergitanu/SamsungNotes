package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.dragndrop;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.dragndrop.DragAndDropHelper;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002J(\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\b\u0010 \u001a\u00020\u0011H\u0002J\b\u0010!\u001a\u00020\u0011H\u0002J\u000e\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u000fJ\u0010\u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'H\u0002J\u0018\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/dragndrop/DragAndDropHelper;", "", "context", "Landroid/content/Context;", "teView", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;)V", "dragAndDropLayout", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/dragndrop/DragAndDropLayout;", "isDragAndDropEnabled", "", "()Z", "setDragAndDropEnabled", "(Z)V", "teViewChildCnt", "", "addViewToTEView", "", "selectedText", "", ImageConst.ImageUpscaleConst.KEY_SCALE_FACTOR, "", "checkAlreadyAddedView", "handleTouchEvent", "event", "Landroid/view/MotionEvent;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/dragndrop/DragAndDropCallBack;", "isValidDraggableData", "Landroid/view/DragEvent;", "preprocessText", "removeViewFromTEView", "setDragAndDropListener", "setDragAndDropListenerInternal", "setTEViewChildCount", "childCnt", "setTextAndStartDrag", "startDragAndDrop", "dragData", "Landroid/content/ClipData;", "updateLayout", "xCord", "yCord", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DragAndDropHelper {

    @NotNull
    public static final String TAG = "DragAndDropHelper";

    @NotNull
    private final Context context;

    @NotNull
    private DragAndDropLayout dragAndDropLayout;
    private boolean isDragAndDropEnabled;

    @NotNull
    private final View teView;
    private int teViewChildCnt;

    public DragAndDropHelper(@NotNull Context context, @NotNull View teView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(teView, "teView");
        this.context = context;
        this.teView = teView;
        this.dragAndDropLayout = new DragAndDropLayout(context);
        this.isDragAndDropEnabled = true;
    }

    private final void addViewToTEView(String selectedText, float scaleFactor) {
        LinearLayout.LayoutParams layout = this.dragAndDropLayout.setLayout(this.teView, preprocessText(selectedText), scaleFactor);
        ViewParent parent = this.teView.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).addView(this.dragAndDropLayout.getDragAndDropLayout(), layout);
    }

    private final boolean checkAlreadyAddedView() {
        ViewParent parent = this.teView.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        LibLogger.m5432i(TAG, "childCnt= " + viewGroup.getChildCount());
        return viewGroup.getChildCount() == this.teViewChildCnt + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handleTouchEvent$lambda$0(DragAndDropHelper this$0, String selectedText, DragAndDropCallBack listener, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(selectedText, "$selectedText");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        this$0.setTextAndStartDrag(selectedText);
        listener.onDragStarted();
        this$0.removeViewFromTEView();
        return true;
    }

    private final boolean isValidDraggableData(DragEvent event) {
        return event.getClipDescription().hasMimeType("text/plain");
    }

    private final String preprocessText(String selectedText) {
        StringsKt.m14139M(selectedText, "\n ", "");
        return selectedText;
    }

    private final void removeViewFromTEView() {
        ViewParent parent = this.teView.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).removeView(this.dragAndDropLayout.getDragAndDropLayout());
    }

    private final void setDragAndDropListener() {
        setDragAndDropListenerInternal();
    }

    private final void setDragAndDropListenerInternal() {
        this.teView.setOnDragListener(new View.OnDragListener() { // from class: Y1.a
            @Override // android.view.View.OnDragListener
            public final boolean onDrag(View view, DragEvent dragEvent) {
                return DragAndDropHelper.setDragAndDropListenerInternal$lambda$1(this.f867a, view, dragEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setDragAndDropListenerInternal$lambda$1(DragAndDropHelper this$0, View view, DragEvent e) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        switch (e.getAction()) {
            case 1:
                this$0.dragAndDropLayout.getDragAndDropLayout().setVisibility(0);
                Intrinsics.checkNotNullExpressionValue(e, "e");
                if (!this$0.isValidDraggableData(e)) {
                    return false;
                }
                LibLogger.m5429d(TAG, "ACTION_DRAG_STARTED");
                return true;
            case 2:
                LibLogger.m5429d(TAG, "ACTION_DRAG_LOCATION");
                this$0.teView.setOnTouchListener(null);
                return true;
            case 3:
                ClipData.Item itemAt = e.getClipData().getItemAt(0);
                Intrinsics.checkNotNullExpressionValue(itemAt, "e.clipData.getItemAt(0)");
                LibLogger.m5429d(TAG, "The drop data: " + ((Object) itemAt.getText()));
                this$0.teView.setOnTouchListener(null);
                return true;
            case 4:
                this$0.teView.setOnTouchListener(null);
                if (e.getResult()) {
                    LibLogger.m5429d(TAG, "The drop was handled.");
                } else {
                    LibLogger.m5429d(TAG, "The drop didn't work.");
                }
                return true;
            case 5:
                this$0.teView.setOnTouchListener(null);
                LibLogger.m5429d(TAG, "ACTION_DRAG_ENTERED");
                return true;
            case 6:
                return true;
            default:
                LibLogger.m5429d(TAG, "Unknown action type received by View.OnDragListener.");
                return false;
        }
    }

    private final void setTextAndStartDrag(String selectedText) {
        startDragAndDrop(new ClipData(selectedText, new String[]{"text/plain"}, new ClipData.Item(selectedText)));
    }

    private final void startDragAndDrop(ClipData dragData) {
        this.dragAndDropLayout.getDragAndDropLayout().startDragAndDrop(dragData, new TextExtractionDragShadowBuilder(this.dragAndDropLayout.getDragAndDropLayout()), null, 257);
    }

    private final void updateLayout(float xCord, float yCord) {
        LinearLayout dragAndDropLayout = this.dragAndDropLayout.getDragAndDropLayout();
        dragAndDropLayout.setX(xCord);
        dragAndDropLayout.setY(yCord);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean handleTouchEvent(@NotNull MotionEvent event, @NotNull final String selectedText, float scaleFactor, @NotNull final DragAndDropCallBack listener) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(selectedText, "selectedText");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.isDragAndDropEnabled) {
            return false;
        }
        if (event.getActionMasked() != 2 && event.getActionMasked() != 0) {
            return false;
        }
        if (checkAlreadyAddedView()) {
            LibLogger.m5432i(TAG, "Already attached drag and drop layout");
            updateLayout(event.getX(), event.getY());
            return true;
        }
        if (selectedText.length() <= 0) {
            return true;
        }
        addViewToTEView(selectedText, scaleFactor);
        this.teView.setOnTouchListener(new View.OnTouchListener() { // from class: Y1.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return DragAndDropHelper.handleTouchEvent$lambda$0(this.f868a, selectedText, listener, view, motionEvent);
            }
        });
        setDragAndDropListener();
        return true;
    }

    /* JADX INFO: renamed from: isDragAndDropEnabled, reason: from getter */
    public final boolean getIsDragAndDropEnabled() {
        return this.isDragAndDropEnabled;
    }

    public final void setDragAndDropEnabled(boolean z) {
        this.isDragAndDropEnabled = z;
    }

    public final void setTEViewChildCount(int childCnt) {
        this.teViewChildCnt = childCnt;
    }
}
