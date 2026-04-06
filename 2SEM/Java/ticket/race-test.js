// Race Condition
import http from 'k6/http';
import { check } from 'k6';

export const options = {
    vus: 20,          // 20 usuários simultâneos
    iterations: 20,   // total de 20 requisições (1 por usuário)
    duration: '2s'
};

export default function () {
    const res = http.post('http://localhost:8080/tickets/purchase/1');

    check(res, {
        'status is 201': (r) => r.status === 201,
    });
}