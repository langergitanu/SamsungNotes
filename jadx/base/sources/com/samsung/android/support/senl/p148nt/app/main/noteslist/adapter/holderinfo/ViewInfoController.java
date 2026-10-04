package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo;

import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SeslProgressBar;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.common.widget.HoverPopupTextView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.util.NotesHolderUtil;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentTimeUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ViewInfoController {
    private View mCoeditLoadContainer;
    private View mCoeditProgressContainer;
    private View mCoeditSpaceExtraContainer;
    private TextView mDueDateView;
    private View mOwnerContainer;
    private View mSharedNewBadgeContainer;
    private View mUploadFailedContainer;

    private View inflateCoeditLoadView(View view) {
        if (this.mCoeditLoadContainer == null) {
            this.mCoeditLoadContainer = ViewModeUtils.getInflatedView(view, C8003R.id.coedit_load_icon_view, C8003R.id.inflate_coedit_load_icon_view);
        }
        return this.mCoeditLoadContainer;
    }

    private View inflateCoeditProgressView(View view) {
        if (this.mCoeditProgressContainer == null) {
            this.mCoeditProgressContainer = ViewModeUtils.getInflatedView(view, C8003R.id.coedit_load_progress, C8003R.id.inflate_coedit_load_progress);
        }
        return this.mCoeditProgressContainer;
    }

    private TextView inflateDueDateView(View view) {
        if (this.mDueDateView == null) {
            this.mDueDateView = (TextView) ViewModeUtils.getInflatedView(view, C8003R.id.recycle_bin_due_date, C8003R.id.inflate_recycle_bin_due_date);
        }
        return this.mDueDateView;
    }

    private View inflateOwnerContainer(View view) {
        if (this.mOwnerContainer == null) {
            this.mOwnerContainer = ViewModeUtils.getInflatedView(view, C8003R.id.gcs_owner, C8003R.id.inflate_gcs_owner);
            ViewCompat viewCompat = ViewCompat.getInstance();
            View view2 = this.mOwnerContainer;
            viewCompat.setTooltipText(view2, view2.getContext().getText(C8003R.string.notes_icon_owner));
        }
        return this.mOwnerContainer;
    }

    private View inflateSharedNewBadgeContainer(View view) {
        if (this.mSharedNewBadgeContainer == null) {
            this.mSharedNewBadgeContainer = ViewModeUtils.getInflatedView(view, C8003R.id.gcs_new_badge, C8003R.id.inflate_gcs_new_badge);
        }
        return this.mSharedNewBadgeContainer;
    }

    private View inflateSpaceExtra(View view) {
        if (this.mCoeditSpaceExtraContainer == null) {
            this.mCoeditSpaceExtraContainer = ViewModeUtils.getInflatedView(view, C8003R.id.coedit_space_extra, C8003R.id.inflate_coedit_space_extra);
        }
        return this.mCoeditSpaceExtraContainer;
    }

    private View inflateUploadFailedContainer(View view) {
        if (this.mUploadFailedContainer == null) {
            this.mUploadFailedContainer = ViewModeUtils.getInflatedView(view, C8003R.id.gcs_upload_failed, C8003R.id.inflate_gcs_upload_failed);
            ViewCompat viewCompat = ViewCompat.getInstance();
            View view2 = this.mUploadFailedContainer;
            viewCompat.setTooltipText(view2, view2.getContext().getText(C8003R.string.notes_icon_sync_fail));
        }
        return this.mUploadFailedContainer;
    }

    private void setCoeditLoadVisible(View view, boolean z) {
        setVisible(inflateCoeditLoadView(view), z);
    }

    private boolean setVisible(View view, boolean z) {
        if (view == null) {
            return false;
        }
        view.setVisibility(z ? 0 : 8);
        return true;
    }

    public void init(View view) {
        View view2 = this.mOwnerContainer;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.mUploadFailedContainer;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.mSharedNewBadgeContainer;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        View view5 = this.mCoeditSpaceExtraContainer;
        if (view5 != null) {
            view5.setVisibility(8);
        }
        View view6 = this.mCoeditLoadContainer;
        if (view6 != null) {
            view6.setVisibility(8);
        }
        View view7 = this.mCoeditProgressContainer;
        if (view7 != null) {
            view7.setVisibility(8);
            view.setAlpha(1.0f);
        }
    }

    public void setCoeditExtraVisible(View view, boolean z, boolean z2) {
        setCoeditLoadVisible(view, z);
        setVisible(inflateSharedNewBadgeContainer(view), z2);
    }

    public void setCoeditLoadProgressVisible(View view, boolean z, boolean z2) {
        view.setAlpha(z ? 0.6f : 1.0f);
        if (!z2) {
            setCoeditLoadVisible(view, true);
            return;
        }
        if (setVisible(inflateCoeditProgressView(view), z)) {
            ((SeslProgressBar) this.mCoeditProgressContainer.findViewById(C8003R.id.progress_downloading)).getIndeterminateDrawable().setColorFilter(view.getResources().getColor(C8003R.color.coedit_note_loading_progress, null), PorterDuff.Mode.SRC_IN);
            HoverPopupTextView hoverPopupTextView = (HoverPopupTextView) view.findViewById(C8003R.id.text_content);
            if (hoverPopupTextView == null) {
                return;
            }
            NotesHolderUtil.applyTextOnlyThumbnailFgDim((View) hoverPopupTextView.getParent(), 0);
        }
    }

    public void setCoeditSpaceExtraVisible(View view, String str, boolean z) {
        if (setVisible(inflateSpaceExtra(view), true)) {
            if (setVisible(this.mCoeditSpaceExtraContainer.findViewById(C8003R.id.coedit_member_count_layout), true ^ TextUtils.isEmpty(str))) {
                ((TextView) this.mCoeditSpaceExtraContainer.findViewById(C8003R.id.space_member_count)).setText(str);
            }
            setVisible(this.mCoeditSpaceExtraContainer.findViewById(C8003R.id.coedit_leader_badge), z);
        }
    }

    public void setDueDateViewVisible(View view, long j) {
        if (setVisible(inflateDueDateView(view), true)) {
            int recycleBinDueDate = DocumentTimeUtils.getRecycleBinDueDate(j);
            if (recycleBinDueDate == 0) {
                this.mDueDateView.setText(view.getContext().getResources().getString(C8003R.string.notes_today));
            } else if (recycleBinDueDate == 1) {
                this.mDueDateView.setText(view.getContext().getResources().getString(C8003R.string.notes_tomorrow));
            } else {
                this.mDueDateView.setText(view.getContext().getResources().getQuantityString(C8003R.plurals.plurals_recycle_bin_due_date, recycleBinDueDate, Integer.valueOf(recycleBinDueDate)));
            }
        }
    }

    public void setGcsExtraVisible(View view, boolean z, boolean z2, boolean z3) {
        setVisible(inflateOwnerContainer(view), z);
        setVisible(inflateUploadFailedContainer(view), z2);
        setVisible(inflateSharedNewBadgeContainer(view), z3);
    }

    public View setToolbarCoeditSpaceExtraVisible(AppCompatActivity appCompatActivity, String str, boolean z) {
        if (this.mCoeditSpaceExtraContainer == null) {
            this.mCoeditSpaceExtraContainer = LayoutInflater.from(appCompatActivity).inflate(C8003R.layout.notes_coedit_item_space_extra, (ViewGroup) null);
        }
        setVisible(this.mCoeditSpaceExtraContainer, true);
        if (setVisible(this.mCoeditSpaceExtraContainer.findViewById(C8003R.id.coedit_member_count_layout), true ^ TextUtils.isEmpty(str))) {
            ((TextView) this.mCoeditSpaceExtraContainer.findViewById(C8003R.id.space_member_count)).setText(str);
        }
        setVisible(this.mCoeditSpaceExtraContainer.findViewById(C8003R.id.coedit_leader_badge), z);
        return this.mCoeditSpaceExtraContainer;
    }

    public void init() {
        TextView textView = this.mDueDateView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }
}
