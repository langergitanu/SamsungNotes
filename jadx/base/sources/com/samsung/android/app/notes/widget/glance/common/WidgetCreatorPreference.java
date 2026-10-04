package com.samsung.android.app.notes.widget.glance.common;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/common/WidgetCreatorPreference;", "Lcom/samsung/android/support/senl/nt/base/widget/preference/BaseWidgetPreferenceManager;", "<init>", "()V", "saveSelectedItems", "", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "selectedItems", "", "getSelectedItems", "getSelectedItemsSet", "", "", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetCreatorPreference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetCreatorPreference.kt\ncom/samsung/android/app/notes/widget/glance/common/WidgetCreatorPreference\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,45:1\n1563#2:46\n1634#2,3:47\n1563#2:50\n1634#2,3:51\n*S KotlinDebug\n*F\n+ 1 WidgetCreatorPreference.kt\ncom/samsung/android/app/notes/widget/glance/common/WidgetCreatorPreference\n*L\n10#1:46\n10#1:47,3\n24#1:50\n24#1:51,3\n*E\n"})
public final class WidgetCreatorPreference extends BaseWidgetPreferenceManager {

    @NotNull
    public static final WidgetCreatorPreference INSTANCE = new WidgetCreatorPreference();
    public static final int $stable = 8;

    private WidgetCreatorPreference() {
    }

    @NotNull
    public final List<Integer> getSelectedItems(int appWidgetId) {
        Set<String> stringSet = SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getStringSet(AbstractC0541b.m767i(appWidgetId, BaseWidgetConstant.WIDGET_ID, BaseWidgetConstant.KEY_SELECTED_ITEMS), SetsKt.emptySet());
        List list = stringSet != null ? CollectionsKt.toList(stringSet) : null;
        if (list == null || list.isEmpty()) {
            return CollectionsKt.listOf((Object[]) new Integer[]{0, 1, 2, 3});
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list2));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(Integer.parseInt((String) it.next())));
        }
        return CollectionsKt.sorted(arrayList);
    }

    @NotNull
    public final Set<String> getSelectedItemsSet(int appWidgetId) {
        Set<String> stringSet = SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getStringSet(AbstractC0541b.m767i(appWidgetId, BaseWidgetConstant.WIDGET_ID, BaseWidgetConstant.KEY_SELECTED_ITEMS), SetsKt.emptySet());
        return (stringSet == null || stringSet.isEmpty()) ? SetsKt.setOf((Object[]) new String[]{"0", "1", "2", "3"}) : stringSet;
    }

    public final void saveSelectedItems(int appWidgetId, @NotNull List<Integer> selectedItems) {
        Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
        List<Integer> list = selectedItems;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).intValue()));
        }
        Set<String> set = CollectionsKt.toSet(arrayList);
        SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putStringSet(BaseWidgetConstant.WIDGET_ID + appWidgetId + BaseWidgetConstant.KEY_SELECTED_ITEMS, set);
    }
}
