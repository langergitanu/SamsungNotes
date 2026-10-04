package com.samsung.android.support.senl.p148nt.base.widget.search;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0007J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0007J$\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/widget/search/VoiceButtonHelper;", "", "<init>", "()V", "STT_SVI_ACTION", "", "SUPPORT_HONEY_VOICE_SEARCH", "", "getSUPPORT_HONEY_VOICE_SEARCH$annotations", "getSUPPORT_HONEY_VOICE_SEARCH", "()Z", "setSearchableInfo", "", "searchView", "Landroidx/appcompat/widget/SearchView;", WidgetConstant.WIDGET_SAMSUNG_EXTRA_KEY, "Landroid/content/ComponentName;", "setVoiceButtonListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "makeVoiceRecognizerIntent", "Landroid/content/Intent;", "sviEnabled", "isSviEnabled", "getQueryFromResult", "resultCode", "", "data", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceButtonHelper {

    @NotNull
    public static final VoiceButtonHelper INSTANCE = new VoiceButtonHelper();

    @NotNull
    public static final String STT_SVI_ACTION = "samsung.honeyboard.honeyvoice.action.RECOGNIZE_SPEECH";
    private static final boolean SUPPORT_HONEY_VOICE_SEARCH;

    static {
        SUPPORT_HONEY_VOICE_SEARCH = Build.VERSION.SEM_PLATFORM_INT >= 160000;
    }

    private VoiceButtonHelper() {
    }

    @JvmStatic
    @Nullable
    public static final String getQueryFromResult(int resultCode, @Nullable Intent data, boolean sviEnabled) {
        if (data != null && resultCode == -1) {
            if (sviEnabled) {
                return data.getStringExtra("query");
            }
            ArrayList<String> stringArrayListExtra = data.getStringArrayListExtra("android.speech.extra.RESULTS");
            if (stringArrayListExtra != null) {
                return stringArrayListExtra.get(0);
            }
        }
        return null;
    }

    public static final boolean getSUPPORT_HONEY_VOICE_SEARCH() {
        return SUPPORT_HONEY_VOICE_SEARCH;
    }

    @JvmStatic
    public static /* synthetic */ void getSUPPORT_HONEY_VOICE_SEARCH$annotations() {
    }

    @JvmStatic
    public static final boolean isSviEnabled(@NotNull SearchView searchView) {
        Intrinsics.checkNotNullParameter(searchView, "searchView");
        return SUPPORT_HONEY_VOICE_SEARCH && searchView.seslSetSviEnabled(true);
    }

    @JvmStatic
    @NotNull
    public static final Intent makeVoiceRecognizerIntent(boolean sviEnabled) {
        if (sviEnabled) {
            return new Intent(STT_SVI_ACTION);
        }
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        Intrinsics.checkNotNull(intent.putExtra("android.speech.extra.LANGUAGE", Locale.getDefault()));
        return intent;
    }

    @JvmStatic
    public static final void setSearchableInfo(@NotNull SearchView searchView, @Nullable ComponentName componentName) {
        SearchManager searchManager;
        Intrinsics.checkNotNullParameter(searchView, "searchView");
        if (componentName == null || (searchManager = (SearchManager) searchView.getContext().getSystemService("search")) == null) {
            return;
        }
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName));
        searchView.seslSetSviEnabled(SUPPORT_HONEY_VOICE_SEARCH);
    }

    @JvmStatic
    public static final void setVoiceButtonListener(@NotNull SearchView searchView, @NotNull View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(searchView, "searchView");
        Intrinsics.checkNotNullParameter(listener, "listener");
        View viewFindViewById = searchView.findViewById(C8875R.id.search_voice_btn);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(listener);
        }
    }
}
