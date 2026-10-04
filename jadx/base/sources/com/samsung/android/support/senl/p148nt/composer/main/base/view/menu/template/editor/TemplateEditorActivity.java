package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.editor;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TemplateEditorActivity extends AppCompatActivity {
    private void initToolbar() {
        setTitle(C9086R.string.template_editor_title_adjust_image);
        setSupportActionBar((Toolbar) findViewById(C9086R.id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(TemplateEditorView.TAG);
        if (fragmentFindFragmentByTag != null && fragmentFindFragmentByTag.isAdded()) {
            ((TemplateEditorView) fragmentFindFragmentByTag).dispatchGenericMotionEvent(motionEvent);
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(TemplateEditorView.TAG);
        if (fragmentFindFragmentByTag == null || !fragmentFindFragmentByTag.isAdded()) {
            return;
        }
        ((TemplateEditorView) fragmentFindFragmentByTag).onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C9086R.layout.template_editor_layout);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        String str = TemplateEditorView.TAG;
        if (supportFragmentManager.findFragmentByTag(str) == null) {
            supportFragmentManager.beginTransaction().add(C9086R.id.fragment_container, new TemplateEditorView(), str).commitAllowingStateLoss();
        }
        initToolbar();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(TemplateEditorView.TAG);
        if (fragmentFindFragmentByTag != null && fragmentFindFragmentByTag.isAdded()) {
            ((TemplateEditorView) fragmentFindFragmentByTag).onKeyDown(keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(TemplateEditorView.TAG);
        if (fragmentFindFragmentByTag != null && fragmentFindFragmentByTag.isAdded()) {
            ((TemplateEditorView) fragmentFindFragmentByTag).onKeyUp();
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        WindowManagerCompat.getInstance().disableSystemBarInsets(findViewById(C9086R.id.template_editor_container));
    }
}
