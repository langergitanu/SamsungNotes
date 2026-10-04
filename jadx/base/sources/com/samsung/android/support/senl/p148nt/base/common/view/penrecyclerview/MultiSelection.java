package com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview;

import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/view/penrecyclerview/MultiSelection;", "", "<init>", "()V", "getIsMultiSelectingText", "", "isNeedToScroll", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MultiSelection {

    @NotNull
    public static final MultiSelection INSTANCE = new MultiSelection();

    private MultiSelection() {
    }

    public final boolean getIsMultiSelectingText() {
        try {
            Object objInvoke = Class.forName("android.text.MultiSelection").getDeclaredMethod("getIsMultiSelectingText", null).invoke(null, null);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) objInvoke).booleanValue();
        } catch (ClassNotFoundException e) {
            Logger.m8698e("MultiSelection", "MultiSelection.getIsMultiSelectingText() ClassNotFoundException : " + e);
            return false;
        } catch (IllegalAccessException e2) {
            Logger.m8698e("MultiSelection", "MultiSelection.getIsMultiSelectingText() IllegalAccessException : " + e2);
            return false;
        } catch (IllegalArgumentException e3) {
            Logger.m8698e("MultiSelection", "MultiSelection.getIsMultiSelectingText() IllegalArgumentException : " + e3);
            return false;
        } catch (NoSuchMethodException e5) {
            Logger.m8698e("MultiSelection", "MultiSelection.getIsMultiSelectingText() NoSuchMethodException : " + e5);
            return false;
        } catch (InvocationTargetException e6) {
            Logger.m8698e("MultiSelection", "MultiSelection.getIsMultiSelectingText() InvocationTargetException : " + e6);
            return false;
        }
    }

    public final boolean isNeedToScroll() {
        try {
            Object objInvoke = Class.forName("android.text.MultiSelection").getDeclaredMethod("isNeedToScroll", null).invoke(null, null);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) objInvoke).booleanValue();
        } catch (ClassNotFoundException e) {
            Logger.m8698e("MultiSelection", "MultiSelection.isNeedToScroll() ClassNotFoundException : " + e);
            return false;
        } catch (IllegalAccessException e2) {
            Logger.m8698e("MultiSelection", "MultiSelection.isNeedToScroll() IllegalAccessException : " + e2);
            return false;
        } catch (IllegalArgumentException e3) {
            Logger.m8698e("MultiSelection", "MultiSelection.isNeedToScroll() IllegalArgumentException : " + e3);
            return false;
        } catch (NoSuchMethodException e5) {
            Logger.m8698e("MultiSelection", "MultiSelection.isNeedToScroll() NoSuchMethodException : " + e5);
            return false;
        } catch (InvocationTargetException e6) {
            Logger.m8698e("MultiSelection", "MultiSelection.isNeedToScroll() InvocationTargetException : " + e6);
            return false;
        }
    }
}
