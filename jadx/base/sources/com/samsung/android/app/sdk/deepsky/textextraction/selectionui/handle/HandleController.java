package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data.SelectableCharacter;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data.SelectableWord;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.Handle;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.draw.HandleDrawInfo;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.textselection.TextSelectionHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.util.DrawUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.util.VectorUtil;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\b\u0000\u0018\u0000 >2\u00020\u0001:\u0001>B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u001e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u000bH\u0002J\u0006\u0010$\u001a\u00020\u000bJ\b\u0010%\u001a\u00020\u000bH\u0002J\u0018\u0010&\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0018\u0010'\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0018\u0010(\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0006\u0010)\u001a\u00020\u0012J\u000e\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0018J\b\u0010,\u001a\u00020\u0012H\u0002J\u000e\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u000bJ\u000e\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u000201J\u000e\u00102\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u000bJ\u000e\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u000205J\b\u00106\u001a\u00020\u0012H\u0002J\b\u00107\u001a\u00020\u0012H\u0002J\u0006\u00108\u001a\u00020\u0012J\b\u00109\u001a\u00020\u0012H\u0002J\u001c\u0010:\u001a\u00020\u0012*\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J \u0010;\u001a\u00020\u0012*\u00020\b2\u0006\u0010<\u001a\u00020\u00162\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/HandleController;", "", "context", "Landroid/content/Context;", "textSelectionHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/textselection/TextSelectionHelper;", "(Landroid/content/Context;Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/textselection/TextSelectionHelper;)V", "handleEnd", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/Handle;", "handleStart", "isLongPress", "", "()Z", "setLongPress", "(Z)V", "touchedPoint", "Landroid/graphics/Point;", "drawHandles", "", "canvas", "Landroid/graphics/Canvas;", "findClosestCharFromCoordinates", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableCharacter;", "x", "", "y", "getEndHandlePosition", "Landroid/graphics/Rect;", "getStartHandlePosition", "handleTouchEvent", "event", "Landroid/view/MotionEvent;", "hitFromLongClick", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/HandleTouchEventListener;", "isHandleCrossed", "isHandleMoving", "isHandleNotEmpty", "isTouchPointMoved", "moveWithHandle", "moveWithLongPress", "setEmpty", "setHandleColor", "color", "setHandleMovingStateToIdle", "setHandleShadowEnabled", "enabled", "setImageInfo", "teView", "Landroid/view/View;", "setMovingHandleEnabled", "setScaleFactor", WiggleAnimationConfig.KEY_SCALE, "", "updateHandlePosition", "updateHandlePositionWithAnimation", "updatePosition", "updateTextSelection", "onHandleMove", "updateHandle", "selectedChar", "charForAnimation", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class HandleController {
    private static final int BOUNDING_RECT_MARGIN_DP = 20;
    private static final int MOVING_THRESHOLD_PX = 1;

    @NotNull
    private static final String TAG = "HandleController";

    @NotNull
    private final Context context;

    @NotNull
    private final Handle handleEnd;

    @NotNull
    private final Handle handleStart;
    private boolean isLongPress;

    @NotNull
    private final TextSelectionHelper textSelectionHelper;

    @NotNull
    private Point touchedPoint;

    public HandleController(@NotNull Context context, @NotNull TextSelectionHelper textSelectionHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textSelectionHelper, "textSelectionHelper");
        this.context = context;
        this.textSelectionHelper = textSelectionHelper;
        this.handleStart = new Handle(context, Handle.HandleType.START);
        this.handleEnd = new Handle(context, Handle.HandleType.END);
        this.touchedPoint = new Point(-1, -1);
    }

    private final SelectableCharacter findClosestCharFromCoordinates(int x, int y2) {
        Point point = new Point(x, y2);
        SelectableCharacter selectableCharacterFindTouchedCharacter = this.textSelectionHelper.findTouchedCharacter(point);
        return selectableCharacterFindTouchedCharacter == null ? this.textSelectionHelper.findNearestCharacter(point) : selectableCharacterFindTouchedCharacter;
    }

    private final boolean isHandleCrossed() {
        return this.handleStart.getSelectedChar().getIndex() > this.handleEnd.getSelectedChar().getIndex();
    }

    private final boolean isHandleNotEmpty() {
        return this.handleStart.isNotEmpty() && this.handleEnd.isNotEmpty();
    }

    private final boolean isTouchPointMoved(int x, int y2) {
        return Math.abs(x - this.touchedPoint.x) > 1 || Math.abs(y2 - this.touchedPoint.y) > 1;
    }

    private final void moveWithHandle(int x, int y2) {
        updateTextSelection();
        if (this.handleStart.isMoving()) {
            onHandleMove(this.handleStart, x, y2);
        } else if (this.handleEnd.isMoving()) {
            onHandleMove(this.handleEnd, x, y2);
        }
    }

    private final void moveWithLongPress(int x, int y2) {
        SelectableWord selectedWord = this.textSelectionHelper.getSelectedWord();
        List<SelectableCharacter> selectableCharacters = this.textSelectionHelper.getSelectableOcrResult().getSelectableCharacters();
        if (selectedWord != null) {
            SelectableCharacter selectableCharacterFindClosestCharFromCoordinates = findClosestCharFromCoordinates(x, y2);
            int index = selectableCharacterFindClosestCharFromCoordinates.getIndex();
            int iCoerceAtMost = RangesKt.coerceAtMost(index, ((SelectableCharacter) CollectionsKt.first((List) selectedWord.getSelectableCharacters())).getIndex());
            int iCoerceAtLeast = RangesKt.coerceAtLeast(index, ((SelectableCharacter) CollectionsKt.last((List) selectedWord.getSelectableCharacters())).getIndex());
            this.textSelectionHelper.clearAllSelection();
            this.textSelectionHelper.selectCharacters(selectableCharacters.get(iCoerceAtMost), selectableCharacters.get(iCoerceAtLeast));
            this.textSelectionHelper.setLastSelectedChar(selectableCharacterFindClosestCharFromCoordinates);
        }
    }

    private final void onHandleMove(Handle handle, int i, int i2) {
        SelectableCharacter selectableCharacterFindClosestCharFromCoordinates = findClosestCharFromCoordinates(i, i2);
        updateHandle(handle, selectableCharacterFindClosestCharFromCoordinates, null);
        handle.updateMovingState(Handle.MovingState.MOVING);
        this.textSelectionHelper.setLastSelectedChar(selectableCharacterFindClosestCharFromCoordinates);
    }

    private final void setHandleMovingStateToIdle() {
        Handle handle = this.handleStart;
        Handle.MovingState movingState = Handle.MovingState.IDLE;
        handle.updateMovingState(movingState);
        this.handleEnd.updateMovingState(movingState);
    }

    private final void updateHandle(Handle handle, SelectableCharacter selectableCharacter, SelectableCharacter selectableCharacter2) {
        SelectableWord wordContainingCharacter = this.textSelectionHelper.getSelectableOcrResult().getWordContainingCharacter(selectableCharacter);
        DrawUtil drawUtil = DrawUtil.INSTANCE;
        handle.updateHandle(new HandleDrawInfo(selectableCharacter, drawUtil.isLeftToRightText(wordContainingCharacter.getPoly()), this.touchedPoint, VectorUtil.INSTANCE.calcRectWithMargin(this.textSelectionHelper.getBlockBoundingRect(), drawUtil.convertDpToPx(this.context, Float.valueOf(20.0f))), selectableCharacter2));
    }

    public static /* synthetic */ void updateHandle$default(HandleController handleController, Handle handle, SelectableCharacter selectableCharacter, SelectableCharacter selectableCharacter2, int i, Object obj) {
        if ((i & 2) != 0) {
            selectableCharacter2 = null;
        }
        handleController.updateHandle(handle, selectableCharacter, selectableCharacter2);
    }

    private final void updateHandlePosition() {
        if (this.textSelectionHelper.isTextSelected()) {
            updateHandle$default(this, this.handleStart, this.textSelectionHelper.findStartCharFromSelection(), null, 2, null);
            updateHandle$default(this, this.handleEnd, this.textSelectionHelper.findEndCharFromSelection(), null, 2, null);
        }
    }

    private final void updateHandlePositionWithAnimation() {
        if (this.textSelectionHelper.isTextSelected()) {
            SelectableCharacter selectableCharacterFindStartCharFromSelection = this.textSelectionHelper.findStartCharFromSelection();
            SelectableCharacter selectableCharacterFindEndCharFromSelection = this.textSelectionHelper.findEndCharFromSelection();
            List<SelectableCharacter> selectableCharacters = this.textSelectionHelper.getSelectableOcrResult().getSelectableCharacters();
            if (!isHandleCrossed()) {
                updateHandle(this.handleStart, selectableCharacterFindStartCharFromSelection, selectableCharacterFindStartCharFromSelection);
                updateHandle(this.handleEnd, selectableCharacterFindEndCharFromSelection, selectableCharacterFindEndCharFromSelection);
            } else {
                int iCoerceAtMost = RangesKt.coerceAtMost(selectableCharacterFindEndCharFromSelection.getIndex() + 1, selectableCharacters.size() - 1);
                int iCoerceAtLeast = RangesKt.coerceAtLeast(selectableCharacterFindStartCharFromSelection.getIndex() - 1, 0);
                updateHandle(this.handleStart, selectableCharacterFindStartCharFromSelection, selectableCharacters.get(iCoerceAtMost));
                updateHandle(this.handleEnd, selectableCharacterFindEndCharFromSelection, selectableCharacters.get(iCoerceAtLeast));
            }
        }
    }

    private final void updateTextSelection() {
        List<SelectableCharacter> selectableCharacters = this.textSelectionHelper.getSelectableOcrResult().getSelectableCharacters();
        SelectableCharacter selectedChar = this.handleStart.getSelectedChar();
        SelectableCharacter selectedChar2 = this.handleEnd.getSelectedChar();
        this.textSelectionHelper.clearAllSelection();
        if (!isHandleCrossed()) {
            this.textSelectionHelper.selectCharacters(selectableCharacters.get(selectedChar.getIndex()), selectableCharacters.get(selectedChar2.getIndex()));
        } else if (this.handleStart.isMoving()) {
            this.textSelectionHelper.selectCharacters(selectableCharacters.get(selectedChar2.getIndex() + 1), selectableCharacters.get(selectedChar.getIndex()));
        } else {
            this.textSelectionHelper.selectCharacters(selectableCharacters.get(selectedChar2.getIndex()), selectableCharacters.get(selectedChar.getIndex() - 1));
        }
    }

    public final void drawHandles(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!isHandleNotEmpty() || this.isLongPress) {
            return;
        }
        this.handleStart.draw(canvas);
        this.handleEnd.draw(canvas);
    }

    @NotNull
    public final Rect getEndHandlePosition() {
        return this.handleEnd.getTouchAreaRect();
    }

    @NotNull
    public final Rect getStartHandlePosition() {
        return this.handleStart.getTouchAreaRect();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean handleTouchEvent(@NotNull MotionEvent event, boolean hitFromLongClick, @NotNull HandleTouchEventListener listener) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(listener, "listener");
        int x = (int) (event.getX() + 0.5f);
        int y2 = (int) (event.getY() + 0.5f);
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            if (!this.textSelectionHelper.isTextSelected()) {
                return false;
            }
            if (this.handleStart.contains(x, y2)) {
                this.handleStart.updateMovingState(Handle.MovingState.MOVING);
                listener.onHandleTouchDown(true);
                return true;
            }
            if (!this.handleEnd.contains(x, y2)) {
                return false;
            }
            this.handleEnd.updateMovingState(Handle.MovingState.MOVING);
            listener.onHandleTouchDown(false);
            return true;
        }
        if (actionMasked == 1) {
            this.touchedPoint = new Point(-1, -1);
            if (isHandleMoving() || this.isLongPress) {
                if (isHandleMoving()) {
                    setHandleMovingStateToIdle();
                    updateHandlePositionWithAnimation();
                } else if (this.isLongPress) {
                    this.isLongPress = false;
                    updateHandlePosition();
                }
                listener.onHandleStop();
                return true;
            }
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
            }
        } else {
            if (!isTouchPointMoved(x, y2)) {
                return isHandleMoving() || hitFromLongClick;
            }
            this.touchedPoint = new Point(x, y2);
            if (isHandleMoving()) {
                moveWithHandle(x, y2);
                listener.onHandleMove();
                return true;
            }
            if (hitFromLongClick) {
                this.isLongPress = true;
                moveWithLongPress(x, y2);
                return true;
            }
        }
        return false;
    }

    public final boolean isHandleMoving() {
        return this.handleStart.isMoving() || this.handleEnd.isMoving();
    }

    /* JADX INFO: renamed from: isLongPress, reason: from getter */
    public final boolean getIsLongPress() {
        return this.isLongPress;
    }

    public final void setEmpty() {
        this.handleStart.setEmpty();
        this.handleEnd.setEmpty();
    }

    public final void setHandleColor(int color) {
        this.handleStart.setColor(color);
        this.handleEnd.setColor(color);
    }

    public final void setHandleShadowEnabled(boolean enabled) {
        this.handleStart.setShadowEnabled(enabled);
        this.handleEnd.setShadowEnabled(enabled);
    }

    public final void setImageInfo(@NotNull View teView) {
        Intrinsics.checkNotNullParameter(teView, "teView");
        this.handleStart.setTeView(teView);
        this.handleEnd.setTeView(teView);
    }

    public final void setLongPress(boolean z) {
        this.isLongPress = z;
    }

    public final void setMovingHandleEnabled(boolean enabled) {
        this.handleStart.setMovingEnabled(enabled);
        this.handleEnd.setMovingEnabled(enabled);
    }

    public final void setScaleFactor(float scale) {
        float f = 1 / ((float) (((double) scale) + 1.0E-5d));
        this.handleStart.setScaleFactor(f);
        this.handleEnd.setScaleFactor(f);
        updateHandlePosition();
    }

    public final void updatePosition() {
        updateHandlePosition();
    }
}
