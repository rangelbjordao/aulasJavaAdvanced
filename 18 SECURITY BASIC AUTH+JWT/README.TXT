Como testar:

curl -s -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"user","password":"123456"}'

{"accessToken":"<JWT_AQUI>","tokenType":"Bearer"}

curl http://localhost:8080/publico/hello

curl -v http://localhost:8080/seguro/hello

(erro 403)

TOKEN=<cole-o-token-aqui>

curl -H "Authorization: Bearer $TOKEN" http://localhost:8080/seguro/hello
