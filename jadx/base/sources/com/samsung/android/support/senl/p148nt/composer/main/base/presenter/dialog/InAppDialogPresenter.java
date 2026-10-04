package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.base.common.inapp.model.NearbyMyDevicesModel;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.AlertDialogWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class InAppDialogPresenter {
    private static final String TAG = Logger.createTag("InAppDeviceListDialogPresenter");
    private AlertDialog mDialog;
    private final DialogContract.IParent mMenuParent;

    public InAppDialogPresenter(DialogContract.IParent iParent) {
        this.mMenuParent = iParent;
    }

    private View getView(Activity activity, Map<String, NearbyMyDevicesModel.NearbyDevice> map) {
        int i = 0;
        final String[] strArr = (String[]) map.keySet().toArray(new String[0]);
        String[] strArr2 = new String[strArr.length];
        Iterator<NearbyMyDevicesModel.NearbyDevice> it = map.values().iterator();
        while (it.hasNext()) {
            strArr2[i] = it.next().getDisplayName();
            i++;
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(activity, C9086R.layout.in_app_device_list_item, strArr2) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.InAppDialogPresenter.2
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            @NonNull
            public View getView(int i2, @Nullable View view, @NonNull ViewGroup viewGroup) {
                if (view == null) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.in_app_device_list_item, (ViewGroup) null);
                }
                ((TextView) view.findViewById(C9086R.id.in_app_device_name)).setText((CharSequence) getItem(i2));
                return view;
            }
        };
        View viewInflate = LayoutInflater.from(activity).inflate(C9086R.layout.in_app_device_list_dialog_layout, (ViewGroup) null);
        ListView listView = (ListView) viewInflate.findViewById(C9086R.id.in_app_device_list_view);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.InAppDialogPresenter.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                InAppLogger.m8595d(InAppDialogPresenter.TAG, "showDeviceListDialog# onClick position " + i2);
                InAppDialogPresenter.this.mMenuParent.startInAppCollaboration(strArr[i2]);
                InAppDialogPresenter.this.dismiss();
            }
        });
        return viewInflate;
    }

    private void showDeviceListDialog(Activity activity, Map<String, NearbyMyDevicesModel.NearbyDevice> map) {
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(activity);
        alertDialogBuilderForAppCompat.setTitle(C9086R.string.in_app_device_list_dialog_title);
        alertDialogBuilderForAppCompat.setView(getView(activity, map));
        alertDialogBuilderForAppCompat.setNegativeButton(C9086R.string.dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.InAppDialogPresenter.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        this.mDialog = alertDialogCreate;
        AlertDialogWrapper.setAnchorView(alertDialogCreate, activity.findViewById(C9086R.id.toolbar), AlertDialogWrapper.AnchorType.getTOOLBAR());
        this.mDialog.show();
        InAppLogger.m8595d(TAG, "showDeviceListDialog# show");
        ComposerSA.insertLog("748", "7065");
        Window window = this.mDialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = activity.getResources().getDimensionPixelSize(C9086R.dimen.in_app_device_list_dialog_width);
            window.setAttributes(attributes);
        }
    }

    public void dismiss() {
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        InAppLogger.m8595d(TAG, "dismissDeviceListDialog#");
        this.mDialog.dismiss();
    }

    public void show(Activity activity, Map<String, NearbyMyDevicesModel.NearbyDevice> map) {
        if (map.size() == 1) {
            this.mMenuParent.startInAppCollaboration(((String[]) map.keySet().toArray(new String[0]))[0]);
        } else if (map.size() > 1) {
            showDeviceListDialog(activity, map);
        }
    }
}
