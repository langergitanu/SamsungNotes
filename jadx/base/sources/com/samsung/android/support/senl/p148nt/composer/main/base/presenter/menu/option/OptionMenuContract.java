package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuParam;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface OptionMenuContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IOptionMenu {
        void attachBottomMenu();

        void hideBottomMenu();

        void hideOptionMenu();

        void invalidateOptionsMenu();

        boolean onOptionsItemSelected(@NonNull OptionMenuParam optionMenuParam, int i);

        boolean replaceInAppOptionMenu(boolean z);

        void showBottomMenu();

        void showNoteStyle();

        void showSaveAsPopup();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IOptionMenuMorePopup {
        boolean onOptionsItemSelected(@NonNull OptionMenuParam optionMenuParam, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IOptionMenuShare {
        void showPopupMenu(Activity activity, OptionMenuSharePresenter optionMenuSharePresenter);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IOptionMenuViewMode extends IOptionMenu {
    }
}
