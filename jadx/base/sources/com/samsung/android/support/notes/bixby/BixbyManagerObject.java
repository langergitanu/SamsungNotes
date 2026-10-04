package com.samsung.android.support.notes.bixby;

import android.app.Application;
import android.content.Intent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.notes.bixby.BixbyManagerContract;
import com.samsung.android.support.notes.bixby.bixby2.Bixby2;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001e¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/BixbyManagerObject;", "Lcom/samsung/android/support/notes/bixby/BixbyManagerDummy;", "<init>", "()V", "mBixby2", "Lcom/samsung/android/support/notes/bixby/bixby2/Bixby2;", "setup", "", "application", "Landroid/app/Application;", "registerBixby2Action", "contract", "Lcom/samsung/android/support/notes/bixby/BixbyManagerContract$IBixby2Action;", "registerNoteListActivityBixby2", "Lcom/samsung/android/support/notes/bixby/BixbyManagerContract$INoteListActivity;", "releaseNoteListActivity", "registerNoteFragmentBixby2", "Lcom/samsung/android/support/notes/bixby/BixbyManagerContract$INoteFragment;", "releaseNoteFragment", "registerDrawerFragmentBixby2", "Lcom/samsung/android/support/notes/bixby/BixbyManagerContract$IDrawerFragment;", "releaseDrawerFragment", "handleAppLink", "", "id", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "bixbyAction", "", "getBixbyAction", "()Ljava/lang/String;", Bixby2Constants.BIXBY_PARAM_SHARE_TYPE, "getShareType", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BixbyManagerObject extends BixbyManagerDummy {

    @Nullable
    private Bixby2 mBixby2;

    @Override // com.samsung.android.support.notes.bixby.BixbyManagerDummy
    @Nullable
    public String getBixbyAction() {
        Bixby2 bixby2 = this.mBixby2;
        if (bixby2 != null) {
            return bixby2.getBixbyAction();
        }
        return null;
    }

    @Override // com.samsung.android.support.notes.bixby.BixbyManagerDummy
    @Nullable
    public String getShareType() {
        Bixby2 bixby2 = this.mBixby2;
        if (bixby2 != null) {
            return bixby2.getShareType();
        }
        return null;
    }

    @Override // com.samsung.android.support.notes.bixby.BixbyManagerDummy
    public int handleAppLink(int id, @Nullable Intent intent) {
        Bixby2 bixby2 = this.mBixby2;
        if (bixby2 == null || intent == null) {
            return 0;
        }
        Intrinsics.checkNotNull(bixby2);
        return bixby2.handleAppLink(id, intent);
    }

    @Override // com.samsung.android.support.notes.bixby.BixbyManagerDummy
    public void registerBixby2Action(@Nullable BixbyManagerContract.IBixby2Action contract) {
        Bixby2 bixby2 = this.mBixby2;
        if (bixby2 != null) {
            bixby2.bixbyAction(contract != null ? contract.registerBixby2Action() : null);
        }
    }

    @Override // com.samsung.android.support.notes.bixby.BixbyManagerDummy
    public void registerDrawerFragmentBixby2(@Nullable BixbyManagerContract.IDrawerFragment contract) {
        Bixby2 bixby2 = this.mBixby2;
        if (bixby2 != null) {
            bixby2.registerDrawerFragment(contract != null ? contract.registerDrawerFragmentBixby2() : null);
        }
    }

    @Override // com.samsung.android.support.notes.bixby.BixbyManagerDummy
    public void registerNoteFragmentBixby2(@Nullable BixbyManagerContract.INoteFragment contract) {
        Bixby2 bixby2 = this.mBixby2;
        if (bixby2 != null) {
            bixby2.registerNoteFragment(contract != null ? contract.registerNoteFragmentBixby2() : null);
        }
    }

    @Override // com.samsung.android.support.notes.bixby.BixbyManagerDummy
    public void registerNoteListActivityBixby2(@Nullable BixbyManagerContract.INoteListActivity contract) {
        Bixby2 bixby2 = this.mBixby2;
        if (bixby2 != null) {
            bixby2.registerNoteListActivity(contract != null ? contract.registerNoteListActivityBixby2() : null);
        }
    }

    @Override // com.samsung.android.support.notes.bixby.BixbyManagerDummy
    public void releaseDrawerFragment() {
        Bixby2 bixby2 = this.mBixby2;
        if (bixby2 != null) {
            bixby2.releaseDrawerFragment();
        }
    }

    @Override // com.samsung.android.support.notes.bixby.BixbyManagerDummy
    public void releaseNoteFragment() {
        Bixby2 bixby2 = this.mBixby2;
        if (bixby2 != null) {
            bixby2.releaseNoteFragment();
        }
    }

    @Override // com.samsung.android.support.notes.bixby.BixbyManagerDummy
    public void releaseNoteListActivity() {
        Bixby2 bixby2 = this.mBixby2;
        if (bixby2 != null) {
            bixby2.releaseNoteListActivity();
        }
    }

    @Override // com.samsung.android.support.notes.bixby.BixbyManagerDummy
    public void setup(@Nullable Application application) {
        this.mBixby2 = new Bixby2(application);
    }
}
