import { Route, Routes } from "react-router-dom";
import UserRoutes from "./routes/UserRoutes";
import Footer from "./components/footer/Footer";
import Navbar from "./components/navbar/Navbar";
import MarqueeSlider from "./components/marquee/MarqueeSlider";
import SwiperComponent from "./components/swiper/SwiperComponent";

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
        <SwiperComponent />
        <Footer />
      </div>
    </>
  );
}

export default App;
