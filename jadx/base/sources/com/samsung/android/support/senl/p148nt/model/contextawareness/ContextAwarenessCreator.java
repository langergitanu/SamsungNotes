package com.samsung.android.support.senl.p148nt.model.contextawareness;

import android.content.Intent;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.common.log.CALogger;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.SuggestionInfo;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.SuggestionInfoFactory;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ContextAwarenessCreator {
    private static final String TAG = CALogger.createTag("ContextAwarenessCreator");
    private final ExecutorService mExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
    private Intent mIntent;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SuggestionInfoCreatorCallable implements Callable<List<SuggestionInfo>> {
        public /* synthetic */ SuggestionInfoCreatorCallable(ContextAwarenessCreator contextAwarenessCreator, int i) {
            this();
        }

        private SuggestionInfoCreatorCallable() {
        }

        @Override // java.util.concurrent.Callable
        public List<SuggestionInfo> call() {
            return SuggestionInfoFactory.getInstance().makeSuggestionInfo(ContextAwarenessCreator.this.mIntent);
        }
    }

    public SuggestionInfo createSuggestionInfo(Intent intent) {
        this.mIntent = intent;
        try {
            List list = (List) ((FutureTask) this.mExecutor.submit(new SuggestionInfoCreatorCallable(this, 0))).get();
            if (list.isEmpty()) {
                return null;
            }
            return (SuggestionInfo) list.get(0);
        } catch (InterruptedException | ExecutionException e) {
            AbstractC11014a.m12333r(e, new StringBuilder("createSuggestionInfo# "), TAG);
            return null;
        }
    }
}
