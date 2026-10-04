package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.widget.somrecognizedcard.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class StaggeredGridLayout extends LinearLayout {
    private static final String PRE_FIX_ROW = "row_";
    private static final String TAG = "StaggeredGridLayout";
    private Map<Integer, String> mItemTags;
    private List<View> mItems;
    private int mLastAddedRow;
    private int mSpanCount;

    public StaggeredGridLayout(Context context) {
        super(context);
        init(context);
    }

    private void backupItems() {
        for (int i = 0; i < this.mItems.size(); i++) {
            View viewRemoveItem = removeItem(i);
            if (viewRemoveItem != null) {
                this.mItems.add(viewRemoveItem);
            }
        }
    }

    private LinearLayout createRow(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setTag(PRE_FIX_ROW + i);
        return linearLayout;
    }

    private ViewGroup findRow(int i) {
        return (ViewGroup) findViewWithTag(PRE_FIX_ROW + i);
    }

    private int getMinHeightRow() {
        int i = this.mLastAddedRow;
        int i2 = (i + 1) % this.mSpanCount;
        int i4 = i + 1;
        int i5 = 1000000000;
        while (true) {
            int i6 = this.mSpanCount;
            if (i4 >= this.mLastAddedRow + i6) {
                return i2;
            }
            int i7 = i4 % i6;
            ViewGroup viewGroupFindRow = findRow(i7);
            if (viewGroupFindRow != null) {
                viewGroupFindRow.measure(0, 0);
                int measuredHeight = viewGroupFindRow.getMeasuredHeight();
                if (measuredHeight < i5) {
                    i2 = i7;
                    i5 = measuredHeight;
                }
            }
            i4++;
        }
    }

    private void init(Context context) {
        setOrientation(0);
        this.mItems = new ArrayList();
        this.mItemTags = new HashMap();
        this.mSpanCount = getResources().getConfiguration().orientation != 1 ? 2 : 1;
        this.mLastAddedRow = -1;
        initRows();
    }

    private void initRows() {
        removeAllViews();
        for (int i = 0; i < this.mSpanCount; i++) {
            addView(createRow(i), i, new LinearLayoutCompat.LayoutParams(0, -2, 1.0f));
        }
    }

    private View removeItem(int i) {
        return removeItem(this.mItemTags.get(Integer.valueOf(i)));
    }

    private void restoreItems() {
        for (int i = 0; i < this.mItems.size(); i++) {
            View view = this.mItems.get(i);
            if (view != null) {
                addItem(view);
            }
        }
        this.mItems.clear();
    }

    public void addItem(View view) {
        int minHeightRow = getMinHeightRow();
        ViewGroup viewGroupFindRow = findRow(minHeightRow);
        if (viewGroupFindRow == null) {
            return;
        }
        Map<Integer, String> map = this.mItemTags;
        map.put(Integer.valueOf(map.size()), (String) view.getTag());
        this.mLastAddedRow = minHeightRow;
        viewGroupFindRow.addView(view, -1, -2);
        view.measure(0, 0);
    }

    public int getMaxRowHeight() {
        int i = 0;
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            ViewGroup viewGroupFindRow = findRow(i2);
            if (viewGroupFindRow != null) {
                viewGroupFindRow.measure(0, 0);
                int childCount = viewGroupFindRow.getChildCount();
                MainLogger.m7254d(TAG, "getMaxRowHeight, rowIdx: " + i2 + ", rowItemCount: " + childCount);
                int measuredHeight = 0;
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = viewGroupFindRow.getChildAt(i4);
                    childAt.measure(0, 0);
                    measuredHeight += childAt.getMeasuredHeight();
                    StringBuilder sbM1173s = AbstractC0622a.m1173s(i2, childCount, "getMaxRowHeight, rowIdx: ", ", rowItemCount: ", ". calculatedHeight: ");
                    sbM1173s.append(measuredHeight);
                    MainLogger.m7254d(TAG, sbM1173s.toString());
                }
                if (i < measuredHeight) {
                    i = measuredHeight;
                }
            }
        }
        return i;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        super.onLayout(z, i, i2, i4, i5);
        MainLogger.m7259w(TAG, "onLayout, " + getMeasuredHeight());
    }

    public void removeAllItems() {
        this.mItemTags.clear();
        this.mLastAddedRow = -1;
        initRows();
    }

    public void updateSpan() {
        int i = getResources().getConfiguration().orientation != 1 ? 2 : 1;
        if (this.mSpanCount == i) {
            return;
        }
        this.mSpanCount = i;
        this.mLastAddedRow = -1;
        backupItems();
        initRows();
        restoreItems();
    }

    public View removeItem(String str) {
        View viewFindViewWithTag;
        Integer key = null;
        if (TextUtils.isEmpty(str) || (viewFindViewWithTag = findViewWithTag(str)) == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) viewFindViewWithTag.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(viewFindViewWithTag);
        }
        Iterator<Map.Entry<Integer, String>> it = this.mItemTags.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Integer, String> next = it.next();
            if (next.getValue().equals(str)) {
                key = next.getKey();
                break;
            }
        }
        if (key != null) {
            this.mItemTags.remove(key);
        }
        return viewFindViewWithTag;
    }

    public StaggeredGridLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public StaggeredGridLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
