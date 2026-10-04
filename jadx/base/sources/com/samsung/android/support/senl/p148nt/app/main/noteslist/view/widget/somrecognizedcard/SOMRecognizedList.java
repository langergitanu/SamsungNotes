package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.widget.somrecognizedcard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.SOMRecognizedInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.widget.somrecognizedcard.component.SOMRecognizedItem;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.widget.somrecognizedcard.component.StaggeredGridLayout;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SOMRecognizedList extends FrameLayout implements View.OnTouchListener, SOMRecognizedItem.Contract {
    private static final long LIST_CONTAINER_HEIGHT_UPDATE_DURATION = 400;
    private static final String TAG = "SOMRecognizedList";
    private int mCachedExpandedHeight;
    private Contract mContract;
    private boolean mIsNotifyPended;
    private ValueAnimator mListAnimator;
    private final Object mNotifyPendedMutex;
    private View mRecognizeListInputConsumer;
    private StaggeredGridLayout mSOMRecognizedItemList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        int getNoteListHeight();

        List<SOMRecognizedInfo> getSOMRecognizedInfo();

        boolean isNotifyPendingRequired();

        void onNoteSelectedBySOMRecognizedCard(String str, int i);
    }

    public SOMRecognizedList(@NonNull Context context) {
        super(context);
        this.mNotifyPendedMutex = new Object();
        this.mCachedExpandedHeight = -1;
        initLayout(context);
    }

    private void addItem(SOMRecognizedInfo sOMRecognizedInfo) {
        SOMRecognizedItem sOMRecognizedItem = new SOMRecognizedItem(getContext());
        sOMRecognizedItem.setTag(sOMRecognizedInfo.getUuid());
        sOMRecognizedItem.decorate(sOMRecognizedInfo);
        sOMRecognizedItem.setContract(this);
        this.mSOMRecognizedItemList.addItem(sOMRecognizedItem);
    }

    private int getExpandedListHeight() {
        if (this.mSOMRecognizedItemList.getChildCount() <= 0) {
            return 0;
        }
        int i = this.mCachedExpandedHeight;
        if (i != -1) {
            return i;
        }
        int maxRowHeight = this.mSOMRecognizedItemList.getMaxRowHeight() + getResources().getDimensionPixelSize(C8003R.dimen.som_recognized_card_list_padding_bottom);
        this.mCachedExpandedHeight = maxRowHeight;
        return maxRowHeight;
    }

    private List<SOMRecognizedInfo> getSOMRecognizedInfo() {
        Contract contract = this.mContract;
        return contract == null ? Collections.EMPTY_LIST : contract.getSOMRecognizedInfo();
    }

    private void initLayout(Context context) {
        LayoutInflater.from(context).inflate(C8003R.layout.som_recognized_list, (ViewGroup) this, true);
        this.mSOMRecognizedItemList = (StaggeredGridLayout) findViewById(C8003R.id.som_recognized_item_list);
        View viewFindViewById = findViewById(C8003R.id.som_recognized_item_list_input_consumer);
        this.mRecognizeListInputConsumer = viewFindViewById;
        viewFindViewById.setOnTouchListener(this);
    }

    private boolean isNotifyPendingRequired() {
        Contract contract = this.mContract;
        if (contract == null) {
            return false;
        }
        return contract.isNotifyPendingRequired();
    }

    private void updateItemSelectedState(SOMRecognizedInfo sOMRecognizedInfo, boolean z) {
        if (sOMRecognizedInfo.isSelected() == z) {
            return;
        }
        sOMRecognizedInfo.setIsSelected(z);
        ((SOMRecognizedItem) this.mSOMRecognizedItemList.findViewWithTag(sOMRecognizedInfo.getUuid())).decorateSelectedState(sOMRecognizedInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayoutHeight(@NotesConstants.SOMRecognizedCardShape int i) {
        if (i == 0) {
            updateListHeight(0);
            updateListContainerHeight(0);
        } else {
            updateListHeight(-2);
            updateListContainerHeight(-2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateListContainerHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null || layoutParams.height == i) {
            return;
        }
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    private void updateListHeight(int i) {
        ViewGroup.LayoutParams layoutParams = this.mSOMRecognizedItemList.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.height = i;
        this.mSOMRecognizedItemList.setLayoutParams(layoutParams);
    }

    private void updateListSpan() {
        StaggeredGridLayout staggeredGridLayout = this.mSOMRecognizedItemList;
        if (staggeredGridLayout == null) {
            return;
        }
        staggeredGridLayout.updateSpan();
        this.mCachedExpandedHeight = -1;
        updateSOMRecognizedInfo(true);
    }

    public void animateLayoutHeight(@NotesConstants.SOMRecognizedCardShape int i, @NotesConstants.SOMRecognizedCardShape final int i2) {
        if (this.mContract == null) {
            updateLayoutHeight(i2);
            return;
        }
        ValueAnimator valueAnimator = this.mListAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        updateListHeight(-2);
        int expandedListHeight = getExpandedListHeight();
        int noteListHeight = this.mContract.getNoteListHeight();
        final int iMin = i == 0 ? 0 : Math.min(noteListHeight, expandedListHeight);
        final int iMin2 = i2 != 0 ? Math.min(noteListHeight, expandedListHeight) : 0;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(iMin, iMin2, "animateLayoutHeight, startHeight: ", ", endHeight: ", ", noteListHeight: ");
        sbM1173s.append(noteListHeight);
        sbM1173s.append(", cardListHeight: ");
        sbM1173s.append(expandedListHeight);
        MainLogger.m7258i(TAG, sbM1173s.toString());
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mListAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.4f, 0.6f, 0.0f, 1.0f));
        this.mListAnimator.setDuration(400L);
        this.mListAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.somrecognizedcard.SOMRecognizedList.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator2) {
                float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                SOMRecognizedList.this.updateListContainerHeight((int) ((fFloatValue * (iMin2 - r0)) + iMin));
            }
        });
        this.mListAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.somrecognizedcard.SOMRecognizedList.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SOMRecognizedList.this.updateLayoutHeight(i2);
                SOMRecognizedList.this.mListAnimator = null;
            }
        });
        this.mListAnimator.start();
    }

    public void handlePendedNotify(String str, boolean z) {
        synchronized (this.mNotifyPendedMutex) {
            if (!z) {
                try {
                    if (isNotifyPendingRequired()) {
                        MainLogger.m7259w(TAG, "handlePendedNotify, ignore, card collapsed, isNotifyPended: " + this.mIsNotifyPended + ", caller: " + str);
                        return;
                    }
                    if (!this.mIsNotifyPended) {
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            MainLogger.m7258i(TAG, "handlePendedNotify, caller: " + str);
            this.mIsNotifyPended = false;
            requestFocus();
            notifyDataSetChanged();
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.somrecognizedcard.component.SOMRecognizedItem.Contract
    public boolean isSelectedHolder(String str) {
        List<SOMRecognizedInfo> sOMRecognizedInfo = getSOMRecognizedInfo();
        if (sOMRecognizedInfo == null) {
            return false;
        }
        for (SOMRecognizedInfo sOMRecognizedInfo2 : sOMRecognizedInfo) {
            if (str.equals(sOMRecognizedInfo2.getUuid())) {
                return sOMRecognizedInfo2.isSelected();
            }
        }
        return false;
    }

    public synchronized void notifyDataSetChanged() {
        List<SOMRecognizedInfo> sOMRecognizedInfo = getSOMRecognizedInfo();
        if (sOMRecognizedInfo == null) {
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(sOMRecognizedInfo);
        this.mCachedExpandedHeight = -1;
        this.mSOMRecognizedItemList.removeAllItems();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            addItem((SOMRecognizedInfo) it.next());
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateListSpan();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.somrecognizedcard.component.SOMRecognizedItem.Contract
    public void onNoteSelected(String str, int i) {
        if (this.mContract == null) {
            return;
        }
        MainLogger.m7259w(TAG, "onNoteSelected, uuid: " + str + ", toolType: " + i);
        this.mContract.onNoteSelectedBySOMRecognizedCard(str, i);
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_SCREEN_OFF_MEMO_FOLDER, NotesSAConstants.EVENT_SCREEN_OFF_MEMO_VIEW_RECENT_MEMOS_AS_TEXT_OPEN);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View view, MotionEvent motionEvent) {
        return view.getId() == C8003R.id.som_recognized_item_list_input_consumer;
    }

    public void setContract(Contract contract) {
        this.mContract = contract;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.somrecognizedcard.component.SOMRecognizedItem.Contract
    public void setSelectedState(String str, boolean z) {
        synchronized (this.mNotifyPendedMutex) {
            try {
                List<SOMRecognizedInfo> sOMRecognizedInfo = getSOMRecognizedInfo();
                if (sOMRecognizedInfo == null) {
                    return;
                }
                for (SOMRecognizedInfo sOMRecognizedInfo2 : sOMRecognizedInfo) {
                    if (sOMRecognizedInfo2.getUuid().equals(str)) {
                        updateItemSelectedState(sOMRecognizedInfo2, z);
                    } else {
                        updateItemSelectedState(sOMRecognizedInfo2, false);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void updateLayout(@NotesConstants.SOMRecognizedCardShape int i) {
        updateLayoutHeight(i);
    }

    public void updateRunningState(boolean z) {
        if (z) {
            this.mRecognizeListInputConsumer.setVisibility(0);
        } else {
            this.mRecognizeListInputConsumer.setVisibility(8);
            handlePendedNotify("updateRunningState", true);
        }
    }

    public void updateSOMRecognizedInfo() {
        updateSOMRecognizedInfo(false);
    }

    public void updateSOMRecognizedInfo(boolean z) {
        synchronized (this.mNotifyPendedMutex) {
            try {
                List<SOMRecognizedInfo> sOMRecognizedInfo = getSOMRecognizedInfo();
                if (sOMRecognizedInfo == null) {
                    return;
                }
                MainLogger.m7259w(TAG, "updateSOMRecognizedInfo, size: " + sOMRecognizedInfo.size());
                if (z || !isNotifyPendingRequired()) {
                    requestFocus();
                    notifyDataSetChanged();
                } else {
                    MainLogger.m7259w(TAG, "updateSOMRecognizedInfo, pending notify");
                    this.mIsNotifyPended = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public SOMRecognizedList(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mNotifyPendedMutex = new Object();
        this.mCachedExpandedHeight = -1;
        initLayout(context);
    }

    public SOMRecognizedList(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNotifyPendedMutex = new Object();
        this.mCachedExpandedHeight = -1;
        initLayout(context);
    }
}
