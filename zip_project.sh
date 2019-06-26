#!/bin/bash

OUT_ZIP="Test_entrevoisins.zip"

if [ -f "${OUT_ZIP}" ]; then
    rm "${OUT_ZIP}"
fi
zip -rq "${OUT_ZIP}" pom.xml run-tests.sh src
echo "${OUT_ZIP}"
