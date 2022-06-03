import axios from 'axios';

const apiUser = axios.create({
    baseURL: 'http://localhost:8080/users'
});

export default apiUser;