import { Route, Routes } from "react-router-dom";
import "./App.css";
import UserRoutes from "./routes/UserRoutes";
import Footer from "./components/footer/Footer";
import Navbar from "./components/navbar/Navbar";
import LogoClouds from "./components/logoClouds/LogoClouds";

function App() {
  return (
    <>
      <div>
        <Navbar />
      </div>
      <Routes>
        <Route path="/*" element={<UserRoutes />}></Route>
      </Routes>
      <div>
        <LogoClouds />
        <Footer />
      </div>
    </>
  );
}

export default App;
