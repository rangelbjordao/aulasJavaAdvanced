

Como testar:

curl -v -s -X POST http://localhost:8080/register -H "Content-Type: application/json" -d '{"email":"usuario@email.com","password":"123456"}'

curl -v -s -X POST http://localhost:8080/login -H "Content-Type: application/json" -d '{"email":"usuario@email.com","password":"123456"}'

{"accessToken":"<JWT_AQUI>","tokenType":"Bearer"}

curl http://localhost:8080/publico/hello

curl -v http://localhost:8080/seguro/hello
(erro 403)

TOKEN=<cole-o-token-aqui>
curl -H "Authorization: Bearer $TOKEN" http://localhost:8080/seguro/hello

