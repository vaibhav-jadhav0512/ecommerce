import axios from "axios";
import {
  REGISTER_REQUEST,
  REGISTER_SUCCESS,
  REGISTER_FAILURE,
  LOGIN_REQUEST,
  LOGIN_SUCCESS,
  LOGIN_FAILURE,
  GET_USER_REQUEST,
  GET_USER_SUCCESS,
  GET_USER_FAILURE,
  LOGOUT,
} from "./actionType";
import { api, okta, API_BASE_URL, OKTA_BASE_URL } from "../../config/api";

// Register action creators
const token = localStorage.getItem("jwt");
const registerRequest = () => ({ type: REGISTER_REQUEST });
const registerSuccess = (user) => ({ type: REGISTER_SUCCESS, payload: user });
const registerFailure = (error) => ({ type: REGISTER_FAILURE, payload: error });

export const register = (userData) => async (dispatch) => {
  dispatch(registerRequest());
  try {
    const response = await axios.post(`${API_BASE_URL}/auth/signup`, userData);
    const user = response.data;
    if (user.jwt) localStorage.setItem("jwt", user.jwt);
    console.log("registerr :", user);
    dispatch(registerSuccess(user.jwt));
  } catch (error) {
    dispatch(registerFailure(error.message));
  }
};

// Login action creators
const loginRequest = () => ({ type: LOGIN_REQUEST });
const loginSuccess = (user) => ({ type: LOGIN_SUCCESS, payload: user });
const loginFailure = (error) => ({ type: LOGIN_FAILURE, payload: error });

export const login = (userData) => async (dispatch) => {
  // dispatch(loginRequest());
  // try {
  // const body = {
  //   grant_type: "client_credentials",
  //   redirect_uri: "http://localhost:3001",
  //   username: userData.email,
  //   password: userData.password,
  //   scope: "internal",
  // };
  // const response = await axios.post(
  //   `${OKTA_BASE_URL}/oauth2/default/v1/token`,
  //   body,
  //   {
  //     auth: {
  //       username: "0oaao9o5zyIWHzLKy5d7",
  //       password:
  //         "RYdeUmHnTeHROrzOuUMPYSx-QDHLoR3vAqdADj3qvYi-GoI-n_ZHO9rCSqrnGXXe",
  //     },

  //     headers: {
  //       "Content-Type": "application/x-www-form-urlencoded",
  //     },
  //   }
  // );
  // console.log(response);
  //   const user = response.data;
  //   if (user.jwt) localStorage.setItem("jwt", user.access_token);
  //   console.log("login ", user);
  //   dispatch(loginSuccess(user.access_token));
  // } catch (error) {
  //   dispatch(loginFailure(error.message));
  // }
  const url = "https://dev-25813495.okta.com/oauth2/default/v1/token";
  const clientId = "0oaao9o5zyIWHzLKy5d7";
  const clientSecret =
    "RYdeUmHnTeHROrzOuUMPYSx-QDHLoR3vAqdADj3qvYi-GoI-n_ZHO9rCSqrnGXXe";

  const headers = {
    "Content-Type": "application/x-www-form-urlencoded",
    Authorization: `Basic ${btoa(`${clientId}:${clientSecret}`)}`,
  };

  const data = new URLSearchParams();
  data.append("grant_type", "client_credentials");
  data.append("scope", "internal");
  data.append("redirect_uri", "http://localhost:3001/");
  data.append("username", "samvaibhav007@gmail.com");
  data.append("password", "Karan@123");

  axios
    .post(url, data, { headers })
    .then((response) => {
      console.log(response.data);
    })
    .catch((error) => {
      console.error(error);
    });
};

//  get user from token
export const getUser = (jwt) => {
  return async (dispatch) => {
    dispatch({ type: GET_USER_REQUEST });
    try {
      const response = await axios.get(`${API_BASE_URL}/api/users/profile`, {
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });
      const user = response.data;
      dispatch({ type: GET_USER_SUCCESS, payload: user });
      console.log("req User ", user);
    } catch (error) {
      const errorMessage = error.message;
      dispatch({ type: GET_USER_FAILURE, payload: errorMessage });
    }
  };
};

export const logout = (token) => {
  return async (dispatch) => {
    dispatch({ type: LOGOUT });
    localStorage.clear();
  };
};
