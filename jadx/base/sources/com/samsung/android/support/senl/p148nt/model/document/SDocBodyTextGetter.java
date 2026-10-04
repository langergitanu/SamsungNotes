package com.samsung.android.support.senl.p148nt.model.document;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentBase;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.common.SpenOpenModeManager;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/document/SDocBodyTextGetter;", "", StateHandler.KEY_APP_STATE, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getText", "", "docPath", AbstractCircuitBreaker.PROPERTY_NAME, "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc;", "path", "close", "", ExternalDataConstants.DOCUMENT_TABLE_NAME, "Companion", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SDocBodyTextGetter {

    @NotNull
    private static final String TAG;

    @NotNull
    private final Context appContext;

    static {
        String strCreateTag = ModelLogger.createTag("SDocBodyTextGetter");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public SDocBodyTextGetter(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
    }

    private final void close(SpenSDoc document) {
        try {
            if (document.isClosed()) {
                return;
            }
            document.close(true);
        } catch (IOException e) {
            AbstractC11014a.m12314C("close, e : ", e.getMessage(), TAG);
        }
    }

    private final SpenSDoc open(String path) {
        try {
            return DocumentConstructor.makeSpenSDoc(this.appContext, path, null, null, SpenOpenModeManager.INSTANCE.getInstance().use(7000, path));
        } catch (Exception unused) {
            return null;
        }
    }

    @WorkerThread
    @NotNull
    public final String getText(@NotNull String docPath) {
        Intrinsics.checkNotNullParameter(docPath, "docPath");
        SpenSDoc spenSDocOpen = open(docPath);
        if (spenSDocOpen == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<SpenContentBase> contentList = spenSDocOpen.getContentList();
        Intrinsics.checkNotNull(contentList);
        Iterator<SpenContentBase> it = contentList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenContentBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenContentBase spenContentBase = next;
            if (sb.length() >= 30000) {
                break;
            }
            if (spenContentBase.getType() == 1) {
                if (!TextUtils.isEmpty(spenContentBase.getText())) {
                    sb.append(spenContentBase.getText());
                }
                sb.append('\n');
            }
        }
        close(spenSDocOpen);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
