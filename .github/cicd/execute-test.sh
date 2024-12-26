#!/bin/bash
set -e

echo "Current working directory: $(pwd)"

# 1. Finde das Root-Verzeichnis des Projekts
PROJECT_ROOT=$(git rev-parse --show-toplevel)
echo "Project root directory: ${PROJECT_ROOT}"

# 2. Navigiere zum devservices-demo Modul
cd "${PROJECT_ROOT}/continuous-testing-demo"

# 3. Führe die Tests aus
echo "Running tests in: $(pwd)"
./mvnw test

echo "Test execution finished in: $(pwd)"