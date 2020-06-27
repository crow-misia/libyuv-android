/*
 * Copyright (C) 2010 The Android Open Source Project
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

#ifndef SCOPED_LOCAL_REF_H__
#define SCOPED_LOCAL_REF_H__

#include <jni.h>
#include <cstddef>
#include "../macros.h"

// A smart pointer that deletes a JNI local reference when it goes out of scope.
template <typename T>
class ScopedLocalRef {
public:
    ScopedLocalRef(JNIEnv* env, T localRef) : mEnv(env), mLocalRef(localRef) {}

    ~ScopedLocalRef() {
        reset();
    }

    void reset(T ptr = nullptr) {
        if (ptr != mLocalRef) {
            if (mLocalRef != nullptr) {
                mEnv->DeleteLocalRef(mLocalRef);
            }
            mLocalRef = ptr;
        }
    }

    T get() const {
        return mLocalRef;
    }

private:
    JNIEnv* mEnv;
    T mLocalRef;

    DISALLOW_COPY_AND_ASSIGN(ScopedLocalRef);
};

#endif  // SCOPED_LOCAL_REF_H__