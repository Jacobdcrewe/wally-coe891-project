/*
 * Copyright (C) 2014 Freddie (Musenkishi) Lust-Hed
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

package com.musenkishi.wally.models;

import android.os.Parcelable;

import auto.parcel.AutoParcel;

/**
 * Placeholder for tags
 * Created by Musenkishi on 2014-02-23.
 */
@AutoParcel
public abstract class Tag implements Parcelable {

    public abstract String name();

    public static Tag create(String name) {
        return new AutoParcel_Tag(name);
    }
}