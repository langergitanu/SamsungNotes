package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller;

import android.app.Activity;
import android.content.Context;
import android.hardware.input.InputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.KeyboardUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ExternalKeyboardManager {
    private static final String TAG = Logger.createTag("ExternalKeyboardManager");
    private InputManager.InputDeviceListener deviceListener;
    private InputManager inputManager;
    private boolean isExternalKeyboardConnected;
    private final List<OnExternalKeyboardConnectedListener> listeners = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnExternalKeyboardConnectedListener {
        void onExternalKeyboardConnected();

        void onExternalKeyboardDisconnected();
    }

    private void notifyListeners() {
        for (OnExternalKeyboardConnectedListener onExternalKeyboardConnectedListener : this.listeners) {
            if (this.isExternalKeyboardConnected) {
                onExternalKeyboardConnectedListener.onExternalKeyboardConnected();
            } else {
                onExternalKeyboardConnectedListener.onExternalKeyboardDisconnected();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnected() {
        this.isExternalKeyboardConnected = true;
        notifyListeners();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDisconnected() {
        this.isExternalKeyboardConnected = false;
        notifyListeners();
    }

    public void addListener(OnExternalKeyboardConnectedListener onExternalKeyboardConnectedListener) {
        Logger.m10999d(TAG, "addOnExternalKeyboardListener# " + onExternalKeyboardConnectedListener.hashCode());
        if (this.listeners.contains(onExternalKeyboardConnectedListener)) {
            return;
        }
        this.listeners.add(onExternalKeyboardConnectedListener);
    }

    public void onAttachView(Activity activity) {
        final Context applicationContext = activity.getApplicationContext();
        this.inputManager = (InputManager) applicationContext.getSystemService("input");
        InputManager.InputDeviceListener inputDeviceListener = new InputManager.InputDeviceListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ExternalKeyboardManager.1
            @Override // android.hardware.input.InputManager.InputDeviceListener
            public void onInputDeviceAdded(int i) {
                AbstractC0000a.m3D(i, "onInputDeviceAdded# ", ExternalKeyboardManager.TAG);
                if (ExternalKeyboardManager.this.isExternalKeyboardConnected || !KeyboardUtils.INSTANCE.isExternalKeyboardConnected(applicationContext)) {
                    return;
                }
                ExternalKeyboardManager.this.onConnected();
            }

            @Override // android.hardware.input.InputManager.InputDeviceListener
            public void onInputDeviceChanged(int i) {
                AbstractC0000a.m3D(i, "onInputDeviceChanged# ", ExternalKeyboardManager.TAG);
                if (!ExternalKeyboardManager.this.isExternalKeyboardConnected && KeyboardUtils.INSTANCE.isExternalKeyboardConnected(applicationContext)) {
                    ExternalKeyboardManager.this.onConnected();
                } else {
                    if (!ExternalKeyboardManager.this.isExternalKeyboardConnected || KeyboardUtils.INSTANCE.isExternalKeyboardConnected(applicationContext)) {
                        return;
                    }
                    ExternalKeyboardManager.this.onDisconnected();
                }
            }

            @Override // android.hardware.input.InputManager.InputDeviceListener
            public void onInputDeviceRemoved(int i) {
                AbstractC0000a.m3D(i, "onInputDeviceRemoved# ", ExternalKeyboardManager.TAG);
                if (!ExternalKeyboardManager.this.isExternalKeyboardConnected || KeyboardUtils.INSTANCE.isExternalKeyboardConnected(applicationContext)) {
                    return;
                }
                ExternalKeyboardManager.this.onDisconnected();
            }
        };
        this.deviceListener = inputDeviceListener;
        this.inputManager.registerInputDeviceListener(inputDeviceListener, null);
        this.isExternalKeyboardConnected = KeyboardUtils.INSTANCE.isExternalKeyboardConnected(applicationContext);
    }

    public void onDetachView() {
        InputManager.InputDeviceListener inputDeviceListener;
        this.listeners.clear();
        InputManager inputManager = this.inputManager;
        if (inputManager != null && (inputDeviceListener = this.deviceListener) != null) {
            inputManager.unregisterInputDeviceListener(inputDeviceListener);
        }
        this.inputManager = null;
        this.deviceListener = null;
    }

    public void removeListener(OnExternalKeyboardConnectedListener onExternalKeyboardConnectedListener) {
        Logger.m10999d(TAG, "removeOnExternalKeyboardListener# " + onExternalKeyboardConnectedListener.hashCode());
        this.listeners.remove(onExternalKeyboardConnectedListener);
    }
}
