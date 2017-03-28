/*
 * Copyright (C) 2016 The Android Open Source Project
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
package com.example.android.sunshine.data;

import android.provider.BaseColumns;

/**
 * Defines table and column names for the weather database. This class is not necessary, but keeps
 * the code organized.
 */
public class WeatherContract {

    public  static final class WeatherEntry implements BaseColumns {
         final static String TABLE_NAME="weather";
         final static String COLUMN_DATE="date";
         final static String COLUMN_WEATHER_ID="weather_id";
        final static String COLUMN_MIN_TEMP="min";
        final static String COLUMN_MAX_TEMP="max";
        final static String COLUMN_HUMIDITY="humidity";
        final static String COLUMN_PRESSURE="pressure";
        final static String COLUMN_WIND_SPEED="wind";
        final static String COLUMN_DEGREES="degress";

    };
}