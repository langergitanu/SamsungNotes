package com.samsung.android.sdk.composer.writing;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.glance.AbstractC2821a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000eR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/writing/SpenEasyWritingPadManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mSharedPreferences", "Landroid/content/SharedPreferences;", "isGuideTextEnabled", "", "()Z", "onChangeGuideVisible", "", "type", "", "visible", "count", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenEasyWritingPadManager {
    private static final int GUIDE_TYPE_EASY_WRITING_PAD = 0;

    @NotNull
    private static final String KEY_EASYWRITINGPAD_GUIDE_TEXT = "EASYWRITINGPAD_GUIDETEXT";

    @NotNull
    private static final String PREFERENCE_NAME = "_writing";

    @NotNull
    private static final String TAG = "SpenEasyWritingPadManager";

    @Nullable
    private final SharedPreferences mSharedPreferences;

    public SpenEasyWritingPadManager(@Nullable Context context) {
        SharedPreferences sharedPreferences;
        if (context != null) {
            sharedPreferences = context.getSharedPreferences(context.getPackageName() + PREFERENCE_NAME, 0);
        } else {
            sharedPreferences = null;
        }
        this.mSharedPreferences = sharedPreferences;
    }

    public final boolean isGuideTextEnabled() {
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        return sharedPreferences != null && sharedPreferences.getBoolean(KEY_EASYWRITINGPAD_GUIDE_TEXT, true);
    }

    public final void onChangeGuideVisible(int type, boolean visible, int count) {
        AbstractC0000a.m26w(AbstractC2821a.m2226q("onChangeGuideTextVisible type:", type, ", visible:", visible, ", count:"), TAG, count);
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (type == 0) {
                editorEdit.putBoolean(KEY_EASYWRITINGPAD_GUIDE_TEXT, false);
            }
            editorEdit.apply();
        }
    }
}
