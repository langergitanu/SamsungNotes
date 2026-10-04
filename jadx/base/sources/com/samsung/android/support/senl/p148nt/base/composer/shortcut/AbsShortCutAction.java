package com.samsung.android.support.senl.p148nt.base.composer.shortcut;

import android.view.KeyEvent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsShortCutAction {
    static int META_STATE_BIN_BEGIN = 9;
    protected long mKey;
    Shortcut mShortcut;

    public AbsShortCutAction() {
    }

    public static long convertKey(KeyEvent keyEvent) {
        return (((long) createMetaState(keyEvent.isCtrlPressed(), (keyEvent.getMetaState() & 16) != 0, keyEvent.isShiftPressed())) << META_STATE_BIN_BEGIN) + ((long) keyEvent.getKeyCode());
    }

    public static int createMetaState(boolean z, boolean z2, boolean z3) {
        return (z ? 4096 : 0) | (z2 ? 16 : 0) | (z3 ? 1 : 0);
    }

    public boolean doAction() {
        return false;
    }

    public long getKey() {
        return this.mKey;
    }

    public int getKeyCode() {
        return this.mShortcut.getKeyCode();
    }

    public boolean isBLEEvent(KeyEvent keyEvent) {
        return (keyEvent.getFlags() & 33554432) != 0;
    }

    public boolean isEditType() {
        return this.mShortcut.getEditType();
    }

    public void setKey() {
        this.mKey = (((long) this.mShortcut.getMetaState()) << META_STATE_BIN_BEGIN) + ((long) this.mShortcut.getKeyCode());
    }

    public void setShortcut(Shortcut shortcut) {
        this.mShortcut = shortcut;
        setKey();
    }

    public AbsShortCutAction(Shortcut shortcut) {
        this.mShortcut = shortcut;
        setKey();
    }

    public boolean doAction(KeyEvent keyEvent) {
        return doAction();
    }
}
