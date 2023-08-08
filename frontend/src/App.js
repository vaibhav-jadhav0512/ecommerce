import { Route, Routes } from "react-router-dom";
import "./App.css";
import UserRoutes from "./routes/UserRoutes";
import Footer from "./components/footer/Footer";
import Navbar from "./components/navbar/Navbar";
import TestimonialCarousal from "./components/testimonial/TestimonialCarousal";
import MarqueeSlider from "./components/marquee/MarqueeSlider";

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
        <MarqueeSlider />
        <TestimonialCarousal />
        <Footer />
      </div>
    </>
  );
}

export default App;
