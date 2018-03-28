package com.msww.ms.utils;

import com.msww.ms.user.model.MswwResult;

public class MswwResultUtil {
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static MswwResult success(Object data) {
        MswwResult mswwResult = new MswwResult();
        mswwResult.setResultCode(0);
        mswwResult.setMessage("success");
        mswwResult.setData(data);
        return mswwResult;
    }

    @SuppressWarnings("rawtypes")
    public static MswwResult success() {
        return success(null);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static MswwResult error(Integer resultCode, String message) {
        MswwResult mswwResult = new MswwResult();
        mswwResult.setResultCode(resultCode);
        mswwResult.setMessage(message);
        mswwResult.setData(null);
        return mswwResult;
    };
}
