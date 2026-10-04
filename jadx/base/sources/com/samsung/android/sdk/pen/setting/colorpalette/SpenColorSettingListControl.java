package com.samsung.android.sdk.pen.setting.colorpalette;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomappbar.RunnableC4587a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.sdk.pen.setting.colorpalette.OnSelectItemEventListener;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAccessibility;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0001\u0018\u0000 F2\u00020\u0001:\u0001FB)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u001d\u001a\u00020\u001eJ$\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u00152\b\u0010!\u001a\u0004\u0018\u00010\u00192\b\u0010\"\u001a\u0004\u0018\u00010\u0019J\u001e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bJ\u0010\u0010(\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010\u001cJ\u0016\u0010*\u001a\u00020$2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010,J\u0016\u0010-\u001a\u00020$2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005J\u000e\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\bJ\u000e\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\bJ\u000e\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u000207J\u0010\u00108\u001a\u0004\u0018\u0001092\u0006\u00106\u001a\u000207J\b\u0010:\u001a\u00020\u001eH\u0002J\u0010\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020\bH\u0002J\u0018\u0010=\u001a\u00020$2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002J(\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bH\u0002J\u0018\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\bH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00101\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b2\u0010\f¨\u0006G"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingListControl;", "", "mContext", "Landroid/content/Context;", "paletteData", "", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;", "maxSelectCount", "", "<init>", "(Landroid/content/Context;Ljava/util/List;I)V", "getMaxSelectCount", "()I", "mItems", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingItem;", "Lkotlin/collections/ArrayList;", "value", "selectedCount", "getSelectedCount", "mListView", "Landroid/widget/ListView;", "mListAdapter", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingListAdapter;", "mTopDivider", "Landroid/view/View;", "mBottomDivider", "mSelectItemEventListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnSelectItemEventListener;", "close", "", "setListInfo", "listView", "topDivider", "bottomDivider", "setListItemInfo", "", "itemId", "itemNormalDrawableId", "itemTransparentDrawableId", "setListSelectItemEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getSelectedList", XmlErrorCodes.LIST, "", "setSelectedList", "selectList", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "firstVisiblePosition", "getFirstVisiblePosition", "setSelection", "position", "notifyItemUnchanged", "reason", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnSelectItemEventListener$UnchangedReason;", "getItemUnchangedMessage", "", "clearSelectedItem", "setSelectedItem", "index", "initSwatchList", "initListView", "context", "resourceId", "normalResource", "transparentResource", "setDivider", "topVisible", "bottomVisible", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
@SourceDebugExtension({"SMAP\nSpenColorSettingListControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenColorSettingListControl.kt\ncom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingListControl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,225:1\n1#2:226\n*E\n"})
public final class SpenColorSettingListControl {
    public static final int MIN_SELECT_COUNT = 1;

    @NotNull
    private static final String TAG = "SpenColorSettingListControl";

    @Nullable
    private View mBottomDivider;

    @Nullable
    private Context mContext;

    @NotNull
    private ArrayList<SpenColorSettingItem> mItems = new ArrayList<>();

    @Nullable
    private SpenColorSettingListAdapter mListAdapter;

    @Nullable
    private ListView mListView;

    @Nullable
    private OnSelectItemEventListener mSelectItemEventListener;

    @Nullable
    private View mTopDivider;
    private final int maxSelectCount;
    private int selectedCount;

    public SpenColorSettingListControl(@Nullable Context context, @Nullable List<SpenColorPaletteData> list, int i) {
        this.mContext = context;
        this.maxSelectCount = i;
        initSwatchList(list);
    }

