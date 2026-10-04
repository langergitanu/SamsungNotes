package com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata;

import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J$\u0010\u0007\u001a\u00020\u00032\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/crowdhwrdata/SpenCrowdHwrManagerListener;", "", "onSentenceChanged", "", "sentence", "", "getSentence", "onSubmitted", "listFile", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onClearAll", "onUndo", "onHandwritingUpdated", "isEmpty", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenCrowdHwrManagerListener {
    @NotNull
    String getSentence();

    void onClearAll();

    void onHandwritingUpdated(boolean isEmpty);

    void onSentenceChanged(@NotNull String sentence);

    void onSubmitted(@Nullable ArrayList<String> listFile);

    void onUndo();
}
