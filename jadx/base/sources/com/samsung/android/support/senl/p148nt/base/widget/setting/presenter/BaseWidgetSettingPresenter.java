package com.samsung.android.support.senl.p148nt.base.widget.setting.presenter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingModel;
import com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p046K2.DialogInterfaceOnClickListenerC0161a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b&\u0018\u0000 F2\u00020\u0001:\u0001FB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0004J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0014J\"\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J\b\u0010\u001f\u001a\u00020\u0014H&J\b\u0010 \u001a\u00020\u0014H\u0016J\u0006\u0010!\u001a\u00020\u0014J\u000e\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u001bJ\u000e\u0010)\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u001bJ\u000e\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u001bJ\b\u00105\u001a\u00020\u0014H\u0002J\u000e\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020:J\u000e\u0010D\u001a\u00020\u00142\u0006\u0010E\u001a\u00020:R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u00020\u000eX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\"\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b&\u0010$R$\u0010+\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010$\"\u0004\b-\u0010.R\u0011\u00101\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b2\u0010$R\u0011\u00103\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b4\u0010$R\u0011\u00106\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b7\u0010$R\u0013\u0010;\u001a\u0004\u0018\u00010<8F¢\u0006\u0006\u001a\u0004\b=\u0010>R$\u0010?\u001a\u00020:2\u0006\u0010*\u001a\u00020:8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006G"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "", "mActivity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getMActivity", "()Landroid/app/Activity;", "setMActivity", "model", "Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingModel;", "getModel", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingModel;", "view", "Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;", "getView", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;", "setView", "(Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;)V", "checkValidWidget", "", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "Landroid/os/Bundle;", "onDestroy", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "saveAndFinish", "cancelAndFinish", "showCancelDialog", "transparency", "getTransparency", "()I", "reverseTransparency", "getReverseTransparency", "onTransparencyChanged", "progress", "onTransparencyChangedOneUi7x", "value", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "(I)V", "onBackgroundColorCheckChanged", "bgColor", "darkMode", "getDarkMode", BaseWidgetConstant.WIDGET_THEME, "getTheme", "updateTheme", "widgetId", "getWidgetId", "onDarkModeSwitchChanged", "switchOn", "", "oneUiWidgetSource", "", "getOneUiWidgetSource", "()Ljava/lang/String;", "matchSetting", "getMatchSetting", "()Z", "setMatchSetting", "(Z)V", "onMatchSetting", "isMatch", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class BaseWidgetSettingPresenter {

    @NotNull
    private static final String TAG = "BaseWidgetSettingPresenter";

    @Nullable
    private Activity mActivity;

    public BaseWidgetSettingPresenter(@Nullable Activity activity) {
        this.mActivity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCancelDialog$lambda$2(AlertDialog alertDialog, DialogInterface dialogInterface, int i) {
        if (alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }

    private final void updateTheme() {
        BaseWidgetUtils.Companion companion = BaseWidgetUtils.INSTANCE;
        getMModel().setTheme(companion.checkThemeSetting(this.mActivity, getMModel().getReverseTransparency(), !companion.isSupportedNewWidget() ? companion.getCurrentBackgroundColor(this.mActivity, getBackgroundColor(), getDarkMode()) : getMModel().getBackgroundColor(), getMModel().getOneUiWidgetSource()));
    }

    public void cancelAndFinish() {
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.finishAndRemoveTask();
        }
    }

    public final void checkValidWidget() {
        if (getMModel().getWidgetId() == -1) {
            Logger.m8698e(TAG, "widget id invalid");
            cancelAndFinish();
        }
    }

    public final int getBackgroundColor() {
        return getMModel().getBackgroundColor();
    }

    public final int getDarkMode() {
        return getMModel().getDarkMode();
    }

    @Nullable
    public final Activity getMActivity() {
        return this.mActivity;
    }

    public final boolean getMatchSetting() {
        return getMModel().getMatchSetting();
    }

    @NotNull
    /* JADX INFO: renamed from: getModel */
    public abstract BaseWidgetSettingModel getMModel();

    @Nullable
    public final String getOneUiWidgetSource() {
        return getMModel().getOneUiWidgetSource();
    }

    public final int getReverseTransparency() {
        return getMModel().getReverseTransparency();
    }

    public final int getTheme() {
        return getMModel().getTheme();
    }

    public final int getTransparency() {
        return getMModel().getTransparency();
    }

    @NotNull
    public abstract BaseWidgetSettingContract getView();

    public final int getWidgetId() {
        return getMModel().getWidgetId();
    }

    public abstract void onActivityResult(int requestCode, int resultCode, @Nullable Intent data);

    public final void onBackgroundColorCheckChanged(int bgColor) {
        Logger.m8702i(TAG, "onBackgroundColorCheckChanged. " + bgColor);
        getMModel().setBackgroundColor(bgColor);
        updateTheme();
    }

    public final void onDarkModeSwitchChanged(boolean switchOn) {
        Logger.m8702i(TAG, "onDarkModeSwitchChanged.  " + switchOn);
        getMModel().setDarkMode(switchOn ? 1 : 0);
        NotesSamsungAnalytics.INSTANCE.insertLog("616", "6130", switchOn ? "a" : "b");
        updateTheme();
        BaseWidgetSettingContract view = getView();
        if (view != null) {
            view.updateWidgetSettingDarkMode();
        }
    }

    public final void onDestroy() {
        this.mActivity = null;
    }

    public final void onMatchSetting(boolean isMatch) {
        getMModel().setMatchSetting(isMatch);
        getMModel().setDarkMode(isMatch ? 1 : 0);
        updateTheme();
        getView().updateWidgetSettingDarkMode();
    }

    public final void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        getMModel().onSaveInstanceState(outState);
    }

    public final void onTransparencyChanged(int progress) {
        Logger.m8702i(TAG, "onTransparencyChanged. " + progress);
        getMModel().setTransparency(progress);
        BaseWidgetUtils.Companion companion = BaseWidgetUtils.INSTANCE;
        int currentBackgroundColor = companion.getCurrentBackgroundColor(this.mActivity, getBackgroundColor(), getDarkMode());
        int theme = getTheme();
        if (companion.isChangedTheme(this.mActivity, theme, getReverseTransparency(), currentBackgroundColor, getMModel().getOneUiWidgetSource())) {
            Logger.m8702i(TAG, "onTransparencyChanged change theme. " + theme);
            getMModel().setTheme(theme == 1 ? 0 : 1);
            BaseWidgetSettingContract view = getView();
            if (view != null) {
                view.updateWidgetPreviewTheme();
            }
        }
        int iConvertAlpha = companion.convertAlpha(getMModel().getReverseTransparency());
        BaseWidgetSettingContract view2 = getView();
        if (view2 != null) {
            view2.updateWidgetPreviewAlpha(iConvertAlpha);
        }
        NotesSamsungAnalytics.INSTANCE.insertLog("616", "6127", progress);
    }

    public final void onTransparencyChangedOneUi7x(int progress) {
        Logger.m8702i(TAG, "onTransparencyChanged. " + progress);
        getMModel().setTransparency(progress);
        int iConvertAlpha = BaseWidgetUtils.INSTANCE.convertAlpha(getMModel().getReverseTransparency());
        BaseWidgetSettingContract view = getView();
        if (view != null) {
            view.updateWidgetPreviewAlpha(iConvertAlpha);
        }
    }

    public abstract void saveAndFinish();

    public final void setBackgroundColor(int i) {
        getMModel().setBackgroundColor(i);
    }

    public final void setMActivity(@Nullable Activity activity) {
        this.mActivity = activity;
    }

    public final void setMatchSetting(boolean z) {
        getMModel().setMatchSetting(z);
    }

    public abstract void setView(@NotNull BaseWidgetSettingContract baseWidgetSettingContract);

    /* JADX WARN: Multi-variable type inference failed */
    public final void showCancelDialog() {
        if (!getMModel().isWidgetContentChanged()) {
            Logger.m8703w(TAG, "showCancelDialog widget does not changed");
            cancelAndFinish();
            return;
        }
        if (this.mActivity == null) {
            return;
        }
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(this.mActivity, 0, 2, 0 == true ? 1 : 0).create();
        Activity activity = this.mActivity;
        alertDialogCreate.setMessage(activity != null ? activity.getString(C8875R.string.base_string_popup_ask_save) : null);
        Activity activity2 = this.mActivity;
        final int i = 0;
        alertDialogCreate.setButton(-2, activity2 != null ? activity2.getString(C8875R.string.string_discard) : null, new DialogInterface.OnClickListener(this) { // from class: f3.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ BaseWidgetSettingPresenter f8607b;

            {
                this.f8607b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                switch (i) {
                    case 0:
                        this.f8607b.cancelAndFinish();
                        break;
                    default:
                        this.f8607b.saveAndFinish();
                        break;
                }
            }
        });
        Activity activity3 = this.mActivity;
        final int i2 = 1;
        alertDialogCreate.setButton(-1, activity3 != null ? activity3.getString(C8875R.string.base_string_save_type1) : null, new DialogInterface.OnClickListener(this) { // from class: f3.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ BaseWidgetSettingPresenter f8607b;

            {
                this.f8607b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i22) {
                switch (i2) {
                    case 0:
                        this.f8607b.cancelAndFinish();
                        break;
                    default:
                        this.f8607b.saveAndFinish();
                        break;
                }
            }
        });
        Activity activity4 = this.mActivity;
        alertDialogCreate.setButton(-3, activity4 != null ? activity4.getString(C8875R.string.dialog_cancel) : null, new DialogInterfaceOnClickListenerC0161a(alertDialogCreate, 15));
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
    }
}
