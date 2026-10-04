package com.samsung.android.sdk.smp;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import androidx.core.util.Pair;
import com.samsung.android.sdk.smp.SmpCallback;
import com.samsung.android.sdk.smp.SmpException;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.util.ApiValidationCheckUtil;
import com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmpConfiguration {
    private static int mSmallIconId;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @TargetApi(26)
    public static class ChannelInfo {
        private final Map<Type, String> mChannels;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Builder {
            private Map<Type, String> mChannels;

            public Builder(String str, String str2) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
                ApiValidationCheckUtil.checkSmpApiValidity(new Pair("notice channelId", str), new Pair("marketing channelId", str2));
                HashMap map = new HashMap();
                this.mChannels = map;
                map.put(Type.Notice, str);
                this.mChannels.put(Type.Marketing, str2);
            }

            public Builder apply(Type type, String str) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
                ApiValidationCheckUtil.checkSmpApiValidity(new Pair("channelType", type), new Pair("channelId", str));
                this.mChannels.put(type, str);
                return this;
            }

            public ChannelInfo build() {
                return new ChannelInfo(this.mChannels);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public enum Type {
            Notice,
            Marketing
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<Type, String> getChannels() {
            return this.mChannels;
        }

        public String getChannelId(Type type) {
            return this.mChannels.get(type);
        }

        private ChannelInfo(Map<Type, String> map) {
            this.mChannels = map;
        }
    }

    @TargetApi(26)
    public static String getNotifChannelId(Context context, ChannelInfo.Type type) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context), new Pair("channelType", type));
            return SmpInterfaceImpl.getNotifChannelId(context.getApplicationContext(), type);
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static int getNotifColor(Context context) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            return SmpInterfaceImpl.getNotifColor(context.getApplicationContext());
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static String getNotifGroup(Context context) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            return SmpInterfaceImpl.getNotifGroup(context.getApplicationContext());
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static int getNotifSmallIcon() {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity();
            return mSmallIconId;
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static Uri getSound(Context context) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            return SmpInterfaceImpl.getSound(context.getApplicationContext());
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static boolean getSoundEnabled(Context context) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            return SmpInterfaceImpl.getSoundEnabled(context.getApplicationContext());
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static boolean getVibrateEnabled(Context context) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            return SmpInterfaceImpl.getVibrateEnabled(context.getApplicationContext());
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static long[] getVibratePattern(Context context) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            return SmpInterfaceImpl.getVibratePattern(context.getApplicationContext());
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static void setDebug(Context context, boolean z) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            SmpInterfaceImpl.setDebug(context.getApplicationContext(), z);
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    @TargetApi(26)
    public static void setNotifChannel(Context context, ChannelInfo channelInfo) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context), new Pair("channelInfo", channelInfo));
            SmpInterfaceImpl.setNotifChannel(context.getApplicationContext(), channelInfo.getChannels());
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static void setNotifColor(Context context, int i) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            SmpInterfaceImpl.setNotifColor(context.getApplicationContext(), i);
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static void setNotifGroup(Context context, String str) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
        try {
            SmpInterfaceImpl.setNotifGroup(context.getApplicationContext(), str);
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static void setNotifSmallIcon(int i) throws SmpException.IllegalStateException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity();
            mSmallIconId = i;
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static void setSound(Context context, Uri uri) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context), new Pair("sound uri", uri));
            SmpInterfaceImpl.setSound(context.getApplicationContext(), uri);
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static void setSoundEnabled(Context context, boolean z) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            SmpInterfaceImpl.setSoundEnabled(context.getApplicationContext(), z);
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static void setVibrateEnabled(Context context, boolean z) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
        try {
            SmpInterfaceImpl.setVibrateEnabled(context.getApplicationContext(), z);
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static void setVibratePattern(Context context, long[] jArr) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context), new Pair("vibrate pattern", jArr));
            SmpInterfaceImpl.setVibratePattern(context.getApplicationContext(), jArr);
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    @TargetApi(26)
    public static void getNotifChannelId(Context context, ChannelInfo.Type type, SmpCallback.Success<String> success, SmpCallback.Error error) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context), new Pair("channelType", type));
        SmpInterfaceImpl.getNotifChannelId(context.getApplicationContext(), type, success, error);
    }

    public static void getNotifColor(Context context, SmpCallback.Success<Integer> success, SmpCallback.Error error) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
        SmpInterfaceImpl.getNotifColor(context.getApplicationContext(), success, error);
    }

    public static void getNotifGroup(Context context, SmpCallback.Success<String> success, SmpCallback.Error error) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
        SmpInterfaceImpl.getNotifGroup(context.getApplicationContext(), success, error);
    }

    public static void getSound(Context context, SmpCallback.Success<Uri> success, SmpCallback.Error error) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
        SmpInterfaceImpl.getSound(context.getApplicationContext(), success, error);
    }

    public static void getSoundEnabled(Context context, SmpCallback.Success<Boolean> success, SmpCallback.Error error) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
        SmpInterfaceImpl.getSoundEnabled(context.getApplicationContext(), success, error);
    }

    public static void getVibrateEnabled(Context context, SmpCallback.Success<Boolean> success, SmpCallback.Error error) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
        SmpInterfaceImpl.getVibrateEnabled(context.getApplicationContext(), success, error);
    }

    public static void getVibratePattern(Context context, SmpCallback.Success<Long[]> success, SmpCallback.Error error) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
        SmpInterfaceImpl.getVibratePattern(context.getApplicationContext(), success, error);
    }

    @TargetApi(26)
    public static void setNotifChannel(Context context, ChannelInfo channelInfo, SmpCallback.Success<Void> success, SmpCallback.Error error) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context), new Pair("channelInfo", channelInfo));
        SmpInterfaceImpl.setNotifChannel(context.getApplicationContext(), channelInfo.getChannels(), success, error);
    }

    public static void setNotifColor(Context context, int i, SmpCallback.Success<Void> success, SmpCallback.Error error) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
        SmpInterfaceImpl.setNotifColor(context.getApplicationContext(), i, success, error);
    }

    public static void setNotifGroup(Context context, String str, SmpCallback.Success<Void> success, SmpCallback.Error error) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
        SmpInterfaceImpl.setNotifGroup(context.getApplicationContext(), str, success, error);
    }

    public static void setSound(Context context, Uri uri, SmpCallback.Success<Void> success, SmpCallback.Error error) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context), new Pair("sound uri", uri));
        SmpInterfaceImpl.setSound(context.getApplicationContext(), uri, success, error);
    }

    public static void setSoundEnabled(Context context, boolean z, SmpCallback.Success<Void> success, SmpCallback.Error error) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
        SmpInterfaceImpl.setSoundEnabled(context.getApplicationContext(), z, success, error);
    }

    public static void setVibrateEnabled(Context context, boolean z, SmpCallback.Success<Void> success, SmpCallback.Error error) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
        SmpInterfaceImpl.setVibrateEnabled(context.getApplicationContext(), z, success, error);
    }

    public static void setVibratePattern(Context context, long[] jArr, SmpCallback.Success<Void> success, SmpCallback.Error error) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context), new Pair("vibrate pattern", jArr));
        SmpInterfaceImpl.setVibratePattern(context.getApplicationContext(), jArr, success, error);
    }
}
