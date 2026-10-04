package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.AppWidgetResolverConstructor;
import com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.IAppWidgetResolver;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskLock;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuPinToHome {
    private static final String TAG = "OptionMenuPinToHome";

    public boolean isSupportedPinToHome(Activity activity) {
        try {
            IAppWidgetResolver appWidgetResolver = AppWidgetResolverConstructor.getAppWidgetResolver();
            if (appWidgetResolver != null) {
                return appWidgetResolver.isSupportedPinToHome(activity);
            }
            Logger.m11000e(TAG, "isSupportedPinToHome: cannot get the WidgetResolver class");
            return false;
        } catch (Exception e) {
            Logger.m11001e(TAG, "isSupportedPinToHome# " + e.getMessage(), e);
            return false;
        }
    }

    public void onClickPinToHome(final Activity activity, final MenuPresenterContract.IMenuManager iMenuManager, DialogPresenterManager dialogPresenterManager, final ComposerModel composerModel, final OptionMenuLock optionMenuLock) {
        try {
            final IAppWidgetResolver appWidgetResolver = AppWidgetResolverConstructor.getAppWidgetResolver();
            if (appWidgetResolver == null) {
                Logger.m11000e(TAG, "onClickPinToHome: cannot get the WidgetResolver class");
                return;
            }
            if (!appWidgetResolver.isAvailableToReferWidget(activity)) {
                appWidgetResolver.showWidgetMaximumToast(activity);
                return;
            }
            if (!appWidgetResolver.isAvailableToAddWidget(activity, composerModel.getDocState().getUuid())) {
                appWidgetResolver.showWidgetAlreadyPinToast(activity);
            } else if (composerModel.getNotesDocEntityManager().isLocked()) {
                dialogPresenterManager.showUnlockConfirmDialog(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuPinToHome.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OptionMenuLock optionMenuLock2 = optionMenuLock;
                        if (optionMenuLock2 != null) {
                            optionMenuLock2.unlock(new Task.Callback<TaskLock.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuPinToHome.1.1
                                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                                public void onError(TaskLock.ResultValues resultValues) {
                                }

                                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                                public void onSuccess(TaskLock.ResultValues resultValues) {
                                    IAppWidgetResolver iAppWidgetResolver;
                                    RunnableC98221 runnableC98221 = RunnableC98221.this;
                                    Activity activity2 = activity;
                                    if (activity2 == null || composerModel == null || (iAppWidgetResolver = appWidgetResolver) == null) {
                                        return;
                                    }
                                    iAppWidgetResolver.pinToHme(activity2, resultValues.getUuid(), resultValues.getPath());
                                    iMenuManager.invalidateOptionsMenu();
                                    activity.getWindow().clearFlags(8192);
                                }
                            });
                        }
                    }
                });
            } else {
                appWidgetResolver.pinToHme(activity, composerModel.getDocState().getUuid(), composerModel.getDocState().getLoadPath());
            }
        } catch (Exception e) {
            Logger.m11001e(TAG, "onClickPinToHome# " + e.getMessage(), e);
        }
    }
}
