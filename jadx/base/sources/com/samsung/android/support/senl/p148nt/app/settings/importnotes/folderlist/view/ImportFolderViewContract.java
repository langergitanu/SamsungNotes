package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.view;

import android.content.Intent;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\u000b\u001a\u00020\u0007H&J\b\u0010\f\u001a\u00020\u0007H&¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/view/ImportFolderViewContract;", "", "getChildFragmentManager", "Landroidx/fragment/app/FragmentManager;", "isResumed", "", "startGoogleDriveActivity", "", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "startRequestAuthorizationActivity", "startMyfilesPickerActivity", "startSNBAKPickerActivity", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ImportFolderViewContract {
    @Nullable
    FragmentManager getChildFragmentManager();

    boolean isResumed();

    void startGoogleDriveActivity(@Nullable Intent intent);

    void startMyfilesPickerActivity();

    void startRequestAuthorizationActivity(@Nullable Intent intent);

    void startSNBAKPickerActivity();
}
