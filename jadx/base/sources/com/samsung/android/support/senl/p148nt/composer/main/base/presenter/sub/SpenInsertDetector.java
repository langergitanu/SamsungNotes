package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpenInsertDetector {
    private static final String ACTION_PEN_INSERT = "com.samsung.pen.INSERT";
    private static final String TAG = Logger.createTag("SpenInsertDetector");
    private final Runnable mDetachRunnable;
    private final IntentFilter mIntentFilter;
    private boolean mIsFirstSpenInsertReceiver = false;
    private final BroadcastReceiver mSpenInsertReceiver = new BroadcastReceiver() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.SpenInsertDetector.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (SpenInsertDetector.ACTION_PEN_INSERT.equals(intent.getAction())) {
                if (SpenInsertDetector.this.mIsFirstSpenInsertReceiver) {
                    SpenInsertDetector.this.mIsFirstSpenInsertReceiver = false;
                    return;
                }
                boolean booleanExtra = intent.getBooleanExtra("penInsert", true);
                boolean booleanExtra2 = intent.getBooleanExtra("isBoot", false);
                String str = SpenInsertDetector.TAG;
                StringBuilder sb = new StringBuilder("ACTION_PEN_INSERT :");
                sb.append(context.hashCode());
                sb.append(" / ");
                sb.append(booleanExtra);
                sb.append(" / ");
                AbstractC8014b.m7215q(sb, booleanExtra2, str);
                if (booleanExtra2 || booleanExtra || SpenInsertDetector.this.mDetachRunnable == null) {
                    return;
                }
                SpenInsertDetector.this.mDetachRunnable.run();
            }
        }
    };

    public SpenInsertDetector(Runnable runnable) {
        this.mDetachRunnable = runnable;
        IntentFilter intentFilter = new IntentFilter();
        this.mIntentFilter = intentFilter;
        intentFilter.addAction(ACTION_PEN_INSERT);
    }

    public void registerSpenInsertReceiver(Context context) {
        BroadcastReceiver broadcastReceiver = this.mSpenInsertReceiver;
        if (broadcastReceiver != null) {
            try {
                context.registerReceiver(broadcastReceiver, this.mIntentFilter);
            } catch (Exception e) {
                Logger.m11000e(TAG, e.toString());
            }
            this.mIsFirstSpenInsertReceiver = true;
        }
    }

    public void unregisterSpenInsertReceiver(Context context) {
        BroadcastReceiver broadcastReceiver = this.mSpenInsertReceiver;
        if (broadcastReceiver != null) {
            try {
                context.unregisterReceiver(broadcastReceiver);
            } catch (Exception e) {
                Logger.m11000e(TAG, e.toString());
            }
        }
    }
}
