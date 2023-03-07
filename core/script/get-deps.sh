#!/usr/bin/env bash

set -ue -o pipefail

export LC_ALL=C

CURDIR=$(cd $(dirname $0)/..; pwd)

. $CURDIR/../VERSIONS

# libyuv
rm -rf $CURDIR/deps/libyuv
mkdir -p $CURDIR/deps/libyuv
if [ ! -e $CURDIR/deps/libyuv.${LIBYUV_VERSION}.tar.gz ]; then
  curl -Lo $CURDIR/deps/libyuv.${LIBYUV_VERSION}.tar.gz https://chromium.googlesource.com/libyuv/libyuv/+archive/${LIBYUV_VERSION}.tar.gz
fi
pushd $CURDIR/deps/libyuv
  tar xf $CURDIR/deps/libyuv.${LIBYUV_VERSION}.tar.gz
popd
pushd $CURDIR/deps/libyuv
  patch -u -p1 < $CURDIR/script/disable_test_and_jpeg.patch
  patch -u -p1 < $CURDIR/script/fix_bug_scale_down_1_2_uv.patch
popd
