package com.google.android.play.core.missingsplits;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.internal.C5203by;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import cz.msebera.android.httpclient.protocol.HTTP;

/* JADX INFO: loaded from: classes5.dex */
public class PlayCoreMissingSplitsActivity extends Activity implements DialogInterface.OnClickListener {
    /* JADX INFO: renamed from: a */
    private final String m4038a() {
        return getApplicationInfo().loadLabel(getPackageManager()).toString();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            m4039a(getPackageName());
        }
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AlertDialog.Builder neutralButton = new AlertDialog.Builder(this).setTitle("Installation failed").setCancelable(false).setNeutralButton(HTTP.CONN_CLOSE, this);
        if (C5203by.m3973a(this)) {
            String strM4038a = m4038a();
            StringBuilder sb = new StringBuilder(String.valueOf(strM4038a).length() + 91);
            sb.append("The app ");
            sb.append(strM4038a);
            sb.append(" is missing required components and must be reinstalled from the Google Play Store.");
            neutralButton.setMessage(sb.toString()).setPositiveButton("Reinstall", this);
        } else {
            String strM4038a2 = m4038a();
            StringBuilder sb2 = new StringBuilder(String.valueOf(strM4038a2).length() + 87);
            sb2.append("The app ");
            sb2.append(strM4038a2);
            sb2.append(" is missing required components and must be reinstalled from an official store.");
            neutralButton.setMessage(sb2.toString());
        }
        neutralButton.create().show();
    }

    /* JADX INFO: renamed from: a */
    private final void m4039a(String str) {
        try {
            startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(AbstractC2322a.m1626p(new StringBuilder(String.valueOf(str).length() + 66), AuthenticationConstants.Broker.PLAY_STORE_INSTALL_PREFIX, str, "&referrer=utm_source%3Dplay.core.missingsplits"))).setPackage("com.android.vending"));
        } catch (ActivityNotFoundException e) {
            new C5157af(getClass().getName()).m3876a(e, "Couldn't start missing splits activity for %s", str);
        }
    }
}
