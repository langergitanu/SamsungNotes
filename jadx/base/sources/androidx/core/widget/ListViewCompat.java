package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.ReplaceWith;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class ListViewCompat {
    private ListViewCompat() {
    }

    @ReplaceWith(expression = "listView.canScrollList(direction)")
    @Deprecated
    public static boolean canScrollList(ListView listView, int i) {
        return listView.canScrollList(i);
    }

    @ReplaceWith(expression = "listView.scrollListBy(y)")
    @Deprecated
    public static void scrollListBy(ListView listView, int i) {
        listView.scrollListBy(i);
    }
}
