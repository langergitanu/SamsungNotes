package com.samsung.android.app.notes.memolist;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.Migrations;
import java.io.IOException;
import java.io.InputStream;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class NoticeUTActivity extends AppCompatActivity {
    private static final String TAG = "NoticeUTActivity";

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAppData(Context context) {
        StringBuilder sb;
        InputStream inputStream = null;
        try {
            try {
                Debugger.m8609e(TAG, "clearAppData, package : " + context.getPackageName());
                inputStream = Runtime.getRuntime().exec("pm clear " + context.getPackageName()).getInputStream();
                SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putInt(Constants.PREFERENCE_NOTICE_FOR_UT, 6);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e = e;
                        sb = new StringBuilder("clearAppData, fail to close the stream : ");
                        AbstractC0000a.m20q(e, sb, TAG);
                    }
                }
            } catch (Exception e2) {
                Debugger.m8609e(TAG, "clearAppData, fail to clearAppData : " + e2.getMessage());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e = e3;
                        sb = new StringBuilder("clearAppData, fail to close the stream : ");
                        AbstractC0000a.m20q(e, sb, TAG);
                    }
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    AbstractC0000a.m20q(e5, new StringBuilder("clearAppData, fail to close the stream : "), TAG);
                }
            }
            throw th;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C8003R.layout.notice_empty_layout);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(this);
        alertDialogBuilderForAppCompat.setTitle(C8003R.string.notice_for_ut_title);
        alertDialogBuilderForAppCompat.setMessage(C8003R.string.notice_for_ut_body);
        alertDialogBuilderForAppCompat.setCancelable(false);
        alertDialogBuilderForAppCompat.setPositiveButton(getResources().getString(C8003R.string.f6004OK), new DialogInterface.OnClickListener() { // from class: com.samsung.android.app.notes.memolist.NoticeUTActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Logger.m8698e(NoticeUTActivity.TAG, "onClick, clearAppData - start");
                Migrations.NEED_TO_BE_CLEARED_DATA.set(false);
                NoticeUTActivity noticeUTActivity = NoticeUTActivity.this;
                noticeUTActivity.clearAppData(noticeUTActivity.getApplicationContext());
                dialogInterface.dismiss();
                NoticeUTActivity.this.finish();
                Logger.m8698e(NoticeUTActivity.TAG, "onClick, clearAppData - end");
            }
        });
        alertDialogBuilderForAppCompat.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.samsung.android.app.notes.memolist.NoticeUTActivity.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() != 4) {
                    return false;
                }
                MainLogger.m7258i(NoticeUTActivity.TAG, "backKey");
                return true;
            }
        });
        alertDialogBuilderForAppCompat.show();
    }
}
