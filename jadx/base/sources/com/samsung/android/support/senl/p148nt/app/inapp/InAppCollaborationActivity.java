package com.samsung.android.support.senl.p148nt.app.inapp;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7005f;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.InAppSAConstants;
import com.samsung.android.support.senl.p148nt.app.inapp.view.InAppActivityAttributes;
import com.samsung.android.support.senl.p148nt.app.inapp.view.InAppView;
import com.samsung.android.support.senl.p148nt.app.inapp.view.dialog.DisconnectDialogFragment;
import com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityClientManager;
import com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityServiceManager;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.ContinuityConstant;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p066P2.RunnableC0201c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\fH\u0014J\b\u0010\u0015\u001a\u00020\fH\u0016J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020%H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/InAppCollaborationActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/samsung/android/support/senl/nt/app/inapp/view/InAppView$ActivityContract;", "<init>", "()V", "mView", "Lcom/samsung/android/support/senl/nt/app/inapp/view/InAppView;", "mInAppActivityAttributes", "Lcom/samsung/android/support/senl/nt/app/inapp/view/InAppActivityAttributes;", "mBlockTouchListener", "Landroid/view/View$OnTouchListener;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initContinuityService", "setBackPressedListener", "onBackKeyDown", "onResume", "onPause", "onDestroy", "onDetachedFromWindow", "onMultiWindowModeChanged", "isInMultiWindowMode", "", "newConfig", "Landroid/content/res/Configuration;", "onConfigurationChanged", "onWindowFocusChanged", "hasFocus", "finishActivity", "initBlockView", "visibility", "", "initBlockViewDuringAiProcess", "updateUIMode", "message", "", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppCollaborationActivity extends AppCompatActivity implements InAppView.ActivityContract {

    @NotNull
    private static final String TAG = "InAppCollaborationActivity";

    @NotNull
    private final View.OnTouchListener mBlockTouchListener = new ViewOnTouchListenerC7005f(8);

    @Nullable
    private InAppActivityAttributes mInAppActivityAttributes;

    @Nullable
    private InAppView mView;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.inapp.InAppCollaborationActivity$initContinuityService$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m13886d2 = {"com/samsung/android/support/senl/nt/app/inapp/InAppCollaborationActivity$initContinuityService$1", "Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityServiceManager$ContinuityActionContract;", "onServiceConnected", "", "onServiceDisconnected", "readyToInAppCollaboration", "closedInAppCollaboration", "messageReceived", "message", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class C80531 implements ContinuityServiceManager.ContinuityActionContract {
        public C80531() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void readyToInAppCollaboration$lambda$1(InAppCollaborationActivity inAppCollaborationActivity) {
            InAppView inAppView = inAppCollaborationActivity.mView;
            if (inAppView != null) {
                inAppView.showCloseButton();
            }
        }

        @Override // com.samsung.android.support.senl.nt.base.common.inapp.ContinuityServiceManager.ContinuityActionContract
        public void closedInAppCollaboration() {
            InAppLogger.m8595d(InAppCollaborationActivity.TAG, "closedInAppCollaboration");
            ContinuityClientManager companion = ContinuityClientManager.INSTANCE.getInstance();
            if (companion != null) {
                companion.disconnect(InAppCollaborationActivity.this.getApplicationContext());
            }
            InAppCollaborationActivity.this.finishActivity();
        }

        @Override // com.samsung.android.support.senl.nt.base.common.inapp.ContinuityServiceManager.ContinuityActionContract
        public void messageReceived(byte[] message) {
            Intrinsics.checkNotNullParameter(message, "message");
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            String str = new String(message, UTF_8);
            if (StringsKt.m14145S(str, ContinuityConstant.UI_MODE)) {
                InAppCollaborationActivity.this.updateUIMode(str);
                return;
            }
            InAppView inAppView = InAppCollaborationActivity.this.mView;
            if (inAppView != null) {
                inAppView.receiveData(message);
            }
        }

        @Override // com.samsung.android.support.senl.nt.base.common.inapp.ContinuityServiceManager.ContinuityServiceContract
        public void onServiceConnected() {
        }

        @Override // com.samsung.android.support.senl.nt.base.common.inapp.ContinuityServiceManager.ContinuityServiceContract
        public void onServiceDisconnected() {
            InAppCollaborationActivity inAppCollaborationActivity = InAppCollaborationActivity.this;
            inAppCollaborationActivity.runOnUiThread(new RunnableC8056a(inAppCollaborationActivity, 0));
        }

        @Override // com.samsung.android.support.senl.nt.base.common.inapp.ContinuityServiceManager.ContinuityActionContract
        public void readyToInAppCollaboration() {
            InAppCollaborationActivity inAppCollaborationActivity = InAppCollaborationActivity.this;
            inAppCollaborationActivity.runOnUiThread(new RunnableC8056a(inAppCollaborationActivity, 1));
        }
    }

    private final void initBlockView(int visibility) {
        View viewFindViewById = findViewById(C8003R.id.in_app_collaboration_dim);
        viewFindViewById.setVisibility(visibility);
        if (visibility == 0) {
            viewFindViewById.setOnTouchListener(this.mBlockTouchListener);
        }
    }

    private final void initBlockViewDuringAiProcess(int visibility) {
        View viewFindViewById = findViewById(C8003R.id.in_app_collaboration_dim_during_ai_process);
        viewFindViewById.setVisibility(visibility);
        if (visibility == 0) {
            viewFindViewById.setOnTouchListener(this.mBlockTouchListener);
        }
    }

    private final void initContinuityService() {
        InAppLogger.m8595d(TAG, "initContinuityService");
        ContinuityClientManager.Companion companion = ContinuityClientManager.INSTANCE;
        ContinuityClientManager companion2 = companion.getInstance();
        if (companion2 != null) {
            companion2.setActionContract(new C80531());
        }
        ContinuityClientManager companion3 = companion.getInstance();
        if (companion3 != null) {
            companion3.setContinuityIntent(getIntent());
        }
        if (companion.getInstance() != null) {
            ContinuityClientManager companion4 = companion.getInstance();
            Intrinsics.checkNotNull(companion4);
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            if (companion4.connect(applicationContext)) {
                return;
            }
            finishActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mBlockTouchListener$lambda$0(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBackKeyDown() {
        InAppView inAppView = this.mView;
        if (inAppView != null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            inAppView.showDisconnectDialog(supportFragmentManager, new DisconnectDialogFragment.Contract() { // from class: com.samsung.android.support.senl.nt.app.inapp.InAppCollaborationActivity.onBackKeyDown.1
                @Override // com.samsung.android.support.senl.nt.app.inapp.view.dialog.DisconnectDialogFragment.Contract
                public void onPositiveButton() {
                    InAppLogger.m8595d(InAppCollaborationActivity.TAG, "onBackKeyDown# onPositiveButton - disconnect");
                    if (ContinuityClientManager.INSTANCE.getInstance().closeInAppCollaboration()) {
                        return;
                    }
                    InAppCollaborationActivity.this.finishActivity();
                }
            });
        }
    }

    private final void setBackPressedListener() {
        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback() { // from class: com.samsung.android.support.senl.nt.app.inapp.InAppCollaborationActivity$setBackPressedListener$backPressedCallback$1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                this.this$0.onBackKeyDown();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUIMode(String message) {
        InAppLogger.m8595d(TAG, "updateUIMode# message : " + message);
        View viewFindViewById = findViewById(C8003R.id.in_app_collaboration_dim);
        if (viewFindViewById == null) {
            InAppLogger.m8596e(TAG, "updateUIMode# blockView is null");
        } else {
            runOnUiThread(new RunnableC0201c(message, 22, viewFindViewById, this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateUIMode$lambda$1(String str, View view, InAppCollaborationActivity inAppCollaborationActivity) {
        if (!Intrinsics.areEqual(str, ContinuityConstant.DIM_SET)) {
            if (!Intrinsics.areEqual(str, ContinuityConstant.DIM_RELEASE) || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            view.setOnTouchListener(null);
            return;
        }
        if (view.getVisibility() == 0) {
            return;
        }
        view.setVisibility(0);
        view.setOnTouchListener(inAppCollaborationActivity.mBlockTouchListener);
        InAppView inAppView = inAppCollaborationActivity.mView;
        if (inAppView != null) {
            inAppView.setDimView();
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.inapp.view.InAppView.ActivityContract
    public void finishActivity() {
        InAppLogger.m8595d(TAG, "finishActivity#");
        ContinuityClientManager companion = ContinuityClientManager.INSTANCE.getInstance();
        if (companion != null) {
            companion.release(getApplicationContext());
        }
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        InAppView inAppView = this.mView;
        if (inAppView == null) {
            return;
        }
        Intrinsics.checkNotNull(inAppView);
        if (inAppView.needViewChange(newConfig)) {
            InAppLogger.m8595d(TAG, "onConfigurationChanged# needViewChange");
            int visibility = findViewById(C8003R.id.in_app_collaboration_dim).getVisibility();
            int visibility2 = findViewById(C8003R.id.in_app_collaboration_dim_during_ai_process).getVisibility();
            InAppView inAppView2 = this.mView;
            Intrinsics.checkNotNull(inAppView2);
            inAppView2.createView(this);
            initBlockView(visibility);
            initBlockViewDuringAiProcess(visibility2);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getDelegate().setLocalNightMode(1);
        super.onCreate(savedInstanceState);
        InAppLogger.m8595d(TAG, "onCreate");
        CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT);
        SpenSdkInitializer.initialize(getApplicationContext());
        initContinuityService();
        this.mView = new InAppView(this, this);
        InAppActivityAttributes inAppActivityAttributes = new InAppActivityAttributes();
        this.mInAppActivityAttributes = inAppActivityAttributes;
        inAppActivityAttributes.setupAttributes(this);
        setBackPressedListener();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        InAppLogger.m8595d(TAG, "onDestroy");
        ContinuityClientManager.Companion companion = ContinuityClientManager.INSTANCE;
        ContinuityClientManager companion2 = companion.getInstance();
        if (companion2 != null) {
            companion2.disconnect(getApplicationContext());
        }
        ContinuityClientManager companion3 = companion.getInstance();
        if (companion3 != null) {
            companion3.release(getApplicationContext());
        }
        InAppView inAppView = this.mView;
        if (inAppView != null) {
            inAppView.detachedView();
        }
        InAppActivityAttributes inAppActivityAttributes = this.mInAppActivityAttributes;
        if (inAppActivityAttributes != null) {
            inAppActivityAttributes.clearAttributes(this);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InAppLogger.m8595d(TAG, "onDetachedFromWindow");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, @NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
        if (isInMultiWindowMode) {
            finishActivity();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        InAppLogger.m8595d(TAG, "onPause");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        InAppLogger.m8595d(TAG, "onResume");
        updateUIMode("onResume");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        InAppActivityAttributes inAppActivityAttributes;
        super.onWindowFocusChanged(hasFocus);
        if (!hasFocus || (inAppActivityAttributes = this.mInAppActivityAttributes) == null) {
            return;
        }
        inAppActivityAttributes.windowFocusChanged(this);
    }
}
