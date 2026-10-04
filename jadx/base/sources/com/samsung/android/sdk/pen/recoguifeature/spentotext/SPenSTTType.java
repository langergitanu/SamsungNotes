package com.samsung.android.sdk.pen.recoguifeature.spentotext;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/SPenSTTType;", "", "<init>", "()V", "SPEN_TO_TEXT_ACTION_NONE", "", "SPEN_TO_TEXT_ACTION_SPACE", "SPEN_TO_TEXT_ACTION_BACKSPACE", "SPEN_TO_TEXT_ACTION_ENTER", "SPEN_TO_TEXT_TARGET_BODY_TEXT", "SPEN_TO_TEXT_TARGET_OBJECT_TEXT_BOX", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SPenSTTType {

    @NotNull
    public static final SPenSTTType INSTANCE = new SPenSTTType();
    public static final int SPEN_TO_TEXT_ACTION_BACKSPACE = 2;
    public static final int SPEN_TO_TEXT_ACTION_ENTER = 3;
    public static final int SPEN_TO_TEXT_ACTION_NONE = 0;
    public static final int SPEN_TO_TEXT_ACTION_SPACE = 1;
    public static final int SPEN_TO_TEXT_TARGET_BODY_TEXT = 0;
    public static final int SPEN_TO_TEXT_TARGET_OBJECT_TEXT_BOX = 1;

    private SPenSTTType() {
    }
}
