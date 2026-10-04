package com.samsung.android.sdk.ocr.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.ocr.service.IOCRService;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class OCRServiceCreator {
    private static final String TAG = "OCRServiceCreator";
    private final Condition mConnectionCondition;
    private final ReentrantLock mConnectionLock;
    private Context mContext;
    private IOCRService mIOCRService;
    private boolean mIsConnected;
    private final ServiceConnection mServiceConnection;

    public OCRServiceCreator(Context context) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mConnectionLock = reentrantLock;
        this.mConnectionCondition = reentrantLock.newCondition();
        this.mIsConnected = false;
        this.mServiceConnection = new ServiceConnection() { // from class: com.samsung.android.sdk.ocr.service.OCRServiceCreator.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.i(OCRServiceCreator.TAG, "onServiceConnected : " + componentName);
                OCRServiceCreator.this.mIOCRService = IOCRService.Stub.asInterface(iBinder);
                OCRServiceCreator.this.mConnectionLock.lock();
                try {
                    OCRServiceCreator.this.mIsConnected = true;
                    Log.d(OCRServiceCreator.TAG, "connected, signal all : " + OCRServiceCreator.this.mServiceConnection);
                    OCRServiceCreator.this.mConnectionCondition.signalAll();
                } finally {
                    OCRServiceCreator.this.mConnectionLock.unlock();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Log.i(OCRServiceCreator.TAG, "onServiceDisconnected " + componentName);
                OCRServiceCreator.this.mConnectionLock.lock();
                try {
                    OCRServiceCreator.this.mIsConnected = false;
                    Log.d(OCRServiceCreator.TAG, "disconnected, signal all : " + OCRServiceCreator.this.mServiceConnection);
                    OCRServiceCreator.this.mConnectionCondition.signalAll();
                    OCRServiceCreator.this.mConnectionLock.unlock();
                    OCRServiceCreator.this.mIOCRService = null;
                } catch (Throwable th) {
                    OCRServiceCreator.this.mConnectionLock.unlock();
                    throw th;
                }
            }
        };
        this.mContext = context.getApplicationContext();
    }

    private Intent getIntent() {
        return AbstractC2821a.m2214e(OCRServiceConstant.ACTION_OCR_SERVICE, "com.samsung.android.sdk.ocr");
    }

    public void close() {
        this.mConnectionLock.lock();
        Log.d(TAG, "close() : connected? " + this.mIsConnected);
        try {
            if (this.mIsConnected) {
                this.mContext.unbindService(this.mServiceConnection);
            }
            this.mConnectionLock.unlock();
            this.mContext = null;
        } catch (Throwable th) {
            this.mConnectionLock.unlock();
            throw th;
        }
    }

    public void connect() {
        this.mConnectionLock.lock();
        try {
            try {
                if (!this.mIsConnected) {
                    this.mContext.bindService(getIntent(), this.mServiceConnection, 1);
                    while (!this.mIsConnected) {
                        this.mConnectionCondition.await();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            this.mConnectionLock.unlock();
        }
    }

    public IOCRService getService() {
        return this.mIOCRService;
    }
}
