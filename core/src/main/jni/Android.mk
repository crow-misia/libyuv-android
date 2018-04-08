LOCAL_PATH := $(call my-dir)

include $(addprefix $(LOCAL_PATH)/, $(addsuffix /Android.mk, \
  libyuv \
  libyuv-jni \
))
