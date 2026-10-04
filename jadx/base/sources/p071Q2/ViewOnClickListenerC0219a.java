package p071Q2;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuItemImpl;
import com.google.android.material.appbar.model.AppBarModel;
import com.google.android.material.appbar.model.ButtonModel;
import com.google.android.material.appbar.model.view.SuggestAppBarView;
import com.google.android.material.oneui.dividerbuttonlayout.DividerButtonLayout;
import com.google.android.material.snackbar.Snackbar;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionData;
import com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdaterLocalImpl;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value.ToggleCapsule;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.OnDeviceLanguage;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.p138ui.LanguageSelectFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SimpleViewHolder;
import com.samsung.android.support.senl.p148nt.app.main.oldnotes.adpater.holder.OldCategoryHolder;
import com.samsung.android.support.senl.p148nt.app.main.oldnotes.model.OldCategoryData;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.UpdateTipCardPreference;
import com.samsung.android.support.senl.p148nt.app.settings.main.SettingsMiscHelper;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TableManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.FolderViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.table.TableCalculateMenu;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;

/* JADX INFO: renamed from: Q2.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ViewOnClickListenerC0219a implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f654a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f655b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f656c;

    public /* synthetic */ ViewOnClickListenerC0219a(Object obj, Object obj2, int i) {
        this.f654a = i;
        this.f655b = obj;
        this.f656c = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f654a) {
            case 0:
                OldCategoryHolder.decorateItemView$lambda$0((OldCategoryHolder) this.f655b, (OldCategoryData) this.f656c, view);
                break;
            case 1:
                SuggestAppBarView.generateButton$lambda$11$lambda$10((ButtonModel) this.f655b, (SuggestAppBarView) this.f656c, view);
                break;
            case 2:
                SuggestAppBarView.setCloseClickListener$lambda$6$lambda$5((AppBarModel.OnClickListener) this.f655b, (SuggestAppBarView) this.f656c, view);
                break;
            case 3:
                DividerButtonLayout.createDividerButton$lambda$6$lambda$5((DividerButtonLayout) this.f655b, (MenuItemImpl) this.f656c, view);
                break;
            case 4:
                ((Snackbar) this.f655b).lambda$setAction$0((View.OnClickListener) this.f656c, view);
                break;
            case 5:
                SurfacePackageUpdaterLocalImpl.assignText$lambda$18$lambda$17$lambda$16((SurfacePackageUpdaterLocalImpl) this.f655b, (SuggestionData) this.f656c, view);
                break;
            case 6:
                CapsuleHelperImpl.drawToggleCapsule$lambda$8$lambda$6((ToggleCapsule) this.f655b, (CapsuleHelperImpl) this.f656c, view);
                break;
            case 7:
                LanguageSelectFragment.createLanguageRadioButton$lambda$18$lambda$17((LanguageSelectFragment) this.f655b, (OnDeviceLanguage) this.f656c, view);
                break;
            case 8:
                ((SimpleViewHolder) this.f655b).lambda$decorateSearchExtra$0((MainListDocumentData) this.f656c, view);
                break;
            case 9:
                SettingsMiscHelper.initTipCard$lambda$1((SettingsMiscHelper) this.f655b, (UpdateTipCardPreference) this.f656c, view);
                break;
            case 10:
                PermissionHelper.showGotoSettingsSnackBar$lambda$5((Runnable[]) this.f655b, (Activity) this.f656c, view);
                break;
            case 11:
                ((DialogPresenterManager) this.f655b).lambda$showOpenLinkPopup$0((Runnable) this.f656c, view);
                break;
            case 12:
                ((FolderViewManager) this.f655b).lambda$init$2((AlertDialog) this.f656c, view);
                break;
            default:
                TableCalculateMenu.setUpRemoveDialog$lambda$4((TableCalculateMenu) this.f655b, (TableManager.Calculation) this.f656c, view);
                break;
        }
    }
}
