.PHONY: infra-start infra-cleanup infra-restart

infra-start:
	docker compose -f docker-compose.test.yml up -d

infra-cleanup:
	docker compose -f docker-compose.test.yml down
	rm -rf ./docker/mysql/data

infra-restart: infra-cleanup infra-start