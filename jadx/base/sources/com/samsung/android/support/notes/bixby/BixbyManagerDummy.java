package com.samsung.android.support.notes.bixby;

import android.app.Application;
import android.content.Intent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.notes.bixby.BixbyManagerContract;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0016\u001a\u00020\u0005J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001f¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/BixbyManagerDummy;", "", "<init>", "()V", "setup", "", "application", "Landroid/app/Application;", "registerNoteListActivityBixby2", "contract", "Lcom/samsung/android/support/notes/bixby/BixbyManagerContract$INoteListActivity;", "releaseNoteListActivity", "registerBixby2Action", "Lcom/samsung/android/support/notes/bixby/BixbyManagerContract$IBixby2Action;", "registerNoteFragmentBixby2", "Lcom/samsung/android/support/notes/bixby/BixbyManagerContract$INoteFragment;", "releaseNoteFragment", "registerDrawerFragmentBixby2", "Lcom/samsung/android/support/notes/bixby/BixbyManagerContract$IDrawerFragment;", "releaseDrawerFragment", "registerComposerFragmentBixby2", "Lcom/samsung/android/support/notes/bixby/BixbyManagerContract$IComposerFragment;", "releaseComposerFragment", "handleAppLink", "", "id", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "bixbyAction", "", "getBixbyAction", "()Ljava/lang/String;", Bixby2Constants.BIXBY_PARAM_SHARE_TYPE, "getShareType", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BixbyManagerDummy {
    @Nullable
    public String getBixbyAction() {
        return Bixby2Constants.BIXBY_ACTION_SELECT;
    }

    @Nullable
    public String getShareType() {
        return "none";
    }

    public int handleAppLink(int id, @Nullable Intent intent) {
        return 0;
    }

    public void registerBixby2Action(@Nullable BixbyManagerContract.IBixby2Action contract) {
    }

    public final void registerComposerFragmentBixby2(@Nullable BixbyManagerContract.IComposerFragment contract) {
    }

    public void registerDrawerFragmentBixby2(@Nullable BixbyManagerContract.IDrawerFragment contract) {
    }

    public void registerNoteFragmentBixby2(@Nullable BixbyManagerContract.INoteFragment contract) {
    }

    public void registerNoteListActivityBixby2(@Nullable BixbyManagerContract.INoteListActivity contract) {
    }

    public final void releaseComposerFragment() {
    }

    public void releaseDrawerFragment() {
    }

    public void releaseNoteFragment() {
    }

    public void releaseNoteListActivity() {
    }

    public void setup(@Nullable Application application) {
    }
}
