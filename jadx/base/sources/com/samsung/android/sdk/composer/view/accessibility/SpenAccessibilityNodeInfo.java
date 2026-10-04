package com.samsung.android.sdk.composer.view.accessibility;

import android.graphics.Rect;
import android.text.Editable;
import kotlin.Metadata;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B%\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0002\u0010\nJ\"\u0010.\u001a\u00020/2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJX\u0010.\u001a\u00020/2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020'2\u0006\u0010+\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000eR\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\f\"\u0004\b-\u0010\u000e¨\u00062"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/view/accessibility/SpenAccessibilityNodeInfo;", "", "<init>", "()V", "nativeId", "", "bound", "Landroid/graphics/Rect;", "description", "", "(ILandroid/graphics/Rect;Ljava/lang/String;)V", "getNativeId", "()I", "setNativeId", "(I)V", "getBound", "()Landroid/graphics/Rect;", "setBound", "(Landroid/graphics/Rect;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "roleDescription", "getRoleDescription", "setRoleDescription", "stateDescription", "getStateDescription", "setStateDescription", "text", "Landroid/text/Editable;", "getText", "()Landroid/text/Editable;", "setText", "(Landroid/text/Editable;)V", "propertyFlag", "getPropertyFlag", "setPropertyFlag", "isFocused", "", "()Z", "setFocused", "(Z)V", "pageIndex", "getPageIndex", "setPageIndex", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "", StringLookupFactory.KEY_PROPERTIES, "focused", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenAccessibilityNodeInfo {

    @Nullable
    private Rect bound;

    @Nullable
    private String description;
    private boolean isFocused;
    private int nativeId;
    private int pageIndex = -1;
    private int propertyFlag;

    @Nullable
    private String roleDescription;

    @Nullable
    private String stateDescription;

    @Nullable
    private Editable text;

    public SpenAccessibilityNodeInfo() {
    }

    @Nullable
    public final Rect getBound() {
        return this.bound;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    public final int getNativeId() {
        return this.nativeId;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    public final int getPropertyFlag() {
        return this.propertyFlag;
    }

    @Nullable
    public final String getRoleDescription() {
        return this.roleDescription;
    }

    @Nullable
    public final String getStateDescription() {
        return this.stateDescription;
    }

    @Nullable
    public final Editable getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: isFocused, reason: from getter */
    public final boolean getIsFocused() {
        return this.isFocused;
    }

    public final void set(int nativeId, @Nullable Rect bound, @Nullable String description) {
        this.nativeId = nativeId;
        this.bound = bound;
        this.description = description;
    }

    public final void setBound(@Nullable Rect rect) {
        this.bound = rect;
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    public final void setFocused(boolean z) {
        this.isFocused = z;
    }

    public final void setNativeId(int i) {
        this.nativeId = i;
    }

    public final void setPageIndex(int i) {
        this.pageIndex = i;
    }

    public final void setPropertyFlag(int i) {
        this.propertyFlag = i;
    }

    public final void setRoleDescription(@Nullable String str) {
        this.roleDescription = str;
    }

    public final void setStateDescription(@Nullable String str) {
        this.stateDescription = str;
    }

    public final void setText(@Nullable Editable editable) {
        this.text = editable;
    }

    public SpenAccessibilityNodeInfo(int i, @Nullable Rect rect, @Nullable String str) {
        this.nativeId = i;
        this.bound = rect;
        this.description = str;
    }

    public final void set(int nativeId, @Nullable Rect bound, @Nullable String description, @Nullable String roleDescription, @Nullable String stateDescription, @Nullable String text, int properties, boolean focused, int pageIndex) {
        this.nativeId = nativeId;
        this.bound = bound;
        this.description = description;
        this.roleDescription = roleDescription;
        this.stateDescription = stateDescription;
        this.text = Editable.Factory.getInstance().newEditable(text);
        this.propertyFlag = properties;
        this.isFocused = focused;
        this.pageIndex = pageIndex;
    }
}