    private final void clearSelectedItem() {
        Iterator<SpenColorSettingItem> it = this.mItems.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenColorSettingItem next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.setUsed(false);
        }
    }

    private final void initListView(Context context, int resourceId, int normalResource, int transparentResource) {
        if (this.mListView == null) {
            return;
        }
        SpenColorSettingListAdapter spenColorSettingListAdapter = new SpenColorSettingListAdapter(context, resourceId, this.mItems);
        this.mListAdapter = spenColorSettingListAdapter;
        spenColorSettingListAdapter.setItemBackgroundResource(normalResource, transparentResource);
        ListView listView = this.mListView;
        if (listView != null) {
            listView.setAdapter((ListAdapter) this.mListAdapter);
        }
        ListView listView2 = this.mListView;
        if (listView2 != null) {
            listView2.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingListControl.initListView.1
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    int i = 0;
                    int i2 = (firstVisibleItem != 0 || view.canScrollList(-1)) ? 0 : 8;
                    if (firstVisibleItem + visibleItemCount == SpenColorSettingListControl.this.mItems.size() && !view.canScrollList(1)) {
                        i = 8;
                    }
                    SpenColorSettingListControl.this.setDivider(i2, i);
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView view, int scrollState) {
                    Intrinsics.checkNotNullParameter(view, "view");
                }
            });
        }
        ListView listView3 = this.mListView;
        if (listView3 != null) {
            listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingListControl.initListView.2
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Log.i(SpenColorSettingListControl.TAG, "onItemClick!!!! position=" + position + " Items=NOT NULL");
                    Object obj = SpenColorSettingListControl.this.mItems.get(position);
                    Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                    SpenColorSettingItem spenColorSettingItem = (SpenColorSettingItem) obj;
                    boolean zIsUsed = spenColorSettingItem.getIsUsed();
                    OnSelectItemEventListener.UnchangedReason unchangedReason = OnSelectItemEventListener.UnchangedReason.UNKNOWN;
                    boolean z = false;
                    if (!zIsUsed && SpenColorSettingListControl.this.getSelectedCount() == SpenColorSettingListControl.this.getMaxSelectCount()) {
                        unchangedReason = OnSelectItemEventListener.UnchangedReason.MAX_VALUE_LIMIT;
                    } else if (zIsUsed && SpenColorSettingListControl.this.getSelectedCount() == 1) {
                        unchangedReason = OnSelectItemEventListener.UnchangedReason.MIN_VALUE_LIMIT;
                    } else {
                        SpenColorSettingListControl spenColorSettingListControl = SpenColorSettingListControl.this;
                        spenColorSettingListControl.selectedCount = spenColorSettingListControl.getSelectedCount() + (spenColorSettingItem.toggle() ? 1 : -1);
                        SpenColorSettingListAdapter spenColorSettingListAdapter2 = SpenColorSettingListControl.this.mListAdapter;
                        if (spenColorSettingListAdapter2 != null) {
                            spenColorSettingListAdapter2.notifyDataSetChanged();
                        }
                        zIsUsed = spenColorSettingItem.getIsUsed();
                        z = true;
                    }
                    AbstractC2322a.m1631u(SpenColorSettingListControl.this.getSelectedCount(), "selectedCount=", SpenColorSettingListControl.TAG);
                    if (SpenColorSettingListControl.this.mSelectItemEventListener == null) {
                        return;
                    }
                    if (z) {
                        OnSelectItemEventListener onSelectItemEventListener = SpenColorSettingListControl.this.mSelectItemEventListener;
                        if (onSelectItemEventListener != null) {
                            onSelectItemEventListener.onSelectItemChanged(position, zIsUsed);
                            return;
                        }
                        return;
                    }
                    OnSelectItemEventListener onSelectItemEventListener2 = SpenColorSettingListControl.this.mSelectItemEventListener;
                    if (onSelectItemEventListener2 != null) {
                        onSelectItemEventListener2.onSelectItemUnchanged(position, unchangedReason);
                    }
                }
            });
        }
        ListView listView4 = this.mListView;
        if (listView4 != null) {
            listView4.setOnItemSelectedListener(new C75263(context));
        }
    }

    private final boolean initSwatchList(List<SpenColorPaletteData> paletteData) {
        List<SpenColorPaletteData> list = paletteData;
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (SpenColorPaletteData spenColorPaletteData : paletteData) {
            this.mItems.add(new SpenColorSettingItem(spenColorPaletteData.index, spenColorPaletteData.values, spenColorPaletteData.names, spenColorPaletteData.themeValues));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDivider(int topVisible, int bottomVisible) {
        View view = this.mTopDivider;
        if (view != null && view.getVisibility() != topVisible) {
            view.setVisibility(topVisible);
        }
        View view2 = this.mBottomDivider;
        if (view2 == null || view2.getVisibility() == bottomVisible) {
            return;
        }
        view2.setVisibility(bottomVisible);
    }

    private final boolean setSelectedItem(int index) {
        Iterator<SpenColorSettingItem> it = this.mItems.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenColorSettingItem next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenColorSettingItem spenColorSettingItem = next;
            if (spenColorSettingItem.getIndex() == index && !spenColorSettingItem.getIsUsed()) {
                spenColorSettingItem.setUsed(true);
                return true;
            }
        }
        return false;
    }

    public final void close() {
        this.mContext = null;
        this.mItems.clear();
        this.mListAdapter = null;
        this.mListView = null;
        this.mTopDivider = null;
        this.mBottomDivider = null;
    }

    public final int getFirstVisiblePosition() {
        ListView listView = this.mListView;
        if (listView != null) {
            return listView.getFirstVisiblePosition();
        }
        return -1;
    }

    @Nullable
    public final String getItemUnchangedMessage(@NotNull OnSelectItemEventListener.UnchangedReason reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Context context = this.mContext;
        if (context == null) {
            return null;
        }
        if (reason != OnSelectItemEventListener.UnchangedReason.MAX_VALUE_LIMIT) {
            if (reason == OnSelectItemEventListener.UnchangedReason.MIN_VALUE_LIMIT) {
                return context.getResources().getString(C7932R.string.pen_string_setting_select_at_least_one);
            }
            return null;
        }
        Resources resources = context.getResources();
        int i = C7932R.plurals.plurals_count_show_colors;
        int i2 = this.maxSelectCount;
        return resources.getQuantityString(i, i2, Integer.valueOf(i2));
    }

    public final int getMaxSelectCount() {
        return this.maxSelectCount;
    }

    public final int getSelectedCount() {
        return this.selectedCount;
    }

    public final boolean getSelectedList(@Nullable List<Integer> list) {
        if (list == null) {
            Log.i(TAG, "getSelectPaletteList(). Item(or list) is null.");
            return false;
        }
        Iterator<SpenColorSettingItem> it = this.mItems.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenColorSettingItem next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenColorSettingItem spenColorSettingItem = next;
            if (spenColorSettingItem.getIsUsed()) {
                list.add(Integer.valueOf(spenColorSettingItem.getIndex()));
            }
        }
        return true;
    }

    public final void notifyItemUnchanged(@NotNull OnSelectItemEventListener.UnchangedReason reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        String itemUnchangedMessage = getItemUnchangedMessage(reason);
        if (itemUnchangedMessage != null) {
            Toast.makeText(this.mContext, itemUnchangedMessage, 0).show();
        }
    }

    public final void setColorTheme(int theme) {
        SpenColorSettingListAdapter spenColorSettingListAdapter = this.mListAdapter;
        if (spenColorSettingListAdapter != null) {
            spenColorSettingListAdapter.setColorTheme(theme);
        }
        SpenColorSettingListAdapter spenColorSettingListAdapter2 = this.mListAdapter;
        if (spenColorSettingListAdapter2 != null) {
            spenColorSettingListAdapter2.notifyDataSetChanged();
        }
    }

    public final void setListInfo(@Nullable ListView listView, @Nullable View topDivider, @Nullable View bottomDivider) {
        Log.i(TAG, "setListInfo() ");
        this.mListView = listView;
        this.mTopDivider = topDivider;
        this.mBottomDivider = bottomDivider;
    }

    public final boolean setListItemInfo(int itemId, int itemNormalDrawableId, int itemTransparentDrawableId) {
        if (this.mListView == null) {
            return false;
        }
        Context context = this.mContext;
        if (context == null) {
            return true;
        }
        initListView(context, itemId, itemNormalDrawableId, itemTransparentDrawableId);
        return true;
    }

    public final void setListSelectItemEventListener(@Nullable OnSelectItemEventListener listener) {
        this.mSelectItemEventListener = listener;
    }

    public final boolean setSelectedList(@Nullable List<Integer> selectList) {
        Log.i(TAG, "setSelectedList()");
        if (selectList == null) {
            Log.i(TAG, "setSelectPaletteList(). Item(or selectedList) is null.");
            return false;
        }
        if (selectList.size() > this.maxSelectCount) {
            AbstractC6670b.m4744e(selectList.size(), this.maxSelectCount, "setSelectPaletteList(). The maximum is exceeded. input=", " max=", TAG);
            return false;
        }
        if (this.selectedCount > 0) {
            clearSelectedItem();
            this.selectedCount = 0;
        }
        int size = selectList.size();
        for (int i = 0; i < size; i++) {
            Log.i(TAG, "[" + i + "]=" + selectList.get(i));
            if (setSelectedItem(selectList.get(i).intValue())) {
                this.selectedCount++;
            }
        }
        SpenColorSettingListAdapter spenColorSettingListAdapter = this.mListAdapter;
        if (spenColorSettingListAdapter != null) {
            spenColorSettingListAdapter.notifyDataSetChanged();
        }
        return true;
    }

    public final void setSelection(int position) {
        ListView listView = this.mListView;
        if (listView != null) {
            listView.setSelection(position);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingListControl$initListView$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016¨\u0006\r"}, m13886d2 = {"com/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingListControl$initListView$3", "Landroid/widget/AdapterView$OnItemSelectedListener;", "onItemSelected", "", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "", "id", "", "onNothingSelected", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class C75263 implements AdapterView.OnItemSelectedListener {
        final /* synthetic */ Context $context;

        public C75263(Context context) {
            this.$context = context;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (view == null || !SpenSettingUtilAccessibility.isVoiceAssistantEnabled(this.$context)) {
                return;
            }
            view.post(new RunnableC4587a(view, 2));
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }
}
