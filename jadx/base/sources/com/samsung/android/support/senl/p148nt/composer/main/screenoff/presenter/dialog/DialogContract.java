package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.net.Uri;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogContract;", "", "ISaveNoteDialogPresenter", "ISelectNoteDialogPresenter", "IPinNoteDialogPresenter", "IDialogCreator", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface DialogContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogContract$IDialogCreator;", "", "createSaveNoteDialogPresenter", "Landroid/app/Dialog;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogContract$ISaveNoteDialogPresenter;", "createSelectNoteDialogPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogContract$ISelectNoteDialogPresenter;", "createPinNoteDialogPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogContract$IPinNoteDialogPresenter;", "pinnedNoteUri", "Landroid/net/Uri;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IDialogCreator {
        @NotNull
        Dialog createPinNoteDialogPresenter(@NotNull Activity activity, @NotNull IPinNoteDialogPresenter presenter, @NotNull Uri pinnedNoteUri);

        @NotNull
        Dialog createSaveNoteDialogPresenter(@NotNull Activity activity, @NotNull ISaveNoteDialogPresenter presenter);

        @NotNull
        Dialog createSelectNoteDialogPresenter(@NotNull Activity activity, @NotNull ISelectNoteDialogPresenter presenter);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogContract$IPinNoteDialogPresenter;", "", "cancel", "", ClientCookie.DISCARD_ATTR, "save", "dismiss", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IPinNoteDialogPresenter {
        void cancel();

        void discard();

        void dismiss();

        void save();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogContract$ISaveNoteDialogPresenter;", "", "cancel", "", ClientCookie.DISCARD_ATTR, "save", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ISaveNoteDialogPresenter {
        void cancel();

        void discard();

        void save();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogContract$ISelectNoteDialogPresenter;", "", "cancel", "", ClientCookie.DISCARD_ATTR, "save", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ISelectNoteDialogPresenter {
        void cancel();

        void discard();

        void save();
    }
}
