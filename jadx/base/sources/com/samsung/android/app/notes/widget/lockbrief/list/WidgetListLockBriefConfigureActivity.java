package com.samsung.android.app.notes.widget.lockbrief.list;

import android.app.ComponentCaller;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.lockbrief.BaseWidgetLockBriefUnlockActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013J\b\u0010\u0014\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/lockbrief/list/WidgetListLockBriefConfigureActivity;", "Lcom/samsung/android/support/senl/nt/base/widget/lockbrief/BaseWidgetLockBriefUnlockActivity;", "<init>", "()V", "mAppWidgetId", "", "mUuidList", "", "", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", NotesConstants.KEY_CALLER, "Landroid/app/ComponentCaller;", "getUuidListUpdate", "newUuidList", "", "startActivity", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetListLockBriefConfigureActivity extends BaseWidgetLockBriefUnlockActivity {
    private static final int REQUEST_INTENT_PICK_NOTE_LIST = 1;

    @NotNull
    private static final String TAG = "WidgetListLockBriefConfigureActivity";
    private int mAppWidgetId = -1;

    @NotNull
    private List<String> mUuidList = new ArrayList();
    public static final int $stable = 8;

    @NotNull
    public final List<String> getUuidListUpdate(@NotNull List<String> newUuidList) {
        Intrinsics.checkNotNullParameter(newUuidList, "newUuidList");
        ArrayList arrayList = new ArrayList(this.mUuidList);
        for (String str : new ArrayList(this.mUuidList)) {
            if (newUuidList.contains(str)) {
                newUuidList.remove(str);
            } else {
                arrayList.remove(str);
            }
        }
        arrayList.addAll(0, newUuidList);
        return arrayList;
    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data, @NotNull ComponentCaller caller) {
        ArrayList<String> arrayList;
        Intrinsics.checkNotNullParameter(caller, "caller");
        super.onActivityResult(requestCode, resultCode, data, caller);
        if (requestCode == 1 && resultCode == -1) {
            if (data == null || (arrayList = data.getStringArrayListExtra(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST)) == null) {
                arrayList = new ArrayList<>();
            }
            List<String> uuidListUpdate = getUuidListUpdate(CollectionsKt.toMutableList((Collection) arrayList));
            if (!Intrinsics.areEqual(this.mUuidList, uuidListUpdate)) {
                WidgetBroadcast.INSTANCE.sendPickNoteListBroadcast(this, this.mAppWidgetId, uuidListUpdate);
            }
        }
        finishAndRemoveTask();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.lockbrief.BaseWidgetLockBriefUnlockActivity
    public void startActivity() {
        int intExtra = getIntent().getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
        this.mAppWidgetId = intExtra;
        this.mUuidList = WidgetPreferenceManager.INSTANCE.getNoteUuidList(intExtra);
        if (NoteListAccessHandler.getNotePickerClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        Intent intent = new Intent(this, NoteListAccessHandler.getNotePickerClass());
        intent.setAction(WidgetConstant.ACTION_MEMO_PICK_FROM_NOTE_LIST);
        intent.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_PICK_MEMO, true);
        intent.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_SETTING_PICK_MEMO, true);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, this.mAppWidgetId);
        intent.putExtra(WidgetConstant.Pick.TYPE, 1);
        intent.putStringArrayListExtra(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST, new ArrayList<>(this.mUuidList));
        startActivityForResult(intent, 1);
    }
}
