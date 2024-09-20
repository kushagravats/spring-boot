#!/bin/bash

git checkout 2.3.x

git merge 2.2.x

if [ $? -ne 0 ]; then
    echo "Merge conflicts detected. Please resolve them and then run:"
    echo "git add <file_with_conflicts>"
    echo "git commit"
    exit 1
fi

git push origin 2.3.x

source ./test-functions.sh
install_service
start_service
await_app
curl -s http://127.0.0.1:8080/
