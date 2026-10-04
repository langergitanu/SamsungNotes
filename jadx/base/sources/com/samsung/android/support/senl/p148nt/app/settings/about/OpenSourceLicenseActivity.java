package com.samsung.android.support.senl.p148nt.app.settings.about;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p196io.CloseableKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/about/OpenSourceLicenseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initToolbar", "initLayout", "readTextFromAsset", "assetPath", "onDestroy", "onSupportNavigateUp", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class OpenSourceLicenseActivity extends AppCompatActivity {

    @NotNull
    private final String TAG = "ST$OpenSourceLicenseActivity";

    private final void initLayout() {
        MainLogger.m7258i(this.TAG, "initLayout()");
        TextView textView = (TextView) findViewById(C8003R.id.license_text);
        try {
            int color = ContextCompat.getColor(getApplicationContext(), C8003R.color.open_source_license_text_color);
            textView.setText(readTextFromAsset("legal/NOTICE"));
            textView.setTextColor(color);
            textView.setTextSize(13.0f);
            textView.setLineSpacing(0.0f, 1.2f);
            textView.setBackgroundColor(0);
            textView.setTypeface(Typeface.MONOSPACE);
        } catch (IOException e) {
            AbstractC6670b.m4738C("initLayout. IOException occurred: ", e.getMessage(), this.TAG);
        }
    }

    private final void initToolbar() {
        Context applicationContext;
        int i;
        MainLogger.m7258i(this.TAG, "initToolbar()");
        setSupportActionBar((Toolbar) findViewById(C8003R.id.toolbar));
        if (!CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() || SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 50100) {
            applicationContext = getApplicationContext();
            i = C8003R.string.notes;
        } else {
            applicationContext = getApplicationContext();
            i = C8003R.string.notes_jp;
        }
        String string = ContextCompat.getString(applicationContext, i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ActionBar supportActionBar = getSupportActionBar();
        Intrinsics.checkNotNull(supportActionBar);
        supportActionBar.setTitle(string);
        ActionBar supportActionBar2 = getSupportActionBar();
        Intrinsics.checkNotNull(supportActionBar2);
        supportActionBar2.setDisplayHomeAsUpEnabled(true);
    }

    private final String readTextFromAsset(String assetPath) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open(assetPath), "UTF-8"));
            try {
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    stringBuffer.append('\n');
                    stringBuffer.append(line);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedReader, null);
            } finally {
            }
        } catch (IOException e) {
            AbstractC6670b.m4738C("readTextFromAsset. IOException occurred. ", e.getMessage(), this.TAG);
        }
        String string = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainLogger.m7258i(this.TAG, "onCreate()");
        PostLaunchManager.INSTANCE.getInstance().executeBaseLogics();
        setContentView(C8003R.layout.open_source_license_activity);
        initToolbar();
        initLayout();
        WindowManagerCompat.Companion companion = WindowManagerCompat.INSTANCE;
        companion.getInstance().disableSystemBarInsets(findViewById(C8003R.id.activity_container));
        WindowManagerCompat.controllIndicatorBar$default(companion.getInstance(), this, getResources().getConfiguration().orientation, false, 4, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
