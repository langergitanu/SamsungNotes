package com.samsung.android.support.senl.p148nt.app.labs;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p145cm.base.common.util.EnvironmentUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.ContextCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class LabsController implements View.OnClickListener {
    private static final int LABS_ENABLE_COUNT = 4;
    private static final String TAG = "LabsController";
    private static LabsController mInstance;
    private int mLabsEnableCount = 0;
    private Toast mPrevToast;
    private int mViewId;

    private LabsController() {
    }

    private void changeViewForActivated(View view, boolean z) {
        if (z) {
            view.setForeground(new ColorDrawable(-2130771968));
        } else {
            view.setForeground(null);
        }
    }

    public static LabsController getInstance() {
        if (mInstance == null) {
            mInstance = new LabsController();
        }
        return mInstance;
    }

    private boolean isAvailable() {
        if (DeviceInfo.isEngMode()) {
            return true;
        }
        if (AbstractC2322a.m1607A(Environment.getExternalStorageDirectory().getPath() + "/SamsungNotesLabs.cfg")) {
            return true;
        }
        setLaboratoryMode(false);
        return false;
    }

    private void releaseToast() {
        Toast toast = this.mPrevToast;
        if (toast != null) {
            toast.cancel();
            this.mPrevToast = null;
        }
    }

    private void setLaboratoryMode(boolean z) {
        EnvironmentUtils.setLaboratoryMode(z, "dDxo#DEo(Ea#lo^isExdGL@AX!@dov$u*gDW)-+FGx");
        if (z) {
            return;
        }
        releaseToast();
    }

    private void show(Context context, String str, boolean z) {
        releaseToast();
        Toast toastMakeText = Toast.makeText(context, str, z ? 1 : 0);
        toastMakeText.show();
        this.mPrevToast = toastMakeText;
    }

    private void showCount(Context context) {
        show(context, "Labs count : " + this.mLabsEnableCount, false);
    }

    private void showState(View view) {
        boolean zIsRunningLaboratoryMode = EnvironmentUtils.isRunningLaboratoryMode();
        show(view.getContext(), "Labs ".concat(zIsRunningLaboratoryMode ? "enabled" : "disabled"), true);
        changeViewForActivated(view, zIsRunningLaboratoryMode);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mViewId != view.getId()) {
            return;
        }
        if (EnvironmentUtils.isRunningLaboratoryMode()) {
            int i = this.mLabsEnableCount;
            if (i == 0) {
                setLaboratoryMode(false);
                showState(view);
                return;
            } else {
                if (i > 0) {
                    showCount(view.getContext());
                    this.mLabsEnableCount--;
                    return;
                }
                return;
            }
        }
        int i2 = this.mLabsEnableCount;
        if (i2 == 4) {
            setLaboratoryMode(true);
            showState(view);
        } else if (i2 < 4) {
            this.mLabsEnableCount = i2 + 1;
            showCount(view.getContext());
        }
    }

    public void removeController(@NonNull View view) {
        view.setOnClickListener(null);
        releaseToast();
    }

    public boolean runLabs(Context context) {
        if (!EnvironmentUtils.isRunningLaboratoryMode()) {
            return false;
        }
        Intent intent = new Intent(context, (Class<?>) LabsActivity.class);
        ActivityOptions activityOptionsMakeLaunchBoundOption = ContextCompat.INSTANCE.getInstance().makeLaunchBoundOption(0, 0, 500, 1000);
        intent.setFlags(469762048);
        context.startActivity(intent, activityOptionsMakeLaunchBoundOption.toBundle());
        return true;
    }

    public void setController(@NonNull View view) {
        if (isAvailable()) {
            if (view.getForeground() != null) {
                Logger.m7105w(TAG, "view has foreground");
            }
            view.setClickable(true);
            view.setOnClickListener(this);
            this.mViewId = view.getId();
            boolean zIsRunningLaboratoryMode = EnvironmentUtils.isRunningLaboratoryMode();
            changeViewForActivated(view, zIsRunningLaboratoryMode);
            this.mLabsEnableCount = zIsRunningLaboratoryMode ? 4 : 0;
            Logger.m7100d(TAG, "set Labs control view");
        }
    }
}
