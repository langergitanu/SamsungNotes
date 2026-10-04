package com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 R2\u00020\u0001:\u0001RB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020-J\u0010\u0010/\u001a\u00020-2\b\u00100\u001a\u0004\u0018\u00010\u001cJ\u0010\u00101\u001a\u00020-2\b\u00100\u001a\u0004\u0018\u00010\u001aJ\"\u00102\u001a\u00020-2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0007H\u0016J\u000e\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u000206J\u0010\u0010:\u001a\u00020\u00072\u0006\u00105\u001a\u000206H\u0002J \u0010;\u001a\u00020-2\u0006\u0010<\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0007H\u0002J\u0018\u0010>\u001a\u00020-2\u0006\u0010<\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u0010H\u0002J\u0010\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020\u0010H\u0002J\u0018\u0010A\u001a\u00020-2\u0006\u0010<\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u0010H\u0002J8\u0010B\u001a\u00020-2\u0016\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0014j\b\u0012\u0004\u0012\u00020\u0010`\u00152\u0006\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u0010H\u0002J\u0010\u0010M\u001a\u00020\u00102\u0006\u0010N\u001a\u00020OH\u0014J\u0010\u0010P\u001a\u00020\u00102\u0006\u0010N\u001a\u00020OH\u0014J\u0010\u0010Q\u001a\u00020\u00102\u0006\u0010N\u001a\u00020OH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0014j\b\u0012\u0004\u0012\u00020\u0011`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0014j\b\u0012\u0004\u0012\u00020\u0010`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010H\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bH\u0010\b\"\u0004\bI\u0010\nR$\u0010K\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bK\u0010\b\"\u0004\bL\u0010\n¨\u0006S"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/view/penrecyclerview/BasePenRecyclerViewModel;", "", "mView", "Lcom/samsung/android/support/senl/nt/base/common/view/penrecyclerview/IBasePenRecyclerView;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/common/view/penrecyclerview/IBasePenRecyclerView;)V", "isPenMultiSelectionOn", "", "()Z", "setPenMultiSelectionOn", "(Z)V", "mIsPenMultiSelectionEnabled", "mIsPenMultiSelectionDisabledDuringPenMultiSelectionOn", "mIsDragMouseEnabled", "mSelectedItemHashMap", "Ljava/util/HashMap;", "", "Lcom/samsung/android/support/senl/nt/base/common/view/penrecyclerview/SelectedItem;", "Lkotlin/collections/HashMap;", "mSelectedItemArray", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mSelectedItemPositonArrayList", "mIsLongPressed", "mLastAction", "mOnPenMultiSelectionListener", "Lcom/samsung/android/support/senl/nt/base/common/view/penrecyclerview/OnPenMultiSelectionListener;", "mOnMouseMultiSelectionListener", "Lcom/samsung/android/support/senl/nt/base/common/view/penrecyclerview/OnMouseMultiSelectionListener;", "mTwDragStartX", "mTwDragStartY", "mTwDragEndX", "mTwDragEndY", "mPenDragLeft", "mPenDragRight", "mPenDragTop", "mPenDragBottom", "mIsfirstMoveEvent", "mMulSelStartItemPos", "mMuSelCurrentItemPos", "mMulSelStartItemY", "mMulSelStartItemDeltaY", "mIsMulSelStartItemVisible", "mOriginGapStrategy", "startDragMouseMultiSelection", "", "cancelDragMouseMultiSelection", "setOnMouseMultiSelectionListener", "l", "setOnPenMultiSelectionListener", "processTouchEvent", "context", "Landroid/content/Context;", "ev", "Landroid/view/MotionEvent;", "bOutOfChildren", "isPenMultiSelectionMode", "event", "isMouseDragEvent", "processPenMoveOnPenSelection", "x", "y", "initPenMoveOnPenSeletion", "checkSelectionOfChildView", "childIndex", "processPenUpOnPenSelection", "notifyMultiSelectionListener", "selectedItemPosition", "recyclerViewWidth", "penDragLeft", "penDragRight", "press", "isLongPressed", "setLongPressed", "enabled", "isPenMultiSelectionEnabled", "setPenMultiSelectionEnabled", "getCustomViewLeft", "view", "Landroid/view/View;", "getCustomViewRight", "getCustomViewBottom", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BasePenRecyclerViewModel {
    private static final int INVALID_POSITION = -1;

    @NotNull
    private static final String TAG = "BasePenRecyclerViewModel";
    private boolean isPenMultiSelectionOn;
    private boolean mIsDragMouseEnabled;
    private boolean mIsLongPressed;
    private boolean mIsMulSelStartItemVisible;
    private boolean mIsPenMultiSelectionDisabledDuringPenMultiSelectionOn;
    private boolean mIsPenMultiSelectionEnabled;
    private boolean mIsfirstMoveEvent;
    private int mLastAction;
    private int mMuSelCurrentItemPos;
    private int mMulSelStartItemDeltaY;
    private int mMulSelStartItemPos;
    private int mMulSelStartItemY;

    @Nullable
    private OnMouseMultiSelectionListener mOnMouseMultiSelectionListener;

    @Nullable
    private OnPenMultiSelectionListener mOnPenMultiSelectionListener;
    private int mOriginGapStrategy;
    private int mPenDragBottom;
    private int mPenDragLeft;
    private int mPenDragRight;
    private int mPenDragTop;

    @NotNull
    private final ArrayList<SelectedItem> mSelectedItemArray;

    @NotNull
    private final HashMap<Integer, SelectedItem> mSelectedItemHashMap;

    @NotNull
    private final ArrayList<Integer> mSelectedItemPositonArrayList;
    private int mTwDragEndX;
    private int mTwDragEndY;
    private int mTwDragStartX;
    private int mTwDragStartY;

    @NotNull
    private final IBasePenRecyclerView mView;

    public BasePenRecyclerViewModel(@NotNull IBasePenRecyclerView mView) {
        Intrinsics.checkNotNullParameter(mView, "mView");
        this.mView = mView;
        this.mIsPenMultiSelectionEnabled = true;
        this.mSelectedItemHashMap = new HashMap<>();
        this.mSelectedItemArray = new ArrayList<>();
        this.mSelectedItemPositonArrayList = new ArrayList<>();
        this.mIsfirstMoveEvent = true;
        this.mMulSelStartItemPos = -1;
        this.mMuSelCurrentItemPos = -1;
    }

    private final void checkSelectionOfChildView(int childIndex) {
        View childAt = this.mView.getChildAt(childIndex);
        if (childAt == null || childAt.getVisibility() != 0) {
            return;
        }
        if (childAt.getHeight() + childAt.getTop() < 0 || childAt.getTop() > this.mView.getHeight()) {
            return;
        }
        int top = childAt.getTop();
        int customViewBottom = getCustomViewBottom(childAt);
        int i = this.mPenDragTop;
        if ((i <= top || this.mPenDragBottom >= customViewBottom) && ((i < top || this.mPenDragBottom > customViewBottom) && ((i > top || this.mPenDragBottom <= top) && (i >= customViewBottom || this.mPenDragBottom < customViewBottom)))) {
            int childAdapterPosition = this.mView.getChildAdapterPosition(childAt);
            SelectedItem selectedItem = this.mSelectedItemHashMap.get(Integer.valueOf(childAdapterPosition));
            if (selectedItem != null) {
                AbstractC4539a.m3203m(childAdapterPosition, "dispatchTouchEvent() remove item : ", TAG);
                this.mSelectedItemHashMap.remove(Integer.valueOf(childAdapterPosition));
                this.mSelectedItemArray.remove(selectedItem);
                return;
            }
            return;
        }
        int childAdapterPosition2 = this.mView.getChildAdapterPosition(childAt);
        SelectedItem selectedItem2 = this.mSelectedItemHashMap.get(Integer.valueOf(childAdapterPosition2));
        if (selectedItem2 != null) {
            if (this.mSelectedItemArray.contains(selectedItem2)) {
                return;
            }
            this.mSelectedItemArray.add(selectedItem2);
            Logger.m8697d(TAG, "dispatchTouchEvent() add item : " + childAdapterPosition2);
            return;
        }
        SelectedItem selectedItem3 = new SelectedItem();
        selectedItem3.setLeft(getCustomViewLeft(childAt));
        selectedItem3.setRight(getCustomViewRight(childAt));
        selectedItem3.setPosition(childAdapterPosition2);
        this.mSelectedItemHashMap.put(Integer.valueOf(childAdapterPosition2), selectedItem3);
        this.mSelectedItemArray.add(selectedItem3);
        Logger.m8697d(TAG, "dispatchTouchEvent() add item : " + childAdapterPosition2);
    }

    private final void initPenMoveOnPenSeletion(int x, int y2) {
        this.mSelectedItemPositonArrayList.clear();
        this.mSelectedItemArray.clear();
        this.mSelectedItemHashMap.clear();
        this.mView.setGapStrategy(0);
        this.mTwDragStartX = x;
        this.mTwDragStartY = y2;
        this.mMulSelStartItemY = 0;
        this.mMulSelStartItemDeltaY = 0;
        this.mMuSelCurrentItemPos = -1;
        this.mIsMulSelStartItemVisible = false;
        int childCount = this.mView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mView.getChildAt(i);
            float f = y2;
            if (f >= childAt.getY() && f <= childAt.getY() + childAt.getHeight()) {
                int childAdapterPosition = this.mView.getChildAdapterPosition(childAt);
                this.mMulSelStartItemPos = childAdapterPosition;
                this.mMuSelCurrentItemPos = childAdapterPosition;
                this.mMulSelStartItemY = (int) childAt.getY();
                this.mMulSelStartItemDeltaY = y2 - ((int) childAt.getY());
                return;
            }
            if (i == this.mView.getChildCount() - 1 && f >= childAt.getY() + childAt.getHeight()) {
                IBasePenRecyclerView iBasePenRecyclerView = this.mView;
                int childAdapterPosition2 = iBasePenRecyclerView.getChildAdapterPosition(iBasePenRecyclerView.getChildAt(i));
                this.mMulSelStartItemPos = childAdapterPosition2;
                this.mMuSelCurrentItemPos = childAdapterPosition2;
                this.mMulSelStartItemY = (int) childAt.getY();
                this.mMulSelStartItemDeltaY = y2 - ((int) childAt.getY());
                return;
            }
        }
    }

    private final boolean isMouseDragEvent(MotionEvent ev) {
        return ev.getToolType(0) == 3 && this.mIsDragMouseEnabled;
    }

    private final void notifyMultiSelectionListener(ArrayList<Integer> selectedItemPosition, int recyclerViewWidth, int penDragLeft, int penDragRight) {
        if (this.mIsDragMouseEnabled) {
            OnMouseMultiSelectionListener onMouseMultiSelectionListener = this.mOnMouseMultiSelectionListener;
            if (onMouseMultiSelectionListener != null) {
                Intrinsics.checkNotNull(onMouseMultiSelectionListener);
                onMouseMultiSelectionListener.onSelectedItemPosition(selectedItemPosition, recyclerViewWidth, penDragLeft, penDragRight);
                return;
            }
            return;
        }
        OnPenMultiSelectionListener onPenMultiSelectionListener = this.mOnPenMultiSelectionListener;
        if (onPenMultiSelectionListener != null) {
            Intrinsics.checkNotNull(onPenMultiSelectionListener);
            onPenMultiSelectionListener.onSelectedItemPosition(selectedItemPosition, recyclerViewWidth, penDragLeft, penDragRight);
        }
    }

    private final void processPenMoveOnPenSelection(int x, int y2, boolean bOutOfChildren) {
        int i;
        if (this.mIsPenMultiSelectionEnabled) {
            this.mTwDragEndX = x;
            this.mTwDragEndY = y2;
            if (this.mIsfirstMoveEvent) {
                this.mIsfirstMoveEvent = false;
                initPenMoveOnPenSeletion(x, y2);
            }
            int childCount = this.mView.getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                View childAt = this.mView.getChildAt(i2);
                if (this.mMulSelStartItemPos == this.mView.getChildAdapterPosition(childAt)) {
                    if (this.mMulSelStartItemY != ((int) childAt.getY())) {
                        this.mTwDragStartY = ((int) childAt.getY()) + this.mMulSelStartItemDeltaY;
                    }
                    this.mIsMulSelStartItemVisible = true;
                } else {
                    i2++;
                }
            }
            if (!this.mIsMulSelStartItemVisible) {
                int childCount2 = this.mView.getChildCount();
                int i4 = 0;
                while (true) {
                    if (i4 >= childCount2) {
                        break;
                    }
                    View childAt2 = this.mView.getChildAt(i4);
                    float f = y2;
                    if (f >= childAt2.getY() && f <= childAt2.getY() + childAt2.getHeight()) {
                        this.mMuSelCurrentItemPos = this.mView.getChildAdapterPosition(childAt2);
                        break;
                    }
                    i4++;
                }
                int i5 = this.mMulSelStartItemPos;
                if (i5 != -1 && (i = this.mMuSelCurrentItemPos) != -1) {
                    if (i > i5) {
                        this.mTwDragStartY = 0;
                    } else if (i < i5) {
                        this.mTwDragStartY = this.mView.getHeight();
                    }
                }
            }
            int i6 = this.mTwDragStartX;
            int i7 = this.mTwDragEndX;
            if (i6 < i7) {
                this.mPenDragLeft = i6;
                this.mPenDragRight = i7;
            } else {
                this.mPenDragLeft = i7;
                this.mPenDragRight = i6;
            }
            int i8 = this.mTwDragStartY;
            int i9 = this.mTwDragEndY;
            if (i8 < i9) {
                this.mPenDragTop = i8;
                this.mPenDragBottom = i9;
            } else {
                this.mPenDragTop = i9;
                this.mPenDragBottom = i8;
            }
            if (bOutOfChildren && this.mView.getChildCount() > 0) {
                this.mPenDragTop = (int) this.mView.getChildAt(0).getY();
            }
            int childCount3 = this.mView.getChildCount();
            for (int i10 = 0; i10 < childCount3; i10++) {
                checkSelectionOfChildView(i10);
            }
            this.mView.invalidate();
        }
    }

    private final void processPenUpOnPenSelection(int x, int y2) {
        if (this.mIsPenMultiSelectionEnabled || this.mIsPenMultiSelectionDisabledDuringPenMultiSelectionOn) {
            this.mSelectedItemPositonArrayList.clear();
            int size = this.mSelectedItemArray.size();
            for (int i = 0; i < size; i++) {
                if (this.mSelectedItemArray.get(i).isOverlaid(this.mPenDragLeft, this.mPenDragRight)) {
                    this.mSelectedItemPositonArrayList.add(Integer.valueOf(this.mSelectedItemArray.get(i).getPosition()));
                } else {
                    AbstractC4539a.m3203m(this.mSelectedItemArray.get(i).getPosition(), "dispatchTouchEvent(up) remove item : ", TAG);
                }
            }
            if (this.mSelectedItemPositonArrayList.isEmpty()) {
                int childCount = this.mView.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.mView.getChildAt(i2);
                    if (childAt != null && childAt.getVisibility() == 0) {
                        if (childAt.getHeight() + childAt.getTop() >= 0 && childAt.getTop() <= this.mView.getHeight()) {
                            int top = childAt.getTop();
                            int customViewBottom = getCustomViewBottom(childAt);
                            int customViewLeft = getCustomViewLeft(childAt);
                            int customViewRight = getCustomViewRight(childAt);
                            if (top < y2 && customViewBottom > y2 && customViewLeft < x && customViewRight > x) {
                                this.mSelectedItemPositonArrayList.add(Integer.valueOf(this.mView.getChildAdapterPosition(childAt)));
                            }
                        }
                    }
                }
                if (this.mSelectedItemPositonArrayList.size() == 1) {
                    notifyMultiSelectionListener(this.mSelectedItemPositonArrayList, this.mView.getWidth(), this.mPenDragLeft, this.mPenDragRight);
                }
            } else {
                Collections.sort(this.mSelectedItemPositonArrayList);
                notifyMultiSelectionListener(this.mSelectedItemPositonArrayList, this.mView.getWidth(), this.mPenDragLeft, this.mPenDragRight);
                StringBuilder sb = new StringBuilder();
                int size2 = this.mSelectedItemPositonArrayList.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    Integer num = this.mSelectedItemPositonArrayList.get(i4);
                    Intrinsics.checkNotNullExpressionValue(num, "get(...)");
                    sb.append(num.intValue());
                    sb.append(SQLKeyword.COMMA);
                }
                Logger.m8697d(TAG, "dispatchTouchEvent(up) items cnt : " + this.mSelectedItemPositonArrayList.size());
                Logger.m8697d(TAG, "dispatchTouchEvent(up) items : " + ((Object) sb));
            }
            this.mMulSelStartItemPos = -1;
            this.mMulSelStartItemY = 0;
            this.mMulSelStartItemDeltaY = 0;
            this.mMuSelCurrentItemPos = -1;
            this.mIsMulSelStartItemVisible = false;
            this.isPenMultiSelectionOn = false;
            this.mIsPenMultiSelectionDisabledDuringPenMultiSelectionOn = false;
            this.mIsfirstMoveEvent = true;
            this.mTwDragStartX = 0;
            this.mTwDragStartY = 0;
            this.mTwDragEndX = 0;
            this.mTwDragEndY = 0;
            this.mPenDragLeft = 0;
            this.mPenDragRight = 0;
            this.mPenDragTop = 0;
            this.mPenDragBottom = 0;
            this.mView.setGapStrategy(this.mOriginGapStrategy);
            this.mView.invalidate();
        }
    }

    public final void cancelDragMouseMultiSelection() {
        if (this.isPenMultiSelectionOn) {
            return;
        }
        this.mIsDragMouseEnabled = false;
    }

    public int getCustomViewBottom(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return view.getBottom();
    }

    public int getCustomViewLeft(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return view.getLeft();
    }

    public int getCustomViewRight(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return view.getRight();
    }

    public final boolean isLongPressed() {
        return this.mIsLongPressed && this.mLastAction != 212;
    }

    /* JADX INFO: renamed from: isPenMultiSelectionEnabled, reason: from getter */
    public final boolean getMIsPenMultiSelectionEnabled() {
        return this.mIsPenMultiSelectionEnabled;
    }

    public final boolean isPenMultiSelectionMode(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return (event.getToolType(0) == 2 && (event.getButtonState() & 32) != 0) || isMouseDragEvent(event);
    }

    /* JADX INFO: renamed from: isPenMultiSelectionOn, reason: from getter */
    public final boolean getIsPenMultiSelectionOn() {
        return this.isPenMultiSelectionOn;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void processTouchEvent(@Nullable Context context, @NotNull MotionEvent ev, boolean bOutOfChildren) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        int action = ev.getAction();
        int x = (int) ev.getX();
        int y2 = (int) ev.getY();
        if (action == 0) {
            if (isPenMultiSelectionMode(ev)) {
                this.isPenMultiSelectionOn = true;
                this.mOriginGapStrategy = this.mView.getGapStrategy();
                if (bOutOfChildren || MultiSelection.INSTANCE.getIsMultiSelectingText()) {
                    this.isPenMultiSelectionOn = false;
                }
            }
        } else if (action == 1) {
            if (this.isPenMultiSelectionOn) {
                processPenUpOnPenSelection(x, y2);
                this.mIsDragMouseEnabled = false;
                this.mLastAction = 212;
                return;
            }
            this.mIsDragMouseEnabled = false;
        } else if (action == 2) {
            if (this.isPenMultiSelectionOn && isPenMultiSelectionMode(ev)) {
                processPenMoveOnPenSelection(x, y2, bOutOfChildren);
            }
        } else if (action != 3) {
            switch (action) {
            }
        }
        this.mLastAction = action;
    }

    public final void setLongPressed(boolean z) {
        this.mIsLongPressed = z;
    }

    public final void setOnMouseMultiSelectionListener(@Nullable OnMouseMultiSelectionListener l) {
        this.mOnMouseMultiSelectionListener = l;
    }

    public final void setOnPenMultiSelectionListener(@Nullable OnPenMultiSelectionListener l) {
        this.mOnPenMultiSelectionListener = l;
    }

    public final void setPenMultiSelectionEnabled(boolean z) {
        if (this.mIsPenMultiSelectionEnabled == z) {
            return;
        }
        Logger.m8698e(TAG, "setPenMultiSelectionEnabled:" + z);
        this.mIsPenMultiSelectionEnabled = z;
        boolean z2 = false;
        if (this.isPenMultiSelectionOn && !z) {
            z2 = true;
        }
        this.mIsPenMultiSelectionDisabledDuringPenMultiSelectionOn = z2;
    }

    public final void setPenMultiSelectionOn(boolean z) {
        this.isPenMultiSelectionOn = z;
    }

    public final void startDragMouseMultiSelection() {
        if (this.mIsDragMouseEnabled) {
            return;
        }
        this.mIsDragMouseEnabled = true;
    }
}
