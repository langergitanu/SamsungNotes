package com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001a\u001b\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\nH\u0016J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nJ\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/ImportCategorySpinnerAdapter;", "Landroid/widget/BaseAdapter;", "mContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/ImportCategorySpinnerAdapter$Contract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/ImportCategorySpinnerAdapter$Contract;)V", "mCategories", "", "", "mCounts", "", "getCount", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", DynamicActionBarProvider.METHOD_GET_DATA, "add", "", "category", "Contract", "ViewHolder", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImportCategorySpinnerAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImportCategorySpinnerAdapter.kt\ncom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/ImportCategorySpinnerAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,165:1\n1#2:166\n*E\n"})
public final class ImportCategorySpinnerAdapter extends BaseAdapter {
    private static final int ALL_CATEGORY_INDEX = 0;

    @NotNull
    private static final String TAG = "ST$ImportCategorySpinnerAdapter";

    @NotNull
    private final List<String> mCategories;

    @NotNull
    private final Contract mContract;

    @NotNull
    private final List<Integer> mCounts;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/ImportCategorySpinnerAdapter$Contract;", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "spinnerListView", "Landroid/widget/ListView;", "getSpinnerListView", "()Landroid/widget/ListView;", "defaultTitle", "", "getDefaultTitle", "()Ljava/lang/String;", "selectedCategoryPosition", "", "getSelectedCategoryPosition", "()I", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        @Nullable
        Context getContext();

        @NotNull
        String getDefaultTitle();

        int getSelectedCategoryPosition();

        @Nullable
        ListView getSpinnerListView();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/ImportCategorySpinnerAdapter$ViewHolder;", "", "<init>", "()V", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "setTitleView", "(Landroid/widget/TextView;)V", "countView", "getCountView", "setCountView", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ViewHolder {

        @Nullable
        private TextView countView;

        @Nullable
        private TextView titleView;

        @Nullable
        public final TextView getCountView() {
            return this.countView;
        }

        @Nullable
        public final TextView getTitleView() {
            return this.titleView;
        }

        public final void setCountView(@Nullable TextView textView) {
            this.countView = textView;
        }

        public final void setTitleView(@Nullable TextView textView) {
            this.titleView = textView;
        }
    }

    public ImportCategorySpinnerAdapter(@NotNull Contract mContract) {
        Intrinsics.checkNotNullParameter(mContract, "mContract");
        this.mContract = mContract;
        ArrayList arrayList = new ArrayList();
        this.mCategories = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.mCounts = arrayList2;
        arrayList.add("");
        arrayList2.add(0);
        Context context = mContract.getContext();
        Intrinsics.checkNotNull(context);
        String string = context.getResources().getString(C8003R.string.uncategorised);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        arrayList.add(string);
        arrayList2.add(0);
    }

    public final void add(@Nullable String category) {
        List<Integer> list = this.mCounts;
        list.set(0, Integer.valueOf(list.get(0).intValue() + 1));
        if (category == null || category.length() == 0) {
            List<Integer> list2 = this.mCounts;
            list2.set(list2.size() - 1, Integer.valueOf(((Number) AbstractC0000a.m10g(this.mCounts, 1)).intValue() + 1));
            return;
        }
        int size = this.mCategories.size();
        int i = 1;
        while (true) {
            if (i >= size) {
                this.mCategories.add(size - 1, category);
                List<Integer> list3 = this.mCounts;
                list3.add(list3.size() - 1, 1);
                break;
            } else {
                if (StringsKt__StringsJVMKt.compareTo(category, this.mCategories.get(i), true) == 0) {
                    List<Integer> list4 = this.mCounts;
                    list4.set(i, Integer.valueOf(list4.get(i).intValue() + 1));
                    break;
                }
                i++;
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size = this.mCategories.size();
        return ((Number) AbstractC0000a.m10g(this.mCounts, 1)).intValue() == 0 ? size - 1 : size;
    }

    @Override // android.widget.Adapter
    @NotNull
    public Object getItem(int position) {
        return this.mCategories.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @NotNull
    public final String getTitle(int position) {
        if (position >= 0 && position < this.mCategories.size()) {
            return position == 0 ? this.mContract.getDefaultTitle() : this.mCategories.get(position);
        }
        MainLogger.m7258i(TAG, "Invalid spinner position");
        return "";
    }

    @Override // android.widget.Adapter
    @NotNull
    public View getView(int position, @Nullable View convertView, @NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(C8003R.layout.notespicker_spinner_dropdown_item, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.setTitleView((TextView) convertView.findViewById(C8003R.id.category_title));
            viewHolder.setCountView((TextView) convertView.findViewById(C8003R.id.category_count));
            convertView.setTag(viewHolder);
        }
        Object tag = convertView.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.adapter.ImportCategorySpinnerAdapter.ViewHolder");
        ViewHolder viewHolder2 = (ViewHolder) tag;
        if (viewHolder2.getTitleView() == null) {
            throw new IllegalStateException("Invalid view holder");
        }
        TextView titleView = viewHolder2.getTitleView();
        Intrinsics.checkNotNull(titleView);
        titleView.setText(getTitle(position));
        TextView countView = viewHolder2.getCountView();
        Intrinsics.checkNotNull(countView);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(" (%s)", Arrays.copyOf(new Object[]{ContentUtils.convertToArabicNumber(this.mCounts.get(position).intValue())}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        countView.setText(str);
        if (this.mContract.getSpinnerListView() == null || this.mContract.getSelectedCategoryPosition() != position) {
            TextView titleView2 = viewHolder2.getTitleView();
            Intrinsics.checkNotNull(titleView2);
            Context context = this.mContract.getContext();
            Intrinsics.checkNotNull(context);
            titleView2.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, C8003R.color.notes_title_color)));
            TextView countView2 = viewHolder2.getCountView();
            Intrinsics.checkNotNull(countView2);
            Context context2 = this.mContract.getContext();
            Intrinsics.checkNotNull(context2);
            countView2.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context2, C8003R.color.notes_title_color)));
            return convertView;
        }
        TextView titleView3 = viewHolder2.getTitleView();
        Intrinsics.checkNotNull(titleView3);
        Context context3 = this.mContract.getContext();
        Intrinsics.checkNotNull(context3);
        titleView3.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context3, C8003R.color.notes_primary_color)));
        TextView countView3 = viewHolder2.getCountView();
        Intrinsics.checkNotNull(countView3);
        Context context4 = this.mContract.getContext();
        Intrinsics.checkNotNull(context4);
        countView3.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context4, C8003R.color.notes_primary_color)));
        return convertView;
    }
}
