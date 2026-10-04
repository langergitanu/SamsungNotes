package com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import androidx.viewpager.widget.PagerAdapter;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.view.TipCardView;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCardProgress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p066P2.C0200b;
import p066P2.RunnableC0201c;
import p066P2.RunnableC0202d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TipCardAdapter extends PagerAdapter {
    private TipCardView.Contract mContract;
    private final String TAG = "TipCardAdapter";
    private final ArrayList<TipCard> mTipCardList = new ArrayList<>();
    private final Map<Integer, TipCardView> mTipCardViews = new HashMap();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AddTipCardCallback {
        void onSuccess(int i);
    }

    private int addTipCardInternal(TipCard tipCard) {
        synchronized (this.mTipCardList) {
            if (tipCard != null) {
                try {
                    if (!isContainedTipCard(tipCard.getType())) {
                        MainLogger.m7258i("TipCardAdapter", "addTipCard# type : " + tipCard.getType());
                        this.mTipCardList.add(0, tipCard);
                        Collections.sort(this.mTipCardList);
                        notifyDataSetChanged();
                        return this.mTipCardList.indexOf(tipCard);
                    }
                } finally {
                }
            }
            return -1;
        }
    }

    private void clearTipCardInternal(boolean z) {
        synchronized (this.mTipCardList) {
            try {
                MainLogger.m7254d("TipCardAdapter", "clearTipCardInternal# TipCard size : " + this.mTipCardList.size() + ", isExcludeProgressTipCard : " + z);
                if (this.mTipCardList.isEmpty()) {
                    return;
                }
                if (z) {
                    ArrayList arrayList = new ArrayList();
                    int size = this.mTipCardList.size();
                    for (int i = 0; i < size; i++) {
                        if (!this.mTipCardList.get(i).isProgressTipCard()) {
                            arrayList.add(this.mTipCardList.get(i));
                        }
                    }
                    this.mTipCardList.removeAll(arrayList);
                } else {
                    this.mTipCardList.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private TipCard getTipCardIndexFromType(int i) {
        synchronized (this.mTipCardList) {
            try {
                for (TipCard tipCard : this.mTipCardList) {
                    if (tipCard.getType() == i) {
                        return tipCard;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private TipCardView getTipCardView(Context context, TipCard tipCard) {
        TipCardView tipCardView = this.mTipCardViews.get(Integer.valueOf(tipCard.hashCode()));
        if (tipCardView != null) {
            return tipCardView;
        }
        TipCardView tipCardView2 = new TipCardView(context, tipCard);
        tipCardView2.setContract(this.mContract);
        this.mTipCardViews.put(Integer.valueOf(tipCard.hashCode()), tipCardView2);
        return tipCardView2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addTipCard$0(TipCard tipCard, AddTipCardCallback addTipCardCallback) {
        int iAddTipCardInternal = addTipCardInternal(tipCard);
        if (iAddTipCardInternal < 0) {
            return;
        }
        addTipCardCallback.onSuccess(iAddTipCardInternal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearTipCard$3(boolean z, Runnable runnable) {
        clearTipCardInternal(z);
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeTipCard$1(List list, Runnable runnable) {
        removeTipCardInternal(list);
        runnable.run();
    }

    private void removeTipCardInternal(List<Integer> list) {
        synchronized (this.mTipCardList) {
            try {
                if (list == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                int size = this.mTipCardList.size();
                for (int i = 0; i < size; i++) {
                    if (list.contains(Integer.valueOf(this.mTipCardList.get(i).getType()))) {
                        arrayList.add(this.mTipCardList.get(i));
                    }
                }
                MainLogger.m7258i("TipCardAdapter", "removeTipCard# type " + list + ", removingTipCard : " + Arrays.toString(arrayList.stream().map(new C0200b(0)).toArray()) + ", TipCardList : " + Arrays.toString(this.mTipCardList.stream().map(new C0200b(0)).toArray()));
                if (arrayList.isEmpty()) {
                    return;
                }
                this.mTipCardList.removeAll(arrayList);
                MainLogger.m7258i("TipCardAdapter", "removeTipCard# type " + list + ", remainedTipCardList : " + Arrays.toString(this.mTipCardList.stream().map(new C0200b(0)).toArray()));
                notifyDataSetChanged();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: updateProgressInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$updateProgress$2(int i, int i2, int i4, int i5, int i6) {
        synchronized (this.mTipCardList) {
            try {
                TipCard tipCardIndexFromType = getTipCardIndexFromType(i);
                if (tipCardIndexFromType == null) {
                    return;
                }
                ((TipCardProgress) tipCardIndexFromType).setProgressInfo(i2, i4, i5);
                ((TipCardProgress) tipCardIndexFromType).setState(i6);
                TipCardView tipCardView = this.mTipCardViews.get(Integer.valueOf(tipCardIndexFromType.hashCode()));
                if (tipCardView != null) {
                    ((TipCardProgress) tipCardView.getTipCard()).setProgressInfo(i2, i4, i5);
                    ((TipCardProgress) tipCardView.getTipCard()).setState(i6);
                    tipCardView.updateLayout();
                } else {
                    notifyDataSetChanged();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addTipCard(TipCard tipCard, AddTipCardCallback addTipCardCallback) {
        this.mUiHandler.post(new RunnableC0201c(this, 1, tipCard, addTipCardCallback));
    }

    public void clearTipCard(boolean z, Runnable runnable) {
        this.mUiHandler.post(new RunnableC0202d(this, z, runnable, 0));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        int size;
        synchronized (this.mTipCardList) {
            size = this.mTipCardList.size();
        }
        return size;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return ((obj instanceof TipCard) && ((TipCard) obj).isProgressTipCard()) ? -1 : -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        TipCardView tipCardView;
        synchronized (this.mTipCardList) {
            try {
                TipCard tipCard = this.mTipCardList.get(i);
                int iIndexOf = this.mTipCardList.indexOf(tipCard);
                MainLogger.m7258i("TipCardAdapter", "instantiateItem# sortedPosition : " + iIndexOf + " type: " + tipCard.getType());
                tipCardView = getTipCardView(viewGroup.getContext(), tipCard);
                tipCardView.updateLayout();
                tipCardView.setPageTag(iIndexOf);
                if (tipCardView.getParent() != null) {
                    ((ViewGroup) tipCardView.getParent()).removeView(tipCardView);
                }
                viewGroup.addView(tipCardView);
            } catch (Throwable th) {
                throw th;
            }
        }
        return tipCardView;
    }

    public boolean isContainedTipCard(int i) {
        synchronized (this.mTipCardList) {
            try {
                Iterator<TipCard> it = this.mTipCardList.iterator();
                while (it.hasNext()) {
                    if (it.next().getType() == i) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view.equals(obj);
    }

    public void removeTipCard(List<Integer> list, Runnable runnable) {
        this.mUiHandler.post(new RunnableC0201c(this, 0, list, runnable));
    }

    public void setTipCardViewContract(TipCardView.Contract contract) {
        this.mContract = contract;
    }

    public void updateProgress(TipCard tipCard) {
        final int type = tipCard.getType();
        if (!tipCard.isProgressTipCard()) {
            MainLogger.m7255e("TipCardAdapter", "updateProgress, tipCard is not progress type: " + type);
            return;
        }
        TipCardProgress tipCardProgress = (TipCardProgress) tipCard;
        final int mTotal = tipCardProgress.getMTotal();
        final int mFinished = tipCardProgress.getMFinished();
        final int failed = tipCardProgress.getFailed();
        final int mState = tipCardProgress.getMState();
        StringBuilder sbM1173s = AbstractC0622a.m1173s(type, mTotal, "updateProgress, TipCard type: ", ", total: ", ", finished: ");
        AbstractC2821a.m2235z(sbM1173s, mFinished, failed, ", failed: ", ", state: ");
        AbstractC8014b.m7212n(sbM1173s, "TipCardAdapter", mState);
        if (mTotal <= 0) {
            return;
        }
        this.mUiHandler.post(new Runnable() { // from class: P2.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f615a.lambda$updateProgress$2(type, mTotal, mFinished, failed, mState);
            }
        });
    }
}
