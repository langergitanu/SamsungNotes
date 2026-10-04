package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;
import androidx.appcompat.util.SeslMisc;
import androidx.appcompat.util.SeslShowButtonShapesHelper;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ActionProvider;
import androidx.core.widget.TextViewCompat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups;
    ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private boolean mIsLightTheme;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    private NumberFormat mNumberFormat;
    int mOpenSubMenuId;
    OverflowMenuButton mOverflowButton;
    OverflowPopup mOverflowPopup;
    private Drawable mPendingOverflowIcon;
    private boolean mPendingOverflowIconSet;
    private ActionMenuPopupCallback mPopupCallback;
    final PopupPresenterCallback mPopupPresenterCallback;
    OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private boolean mStrictWidthLimit;
    private CharSequence mTooltipText;
    private boolean mUseTextItemMode;
    private int mWidthLimit;
    private boolean mWidthLimitSet;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ActionButtonSubmenu extends MenuPopupHelper {
        public ActionButtonSubmenu(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false, C0419R.attr.actionOverflowMenuStyle);
            if (!((MenuItemImpl) subMenuBuilder.getItem()).isActionButton()) {
                View view2 = ActionMenuPresenter.this.mOverflowButton;
                setAnchorView(view2 == null ? (View) ((BaseMenuPresenter) ActionMenuPresenter.this).mMenuView : view2);
            }
            setPresenterCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public void onDismiss() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.mActionButtonPopup = null;
            actionMenuPresenter.mOpenSubMenuId = 0;
            super.onDismiss();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        public ActionMenuPopupCallback() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.PopupCallback
        public ShowableListMenu getPopup() {
            ActionButtonSubmenu actionButtonSubmenu = ActionMenuPresenter.this.mActionButtonPopup;
            if (actionButtonSubmenu != null) {
                return actionButtonSubmenu.getPopup();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OpenOverflowRunnable implements Runnable {
        private OverflowPopup mPopup;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.mPopup = overflowPopup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((BaseMenuPresenter) ActionMenuPresenter.this).mMenu != null) {
                ((BaseMenuPresenter) ActionMenuPresenter.this).mMenu.changeMenuMode();
            }
            View view = (View) ((BaseMenuPresenter) ActionMenuPresenter.this).mMenuView;
            int dimensionPixelSize = ((BaseMenuPresenter) ActionMenuPresenter.this).mContext.getResources().getDimensionPixelSize(C0419R.dimen.sesl_action_menu_view_padding_end);
            if (view != null && view.getWindowToken() != null && this.mPopup.tryShow(dimensionPixelSize, 0)) {
                ActionMenuPresenter.this.mOverflowPopup = this.mPopup;
            }
            ActionMenuPresenter.this.mPostedOpenRunnable = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OverflowImageView extends AppCompatImageView {
        private Configuration mConfiguration;
        private SeslShowButtonShapesHelper mSBSHelper;

        public OverflowImageView(Context context) {
            super(context, null, C0419R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setLongClickable(true);
            Resources resources = getResources();
            ActionMenuPresenter.this.mTooltipText = resources.getString(C0419R.string.sesl_action_menu_overflow_description);
            TooltipCompat.setTooltipText(this, ActionMenuPresenter.this.mTooltipText);
            if (Build.VERSION.SDK_INT <= 27) {
                this.mSBSHelper = new SeslShowButtonShapesHelper(this, ResourcesCompat.getDrawable(resources, C0419R.drawable.sesl_more_button_show_button_shapes_background, null), getBackground());
            }
            this.mConfiguration = ((BaseMenuPresenter) ActionMenuPresenter.this).mContext.getResources().getConfiguration();
        }

        @Override // android.view.View
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            Configuration configuration2 = this.mConfiguration;
            int iDiff = configuration2 != null ? configuration2.diff(configuration) : 4096;
            this.mConfiguration = configuration;
            Context context = getContext();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, C0419R.styleable.View, C0419R.attr.actionOverflowButtonStyle, 0);
            setMinimumHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(C0419R.styleable.View_android_minHeight, 0));
            typedArrayObtainStyledAttributes.recycle();
            ActionMenuPresenter.this.mTooltipText = context.getResources().getString(C0419R.string.sesl_action_menu_overflow_description);
            if ((iDiff & 4096) != 0) {
                TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(null, C0419R.styleable.AppCompatImageView, C0419R.attr.actionOverflowButtonStyle, 0);
                Drawable drawable = ContextCompat.getDrawable(context, typedArrayObtainStyledAttributes2.getResourceId(C0419R.styleable.AppCompatImageView_android_src, -1));
                if (drawable != null) {
                    setImageDrawable(drawable);
                }
                typedArrayObtainStyledAttributes2.recycle();
            }
            SeslShowButtonShapesHelper seslShowButtonShapesHelper = this.mSBSHelper;
            if (seslShowButtonShapesHelper != null) {
                seslShowButtonShapesHelper.updateOverflowButtonBackground(ContextCompat.getDrawable(context, C0419R.drawable.sesl_more_button_show_button_shapes_background));
            }
        }

        @Override // android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            SeslShowButtonShapesHelper seslShowButtonShapesHelper = this.mSBSHelper;
            if (seslShowButtonShapesHelper != null) {
                seslShowButtonShapesHelper.updateButtonBackground();
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            if (ActionMenuPresenter.this.showOverflowMenu() && isHovered()) {
                TooltipCompat.setTooltipNull(true);
            }
            return true;
        }

        @Override // android.view.View
        public boolean performLongClick() {
            TooltipCompat.seslSetNextTooltipForceActionBarPosX(true);
            TooltipCompat.seslSetNextTooltipForceBelow(true);
            return super.performLongClick();
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i, int i2, int i4, int i5) {
            boolean frame = super.setFrame(i, i2, i4, i5);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int paddingLeft = (getPaddingLeft() - getPaddingRight()) / 2;
                DrawableCompat.setHotspotBounds(background, paddingLeft, 0, width + paddingLeft, height);
            }
            return frame;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class OverflowMenuButton extends FrameLayout implements ActionMenuView.ActionMenuChildView {
        private static final int BADGE_LIMIT_NUMBER = 99;
        private ViewGroup mBadgeBackground;
        private CharSequence mBadgeContentDescription;
        private TextView mBadgeText;
        private CharSequence mContentDescription;
        private View mInnerView;

        public OverflowMenuButton(Context context) {
            super(context);
            View overflowTextView = ActionMenuPresenter.this.mUseTextItemMode ? ActionMenuPresenter.this.new OverflowTextView(context) : ActionMenuPresenter.this.new OverflowImageView(context);
            this.mInnerView = overflowTextView;
            addView(overflowTextView, new FrameLayout.LayoutParams(-2, -2));
            Resources resources = getResources();
            View view = this.mInnerView;
            if (view instanceof OverflowImageView) {
                this.mContentDescription = view.getContentDescription();
                StringBuilder sb = new StringBuilder();
                sb.append((Object) this.mContentDescription);
                sb.append(" , ");
                this.mBadgeContentDescription = AbstractC0000a.m12i(resources, C0419R.string.sesl_preferecne_badge_description, sb);
            }
            if (TextUtils.isEmpty(this.mContentDescription)) {
                String string = resources.getString(C0419R.string.sesl_action_menu_overflow_description);
                this.mContentDescription = string;
                View view2 = this.mInnerView;
                if (view2 != null) {
                    view2.setContentDescription(string);
                }
            }
            ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0419R.layout.sesl_action_menu_item_badge, (ViewGroup) this, false);
            this.mBadgeBackground = viewGroup;
            this.mBadgeText = (TextView) viewGroup.getChildAt(0);
            addView(this.mBadgeBackground);
        }

        public View getInnerView() {
            return this.mInnerView;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerAfter() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerBefore() {
            return false;
        }

        @Override // android.view.View
        public void onConfigurationChanged(Configuration configuration) {
            float dimension;
            super.onConfigurationChanged(configuration);
            Resources resources = getResources();
            this.mBadgeText.setTextSize(0, (int) resources.getDimension(C0419R.dimen.sesl_menu_item_badge_text_size));
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mBadgeBackground.getLayoutParams();
            CharSequence text = this.mBadgeText.getText();
            if (text == null || text.toString() == null) {
                float dimension2 = resources.getDimension(C0419R.dimen.sesl_badge_default_width);
                if (text != null) {
                    dimension = resources.getDimension(C0419R.dimen.sesl_badge_additional_width) * text.length();
                } else {
                    dimension = 0.0f;
                }
                marginLayoutParams.width = (int) (dimension2 + dimension);
                marginLayoutParams.height = (int) (resources.getDimension(C0419R.dimen.sesl_badge_additional_width) + resources.getDimension(C0419R.dimen.sesl_badge_default_width));
                marginLayoutParams.topMargin = (int) getResources().getDimension(C0419R.dimen.sesl_menu_item_number_badge_top_margin);
                marginLayoutParams.setMarginEnd((int) resources.getDimension(C0419R.dimen.sesl_menu_item_number_badge_end_margin));
            } else {
                marginLayoutParams.width = (int) resources.getDimension(C0419R.dimen.sesl_menu_item_badge_size);
                marginLayoutParams.height = (int) resources.getDimension(C0419R.dimen.sesl_menu_item_badge_size);
            }
            this.mBadgeBackground.setLayoutParams(marginLayoutParams);
            if (this.mInnerView instanceof OverflowImageView) {
                this.mContentDescription = getContentDescription();
                StringBuilder sb = new StringBuilder();
                sb.append((Object) this.mContentDescription);
                sb.append(" , ");
                this.mBadgeContentDescription = AbstractC0000a.m12i(resources, C0419R.string.sesl_preferecne_badge_description, sb);
            }
            if (TextUtils.isEmpty(this.mContentDescription)) {
                this.mContentDescription = resources.getString(C0419R.string.sesl_action_menu_overflow_description);
                StringBuilder sb2 = new StringBuilder();
                sb2.append((Object) this.mContentDescription);
                sb2.append(" , ");
                this.mBadgeContentDescription = AbstractC0000a.m12i(resources, C0419R.string.sesl_preferecne_badge_description, sb2);
            }
            if (this.mBadgeBackground.getVisibility() == 0) {
                View view = this.mInnerView;
                if (view instanceof OverflowImageView) {
                    view.setContentDescription(this.mBadgeContentDescription);
                    return;
                }
                return;
            }
            View view2 = this.mInnerView;
            if (view2 instanceof OverflowImageView) {
                view2.setContentDescription(this.mContentDescription);
            }
        }

        public void setBadgeText(String str, int i) {
            String str2;
            int dimension;
            int dimension2;
            if (i > 99) {
                i = 99;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mBadgeBackground.getLayoutParams();
            if (str != null) {
                dimension = (int) getResources().getDimension(C0419R.dimen.sesl_menu_item_badge_size);
                dimension2 = (int) getResources().getDimension(C0419R.dimen.sesl_menu_item_badge_size);
                str2 = "";
            } else {
                str2 = ActionMenuPresenter.this.mNumberFormat.format(i);
                dimension = (int) ((getResources().getDimension(C0419R.dimen.sesl_badge_additional_width) * str2.length()) + getResources().getDimension(C0419R.dimen.sesl_badge_default_width));
                dimension2 = (int) (getResources().getDimension(C0419R.dimen.sesl_badge_additional_width) + getResources().getDimension(C0419R.dimen.sesl_badge_default_width));
                marginLayoutParams.topMargin = (int) getResources().getDimension(C0419R.dimen.sesl_menu_item_number_badge_top_margin);
                marginLayoutParams.setMarginEnd((int) getResources().getDimension(C0419R.dimen.sesl_menu_item_number_badge_end_margin));
            }
            this.mBadgeText.setText(str2);
            marginLayoutParams.width = dimension;
            marginLayoutParams.height = dimension2;
            this.mBadgeBackground.setLayoutParams(marginLayoutParams);
            this.mBadgeBackground.setVisibility(i > 0 ? 0 : 8);
            if (this.mBadgeBackground.getVisibility() == 0) {
                View view = this.mInnerView;
                if (view instanceof OverflowImageView) {
                    view.setContentDescription(this.mBadgeContentDescription);
                    return;
                }
                return;
            }
            View view2 = this.mInnerView;
            if (view2 instanceof OverflowImageView) {
                view2.setContentDescription(this.mContentDescription);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OverflowPopup extends MenuPopupHelper {
        public OverflowPopup(Context context, MenuBuilder menuBuilder, View view, boolean z) {
            super(context, menuBuilder, view, z, C0419R.attr.actionOverflowMenuStyle);
            setGravity(8388613);
            setPresenterCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public void onDismiss() {
            if (((BaseMenuPresenter) ActionMenuPresenter.this).mMenu != null) {
                ((BaseMenuPresenter) ActionMenuPresenter.this).mMenu.close();
            }
            ActionMenuPresenter.this.mOverflowPopup = null;
            super.onDismiss();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OverflowTextView extends AppCompatTextView {
        private SeslShowButtonShapesHelper mSBBHelper;

        public OverflowTextView(Context context) {
            super(context, null, C0419R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, C0419R.styleable.AppCompatTheme, 0, 0);
            TextViewCompat.setTextAppearance(this, typedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.AppCompatTheme_actionMenuTextAppearance, 0));
            typedArrayObtainStyledAttributes.recycle();
            Resources resources = getResources();
            setText(resources.getString(C0419R.string.sesl_more_item_label));
            ActionMenuPresenter.this.mIsLightTheme = SeslMisc.isLightTheme(context);
            if (ActionMenuPresenter.this.mIsLightTheme) {
                setBackgroundResource(C0419R.drawable.sesl_action_bar_item_text_background_light);
            } else {
                setBackgroundResource(C0419R.drawable.sesl_action_bar_item_text_background_dark);
            }
            if (Build.VERSION.SDK_INT > 27) {
                seslSetButtonShapeEnabled(true);
            } else {
                this.mSBBHelper = new SeslShowButtonShapesHelper(this, ResourcesCompat.getDrawable(resources, C0419R.drawable.sesl_action_text_button_show_button_shapes_background, null), getBackground());
            }
        }

        @Override // android.widget.TextView, android.view.View
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            SeslShowButtonShapesHelper seslShowButtonShapesHelper = this.mSBBHelper;
            if (seslShowButtonShapesHelper != null) {
                seslShowButtonShapesHelper.updateButtonBackground();
            }
        }

        @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            SeslShowButtonShapesHelper seslShowButtonShapesHelper = this.mSBBHelper;
            if (seslShowButtonShapesHelper != null) {
                seslShowButtonShapesHelper.updateButtonBackground();
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.showOverflowMenu();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class PopupPresenterCallback implements MenuPresenter.Callback {
        public PopupPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.getRootMenu().close(false);
            }
            MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
            if (menuBuilder == ((BaseMenuPresenter) ActionMenuPresenter.this).mMenu) {
                return false;
            }
            ActionMenuPresenter.this.mOpenSubMenuId = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                return callback.onOpenSubMenu(menuBuilder);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.appcompat.widget.ActionMenuPresenter.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int openSubMenuId;

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.openSubMenuId);
        }

        public SavedState(Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, C0419R.layout.sesl_action_menu_layout, C0419R.layout.sesl_action_menu_item_layout);
        this.mActionButtonGroups = new SparseBooleanArray();
        this.mPopupPresenterCallback = new PopupPresenterCallback();
        this.mIsLightTheme = false;
        this.mNumberFormat = NumberFormat.getInstance(Locale.getDefault());
        this.mUseTextItemMode = context.getResources().getBoolean(C0419R.bool.sesl_action_bar_text_item_mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View findViewForItem(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof MenuView.ItemView) && ((MenuView.ItemView) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public void bindItemView(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.initialize(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.mMenuView);
        if (this.mPopupCallback == null) {
            this.mPopupCallback = new ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.mPopupCallback);
    }

    public boolean dismissPopupMenus() {
        return hideOverflowMenu() | hideSubMenus();
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.mOverflowButton) {
            return false;
        }
        return super.filterLeftoverView(viewGroup, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.widget.ActionMenuPresenter] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r15v1, types: [androidx.appcompat.view.menu.MenuItemImpl] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        ArrayList<MenuItemImpl> visibleItems;
        int size;
        int iMeasureChildForCells;
        int i;
        ?? r02;
        int i2;
        ActionMenuPresenter actionMenuPresenter = this;
        MenuBuilder menuBuilder = actionMenuPresenter.mMenu;
        View view = null;
        ?? r32 = 0;
        if (menuBuilder != null) {
            visibleItems = menuBuilder.getVisibleItems();
            size = visibleItems.size();
        } else {
            visibleItems = null;
            size = 0;
        }
        int i4 = actionMenuPresenter.mMaxItems;
        int i5 = actionMenuPresenter.mActionItemWidthLimit;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        Object obj = actionMenuPresenter.mMenuView;
        if (obj == null) {
            Log.d(TAG, "mMenuView is null, maybe Menu has not been initialized.");
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) obj;
        boolean z = false;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            MenuItemImpl menuItemImpl = visibleItems.get(i8);
            if (menuItemImpl.requiresActionButton()) {
                i6++;
            } else if (menuItemImpl.requestsActionButton()) {
                i7++;
            } else {
                z = true;
            }
            if (actionMenuPresenter.mExpandedActionViewsExclusive && menuItemImpl.isActionViewExpanded()) {
                i4 = 0;
            }
        }
        if (actionMenuPresenter.mReserveOverflow && (z || i7 + i6 > i4)) {
            i4--;
        }
        int i9 = i4 - i6;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.mActionButtonGroups;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.mStrictWidthLimit) {
            int i10 = actionMenuPresenter.mMinCellSize;
            iMeasureChildForCells = i5 / i10;
            i = ((i5 % i10) / iMeasureChildForCells) + i10;
        } else {
            iMeasureChildForCells = 0;
            i = 0;
        }
        int i11 = 0;
        int i12 = 0;
        ?? r03 = actionMenuPresenter;
        while (i11 < size) {
            MenuItemImpl menuItemImpl2 = visibleItems.get(i11);
            if (menuItemImpl2.requiresActionButton()) {
                View itemView = r03.getItemView(menuItemImpl2, view, viewGroup);
                if (r03.mStrictWidthLimit) {
                    iMeasureChildForCells -= ActionMenuView.measureChildForCells(itemView, i, iMeasureChildForCells, iMakeMeasureSpec, r32);
                } else {
                    itemView.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = itemView.getMeasuredWidth();
                i5 -= measuredWidth;
                if (i12 == 0) {
                    i12 = measuredWidth;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                menuItemImpl2.setIsActionButton(true);
                r02 = r32;
                i2 = size;
            } else if (menuItemImpl2.requestsActionButton()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId2);
                boolean z3 = (i9 > 0 || z2) && i5 > 0 && (!r03.mStrictWidthLimit || iMeasureChildForCells > 0);
                boolean z4 = z3;
                i2 = size;
                if (z3) {
                    View itemView2 = r03.getItemView(menuItemImpl2, null, viewGroup);
                    if (r03.mStrictWidthLimit) {
                        int iMeasureChildForCells2 = ActionMenuView.measureChildForCells(itemView2, i, iMeasureChildForCells, iMakeMeasureSpec, 0);
                        iMeasureChildForCells -= iMeasureChildForCells2;
                        if (iMeasureChildForCells2 == 0) {
                            z4 = false;
                        }
                    } else {
                        itemView2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z5 = z4;
                    int measuredWidth2 = itemView2.getMeasuredWidth();
                    i5 -= measuredWidth2;
                    if (i12 == 0) {
                        i12 = measuredWidth2;
                    }
                    z3 = z5 & (i5 >= 0);
                }
                if (z3 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z2) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i13 = 0; i13 < i11; i13++) {
                        MenuItemImpl menuItemImpl3 = visibleItems.get(i13);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.isActionButton()) {
                                i9++;
                            }
                            menuItemImpl3.setIsActionButton(false);
                        }
                    }
                }
                if (z3) {
                    i9--;
                }
                menuItemImpl2.setIsActionButton(z3);
                r02 = 0;
            } else {
                r02 = r32;
                i2 = size;
                menuItemImpl2.setIsActionButton(r02);
            }
            i11++;
            r32 = r02;
            size = i2;
            view = null;
            r03 = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.hasCollapsibleActionView()) {
            actionView = super.getItemView(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        MenuView menuView = this.mMenuView;
        MenuView menuView2 = super.getMenuView(viewGroup);
        if (menuView != menuView2) {
            ((ActionMenuView) menuView2).setPresenter(this);
        }
        return menuView2;
    }

    public Drawable getOverflowIcon() {
        if (this.mUseTextItemMode) {
            return null;
        }
        OverflowMenuButton overflowMenuButton = this.mOverflowButton;
        if (overflowMenuButton != null) {
            return ((AppCompatImageView) overflowMenuButton.getInnerView()).getDrawable();
        }
        if (this.mPendingOverflowIconSet) {
            return this.mPendingOverflowIcon;
        }
        return null;
    }

    public boolean hideOverflowMenu() {
        Object obj;
        OpenOverflowRunnable openOverflowRunnable = this.mPostedOpenRunnable;
        if (openOverflowRunnable != null && (obj = this.mMenuView) != null) {
            ((View) obj).removeCallbacks(openOverflowRunnable);
            this.mPostedOpenRunnable = null;
            return true;
        }
        OverflowPopup overflowPopup = this.mOverflowPopup;
        if (overflowPopup == null) {
            return false;
        }
        overflowPopup.dismiss();
        return true;
    }

    public boolean hideSubMenus() {
        ActionButtonSubmenu actionButtonSubmenu = this.mActionButtonPopup;
        if (actionButtonSubmenu == null) {
            return false;
        }
        actionButtonSubmenu.dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context context, @Nullable MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = actionBarPolicy.showsOverflowMenuButton();
        }
        if (!this.mWidthLimitSet) {
            this.mWidthLimit = actionBarPolicy.getEmbeddedMenuWidthLimit();
        }
        if (!this.mMaxItemsSet) {
            this.mMaxItems = actionBarPolicy.getMaxActionButtons();
        }
        int measuredWidth = this.mWidthLimit;
        if (this.mReserveOverflow) {
            if (this.mOverflowButton == null) {
                OverflowMenuButton overflowMenuButton = new OverflowMenuButton(this.mSystemContext);
                this.mOverflowButton = overflowMenuButton;
                overflowMenuButton.setId(C0419R.id.sesl_action_bar_overflow_button);
                if (this.mPendingOverflowIconSet) {
                    if (this.mUseTextItemMode) {
                        ((AppCompatImageView) this.mOverflowButton.getInnerView()).setImageDrawable(this.mPendingOverflowIcon);
                    }
                    this.mPendingOverflowIcon = null;
                    this.mPendingOverflowIconSet = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.mOverflowButton.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.mOverflowButton.getMeasuredWidth();
        } else {
            this.mOverflowButton = null;
        }
        this.mActionItemWidthLimit = measuredWidth;
        this.mMinCellSize = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public boolean isOverflowMenuShowPending() {
        return this.mPostedOpenRunnable != null || isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowing() {
        OverflowPopup overflowPopup = this.mOverflowPopup;
        return overflowPopup != null && overflowPopup.isShowing();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        dismissPopupMenus();
        super.onCloseMenu(menuBuilder, z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        OverflowMenuButton overflowMenuButton;
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(this.mContext);
        if (!this.mMaxItemsSet) {
            this.mMaxItems = actionBarPolicy.getMaxActionButtons();
        }
        if (!this.mWidthLimitSet) {
            this.mWidthLimit = actionBarPolicy.getEmbeddedMenuWidthLimit();
        }
        if (!this.mReserveOverflow || (overflowMenuButton = this.mOverflowButton) == null) {
            this.mActionItemWidthLimit = this.mWidthLimit;
        } else {
            this.mActionItemWidthLimit = this.mWidthLimit - overflowMenuButton.getMeasuredWidth();
        }
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder != null) {
            menuBuilder.onItemsChanged(true);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        MenuBuilder menuBuilder;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof SavedState) && (i = ((SavedState) parcelable).openSubMenuId) > 0 && (menuBuilder = this.mMenu) != null && (menuItemFindItem = menuBuilder.findItem(i)) != null) {
            onSubMenuSelected((SubMenuBuilder) menuItemFindItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.openSubMenuId = this.mOpenSubMenuId;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean z = false;
        if (subMenuBuilder == null || !subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.getParentMenu() != this.mMenu) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.getParentMenu();
        }
        View viewFindViewForItem = findViewForItem(subMenuBuilder2.getItem());
        if (viewFindViewForItem == null) {
            return false;
        }
        this.mOpenSubMenuId = subMenuBuilder.getItem().getItemId();
        int size = subMenuBuilder.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = subMenuBuilder.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        ActionButtonSubmenu actionButtonSubmenu = new ActionButtonSubmenu(this.mContext, subMenuBuilder, viewFindViewForItem);
        this.mActionButtonPopup = actionButtonSubmenu;
        actionButtonSubmenu.setForceShowIcon(z);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(subMenuBuilder);
        return true;
    }

    @Override // androidx.core.view.ActionProvider.SubUiVisibilityListener
    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.onSubMenuSelected(null);
            return;
        }
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder != null) {
            menuBuilder.close(false);
        }
    }

    @Nullable
    public MenuPopupHelper seslGetOverflowPopup() {
        return this.mOverflowPopup;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.mExpandedActionViewsExclusive = z;
    }

    public void setItemLimit(int i) {
        this.mMaxItems = i;
        this.mMaxItemsSet = true;
    }

    public void setMenuView(ActionMenuView actionMenuView) {
        this.mMenuView = actionMenuView;
        actionMenuView.initialize(this.mMenu);
    }

    public void setOverflowIcon(Drawable drawable) {
        if (this.mUseTextItemMode) {
            return;
        }
        OverflowMenuButton overflowMenuButton = this.mOverflowButton;
        if (overflowMenuButton != null) {
            ((AppCompatImageView) overflowMenuButton.getInnerView()).setImageDrawable(drawable);
        } else {
            this.mPendingOverflowIconSet = true;
            this.mPendingOverflowIcon = drawable;
        }
    }

    public void setReserveOverflow(boolean z) {
        this.mReserveOverflow = z;
        this.mReserveOverflowSet = true;
    }

    public void setWidthLimit(int i, boolean z) {
        this.mWidthLimit = i;
        this.mStrictWidthLimit = z;
        this.mWidthLimitSet = true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean shouldIncludeItem(int i, MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }

    public boolean showOverflowMenu() {
        MenuBuilder menuBuilder;
        if (!this.mReserveOverflow || isOverflowMenuShowing() || (menuBuilder = this.mMenu) == null || this.mMenuView == null || this.mPostedOpenRunnable != null || menuBuilder.getNonActionItems().isEmpty()) {
            return false;
        }
        OpenOverflowRunnable openOverflowRunnable = new OpenOverflowRunnable(new OverflowPopup(this.mContext, this.mMenu, this.mOverflowButton, true));
        this.mPostedOpenRunnable = openOverflowRunnable;
        ((View) this.mMenuView).post(openOverflowRunnable);
        return true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        MenuView menuView;
        super.updateMenuView(z);
        Object obj = this.mMenuView;
        if (obj != null) {
            ((View) obj).requestLayout();
        }
        MenuBuilder menuBuilder = this.mMenu;
        boolean z2 = false;
        if (menuBuilder != null) {
            ArrayList<MenuItemImpl> actionItems = menuBuilder.getActionItems();
            int size = actionItems.size();
            for (int i = 0; i < size; i++) {
                ActionProvider supportActionProvider = actionItems.get(i).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        MenuBuilder menuBuilder2 = this.mMenu;
        ArrayList<MenuItemImpl> nonActionItems = menuBuilder2 != null ? menuBuilder2.getNonActionItems() : null;
        if (this.mReserveOverflow && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z2 = !nonActionItems.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.mOverflowButton == null) {
                OverflowMenuButton overflowMenuButton = new OverflowMenuButton(this.mSystemContext);
                this.mOverflowButton = overflowMenuButton;
                overflowMenuButton.setId(C0419R.id.sesl_action_bar_overflow_button);
            }
            ViewGroup viewGroup = (ViewGroup) this.mOverflowButton.getParent();
            if (viewGroup != this.mMenuView) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.mOverflowButton);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.mMenuView;
                if (actionMenuView != null) {
                    actionMenuView.addView(this.mOverflowButton, actionMenuView.generateOverflowButtonLayoutParams());
                }
            }
        } else {
            OverflowMenuButton overflowMenuButton2 = this.mOverflowButton;
            if (overflowMenuButton2 != null) {
                Object parent = overflowMenuButton2.getParent();
                Object obj2 = this.mMenuView;
                if (parent == obj2) {
                    if (obj2 != null) {
                        ((ViewGroup) obj2).removeView(this.mOverflowButton);
                    }
                    if (isOverflowMenuShowing()) {
                        hideOverflowMenu();
                    }
                }
            }
        }
        if (this.mOverflowButton != null && (menuView = this.mMenuView) != null) {
            ActionMenuView actionMenuView2 = (ActionMenuView) menuView;
            this.mOverflowButton.setBadgeText(actionMenuView2.getOverflowBadgeText(), actionMenuView2.getSumOfDigitsInBadges());
        }
        OverflowMenuButton overflowMenuButton3 = this.mOverflowButton;
        if ((overflowMenuButton3 == null || overflowMenuButton3.getVisibility() != 0) && isOverflowMenuShowing()) {
            hideOverflowMenu();
        }
        MenuView menuView2 = this.mMenuView;
        if (menuView2 != null) {
            ((ActionMenuView) menuView2).setOverflowReserved(this.mReserveOverflow);
        }
    }
}
