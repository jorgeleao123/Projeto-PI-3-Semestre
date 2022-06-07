import axios from 'axios';

const apiContest = axios.create({
    baseURL: 'http://localhost:8080/contestations'
});

export default apiContest;