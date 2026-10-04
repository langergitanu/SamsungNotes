package com.samsung.android.support.senl.p148nt.base.composer.content;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectCodeBlock;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/content/ObjectHelper;", "", "<init>", "()V", "removeObjectSpan", "", ExternalDataConstants.Column.TEXT_BOX, "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "setObjectSpanDefaultOption", "", "objectSpan", "Lcom/samsung/android/sdk/pen/document/textspan/SpenObjectSpan;", "setInlineOption", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ObjectHelper {

    @NotNull
    public static final ObjectHelper INSTANCE = new ObjectHelper();

    private ObjectHelper() {
    }

    @JvmStatic
    public static final void setInlineOption(@NotNull SpenObjectSpan objectSpan) {
        Intrinsics.checkNotNullParameter(objectSpan, "objectSpan");
        objectSpan.setLayoutOption(1);
    }

    @JvmStatic
    public static final void setObjectSpanDefaultOption(@NotNull SpenObjectSpan objectSpan) {
        Intrinsics.checkNotNullParameter(objectSpan, "objectSpan");
        SpenObjectBase obj = objectSpan.getObj();
        if (obj instanceof SpenObjectTable) {
            objectSpan.setLayoutOption(3);
            objectSpan.setLayoutConstraint(2);
        } else if (obj instanceof SpenObjectCodeBlock) {
            objectSpan.setLayoutConstraint(1);
        }
    }

    public final boolean removeObjectSpan(@NotNull SpenObjectTextBox textBox) {
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        ArrayList<SpenObjectSpan> objectSpan = textBox.getObjectSpan();
        if (objectSpan == null || objectSpan.isEmpty()) {
            return false;
        }
        int size = objectSpan.size();
        if (1 <= size) {
            int i = 1;
            while (true) {
                textBox.removeObjectSpan(objectSpan.get(size - i));
                if (i == size) {
                    break;
                }
                i++;
            }
        }
        return true;
    }
}
