LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_SRC_FILES := \
    libyuv_jni.cpp

LOCAL_EXPORT_C_INCLUDES := $(LOCAL_PATH)/../libyuv/include
LOCAL_C_INCLUDES += $(LOCAL_PATH)/../libyuv/include

LOCAL_MODULE := yuv

LOCAL_STATIC_LIBRARIES := yuv-core

include $(BUILD_SHARED_LIBRARY)
