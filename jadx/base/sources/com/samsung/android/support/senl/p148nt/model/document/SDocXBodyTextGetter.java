package com.samsung.android.support.senl.p148nt.model.document;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.DisplayDataConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/document/SDocXBodyTextGetter;", "", StateHandler.KEY_APP_STATE, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getText", "", "docPath", "getMaxLengthBodyText", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SDocXBodyTextGetter {

    @NotNull
    private final Context appContext;

    public SDocXBodyTextGetter(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
    }

    @NotNull
    public final String getMaxLengthBodyText(@NotNull String docPath) {
        Intrinsics.checkNotNullParameter(docPath, "docPath");
        String strTrimMaxIndexContentString = DisplayDataConverter.trimMaxIndexContentString(getText(docPath));
        Intrinsics.checkNotNullExpressionValue(strTrimMaxIndexContentString, "trimMaxIndexContentString(...)");
        return strTrimMaxIndexContentString;
    }

    @NotNull
    public final String getText(@NotNull String docPath) {
        Intrinsics.checkNotNullParameter(docPath, "docPath");
        if (!SpenSdkInitializer.initialize(this.appContext) || docPath.length() == 0 || !AbstractC2322a.m1607A(docPath)) {
            return "";
        }
        String bodyTextString = SpenWNoteFile.getBodyTextString(docPath);
        if (TextUtils.isEmpty(bodyTextString)) {
            return "";
        }
        Intrinsics.checkNotNull(bodyTextString);
        return bodyTextString;
    }
}
