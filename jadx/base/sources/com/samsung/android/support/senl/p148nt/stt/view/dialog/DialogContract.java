package com.samsung.android.support.senl.p148nt.stt.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/DialogContract;", "", "IDiscardConfirmDialogPresenter", "IRemoveConfirmDialogPresenter", "IDialogCreator", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface DialogContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/DialogContract$IDialogCreator;", "", "createDiscardConfirmDialog", "Landroid/app/Dialog;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "presenter", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/DialogContract$IDiscardConfirmDialogPresenter;", "createRemoveTranscriptConfirmDialog", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/RemoveTranscriptConfirmDialog;", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/DialogContract$IRemoveConfirmDialogPresenter;", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IDialogCreator {
        @Nullable
        Dialog createDiscardConfirmDialog(@Nullable Activity activity, @NotNull IDiscardConfirmDialogPresenter presenter);

        @Nullable
        RemoveTranscriptConfirmDialog createRemoveTranscriptConfirmDialog(@Nullable IRemoveConfirmDialogPresenter presenter);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/DialogContract$IDiscardConfirmDialogPresenter;", "", "cancel", "", ClientCookie.DISCARD_ATTR, "save", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IDiscardConfirmDialogPresenter {
        void cancel();

        void discard();

        void save();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/DialogContract$IRemoveConfirmDialogPresenter;", "", "remove", "", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IRemoveConfirmDialogPresenter {
        void remove();
    }
}
