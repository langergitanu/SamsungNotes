package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut.keyshortcut;

import android.app.Activity;
import android.view.KeyboardShortcutGroup;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotEditKeyboardShortcutManager extends KeyboardShortcutManager {
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut.keyshortcut.KeyboardShortcutManager
    public KeyboardShortcutGroup getKeyboardShortcutGroup(Activity activity, boolean z, Mode mode) {
        ArrayList arrayList = new ArrayList();
        initFind(activity, arrayList);
        return new KeyboardShortcutGroup(activity.getResources().getString(C9086R.string.app_name), arrayList);
    }
}
