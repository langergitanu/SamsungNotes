package com.samsung.android.support.notes.bixby;

import android.app.Application;
import android.content.Intent;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.notes.bixby.BixbyManagerContract;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0011\u001a\u00020\u0007J\u0010\u0010\u0012\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0014\u001a\u00020\u0007J\u0010\u0010\u0015\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0017\u001a\u00020\u0007J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b\"\u0010 ¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/BixbyManager;", "", "<init>", "()V", "mBixbyManagerObject", "Lcom/samsung/android/support/notes/bixby/BixbyManagerDummy;", "setup", "", "activate", "", "application", "Landroid/app/Application;", "registerBixby2Action", "contract", "Lcom/samsung/android/support/notes/bixby/BixbyManagerContract$IBixby2Action;", "registerNoteListActivityBixby2", "Lcom/samsung/android/support/notes/bixby/BixbyManagerContract$INoteListActivity;", "releaseNoteListActivity", "registerNoteFragmentBixby2", "Lcom/samsung/android/support/notes/bixby/BixbyManagerContract$INoteFragment;", "releaseNoteFragment", "registerDrawerFragmentBixby2", "Lcom/samsung/android/support/notes/bixby/BixbyManagerContract$IDrawerFragment;", "releaseDrawerFragment", "handleAppLink", "", "id", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "bixbyAction", "", "getBixbyAction", "()Ljava/lang/String;", Bixby2Constants.BIXBY_PARAM_SHARE_TYPE, "getShareType", "Companion", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BixbyManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "BixbyManager";

    @Nullable
    private static BixbyManager mInstance;

    @NotNull
    private BixbyManagerDummy mBixbyManagerObject = new BixbyManagerDummy();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u001a\u0010\t\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/BixbyManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/notes/bixby/BixbyManager;", "getMInstance$annotations", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/notes/bixby/BixbyManager;", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @JvmStatic
        private static /* synthetic */ void getMInstance$annotations() {
        }

        @NotNull
        public final synchronized BixbyManager getInstance() {
            BixbyManager bixbyManager;
            try {
                if (BixbyManager.mInstance == null) {
                    BixbyManager.mInstance = new BixbyManager();
                }
                bixbyManager = BixbyManager.mInstance;
                Intrinsics.checkNotNull(bixbyManager, "null cannot be cast to non-null type com.samsung.android.support.notes.bixby.BixbyManager");
            } catch (Throwable th) {
                throw th;
            }
            return bixbyManager;
        }

        private Companion() {
        }
    }

    @NotNull
    public static final synchronized BixbyManager getInstance() {
        return INSTANCE.getInstance();
    }

    @Nullable
    public final String getBixbyAction() {
        return this.mBixbyManagerObject.getBixbyAction();
    }

    @Nullable
    public final String getShareType() {
        return this.mBixbyManagerObject.getShareType();
    }

    public final int handleAppLink(int id, @Nullable Intent intent) {
        AbstractC4539a.m3203m(id, "handleAppLink id : ", TAG);
        return this.mBixbyManagerObject.handleAppLink(id, intent);
    }

    public final void registerBixby2Action(@Nullable BixbyManagerContract.IBixby2Action contract) {
        this.mBixbyManagerObject.registerBixby2Action(contract);
    }

    public final void registerDrawerFragmentBixby2(@Nullable BixbyManagerContract.IDrawerFragment contract) {
        this.mBixbyManagerObject.registerDrawerFragmentBixby2(contract);
    }

    public final void registerNoteFragmentBixby2(@Nullable BixbyManagerContract.INoteFragment contract) {
        this.mBixbyManagerObject.registerNoteFragmentBixby2(contract);
    }

    public final void registerNoteListActivityBixby2(@Nullable BixbyManagerContract.INoteListActivity contract) {
        this.mBixbyManagerObject.registerNoteListActivityBixby2(contract);
    }

    public final void releaseDrawerFragment() {
        this.mBixbyManagerObject.releaseDrawerFragment();
    }

    public final void releaseNoteFragment() {
        this.mBixbyManagerObject.releaseNoteFragment();
    }

    public final void releaseNoteListActivity() {
        this.mBixbyManagerObject.releaseNoteListActivity();
    }

    public final void setup(boolean activate, @Nullable Application application) {
        Logger.m8697d(TAG, "setup activate : " + activate);
        BixbyManagerDummy bixbyManagerObject = activate ? new BixbyManagerObject() : new BixbyManagerDummy();
        this.mBixbyManagerObject = bixbyManagerObject;
        bixbyManagerObject.setup(application);
    }
}
