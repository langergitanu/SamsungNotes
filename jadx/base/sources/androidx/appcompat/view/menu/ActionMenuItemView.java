package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;
import androidx.appcompat.util.SeslMisc;
import androidx.appcompat.util.SeslShowButtonShapesHelper;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, View.OnClickListener, ActionMenuView.ActionMenuChildView, View.OnLongClickListener {
    private static final float MAX_FONT_SCALE = 1.2f;
    private static final int MAX_ICON_SIZE = 32;
    private static final String TAG = "ActionMenuItemView";
    private final Drawable initBackgroundDrawable;
    private boolean mAllowTextWithIcon;
    private float mDefaultTextSize;
    private boolean mExpandedFormat;
    private ForwardingListener mForwardingListener;
    private Drawable mIcon;
    private boolean mIsChangedRelativePadding;
    private boolean mIsLastItem;
    MenuItemImpl mItemData;
    MenuBuilder.ItemInvoker mItemInvoker;
    private int mMaxIconSize;
    private int mMinWidth;
    PopupCallback mPopupCallback;
    private SeslShowButtonShapesHelper mSBSHelper;
    private int mSavedPaddingLeft;
    private CharSequence mTitle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ActionMenuItemForwardingListener extends ForwardingListener {
        public ActionMenuItemForwardingListener() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public ShowableListMenu getPopup() {
            PopupCallback popupCallback = ActionMenuItemView.this.mPopupCallback;
            if (popupCallback != null) {
                return popupCallback.getPopup();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public boolean onForwardingStarted() {
            ShowableListMenu popup;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            MenuBuilder.ItemInvoker itemInvoker = actionMenuItemView.mItemInvoker;
            return itemInvoker != null && itemInvoker.invokeItem(actionMenuItemView.mItemData) && (popup = getPopup()) != null && popup.isShowing();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class PopupCallback {
        public abstract ShowableListMenu getPopup();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    private boolean shouldAllowTextWithIcon() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (i < 480) {
            return (i >= 640 && i2 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    private void updateTextButtonVisibility() {
        boolean zSeslIsTextButtonVisible = seslIsTextButtonVisible();
        setText(zSeslIsTextButtonVisible ? this.mTitle : null);
        if (zSeslIsTextButtonVisible) {
            setBackgroundResource(SeslMisc.isLightTheme(getContext()) ? C0419R.drawable.sesl_action_bar_item_text_background_light : C0419R.drawable.sesl_action_bar_item_text_background_dark);
        } else {
            setBackground(this.initBackgroundDrawable);
        }
        CharSequence contentDescription = this.mItemData.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(zSeslIsTextButtonVisible ? null : this.mItemData.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.mItemData.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            TooltipCompat.setTooltipText(this, zSeslIsTextButtonVisible ? null : this.mItemData.getTitle());
        } else {
            TooltipCompat.setTooltipText(this, tooltipText);
        }
        if (this.mDefaultTextSize > 0.0f) {
            setTextSize(1, this.mDefaultTextSize * Math.min(getResources().getConfiguration().fontScale, 1.2f));
        }
        setText(zSeslIsTextButtonVisible ? this.mTitle : null);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.mItemData = menuItemImpl;
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitleForItemView(this));
        setId(menuItemImpl.getItemId());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() && this.mForwardingListener == null) {
            this.mForwardingListener = new ActionMenuItemForwardingListener();
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerAfter() {
        return hasText();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerBefore() {
        return hasText() && this.mItemData.getIcon() == null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MenuBuilder.ItemInvoker itemInvoker = this.mItemInvoker;
        if (itemInvoker != null) {
            itemInvoker.invokeItem(this.mItemData);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mAllowTextWithIcon = shouldAllowTextWithIcon();
        updateTextButtonVisibility();
    }

    @Override // android.view.View
    public void onHoverChanged(boolean z) {
        TooltipCompat.seslSetNextTooltipForceActionBarPosX(true);
        TooltipCompat.seslSetNextTooltipForceBelow(true);
        super.onHoverChanged(z);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return false;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i4;
        boolean zHasText = hasText();
        if (zHasText && (i4 = this.mSavedPaddingLeft) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        if (this.mSBSHelper != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            this.mSBSHelper.setBackgroundOn(ContextCompat.getDrawable(getContext(), hasText() ? C0419R.drawable.sesl_action_text_button_show_button_shapes_background : this.mIsLastItem ? C0419R.drawable.sesl_more_button_show_button_shapes_background : C0419R.drawable.sesl_action_icon_button_show_button_shapes_background));
            this.mSBSHelper.updateButtonBackground();
            setPadding(paddingLeft, getPaddingTop(), paddingRight, getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.mMinWidth) : this.mMinWidth;
        if (mode != 1073741824 && this.mMinWidth > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i2);
        }
        if (zHasText || this.mIcon == null) {
            return;
        }
        int measuredWidth2 = getMeasuredWidth();
        int iWidth = this.mIcon.getBounds().width();
        if (this.mIsChangedRelativePadding) {
            return;
        }
        super.setPadding((measuredWidth2 - iWidth) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence contentDescription = getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            return;
        }
        accessibilityEvent.getText().add(contentDescription);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener;
        if (this.mItemData.hasSubMenu() && (forwardingListener = this.mForwardingListener) != null && forwardingListener.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        if (this.mIcon == null) {
            TooltipCompat.setTooltipNull(true);
            return true;
        }
        TooltipCompat.seslSetNextTooltipForceActionBarPosX(true);
        TooltipCompat.seslSetNextTooltipForceBelow(true);
        return super.performLongClick();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return true;
    }

    public boolean seslIsTextButtonVisible() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.mTitle);
        if (this.mIcon != null && (!this.mItemData.showsTextAsAction() || (!this.mAllowTextWithIcon && !this.mExpandedFormat))) {
            z = false;
        }
        return z2 & z;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        super.setBackground(drawable);
        SeslShowButtonShapesHelper seslShowButtonShapesHelper = this.mSBSHelper;
        if (seslShowButtonShapesHelper != null) {
            seslShowButtonShapesHelper.setBackgroundOff(drawable);
        }
    }

    public void setExpandedFormat(boolean z) {
        if (this.mExpandedFormat != z) {
            this.mExpandedFormat = z;
            MenuItemImpl menuItemImpl = this.mItemData;
            if (menuItemImpl != null) {
                menuItemImpl.actionFormatChanged();
            }
        }
    }

    @Override // android.widget.TextView
    public boolean setFrame(int i, int i2, int i4, int i5) {
        boolean frame = super.setFrame(i, i2, i4, i5);
        if (this.mIsChangedRelativePadding) {
            Drawable background = getBackground();
            if (this.mIcon != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int paddingLeft = (getPaddingLeft() - getPaddingRight()) / 2;
                DrawableCompat.setHotspotBounds(background, paddingLeft, 0, width + paddingLeft, height);
                return frame;
            }
            if (background != null) {
                DrawableCompat.setHotspotBounds(background, 0, 0, getWidth(), getHeight());
            }
        }
        return frame;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.mMaxIconSize;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, null, null, null);
        if (hasText() && ViewCompat.getLayoutDirection(this) == 1) {
            setCompoundDrawables(null, null, drawable, null);
        } else {
            setCompoundDrawables(drawable, null, null, null);
        }
        updateTextButtonVisibility();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setIsLastItem(boolean z) {
        this.mIsLastItem = z;
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker) {
        this.mItemInvoker = itemInvoker;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i4, int i5) {
        this.mSavedPaddingLeft = i;
        super.setPadding(i, i2, i4, i5);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i, int i2, int i4, int i5) {
        this.mSavedPaddingLeft = i;
        this.mIsChangedRelativePadding = true;
        super.setPaddingRelative(i, i2, i4, i5);
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.mPopupCallback = popupCallback;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        setContentDescription(charSequence);
        updateTextButtonVisibility();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsChangedRelativePadding = false;
        this.mDefaultTextSize = 0.0f;
        this.mIsLastItem = false;
        Resources resources = context.getResources();
        this.mAllowTextWithIcon = shouldAllowTextWithIcon();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0419R.styleable.ActionMenuItemView, i, 0);
        this.mMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0419R.styleable.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.mMaxIconSize = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.mSavedPaddingLeft = -1;
        setSaveEnabled(false);
        TypedArray typedArrayObtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(null, C0419R.styleable.AppCompatTheme, 0, 0);
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(C0419R.styleable.AppCompatTheme_actionMenuTextAppearance, 0);
        typedArrayObtainStyledAttributes2.recycle();
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(resourceId, C0419R.styleable.TextAppearance);
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes3.peekValue(C0419R.styleable.TextAppearance_android_textSize);
        typedArrayObtainStyledAttributes3.recycle();
        if (typedValuePeekValue != null) {
            this.mDefaultTextSize = TypedValue.complexToFloat(typedValuePeekValue.data);
        }
        if (Build.VERSION.SDK_INT > 27) {
            seslSetButtonShapeEnabled(true);
        } else {
            this.mSBSHelper = new SeslShowButtonShapesHelper(this, ResourcesCompat.getDrawable(getResources(), C0419R.drawable.sesl_action_text_button_show_button_shapes_background, null), getBackground());
        }
        TypedArray typedArrayObtainStyledAttributes4 = context.getTheme().obtainStyledAttributes(null, C0419R.styleable.AppCompatTheme, 0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes4.getResourceId(C0419R.styleable.AppCompatTheme_actionButtonStyle, 0);
        typedArrayObtainStyledAttributes4.recycle();
        TypedArray typedArrayObtainStyledAttributes5 = context.getTheme().obtainStyledAttributes(resourceId2, new int[]{R.attr.background});
        this.initBackgroundDrawable = typedArrayObtainStyledAttributes5.getDrawable(0);
        typedArrayObtainStyledAttributes5.recycle();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c) {
    }
}
