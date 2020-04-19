LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := libyuv

LOCAL_SRC_FILES := \
    convert.cpp \
    convert_argb.cpp \
    convert_from.cpp \
    convert_from_argb.cpp \
    helper.cpp \
    jniload.cpp \
    jniutil.cpp \
    memcopy.cpp \
    planer_functions.cpp \
    rotate.cpp \
    rotate_argb.cpp \
    scale.cpp \
    scale_argb.cpp

LOCAL_EXPORT_C_INCLUDES := \
    $(LOCAL_PATH)/nativehelper \
    $(LOCAL_PATH)/../libyuv/include

LOCAL_STATIC_LIBRARIES := libyuv_static

include $(BUILD_SHARED_LIBRARY)
