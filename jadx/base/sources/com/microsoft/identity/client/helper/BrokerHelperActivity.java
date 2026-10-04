package com.microsoft.identity.client.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.internal.broker.PackageHelper;
import com.microsoft.identity.msal.C6452R;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BrokerHelperActivity extends Activity {
    private final String MANIFEST_TEMPLATE = "<activity android:name=\"com.microsoft.identity.client.BrowserTabActivity\">\n    <intent-filter>\n        <action android:name=\"android.intent.action.VIEW\" />\n        <category android:name=\"android.intent.category.DEFAULT\" />\n        <category android:name=\"android.intent.category.BROWSABLE\" />\n        <data\n            android:host=\"%s\"\n            android:path=\"/%s\"\n            android:scheme=\"msauth\" />\n    </intent-filter>\n</activity>";
    TextView mManifest;
    TextView mPackageName;
    TextView mRedirect;
    TextView mSignature;

    public static Intent createStartIntent(Context context) {
        return new Intent(context, (Class<?>) BrokerHelperActivity.class);
    }

    private String getSignature(boolean z) {
        String sha1SignatureForPackage = new PackageHelper(getApplicationContext().getPackageManager()).getSha1SignatureForPackage(getPackageName());
        if (!z) {
            return sha1SignatureForPackage;
        }
        try {
            return URLEncoder.encode(sha1SignatureForPackage, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e("getSignature", "Character encoding UTF-8 is not supported.", e);
            throw new RuntimeException("Unexpected: Unable to get the signature for this application package.");
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C6452R.layout.broker_helper);
        this.mPackageName = (TextView) findViewById(C6452R.id.txtPackageName);
        this.mSignature = (TextView) findViewById(C6452R.id.txtSignature);
        this.mRedirect = (TextView) findViewById(C6452R.id.txtRedirect);
        this.mManifest = (TextView) findViewById(C6452R.id.txtManifest);
        this.mSignature.append(getSignature(false));
        this.mRedirect.append(PackageHelper.getBrokerRedirectUri(getApplicationContext(), getPackageName()));
        this.mManifest.append(AbstractC0541b.m775q("<activity android:name=\"com.microsoft.identity.client.BrowserTabActivity\">\n    <intent-filter>\n        <action android:name=\"android.intent.action.VIEW\" />\n        <category android:name=\"android.intent.category.DEFAULT\" />\n        <category android:name=\"android.intent.category.BROWSABLE\" />\n        <data\n            android:host=\"", getPackageName(), "\"\n            android:path=\"/", getSignature(false), "\"\n            android:scheme=\"msauth\" />\n    </intent-filter>\n</activity>"));
        this.mPackageName.append(getPackageName());
    }
}
