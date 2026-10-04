package com.samsung.android.app.notes.widget.setting.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.app.notes.widget.setting.common.WidgetSettingConstant;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.common.BaseWidgetSettingConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingModel;
import com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingState;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016J\u0016\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\u0011J\u0014\u0010 \u001a\u00020\u00112\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u000eJ\u0014\u0010\"\u001a\u00020\u00112\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010$\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010&¨\u0006("}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/model/WidgetListSettingModel;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingModel;", "bundle", "Landroid/os/Bundle;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/os/Bundle;Landroid/app/Activity;)V", "mWidgetSettingState", "Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingState;", "mOriginalNoteList", "", "", "mCurrentDisplayList", "", "mNoteList", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "", "outState", "widgetSettingState", "getWidgetSettingState", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingState;", "noteList", "getNoteList", "()Ljava/util/List;", "swapItem", "srcIndex", "", "dstIndex", "removeDisplayList", "position", "updateLatestDisplayList", "updateNoteList", "newNoteList", "deleteUUIDNoteList", "uuidList", "isWidgetContentChanged", "", "()Z", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetListSettingModel extends BaseWidgetSettingModel {

    @NotNull
    private static final String TAG = "WidgetListSettingModel";

    @NotNull
    private List<String> mCurrentDisplayList;

    @Nullable
    private List<String> mNoteList;

    @NotNull
    private final List<String> mOriginalNoteList;

    @Nullable
    private final BaseWidgetSettingState mWidgetSettingState;
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetListSettingModel(@Nullable Bundle bundle, @NotNull Activity activity) {
        super(activity.getIntent().getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1));
        Intrinsics.checkNotNullParameter(activity, "activity");
        BaseWidgetSettingState baseWidgetSettingState = new BaseWidgetSettingState();
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        this.mWidgetSettingState = baseWidgetSettingState.init(activity, intent, getWidgetId(), bundle);
        List<String> noteUuidList = WidgetPreferenceManager.INSTANCE.getNoteUuidList(getWidgetId());
        this.mOriginalNoteList = noteUuidList;
        this.mCurrentDisplayList = new ArrayList(noteUuidList);
        if (bundle == null) {
            this.mNoteList = new ArrayList(noteUuidList);
            return;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList(WidgetSettingConstant.KEY_CURRENT_NOTE_LIST);
        this.mNoteList = stringArrayList;
        if (stringArrayList != null) {
            this.mCurrentDisplayList = new ArrayList(this.mNoteList);
        } else {
            this.mNoteList = new ArrayList();
        }
    }

    public final void deleteUUIDNoteList(@NotNull List<String> uuidList) {
        List<String> list;
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        for (String str : uuidList) {
            List<String> list2 = this.mNoteList;
            if (list2 != null && list2.contains(str) && (list = this.mNoteList) != null) {
                list.remove(str);
            }
        }
    }

    @NotNull
    public final List<String> getNoteList() {
        List<String> list = this.mNoteList;
        Intrinsics.checkNotNull(list);
        return list;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingModel
    @NotNull
    public BaseWidgetSettingState getWidgetSettingState() {
        BaseWidgetSettingState baseWidgetSettingState = this.mWidgetSettingState;
        Intrinsics.checkNotNull(baseWidgetSettingState);
        return baseWidgetSettingState;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingModel
    public boolean isWidgetContentChanged() {
        return (!super.isWidgetContentChanged() && Intrinsics.areEqual(this.mOriginalNoteList, this.mNoteList) && Intrinsics.areEqual(this.mCurrentDisplayList, this.mNoteList)) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingModel
    public void onSaveInstanceState(@Nullable Bundle outState) {
        WidgetLogger.m5154d(TAG, "onSaveInstanceState# ");
        if (outState != null) {
            outState.putInt(BaseWidgetSettingConstant.KEY_TRANSPARENCY, getTransparency());
        }
        if (outState != null) {
            outState.putInt(BaseWidgetSettingConstant.KEY_OLD_TRANSPARENCY, getOldTransparency());
        }
        if (outState != null) {
            outState.putInt(BaseWidgetSettingConstant.KEY_BACKGROUND_COLOR, getBackgroundColor());
        }
        if (outState != null) {
            outState.putInt(BaseWidgetSettingConstant.KEY_OLD_BACKGROUND_COLOR, getOldBackgroundColor());
        }
        if (outState != null) {
            outState.putInt(BaseWidgetSettingConstant.KEY_DARK_MODE, getDarkMode());
        }
        if (outState != null) {
            outState.putInt(BaseWidgetSettingConstant.KEY_OLD_DARK_MODE, getOldDarkMode());
        }
        if (outState != null) {
            outState.putStringArrayList(WidgetSettingConstant.KEY_CURRENT_NOTE_LIST, (ArrayList) this.mNoteList);
        }
        if (outState != null) {
            BaseWidgetSettingState baseWidgetSettingState = this.mWidgetSettingState;
            outState.putString(BaseWidgetSettingConstant.KEY_ONE_UI_WIDGET_SOURCE_SPACE, baseWidgetSettingState != null ? baseWidgetSettingState.getOneUiWidgetSource() : null);
        }
    }

    public final void removeDisplayList(int position) {
        this.mCurrentDisplayList.remove(position);
    }

    public final void swapItem(int srcIndex, int dstIndex) {
        List<String> list = this.mNoteList;
        Intrinsics.checkNotNull(list);
        String str = list.get(srcIndex);
        List<String> list2 = this.mNoteList;
        if (list2 != null) {
            list2.remove(str);
        }
        List<String> list3 = this.mNoteList;
        if (list3 != null) {
            list3.add(dstIndex, str);
        }
        updateLatestDisplayList();
    }

    public final void updateLatestDisplayList() {
        this.mCurrentDisplayList.clear();
        List<String> list = this.mCurrentDisplayList;
        List<String> list2 = this.mNoteList;
        Intrinsics.checkNotNull(list2);
        list.addAll(list2);
    }

    public final void updateNoteList(@NotNull List<String> newNoteList) {
        Intrinsics.checkNotNullParameter(newNoteList, "newNoteList");
        List<String> list = this.mNoteList;
        Intrinsics.checkNotNull(list);
        for (String str : new ArrayList(list)) {
            if (newNoteList.contains(str)) {
                newNoteList.remove(str);
            } else {
                List<String> list2 = this.mNoteList;
                if (list2 != null) {
                    list2.remove(str);
                }
            }
        }
        List<String> list3 = this.mNoteList;
        if (list3 != null) {
            list3.addAll(0, newNoteList);
        }
    }
}
