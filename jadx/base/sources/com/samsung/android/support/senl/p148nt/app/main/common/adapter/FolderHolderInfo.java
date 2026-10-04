package com.samsung.android.support.senl.p148nt.app.main.common.adapter;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.res.ResourcesCompat;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FontUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderHolderInfo {
    private static final String TAG = "FolderHolderInfo";
    private ImageView mArrowIcon;
    private View mArrowIconLayout;
    private CheckBox mCheckBox;
    private int mColor;
    private int mCount;
    private int mDepth;
    private View mFolderItem;
    private View mFolderItemContainer;
    private View mFolderItemLayout;
    private boolean mHasChild;
    private View mIconLayout;
    private boolean mIsExpanded;
    private View mSelectedHolderLayout;
    private SwitchCompat mSyncSwitch;
    private String mTitle;
    private TextView mTitleView;
    private View mTouchedView;
    private String mUuid;
    private int mViewType;
    private final float[] mTouchPos = {-1.0f, -1.0f};
    private boolean mIsSolid = false;

    private void inflateCheckBox() {
        if (this.mCheckBox == null) {
            CheckBox checkBox = (CheckBox) ViewModeUtils.getInflatedView(this.mFolderItemContainer, C8003R.id.checkbox, C8003R.id.inflate_checkbox);
            this.mCheckBox = checkBox;
            checkBox.setImportantForAccessibility(2);
            this.mCheckBox.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.adapter.FolderHolderInfo.1
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        FolderHolderInfo.this.mFolderItemContainer.requestFocus();
                    }
                }
            });
        }
    }

    private void inflateFolderSyncSwitch() {
        if (this.mSyncSwitch == null) {
            SwitchCompat switchCompat = (SwitchCompat) ViewModeUtils.getInflatedView(this.mFolderItemContainer, C8003R.id.folder_to_sync_switch, C8003R.id.inflate_folder_to_sync_switch);
            this.mSyncSwitch = switchCompat;
            switchCompat.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.adapter.FolderHolderInfo.2
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        FolderHolderInfo.this.mFolderItemContainer.requestFocus();
                    }
                }
            });
        }
    }

    public View getArrowIconLayout() {
        return this.mArrowIconLayout;
    }

    public CheckBox getCheckBox() {
        inflateCheckBox();
        return this.mCheckBox;
    }

    public int getColor() {
        return this.mColor;
    }

    public int getCount() {
        return this.mCount;
    }

    public int getDepth() {
        return this.mDepth;
    }

    public View getFolderItemContainer() {
        return this.mFolderItemContainer;
    }

    public View getFolderItemLayout() {
        return this.mFolderItemLayout;
    }

    public SwitchCompat getFolderSyncSwitch() {
        inflateFolderSyncSwitch();
        return this.mSyncSwitch;
    }

    public View getIconLayout() {
        return this.mIconLayout;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public float[] getTouchPos() {
        float[] fArr = this.mTouchPos;
        if (fArr[0] >= 0.0f && fArr[1] >= 0.0f) {
            return fArr;
        }
        MainLogger.m7259w(TAG, "getTouchPos, do not defined touch pos, return root vie center");
        return new float[]{Math.abs((this.mFolderItemContainer.getRight() - this.mFolderItemContainer.getLeft()) / 2), Math.abs((this.mFolderItemContainer.getBottom() - this.mFolderItemContainer.getTop()) / 2)};
    }

    public View getTouchedView() {
        View view = this.mTouchedView;
        if (view != null) {
            return view;
        }
        MainLogger.m7259w(TAG, "getTouchedView, do not defined touched view, return root view");
        return this.mFolderItemContainer;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public int getViewType() {
        return this.mViewType;
    }

    public boolean hasChild() {
        return this.mHasChild;
    }

    public boolean isCheckboxVisible() {
        CheckBox checkBox = this.mCheckBox;
        return checkBox != null && checkBox.getVisibility() == 0;
    }

    public boolean isExpanded() {
        return this.mIsExpanded;
    }

    public boolean isFolderSyncSwitch() {
        return this.mSyncSwitch != null;
    }

    public boolean isSolid() {
        return this.mIsSolid;
    }

    public void setArrow(ImageView imageView) {
        this.mArrowIcon = imageView;
    }

    public void setArrowExpanded(boolean z, String str) {
        View view = this.mIconLayout;
        if (view == null) {
            return;
        }
        this.mIsExpanded = !z;
        view.setContentDescription(view.getResources().getString(C8003R.string.ps_button_tts, this.mIconLayout.getResources().getString(z ? C8003R.string.folder_expand_tts : C8003R.string.folder_collapse_tts)));
        if (FolderConstants.MyFolders.UUID.equals(str)) {
            ((ImageView) this.mIconLayout.findViewById(C8003R.id.icon)).setImageResource(FolderUtils.getFolderHomeDrawable(this.mIsExpanded, this.mIsSolid));
            return;
        }
        if (this.mArrowIcon == null) {
            return;
        }
        PathInterpolator pathInterpolator = new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f);
        if (z) {
            this.mArrowIcon.animate().setDuration(200L).setInterpolator(pathInterpolator).rotation(LocaleUtils.isRTLMode() ? 90.0f : -90.0f).start();
        } else {
            this.mArrowIcon.animate().setDuration(200L).setInterpolator(pathInterpolator).rotation(0.0f).start();
        }
        ((ImageView) this.mIconLayout.findViewById(C8003R.id.icon)).setImageResource(FolderUtils.getUserFolderDrawable(this.mIsExpanded, this.mIsSolid));
    }

    public void setArrowIconLayout(View view) {
        this.mArrowIconLayout = view;
    }

    public void setBackground(int i, int i2) {
        setBackground(i, i2, false);
    }

    public FolderHolderInfo setColor(int i) {
        this.mColor = i;
        return this;
    }

    public FolderHolderInfo setCount(int i) {
        this.mCount = i;
        return this;
    }

    public FolderHolderInfo setDepth(int i) {
        this.mDepth = i;
        return this;
    }

    public FolderHolderInfo setExpanded(boolean z) {
        this.mIsExpanded = z;
        return this;
    }

    public FolderHolderInfo setFolderItem(View view) {
        this.mFolderItem = view;
        return this;
    }

    public FolderHolderInfo setFolderItemContainer(View view) {
        this.mFolderItemContainer = view;
        return this;
    }

    public FolderHolderInfo setFolderItemLayout(View view) {
        this.mFolderItemLayout = view;
        return this;
    }

    public FolderHolderInfo setHasChild(boolean z) {
        this.mHasChild = z;
        return this;
    }

    public void setHighlightSelectedFolder(boolean z) {
        ImageView imageView;
        FontUtils.setFont(this.mTitleView, z ? "Roboto_Medium" : "Roboto_Regular");
        View view = this.mSelectedHolderLayout;
        if (view == null || (imageView = (ImageView) view.findViewById(C8003R.id.icon)) == null) {
            return;
        }
        this.mSelectedHolderLayout.setSelected(z);
        if (z) {
            this.mSelectedHolderLayout.setBackgroundResource(C8003R.drawable.drawer_item_selector_bg);
        } else {
            this.mSelectedHolderLayout.setBackgroundResource(C8003R.color.transparent);
        }
        imageView.setImageResource(FolderUtils.getDrawerFolderDrawable(getUuid(), z, this.mIsExpanded, hasChild()));
    }

    public void setIconLayout(View view) {
        this.mIconLayout = view;
    }

    public void setIsSolid(boolean z) {
        this.mIsSolid = z;
    }

    public void setReorderSelected(boolean z) {
        if (!z) {
            this.mFolderItemContainer.setTranslationZ(0.0f);
            this.mFolderItemContainer.setForeground(new ColorDrawable(0));
        } else {
            Resources resources = this.mFolderItemContainer.getResources();
            this.mFolderItemContainer.setTranslationZ(resources.getDimensionPixelSize(C8003R.dimen.folder_list_item_reorder_elevation));
            this.mFolderItemContainer.setForeground(ResourcesCompat.getDrawable(resources, C8003R.drawable.reorder_selected_frame, null));
        }
    }

    public void setSelectedFolder(boolean z) {
        this.mFolderItemContainer.setSelected(z);
    }

    public FolderHolderInfo setSelectedHolderLayout(View view) {
        this.mSelectedHolderLayout = view;
        return this;
    }

    public FolderHolderInfo setTitle(String str) {
        this.mTitle = str;
        return this;
    }

    public FolderHolderInfo setTitleView(TextView textView) {
        this.mTitleView = textView;
        return this;
    }

    public void setTouchPos(float f, float f4) {
        float[] fArr = this.mTouchPos;
        fArr[0] = f;
        fArr[1] = f4;
    }

    public void setTouchedView(View view) {
        this.mTouchedView = view;
    }

    public FolderHolderInfo setUuid(String str) {
        this.mUuid = str;
        return this;
    }

    public FolderHolderInfo setViewType(int i) {
        this.mViewType = i;
        return this;
    }

    public void toggleCheckBox(boolean z) {
        if (this.mCheckBox == null) {
            inflateCheckBox();
        }
        this.mCheckBox.setChecked(z);
    }

    public void toggleFolderSyncSwitch(boolean z) {
        if (this.mSyncSwitch == null) {
            inflateFolderSyncSwitch();
        }
        this.mSyncSwitch.setChecked(z);
    }

    public void setBackground(int i, int i2, boolean z) {
        if (z) {
            this.mFolderItem.setBackground(ResourcesCompat.getDrawable(this.mFolderItemContainer.getResources(), C8003R.drawable.folder_list_item_bg_round, null));
            return;
        }
        if (i == 0 && i2 > 1) {
            this.mFolderItem.setBackground(ResourcesCompat.getDrawable(this.mFolderItemContainer.getResources(), C8003R.drawable.folder_list_item_bg_top, null));
        } else if (i == i2 - 1) {
            this.mFolderItem.setBackground(ResourcesCompat.getDrawable(this.mFolderItemContainer.getResources(), C8003R.drawable.folder_list_item_bg_bottom, null));
        } else {
            this.mFolderItem.setBackground(ResourcesCompat.getDrawable(this.mFolderItemContainer.getResources(), C8003R.drawable.folder_list_item_bg, null));
        }
    }
}
