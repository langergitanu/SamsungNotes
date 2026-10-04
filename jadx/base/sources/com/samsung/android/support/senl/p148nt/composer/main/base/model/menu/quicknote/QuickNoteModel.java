package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.quicknote;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.SuggestionInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class QuickNoteModel implements Observer {
    private static final String TAG = Logger.createTag("QuickNoteModel");
    private OnUpdateListener mOnUpdateListener;
    private IContextAwarenessResult mResult;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.model.menu.quicknote.QuickNoteModel$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C91531 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$model$contextawareness$common$result$IContextAwarenessResult$Request */
        static final /* synthetic */ int[] f6774xa6a48947;

        static {
            int[] iArr = new int[IContextAwarenessResult.Request.values().length];
            f6774xa6a48947 = iArr;
            try {
                iArr[IContextAwarenessResult.Request.DRAW_SUGGESTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6774xa6a48947[IContextAwarenessResult.Request.ATTACH_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnUpdateListener {
        void onReceivedData(IContextAwarenessResult iContextAwarenessResult);

        void onSuggested(IContextAwarenessResult iContextAwarenessResult);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SuggestedData {
        Set<String> mExcludedIds = new HashSet();
        IContextAwarenessResult mResult;
        List<SuggestionInfo> mSuggestionInfoList;

        public SuggestedData(IContextAwarenessResult iContextAwarenessResult) {
            this.mResult = iContextAwarenessResult;
            this.mSuggestionInfoList = new ArrayList(iContextAwarenessResult.getSuggestionInfoList());
        }

        public void addExcludedIds(List<String> list) {
            this.mExcludedIds.addAll(list);
        }

        public Set<String> getExcludedIds() {
            return this.mExcludedIds;
        }

        public IContextAwarenessResult getResult() {
            return this.mResult;
        }

        public List<SuggestionInfo> getSuggestionInfoList() {
            return this.mSuggestionInfoList;
        }
    }

    public void clear() {
        this.mResult = null;
    }

    public IContextAwarenessResult getResult() {
        return this.mResult;
    }

    public boolean hasResult() {
        IContextAwarenessResult iContextAwarenessResult = this.mResult;
        return (iContextAwarenessResult == null || iContextAwarenessResult.getSuggestionInfoList() == null) ? false : true;
    }

    public boolean isEmptyResult() {
        return !hasResult() || this.mResult.getSuggestionInfoList().isEmpty();
    }

    public void setOnUpdateListener(OnUpdateListener onUpdateListener) {
        this.mOnUpdateListener = onUpdateListener;
    }

    @NonNull
    public String toString() {
        return super.toString() + PropertyUtils.MAPPED_DELIM + this.mResult + PropertyUtils.MAPPED_DELIM2;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        OnUpdateListener onUpdateListener;
        this.mResult = (IContextAwarenessResult) obj;
        String str = TAG;
        Logger.m10999d(str, "update# isResponseSuccess " + this.mResult.isResponseSuccess());
        IContextAwarenessResult.Request request = this.mResult.getRequest();
        if (request == null) {
            Logger.m11000e(str, "update# request is null");
            return;
        }
        if (this.mResult.getSuggestionInfoList() == null) {
            Logger.m11000e(str, "update# list is null");
            return;
        }
        Logger.m10999d(str, "update# request " + request.toString() + " | " + this.mResult.hashCode());
        int i = C91531.f6774xa6a48947[request.ordinal()];
        if (i != 1) {
            if (i == 2 && (onUpdateListener = this.mOnUpdateListener) != null) {
                onUpdateListener.onReceivedData(this.mResult);
                return;
            }
            return;
        }
        OnUpdateListener onUpdateListener2 = this.mOnUpdateListener;
        if (onUpdateListener2 != null) {
            onUpdateListener2.onSuggested(this.mResult);
        }
    }
}
