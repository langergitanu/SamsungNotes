package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.widget.somrecognizedcard.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.SOMRecognizedInfo;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SOMRecognizedItem extends FrameLayout implements View.OnClickListener, View.OnTouchListener {
    private ImageView mArrowNoteSelectView;
    private Contract mContract;
    private View mDateDummyView;
    private TextView mDateView;
    private SOMRecognizedInfoTextView mInfoView;
    private int mToolType;
    private String mUuid;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        boolean isSelectedHolder(String str);

        void onNoteSelected(String str, int i);

        void setSelectedState(String str, boolean z);
    }

    public SOMRecognizedItem(@NonNull Context context) {
        super(context);
        this.mToolType = 1;
        init(context);
    }

    private void init(@NonNull Context context) {
        LayoutInflater.from(context).inflate(C8003R.layout.som_recognized_item_view, (ViewGroup) this, true);
        setOnClickListener(this);
        setOnTouchListener(this);
        SOMRecognizedInfoTextView sOMRecognizedInfoTextView = (SOMRecognizedInfoTextView) findViewById(C8003R.id.som_recognized_item_info_view);
        this.mInfoView = sOMRecognizedInfoTextView;
        sOMRecognizedInfoTextView.setOnTouchListener(this);
        this.mDateView = (TextView) findViewById(C8003R.id.som_recognized_item_date_view);
        this.mDateDummyView = findViewById(C8003R.id.som_recognized_item_date_dummy_view);
        ImageView imageView = (ImageView) findViewById(C8003R.id.som_recognized_item_note_select);
        this.mArrowNoteSelectView = imageView;
        imageView.setOnClickListener(this);
        String string = getResources().getString(C8003R.string.som_recognized_item_open_note);
        this.mArrowNoteSelectView.setContentDescription(string);
        ViewCompat.getInstance().setTooltipText(this.mArrowNoteSelectView, string);
    }

    private boolean isSelectedHolder(String str) {
        Contract contract = this.mContract;
        if (contract == null) {
            return false;
        }
        return contract.isSelectedHolder(str);
    }

    private void onNoteSelected() {
        Contract contract = this.mContract;
        if (contract == null) {
            return;
        }
        contract.onNoteSelected(this.mUuid, this.mToolType);
    }

    private void setSelectedState(String str, boolean z) {
        Contract contract = this.mContract;
        if (contract == null) {
            return;
        }
        contract.setSelectedState(str, z);
    }

    public void decorate(SOMRecognizedInfo sOMRecognizedInfo) {
        this.mUuid = sOMRecognizedInfo.getUuid();
        this.mInfoView.setText(sOMRecognizedInfo.getTextInfo());
        TextView textView = this.mDateView;
        textView.setText(ContentUtils.getDate(textView.getContext(), sOMRecognizedInfo.getLastModifiedTime()));
        decorateSelectedState(sOMRecognizedInfo);
    }

    public void decorateSelectedState(SOMRecognizedInfo sOMRecognizedInfo) {
        boolean zIsSelected = sOMRecognizedInfo.isSelected();
        setSelected(sOMRecognizedInfo.isSelected());
        this.mDateView.setVisibility(zIsSelected ? 8 : 0);
        this.mDateDummyView.setVisibility(zIsSelected ? 8 : 0);
        this.mArrowNoteSelectView.setVisibility(zIsSelected ? 0 : 4);
        this.mArrowNoteSelectView.setRotation(LocaleUtils.isRTLMode() ? 180.0f : 0.0f);
    }

    public boolean hasTextSelection() {
        return this.mInfoView.hasSelection();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C8003R.id.som_recognized_item_note_select) {
            setSelectedState(this.mUuid, false);
            onNoteSelected();
        } else {
            if (hasTextSelection()) {
                return;
            }
            setSelectedState(this.mUuid, !isSelectedHolder(this.mUuid));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        int id = view.getId();
        int action = motionEvent.getAction();
        if (action == 1) {
            this.mToolType = motionEvent.getToolType(motionEvent.getPointerCount() - 1);
        } else if (action == 0 && 3 == motionEvent.getToolType(motionEvent.getPointerCount() - 1)) {
            this.mToolType = 3;
        }
        if (id == C8003R.id.som_recognized_item_info_view) {
            if (motionEvent.getButtonState() != 32 && motionEvent.getButtonState() != 64) {
                onTouchEvent(motionEvent);
            } else if (isPressed()) {
                motionEvent.setAction(3);
                view.clearFocus();
                onTouchEvent(motionEvent);
            }
        }
        return false;
    }

    public void setContract(Contract contract) {
        this.mContract = contract;
    }

    public SOMRecognizedItem(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mToolType = 1;
        init(context);
    }

    public SOMRecognizedItem(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mToolType = 1;
        init(context);
    }
}
