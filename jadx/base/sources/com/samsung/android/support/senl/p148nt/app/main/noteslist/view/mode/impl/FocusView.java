package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.FocusViewParams;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FocusView {
    private final Contract mContract;
    private FocusViewParams mFocusViewParams = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        Toolbar getToolbar();
    }

    public FocusView(Contract contract) {
        this.mContract = contract;
    }

    public void checkFocus(String str) {
        if (hasFocusViewParams() && hasFocus(str)) {
            if (this.mFocusViewParams.hasSearchFocusType()) {
                onFocusSearchView(this.mContract.getToolbar());
            }
            releaseFocusViewParams();
        }
    }

    public boolean hasFocus(String str) {
        FocusViewParams focusViewParams = this.mFocusViewParams;
        return focusViewParams != null && focusViewParams.hasFocus(str);
    }

    public boolean hasFocusViewParams() {
        return this.mFocusViewParams != null;
    }

    public void onFocusSearchView(final Toolbar toolbar) {
        if (toolbar == null) {
            return;
        }
        toolbar.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.FocusView.1
            @Override // java.lang.Runnable
            public void run() {
                View viewFindViewById = toolbar.findViewById(C8003R.id.action_search);
                if (viewFindViewById == null) {
                    return;
                }
                viewFindViewById.sendAccessibilityEvent(128);
                viewFindViewById.requestFocus();
            }
        });
    }

    public void releaseFocusViewParams() {
        this.mFocusViewParams = null;
    }

    public void setSearchFocus(int i, String str) {
        if (FeatureUtils.isSearchMode(i)) {
            this.mFocusViewParams = new FocusViewParams.FocusViewParamsBuilder().setFolderUuid(str).setFocusType(FocusViewParams.FocusViewParamsBuilder.FocusType.SEARCH).build();
        }
    }

    public void updateFocus(String str) {
        if (!hasFocusViewParams() || hasFocus(str)) {
            return;
        }
        releaseFocusViewParams();
    }
}
