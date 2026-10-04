package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.C6228R;
import com.microsoft.identity.common.logging.Logger;
import java.security.cert.X509Certificate;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SmartcardCertPickerDialog extends SmartcardDialog {
    private static final String TAG = "SmartcardCertPickerDialog";
    private final ICancelCbaCallback mCancelCbaCallback;
    private final List<ICertDetails> mCertList;
    private final PositiveButtonListener mPositiveButtonListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CertDetailsAdapter extends ArrayAdapter<ICertDetails> {
        public CertDetailsAdapter(@NonNull Context context, @NonNull List<ICertDetails> list) {
            super(context, 0, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        @NonNull
        public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(C6228R.layout.certificate_row_layout, viewGroup, false);
            }
            TextView textView = (TextView) view.findViewById(C6228R.id.subjectText);
            TextView textView2 = (TextView) view.findViewById(C6228R.id.issuerText);
            X509Certificate certificate = ((ICertDetails) getItem(i)).getCertificate();
            textView.setText(certificate.getSubjectDN().getName());
            textView2.setText(certificate.getIssuerDN().getName());
            ((RadioButton) view.findViewById(C6228R.id.radioButton)).setChecked(i == ((ListView) viewGroup).getCheckedItemPosition());
            return view;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PositiveButtonListener {
        void onClick(@NonNull ICertDetails iCertDetails);
    }

    public SmartcardCertPickerDialog(@NonNull List<ICertDetails> list, @NonNull PositiveButtonListener positiveButtonListener, @NonNull ICancelCbaCallback iCancelCbaCallback, @NonNull Activity activity) {
        super(activity);
        this.mCertList = list;
        this.mPositiveButtonListener = positiveButtonListener;
        this.mCancelCbaCallback = iCancelCbaCallback;
        createDialog();
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.SmartcardDialog
    public void createDialog() {
        final String strM1170p = AbstractC0622a.m1170p(TAG, ":createDialog", new StringBuilder());
        final CertDetailsAdapter certDetailsAdapter = new CertDetailsAdapter(this.mActivity, this.mCertList);
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardCertPickerDialog.1
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialogCreate = new AlertDialog.Builder(SmartcardCertPickerDialog.this.mActivity, C6228R.style.CertAlertDialogTheme).setTitle(C6228R.string.smartcard_cert_dialog_title).setSingleChoiceItems(certDetailsAdapter, 0, (DialogInterface.OnClickListener) null).setPositiveButton(C6228R.string.smartcard_cert_dialog_positive_button, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardCertPickerDialog.1.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ICertDetails iCertDetails = (ICertDetails) certDetailsAdapter.getItem(((AlertDialog) dialogInterface).getListView().getCheckedItemPosition());
                        if (iCertDetails != null) {
                            SmartcardCertPickerDialog.this.mPositiveButtonListener.onClick(iCertDetails);
                        } else {
                            SmartcardCertPickerDialog.this.mCancelCbaCallback.onCancel();
                            Logger.error(strM1170p, "Could not retrieve info for selected certificate entry.", null);
                        }
                    }
                }).setNegativeButton(C6228R.string.smartcard_cert_dialog_negative_button, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardCertPickerDialog.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SmartcardCertPickerDialog.this.mCancelCbaCallback.onCancel();
                    }
                }).create();
                final ListView listView = alertDialogCreate.getListView();
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardCertPickerDialog.1.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        listView.setItemChecked(i, true);
                        certDetailsAdapter.notifyDataSetChanged();
                    }
                });
                alertDialogCreate.setCanceledOnTouchOutside(false);
                alertDialogCreate.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardCertPickerDialog.1.4
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        SmartcardCertPickerDialog.this.mCancelCbaCallback.onCancel();
                    }
                });
                SmartcardCertPickerDialog.this.mDialog = alertDialogCreate;
            }
        });
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.SmartcardDialog
    public void onUnexpectedUnplug() {
        this.mCancelCbaCallback.onCancel();
    }
}
