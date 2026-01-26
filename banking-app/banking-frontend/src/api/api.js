import axios from "axios";

export const customerApi = axios.create({
  baseURL: "http://localhost:8082/api/customers"
});

export const accountApi = axios.create({
  baseURL: "http://localhost:8083/api/accounts"
});

export const transactionApi = axios.create({
  baseURL: "http://localhost:8084/api/transactions"
});
