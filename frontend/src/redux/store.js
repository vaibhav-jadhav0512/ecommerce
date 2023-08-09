import { applyMiddleware, combineReducers, createStore, compose } from "redux";
import thunk from "redux-thunk";
import authReducer from "./auth/reducer";

const rootReducers = combineReducers({
  auth: authReducer,
  //   customersProduct: customerProductReducer,
  //   cart: cartReducer,
  //   order: orderReducer,
  //   review: ReviewReducer,
  // // admin
  // adminsProduct:productReducer,
  // adminsOrder:adminOrderReducer,
});

// export const store = legacy_createStore(rootReducers, applyMiddleware(thunk));
const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
export const store = createStore(
  rootReducers,
  /* preloadedState, */ composeEnhancers(applyMiddleware(thunk))
);
