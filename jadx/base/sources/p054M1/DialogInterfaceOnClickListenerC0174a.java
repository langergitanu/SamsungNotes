package p054M1;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import com.samsung.android.app.notes.widget.common.ConvertConfirmDialogActivity;
import com.samsung.android.support.senl.p148nt.app.lock.strategy.LockManagerStrategy;
import com.samsung.android.support.senl.p148nt.app.main.common.handoff.HandoffLaunchManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.SortByDialogFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsImportPrefFragment;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.ConfirmDialog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: renamed from: M1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class DialogInterfaceOnClickListenerC0174a implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f554a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f555b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f556c;

    public /* synthetic */ DialogInterfaceOnClickListenerC0174a(Object obj, Object obj2, int i) {
        this.f554a = i;
        this.f555b = obj;
        this.f556c = obj2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f554a) {
            case 0:
                ConvertConfirmDialogActivity.onCreate$lambda$0((ConvertConfirmDialogActivity.ConvertConfirmsDialogFragment) this.f555b, (ConvertConfirmDialogActivity) this.f556c, dialogInterface, i);
                break;
            case 1:
                LockManagerStrategy.migrateSDOCPreProcess$lambda$0((Activity) this.f555b, (String) this.f556c, dialogInterface, i);
                break;
            case 2:
                HandoffLaunchManager.handleComposer$lambda$1((HandoffLaunchManager) this.f555b, (JSONObject) this.f556c, dialogInterface, i);
                break;
            case 3:
                SortByDialogFragment.onCreateDialog$lambda$1((View) this.f555b, (SortByDialogFragment) this.f556c, dialogInterface, i);
                break;
            case 4:
                SettingsImportPrefFragment.showDialogWhenMobileNetwork$lambda$1((Runnable) this.f555b, (SettingsImportPrefFragment) this.f556c, dialogInterface, i);
                break;
            case 5:
                HandoffUtils.showDialogDisableSyncTurnOn$lambda$2((Runnable) this.f555b, (WeakReference) this.f556c, dialogInterface, i);
                break;
            default:
                ConfirmDialog.buildDialog$lambda$0((ConfirmDialog) this.f555b, (DialogInterface.OnClickListener) this.f556c, dialogInterface, i);
                break;
        }
    }
}
