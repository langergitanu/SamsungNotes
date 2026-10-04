package com.samsung.android.support.senl.p148nt.composer.main.base.sample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ChangeNoteActivity extends AppCompatActivity {
    private static final String TAG = Logger.createTag("BaseComposerActivity");
    BaseComposerFragment mBaseComposerFragment;

    public void initList() {
        final List<MainListDocumentData> all = NotesDataRepositoryFactory.newInstance(this).createMainListDocumentDataRepository().getAll(new SortParam.SortParamBuilder().setSortType(4).setIsDesc(true).build());
        final ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10 && i < all.size(); i++) {
            MainListDocumentData mainListDocumentData = all.get(i);
            arrayList.add(mainListDocumentData.getTitle() + "/" + mainListDocumentData.getUuid());
        }
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.sample.ChangeNoteActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainListDocumentData mainListDocumentData2 = (MainListDocumentData) all.get(((Integer) view.getTag()).intValue());
                ChangeNoteActivity.this.mBaseComposerFragment.changeNote(mainListDocumentData2.getUuid(), mainListDocumentData2.getFilePath());
            }
        };
        ((ListView) getWindow().getDecorView().findViewById(C9086R.id.test_list_view)).setAdapter((ListAdapter) new ArrayAdapter<String>(this, C9086R.layout.comp_listpopupwindow_item, arrayList) { // from class: com.samsung.android.support.senl.nt.composer.main.base.sample.ChangeNoteActivity.2
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            @NonNull
            public View getView(int i2, @Nullable View view, @NonNull ViewGroup viewGroup) {
                RelativeLayout relativeLayout = view instanceof RelativeLayout ? (RelativeLayout) view : (RelativeLayout) LayoutInflater.from(this).inflate(C9086R.layout.comp_listpopupwindow_item, (ViewGroup) null);
                relativeLayout.setTag(Integer.valueOf(i2));
                relativeLayout.setOnClickListener(onClickListener);
                ((TextView) relativeLayout.findViewById(C9086R.id.item_text)).setText((String) arrayList.get(i2));
                return relativeLayout;
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C9086R.layout.activity_composer_sample_change_note);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.mBaseComposerFragment = new BaseComposerFragment();
        supportFragmentManager.beginTransaction().add(C9086R.id.composer_fragment_container, this.mBaseComposerFragment, TAG).commitAllowingStateLoss();
        initList();
    }
}
