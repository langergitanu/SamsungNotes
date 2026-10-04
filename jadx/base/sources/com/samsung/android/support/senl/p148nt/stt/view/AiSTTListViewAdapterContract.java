package com.samsung.android.support.senl.p148nt.stt.view;

import android.os.Bundle;
import com.samsung.android.support.senl.p148nt.stt.base.model.paint.PaintHelper;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0005H&¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListViewAdapterContract;", "", "onWordTouched", "", "touchedWordTimestamp", "", "onSpeakerRename", "bundle", "Landroid/os/Bundle;", "position", "getSpeakerNameMap", "", "", "onItemCheckedChange", "isChecked", "", "getPaintHelper", "Lcom/samsung/android/support/senl/nt/stt/base/model/paint/PaintHelper;", "clearSTTFocus", "onEditWordTouched", "onEditTextChanged", "string", "pos", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface AiSTTListViewAdapterContract {
    void clearSTTFocus();

    @Nullable
    PaintHelper getPaintHelper();

    @NotNull
    Map<Integer, String> getSpeakerNameMap();

    void onEditTextChanged(@NotNull String string, int pos);

    void onEditWordTouched();

    void onItemCheckedChange(int position, boolean isChecked);

    void onSpeakerRename(@NotNull Bundle bundle, int position);

    void onWordTouched(int touchedWordTimestamp);
}
