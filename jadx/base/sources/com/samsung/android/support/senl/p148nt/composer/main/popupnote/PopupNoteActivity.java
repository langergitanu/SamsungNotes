package com.samsung.android.support.senl.p148nt.composer.main.popupnote;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.app.KeyguardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment;
import com.samsung.android.support.senl.p148nt.composer.main.lockscreen.view.LsComposerFragment;
import com.samsung.android.support.senl.p148nt.composer.main.popupnote.util.PopupNoteUtils;
import com.samsung.android.support.senl.p148nt.composer.main.popupnote.view.PopupNoteFragment;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p047K3.ViewOnLayoutChangeListenerC0162a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0010H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0010H\u0014J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/popupnote/PopupNoteActivity;", "Lcom/samsung/android/support/senl/nt/composer/main/base/BaseComposerActivity;", "<init>", "()V", "mDecorView", "Landroid/view/View;", "mOnLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "mIsFreeForm", "", "mLocation", "", "mDecorViewWidth", "", "mDecorViewHeight", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initialize", "createFragment", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/BaseComposerFragment;", "onDestroy", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class PopupNoteActivity extends BaseComposerActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = Logger.createTag("PopupNoteActivity");

    @Nullable
    private View mDecorView;
    private int mDecorViewHeight;
    private int mDecorViewWidth;
    private boolean mIsFreeForm = true;

    @NotNull
    private final int[] mLocation = new int[2];

    @Nullable
    private View.OnLayoutChangeListener mOnLayoutChangeListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/popupnote/PopupNoteActivity$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "getPopupNoteActivityOptions", "Landroid/app/ActivityOptions;", "context", "Landroid/content/Context;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final ActivityOptions getPopupNoteActivityOptions(@Nullable Context context) {
            return PopupNoteUtils.getPopupNoteInfo(context);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(PopupNoteActivity popupNoteActivity, View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (popupNoteActivity.mIsFreeForm) {
            View view2 = popupNoteActivity.mDecorView;
            if (view2 != null) {
                view2.getLocationOnScreen(popupNoteActivity.mLocation);
            }
            popupNoteActivity.mDecorViewWidth = i4 - i;
            popupNoteActivity.mDecorViewHeight = i5 - i2;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity
    @NotNull
    public BaseComposerFragment createFragment() {
        if (KeyguardManagerCompat.INSTANCE.getInstance().isKeyguardLocked(getApplicationContext())) {
            Logger.m11003i(TAG, "createFragment, LockScreenNote");
            return new LsComposerFragment();
        }
        Logger.m11003i(TAG, "createFragment, PopupNote");
        return new PopupNoteFragment();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity
    public void initialize() {
        addFragment();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        boolean zIsFreeFormWindow = WindowManagerCompat.INSTANCE.getInstance().isFreeFormWindow(this);
        this.mIsFreeForm = zIsFreeFormWindow;
        if (!zIsFreeFormWindow) {
            PopupNoteUtils popupNoteUtils = PopupNoteUtils.INSTANCE;
            int i = this.mDecorViewWidth;
            int i2 = this.mDecorViewHeight;
            int[] iArr = this.mLocation;
            popupNoteUtils.saveScreenInfo(this, i, i2, iArr[0], iArr[1]);
        }
        super.onConfigurationChanged(newConfig);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        this.mDecorView = decorView;
        ViewOnLayoutChangeListenerC0162a viewOnLayoutChangeListenerC0162a = new ViewOnLayoutChangeListenerC0162a(this, 0);
        this.mOnLayoutChangeListener = viewOnLayoutChangeListenerC0162a;
        if (decorView != null) {
            decorView.addOnLayoutChangeListener(viewOnLayoutChangeListenerC0162a);
        }
        ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, "0002", ResourceUtils.isTabletLayout(this) ? "b" : "a");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        View view = this.mDecorView;
        if (view != null) {
            view.removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
        }
        PopupNoteUtils.INSTANCE.savePopupNoteInfo(this);
        super.onDestroy();
    }
}
