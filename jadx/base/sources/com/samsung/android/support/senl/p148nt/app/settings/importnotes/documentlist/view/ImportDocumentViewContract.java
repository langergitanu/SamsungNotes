package com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.view;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/view/ImportDocumentViewContract;", "", "getContext", "Landroid/content/Context;", "getChildFragmentManager", "Landroidx/fragment/app/FragmentManager;", "activityFinish", "", "isFragmentAdded", "", "()Z", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ImportDocumentViewContract {
    void activityFinish();

    @Nullable
    FragmentManager getChildFragmentManager();

    @Nullable
    Context getContext();

    boolean isFragmentAdded();
}
