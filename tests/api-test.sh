#!/bin/bash

set -e

BASE_URL="http://localhost:8081"

echo "======================================"
echo "UAT API / Functional Testing"
echo "======================================"

echo ""
echo "Test 1: Health API"

HEALTH_RESPONSE=$(curl -s -f "$BASE_URL/health")

echo "Response: $HEALTH_RESPONSE"

if [ "$HEALTH_RESPONSE" = "OK" ]; then
    echo "PASS: Health API"
else
    echo "FAIL: Health API"
    exit 1
fi


echo ""
echo "Test 2: Premium API"

PREMIUM_RESPONSE=$(curl -s -f "$BASE_URL/premium")

echo "Response: $PREMIUM_RESPONSE"

if [ "$PREMIUM_RESPONSE" = "Premium: 9000.0" ]; then
    echo "PASS: Premium API"
else
    echo "FAIL: Premium API"
    exit 1
fi


echo ""
echo "======================================"
echo "ALL UAT API TESTS PASSED"
echo "======================================"
