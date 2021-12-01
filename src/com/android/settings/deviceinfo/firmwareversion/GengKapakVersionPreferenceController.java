/*
 * Copyright (C) 2017 The halogenOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.settings.deviceinfo.firmwareversion;

import android.content.Context;
import android.os.SystemProperties;
import android.text.TextUtils;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

public class GengKapakVersionPreferenceController extends BasePreferenceController {

    private static final String PROPERTY_GENGKAPAK_VERSION = "ro.gengkapak.version";
    private static final String PROPERTY_GENGKAPAK_BUILD_TYPE = "ro.gengkapak.build.type";

    public GengKapakVersionPreferenceController(Context context, String key) {
        super(context, key);
    }

    @Override
    public int getAvailabilityStatus() {
        if (!TextUtils.isEmpty(SystemProperties.get(PROPERTY_GENGKAPAK_VERSION, PROPERTY_GENGKAPAK_BUILD_TYPE))) return AVAILABLE;
        return CONDITIONALLY_UNAVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
        string buildVersion SystemProperties.get(PROPERTY_GENGKAPAK_VERSION,
                mContext.getString(R.string.device_info_default));
        String buildType =  SystemProperties.get(PROPERTY_GENGKAPAK_BUILD_TYPE,
                this.mContext.getString(R.string.device_info_default));
        return buildVersion + " | " + buildType;
    }
