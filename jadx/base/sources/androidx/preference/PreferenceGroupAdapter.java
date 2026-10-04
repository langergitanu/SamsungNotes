package androidx.preference;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.AbstractC1974b;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class PreferenceGroupAdapter extends RecyclerView.Adapter<PreferenceViewHolder> implements Preference.OnPreferenceChangeInternalListener, PreferenceGroup.PreferencePositionCallback {
    private static final String TAG = "PreferenceGroupAdapter";
    private List<Integer> mAccessibilityPositionTable;
    private ViewGroup mParent;
    private final PreferenceGroup mPreferenceGroup;
    private final List<PreferenceResourceDescriptor> mPreferenceResourceDescriptors;
    private List<Preference> mPreferences;
    private List<Preference> mVisiblePreferences;
    private final Runnable mSyncRunnable = new Runnable() { // from class: androidx.preference.PreferenceGroupAdapter.1
        @Override // java.lang.Runnable
        public void run() {
            PreferenceGroupAdapter.this.updatePreferences();
        }
    };
    private int mCategoryLayoutId = C3711R.layout.sesl_preference_category;
    private boolean mIsCategoryAfter = false;
    private Preference mNextPreference = null;
    private Preference mNextGroupPreference = null;
    private int mParentWidth = 0;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PreferenceResourceDescriptor {
        String mClassName;
        String mDotDescription;
        boolean mIsDotVisibled;
        int mLayoutResId;
        int mWidgetLayoutResId;

        public PreferenceResourceDescriptor(@NonNull Preference preference) {
            this.mClassName = preference.getClass().getName();
            this.mLayoutResId = preference.getLayoutResource();
            this.mWidgetLayoutResId = preference.getWidgetLayoutResource();
            this.mIsDotVisibled = preference.getDotVisibility();
            this.mDotDescription = preference.getDotContentDescription();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PreferenceResourceDescriptor)) {
                return false;
            }
            PreferenceResourceDescriptor preferenceResourceDescriptor = (PreferenceResourceDescriptor) obj;
            return this.mLayoutResId == preferenceResourceDescriptor.mLayoutResId && this.mWidgetLayoutResId == preferenceResourceDescriptor.mWidgetLayoutResId && TextUtils.equals(this.mClassName, preferenceResourceDescriptor.mClassName) && this.mIsDotVisibled == preferenceResourceDescriptor.mIsDotVisibled && TextUtils.equals(this.mDotDescription, preferenceResourceDescriptor.mDotDescription);
        }

        public int hashCode() {
            return this.mClassName.hashCode() + ((((527 + this.mLayoutResId) * 31) + this.mWidgetLayoutResId) * 31);
        }
    }

    public PreferenceGroupAdapter(PreferenceGroup preferenceGroup) {
        this.mPreferenceGroup = preferenceGroup;
        preferenceGroup.setOnPreferenceChangeInternalListener(this);
        this.mPreferences = new ArrayList();
        this.mVisiblePreferences = new ArrayList();
        this.mPreferenceResourceDescriptors = new ArrayList();
        this.mAccessibilityPositionTable = new ArrayList();
        if (preferenceGroup instanceof PreferenceScreen) {
            setHasStableIds(((PreferenceScreen) preferenceGroup).shouldUseGeneratedIds());
        } else {
            setHasStableIds(true);
        }
        updatePreferences();
    }

    private List<Integer> createAccessibilityPositionTable() {
        int i;
        ArrayList arrayList = new ArrayList();
        Iterator<Preference> it = this.mVisiblePreferences.iterator();
        int i2 = -1;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (it.next().getLayoutResource() != C3711R.layout.sesl_preference_category_empty) {
                i2++;
            }
            arrayList.add(Integer.valueOf(Math.max(i2, 0)));
        }
        if (arrayList.size() > 0 && ((Integer) AbstractC1974b.m1313f(1, arrayList)).intValue() >= this.mVisiblePreferences.size()) {
            Log.w(TAG, "accessibilityPosition over visible size | last " + arrayList.get(arrayList.size() - 1) + " vsize " + this.mVisiblePreferences.size());
            for (i = 0; i < arrayList.size(); i++) {
                arrayList.set(i, Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    private ExpandButton createExpandButton(final PreferenceGroup preferenceGroup, List<Preference> list) {
        ExpandButton expandButton = new ExpandButton(preferenceGroup.getContext(), list, preferenceGroup.getId());
        expandButton.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: androidx.preference.PreferenceGroupAdapter.3
            @Override // androidx.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(@NonNull Preference preference) {
                preferenceGroup.setInitialExpandedChildrenCount(Integer.MAX_VALUE);
                PreferenceGroupAdapter.this.onPreferenceHierarchyChange(preference);
                PreferenceGroup.OnExpandButtonClickListener onExpandButtonClickListener = preferenceGroup.getOnExpandButtonClickListener();
                if (onExpandButtonClickListener == null) {
                    return true;
                }
                onExpandButtonClickListener.onExpandButtonClick();
                return true;
            }
        });
        return expandButton;
    }

    private List<Preference> createVisiblePreferencesList(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        int i = 0;
        for (int i2 = 0; i2 < preferenceCount; i2++) {
            Preference preference = preferenceGroup.getPreference(i2);
            if (preference.isVisible()) {
                if (!isGroupExpandable(preferenceGroup) || i < preferenceGroup.getInitialExpandedChildrenCount()) {
                    arrayList.add(preference);
                } else {
                    arrayList2.add(preference);
                }
                if (preference instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preference;
                    if (!preferenceGroup2.isOnSameScreenAsChildren()) {
                        continue;
                    } else {
                        if (isGroupExpandable(preferenceGroup) && isGroupExpandable(preferenceGroup2)) {
                            throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                        }
                        for (Preference preference2 : createVisiblePreferencesList(preferenceGroup2)) {
                            if (!isGroupExpandable(preferenceGroup) || i < preferenceGroup.getInitialExpandedChildrenCount()) {
                                arrayList.add(preference2);
                            } else {
                                arrayList2.add(preference2);
                            }
                            i++;
                        }
                    }
                } else {
                    i++;
                }
            }
        }
        if (isGroupExpandable(preferenceGroup) && i > preferenceGroup.getInitialExpandedChildrenCount()) {
            arrayList.add(createExpandButton(preferenceGroup, arrayList2));
        }
        return arrayList;
    }

    private void flattenPreferenceGroup(List<Preference> list, PreferenceGroup preferenceGroup) {
        preferenceGroup.sortPreferences();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            Preference preference = preferenceGroup.getPreference(i);
            if (i == preferenceCount - 1) {
                this.mNextPreference = null;
                if (this.mIsCategoryAfter && preference == this.mNextGroupPreference) {
                    this.mNextGroupPreference = null;
                }
            } else {
                this.mNextPreference = preferenceGroup.getPreference(i + 1);
                if (preference == this.mNextGroupPreference) {
                    this.mNextGroupPreference = null;
                }
            }
            boolean z = preference instanceof PreferenceCategory;
            if (z && !preference.mIsRoundChanged) {
                preference.seslSetSubheaderRoundedBackground(15);
            }
            list.add(preference);
            if (z && TextUtils.isEmpty(preference.getTitle()) && this.mCategoryLayoutId == preference.getLayoutResource()) {
                preference.setLayoutResource(C3711R.layout.sesl_preference_category_empty);
            }
            PreferenceResourceDescriptor preferenceResourceDescriptor = new PreferenceResourceDescriptor(preference);
            if (!this.mPreferenceResourceDescriptors.contains(preferenceResourceDescriptor)) {
                this.mPreferenceResourceDescriptors.add(preferenceResourceDescriptor);
            }
            if (preference instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preference;
                if (preferenceGroup2.isOnSameScreenAsChildren()) {
                    this.mNextGroupPreference = this.mNextPreference;
                    flattenPreferenceGroup(list, preferenceGroup2);
                }
            }
            preference.setOnPreferenceChangeInternalListener(this);
        }
    }

    private boolean isGroupExpandable(PreferenceGroup preferenceGroup) {
        return preferenceGroup.getInitialExpandedChildrenCount() != Integer.MAX_VALUE;
    }

    @Nullable
    public Preference getItem(int i) {
        if (i < 0 || i >= getItemCount()) {
            return null;
        }
        return this.mVisiblePreferences.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mVisiblePreferences.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        if (!hasStableIds() || getItem(i) == null) {
            return -1L;
        }
        return getItem(i).getId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        PreferenceResourceDescriptor preferenceResourceDescriptor = new PreferenceResourceDescriptor(getItem(i));
        int iIndexOf = this.mPreferenceResourceDescriptors.indexOf(preferenceResourceDescriptor);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int size = this.mPreferenceResourceDescriptors.size();
        this.mPreferenceResourceDescriptors.add(preferenceResourceDescriptor);
        return size;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getListWidth() {
        return this.mParentWidth;
    }

    @Override // androidx.preference.PreferenceGroup.PreferencePositionCallback
    public int getPreferenceAdapterPosition(@NonNull String str) {
        int size = this.mVisiblePreferences.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(str, this.mVisiblePreferences.get(i).getKey())) {
                return i;
            }
        }
        return -1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isSwitchLayout(Preference preference) {
        if (preference.getLayoutResource() == C3711R.layout.sesl_preference_switch && preference.getWidgetLayoutResource() == C3711R.layout.sesl_preference_widget_switch) {
            return true;
        }
        return preference.getLayoutResource() == C3711R.layout.sesl_preference_switch_screen && preference.getWidgetLayoutResource() == C3711R.layout.sesl_switch_preference_screen_widget_divider;
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeInternalListener
    public void onPreferenceChange(@NonNull Preference preference) {
        int iIndexOf = this.mVisiblePreferences.indexOf(preference);
        if (iIndexOf != -1) {
            notifyItemChanged(iIndexOf, preference);
        }
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeInternalListener
    public void onPreferenceHierarchyChange(@NonNull Preference preference) {
        this.mHandler.removeCallbacks(this.mSyncRunnable);
        this.mHandler.post(this.mSyncRunnable);
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeInternalListener
    public void onPreferenceVisibilityChange(@NonNull Preference preference) {
        onPreferenceHierarchyChange(preference);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int seslGetAccessibilityItemCount() {
        List<Integer> list = this.mAccessibilityPositionTable;
        if (list != null && list.size() > 0) {
            return ((Integer) AbstractC0000a.m10g(this.mAccessibilityPositionTable, 1)).intValue() + 1;
        }
        Iterator<Preference> it = this.mVisiblePreferences.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getLayoutResource() == C3711R.layout.sesl_preference_category_empty) {
                i++;
            }
        }
        return getItemCount() - i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int seslGetAccessibilityItemPosition(int i) {
        List<Integer> list = this.mAccessibilityPositionTable;
        if (list == null || i >= list.size()) {
            return -1;
        }
        return this.mAccessibilityPositionTable.get(i).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean seslUseCustomAccessibilityPosition() {
        return true;
    }

    public void updatePreferences() {
        Iterator<Preference> it = this.mPreferences.iterator();
        while (it.hasNext()) {
            it.next().setOnPreferenceChangeInternalListener(null);
        }
        ArrayList arrayList = new ArrayList(this.mPreferences.size());
        this.mPreferences = arrayList;
        flattenPreferenceGroup(arrayList, this.mPreferenceGroup);
        final List<Preference> list = this.mVisiblePreferences;
        final List<Preference> listCreateVisiblePreferencesList = createVisiblePreferencesList(this.mPreferenceGroup);
        this.mVisiblePreferences = listCreateVisiblePreferencesList;
        this.mAccessibilityPositionTable = createAccessibilityPositionTable();
        PreferenceManager preferenceManager = this.mPreferenceGroup.getPreferenceManager();
        if (preferenceManager == null || preferenceManager.getPreferenceComparisonCallback() == null) {
            notifyDataSetChanged();
        } else {
            final PreferenceManager.PreferenceComparisonCallback preferenceComparisonCallback = preferenceManager.getPreferenceComparisonCallback();
            DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: androidx.preference.PreferenceGroupAdapter.2
                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areContentsTheSame(int i, int i2) {
                    return preferenceComparisonCallback.arePreferenceContentsTheSame((Preference) list.get(i), (Preference) listCreateVisiblePreferencesList.get(i2));
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areItemsTheSame(int i, int i2) {
                    return preferenceComparisonCallback.arePreferenceItemsTheSame((Preference) list.get(i), (Preference) listCreateVisiblePreferencesList.get(i2));
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getNewListSize() {
                    return listCreateVisiblePreferencesList.size();
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getOldListSize() {
                    return list.size();
                }
            }).dispatchUpdatesTo(this);
        }
        Iterator<Preference> it2 = this.mPreferences.iterator();
        while (it2.hasNext()) {
            it2.next().clearWasDetached();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull PreferenceViewHolder preferenceViewHolder, int i) {
        Preference item = getItem(i);
        preferenceViewHolder.resetState();
        if (!isSwitchLayout(item)) {
            if (item instanceof SeekBarPreference) {
                preferenceViewHolder.seslSetViewHolderRecoilEffectEnabled(false);
            }
            item.onBindViewHolder(preferenceViewHolder);
            return;
        }
        int width = this.mParent.getWidth();
        this.mParentWidth = width;
        if (item instanceof SwitchPreference) {
            ((SwitchPreference) item).onBindViewHolder(preferenceViewHolder, width);
        } else if (item instanceof SwitchPreferenceCompat) {
            ((SwitchPreferenceCompat) item).onBindViewHolder(preferenceViewHolder, width);
        } else {
            item.onBindViewHolder(preferenceViewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public PreferenceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        PreferenceResourceDescriptor preferenceResourceDescriptor = this.mPreferenceResourceDescriptors.get(i);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        this.mParent = viewGroup;
        View viewInflate = layoutInflaterFrom.inflate(preferenceResourceDescriptor.mLayoutResId, viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(android.R.id.widget_frame);
        if (viewGroup2 != null) {
            int i2 = preferenceResourceDescriptor.mWidgetLayoutResId;
            if (i2 != 0) {
                layoutInflaterFrom.inflate(i2, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        View viewFindViewById = viewInflate.findViewById(C3711R.id.badge_frame);
        if (viewFindViewById != null) {
            if (preferenceResourceDescriptor.mIsDotVisibled) {
                viewFindViewById.setVisibility(0);
            } else {
                viewFindViewById.setVisibility(8);
            }
            String str = preferenceResourceDescriptor.mDotDescription;
            if (str != null) {
                viewFindViewById.setContentDescription(str);
            }
        }
        return new PreferenceViewHolder(viewInflate);
    }

    @Override // androidx.preference.PreferenceGroup.PreferencePositionCallback
    public int getPreferenceAdapterPosition(@NonNull Preference preference) {
        int size = this.mVisiblePreferences.size();
        for (int i = 0; i < size; i++) {
            Preference preference2 = this.mVisiblePreferences.get(i);
            if (preference2 != null && preference2.equals(preference)) {
                return i;
            }
        }
        return -1;
    }
}
