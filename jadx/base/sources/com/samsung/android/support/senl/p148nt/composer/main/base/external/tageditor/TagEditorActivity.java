package com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistAsButton;
import com.samsung.android.support.senl.p148nt.base.winset.util.ButtonShapeUtil;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.common.BackgroundUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.common.Utils;
import com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.controller.StateChangeListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.controller.TagEditorController;
import com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.model.CandidateTagData;
import com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.view.TagEditorUI;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TagEditorActivity extends AppCompatActivity implements TagEditorController {
    private static final String TAG = "TagEditorActivity";
    private TagEditorUI mEditorUI;
    private List<StateChangeListener> mStateChangeListener = new ArrayList();
    private StateChangeListener.State mCurrentState = StateChangeListener.State.INITIALIZED;
    private boolean mIsBackPressed = false;
    private TagEditorUI.TagEditorActionListener mActionListener = new TagEditorUI.TagEditorActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.tageditor.TagEditorActivity.1
        @Override // com.samsung.android.support.senl.nt.composer.main.base.external.tageditor.view.TagEditorUI.TagEditorActionListener
        public void onSavePressed(List<CandidateTagData> list) {
            Logger.m10999d(TagEditorActivity.TAG, "onSavePressed: " + list);
            TagEditorActivity tagEditorActivity = TagEditorActivity.this;
            tagEditorActivity.save(tagEditorActivity, list);
        }
    };

    private void notifyStateChanged(StateChangeListener.State state) {
        notifyStateChanged(state, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save(AppCompatActivity appCompatActivity, List<CandidateTagData> list) {
        Intent intent = appCompatActivity.getIntent();
        if (intent == null) {
            intent = new Intent();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (CandidateTagData candidateTagData : list) {
            if (candidateTagData.isSelected()) {
                arrayList.add(candidateTagData.getTitle());
            } else {
                arrayList2.add(candidateTagData.getTitle());
            }
        }
        intent.putStringArrayListExtra(ComposerConstants.INTENT_KEY_RESULT_SELECT_TAGS, arrayList);
        intent.putStringArrayListExtra(ComposerConstants.INTENT_KEY_RESULT_UNSELECT_TAGS, arrayList2);
        appCompatActivity.setResult(-1, intent);
        appCompatActivity.finish();
    }

    public void init() {
        ArrayList<String> stringArrayListExtra;
        Utils.setStatusBarForLandscape(this);
        setContentView(C9086R.layout.activity_tag_board);
        BackgroundUtils.applyBackground(this, getWindow());
        TagEditorUI tagEditorUI = new TagEditorUI(this);
        this.mEditorUI = tagEditorUI;
        tagEditorUI.initView(this, getWindow().getDecorView());
        this.mEditorUI.setActionListener(this.mActionListener);
        Intent intent = getIntent();
        if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra(ComposerConstants.INTENT_KEY_SELECTED_TAG)) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                arrayList.add(new CandidateTagData(it.next(), true));
            }
            TagEditorUI tagEditorUI2 = this.mEditorUI;
            if (tagEditorUI2 != null) {
                tagEditorUI2.initCandidateTagList(arrayList);
            }
        }
        TextView textView = (TextView) findViewById(C9086R.id.btn_save);
        textView.setAccessibilityDelegate(new VoiceAssistAsButton());
        ButtonShapeUtil.setButtonShapeEnabled(textView);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Utils.setStatusBarForLandscape(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        init();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mIsBackPressed) {
            notifyStateChanged(StateChangeListener.State.DESTROYED_WITHOUT_SAVE);
            this.mIsBackPressed = false;
        } else {
            notifyStateChanged(StateChangeListener.State.DESTROYED_WITH_SAVE);
        }
        BackgroundUtils.resetBackground(getWindow());
        TagEditorUI tagEditorUI = this.mEditorUI;
        if (tagEditorUI != null) {
            tagEditorUI.onDestroy();
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.mIsBackPressed = true;
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        notifyStateChanged(StateChangeListener.State.RESUME);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.controller.TagEditorController
    public void registerListener(StateChangeListener stateChangeListener) {
        if (this.mStateChangeListener.contains(stateChangeListener)) {
            return;
        }
        this.mStateChangeListener.add(stateChangeListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.controller.TagEditorController
    public void unregisterListener(StateChangeListener stateChangeListener) {
        if (this.mStateChangeListener.contains(stateChangeListener)) {
            this.mStateChangeListener.remove(stateChangeListener);
        }
    }

    private void notifyStateChanged(StateChangeListener.State state, boolean z) {
        if (!this.mCurrentState.equals(state) || z) {
            this.mCurrentState = state;
            if (this.mStateChangeListener.isEmpty()) {
                return;
            }
            Iterator<StateChangeListener> it = this.mStateChangeListener.iterator();
            while (it.hasNext()) {
                it.next().onStateChanged(state);
            }
        }
    }
}
