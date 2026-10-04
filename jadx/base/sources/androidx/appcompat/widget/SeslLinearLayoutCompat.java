package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.C0419R;
import androidx.appcompat.animation.SeslRecoilAnimator;
import androidx.appcompat.graphics.drawable.SeslRecoilDrawable;
import androidx.appcompat.util.SeslRoundedCorner;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 29)
public class SeslLinearLayoutCompat extends LinearLayoutCompat {
    private static final int MOTION_EVENT_ACTION_PEN_DOWN = 211;
    private static final int MOTION_EVENT_ACTION_PEN_UP = 212;
    private final ItemBackgroundHolder mItemBackgroundHolder;
    private final SeslRecoilAnimator.Holder mRecoilAnimatorHolder;
    private final SeslRoundedCorner mRoundedCorner;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ItemBackgroundHolder {
        Drawable activeBg = null;

        public ItemBackgroundHolder() {
        }

        public void setCancel() {
            Drawable drawable = this.activeBg;
            if (drawable != null) {
                if (drawable instanceof SeslRecoilDrawable) {
                    ((SeslRecoilDrawable) drawable).setCancel();
                } else {
                    drawable.setState(new int[0]);
                }
                this.activeBg = null;
            }
        }

        public void setPress(View view) {
            setRelease();
            Drawable background = view.getBackground();
            this.activeBg = background;
            if (background != null) {
                background.setState(new int[]{R.attr.state_hovered});
            }
        }

        public void setRelease() {
            Drawable drawable = this.activeBg;
            if (drawable != null) {
                drawable.setState(new int[0]);
                this.activeBg = null;
            }
        }
    }

    public SeslLinearLayoutCompat(@NonNull Context context) {
        this(context, null);
    }

    private View findChildViewUnder(View view, int i, int i2) {
        View viewFindChildViewUnder = null;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int[] iArrTransformCoordinate = transformCoordinate(viewGroup, i, i2);
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                View childAt = viewGroup.getChildAt(i4);
                if (isPointInsideView(iArrTransformCoordinate[0], iArrTransformCoordinate[1], childAt) && (viewFindChildViewUnder = findChildViewUnder(childAt, iArrTransformCoordinate[0], iArrTransformCoordinate[1])) != null) {
                    break;
                }
            }
        }
        return (viewFindChildViewUnder == null && view.isClickable() && view.getVisibility() == 0 && view.isEnabled()) ? view : viewFindChildViewUnder;
    }

    private View findClickableChildUnder(MotionEvent motionEvent) {
        View childAt;
        int i = 0;
        while (true) {
            if (i >= getChildCount()) {
                childAt = null;
                break;
            }
            childAt = getChildAt(i);
            if (isPointInsideView((int) motionEvent.getX(), (int) motionEvent.getY(), childAt)) {
                break;
            }
            i++;
        }
        if (childAt == null) {
            return null;
        }
        View viewFindChildViewUnder = findChildViewUnder(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        if (viewFindChildViewUnder != null && viewFindChildViewUnder != childAt) {
            if (viewFindChildViewUnder.getHeight() * viewFindChildViewUnder.getWidth() < ((double) (childAt.getHeight() * childAt.getWidth())) * 0.5d) {
                return null;
            }
        }
        return viewFindChildViewUnder;
    }

    private boolean isPointInsideView(int i, int i2, View view) {
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()).contains(i, i2);
    }

    private int[] transformCoordinate(View view, int i, int i2) {
        return new int[]{i - view.getLeft(), i2 - view.getTop()};
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.mRoundedCorner.drawRoundedCorner(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 66) {
            if (keyEvent.getAction() == 0) {
                View focusedChild = getFocusedChild();
                if (focusedChild != null) {
                    this.mRecoilAnimatorHolder.setPress(focusedChild);
                }
            } else {
                this.mRecoilAnimatorHolder.setRelease();
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            View viewFindClickableChildUnder = findClickableChildUnder(motionEvent);
            if (viewFindClickableChildUnder != null) {
                this.mItemBackgroundHolder.setPress(viewFindClickableChildUnder);
                this.mRecoilAnimatorHolder.setPress(viewFindClickableChildUnder);
            }
        } else if (action == 1) {
            this.mItemBackgroundHolder.setRelease();
            this.mRecoilAnimatorHolder.setRelease();
        } else if (action == 3) {
            this.mItemBackgroundHolder.setCancel();
            this.mRecoilAnimatorHolder.setRelease();
        } else if (action != 211) {
            if (action == 212) {
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public SeslRoundedCorner getRoundedCorner() {
        return this.mRoundedCorner;
    }

    public SeslLinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SeslLinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0419R.styleable.SeslLayout, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, C0419R.styleable.SeslLayout, attributeSet, tintTypedArrayObtainStyledAttributes.getWrappedTypeArray(), i, 0);
        int i2 = tintTypedArrayObtainStyledAttributes.getInt(C0419R.styleable.SeslLayout_seslLayoutRoundedCorner, 0);
        tintTypedArrayObtainStyledAttributes.recycle();
        SeslRoundedCorner seslRoundedCorner = new SeslRoundedCorner(context);
        this.mRoundedCorner = seslRoundedCorner;
        seslRoundedCorner.setRoundedCorners(i2);
        this.mItemBackgroundHolder = new ItemBackgroundHolder();
        this.mRecoilAnimatorHolder = new SeslRecoilAnimator.Holder(context);
    }
}
