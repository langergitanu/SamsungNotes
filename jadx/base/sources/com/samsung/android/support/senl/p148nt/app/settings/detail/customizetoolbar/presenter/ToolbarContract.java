package com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.presenter;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/presenter/ToolbarContract;", "", "IAdapter", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ToolbarContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000e\u001a\u00020\fX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/presenter/ToolbarContract$IAdapter;", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "contentDescriptions", "", "", "getContentDescriptions", "()[Ljava/lang/String;", "getDrawableIconId", "", "index", "selectedItem", "getSelectedItem", "()I", "setSelectedItem", "(I)V", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IAdapter {
        @NotNull
        Activity getActivity();

        @Nullable
        String[] getContentDescriptions();

        int getDrawableIconId(int index);

        int getSelectedItem();

        void setSelectedItem(int i);
    }
}
