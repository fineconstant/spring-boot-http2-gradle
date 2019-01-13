#!/usr/bin/env bash

keytool -genkey \
    -alias localhost \
    -ext san=dns:localhost \
    -keyalg RSA \
    -storetype PKCS12 \
    -keypass changeit \
    -storepass changeit \
    -keysize 2048 \
    -keystore src/main/resources/keystore.pfx
