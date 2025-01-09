#!/bin/bash
set -e

echo "Current working directory: $(pwd)"


PROJECT_ROOT=$(git rev-parse --show-toplevel)
echo "Project root directory: ${PROJECT_ROOT}"


cd "${PROJECT_ROOT}/continuous-testing-demo"


echo "Running tests in: $(pwd)"
./mvnw test

echo "Test execution finished in: $(pwd)"