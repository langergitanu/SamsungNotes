package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite;

import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DirectWriteManager {
    ArrayList<ISaveInstance> mSaveInstance;
    DirectWriteEnableStateData mDirectWriteEnableStateData = new DirectWriteEnableStateData();
    DirectWriteTextTypeData mDirectWriteTextTypeData = new DirectWriteTextTypeData();
    DirectWriteLanguageData mDirectWriteLanguageData = new DirectWriteLanguageData();

    public DirectWriteManager() {
        ArrayList<ISaveInstance> arrayList = new ArrayList<>();
        this.mSaveInstance = arrayList;
        arrayList.add(this.mDirectWriteEnableStateData);
    }

    public boolean getDirectWriteEnableState() {
        return this.mDirectWriteEnableStateData.getValue().booleanValue();
    }

    public String getDirectWriteLanguage() {
        return this.mDirectWriteLanguageData.getValue();
    }

    public int getDirectWriteTextType() {
        return this.mDirectWriteTextTypeData.getValue().intValue();
    }

    public String getKeyboardLanguage() {
        return this.mDirectWriteLanguageData.getKeyboardLanguage();
    }

    public boolean isLanguageMatched() {
        return this.mDirectWriteLanguageData.isLanguageMatched();
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Iterator<ISaveInstance> it = this.mSaveInstance.iterator();
        while (it.hasNext()) {
            it.next().onSaveInstanceState(bundle);
        }
    }

    public void restoreState(Bundle bundle) {
        Iterator<ISaveInstance> it = this.mSaveInstance.iterator();
        while (it.hasNext()) {
            it.next().restoreState(bundle);
        }
    }

    public void setDirectWriteEnableState(boolean z) {
        this.mDirectWriteEnableStateData.setValue(Boolean.valueOf(z));
    }

    public void setDirectWriteLanguage(String str) {
        this.mDirectWriteLanguageData.setValue(str);
    }

    public void setDirectWriteTextType(int i) {
        this.mDirectWriteTextTypeData.setValue(Integer.valueOf(i));
    }

    public void setKeyboardLanguage(String str) {
        this.mDirectWriteLanguageData.setKeyboardLanguage(str);
    }

    public void setLanguageMatching(boolean z) {
        this.mDirectWriteLanguageData.setLanguageMatching(z);
    }
}
