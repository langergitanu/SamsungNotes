package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.main.coedit.spacepicker.adapter.SpacePickerSelectListener;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.task.CoeditSpaceThumbnailTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SpaceEntry;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditSpaceHolder extends CommonHolder implements View.OnClickListener {
    private final Executor THUMBNAIL_EXECUTOR;
    private String mGroupId;
    private CommonHolderInfo mHolderInfo;
    private final boolean mIsPickerMode;
    private String mSpaceId;

    public CoeditSpaceHolder(@NonNull View view, int i) {
        super(view, i);
        this.THUMBNAIL_EXECUTOR = AbstractC4539a.m3201k("CoeditSpaceHolder");
        setHolderType();
        initRootView(this, true);
        this.mIsPickerMode = false;
    }

    private void decorateNewBadge(boolean z) {
        View viewFindViewById = this.itemView.findViewById(C8003R.id.space_new_badge);
        if (this.mIsPickerMode) {
            viewFindViewById.setVisibility(8);
        } else {
            viewFindViewById.setVisibility(z ? 0 : 8);
        }
    }

    private void decorateThumbnail(SpaceEntry spaceEntry) {
        new CoeditSpaceThumbnailTask((ViewGroup) this.itemView.findViewById(C8003R.id.space_thumbnail), spaceEntry.getMembers()).executeOnExecutor(this.THUMBNAIL_EXECUTOR, new Void[0]);
    }

    private void initRootView(View.OnClickListener onClickListener, boolean z) {
        View viewFindViewById = this.itemView.findViewById(C8003R.id.space_item_container);
        viewFindViewById.setOnClickListener(onClickListener);
        if (z) {
            viewFindViewById.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.CoeditSpaceHolder.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (CoeditSpaceHolder.this.getMAdapterContract() == null || !CoeditSpaceHolder.this.getMAdapterContract().onSpaceLongPressed(CoeditSpaceHolder.this.mGroupId, CoeditSpaceHolder.this.mSpaceId)) {
                        return true;
                    }
                    view.performHapticFeedback(0);
                    return true;
                }
            });
        }
    }

    private void setHolderType() {
        setHolderType(8192);
    }

    public void clearThumbnailHolder() {
        ViewGroup viewGroup = (ViewGroup) this.itemView.findViewById(C8003R.id.space_thumbnail);
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void decorate(Common common, StateInfo stateInfo) {
        SpaceEntry spaceEntry = common.space;
        if (spaceEntry == null) {
            return;
        }
        if (this.mHolderInfo == null) {
            this.mHolderInfo = new CommonHolderInfo().setHolderType(8192).setRootCardView(this.itemView);
        }
        this.mSpaceId = spaceEntry.getSpaceId();
        this.mGroupId = spaceEntry.getGroupId();
        ((TextView) this.itemView.findViewById(C8003R.id.space_title)).setText(spaceEntry.getTitle());
        ((TextView) this.itemView.findViewById(C8003R.id.space_member_count)).setText(LocaleUtils.convertToArabicNumber(spaceEntry.getMemberCount()));
        this.itemView.findViewById(C8003R.id.coedit_leader_badge).setVisibility(spaceEntry.isOwnedByMe() ? 0 : 8);
        decorateNewBadge(spaceEntry.getUnReadCount() > 0);
        decorateThumbnail(spaceEntry);
        if (getMAdapterContract() != null) {
            this.mHolderInfo.setEnable(!FeatureUtils.isEditMode(getMAdapterContract().getModeIndex()));
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.itemView.getLayoutParams();
        if (getMIsBottomOfSameViewType()) {
            marginLayoutParams.bottomMargin = this.itemView.getResources().getDimensionPixelOffset(C8003R.dimen.co_edit_space_holder_margin_bottom);
        } else {
            marginLayoutParams.bottomMargin = 0;
        }
    }

    public CommonHolderInfo getCoeditSpaceHolderInfo() {
        return this.mHolderInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        getMAdapterContract().onSpaceSelected(this.mGroupId, this.mSpaceId);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void onViewAttachedToWindow(@NonNull CommonHolder commonHolder) {
        this.mHolderInfo.setEnable(!FeatureUtils.isEditMode(getMAdapterContract().getModeIndex()));
    }

    public CoeditSpaceHolder(@NonNull View view, int i, final SpacePickerSelectListener spacePickerSelectListener) {
        super(view, i);
        this.THUMBNAIL_EXECUTOR = AbstractC4539a.m3201k("CoeditSpaceHolder");
        setHolderType();
        initRootView(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.CoeditSpaceHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                spacePickerSelectListener.onSpaceSelected(CoeditSpaceHolder.this.mGroupId, CoeditSpaceHolder.this.mSpaceId);
            }
        }, false);
        this.mIsPickerMode = true;
    }
}
