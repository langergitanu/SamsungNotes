package com.samsung.android.app.notes.widget.glance.list.setting.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
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
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001BB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016J\u0016\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u001dJ\u000e\u0010<\u001a\u00020\u00112\u0006\u0010=\u001a\u00020\u001dJ\u0006\u0010>\u001a\u00020\u0011J\u0014\u0010?\u001a\u00020\u00112\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\f0\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0011\u0010\"\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b#\u0010\u001fR\u0011\u0010$\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b%\u0010\u001fR$\u0010'\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b,\u0010\u001fR$\u0010.\u001a\u00020-2\u0006\u0010&\u001a\u00020-8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00103\u001a\u00020-2\u0006\u0010&\u001a\u00020-8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u0011\u00106\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u0010A\u001a\u00020-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u00100¨\u0006C"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/list/setting/model/WidgetListGlanceSettingModel;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingModel;", "bundle", "Landroid/os/Bundle;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/os/Bundle;Landroid/app/Activity;)V", "mWidgetSettingStateGlance", "Lcom/samsung/android/app/notes/widget/glance/list/setting/model/WidgetListGlanceSettingState;", "mOriginalNoteListGlance", "", "", "mCurrentDisplayListGlance", "", "mNoteListGlance", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "", "outStateGlance", "widgetSettingState", "Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingState;", "getWidgetSettingState", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingState;", "noteList", "getNoteList", "()Ljava/util/List;", "originalNoteList", "getOriginalNoteList", "minWidth", "", "getMinWidth", "()I", "minHeight", "getMinHeight", "row", "getRow", "column", "getColumn", "value", "backgroundShape", "getBackgroundShape", "setBackgroundShape", "(I)V", "oldBackgroundShape", "getOldBackgroundShape", "", "backgroundOnOff", "getBackgroundOnOff", "()Z", "setBackgroundOnOff", "(Z)V", "oldBackgroundOnOff", "getOldBackgroundOnOff", "setOldBackgroundOnOff", "providerName", "getProviderName", "()Ljava/lang/String;", "swapItemGlance", "srcIndex", "dstIndex", "removeDisplayListGlance", "position", "updateLatestDisplayListGlance", "updateNoteListGlance", "newNoteList", "isWidgetContentChanged", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetListGlanceSettingModel extends BaseWidgetSettingModel {

    @NotNull
    private static final String TAG = "WidgetListGlanceSettingModel";

    @NotNull
    private List<String> mCurrentDisplayListGlance;

    @Nullable
    private List<String> mNoteListGlance;

    @NotNull
    private final List<String> mOriginalNoteListGlance;

    @NotNull
    private final WidgetListGlanceSettingState mWidgetSettingStateGlance;
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetListGlanceSettingModel(@Nullable Bundle bundle, @NotNull Activity activity) {
        super(activity.getIntent().getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1));
        Intrinsics.checkNotNullParameter(activity, "activity");
        WidgetListGlanceSettingState widgetListGlanceSettingState = new WidgetListGlanceSettingState();
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        BaseWidgetSettingState baseWidgetSettingStateInit = widgetListGlanceSettingState.init(activity, intent, getWidgetId(), bundle);
        Intrinsics.checkNotNull(baseWidgetSettingStateInit, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.glance.list.setting.model.WidgetListGlanceSettingState");
        this.mWidgetSettingStateGlance = (WidgetListGlanceSettingState) baseWidgetSettingStateInit;
        List<String> noteUuidList = WidgetPreferenceManager.INSTANCE.getNoteUuidList(getWidgetId());
        this.mOriginalNoteListGlance = noteUuidList;
        List<String> list = noteUuidList;
        this.mCurrentDisplayListGlance = new ArrayList(list);
        if (bundle == null) {
            this.mNoteListGlance = new ArrayList(list);
            return;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList(WidgetSettingConstant.KEY_CURRENT_NOTE_LIST);
        this.mNoteListGlance = stringArrayList;
        if (stringArrayList != null) {
            this.mCurrentDisplayListGlance = new ArrayList(this.mNoteListGlance);
        } else {
            this.mNoteListGlance = new ArrayList();
        }
    }

    public final boolean getBackgroundOnOff() {
        return this.mWidgetSettingStateGlance.getMBackgroundOnOff();
    }

    public final int getBackgroundShape() {
        return this.mWidgetSettingStateGlance.getBackgroundShape();
    }

    public final int getColumn() {
        return this.mWidgetSettingStateGlance.getMColumn();
    }

    public final int getMinHeight() {
        return this.mWidgetSettingStateGlance.getMinHeight();
    }

    public final int getMinWidth() {
        return this.mWidgetSettingStateGlance.getMinWidth();
    }

    @NotNull
    public final List<String> getNoteList() {
        List<String> list = this.mNoteListGlance;
        Intrinsics.checkNotNull(list);
        return list;
    }

    public final boolean getOldBackgroundOnOff() {
        return this.mWidgetSettingStateGlance.getOldBackgroundOnOff();
    }

    public final int getOldBackgroundShape() {
        return this.mWidgetSettingStateGlance.getOldBackgroundShape();
    }

    @NotNull
    public final List<String> getOriginalNoteList() {
        return this.mOriginalNoteListGlance;
    }

    @NotNull
    public final String getProviderName() {
        return this.mWidgetSettingStateGlance.getProviderName();
    }

    public final int getRow() {
        return this.mWidgetSettingStateGlance.getRow();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingModel
    @NotNull
    public BaseWidgetSettingState getWidgetSettingState() {
        return this.mWidgetSettingStateGlance;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingModel
    public boolean isWidgetContentChanged() {
        return (!super.isWidgetContentChanged() && Intrinsics.areEqual(this.mOriginalNoteListGlance, this.mNoteListGlance) && Intrinsics.areEqual(this.mCurrentDisplayListGlance, this.mNoteListGlance) && getBackgroundShape() == getOldBackgroundShape() && getBackgroundOnOff() == getOldBackgroundOnOff()) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingModel
    public void onSaveInstanceState(@Nullable Bundle outStateGlance) {
        WidgetLogger.m5154d(TAG, "onSaveInstanceState# ");
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetSettingConstant.KEY_TRANSPARENCY, getTransparency());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetSettingConstant.KEY_OLD_TRANSPARENCY, getOldTransparency());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetSettingConstant.KEY_BACKGROUND_COLOR, getBackgroundColor());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetSettingConstant.KEY_OLD_BACKGROUND_COLOR, getOldBackgroundColor());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetSettingConstant.KEY_DARK_MODE, getDarkMode());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetSettingConstant.KEY_OLD_DARK_MODE, getOldDarkMode());
        }
        if (outStateGlance != null) {
            outStateGlance.putStringArrayList(WidgetSettingConstant.KEY_CURRENT_NOTE_LIST, (ArrayList) this.mNoteListGlance);
        }
        if (outStateGlance != null) {
            outStateGlance.putString(BaseWidgetSettingConstant.KEY_ONE_UI_WIDGET_SOURCE_SPACE, this.mWidgetSettingStateGlance.getOneUiWidgetSource());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetConstant.WIDGET_GLANCE_MIN_WIDTH, getMinWidth());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetConstant.WIDGET_GLANCE_MIN_HEIGHT, getMinHeight());
        }
        if (outStateGlance != null) {
            outStateGlance.putBoolean(BaseWidgetSettingConstant.KEY_MATCH_SETTING, getMatchSetting());
        }
        if (outStateGlance != null) {
            outStateGlance.putBoolean(BaseWidgetSettingConstant.KEY_OLD_MATCH_SETTING, getOldMatchSetting());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetConstant.WIDGET_GLANCE_ROW_SPAN, getRow());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetConstant.WIDGET_GLANCE_COLUMN_SPAN, getColumn());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, getBackgroundShape());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetSettingConstant.KEY_OLD_WIDGET_BACKGROUND_SHAPE, getOldBackgroundShape());
        }
        if (outStateGlance != null) {
            outStateGlance.putBoolean(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, getBackgroundOnOff());
        }
        if (outStateGlance != null) {
            outStateGlance.putBoolean(BaseWidgetSettingConstant.KEY_OLD_WIDGET_BACKGROUND_ON_OFF, getOldBackgroundOnOff());
        }
        if (outStateGlance != null) {
            outStateGlance.putString(WidgetConstant.WIDGET_PROVIDER_NAME, getProviderName());
        }
    }

    public final void removeDisplayListGlance(int position) {
        this.mCurrentDisplayListGlance.remove(position);
    }

    public final void setBackgroundOnOff(boolean z) {
        this.mWidgetSettingStateGlance.setBackgroundOnOff(z);
    }

    public final void setBackgroundShape(int i) {
        this.mWidgetSettingStateGlance.setBackgroundShape(i);
    }

    public final void setOldBackgroundOnOff(boolean z) {
        this.mWidgetSettingStateGlance.setOldBackgroundOnOff(z);
    }

    public final void swapItemGlance(int srcIndex, int dstIndex) {
        List<String> list = this.mNoteListGlance;
        Intrinsics.checkNotNull(list);
        String str = list.get(srcIndex);
        List<String> list2 = this.mNoteListGlance;
        if (list2 != null) {
            list2.remove(str);
        }
        List<String> list3 = this.mNoteListGlance;
        if (list3 != null) {
            list3.add(dstIndex, str);
        }
        updateLatestDisplayListGlance();
    }

    public final void updateLatestDisplayListGlance() {
        this.mCurrentDisplayListGlance.clear();
        List<String> list = this.mCurrentDisplayListGlance;
        List<String> list2 = this.mNoteListGlance;
        Intrinsics.checkNotNull(list2);
        list.addAll(list2);
    }

    public final void updateNoteListGlance(@NotNull List<String> newNoteList) {
        Intrinsics.checkNotNullParameter(newNoteList, "newNoteList");
        List<String> list = this.mNoteListGlance;
        Intrinsics.checkNotNull(list);
        for (String str : new ArrayList(list)) {
            if (newNoteList.contains(str)) {
                newNoteList.remove(str);
            } else {
                List<String> list2 = this.mNoteListGlance;
                if (list2 != null) {
                    list2.remove(str);
                }
            }
        }
        List<String> list3 = this.mNoteListGlance;
        if (list3 != null) {
            list3.addAll(0, newNoteList);
        }
    }
}
