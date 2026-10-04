package com.samsung.android.sdk.pen.engine;

import com.samsung.android.sdk.pen.SpenSettingShapeInfo;
import com.samsung.android.sdk.pen.SpenSettingTextInfo;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000bH&¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenShapeChangeListener;", "", "onChanged", "", "info", "Lcom/samsung/android/sdk/pen/SpenSettingShapeInfo;", "onTextChanged", "Lcom/samsung/android/sdk/pen/SpenSettingTextInfo;", "state", "", "onTextSelectionChanged", "", "selStart", "selEnd", "onTextMoreButtonDown", "objectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "onTextFocusChanged", "gainFocus", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenShapeChangeListener {
    public static final int CONTROL_STATE_NOT_CHANGED = 2;
    public static final int CONTROL_STATE_SELECTED = 0;
    public static final int CONTROL_STATE_UNSELECTED = 1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenShapeChangeListener$Companion;", "", "<init>", "()V", "CONTROL_STATE_SELECTED", "", "CONTROL_STATE_UNSELECTED", "CONTROL_STATE_NOT_CHANGED", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int CONTROL_STATE_NOT_CHANGED = 2;
        public static final int CONTROL_STATE_SELECTED = 0;
        public static final int CONTROL_STATE_UNSELECTED = 1;

        private Companion() {
        }
    }

    void onChanged(@Nullable SpenSettingShapeInfo info);

    void onTextChanged(@Nullable SpenSettingTextInfo info, int state);

    void onTextFocusChanged(boolean gainFocus);

    void onTextMoreButtonDown(@Nullable SpenObjectShape objectShape);

    boolean onTextSelectionChanged(int selStart, int selEnd);
}
