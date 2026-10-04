package com.samsung.android.support.senl.p148nt.app.main.common.hashtag;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.flexbox.FlexboxLayout;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class HashTagListLayout extends FlexboxLayout implements View.OnClickListener {
    private Contract mContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        boolean isSelectedTag(String str);

        void onTagSelected(String str);
    }

    public HashTagListLayout(Context context) {
        super(context);
        init();
    }

    private void addHashTagItem(String str) {
        boolean z = false;
        View viewInflate = LayoutInflater.from(getContext()).inflate(C8003R.layout.flexbox_tag_item, (ViewGroup) this, false);
        String lowerCase = str.toLowerCase();
        viewInflate.setTag(lowerCase);
        viewInflate.setOnClickListener(this);
        TextView textView = (TextView) viewInflate.findViewById(C8003R.id.tag_item_text);
        textView.setText(ContentUtils.convertTagText(str));
        CharUtils.applyTextSizeUntilLargeSize(getContext(), textView, 14.0f);
        Contract contract = this.mContract;
        if (contract != null && contract.isSelectedTag(lowerCase)) {
            z = true;
        }
        viewInflate.setSelected(z);
        addView(viewInflate);
    }

    private void init() {
        setFlexWrap(1);
        setJustifyContent(0);
        setFlexDirection(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NonNull View view) {
        String str = (String) view.getTag();
        view.setSelected(!view.isSelected());
        Contract contract = this.mContract;
        if (contract == null) {
            return;
        }
        contract.onTagSelected(str);
    }

    public void reloadTags(List<String> list) {
        if (list == null) {
            return;
        }
        removeAllViews();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            addHashTagItem(it.next());
        }
    }

    public void setContract(Contract contract) {
        this.mContract = contract;
    }

    public HashTagListLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public HashTagListLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
