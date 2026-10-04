package com.samsung.android.app.notes.widget.glance.setting.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.glance.common.WidgetCreatorPreference;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.common.BaseWidgetSettingConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingModel;
import com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingState;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u00102\u001a\u00020\u00112\f\u00103\u001a\b\u0012\u0004\u0012\u00020\f0\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b \u0010\u001cR$\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010%R$\u0010&\u001a\u00020\f2\u0006\u0010!\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010%R$\u0010*\u001a\u00020)2\u0006\u0010!\u001a\u00020)8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u00020)2\u0006\u0010!\u001a\u00020)8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\u0014\u00104\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010,¨\u00066"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/setting/model/WidgetCreatorSettingModel;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingModel;", "bundle", "Landroid/os/Bundle;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/os/Bundle;Landroid/app/Activity;)V", "mWidgetSettingState", "Lcom/samsung/android/app/notes/widget/glance/setting/model/WidgetCreatorSettingState;", "mOriginalSelectedItems", "", "", "mCurrentSelectedItems", "", "mSelectedItems", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "", "outState", "widgetSettingState", "Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingState;", "getWidgetSettingState", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingState;", "selectedItems", "getSelectedItems", "()Ljava/util/List;", "column", "getColumn", "()I", "width", "getWidth", "height", "getHeight", "value", "backgroundShape", "getBackgroundShape", "setBackgroundShape", "(I)V", "oldBackgroundShape", "getOldBackgroundShape", "setOldBackgroundShape", "", "backgroundOnOff", "getBackgroundOnOff", "()Z", "setBackgroundOnOff", "(Z)V", "oldBackgroundOnOff", "getOldBackgroundOnOff", "setOldBackgroundOnOff", "updateSelectedItems", "newSelectedItems", "isWidgetContentChanged", "Companion", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetCreatorSettingModel extends BaseWidgetSettingModel {

    @NotNull
    private static final String TAG = "WidgetToolbarSettingModel";

    @NotNull
    private final List<Integer> mCurrentSelectedItems;

    @NotNull
    private final List<Integer> mOriginalSelectedItems;

    @NotNull
    private List<Integer> mSelectedItems;

    @NotNull
    private final WidgetCreatorSettingState mWidgetSettingState;
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCreatorSettingModel(@Nullable Bundle bundle, @NotNull Activity activity) {
        super(activity.getIntent().getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1));
        Intrinsics.checkNotNullParameter(activity, "activity");
        WidgetCreatorSettingState widgetCreatorSettingState = new WidgetCreatorSettingState();
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        BaseWidgetSettingState baseWidgetSettingStateInit = widgetCreatorSettingState.init(activity, intent, getWidgetId(), bundle);
        Intrinsics.checkNotNull(baseWidgetSettingStateInit, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.glance.setting.model.WidgetCreatorSettingState");
        this.mWidgetSettingState = (WidgetCreatorSettingState) baseWidgetSettingStateInit;
        List<Integer> selectedItems = WidgetCreatorPreference.INSTANCE.getSelectedItems(getWidgetId());
        this.mOriginalSelectedItems = selectedItems;
        List<Integer> list = selectedItems;
        this.mCurrentSelectedItems = new ArrayList(list);
        this.mSelectedItems = new ArrayList();
        if (bundle == null) {
            this.mSelectedItems = new ArrayList(list);
        } else {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(BaseWidgetConstant.KEY_SELECTED_ITEMS);
            this.mSelectedItems = integerArrayList == null ? new ArrayList<>() : integerArrayList;
        }
    }

    public final boolean getBackgroundOnOff() {
        return this.mWidgetSettingState.getMBackgroundOnOff();
    }

    public final int getBackgroundShape() {
        return this.mWidgetSettingState.getMBackgroundShape();
    }

    public final int getColumn() {
        return this.mWidgetSettingState.getMColumn();
    }

    public final int getHeight() {
        return this.mWidgetSettingState.getMHeight();
    }

    public final boolean getOldBackgroundOnOff() {
        return this.mWidgetSettingState.getOldBackgroundOnOff();
    }

    public final int getOldBackgroundShape() {
        return this.mWidgetSettingState.getOldBackgroundShape();
    }

    @NotNull
    public final List<Integer> getSelectedItems() {
        return this.mSelectedItems;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingModel
    @NotNull
    public BaseWidgetSettingState getWidgetSettingState() {
        return this.mWidgetSettingState;
    }

    public final int getWidth() {
        return this.mWidgetSettingState.getWidth();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingModel
    public boolean isWidgetContentChanged() {
        return (!super.isWidgetContentChanged() && Intrinsics.areEqual(this.mOriginalSelectedItems, this.mSelectedItems) && Intrinsics.areEqual(this.mCurrentSelectedItems, this.mSelectedItems) && getBackgroundShape() == getOldBackgroundShape() && getBackgroundOnOff() == getOldBackgroundOnOff()) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingModel
    public void onSaveInstanceState(@Nullable Bundle outState) {
        Logger.m8697d(TAG, "onSaveInstanceState# ");
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
            outState.putString(BaseWidgetSettingConstant.KEY_ONE_UI_WIDGET_SOURCE_SPACE, getOneUiWidgetSource());
        }
        if (outState != null) {
            outState.putIntegerArrayList(BaseWidgetConstant.KEY_SELECTED_ITEMS, new ArrayList<>(this.mSelectedItems));
        }
        if (outState != null) {
            outState.putInt(BaseWidgetConstant.WIDGET_GLANCE_COLUMN_SPAN, getColumn());
        }
        if (outState != null) {
            outState.putInt(BaseWidgetConstant.WIDGET_GLANCE_MIN_WIDTH, getWidth());
        }
        if (outState != null) {
            outState.putInt(BaseWidgetConstant.WIDGET_GLANCE_MIN_HEIGHT, getHeight());
        }
        if (outState != null) {
            outState.putBoolean(BaseWidgetSettingConstant.KEY_MATCH_SETTING, getMatchSetting());
        }
        if (outState != null) {
            outState.putBoolean(BaseWidgetSettingConstant.KEY_OLD_MATCH_SETTING, getOldMatchSetting());
        }
        if (outState != null) {
            outState.putInt(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, getBackgroundShape());
        }
        if (outState != null) {
            outState.putInt(BaseWidgetSettingConstant.KEY_OLD_WIDGET_BACKGROUND_SHAPE, getOldBackgroundShape());
        }
        if (outState != null) {
            outState.putBoolean(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, getBackgroundOnOff());
        }
        if (outState != null) {
            outState.putBoolean(BaseWidgetSettingConstant.KEY_OLD_WIDGET_BACKGROUND_ON_OFF, getOldBackgroundOnOff());
        }
    }

    public final void setBackgroundOnOff(boolean z) {
        this.mWidgetSettingState.setBackgroundOnOff(z);
    }

    public final void setBackgroundShape(int i) {
        this.mWidgetSettingState.setBackgroundShape(i);
    }

    public final void setOldBackgroundOnOff(boolean z) {
        this.mWidgetSettingState.setOldBackgroundOnOff(z);
    }

    public final void setOldBackgroundShape(int i) {
        this.mWidgetSettingState.setOldBackgroundShape(i);
    }

    public final void updateSelectedItems(@NotNull List<Integer> newSelectedItems) {
        Intrinsics.checkNotNullParameter(newSelectedItems, "newSelectedItems");
        Iterator it = new ArrayList(this.mSelectedItems).iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            if (newSelectedItems.contains(Integer.valueOf(iIntValue))) {
                newSelectedItems.remove(Integer.valueOf(iIntValue));
            } else {
                this.mSelectedItems.remove(Integer.valueOf(iIntValue));
            }
        }
        this.mSelectedItems.addAll(0, newSelectedItems);
        CollectionsKt.sort(this.mSelectedItems);
    }
}
