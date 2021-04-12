mkdir -p ./build

docker run -d --name sample noyo/noyorest tail -f /dev/null
docker cp sample:/usr/src/noyo/noyo.jar ./build/noyo.jar
docker rm -f sample > /dev/null
