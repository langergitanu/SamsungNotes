package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.SeslDropDownItemTextView;
import androidx.appcompat.widget.TintTypedArray;
import java.text.NumberFormat;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView, AbsListView.SelectionBoundsAdjuster {
    private static final int BADGE_LIMIT_NUMBER = 99;
    private static final String TAG = "ListMenuItemView";
    private Drawable mBackground;
    private TextView mBadgeView;
    private CheckBox mCheckBox;
    private LinearLayout mContent;
    private SeslDropDownItemTextView mDropDownItemTextView;
    private boolean mForceShowIcon;
    private ImageView mGroupDivider;
    private boolean mHasListDivider;
    private ImageView mIconView;
    private LayoutInflater mInflater;
    private boolean mIsSubMenu;
    private MenuItemImpl mItemData;
    private NumberFormat mNumberFormat;
    private boolean mPreserveIconSpacing;
    private RadioButton mRadioButton;
    private TextView mShortcutView;
    private Drawable mSubMenuArrow;
    private ImageView mSubMenuArrowView;
    private int mTextAppearance;
    private Context mTextAppearanceContext;
    private LinearLayout mTitleParent;
    private TextView mTitleView;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0419R.attr.listMenuViewStyle);
    }

    private void addContentView(View view) {
        addContentView(view, -1);
    }

    private LayoutInflater getInflater() {
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(getContext());
        }
        return this.mInflater;
    }

    private void insertCheckBox() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(C0419R.layout.sesl_list_menu_item_checkbox, (ViewGroup) this, false);
        this.mCheckBox = checkBox;
        addContentView(checkBox);
    }

    private void insertIconView() {
        if (this.mIsSubMenu) {
            return;
        }
        ImageView imageView = (ImageView) getInflater().inflate(C0419R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
        this.mIconView = imageView;
        addContentView(imageView, 0);
    }

    private void insertRadioButton() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(C0419R.layout.sesl_list_menu_item_radio, (ViewGroup) this, false);
        this.mRadioButton = radioButton;
        addContentView(radioButton);
    }

    private boolean isNumericValue(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    private void seslCheckMaxFontScale(TextView textView, int i) {
        float f = getResources().getConfiguration().fontScale;
        if (f > 1.2f) {
            textView.setTextSize(0, (i / f) * 1.2f);
        }
    }

    private void setBadgeText(String str) {
        if (this.mBadgeView == null) {
            this.mBadgeView = (TextView) findViewById(C0419R.id.menu_badge);
        }
        if (this.mBadgeView == null) {
            Log.i(TAG, "SUB_MENU_ITEM_LAYOUT case, mBadgeView is null");
            return;
        }
        if (this.mTitleParent == null) {
            Log.i(TAG, "mTitleParent is null");
            return;
        }
        Resources resources = getResources();
        float dimension = resources.getDimension(C0419R.dimen.sesl_badge_additional_width);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mBadgeView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleParent.getLayoutParams();
        if (isNumericValue(str)) {
            String str2 = this.mNumberFormat.format(Math.min(Integer.parseInt(str), 99));
            seslCheckMaxFontScale(this.mBadgeView, resources.getDimensionPixelSize(C0419R.dimen.sesl_menu_item_badge_text_size));
            this.mBadgeView.setText(str2);
            int length = (int) ((str2.length() * dimension) + resources.getDimension(C0419R.dimen.sesl_badge_default_width));
            int dimension2 = (int) (resources.getDimension(C0419R.dimen.sesl_badge_default_width) + dimension);
            layoutParams.width = length;
            layoutParams.height = dimension2;
            layoutParams.addRule(15, -1);
            this.mBadgeView.setLayoutParams(layoutParams);
        } else {
            layoutParams.topMargin = (int) resources.getDimension(C0419R.dimen.sesl_list_menu_item_dot_badge_top_margin);
            layoutParams2.width = -2;
            this.mTitleParent.setLayoutParams(layoutParams2);
            this.mBadgeView.setLayoutParams(layoutParams);
        }
        int i = layoutParams.width;
        if (str != null) {
            this.mTitleParent.setPaddingRelative(0, 0, getResources().getDimensionPixelSize(C0419R.dimen.sesl_list_menu_item_dot_badge_end_margin) + i, 0);
        }
        this.mBadgeView.setVisibility(str == null ? 8 : 0);
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.mSubMenuArrowView;
        if (imageView == null || this.mIsSubMenu) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.mGroupDivider;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mGroupDivider.getLayoutParams();
        rect.top = this.mGroupDivider.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.mItemData = menuItemImpl;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setTitle(menuItemImpl.getTitleForItemView(this));
        setCheckable(menuItemImpl.isCheckable());
        setShortcut(menuItemImpl.shouldShowShortcut(), menuItemImpl.getShortcut());
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        setSubMenuArrowVisible(menuItemImpl.hasSubMenu());
        setContentDescription(menuItemImpl.getContentDescription());
        setBadgeText(menuItemImpl.getBadgeText());
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.mBackground);
        SeslDropDownItemTextView seslDropDownItemTextView = (SeslDropDownItemTextView) findViewById(C0419R.id.sub_menu_title);
        this.mDropDownItemTextView = seslDropDownItemTextView;
        boolean z = seslDropDownItemTextView != null;
        this.mIsSubMenu = z;
        if (z) {
            return;
        }
        TextView textView = (TextView) findViewById(C0419R.id.title);
        this.mTitleView = textView;
        int i = this.mTextAppearance;
        if (i != -1) {
            textView.setTextAppearance(this.mTextAppearanceContext, i);
        }
        TextView textView2 = this.mTitleView;
        if (textView2 != null) {
            textView2.setSingleLine(false);
            this.mTitleView.setMaxLines(2);
        }
        this.mShortcutView = (TextView) findViewById(C0419R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(C0419R.id.submenuarrow);
        this.mSubMenuArrowView = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.mSubMenuArrow);
        }
        this.mGroupDivider = (ImageView) findViewById(C0419R.id.group_divider);
        this.mContent = (LinearLayout) findViewById(C0419R.id.content);
        this.mTitleParent = (LinearLayout) findViewById(C0419R.id.title_parent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        TextView textView = this.mBadgeView;
        if (textView == null || textView.getVisibility() != 0 || this.mBadgeView.getWidth() <= 0) {
            return;
        }
        CharSequence title = this.mItemData.getTitle();
        if (!TextUtils.isEmpty(getContentDescription())) {
            accessibilityNodeInfo.setContentDescription(getContentDescription());
            return;
        }
        accessibilityNodeInfo.setContentDescription(((Object) title) + " , " + getResources().getString(C0419R.string.sesl_action_menu_overflow_badge_description));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mIconView != null && this.mPreserveIconSpacing && !this.mIsSubMenu) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mIconView.getLayoutParams();
            int i4 = layoutParams.height;
            if (i4 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i4;
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        View view;
        if (!z && this.mRadioButton == null && this.mCheckBox == null) {
            return;
        }
        if (this.mIsSubMenu) {
            if (z) {
                this.mDropDownItemTextView.setChecked(this.mItemData.isChecked());
                return;
            }
            return;
        }
        if (this.mItemData.isExclusiveCheckable()) {
            if (this.mRadioButton == null) {
                insertRadioButton();
            }
            compoundButton = this.mRadioButton;
            view = this.mCheckBox;
        } else {
            if (this.mCheckBox == null) {
                insertCheckBox();
            }
            compoundButton = this.mCheckBox;
            view = this.mRadioButton;
        }
        if (z) {
            compoundButton.setChecked(this.mItemData.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.mCheckBox;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.mRadioButton;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.mIsSubMenu) {
            this.mDropDownItemTextView.setChecked(z);
            return;
        }
        if (this.mItemData.isExclusiveCheckable()) {
            if (this.mRadioButton == null) {
                insertRadioButton();
            }
            compoundButton = this.mRadioButton;
        } else {
            if (this.mCheckBox == null) {
                insertCheckBox();
            }
            compoundButton = this.mCheckBox;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
        this.mPreserveIconSpacing = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.mGroupDivider;
        if (imageView != null) {
            imageView.setVisibility((this.mHasListDivider || !z) ? 8 : 0);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable drawable) {
        if (this.mIsSubMenu) {
            return;
        }
        boolean z = this.mItemData.shouldShowIcon() || this.mForceShowIcon;
        if (z || this.mPreserveIconSpacing) {
            ImageView imageView = this.mIconView;
            if (imageView == null && drawable == null && !this.mPreserveIconSpacing) {
                return;
            }
            if (imageView == null) {
                insertIconView();
            }
            if (drawable == null && !this.mPreserveIconSpacing) {
                this.mIconView.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.mIconView;
            if (!z) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.mIconView.getVisibility() != 0) {
                this.mIconView.setVisibility(0);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c) {
        if (this.mIsSubMenu) {
            return;
        }
        int i = (z && this.mItemData.shouldShowShortcut()) ? 0 : 8;
        if (i == 0) {
            this.mShortcutView.setText(this.mItemData.getShortcutLabel());
        }
        if (this.mShortcutView.getVisibility() != i) {
            this.mShortcutView.setVisibility(i);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        if (this.mIsSubMenu) {
            if (charSequence == null) {
                if (this.mDropDownItemTextView.getVisibility() != 8) {
                    this.mDropDownItemTextView.setVisibility(8);
                    return;
                }
                return;
            } else {
                this.mDropDownItemTextView.setText(charSequence);
                if (this.mDropDownItemTextView.getVisibility() != 0) {
                    this.mDropDownItemTextView.setVisibility(0);
                    return;
                }
                return;
            }
        }
        if (charSequence == null) {
            if (this.mTitleView.getVisibility() != 8) {
                this.mTitleView.setVisibility(8);
            }
        } else {
            this.mTitleView.setText(charSequence);
            if (this.mTitleView.getVisibility() != 0) {
                this.mTitleView.setVisibility(0);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return this.mForceShowIcon;
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mIsSubMenu = false;
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, C0419R.styleable.MenuView, i, 0);
        this.mBackground = tintTypedArrayObtainStyledAttributes.getDrawable(C0419R.styleable.MenuView_android_itemBackground);
        this.mTextAppearance = tintTypedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.MenuView_android_itemTextAppearance, -1);
        this.mPreserveIconSpacing = tintTypedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.MenuView_preserveIconSpacing, false);
        this.mTextAppearanceContext = context;
        this.mSubMenuArrow = tintTypedArrayObtainStyledAttributes.getDrawable(C0419R.styleable.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, C0419R.attr.dropDownListViewStyle, 0);
        this.mHasListDivider = typedArrayObtainStyledAttributes.hasValue(0);
        tintTypedArrayObtainStyledAttributes.recycle();
        typedArrayObtainStyledAttributes.recycle();
        this.mNumberFormat = NumberFormat.getInstance(Locale.getDefault());
    }

    private void addContentView(View view, int i) {
        LinearLayout linearLayout = this.mContent;
        if (linearLayout != null) {
            linearLayout.addView(view, i);
        } else {
            addView(view, i);
        }
    }
}
