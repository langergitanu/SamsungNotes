package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NoteInfoViewManager {
    private final View mContainer;
    private final Contract mContract;
    private final TextView mCreatedTimeView;
    private final TextView mCreatorView;
    private final TextView mModifiedTimeView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        AppCompatActivity getActivity();

        TitleEditorPresenter getPresenter();
    }

    public NoteInfoViewManager(View view, Contract contract) {
        this.mContract = contract;
        this.mContainer = view;
        this.mModifiedTimeView = (TextView) view.findViewById(C9086R.id.comp_title_modified_time_text);
        this.mCreatedTimeView = (TextView) view.findViewById(C9086R.id.comp_title_created_time_text);
        this.mCreatorView = (TextView) view.findViewById(C9086R.id.comp_title_mde_creator);
    }

    public void initInfoTextViews() {
        this.mModifiedTimeView.setText(this.mContract.getPresenter().getModifiedTime());
        this.mCreatedTimeView.setText(this.mContract.getPresenter().getCreatedTime());
    }

    public void setCreatedTime(String str) {
        TextView textView = this.mCreatedTimeView;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setModifiedTime(String str) {
        TextView textView = this.mModifiedTimeView;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void updateCreator() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.mCreatorView.setText(this.mContract.getPresenter().getCreatorText());
        } else {
            this.mCreatorView.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.NoteInfoViewManager.1
                @Override // java.lang.Runnable
                public void run() {
                    NoteInfoViewManager.this.mCreatorView.setText(NoteInfoViewManager.this.mContract.getPresenter().getCreatorText());
                }
            });
        }
    }

    public void updateInfoContainer() {
        if (this.mContract.getPresenter().initTimeDataOnShow()) {
            this.mCreatedTimeView.setText(this.mContract.getPresenter().getCreatedTime());
            this.mModifiedTimeView.setText(this.mContract.getPresenter().getModifiedTime());
        }
        String createdTime = this.mContract.getPresenter().getCreatedTime();
        String creatorText = this.mContract.getPresenter().getCreatorText();
        if (createdTime == null && creatorText == null) {
            this.mContainer.setVisibility(8);
            return;
        }
        this.mContainer.setVisibility(0);
        if (createdTime == null) {
            this.mCreatedTimeView.setVisibility(8);
            this.mModifiedTimeView.setVisibility(8);
        } else {
            this.mCreatedTimeView.setVisibility(0);
            this.mModifiedTimeView.setVisibility(0);
        }
        if (creatorText == null) {
            this.mCreatorView.setVisibility(8);
            return;
        }
        this.mCreatorView.setVisibility(0);
        if (TextUtils.isEmpty(creatorText)) {
            return;
        }
        this.mCreatorView.setText(creatorText);
    }
}
