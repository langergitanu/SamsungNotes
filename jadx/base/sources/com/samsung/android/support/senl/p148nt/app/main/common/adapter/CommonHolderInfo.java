package com.samsung.android.support.senl.p148nt.app.main.common.adapter;

import android.view.View;
import android.widget.CheckBox;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.ViewInfoController;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CommonHolderInfo {
    private CheckBox mCheckBoxView;
    private String mDateText;
    private int mHolderType;
    private boolean mIsExpandable;
    private long mLastModifiedAt;
    private int mPosition;
    private String mPrevUuid;
    private View mRootCardView;
    private CharSequence mTitleText;
    private String mUuid;
    protected final ViewInfoController mCommonViewInfoController = new ViewInfoController();
    private final float[] mTouchPos = new float[2];
    protected boolean mIsEnable = true;

    private void inflateCheckBox() {
        if (isCheckboxInflated()) {
            return;
        }
        CheckBox checkBox = (CheckBox) ViewModeUtils.getInflatedView(this.mRootCardView, C8003R.id.checkbox, C8003R.id.inflate_checkbox);
        this.mCheckBoxView = checkBox;
        if (checkBox != null) {
            checkBox.setTag(this.mUuid);
        }
    }

    public CheckBox getCheckBox() {
        inflateCheckBox();
        return this.mCheckBoxView;
    }

    public String getDateText() {
        return this.mDateText;
    }

    public int getHolderType() {
        return this.mHolderType;
    }

    public boolean getIsEnable() {
        return this.mIsEnable;
    }

    public long getLastModifiedAt() {
        return this.mLastModifiedAt;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public String getPrevUuid() {
        return this.mPrevUuid;
    }

    public View getRootCardView() {
        return this.mRootCardView;
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public float[] getTouchPos() {
        return this.mTouchPos;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public void initInfoViews() {
        this.mCommonViewInfoController.init();
    }

    public boolean isCheckboxInflated() {
        return this.mCheckBoxView != null;
    }

    public boolean isExpandable() {
        return this.mIsExpandable;
    }

    public void setCoeditExtraVisible(boolean z, boolean z2) {
    }

    public void setCoeditLoadProgressVisible(boolean z, boolean z2) {
    }

    public void setCoeditSpaceExtraVisible(String str, boolean z) {
    }

    public CommonHolderInfo setDateText(String str) {
        this.mDateText = str;
        return this;
    }

    public void setDueDateViewVisible(long j) {
        this.mCommonViewInfoController.setDueDateViewVisible(getRootCardView(), j);
    }

    public CommonHolderInfo setEnable(boolean z) {
        if (this.mIsEnable != z) {
            this.mIsEnable = z;
            if (z) {
                this.mRootCardView.setAlpha(1.0f);
                this.mRootCardView.setEnabled(true);
                return this;
            }
            this.mRootCardView.setAlpha(0.5f);
            this.mRootCardView.setEnabled(false);
        }
        return this;
    }

    public void setExpandable(boolean z) {
        this.mIsExpandable = z;
    }

    public void setGcsExtraVisible(boolean z, boolean z2, boolean z3) {
    }

    public CommonHolderInfo setHolderType(int i) {
        this.mHolderType = i;
        return this;
    }

    public CommonHolderInfo setLastModifiedAt(long j) {
        this.mLastModifiedAt = j;
        return this;
    }

    public CommonHolderInfo setPosition(int i) {
        this.mPosition = i;
        return this;
    }

    public CommonHolderInfo setRootCardView(View view) {
        this.mRootCardView = view;
        return this;
    }

    public CommonHolderInfo setTitle(CharSequence charSequence) {
        this.mTitleText = charSequence;
        return this;
    }

    public void setTouchPos(float f, float f4) {
        float[] fArr = this.mTouchPos;
        fArr[0] = f;
        fArr[1] = f4;
    }

    public CommonHolderInfo setUuid(String str) {
        this.mPrevUuid = this.mUuid;
        this.mUuid = str;
        return this;
    }
}
