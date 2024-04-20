2024-04-20
- sqlite database
- use flyway for database upgrade

2024-04-19

- get_read:
	id - removed from response

- put_update:
	changed endpoint contract
	name\type - partial updates

- post_create
	id - removed from request
	strict other json fields


2024-04-11
Added version prefix for endpoint "/api/v1"
Added crud for accounts (no data validations)
