package com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.sdk.pen.setting.common.ViewOnLongClickListenerC7556a;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.bitmap.BitmapManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.widget.HoverPopupTextView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.adapter.holder.ImportDocumentRecyclerViewHolder;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.model.ImportDocumentModel;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 F2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001FB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0013H\u0016J\u001a\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u0013H\u0002J\u0018\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020)H\u0002J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0002H\u0002J\b\u0010-\u001a\u00020\u0013H\u0016J\b\u0010.\u001a\u00020\u001cH\u0002J(\u0010/\u001a\u00020\u00132\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u00101\u001a\u00020\u000bH\u0002J\u0012\u00102\u001a\u00020\u001c2\b\u00103\u001a\u0004\u0018\u00010\u000bH\u0002J\u000e\u0010/\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u000bJ\u001d\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u000107¢\u0006\u0002\u00108J\b\u00109\u001a\u00020\u001cH\u0002J\u000e\u0010:\u001a\u00020\u001c2\u0006\u00106\u001a\u000207J\"\u0010;\u001a\u00020\u001c2\u001a\u0010<\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\fJ\u0018\u0010?\u001a\u00020\u001c2\b\u0010@\u001a\u0004\u0018\u00010\u000f2\u0006\u0010A\u001a\u00020\u0013R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010=\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b>\u0010\u0016R!\u0010B\u001a\u0012\u0012\u0004\u0012\u00020C0\nj\b\u0012\u0004\u0012\u00020C`\f8F¢\u0006\u0006\u001a\u0004\bD\u0010E¨\u0006G"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/ImportDocumentRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/holder/ImportDocumentRecyclerViewHolder;", "mAdapterContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/ImportDocumentAdapterContract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/ImportDocumentAdapterContract;)V", "mBitmapManager", "Lcom/samsung/android/support/senl/nt/app/common/bitmap/BitmapManager;", "mImportDataContainer", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/model/ImportDocumentModel;", "Lkotlin/collections/ArrayList;", "mFilteredItemData", "value", "", "selectedCategory", "getSelectedCategory", "()Ljava/lang/String;", "", "selectedCategoryType", "getSelectedCategoryType", "()I", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "", "holder", "onBindViewHolder", "viewHolder", "position", "setEndMargin", "targetView", "Landroid/view/View;", "id", "getDate", "context", "Landroid/content/Context;", "milliSeconds", "", "getDateFormat", "modifyTime", "updateContentDescription", "getItemCount", "refreshFilteredItems", "add", XmlErrorCodes.LIST, "data", "addToFilteredItems", "item", "setCheckItem", "vh", "checked", "", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/holder/ImportDocumentRecyclerViewHolder;Ljava/lang/Boolean;)V", "setAllItemCheckedFalse", "setAllItemChecked", "toggleSelectState", "items", "checkedItemCount", "getCheckedItemCount", "setCategory", "category", "type", "checkedItems", "Lcom/samsung/android/app/notes/sync/items/ImportItem;", "getCheckedItems", "()Ljava/util/ArrayList;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImportDocumentRecyclerViewAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImportDocumentRecyclerViewAdapter.kt\ncom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/ImportDocumentRecyclerViewAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,388:1\n1#2:389\n*E\n"})
public final class ImportDocumentRecyclerViewAdapter extends RecyclerView.Adapter<ImportDocumentRecyclerViewHolder> {

    @NotNull
    private static final String TAG = "ST$ImportDocumentRecyclerViewAdapter";

    @Nullable
    private final ImportDocumentAdapterContract mAdapterContract;

    @Nullable
    private String selectedCategory;
    private int selectedCategoryType;

    @NotNull
    private final BitmapManager mBitmapManager = new BitmapManager();

    @NotNull
    private final ArrayList<ImportDocumentModel> mImportDataContainer = new ArrayList<>();

    @NotNull
    private final ArrayList<ImportDocumentModel> mFilteredItemData = new ArrayList<>();

    public ImportDocumentRecyclerViewAdapter(@Nullable ImportDocumentAdapterContract importDocumentAdapterContract) {
        this.mAdapterContract = importDocumentAdapterContract;
    }

