build:
	./gradlew build

ktor:
	./gradlew ktor:installDist
	./ktor/build/install/ktor/bin/ktor

docker:
	docker-compose -f docker-compose.yml up -d

.PHONY: build \
	ktor \
	docker
