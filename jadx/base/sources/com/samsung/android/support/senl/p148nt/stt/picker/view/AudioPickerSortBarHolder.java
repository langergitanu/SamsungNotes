package com.samsung.android.support.senl.p148nt.stt.picker.view;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.TooltipCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.C11253j;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001cJ\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u001cH\u0007J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u0004H\u0016J\u000e\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u001fJ\u0006\u0010)\u001a\u00020\u001fJ\b\u0010*\u001a\u00020!H\u0002J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001cH\u0002J\b\u0010-\u001a\u00020!H\u0002J\b\u0010.\u001a\u00020!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerSortBarHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "mView", "Landroid/view/View;", "mAdapterContract", "Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerListViewAdapterContract;", "<init>", "(Landroid/view/View;Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerListViewAdapterContract;)V", "mSortByLayout", "Landroid/widget/LinearLayout;", "mSortArrowLayout", "mSortByText", "Landroid/widget/TextView;", "mInternalStorageLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMInternalStorageLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMInternalStorageLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "mNumberItems", "mInternalExpand", "Landroid/widget/ImageView;", "getMInternalExpand", "()Landroid/widget/ImageView;", "setMInternalExpand", "(Landroid/widget/ImageView;)V", "mCurrentSortType", "", "mCurrentSortOrder", "mIsExpand", "", "initSortState", "", "sortType", "sortOrder", "initInternalStorage", TextConst.KEY_PARAM_NUMBER, "onClick", VPathDataCmd.RCurveTo, "updateExpandIcon", "isExpand", "showSortTypeDialog", "getSortTypeFromSortTypePopupMenuOrder", "itemOrder", "decorateSortType", "decorateSortOrder", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AudioPickerSortBarHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public static final int BY_ASC = 4;
    public static final int BY_CREATED_TIME = 1;
    public static final int BY_DESC = 5;
    public static final int BY_NAME = 2;
    public static final int BY_SIZE = 3;

    @NotNull
    private static final String TAG = "AudioPickerSortBar";

    @Nullable
    private final AudioPickerListViewAdapterContract mAdapterContract;
    private int mCurrentSortOrder;
    private int mCurrentSortType;

    @Nullable
    private ImageView mInternalExpand;

    @Nullable
    private ConstraintLayout mInternalStorageLayout;
    private boolean mIsExpand;

    @Nullable
    private TextView mNumberItems;

    @Nullable
    private LinearLayout mSortArrowLayout;

    @Nullable
    private LinearLayout mSortByLayout;

    @Nullable
    private TextView mSortByText;

    @NotNull
    private final View mView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioPickerSortBarHolder(@NotNull View mView, @Nullable AudioPickerListViewAdapterContract audioPickerListViewAdapterContract) {
        super(mView);
        Intrinsics.checkNotNullParameter(mView, "mView");
        this.mView = mView;
        this.mAdapterContract = audioPickerListViewAdapterContract;
        this.mSortByLayout = (LinearLayout) this.itemView.findViewById(C11493R.id.sortby_layout);
        this.mSortArrowLayout = (LinearLayout) this.itemView.findViewById(C11493R.id.sort_arrow_layout);
        this.mSortByText = (TextView) this.itemView.findViewById(C11493R.id.sort_message);
        this.mInternalStorageLayout = (ConstraintLayout) this.itemView.findViewById(C11493R.id.internal_storage_infor_layout);
        this.mNumberItems = (TextView) this.itemView.findViewById(C11493R.id.search_item_number);
        this.mInternalExpand = (ImageView) this.itemView.findViewById(C11493R.id.internal_expand_ic);
        updateExpandIcon(true);
        LinearLayout linearLayout = this.mSortByLayout;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        LinearLayout linearLayout2 = this.mSortArrowLayout;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(this);
        }
    }

    private final void decorateSortOrder() {
        LinearLayout linearLayout = this.mSortArrowLayout;
        if (linearLayout == null) {
            return;
        }
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setRotation(this.mCurrentSortOrder == 4 ? 180 : 0);
    }

    private final void decorateSortType() {
        TextView textView = this.mSortByText;
        if (textView == null) {
            return;
        }
        int i = this.mCurrentSortType;
        if (i == 1) {
            Intrinsics.checkNotNull(textView);
            textView.setText(C11493R.string.audio_picker_sort_by_create_date);
        } else if (i == 2) {
            Intrinsics.checkNotNull(textView);
            textView.setText(C11493R.string.file_picker_sort_by_sort_name);
        } else {
            if (i != 3) {
                return;
            }
            Intrinsics.checkNotNull(textView);
            textView.setText(C11493R.string.file_picker_sort_by_sort_size);
        }
    }

    private final int getSortTypeFromSortTypePopupMenuOrder(int itemOrder) {
        if (itemOrder != 0) {
            return itemOrder != 1 ? 3 : 1;
        }
        return 2;
    }

    private final void showSortTypeDialog() {
        PopupMenu popupMenu = new PopupMenu(this.mView.getContext(), this.mView.findViewById(C11493R.id.sortby_layout), 48);
        popupMenu.getMenuInflater().inflate(C11493R.menu.audio_picker_sort_by_menu, popupMenu.getMenu());
        Menu menu = popupMenu.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu, "getMenu(...)");
        int i = this.mCurrentSortType;
        if (i == 1) {
            menu.findItem(C11493R.id.sortby_time).setChecked(true);
        } else if (i == 2) {
            menu.findItem(C11493R.id.sortby_name).setChecked(true);
        } else if (i != 3) {
            Logger.m12711e(TAG, "showSortTypeDialog# unexpected sortType: " + i);
        } else {
            menu.findItem(C11493R.id.sortby_size).setChecked(true);
        }
        popupMenu.setOnMenuItemClickListener(new C11253j(this, 10));
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showSortTypeDialog$lambda$0(AudioPickerSortBarHolder audioPickerSortBarHolder, MenuItem menuItem) {
        if (menuItem.isChecked()) {
            menuItem.setChecked(false);
        } else {
            menuItem.setChecked(true);
            audioPickerSortBarHolder.mCurrentSortType = audioPickerSortBarHolder.getSortTypeFromSortTypePopupMenuOrder(menuItem.getOrder());
            audioPickerSortBarHolder.decorateSortType();
            AudioPickerListViewAdapterContract audioPickerListViewAdapterContract = audioPickerSortBarHolder.mAdapterContract;
            if (audioPickerListViewAdapterContract != null) {
                audioPickerListViewAdapterContract.onUpdateSortItem(audioPickerSortBarHolder.mCurrentSortType, audioPickerSortBarHolder.mCurrentSortOrder);
            }
        }
        return false;
    }

    @Nullable
    public final ImageView getMInternalExpand() {
        return this.mInternalExpand;
    }

    @Nullable
    public final ConstraintLayout getMInternalStorageLayout() {
        return this.mInternalStorageLayout;
    }

    @SuppressLint({"SetTextI18n"})
    public final void initInternalStorage(int number) {
        ConstraintLayout constraintLayout = this.mInternalStorageLayout;
        Intrinsics.checkNotNull(constraintLayout);
        constraintLayout.setVisibility(0);
        TextView textView = this.mNumberItems;
        Intrinsics.checkNotNull(textView);
        textView.setText("(" + this.mView.getContext().getResources().getQuantityString(C11493R.plurals.plurals_count_items, number, Integer.valueOf(number)) + ")");
    }

    public final void initSortState(int sortType, int sortOrder) {
        this.mCurrentSortType = sortType;
        this.mCurrentSortOrder = sortOrder;
        decorateSortType();
        decorateSortOrder();
    }

    /* JADX INFO: renamed from: isExpand, reason: from getter */
    public final boolean getMIsExpand() {
        return this.mIsExpand;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id = v.getId();
        if (id != C11493R.id.sort_arrow_layout) {
            if (id == C11493R.id.sortby_layout) {
                showSortTypeDialog();
                return;
            } else {
                Logger.m12710d(TAG, "onClick# unexpectedView");
                return;
            }
        }
        this.mCurrentSortOrder = this.mCurrentSortOrder == 5 ? 4 : 5;
        decorateSortOrder();
        AudioPickerListViewAdapterContract audioPickerListViewAdapterContract = this.mAdapterContract;
        if (audioPickerListViewAdapterContract != null) {
            audioPickerListViewAdapterContract.onUpdateSortItem(this.mCurrentSortType, this.mCurrentSortOrder);
        }
    }

    public final void setMInternalExpand(@Nullable ImageView imageView) {
        this.mInternalExpand = imageView;
    }

    public final void setMInternalStorageLayout(@Nullable ConstraintLayout constraintLayout) {
        this.mInternalStorageLayout = constraintLayout;
    }

    public final void updateExpandIcon(boolean isExpand) {
        ImageView imageView = this.mInternalExpand;
        if (imageView == null) {
            return;
        }
        this.mIsExpand = isExpand;
        Intrinsics.checkNotNull(imageView);
        imageView.animate().rotation(isExpand ? 180 : PopOverActivityWrapper.DEFAULT_WIDTH).setDuration(200L);
        ImageView imageView2 = this.mInternalExpand;
        Intrinsics.checkNotNull(imageView2);
        imageView2.setContentDescription(this.mView.getContext().getResources().getString(isExpand ? C11493R.string.search_collapsed_filter_header : C11493R.string.search_expanded_filter_header));
        ImageView imageView3 = this.mInternalExpand;
        Intrinsics.checkNotNull(imageView3);
        TooltipCompat.setTooltipText(imageView3, this.mView.getContext().getResources().getString(isExpand ? C11493R.string.search_state_collapse_filter_header : C11493R.string.search_state_expand_filter_header));
    }
}
