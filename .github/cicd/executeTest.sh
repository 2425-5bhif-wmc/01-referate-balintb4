#!/usr/bin/env bash

set -e

pushd devservices-demo
    mvn test
popd