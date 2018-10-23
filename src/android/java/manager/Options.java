/*
 * Apache 2.0 License
 *
 * Copyright (c) Sebastian Katzer 2017
 *
 * This file contains Original Code and/or Modifications of Original Code
 * as defined in and that are subject to the Apache License
 * Version 2.0 (the 'License'). You may not use this file except in
 * compliance with the License. Please obtain a copy of the License at
 * http://opensource.org/licenses/Apache-2.0/ and read it before using this
 * file.
 *
 * The Original Code and all software distributed under the License are
 * distributed on an 'AS IS' basis, WITHOUT WARRANTY OF ANY KIND, EITHER
 * EXPRESS OR IMPLIED, AND APPLE HEREBY DISCLAIMS ALL SUCH WARRANTIES,
 * INCLUDING WITHOUT LIMITATION, ANY WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE, QUIET ENJOYMENT OR NON-INFRINGEMENT.
 * Please see the License for the specific language governing rights and
 * limitations under the License.
 */

package com.rolamix.plugins.audioplayer.manager;

import android.content.Context;

import org.json.JSONObject;

/**
 * Wrapper around the JSON object passed through JS which contains all
 * possible option values. Class provides simple readers and more advanced
 * methods to convert independent values into platform specific values.
 */
public final class Options {
    // Default icon path
    private static final String DEFAULT_ICON = "icon";

    // The original JSON object
    private final JSONObject options;

    // The application context
    private final Context context;

    /**
     * Constructor
     *
     * @param context The application context.
     */
    public Options(Context context) {
        this.context = context;
        this.options = new JSONObject();
    }
    /**
     * Constructor
     *
     * @param context The application context.
     * @param options The options dict map.
     */
    public Options(Context context, JSONObject options) {
        this.context = context;
        this.options = options;
    }

    /**
     * Application context.
     */
    public Context getContext () {
        return context;
    }

    /**
     * Wrapped JSON object.
     */
    public JSONObject getDict() {
        return options;
    }

    /**
     * JSON object as string.
     */
    public String toString() {
        return options.toString();
    }

    /**
     * icon resource ID for the local notification.
     */
    public String getIcon() {
        return options.optString("icon", DEFAULT_ICON);
    }
}
