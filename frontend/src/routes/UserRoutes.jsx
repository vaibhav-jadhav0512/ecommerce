import React from "react";
import { Route, Routes } from "react-router-dom";
import Home from "../components/home/Home";

const UserRoutes = () => {
  return (
    <div>
      <Routes>
        <Route path="/" element={<Home />}></Route>
      </Routes>
    </div>
  );
};

export default UserRoutes;
