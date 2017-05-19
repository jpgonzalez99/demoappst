#!/usr/bin/env bash

set -u -e -o pipefail

set +x

# Default options
COMPILE=false
MOCK_SERVER=false
API_URL="http://localhost:3005/"
# BASE_PATH="/demo-app-st"

# Parse options
while [[ $# -gt 0 ]]; do
   key="$1"

   case $key in
      -c|--compile)
         COMPILE=true
      ;;
      -m|--mock)
         MOCK_SERVER=true
      ;;
      -a|--api)
         API_URL="$2"
         shift # past argument
      ;;
      # -b|--base)
      #    BASE_PATH="$2"
      #    shift # past argument
      # ;;
      --default)
         DEFAULT=YES
      ;;
      *)
         # unknown option
      # echo "Unknown option, use -m|--mock for up mockserver -a|--api for api url, -c|--compile for compile before, -b|--base for base path"
      echo "Unknown option, use -m|--mock for up mockserver -a|--api for api url, -c|--compile for compile before"
      exit 1;
      ;;
   esac
   shift
done


# compile if request by user
if [[ $COMPILE == true ]]; then
  npm run build
fi


# Remove old image if exists
IMG_ID=`docker ps -aq --filter "ancestor=demo-app-st"`
if [[ $IMG_ID ]]; then
   docker rm -f $IMG_ID
fi

docker build -t demo-app-st .
# docker run -p 80:80 -e "API_URL=${API_URL}" -e "BASE_PATH=${BASE_PATH}" -itd demo-app-st
docker run -p 8080:8080 -e "API_URL=${API_URL}" -itd demo-app-st

# up mock server if request by user
if [[ $MOCK_SERVER == true ]]; then
   DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
   $DIR/mock-server/node_modules/.bin/nodemon $DIR/mock-server/src/main.js
fi

set -x