    private final int add(ArrayList<ImportDocumentModel> list, ImportDocumentModel data) {
        ImportItem importItem = data.getImportItem();
        Intrinsics.checkNotNull(importItem);
        long timeStamp = importItem.getTimeStamp();
        int i = 0;
        while (true) {
            if (i >= list.size()) {
                break;
            }
            ImportDocumentModel importDocumentModel = list.get(i);
            Intrinsics.checkNotNullExpressionValue(importDocumentModel, "get(...)");
            ImportItem importItem2 = importDocumentModel.getImportItem();
            Intrinsics.checkNotNull(importItem2);
            if (timeStamp > importItem2.getTimeStamp()) {
                list.add(i, data);
                break;
            }
            i++;
        }
        if (i == list.size()) {
            list.add(data);
        }
        return i;
    }

    private final void addToFilteredItems(ImportDocumentModel item) {
        if (item == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        int i = this.selectedCategoryType;
        if (i == 11 || ((i == 12 && TextUtils.isEmpty(item.getCategory())) || Intrinsics.areEqual(this.selectedCategory, item.getCategory()))) {
            notifyItemInserted(add(this.mFilteredItemData, item));
        }
    }

    private final String getDate(Context context, long milliSeconds) {
        if (!DateUtils.isToday(milliSeconds)) {
            return getDateFormat(milliSeconds);
        }
        String str = DateFormat.getTimeFormat(context).format(Long.valueOf(milliSeconds));
        Intrinsics.checkNotNull(str);
        return str;
    }

    private final String getDateFormat(long modifyTime) {
        String str = new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), "yyyyMMMd"), Locale.getDefault()).format(Long.valueOf(modifyTime));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateViewHolder$lambda$2$lambda$0(ImportDocumentRecyclerViewAdapter importDocumentRecyclerViewAdapter, View view) {
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.adapter.holder.ImportDocumentRecyclerViewHolder");
        ImportDocumentRecyclerViewHolder importDocumentRecyclerViewHolder = (ImportDocumentRecyclerViewHolder) tag;
        if (importDocumentRecyclerViewHolder.getAdapterPosition() < 0) {
            return;
        }
        importDocumentRecyclerViewAdapter.setCheckItem(importDocumentRecyclerViewHolder, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateViewHolder$lambda$2$lambda$1(ImportDocumentRecyclerViewAdapter importDocumentRecyclerViewAdapter, View view) {
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.adapter.holder.ImportDocumentRecyclerViewHolder");
        ImportDocumentRecyclerViewHolder importDocumentRecyclerViewHolder = (ImportDocumentRecyclerViewHolder) tag;
        ImportDocumentAdapterContract importDocumentAdapterContract = importDocumentRecyclerViewAdapter.mAdapterContract;
        Intrinsics.checkNotNull(importDocumentAdapterContract);
        importDocumentAdapterContract.onItemLongPressed();
        CheckBox mCheckBox = importDocumentRecyclerViewHolder.getMCheckBox();
        Intrinsics.checkNotNull(mCheckBox);
        if (mCheckBox.isChecked()) {
            return true;
        }
        importDocumentRecyclerViewAdapter.setCheckItem(importDocumentRecyclerViewHolder, null);
        return true;
    }

    private final void refreshFilteredItems() {
        this.mFilteredItemData.clear();
        Iterator<ImportDocumentModel> it = this.mImportDataContainer.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ImportDocumentModel next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            addToFilteredItems(next);
        }
    }

    private final void setAllItemCheckedFalse() {
        int size = this.mFilteredItemData.size();
        for (int i = 0; i < size; i++) {
            ImportDocumentModel importDocumentModel = this.mFilteredItemData.get(i);
            Intrinsics.checkNotNullExpressionValue(importDocumentModel, "get(...)");
            importDocumentModel.setChecked(false);
        }
    }

    private final void setEndMargin(View targetView, int id) {
        if (targetView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = targetView.getLayoutParams();
        if (LocaleUtils.isRTLMode()) {
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).leftMargin = targetView.getContext().getResources().getDimensionPixelSize(id);
                return;
            } else {
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams).leftMargin = targetView.getContext().getResources().getDimensionPixelSize(id);
                    return;
                }
                return;
            }
        }
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).rightMargin = targetView.getContext().getResources().getDimensionPixelSize(id);
        } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).rightMargin = targetView.getContext().getResources().getDimensionPixelSize(id);
        }
    }

    private final void updateContentDescription(ImportDocumentRecyclerViewHolder viewHolder) {
        StringBuilder sb = new StringBuilder(viewHolder.itemView.getResources().getString(C8003R.string.selectall_voice_ass_tick_box));
        if (!TextUtils.isEmpty(viewHolder.getTitleText())) {
            sb.append(SQLKeyword.COMMA);
            sb.append(viewHolder.getTitleText());
        }
        if (!TextUtils.isEmpty(viewHolder.getContentText())) {
            sb.append(SQLKeyword.COMMA);
            sb.append(viewHolder.getContentText());
        }
        viewHolder.itemView.setContentDescription(sb.toString());
    }

    public final int getCheckedItemCount() {
        Iterator<ImportDocumentModel> it = this.mFilteredItemData.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        int i = 0;
        while (it.hasNext()) {
            ImportDocumentModel next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            if (next.getIsChecked()) {
                i++;
            }
        }
        return i;
    }

    @NotNull
    public final ArrayList<ImportItem> getCheckedItems() {
        ImportItem importItem;
        ArrayList<ImportItem> arrayList = new ArrayList<>();
        Iterator<ImportDocumentModel> it = this.mFilteredItemData.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ImportDocumentModel next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            ImportDocumentModel importDocumentModel = next;
            if (importDocumentModel.getIsChecked() && (importItem = importDocumentModel.getImportItem()) != null) {
                arrayList.add(importItem);
            }
        }
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mFilteredItemData.size();
    }

    @Nullable
    public final String getSelectedCategory() {
        return this.selectedCategory;
    }

    public final int getSelectedCategoryType() {
        return this.selectedCategoryType;
    }

    public final void setAllItemChecked(boolean checked) {
        int size = this.mFilteredItemData.size();
        for (int i = 0; i < size; i++) {
            ImportDocumentModel importDocumentModel = this.mFilteredItemData.get(i);
            Intrinsics.checkNotNullExpressionValue(importDocumentModel, "get(...)");
            ImportDocumentModel importDocumentModel2 = importDocumentModel;
            if (importDocumentModel2.getIsChecked() != checked) {
                importDocumentModel2.setChecked(checked);
            }
        }
    }

    public final void setCategory(@Nullable String category, int type) {
        this.selectedCategory = category;
        this.selectedCategoryType = type;
        setAllItemCheckedFalse();
        refreshFilteredItems();
    }

    public final void setCheckItem(@NotNull ImportDocumentRecyclerViewHolder vh, @Nullable Boolean checked) {
        Intrinsics.checkNotNullParameter(vh, "vh");
        ImportDocumentModel importDocumentModel = this.mFilteredItemData.get(vh.getAdapterPosition());
        Intrinsics.checkNotNullExpressionValue(importDocumentModel, "get(...)");
        ImportDocumentModel importDocumentModel2 = importDocumentModel;
        if (checked != null) {
            importDocumentModel2.setChecked(checked.booleanValue());
        } else {
            importDocumentModel2.setChecked(!importDocumentModel2.getIsChecked());
        }
        CheckBox mCheckBox = vh.getMCheckBox();
        Intrinsics.checkNotNull(mCheckBox);
        mCheckBox.setChecked(importDocumentModel2.getIsChecked());
        ImportDocumentAdapterContract importDocumentAdapterContract = this.mAdapterContract;
        if (importDocumentAdapterContract != null) {
            importDocumentAdapterContract.onItemChecked();
        }
    }

    public final void toggleSelectState(@Nullable ArrayList<Integer> items) {
        if (items == null || items.isEmpty()) {
            return;
        }
        Iterator<Integer> it = items.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Integer next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            int iIntValue = next.intValue();
            if (iIntValue >= 0 && iIntValue < this.mFilteredItemData.size()) {
                ImportDocumentModel importDocumentModel = this.mFilteredItemData.get(iIntValue);
                Intrinsics.checkNotNullExpressionValue(importDocumentModel, "get(...)");
                importDocumentModel.setChecked(!r1.getIsChecked());
                notifyItemChanged(iIntValue);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ImportDocumentRecyclerViewHolder viewHolder, int position) {
        String lastModifiedAt;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        MainLogger.m7258i(TAG, "onBindViewHolder " + position);
        ImportDocumentModel importDocumentModel = this.mFilteredItemData.get(position);
        Intrinsics.checkNotNullExpressionValue(importDocumentModel, "get(...)");
        ImportDocumentModel importDocumentModel2 = importDocumentModel;
        CheckBox mCheckBox = viewHolder.getMCheckBox();
        if (mCheckBox != null) {
            mCheckBox.setChecked(importDocumentModel2.getIsChecked());
        }
        ImportItem importItem = importDocumentModel2.getImportItem();
        if (TextUtils.isEmpty(importItem != null ? importItem.getTitle() : null)) {
            viewHolder.setTitleVisibility(false);
        } else {
            ImportItem importItem2 = importDocumentModel2.getImportItem();
            viewHolder.setTitleText(importItem2 != null ? importItem2.getTitle() : null);
        }
        ImportItem importItem3 = importDocumentModel2.getImportItem();
        if (TextUtils.isEmpty(importItem3 != null ? importItem3.getContent() : null)) {
            viewHolder.setContentVisibility(false);
        } else {
            ImportItem importItem4 = importDocumentModel2.getImportItem();
            viewHolder.setContentText(importItem4 != null ? importItem4.getContent() : null);
        }
        Context context = viewHolder.itemView.getContext();
        if (viewHolder.isVisibleTitle()) {
            TextView mTitleView = viewHolder.getMTitleView();
            Intrinsics.checkNotNull(mTitleView);
            mTitleView.setTextColor(ContextCompat.getColor(context, C8003R.color.settings_list_text_color));
            TextView mTitleView2 = viewHolder.getMTitleView();
            Intrinsics.checkNotNull(mTitleView2);
            ImportItem importItem5 = importDocumentModel2.getImportItem();
            mTitleView2.setText(importItem5 != null ? importItem5.getTitle() : null);
        } else if (!viewHolder.isVisibleContent()) {
            viewHolder.setTitleText(context.getResources().getString(C8003R.string.import_memo_item_no_text));
            TextView mTitleView3 = viewHolder.getMTitleView();
            Intrinsics.checkNotNull(mTitleView3);
            mTitleView3.setTextColor(ContextCompat.getColor(context, C8003R.color.settings_edit_hint_color));
        }
        if (importDocumentModel2.getDataType() == 1) {
            viewHolder.updateVoiceContainer("");
            viewHolder.updateFavoriteLayout(false);
            viewHolder.setImageVisibility(false);
            viewHolder.getMTimeContainer().setVisibility(4);
        } else {
            MemoMetaDataItem memoMetaDataItem = importDocumentModel2.getMemoMetaDataItem();
            if (memoMetaDataItem != null) {
                if (memoMetaDataItem.getHasImage()) {
                    setEndMargin(viewHolder.getMTitleView(), C8003R.dimen.settings_item_blank_default);
                    setEndMargin(viewHolder.getMContentView(), C8003R.dimen.settings_item_blank_default);
                    viewHolder.setImage(memoMetaDataItem.getImageFile().curFullPath, this.mBitmapManager);
                } else {
                    setEndMargin(viewHolder.getMTitleView(), C8003R.dimen.settings_list_item_blank_end_content);
                    setEndMargin(viewHolder.getMContentView(), C8003R.dimen.settings_list_item_blank_end_content);
                    viewHolder.setImageVisibility(false);
                }
                if (memoMetaDataItem.getHasVoice()) {
                    String voiceRuntime = memoMetaDataItem.getVoiceRuntime();
                    Intrinsics.checkNotNullExpressionValue(voiceRuntime, "getVoiceRuntime(...)");
                    viewHolder.updateVoiceContainer(voiceRuntime);
                } else {
                    viewHolder.updateVoiceContainer("");
                }
                if (memoMetaDataItem.getIsFavorite()) {
                    viewHolder.updateFavoriteLayout(true);
                } else {
                    viewHolder.updateFavoriteLayout(false);
                }
            } else {
                viewHolder.setImageVisibility(false);
                viewHolder.updateVoiceContainer("");
                viewHolder.updateFavoriteLayout(false);
            }
            viewHolder.getMTimeContainer().setVisibility(0);
            TextView mModifiedTime = viewHolder.getMModifiedTime();
            Context context2 = viewHolder.getMModifiedTime().getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            mModifiedTime.setText(getDate(context2, (memoMetaDataItem == null || (lastModifiedAt = memoMetaDataItem.getLastModifiedAt()) == null) ? 0L : Long.parseLong(lastModifiedAt)));
        }
        if (viewHolder.isVisibleContent()) {
            int i = viewHolder.isVisibleTitle() ? 2 : 3;
            HoverPopupTextView mContentView = viewHolder.getMContentView();
            Intrinsics.checkNotNull(mContentView);
            mContentView.setMaxLines(i);
        }
        updateContentDescription(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ImportDocumentRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C8003R.layout.import_list_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        ImportDocumentRecyclerViewHolder importDocumentRecyclerViewHolder = new ImportDocumentRecyclerViewHolder(viewInflate);
        View rootCardView = importDocumentRecyclerViewHolder.getMRootCardView();
        if (rootCardView != null) {
            rootCardView.setTag(importDocumentRecyclerViewHolder);
            rootCardView.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.adapter.ImportDocumentRecyclerViewAdapter$onCreateViewHolder$1$1
                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
                    Intrinsics.checkNotNullParameter(host, "host");
                    Intrinsics.checkNotNullParameter(info, "info");
                    super.onInitializeAccessibilityNodeInfo(host, info);
                    info.setCheckable(true);
                    Object tag = host.getTag();
                    Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.adapter.holder.ImportDocumentRecyclerViewHolder");
                    CheckBox mCheckBox = ((ImportDocumentRecyclerViewHolder) tag).getMCheckBox();
                    Intrinsics.checkNotNull(mCheckBox);
                    info.setChecked(mCheckBox.isChecked());
                }
            });
            rootCardView.setOnClickListener(new ViewOnClickListenerC8556a(this, 5));
            rootCardView.setOnLongClickListener(new ViewOnLongClickListenerC7556a(this, 1));
        }
        return importDocumentRecyclerViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull ImportDocumentRecyclerViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        ImportDocumentModel importDocumentModel = this.mFilteredItemData.get(holder.getAdapterPosition());
        Intrinsics.checkNotNullExpressionValue(importDocumentModel, "get(...)");
        ImportDocumentModel importDocumentModel2 = importDocumentModel;
        CheckBox mCheckBox = holder.getMCheckBox();
        if (mCheckBox != null) {
            mCheckBox.setChecked(importDocumentModel2.getIsChecked());
        }
    }

    public final void add(@NotNull ImportDocumentModel item) {
        int iIndexOf;
        boolean zIsChecked;
        Intrinsics.checkNotNullParameter(item, "item");
        MainLogger.m7258i(TAG, "add()");
        boolean z = true;
        if (item.getDataType() == 1) {
            add(this.mImportDataContainer, item);
            addToFilteredItems(item);
            return;
        }
        Iterator<ImportDocumentModel> it = this.mImportDataContainer.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (true) {
            if (!it.hasNext()) {
                z = false;
                iIndexOf = 0;
                zIsChecked = false;
                break;
            } else {
                ImportDocumentModel next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                ImportDocumentModel importDocumentModel = next;
                if (importDocumentModel.getImportItem() == item.getImportItem()) {
                    iIndexOf = this.mImportDataContainer.indexOf(importDocumentModel);
                    zIsChecked = importDocumentModel.getIsChecked();
                    break;
                }
            }
        }
        if (z) {
            ImportDocumentModel importDocumentModel2 = this.mImportDataContainer.get(iIndexOf);
            Intrinsics.checkNotNullExpressionValue(importDocumentModel2, "get(...)");
            ImportDocumentModel importDocumentModel3 = importDocumentModel2;
            this.mImportDataContainer.set(iIndexOf, item);
            if (this.mFilteredItemData.indexOf(importDocumentModel3) >= 0) {
                ArrayList<ImportDocumentModel> arrayList = this.mFilteredItemData;
                arrayList.set(arrayList.indexOf(importDocumentModel3), item);
                notifyItemChanged(this.mFilteredItemData.indexOf(item));
            }
            item.setChecked(zIsChecked);
            return;
        }
        add(this.mImportDataContainer, item);
        addToFilteredItems(item);
    }
}
