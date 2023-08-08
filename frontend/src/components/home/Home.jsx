import React from "react";
import Carousel from "../carousel/Carousel";
import HomeSectionCarousel from "../homesectionCarousel/HomeSectionCarousel";
import { mensKurta } from "../../data/mensKurta";
import { womenDress } from "../../data/womenDress";
import { womenTop } from "../../data/womenTop";

const Home = () => {
  return (
    <div>
      <Carousel />
      <div className="space-y-10 py-20 flex flex-col justify-center px-5 lg:px-10">
        <HomeSectionCarousel data={mensKurta} sectionName={"Kurta"} />
        <HomeSectionCarousel data={womenDress} sectionName={"Dress"} />
        <HomeSectionCarousel data={womenTop} sectionName={"Tops"} />
      </div>
    </div>
  );
};

export default Home;
