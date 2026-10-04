package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder;

import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.SubHeaderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SubHeaderHolder extends CommonHolder {
    private final View.OnClickListener mOnClickListener;
    private SubHeaderHolderInfo mSubHeaderHolderInfo;
    private TextView mTitleView;

    public SubHeaderHolder(@NonNull View view, int i) {
        super(view, i);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.SubHeaderHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!FeatureUtils.isNotSupportCheckingSubHeader(SubHeaderHolder.this.mSubHeaderHolderInfo.getId()) && SubHeaderHolder.this.mSubHeaderHolderInfo.getIsEnable()) {
                    boolean z = !SubHeaderHolder.this.mSubHeaderHolderInfo.getCheckBox().isChecked();
                    if (SubHeaderHolder.this.isSortedType(((Long) view2.getTag()).longValue()) ? SubHeaderHolder.this.getMAdapterContract().onSubHeaderSelected(z, SubHeaderHolder.this.getAbsoluteAdapterPosition()) : SubHeaderHolder.this.getMAdapterContract().onSubHeaderSelected(((Long) view2.getTag()).longValue(), z)) {
                        SubHeaderHolder.this.mSubHeaderHolderInfo.getCheckBox().setChecked(z);
                        SubHeaderHolder.this.mSubHeaderHolderInfo.getCheckBox().jumpDrawablesToCurrentState();
                    }
                }
            }
        };
        this.mOnClickListener = onClickListener;
        setHolderType(4096);
        view.setOnClickListener(onClickListener);
        this.mTitleView = (TextView) view.findViewById(C8003R.id.sub_header_title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSortedType(long j) {
        return j == -24 || j == -25 || j == -26 || j == -27 || j == -28 || j == -29;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void decorate(Common common, StateInfo stateInfo) {
        String string;
        long j = common.f6179id;
        if (j == -14) {
            string = this.itemView.getResources().getString(C8003R.string.gcs_space_list_sub_header_old_format_notes);
        } else if (j == -15) {
            string = this.itemView.getResources().getString(C8003R.string.gcs_space_list_sub_header_new_format_notes);
        } else if (j == -16) {
            string = this.itemView.getResources().getString(C8003R.string.co_edit_list_sub_header_notebook);
        } else if (j == -24) {
            string = this.itemView.getResources().getString(C8003R.string.notes_today);
        } else if (j == -25) {
            string = this.itemView.getResources().getString(C8003R.string.notes_7days);
        } else if (j == -26) {
            string = this.itemView.getResources().getString(C8003R.string.notes_30days);
        } else if (j == -27) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(2, (int) common.time);
            new SimpleDateFormat("MMM", Locale.getDefault());
            string = new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), "MMM"), Locale.getDefault()).format(calendar.getTime());
        } else if (j == -28) {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(1, (int) common.time);
            new SimpleDateFormat("yyyy", Locale.getDefault());
            string = new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), "yyyy"), Locale.getDefault()).format(calendar2.getTime());
        } else if (j == -29) {
            string = this.itemView.getResources().getString(C8003R.string.favorite_notes_header);
        } else if (j == -30) {
            string = this.itemView.getResources().getString(C8003R.string.search_related_results);
            this.mTitleView.setTextAppearance(C8003R.style.SearchHeader);
        } else if (j == -31) {
            string = "\n\n\n";
        } else {
            MainLogger.m7258i("SubHeaderHolder", "decorate blank");
            string = "";
        }
        this.mTitleView.setText(string);
        int viewMode = getViewMode();
        if (ContentUtils.isListViewMode(viewMode)) {
            this.itemView.setPadding(this.itemView.getResources().getDimensionPixelSize(C8003R.dimen.sub_header_list_text_padding_start_end), 0, this.itemView.getResources().getDimensionPixelSize(C8003R.dimen.sub_header_text_padding_end), 0);
        } else {
            if (ContentUtils.isSimpleViewMode(viewMode) && NotesUtils.isTabletLayout(this.itemView.getContext())) {
                int i = DeviceInfo.isVSTModel() ? C8003R.color.noteslist_fragment_bg_color_for_vst : C8003R.color.noteslist_fragment_bg_color;
                View view = this.itemView;
                view.setBackgroundColor(view.getResources().getColor(i, null));
            }
            this.itemView.setPadding(this.itemView.getResources().getDimensionPixelSize(C8003R.dimen.sub_header_text_padding_start), 0, this.itemView.getResources().getDimensionPixelSize(C8003R.dimen.sub_header_text_padding_end), 0);
        }
        this.itemView.setTag(Long.valueOf(j));
        SubHeaderHolderInfo subHeaderHolderInfo = this.mSubHeaderHolderInfo;
        if (subHeaderHolderInfo == null) {
            this.mSubHeaderHolderInfo = (SubHeaderHolderInfo) new SubHeaderHolderInfo().setId(j).setTitle(string).setRootCardView(this.itemView).setHolderType(getMHolderType()).setPosition(getAbsoluteAdapterPosition()).setEnable(true);
        } else {
            subHeaderHolderInfo.setId(j).setPosition(getAbsoluteAdapterPosition()).setEnable(true);
        }
    }

    public SubHeaderHolderInfo getSubHeaderHolderInfo() {
        return this.mSubHeaderHolderInfo;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void onBindViewHolder(int i) {
        if (FeatureUtils.isNotSupportCheckingSubHeader(this.mSubHeaderHolderInfo.getId())) {
            return;
        }
        getMAdapterContract().onBindViewHolder(this.mSubHeaderHolderInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void onViewAttachedToWindow(@NonNull CommonHolder commonHolder) {
        if (FeatureUtils.isNotSupportCheckingSubHeader(this.mSubHeaderHolderInfo.getId())) {
            return;
        }
        getMAdapterContract().onViewAttachedToWindow(this.mSubHeaderHolderInfo);
    }
}
