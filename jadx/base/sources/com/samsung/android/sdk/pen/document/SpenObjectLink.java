package com.samsung.android.sdk.pen.document;

import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u001c\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u001eH\u0002J\u0019\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 J\u001b\u0010@\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u001e2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u0010A\u001a\u00020\b2\u0006\u0010?\u001a\u00020\u001eH\u0082 J\u001b\u0010B\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u001e2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u0010C\u001a\u00020\b2\u0006\u0010?\u001a\u00020\u001eH\u0082 J\u001b\u0010D\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u001e2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u0010E\u001a\u00020\b2\u0006\u0010?\u001a\u00020\u001eH\u0082 J\u001b\u0010F\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u001e2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u0010G\u001a\u00020\b2\u0006\u0010?\u001a\u00020\u001eH\u0082 J\u001b\u0010H\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u0010I\u001a\u00020\b2\u0006\u0010?\u001a\u00020\u001eH\u0082 J\u001b\u0010J\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u0010K\u001a\u00020\b2\u0006\u0010?\u001a\u00020\u001eH\u0082 J\u0019\u0010L\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0082 J\u0011\u0010M\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u001eH\u0082 J\u0019\u0010N\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001eH\u0082 J\u0011\u0010O\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u001eH\u0082 J\u0019\u0010P\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001eH\u0082 J\u0011\u0010Q\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u001eH\u0082 JE\u0010R\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u001e22\u0010*\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020-0,\u0018\u00010+j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020-0,\u0018\u0001`.H\u0082 J9\u0010S\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020-0,0+j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020-0,`.2\u0006\u0010?\u001a\u00020\u001eH\u0082 J!\u0010T\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u001e2\u0006\u0010U\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\u001eH\u0082 J\u001d\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0,2\u0006\u0010?\u001a\u00020\u001eH\u0082 R(\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR(\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR(\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR(\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\fR(\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\fR$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R$\u0010'\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010 \"\u0004\b)\u0010\"R|\u0010/\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020-0,\u0018\u00010+j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020-0,\u0018\u0001`.22\u0010*\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020-0,\u0018\u00010+j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020-0,\u0018\u0001`.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R<\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0,2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0,8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010#\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010 ¨\u0006X"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectLink;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "<init>", "()V", "isTemplateObject", "", "(Z)V", "packageName", "", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "action", "getAction", "setAction", "path", "thumbnailPath", "getThumbnailPath", "setThumbnailPath", "title", DynamicActionBarProvider.METHOD_GET_DATA, "setTitle", "body", "getBody", "setBody", "option", "getOption", "setOption", "version", "", "getVersion", "()I", "setVersion", "(I)V", "type", "viewType", "getViewType", "setViewType", "iconType", "getIconType", "setIconType", "colorList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "", "Lkotlin/collections/ArrayList;", "backgroundGradientColors", "getBackgroundGradientColors", "()Ljava/util/ArrayList;", "setBackgroundGradientColors", "(Ljava/util/ArrayList;)V", "colors", "dummyThumbnailColors", "getDummyThumbnailColors", "()Lkotlin/Pair;", "setDummyThumbnailColors", "(Lkotlin/Pair;)V", "getType", "throwUncheckedException", "", "errno", "ObjectLink_init", "handle", "ObjectLink_setPackageName", "ObjectLink_getPackageName", "ObjectLink_setAction", "ObjectLink_getAction", "ObjectLink_setThumbnailPath", "ObjectLink_getThumbnailPath", "ObjectLink_setTitle", "ObjectLink_getTitle", "ObjectLink_setBody", "ObjectLink_getBody", "ObjectLink_setOption", "ObjectLink_getOption", "ObjectLink_setVersion", "ObjectLink_getVersion", "ObjectLink_setViewType", "ObjectLink_getViewType", "ObjectLink_setIconType", "ObjectLink_getIconType", "ObjectLink_setBackgroundGradientColors", "ObjectLink_getBackgroundGradientColors", "ObjectLink_setDummyThumbnailColors", "tintColor", "backgroundColor", "ObjectLink_getDummyThumbnailColors", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenObjectLink extends SpenObjectBase {
    public SpenObjectLink() {
        super(17);
    }

    private final native String ObjectLink_getAction(int handle);

    private final native ArrayList<Pair<Integer, Float>> ObjectLink_getBackgroundGradientColors(int handle);

    private final native String ObjectLink_getBody(int handle);

    private final native Pair<Integer, Integer> ObjectLink_getDummyThumbnailColors(int handle);

    private final native int ObjectLink_getIconType(int handle);

    private final native String ObjectLink_getOption(int handle);

    private final native String ObjectLink_getPackageName(int handle);

    private final native String ObjectLink_getThumbnailPath(int handle);

    private final native String ObjectLink_getTitle(int handle);

    private final native int ObjectLink_getVersion(int handle);

    private final native int ObjectLink_getViewType(int handle);

    private final native boolean ObjectLink_init(int handle, boolean isTemplateObject);

    private final native boolean ObjectLink_setAction(int handle, String action);

    private final native boolean ObjectLink_setBackgroundGradientColors(int handle, ArrayList<Pair<Integer, Float>> colorList);

    private final native boolean ObjectLink_setBody(int handle, String body);

    private final native boolean ObjectLink_setDummyThumbnailColors(int handle, int tintColor, int backgroundColor);

    private final native boolean ObjectLink_setIconType(int handle, int iconType);

    private final native boolean ObjectLink_setOption(int handle, String option);

    private final native boolean ObjectLink_setPackageName(int handle, String packageName);

    private final native boolean ObjectLink_setThumbnailPath(int handle, String path);

    private final native boolean ObjectLink_setTitle(int handle, String title);

    private final native boolean ObjectLink_setVersion(int handle, int version);

    private final native boolean ObjectLink_setViewType(int handle, int viewType);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenObjectLink(" + this + ") is already closed");
    }

    @Nullable
    public final String getAction() {
        return ObjectLink_getAction(getMHandle());
    }

    @Nullable
    public final ArrayList<Pair<Integer, Float>> getBackgroundGradientColors() {
        return ObjectLink_getBackgroundGradientColors(getMHandle());
    }

    @Nullable
    public final String getBody() {
        return ObjectLink_getBody(getMHandle());
    }

    @NotNull
    public final Pair<Integer, Integer> getDummyThumbnailColors() {
        return ObjectLink_getDummyThumbnailColors(getMHandle());
    }

    public final int getIconType() {
        return ObjectLink_getIconType(getMHandle());
    }

    @Nullable
    public final String getOption() {
        return ObjectLink_getOption(getMHandle());
    }

    @Nullable
    public final String getPackageName() {
        return ObjectLink_getPackageName(getMHandle());
    }

    @Nullable
    public final String getThumbnailPath() {
        return ObjectLink_getThumbnailPath(getMHandle());
    }

    @Nullable
    public final String getTitle() {
        return ObjectLink_getTitle(getMHandle());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public int getType() {
        return super.getType();
    }

    public final int getVersion() {
        return ObjectLink_getVersion(getMHandle());
    }

    public final int getViewType() {
        return ObjectLink_getViewType(getMHandle());
    }

    public final void setAction(@Nullable String str) {
        if (ObjectLink_setAction(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBackgroundGradientColors(@Nullable ArrayList<Pair<Integer, Float>> arrayList) {
        if (ObjectLink_setBackgroundGradientColors(getMHandle(), arrayList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBody(@Nullable String str) {
        if (ObjectLink_setBody(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setDummyThumbnailColors(@NotNull Pair<Integer, Integer> colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        if (ObjectLink_setDummyThumbnailColors(getMHandle(), colors.getFirst().intValue(), colors.getSecond().intValue())) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setIconType(int i) {
        if (ObjectLink_setIconType(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setOption(@Nullable String str) {
        if (ObjectLink_setOption(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setPackageName(@Nullable String str) {
        if (ObjectLink_setPackageName(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setThumbnailPath(@Nullable String str) {
        if (ObjectLink_setThumbnailPath(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTitle(@Nullable String str) {
        if (ObjectLink_setTitle(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setVersion(int i) {
        if (ObjectLink_setVersion(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setViewType(int i) {
        if (ObjectLink_setViewType(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectLink(boolean z) {
        super(17);
        if (ObjectLink_init(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
