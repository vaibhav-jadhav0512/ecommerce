import axios from "axios";
const LOCALHOST = "http://localhost:8888";
const OKTA = "https://dev-25813495.okta.com";
export const API_BASE_URL = LOCALHOST;
export const OKTA_BASE_URL = OKTA;

const api = axios.create({
  baseURL: API_BASE_URL,
});

const token = localStorage.getItem("jwt");
var username = "0oaao9o5zyIWHzLKy5d7";
var password =
  "RYdeUmHnTeHROrzOuUMPYSx-QDHLoR3vAqdADj3qvYi-GoI-n_ZHO9rCSqrnGXXe";
const okta = axios.create({
  baseURL: OKTA_BASE_URL,
  auth: {
    username: username,
    password: password,
  },
});

api.defaults.headers.common["Authorization"] = `Bearer ${token}`;

api.defaults.headers.post["Content-Type"] = "application/json";
okta.defaults.headers.post["Content-Type"] =
  "application/x-www-form-urlencoded";

export { api, okta };
