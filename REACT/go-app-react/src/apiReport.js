import axios from 'axios';

const apiReport = axios.create({
    baseURL: 'http://localhost:8080/reports'
});

export default apiReport;