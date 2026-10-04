package com.samsung.android.app.notes.widget.lockbrief;

import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.WidgetToolbarBroadCast;
import com.samsung.android.app.notes.widget.glance.common.WidgetCreatorPreference;
import com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorRecycleViewActivity;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.lockbrief.BaseWidgetLockBriefUnlockActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/lockbrief/WidgetCreatorLockBriefConfigureActivity;", "Lcom/samsung/android/support/senl/nt/base/widget/lockbrief/BaseWidgetLockBriefUnlockActivity;", "<init>", "()V", "mAppWidgetId", "", "mSelectedItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "startActivity", "Companion", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetCreatorLockBriefConfigureActivity extends BaseWidgetLockBriefUnlockActivity {
    private static final int REQUEST_CODE_CONFIG_CONTROL = 1;

    @NotNull
    private static final String TAG = "WidgetCreatorLockBriefConfigureActivity";
    private int mAppWidgetId = -1;

    @NotNull
    private ArrayList<Integer> mSelectedItems = new ArrayList<>();
    public static final int $stable = 8;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        List<Integer> listEmptyList;
        ArrayList<Integer> integerArrayListExtra;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == -1) {
            if (data == null || (integerArrayListExtra = data.getIntegerArrayListExtra(BaseWidgetConstant.KEY_SELECTED_ITEMS)) == null || (listEmptyList = CollectionsKt.toList(integerArrayListExtra)) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            if (!listEmptyList.isEmpty() && !Intrinsics.areEqual(this.mSelectedItems, listEmptyList)) {
                WidgetToolbarBroadCast.INSTANCE.sendUpdateWidgetCreatorBroadcast(this, this.mAppWidgetId, listEmptyList);
            }
        }
        finishAndRemoveTask();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.lockbrief.BaseWidgetLockBriefUnlockActivity
    public void startActivity() {
        this.mAppWidgetId = getIntent().getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
        this.mSelectedItems = new ArrayList<>(WidgetCreatorPreference.INSTANCE.getSelectedItems(this.mAppWidgetId));
        Intent intent = new Intent(this, (Class<?>) WidgetCreatorRecycleViewActivity.class);
        intent.putIntegerArrayListExtra(BaseWidgetConstant.KEY_SELECTED_ITEMS, this.mSelectedItems);
        startActivityForResult(intent, 1);
    }
}
