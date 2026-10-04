package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0001J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0001J\u0006\u0010\u0011\u001a\u00020\u0007R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/SpenVoiceDataEventListenerImpl;", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$VoiceDataEventListener;", "<init>", "()V", "mListenerList", "", "onVoiceDataChanged", "", "spenWNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "spenVoiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "changeType", "", "addVoiceDataListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeVoiceDataListener", "release", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenVoiceDataEventListenerImpl implements SpenWNote.VoiceDataEventListener {

    @NotNull
    private static final String TAG;

    @Nullable
    private List<SpenWNote.VoiceDataEventListener> mListenerList = new ArrayList();

    static {
        String strCreateTag = Logger.createTag("SpenVoiceDataEventListener");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public final void addVoiceDataListener(@NotNull SpenWNote.VoiceDataEventListener listener) {
        List<SpenWNote.VoiceDataEventListener> list;
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<SpenWNote.VoiceDataEventListener> list2 = this.mListenerList;
        if (list2 == null || list2.contains(listener) || (list = this.mListenerList) == null) {
            return;
        }
        list.add(listener);
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.VoiceDataEventListener
    public void onVoiceDataChanged(@NotNull SpenWNote spenWNote, @NotNull SpenVoiceData spenVoiceData, int changeType) {
        Intrinsics.checkNotNullParameter(spenWNote, "spenWNote");
        Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
        AbstractC0000a.m3D(changeType, "onVoiceDataChanged. ", TAG);
        List<SpenWNote.VoiceDataEventListener> list = this.mListenerList;
        if (list == null || list.isEmpty()) {
            return;
        }
        List<SpenWNote.VoiceDataEventListener> list2 = this.mListenerList;
        Intrinsics.checkNotNull(list2);
        Iterator<SpenWNote.VoiceDataEventListener> it = list2.iterator();
        while (it.hasNext()) {
            it.next().onVoiceDataChanged(spenWNote, spenVoiceData, changeType);
        }
    }

    public final void release() {
        List<SpenWNote.VoiceDataEventListener> list = this.mListenerList;
        if (list != null) {
            list.clear();
        }
        this.mListenerList = null;
    }

    public final void removeVoiceDataListener(@NotNull SpenWNote.VoiceDataEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<SpenWNote.VoiceDataEventListener> list = this.mListenerList;
        if (list != null) {
            list.remove(listener);
        }
    }
}
