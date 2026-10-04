package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/GoToSettingsDialogPresenter;", "", "<init>", "()V", Constants.IntentExtraValue.SHOW, "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "errorMessage", "", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class GoToSettingsDialogPresenter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/GoToSettingsDialogPresenter$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return GoToSettingsDialogPresenter.TAG;
        }

        private Companion() {
        }
    }

    static {
        String strCreateTag = Logger.createTag("GoToSettingsDialogPresenter");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public final void show(@NotNull final Activity activity, int errorMessage) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.GoToSettingsDialogPresenter$show$onClickListenerWrapper$1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                UserInputSkipper.Tag tag = UserInputSkipper.Tag.Default;
                if (UserInputSkipper.isValidEvent(tag)) {
                    UserInputSkipper.setHoldingEventTime(300L, tag);
                    if (CommonUtil.isNotAvailableActivity(activity)) {
                        Logger.m11000e(GoToSettingsDialogPresenter.INSTANCE.getTAG(), "show# isNotAvailableActivity");
                        return;
                    }
                    try {
                        Intent intent = new Intent(BaseUtils.getApplicationContext(), NoteListAccessHandler.getSettingsActivity());
                        intent.putExtra(SettingsConstants.KEY_CALLEE, SettingsConstants.CALLEE_COMPOSER_DELEGATE_SETTINGS);
                        intent.putExtra(SettingsConstants.FRAGMENT_TYPE, 4);
                        intent.putExtra(SettingsConstants.EXTRA_FRAGMENT_ARG_KEY, SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION);
                        PopOverActivityWrapper.startActivity(activity, intent, 5);
                    } catch (NullPointerException e) {
                        AbstractC8014b.m7198D("show# ", e.getMessage(), GoToSettingsDialogPresenter.INSTANCE.getTAG());
                    }
                }
            }
        };
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(activity, 0, 2, null);
        alertDialogBuilderForAppCompat.setMessage(errorMessage);
        alertDialogBuilderForAppCompat.setNegativeButton(C9086R.string.co_edit_go_to_settings, onClickListener);
        alertDialogBuilderForAppCompat.setPositiveButton(C9086R.string.ai_drawing_cancel, (DialogInterface.OnClickListener) null);
        alertDialogBuilderForAppCompat.create().show();
    }
}
