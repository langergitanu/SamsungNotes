package com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.model;

import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.HashTagHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CandidateTagData {
    private boolean mSelected;
    private String mTitle;
    private int mType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Type {
        public static final int USER = 0;
    }

    public CandidateTagData(String str, boolean z) {
        init(str, 0, z);
    }

    private void init(String str, int i, boolean z) {
        this.mTitle = !TextUtils.isEmpty(str) ? removeSymbol(str) : "";
        this.mType = i;
        this.mSelected = z;
    }

    private String removeSymbol(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!HashTagHelper.isSpecialCharacter(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof CandidateTagData) && this.mTitle.equalsIgnoreCase(((CandidateTagData) obj).getTitle())) {
            return true;
        }
        return super.equals(obj);
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int getType() {
        return this.mType;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isSelected() {
        return this.mSelected;
    }

    public void setSelected(boolean z) {
        this.mSelected = z;
    }

    public CandidateTagData(String str, int i, boolean z) {
        init(str, i, z);
    }
}
